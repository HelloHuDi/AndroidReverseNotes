package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b implements f, r {
    private static Map<Long, a> cqS = new HashMap();
    private Queue<g> cqQ = new LinkedList();
    private boolean cqU = false;
    private long cqW = 0;
    public ap cra = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(5354);
            try {
                b.b(b.this);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
            }
            AppMethodBeat.o(5354);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(5355);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(5355);
            return str;
        }
    }, false);
    public n fyJ = new n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(5351);
            boolean isWifi = at.isWifi(ah.getContext());
            if (i == 4 || i == 6) {
                try {
                    ab.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(b.this.mgU));
                    if (!b.this.mgU && isWifi) {
                        b bVar = b.this;
                        List<g> buT = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buT();
                        if (buT == null || buT.size() <= 0) {
                            ab.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
                        } else {
                            ab.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", Integer.valueOf(buT.size()));
                            for (g gVar : buT) {
                                if (gVar.field_itemStatus == 3) {
                                    gVar.field_itemStatus = 1;
                                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
                                }
                            }
                            bVar.run();
                        }
                    }
                    b.this.mgU = isWifi;
                    AppMethodBeat.o(5351);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
                    AppMethodBeat.o(5351);
                    return;
                }
            }
            b.this.mgU = isWifi;
            AppMethodBeat.o(5351);
        }
    };
    private boolean mgU = at.isWifi(ah.getContext());
    private boolean running = false;

    static {
        AppMethodBeat.i(5361);
        AppMethodBeat.o(5361);
    }

    public b() {
        AppMethodBeat.i(5356);
        com.tencent.mm.kernel.g.RO().a(this.fyJ);
        com.tencent.mm.kernel.g.Rg().a(404, (f) this);
        AppMethodBeat.o(5356);
    }

    public final void onSceneEnd(final int i, int i2, String str, final m mVar) {
        AppMethodBeat.i(5357);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5349);
                if (mVar.getType() != 404) {
                    AppMethodBeat.o(5349);
                } else if (mVar instanceof ai) {
                    b.this.cqU = false;
                    long j = ((ai) mVar).mgf.field_localId;
                    g gVar = ((ai) mVar).mgf;
                    b.cqS.remove(Long.valueOf(j));
                    if (i != 0) {
                        ab.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", Long.valueOf(j));
                        h.pYm.e(10659, Integer.valueOf(0), Integer.valueOf(gVar.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(gVar)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.ix(gVar.field_localId)));
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().J(3, j);
                    }
                    b.b(b.this);
                    AppMethodBeat.o(5349);
                } else {
                    AppMethodBeat.o(5349);
                }
            }

            public final String toString() {
                AppMethodBeat.i(5350);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(5350);
                return str;
            }
        });
        AppMethodBeat.o(5357);
    }

    public final void run() {
        AppMethodBeat.i(5358);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5352);
                long currentTimeMillis = System.currentTimeMillis() - b.this.cqW;
                if (b.this.running) {
                    if (currentTimeMillis < 60000) {
                        AppMethodBeat.o(5352);
                        return;
                    }
                    ab.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + b.this.running);
                }
                b.this.cqU = false;
                b.this.running = true;
                b.this.cra.ae(10, 10);
                AppMethodBeat.o(5352);
            }

            public final String toString() {
                AppMethodBeat.i(5353);
                String str = super.toString() + "|run";
                AppMethodBeat.o(5353);
                return str;
            }
        });
        AppMethodBeat.o(5358);
    }

    public final void Fb() {
        AppMethodBeat.i(5359);
        this.cqQ.clear();
        cqS.clear();
        this.running = false;
        this.cqU = false;
        AppMethodBeat.o(5359);
    }

    static /* synthetic */ void b(b bVar) {
        g gVar;
        AppMethodBeat.i(5360);
        bVar.cqW = System.currentTimeMillis();
        if (!bVar.cqU && bVar.cqQ.size() == 0) {
            List<g> buU = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buU();
            if (!(buU == null || buU.size() == 0)) {
                for (g gVar2 : buU) {
                    if (cqS.containsKey(Long.valueOf(gVar2.field_localId))) {
                        ab.d("MicroMsg.Fav.FavCheckCdnService", "File is Already running:" + gVar2.field_localId);
                    } else {
                        bVar.cqQ.add(gVar2);
                        cqS.put(Long.valueOf(gVar2.field_localId), null);
                    }
                }
                ab.i("MicroMsg.Fav.FavCheckCdnService", "klem GetNeedRun procing:" + cqS.size() + ",send:" + bVar.cqQ.size() + "]");
                bVar.cqQ.size();
            }
        }
        if (bVar.cqU || bVar.cqQ.size() > 0) {
            if (!bVar.cqU && bVar.cqQ.size() > 0) {
                gVar2 = (g) bVar.cqQ.poll();
                if (gVar2 != null && gVar2.field_localId > 0) {
                    bVar.cqU = true;
                    com.tencent.mm.kernel.g.Rg().a(new ai(gVar2), 0);
                }
            }
            AppMethodBeat.o(5360);
            return;
        }
        bVar.Fb();
        ab.i("MicroMsg.Fav.FavCheckCdnService", "klem No Data Any More , Stop Service");
        AppMethodBeat.o(5360);
    }
}
