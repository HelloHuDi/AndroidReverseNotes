package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetStrokeStyleActionRadialArg extends RealSetStrokeStyleActionArg {
    public static final Creator<RealSetStrokeStyleActionRadialArg> CREATOR = new Creator<RealSetStrokeStyleActionRadialArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionRadialArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103418);
            RealSetStrokeStyleActionRadialArg realSetStrokeStyleActionRadialArg = new RealSetStrokeStyleActionRadialArg(parcel);
            AppMethodBeat.o(103418);
            return realSetStrokeStyleActionRadialArg;
        }
    };
    public float hcX;
    public float hcY;
    public int[] hdb;
    public float hdd;
    public float[] positions;

    public RealSetStrokeStyleActionRadialArg(Parcel parcel) {
        super(parcel);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103419);
        if (this.hdb == null || this.positions == null) {
            AppMethodBeat.o(103419);
            return false;
        }
        dVar.hcE.setShader(new RadialGradient(this.hcX, this.hcY, this.hdd, this.hdb, this.positions, TileMode.CLAMP));
        AppMethodBeat.o(103419);
        return true;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103420);
        if (this == obj) {
            AppMethodBeat.o(103420);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionRadialArg)) {
            AppMethodBeat.o(103420);
            return false;
        } else if (super.equals(obj)) {
            RealSetStrokeStyleActionRadialArg realSetStrokeStyleActionRadialArg = (RealSetStrokeStyleActionRadialArg) obj;
            if (Float.compare(realSetStrokeStyleActionRadialArg.hcX, this.hcX) == 0 && Float.compare(realSetStrokeStyleActionRadialArg.hcY, this.hcY) == 0 && Float.compare(realSetStrokeStyleActionRadialArg.hdd, this.hdd) == 0 && Arrays.equals(this.hdb, realSetStrokeStyleActionRadialArg.hdb) && Arrays.equals(this.positions, realSetStrokeStyleActionRadialArg.positions)) {
                AppMethodBeat.o(103420);
                return true;
            }
            AppMethodBeat.o(103420);
            return false;
        } else {
            AppMethodBeat.o(103420);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103421);
        int hash = (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY), Float.valueOf(this.hdd)}) * 31) + Arrays.hashCode(this.hdb)) * 31) + Arrays.hashCode(this.positions);
        AppMethodBeat.o(103421);
        return hash;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103422);
        super.i(parcel);
        this.hcX = parcel.readFloat();
        this.hcY = parcel.readFloat();
        this.hdd = parcel.readFloat();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.hdb = new int[readInt];
            parcel.readIntArray(this.hdb);
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.positions = new float[readInt];
            parcel.readFloatArray(this.positions);
        }
        AppMethodBeat.o(103422);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103423);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hcX);
        parcel.writeFloat(this.hcY);
        parcel.writeFloat(this.hdd);
        if (this.hdb != null) {
            parcel.writeInt(this.hdb.length);
            parcel.writeIntArray(this.hdb);
        } else {
            parcel.writeInt(0);
        }
        if (this.positions != null) {
            parcel.writeInt(this.positions.length);
            parcel.writeFloatArray(this.positions);
            AppMethodBeat.o(103423);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(103423);
    }

    public int describeContents() {
        return 0;
    }

    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(103424);
        super.f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.o(103424);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 3) {
            AppMethodBeat.o(103424);
            return;
        }
        this.hcX = g.d(optJSONArray, 1);
        this.hcY = g.d(optJSONArray, 2);
        this.hdd = g.d(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        this.hdb = new int[optJSONArray2.length()];
        this.positions = new float[optJSONArray2.length()];
        for (int i = 0; i < optJSONArray2.length(); i++) {
            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
            if (optJSONArray3.length() >= 2) {
                this.positions[i] = (float) optJSONArray3.optDouble(0);
                this.hdb[i] = g.n(optJSONArray3.optJSONArray(1));
            }
        }
        AppMethodBeat.o(103424);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103425);
        super.j(jSONObject);
        AppMethodBeat.o(103425);
    }

    static {
        AppMethodBeat.i(103426);
        AppMethodBeat.o(103426);
    }
}
