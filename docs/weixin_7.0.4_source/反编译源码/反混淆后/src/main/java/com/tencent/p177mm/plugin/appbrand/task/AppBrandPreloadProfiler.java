package com.tencent.p177mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler */
public class AppBrandPreloadProfiler implements Parcelable {
    public static final Creator<AppBrandPreloadProfiler> CREATOR = new C385171();
    public long endTime = Long.MAX_VALUE;
    public long iEh = Long.MAX_VALUE;
    public long iEi = Long.MAX_VALUE;
    public long iEj = Long.MAX_VALUE;
    public long startTime = Long.MAX_VALUE;

    /* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler$1 */
    static class C385171 implements Creator<AppBrandPreloadProfiler> {
        C385171() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPreloadProfiler[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(132781);
            AppBrandPreloadProfiler appBrandPreloadProfiler = new AppBrandPreloadProfiler(parcel);
            AppMethodBeat.m2505o(132781);
            return appBrandPreloadProfiler;
        }
    }

    public final long aLK() {
        AppMethodBeat.m2504i(132782);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.iEh = elapsedRealtime;
        AppMethodBeat.m2505o(132782);
        return elapsedRealtime;
    }

    public final long aLL() {
        AppMethodBeat.m2504i(132783);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.endTime = elapsedRealtime;
        AppMethodBeat.m2505o(132783);
        return elapsedRealtime;
    }

    public final long aLM() {
        if (this.iEj == Long.MAX_VALUE || this.endTime == Long.MAX_VALUE) {
            return 0;
        }
        return this.endTime - this.iEj;
    }

    public final long aLN() {
        if (this.endTime == Long.MAX_VALUE || this.iEh == Long.MAX_VALUE) {
            return 0;
        }
        return this.endTime - this.iEh;
    }

    public String toString() {
        AppMethodBeat.m2504i(132784);
        String t;
        if (this.iEh == Long.MAX_VALUE || this.iEi == Long.MAX_VALUE || this.startTime == Long.MAX_VALUE || this.endTime == Long.MAX_VALUE) {
            t = C5046bo.m7584t("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", Long.valueOf(this.iEh), Long.valueOf(this.iEi), Long.valueOf(this.startTime), Long.valueOf(this.endTime));
            AppMethodBeat.m2505o(132784);
            return t;
        }
        t = C5046bo.m7584t("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", Long.valueOf(this.iEi - this.iEh), Long.valueOf(this.startTime - this.iEi), Long.valueOf(this.endTime - this.startTime));
        AppMethodBeat.m2505o(132784);
        return t;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(132785);
        parcel.writeLong(this.iEh);
        parcel.writeLong(this.iEi);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeLong(this.iEj);
        AppMethodBeat.m2505o(132785);
    }

    protected AppBrandPreloadProfiler(Parcel parcel) {
        AppMethodBeat.m2504i(132786);
        this.iEh = parcel.readLong();
        this.iEi = parcel.readLong();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.iEj = parcel.readLong();
        AppMethodBeat.m2505o(132786);
    }

    static {
        AppMethodBeat.m2504i(132787);
        AppMethodBeat.m2505o(132787);
    }
}
