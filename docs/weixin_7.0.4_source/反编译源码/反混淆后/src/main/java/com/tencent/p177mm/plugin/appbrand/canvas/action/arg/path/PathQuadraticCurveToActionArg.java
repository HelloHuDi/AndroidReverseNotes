package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg */
public class PathQuadraticCurveToActionArg extends BasePathActionArg {
    public static final Creator<PathQuadraticCurveToActionArg> CREATOR = new C21001();
    /* renamed from: x1 */
    public float f16144x1;
    /* renamed from: x2 */
    public float f16145x2;
    /* renamed from: y1 */
    public float f16146y1;
    /* renamed from: y2 */
    public float f16147y2;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg$1 */
    static class C21001 implements Creator<PathQuadraticCurveToActionArg> {
        C21001() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathQuadraticCurveToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103622);
            PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = new PathQuadraticCurveToActionArg(parcel);
            AppMethodBeat.m2505o(103622);
            return pathQuadraticCurveToActionArg;
        }
    }

    public PathQuadraticCurveToActionArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103623);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f16144x1 = C42668g.m75561d(optJSONArray, 0);
        this.f16146y1 = C42668g.m75561d(optJSONArray, 1);
        this.f16145x2 = C42668g.m75561d(optJSONArray, 2);
        this.f16147y2 = C42668g.m75561d(optJSONArray, 3);
        AppMethodBeat.m2505o(103623);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103624);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f16144x1);
        parcel.writeFloat(this.f16146y1);
        parcel.writeFloat(this.f16145x2);
        parcel.writeFloat(this.f16147y2);
        AppMethodBeat.m2505o(103624);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103625);
        super.mo5879i(parcel);
        this.f16144x1 = parcel.readFloat();
        this.f16146y1 = parcel.readFloat();
        this.f16145x2 = parcel.readFloat();
        this.f16147y2 = parcel.readFloat();
        AppMethodBeat.m2505o(103625);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103626);
        if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103626);
            return false;
        } else if (obj instanceof PathQuadraticCurveToActionArg) {
            PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg) obj;
            if (pathQuadraticCurveToActionArg.f16144x1 == this.f16144x1 && pathQuadraticCurveToActionArg.f16146y1 == this.f16146y1 && pathQuadraticCurveToActionArg.f16145x2 == this.f16145x2 && pathQuadraticCurveToActionArg.f16147y2 == this.f16147y2) {
                AppMethodBeat.m2505o(103626);
                return true;
            }
            AppMethodBeat.m2505o(103626);
            return false;
        } else {
            AppMethodBeat.m2505o(103626);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(103627);
        AppMethodBeat.m2505o(103627);
    }
}
