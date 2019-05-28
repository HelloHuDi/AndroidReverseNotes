package com.tencent.p177mm.plugin.fav.p408b.p409e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.fav.p407a.C11849af;
import com.tencent.p177mm.plugin.fav.p407a.C20672ac;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39036aj;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.b.e.e */
public final class C39041e implements C1202f, C20672ac {
    private static Map<Long, C1446a> cqS = new HashMap();
    private static Map<Long, Integer> mhg = new HashMap();
    private static Set<Long> mhi = new HashSet();
    private Queue<C27966g> cqQ = new LinkedList();
    private boolean cqU = false;
    public int cqV = 0;
    private long cqW = 0;
    public C7564ap cra = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C279833(), false);
    private boolean running = false;

    /* renamed from: com.tencent.mm.plugin.fav.b.e.e$2 */
    class C279822 implements Runnable {
        C279822() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5390);
            long currentTimeMillis = System.currentTimeMillis() - C39041e.this.cqW;
            if (C39041e.this.running) {
                if (currentTimeMillis < 60000) {
                    AppMethodBeat.m2505o(5390);
                    return;
                }
                C4990ab.m7412e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + C39041e.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C39041e.this.running);
            }
            C39041e.this.cqU = false;
            C39041e.this.running = true;
            C39041e.this.cqV = 3;
            C39041e.this.cra.mo16770ae(10, 10);
            AppMethodBeat.m2505o(5390);
        }

        public final String toString() {
            AppMethodBeat.m2504i(5391);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(5391);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.e$3 */
    class C279833 implements C5015a {
        C279833() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(5392);
            try {
                C39041e.m66431d(C39041e.this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavSendService", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(5392);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(5393);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.m2505o(5393);
            return str;
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m66432e(C39041e c39041e) {
        AppMethodBeat.m2504i(5400);
        c39041e.mo61949Fb();
        AppMethodBeat.m2505o(5400);
    }

    static {
        AppMethodBeat.m2504i(5401);
        AppMethodBeat.m2505o(5401);
    }

    public C39041e() {
        AppMethodBeat.m2504i(5394);
        C1720g.m3540Rg().mo14539a(401, (C1202f) this);
        AppMethodBeat.m2505o(5394);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(5395);
        C4990ab.m7417i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(5388);
                if (c1207m.getType() != 401) {
                    AppMethodBeat.m2505o(5388);
                } else if (c1207m instanceof C11849af) {
                    C39041e.this.cqU = false;
                    C27966g c27966g = ((C11849af) c1207m).mfY;
                    long j = c27966g.field_localId;
                    C39041e.cqS.remove(Long.valueOf(j));
                    if ((i == 0 && i2 == 0) || i2 == -400) {
                        C39041e.mhi.add(Long.valueOf(j));
                    }
                    if (!(i == 0 || i2 == -400)) {
                        C39041e.this.cqV = C39041e.this.cqV - 1;
                    }
                    Integer valueOf = Integer.valueOf(C5046bo.m7512a((Integer) C39041e.mhg.get(Long.valueOf(j)), 0));
                    if (!(i == 1 || i == 0)) {
                        valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        C39041e.mhg.put(Long.valueOf(c27966g.field_localId), valueOf);
                    }
                    if (valueOf.intValue() <= 0) {
                        int ed = C27968h.m44527ed(i, i2);
                        C7060h.pYm.mo8381e(10659, Integer.valueOf(0), Integer.valueOf(c27966g.field_type), Integer.valueOf(ed), Long.valueOf(C39037b.m66369b(c27966g)), Long.valueOf(C27968h.m44529ix(c27966g.field_localId)));
                        C39041e.mhg.remove(Long.valueOf(j));
                        C4990ab.m7413e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", Long.valueOf(j));
                        if (c27966g.field_itemStatus == 12) {
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(14, c27966g.field_localId);
                        }
                        if (c27966g.field_itemStatus == 9) {
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(11, c27966g.field_localId);
                        }
                    }
                    if (C39041e.this.cqV <= 0) {
                        C4990ab.m7416i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
                        C39041e.m66432e(C39041e.this);
                    } else if (!C39041e.m66431d(C39041e.this)) {
                        C39041e.startSync();
                        AppMethodBeat.m2505o(5388);
                        return;
                    }
                    AppMethodBeat.m2505o(5388);
                } else {
                    AppMethodBeat.m2505o(5388);
                }
            }

            public final String toString() {
                AppMethodBeat.m2504i(5389);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.m2505o(5389);
                return str;
            }
        });
        AppMethodBeat.m2505o(5395);
    }

    public final boolean ame() {
        return this.cqU;
    }

    public final void run() {
        AppMethodBeat.m2504i(5396);
        C1720g.m3539RS().mo10302aa(new C279822());
        AppMethodBeat.m2505o(5396);
    }

    /* renamed from: Fb */
    public final void mo61949Fb() {
        AppMethodBeat.m2504i(5397);
        C4990ab.m7416i("MicroMsg.Fav.FavSendService", "on finish");
        this.cqQ.clear();
        cqS.clear();
        this.running = false;
        this.cqU = false;
        mhg.clear();
        AppMethodBeat.m2505o(5397);
    }

    public static void startSync() {
        AppMethodBeat.m2504i(5398);
        C1720g.m3540Rg().mo14541a(new C39036aj(), 0);
        AppMethodBeat.m2505o(5398);
    }

    /* renamed from: d */
    static /* synthetic */ boolean m66431d(C39041e c39041e) {
        C27966g c27966g;
        AppMethodBeat.m2504i(5399);
        C4990ab.m7416i("MicroMsg.Fav.FavSendService", "tryStartNetscene");
        c39041e.cqW = System.currentTimeMillis();
        if (!c39041e.cqU && c39041e.cqQ.size() == 0) {
            List<C27966g> buV = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buV();
            if (!(buV == null || buV.size() == 0)) {
                for (C27966g c27966g2 : buV) {
                    if (mhi.contains(Long.valueOf(c27966g2.field_localId))) {
                        C4990ab.m7417i("MicroMsg.Fav.FavSendService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", Integer.valueOf(c27966g2.field_id), Long.valueOf(c27966g2.field_localId), Integer.valueOf(c27966g2.field_sourceType), c27966g2.field_sourceId);
                    } else if (cqS.containsKey(Long.valueOf(c27966g2.field_localId))) {
                        C4990ab.m7416i("MicroMsg.Fav.FavSendService", "File is Already running:" + c27966g2.field_localId);
                    } else {
                        if (!mhg.containsKey(Long.valueOf(c27966g2.field_localId))) {
                            mhg.put(Long.valueOf(c27966g2.field_localId), Integer.valueOf(3));
                        }
                        c39041e.cqQ.add(c27966g2);
                        cqS.put(Long.valueOf(c27966g2.field_localId), null);
                    }
                }
                C4990ab.m7416i("MicroMsg.Fav.FavSendService", "klem GetNeedRun procing:" + cqS.size() + ",send:" + c39041e.cqQ.size() + "]");
                c39041e.cqQ.size();
            }
        }
        if (c39041e.cqU || c39041e.cqQ.size() > 0) {
            C4990ab.m7417i("MicroMsg.Fav.FavSendService", "Has Data, start service %d", Integer.valueOf(c39041e.cqQ.size()));
            if (!c39041e.cqU && c39041e.cqQ.size() > 0) {
                c27966g2 = (C27966g) c39041e.cqQ.poll();
                if (c27966g2 != null && c27966g2.field_localId > 0) {
                    c39041e.cqU = true;
                    C1720g.m3540Rg().mo14541a(new C11849af(c27966g2), 0);
                    AppMethodBeat.m2505o(5399);
                    return true;
                }
            }
        }
        c39041e.mo61949Fb();
        C4990ab.m7416i("MicroMsg.Fav.FavSendService", "klem No Data Any More , Stop Service");
        AppMethodBeat.m2505o(5399);
        return false;
    }
}
