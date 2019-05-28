package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg */
public class PathLineToActionArg extends BasePathActionArg {
    public static final Creator<PathLineToActionArg> CREATOR = new C381451();
    /* renamed from: x */
    public float f16142x;
    /* renamed from: y */
    public float f16143y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg$1 */
    static class C381451 implements Creator<PathLineToActionArg> {
        C381451() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathLineToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103610);
            PathLineToActionArg pathLineToActionArg = new PathLineToActionArg(parcel);
            AppMethodBeat.m2505o(103610);
            return pathLineToActionArg;
        }
    }

    public PathLineToActionArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103611);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f16142x = C42668g.m75561d(optJSONArray, 0);
        this.f16143y = C42668g.m75561d(optJSONArray, 1);
        AppMethodBeat.m2505o(103611);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103612);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f16142x);
        parcel.writeFloat(this.f16143y);
        AppMethodBeat.m2505o(103612);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103613);
        super.mo5879i(parcel);
        this.f16142x = parcel.readFloat();
        this.f16143y = parcel.readFloat();
        AppMethodBeat.m2505o(103613);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103614);
        if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103614);
            return false;
        } else if (obj instanceof PathLineToActionArg) {
            PathLineToActionArg pathLineToActionArg = (PathLineToActionArg) obj;
            if (pathLineToActionArg.f16142x == this.f16142x && pathLineToActionArg.f16143y == this.f16143y) {
                AppMethodBeat.m2505o(103614);
                return true;
            }
            AppMethodBeat.m2505o(103614);
            return false;
        } else {
            AppMethodBeat.m2505o(103614);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(103615);
        AppMethodBeat.m2505o(103615);
    }
}
