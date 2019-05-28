package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PathActionArg extends BasePathActionArg {
    public float hcR;
    public float hdt;
    public boolean hdu;
    public float radius;
    public float x;
    public float y;

    public PathActionArg(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public final void j(JSONObject jSONObject) {
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        this.radius = g.d(optJSONArray, 2);
        this.hcR = (float) optJSONArray.optDouble(3);
        this.hdt = (float) optJSONArray.optDouble(4);
        this.hdu = optJSONArray.optBoolean(5);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.radius);
        parcel.writeFloat(this.hcR);
        parcel.writeFloat(this.hdt);
        parcel.writeInt(this.hdu ? 1 : 0);
    }

    public final void i(Parcel parcel) {
        boolean z = true;
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
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
        if (pathActionArg.x == this.x && pathActionArg.y == this.y && pathActionArg.radius == this.radius && pathActionArg.hcR == this.hcR && pathActionArg.hdu == this.hdu) {
            return true;
        }
        return false;
    }
}
