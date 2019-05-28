package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class h {
    static int index = 0;
    private a jwj;
    int[] jxO = new int[]{1000, 1000, 1000, 2000, 5000, 9000, 1000};
    int jxP = 0;
    boolean jxQ = false;
    ap jxR = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(17672);
            if (h.this.jxQ) {
                ab.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", Integer.valueOf(h.index));
                h.this.jxP = 0;
                AppMethodBeat.o(17672);
            } else {
                ab.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", Integer.valueOf(h.index));
                if (h.index < h.this.jxO.length) {
                    h.this.jwj.aTK();
                    long j = (long) h.this.jxO[h.index];
                    h.this.jxR.ae(j, j);
                    h.acr();
                } else {
                    h.this.jxQ = true;
                    h.this.jxP = 0;
                    h.this.jwj.aTL();
                }
                AppMethodBeat.o(17672);
            }
            return false;
        }
    }, false);

    public interface a {
        void aTK();

        void aTL();
    }

    static /* synthetic */ int acr() {
        int i = index;
        index = i + 1;
        return i;
    }

    public h(a aVar) {
        AppMethodBeat.i(17673);
        this.jwj = aVar;
        AppMethodBeat.o(17673);
    }
}
