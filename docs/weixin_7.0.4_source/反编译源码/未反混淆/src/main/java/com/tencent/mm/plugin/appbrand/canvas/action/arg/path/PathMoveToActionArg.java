package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathMoveToActionArg extends BasePathActionArg {
    public static final Creator<PathMoveToActionArg> CREATOR = new Creator<PathMoveToActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathMoveToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103616);
            PathMoveToActionArg pathMoveToActionArg = new PathMoveToActionArg(parcel);
            AppMethodBeat.o(103616);
            return pathMoveToActionArg;
        }
    };
    public float x;
    public float y;

    public PathMoveToActionArg(Parcel parcel) {
        super(parcel);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103617);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        AppMethodBeat.o(103617);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103618);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        AppMethodBeat.o(103618);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103619);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        AppMethodBeat.o(103619);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103620);
        if (!super.equals(obj)) {
            AppMethodBeat.o(103620);
            return false;
        } else if (obj instanceof PathMoveToActionArg) {
            PathMoveToActionArg pathMoveToActionArg = (PathMoveToActionArg) obj;
            if (pathMoveToActionArg.x == this.x && pathMoveToActionArg.y == this.y) {
                AppMethodBeat.o(103620);
                return true;
            }
            AppMethodBeat.o(103620);
            return false;
        } else {
            AppMethodBeat.o(103620);
            return false;
        }
    }

    static {
        AppMethodBeat.i(103621);
        AppMethodBeat.o(103621);
    }
}
