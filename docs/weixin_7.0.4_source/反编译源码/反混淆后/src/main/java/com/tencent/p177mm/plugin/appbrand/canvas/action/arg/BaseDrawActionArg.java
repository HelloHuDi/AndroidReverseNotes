package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg */
public abstract class BaseDrawActionArg implements DrawActionArg {
    public String method;

    public BaseDrawActionArg(Parcel parcel) {
        this.method = parcel.readString();
    }

    @Deprecated
    public BaseDrawActionArg(Parcel parcel, byte b) {
        mo5879i(parcel);
    }

    public boolean ayg() {
        return false;
    }

    @Deprecated
    /* renamed from: i */
    public void mo5879i(Parcel parcel) {
        this.method = parcel.readString();
    }

    /* renamed from: j */
    public void mo5880j(JSONObject jSONObject) {
        this.method = jSONObject.optString(C8741b.METHOD);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.method);
    }

    public String toString() {
        return String.format("method %s", new Object[]{this.method});
    }

    /* renamed from: a */
    public boolean mo21512a(C2102d c2102d, Canvas canvas) {
        return false;
    }

    public void reset() {
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseDrawActionArg)) {
            return false;
        }
        BaseDrawActionArg baseDrawActionArg = (BaseDrawActionArg) obj;
        if (this.method == baseDrawActionArg.method) {
            return true;
        }
        if (this.method == null || !this.method.equals(baseDrawActionArg.method)) {
            return false;
        }
        return true;
    }
}
