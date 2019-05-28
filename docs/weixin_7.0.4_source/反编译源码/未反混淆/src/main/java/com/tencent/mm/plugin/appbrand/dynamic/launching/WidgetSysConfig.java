package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WidgetSysConfig implements Parcelable {
    public static final Creator<WidgetSysConfig> CREATOR = new Creator<WidgetSysConfig>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WidgetSysConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(10932);
            WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
            widgetSysConfig.hfU = parcel.readInt();
            widgetSysConfig.hfV = parcel.readInt();
            widgetSysConfig.hfW = parcel.readInt();
            AppMethodBeat.o(10932);
            return widgetSysConfig;
        }
    };
    public int hfU;
    public int hfV;
    public int hfW;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(10933);
        parcel.writeInt(this.hfU);
        parcel.writeInt(this.hfV);
        parcel.writeInt(this.hfW);
        AppMethodBeat.o(10933);
    }

    static {
        AppMethodBeat.i(10934);
        AppMethodBeat.o(10934);
    }
}
