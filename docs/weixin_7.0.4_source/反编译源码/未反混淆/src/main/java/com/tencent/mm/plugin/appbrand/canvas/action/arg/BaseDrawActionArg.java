package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONObject;

public abstract class BaseDrawActionArg implements DrawActionArg {
    public String method;

    public BaseDrawActionArg(Parcel parcel) {
        this.method = parcel.readString();
    }

    @Deprecated
    public BaseDrawActionArg(Parcel parcel, byte b) {
        i(parcel);
    }

    public boolean ayg() {
        return false;
    }

    @Deprecated
    public void i(Parcel parcel) {
        this.method = parcel.readString();
    }

    public void j(JSONObject jSONObject) {
        this.method = jSONObject.optString(b.METHOD);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.method);
    }

    public String toString() {
        return String.format("method %s", new Object[]{this.method});
    }

    public boolean a(d dVar, Canvas canvas) {
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
