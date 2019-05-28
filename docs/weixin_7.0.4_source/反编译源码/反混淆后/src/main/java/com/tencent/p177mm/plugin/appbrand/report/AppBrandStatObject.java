package com.tencent.p177mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandStatObject */
public final class AppBrandStatObject implements Parcelable {
    public static final Creator<AppBrandStatObject> CREATOR = new C107121();
    public int cOo;
    public int cOq;
    public String cOr;
    public String cst;
    public String hQF;
    public int iAo;
    public AppBrandRecommendStatObj iAp;
    public int scene;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandStatObject$1 */
    static class C107121 implements Creator<AppBrandStatObject> {
        C107121() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandStatObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(96184);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject(parcel);
            AppMethodBeat.m2505o(96184);
            return appBrandStatObject;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(96185);
        String str = "AppBrandStatObject{preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", usedState=" + this.iAo + '}';
        AppMethodBeat.m2505o(96185);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(96186);
        parcel.writeInt(this.cOq);
        parcel.writeString(this.cOr);
        parcel.writeInt(this.scene);
        parcel.writeString(this.cst);
        parcel.writeInt(this.iAo);
        parcel.writeInt(this.cOo);
        parcel.writeString(this.hQF);
        parcel.writeParcelable(this.iAp, i);
        AppMethodBeat.m2505o(96186);
    }

    protected AppBrandStatObject(Parcel parcel) {
        AppMethodBeat.m2504i(96187);
        this.cOq = parcel.readInt();
        this.cOr = parcel.readString();
        this.scene = parcel.readInt();
        this.cst = parcel.readString();
        this.iAo = parcel.readInt();
        this.cOo = parcel.readInt();
        this.hQF = parcel.readString();
        this.iAp = (AppBrandRecommendStatObj) parcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader());
        AppMethodBeat.m2505o(96187);
    }

    static {
        AppMethodBeat.m2504i(96188);
        AppMethodBeat.m2505o(96188);
    }
}
