package com.google.android.gms.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

final /* synthetic */ class zzw implements Runnable {
    private final zzt zzch;

    zzw(zzt zzt) {
        this.zzch = zzt;
    }

    /* JADX WARNING: Missing block: B:17:0x004d, code skipped:
            if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x006c;
     */
    /* JADX WARNING: Missing block: B:18:0x004f, code skipped:
            r2 = java.lang.String.valueOf(r0);
            new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 8).append("Sending ").append(r2);
     */
    /* JADX WARNING: Missing block: B:19:0x006c, code skipped:
            r2 = r1.zzcg.zzk;
            r3 = r1.zzcc;
            r4 = android.os.Message.obtain();
            r4.what = r0.what;
            r4.arg1 = r0.zzck;
            r4.replyTo = r3;
            r3 = new android.os.Bundle();
            r3.putBoolean("oneWay", r0.zzu());
            r3.putString("pkg", r2.getPackageName());
            r3.putBundle("data", r0.zzcm);
            r4.setData(r3);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            r0 = r1.zzcd;
     */
    /* JADX WARNING: Missing block: B:22:0x00aa, code skipped:
            if (r0.zzab == null) goto L_0x00c3;
     */
    /* JADX WARNING: Missing block: B:23:0x00ac, code skipped:
            r0.zzab.send(r4);
     */
    /* JADX WARNING: Missing block: B:24:0x00b3, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:25:0x00b4, code skipped:
            r1.zzd(2, r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:32:0x00c5, code skipped:
            if (r0.zzcj == null) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:33:0x00c7, code skipped:
            r0.zzcj.send(r4);
     */
    /* JADX WARNING: Missing block: B:34:0x00ce, code skipped:
            r0 = new java.lang.IllegalStateException("Both messengers are null");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.m2504i(57615);
        zzt zzt = this.zzch;
        loop0:
        while (true) {
            synchronized (zzt) {
                try {
                    if (zzt.state != 2) {
                        AppMethodBeat.m2505o(57615);
                        return;
                    } else if (zzt.zzce.isEmpty()) {
                        zzt.zzs();
                        AppMethodBeat.m2505o(57615);
                        return;
                    } else {
                        zzz zzz = (zzz) zzt.zzce.poll();
                        zzt.zzcf.put(zzz.zzck, zzz);
                        zzt.zzcg.zzbz.schedule(new zzx(zzt, zzz), 30, TimeUnit.SECONDS);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57615);
                }
            }
        }
        throw r0;
    }
}
