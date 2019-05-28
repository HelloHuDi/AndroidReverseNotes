package com.tencent.mm.graphics.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public enum d {
    ;
    
    public WeakReference<Context> eCP;
    public HashMap<Integer, a> eCQ;
    public final Object eCR;
    public boolean isRunning;
    public Timer mTimer;

    private d(String str) {
        AppMethodBeat.i(57089);
        this.eCP = null;
        this.eCQ = new HashMap();
        this.isRunning = false;
        this.mTimer = null;
        this.eCR = new Object();
        AppMethodBeat.o(57089);
    }

    static {
        AppMethodBeat.o(57092);
    }

    public final b Py() {
        b bVar;
        AppMethodBeat.i(57090);
        synchronized (this.eCR) {
            try {
                if (this.eCQ != null) {
                    a aVar = (a) this.eCQ.get(Integer.valueOf(2));
                    if (aVar != null && (aVar instanceof b)) {
                        aVar.Pw();
                        bVar = (b) aVar;
                    }
                }
                bVar = null;
                AppMethodBeat.o(57090);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57090);
            }
        }
        return bVar;
    }

    /* JADX WARNING: Missing block: B:14:0x0028, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(57091);
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Pz() {
        AppMethodBeat.i(57091);
        synchronized (this.eCR) {
            try {
                if (this.isRunning) {
                    if (this.mTimer != null) {
                        this.mTimer.cancel();
                    }
                    this.isRunning = false;
                    if (this.eCQ != null) {
                        this.eCQ.clear();
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57091);
            }
        }
    }
}
