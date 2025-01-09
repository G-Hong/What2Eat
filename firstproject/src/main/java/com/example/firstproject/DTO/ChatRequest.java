//사용자의 질문 데이터를 담는 요청 DTO
package com.example.firstproject.DTO;

public class ChatRequest {
    private String question;

    public ChatRequest() {}

    public ChatRequest(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
