package com.tencent.mm.bf;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class e {
    private static e fQQ = null;
    private byte[] eHH = new byte[0];
    public az fBz = new az(1, "speex_worker");
    private String fQR;
    private f fQS = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(116558);
            if (e.this.fQR == null) {
                AppMethodBeat.o(116558);
                return;
            }
            ab.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a) mVar).filename + " filepath " + e.this.fQR + " errCode " + i2);
            if (((a) mVar).filename.equals(e.this.fQR)) {
                g.Rg().b(240, e.this.fQS);
                if (i2 == 0) {
                    d.ajP();
                    d.ajR();
                }
                try {
                    ab.d("MicroMsg.SpeexUploadCore", "delete " + e.this.fQR + " delete " + new b(e.this.fQR).delete() + " errCode " + i2);
                } catch (Exception e) {
                    ab.e("MicroMsg.SpeexUploadCore", "exception:%s", bo.l(e));
                } finally {
                    e.ajY().start();
                    e.this.fQR = null;
                    AppMethodBeat.o(116558);
                }
            } else {
                AppMethodBeat.o(116558);
            }
        }
    };

    public e() {
        AppMethodBeat.i(116559);
        AppMethodBeat.o(116559);
    }

    public static e ajY() {
        AppMethodBeat.i(116560);
        if (fQQ == null) {
            fQQ = new e();
        }
        e eVar = fQQ;
        AppMethodBeat.o(116560);
        return eVar;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(116561);
        ab.d("MicroMsg.SpeexUploadCore", "pushWork");
        this.fBz.e(aVar);
        AppMethodBeat.o(116561);
    }

    public final void start() {
        AppMethodBeat.i(116562);
        if (at.isWifi(ah.getContext())) {
            new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(116557);
                    Looper.myQueue().addIdleHandler(new IdleHandler() {
                        public final boolean queueIdle() {
                            AppMethodBeat.i(116556);
                            e.this.b(new a() {
                                public final boolean acf() {
                                    return true;
                                }

                                public final boolean acg() {
                                    AppMethodBeat.i(116555);
                                    e.b(e.this);
                                    AppMethodBeat.o(116555);
                                    return false;
                                }
                            });
                            AppMethodBeat.o(116556);
                            return false;
                        }
                    });
                    AppMethodBeat.o(116557);
                }
            }, 100);
            AppMethodBeat.o(116562);
            return;
        }
        AppMethodBeat.o(116562);
    }

    private static b cB(int i, int i2) {
        AppMethodBeat.i(116563);
        b bVar = new b(b.ajO());
        if (bVar.exists() && bVar.isDirectory()) {
            b[] dMF = bVar.dMF();
            int i3 = 0;
            bVar = null;
            while (dMF != null && i3 < dMF.length) {
                bVar = dMF[i3];
                if (bVar != null && bVar.isFile()) {
                    ab.d("MicroMsg.SpeexUploadCore", "file " + j.w(bVar.mUri));
                    String w = j.w(bVar.mUri);
                    long length = bVar.length();
                    if (bVar.getName().endsWith(".spx")) {
                        if (length >= ((long) i) && length <= ((long) i2)) {
                            break;
                        }
                        ab.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", w, Integer.valueOf(i), Integer.valueOf(i2));
                        com.tencent.mm.vfs.e.deleteFile(w);
                        bVar = null;
                    } else {
                        bVar = null;
                    }
                }
                i3++;
            }
            AppMethodBeat.o(116563);
            return bVar;
        }
        AppMethodBeat.o(116563);
        return null;
    }
}
