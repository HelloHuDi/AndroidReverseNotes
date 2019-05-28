package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg */
public class PathBezierCurveToActionArg extends BasePathActionArg {
    public static final Creator<PathBezierCurveToActionArg> CREATOR = new C423941();
    /* renamed from: x1 */
    public float f17176x1;
    /* renamed from: x2 */
    public float f17177x2;
    /* renamed from: x3 */
    public float f17178x3;
    /* renamed from: y1 */
    public float f17179y1;
    /* renamed from: y2 */
    public float f17180y2;
    /* renamed from: y3 */
    public float f17181y3;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg$1 */
    static class C423941 implements Creator<PathBezierCurveToActionArg> {
        C423941() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathBezierCurveToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103601);
            PathBezierCurveToActionArg pathBezierCurveToActionArg = new PathBezierCurveToActionArg(parcel);
            AppMethodBeat.m2505o(103601);
            return pathBezierCurveToActionArg;
        }
    }

    public PathBezierCurveToActionArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103602);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f17176x1 = C42668g.m75561d(optJSONArray, 0);
        this.f17179y1 = C42668g.m75561d(optJSONArray, 1);
        this.f17177x2 = C42668g.m75561d(optJSONArray, 2);
        this.f17180y2 = C42668g.m75561d(optJSONArray, 3);
        this.f17178x3 = C42668g.m75561d(optJSONArray, 4);
        this.f17181y3 = C42668g.m75561d(optJSONArray, 5);
        AppMethodBeat.m2505o(103602);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103603);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f17176x1);
        parcel.writeFloat(this.f17179y1);
        parcel.writeFloat(this.f17177x2);
        parcel.writeFloat(this.f17180y2);
        parcel.writeFloat(this.f17177x2);
        parcel.writeFloat(this.f17180y2);
        AppMethodBeat.m2505o(103603);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103604);
        super.mo5879i(parcel);
        this.f17176x1 = parcel.readFloat();
        this.f17179y1 = parcel.readFloat();
        this.f17177x2 = parcel.readFloat();
        this.f17180y2 = parcel.readFloat();
        this.f17178x3 = parcel.readFloat();
        this.f17181y3 = parcel.readFloat();
        AppMethodBeat.m2505o(103604);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103605);
        if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103605);
            return false;
        } else if (obj instanceof PathBezierCurveToActionArg) {
            PathBezierCurveToActionArg pathBezierCurveToActionArg = (PathBezierCurveToActionArg) obj;
            if (pathBezierCurveToActionArg.f17176x1 == this.f17176x1 && pathBezierCurveToActionArg.f17179y1 == this.f17179y1 && pathBezierCurveToActionArg.f17177x2 == this.f17177x2 && pathBezierCurveToActionArg.f17180y2 == this.f17180y2 && pathBezierCurveToActionArg.f17178x3 == this.f17178x3 && pathBezierCurveToActionArg.f17181y3 == this.f17181y3) {
                AppMethodBeat.m2505o(103605);
                return true;
            }
            AppMethodBeat.m2505o(103605);
            return false;
        } else {
            AppMethodBeat.m2505o(103605);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(103606);
        AppMethodBeat.m2505o(103606);
    }
}
