package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetLineDashActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineDashActionArg> CREATOR = new Creator<SetLineDashActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineDashActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103513);
            SetLineDashActionArg setLineDashActionArg = new SetLineDashActionArg(parcel);
            AppMethodBeat.o(103513);
            return setLineDashActionArg;
        }
    };
    public float[] hdk = null;
    public float hdl = Float.MIN_VALUE;

    public SetLineDashActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103514);
        super.i(parcel);
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.hdk = new float[readInt];
            parcel.readFloatArray(this.hdk);
        }
        this.hdl = parcel.readFloat();
        AppMethodBeat.o(103514);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103515);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(103515);
            return;
        }
        try {
            JSONArray jSONArray = optJSONArray.getJSONArray(0);
            if (jSONArray == null) {
                AppMethodBeat.o(103515);
                return;
            }
            this.hdk = new float[jSONArray.length()];
            for (int i = 0; i < this.hdk.length; i++) {
                this.hdk[i] = g.d(jSONArray, i);
            }
            this.hdl = g.d(optJSONArray, 1);
            AppMethodBeat.o(103515);
        } catch (JSONException e) {
            AppMethodBeat.o(103515);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103516);
        super.writeToParcel(parcel, i);
        if (this.hdk != null) {
            parcel.writeInt(this.hdk.length);
            parcel.writeFloatArray(this.hdk);
        }
        parcel.writeFloat(this.hdl);
        AppMethodBeat.o(103516);
    }

    static {
        AppMethodBeat.i(103519);
        AppMethodBeat.o(103519);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103517);
        if (this == obj) {
            AppMethodBeat.o(103517);
            return true;
        } else if (!(obj instanceof SetLineDashActionArg)) {
            AppMethodBeat.o(103517);
            return false;
        } else if (super.equals(obj)) {
            SetLineDashActionArg setLineDashActionArg = (SetLineDashActionArg) obj;
            if (Float.compare(setLineDashActionArg.hdl, this.hdl) == 0 && Arrays.equals(this.hdk, setLineDashActionArg.hdk)) {
                AppMethodBeat.o(103517);
                return true;
            }
            AppMethodBeat.o(103517);
            return false;
        } else {
            AppMethodBeat.o(103517);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103518);
        int hash = (Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hdl)}) * 31) + Arrays.hashCode(this.hdk);
        AppMethodBeat.o(103518);
        return hash;
    }
}
