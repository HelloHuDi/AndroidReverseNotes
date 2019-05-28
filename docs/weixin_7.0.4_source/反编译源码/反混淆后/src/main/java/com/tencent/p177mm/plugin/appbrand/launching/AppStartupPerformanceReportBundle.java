package com.tencent.p177mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C37827cg;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle */
public class AppStartupPerformanceReportBundle implements Parcelable, C10441j {
    public static final Creator<AppStartupPerformanceReportBundle> CREATOR = new C271501();
    public final String igT;
    public final List<C37827cg> igU;
    public final List<kv_14609> igV;
    public boolean igW;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle$1 */
    static class C271501 implements Creator<AppStartupPerformanceReportBundle> {
        C271501() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppStartupPerformanceReportBundle[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(131802);
            AppStartupPerformanceReportBundle appStartupPerformanceReportBundle = new AppStartupPerformanceReportBundle(parcel, (byte) 0);
            AppMethodBeat.m2505o(131802);
            return appStartupPerformanceReportBundle;
        }
    }

    /* synthetic */ AppStartupPerformanceReportBundle(Parcel parcel, byte b) {
        this(parcel);
    }

    public final boolean aHk() {
        AppMethodBeat.m2504i(131803);
        if (this.igV == null) {
            AppMethodBeat.m2505o(131803);
            return false;
        }
        for (kv_14609 kv_14609 : this.igV) {
            if (kv_14609 != null) {
                Object obj;
                if (kv_14609.iCm > 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppMethodBeat.m2505o(131803);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(131803);
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(131804);
        parcel.writeString(this.igT);
        if (C5046bo.m7548ek(this.igU)) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.igU.size());
            for (C37827cg Fj : this.igU) {
                parcel.writeString(Fj.mo4982Fj());
            }
        }
        parcel.writeTypedList(this.igV);
        parcel.writeByte((byte) (this.igW ? 1 : 0));
        AppMethodBeat.m2505o(131804);
    }

    public AppStartupPerformanceReportBundle(String str) {
        AppMethodBeat.m2504i(131805);
        this.igT = str;
        this.igU = new LinkedList();
        this.igV = new LinkedList();
        AppMethodBeat.m2505o(131805);
    }

    private AppStartupPerformanceReportBundle(Parcel parcel) {
        boolean z = false;
        AppMethodBeat.m2504i(131806);
        this.igT = parcel.readString();
        this.igU = new LinkedList();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            for (int i = 0; i < readInt; i++) {
                this.igU.add(new C37827cg(parcel.readString()));
            }
        }
        this.igV = parcel.createTypedArrayList(kv_14609.CREATOR);
        if (parcel.readByte() > (byte) 0) {
            z = true;
        }
        this.igW = z;
        AppMethodBeat.m2505o(131806);
    }

    static {
        AppMethodBeat.m2504i(131807);
        AppMethodBeat.m2505o(131807);
    }
}
