package com.tencent.p177mm.p188an;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p188an.C41755c.C1240d;
import com.tencent.p177mm.p188an.C41755c.C41756a;
import com.tencent.p177mm.p188an.C41755c.C8952b;
import com.tencent.p177mm.p188an.C41755c.C8953c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.mm.an.a */
public final class C41753a {
    private static boolean active = false;
    private static final C41755c fAg = new C41755c();
    private static boolean fAh = true;
    private static long fAi = 0;
    private static long fAj = 0;
    private static Thread thread = null;

    /* renamed from: com.tencent.mm.an.a$a */
    public static class C1239a implements Comparable<C1239a> {
        public long endTime = 0;
        public long fAk = 0;
        public int fAl = 0;
        public boolean fAm = true;
        public boolean fAn = false;
        public int fAo = 0;
        public long fAp = 0;
        public long fAq = 0;
        public long fAr = 0;
        public int pid = 0;
        public long startTime = 0;
        public int type = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            C1239a c1239a = (C1239a) obj;
            if (this.fAk == 0 || c1239a.fAk == 0) {
                return (int) (this.startTime - c1239a.startTime);
            }
            return (int) (this.fAk - c1239a.fAk);
        }

        public final String toString() {
            AppMethodBeat.m2504i(58327);
            StringBuilder stringBuilder = new StringBuilder();
            switch (this.type) {
                case 0:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[]{C41753a.m73605fF(this.fAk), C41753a.m73605fF(this.startTime), C41753a.m73605fF(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.fAm)}));
                    break;
                case 1:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[]{C41753a.m73605fF(this.fAk), C41753a.m73605fF(this.startTime), C41753a.m73605fF(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.fAl), Boolean.valueOf(this.fAm)}));
                    break;
                case 2:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[]{C41753a.m73605fF(this.fAk), C41753a.m73605fF(this.startTime), C41753a.m73605fF(this.endTime), Integer.valueOf(this.fAo)}));
                    break;
                case 3:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[]{C41753a.m73605fF(this.fAk), C41753a.m73605fF(this.startTime), C41753a.m73605fF(this.endTime), Integer.valueOf(this.fAo)}));
                    break;
                case 4:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s", new Object[]{C41753a.m73605fF(this.fAk), C41753a.m73605fF(this.startTime), C41753a.m73605fF(this.endTime), Integer.valueOf(this.pid), C41753a.m73605fF(this.fAp), Long.valueOf(this.fAq), Long.valueOf(this.fAr)}));
                    break;
            }
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(58327);
            return stringBuilder2;
        }
    }

    static {
        AppMethodBeat.m2504i(58336);
        AppMethodBeat.m2505o(58336);
    }

    public static boolean isActive() {
        return active;
    }

    /* renamed from: cL */
    public static final void m73603cL(boolean z) {
        AppMethodBeat.m2504i(58328);
        boolean z2 = !C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getBoolean("msg_delay_close_detect", false);
        fAh = z2;
        if (z2) {
            active = z;
            if (z) {
                C4990ab.m7417i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
                if (thread != null) {
                    thread.interrupt();
                }
                C4990ab.m7417i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", Long.valueOf(System.currentTimeMillis()));
                thread = null;
                fAg.clear();
                C4990ab.m7417i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", Long.valueOf(System.currentTimeMillis()));
                fAi = C1839cb.aaD();
                AppMethodBeat.m2505o(58328);
                return;
            }
            C4990ab.m7417i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
            if (thread == null) {
                Thread h = C7305d.m12301h(fAg, "ProcessDetector_" + Process.myPid());
                thread = h;
                h.start();
                fAg.fAA = true;
            }
            fAj = C1839cb.aaD();
            AppMethodBeat.m2505o(58328);
            return;
        }
        AppMethodBeat.m2505o(58328);
    }

    /* renamed from: fE */
    public static boolean m73604fE(long j) {
        if (fAi <= 0 || fAj <= 0 || j <= 0) {
            return false;
        }
        if (fAi >= fAj) {
            if (j < fAi) {
                return false;
            }
            return true;
        } else if (j >= fAj) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: ll */
    public static void m73606ll(int i) {
        AppMethodBeat.m2504i(58329);
        if (!fAh) {
            AppMethodBeat.m2505o(58329);
        } else if (active) {
            AppMethodBeat.m2505o(58329);
        } else {
            C41755c c41755c = fAg;
            c41755c.fAu.fAC.add(new C41756a(C1839cb.aaD(), System.currentTimeMillis(), i));
            AppMethodBeat.m2505o(58329);
        }
    }

    /* renamed from: lm */
    public static void m73607lm(int i) {
        AppMethodBeat.m2504i(58330);
        if (!fAh) {
            AppMethodBeat.m2505o(58330);
        } else if (active) {
            AppMethodBeat.m2505o(58330);
        } else {
            C41755c c41755c = fAg;
            c41755c.fAu.fAD.add(new C41756a(C1839cb.aaD(), System.currentTimeMillis(), i));
            AppMethodBeat.m2505o(58330);
        }
    }

    /* renamed from: a */
    public static void m73602a(long j, long j2, long j3, long j4, long j5) {
        AppMethodBeat.m2504i(58331);
        if (fAh) {
            C41755c c41755c = fAg;
            C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]delayed msg[%s]", new C8953c(Process.myPid(), j, j2, j3, j4, j5).toString());
            c41755c.fAu.fAE.add(r0);
            AppMethodBeat.m2505o(58331);
            return;
        }
        AppMethodBeat.m2505o(58331);
    }

    /* renamed from: ln */
    public static void m73608ln(int i) {
        fAg.fAs = i;
    }

    public static List<C1239a> afS() {
        AppMethodBeat.m2504i(58332);
        if (C4996ah.bqo()) {
            C8952b c8952b;
            C8952b c8952b2;
            C1239a a;
            String str = fAg.fAy;
            String str2 = str + "/mm";
            String str3 = str + "/push";
            try {
                c8952b = (C8952b) C41754b.m73609x(new FileInputStream(str2));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ActiveDetector", "%s,read exception:" + e.getMessage(), str2);
                c8952b = null;
            }
            try {
                c8952b2 = (C8952b) C41754b.m73609x(new FileInputStream(str3));
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.ActiveDetector", "%s,read exception:" + e2.getMessage(), str3);
                c8952b2 = null;
            }
            ArrayList arrayList = new ArrayList();
            if (c8952b != null) {
                for (C1240d a2 : c8952b.fAB) {
                    a = C41753a.m73601a(a2, 0);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                for (C41756a a3 : c8952b.fAD) {
                    a = C41753a.m73600a(a3, 3);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                for (C8953c c8953c : c8952b.fAE) {
                    Object obj;
                    if (c8953c == null) {
                        obj = null;
                    } else {
                        C1239a c1239a = new C1239a();
                        c1239a.pid = c8953c.pid;
                        c1239a.fAk = c8953c.fAk;
                        c1239a.startTime = c8953c.fAF;
                        c1239a.endTime = c8953c.fAF;
                        c1239a.type = 4;
                        c1239a.fAp = c8953c.fAp;
                        c1239a.fAq = c8953c.fAq;
                        c1239a.fAr = c8953c.fAr;
                        a = c1239a;
                    }
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
            }
            if (c8952b2 != null) {
                for (C1240d a22 : c8952b2.fAB) {
                    a = C41753a.m73601a(a22, 1);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                for (C41756a a32 : c8952b2.fAC) {
                    a = C41753a.m73600a(a32, 2);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            }
            Collections.sort(arrayList);
            AppMethodBeat.m2505o(58332);
            return arrayList;
        }
        AppMethodBeat.m2505o(58332);
        return null;
    }

    /* renamed from: fF */
    static String m73605fF(long j) {
        AppMethodBeat.m2504i(58333);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
        AppMethodBeat.m2505o(58333);
        return format;
    }

    /* renamed from: a */
    private static C1239a m73601a(C1240d c1240d, int i) {
        AppMethodBeat.m2504i(58334);
        if (c1240d == null) {
            AppMethodBeat.m2505o(58334);
            return null;
        }
        C1239a c1239a = new C1239a();
        c1239a.fAk = c1240d.fAG;
        c1239a.startTime = c1240d.startTime;
        c1239a.endTime = c1240d.endTime;
        c1239a.type = i;
        c1239a.pid = c1240d.pid;
        c1239a.fAm = c1240d.fAm;
        if (i == 1) {
            c1239a.fAl = c1240d.fAl;
            c1239a.fAn = c1240d.fAn;
        }
        AppMethodBeat.m2505o(58334);
        return c1239a;
    }

    /* renamed from: a */
    private static C1239a m73600a(C41756a c41756a, int i) {
        AppMethodBeat.m2504i(58335);
        if (c41756a == null) {
            AppMethodBeat.m2505o(58335);
            return null;
        }
        C1239a c1239a = new C1239a();
        c1239a.fAk = c41756a.fAk;
        c1239a.startTime = c41756a.time;
        c1239a.endTime = c41756a.time;
        c1239a.type = i;
        c1239a.fAo = c41756a.type;
        AppMethodBeat.m2505o(58335);
        return c1239a;
    }
}
