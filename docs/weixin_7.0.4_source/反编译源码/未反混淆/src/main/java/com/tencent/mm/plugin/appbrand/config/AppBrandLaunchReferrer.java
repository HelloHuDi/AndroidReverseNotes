package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer implements Parcelable {
    public static final Creator<AppBrandLaunchReferrer> CREATOR = new Creator<AppBrandLaunchReferrer>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLaunchReferrer[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(86896);
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer(parcel, (byte) 0);
            AppMethodBeat.o(86896);
            return appBrandLaunchReferrer;
        }
    };
    public String appId;
    public String businessType;
    public String cFM;
    public String cOv;
    public int cvp;
    public int hgQ;
    public String hgR;
    public String hgS;
    public String hgT;
    public String hgU;
    public String url;

    /* synthetic */ AppBrandLaunchReferrer(Parcel parcel, byte b) {
        this(parcel);
    }

    public final String toString() {
        AppMethodBeat.i(86897);
        String str = "AppBrandLaunchReferrer{launchScene=" + this.hgQ + ", appId='" + this.appId + '\'' + ", extraData='" + this.cFM + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.hgS + '\'' + ", sourceType='" + this.cvp + '\'' + ", businessType='" + this.businessType + '\'' + '}';
        AppMethodBeat.o(86897);
        return str;
    }

    private void j(Parcel parcel) {
        AppMethodBeat.i(86898);
        this.hgQ = parcel.readInt();
        this.appId = parcel.readString();
        this.cFM = parcel.readString();
        this.hgR = parcel.readString();
        this.url = parcel.readString();
        this.hgS = parcel.readString();
        this.cvp = parcel.readInt();
        this.businessType = parcel.readString();
        this.cOv = parcel.readString();
        this.hgT = parcel.readString();
        this.hgU = parcel.readString();
        AppMethodBeat.o(86898);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(86899);
        parcel.writeInt(this.hgQ);
        parcel.writeString(this.appId);
        parcel.writeString(this.cFM);
        parcel.writeString(this.hgR);
        parcel.writeString(this.url);
        parcel.writeString(this.hgS);
        parcel.writeInt(this.cvp);
        parcel.writeString(this.businessType);
        parcel.writeString(this.cOv);
        parcel.writeString(this.hgT);
        parcel.writeString(this.hgU);
        AppMethodBeat.o(86899);
    }

    public final void a(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        AppMethodBeat.i(86900);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.o(86900);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        appBrandLaunchReferrer.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        j(obtain);
        obtain.recycle();
        AppMethodBeat.o(86900);
    }

    public final JSONObject ayF() {
        Object jSONObject;
        AppMethodBeat.i(86901);
        try {
            jSONObject = new JSONObject(this.cFM);
        } catch (Exception e) {
            jSONObject = this.cFM;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appId", this.appId);
            jSONObject2.put("extraData", jSONObject);
            if ((this.hgQ == 1 || this.hgQ == 3 || this.hgQ == 2) && !bo.isNullOrNil(this.hgR)) {
                jSONObject2.put("privateExtraData", new JSONObject(this.hgR));
            }
            if (this.hgQ == 6 && !bo.isNullOrNil(this.cOv)) {
                jSONObject2.put("messageExtraData", new JSONObject(this.cOv));
            }
            if (this.hgQ == 7 && !bo.isNullOrNil(this.hgT)) {
                jSONObject2.put("openapiInvokeData", new JSONObject(this.hgT));
            }
            if (this.hgQ == 7 && !bo.isNullOrNil(this.hgU)) {
                jSONObject2.put("transitiveData", new JSONObject(this.hgU));
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", e2);
        }
        if (jSONObject2.length() == 0) {
            AppMethodBeat.o(86901);
            return null;
        }
        AppMethodBeat.o(86901);
        return jSONObject2;
    }

    public final int describeContents() {
        return 0;
    }

    private AppBrandLaunchReferrer(Parcel parcel) {
        AppMethodBeat.i(86902);
        j(parcel);
        AppMethodBeat.o(86902);
    }

    static {
        AppMethodBeat.i(86903);
        AppMethodBeat.o(86903);
    }
}
