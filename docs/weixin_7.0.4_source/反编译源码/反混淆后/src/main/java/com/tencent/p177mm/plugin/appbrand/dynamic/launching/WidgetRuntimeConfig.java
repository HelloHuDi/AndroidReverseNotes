package com.tencent.p177mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig */
public class WidgetRuntimeConfig implements Parcelable {
    public static final Creator<WidgetRuntimeConfig> CREATOR = new C21531();
    public String appId;
    public int hog;
    public int hox = 32;
    public boolean hoy = false;
    public boolean hoz = true;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig$1 */
    static class C21531 implements Creator<WidgetRuntimeConfig> {
        C21531() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WidgetRuntimeConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(10929);
            WidgetRuntimeConfig widgetRuntimeConfig = new WidgetRuntimeConfig();
            widgetRuntimeConfig.appId = parcel.readString();
            widgetRuntimeConfig.hog = parcel.readInt();
            widgetRuntimeConfig.hox = parcel.readInt();
            widgetRuntimeConfig.hoy = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            widgetRuntimeConfig.hoz = z;
            AppMethodBeat.m2505o(10929);
            return widgetRuntimeConfig;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(10930);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hog);
        parcel.writeInt(this.hox);
        if (this.hoy) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.hoz) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        AppMethodBeat.m2505o(10930);
    }

    static {
        AppMethodBeat.m2504i(10931);
        AppMethodBeat.m2505o(10931);
    }
}
