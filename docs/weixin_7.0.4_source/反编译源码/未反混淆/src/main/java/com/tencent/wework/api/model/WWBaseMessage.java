package com.tencent.wework.api.model;

import android.os.Bundle;
import android.os.SystemClock;

public abstract class WWBaseMessage extends BaseMessage {
    public String appId;
    public String hgS;
    public String transaction;

    public void toBundle(Bundle bundle) {
        String valueOf = String.valueOf(SystemClock.uptimeMillis());
        this.transaction = valueOf;
        bundle.putString("_wwapi_basereq_transaction", valueOf);
        bundle.putString("_wwapi_basereq_openid", this.appId);
        bundle.putString("_wwapi_basereq_agentid", this.hgS);
        try {
            bundle.putString("_wwapi_basereq_appbundle", this.mContext.getPackageName());
            bundle.putString("_wwapi_basereq_appname", this.mContext.getString(this.mContext.getApplicationInfo().labelRes));
        } catch (Throwable th) {
        }
        bundle.putInt("_wwobject_sdkVer", 2);
    }

    public boolean checkArgs() {
        return true;
    }
}
