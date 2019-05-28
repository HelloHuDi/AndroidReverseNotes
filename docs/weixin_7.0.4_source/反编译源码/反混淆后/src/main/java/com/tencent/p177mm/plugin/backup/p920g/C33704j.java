package com.tencent.p177mm.plugin.backup.p920g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.backup.g.j */
public final class C33704j {
    private static int jxV = 60000;
    private C33705a jtM;
    long jxW = 0;
    long jxX;
    long jxY;
    long jxZ;
    long jya;
    int jyb = 0;
    Queue<Long> jyc = new LinkedList();
    C7564ap jyd = new C7564ap(Looper.getMainLooper(), new C274901(), true);

    /* renamed from: com.tencent.mm.plugin.backup.g.j$1 */
    class C274901 implements C5015a {
        C274901() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(17676);
            long gb = C5046bo.m7566gb(C33704j.this.jxZ);
            if (gb != 0) {
                C33704j.this.jxX = (C33704j.this.jxY / gb) * 1000;
                C33704j.this.jyc.offer(Long.valueOf(C33704j.this.jxX));
                try {
                    gb = ((Long) C33704j.this.jyc.poll()).longValue();
                } catch (Exception e) {
                    gb = 0;
                }
                C33704j.this.jxX = (((C33704j.this.jxW * 10) - gb) + C33704j.this.jxX) / 10;
                C33704j.this.jxX = C33704j.this.jxX > 0 ? C33704j.this.jxX : 0;
                C33704j.this.jxW = C33704j.this.jxX;
                C33704j.this.jxY = 0;
                C33704j.this.jxZ = C5046bo.anU();
                C33704j.this.jtM.aTn();
                if (C33704j.this.jxX >= 102400) {
                    if (C33704j.this.jyb != 0) {
                        C33704j.this.jyb = 0;
                        C33704j.this.jya = 0;
                        C33704j.this.jtM.mo15077ro(0);
                        C4990ab.m7416i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
                    }
                } else if (C33704j.this.jxX < 2) {
                    if (C33704j.this.jyb == 0) {
                        C33704j.this.jyb = 1;
                        C33704j.this.jtM.mo15077ro(1);
                        C33704j.this.jya = C5046bo.anU();
                        C4990ab.m7413e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", Long.valueOf(C33704j.this.jya));
                    } else if (C33704j.this.jyb == 1) {
                        if (C33704j.this.jya <= 0) {
                            C33704j.this.jya = C5046bo.anU();
                            C4990ab.m7413e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", Long.valueOf(C33704j.this.jya));
                        } else if (C5046bo.m7566gb(C33704j.this.jya) > ((long) C33704j.jxV)) {
                            C4990ab.m7413e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", Long.valueOf(C5046bo.m7566gb(C33704j.this.jya)));
                            C33704j.this.jyb = 2;
                            C33704j.this.jtM.aTo();
                            C33704j.this.jya = 0;
                            AppMethodBeat.m2505o(17676);
                            return false;
                        }
                    }
                } else if (C33704j.this.jyb != 1) {
                    C33704j.this.jyb = 1;
                    C33704j.this.jtM.mo15077ro(1);
                    C4990ab.m7412e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
                }
            }
            AppMethodBeat.m2505o(17676);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.j$a */
    public interface C33705a {
        void aTn();

        void aTo();

        /* renamed from: ro */
        void mo15077ro(int i);
    }

    public C33704j(C33705a c33705a) {
        AppMethodBeat.m2504i(17677);
        this.jtM = c33705a;
        AppMethodBeat.m2505o(17677);
    }

    /* renamed from: gz */
    static String m55084gz(long j) {
        AppMethodBeat.m2504i(17678);
        String c;
        if ((j >> 30) > 0) {
            c = C5046bo.m7535c(j, 100.0d);
            AppMethodBeat.m2505o(17678);
            return c;
        } else if ((j >> 20) > 0) {
            c = C5046bo.m7526b(j, 100.0d);
            AppMethodBeat.m2505o(17678);
            return c;
        } else if ((j >> 9) > 0) {
            c = Math.round(((float) j) / 1024.0f) + " KB";
            AppMethodBeat.m2505o(17678);
            return c;
        } else {
            c = j + " B";
            AppMethodBeat.m2505o(17678);
            return c;
        }
    }
}
