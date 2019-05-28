package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;

public class FaceDetectReporter implements Parcelable {
    public static final Creator<FaceDetectReporter> CREATOR = new Creator<FaceDetectReporter>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReporter[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(227);
            FaceDetectReporter faceDetectReporter = new FaceDetectReporter(parcel);
            AppMethodBeat.o(227);
            return faceDetectReporter;
        }
    };
    public static FaceDetectReporter lUy = new FaceDetectReporter();
    public String appId = "";
    public long hbj = 0;
    public long lUA = -1;
    public long lUB = -1;
    public int lUC = 0;
    public boolean lUD = false;
    public boolean lUt = false;
    private FaceDetectReportInfo lUu = null;
    public int lUv = -1;
    public int lUw = 0;
    public int lUx = 0;
    private long lUz = 0;

    static {
        AppMethodBeat.i(242);
        AppMethodBeat.o(242);
    }

    protected FaceDetectReporter(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(228);
        this.hbj = parcel.readLong();
        this.lUt = parcel.readByte() != (byte) 0;
        this.lUu = (FaceDetectReportInfo) parcel.readParcelable(FaceDetectReportInfo.class.getClassLoader());
        this.appId = parcel.readString();
        this.lUv = parcel.readInt();
        this.lUw = parcel.readInt();
        this.lUx = parcel.readInt();
        this.lUz = parcel.readLong();
        this.lUA = parcel.readLong();
        this.lUB = parcel.readLong();
        this.lUC = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.lUD = z;
        AppMethodBeat.o(228);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        AppMethodBeat.i(229);
        parcel.writeLong(this.hbj);
        parcel.writeByte((byte) (this.lUt ? 1 : 0));
        parcel.writeParcelable(this.lUu, i);
        parcel.writeString(this.appId);
        parcel.writeInt(this.lUv);
        parcel.writeInt(this.lUw);
        parcel.writeInt(this.lUx);
        parcel.writeLong(this.lUz);
        parcel.writeLong(this.lUA);
        parcel.writeLong(this.lUB);
        parcel.writeInt(this.lUC);
        if (!this.lUD) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        AppMethodBeat.o(229);
    }

    public int describeContents() {
        return 0;
    }

    public static FaceDetectReporter bsJ() {
        AppMethodBeat.i(230);
        FaceDetectReporter faceDetectReporter;
        if (lUy == null) {
            synchronized (FaceDetectReporter.class) {
                try {
                    if (lUy == null) {
                        lUy = new FaceDetectReporter();
                    }
                    faceDetectReporter = lUy;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(230);
                }
            }
            return faceDetectReporter;
        }
        faceDetectReporter = lUy;
        AppMethodBeat.o(230);
        return faceDetectReporter;
    }

    public static void i(long j, int i, int i2) {
        AppMethodBeat.i(231);
        ab.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        h.pYm.e(14121, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(231);
    }

    private FaceDetectReporter() {
    }

    public final long bsK() {
        AppMethodBeat.i(232);
        ab.v("MicroMsg.FaceDetectReporter", "create report session");
        if (this.lUu == null) {
            this.lUu = new FaceDetectReportInfo();
        }
        this.lUu.reset();
        this.lUt = false;
        this.hbj = System.currentTimeMillis();
        this.lUu.hbj = this.hbj;
        long j = this.hbj;
        AppMethodBeat.o(232);
        return j;
    }

    public final long bsL() {
        AppMethodBeat.i(d.MIC_PTU_MEISHI);
        ab.v("MicroMsg.FaceDetectReporter", "create interface called session");
        this.lUz = System.currentTimeMillis();
        this.lUC = 0;
        this.lUD = false;
        this.lUA = -1;
        this.lUB = -1;
        long j = this.lUz;
        AppMethodBeat.o(d.MIC_PTU_MEISHI);
        return j;
    }

    public final void a(FaceDetectReporter faceDetectReporter) {
        AppMethodBeat.i(d.MIC_PTU_FENGJING);
        ab.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", bo.dpG().toString());
        this.lUu = faceDetectReporter.lUu;
        this.lUt = faceDetectReporter.lUt;
        this.hbj = faceDetectReporter.hbj;
        this.lUw = faceDetectReporter.lUw;
        this.lUx = faceDetectReporter.lUx;
        String str = "MicroMsg.FaceDetectReporter";
        String str2 = "alvinluo sessionId: %d, info: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.hbj);
        objArr[1] = this.lUu != null ? this.lUu.toString() : BuildConfig.COMMAND;
        ab.v(str, str2, objArr);
        AppMethodBeat.o(d.MIC_PTU_FENGJING);
    }

    public final void R(int i, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(d.MIC_PTU_AUTOLEVEL);
        ab.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", Integer.valueOf(i), Boolean.valueOf(z));
        h hVar = h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(this.hbj);
        if (!z) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        hVar.e(14005, objArr);
        AppMethodBeat.o(d.MIC_PTU_AUTOLEVEL);
    }

    public static int vl(int i) {
        switch (i) {
            case 0:
            case 3:
                return 2;
            case 1:
            case 4:
                return 3;
            case 2:
                return 1;
            case 5:
                return 4;
            default:
                return -1;
        }
    }

    public final void c(int i, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(236);
        a(i, z, i2, i3, i4, 0);
        AppMethodBeat.o(236);
    }

    public final void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(d.MIC_PTU_LENGMEIREN);
        ab.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", Long.valueOf(this.hbj), Boolean.valueOf(this.lUt), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!(this.lUu == null || this.lUt)) {
            ab.v("MicroMsg.FaceDetectReporter", "info: %s", this.lUu.toString());
            this.lUt = true;
            this.lUu.lSp = i5;
            if (this.lUu.cpf != 0) {
                this.lUu.lUq = this.lUu.lUp / this.lUu.cpf;
            }
            int i6 = 0;
            if (this.lUu.lUr.containsKey(Integer.valueOf(0)) && this.lUu.lUs.containsKey(Integer.valueOf(0))) {
                i6 = (int) (((Long) this.lUu.lUs.get(Integer.valueOf(0))).longValue() - ((Long) this.lUu.lUr.get(Integer.valueOf(0))).longValue());
                ab.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + i6 + "  hashCode :" + hashCode());
            }
            int i7 = i6;
            if (this.lUu.lUr.containsKey(Integer.valueOf(4)) && this.lUu.lUs.containsKey(Integer.valueOf(4))) {
                i6 = (int) (((Long) this.lUu.lUs.get(Integer.valueOf(4))).longValue() - ((Long) this.lUu.lUr.get(Integer.valueOf(4))).longValue());
                ab.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + i6 + "  hashCode :" + hashCode());
            } else {
                i6 = 0;
            }
            if (this.lUu.lUr.containsKey(Integer.valueOf(6)) && this.lUu.lUs.containsKey(Integer.valueOf(6))) {
                i6 = (int) (((Long) this.lUu.lUs.get(Integer.valueOf(6))).longValue() - ((Long) this.lUu.lUr.get(Integer.valueOf(6))).longValue());
                ab.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + i6 + "  hashCode :" + hashCode());
            }
            ab.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(hashCode()));
            h hVar = h.pYm;
            Object[] objArr = new Object[29];
            objArr[0] = Long.valueOf(this.hbj);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(z ? 1 : 0);
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = Integer.valueOf(i4);
            objArr[6] = Integer.valueOf(this.lUu.lUb);
            objArr[7] = Integer.valueOf(this.lUu.lUc);
            objArr[8] = Integer.valueOf(this.lUu.lUd);
            objArr[9] = Integer.valueOf(this.lUu.lUa);
            objArr[10] = Integer.valueOf(this.lUu.lUe);
            objArr[11] = Integer.valueOf(this.lUu.lUf);
            objArr[12] = Integer.valueOf(this.lUu.lUg);
            objArr[13] = Integer.valueOf(this.lUu.lUh);
            objArr[14] = Integer.valueOf(this.lUu.lUi);
            objArr[15] = Integer.valueOf(this.lUu.lUj);
            objArr[16] = Integer.valueOf(this.lUu.lUk);
            objArr[17] = Integer.valueOf(this.lUu.lUl);
            objArr[18] = Integer.valueOf(this.lUu.lUm);
            objArr[19] = Integer.valueOf(this.lUu.lSp);
            objArr[20] = Integer.valueOf(this.lUu.lUn);
            objArr[21] = Integer.valueOf(this.lUu.lUo);
            objArr[22] = Integer.valueOf(this.lUu.lUq);
            objArr[23] = Integer.valueOf(i7);
            objArr[24] = Integer.valueOf(i6);
            objArr[25] = this.appId;
            objArr[26] = Integer.valueOf(this.lUv);
            objArr[27] = Integer.valueOf(this.lUw);
            objArr[28] = Integer.valueOf(this.lUx);
            hVar.e(14006, objArr);
        }
        AppMethodBeat.o(d.MIC_PTU_LENGMEIREN);
    }

    public final void ce(String str, int i) {
        long j = -1;
        int i2 = 1;
        AppMethodBeat.i(d.MIC_PTU_SHIGUANG);
        if (this.lUA == -1 || this.lUB == -1 || this.lUB < this.lUA) {
            ab.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", Long.valueOf(this.lUA), Long.valueOf(this.lUB));
        } else {
            j = this.lUB - this.lUA;
        }
        ab.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", Long.valueOf(this.lUz), str, Integer.valueOf(-1), Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(this.lUD), this.appId, Integer.valueOf(this.lUC));
        h hVar = h.pYm;
        Object[] objArr = new Object[8];
        objArr[0] = Long.valueOf(this.lUz);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(-1);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.appId;
        if (!this.lUD) {
            i2 = 0;
        }
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Long.valueOf(j);
        objArr[7] = Integer.valueOf(this.lUC);
        hVar.e(14560, objArr);
        AppMethodBeat.o(d.MIC_PTU_SHIGUANG);
    }

    public final void G(int i, long j) {
        AppMethodBeat.i(d.MIC_PTU_SHISHANG2);
        if (this.lUu != null) {
            FaceDetectReportInfo faceDetectReportInfo = this.lUu;
            faceDetectReportInfo.cpf++;
            faceDetectReportInfo = this.lUu;
            faceDetectReportInfo.lUp = (int) (((long) faceDetectReportInfo.lUp) + j);
            this.lUu.vk(i);
        }
        AppMethodBeat.o(d.MIC_PTU_SHISHANG2);
    }

    public final void H(int i, long j) {
        AppMethodBeat.i(240);
        if (this.lUu != null) {
            ab.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + j);
            this.lUu.lUr.put(Integer.valueOf(i), Long.valueOf(j));
        }
        AppMethodBeat.o(240);
    }

    public final void I(int i, long j) {
        AppMethodBeat.i(d.MIC_PTU_QINGCONG);
        if (this.lUu != null) {
            ab.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + j);
            this.lUu.lUs.put(Integer.valueOf(i), Long.valueOf(j));
        }
        AppMethodBeat.o(d.MIC_PTU_QINGCONG);
    }
}
