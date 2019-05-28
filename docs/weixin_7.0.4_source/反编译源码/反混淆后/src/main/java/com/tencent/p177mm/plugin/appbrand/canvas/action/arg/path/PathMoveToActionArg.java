package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg */
public class PathMoveToActionArg extends BasePathActionArg {
    public static final Creator<PathMoveToActionArg> CREATOR = new C101541();
    /* renamed from: x */
    public float f3603x;
    /* renamed from: y */
    public float f3604y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg$1 */
    static class C101541 implements Creator<PathMoveToActionArg> {
        C101541() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathMoveToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103616);
            PathMoveToActionArg pathMoveToActionArg = new PathMoveToActionArg(parcel);
            AppMethodBeat.m2505o(103616);
            return pathMoveToActionArg;
        }
    }

    public PathMoveToActionArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103617);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f3603x = C42668g.m75561d(optJSONArray, 0);
        this.f3604y = C42668g.m75561d(optJSONArray, 1);
        AppMethodBeat.m2505o(103617);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103618);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f3603x);
        parcel.writeFloat(this.f3604y);
        AppMethodBeat.m2505o(103618);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103619);
        super.mo5879i(parcel);
        this.f3603x = parcel.readFloat();
        this.f3604y = parcel.readFloat();
        AppMethodBeat.m2505o(103619);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103620);
        if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103620);
            return false;
        } else if (obj instanceof PathMoveToActionArg) {
            PathMoveToActionArg pathMoveToActionArg = (PathMoveToActionArg) obj;
            if (pathMoveToActionArg.f3603x == this.f3603x && pathMoveToActionArg.f3604y == this.f3604y) {
                AppMethodBeat.m2505o(103620);
                return true;
            }
            AppMethodBeat.m2505o(103620);
            return false;
        } else {
            AppMethodBeat.m2505o(103620);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(103621);
        AppMethodBeat.m2505o(103621);
    }
}
