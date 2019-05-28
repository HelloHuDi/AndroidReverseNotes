package com.tencent.p177mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p230g.p231a.C42013j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper */
public final class NFCIPCHelper {

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper$NFCEventTransfer */
    public static class NFCEventTransfer implements Parcelable {
        public static final Creator<NFCEventTransfer> CREATOR = new C145341();
        public int actionCode;
        public String csd;
        public boolean cse;
        public boolean csf;
        public Bundle csg;

        /* renamed from: com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper$NFCEventTransfer$1 */
        static class C145341 implements Creator<NFCEventTransfer> {
            C145341() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NFCEventTransfer[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(6946);
                NFCEventTransfer nFCEventTransfer = new NFCEventTransfer(parcel);
                AppMethodBeat.m2505o(6946);
                return nFCEventTransfer;
            }
        }

        public NFCEventTransfer(C42013j c42013j) {
            this.actionCode = c42013j.csb.actionCode;
            this.csd = c42013j.csb.csd;
            this.cse = c42013j.csb.cse;
            this.csf = c42013j.csb.csf;
        }

        protected NFCEventTransfer(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(6947);
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
            AppMethodBeat.m2505o(6947);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(6948);
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
            AppMethodBeat.m2505o(6948);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.m2504i(6949);
            AppMethodBeat.m2505o(6949);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper$a */
    public static class C14535a implements C45413i<NFCEventTransfer, NFCEventTransfer> {
        private C14535a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(6950);
            NFCEventTransfer nFCEventTransfer = (NFCEventTransfer) obj;
            C4990ab.m7417i("MicroMsg.NFCIPCHelper", "alvinluo NfcEventInvokeTask invoke process: %s", ((C6624h) C1720g.m3533RM().mo5224Rn()).eHT);
            C42013j c42013j = new C42013j();
            c42013j.csb.actionCode = nFCEventTransfer.actionCode;
            c42013j.csb.csd = nFCEventTransfer.csd;
            c42013j.csb.cse = nFCEventTransfer.cse;
            c42013j.csb.csf = nFCEventTransfer.csf;
            C4879a.xxA.mo10055m(c42013j);
            nFCEventTransfer.csg = c42013j.csc.csg;
            AppMethodBeat.m2505o(6950);
            return nFCEventTransfer;
        }
    }

    public static void cYy() {
        AppMethodBeat.m2504i(6951);
        C4990ab.m7412e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
        C7060h.pYm.mo15419k(968, 0, 1);
        AppMethodBeat.m2505o(6951);
    }
}
