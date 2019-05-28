package com.tencent.mm.plugin.appbrand.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

public class a {
    private static a hui;
    public String appId = "";
    boolean cph = false;
    private int hub = 0;
    public long huc = 0;
    public long hud = 0;
    public int hue = -1;
    private float huf = -1.0f;
    public CopyOnWriteArrayList<Long> hug = new CopyOnWriteArrayList();
    HashMap<Integer, Integer> huh = new HashMap();
    public c huj = new c() {
        public final void onCreate() {
            AppMethodBeat.i(130326);
            ab.i("MicroMsg.MBNiReporter", "hy: onCreate");
            a.e(a.this);
            AppMethodBeat.o(130326);
        }

        public final void onResume() {
            AppMethodBeat.i(130327);
            ab.i("MicroMsg.MBNiReporter", "hy: onResume");
            AppMethodBeat.o(130327);
        }

        public final void a(d dVar) {
            AppMethodBeat.i(130328);
            ab.i("MicroMsg.MBNiReporter", "hy: onPause");
            a aVar = a.this;
            if (aVar.cph) {
                ab.i("MicroMsg.MBNiReporter", "hy: hasReported!");
                AppMethodBeat.o(130328);
                return;
            }
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    double i;
                    AppMethodBeat.i(130331);
                    long g = a.this.hud - a.this.huc;
                    long yz = (bo.yz() - a.this.hud) / 1000;
                    if (yz <= 0 || yz >= 10) {
                        i = (double) a.this.huf;
                    } else if (a.this.mbInspector != null) {
                        i = (double) a.this.mbInspector.fQ(a.this.hue);
                    } else {
                        i = -1.0d;
                    }
                    b bVar = new b();
                    if (a.this.hug.size() > 0 && a.this.hub > 0) {
                        a.a(a.this, bVar, a.this.hug);
                    }
                    a aVar = new a();
                    if (a.this.hug.size() > 0) {
                        a.a(aVar, a.this.hug);
                    }
                    a.this.hub = 0;
                    a.this.hug.clear();
                    a aVar2 = a.this;
                    synchronized (aVar2.huh) {
                        try {
                            for (Entry entry : aVar2.huh.entrySet()) {
                                ab.i("MicroMsg.MBNiReporter", "hy: picSize level:%d,num:%d", Integer.valueOf(((Integer) entry.getKey()).intValue()), Integer.valueOf(((Integer) entry.getValue()).intValue()));
                                h.pYm.a(936, (long) r6, (long) r2, false);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(130331);
                        }
                    }
                    a.this.huh.clear();
                    ab.i("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", a.this.appId, Long.valueOf(g), Double.valueOf(i), Integer.valueOf(bVar.hum), Long.valueOf(bVar.hoN), Double.valueOf(bVar.hun), Integer.valueOf(aVar.hum), Long.valueOf(aVar.hoN), Double.valueOf(aVar.hun));
                    if (g > 0) {
                        h.pYm.e(16136, a.this.appId, Long.valueOf(g), Double.valueOf(i), Integer.valueOf(bVar.hum), Long.valueOf(bVar.hoN), Double.valueOf(bVar.hun), Integer.valueOf(aVar.hum), Long.valueOf(aVar.hoN), Double.valueOf(aVar.hun));
                    }
                    a.this.cph = true;
                    AppMethodBeat.o(130331);
                }
            });
            AppMethodBeat.o(130328);
        }

        public final void onDestroy() {
            AppMethodBeat.i(130329);
            ab.i("MicroMsg.MBNiReporter", "hy: onDestroy");
            a aVar = a.this;
            ab.i("MicroMsg.MBNiReporter", "hy: release!");
            g.b(aVar.appId, aVar.huj);
            AppMethodBeat.o(130329);
        }
    };
    public com.tencent.magicbrush.a mbInspector;

    class a {
        long hoN;
        int hum;
        double hun;

        a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ long hul;

        public AnonymousClass4(long j) {
            this.hul = j;
        }

        public final void run() {
            AppMethodBeat.i(130330);
            if (this.hul <= 0) {
                AppMethodBeat.o(130330);
            } else if (this.hul < 5120) {
                if (a.this.huh.containsKey(Integer.valueOf(0))) {
                    a.this.huh.put(Integer.valueOf(0), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(0))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(0), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 10240) {
                if (a.this.huh.containsKey(Integer.valueOf(1))) {
                    a.this.huh.put(Integer.valueOf(1), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(1))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(1), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 20480) {
                if (a.this.huh.containsKey(Integer.valueOf(2))) {
                    a.this.huh.put(Integer.valueOf(2), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(2))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(2), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 51200) {
                if (a.this.huh.containsKey(Integer.valueOf(3))) {
                    a.this.huh.put(Integer.valueOf(3), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(3))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(3), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 102400) {
                if (a.this.huh.containsKey(Integer.valueOf(4))) {
                    a.this.huh.put(Integer.valueOf(4), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(4))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(4), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 153600) {
                if (a.this.huh.containsKey(Integer.valueOf(5))) {
                    a.this.huh.put(Integer.valueOf(5), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(5))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(5), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 204800) {
                if (a.this.huh.containsKey(Integer.valueOf(6))) {
                    a.this.huh.put(Integer.valueOf(6), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(6))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(6), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 512000) {
                if (a.this.huh.containsKey(Integer.valueOf(7))) {
                    a.this.huh.put(Integer.valueOf(7), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(7))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(7), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 1048576) {
                if (a.this.huh.containsKey(Integer.valueOf(8))) {
                    a.this.huh.put(Integer.valueOf(8), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(8))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(8), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 2097152) {
                if (a.this.huh.containsKey(Integer.valueOf(9))) {
                    a.this.huh.put(Integer.valueOf(9), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(9))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(9), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (this.hul < 3145728) {
                if (a.this.huh.containsKey(Integer.valueOf(10))) {
                    a.this.huh.put(Integer.valueOf(10), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(10))).intValue() + 1));
                    AppMethodBeat.o(130330);
                    return;
                }
                a.this.huh.put(Integer.valueOf(10), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            } else if (a.this.huh.containsKey(Integer.valueOf(11))) {
                a.this.huh.put(Integer.valueOf(11), Integer.valueOf(((Integer) a.this.huh.get(Integer.valueOf(11))).intValue() + 1));
                AppMethodBeat.o(130330);
            } else {
                a.this.huh.put(Integer.valueOf(11), Integer.valueOf(1));
                AppMethodBeat.o(130330);
            }
        }
    }

    class b {
        long hoN;
        int hum;
        double hun;

        b() {
        }
    }

    public a() {
        AppMethodBeat.i(130332);
        AppMethodBeat.o(130332);
    }

    public static a aBG() {
        AppMethodBeat.i(130333);
        if (hui == null) {
            synchronized (a.class) {
                try {
                    if (hui == null) {
                        hui = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(130333);
                    }
                }
            }
        }
        a aVar = hui;
        AppMethodBeat.o(130333);
        return aVar;
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(130334);
        ab.i("MicroMsg.MBNiReporter", "hy: initStatis!");
        if (aVar.hug != null && aVar.hug.size() > 0) {
            aVar.hug.clear();
        }
        if (aVar.huh != null && aVar.huh.size() > 0) {
            aVar.huh.clear();
        }
        aVar.cph = false;
        aVar.hub = 0;
        aVar.huc = 0;
        aVar.hud = 0;
        AppMethodBeat.o(130334);
    }

    static /* synthetic */ void a(a aVar, b bVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        int i = 0;
        AppMethodBeat.i(130335);
        if (copyOnWriteArrayList.size() >= aVar.hub) {
            Long[] lArr = (Long[]) Arrays.copyOf(copyOnWriteArrayList.toArray(new Long[0]), aVar.hub);
            if (lArr == null || lArr.length <= 0) {
                AppMethodBeat.o(130335);
                return;
            }
            double d = 0.0d;
            int length = lArr.length;
            while (i < length) {
                d += (double) lArr[i].longValue();
                i++;
            }
            double d2 = d / ((double) length);
            bVar.hum = lArr.length;
            bVar.hoN = (long) d;
            bVar.hun = d2;
        }
        AppMethodBeat.o(130335);
    }
}
