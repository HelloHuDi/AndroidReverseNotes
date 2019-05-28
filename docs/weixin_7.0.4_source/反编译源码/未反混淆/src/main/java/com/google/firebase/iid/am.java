package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

final /* synthetic */ class am implements Runnable {
    private final aj bwX;

    am(aj ajVar) {
        this.bwX = ajVar;
    }

    /* JADX WARNING: Missing block: B:17:0x004b, code skipped:
            if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x006a;
     */
    /* JADX WARNING: Missing block: B:18:0x004d, code skipped:
            r2 = java.lang.String.valueOf(r0);
            new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 8).append("Sending ").append(r2);
     */
    /* JADX WARNING: Missing block: B:19:0x006a, code skipped:
            r2 = r1.bwW.bvF;
            r3 = r1.bwS;
            r4 = android.os.Message.obtain();
            r4.what = r0.what;
            r4.arg1 = r0.bvC;
            r4.replyTo = r3;
            r3 = new android.os.Bundle();
            r3.putBoolean("oneWay", r0.zzw());
            r3.putString("pkg", r2.getPackageName());
            r3.putBundle("data", r0.bvE);
            r4.setData(r3);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            r0 = r1.bwT;
     */
    /* JADX WARNING: Missing block: B:22:0x00a6, code skipped:
            if (r0.bwC == null) goto L_0x00bf;
     */
    /* JADX WARNING: Missing block: B:23:0x00a8, code skipped:
            r0.bwC.send(r4);
     */
    /* JADX WARNING: Missing block: B:24:0x00af, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:25:0x00b0, code skipped:
            r1.zza(2, r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:32:0x00c1, code skipped:
            if (r0.bwZ == null) goto L_0x00ca;
     */
    /* JADX WARNING: Missing block: B:33:0x00c3, code skipped:
            r0.bwZ.send(r4);
     */
    /* JADX WARNING: Missing block: B:34:0x00ca, code skipped:
            r0 = new java.lang.IllegalStateException("Both messengers are null");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.i(108832);
        aj ajVar = this.bwX;
        loop0:
        while (true) {
            synchronized (ajVar) {
                try {
                    if (ajVar.state != 2) {
                        AppMethodBeat.o(108832);
                        return;
                    } else if (ajVar.bwU.isEmpty()) {
                        ajVar.zzu();
                        AppMethodBeat.o(108832);
                        return;
                    } else {
                        c cVar = (c) ajVar.bwU.poll();
                        ajVar.bwV.put(cVar.bvC, cVar);
                        ajVar.bwW.bwP.schedule(new an(ajVar, cVar), 30, TimeUnit.SECONDS);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108832);
                }
            }
        }
        throw r0;
    }
}
