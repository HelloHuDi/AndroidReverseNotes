package com.tencent.p177mm.plugin.appbrand.game.p1223f;

import com.tencent.magicbrush.C1000a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.game.f.a */
public class C38226a {
    private static C38226a hui;
    public String appId = "";
    boolean cph = false;
    private int hub = 0;
    public long huc = 0;
    public long hud = 0;
    public int hue = -1;
    private float huf = -1.0f;
    public CopyOnWriteArrayList<Long> hug = new CopyOnWriteArrayList();
    HashMap<Integer, Integer> huh = new HashMap();
    public C33186c huj = new C382253();
    public C1000a mbInspector;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$5 */
    class C192405 implements Runnable {
        C192405() {
        }

        public final void run() {
            double i;
            AppMethodBeat.m2504i(130331);
            long g = C38226a.this.hud - C38226a.this.huc;
            long yz = (C5046bo.m7588yz() - C38226a.this.hud) / 1000;
            if (yz <= 0 || yz >= 10) {
                i = (double) C38226a.this.huf;
            } else if (C38226a.this.mbInspector != null) {
                i = (double) C38226a.this.mbInspector.mo3981fQ(C38226a.this.hue);
            } else {
                i = -1.0d;
            }
            C26890b c26890b = new C26890b();
            if (C38226a.this.hug.size() > 0 && C38226a.this.hub > 0) {
                C38226a.m64679a(C38226a.this, c26890b, C38226a.this.hug);
            }
            C19241a c19241a = new C19241a();
            if (C38226a.this.hug.size() > 0) {
                C38226a.m64678a(c19241a, C38226a.this.hug);
            }
            C38226a.this.hub = 0;
            C38226a.this.hug.clear();
            C38226a c38226a = C38226a.this;
            synchronized (c38226a.huh) {
                try {
                    for (Entry entry : c38226a.huh.entrySet()) {
                        C4990ab.m7417i("MicroMsg.MBNiReporter", "hy: picSize level:%d,num:%d", Integer.valueOf(((Integer) entry.getKey()).intValue()), Integer.valueOf(((Integer) entry.getValue()).intValue()));
                        C7060h.pYm.mo8378a(936, (long) r6, (long) r2, false);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(130331);
                }
            }
            C38226a.this.huh.clear();
            C4990ab.m7417i("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", C38226a.this.appId, Long.valueOf(g), Double.valueOf(i), Integer.valueOf(c26890b.hum), Long.valueOf(c26890b.hoN), Double.valueOf(c26890b.hun), Integer.valueOf(c19241a.hum), Long.valueOf(c19241a.hoN), Double.valueOf(c19241a.hun));
            if (g > 0) {
                C7060h.pYm.mo8381e(16136, C38226a.this.appId, Long.valueOf(g), Double.valueOf(i), Integer.valueOf(c26890b.hum), Long.valueOf(c26890b.hoN), Double.valueOf(c26890b.hun), Integer.valueOf(c19241a.hum), Long.valueOf(c19241a.hoN), Double.valueOf(c19241a.hun));
            }
            C38226a.this.cph = true;
            AppMethodBeat.m2505o(130331);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$a */
    class C19241a {
        long hoN;
        int hum;
        double hun;

        C19241a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$4 */
    public class C268894 implements Runnable {
        final /* synthetic */ long hul;

        public C268894(long j) {
            this.hul = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(130330);
            if (this.hul <= 0) {
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 5120) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(0))) {
                    C38226a.this.huh.put(Integer.valueOf(0), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(0))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(0), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 10240) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(1))) {
                    C38226a.this.huh.put(Integer.valueOf(1), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(1))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(1), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 20480) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(2))) {
                    C38226a.this.huh.put(Integer.valueOf(2), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(2))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(2), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 51200) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(3))) {
                    C38226a.this.huh.put(Integer.valueOf(3), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(3))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(3), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 102400) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(4))) {
                    C38226a.this.huh.put(Integer.valueOf(4), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(4))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(4), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 153600) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(5))) {
                    C38226a.this.huh.put(Integer.valueOf(5), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(5))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(5), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 204800) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(6))) {
                    C38226a.this.huh.put(Integer.valueOf(6), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(6))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(6), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 512000) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(7))) {
                    C38226a.this.huh.put(Integer.valueOf(7), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(7))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(7), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 1048576) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(8))) {
                    C38226a.this.huh.put(Integer.valueOf(8), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(8))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(8), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 2097152) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(9))) {
                    C38226a.this.huh.put(Integer.valueOf(9), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(9))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(9), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (this.hul < 3145728) {
                if (C38226a.this.huh.containsKey(Integer.valueOf(10))) {
                    C38226a.this.huh.put(Integer.valueOf(10), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(10))).intValue() + 1));
                    AppMethodBeat.m2505o(130330);
                    return;
                }
                C38226a.this.huh.put(Integer.valueOf(10), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            } else if (C38226a.this.huh.containsKey(Integer.valueOf(11))) {
                C38226a.this.huh.put(Integer.valueOf(11), Integer.valueOf(((Integer) C38226a.this.huh.get(Integer.valueOf(11))).intValue() + 1));
                AppMethodBeat.m2505o(130330);
            } else {
                C38226a.this.huh.put(Integer.valueOf(11), Integer.valueOf(1));
                AppMethodBeat.m2505o(130330);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$b */
    class C26890b {
        long hoN;
        int hum;
        double hun;

        C26890b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$3 */
    class C382253 extends C33186c {
        C382253() {
        }

        public final void onCreate() {
            AppMethodBeat.m2504i(130326);
            C4990ab.m7416i("MicroMsg.MBNiReporter", "hy: onCreate");
            C38226a.m64683e(C38226a.this);
            AppMethodBeat.m2505o(130326);
        }

        public final void onResume() {
            AppMethodBeat.m2504i(130327);
            C4990ab.m7416i("MicroMsg.MBNiReporter", "hy: onResume");
            AppMethodBeat.m2505o(130327);
        }

        /* renamed from: a */
        public final void mo6074a(C33184d c33184d) {
            AppMethodBeat.m2504i(130328);
            C4990ab.m7416i("MicroMsg.MBNiReporter", "hy: onPause");
            C38226a c38226a = C38226a.this;
            if (c38226a.cph) {
                C4990ab.m7416i("MicroMsg.MBNiReporter", "hy: hasReported!");
                AppMethodBeat.m2505o(130328);
                return;
            }
            C26006a.post(new C192405());
            AppMethodBeat.m2505o(130328);
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(130329);
            C4990ab.m7416i("MicroMsg.MBNiReporter", "hy: onDestroy");
            C38226a c38226a = C38226a.this;
            C4990ab.m7416i("MicroMsg.MBNiReporter", "hy: release!");
            C33183g.m54276b(c38226a.appId, c38226a.huj);
            AppMethodBeat.m2505o(130329);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$2 */
    public class C382272 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(130325);
            C1000a c = C38226a.this.mbInspector;
            if (c != null) {
                C38226a.this.huf = c.mo3981fQ(C38226a.this.hue);
            }
            AppMethodBeat.m2505o(130325);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$1 */
    public class C382281 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(130324);
            C38226a.this.hub = C38226a.this.hug.size();
            C4990ab.m7417i("MicroMsg.MBNiReporter", "hy: onFirstFrameRendered picnum:%d", Integer.valueOf(C38226a.this.hub));
            AppMethodBeat.m2505o(130324);
        }
    }

    public C38226a() {
        AppMethodBeat.m2504i(130332);
        AppMethodBeat.m2505o(130332);
    }

    public static C38226a aBG() {
        AppMethodBeat.m2504i(130333);
        if (hui == null) {
            synchronized (C38226a.class) {
                try {
                    if (hui == null) {
                        hui = new C38226a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(130333);
                    }
                }
            }
        }
        C38226a c38226a = hui;
        AppMethodBeat.m2505o(130333);
        return c38226a;
    }

    /* renamed from: e */
    static /* synthetic */ void m64683e(C38226a c38226a) {
        AppMethodBeat.m2504i(130334);
        C4990ab.m7416i("MicroMsg.MBNiReporter", "hy: initStatis!");
        if (c38226a.hug != null && c38226a.hug.size() > 0) {
            c38226a.hug.clear();
        }
        if (c38226a.huh != null && c38226a.huh.size() > 0) {
            c38226a.huh.clear();
        }
        c38226a.cph = false;
        c38226a.hub = 0;
        c38226a.huc = 0;
        c38226a.hud = 0;
        AppMethodBeat.m2505o(130334);
    }

    /* renamed from: a */
    static /* synthetic */ void m64679a(C38226a c38226a, C26890b c26890b, CopyOnWriteArrayList copyOnWriteArrayList) {
        int i = 0;
        AppMethodBeat.m2504i(130335);
        if (copyOnWriteArrayList.size() >= c38226a.hub) {
            Long[] lArr = (Long[]) Arrays.copyOf(copyOnWriteArrayList.toArray(new Long[0]), c38226a.hub);
            if (lArr == null || lArr.length <= 0) {
                AppMethodBeat.m2505o(130335);
                return;
            }
            double d = 0.0d;
            int length = lArr.length;
            while (i < length) {
                d += (double) lArr[i].longValue();
                i++;
            }
            double d2 = d / ((double) length);
            c26890b.hum = lArr.length;
            c26890b.hoN = (long) d;
            c26890b.hun = d2;
        }
        AppMethodBeat.m2505o(130335);
    }
}
