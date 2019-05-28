package com.tencent.p177mm.plugin.fav.p408b.p409e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.fav.p407a.C20678r;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C45924ai;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.fav.b.e.b */
public final class C6903b implements C1202f, C20678r {
    private static Map<Long, C1446a> cqS = new HashMap();
    private Queue<C27966g> cqQ = new LinkedList();
    private boolean cqU = false;
    private long cqW = 0;
    public C7564ap cra = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C69074(), false);
    public C1923n fyJ = new C69052();
    private boolean mgU = C5023at.isWifi(C4996ah.getContext());
    private boolean running = false;

    /* renamed from: com.tencent.mm.plugin.fav.b.e.b$2 */
    class C69052 extends C1924a {
        C69052() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(5351);
            boolean isWifi = C5023at.isWifi(C4996ah.getContext());
            if (i == 4 || i == 6) {
                try {
                    C4990ab.m7417i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(C6903b.this.mgU));
                    if (!C6903b.this.mgU && isWifi) {
                        C6903b c6903b = C6903b.this;
                        List<C27966g> buT = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buT();
                        if (buT == null || buT.size() <= 0) {
                            C4990ab.m7416i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
                        } else {
                            C4990ab.m7417i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", Integer.valueOf(buT.size()));
                            for (C27966g c27966g : buT) {
                                if (c27966g.field_itemStatus == 3) {
                                    c27966g.field_itemStatus = 1;
                                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
                                }
                            }
                            c6903b.run();
                        }
                    }
                    C6903b.this.mgU = isWifi;
                    AppMethodBeat.m2505o(5351);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
                    AppMethodBeat.m2505o(5351);
                    return;
                }
            }
            C6903b.this.mgU = isWifi;
            AppMethodBeat.m2505o(5351);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.b$3 */
    class C69063 implements Runnable {
        C69063() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5352);
            long currentTimeMillis = System.currentTimeMillis() - C6903b.this.cqW;
            if (C6903b.this.running) {
                if (currentTimeMillis < 60000) {
                    AppMethodBeat.m2505o(5352);
                    return;
                }
                C4990ab.m7412e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + C6903b.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C6903b.this.running);
            }
            C6903b.this.cqU = false;
            C6903b.this.running = true;
            C6903b.this.cra.mo16770ae(10, 10);
            AppMethodBeat.m2505o(5352);
        }

        public final String toString() {
            AppMethodBeat.m2504i(5353);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(5353);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.b$4 */
    class C69074 implements C5015a {
        C69074() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(5354);
            try {
                C6903b.m11427b(C6903b.this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(5354);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(5355);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.m2505o(5355);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(5361);
        AppMethodBeat.m2505o(5361);
    }

    public C6903b() {
        AppMethodBeat.m2504i(5356);
        C1720g.m3535RO().mo5187a(this.fyJ);
        C1720g.m3540Rg().mo14539a(404, (C1202f) this);
        AppMethodBeat.m2505o(5356);
    }

    public final void onSceneEnd(final int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(5357);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(5349);
                if (c1207m.getType() != 404) {
                    AppMethodBeat.m2505o(5349);
                } else if (c1207m instanceof C45924ai) {
                    C6903b.this.cqU = false;
                    long j = ((C45924ai) c1207m).mgf.field_localId;
                    C27966g c27966g = ((C45924ai) c1207m).mgf;
                    C6903b.cqS.remove(Long.valueOf(j));
                    if (i != 0) {
                        C4990ab.m7413e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", Long.valueOf(j));
                        C7060h.pYm.mo8381e(10659, Integer.valueOf(0), Integer.valueOf(c27966g.field_type), Integer.valueOf(-2), Long.valueOf(C39037b.m66369b(c27966g)), Long.valueOf(C27968h.m44529ix(c27966g.field_localId)));
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(3, j);
                    }
                    C6903b.m11427b(C6903b.this);
                    AppMethodBeat.m2505o(5349);
                } else {
                    AppMethodBeat.m2505o(5349);
                }
            }

            public final String toString() {
                AppMethodBeat.m2504i(5350);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.m2505o(5350);
                return str;
            }
        });
        AppMethodBeat.m2505o(5357);
    }

    public final void run() {
        AppMethodBeat.m2504i(5358);
        C1720g.m3539RS().mo10302aa(new C69063());
        AppMethodBeat.m2505o(5358);
    }

    /* renamed from: Fb */
    public final void mo15181Fb() {
        AppMethodBeat.m2504i(5359);
        this.cqQ.clear();
        cqS.clear();
        this.running = false;
        this.cqU = false;
        AppMethodBeat.m2505o(5359);
    }

    /* renamed from: b */
    static /* synthetic */ void m11427b(C6903b c6903b) {
        C27966g c27966g;
        AppMethodBeat.m2504i(5360);
        c6903b.cqW = System.currentTimeMillis();
        if (!c6903b.cqU && c6903b.cqQ.size() == 0) {
            List<C27966g> buU = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buU();
            if (!(buU == null || buU.size() == 0)) {
                for (C27966g c27966g2 : buU) {
                    if (cqS.containsKey(Long.valueOf(c27966g2.field_localId))) {
                        C4990ab.m7410d("MicroMsg.Fav.FavCheckCdnService", "File is Already running:" + c27966g2.field_localId);
                    } else {
                        c6903b.cqQ.add(c27966g2);
                        cqS.put(Long.valueOf(c27966g2.field_localId), null);
                    }
                }
                C4990ab.m7416i("MicroMsg.Fav.FavCheckCdnService", "klem GetNeedRun procing:" + cqS.size() + ",send:" + c6903b.cqQ.size() + "]");
                c6903b.cqQ.size();
            }
        }
        if (c6903b.cqU || c6903b.cqQ.size() > 0) {
            if (!c6903b.cqU && c6903b.cqQ.size() > 0) {
                c27966g2 = (C27966g) c6903b.cqQ.poll();
                if (c27966g2 != null && c27966g2.field_localId > 0) {
                    c6903b.cqU = true;
                    C1720g.m3540Rg().mo14541a(new C45924ai(c27966g2), 0);
                }
            }
            AppMethodBeat.m2505o(5360);
            return;
        }
        c6903b.mo15181Fb();
        C4990ab.m7416i("MicroMsg.Fav.FavCheckCdnService", "klem No Data Any More , Stop Service");
        AppMethodBeat.m2505o(5360);
    }
}
