package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class NFCIPCHelper {

    public static class NFCEventTransfer implements Parcelable {
        public static final Creator<NFCEventTransfer> CREATOR = new Creator<NFCEventTransfer>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NFCEventTransfer[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(6946);
                NFCEventTransfer nFCEventTransfer = new NFCEventTransfer(parcel);
                AppMethodBeat.o(6946);
                return nFCEventTransfer;
            }
        };
        public int actionCode;
        public String csd;
        public boolean cse;
        public boolean csf;
        public Bundle csg;

        public NFCEventTransfer(j jVar) {
            this.actionCode = jVar.csb.actionCode;
            this.csd = jVar.csb.csd;
            this.cse = jVar.csb.cse;
            this.csf = jVar.csb.csf;
        }

        protected NFCEventTransfer(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(6947);
            this.actionCode = parcel.readInt();
            this.csd = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.cse = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.csf = z2;
            this.csg = parcel.readBundle(getClass().getClassLoader());
            AppMethodBeat.o(6947);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(6948);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.csd);
            if (this.cse) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.csf) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            parcel.writeBundle(this.csg);
            AppMethodBeat.o(6948);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(6949);
            AppMethodBeat.o(6949);
        }
    }

    public static class a implements i<NFCEventTransfer, NFCEventTransfer> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(6950);
            NFCEventTransfer nFCEventTransfer = (NFCEventTransfer) obj;
            ab.i("MicroMsg.NFCIPCHelper", "alvinluo NfcEventInvokeTask invoke process: %s", ((h) g.RM().Rn()).eHT);
            j jVar = new j();
            jVar.csb.actionCode = nFCEventTransfer.actionCode;
            jVar.csb.csd = nFCEventTransfer.csd;
            jVar.csb.cse = nFCEventTransfer.cse;
            jVar.csb.csf = nFCEventTransfer.csf;
            com.tencent.mm.sdk.b.a.xxA.m(jVar);
            nFCEventTransfer.csg = jVar.csc.csg;
            AppMethodBeat.o(6950);
            return nFCEventTransfer;
        }
    }

    public static void cYy() {
        AppMethodBeat.i(6951);
        ab.e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
        com.tencent.mm.plugin.report.service.h.pYm.k(968, 0, 1);
        AppMethodBeat.o(6951);
    }
}
