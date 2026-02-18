package com.email.smart_email_assistant_sb.app;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailGeneratorService {
    public String generateEmailReply(EmailRequest emailRequest) {
        //build the prompt
        String prompt= buildPrompt(emailRequest);

        //craft a request body
        Map<String, Object> requestBody= Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                })
                }
        );
        //Do request and get response
        //return response

    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt= new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content, please don't generate a subject line. ");
        if(emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a ").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }

}
