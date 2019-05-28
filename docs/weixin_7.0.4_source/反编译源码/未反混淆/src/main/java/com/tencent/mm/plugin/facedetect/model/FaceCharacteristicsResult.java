package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public class FaceCharacteristicsResult implements Parcelable {
    public static final Creator<FaceCharacteristicsResult> CREATOR = new Creator<FaceCharacteristicsResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceCharacteristicsResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
            FaceCharacteristicsResult faceCharacteristicsResult = new FaceCharacteristicsResult(parcel);
            AppMethodBeat.o(ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
            return faceCharacteristicsResult;
        }
    };
    public String aIm;
    public int errCode;
    public FaceStatus lTF;

    protected FaceCharacteristicsResult(Parcel parcel) {
        AppMethodBeat.i(178);
        this.errCode = parcel.readInt();
        this.aIm = parcel.readString();
        AppMethodBeat.o(178);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(179);
        parcel.writeParcelable(this.lTF, i);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.aIm);
        AppMethodBeat.o(179);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(181);
        AppMethodBeat.o(181);
    }

    public String toString() {
        AppMethodBeat.i(180);
        String str = "FaceCharacteristicsResult{mStatus=" + this.lTF + ", errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + '}';
        AppMethodBeat.o(180);
        return str;
    }

    public static boolean vh(int i) {
        return i >= 10 && i < 100;
    }

    public static boolean vi(int i) {
        return i > 0 && i < 10;
    }

    public static boolean vj(int i) {
        return i <= 0;
    }

    public final void ay(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }
}
