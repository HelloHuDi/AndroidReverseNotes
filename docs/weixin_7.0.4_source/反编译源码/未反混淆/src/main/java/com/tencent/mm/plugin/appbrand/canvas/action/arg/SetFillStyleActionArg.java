package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.g;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFillStyleActionArg extends BaseDrawActionArg {
    public static final Creator<SetFillStyleActionArg> CREATOR = new Creator<SetFillStyleActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFillStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103448);
            SetFillStyleActionArg setFillStyleActionArg = new SetFillStyleActionArg(parcel);
            AppMethodBeat.o(103448);
            return setFillStyleActionArg;
        }
    };
    public RealSetFillStyleActionArg hdg;

    public SetFillStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void reset() {
        AppMethodBeat.i(103449);
        super.reset();
        g.ayn().a(this.hdg);
        this.hdg = null;
        AppMethodBeat.o(103449);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103450);
        if (this.hdg == null) {
            AppMethodBeat.o(103450);
            return false;
        }
        boolean a = this.hdg.a(dVar, canvas);
        AppMethodBeat.o(103450);
        return a;
    }

    public int describeContents() {
        return 0;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103451);
        super.i(parcel);
        this.hdg = (RealSetFillStyleActionArg) parcel.readParcelable(SetFillStyleActionArg.class.getClassLoader());
        AppMethodBeat.o(103451);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103452);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.hdg, i);
        AppMethodBeat.o(103452);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103453);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(103453);
            return;
        }
        this.hdg = (RealSetFillStyleActionArg) g.ayn().yy(optJSONArray.optString(0));
        this.hdg.f(optJSONArray);
        AppMethodBeat.o(103453);
    }

    static {
        AppMethodBeat.i(103456);
        AppMethodBeat.o(103456);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103454);
        if (this == obj) {
            AppMethodBeat.o(103454);
            return true;
        } else if (!(obj instanceof SetFillStyleActionArg)) {
            AppMethodBeat.o(103454);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdg, ((SetFillStyleActionArg) obj).hdg);
            AppMethodBeat.o(103454);
            return equals;
        } else {
            AppMethodBeat.o(103454);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103455);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdg});
        AppMethodBeat.o(103455);
        return hash;
    }
}
