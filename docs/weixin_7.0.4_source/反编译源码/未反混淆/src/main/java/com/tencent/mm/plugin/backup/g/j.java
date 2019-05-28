package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Queue;

public final class j {
    private static int jxV = 60000;
    private a jtM;
    long jxW = 0;
    long jxX;
    long jxY;
    long jxZ;
    long jya;
    int jyb = 0;
    Queue<Long> jyc = new LinkedList();
    ap jyd = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(17676);
            long gb = bo.gb(j.this.jxZ);
            if (gb != 0) {
                j.this.jxX = (j.this.jxY / gb) * 1000;
                j.this.jyc.offer(Long.valueOf(j.this.jxX));
                try {
                    gb = ((Long) j.this.jyc.poll()).longValue();
                } catch (Exception e) {
                    gb = 0;
                }
                j.this.jxX = (((j.this.jxW * 10) - gb) + j.this.jxX) / 10;
                j.this.jxX = j.this.jxX > 0 ? j.this.jxX : 0;
                j.this.jxW = j.this.jxX;
                j.this.jxY = 0;
                j.this.jxZ = bo.anU();
                j.this.jtM.aTn();
                if (j.this.jxX >= 102400) {
                    if (j.this.jyb != 0) {
                        j.this.jyb = 0;
                        j.this.jya = 0;
                        j.this.jtM.ro(0);
                        ab.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
                    }
                } else if (j.this.jxX < 2) {
                    if (j.this.jyb == 0) {
                        j.this.jyb = 1;
                        j.this.jtM.ro(1);
                        j.this.jya = bo.anU();
                        ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", Long.valueOf(j.this.jya));
                    } else if (j.this.jyb == 1) {
                        if (j.this.jya <= 0) {
                            j.this.jya = bo.anU();
                            ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", Long.valueOf(j.this.jya));
                        } else if (bo.gb(j.this.jya) > ((long) j.jxV)) {
                            ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", Long.valueOf(bo.gb(j.this.jya)));
                            j.this.jyb = 2;
                            j.this.jtM.aTo();
                            j.this.jya = 0;
                            AppMethodBeat.o(17676);
                            return false;
                        }
                    }
                } else if (j.this.jyb != 1) {
                    j.this.jyb = 1;
                    j.this.jtM.ro(1);
                    ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
                }
            }
            AppMethodBeat.o(17676);
            return true;
        }
    }, true);

    public interface a {
        void aTn();

        void aTo();

        void ro(int i);
    }

    public j(a aVar) {
        AppMethodBeat.i(17677);
        this.jtM = aVar;
        AppMethodBeat.o(17677);
    }

    static String gz(long j) {
        AppMethodBeat.i(17678);
        String c;
        if ((j >> 30) > 0) {
            c = bo.c(j, 100.0d);
            AppMethodBeat.o(17678);
            return c;
        } else if ((j >> 20) > 0) {
            c = bo.b(j, 100.0d);
            AppMethodBeat.o(17678);
            return c;
        } else if ((j >> 9) > 0) {
            c = Math.round(((float) j) / 1024.0f) + " KB";
            AppMethodBeat.o(17678);
            return c;
        } else {
            c = j + " B";
            AppMethodBeat.o(17678);
            return c;
        }
    }
}
