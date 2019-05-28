package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.platformtools.ax */
public final class C5031ax {
    static boolean cQz;
    private TelephonyManager xAM;
    private PhoneStateListener xAN;
    List<C5030a> xAO = new LinkedList();

    /* renamed from: com.tencent.mm.sdk.platformtools.ax$1 */
    class C50291 extends PhoneStateListener {
        C50291() {
        }

        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.m2504i(52214);
            C4990ab.m7417i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", Integer.valueOf(i), str);
            if (C5031ax.this.xAO.size() > 0) {
                for (C5030a ih : (C5030a[]) C5031ax.this.xAO.toArray(new C5030a[C5031ax.this.xAO.size()])) {
                    ih.mo4652ih(i);
                }
            }
            super.onCallStateChanged(i, str);
            switch (i) {
                case 0:
                    C5031ax.cQz = false;
                    AppMethodBeat.m2505o(52214);
                    return;
                case 1:
                case 2:
                    C5031ax.cQz = true;
                    break;
            }
            AppMethodBeat.m2505o(52214);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ax$a */
    public interface C5030a {
        /* renamed from: ih */
        void mo4652ih(int i);
    }

    public C5031ax() {
        AppMethodBeat.m2504i(52215);
        AppMethodBeat.m2505o(52215);
    }

    /* renamed from: a */
    public final void mo10365a(C5030a c5030a) {
        AppMethodBeat.m2504i(52216);
        this.xAO.add(c5030a);
        AppMethodBeat.m2505o(52216);
    }

    public final void dpf() {
        AppMethodBeat.m2504i(52217);
        this.xAO.clear();
        AppMethodBeat.m2505o(52217);
    }

    /* renamed from: Ex */
    public static boolean m7487Ex() {
        AppMethodBeat.m2504i(52218);
        C4990ab.m7417i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", Boolean.valueOf(cQz));
        boolean z = cQz;
        AppMethodBeat.m2505o(52218);
        return z;
    }

    /* renamed from: gK */
    public final void mo10368gK(Context context) {
        AppMethodBeat.m2504i(52219);
        C4990ab.m7416i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
        if (this.xAM == null) {
            this.xAM = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.xAN == null) {
            this.xAN = new C50291();
        }
        this.xAM.listen(this.xAN, 32);
        AppMethodBeat.m2505o(52219);
    }

    public final void end() {
        AppMethodBeat.m2504i(52220);
        C4990ab.m7416i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
        if (this.xAM != null) {
            this.xAM.listen(this.xAN, 0);
            this.xAN = null;
        }
        AppMethodBeat.m2505o(52220);
    }
}
