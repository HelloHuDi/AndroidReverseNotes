package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo */
public class LocalUsageInfo implements Parcelable {
    public static final Creator<LocalUsageInfo> CREATOR = new C267561();
    public final String appId;
    public final int axy;
    public final String bQo;
    public final String haO;
    public final boolean haP;
    public final long haQ;
    public final long haR;
    public final int har;
    public final String nickname;
    public final String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo$1 */
    static class C267561 implements Creator<LocalUsageInfo> {
        C267561() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocalUsageInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114908);
            LocalUsageInfo localUsageInfo = new LocalUsageInfo(parcel, (byte) 0);
            AppMethodBeat.m2505o(114908);
            return localUsageInfo;
        }
    }

    /* synthetic */ LocalUsageInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public LocalUsageInfo(String str, String str2, int i, int i2, String str3, String str4, String str5, boolean z, long j, long j2) {
        this.username = str;
        this.appId = str2;
        this.har = i;
        this.axy = i2;
        this.nickname = str3;
        this.bQo = str4;
        this.haO = str5;
        this.haP = z;
        this.haQ = j;
        this.haR = j2;
    }

    /* renamed from: e */
    public final boolean mo53657e(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.m2504i(114909);
        if (localUsageInfo == null) {
            AppMethodBeat.m2505o(114909);
            return false;
        } else if (C5046bo.isNullOrNil(localUsageInfo.username)) {
            AppMethodBeat.m2505o(114909);
            return false;
        } else if (localUsageInfo.username.equals(this.username) && localUsageInfo.har == this.har) {
            AppMethodBeat.m2505o(114909);
            return true;
        } else {
            AppMethodBeat.m2505o(114909);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114910);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.har);
        parcel.writeInt(this.axy);
        parcel.writeString(this.nickname);
        parcel.writeString(this.bQo);
        parcel.writeString(this.haO);
        parcel.writeByte((byte) (this.haP ? 1 : 0));
        parcel.writeLong(this.haQ);
        parcel.writeLong(this.haR);
        AppMethodBeat.m2505o(114910);
    }

    private LocalUsageInfo(Parcel parcel) {
        AppMethodBeat.m2504i(114911);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.har = parcel.readInt();
        this.axy = parcel.readInt();
        this.nickname = parcel.readString();
        this.bQo = parcel.readString();
        this.haO = parcel.readString();
        this.haP = parcel.readByte() > (byte) 0;
        this.haQ = parcel.readLong();
        this.haR = parcel.readLong();
        AppMethodBeat.m2505o(114911);
    }

    static {
        AppMethodBeat.m2504i(114912);
        AppMethodBeat.m2505o(114912);
    }
}
