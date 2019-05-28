package com.tencent.mm.plugin.facedetectlight.Utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTAGFaceReflectResult implements Parcelable {
    public static final Creator<YTAGFaceReflectResult> CREATOR = new Creator<YTAGFaceReflectResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new YTAGFaceReflectResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(754);
            YTAGFaceReflectResult yTAGFaceReflectResult = new YTAGFaceReflectResult(parcel);
            AppMethodBeat.o(754);
            return yTAGFaceReflectResult;
        }
    };
    public byte[] data;
    public int result;
    public byte[] sidedata;

    public YTAGFaceReflectResult(int i) {
        this.result = i;
        this.data = null;
        this.sidedata = null;
    }

    protected YTAGFaceReflectResult(Parcel parcel) {
        AppMethodBeat.i(755);
        this.result = parcel.readInt();
        this.data = parcel.createByteArray();
        this.sidedata = parcel.createByteArray();
        AppMethodBeat.o(755);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(756);
        parcel.writeInt(this.result);
        parcel.writeByteArray(this.data);
        parcel.writeByteArray(this.sidedata);
        AppMethodBeat.o(756);
    }

    static {
        AppMethodBeat.i(757);
        AppMethodBeat.o(757);
    }

    public int describeContents() {
        return 0;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setSidedata(byte[] bArr) {
        this.sidedata = bArr;
    }
}
