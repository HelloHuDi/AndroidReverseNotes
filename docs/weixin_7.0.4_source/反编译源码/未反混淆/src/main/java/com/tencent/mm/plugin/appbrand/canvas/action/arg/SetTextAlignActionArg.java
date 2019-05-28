package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetTextAlignActionArg extends BaseDrawActionArg {
    public static final Creator<SetTextAlignActionArg> CREATOR = new Creator<SetTextAlignActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetTextAlignActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103557);
            SetTextAlignActionArg setTextAlignActionArg = new SetTextAlignActionArg(parcel);
            AppMethodBeat.o(103557);
            return setTextAlignActionArg;
        }
    };
    public String hdq;

    public SetTextAlignActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103558);
        super.i(parcel);
        this.hdq = parcel.readString();
        AppMethodBeat.o(103558);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103559);
        super.j(jSONObject);
        this.hdq = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103559);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103560);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdq);
        AppMethodBeat.o(103560);
    }

    static {
        AppMethodBeat.i(103563);
        AppMethodBeat.o(103563);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103561);
        if (this == obj) {
            AppMethodBeat.o(103561);
            return true;
        } else if (!(obj instanceof SetTextAlignActionArg)) {
            AppMethodBeat.o(103561);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdq, ((SetTextAlignActionArg) obj).hdq);
            AppMethodBeat.o(103561);
            return equals;
        } else {
            AppMethodBeat.o(103561);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103562);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdq});
        AppMethodBeat.o(103562);
        return hash;
    }
}
