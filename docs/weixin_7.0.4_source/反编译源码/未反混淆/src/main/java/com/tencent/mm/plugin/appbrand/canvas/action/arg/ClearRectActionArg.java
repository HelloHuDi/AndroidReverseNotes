package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClearRectActionArg extends BaseDrawActionArg {
    public static final Creator<ClearRectActionArg> CREATOR = new Creator<ClearRectActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ClearRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103309);
            ClearRectActionArg clearRectActionArg = new ClearRectActionArg(parcel);
            AppMethodBeat.o(103309);
            return clearRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public ClearRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103310);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(103310);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103311);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(103311);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103312);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        this.width = g.d(optJSONArray, 2);
        this.height = g.d(optJSONArray, 3);
        AppMethodBeat.o(103312);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103313);
        if (this == obj) {
            AppMethodBeat.o(103313);
            return true;
        } else if (!(obj instanceof ClearRectActionArg)) {
            AppMethodBeat.o(103313);
            return false;
        } else if (super.equals(obj)) {
            ClearRectActionArg clearRectActionArg = (ClearRectActionArg) obj;
            if (Float.compare(clearRectActionArg.x, this.x) == 0 && Float.compare(clearRectActionArg.y, this.y) == 0 && Float.compare(clearRectActionArg.width, this.width) == 0 && Float.compare(clearRectActionArg.height, this.height) == 0) {
                AppMethodBeat.o(103313);
                return true;
            }
            AppMethodBeat.o(103313);
            return false;
        } else {
            AppMethodBeat.o(103313);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103314);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height)});
        AppMethodBeat.o(103314);
        return hash;
    }

    static {
        AppMethodBeat.i(103315);
        AppMethodBeat.o(103315);
    }
}
