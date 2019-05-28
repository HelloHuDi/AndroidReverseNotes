package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArg */
public abstract class PathActionArg extends BasePathActionArg {
    public float hcR;
    public float hdt;
    public boolean hdu;
    public float radius;
    /* renamed from: x */
    public float f16140x;
    /* renamed from: y */
    public float f16141y;

    public PathActionArg(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f16140x = C42668g.m75561d(optJSONArray, 0);
        this.f16141y = C42668g.m75561d(optJSONArray, 1);
        this.radius = C42668g.m75561d(optJSONArray, 2);
        this.hcR = (float) optJSONArray.optDouble(3);
        this.hdt = (float) optJSONArray.optDouble(4);
        this.hdu = optJSONArray.optBoolean(5);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f16140x);
        parcel.writeFloat(this.f16141y);
        parcel.writeFloat(this.radius);
        parcel.writeFloat(this.hcR);
        parcel.writeFloat(this.hdt);
        parcel.writeInt(this.hdu ? 1 : 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        boolean z = true;
        super.mo5879i(parcel);
        this.f16140x = parcel.readFloat();
        this.f16141y = parcel.readFloat();
        this.radius = parcel.readFloat();
        this.hcR = parcel.readFloat();
        this.hdt = parcel.readFloat();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.hdu = z;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof PathActionArg)) {
            return false;
        }
        PathActionArg pathActionArg = (PathActionArg) obj;
        if (pathActionArg.f16140x == this.f16140x && pathActionArg.f16141y == this.f16141y && pathActionArg.radius == this.radius && pathActionArg.hcR == this.hcR && pathActionArg.hdu == this.hdu) {
            return true;
        }
        return false;
    }
}
