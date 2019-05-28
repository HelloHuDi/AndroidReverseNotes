package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathRectActionArg extends BasePathActionArg {
    public static final Creator<PathRectActionArg> CREATOR = new Creator<PathRectActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103628);
            PathRectActionArg pathRectActionArg = new PathRectActionArg(parcel);
            AppMethodBeat.o(103628);
            return pathRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public PathRectActionArg(Parcel parcel) {
        super(parcel);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103629);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.d(optJSONArray, 0);
        this.y = g.d(optJSONArray, 1);
        this.width = g.d(optJSONArray, 2);
        this.height = g.d(optJSONArray, 3);
        AppMethodBeat.o(103629);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103630);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(103630);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103631);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(103631);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103632);
        if (!super.equals(obj)) {
            AppMethodBeat.o(103632);
            return false;
        } else if (obj instanceof PathRectActionArg) {
            PathRectActionArg pathRectActionArg = (PathRectActionArg) obj;
            if (pathRectActionArg.x == this.x && pathRectActionArg.y == this.y && pathRectActionArg.width == this.width && pathRectActionArg.height == this.height) {
                AppMethodBeat.o(103632);
                return true;
            }
            AppMethodBeat.o(103632);
            return false;
        } else {
            AppMethodBeat.o(103632);
            return false;
        }
    }

    static {
        AppMethodBeat.i(103633);
        AppMethodBeat.o(103633);
    }
}
