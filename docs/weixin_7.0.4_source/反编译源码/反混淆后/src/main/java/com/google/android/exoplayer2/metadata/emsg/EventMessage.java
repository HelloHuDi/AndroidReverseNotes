package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class EventMessage implements Entry {
    public static final Creator<EventMessage> CREATOR = new C08741();
    private int aBR;
    public final String bfh;
    public final long bfi;
    public final byte[] bfj;
    /* renamed from: id */
    public final long f17723id;
    public final String value;

    /* renamed from: com.google.android.exoplayer2.metadata.emsg.EventMessage$1 */
    static class C08741 implements Creator<EventMessage> {
        C08741() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EventMessage[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95267);
            EventMessage eventMessage = new EventMessage(parcel);
            AppMethodBeat.m2505o(95267);
            return eventMessage;
        }
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.bfh = str;
        this.value = str2;
        this.bfi = j;
        this.f17723id = j2;
        this.bfj = bArr;
    }

    EventMessage(Parcel parcel) {
        AppMethodBeat.m2504i(95268);
        this.bfh = parcel.readString();
        this.value = parcel.readString();
        this.bfi = parcel.readLong();
        this.f17723id = parcel.readLong();
        this.bfj = parcel.createByteArray();
        AppMethodBeat.m2505o(95268);
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.m2504i(95269);
        if (this.aBR == 0) {
            hashCode = ((this.bfh != null ? this.bfh.hashCode() : 0) + JsApiGetABTestConfig.CTRL_INDEX) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            this.aBR = ((((((hashCode + i) * 31) + ((int) (this.bfi ^ (this.bfi >>> 32)))) * 31) + ((int) (this.f17723id ^ (this.f17723id >>> 32)))) * 31) + Arrays.hashCode(this.bfj);
        }
        hashCode = this.aBR;
        AppMethodBeat.m2505o(95269);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95270);
        if (this == obj) {
            AppMethodBeat.m2505o(95270);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95270);
            return false;
        } else {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.bfi == eventMessage.bfi && this.f17723id == eventMessage.f17723id && C17675v.m27574j(this.bfh, eventMessage.bfh) && C17675v.m27574j(this.value, eventMessage.value) && Arrays.equals(this.bfj, eventMessage.bfj)) {
                AppMethodBeat.m2505o(95270);
                return true;
            }
            AppMethodBeat.m2505o(95270);
            return false;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95271);
        parcel.writeString(this.bfh);
        parcel.writeString(this.value);
        parcel.writeLong(this.bfi);
        parcel.writeLong(this.f17723id);
        parcel.writeByteArray(this.bfj);
        AppMethodBeat.m2505o(95271);
    }

    static {
        AppMethodBeat.m2504i(95272);
        AppMethodBeat.m2505o(95272);
    }
}
