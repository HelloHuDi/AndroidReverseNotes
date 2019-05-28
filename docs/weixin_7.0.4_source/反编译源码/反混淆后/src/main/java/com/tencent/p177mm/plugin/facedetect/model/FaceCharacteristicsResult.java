package com.tencent.p177mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.facedetect.FaceProNative.FaceStatus;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult */
public class FaceCharacteristicsResult implements Parcelable {
    public static final Creator<FaceCharacteristicsResult> CREATOR = new C118071();
    public String aIm;
    public int errCode;
    public FaceStatus lTF;

    /* renamed from: com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult$1 */
    static class C118071 implements Creator<FaceCharacteristicsResult> {
        C118071() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceCharacteristicsResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
            FaceCharacteristicsResult faceCharacteristicsResult = new FaceCharacteristicsResult(parcel);
            AppMethodBeat.m2505o(ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
            return faceCharacteristicsResult;
        }
    }

    protected FaceCharacteristicsResult(Parcel parcel) {
        AppMethodBeat.m2504i(178);
        this.errCode = parcel.readInt();
        this.aIm = parcel.readString();
        AppMethodBeat.m2505o(178);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(179);
        parcel.writeParcelable(this.lTF, i);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.aIm);
        AppMethodBeat.m2505o(179);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(181);
        AppMethodBeat.m2505o(181);
    }

    public String toString() {
        AppMethodBeat.m2504i(180);
        String str = "FaceCharacteristicsResult{mStatus=" + this.lTF + ", errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + '}';
        AppMethodBeat.m2505o(180);
        return str;
    }

    /* renamed from: vh */
    public static boolean m19654vh(int i) {
        return i >= 10 && i < 100;
    }

    /* renamed from: vi */
    public static boolean m19655vi(int i) {
        return i > 0 && i < 10;
    }

    /* renamed from: vj */
    public static boolean m19656vj(int i) {
        return i <= 0;
    }

    /* renamed from: ay */
    public final void mo23599ay(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }
}
