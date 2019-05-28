package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.j.d;
import com.tencent.mm.pluginsdk.g.a.c.k;

public class WxaPkgLoadProgress implements Parcelable, d, k {
    public static final Creator<WxaPkgLoadProgress> CREATOR = new Creator<WxaPkgLoadProgress>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgLoadProgress[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(59523);
            WxaPkgLoadProgress wxaPkgLoadProgress = new WxaPkgLoadProgress(parcel);
            AppMethodBeat.o(59523);
            return wxaPkgLoadProgress;
        }
    };
    public long gUP = -1;
    public long gUQ = -1;
    public int progress = 0;

    public WxaPkgLoadProgress(int i, long j, long j2) {
        this.progress = i;
        this.gUP = j;
        this.gUQ = j2;
    }

    protected WxaPkgLoadProgress(Parcel parcel) {
        AppMethodBeat.i(59524);
        this.progress = parcel.readInt();
        this.gUP = parcel.readLong();
        this.gUQ = parcel.readLong();
        AppMethodBeat.o(59524);
    }

    static {
        AppMethodBeat.i(59527);
        AppMethodBeat.o(59527);
    }

    public String toString() {
        AppMethodBeat.i(59525);
        String str = "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.gUP + ", totalLength=" + this.gUQ + '}';
        AppMethodBeat.o(59525);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(59526);
        parcel.writeInt(this.progress);
        parcel.writeLong(this.gUP);
        parcel.writeLong(this.gUQ);
        AppMethodBeat.o(59526);
    }

    public final int getProgress() {
        return this.progress;
    }

    public final long awk() {
        return this.gUP;
    }

    public final long awl() {
        return this.gUQ;
    }
}
