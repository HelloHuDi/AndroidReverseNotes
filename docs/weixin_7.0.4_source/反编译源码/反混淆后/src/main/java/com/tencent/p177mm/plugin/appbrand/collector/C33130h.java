package com.tencent.p177mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.collector.h */
public final class C33130h implements C2106b {
    private Map<String, CollectSession> eGu = new C10166a();
    private Map<String, Set<CollectSession>> heK = new C10166a();

    public C33130h() {
        AppMethodBeat.m2504i(57045);
        AppMethodBeat.m2505o(57045);
    }

    /* renamed from: a */
    private boolean m54150a(String str, CollectSession collectSession) {
        AppMethodBeat.m2504i(57046);
        if (str == null || str.length() == 0 || collectSession == null) {
            AppMethodBeat.m2505o(57046);
            return false;
        }
        Set set = (Set) this.heK.get(str);
        if (set == null) {
            set = new LinkedHashSet();
            this.heK.put(str, set);
        }
        boolean add = set.add(collectSession);
        AppMethodBeat.m2505o(57046);
        return add;
    }

    /* renamed from: yP */
    private Set<CollectSession> m54151yP(String str) {
        AppMethodBeat.m2504i(57047);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(57047);
            return null;
        }
        Set<CollectSession> set = (Set) this.heK.get(str);
        AppMethodBeat.m2505o(57047);
        return set;
    }

    public final void clear() {
        AppMethodBeat.m2504i(57048);
        this.eGu.clear();
        this.heK.clear();
        AppMethodBeat.m2505o(57048);
    }

    /* renamed from: yQ */
    private CollectSession m54152yQ(String str) {
        AppMethodBeat.m2504i(57049);
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        if (collectSession == null) {
            collectSession = new CollectSession(str);
            this.eGu.put(str, collectSession);
        }
        AppMethodBeat.m2505o(57049);
        return collectSession;
    }

    /* renamed from: a */
    public final void mo5916a(CollectSession collectSession) {
        AppMethodBeat.m2504i(57050);
        String str = collectSession.f17182id;
        CollectSession collectSession2 = (CollectSession) this.eGu.get(str);
        if (collectSession2 == null) {
            this.eGu.put(str, collectSession);
            m54150a(collectSession.groupId, collectSession);
            AppMethodBeat.m2505o(57050);
            return;
        }
        TimePoint timePoint = collectSession.heA;
        if (collectSession2.heA == null) {
            collectSession2.heA = timePoint;
            AppMethodBeat.m2505o(57050);
            return;
        }
        while (timePoint != null) {
            String str2 = timePoint.name;
            long j = timePoint.heM.get();
            if (!(str == null || str.length() == 0)) {
                CollectSession yQ = m54152yQ(str);
                if (yQ.heA == null) {
                    yQ.mo67917yF(str2);
                    yQ.heA.heM.set(j);
                } else {
                    TimePoint timePoint2 = (TimePoint) yQ.heC.get(str2);
                    if (timePoint2 == null) {
                        yQ.mo67918yG(str2);
                        yQ.heB.heM.set(j);
                    } else {
                        timePoint2.heM.set((j + (timePoint2.heM.get() * ((long) timePoint2.heL.get()))) / ((long) (timePoint2.heL.get() + 1)));
                        timePoint2.heL.getAndIncrement();
                    }
                }
            }
            timePoint = (TimePoint) timePoint.heN.get();
        }
        AppMethodBeat.m2505o(57050);
    }

    /* renamed from: bD */
    public final CollectSession mo5917bD(String str, String str2) {
        AppMethodBeat.m2504i(57051);
        if (str == null || str.length() == 0) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", str2);
            AppMethodBeat.m2505o(57051);
            return null;
        }
        CollectSession yQ = m54152yQ(str);
        if (yQ.heA == null) {
            yQ.mo67917yF(str2);
        } else {
            yQ.mo67918yG(str2);
        }
        AppMethodBeat.m2505o(57051);
        return yQ;
    }

    /* renamed from: l */
    public final void mo5922l(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(57052);
        if (!z) {
            AppMethodBeat.m2505o(57052);
        } else if (str == null || str.length() == 0) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str2);
            AppMethodBeat.m2505o(57052);
        } else {
            CollectSession yQ = m54152yQ(str);
            if (yQ.heA == null) {
                yQ.mo67917yF(str2);
                AppMethodBeat.m2505o(57052);
                return;
            }
            yQ.mo67918yG(str2);
            AppMethodBeat.m2505o(57052);
        }
    }

    /* renamed from: d */
    public final void mo5921d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(57053);
        if (!z) {
            AppMethodBeat.m2505o(57053);
        } else if (str2 == null || str2.length() == 0) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str3);
            AppMethodBeat.m2505o(57053);
        } else if (str == null || str.length() == 0) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", str3);
            AppMethodBeat.m2505o(57053);
        } else {
            CollectSession yQ = m54152yQ(str2);
            if (yQ.heA == null) {
                yQ.groupId = str;
                m54150a(str, yQ);
                yQ.mo67917yF(str3);
                AppMethodBeat.m2505o(57053);
                return;
            }
            yQ.mo67918yG(str3);
            AppMethodBeat.m2505o(57053);
        }
    }

    /* renamed from: yH */
    public final CollectSession mo5924yH(String str) {
        AppMethodBeat.m2504i(57054);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(57054);
            return null;
        }
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        AppMethodBeat.m2505o(57054);
        return collectSession;
    }

    /* renamed from: yI */
    public final CollectSession mo5925yI(String str) {
        AppMethodBeat.m2504i(57055);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(57055);
            return null;
        }
        CollectSession collectSession = (CollectSession) this.eGu.remove(str);
        AppMethodBeat.m2505o(57055);
        return collectSession;
    }

    /* renamed from: bE */
    public final void mo5918bE(String str, String str2) {
        AppMethodBeat.m2504i(57056);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", str, str2);
            AppMethodBeat.m2505o(57056);
            return;
        }
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        if (collectSession == null) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", str, str2);
            AppMethodBeat.m2505o(57056);
            return;
        }
        collectSession.heD = str2;
        AppMethodBeat.m2505o(57056);
    }

    public final void print(String str) {
        AppMethodBeat.m2504i(57057);
        CollectSession collectSession = (CollectSession) this.eGu.get(str);
        if (collectSession == null) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", str);
            AppMethodBeat.m2505o(57057);
            return;
        }
        TimePoint timePoint = collectSession.heA;
        if (timePoint == null) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", str);
            AppMethodBeat.m2505o(57057);
            return;
        }
        C2109e.m4326a(timePoint).insert(0, String.format("session : %s\n", new Object[]{collectSession.f17182id}));
        C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "%s", r1.toString());
        AppMethodBeat.m2505o(57057);
    }

    /* renamed from: yJ */
    public final StringBuilder mo5926yJ(String str) {
        AppMethodBeat.m2504i(57058);
        Set yP = m54151yP(str);
        StringBuilder append;
        if (yP == null || yP.isEmpty()) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            append = new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[]{str}));
            AppMethodBeat.m2505o(57058);
            return append;
        }
        LinkedHashSet<CollectSession> linkedHashSet = new LinkedHashSet(yP);
        TimePoint timePoint = new TimePoint();
        for (CollectSession collectSession : linkedHashSet) {
            if (collectSession.heB == null || !(collectSession.heD == null || collectSession.heB.name.equals(collectSession.heD))) {
                C4990ab.m7413e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", collectSession.f17182id);
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
        append = C2109e.m4326a(timePoint);
        append.insert(0, String.format("GroupId : %s, size : %d\n", new Object[]{str, Integer.valueOf(linkedHashSet.size())}));
        AppMethodBeat.m2505o(57058);
        return append;
    }

    /* renamed from: bF */
    public final int mo5919bF(String str, String str2) {
        AppMethodBeat.m2504i(57059);
        Set yP = m54151yP(str);
        if (yP == null || yP.isEmpty()) {
            C4990ab.m7417i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            AppMethodBeat.m2505o(57059);
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
            AppMethodBeat.m2505o(57059);
            return 0;
        }
        int i4 = i2 / i;
        AppMethodBeat.m2505o(57059);
        return i4;
    }
}
