package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg */
public class PathRectActionArg extends BasePathActionArg {
    public static final Creator<PathRectActionArg> CREATOR = new C268151();
    public float height;
    public float width;
    /* renamed from: x */
    public float f13671x;
    /* renamed from: y */
    public float f13672y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg$1 */
    static class C268151 implements Creator<PathRectActionArg> {
        C268151() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103628);
            PathRectActionArg pathRectActionArg = new PathRectActionArg(parcel);
            AppMethodBeat.m2505o(103628);
            return pathRectActionArg;
        }
    }

    public PathRectActionArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103629);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f13671x = C42668g.m75561d(optJSONArray, 0);
        this.f13672y = C42668g.m75561d(optJSONArray, 1);
        this.width = C42668g.m75561d(optJSONArray, 2);
        this.height = C42668g.m75561d(optJSONArray, 3);
        AppMethodBeat.m2505o(103629);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103630);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f13671x);
        parcel.writeFloat(this.f13672y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.m2505o(103630);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103631);
        super.mo5879i(parcel);
        this.f13671x = parcel.readFloat();
        this.f13672y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.m2505o(103631);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103632);
        if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103632);
            return false;
        } else if (obj instanceof PathRectActionArg) {
            PathRectActionArg pathRectActionArg = (PathRectActionArg) obj;
            if (pathRectActionArg.f13671x == this.f13671x && pathRectActionArg.f13672y == this.f13672y && pathRectActionArg.width == this.width && pathRectActionArg.height == this.height) {
                AppMethodBeat.m2505o(103632);
                return true;
            }
            AppMethodBeat.m2505o(103632);
            return false;
        } else {
            AppMethodBeat.m2505o(103632);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(103633);
        AppMethodBeat.m2505o(103633);
    }
}
