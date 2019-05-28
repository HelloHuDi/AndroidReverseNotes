package com.tencent.p177mm.plugin.sport.model;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C6546sd;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7574bs;
import java.util.Calendar;

/* renamed from: com.tencent.mm.plugin.sport.model.a */
public final class C46267a {
    public C43620c rPa;
    public C4884c<C6546sd> rPb = new C292611();
    public C35161f rPc;
    private long rPd;
    long rPe;

    /* renamed from: com.tencent.mm.plugin.sport.model.a$1 */
    class C292611 extends C4884c<C6546sd> {
        C292611() {
            AppMethodBeat.m2504i(93627);
            this.xxI = C6546sd.class.getName().hashCode();
            AppMethodBeat.m2505o(93627);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(93628);
            C6546sd c6546sd = (C6546sd) c4883b;
            long cwf;
            boolean kQ;
            switch (c6546sd.cOe.action) {
                case 1:
                case 2:
                case 3:
                    C22168h.cws();
                    if (C46267a.cwh()) {
                        C46267a.this.rPa.cwj();
                        cwf = C46267a.cwf();
                        if (c6546sd.cOe.action == 1) {
                            kQ = C46267a.this.mo74385kQ(cwf);
                        } else if (C22172n.m33796Z(C46267a.this.cwe(), cwf)) {
                            kQ = C46267a.this.mo74385kQ(cwf);
                        } else {
                            kQ = false;
                        }
                        C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", Integer.valueOf(c6546sd.cOe.action), Long.valueOf(cwf), Boolean.valueOf(kQ));
                        break;
                    }
                    break;
                case 4:
                case 5:
                    C22168h.cws();
                    if (C46267a.cwh()) {
                        cwf = C46267a.cwf();
                        C46267a c46267a = C46267a.this;
                        if (c46267a.rPe == 0) {
                            c46267a.rPe = C43623k.m78065aa(3, 0);
                        }
                        boolean Y = C22172n.m33795Y(c46267a.rPe, System.currentTimeMillis());
                        if (C22172n.m33796Z(C46267a.this.cwe(), cwf) || Y) {
                            kQ = C46267a.this.mo74385kQ(cwf);
                        } else {
                            kQ = false;
                        }
                        C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", Integer.valueOf(c6546sd.cOe.action), Long.valueOf(cwf), Boolean.valueOf(kQ), Boolean.valueOf(Y), Boolean.valueOf(r5));
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(93628);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sport.model.a$3 */
    public class C292623 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(93630);
            try {
                C4996ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "clearConfig", null, null);
                AppMethodBeat.m2505o(93630);
            } catch (Exception e) {
                AppMethodBeat.m2505o(93630);
            }
        }
    }

    public C46267a() {
        AppMethodBeat.m2504i(93631);
        this.rPb.dnU();
        this.rPa = new C43620c();
        AppMethodBeat.m2505o(93631);
    }

    public final void cwd() {
        AppMethodBeat.m2504i(93632);
        C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "forceUploadDeviceStep %d", Long.valueOf(C46267a.cwf()));
        mo74385kQ(r0);
        AppMethodBeat.m2505o(93632);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kQ */
    public final boolean mo74385kQ(long j) {
        AppMethodBeat.m2504i(93633);
        if (this.rPc != null) {
            C1720g.m3540Rg().mo14547c(this.rPc);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", C22172n.m33800fQ(System.currentTimeMillis()), Long.valueOf(j));
        this.rPc = new C35161f("", "gh_43f2581f6fd6", (int) (timeInMillis / 1000), (int) (r6 / 1000), (int) j, C7574bs.dut(), 1);
        C1720g.m3540Rg().mo14541a(this.rPc, 0);
        m86662kS(System.currentTimeMillis());
        m86661kR(j);
        AppMethodBeat.m2505o(93633);
        return true;
    }

    public final long cwe() {
        AppMethodBeat.m2504i(93634);
        if (this.rPd == 0) {
            this.rPd = C43623k.m78065aa(4, 0);
        }
        long j = this.rPd;
        AppMethodBeat.m2505o(93634);
        return j;
    }

    /* renamed from: kR */
    private void m86661kR(long j) {
        AppMethodBeat.m2504i(93635);
        this.rPd = j;
        C43623k.m78066ab(4, this.rPd);
        AppMethodBeat.m2505o(93635);
    }

    /* renamed from: kS */
    private void m86662kS(long j) {
        AppMethodBeat.m2504i(93636);
        this.rPe = j;
        C43623k.m78066ab(3, j);
        AppMethodBeat.m2505o(93636);
    }

    public static long cwf() {
        AppMethodBeat.m2504i(93637);
        long cwg = C46267a.cwg();
        if (C4971b.dqw()) {
            boolean a;
            try {
                a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_weixin_sport_brand_api_flag, true);
            } catch (Exception e) {
                a = true;
            }
            if (a) {
                long cwH = (long) C22172n.cwH();
                if (cwH > cwg) {
                    C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "getTodayStep MIUI Step %d %d", Long.valueOf(cwH), Long.valueOf(cwg));
                    AppMethodBeat.m2505o(93637);
                    return cwH;
                }
            }
        }
        AppMethodBeat.m2505o(93637);
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
        AppMethodBeat.m2504i(93638);
        long currentTimeMillis = System.currentTimeMillis();
        long cwC = C22172n.cwC();
        Cursor cursor = null;
        Cursor query;
        try {
            query = C4996ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "getTodayStepCount", null, null);
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
                        C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(93638);
                        return j2;
                    }
                    j2 = j;
                    if (j2 == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(93638);
                    return j2;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.m2505o(93638);
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
                        String cwy = C43623k.cwy();
                        if (C5046bo.isNullOrNil(cwy)) {
                            str = "unknown";
                            j2 = 0;
                        } else {
                            long[] ZV = C22172n.m33797ZV(cwy);
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
                C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(93638);
                return j2;
            }
        } catch (Exception e3) {
            query = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(93638);
            throw th;
        }
        j2 = j;
        if (j2 == -1) {
        }
        C4990ab.m7417i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(93638);
        return j2;
    }

    /* renamed from: ZR */
    public final void mo74382ZR(final String str) {
        AppMethodBeat.m2504i(93639);
        C7305d.xDG.mo10151b(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(93629);
                try {
                    C4996ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "updateConfig", new String[]{str}, null);
                    AppMethodBeat.m2505o(93629);
                } catch (Exception e) {
                    AppMethodBeat.m2505o(93629);
                }
            }
        }, "Sport.updateConfigToPush");
        AppMethodBeat.m2505o(93639);
    }

    static /* synthetic */ boolean cwh() {
        AppMethodBeat.m2504i(93640);
        if (C22172n.m33799eU(C4996ah.getContext()) && C22172n.cvY()) {
            AppMethodBeat.m2505o(93640);
            return true;
        }
        AppMethodBeat.m2505o(93640);
        return false;
    }
}
