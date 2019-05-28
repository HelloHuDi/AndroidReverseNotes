package com.tencent.p177mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.report.service.StIDKeyDataInfo */
class StIDKeyDataInfo implements Parcelable {
    public static final Creator<StIDKeyDataInfo> CREATOR = new C37421();
    public long key;
    public long lhy;
    public boolean pXA;
    public long value;

    /* renamed from: com.tencent.mm.plugin.report.service.StIDKeyDataInfo$1 */
    static class C37421 implements Creator<StIDKeyDataInfo> {
        C37421() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StIDKeyDataInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(72800);
            StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo(parcel);
            AppMethodBeat.m2505o(72800);
            return stIDKeyDataInfo;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(72801);
        parcel.writeLong(this.lhy);
        parcel.writeLong(this.key);
        parcel.writeLong(this.value);
        parcel.writeInt(this.pXA ? 1 : 0);
        AppMethodBeat.m2505o(72801);
    }

    protected StIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(72802);
        this.lhy = parcel.readLong();
        this.key = parcel.readLong();
        this.value = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.pXA = z;
        AppMethodBeat.m2505o(72802);
    }

    static {
        AppMethodBeat.m2504i(72803);
        AppMethodBeat.m2505o(72803);
    }
}
