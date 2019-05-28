package com.tencent.youtu.ytagreflectlivecheck.requester;

public interface RGBConfigRequester {

    public interface RGBConfigRequestCallBack {
        void onFailed(int i);

        void onSuccess(String str);
    }

    public static class YTColorSeqReq {
        public String app_id;
        public String business_name;
        public String person_id;

        public YTColorSeqReq(String str, String str2, String str3) {
            this.app_id = str;
            this.business_name = str2;
            this.person_id = str3;
        }
    }

    YTColorSeqReq getColorSeqReq();

    void request(String str, RGBConfigRequestCallBack rGBConfigRequestCallBack);
}
