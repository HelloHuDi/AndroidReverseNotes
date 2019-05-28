package com.tencent.mm.an;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class a {
    private static boolean active = false;
    private static final c fAg = new c();
    private static boolean fAh = true;
    private static long fAi = 0;
    private static long fAj = 0;
    private static Thread thread = null;

    public static class a implements Comparable<a> {
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
            a aVar = (a) obj;
            if (this.fAk == 0 || aVar.fAk == 0) {
                return (int) (this.startTime - aVar.startTime);
            }
            return (int) (this.fAk - aVar.fAk);
        }

        public final String toString() {
            AppMethodBeat.i(58327);
            StringBuilder stringBuilder = new StringBuilder();
            switch (this.type) {
                case 0:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[]{a.fF(this.fAk), a.fF(this.startTime), a.fF(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.fAm)}));
                    break;
                case 1:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[]{a.fF(this.fAk), a.fF(this.startTime), a.fF(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.fAl), Boolean.valueOf(this.fAm)}));
                    break;
                case 2:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[]{a.fF(this.fAk), a.fF(this.startTime), a.fF(this.endTime), Integer.valueOf(this.fAo)}));
                    break;
                case 3:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[]{a.fF(this.fAk), a.fF(this.startTime), a.fF(this.endTime), Integer.valueOf(this.fAo)}));
                    break;
                case 4:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s", new Object[]{a.fF(this.fAk), a.fF(this.startTime), a.fF(this.endTime), Integer.valueOf(this.pid), a.fF(this.fAp), Long.valueOf(this.fAq), Long.valueOf(this.fAr)}));
                    break;
            }
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(58327);
            return stringBuilder2;
        }
    }

    static {
        AppMethodBeat.i(58336);
        AppMethodBeat.o(58336);
    }

    public static boolean isActive() {
        return active;
    }

    public static final void cL(boolean z) {
        AppMethodBeat.i(58328);
        boolean z2 = !ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).getBoolean("msg_delay_close_detect", false);
        fAh = z2;
        if (z2) {
            active = z;
            if (z) {
                ab.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
                if (thread != null) {
                    thread.interrupt();
                }
                ab.i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", Long.valueOf(System.currentTimeMillis()));
                thread = null;
                fAg.clear();
                ab.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", Long.valueOf(System.currentTimeMillis()));
                fAi = cb.aaD();
                AppMethodBeat.o(58328);
                return;
            }
            ab.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
            if (thread == null) {
                Thread h = d.h(fAg, "ProcessDetector_" + Process.myPid());
                thread = h;
                h.start();
                fAg.fAA = true;
            }
            fAj = cb.aaD();
            AppMethodBeat.o(58328);
            return;
        }
        AppMethodBeat.o(58328);
    }

    public static boolean fE(long j) {
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

    public static void ll(int i) {
        AppMethodBeat.i(58329);
        if (!fAh) {
            AppMethodBeat.o(58329);
        } else if (active) {
            AppMethodBeat.o(58329);
        } else {
            c cVar = fAg;
            cVar.fAu.fAC.add(new a(cb.aaD(), System.currentTimeMillis(), i));
            AppMethodBeat.o(58329);
        }
    }

    public static void lm(int i) {
        AppMethodBeat.i(58330);
        if (!fAh) {
            AppMethodBeat.o(58330);
        } else if (active) {
            AppMethodBeat.o(58330);
        } else {
            c cVar = fAg;
            cVar.fAu.fAD.add(new a(cb.aaD(), System.currentTimeMillis(), i));
            AppMethodBeat.o(58330);
        }
    }

    public static void a(long j, long j2, long j3, long j4, long j5) {
        AppMethodBeat.i(58331);
        if (fAh) {
            c cVar = fAg;
            ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]delayed msg[%s]", new c(Process.myPid(), j, j2, j3, j4, j5).toString());
            cVar.fAu.fAE.add(r0);
            AppMethodBeat.o(58331);
            return;
        }
        AppMethodBeat.o(58331);
    }

    public static void ln(int i) {
        fAg.fAs = i;
    }

    public static List<a> afS() {
        AppMethodBeat.i(58332);
        if (ah.bqo()) {
            b bVar;
            b bVar2;
            a a;
            String str = fAg.fAy;
            String str2 = str + "/mm";
            String str3 = str + "/push";
            try {
                bVar = (b) b.x(new FileInputStream(str2));
            } catch (Exception e) {
                ab.e("MicroMsg.ActiveDetector", "%s,read exception:" + e.getMessage(), str2);
                bVar = null;
            }
            try {
                bVar2 = (b) b.x(new FileInputStream(str3));
            } catch (Exception e2) {
                ab.e("MicroMsg.ActiveDetector", "%s,read exception:" + e2.getMessage(), str3);
                bVar2 = null;
            }
            ArrayList arrayList = new ArrayList();
            if (bVar != null) {
                for (c.d a2 : bVar.fAB) {
                    a = a(a2, 0);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                for (a a3 : bVar.fAD) {
                    a = a(a3, 3);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                for (c cVar : bVar.fAE) {
                    Object obj;
                    if (cVar == null) {
                        obj = null;
                    } else {
                        a aVar = new a();
                        aVar.pid = cVar.pid;
                        aVar.fAk = cVar.fAk;
                        aVar.startTime = cVar.fAF;
                        aVar.endTime = cVar.fAF;
                        aVar.type = 4;
                        aVar.fAp = cVar.fAp;
                        aVar.fAq = cVar.fAq;
                        aVar.fAr = cVar.fAr;
                        a = aVar;
                    }
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
            }
            if (bVar2 != null) {
                for (c.d a22 : bVar2.fAB) {
                    a = a(a22, 1);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                for (a a32 : bVar2.fAC) {
                    a = a(a32, 2);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            }
            Collections.sort(arrayList);
            AppMethodBeat.o(58332);
            return arrayList;
        }
        AppMethodBeat.o(58332);
        return null;
    }

    static String fF(long j) {
        AppMethodBeat.i(58333);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
        AppMethodBeat.o(58333);
        return format;
    }

    private static a a(c.d dVar, int i) {
        AppMethodBeat.i(58334);
        if (dVar == null) {
            AppMethodBeat.o(58334);
            return null;
        }
        a aVar = new a();
        aVar.fAk = dVar.fAG;
        aVar.startTime = dVar.startTime;
        aVar.endTime = dVar.endTime;
        aVar.type = i;
        aVar.pid = dVar.pid;
        aVar.fAm = dVar.fAm;
        if (i == 1) {
            aVar.fAl = dVar.fAl;
            aVar.fAn = dVar.fAn;
        }
        AppMethodBeat.o(58334);
        return aVar;
    }

    private static a a(a aVar, int i) {
        AppMethodBeat.i(58335);
        if (aVar == null) {
            AppMethodBeat.o(58335);
            return null;
        }
        a aVar2 = new a();
        aVar2.fAk = aVar.fAk;
        aVar2.startTime = aVar.time;
        aVar2.endTime = aVar.time;
        aVar2.type = i;
        aVar2.fAo = aVar.type;
        AppMethodBeat.o(58335);
        return aVar2;
    }
}
