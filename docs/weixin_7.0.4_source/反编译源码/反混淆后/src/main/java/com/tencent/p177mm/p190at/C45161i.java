package com.tencent.p177mm.p190at;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p190at.C9022l.C9023b;
import com.tencent.p177mm.p190at.C9022l.C9028a;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.tencent.mm.at.i */
public final class C45161i implements C1202f, C32231g {
    private static Set<Integer> fEL = new HashSet();
    private Queue<C25822e> cqQ = new LinkedList();
    private boolean cqU = false;
    int cqV = 0;
    private long cqW = 0;
    C1446a cqZ = new C1446a();
    private C7564ap cra;
    private LinkedList<C9022l> fEM = new LinkedList();
    public C17945a fEN = null;
    private boolean fEO = false;
    private C9028a fEP = new C417611();
    private boolean running = false;

    /* renamed from: com.tencent.mm.at.i$4 */
    class C179424 implements Runnable {
        C179424() {
        }

        public final void run() {
            AppMethodBeat.m2504i(78287);
            long currentTimeMillis = System.currentTimeMillis() - C45161i.this.cqW;
            if (C45161i.this.running) {
                if (currentTimeMillis < 60000) {
                    AppMethodBeat.m2505o(78287);
                    return;
                }
                C4990ab.m7412e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + C45161i.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C45161i.this.running);
            }
            C4990ab.m7416i("MicroMsg.ImgService", "run from run");
            C45161i.this.running = true;
            C45161i.this.cqV = 3;
            C45161i.this.cqZ.evE = SystemClock.elapsedRealtime();
            C45161i.this.cra.mo16770ae(10, 10);
            AppMethodBeat.m2505o(78287);
        }

        public final String toString() {
            AppMethodBeat.m2504i(78288);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(78288);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.at.i$5 */
    class C179435 implements C5015a {
        C179435() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78289);
            try {
                C45161i.m83140e(C45161i.this);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ImgService", "exception:%s", C5046bo.m7574l(e));
            }
            AppMethodBeat.m2505o(78289);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(78290);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.m2505o(78290);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.at.i$6 */
    class C179446 implements Runnable {
        final /* synthetic */ C25822e fET;
        final /* synthetic */ int fEU;

        C179446(C25822e c25822e, int i) {
            this.fET = c25822e;
            this.fEU = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(78291);
            C1720g.m3535RO().eJo.mo14541a(new C9022l((int) this.fET.fDy, this.fEU, (byte) 0), 0);
            AppMethodBeat.m2505o(78291);
        }
    }

    /* renamed from: com.tencent.mm.at.i$a */
    public interface C17945a {
        /* renamed from: b */
        void mo33481b(long j, int i, int i2);

        /* renamed from: k */
        void mo33482k(long j, boolean z);
    }

    /* renamed from: com.tencent.mm.at.i$1 */
    class C417611 implements C9028a {

        /* renamed from: com.tencent.mm.at.i$1$1 */
        class C12851 implements Runnable {
            C12851() {
            }

            public final void run() {
                AppMethodBeat.m2504i(78282);
                C4990ab.m7416i("MicroMsg.ImgService", "on image upload end. queue size : " + C45161i.this.fEM.size());
                C45161i.this.fEO = false;
                if (C45161i.this.fEM.size() > 0) {
                    C1207m c1207m = (C9022l) C45161i.this.fEM.poll();
                    if (c1207m != null) {
                        C4990ab.m7416i("MicroMsg.ImgService", "upload image scene hashcode : " + c1207m.hashCode());
                        C1720g.m3535RO().eJo.mo14541a(c1207m, 0);
                        C45161i.this.fEO = true;
                        AppMethodBeat.m2505o(78282);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.ImgService", "poll image scene is null");
                }
                AppMethodBeat.m2505o(78282);
            }
        }

        C417611() {
        }

        public final void agX() {
            AppMethodBeat.m2504i(78283);
            C1720g.m3537RQ();
            C1720g.m3539RS().mo10302aa(new C12851());
            AppMethodBeat.m2505o(78283);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m83141f(C45161i c45161i) {
        AppMethodBeat.m2504i(78304);
        c45161i.m83133Fb();
        AppMethodBeat.m2505o(78304);
    }

    static {
        AppMethodBeat.m2504i(78305);
        AppMethodBeat.m2505o(78305);
    }

    /* renamed from: lA */
    public static boolean m83147lA(int i) {
        AppMethodBeat.m2504i(78292);
        if (C4872b.dnO() || C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE) {
            C4990ab.m7417i("MicroMsg.ImgService", "setRun imgLocalId %s %s", Integer.valueOf(i), C5046bo.dpG().toString());
        }
        boolean add = fEL.add(Integer.valueOf(i));
        AppMethodBeat.m2505o(78292);
        return add;
    }

    /* renamed from: lB */
    public static boolean m83148lB(int i) {
        AppMethodBeat.m2504i(78293);
        if (C4872b.dnO() || C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE) {
            C4990ab.m7417i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", Integer.valueOf(i), C5046bo.dpG().toString());
        }
        boolean remove = fEL.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(78293);
        return remove;
    }

    public C45161i() {
        AppMethodBeat.m2504i(78294);
        C1720g.m3537RQ();
        this.cra = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C179435(), false);
        if (C1720g.m3535RO().eJo != null) {
            C1720g.m3535RO().eJo.mo14539a(110, (C1202f) this);
        }
        this.fEM.clear();
        this.fEO = false;
        AppMethodBeat.m2505o(78294);
    }

    /* renamed from: a */
    public final void mo73126a(String str, String str2, ArrayList<String> arrayList, int i, boolean z) {
        AppMethodBeat.m2504i(78295);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            C4990ab.m7419v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", Boolean.valueOf(z), Integer.valueOf(C1853r.m3854g(str3, str2, z) ? 1 : 0));
            m83135a(new C9022l(str, str2, str3, r4, this, i, this.fEP));
        }
        AppMethodBeat.m2505o(78295);
    }

    /* renamed from: a */
    public final void mo73127a(ArrayList<Integer> arrayList, String str, String str2, ArrayList<String> arrayList2, int i, boolean z) {
        AppMethodBeat.m2504i(78296);
        int i2 = 0;
        Iterator it = arrayList2.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                String str3 = (String) it.next();
                if (arrayList.size() <= i3) {
                    C4990ab.m7421w("MicroMsg.ImgService", "Wrong! origImgPath:%s size:%s", str3, Integer.valueOf(arrayList.size()));
                    AppMethodBeat.m2505o(78296);
                    return;
                }
                int intValue = ((Integer) arrayList.get(i3)).intValue();
                i2 = i3 + 1;
                int i4 = C1853r.m3854g(str3, str2, z) ? 1 : 0;
                String str4 = "";
                C25822e ly = C32291o.ahl().mo73116ly(intValue);
                if (ly != null) {
                    str4 = ly.fDK;
                }
                C9022l c9022l = new C9022l((long) intValue, str, str2, str3, i4, this, i, str4, "");
                c9022l.fFv = new C9023b(this.fEP);
                m83135a(c9022l);
            } else {
                AppMethodBeat.m2505o(78296);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m83135a(final C9022l c9022l) {
        AppMethodBeat.m2504i(78297);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78284);
                C4990ab.m7417i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", Boolean.valueOf(C45161i.this.fEO), Integer.valueOf(c9022l.hashCode()));
                if (C45161i.this.fEO) {
                    C45161i.this.fEM.offer(c9022l);
                    AppMethodBeat.m2505o(78284);
                    return;
                }
                C1720g.m3535RO().eJo.mo14541a(c9022l, 0);
                C45161i.this.fEO = true;
                AppMethodBeat.m2505o(78284);
            }
        });
        AppMethodBeat.m2505o(78297);
    }

    /* renamed from: lC */
    public static void m83149lC(int i) {
        AppMethodBeat.m2504i(78298);
        C4990ab.m7421w("MicroMsg.ImgService", "setImgError, %d", Integer.valueOf(i));
        C25822e ly = C32291o.ahl().mo73116ly(i);
        if (ly == null || ly.fDy <= 0) {
            AppMethodBeat.m2505o(78298);
            return;
        }
        C7620bi jf;
        C25822e lz = C32291o.ahl().mo73117lz((int) ly.fDy);
        if (lz != null) {
            lz.setStatus(-1);
            lz.bJt = C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
            C32291o.ahl().mo73076a((int) lz.fDy, lz);
            jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(lz.fDH);
        } else {
            ly.setStatus(-1);
            ly.bJt = C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
            C32291o.ahl().mo73076a(i, ly);
            C6575cy jf2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(ly.fDH);
        }
        if (jf2.field_msgId != ly.fDH) {
            AppMethodBeat.m2505o(78298);
            return;
        }
        jf2.setStatus(5);
        C7053e.pXa.mo8378a(111, 31, 1, true);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) ((int) jf2.field_msgId), jf2);
        AppMethodBeat.m2505o(78298);
    }

    public final void onSceneEnd(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(78299);
        C4990ab.m7417i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C9022l) {
            C9022l c9022l = (C9022l) c1207m;
            if (!(this.fEN == null || c9022l == null || c9022l.csG == null)) {
                this.fEN.mo33482k(c9022l.csG.field_msgId, c9022l.csG.field_status != 5);
            }
        }
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78285);
                if (c1207m.getType() != 110) {
                    AppMethodBeat.m2505o(78285);
                } else if (c1207m instanceof C9022l) {
                    C45161i.this.cqU = false;
                    int i = (int) ((C9022l) c1207m).fEX;
                    if (C45161i.this.cqV > 0) {
                        C45161i.m83140e(C45161i.this);
                    } else {
                        C45161i.m83141f(C45161i.this);
                    }
                    C45161i.m83148lB(i);
                    AppMethodBeat.m2505o(78285);
                } else {
                    AppMethodBeat.m2505o(78285);
                }
            }

            public final String toString() {
                AppMethodBeat.m2504i(78286);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.m2505o(78286);
                return str;
            }
        });
        AppMethodBeat.m2505o(78299);
    }

    /* renamed from: Fb */
    private void m83133Fb() {
        AppMethodBeat.m2504i(78300);
        this.cqQ.clear();
        this.running = false;
        C4990ab.m7410d("MicroMsg.ImgService", "Finish service use time(ms):" + this.cqZ.mo4908Mr());
        AppMethodBeat.m2505o(78300);
    }

    public final void run() {
        AppMethodBeat.m2504i(78301);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C179424());
        AppMethodBeat.m2505o(78301);
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(78302);
        C9022l c9022l = (C9022l) c1207m;
        if (!(this.fEN == null || c9022l == null || c9022l.csG == null)) {
            this.fEN.mo33481b(c9022l.csG.field_msgId, i, i2);
        }
        AppMethodBeat.m2505o(78302);
    }

    /* renamed from: e */
    static /* synthetic */ void m83140e(C45161i c45161i) {
        C25822e c25822e;
        AppMethodBeat.m2504i(78303);
        c45161i.cqW = System.currentTimeMillis();
        if (!c45161i.cqU && c45161i.cqQ.size() == 0) {
            List<C25822e> agV = C32291o.ahl().agV();
            if (agV == null || agV.size() == 0) {
                C4990ab.m7416i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
            } else {
                for (C25822e c25822e2 : agV) {
                    if (C5046bo.isNullOrNil(c25822e2.fDz)) {
                        C4990ab.m7416i("MicroMsg.ImgService", "the process is killed while selecting pic");
                    } else {
                        C25822e lz = C32291o.ahl().mo73117lz((int) c25822e2.fDy);
                        if (fEL.contains(Integer.valueOf(lz == null ? (int) c25822e2.fDy : (int) lz.fDy))) {
                            C4990ab.m7410d("MicroMsg.ImgService", "File is Already running:" + c25822e2.fDy);
                        } else if (lz == null ? c25822e2.fDH <= 0 || c25822e2.cKK > 0 || c25822e2.offset > c25822e2.frO || c25822e2.status == -1 : lz.fDH <= 0 || lz.cKK > 0 || c25822e2.offset > c25822e2.frO || c25822e2.status == -1 || lz.status == -1) {
                            if (((long) (c25822e2.fDG + 600)) < C5046bo.anT()) {
                                C45161i.m83149lC((int) c25822e2.fDy);
                            } else {
                                C4990ab.m7417i("MicroMsg.ImgService", "getNeedRunInfo queueSend add %s %s %s %s", Long.valueOf(c25822e2.fDy), Boolean.valueOf(c25822e2.agP()), Integer.valueOf(c25822e2.offset), Integer.valueOf(c25822e2.frO));
                                c45161i.cqQ.add(c25822e2);
                            }
                        }
                    }
                }
                c45161i.cqQ.size();
            }
        }
        if (c45161i.cqU || c45161i.cqQ.size() > 0) {
            c25822e2 = null;
            if (!c45161i.cqU && c45161i.cqQ.size() > 0) {
                C25822e lz2;
                while (c45161i.cqQ.size() > 0) {
                    c25822e2 = (C25822e) c45161i.cqQ.poll();
                    lz2 = C32291o.ahl().mo73117lz((int) c25822e2.fDy);
                    if (fEL.contains(Integer.valueOf(lz2 == null ? (int) c25822e2.fDy : (int) lz2.fDy))) {
                        c25822e2 = null;
                    }
                }
                c45161i.cqU = true;
                if (c25822e2 != null && c25822e2.fDy > 0) {
                    C1207m c9022l;
                    lz2 = C32291o.ahl().mo73117lz((int) c25822e2.fDy);
                    if (lz2 != null) {
                        C4990ab.m7417i("MicroMsg.ImgService", "try upload hdinfo %s", Long.valueOf(lz2.fDy));
                        c9022l = new C9022l((int) lz2.fDy, 1);
                    } else {
                        C4990ab.m7417i("MicroMsg.ImgService", "try upload normalinfo %s", Long.valueOf(c25822e2.fDy));
                        c9022l = new C9022l((int) c25822e2.fDy, 0);
                    }
                    C1720g.m3535RO().eJo.mo14541a(c9022l, 0);
                }
            }
            AppMethodBeat.m2505o(78303);
            return;
        }
        c45161i.m83133Fb();
        C4990ab.m7410d("MicroMsg.ImgService", "No Data Any More , Stop Service");
        AppMethodBeat.m2505o(78303);
    }
}
