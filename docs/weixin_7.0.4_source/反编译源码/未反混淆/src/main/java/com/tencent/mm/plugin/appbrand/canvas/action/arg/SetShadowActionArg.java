package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetShadowActionArg extends BaseDrawActionArg {
    public static final Creator<SetShadowActionArg> CREATOR = new Creator<SetShadowActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetShadowActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103541);
            SetShadowActionArg setShadowActionArg = new SetShadowActionArg(parcel);
            AppMethodBeat.o(103541);
            return setShadowActionArg;
        }
    };
    public int color;
    public float hdo;
    public float x;
    public float y;

    public SetShadowActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103542);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.hdo = parcel.readFloat();
        this.color = parcel.readInt();
        AppMethodBeat.o(103542);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103543);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.hdo);
        parcel.writeInt(this.color);
        AppMethodBeat.o(103543);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103544);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        optJSONArray.length();
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        this.hdo = g.d(optJSONArray, 2);
        optJSONArray = optJSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(103544);
            return;
        }
        this.color = g.n(optJSONArray);
        AppMethodBeat.o(103544);
    }

    static {
        AppMethodBeat.i(103547);
        AppMethodBeat.o(103547);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103545);
        if (this == obj) {
            AppMethodBeat.o(103545);
            return true;
        } else if (!(obj instanceof SetShadowActionArg)) {
            AppMethodBeat.o(103545);
            return false;
        } else if (super.equals(obj)) {
            SetShadowActionArg setShadowActionArg = (SetShadowActionArg) obj;
            if (Float.compare(setShadowActionArg.x, this.x) == 0 && Float.compare(setShadowActionArg.y, this.y) == 0 && Float.compare(setShadowActionArg.hdo, this.hdo) == 0 && this.color == setShadowActionArg.color) {
                AppMethodBeat.o(103545);
                return true;
            }
            AppMethodBeat.o(103545);
            return false;
        } else {
            AppMethodBeat.o(103545);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103546);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.hdo), Integer.valueOf(this.color)});
        AppMethodBeat.o(103546);
        return hash;
    }
}
