package com.tencent.p177mm.plugin.fav.p408b.p409e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.fav.p407a.C11850al;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C34130u;
import com.tencent.p177mm.plugin.fav.p407a.C43057f;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.protocal.protobuf.aav;
import com.tencent.p177mm.protocal.protobuf.bca;
import com.tencent.p177mm.protocal.protobuf.bcd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.b.e.c */
public final class C20683c implements C1202f, C34130u {
    public Map<String, C11860a> mhd = new HashMap();

    /* renamed from: com.tencent.mm.plugin.fav.b.e.c$a */
    static class C11860a {
        int mgq;
        C43057f mgr;
        int retryCount;
        long time;

        private C11860a() {
        }

        /* synthetic */ C11860a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.c$1 */
    class C206841 implements Runnable {
        C206841() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5362);
            List<C43057f> buQ = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavEditInfoStorage().buQ();
            if (buQ == null) {
                AppMethodBeat.m2505o(5362);
                return;
            }
            C4990ab.m7417i("MicroMsg.Fav.FavEditService", "infos size %d", Integer.valueOf(buQ.size()));
            for (C43057f c43057f : buQ) {
                String x = C20683c.m31928x(c43057f.field_localId, c43057f.field_type);
                C11860a c11860a = (C11860a) C20683c.this.mhd.get(x);
                if (c11860a == null) {
                    C4990ab.m7417i("MicroMsg.Fav.FavEditService", "not match key %s", x);
                    c11860a = new C11860a();
                    c11860a.mgr = c43057f;
                    c11860a.retryCount = 3;
                    c11860a.time = SystemClock.elapsedRealtime();
                    C20683c.this.mhd.put(x, c11860a);
                    C20683c.m31927a(c11860a, true);
                } else {
                    C4990ab.m7417i("MicroMsg.Fav.FavEditService", "match key %s, check start", x);
                    C20683c.m31927a(c11860a, false);
                }
            }
            AppMethodBeat.m2505o(5362);
        }

        public final String toString() {
            AppMethodBeat.m2504i(5363);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(5363);
            return str;
        }
    }

    public C20683c() {
        AppMethodBeat.m2504i(5366);
        C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetAgcRxOn, (C1202f) this);
        C1720g.m3540Rg().mo14539a(401, (C1202f) this);
        AppMethodBeat.m2505o(5366);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(5367);
        if (c1207m == null) {
            AppMethodBeat.m2505o(5367);
            return;
        }
        C4990ab.m7417i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
        if (c1207m.getType() == 401) {
            C4990ab.m7416i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
            run();
            AppMethodBeat.m2505o(5367);
            return;
        }
        C11850al c11850al = (C11850al) c1207m;
        if (c11850al.type != 0) {
            long j;
            int size;
            if (i == 0 && i2 == 0) {
                C4990ab.m7417i("MicroMsg.Fav.FavEditService", "clear job, key %s", C20683c.m31928x(c11850al.bvg(), c11850al.bvh()));
                this.mhd.remove(r0);
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavEditInfoStorage().mo54698s(c11850al.bvg(), c11850al.bvh());
                C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c11850al.bvg());
                if (iE != null) {
                    int i3;
                    j = (long) iE.field_id;
                    size = iE.field_tagProto.wiJ.size();
                    if (c11850al.mgr == null) {
                        i3 = 1;
                    } else {
                        i3 = c11850al.mgr.field_scene;
                    }
                    C27968h.m44532k(j, size, i3);
                }
                AppMethodBeat.m2505o(5367);
                return;
            }
            C4990ab.m7417i("MicroMsg.Fav.FavEditService", "retry job, key %s", C20683c.m31928x(c11850al.bvg(), c11850al.bvh()));
            final C11860a c11860a = (C11860a) this.mhd.get(r0);
            if (c11860a == null) {
                C4990ab.m7421w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", Long.valueOf(j), Integer.valueOf(size));
                AppMethodBeat.m2505o(5367);
                return;
            }
            C1720g.m3539RS().mo10310m(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(5364);
                    C20683c.m31927a(c11860a, false);
                    AppMethodBeat.m2505o(5364);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(5365);
                    String str = super.toString() + "|retryJob";
                    AppMethodBeat.m2505o(5365);
                    return str;
                }
            }, 3000);
        }
        AppMethodBeat.m2505o(5367);
    }

    public final void run() {
        AppMethodBeat.m2504i(5368);
        C1720g.m3539RS().mo10302aa(new C206841());
        AppMethodBeat.m2505o(5368);
    }

    /* renamed from: x */
    public static String m31928x(long j, int i) {
        AppMethodBeat.m2504i(5369);
        String str = j + "&&" + i;
        AppMethodBeat.m2505o(5369);
        return str;
    }

    /* renamed from: a */
    public final void mo35979a(long j, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, int i) {
        C43057f c43057f;
        int i2;
        AppMethodBeat.m2504i(5370);
        C4990ab.m7417i("MicroMsg.Fav.FavEditService", "addTag %d", Long.valueOf(j));
        C43057f iD = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavEditInfoStorage().mo54697iD(j);
        if (iD == null) {
            c43057f = new C43057f();
            i2 = 1;
        } else {
            c43057f = iD;
            i2 = 0;
        }
        c43057f.field_localId = j;
        aav aav = new aav();
        aav.mgt = linkedList;
        aav.wie = linkedList2;
        c43057f.field_modItem = aav;
        c43057f.field_time = C5046bo.anU();
        c43057f.field_type = 0;
        c43057f.field_scene = i;
        if (i2 != 0) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavEditInfoStorage().mo54694a(c43057f);
        } else {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavEditInfoStorage().mo54695a(c43057f, "localId");
        }
        run();
        AppMethodBeat.m2505o(5370);
    }

    /* renamed from: a */
    static /* synthetic */ void m31927a(C11860a c11860a, boolean z) {
        AppMethodBeat.m2504i(5371);
        c11860a.retryCount--;
        if (c11860a.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - c11860a.time < 7200000) {
                C4990ab.m7417i("MicroMsg.Fav.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", Integer.valueOf(c11860a.mgq), Long.valueOf(c11860a.mgr.field_localId), Integer.valueOf(c11860a.mgr.field_type));
                AppMethodBeat.m2505o(5371);
                return;
            }
            c11860a.time = SystemClock.elapsedRealtime();
            c11860a.retryCount = 3;
        }
        if (c11860a.mgq <= 0) {
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c11860a.mgr.field_localId);
            if (iE == null || iE.field_id <= 0) {
                C4990ab.m7421w("MicroMsg.Fav.FavEditService", "want to start mod item, but favid is invalid, local id %d", Long.valueOf(c11860a.mgr.field_localId));
                AppMethodBeat.m2505o(5371);
                return;
            }
            c11860a.mgq = iE.field_id;
            C4990ab.m7417i("MicroMsg.Fav.FavEditService", "want mod item, find id %d by local id %d", Integer.valueOf(c11860a.mgq), Long.valueOf(c11860a.mgr.field_localId));
        } else if (!z) {
            C4990ab.m7421w("MicroMsg.Fav.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", Integer.valueOf(c11860a.mgq));
            AppMethodBeat.m2505o(5371);
            return;
        }
        C4990ab.m7417i("MicroMsg.Fav.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", Boolean.valueOf(z), Integer.valueOf(c11860a.mgq), Integer.valueOf(c11860a.mgr.field_type));
        C1720g.m3540Rg().mo14541a(new C11850al(c11860a.mgq, c11860a.mgr), 0);
        AppMethodBeat.m2505o(5371);
    }
}
