package com.tencent.p177mm.plugin.facedetectlight.Utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult */
public class YTAGFaceReflectResult implements Parcelable {
    public static final Creator<YTAGFaceReflectResult> CREATOR = new C341221();
    public byte[] data;
    public int result;
    public byte[] sidedata;

    /* renamed from: com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult$1 */
    static class C341221 implements Creator<YTAGFaceReflectResult> {
        C341221() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new YTAGFaceReflectResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(754);
            YTAGFaceReflectResult yTAGFaceReflectResult = new YTAGFaceReflectResult(parcel);
            AppMethodBeat.m2505o(754);
            return yTAGFaceReflectResult;
        }
    }

    public YTAGFaceReflectResult(int i) {
        this.result = i;
        this.data = null;
        this.sidedata = null;
    }

    protected YTAGFaceReflectResult(Parcel parcel) {
        AppMethodBeat.m2504i(755);
        this.result = parcel.readInt();
        this.data = parcel.createByteArray();
        this.sidedata = parcel.createByteArray();
        AppMethodBeat.m2505o(755);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(756);
        parcel.writeInt(this.result);
        parcel.writeByteArray(this.data);
        parcel.writeByteArray(this.sidedata);
        AppMethodBeat.m2505o(756);
    }

    static {
        AppMethodBeat.m2504i(757);
        AppMethodBeat.m2505o(757);
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
