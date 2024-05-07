package project.mdm.entity;

public enum InquiryType {

    SERVICE("서비스 관련 문의"), EVENT("이벤트 관련 문의"), ETC("기타 문의");

    private String name;

    InquiryType(String name) {
        this.name = name;
    }
}
