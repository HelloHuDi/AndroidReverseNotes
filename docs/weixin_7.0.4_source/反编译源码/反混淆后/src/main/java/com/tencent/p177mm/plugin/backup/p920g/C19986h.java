package com.tencent.p177mm.plugin.backup.p920g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.backup.g.h */
public final class C19986h {
    static int index = 0;
    private C19987a jwj;
    int[] jxO = new int[]{1000, 1000, 1000, 2000, 5000, 9000, 1000};
    int jxP = 0;
    boolean jxQ = false;
    C7564ap jxR = new C7564ap(Looper.getMainLooper(), new C199881(), false);

    /* renamed from: com.tencent.mm.plugin.backup.g.h$a */
    public interface C19987a {
        void aTK();

        void aTL();
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.h$1 */
    class C199881 implements C5015a {
        C199881() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(17672);
            if (C19986h.this.jxQ) {
                C4990ab.m7413e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", Integer.valueOf(C19986h.index));
                C19986h.this.jxP = 0;
                AppMethodBeat.m2505o(17672);
            } else {
                C4990ab.m7417i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", Integer.valueOf(C19986h.index));
                if (C19986h.index < C19986h.this.jxO.length) {
                    C19986h.this.jwj.aTK();
                    long j = (long) C19986h.this.jxO[C19986h.index];
                    C19986h.this.jxR.mo16770ae(j, j);
                    C19986h.acr();
                } else {
                    C19986h.this.jxQ = true;
                    C19986h.this.jxP = 0;
                    C19986h.this.jwj.aTL();
                }
                AppMethodBeat.m2505o(17672);
            }
            return false;
        }
    }

    static /* synthetic */ int acr() {
        int i = index;
        index = i + 1;
        return i;
    }

    public C19986h(C19987a c19987a) {
        AppMethodBeat.m2504i(17673);
        this.jwj = c19987a;
        AppMethodBeat.m2505o(17673);
    }
}
