package com.tencent.p177mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.report.service.KVReportDataInfo */
class KVReportDataInfo implements Parcelable {
    public static final Creator<KVReportDataInfo> CREATOR = new C37411();
    public long ctk = 0;
    public boolean pXA;
    public long pXX;
    public boolean pXY;
    public boolean pXZ;
    public String value;

    /* renamed from: com.tencent.mm.plugin.report.service.KVReportDataInfo$1 */
    static class C37411 implements Creator<KVReportDataInfo> {
        C37411() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KVReportDataInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(72729);
            KVReportDataInfo kVReportDataInfo = new KVReportDataInfo(parcel);
            AppMethodBeat.m2505o(72729);
            return kVReportDataInfo;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(72730);
        parcel.writeLong(this.pXX);
        parcel.writeLong(this.ctk);
        parcel.writeString(this.value);
        if (this.pXY) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pXA) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pXZ) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        AppMethodBeat.m2505o(72730);
    }

    protected KVReportDataInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(72731);
        this.pXX = parcel.readLong();
        this.ctk = parcel.readLong();
        this.value = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pXY = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pXA = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.pXZ = z2;
        AppMethodBeat.m2505o(72731);
    }

    static {
        AppMethodBeat.m2504i(72732);
        AppMethodBeat.m2505o(72732);
    }
}
