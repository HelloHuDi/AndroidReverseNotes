package com.tencent.p177mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.VertifyInfo */
public class VertifyInfo implements Parcelable {
    public static final Creator<VertifyInfo> CREATOR = new C224451();
    public String gCk = "";
    public String mFileName = "";
    public String mText = "";
    public boolean mcM = false;
    public String sKY = "";
    public int sLg = 0;
    public int sLn;
    public int sLo;
    public int sLp = 0;
    public boolean sLq = false;

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.VertifyInfo$1 */
    static class C224451 implements Creator<VertifyInfo> {
        C224451() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VertifyInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(26108);
            VertifyInfo vertifyInfo = new VertifyInfo();
            vertifyInfo.sLn = parcel.readInt();
            vertifyInfo.sLo = parcel.readInt();
            vertifyInfo.sLp = parcel.readInt();
            vertifyInfo.sLg = parcel.readInt();
            vertifyInfo.mText = parcel.readString();
            vertifyInfo.sKY = parcel.readString();
            vertifyInfo.mFileName = parcel.readString();
            vertifyInfo.sLq = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            vertifyInfo.mcM = z;
            vertifyInfo.sLg = vertifyInfo.sLn;
            AppMethodBeat.m2505o(26108);
            return vertifyInfo;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(26109);
        parcel.writeInt(this.sLn);
        parcel.writeInt(this.sLo);
        parcel.writeInt(this.sLp);
        parcel.writeInt(this.sLg);
        parcel.writeString(C5046bo.m7532bc(this.mText, ""));
        parcel.writeString(C5046bo.m7532bc(this.sKY, ""));
        parcel.writeString(C5046bo.m7532bc(this.mFileName, ""));
        if (this.sLq) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.mcM) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        AppMethodBeat.m2505o(26109);
    }

    static {
        AppMethodBeat.m2504i(26110);
        AppMethodBeat.m2505o(26110);
    }
}
