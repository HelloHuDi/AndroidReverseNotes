package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg */
public class PathClosePathActionArg extends BasePathActionArg {
    public static final Creator<PathClosePathActionArg> CREATOR = new C331231();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg$1 */
    static class C331231 implements Creator<PathClosePathActionArg> {
        C331231() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathClosePathActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103607);
            PathClosePathActionArg pathClosePathActionArg = new PathClosePathActionArg(parcel);
            AppMethodBeat.m2505o(103607);
            return pathClosePathActionArg;
        }
    }

    public PathClosePathActionArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103608);
        super.mo5880j(jSONObject);
        AppMethodBeat.m2505o(103608);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(103609);
        AppMethodBeat.m2505o(103609);
    }
}
