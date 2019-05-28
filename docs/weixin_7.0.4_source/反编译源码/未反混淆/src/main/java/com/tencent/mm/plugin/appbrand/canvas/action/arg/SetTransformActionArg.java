package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetTransformActionArg extends BaseDrawActionArg {
    public static final Creator<SetTransformActionArg> CREATOR = new Creator<SetTransformActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetTransformActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103571);
            SetTransformActionArg setTransformActionArg = new SetTransformActionArg(parcel);
            AppMethodBeat.o(103571);
            return setTransformActionArg;
        }
    };
    public float hdr;
    public float hds;
    public float scaleX;
    public float scaleY;
    public float translateX;
    public float translateY;

    public SetTransformActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103572);
        super.i(parcel);
        this.scaleX = parcel.readFloat();
        this.hdr = parcel.readFloat();
        this.hds = parcel.readFloat();
        this.scaleY = parcel.readFloat();
        this.translateX = parcel.readFloat();
        this.translateY = parcel.readFloat();
        AppMethodBeat.o(103572);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103573);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        try {
            this.scaleX = (float) optJSONArray.getDouble(0);
            this.hdr = (float) optJSONArray.getDouble(1);
            this.hds = (float) optJSONArray.getDouble(2);
            this.scaleY = (float) optJSONArray.getDouble(3);
            this.translateX = g.c(optJSONArray, 4);
            this.translateY = g.c(optJSONArray, 5);
            AppMethodBeat.o(103573);
        } catch (JSONException e) {
            d.printErrStackTrace("SetTransformActionArg", e, "", new Object[0]);
            AppMethodBeat.o(103573);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103574);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.scaleY);
        parcel.writeFloat(this.hdr);
        parcel.writeFloat(this.hds);
        parcel.writeFloat(this.scaleY);
        parcel.writeFloat(this.translateX);
        parcel.writeFloat(this.translateY);
        AppMethodBeat.o(103574);
    }

    static {
        AppMethodBeat.i(103577);
        AppMethodBeat.o(103577);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103575);
        if (this == obj) {
            AppMethodBeat.o(103575);
            return true;
        } else if (!(obj instanceof SetTransformActionArg)) {
            AppMethodBeat.o(103575);
            return false;
        } else if (super.equals(obj)) {
            SetTransformActionArg setTransformActionArg = (SetTransformActionArg) obj;
            if (Float.compare(setTransformActionArg.scaleX, this.scaleX) == 0 && Float.compare(setTransformActionArg.hdr, this.hdr) == 0 && Float.compare(setTransformActionArg.hds, this.hds) == 0 && Float.compare(setTransformActionArg.scaleY, this.scaleY) == 0 && Float.compare(setTransformActionArg.translateX, this.translateX) == 0 && Float.compare(setTransformActionArg.translateY, this.translateY) == 0) {
                AppMethodBeat.o(103575);
                return true;
            }
            AppMethodBeat.o(103575);
            return false;
        } else {
            AppMethodBeat.o(103575);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103576);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.scaleX), Float.valueOf(this.hdr), Float.valueOf(this.hds), Float.valueOf(this.scaleY), Float.valueOf(this.translateX), Float.valueOf(this.translateY)});
        AppMethodBeat.o(103576);
        return hash;
    }
}
