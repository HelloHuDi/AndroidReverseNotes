package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg */
public class RealSetStrokeStyleActionArg extends BaseDrawActionArg {
    public static final Creator<RealSetStrokeStyleActionArg> CREATOR = new C191411();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg$1 */
    static class C191411 implements Creator<RealSetStrokeStyleActionArg> {
        C191411() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103398);
            RealSetStrokeStyleActionArg realSetStrokeStyleActionArg = new RealSetStrokeStyleActionArg(parcel);
            AppMethodBeat.m2505o(103398);
            return realSetStrokeStyleActionArg;
        }
    }

    public RealSetStrokeStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public void mo34358f(JSONArray jSONArray) {
    }

    static {
        AppMethodBeat.m2504i(103399);
        AppMethodBeat.m2505o(103399);
    }
}
