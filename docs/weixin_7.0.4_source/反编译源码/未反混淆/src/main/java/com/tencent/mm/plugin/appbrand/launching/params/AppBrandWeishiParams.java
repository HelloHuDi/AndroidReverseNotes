package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandWeishiParams implements Parcelable {
    public static final Creator<AppBrandWeishiParams> CREATOR = new Creator<AppBrandWeishiParams>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandWeishiParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102112);
            AppBrandWeishiParams appBrandWeishiParams = new AppBrandWeishiParams(parcel);
            AppMethodBeat.o(102112);
            return appBrandWeishiParams;
        }
    };
    public String appId;
    public String appName;
    public int ffp;
    public String ijv;
    public String ijw;
    public String ijx;
    public String thumbUrl;

    public String toString() {
        AppMethodBeat.i(102113);
        String str = "AppBrandWeishiParams{fromOpenSdk=" + this.ffp + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbFullPath='" + this.ijv + '\'' + ", msgImgPath='" + this.ijw + '\'' + ", appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", sourceUserName='" + this.ijx + '\'' + '}';
        AppMethodBeat.o(102113);
        return str;
    }

    public AppBrandWeishiParams(Parcel parcel) {
        AppMethodBeat.i(102114);
        j(parcel);
        AppMethodBeat.o(102114);
    }

    private void j(Parcel parcel) {
        AppMethodBeat.i(102115);
        this.ffp = parcel.readInt();
        this.thumbUrl = parcel.readString();
        this.ijv = parcel.readString();
        this.ijw = parcel.readString();
        this.appId = parcel.readString();
        this.appName = parcel.readString();
        this.ijx = parcel.readString();
        AppMethodBeat.o(102115);
    }

    public final void a(AppBrandWeishiParams appBrandWeishiParams) {
        AppMethodBeat.i(102116);
        if (appBrandWeishiParams == null) {
            AppMethodBeat.o(102116);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        appBrandWeishiParams.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        j(obtain);
        obtain.recycle();
        AppMethodBeat.o(102116);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102117);
        parcel.writeInt(this.ffp);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.ijv);
        parcel.writeString(this.ijw);
        parcel.writeString(this.appId);
        parcel.writeString(this.appName);
        parcel.writeString(this.ijx);
        AppMethodBeat.o(102117);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(102118);
        AppMethodBeat.o(102118);
    }
}
