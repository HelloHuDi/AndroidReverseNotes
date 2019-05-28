package com.tencent.p177mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p298j.C45569d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40431k;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress */
public class WxaPkgLoadProgress implements Parcelable, C45569d, C40431k {
    public static final Creator<WxaPkgLoadProgress> CREATOR = new C100641();
    public long gUP = -1;
    public long gUQ = -1;
    public int progress = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress$1 */
    static class C100641 implements Creator<WxaPkgLoadProgress> {
        C100641() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgLoadProgress[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(59523);
            WxaPkgLoadProgress wxaPkgLoadProgress = new WxaPkgLoadProgress(parcel);
            AppMethodBeat.m2505o(59523);
            return wxaPkgLoadProgress;
        }
    }

    public WxaPkgLoadProgress(int i, long j, long j2) {
        this.progress = i;
        this.gUP = j;
        this.gUQ = j2;
    }

    protected WxaPkgLoadProgress(Parcel parcel) {
        AppMethodBeat.m2504i(59524);
        this.progress = parcel.readInt();
        this.gUP = parcel.readLong();
        this.gUQ = parcel.readLong();
        AppMethodBeat.m2505o(59524);
    }

    static {
        AppMethodBeat.m2504i(59527);
        AppMethodBeat.m2505o(59527);
    }

    public String toString() {
        AppMethodBeat.m2504i(59525);
        String str = "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.gUP + ", totalLength=" + this.gUQ + '}';
        AppMethodBeat.m2505o(59525);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(59526);
        parcel.writeInt(this.progress);
        parcel.writeLong(this.gUP);
        parcel.writeLong(this.gUQ);
        AppMethodBeat.m2505o(59526);
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
