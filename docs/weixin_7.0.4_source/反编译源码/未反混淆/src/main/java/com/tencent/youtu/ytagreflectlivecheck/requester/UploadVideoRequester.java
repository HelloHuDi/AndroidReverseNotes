package com.tencent.youtu.ytagreflectlivecheck.requester;

public interface UploadVideoRequester {

    public interface UploadVideoResponse {
        void onFailed(int i, String str);

        void onSuccess(String str);
    }

    void request(String str, UploadVideoResponse uploadVideoResponse);
}
