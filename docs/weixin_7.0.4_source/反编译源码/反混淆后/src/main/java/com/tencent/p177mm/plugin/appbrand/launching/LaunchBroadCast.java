package com.tencent.p177mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast */
public final class LaunchBroadCast implements Parcelable {
    public static final Creator<LaunchBroadCast> CREATOR = new C23751();
    public String appId;
    public int cDB;
    public boolean cQe;
    public int har;
    public String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast$1 */
    static class C23751 implements Creator<LaunchBroadCast> {
        C23751() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchBroadCast[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102105);
            LaunchBroadCast launchBroadCast = new LaunchBroadCast(parcel, (byte) 0);
            AppMethodBeat.m2505o(102105);
            return launchBroadCast;
        }
    }

    /* synthetic */ LaunchBroadCast(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    static void m43154a(String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(102106);
        LaunchBroadCast launchBroadCast = new LaunchBroadCast();
        launchBroadCast.username = null;
        launchBroadCast.appId = str;
        launchBroadCast.har = i;
        launchBroadCast.cDB = i2;
        launchBroadCast.cQe = z;
        C10276d.m17931a(str, launchBroadCast);
        AppMethodBeat.m2505o(102106);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102107);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.har);
        parcel.writeInt(this.cDB);
        parcel.writeByte(this.cQe ? (byte) 1 : (byte) 0);
        AppMethodBeat.m2505o(102107);
    }

    private LaunchBroadCast() {
    }

    private LaunchBroadCast(Parcel parcel) {
        AppMethodBeat.m2504i(102108);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.har = parcel.readInt();
        this.cDB = parcel.readInt();
        this.cQe = parcel.readByte() != (byte) 0;
        AppMethodBeat.m2505o(102108);
    }

    static {
        AppMethodBeat.m2504i(102109);
        AppMethodBeat.m2505o(102109);
    }
}
