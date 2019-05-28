package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathLineToActionArg extends BasePathActionArg {
    public static final Creator<PathLineToActionArg> CREATOR = new Creator<PathLineToActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathLineToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103610);
            PathLineToActionArg pathLineToActionArg = new PathLineToActionArg(parcel);
            AppMethodBeat.o(103610);
            return pathLineToActionArg;
        }
    };
    public float x;
    public float y;

    public PathLineToActionArg(Parcel parcel) {
        super(parcel);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103611);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        AppMethodBeat.o(103611);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103612);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        AppMethodBeat.o(103612);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103613);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        AppMethodBeat.o(103613);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103614);
        if (!super.equals(obj)) {
            AppMethodBeat.o(103614);
            return false;
        } else if (obj instanceof PathLineToActionArg) {
            PathLineToActionArg pathLineToActionArg = (PathLineToActionArg) obj;
            if (pathLineToActionArg.x == this.x && pathLineToActionArg.y == this.y) {
                AppMethodBeat.o(103614);
                return true;
            }
            AppMethodBeat.o(103614);
            return false;
        } else {
            AppMethodBeat.o(103614);
            return false;
        }
    }

    static {
        AppMethodBeat.i(103615);
        AppMethodBeat.o(103615);
    }
}
