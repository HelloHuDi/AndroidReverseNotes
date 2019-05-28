package com.tencent.p177mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.utils.C18749a;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelpay.PayReq */
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

    /* renamed from: com.tencent.mm.opensdk.modelpay.PayReq$Options */
    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags = -1;

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128151);
            this.callbackClassName = C18749a.m29301b(bundle, "_wxapi_payoptions_callback_classname");
            this.callbackFlags = C18749a.m29300a(bundle, "_wxapi_payoptions_callback_flags");
            AppMethodBeat.m2505o(128151);
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128150);
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
            AppMethodBeat.m2505o(128150);
        }
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128152);
        if (this.appId == null || this.appId.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, invalid appId");
            AppMethodBeat.m2505o(128152);
            return false;
        } else if (this.partnerId == null || this.partnerId.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, invalid partnerId");
            AppMethodBeat.m2505o(128152);
            return false;
        } else if (this.prepayId == null || this.prepayId.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, invalid prepayId");
            AppMethodBeat.m2505o(128152);
            return false;
        } else if (this.nonceStr == null || this.nonceStr.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, invalid nonceStr");
            AppMethodBeat.m2505o(128152);
            return false;
        } else if (this.timeStamp == null || this.timeStamp.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, invalid timeStamp");
            AppMethodBeat.m2505o(128152);
            return false;
        } else if (this.packageValue == null || this.packageValue.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, invalid packageValue");
            AppMethodBeat.m2505o(128152);
            return false;
        } else if (this.sign == null || this.sign.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, invalid sign");
            AppMethodBeat.m2505o(128152);
            return false;
        } else if (this.extData == null || this.extData.length() <= 1024) {
            AppMethodBeat.m2505o(128152);
            return true;
        } else {
            Log.m4140e(TAG, "checkArgs fail, extData length too long");
            AppMethodBeat.m2505o(128152);
            return false;
        }
    }

    public void fromBundle(Bundle bundle) {
        AppMethodBeat.m2504i(128154);
        super.fromBundle(bundle);
        this.appId = C18749a.m29301b(bundle, "_wxapi_payreq_appid");
        this.partnerId = C18749a.m29301b(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = C18749a.m29301b(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = C18749a.m29301b(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = C18749a.m29301b(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = C18749a.m29301b(bundle, "_wxapi_payreq_packagevalue");
        this.sign = C18749a.m29301b(bundle, "_wxapi_payreq_sign");
        this.extData = C18749a.m29301b(bundle, "_wxapi_payreq_extdata");
        this.signType = C18749a.m29301b(bundle, "_wxapi_payreq_sign_type");
        this.options = new Options();
        this.options.fromBundle(bundle);
        AppMethodBeat.m2505o(128154);
    }

    public int getType() {
        return 5;
    }

    public void toBundle(Bundle bundle) {
        AppMethodBeat.m2504i(128153);
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
        AppMethodBeat.m2505o(128153);
    }
}
