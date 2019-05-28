package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class LocalUsageInfo implements Parcelable {
    public static final Creator<LocalUsageInfo> CREATOR = new Creator<LocalUsageInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocalUsageInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114908);
            LocalUsageInfo localUsageInfo = new LocalUsageInfo(parcel, (byte) 0);
            AppMethodBeat.o(114908);
            return localUsageInfo;
        }
    };
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

    public final boolean e(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.i(114909);
        if (localUsageInfo == null) {
            AppMethodBeat.o(114909);
            return false;
        } else if (bo.isNullOrNil(localUsageInfo.username)) {
            AppMethodBeat.o(114909);
            return false;
        } else if (localUsageInfo.username.equals(this.username) && localUsageInfo.har == this.har) {
            AppMethodBeat.o(114909);
            return true;
        } else {
            AppMethodBeat.o(114909);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114910);
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
        AppMethodBeat.o(114910);
    }

    private LocalUsageInfo(Parcel parcel) {
        AppMethodBeat.i(114911);
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
        AppMethodBeat.o(114911);
    }

    static {
        AppMethodBeat.i(114912);
        AppMethodBeat.o(114912);
    }
}
