package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public class EmojiCaptureReporter implements Parcelable {
    public static final Creator<EmojiCaptureReporter> CREATOR = new Creator<EmojiCaptureReporter>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EmojiCaptureReporter[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(57450);
            EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter(parcel);
            AppMethodBeat.o(57450);
            return emojiCaptureReporter;
        }
    };
    public long ckF;
    public boolean eAb;
    public long euE;
    public String eyJ;
    public long ezZ;
    public boolean fas;
    public long lgL;
    public long lgM;
    public long lgN;
    public long lgO;
    public long lgP;
    public long lgQ;
    public long lgR;
    public boolean lgS;
    public boolean lgT;
    public int lgU;
    public int lgV;
    public String lgW;
    public String lgX;
    public String lgY;
    public int scene;
    public int textColor;

    public final void bmv() {
        int i;
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(57451);
        if (!bo.isNullOrNil(this.eyJ)) {
            this.eyJ = this.eyJ.replace(",", " ");
        }
        h hVar = h.pYm;
        Object[] objArr = new Object[19];
        objArr[0] = Long.valueOf(this.ezZ);
        objArr[1] = Long.valueOf(this.ckF);
        objArr[2] = Long.valueOf(this.euE);
        objArr[3] = Long.valueOf(this.lgR);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = this.eyJ;
        objArr[7] = Integer.toHexString(this.textColor & 16777215);
        if (this.lgS) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[8] = Integer.valueOf(i);
        if (this.lgT) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(this.lgU);
        if (this.eAb) {
            i3 = 1;
        }
        objArr[11] = Integer.valueOf(i3);
        objArr[12] = Integer.valueOf(this.lgV);
        objArr[13] = this.lgW;
        objArr[14] = "";
        objArr[15] = "";
        if (this.fas) {
            i2 = 2;
        }
        objArr[16] = Integer.valueOf(i2);
        objArr[17] = this.lgX;
        objArr[18] = this.lgY;
        hVar.e(15989, objArr);
        AppMethodBeat.o(57451);
    }

    public static void a(int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, int i3, int i4) {
        AppMethodBeat.i(57452);
        h.pYm.e(15982, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(57452);
    }

    public static void bmw() {
        AppMethodBeat.i(57453);
        h.pYm.e(15982, Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.o(57453);
    }

    public static void a(long j, String str, int i) {
        AppMethodBeat.i(57454);
        h.pYm.e(15982, Integer.valueOf(23), Long.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str, Integer.valueOf(i), Integer.valueOf(0));
        AppMethodBeat.o(57454);
    }

    public static void d(long j, long j2, int i) {
        AppMethodBeat.i(57455);
        a(20, j, 0, 0, 0, 0, j2, 0, 0, i);
        AppMethodBeat.o(57455);
    }

    public static void g(long j, int i, int i2) {
        AppMethodBeat.i(57456);
        a(22, j, 0, 0, 0, 0, 0, 0, i, i2);
        switch (i) {
            case 1:
                dU(7, 1);
                AppMethodBeat.o(57456);
                return;
            case 2:
                dU(6, 1);
                AppMethodBeat.o(57456);
                return;
            case 3:
                dU(8, 1);
                break;
            case 4:
                dU(28, 1);
                AppMethodBeat.o(57456);
                return;
            case 5:
                dU(22, 1);
                AppMethodBeat.o(57456);
                return;
            case 6:
                dU(24, 1);
                AppMethodBeat.o(57456);
                return;
            case 7:
                dU(25, 1);
                AppMethodBeat.o(57456);
                return;
            case 8:
                dU(26, 1);
                AppMethodBeat.o(57456);
                return;
            case 9:
                dU(27, 1);
                AppMethodBeat.o(57456);
                return;
            case 10:
                AppMethodBeat.o(57456);
                return;
        }
        AppMethodBeat.o(57456);
    }

    public static void e(long j, long j2, int i) {
        AppMethodBeat.i(57457);
        a(19, j, 0, 0, 0, j2, 0, 0, 0, i);
        dU(1, 1);
        AppMethodBeat.o(57457);
    }

    public static void h(long j, int i, int i2) {
        AppMethodBeat.i(57458);
        a(21, j, 0, 0, 0, 0, 0, i, 0, i2);
        switch (i) {
            case 1:
                dU(5, 1);
                break;
            case 3:
                dU(21, 1);
                AppMethodBeat.o(57458);
                return;
            case 4:
                dU(29, 1);
                AppMethodBeat.o(57458);
                return;
            case 5:
                dU(30, 1);
                AppMethodBeat.o(57458);
                return;
        }
        AppMethodBeat.o(57458);
    }

    public static void dU(int i, int i2) {
        AppMethodBeat.i(57459);
        h.pYm.k(852, (long) i, (long) i2);
        AppMethodBeat.o(57459);
    }

    public static void up(int i) {
        AppMethodBeat.i(139076);
        dU(i, 1);
        AppMethodBeat.o(139076);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        AppMethodBeat.i(57461);
        parcel.writeLong(this.ezZ);
        parcel.writeLong(this.lgL);
        parcel.writeLong(this.lgM);
        parcel.writeLong(this.lgN);
        parcel.writeLong(this.lgO);
        parcel.writeLong(this.lgP);
        parcel.writeLong(this.lgQ);
        parcel.writeLong(this.euE);
        parcel.writeLong(this.lgR);
        parcel.writeLong(this.ckF);
        parcel.writeInt(this.textColor);
        parcel.writeByte(this.lgS ? (byte) 1 : (byte) 0);
        if (this.lgT) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeInt(this.lgU);
        if (!this.eAb) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.lgV);
        parcel.writeString(this.eyJ);
        parcel.writeString(this.lgW);
        AppMethodBeat.o(57461);
    }

    public EmojiCaptureReporter(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(57462);
        this.ezZ = parcel.readLong();
        this.lgL = parcel.readLong();
        this.lgM = parcel.readLong();
        this.lgN = parcel.readLong();
        this.lgO = parcel.readLong();
        this.lgP = parcel.readLong();
        this.lgQ = parcel.readLong();
        this.euE = parcel.readLong();
        this.lgR = parcel.readLong();
        this.ckF = parcel.readLong();
        this.textColor = parcel.readInt();
        this.lgS = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.lgT = z;
        this.lgU = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.eAb = z2;
        this.lgV = parcel.readInt();
        this.eyJ = parcel.readString();
        this.lgW = parcel.readString();
        AppMethodBeat.o(57462);
    }

    static {
        AppMethodBeat.i(57463);
        AppMethodBeat.o(57463);
    }
}
