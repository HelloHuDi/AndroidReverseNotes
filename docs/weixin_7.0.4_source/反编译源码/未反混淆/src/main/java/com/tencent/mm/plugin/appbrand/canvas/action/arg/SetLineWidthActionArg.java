package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineWidthActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineWidthActionArg> CREATOR = new Creator<SetLineWidthActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineWidthActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103527);
            SetLineWidthActionArg setLineWidthActionArg = new SetLineWidthActionArg(parcel);
            AppMethodBeat.o(103527);
            return setLineWidthActionArg;
        }
    };
    public float hdn;

    public SetLineWidthActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103528);
        super.i(parcel);
        this.hdn = parcel.readFloat();
        AppMethodBeat.o(103528);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103529);
        super.j(jSONObject);
        this.hdn = g.d(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.o(103529);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103530);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hdn);
        AppMethodBeat.o(103530);
    }

    static {
        AppMethodBeat.i(103533);
        AppMethodBeat.o(103533);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103531);
        if (this == obj) {
            AppMethodBeat.o(103531);
            return true;
        } else if (!(obj instanceof SetLineWidthActionArg)) {
            AppMethodBeat.o(103531);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(103531);
            return false;
        } else if (Float.compare(((SetLineWidthActionArg) obj).hdn, this.hdn) == 0) {
            AppMethodBeat.o(103531);
            return true;
        } else {
            AppMethodBeat.o(103531);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103532);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hdn)});
        AppMethodBeat.o(103532);
        return hash;
    }
}
