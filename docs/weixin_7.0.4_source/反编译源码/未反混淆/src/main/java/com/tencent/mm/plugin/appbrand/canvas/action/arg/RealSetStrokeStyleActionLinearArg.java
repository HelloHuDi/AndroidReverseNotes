package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

public class RealSetStrokeStyleActionLinearArg extends RealSetStrokeStyleActionArg {
    public static final Creator<RealSetStrokeStyleActionLinearArg> CREATOR = new Creator<RealSetStrokeStyleActionLinearArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionLinearArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103400);
            RealSetStrokeStyleActionLinearArg realSetStrokeStyleActionLinearArg = new RealSetStrokeStyleActionLinearArg(parcel);
            AppMethodBeat.o(103400);
            return realSetStrokeStyleActionLinearArg;
        }
    };
    public float hcX;
    public float hcY;
    public float hcZ;
    public float hda;
    public int[] hdb;
    public float[] positions;

    public RealSetStrokeStyleActionLinearArg(Parcel parcel) {
        super(parcel);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103401);
        if (this.hdb == null || this.positions == null) {
            AppMethodBeat.o(103401);
            return false;
        }
        dVar.hcE.setShader(new LinearGradient(this.hcX, this.hcY, this.hcZ, this.hda, this.hdb, this.positions, TileMode.CLAMP));
        AppMethodBeat.o(103401);
        return true;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103402);
        if (this == obj) {
            AppMethodBeat.o(103402);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionLinearArg)) {
            AppMethodBeat.o(103402);
            return false;
        } else if (super.equals(obj)) {
            RealSetStrokeStyleActionLinearArg realSetStrokeStyleActionLinearArg = (RealSetStrokeStyleActionLinearArg) obj;
            if (Float.compare(realSetStrokeStyleActionLinearArg.hcX, this.hcX) == 0 && Float.compare(realSetStrokeStyleActionLinearArg.hcY, this.hcY) == 0 && Float.compare(realSetStrokeStyleActionLinearArg.hcZ, this.hcZ) == 0 && Float.compare(realSetStrokeStyleActionLinearArg.hda, this.hda) == 0 && Arrays.equals(this.hdb, realSetStrokeStyleActionLinearArg.hdb) && Arrays.equals(this.positions, realSetStrokeStyleActionLinearArg.positions)) {
                AppMethodBeat.o(103402);
                return true;
            }
            AppMethodBeat.o(103402);
            return false;
        } else {
            AppMethodBeat.o(103402);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103403);
        int hash = (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY), Float.valueOf(this.hcZ), Float.valueOf(this.hda)}) * 31) + Arrays.hashCode(this.hdb)) * 31) + Arrays.hashCode(this.positions);
        AppMethodBeat.o(103403);
        return hash;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103404);
        super.i(parcel);
        this.hcX = parcel.readFloat();
        this.hcY = parcel.readFloat();
        this.hcZ = parcel.readFloat();
        this.hda = parcel.readFloat();
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
        AppMethodBeat.o(103404);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103405);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hcX);
        parcel.writeFloat(this.hcY);
        parcel.writeFloat(this.hcZ);
        parcel.writeFloat(this.hda);
        if (this.hdb != null) {
            parcel.writeInt(this.hdb.length);
            parcel.writeIntArray(this.hdb);
        } else {
            parcel.writeInt(0);
        }
        if (this.positions != null) {
            parcel.writeInt(this.positions.length);
            parcel.writeFloatArray(this.positions);
            AppMethodBeat.o(103405);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(103405);
    }

    public int describeContents() {
        return 0;
    }

    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(103406);
        super.f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.o(103406);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(103406);
            return;
        }
        this.hcX = g.d(optJSONArray, 0);
        this.hcY = g.d(optJSONArray, 1);
        this.hcZ = g.d(optJSONArray, 2);
        this.hda = g.d(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            AppMethodBeat.o(103406);
            return;
        }
        this.hdb = new int[optJSONArray2.length()];
        this.positions = new float[optJSONArray2.length()];
        for (int i = 0; i < optJSONArray2.length(); i++) {
            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
            if (optJSONArray3.length() >= 2) {
                this.positions[i] = (float) optJSONArray3.optDouble(0);
                this.hdb[i] = g.n(optJSONArray3.optJSONArray(1));
            }
        }
        AppMethodBeat.o(103406);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103407);
        super.j(jSONObject);
        AppMethodBeat.o(103407);
    }

    static {
        AppMethodBeat.i(103408);
        AppMethodBeat.o(103408);
    }
}
