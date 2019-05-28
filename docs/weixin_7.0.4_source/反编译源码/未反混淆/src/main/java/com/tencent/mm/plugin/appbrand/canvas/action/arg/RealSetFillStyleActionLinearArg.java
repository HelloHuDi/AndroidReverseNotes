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

public class RealSetFillStyleActionLinearArg extends RealSetFillStyleActionArg {
    public static final Creator<RealSetFillStyleActionLinearArg> CREATOR = new Creator<RealSetFillStyleActionLinearArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionLinearArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103362);
            RealSetFillStyleActionLinearArg realSetFillStyleActionLinearArg = new RealSetFillStyleActionLinearArg(parcel);
            AppMethodBeat.o(103362);
            return realSetFillStyleActionLinearArg;
        }
    };
    public float hcX;
    public float hcY;
    public float hcZ;
    public float hda;
    public int[] hdb;
    public float[] positions;

    public RealSetFillStyleActionLinearArg(Parcel parcel) {
        super(parcel);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103363);
        if (this.hdb == null || this.positions == null) {
            AppMethodBeat.o(103363);
            return false;
        }
        dVar.hcF.setShader(new LinearGradient(this.hcX, this.hcY, this.hcZ, this.hda, this.hdb, this.positions, TileMode.CLAMP));
        AppMethodBeat.o(103363);
        return true;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103364);
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
        AppMethodBeat.o(103364);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103365);
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
            AppMethodBeat.o(103365);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(103365);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103366);
        if (this == obj) {
            AppMethodBeat.o(103366);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionLinearArg)) {
            AppMethodBeat.o(103366);
            return false;
        } else if (super.equals(obj)) {
            RealSetFillStyleActionLinearArg realSetFillStyleActionLinearArg = (RealSetFillStyleActionLinearArg) obj;
            if (Float.compare(realSetFillStyleActionLinearArg.hcX, this.hcX) == 0 && Float.compare(realSetFillStyleActionLinearArg.hcY, this.hcY) == 0 && Float.compare(realSetFillStyleActionLinearArg.hcZ, this.hcZ) == 0 && Float.compare(realSetFillStyleActionLinearArg.hda, this.hda) == 0 && Arrays.equals(this.hdb, realSetFillStyleActionLinearArg.hdb) && Arrays.equals(this.positions, realSetFillStyleActionLinearArg.positions)) {
                AppMethodBeat.o(103366);
                return true;
            }
            AppMethodBeat.o(103366);
            return false;
        } else {
            AppMethodBeat.o(103366);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103367);
        int hash = (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY), Float.valueOf(this.hcZ), Float.valueOf(this.hda)}) * 31) + Arrays.hashCode(this.hdb)) * 31) + Arrays.hashCode(this.positions);
        AppMethodBeat.o(103367);
        return hash;
    }

    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(103368);
        super.f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.o(103368);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(103368);
            return;
        }
        this.hcX = g.d(optJSONArray, 0);
        this.hcY = g.d(optJSONArray, 1);
        this.hcZ = g.d(optJSONArray, 2);
        this.hda = g.d(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            AppMethodBeat.o(103368);
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
        AppMethodBeat.o(103368);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103369);
        super.j(jSONObject);
        AppMethodBeat.o(103369);
    }

    static {
        AppMethodBeat.i(103370);
        AppMethodBeat.o(103370);
    }
}
