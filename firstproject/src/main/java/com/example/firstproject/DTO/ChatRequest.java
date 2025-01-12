//사용자의 질문 데이터를 담는 요청 DTO
package com.example.firstproject.DTO;

public class ChatRequest {
    private String content;

    // 기본 생성자
    public ChatRequest() {}

    // 생성자
    public ChatRequest(String content) {
        this.content = content;
    }

    // Getter 및 Setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
