package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class Message {

    @Id
    Integer sourceId;
    String sourceMessageTitle;
    String sourceMessage;
    String sourceLastName;
    String sourceFirstName;
    String sourceEmail;
    String sourcePhone;
    String sourceMatter;
    BigInteger sourceDatetimeMilliseconds;

    @JsonProperty("sourceId")
    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @JsonProperty("sourceMessageTitle")
    public String getSourceMessageTitle() {
        return sourceMessageTitle;
    }

    public void setSourceMessageTitle(String sourceMessageTitle) {
        this.sourceMessageTitle = sourceMessageTitle;
    }

    @JsonProperty("sourceMessage")
    public String getSourceMessage() {
        return sourceMessage;
    }

    public void setSourceMessage(String sourceMessage) {
        this.sourceMessage = sourceMessage;
    }

    @JsonProperty("sourceLastName")
    public String getSourceLastName() {
        return sourceLastName;
    }

    public void setSourceLastName(String sourceLastName) {
        this.sourceLastName = sourceLastName;
    }

    @JsonProperty("sourceFirstName")
    public String getSourceFirstName() {
        return sourceFirstName;
    }

    public void setSourceFirstName(String sourceFirstName) {
        this.sourceFirstName = sourceFirstName;
    }

    @JsonProperty("sourceEmail")
    public String getSourceEmail() {
        return sourceEmail;
    }

    public void setSourceEmail(String sourceEmail) {
        this.sourceEmail = sourceEmail;
    }

    @JsonProperty("sourcePhone")
    public String getSourcePhone() {
        return sourcePhone;
    }

    public void setSourcePhone(String sourcePhone) {
        this.sourcePhone = sourcePhone;
    }

    @JsonProperty("sourceMatter")
    public String getSourceMatter() {
        return sourceMatter;
    }

    public void setSourceMatter(String sourceMatter) {
        this.sourceMatter = sourceMatter;
    }

    @JsonProperty("sourceDatetimeMilliseconds")
    public BigInteger getSourceDatetimeMilliseconds() {
        return sourceDatetimeMilliseconds;
    }

    public void setSourceDatetimeMilliseconds(BigInteger sourceDatetimeMilliseconds) {
        this.sourceDatetimeMilliseconds = sourceDatetimeMilliseconds;
    }

}
