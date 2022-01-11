package com.bankaya.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BankayaServicesApplication {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(final String[] args) {
        SpringApplication.run(BankayaServicesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        final RestTemplate restTemplate = new RestTemplate();

        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(final HttpURLConnection connection, final String httpMethod) throws IOException {
                if (connection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) connection).setHostnameVerifier(new HostnameVerifier() {

                        @Override
                        public boolean verify(final String hostname, final SSLSession session) {
                            // TODO Auto-generated method stub
                            return false;
                        }
                    });
                }
                super.prepareConnection(connection, httpMethod);
            }
        });

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            protected boolean hasError(final HttpStatus statusCode) {
                return false;
            }
        });
        final HttpHeaders headerJson = new HttpHeaders();
        headerJson.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headerJson.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate;

    }

}
