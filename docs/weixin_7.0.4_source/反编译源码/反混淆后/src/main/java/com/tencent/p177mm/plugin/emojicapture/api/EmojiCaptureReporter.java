package com.tencent.p177mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter */
public class EmojiCaptureReporter implements Parcelable {
    public static final Creator<EmojiCaptureReporter> CREATOR = new C277881();
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

    /* renamed from: com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter$1 */
    static class C277881 implements Creator<EmojiCaptureReporter> {
        C277881() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EmojiCaptureReporter[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(57450);
            EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter(parcel);
            AppMethodBeat.m2505o(57450);
            return emojiCaptureReporter;
        }
    }

    public final void bmv() {
        int i;
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.m2504i(57451);
        if (!C5046bo.isNullOrNil(this.eyJ)) {
            this.eyJ = this.eyJ.replace(",", " ");
        }
        C7060h c7060h = C7060h.pYm;
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
        c7060h.mo8381e(15989, objArr);
        AppMethodBeat.m2505o(57451);
    }

    /* renamed from: a */
    public static void m66031a(int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(57452);
        C7060h.pYm.mo8381e(15982, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.m2505o(57452);
    }

    public static void bmw() {
        AppMethodBeat.m2504i(57453);
        C7060h.pYm.mo8381e(15982, Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.m2505o(57453);
    }

    /* renamed from: a */
    public static void m66032a(long j, String str, int i) {
        AppMethodBeat.m2504i(57454);
        C7060h.pYm.mo8381e(15982, Integer.valueOf(23), Long.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str, Integer.valueOf(i), Integer.valueOf(0));
        AppMethodBeat.m2505o(57454);
    }

    /* renamed from: d */
    public static void m66033d(long j, long j2, int i) {
        AppMethodBeat.m2504i(57455);
        EmojiCaptureReporter.m66031a(20, j, 0, 0, 0, 0, j2, 0, 0, i);
        AppMethodBeat.m2505o(57455);
    }

    /* renamed from: g */
    public static void m66036g(long j, int i, int i2) {
        AppMethodBeat.m2504i(57456);
        EmojiCaptureReporter.m66031a(22, j, 0, 0, 0, 0, 0, 0, i, i2);
        switch (i) {
            case 1:
                EmojiCaptureReporter.m66034dU(7, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 2:
                EmojiCaptureReporter.m66034dU(6, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 3:
                EmojiCaptureReporter.m66034dU(8, 1);
                break;
            case 4:
                EmojiCaptureReporter.m66034dU(28, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 5:
                EmojiCaptureReporter.m66034dU(22, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 6:
                EmojiCaptureReporter.m66034dU(24, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 7:
                EmojiCaptureReporter.m66034dU(25, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 8:
                EmojiCaptureReporter.m66034dU(26, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 9:
                EmojiCaptureReporter.m66034dU(27, 1);
                AppMethodBeat.m2505o(57456);
                return;
            case 10:
                AppMethodBeat.m2505o(57456);
                return;
        }
        AppMethodBeat.m2505o(57456);
    }

    /* renamed from: e */
    public static void m66035e(long j, long j2, int i) {
        AppMethodBeat.m2504i(57457);
        EmojiCaptureReporter.m66031a(19, j, 0, 0, 0, j2, 0, 0, 0, i);
        EmojiCaptureReporter.m66034dU(1, 1);
        AppMethodBeat.m2505o(57457);
    }

    /* renamed from: h */
    public static void m66037h(long j, int i, int i2) {
        AppMethodBeat.m2504i(57458);
        EmojiCaptureReporter.m66031a(21, j, 0, 0, 0, 0, 0, i, 0, i2);
        switch (i) {
            case 1:
                EmojiCaptureReporter.m66034dU(5, 1);
                break;
            case 3:
                EmojiCaptureReporter.m66034dU(21, 1);
                AppMethodBeat.m2505o(57458);
                return;
            case 4:
                EmojiCaptureReporter.m66034dU(29, 1);
                AppMethodBeat.m2505o(57458);
                return;
            case 5:
                EmojiCaptureReporter.m66034dU(30, 1);
                AppMethodBeat.m2505o(57458);
                return;
        }
        AppMethodBeat.m2505o(57458);
    }

    /* renamed from: dU */
    public static void m66034dU(int i, int i2) {
        AppMethodBeat.m2504i(57459);
        C7060h.pYm.mo15419k(852, (long) i, (long) i2);
        AppMethodBeat.m2505o(57459);
    }

    /* renamed from: up */
    public static void m66038up(int i) {
        AppMethodBeat.m2504i(139076);
        EmojiCaptureReporter.m66034dU(i, 1);
        AppMethodBeat.m2505o(139076);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        AppMethodBeat.m2504i(57461);
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
        AppMethodBeat.m2505o(57461);
    }

    public EmojiCaptureReporter(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(57462);
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
        AppMethodBeat.m2505o(57462);
    }

    static {
        AppMethodBeat.m2504i(57463);
        AppMethodBeat.m2505o(57463);
    }
}
