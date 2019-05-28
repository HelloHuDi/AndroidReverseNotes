package com.tencent.p177mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams */
public class AppBrandWeishiParams implements Parcelable {
    public static final Creator<AppBrandWeishiParams> CREATOR = new C271761();
    public String appId;
    public String appName;
    public int ffp;
    public String ijv;
    public String ijw;
    public String ijx;
    public String thumbUrl;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams$1 */
    static class C271761 implements Creator<AppBrandWeishiParams> {
        C271761() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandWeishiParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102112);
            AppBrandWeishiParams appBrandWeishiParams = new AppBrandWeishiParams(parcel);
            AppMethodBeat.m2505o(102112);
            return appBrandWeishiParams;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(102113);
        String str = "AppBrandWeishiParams{fromOpenSdk=" + this.ffp + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbFullPath='" + this.ijv + '\'' + ", msgImgPath='" + this.ijw + '\'' + ", appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", sourceUserName='" + this.ijx + '\'' + '}';
        AppMethodBeat.m2505o(102113);
        return str;
    }

    public AppBrandWeishiParams(Parcel parcel) {
        AppMethodBeat.m2504i(102114);
        m43189j(parcel);
        AppMethodBeat.m2505o(102114);
    }

    /* renamed from: j */
    private void m43189j(Parcel parcel) {
        AppMethodBeat.m2504i(102115);
        this.ffp = parcel.readInt();
        this.thumbUrl = parcel.readString();
        this.ijv = parcel.readString();
        this.ijw = parcel.readString();
        this.appId = parcel.readString();
        this.appName = parcel.readString();
        this.ijx = parcel.readString();
        AppMethodBeat.m2505o(102115);
    }

    /* renamed from: a */
    public final void mo44852a(AppBrandWeishiParams appBrandWeishiParams) {
        AppMethodBeat.m2504i(102116);
        if (appBrandWeishiParams == null) {
            AppMethodBeat.m2505o(102116);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        appBrandWeishiParams.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        m43189j(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(102116);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102117);
        parcel.writeInt(this.ffp);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.ijv);
        parcel.writeString(this.ijw);
        parcel.writeString(this.appId);
        parcel.writeString(this.appName);
        parcel.writeString(this.ijx);
        AppMethodBeat.m2505o(102117);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(102118);
        AppMethodBeat.m2505o(102118);
    }
}
