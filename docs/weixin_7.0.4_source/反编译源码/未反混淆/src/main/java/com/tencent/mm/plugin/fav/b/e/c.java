package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c implements f, u {
    public Map<String, a> mhd = new HashMap();

    static class a {
        int mgq;
        com.tencent.mm.plugin.fav.a.f mgr;
        int retryCount;
        long time;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public c() {
        AppMethodBeat.i(5366);
        g.Rg().a((int) v2helper.EMethodSetAgcRxOn, (f) this);
        g.Rg().a(401, (f) this);
        AppMethodBeat.o(5366);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(5367);
        if (mVar == null) {
            AppMethodBeat.o(5367);
            return;
        }
        ab.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
        if (mVar.getType() == 401) {
            ab.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
            run();
            AppMethodBeat.o(5367);
            return;
        }
        al alVar = (al) mVar;
        if (alVar.type != 0) {
            long j;
            int size;
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.Fav.FavEditService", "clear job, key %s", x(alVar.bvg(), alVar.bvh()));
                this.mhd.remove(r0);
                ((ae) g.M(ae.class)).getFavEditInfoStorage().s(alVar.bvg(), alVar.bvh());
                com.tencent.mm.plugin.fav.a.g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(alVar.bvg());
                if (iE != null) {
                    int i3;
                    j = (long) iE.field_id;
                    size = iE.field_tagProto.wiJ.size();
                    if (alVar.mgr == null) {
                        i3 = 1;
                    } else {
                        i3 = alVar.mgr.field_scene;
                    }
                    h.k(j, size, i3);
                }
                AppMethodBeat.o(5367);
                return;
            }
            ab.i("MicroMsg.Fav.FavEditService", "retry job, key %s", x(alVar.bvg(), alVar.bvh()));
            final a aVar = (a) this.mhd.get(r0);
            if (aVar == null) {
                ab.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", Long.valueOf(j), Integer.valueOf(size));
                AppMethodBeat.o(5367);
                return;
            }
            g.RS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(5364);
                    c.a(aVar, false);
                    AppMethodBeat.o(5364);
                }

                public final String toString() {
                    AppMethodBeat.i(5365);
                    String str = super.toString() + "|retryJob";
                    AppMethodBeat.o(5365);
                    return str;
                }
            }, 3000);
        }
        AppMethodBeat.o(5367);
    }

    public final void run() {
        AppMethodBeat.i(5368);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5362);
                List<com.tencent.mm.plugin.fav.a.f> buQ = ((ae) g.M(ae.class)).getFavEditInfoStorage().buQ();
                if (buQ == null) {
                    AppMethodBeat.o(5362);
                    return;
                }
                ab.i("MicroMsg.Fav.FavEditService", "infos size %d", Integer.valueOf(buQ.size()));
                for (com.tencent.mm.plugin.fav.a.f fVar : buQ) {
                    String x = c.x(fVar.field_localId, fVar.field_type);
                    a aVar = (a) c.this.mhd.get(x);
                    if (aVar == null) {
                        ab.i("MicroMsg.Fav.FavEditService", "not match key %s", x);
                        aVar = new a();
                        aVar.mgr = fVar;
                        aVar.retryCount = 3;
                        aVar.time = SystemClock.elapsedRealtime();
                        c.this.mhd.put(x, aVar);
                        c.a(aVar, true);
                    } else {
                        ab.i("MicroMsg.Fav.FavEditService", "match key %s, check start", x);
                        c.a(aVar, false);
                    }
                }
                AppMethodBeat.o(5362);
            }

            public final String toString() {
                AppMethodBeat.i(5363);
                String str = super.toString() + "|run";
                AppMethodBeat.o(5363);
                return str;
            }
        });
        AppMethodBeat.o(5368);
    }

    public static String x(long j, int i) {
        AppMethodBeat.i(5369);
        String str = j + "&&" + i;
        AppMethodBeat.o(5369);
        return str;
    }

    public final void a(long j, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, int i) {
        com.tencent.mm.plugin.fav.a.f fVar;
        int i2;
        AppMethodBeat.i(5370);
        ab.i("MicroMsg.Fav.FavEditService", "addTag %d", Long.valueOf(j));
        com.tencent.mm.plugin.fav.a.f iD = ((ae) g.M(ae.class)).getFavEditInfoStorage().iD(j);
        if (iD == null) {
            fVar = new com.tencent.mm.plugin.fav.a.f();
            i2 = 1;
        } else {
            fVar = iD;
            i2 = 0;
        }
        fVar.field_localId = j;
        aav aav = new aav();
        aav.mgt = linkedList;
        aav.wie = linkedList2;
        fVar.field_modItem = aav;
        fVar.field_time = bo.anU();
        fVar.field_type = 0;
        fVar.field_scene = i;
        if (i2 != 0) {
            ((ae) g.M(ae.class)).getFavEditInfoStorage().a(fVar);
        } else {
            ((ae) g.M(ae.class)).getFavEditInfoStorage().a(fVar, "localId");
        }
        run();
        AppMethodBeat.o(5370);
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        AppMethodBeat.i(5371);
        aVar.retryCount--;
        if (aVar.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - aVar.time < 7200000) {
                ab.i("MicroMsg.Fav.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", Integer.valueOf(aVar.mgq), Long.valueOf(aVar.mgr.field_localId), Integer.valueOf(aVar.mgr.field_type));
                AppMethodBeat.o(5371);
                return;
            }
            aVar.time = SystemClock.elapsedRealtime();
            aVar.retryCount = 3;
        }
        if (aVar.mgq <= 0) {
            com.tencent.mm.plugin.fav.a.g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(aVar.mgr.field_localId);
            if (iE == null || iE.field_id <= 0) {
                ab.w("MicroMsg.Fav.FavEditService", "want to start mod item, but favid is invalid, local id %d", Long.valueOf(aVar.mgr.field_localId));
                AppMethodBeat.o(5371);
                return;
            }
            aVar.mgq = iE.field_id;
            ab.i("MicroMsg.Fav.FavEditService", "want mod item, find id %d by local id %d", Integer.valueOf(aVar.mgq), Long.valueOf(aVar.mgr.field_localId));
        } else if (!z) {
            ab.w("MicroMsg.Fav.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", Integer.valueOf(aVar.mgq));
            AppMethodBeat.o(5371);
            return;
        }
        ab.i("MicroMsg.Fav.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", Boolean.valueOf(z), Integer.valueOf(aVar.mgq), Integer.valueOf(aVar.mgr.field_type));
        g.Rg().a(new al(aVar.mgq, aVar.mgr), 0);
        AppMethodBeat.o(5371);
    }
}
