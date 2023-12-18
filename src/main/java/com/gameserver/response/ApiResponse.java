package com.gameserver.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Generated;

public class ApiResponse<T> {

    @Schema(
            description = "Version of this API"
    )
    private String apiVersion = "1.0";

    @Schema(
            description = "Payload of this response (entity or error information)"
    )
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse(data);
    }

    @Generated
    public String getApiVersion() {
        return this.apiVersion;
    }

    @Generated
    public T getData() {
        return this.data;
    }

    @Generated
    public void setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Generated
    public void setData(final T data) {
        this.data = data;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResponse)) {
            return false;
        } else {
            ApiResponse<?> other = (ApiResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$apiVersion = this.getApiVersion();
                Object other$apiVersion = other.getApiVersion();
                if (this$apiVersion == null) {
                    if (other$apiVersion != null) {
                        return false;
                    }
                } else if (!this$apiVersion.equals(other$apiVersion)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof ApiResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * 59 + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getApiVersion();
        return "ApiResponse(apiVersion=" + var10000 + ", data=" + this.getData() + ")";
    }

    @Generated
    public ApiResponse() {
    }
}
