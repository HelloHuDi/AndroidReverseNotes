package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg */
public class BasePathActionArg extends BaseDrawActionArg {
    public static final Creator<BasePathActionArg> CREATOR = new C165901();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg$1 */
    static class C165901 implements Creator<BasePathActionArg> {
        C165901() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BasePathActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103585);
            BasePathActionArg basePathActionArg = new BasePathActionArg(parcel);
            AppMethodBeat.m2505o(103585);
            return basePathActionArg;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103586);
        super.writeToParcel(parcel, i);
        AppMethodBeat.m2505o(103586);
    }

    protected BasePathActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    static {
        AppMethodBeat.m2504i(103587);
        AppMethodBeat.m2505o(103587);
    }
}
