package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawRectActionArg extends BaseDrawActionArg {
    public static final Creator<DrawRectActionArg> CREATOR = new Creator<DrawRectActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103339);
            DrawRectActionArg drawRectActionArg = new DrawRectActionArg(parcel);
            AppMethodBeat.o(103339);
            return drawRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public DrawRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103340);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(103340);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103341);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(103341);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103342);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        this.width = g.d(optJSONArray, 2);
        this.height = g.d(optJSONArray, 3);
        AppMethodBeat.o(103342);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103343);
        if (this == obj) {
            AppMethodBeat.o(103343);
            return true;
        } else if (!(obj instanceof DrawRectActionArg)) {
            AppMethodBeat.o(103343);
            return false;
        } else if (super.equals(obj)) {
            DrawRectActionArg drawRectActionArg = (DrawRectActionArg) obj;
            if (Float.compare(drawRectActionArg.x, this.x) == 0 && Float.compare(drawRectActionArg.y, this.y) == 0 && Float.compare(drawRectActionArg.width, this.width) == 0 && Float.compare(drawRectActionArg.height, this.height) == 0) {
                AppMethodBeat.o(103343);
                return true;
            }
            AppMethodBeat.o(103343);
            return false;
        } else {
            AppMethodBeat.o(103343);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103344);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height)});
        AppMethodBeat.o(103344);
        return hash;
    }

    static {
        AppMethodBeat.i(103345);
        AppMethodBeat.o(103345);
    }
}
