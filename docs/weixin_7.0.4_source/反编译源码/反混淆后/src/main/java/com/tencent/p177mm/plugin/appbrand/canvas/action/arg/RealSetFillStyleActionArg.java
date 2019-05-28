package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg */
public class RealSetFillStyleActionArg extends BaseDrawActionArg {
    public static final Creator<RealSetFillStyleActionArg> CREATOR = new C165871();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg$1 */
    static class C165871 implements Creator<RealSetFillStyleActionArg> {
        C165871() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103360);
            RealSetFillStyleActionArg realSetFillStyleActionArg = new RealSetFillStyleActionArg(parcel);
            AppMethodBeat.m2505o(103360);
            return realSetFillStyleActionArg;
        }
    }

    public RealSetFillStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public void mo30544f(JSONArray jSONArray) {
    }

    static {
        AppMethodBeat.m2504i(103361);
        AppMethodBeat.m2505o(103361);
    }
}
