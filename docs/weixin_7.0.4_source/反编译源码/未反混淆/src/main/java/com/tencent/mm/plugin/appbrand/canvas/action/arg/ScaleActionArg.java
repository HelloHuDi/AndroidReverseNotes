package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScaleActionArg extends BaseDrawActionArg {
    public static final Creator<ScaleActionArg> CREATOR = new Creator<ScaleActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScaleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103434);
            ScaleActionArg scaleActionArg = new ScaleActionArg(parcel);
            AppMethodBeat.o(103434);
            return scaleActionArg;
        }
    };
    public float hcX;
    public float hcY;

    public ScaleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103435);
        super.i(parcel);
        this.hcX = parcel.readFloat();
        this.hcY = parcel.readFloat();
        AppMethodBeat.o(103435);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103436);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.hcX = (float) optJSONArray.optDouble(0);
        this.hcY = (float) optJSONArray.optDouble(1);
        AppMethodBeat.o(103436);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103437);
        if (this == obj) {
            AppMethodBeat.o(103437);
            return true;
        } else if (!(obj instanceof ScaleActionArg)) {
            AppMethodBeat.o(103437);
            return false;
        } else if (super.equals(obj)) {
            ScaleActionArg scaleActionArg = (ScaleActionArg) obj;
            if (Float.compare(scaleActionArg.hcX, this.hcX) == 0 && Float.compare(scaleActionArg.hcY, this.hcY) == 0) {
                AppMethodBeat.o(103437);
                return true;
            }
            AppMethodBeat.o(103437);
            return false;
        } else {
            AppMethodBeat.o(103437);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103438);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY)});
        AppMethodBeat.o(103438);
        return hash;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103439);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hcX);
        parcel.writeFloat(this.hcY);
        AppMethodBeat.o(103439);
    }

    static {
        AppMethodBeat.i(103440);
        AppMethodBeat.o(103440);
    }
}
