package com.tencent.p177mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.luggage.sdk.launching.C17829b;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel */
public final class LaunchParcel implements Parcelable {
    public static final Creator<LaunchParcel> CREATOR = new C195801();
    public String appId;
    public int har;
    public String hgC;
    public AppBrandLaunchReferrer hgF;
    public ActivityStarterIpcDelegate ifP;
    public long ijA;
    public C17829b<?> ijB;
    public AppBrandStatObject ijy;
    public LaunchParamsOptional ijz;
    public String username;
    public int version;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel$1 */
    static class C195801 implements Creator<LaunchParcel> {
        C195801() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102119);
            LaunchParcel launchParcel = new LaunchParcel(parcel, (byte) 0);
            AppMethodBeat.m2505o(102119);
            return launchParcel;
        }
    }

    /* synthetic */ LaunchParcel(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102120);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.version);
        parcel.writeInt(this.har);
        parcel.writeString(this.hgC);
        parcel.writeParcelable(this.ijy, i);
        parcel.writeParcelable(this.hgF, i);
        parcel.writeParcelable(this.ijz, i);
        parcel.writeLong(this.ijA);
        parcel.writeParcelable(this.ifP, i);
        OnWXAppResultXPCWrapper.m27900a(this.ijB, parcel);
        AppMethodBeat.m2505o(102120);
    }

    private LaunchParcel(Parcel parcel) {
        AppMethodBeat.m2504i(102121);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readInt();
        this.har = parcel.readInt();
        this.hgC = parcel.readString();
        this.ijy = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
        this.hgF = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.ijz = (LaunchParamsOptional) parcel.readParcelable(LaunchParamsOptional.class.getClassLoader());
        this.ijA = parcel.readLong();
        this.ifP = (ActivityStarterIpcDelegate) parcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader());
        this.ijB = OnWXAppResultXPCWrapper.m27901b(parcel);
        AppMethodBeat.m2505o(102121);
    }

    static {
        AppMethodBeat.m2504i(102124);
        AppMethodBeat.m2505o(102124);
    }

    /* renamed from: c */
    public final void mo34789c(AppBrandInitConfigLU appBrandInitConfigLU) {
        String str = null;
        AppMethodBeat.m2504i(102122);
        if (appBrandInitConfigLU == null) {
            AppMethodBeat.m2505o(102122);
            return;
        }
        if (TextUtils.isEmpty(appBrandInitConfigLU.username)) {
            appBrandInitConfigLU.username = this.username;
        }
        if (!(this.ijz == null || this.ijz.bQj == null)) {
            appBrandInitConfigLU.bQj.mo44852a(this.ijz.bQj);
        }
        appBrandInitConfigLU.hgC = LaunchParcel.m30355Cm(this.hgC);
        appBrandInitConfigLU.hgF.mo73344a(this.hgF);
        appBrandInitConfigLU.bQh = this.ijz == null ? null : this.ijz.bQh;
        if (this.ijz != null) {
            str = this.ijz.bQi;
        }
        appBrandInitConfigLU.bQi = str;
        appBrandInitConfigLU.startTime = this.ijA;
        appBrandInitConfigLU.bQm = this.ijB;
        AppMethodBeat.m2505o(102122);
    }

    /* renamed from: Cm */
    public static String m30355Cm(String str) {
        AppMethodBeat.m2504i(102123);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(102123);
            return str;
        }
        int i = 0;
        while (i < str.length() && IOUtils.DIR_SEPARATOR_UNIX == str.charAt(i)) {
            i++;
        }
        str = str.substring(i);
        AppMethodBeat.m2505o(102123);
        return str;
    }
}
