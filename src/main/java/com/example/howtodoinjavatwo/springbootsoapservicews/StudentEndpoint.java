package com.example.howtodoinjavatwo.springbootsoapservicews;

import com.alineservices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

    @Endpoint
    public class StudentEndpoint
    {
        private static final String NAMESPACE_URI = "http://www.alineservices.com";

        private StudentRepository StudentRepository;

        @Autowired
        public StudentEndpoint(StudentRepository StudentRepository) {
            this.StudentRepository = StudentRepository;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOneRequest")
        @ResponsePayload
        public GetOneResponse getStudent(@RequestPayload GetOneRequest request) {
            GetOneResponse response = new GetOneResponse();
            response.setStudent(StudentRepository.findStudent(request.getNome()));

            return response;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteOneRequest")
        @ResponsePayload
        public DeleteOneResponse getStudent(@RequestPayload DeleteOneRequest request) {
            DeleteOneResponse response = new DeleteOneResponse();
            response.setStudent(StudentRepository.deleteStudent(request.getNome()));

            return response;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setOneRequest")
        @ResponsePayload
        public SetOneResponse addStudent(@RequestPayload SetOneRequest request) {
            SetOneResponse response = new SetOneResponse();
            response.setStudent(StudentRepository.setStudent(request.getStudent()));

            return response;
        }
}
