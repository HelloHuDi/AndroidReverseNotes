package com.tencent.p177mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;

/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.QualitySession */
public class QualitySession implements Parcelable {
    public static final Creator<QualitySession> CREATOR = new C107231();
    public String appId;
    public int apptype;
    public int iCZ;
    public int iDa;
    public final String igT;
    public int scene;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.quality.QualitySession$1 */
    static class C107231 implements Creator<QualitySession> {
        C107231() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QualitySession[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(132703);
            QualitySession qualitySession = new QualitySession(parcel);
            AppMethodBeat.m2505o(132703);
            return qualitySession;
        }
    }

    public QualitySession(String str, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(132704);
        this.igT = str;
        this.appId = appBrandInitConfigWC.appId;
        switch (appBrandInitConfigWC.gVs) {
            case 0:
                this.iCZ = 1;
                break;
            case 1:
                this.iCZ = 2;
                break;
            case 2:
                this.iCZ = 3;
                break;
        }
        this.apptype = appBrandInitConfigWC.bQe + 1000;
        this.scene = appBrandStatObject.scene;
        this.iDa = appBrandInitConfigWC.axy;
        AppMethodBeat.m2505o(132704);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(132705);
        parcel.writeString(this.igT);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iCZ);
        parcel.writeInt(this.apptype);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.iDa);
        AppMethodBeat.m2505o(132705);
    }

    protected QualitySession(Parcel parcel) {
        AppMethodBeat.m2504i(132706);
        this.igT = parcel.readString();
        this.appId = parcel.readString();
        this.iCZ = parcel.readInt();
        this.apptype = parcel.readInt();
        this.scene = parcel.readInt();
        this.iDa = parcel.readInt();
        AppMethodBeat.m2505o(132706);
    }

    static {
        AppMethodBeat.m2504i(132707);
        AppMethodBeat.m2505o(132707);
    }
}
