package com.tencent.p177mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.performance.elf.ElfCheckResponse */
public class ElfCheckResponse implements Parcelable {
    public static final Creator<ElfCheckResponse> CREATOR = new C286662();
    /* renamed from: DA */
    Bundle f13699DA;
    public boolean nDl;
    public long oJs;
    boolean pfo;
    boolean pfp;
    private String pfq;
    private long pfr;
    long pfs;
    String processName;

    /* renamed from: com.tencent.mm.plugin.performance.elf.ElfCheckResponse$2 */
    static class C286662 implements Creator<ElfCheckResponse> {
        C286662() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ElfCheckResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(111052);
            ElfCheckResponse elfCheckResponse = new ElfCheckResponse(parcel);
            AppMethodBeat.m2505o(111052);
            return elfCheckResponse;
        }
    }

    /* renamed from: com.tencent.mm.plugin.performance.elf.ElfCheckResponse$1 */
    class C286671 implements Runnable {
        final /* synthetic */ Context val$context;

        C286671(Context context) {
            this.val$context = context;
        }

        public final void run() {
            AppMethodBeat.m2504i(111051);
            C4990ab.m7417i("MicroMsg.ElfCheckResponse", "call this response %s", ElfCheckResponse.this.toString());
            Intent intent = new Intent(this.val$context, ElfCallUpReceiver.class);
            intent.setAction(ElfCallUpReceiver.class.getName());
            if (ElfCheckResponse.this.f13699DA != null) {
                intent.putExtras(ElfCheckResponse.this.f13699DA);
            }
            this.val$context.sendBroadcast(intent);
            AppMethodBeat.m2505o(111051);
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
        AppMethodBeat.m2504i(111053);
        String str = this.pfo + "," + this.pfp + "," + this.pfr + "," + this.processName + "," + this.pfq + "," + this.pfs;
        AppMethodBeat.m2505o(111053);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        AppMethodBeat.m2504i(111054);
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
        parcel.writeBundle(this.f13699DA);
        AppMethodBeat.m2505o(111054);
    }

    protected ElfCheckResponse(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(111055);
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
        this.f13699DA = parcel.readBundle();
        AppMethodBeat.m2505o(111055);
    }

    static {
        AppMethodBeat.m2504i(111056);
        AppMethodBeat.m2505o(111056);
    }
}
