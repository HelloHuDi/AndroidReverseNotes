package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg */
public class DrawArcActionArg extends BaseDrawActionArg {
    public static final Creator<DrawArcActionArg> CREATOR = new C331171();
    public float hcR;
    public float hcS;
    public float radius;
    /* renamed from: x */
    public float f15027x;
    /* renamed from: y */
    public float f15028y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg$1 */
    static class C331171 implements Creator<DrawArcActionArg> {
        C331171() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawArcActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103325);
            DrawArcActionArg drawArcActionArg = new DrawArcActionArg(parcel);
            AppMethodBeat.m2505o(103325);
            return drawArcActionArg;
        }
    }

    public DrawArcActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103326);
        super.mo5879i(parcel);
        this.f15027x = parcel.readFloat();
        this.f15028y = parcel.readFloat();
        this.radius = parcel.readFloat();
        this.hcR = parcel.readFloat();
        this.hcS = parcel.readFloat();
        AppMethodBeat.m2505o(103326);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103327);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f15027x = C42668g.m75561d(optJSONArray, 0);
        this.f15028y = C42668g.m75561d(optJSONArray, 1);
        this.radius = C42668g.m75561d(optJSONArray, 2);
        this.hcR = (float) optJSONArray.optDouble(3);
        this.hcS = (float) optJSONArray.optDouble(4);
        AppMethodBeat.m2505o(103327);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103328);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f15027x);
        parcel.writeFloat(this.f15028y);
        parcel.writeFloat(this.radius);
        parcel.writeFloat(this.hcR);
        parcel.writeFloat(this.hcS);
        AppMethodBeat.m2505o(103328);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103329);
        if (this == obj) {
            AppMethodBeat.m2505o(103329);
            return true;
        } else if (!(obj instanceof DrawArcActionArg)) {
            AppMethodBeat.m2505o(103329);
            return false;
        } else if (super.equals(obj)) {
            DrawArcActionArg drawArcActionArg = (DrawArcActionArg) obj;
            if (Float.compare(drawArcActionArg.f15027x, this.f15027x) == 0 && Float.compare(drawArcActionArg.f15028y, this.f15028y) == 0 && Float.compare(drawArcActionArg.radius, this.radius) == 0 && Float.compare(drawArcActionArg.hcR, this.hcR) == 0 && Float.compare(drawArcActionArg.hcS, this.hcS) == 0) {
                AppMethodBeat.m2505o(103329);
                return true;
            }
            AppMethodBeat.m2505o(103329);
            return false;
        } else {
            AppMethodBeat.m2505o(103329);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103330);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.f15027x), Float.valueOf(this.f15028y), Float.valueOf(this.radius), Float.valueOf(this.hcR), Float.valueOf(this.hcS)});
        AppMethodBeat.m2505o(103330);
        return hash;
    }

    static {
        AppMethodBeat.m2504i(103331);
        AppMethodBeat.m2505o(103331);
    }
}
