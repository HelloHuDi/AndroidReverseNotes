package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg */
public class FillRectActionArg extends BaseDrawActionArg {
    public static final Creator<FillRectActionArg> CREATOR = new C20921();
    public float height;
    public float width;
    /* renamed from: x */
    public float f1241x;
    /* renamed from: y */
    public float f1242y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg$1 */
    static class C20921 implements Creator<FillRectActionArg> {
        C20921() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FillRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103353);
            FillRectActionArg fillRectActionArg = new FillRectActionArg(parcel);
            AppMethodBeat.m2505o(103353);
            return fillRectActionArg;
        }
    }

    public FillRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103354);
        super.mo5879i(parcel);
        this.f1241x = parcel.readFloat();
        this.f1242y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.m2505o(103354);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103355);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f1241x);
        parcel.writeFloat(this.f1242y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.m2505o(103355);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103356);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f1241x = C42668g.m75561d(optJSONArray, 0);
        this.f1242y = C42668g.m75561d(optJSONArray, 1);
        this.width = C42668g.m75561d(optJSONArray, 2);
        this.height = C42668g.m75561d(optJSONArray, 3);
        AppMethodBeat.m2505o(103356);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103357);
        if (this == obj) {
            AppMethodBeat.m2505o(103357);
            return true;
        } else if (!(obj instanceof FillRectActionArg)) {
            AppMethodBeat.m2505o(103357);
            return false;
        } else if (super.equals(obj)) {
            FillRectActionArg fillRectActionArg = (FillRectActionArg) obj;
            if (Float.compare(fillRectActionArg.f1241x, this.f1241x) == 0 && Float.compare(fillRectActionArg.f1242y, this.f1242y) == 0 && Float.compare(fillRectActionArg.width, this.width) == 0 && Float.compare(fillRectActionArg.height, this.height) == 0) {
                AppMethodBeat.m2505o(103357);
                return true;
            }
            AppMethodBeat.m2505o(103357);
            return false;
        } else {
            AppMethodBeat.m2505o(103357);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103358);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.f1241x), Float.valueOf(this.f1242y), Float.valueOf(this.width), Float.valueOf(this.height)});
        AppMethodBeat.m2505o(103358);
        return hash;
    }

    static {
        AppMethodBeat.m2504i(103359);
        AppMethodBeat.m2505o(103359);
    }
}
