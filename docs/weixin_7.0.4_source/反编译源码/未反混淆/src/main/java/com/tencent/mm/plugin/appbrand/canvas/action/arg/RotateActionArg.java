package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class RotateActionArg extends BaseDrawActionArg {
    public static final Creator<RotateActionArg> CREATOR = new Creator<RotateActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RotateActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103427);
            RotateActionArg rotateActionArg = new RotateActionArg(parcel);
            AppMethodBeat.o(103427);
            return rotateActionArg;
        }
    };
    public float hde;

    public RotateActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103428);
        super.i(parcel);
        this.hde = parcel.readFloat();
        AppMethodBeat.o(103428);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103429);
        super.j(jSONObject);
        this.hde = (float) jSONObject.optJSONArray("data").optDouble(0);
        AppMethodBeat.o(103429);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103430);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hde);
        AppMethodBeat.o(103430);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103431);
        if (this == obj) {
            AppMethodBeat.o(103431);
            return true;
        } else if (!(obj instanceof RotateActionArg)) {
            AppMethodBeat.o(103431);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(103431);
            return false;
        } else if (Float.compare(((RotateActionArg) obj).hde, this.hde) == 0) {
            AppMethodBeat.o(103431);
            return true;
        } else {
            AppMethodBeat.o(103431);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103432);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hde)});
        AppMethodBeat.o(103432);
        return hash;
    }

    static {
        AppMethodBeat.i(103433);
        AppMethodBeat.o(103433);
    }
}
