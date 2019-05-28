package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg */
public class DefaultDrawActionArg extends BaseDrawActionArg {
    public static final Creator<DefaultDrawActionArg> CREATOR = new C268041();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg$1 */
    static class C268041 implements Creator<DefaultDrawActionArg> {
        C268041() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DefaultDrawActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103316);
            DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg(parcel);
            AppMethodBeat.m2505o(103316);
            return defaultDrawActionArg;
        }
    }

    public DefaultDrawActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(103317);
        AppMethodBeat.m2505o(103317);
    }
}
