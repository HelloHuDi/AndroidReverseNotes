package com.tencent.p177mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo */
public class WePkgDiffInfo implements Parcelable {
    public static final Creator<WePkgDiffInfo> CREATOR = new C148011();
    public String cvZ;
    public String downloadUrl;
    public String eBS;
    public int fileSize;
    public String uWO;
    public String uWP;
    public int uWQ;
    public String version;

    /* renamed from: com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo$1 */
    static class C148011 implements Creator<WePkgDiffInfo> {
        C148011() {
        }

        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return null;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WePkgDiffInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(63523);
        parcel.writeString(this.eBS);
        parcel.writeString(this.uWO);
        parcel.writeString(this.uWP);
        parcel.writeString(this.version);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.cvZ);
        parcel.writeInt(this.fileSize);
        parcel.writeInt(this.uWQ);
        AppMethodBeat.m2505o(63523);
    }

    static {
        AppMethodBeat.m2504i(63524);
        AppMethodBeat.m2505o(63524);
    }
}
