package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SeMiterLimitActionArg extends BaseDrawActionArg {
    public static final Creator<SeMiterLimitActionArg> CREATOR = new Creator<SeMiterLimitActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SeMiterLimitActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103441);
            SeMiterLimitActionArg seMiterLimitActionArg = new SeMiterLimitActionArg(parcel);
            AppMethodBeat.o(103441);
            return seMiterLimitActionArg;
        }
    };
    public float hdf;

    public SeMiterLimitActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103442);
        super.i(parcel);
        this.hdf = parcel.readFloat();
        AppMethodBeat.o(103442);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103443);
        super.j(jSONObject);
        this.hdf = (float) jSONObject.optJSONArray("data").optDouble(0);
        AppMethodBeat.o(103443);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103444);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hdf);
        AppMethodBeat.o(103444);
    }

    static {
        AppMethodBeat.i(103447);
        AppMethodBeat.o(103447);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103445);
        if (this == obj) {
            AppMethodBeat.o(103445);
            return true;
        } else if (!(obj instanceof SeMiterLimitActionArg)) {
            AppMethodBeat.o(103445);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(103445);
            return false;
        } else if (Float.compare(((SeMiterLimitActionArg) obj).hdf, this.hdf) == 0) {
            AppMethodBeat.o(103445);
            return true;
        } else {
            AppMethodBeat.o(103445);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103446);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hdf)});
        AppMethodBeat.o(103446);
        return hash;
    }
}
