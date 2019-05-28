package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetTextBaseLineActionArg extends BaseDrawActionArg {
    public static final Creator<SetTextBaseLineActionArg> CREATOR = new Creator<SetTextBaseLineActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetTextBaseLineActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103564);
            SetTextBaseLineActionArg setTextBaseLineActionArg = new SetTextBaseLineActionArg(parcel);
            AppMethodBeat.o(103564);
            return setTextBaseLineActionArg;
        }
    };
    public String hdq;

    public SetTextBaseLineActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103565);
        super.i(parcel);
        this.hdq = parcel.readString();
        AppMethodBeat.o(103565);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103566);
        super.j(jSONObject);
        this.hdq = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103566);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103567);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdq);
        AppMethodBeat.o(103567);
    }

    static {
        AppMethodBeat.i(103570);
        AppMethodBeat.o(103570);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103568);
        if (this == obj) {
            AppMethodBeat.o(103568);
            return true;
        } else if (!(obj instanceof SetTextBaseLineActionArg)) {
            AppMethodBeat.o(103568);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdq, ((SetTextBaseLineActionArg) obj).hdq);
            AppMethodBeat.o(103568);
            return equals;
        } else {
            AppMethodBeat.o(103568);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103569);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdq});
        AppMethodBeat.o(103569);
        return hash;
    }
}
