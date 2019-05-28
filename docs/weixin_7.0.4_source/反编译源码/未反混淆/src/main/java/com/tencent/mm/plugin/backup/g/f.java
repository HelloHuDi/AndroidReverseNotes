package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import junit.framework.Assert;

public final class f {
    public static int jxA = 5000;
    public static int jxz = Downloads.MIN_WAIT_FOR_NETWORK;
    private int jxB = 0;
    private long jxC = 0;
    private long jxD = 0;
    private boolean jxE = false;
    private Boolean jxF = null;

    public final void aUl() {
        AppMethodBeat.i(17662);
        this.jxC = bo.anU();
        ab.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", Long.valueOf(this.jxC));
        this.jxE = false;
        if (this.jxB != 0) {
            this.jxB = 0;
            cg(false);
        }
        AppMethodBeat.o(17662);
    }

    public final void aUm() {
        AppMethodBeat.i(17663);
        this.jxD = this.jxD == Long.MAX_VALUE ? 0 : this.jxD + 1;
        e eVar = new e();
        eVar.jxD = this.jxD;
        try {
            ab.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", Long.valueOf(eVar.jxD));
            b.K(eVar.toByteArray(), 9);
            AppMethodBeat.o(17663);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", e, "buf to BackupHeartBeatRequest err.", new Object[0]);
            AppMethodBeat.o(17663);
        }
    }

    public final void stop() {
        AppMethodBeat.i(17664);
        if (this.jxF != null) {
            ab.i("MicroMsg.BackupHeartBeatHandler", "stop");
            this.jxF = Boolean.TRUE;
        }
        AppMethodBeat.o(17664);
    }

    public final void cg(boolean z) {
        AppMethodBeat.i(17665);
        if (z) {
            Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", this.jxF == null);
        }
        ab.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
        aUl();
        this.jxF = Boolean.FALSE;
        d.h(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17661);
                while (!f.this.jxF.booleanValue()) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    if (f.this.jxF.booleanValue()) {
                        ab.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                        AppMethodBeat.o(17661);
                        return;
                    }
                    long gb = bo.gb(f.this.jxC);
                    ab.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", Integer.valueOf(f.this.jxB), Long.valueOf(f.this.jxC), Long.valueOf(gb), Boolean.valueOf(f.this.jxE));
                    if (f.this.jxE) {
                        if (gb >= ((long) f.jxA)) {
                            if (f.this.jxB != 1) {
                                ab.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(f.this.jxC), Long.valueOf(gb));
                                f.this.jxB = 1;
                            }
                            f.this.stop();
                            AppMethodBeat.o(17661);
                            return;
                        }
                    } else if (gb < ((long) f.jxz)) {
                        f.this.jxB = 0;
                    } else {
                        ab.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(f.this.jxC), Long.valueOf(gb));
                        f.this.aUm();
                        f.this.aUl();
                        f.this.jxE = true;
                    }
                }
                AppMethodBeat.o(17661);
            }
        }, "BackupSendBackupHeartBeat").start();
        aUm();
        AppMethodBeat.o(17665);
    }
}
