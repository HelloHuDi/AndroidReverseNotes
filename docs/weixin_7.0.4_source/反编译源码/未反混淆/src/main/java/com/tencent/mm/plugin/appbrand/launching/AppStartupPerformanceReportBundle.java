package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle implements Parcelable, j {
    public static final Creator<AppStartupPerformanceReportBundle> CREATOR = new Creator<AppStartupPerformanceReportBundle>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppStartupPerformanceReportBundle[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131802);
            AppStartupPerformanceReportBundle appStartupPerformanceReportBundle = new AppStartupPerformanceReportBundle(parcel, (byte) 0);
            AppMethodBeat.o(131802);
            return appStartupPerformanceReportBundle;
        }
    };
    public final String igT;
    public final List<cg> igU;
    public final List<kv_14609> igV;
    public boolean igW;

    /* synthetic */ AppStartupPerformanceReportBundle(Parcel parcel, byte b) {
        this(parcel);
    }

    public final boolean aHk() {
        AppMethodBeat.i(131803);
        if (this.igV == null) {
            AppMethodBeat.o(131803);
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
                    AppMethodBeat.o(131803);
                    return true;
                }
            }
        }
        AppMethodBeat.o(131803);
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(131804);
        parcel.writeString(this.igT);
        if (bo.ek(this.igU)) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.igU.size());
            for (cg Fj : this.igU) {
                parcel.writeString(Fj.Fj());
            }
        }
        parcel.writeTypedList(this.igV);
        parcel.writeByte((byte) (this.igW ? 1 : 0));
        AppMethodBeat.o(131804);
    }

    public AppStartupPerformanceReportBundle(String str) {
        AppMethodBeat.i(131805);
        this.igT = str;
        this.igU = new LinkedList();
        this.igV = new LinkedList();
        AppMethodBeat.o(131805);
    }

    private AppStartupPerformanceReportBundle(Parcel parcel) {
        boolean z = false;
        AppMethodBeat.i(131806);
        this.igT = parcel.readString();
        this.igU = new LinkedList();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            for (int i = 0; i < readInt; i++) {
                this.igU.add(new cg(parcel.readString()));
            }
        }
        this.igV = parcel.createTypedArrayList(kv_14609.CREATOR);
        if (parcel.readByte() > (byte) 0) {
            z = true;
        }
        this.igW = z;
        AppMethodBeat.o(131806);
    }

    static {
        AppMethodBeat.i(131807);
        AppMethodBeat.o(131807);
    }
}
