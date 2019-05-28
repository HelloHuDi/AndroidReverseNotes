package com.tencent.p177mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig */
public class WidgetSysConfig implements Parcelable {
    public static final Creator<WidgetSysConfig> CREATOR = new C382061();
    public int hfU;
    public int hfV;
    public int hfW;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig$1 */
    static class C382061 implements Creator<WidgetSysConfig> {
        C382061() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WidgetSysConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(10932);
            WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
            widgetSysConfig.hfU = parcel.readInt();
            widgetSysConfig.hfV = parcel.readInt();
            widgetSysConfig.hfW = parcel.readInt();
            AppMethodBeat.m2505o(10932);
            return widgetSysConfig;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(10933);
        parcel.writeInt(this.hfU);
        parcel.writeInt(this.hfV);
        parcel.writeInt(this.hfW);
        AppMethodBeat.m2505o(10933);
    }

    static {
        AppMethodBeat.m2504i(10934);
        AppMethodBeat.m2505o(10934);
    }
}
