package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;

public class PayReq extends BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "MicroMsg.PaySdk.PayReq";
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags = -1;

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128151);
            this.callbackClassName = a.b(bundle, "_wxapi_payoptions_callback_classname");
            this.callbackFlags = a.a(bundle, "_wxapi_payoptions_callback_flags");
            AppMethodBeat.o(128151);
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128150);
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
            AppMethodBeat.o(128150);
        }
    }

    public boolean checkArgs() {
        AppMethodBeat.i(128152);
        if (this.appId == null || this.appId.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid appId");
            AppMethodBeat.o(128152);
            return false;
        } else if (this.partnerId == null || this.partnerId.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid partnerId");
            AppMethodBeat.o(128152);
            return false;
        } else if (this.prepayId == null || this.prepayId.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid prepayId");
            AppMethodBeat.o(128152);
            return false;
        } else if (this.nonceStr == null || this.nonceStr.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid nonceStr");
            AppMethodBeat.o(128152);
            return false;
        } else if (this.timeStamp == null || this.timeStamp.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid timeStamp");
            AppMethodBeat.o(128152);
            return false;
        } else if (this.packageValue == null || this.packageValue.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid packageValue");
            AppMethodBeat.o(128152);
            return false;
        } else if (this.sign == null || this.sign.length() == 0) {
            Log.e(TAG, "checkArgs fail, invalid sign");
            AppMethodBeat.o(128152);
            return false;
        } else if (this.extData == null || this.extData.length() <= 1024) {
            AppMethodBeat.o(128152);
            return true;
        } else {
            Log.e(TAG, "checkArgs fail, extData length too long");
            AppMethodBeat.o(128152);
            return false;
        }
    }

    public void fromBundle(Bundle bundle) {
        AppMethodBeat.i(128154);
        super.fromBundle(bundle);
        this.appId = a.b(bundle, "_wxapi_payreq_appid");
        this.partnerId = a.b(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = a.b(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = a.b(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = a.b(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = a.b(bundle, "_wxapi_payreq_packagevalue");
        this.sign = a.b(bundle, "_wxapi_payreq_sign");
        this.extData = a.b(bundle, "_wxapi_payreq_extdata");
        this.signType = a.b(bundle, "_wxapi_payreq_sign_type");
        this.options = new Options();
        this.options.fromBundle(bundle);
        AppMethodBeat.o(128154);
    }

    public int getType() {
        return 5;
    }

    public void toBundle(Bundle bundle) {
        AppMethodBeat.i(128153);
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        if (this.options != null) {
            this.options.toBundle(bundle);
        }
        AppMethodBeat.o(128153);
    }
}
