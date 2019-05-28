package com.tencent.p177mm.plugin.backup.p920g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p921i.C27493e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.backup.g.f */
public final class C42774f {
    public static int jxA = 5000;
    public static int jxz = Downloads.MIN_WAIT_FOR_NETWORK;
    private int jxB = 0;
    private long jxC = 0;
    private long jxD = 0;
    private boolean jxE = false;
    private Boolean jxF = null;

    /* renamed from: com.tencent.mm.plugin.backup.g.f$1 */
    class C274891 implements Runnable {
        C274891() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17661);
            while (!C42774f.this.jxF.booleanValue()) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                if (C42774f.this.jxF.booleanValue()) {
                    C4990ab.m7412e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                    AppMethodBeat.m2505o(17661);
                    return;
                }
                long gb = C5046bo.m7566gb(C42774f.this.jxC);
                C4990ab.m7411d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", Integer.valueOf(C42774f.this.jxB), Long.valueOf(C42774f.this.jxC), Long.valueOf(gb), Boolean.valueOf(C42774f.this.jxE));
                if (C42774f.this.jxE) {
                    if (gb >= ((long) C42774f.jxA)) {
                        if (C42774f.this.jxB != 1) {
                            C4990ab.m7413e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(C42774f.this.jxC), Long.valueOf(gb));
                            C42774f.this.jxB = 1;
                        }
                        C42774f.this.stop();
                        AppMethodBeat.m2505o(17661);
                        return;
                    }
                } else if (gb < ((long) C42774f.jxz)) {
                    C42774f.this.jxB = 0;
                } else {
                    C4990ab.m7413e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(C42774f.this.jxC), Long.valueOf(gb));
                    C42774f.this.aUm();
                    C42774f.this.aUl();
                    C42774f.this.jxE = true;
                }
            }
            AppMethodBeat.m2505o(17661);
        }
    }

    public final void aUl() {
        AppMethodBeat.m2504i(17662);
        this.jxC = C5046bo.anU();
        C4990ab.m7411d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", Long.valueOf(this.jxC));
        this.jxE = false;
        if (this.jxB != 0) {
            this.jxB = 0;
            mo68246cg(false);
        }
        AppMethodBeat.m2505o(17662);
    }

    public final void aUm() {
        AppMethodBeat.m2504i(17663);
        this.jxD = this.jxD == Long.MAX_VALUE ? 0 : this.jxD + 1;
        C27493e c27493e = new C27493e();
        c27493e.jxD = this.jxD;
        try {
            C4990ab.m7417i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", Long.valueOf(c27493e.jxD));
            C19978b.m30877K(c27493e.toByteArray(), 9);
            AppMethodBeat.m2505o(17663);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", e, "buf to BackupHeartBeatRequest err.", new Object[0]);
            AppMethodBeat.m2505o(17663);
        }
    }

    public final void stop() {
        AppMethodBeat.m2504i(17664);
        if (this.jxF != null) {
            C4990ab.m7416i("MicroMsg.BackupHeartBeatHandler", "stop");
            this.jxF = Boolean.TRUE;
        }
        AppMethodBeat.m2505o(17664);
    }

    /* renamed from: cg */
    public final void mo68246cg(boolean z) {
        AppMethodBeat.m2504i(17665);
        if (z) {
            Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", this.jxF == null);
        }
        C4990ab.m7416i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
        aUl();
        this.jxF = Boolean.FALSE;
        C7305d.m12301h(new C274891(), "BackupSendBackupHeartBeat").start();
        aUm();
        AppMethodBeat.m2505o(17665);
    }
}
