package com.tencent.p177mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1912i.C1913a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.network.ac */
public final class C32858ac extends C1913a {
    private C7564ap frk = new C7564ap(new C328571(), false);
    private int gei = 4;
    private long gej;
    private int gek = 0;
    private final RemoteCallbackList<C1923n> gel = new RemoteCallbackList();

    /* renamed from: com.tencent.mm.network.ac$1 */
    class C328571 implements C5015a {
        C328571() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(58683);
            C4990ab.m7417i("MicroMsg.NetworkEvent", "listeners ct : %d", Integer.valueOf(C32858ac.this.gel.beginBroadcast()));
            for (int i = r0 - 1; i >= 0; i--) {
                try {
                    ((C1923n) C32858ac.this.gel.getBroadcastItem(i)).mo5192gl(C32858ac.this.gei);
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.NetworkEvent", "exception:%s", C5046bo.m7574l(e));
                }
            }
            C32858ac.this.gel.finishBroadcast();
            AppMethodBeat.m2505o(58683);
            return false;
        }
    }

    public C32858ac() {
        AppMethodBeat.m2504i(58684);
        AppMethodBeat.m2505o(58684);
    }

    public final int amP() {
        AppMethodBeat.m2504i(58685);
        C4990ab.m7417i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(0 > C5046bo.m7549fp(this.gej) ? 5 : this.gei));
        AppMethodBeat.m2505o(58685);
        return 0 > C5046bo.m7549fp(this.gej) ? 5 : this.gei;
    }

    /* renamed from: mE */
    private boolean m53754mE(int i) {
        if (i == this.gei) {
            return false;
        }
        if (3 != i) {
            if (2 == i) {
                if (this.gei == 0 || this.gei == 1) {
                    return false;
                }
                this.gek++;
                if (this.gek > 0) {
                    this.gei = 2;
                    return true;
                }
            } else if (4 == i) {
                this.gek = 0;
                this.gei = 4;
                return true;
            } else if (VERSION.SDK_INT >= 26 && i == -1) {
                this.gei = 0;
                return true;
            }
            this.gei = i;
            return true;
        } else if (this.gei != 2) {
            return false;
        } else {
            this.gei = i;
            return true;
        }
    }

    /* renamed from: c */
    public final boolean mo5597c(C1923n c1923n) {
        AppMethodBeat.m2504i(58686);
        try {
            this.gel.register(c1923n);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetworkEvent", "addListener %s", e);
            C4990ab.m7413e("MicroMsg.NetworkEvent", "exception:%s", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(58686);
        return true;
    }

    /* renamed from: d */
    public final boolean mo5598d(C1923n c1923n) {
        boolean z = false;
        AppMethodBeat.m2504i(58687);
        try {
            z = this.gel.unregister(c1923n);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetworkEvent", "removeListener %s", e);
            C4990ab.m7413e("MicroMsg.NetworkEvent", "exception:%s", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(58687);
        return z;
    }

    public final void amQ() {
        AppMethodBeat.m2504i(58688);
        this.gel.kill();
        AppMethodBeat.m2505o(58688);
    }

    /* renamed from: mF */
    public final void mo53427mF(int i) {
        AppMethodBeat.m2504i(58689);
        C4990ab.m7417i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i));
        if (!m53754mE(i)) {
            AppMethodBeat.m2505o(58689);
        } else if (this.gei == 0 || this.gei == 4 || this.gei == 6) {
            this.frk.mo16770ae(1000, 1000);
            AppMethodBeat.m2505o(58689);
        } else {
            AppMethodBeat.m2505o(58689);
        }
    }

    public final long amR() {
        return this.gej;
    }
}
