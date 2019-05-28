package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ModulePkgInfo implements Parcelable, Cloneable {
    public static final Creator<ModulePkgInfo> CREATOR = new Creator<ModulePkgInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ModulePkgInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105306);
            ModulePkgInfo modulePkgInfo = new ModulePkgInfo(parcel, (byte) 0);
            AppMethodBeat.o(105306);
            return modulePkgInfo;
        }
    };
    public boolean cta;
    public String cvZ;
    public volatile String gSP;
    public String[] gSQ;
    public PartialFile[] gSR;
    public String name;

    /* synthetic */ ModulePkgInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        AppMethodBeat.i(105307);
        parcel.writeString(this.gSP);
        parcel.writeString(this.name);
        parcel.writeString(this.cvZ);
        if (this.cta) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeStringArray(this.gSQ);
        parcel.writeTypedArray(this.gSR, 0);
        AppMethodBeat.o(105307);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(105308);
        this.gSP = parcel.readString();
        this.name = parcel.readString();
        this.cvZ = parcel.readString();
        this.cta = parcel.readByte() != (byte) 0;
        this.gSQ = parcel.createStringArray();
        this.gSR = (PartialFile[]) parcel.createTypedArray(PartialFile.CREATOR);
        AppMethodBeat.o(105308);
    }

    private ModulePkgInfo(Parcel parcel) {
        AppMethodBeat.i(105309);
        readFromParcel(parcel);
        AppMethodBeat.o(105309);
    }

    static {
        AppMethodBeat.i(105311);
        AppMethodBeat.o(105311);
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(105310);
        ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        modulePkgInfo.readFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(105310);
        return modulePkgInfo;
    }
}
