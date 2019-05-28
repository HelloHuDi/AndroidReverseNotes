package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick implements Parcelable {
    public static final Creator<SnsAdClick> CREATOR = new Creator<SnsAdClick>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsAdClick[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(94453);
            SnsAdClick snsAdClick = new SnsAdClick();
            snsAdClick.cvd = parcel.readInt();
            snsAdClick.fPY = parcel.readInt();
            snsAdClick.cND = parcel.readLong();
            snsAdClick.fPZ = parcel.readInt();
            snsAdClick.fQa = parcel.readInt();
            snsAdClick.fQb = parcel.readInt();
            snsAdClick.fQc = parcel.readInt();
            snsAdClick.startTime = parcel.readLong();
            snsAdClick.fQe = parcel.readLong();
            AppMethodBeat.o(94453);
            return snsAdClick;
        }
    };
    public long cND;
    public int cvd;
    public int fPY;
    public int fPZ;
    public int fQa;
    public int fQb;
    public int fQc;
    public long fQd;
    public long fQe;
    public int fQf;
    public long startTime;

    public SnsAdClick() {
        this.fPY = 0;
        this.fPZ = 0;
        this.fQa = 0;
        this.startTime = 0;
        this.fQb = 0;
        this.fQc = 0;
        this.fQd = 0;
        this.fQe = 0;
        this.fQf = 0;
    }

    public SnsAdClick(int i, long j, int i2) {
        this(i, 7, j, i2, 0, 0);
    }

    public SnsAdClick(int i, int i2, long j, int i3, int i4) {
        this(i, i2, j, i3, i4, 0);
    }

    public SnsAdClick(int i, int i2, long j, int i3, int i4, byte b) {
        this(i, i2, j, 22, i3, i4);
    }

    private SnsAdClick(int i, int i2, long j, int i3, int i4, int i5) {
        AppMethodBeat.i(94454);
        this.fPY = 0;
        this.fPZ = 0;
        this.fQa = 0;
        this.startTime = 0;
        this.fQb = 0;
        this.fQc = 0;
        this.fQd = 0;
        this.fQe = 0;
        this.fQf = 0;
        this.cvd = i;
        this.fPY = i2;
        this.cND = j;
        this.fPZ = i3;
        this.fQa = i4;
        this.fQb = 0;
        this.fQc = 0;
        this.fQf = i5;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(94454);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(94455);
        parcel.writeInt(this.cvd);
        parcel.writeInt(this.fPY);
        parcel.writeLong(this.cND);
        parcel.writeInt(this.fPZ);
        parcel.writeInt(this.fQa);
        parcel.writeInt(this.fQb);
        parcel.writeInt(this.fQc);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.fQe);
        AppMethodBeat.o(94455);
    }

    static {
        AppMethodBeat.i(94456);
        AppMethodBeat.o(94456);
    }
}
