package com.tencent.p177mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.launching.params.AppBrandWeishiParams;

/* renamed from: com.tencent.mm.modelappbrand.LaunchParamsOptional */
public final class LaunchParamsOptional implements Parcelable {
    public static final Creator<LaunchParamsOptional> CREATOR = new C186441();
    public String bQh;
    public String bQi;
    public AppBrandWeishiParams bQj;
    public String fpI;

    /* renamed from: com.tencent.mm.modelappbrand.LaunchParamsOptional$1 */
    static class C186441 implements Creator<LaunchParamsOptional> {
        C186441() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParamsOptional[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(101705);
            LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional(parcel, (byte) 0);
            AppMethodBeat.m2505o(101705);
            return launchParamsOptional;
        }
    }

    /* synthetic */ LaunchParamsOptional(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(101706);
        parcel.writeString(this.bQh);
        parcel.writeString(this.bQi);
        parcel.writeParcelable(this.bQj, i);
        AppMethodBeat.m2505o(101706);
    }

    private LaunchParamsOptional(Parcel parcel) {
        AppMethodBeat.m2504i(101707);
        this.bQh = parcel.readString();
        this.bQi = parcel.readString();
        this.bQj = (AppBrandWeishiParams) parcel.readParcelable(AppBrandWeishiParams.class.getClassLoader());
        AppMethodBeat.m2505o(101707);
    }

    static {
        AppMethodBeat.m2504i(101708);
        AppMethodBeat.m2505o(101708);
    }
}
