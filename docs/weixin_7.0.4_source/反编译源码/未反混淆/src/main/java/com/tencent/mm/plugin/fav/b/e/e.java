package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class e implements f, ac {
    private static Map<Long, a> cqS = new HashMap();
    private static Map<Long, Integer> mhg = new HashMap();
    private static Set<Long> mhi = new HashSet();
    private Queue<g> cqQ = new LinkedList();
    private boolean cqU = false;
    public int cqV = 0;
    private long cqW = 0;
    public ap cra = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(5392);
            try {
                e.d(e.this);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavSendService", e, "", new Object[0]);
            }
            AppMethodBeat.o(5392);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(5393);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(5393);
            return str;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(5400);
        eVar.Fb();
        AppMethodBeat.o(5400);
    }

    static {
        AppMethodBeat.i(5401);
        AppMethodBeat.o(5401);
    }

    public e() {
        AppMethodBeat.i(5394);
        com.tencent.mm.kernel.g.Rg().a(401, (f) this);
        AppMethodBeat.o(5394);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
        AppMethodBeat.i(5395);
        ab.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5388);
                if (mVar.getType() != 401) {
                    AppMethodBeat.o(5388);
                } else if (mVar instanceof af) {
                    e.this.cqU = false;
                    g gVar = ((af) mVar).mfY;
                    long j = gVar.field_localId;
                    e.cqS.remove(Long.valueOf(j));
                    if ((i == 0 && i2 == 0) || i2 == -400) {
                        e.mhi.add(Long.valueOf(j));
                    }
                    if (!(i == 0 || i2 == -400)) {
                        e.this.cqV = e.this.cqV - 1;
                    }
                    Integer valueOf = Integer.valueOf(bo.a((Integer) e.mhg.get(Long.valueOf(j)), 0));
                    if (!(i == 1 || i == 0)) {
                        valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        e.mhg.put(Long.valueOf(gVar.field_localId), valueOf);
                    }
                    if (valueOf.intValue() <= 0) {
                        int ed = h.ed(i, i2);
                        com.tencent.mm.plugin.report.service.h.pYm.e(10659, Integer.valueOf(0), Integer.valueOf(gVar.field_type), Integer.valueOf(ed), Long.valueOf(b.b(gVar)), Long.valueOf(h.ix(gVar.field_localId)));
                        e.mhg.remove(Long.valueOf(j));
                        ab.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", Long.valueOf(j));
                        if (gVar.field_itemStatus == 12) {
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(14, gVar.field_localId);
                        }
                        if (gVar.field_itemStatus == 9) {
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(11, gVar.field_localId);
                        }
                    }
                    if (e.this.cqV <= 0) {
                        ab.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
                        e.e(e.this);
                    } else if (!e.d(e.this)) {
                        e.startSync();
                        AppMethodBeat.o(5388);
                        return;
                    }
                    AppMethodBeat.o(5388);
                } else {
                    AppMethodBeat.o(5388);
                }
            }

            public final String toString() {
                AppMethodBeat.i(5389);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(5389);
                return str;
            }
        });
        AppMethodBeat.o(5395);
    }

    public final boolean ame() {
        return this.cqU;
    }

    public final void run() {
        AppMethodBeat.i(5396);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5390);
                long currentTimeMillis = System.currentTimeMillis() - e.this.cqW;
                if (e.this.running) {
                    if (currentTimeMillis < 60000) {
                        AppMethodBeat.o(5390);
                        return;
                    }
                    ab.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + e.this.running);
                }
                e.this.cqU = false;
                e.this.running = true;
                e.this.cqV = 3;
                e.this.cra.ae(10, 10);
                AppMethodBeat.o(5390);
            }

            public final String toString() {
                AppMethodBeat.i(5391);
                String str = super.toString() + "|run";
                AppMethodBeat.o(5391);
                return str;
            }
        });
        AppMethodBeat.o(5396);
    }

    public final void Fb() {
        AppMethodBeat.i(5397);
        ab.i("MicroMsg.Fav.FavSendService", "on finish");
        this.cqQ.clear();
        cqS.clear();
        this.running = false;
        this.cqU = false;
        mhg.clear();
        AppMethodBeat.o(5397);
    }

    public static void startSync() {
        AppMethodBeat.i(5398);
        com.tencent.mm.kernel.g.Rg().a(new aj(), 0);
        AppMethodBeat.o(5398);
    }

    static /* synthetic */ boolean d(e eVar) {
        g gVar;
        AppMethodBeat.i(5399);
        ab.i("MicroMsg.Fav.FavSendService", "tryStartNetscene");
        eVar.cqW = System.currentTimeMillis();
        if (!eVar.cqU && eVar.cqQ.size() == 0) {
            List<g> buV = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buV();
            if (!(buV == null || buV.size() == 0)) {
                for (g gVar2 : buV) {
                    if (mhi.contains(Long.valueOf(gVar2.field_localId))) {
                        ab.i("MicroMsg.Fav.FavSendService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", Integer.valueOf(gVar2.field_id), Long.valueOf(gVar2.field_localId), Integer.valueOf(gVar2.field_sourceType), gVar2.field_sourceId);
                    } else if (cqS.containsKey(Long.valueOf(gVar2.field_localId))) {
                        ab.i("MicroMsg.Fav.FavSendService", "File is Already running:" + gVar2.field_localId);
                    } else {
                        if (!mhg.containsKey(Long.valueOf(gVar2.field_localId))) {
                            mhg.put(Long.valueOf(gVar2.field_localId), Integer.valueOf(3));
                        }
                        eVar.cqQ.add(gVar2);
                        cqS.put(Long.valueOf(gVar2.field_localId), null);
                    }
                }
                ab.i("MicroMsg.Fav.FavSendService", "klem GetNeedRun procing:" + cqS.size() + ",send:" + eVar.cqQ.size() + "]");
                eVar.cqQ.size();
            }
        }
        if (eVar.cqU || eVar.cqQ.size() > 0) {
            ab.i("MicroMsg.Fav.FavSendService", "Has Data, start service %d", Integer.valueOf(eVar.cqQ.size()));
            if (!eVar.cqU && eVar.cqQ.size() > 0) {
                gVar2 = (g) eVar.cqQ.poll();
                if (gVar2 != null && gVar2.field_localId > 0) {
                    eVar.cqU = true;
                    com.tencent.mm.kernel.g.Rg().a(new af(gVar2), 0);
                    AppMethodBeat.o(5399);
                    return true;
                }
            }
        }
        eVar.Fb();
        ab.i("MicroMsg.Fav.FavSendService", "klem No Data Any More , Stop Service");
        AppMethodBeat.o(5399);
        return false;
    }
}
