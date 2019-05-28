package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class h implements b {
    private Map<String, CollectSession> eGu = new a();
    private Map<String, Set<CollectSession>> heK = new a();

    public h() {
        AppMethodBeat.i(57045);
        AppMethodBeat.o(57045);
    }

    private boolean a(String str, CollectSession collectSession) {
        AppMethodBeat.i(57046);
        if (str == null || str.length() == 0 || collectSession == null) {
            AppMethodBeat.o(57046);
            return false;
        }
        Set set = (Set) this.heK.get(str);
        if (set == null) {
            set = new LinkedHashSet();
            this.heK.put(str, set);
        }
        boolean add = set.add(collectSession);
        AppMethodBeat.o(57046);
        return add;
    }

    private Set<CollectSession> yP(String str) {
        AppMethodBeat.i(57047);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(57047);
            return null;
        }
        Set<CollectSession> set = (Set) this.heK.get(str);
        AppMethodBeat.o(57047);
        return set;
    }

    public final void clear() {
        AppMethodBeat.i(57048);
        this.eGu.clear();
        this.heK.clear();
        AppMethodBeat.o(57048);
    }

    private CollectSession yQ(String str) {
        AppMethodBeat.i(57049);
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        if (collectSession == null) {
            collectSession = new CollectSession(str);
            this.eGu.put(str, collectSession);
        }
        AppMethodBeat.o(57049);
        return collectSession;
    }

    public final void a(CollectSession collectSession) {
        AppMethodBeat.i(57050);
        String str = collectSession.id;
        CollectSession collectSession2 = (CollectSession) this.eGu.get(str);
        if (collectSession2 == null) {
            this.eGu.put(str, collectSession);
            a(collectSession.groupId, collectSession);
            AppMethodBeat.o(57050);
            return;
        }
        TimePoint timePoint = collectSession.heA;
        if (collectSession2.heA == null) {
            collectSession2.heA = timePoint;
            AppMethodBeat.o(57050);
            return;
        }
        while (timePoint != null) {
            String str2 = timePoint.name;
            long j = timePoint.heM.get();
            if (!(str == null || str.length() == 0)) {
                CollectSession yQ = yQ(str);
                if (yQ.heA == null) {
                    yQ.yF(str2);
                    yQ.heA.heM.set(j);
                } else {
                    TimePoint timePoint2 = (TimePoint) yQ.heC.get(str2);
                    if (timePoint2 == null) {
                        yQ.yG(str2);
                        yQ.heB.heM.set(j);
                    } else {
                        timePoint2.heM.set((j + (timePoint2.heM.get() * ((long) timePoint2.heL.get()))) / ((long) (timePoint2.heL.get() + 1)));
                        timePoint2.heL.getAndIncrement();
                    }
                }
            }
            timePoint = (TimePoint) timePoint.heN.get();
        }
        AppMethodBeat.o(57050);
    }

    public final CollectSession bD(String str, String str2) {
        AppMethodBeat.i(57051);
        if (str == null || str.length() == 0) {
            ab.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", str2);
            AppMethodBeat.o(57051);
            return null;
        }
        CollectSession yQ = yQ(str);
        if (yQ.heA == null) {
            yQ.yF(str2);
        } else {
            yQ.yG(str2);
        }
        AppMethodBeat.o(57051);
        return yQ;
    }

    public final void l(String str, String str2, boolean z) {
        AppMethodBeat.i(57052);
        if (!z) {
            AppMethodBeat.o(57052);
        } else if (str == null || str.length() == 0) {
            ab.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str2);
            AppMethodBeat.o(57052);
        } else {
            CollectSession yQ = yQ(str);
            if (yQ.heA == null) {
                yQ.yF(str2);
                AppMethodBeat.o(57052);
                return;
            }
            yQ.yG(str2);
            AppMethodBeat.o(57052);
        }
    }

    public final void d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(57053);
        if (!z) {
            AppMethodBeat.o(57053);
        } else if (str2 == null || str2.length() == 0) {
            ab.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str3);
            AppMethodBeat.o(57053);
        } else if (str == null || str.length() == 0) {
            ab.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", str3);
            AppMethodBeat.o(57053);
        } else {
            CollectSession yQ = yQ(str2);
            if (yQ.heA == null) {
                yQ.groupId = str;
                a(str, yQ);
                yQ.yF(str3);
                AppMethodBeat.o(57053);
                return;
            }
            yQ.yG(str3);
            AppMethodBeat.o(57053);
        }
    }

    public final CollectSession yH(String str) {
        AppMethodBeat.i(57054);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(57054);
            return null;
        }
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        AppMethodBeat.o(57054);
        return collectSession;
    }

    public final CollectSession yI(String str) {
        AppMethodBeat.i(57055);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(57055);
            return null;
        }
        CollectSession collectSession = (CollectSession) this.eGu.remove(str);
        AppMethodBeat.o(57055);
        return collectSession;
    }

    public final void bE(String str, String str2) {
        AppMethodBeat.i(57056);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            ab.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", str, str2);
            AppMethodBeat.o(57056);
            return;
        }
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        if (collectSession == null) {
            ab.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", str, str2);
            AppMethodBeat.o(57056);
            return;
        }
        collectSession.heD = str2;
        AppMethodBeat.o(57056);
    }

    public final void print(String str) {
        AppMethodBeat.i(57057);
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        if (collectSession == null) {
            ab.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", str);
            AppMethodBeat.o(57057);
            return;
        }
        TimePoint timePoint = collectSession.heA;
        if (timePoint == null) {
            ab.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", str);
            AppMethodBeat.o(57057);
            return;
        }
        e.a(timePoint).insert(0, String.format("session : %s\n", new Object[]{collectSession.id}));
        ab.i("MicroMsg.SumCostTimeCollector", "%s", r1.toString());
        AppMethodBeat.o(57057);
    }

    public final StringBuilder yJ(String str) {
        AppMethodBeat.i(57058);
        Set yP = yP(str);
        StringBuilder append;
        if (yP == null || yP.isEmpty()) {
            ab.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            append = new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[]{str}));
            AppMethodBeat.o(57058);
            return append;
        }
        LinkedHashSet<CollectSession> linkedHashSet = new LinkedHashSet(yP);
        TimePoint timePoint = new TimePoint();
        for (CollectSession collectSession : linkedHashSet) {
            if (collectSession.heB == null || !(collectSession.heD == null || collectSession.heB.name.equals(collectSession.heD))) {
                ab.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", collectSession.id);
            } else {
                TimePoint timePoint2 = collectSession.heA;
                TimePoint timePoint3 = timePoint;
                while (timePoint2 != null) {
                    timePoint3.heM.set(((timePoint3.heM.get() * ((long) timePoint3.heL.get())) + timePoint2.heM.get()) / ((long) timePoint3.heL.incrementAndGet()));
                    timePoint3.name = timePoint2.name;
                    timePoint2 = (TimePoint) timePoint2.heN.get();
                    if (timePoint3.heN.get() == null && timePoint2 != null) {
                        timePoint3.heN.set(new TimePoint());
                    }
                    timePoint3 = (TimePoint) timePoint3.heN.get();
                }
            }
        }
        append = e.a(timePoint);
        append.insert(0, String.format("GroupId : %s, size : %d\n", new Object[]{str, Integer.valueOf(linkedHashSet.size())}));
        AppMethodBeat.o(57058);
        return append;
    }

    public final int bF(String str, String str2) {
        AppMethodBeat.i(57059);
        Set yP = yP(str);
        if (yP == null || yP.isEmpty()) {
            ab.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            AppMethodBeat.o(57059);
            return 0;
        }
        int i = 0;
        int i2 = 0;
        for (CollectSession collectSession : new LinkedHashSet(yP)) {
            int i3 = collectSession.cBY.getInt(str2);
            if (i3 != 0) {
                i2 += i3;
                i++;
            }
        }
        if (i == 0) {
            AppMethodBeat.o(57059);
            return 0;
        }
        int i4 = i2 / i;
        AppMethodBeat.o(57059);
        return i4;
    }
}
