package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawArcActionArg extends BaseDrawActionArg {
    public static final Creator<DrawArcActionArg> CREATOR = new Creator<DrawArcActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawArcActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103325);
            DrawArcActionArg drawArcActionArg = new DrawArcActionArg(parcel);
            AppMethodBeat.o(103325);
            return drawArcActionArg;
        }
    };
    public float hcR;
    public float hcS;
    public float radius;
    public float x;
    public float y;

    public DrawArcActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103326);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.radius = parcel.readFloat();
        this.hcR = parcel.readFloat();
        this.hcS = parcel.readFloat();
        AppMethodBeat.o(103326);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103327);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        this.radius = g.d(optJSONArray, 2);
        this.hcR = (float) optJSONArray.optDouble(3);
        this.hcS = (float) optJSONArray.optDouble(4);
        AppMethodBeat.o(103327);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103328);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.radius);
        parcel.writeFloat(this.hcR);
        parcel.writeFloat(this.hcS);
        AppMethodBeat.o(103328);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103329);
        if (this == obj) {
            AppMethodBeat.o(103329);
            return true;
        } else if (!(obj instanceof DrawArcActionArg)) {
            AppMethodBeat.o(103329);
            return false;
        } else if (super.equals(obj)) {
            DrawArcActionArg drawArcActionArg = (DrawArcActionArg) obj;
            if (Float.compare(drawArcActionArg.x, this.x) == 0 && Float.compare(drawArcActionArg.y, this.y) == 0 && Float.compare(drawArcActionArg.radius, this.radius) == 0 && Float.compare(drawArcActionArg.hcR, this.hcR) == 0 && Float.compare(drawArcActionArg.hcS, this.hcS) == 0) {
                AppMethodBeat.o(103329);
                return true;
            }
            AppMethodBeat.o(103329);
            return false;
        } else {
            AppMethodBeat.o(103329);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103330);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.radius), Float.valueOf(this.hcR), Float.valueOf(this.hcS)});
        AppMethodBeat.o(103330);
        return hash;
    }

    static {
        AppMethodBeat.i(103331);
        AppMethodBeat.o(103331);
    }
}
