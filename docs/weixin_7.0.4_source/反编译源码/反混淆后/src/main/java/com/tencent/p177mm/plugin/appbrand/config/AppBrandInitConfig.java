package com.tencent.p177mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig */
public class AppBrandInitConfig implements Parcelable {
    public static final Creator<AppBrandInitConfig> CREATOR = new C101711();
    public String appId;
    public String cwz;
    public int gVs;
    public String hfh;
    public String hgC;
    public int hgD;
    public String hgE;
    public final AppBrandLaunchReferrer hgF;
    public boolean hgG;
    public String iconUrl;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig$1 */
    static class C101711 implements Creator<AppBrandInitConfig> {
        C101711() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(86891);
            AppBrandInitConfig appBrandInitConfig = new AppBrandInitConfig(parcel);
            AppMethodBeat.m2505o(86891);
            return appBrandInitConfig;
        }
    }

    public AppBrandInitConfig() {
        AppMethodBeat.m2504i(86892);
        this.hgF = new AppBrandLaunchReferrer();
        AppMethodBeat.m2505o(86892);
    }

    protected AppBrandInitConfig(Parcel parcel) {
        AppMethodBeat.m2504i(86893);
        this.appId = parcel.readString();
        this.cwz = parcel.readString();
        this.iconUrl = parcel.readString();
        this.gVs = parcel.readInt();
        this.hgC = parcel.readString();
        this.hgF = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.hfh = parcel.readString();
        this.hgG = parcel.readByte() != (byte) 0;
        this.hgD = parcel.readInt();
        this.hgE = parcel.readString();
        AppMethodBeat.m2505o(86893);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(86894);
        parcel.writeString(this.appId);
        parcel.writeString(this.cwz);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.gVs);
        parcel.writeString(this.hgC);
        parcel.writeParcelable(this.hgF, i);
        parcel.writeString(this.hfh);
        parcel.writeByte((byte) (this.hgG ? 1 : 0));
        parcel.writeInt(this.hgD);
        parcel.writeString(this.hgE);
        AppMethodBeat.m2505o(86894);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(86895);
        AppMethodBeat.m2505o(86895);
    }
}
