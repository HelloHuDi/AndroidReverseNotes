package com.tencent.p177mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify */
public class DownloadBigPkgCompleteNotify implements Parcelable {
    public static final Creator<DownloadBigPkgCompleteNotify> CREATOR = new C403971();
    public String eBS;
    public boolean success;

    /* renamed from: com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify$1 */
    static class C403971 implements Creator<DownloadBigPkgCompleteNotify> {
        C403971() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DownloadBigPkgCompleteNotify[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(63456);
            DownloadBigPkgCompleteNotify downloadBigPkgCompleteNotify = new DownloadBigPkgCompleteNotify(parcel, (byte) 0);
            AppMethodBeat.m2505o(63456);
            return downloadBigPkgCompleteNotify;
        }
    }

    public DownloadBigPkgCompleteNotify(String str, boolean z) {
        this.eBS = str;
        this.success = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(63457);
        parcel.writeString(this.eBS);
        parcel.writeInt(this.success ? 1 : 0);
        AppMethodBeat.m2505o(63457);
    }

    private DownloadBigPkgCompleteNotify(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(63458);
        this.eBS = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.success = z;
        AppMethodBeat.m2505o(63458);
    }

    static {
        AppMethodBeat.m2504i(63459);
        AppMethodBeat.m2505o(63459);
    }
}
