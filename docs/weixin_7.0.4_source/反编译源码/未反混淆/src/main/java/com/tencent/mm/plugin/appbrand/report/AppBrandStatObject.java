package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandStatObject implements Parcelable {
    public static final Creator<AppBrandStatObject> CREATOR = new Creator<AppBrandStatObject>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandStatObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96184);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject(parcel);
            AppMethodBeat.o(96184);
            return appBrandStatObject;
        }
    };
    public int cOo;
    public int cOq;
    public String cOr;
    public String cst;
    public String hQF;
    public int iAo;
    public AppBrandRecommendStatObj iAp;
    public int scene;

    public final String toString() {
        AppMethodBeat.i(96185);
        String str = "AppBrandStatObject{preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", usedState=" + this.iAo + '}';
        AppMethodBeat.o(96185);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96186);
        parcel.writeInt(this.cOq);
        parcel.writeString(this.cOr);
        parcel.writeInt(this.scene);
        parcel.writeString(this.cst);
        parcel.writeInt(this.iAo);
        parcel.writeInt(this.cOo);
        parcel.writeString(this.hQF);
        parcel.writeParcelable(this.iAp, i);
        AppMethodBeat.o(96186);
    }

    protected AppBrandStatObject(Parcel parcel) {
        AppMethodBeat.i(96187);
        this.cOq = parcel.readInt();
        this.cOr = parcel.readString();
        this.scene = parcel.readInt();
        this.cst = parcel.readString();
        this.iAo = parcel.readInt();
        this.cOo = parcel.readInt();
        this.hQF = parcel.readString();
        this.iAp = (AppBrandRecommendStatObj) parcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader());
        AppMethodBeat.o(96187);
    }

    static {
        AppMethodBeat.i(96188);
        AppMethodBeat.o(96188);
    }
}
