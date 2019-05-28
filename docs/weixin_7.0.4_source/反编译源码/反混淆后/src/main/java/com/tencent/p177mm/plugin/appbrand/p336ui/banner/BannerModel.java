package com.tencent.p177mm.plugin.appbrand.p336ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.BannerModel */
final class BannerModel implements Parcelable {
    public static final Creator<BannerModel> CREATOR = new C108331();
    private static volatile BannerModel iKW;
    String appId;
    String appName;
    String haO;
    int har;
    String iKV;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.BannerModel$1 */
    static class C108331 implements Creator<BannerModel> {
        C108331() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BannerModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(133316);
            BannerModel bannerModel = new BannerModel(parcel, (byte) 0);
            AppMethodBeat.m2505o(133316);
            return bannerModel;
        }
    }

    /* synthetic */ BannerModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(133317);
        parcel.writeString(this.appId);
        parcel.writeInt(this.har);
        parcel.writeString(this.appName);
        parcel.writeString(this.haO);
        parcel.writeString(this.iKV);
        AppMethodBeat.m2505o(133317);
    }

    BannerModel() {
    }

    private BannerModel(Parcel parcel) {
        AppMethodBeat.m2504i(133318);
        this.appId = parcel.readString();
        this.har = parcel.readInt();
        this.appName = parcel.readString();
        this.haO = parcel.readString();
        this.iKV = parcel.readString();
        AppMethodBeat.m2505o(133318);
    }

    static {
        AppMethodBeat.m2504i(133320);
        AppMethodBeat.m2505o(133320);
    }

    static BannerModel aMS() {
        BannerModel aMJ;
        AppMethodBeat.m2504i(133319);
        synchronized (BannerModel.class) {
            try {
                aMJ = ((C10834e) C1720g.m3528K(C10834e.class)).aMJ();
                iKW = aMJ;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(133319);
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
