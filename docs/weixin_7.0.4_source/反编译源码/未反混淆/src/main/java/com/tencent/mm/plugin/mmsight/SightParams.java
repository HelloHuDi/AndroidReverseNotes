package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;

public class SightParams implements Parcelable {
    public static final Creator<SightParams> CREATOR = new Creator<SightParams>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(60277);
            SightParams sightParams = new SightParams(parcel);
            AppMethodBeat.o(60277);
            return sightParams;
        }
    };
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

    public SightParams(int i, int i2) {
        AppMethodBeat.i(60278);
        if (i == 1) {
            this.fcY = d.afF().afG();
        } else if (i == 2 || i == 3 || i == 4) {
            this.fcY = d.afF().afH();
        } else if (i == 7) {
            this.fcY = d.afF().afK();
        } else {
            this.fcY = d.afF().afH();
        }
        this.scene = i;
        this.mode = i2;
        g.RQ();
        this.osS = ((Integer) g.RP().Ry().get(344066, Integer.valueOf(0))).intValue();
        AppMethodBeat.o(60278);
    }

    protected SightParams(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(60279);
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
        AppMethodBeat.o(60279);
    }

    static {
        AppMethodBeat.i(60281);
        AppMethodBeat.o(60281);
    }

    public final SightParams q(String str, String str2, String str3, String str4) {
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
        AppMethodBeat.i(60280);
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
        AppMethodBeat.o(60280);
    }
}
