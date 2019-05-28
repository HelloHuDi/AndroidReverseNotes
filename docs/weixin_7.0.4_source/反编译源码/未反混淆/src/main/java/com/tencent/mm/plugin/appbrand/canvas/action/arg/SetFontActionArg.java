package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontActionArg> CREATOR = new Creator<SetFontActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103457);
            SetFontActionArg setFontActionArg = new SetFontActionArg(parcel);
            AppMethodBeat.o(103457);
            return setFontActionArg;
        }
    };
    public String name;
    public float size;

    public SetFontActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103458);
        super.i(parcel);
        this.name = parcel.readString();
        this.size = parcel.readFloat();
        AppMethodBeat.o(103458);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103459);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(103459);
            return;
        }
        this.name = optJSONArray.optString(0);
        this.size = g.d(optJSONArray, 1);
        AppMethodBeat.o(103459);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103460);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.name);
        parcel.writeFloat(this.size);
        AppMethodBeat.o(103460);
    }

    static {
        AppMethodBeat.i(103463);
        AppMethodBeat.o(103463);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103461);
        if (this == obj) {
            AppMethodBeat.o(103461);
            return true;
        } else if (!(obj instanceof SetFontActionArg)) {
            AppMethodBeat.o(103461);
            return false;
        } else if (super.equals(obj)) {
            SetFontActionArg setFontActionArg = (SetFontActionArg) obj;
            if (Float.compare(setFontActionArg.size, this.size) == 0 && Objects.equals(this.name, setFontActionArg.name)) {
                AppMethodBeat.o(103461);
                return true;
            }
            AppMethodBeat.o(103461);
            return false;
        } else {
            AppMethodBeat.o(103461);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103462);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.name, Float.valueOf(this.size)});
        AppMethodBeat.o(103462);
        return hash;
    }
}
