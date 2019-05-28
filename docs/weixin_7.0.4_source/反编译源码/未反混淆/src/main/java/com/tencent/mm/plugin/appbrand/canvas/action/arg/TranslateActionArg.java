package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class TranslateActionArg extends BaseDrawActionArg {
    public static final Creator<TranslateActionArg> CREATOR = new Creator<TranslateActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TranslateActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103578);
            TranslateActionArg translateActionArg = new TranslateActionArg(parcel);
            AppMethodBeat.o(103578);
            return translateActionArg;
        }
    };
    public float x;
    public float y;

    public TranslateActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final boolean ayg() {
        return this.x == 0.0f && this.y == 0.0f;
    }

    public int describeContents() {
        return 0;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103579);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        AppMethodBeat.o(103579);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103580);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        AppMethodBeat.o(103580);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103581);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        AppMethodBeat.o(103581);
    }

    static {
        AppMethodBeat.i(103584);
        AppMethodBeat.o(103584);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103582);
        if (this == obj) {
            AppMethodBeat.o(103582);
            return true;
        } else if (!(obj instanceof TranslateActionArg)) {
            AppMethodBeat.o(103582);
            return false;
        } else if (super.equals(obj)) {
            TranslateActionArg translateActionArg = (TranslateActionArg) obj;
            if (Float.compare(translateActionArg.x, this.x) == 0 && Float.compare(translateActionArg.y, this.y) == 0) {
                AppMethodBeat.o(103582);
                return true;
            }
            AppMethodBeat.o(103582);
            return false;
        } else {
            AppMethodBeat.o(103582);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103583);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y)});
        AppMethodBeat.o(103583);
        return hash;
    }
}
