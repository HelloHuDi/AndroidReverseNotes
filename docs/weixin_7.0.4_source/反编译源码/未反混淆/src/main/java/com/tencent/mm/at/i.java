package com.tencent.mm.at;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class i implements f, g {
    private static Set<Integer> fEL = new HashSet();
    private Queue<e> cqQ = new LinkedList();
    private boolean cqU = false;
    int cqV = 0;
    private long cqW = 0;
    com.tencent.mm.compatible.util.g.a cqZ = new com.tencent.mm.compatible.util.g.a();
    private ap cra;
    private LinkedList<l> fEM = new LinkedList();
    public a fEN = null;
    private boolean fEO = false;
    private com.tencent.mm.at.l.a fEP = new com.tencent.mm.at.l.a() {
        public final void agX() {
            AppMethodBeat.i(78283);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78282);
                    ab.i("MicroMsg.ImgService", "on image upload end. queue size : " + i.this.fEM.size());
                    i.this.fEO = false;
                    if (i.this.fEM.size() > 0) {
                        m mVar = (l) i.this.fEM.poll();
                        if (mVar != null) {
                            ab.i("MicroMsg.ImgService", "upload image scene hashcode : " + mVar.hashCode());
                            com.tencent.mm.kernel.g.RO().eJo.a(mVar, 0);
                            i.this.fEO = true;
                            AppMethodBeat.o(78282);
                            return;
                        }
                        ab.w("MicroMsg.ImgService", "poll image scene is null");
                    }
                    AppMethodBeat.o(78282);
                }
            });
            AppMethodBeat.o(78283);
        }
    };
    private boolean running = false;

    /* renamed from: com.tencent.mm.at.i$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ e fET;
        final /* synthetic */ int fEU;

        AnonymousClass6(e eVar, int i) {
            this.fET = eVar;
            this.fEU = i;
        }

        public final void run() {
            AppMethodBeat.i(78291);
            com.tencent.mm.kernel.g.RO().eJo.a(new l((int) this.fET.fDy, this.fEU, (byte) 0), 0);
            AppMethodBeat.o(78291);
        }
    }

    public interface a {
        void b(long j, int i, int i2);

        void k(long j, boolean z);
    }

    static /* synthetic */ void f(i iVar) {
        AppMethodBeat.i(78304);
        iVar.Fb();
        AppMethodBeat.o(78304);
    }

    static {
        AppMethodBeat.i(78305);
        AppMethodBeat.o(78305);
    }

    public static boolean lA(int i) {
        AppMethodBeat.i(78292);
        if (b.dnO() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE) {
            ab.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", Integer.valueOf(i), bo.dpG().toString());
        }
        boolean add = fEL.add(Integer.valueOf(i));
        AppMethodBeat.o(78292);
        return add;
    }

    public static boolean lB(int i) {
        AppMethodBeat.i(78293);
        if (b.dnO() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE) {
            ab.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", Integer.valueOf(i), bo.dpG().toString());
        }
        boolean remove = fEL.remove(Integer.valueOf(i));
        AppMethodBeat.o(78293);
        return remove;
    }

    public i() {
        AppMethodBeat.i(78294);
        com.tencent.mm.kernel.g.RQ();
        this.cra = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(78289);
                try {
                    i.e(i.this);
                } catch (Exception e) {
                    ab.e("MicroMsg.ImgService", "exception:%s", bo.l(e));
                }
                AppMethodBeat.o(78289);
                return false;
            }

            public final String toString() {
                AppMethodBeat.i(78290);
                String str = super.toString() + "|scenePusher";
                AppMethodBeat.o(78290);
                return str;
            }
        }, false);
        if (com.tencent.mm.kernel.g.RO().eJo != null) {
            com.tencent.mm.kernel.g.RO().eJo.a(110, (f) this);
        }
        this.fEM.clear();
        this.fEO = false;
        AppMethodBeat.o(78294);
    }

    public final void a(String str, String str2, ArrayList<String> arrayList, int i, boolean z) {
        AppMethodBeat.i(78295);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            ab.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", Boolean.valueOf(z), Integer.valueOf(r.g(str3, str2, z) ? 1 : 0));
            a(new l(str, str2, str3, r4, this, i, this.fEP));
        }
        AppMethodBeat.o(78295);
    }

    public final void a(ArrayList<Integer> arrayList, String str, String str2, ArrayList<String> arrayList2, int i, boolean z) {
        AppMethodBeat.i(78296);
        int i2 = 0;
        Iterator it = arrayList2.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                String str3 = (String) it.next();
                if (arrayList.size() <= i3) {
                    ab.w("MicroMsg.ImgService", "Wrong! origImgPath:%s size:%s", str3, Integer.valueOf(arrayList.size()));
                    AppMethodBeat.o(78296);
                    return;
                }
                int intValue = ((Integer) arrayList.get(i3)).intValue();
                i2 = i3 + 1;
                int i4 = r.g(str3, str2, z) ? 1 : 0;
                String str4 = "";
                e ly = o.ahl().ly(intValue);
                if (ly != null) {
                    str4 = ly.fDK;
                }
                l lVar = new l((long) intValue, str, str2, str3, i4, this, i, str4, "");
                lVar.fFv = new b(this.fEP);
                a(lVar);
            } else {
                AppMethodBeat.o(78296);
                return;
            }
        }
    }

    private void a(final l lVar) {
        AppMethodBeat.i(78297);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78284);
                ab.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", Boolean.valueOf(i.this.fEO), Integer.valueOf(lVar.hashCode()));
                if (i.this.fEO) {
                    i.this.fEM.offer(lVar);
                    AppMethodBeat.o(78284);
                    return;
                }
                com.tencent.mm.kernel.g.RO().eJo.a(lVar, 0);
                i.this.fEO = true;
                AppMethodBeat.o(78284);
            }
        });
        AppMethodBeat.o(78297);
    }

    public static void lC(int i) {
        AppMethodBeat.i(78298);
        ab.w("MicroMsg.ImgService", "setImgError, %d", Integer.valueOf(i));
        e ly = o.ahl().ly(i);
        if (ly == null || ly.fDy <= 0) {
            AppMethodBeat.o(78298);
            return;
        }
        bi jf;
        e lz = o.ahl().lz((int) ly.fDy);
        if (lz != null) {
            lz.setStatus(-1);
            lz.bJt = d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
            o.ahl().a((int) lz.fDy, lz);
            jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(lz.fDH);
        } else {
            ly.setStatus(-1);
            ly.bJt = d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
            o.ahl().a(i, ly);
            cy jf2 = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(ly.fDH);
        }
        if (jf2.field_msgId != ly.fDH) {
            AppMethodBeat.o(78298);
            return;
        }
        jf2.setStatus(5);
        e.pXa.a(111, 31, 1, true);
        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a((long) ((int) jf2.field_msgId), jf2);
        AppMethodBeat.o(78298);
    }

    public final void onSceneEnd(int i, int i2, String str, final m mVar) {
        AppMethodBeat.i(78299);
        ab.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof l) {
            l lVar = (l) mVar;
            if (!(this.fEN == null || lVar == null || lVar.csG == null)) {
                this.fEN.k(lVar.csG.field_msgId, lVar.csG.field_status != 5);
            }
        }
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78285);
                if (mVar.getType() != 110) {
                    AppMethodBeat.o(78285);
                } else if (mVar instanceof l) {
                    i.this.cqU = false;
                    int i = (int) ((l) mVar).fEX;
                    if (i.this.cqV > 0) {
                        i.e(i.this);
                    } else {
                        i.f(i.this);
                    }
                    i.lB(i);
                    AppMethodBeat.o(78285);
                } else {
                    AppMethodBeat.o(78285);
                }
            }

            public final String toString() {
                AppMethodBeat.i(78286);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(78286);
                return str;
            }
        });
        AppMethodBeat.o(78299);
    }

    private void Fb() {
        AppMethodBeat.i(78300);
        this.cqQ.clear();
        this.running = false;
        ab.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.cqZ.Mr());
        AppMethodBeat.o(78300);
    }

    public final void run() {
        AppMethodBeat.i(78301);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78287);
                long currentTimeMillis = System.currentTimeMillis() - i.this.cqW;
                if (i.this.running) {
                    if (currentTimeMillis < 60000) {
                        AppMethodBeat.o(78287);
                        return;
                    }
                    ab.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + i.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.this.running);
                }
                ab.i("MicroMsg.ImgService", "run from run");
                i.this.running = true;
                i.this.cqV = 3;
                i.this.cqZ.evE = SystemClock.elapsedRealtime();
                i.this.cra.ae(10, 10);
                AppMethodBeat.o(78287);
            }

            public final String toString() {
                AppMethodBeat.i(78288);
                String str = super.toString() + "|run";
                AppMethodBeat.o(78288);
                return str;
            }
        });
        AppMethodBeat.o(78301);
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(78302);
        l lVar = (l) mVar;
        if (!(this.fEN == null || lVar == null || lVar.csG == null)) {
            this.fEN.b(lVar.csG.field_msgId, i, i2);
        }
        AppMethodBeat.o(78302);
    }

    static /* synthetic */ void e(i iVar) {
        e eVar;
        AppMethodBeat.i(78303);
        iVar.cqW = System.currentTimeMillis();
        if (!iVar.cqU && iVar.cqQ.size() == 0) {
            List<e> agV = o.ahl().agV();
            if (agV == null || agV.size() == 0) {
                ab.i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
            } else {
                for (e eVar2 : agV) {
                    if (bo.isNullOrNil(eVar2.fDz)) {
                        ab.i("MicroMsg.ImgService", "the process is killed while selecting pic");
                    } else {
                        e lz = o.ahl().lz((int) eVar2.fDy);
                        if (fEL.contains(Integer.valueOf(lz == null ? (int) eVar2.fDy : (int) lz.fDy))) {
                            ab.d("MicroMsg.ImgService", "File is Already running:" + eVar2.fDy);
                        } else if (lz == null ? eVar2.fDH <= 0 || eVar2.cKK > 0 || eVar2.offset > eVar2.frO || eVar2.status == -1 : lz.fDH <= 0 || lz.cKK > 0 || eVar2.offset > eVar2.frO || eVar2.status == -1 || lz.status == -1) {
                            if (((long) (eVar2.fDG + 600)) < bo.anT()) {
                                lC((int) eVar2.fDy);
                            } else {
                                ab.i("MicroMsg.ImgService", "getNeedRunInfo queueSend add %s %s %s %s", Long.valueOf(eVar2.fDy), Boolean.valueOf(eVar2.agP()), Integer.valueOf(eVar2.offset), Integer.valueOf(eVar2.frO));
                                iVar.cqQ.add(eVar2);
                            }
                        }
                    }
                }
                iVar.cqQ.size();
            }
        }
        if (iVar.cqU || iVar.cqQ.size() > 0) {
            eVar2 = null;
            if (!iVar.cqU && iVar.cqQ.size() > 0) {
                e lz2;
                while (iVar.cqQ.size() > 0) {
                    eVar2 = (e) iVar.cqQ.poll();
                    lz2 = o.ahl().lz((int) eVar2.fDy);
                    if (fEL.contains(Integer.valueOf(lz2 == null ? (int) eVar2.fDy : (int) lz2.fDy))) {
                        eVar2 = null;
                    }
                }
                iVar.cqU = true;
                if (eVar2 != null && eVar2.fDy > 0) {
                    m lVar;
                    lz2 = o.ahl().lz((int) eVar2.fDy);
                    if (lz2 != null) {
                        ab.i("MicroMsg.ImgService", "try upload hdinfo %s", Long.valueOf(lz2.fDy));
                        lVar = new l((int) lz2.fDy, 1);
                    } else {
                        ab.i("MicroMsg.ImgService", "try upload normalinfo %s", Long.valueOf(eVar2.fDy));
                        lVar = new l((int) eVar2.fDy, 0);
                    }
                    com.tencent.mm.kernel.g.RO().eJo.a(lVar, 0);
                }
            }
            AppMethodBeat.o(78303);
            return;
        }
        iVar.Fb();
        ab.d("MicroMsg.ImgService", "No Data Any More , Stop Service");
        AppMethodBeat.o(78303);
    }
}
