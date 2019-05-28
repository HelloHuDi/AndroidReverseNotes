package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawTextActionArg extends BaseDrawActionArg {
    public static final Creator<DrawTextActionArg> CREATOR = new Creator<DrawTextActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawTextActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103346);
            DrawTextActionArg drawTextActionArg = new DrawTextActionArg(parcel);
            AppMethodBeat.o(103346);
            return drawTextActionArg;
        }
    };
    public float hcW;
    public String text;
    public float x;
    public float y;

    public DrawTextActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103347);
        super.i(parcel);
        this.text = parcel.readString();
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.hcW = parcel.readFloat();
        AppMethodBeat.o(103347);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103348);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.text = optJSONArray.optString(0);
        this.x = g.d(optJSONArray, 1);
        this.y = g.d(optJSONArray, 2);
        this.hcW = g.d(optJSONArray, 3);
        AppMethodBeat.o(103348);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103349);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.text);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.hcW);
        AppMethodBeat.o(103349);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103350);
        if (this == obj) {
            AppMethodBeat.o(103350);
            return true;
        } else if (!(obj instanceof DrawTextActionArg)) {
            AppMethodBeat.o(103350);
            return false;
        } else if (super.equals(obj)) {
            DrawTextActionArg drawTextActionArg = (DrawTextActionArg) obj;
            if (Float.compare(drawTextActionArg.x, this.x) == 0 && Float.compare(drawTextActionArg.y, this.y) == 0 && Float.compare(drawTextActionArg.hcW, this.hcW) == 0 && Objects.equals(this.text, drawTextActionArg.text)) {
                AppMethodBeat.o(103350);
                return true;
            }
            AppMethodBeat.o(103350);
            return false;
        } else {
            AppMethodBeat.o(103350);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103351);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.text, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.hcW)});
        AppMethodBeat.o(103351);
        return hash;
    }

    static {
        AppMethodBeat.i(103352);
        AppMethodBeat.o(103352);
    }
}
