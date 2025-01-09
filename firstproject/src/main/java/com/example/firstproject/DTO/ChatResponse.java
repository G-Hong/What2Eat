//ai의 응답 데이터를 담는 DTO
package com.example.firstproject.DTO;

public class ChatResponse {
    private String answer;

    public ChatResponse() {}

    public ChatResponse(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
