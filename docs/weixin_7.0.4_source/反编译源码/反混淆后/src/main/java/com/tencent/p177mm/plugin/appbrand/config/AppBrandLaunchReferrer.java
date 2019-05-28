package com.tencent.p177mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer */
public final class AppBrandLaunchReferrer implements Parcelable {
    public static final Creator<AppBrandLaunchReferrer> CREATOR = new C381591();
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

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer$1 */
    static class C381591 implements Creator<AppBrandLaunchReferrer> {
        C381591() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLaunchReferrer[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(86896);
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer(parcel, (byte) 0);
            AppMethodBeat.m2505o(86896);
            return appBrandLaunchReferrer;
        }
    }

    /* synthetic */ AppBrandLaunchReferrer(Parcel parcel, byte b) {
        this(parcel);
    }

    public final String toString() {
        AppMethodBeat.m2504i(86897);
        String str = "AppBrandLaunchReferrer{launchScene=" + this.hgQ + ", appId='" + this.appId + '\'' + ", extraData='" + this.cFM + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.hgS + '\'' + ", sourceType='" + this.cvp + '\'' + ", businessType='" + this.businessType + '\'' + '}';
        AppMethodBeat.m2505o(86897);
        return str;
    }

    /* renamed from: j */
    private void m83968j(Parcel parcel) {
        AppMethodBeat.m2504i(86898);
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
        AppMethodBeat.m2505o(86898);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(86899);
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
        AppMethodBeat.m2505o(86899);
    }

    /* renamed from: a */
    public final void mo73344a(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        AppMethodBeat.m2504i(86900);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.m2505o(86900);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        appBrandLaunchReferrer.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        m83968j(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(86900);
    }

    public final JSONObject ayF() {
        Object jSONObject;
        AppMethodBeat.m2504i(86901);
        try {
            jSONObject = new JSONObject(this.cFM);
        } catch (Exception e) {
            jSONObject = this.cFM;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appId", this.appId);
            jSONObject2.put("extraData", jSONObject);
            if ((this.hgQ == 1 || this.hgQ == 3 || this.hgQ == 2) && !C5046bo.isNullOrNil(this.hgR)) {
                jSONObject2.put("privateExtraData", new JSONObject(this.hgR));
            }
            if (this.hgQ == 6 && !C5046bo.isNullOrNil(this.cOv)) {
                jSONObject2.put("messageExtraData", new JSONObject(this.cOv));
            }
            if (this.hgQ == 7 && !C5046bo.isNullOrNil(this.hgT)) {
                jSONObject2.put("openapiInvokeData", new JSONObject(this.hgT));
            }
            if (this.hgQ == 7 && !C5046bo.isNullOrNil(this.hgU)) {
                jSONObject2.put("transitiveData", new JSONObject(this.hgU));
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", e2);
        }
        if (jSONObject2.length() == 0) {
            AppMethodBeat.m2505o(86901);
            return null;
        }
        AppMethodBeat.m2505o(86901);
        return jSONObject2;
    }

    public final int describeContents() {
        return 0;
    }

    private AppBrandLaunchReferrer(Parcel parcel) {
        AppMethodBeat.m2504i(86902);
        m83968j(parcel);
        AppMethodBeat.m2505o(86902);
    }

    static {
        AppMethodBeat.m2504i(86903);
        AppMethodBeat.m2505o(86903);
    }
}
