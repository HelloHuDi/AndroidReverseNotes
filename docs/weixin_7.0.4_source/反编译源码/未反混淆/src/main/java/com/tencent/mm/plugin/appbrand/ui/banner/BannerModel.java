package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class BannerModel implements Parcelable {
    public static final Creator<BannerModel> CREATOR = new Creator<BannerModel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BannerModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(133316);
            BannerModel bannerModel = new BannerModel(parcel, (byte) 0);
            AppMethodBeat.o(133316);
            return bannerModel;
        }
    };
    private static volatile BannerModel iKW;
    String appId;
    String appName;
    String haO;
    int har;
    String iKV;

    /* synthetic */ BannerModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(133317);
        parcel.writeString(this.appId);
        parcel.writeInt(this.har);
        parcel.writeString(this.appName);
        parcel.writeString(this.haO);
        parcel.writeString(this.iKV);
        AppMethodBeat.o(133317);
    }

    BannerModel() {
    }

    private BannerModel(Parcel parcel) {
        AppMethodBeat.i(133318);
        this.appId = parcel.readString();
        this.har = parcel.readInt();
        this.appName = parcel.readString();
        this.haO = parcel.readString();
        this.iKV = parcel.readString();
        AppMethodBeat.o(133318);
    }

    static {
        AppMethodBeat.i(133320);
        AppMethodBeat.o(133320);
    }

    static BannerModel aMS() {
        BannerModel aMJ;
        AppMethodBeat.i(133319);
        synchronized (BannerModel.class) {
            try {
                aMJ = ((e) g.K(e.class)).aMJ();
                iKW = aMJ;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(133319);
            }
        }
        return aMJ;
    }

    static BannerModel aMT() {
        BannerModel bannerModel;
        synchronized (BannerModel.class) {
            bannerModel = iKW;
        }
        return bannerModel;
    }
}
