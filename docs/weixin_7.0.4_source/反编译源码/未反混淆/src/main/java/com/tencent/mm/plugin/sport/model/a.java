package com.tencent.mm.plugin.sport.model;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import java.util.Calendar;

public final class a {
    public c rPa;
    public c<sd> rPb = new c<sd>() {
        {
            AppMethodBeat.i(93627);
            this.xxI = sd.class.getName().hashCode();
            AppMethodBeat.o(93627);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(93628);
            sd sdVar = (sd) bVar;
            long cwf;
            boolean kQ;
            switch (sdVar.cOe.action) {
                case 1:
                case 2:
                case 3:
                    h.cws();
                    if (a.cwh()) {
                        a.this.rPa.cwj();
                        cwf = a.cwf();
                        if (sdVar.cOe.action == 1) {
                            kQ = a.this.kQ(cwf);
                        } else if (n.Z(a.this.cwe(), cwf)) {
                            kQ = a.this.kQ(cwf);
                        } else {
                            kQ = false;
                        }
                        ab.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", Integer.valueOf(sdVar.cOe.action), Long.valueOf(cwf), Boolean.valueOf(kQ));
                        break;
                    }
                    break;
                case 4:
                case 5:
                    h.cws();
                    if (a.cwh()) {
                        cwf = a.cwf();
                        a aVar = a.this;
                        if (aVar.rPe == 0) {
                            aVar.rPe = k.aa(3, 0);
                        }
                        boolean Y = n.Y(aVar.rPe, System.currentTimeMillis());
                        if (n.Z(a.this.cwe(), cwf) || Y) {
                            kQ = a.this.kQ(cwf);
                        } else {
                            kQ = false;
                        }
                        ab.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", Integer.valueOf(sdVar.cOe.action), Long.valueOf(cwf), Boolean.valueOf(kQ), Boolean.valueOf(Y), Boolean.valueOf(r5));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(93628);
            return false;
        }
    };
    public f rPc;
    private long rPd;
    long rPe;

    public a() {
        AppMethodBeat.i(93631);
        this.rPb.dnU();
        this.rPa = new c();
        AppMethodBeat.o(93631);
    }

    public final void cwd() {
        AppMethodBeat.i(93632);
        ab.i("MicroMsg.Sport.DeviceStepManager", "forceUploadDeviceStep %d", Long.valueOf(cwf()));
        kQ(r0);
        AppMethodBeat.o(93632);
    }

    /* Access modifiers changed, original: final */
    public final boolean kQ(long j) {
        AppMethodBeat.i(93633);
        if (this.rPc != null) {
            g.Rg().c(this.rPc);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        ab.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", n.fQ(System.currentTimeMillis()), Long.valueOf(j));
        this.rPc = new f("", "gh_43f2581f6fd6", (int) (timeInMillis / 1000), (int) (r6 / 1000), (int) j, bs.dut(), 1);
        g.Rg().a(this.rPc, 0);
        kS(System.currentTimeMillis());
        kR(j);
        AppMethodBeat.o(93633);
        return true;
    }

    public final long cwe() {
        AppMethodBeat.i(93634);
        if (this.rPd == 0) {
            this.rPd = k.aa(4, 0);
        }
        long j = this.rPd;
        AppMethodBeat.o(93634);
        return j;
    }

    private void kR(long j) {
        AppMethodBeat.i(93635);
        this.rPd = j;
        k.ab(4, this.rPd);
        AppMethodBeat.o(93635);
    }

    private void kS(long j) {
        AppMethodBeat.i(93636);
        this.rPe = j;
        k.ab(3, j);
        AppMethodBeat.o(93636);
    }

    public static long cwf() {
        AppMethodBeat.i(93637);
        long cwg = cwg();
        if (com.tencent.mm.sdk.h.b.dqw()) {
            boolean a;
            try {
                a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_sport_brand_api_flag, true);
            } catch (Exception e) {
                a = true;
            }
            if (a) {
                long cwH = (long) n.cwH();
                if (cwH > cwg) {
                    ab.i("MicroMsg.Sport.DeviceStepManager", "getTodayStep MIUI Step %d %d", Long.valueOf(cwH), Long.valueOf(cwg));
                    AppMethodBeat.o(93637);
                    return cwH;
                }
            }
        }
        AppMethodBeat.o(93637);
        return cwg;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053 A:{SYNTHETIC, Splitter:B:12:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053 A:{SYNTHETIC, Splitter:B:12:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053 A:{SYNTHETIC, Splitter:B:12:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long cwg() {
        long j;
        String str;
        long j2;
        Throwable th;
        AppMethodBeat.i(93638);
        long currentTimeMillis = System.currentTimeMillis();
        long cwC = n.cwC();
        Cursor cursor = null;
        Cursor query;
        try {
            query = ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "getTodayStepCount", null, null);
            if (query != null) {
                try {
                    Bundle extras = query.getExtras();
                    j = extras.getLong("TodayStep", -1);
                    if (extras.getLong("TodaySaveTime", 0) == cwC) {
                        str = "push";
                    } else {
                        j = -1;
                        str = "unknown";
                    }
                } catch (Exception e) {
                    j = -1;
                    str = "unknown";
                    if (query != null) {
                        query.close();
                        j2 = -1;
                        if (j2 == -1) {
                        }
                        ab.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(93638);
                        return j2;
                    }
                    j2 = j;
                    if (j2 == -1) {
                    }
                    ab.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(93638);
                    return j2;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.o(93638);
                    throw th;
                }
            }
            j = -1;
            str = "unknown";
            if (query != null) {
                query.close();
                j2 = j;
                if (j2 == -1) {
                    try {
                        String cwy = k.cwy();
                        if (bo.isNullOrNil(cwy)) {
                            str = "unknown";
                            j2 = 0;
                        } else {
                            long[] ZV = n.ZV(cwy);
                            long j3 = ZV[0];
                            j2 = ZV[5];
                            if (j3 == cwC) {
                                str = "mm";
                            } else {
                                str = "unknown";
                                j2 = 0;
                            }
                        }
                    } catch (Exception e2) {
                        str = "unknown";
                        j2 = 0;
                    }
                }
                ab.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(93638);
                return j2;
            }
        } catch (Exception e3) {
            query = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            AppMethodBeat.o(93638);
            throw th;
        }
        j2 = j;
        if (j2 == -1) {
        }
        ab.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(93638);
        return j2;
    }

    public final void ZR(final String str) {
        AppMethodBeat.i(93639);
        d.xDG.b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(93629);
                try {
                    ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "updateConfig", new String[]{str}, null);
                    AppMethodBeat.o(93629);
                } catch (Exception e) {
                    AppMethodBeat.o(93629);
                }
            }
        }, "Sport.updateConfigToPush");
        AppMethodBeat.o(93639);
    }

    static /* synthetic */ boolean cwh() {
        AppMethodBeat.i(93640);
        if (n.eU(ah.getContext()) && n.cvY()) {
            AppMethodBeat.o(93640);
            return true;
        }
        AppMethodBeat.o(93640);
        return false;
    }
}
