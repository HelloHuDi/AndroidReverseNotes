package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class StIDKeyDataInfo implements Parcelable {
    public static final Creator<StIDKeyDataInfo> CREATOR = new Creator<StIDKeyDataInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StIDKeyDataInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(72800);
            StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo(parcel);
            AppMethodBeat.o(72800);
            return stIDKeyDataInfo;
        }
    };
    public long key;
    public long lhy;
    public boolean pXA;
    public long value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(72801);
        parcel.writeLong(this.lhy);
        parcel.writeLong(this.key);
        parcel.writeLong(this.value);
        parcel.writeInt(this.pXA ? 1 : 0);
        AppMethodBeat.o(72801);
    }

    protected StIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(72802);
        this.lhy = parcel.readLong();
        this.key = parcel.readLong();
        this.value = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.pXA = z;
        AppMethodBeat.o(72802);
    }

    static {
        AppMethodBeat.i(72803);
        AppMethodBeat.o(72803);
    }
}
