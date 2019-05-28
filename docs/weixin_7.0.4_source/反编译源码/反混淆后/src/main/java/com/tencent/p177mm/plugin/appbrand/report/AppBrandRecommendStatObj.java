package com.tencent.p177mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj */
public class AppBrandRecommendStatObj implements Parcelable {
    public static final Creator<AppBrandRecommendStatObj> CREATOR = new C107111();
    public float cEB;
    public float cGm;
    public String csB;
    public long hbj;
    public String iAa;
    public String iAb;
    public String iAc;
    public int iAd;
    public String iAe;
    public String izZ;
    public int position;
    public String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj$1 */
    static class C107111 implements Creator<AppBrandRecommendStatObj> {
        C107111() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandRecommendStatObj[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(96179);
            AppBrandRecommendStatObj appBrandRecommendStatObj = new AppBrandRecommendStatObj(parcel);
            AppMethodBeat.m2505o(96179);
            return appBrandRecommendStatObj;
        }
    }

    public AppBrandRecommendStatObj(Parcel parcel) {
        AppMethodBeat.m2504i(96180);
        this.username = parcel.readString();
        this.izZ = parcel.readString();
        this.iAa = parcel.readString();
        this.csB = parcel.readString();
        this.iAb = parcel.readString();
        this.iAc = parcel.readString();
        this.iAd = parcel.readInt();
        this.iAe = parcel.readString();
        this.position = parcel.readInt();
        this.cGm = parcel.readFloat();
        this.cEB = parcel.readFloat();
        this.hbj = parcel.readLong();
        AppMethodBeat.m2505o(96180);
    }

    public String toString() {
        AppMethodBeat.m2504i(96181);
        String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.izZ + '\'' + ", strategy_info=" + this.iAa + ", appid='" + this.csB + '\'' + ", page_path=" + this.iAb + ", page_param=" + this.iAc + ", card_type=" + this.iAd + ", pass_str=" + this.iAe + ", position=" + this.position + ", longitude=" + this.cGm + ", latitude=" + this.cEB + ", sessionId=" + this.hbj + '}';
        AppMethodBeat.m2505o(96181);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(96182);
        parcel.writeString(this.username);
        parcel.writeString(this.izZ);
        parcel.writeString(this.iAa);
        parcel.writeString(this.csB);
        parcel.writeString(this.iAb);
        parcel.writeString(this.iAc);
        parcel.writeInt(this.iAd);
        parcel.writeString(this.iAe);
        parcel.writeInt(this.position);
        parcel.writeFloat(this.cGm);
        parcel.writeFloat(this.cEB);
        parcel.writeLong(this.hbj);
        AppMethodBeat.m2505o(96182);
    }

    static {
        AppMethodBeat.m2504i(96183);
        AppMethodBeat.m2505o(96183);
    }
}
