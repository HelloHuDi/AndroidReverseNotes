package com.tencent.p177mm.p202bf;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;

/* renamed from: com.tencent.mm.bf.e */
public final class C9077e {
    private static C9077e fQQ = null;
    private byte[] eHH = new byte[0];
    public C23498az fBz = new C23498az(1, "speex_worker");
    private String fQR;
    private C1202f fQS = new C90763();

    /* renamed from: com.tencent.mm.bf.e$3 */
    class C90763 implements C1202f {
        C90763() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(116558);
            if (C9077e.this.fQR == null) {
                AppMethodBeat.m2505o(116558);
                return;
            }
            C4990ab.m7410d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((C32332a) c1207m).filename + " filepath " + C9077e.this.fQR + " errCode " + i2);
            if (((C32332a) c1207m).filename.equals(C9077e.this.fQR)) {
                C1720g.m3540Rg().mo14546b(240, C9077e.this.fQS);
                if (i2 == 0) {
                    C25858d.ajP();
                    C25858d.ajR();
                }
                try {
                    C4990ab.m7410d("MicroMsg.SpeexUploadCore", "delete " + C9077e.this.fQR + " delete " + new C5728b(C9077e.this.fQR).delete() + " errCode " + i2);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SpeexUploadCore", "exception:%s", C5046bo.m7574l(e));
                } finally {
                    C9077e.ajY().start();
                    C9077e.this.fQR = null;
                    AppMethodBeat.m2505o(116558);
                }
            } else {
                AppMethodBeat.m2505o(116558);
            }
        }
    }

    /* renamed from: com.tencent.mm.bf.e$1 */
    public class C90781 implements IdleHandler {
        public final boolean queueIdle() {
            AppMethodBeat.m2504i(116554);
            if (C1720g.m3540Rg().foreground) {
                C4990ab.m7420w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
                AppMethodBeat.m2505o(116554);
            } else {
                C4990ab.m7410d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
                C9077e.this.fBz.mo39164pk(false);
                AppMethodBeat.m2505o(116554);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.bf.e$2 */
    class C90792 implements Runnable {

        /* renamed from: com.tencent.mm.bf.e$2$1 */
        class C13061 implements IdleHandler {

            /* renamed from: com.tencent.mm.bf.e$2$1$1 */
            class C13071 implements C23499a {
                C13071() {
                }

                public final boolean acf() {
                    return true;
                }

                public final boolean acg() {
                    AppMethodBeat.m2504i(116555);
                    C9077e.m16458b(C9077e.this);
                    AppMethodBeat.m2505o(116555);
                    return false;
                }
            }

            C13061() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(116556);
                C9077e.this.mo20553b(new C13071());
                AppMethodBeat.m2505o(116556);
                return false;
            }
        }

        C90792() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116557);
            Looper.myQueue().addIdleHandler(new C13061());
            AppMethodBeat.m2505o(116557);
        }
    }

    public C9077e() {
        AppMethodBeat.m2504i(116559);
        AppMethodBeat.m2505o(116559);
    }

    public static C9077e ajY() {
        AppMethodBeat.m2504i(116560);
        if (fQQ == null) {
            fQQ = new C9077e();
        }
        C9077e c9077e = fQQ;
        AppMethodBeat.m2505o(116560);
        return c9077e;
    }

    /* renamed from: b */
    public final void mo20553b(C23499a c23499a) {
        AppMethodBeat.m2504i(116561);
        C4990ab.m7410d("MicroMsg.SpeexUploadCore", "pushWork");
        this.fBz.mo39163e(c23499a);
        AppMethodBeat.m2505o(116561);
    }

    public final void start() {
        AppMethodBeat.m2504i(116562);
        if (C5023at.isWifi(C4996ah.getContext())) {
            new C7306ak(Looper.getMainLooper()).postDelayed(new C90792(), 100);
            AppMethodBeat.m2505o(116562);
            return;
        }
        AppMethodBeat.m2505o(116562);
    }

    /* renamed from: cB */
    private static C5728b m16460cB(int i, int i2) {
        AppMethodBeat.m2504i(116563);
        C5728b c5728b = new C5728b(C32334b.ajO());
        if (c5728b.exists() && c5728b.isDirectory()) {
            C5728b[] dMF = c5728b.dMF();
            int i3 = 0;
            c5728b = null;
            while (dMF != null && i3 < dMF.length) {
                c5728b = dMF[i3];
                if (c5728b != null && c5728b.isFile()) {
                    C4990ab.m7410d("MicroMsg.SpeexUploadCore", "file " + C5736j.m8649w(c5728b.mUri));
                    String w = C5736j.m8649w(c5728b.mUri);
                    long length = c5728b.length();
                    if (c5728b.getName().endsWith(".spx")) {
                        if (length >= ((long) i) && length <= ((long) i2)) {
                            break;
                        }
                        C4990ab.m7411d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", w, Integer.valueOf(i), Integer.valueOf(i2));
                        C5730e.deleteFile(w);
                        c5728b = null;
                    } else {
                        c5728b = null;
                    }
                }
                i3++;
            }
            AppMethodBeat.m2505o(116563);
            return c5728b;
        }
        AppMethodBeat.m2505o(116563);
        return null;
    }
}
