package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetGlobalCompositeOperationActionArg extends BaseDrawActionArg {
    public static final Creator<SetGlobalCompositeOperationActionArg> CREATOR = new Creator<SetGlobalCompositeOperationActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetGlobalCompositeOperationActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103499);
            SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = new SetGlobalCompositeOperationActionArg(parcel);
            AppMethodBeat.o(103499);
            return setGlobalCompositeOperationActionArg;
        }
    };
    public String type;

    public SetGlobalCompositeOperationActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103500);
        super.i(parcel);
        this.type = parcel.readString();
        AppMethodBeat.o(103500);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103501);
        super.j(jSONObject);
        this.type = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103501);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103502);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.type);
        AppMethodBeat.o(103502);
    }

    static {
        AppMethodBeat.i(103505);
        AppMethodBeat.o(103505);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103503);
        if (this == obj) {
            AppMethodBeat.o(103503);
            return true;
        } else if (!(obj instanceof SetGlobalCompositeOperationActionArg)) {
            AppMethodBeat.o(103503);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.type, ((SetGlobalCompositeOperationActionArg) obj).type);
            AppMethodBeat.o(103503);
            return equals;
        } else {
            AppMethodBeat.o(103503);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103504);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.type});
        AppMethodBeat.o(103504);
        return hash;
    }
}
