package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineCapActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineCapActionArg> CREATOR = new Creator<SetLineCapActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineCapActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103506);
            SetLineCapActionArg setLineCapActionArg = new SetLineCapActionArg(parcel);
            AppMethodBeat.o(103506);
            return setLineCapActionArg;
        }
    };
    public String hdj;

    public SetLineCapActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103507);
        super.i(parcel);
        this.hdj = parcel.readString();
        AppMethodBeat.o(103507);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103508);
        super.j(jSONObject);
        this.hdj = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103508);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103509);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdj);
        AppMethodBeat.o(103509);
    }

    static {
        AppMethodBeat.i(103512);
        AppMethodBeat.o(103512);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103510);
        if (this == obj) {
            AppMethodBeat.o(103510);
            return true;
        } else if (!(obj instanceof SetLineCapActionArg)) {
            AppMethodBeat.o(103510);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdj, ((SetLineCapActionArg) obj).hdj);
            AppMethodBeat.o(103510);
            return equals;
        } else {
            AppMethodBeat.o(103510);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103511);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdj});
        AppMethodBeat.o(103511);
        return hash;
    }
}
