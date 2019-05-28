package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class EventMessage implements Entry {
    public static final Creator<EventMessage> CREATOR = new Creator<EventMessage>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EventMessage[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95267);
            EventMessage eventMessage = new EventMessage(parcel);
            AppMethodBeat.o(95267);
            return eventMessage;
        }
    };
    private int aBR;
    public final String bfh;
    public final long bfi;
    public final byte[] bfj;
    public final long id;
    public final String value;

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.bfh = str;
        this.value = str2;
        this.bfi = j;
        this.id = j2;
        this.bfj = bArr;
    }

    EventMessage(Parcel parcel) {
        AppMethodBeat.i(95268);
        this.bfh = parcel.readString();
        this.value = parcel.readString();
        this.bfi = parcel.readLong();
        this.id = parcel.readLong();
        this.bfj = parcel.createByteArray();
        AppMethodBeat.o(95268);
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.i(95269);
        if (this.aBR == 0) {
            hashCode = ((this.bfh != null ? this.bfh.hashCode() : 0) + JsApiGetABTestConfig.CTRL_INDEX) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            this.aBR = ((((((hashCode + i) * 31) + ((int) (this.bfi ^ (this.bfi >>> 32)))) * 31) + ((int) (this.id ^ (this.id >>> 32)))) * 31) + Arrays.hashCode(this.bfj);
        }
        hashCode = this.aBR;
        AppMethodBeat.o(95269);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95270);
        if (this == obj) {
            AppMethodBeat.o(95270);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95270);
            return false;
        } else {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.bfi == eventMessage.bfi && this.id == eventMessage.id && v.j(this.bfh, eventMessage.bfh) && v.j(this.value, eventMessage.value) && Arrays.equals(this.bfj, eventMessage.bfj)) {
                AppMethodBeat.o(95270);
                return true;
            }
            AppMethodBeat.o(95270);
            return false;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95271);
        parcel.writeString(this.bfh);
        parcel.writeString(this.value);
        parcel.writeLong(this.bfi);
        parcel.writeLong(this.id);
        parcel.writeByteArray(this.bfj);
        AppMethodBeat.o(95271);
    }

    static {
        AppMethodBeat.i(95272);
        AppMethodBeat.o(95272);
    }
}
