package com.tencent.p177mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo */
class FaceDetectReportInfo implements Parcelable {
    public static final Creator<FaceDetectReportInfo> CREATOR = new C118081();
    protected int cpf = 0;
    protected long hbj = 0;
    protected int lSp = 0;
    protected int lUa = 0;
    protected int lUb = 0;
    protected int lUc = 0;
    protected int lUd = 0;
    protected int lUe = 0;
    protected int lUf = 0;
    protected int lUg = 0;
    protected int lUh = 0;
    protected int lUi = 0;
    protected int lUj = 0;
    protected int lUk = 0;
    protected int lUl = 0;
    protected int lUm = 0;
    protected int lUn = 0;
    protected int lUo = 0;
    protected int lUp = 0;
    protected int lUq = 0;
    protected HashMap<Integer, Long> lUr = new HashMap();
    protected HashMap<Integer, Long> lUs = new HashMap();

    /* renamed from: com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo$1 */
    static class C118081 implements Creator<FaceDetectReportInfo> {
        C118081() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReportInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(220);
            FaceDetectReportInfo faceDetectReportInfo = new FaceDetectReportInfo(parcel);
            AppMethodBeat.m2505o(220);
            return faceDetectReportInfo;
        }
    }

    public FaceDetectReportInfo() {
        AppMethodBeat.m2504i(221);
        AppMethodBeat.m2505o(221);
    }

    protected FaceDetectReportInfo(Parcel parcel) {
        AppMethodBeat.m2504i(222);
        this.hbj = parcel.readLong();
        this.lUa = parcel.readInt();
        this.lUb = parcel.readInt();
        this.lUc = parcel.readInt();
        this.lUd = parcel.readInt();
        this.lUe = parcel.readInt();
        this.lUf = parcel.readInt();
        this.lUg = parcel.readInt();
        this.lUh = parcel.readInt();
        this.lUi = parcel.readInt();
        this.lUj = parcel.readInt();
        this.lUk = parcel.readInt();
        this.lUl = parcel.readInt();
        this.lUm = parcel.readInt();
        this.lUn = parcel.readInt();
        this.lUo = parcel.readInt();
        this.cpf = parcel.readInt();
        this.lSp = parcel.readInt();
        this.lUp = parcel.readInt();
        this.lUq = parcel.readInt();
        try {
            this.lUr = parcel.readHashMap(HashMap.class.getClassLoader());
            this.lUs = parcel.readHashMap(HashMap.class.getClassLoader());
            AppMethodBeat.m2505o(222);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FaceDetectReportInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(222);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(223);
        parcel.writeLong(this.hbj);
        parcel.writeInt(this.lUa);
        parcel.writeInt(this.lUb);
        parcel.writeInt(this.lUc);
        parcel.writeInt(this.lUd);
        parcel.writeInt(this.lUe);
        parcel.writeInt(this.lUf);
        parcel.writeInt(this.lUg);
        parcel.writeInt(this.lUh);
        parcel.writeInt(this.lUi);
        parcel.writeInt(this.lUj);
        parcel.writeInt(this.lUk);
        parcel.writeInt(this.lUl);
        parcel.writeInt(this.lUm);
        parcel.writeInt(this.lUn);
        parcel.writeInt(this.lUo);
        parcel.writeInt(this.cpf);
        parcel.writeInt(this.lSp);
        parcel.writeInt(this.lUp);
        parcel.writeInt(this.lUq);
        parcel.writeMap(this.lUr);
        parcel.writeMap(this.lUs);
        AppMethodBeat.m2505o(223);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(226);
        AppMethodBeat.m2505o(226);
    }

    /* renamed from: vk */
    public final void mo23608vk(int i) {
        if (i > 0) {
            if (i == 1) {
                this.lUb++;
            } else if (i == 2) {
                this.lUc++;
            } else {
                this.lUb++;
            }
        } else if (i == 0) {
            this.lUd++;
        } else if (i == -11) {
            this.lUf++;
        } else if (i == -12) {
            this.lUg++;
        } else if (i == -13) {
            this.lUh++;
        } else if (i == XWalkUpdater.ERROR_SET_VERNUM) {
            this.lUl++;
        } else if (i == ZipJNI.UNZ_PARAMERROR) {
            this.lUi++;
        } else if (i == ZipJNI.UNZ_BADZIPFILE) {
            this.lUj++;
        } else if (i == ZipJNI.UNZ_CRCERROR) {
            this.lUk++;
        } else if (i == ZipJNI.UNZ_ERR_OPEN_WRITE) {
            this.lUe++;
        } else if (i == -107) {
            this.lUm++;
        } else if (i == -108) {
            this.lUn++;
        } else if (i == -109) {
            this.lUo++;
        } else {
            this.lUa++;
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(224);
        this.hbj = 0;
        this.lUb = 0;
        this.lUc = 0;
        this.lUd = 0;
        this.lUa = 0;
        this.lUe = 0;
        this.lUf = 0;
        this.lUg = 0;
        this.lUh = 0;
        this.lUi = 0;
        this.lUj = 0;
        this.lUk = 0;
        this.lUl = 0;
        this.lUm = 0;
        this.cpf = 0;
        this.lSp = 0;
        this.lUp = 0;
        this.lUq = 0;
        this.lUr.clear();
        this.lUs.clear();
        AppMethodBeat.m2505o(224);
    }

    public String toString() {
        AppMethodBeat.m2504i(225);
        String str = "detectOk: " + this.lUb + ", motionOk: " + this.lUc + ", noFace: " + this.lUd + ", systemErr: " + this.lUa + ", noLiveFace: " + this.lUe + ", tooDark: " + this.lUf + ", tooLight: " + this.lUg + ", backLight: " + this.lUh + ", tooSmall: " + this.lUi + ", tooBig: " + this.lUj + ", tooActive: " + this.lUk + ", poseNotValid: " + this.lUl + ", timeOut: " + this.lUm + ", totalFrame: " + this.cpf + ", verifyTime: " + this.lSp + ", processTimePerFrame: " + this.lUq;
        AppMethodBeat.m2505o(225);
        return str;
    }
}
