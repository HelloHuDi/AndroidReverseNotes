package com.tencent.p177mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;

/* renamed from: com.tencent.mm.plugin.mmsight.SightParams */
public class SightParams implements Parcelable {
    public static final Creator<SightParams> CREATOR = new C212841();
    public VideoTransPara fcY;
    public int mode = 0;
    public int osJ = 2;
    public String osK = "";
    public String osL = "";
    public String osM = "";
    public String osN = "";
    public String osO = "";
    public boolean osP = true;
    public boolean osQ = true;
    public String osR = "";
    public int osS;
    public int scene = -1;

    /* renamed from: com.tencent.mm.plugin.mmsight.SightParams$1 */
    static class C212841 implements Creator<SightParams> {
        C212841() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(60277);
            SightParams sightParams = new SightParams(parcel);
            AppMethodBeat.m2505o(60277);
            return sightParams;
        }
    }

    public SightParams(int i, int i2) {
        AppMethodBeat.m2504i(60278);
        if (i == 1) {
            this.fcY = C42204d.afF().afG();
        } else if (i == 2 || i == 3 || i == 4) {
            this.fcY = C42204d.afF().afH();
        } else if (i == 7) {
            this.fcY = C42204d.afF().afK();
        } else {
            this.fcY = C42204d.afF().afH();
        }
        this.scene = i;
        this.mode = i2;
        C1720g.m3537RQ();
        this.osS = ((Integer) C1720g.m3536RP().mo5239Ry().get(344066, Integer.valueOf(0))).intValue();
        AppMethodBeat.m2505o(60278);
    }

    protected SightParams(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(60279);
        this.mode = parcel.readInt();
        this.fcY = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.osK = parcel.readString();
        this.osL = parcel.readString();
        this.osM = parcel.readString();
        this.osN = parcel.readString();
        this.osS = parcel.readInt();
        this.osJ = parcel.readInt();
        this.osP = parcel.readInt() > 0;
        this.scene = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.osQ = z;
        this.osR = parcel.readString();
        AppMethodBeat.m2505o(60279);
    }

    static {
        AppMethodBeat.m2504i(60281);
        AppMethodBeat.m2505o(60281);
    }

    /* renamed from: q */
    public final SightParams mo36644q(String str, String str2, String str3, String str4) {
        this.osM = str;
        this.osK = str2;
        this.osL = str3;
        this.osN = str4;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        AppMethodBeat.m2504i(60280);
        parcel.writeInt(this.mode);
        parcel.writeParcelable(this.fcY, i);
        parcel.writeString(this.osK);
        parcel.writeString(this.osL);
        parcel.writeString(this.osM);
        parcel.writeString(this.osN);
        parcel.writeInt(this.osS);
        parcel.writeInt(this.osJ);
        parcel.writeInt(this.osP ? 1 : 0);
        parcel.writeInt(this.scene);
        if (!this.osQ) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.osR);
        AppMethodBeat.m2505o(60280);
    }
}
