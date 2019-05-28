package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ElfCheckResponse implements Parcelable {
    public static final Creator<ElfCheckResponse> CREATOR = new Creator<ElfCheckResponse>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ElfCheckResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(111052);
            ElfCheckResponse elfCheckResponse = new ElfCheckResponse(parcel);
            AppMethodBeat.o(111052);
            return elfCheckResponse;
        }
    };
    Bundle DA;
    public boolean nDl;
    public long oJs;
    boolean pfo;
    boolean pfp;
    private String pfq;
    private long pfr;
    long pfs;
    String processName;

    /* renamed from: com.tencent.mm.plugin.performance.elf.ElfCheckResponse$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context) {
            this.val$context = context;
        }

        public final void run() {
            AppMethodBeat.i(111051);
            ab.i("MicroMsg.ElfCheckResponse", "call this response %s", ElfCheckResponse.this.toString());
            Intent intent = new Intent(this.val$context, ElfCallUpReceiver.class);
            intent.setAction(ElfCallUpReceiver.class.getName());
            if (ElfCheckResponse.this.DA != null) {
                intent.putExtras(ElfCheckResponse.this.DA);
            }
            this.val$context.sendBroadcast(intent);
            AppMethodBeat.o(111051);
        }
    }

    public ElfCheckResponse(boolean z, long j, boolean z2, boolean z3, String str, String str2) {
        this.pfp = z3;
        this.pfo = z2;
        this.processName = str;
        this.pfq = str2;
        this.pfs = 1000;
        this.oJs = j;
        this.nDl = z;
    }

    public String toString() {
        AppMethodBeat.i(111053);
        String str = this.pfo + "," + this.pfp + "," + this.pfr + "," + this.processName + "," + this.pfq + "," + this.pfs;
        AppMethodBeat.o(111053);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        AppMethodBeat.i(111054);
        parcel.writeByte(this.pfo ? (byte) 1 : (byte) 0);
        if (this.nDl) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.oJs);
        if (!this.pfp) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        parcel.writeString(this.pfq);
        parcel.writeString(this.processName);
        parcel.writeLong(this.pfr);
        parcel.writeLong(this.pfs);
        parcel.writeBundle(this.DA);
        AppMethodBeat.o(111054);
    }

    protected ElfCheckResponse(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(111055);
        this.pfo = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.nDl = z;
        this.oJs = parcel.readLong();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.pfp = z2;
        this.pfq = parcel.readString();
        this.processName = parcel.readString();
        this.pfr = parcel.readLong();
        this.pfs = parcel.readLong();
        this.DA = parcel.readBundle();
        AppMethodBeat.o(111055);
    }

    static {
        AppMethodBeat.i(111056);
        AppMethodBeat.o(111056);
    }
}
