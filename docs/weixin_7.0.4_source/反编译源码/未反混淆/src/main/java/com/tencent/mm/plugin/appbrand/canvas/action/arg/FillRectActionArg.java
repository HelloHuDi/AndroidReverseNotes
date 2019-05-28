package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class FillRectActionArg extends BaseDrawActionArg {
    public static final Creator<FillRectActionArg> CREATOR = new Creator<FillRectActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FillRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103353);
            FillRectActionArg fillRectActionArg = new FillRectActionArg(parcel);
            AppMethodBeat.o(103353);
            return fillRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public FillRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103354);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(103354);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103355);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(103355);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103356);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        this.width = g.d(optJSONArray, 2);
        this.height = g.d(optJSONArray, 3);
        AppMethodBeat.o(103356);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103357);
        if (this == obj) {
            AppMethodBeat.o(103357);
            return true;
        } else if (!(obj instanceof FillRectActionArg)) {
            AppMethodBeat.o(103357);
            return false;
        } else if (super.equals(obj)) {
            FillRectActionArg fillRectActionArg = (FillRectActionArg) obj;
            if (Float.compare(fillRectActionArg.x, this.x) == 0 && Float.compare(fillRectActionArg.y, this.y) == 0 && Float.compare(fillRectActionArg.width, this.width) == 0 && Float.compare(fillRectActionArg.height, this.height) == 0) {
                AppMethodBeat.o(103357);
                return true;
            }
            AppMethodBeat.o(103357);
            return false;
        } else {
            AppMethodBeat.o(103357);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103358);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height)});
        AppMethodBeat.o(103358);
        return hash;
    }

    static {
        AppMethodBeat.i(103359);
        AppMethodBeat.o(103359);
    }
}
