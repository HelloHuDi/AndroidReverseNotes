package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;

public final class LaunchParamsOptional implements Parcelable {
    public static final Creator<LaunchParamsOptional> CREATOR = new Creator<LaunchParamsOptional>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParamsOptional[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101705);
            LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional(parcel, (byte) 0);
            AppMethodBeat.o(101705);
            return launchParamsOptional;
        }
    };
    public String bQh;
    public String bQi;
    public AppBrandWeishiParams bQj;
    public String fpI;

    /* synthetic */ LaunchParamsOptional(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(101706);
        parcel.writeString(this.bQh);
        parcel.writeString(this.bQi);
        parcel.writeParcelable(this.bQj, i);
        AppMethodBeat.o(101706);
    }

    private LaunchParamsOptional(Parcel parcel) {
        AppMethodBeat.i(101707);
        this.bQh = parcel.readString();
        this.bQi = parcel.readString();
        this.bQj = (AppBrandWeishiParams) parcel.readParcelable(AppBrandWeishiParams.class.getClassLoader());
        AppMethodBeat.o(101707);
    }

    static {
        AppMethodBeat.i(101708);
        AppMethodBeat.o(101708);
    }
}
