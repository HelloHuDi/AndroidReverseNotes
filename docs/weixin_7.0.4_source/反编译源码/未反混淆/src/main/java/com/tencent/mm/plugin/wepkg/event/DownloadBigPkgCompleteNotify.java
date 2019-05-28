package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadBigPkgCompleteNotify implements Parcelable {
    public static final Creator<DownloadBigPkgCompleteNotify> CREATOR = new Creator<DownloadBigPkgCompleteNotify>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DownloadBigPkgCompleteNotify[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(63456);
            DownloadBigPkgCompleteNotify downloadBigPkgCompleteNotify = new DownloadBigPkgCompleteNotify(parcel, (byte) 0);
            AppMethodBeat.o(63456);
            return downloadBigPkgCompleteNotify;
        }
    };
    public String eBS;
    public boolean success;

    public DownloadBigPkgCompleteNotify(String str, boolean z) {
        this.eBS = str;
        this.success = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(63457);
        parcel.writeString(this.eBS);
        parcel.writeInt(this.success ? 1 : 0);
        AppMethodBeat.o(63457);
    }

    private DownloadBigPkgCompleteNotify(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(63458);
        this.eBS = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.success = z;
        AppMethodBeat.o(63458);
    }

    static {
        AppMethodBeat.i(63459);
        AppMethodBeat.o(63459);
    }
}
