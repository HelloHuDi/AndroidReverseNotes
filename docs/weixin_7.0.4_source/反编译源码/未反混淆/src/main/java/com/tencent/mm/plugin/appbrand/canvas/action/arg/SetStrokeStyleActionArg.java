package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.h;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetStrokeStyleActionArg extends BaseDrawActionArg {
    public static final Creator<SetStrokeStyleActionArg> CREATOR = new Creator<SetStrokeStyleActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetStrokeStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103548);
            SetStrokeStyleActionArg setStrokeStyleActionArg = new SetStrokeStyleActionArg(parcel);
            AppMethodBeat.o(103548);
            return setStrokeStyleActionArg;
        }
    };
    public RealSetStrokeStyleActionArg hdp;

    public SetStrokeStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void reset() {
        AppMethodBeat.i(103549);
        super.reset();
        h.ayo().a(this.hdp);
        this.hdp = null;
        AppMethodBeat.o(103549);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103550);
        if (this.hdp == null) {
            AppMethodBeat.o(103550);
            return false;
        }
        boolean a = this.hdp.a(dVar, canvas);
        AppMethodBeat.o(103550);
        return a;
    }

    public int describeContents() {
        return 0;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103551);
        super.i(parcel);
        this.hdp = (RealSetStrokeStyleActionArg) parcel.readParcelable(SetStrokeStyleActionArg.class.getClassLoader());
        AppMethodBeat.o(103551);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103552);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.hdp, i);
        AppMethodBeat.o(103552);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103553);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(103553);
            return;
        }
        this.hdp = (RealSetStrokeStyleActionArg) h.ayo().yy(optJSONArray.optString(0));
        this.hdp.f(optJSONArray);
        AppMethodBeat.o(103553);
    }

    static {
        AppMethodBeat.i(103556);
        AppMethodBeat.o(103556);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103554);
        if (this == obj) {
            AppMethodBeat.o(103554);
            return true;
        } else if (!(obj instanceof SetStrokeStyleActionArg)) {
            AppMethodBeat.o(103554);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdp, ((SetStrokeStyleActionArg) obj).hdp);
            AppMethodBeat.o(103554);
            return equals;
        } else {
            AppMethodBeat.o(103554);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103555);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdp});
        AppMethodBeat.o(103555);
        return hash;
    }
}
