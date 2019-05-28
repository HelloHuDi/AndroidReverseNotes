package com.tencent.mm.ui.chatting.c;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.f;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.me;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.q;

@com.tencent.mm.ui.chatting.c.a.a(dFp = q.class)
public class s extends a implements com.tencent.mm.at.d.a, com.tencent.mm.platformtools.x.a, q {
    private c kvj = new c<au>() {
        {
            AppMethodBeat.i(31453);
            this.xxI = au.class.getName().hashCode();
            AppMethodBeat.o(31453);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(31454);
            au auVar = (au) bVar;
            if (auVar instanceof au) {
                s.a(s.this, auVar.ctR.csG, auVar);
            }
            AppMethodBeat.o(31454);
            return false;
        }
    };
    private ap yQf = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(31455);
            if (s.this.cgL == null) {
                AppMethodBeat.o(31455);
            } else {
                boolean bZv = com.tencent.mm.plugin.priority.a.a.a.a.bZv();
                int lastVisiblePosition = s.this.cgL.getLastVisiblePosition() - s.this.cgL.getHeaderViewsCount();
                h hVar = (h) s.this.cgL.aF(h.class);
                int max = Math.max(s.this.cgL.getFirstVisiblePosition() - s.this.cgL.getHeaderViewsCount(), 0);
                int max2 = Math.max(Math.min(lastVisiblePosition, hVar.getCount()), 0);
                ab.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + max + " last: " + max2);
                if (max2 < max) {
                    ab.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
                    s.this.yQf.ae(1000, 1000);
                    AppMethodBeat.o(31455);
                } else {
                    o.ahm().fDr = true;
                    for (lastVisiblePosition = max; lastVisiblePosition <= max2; lastVisiblePosition++) {
                        bi Ou = hVar.Ou(lastVisiblePosition);
                        if (Ou != null && Ou.field_isSend == 0 && Ou.drE()) {
                            e fI = o.ahl().fI(Ou.field_msgSvrId);
                            if (!(fI.agP() || Ou.dJF == 2)) {
                                if (Ou.dJF != 1) {
                                    if (bZv) {
                                        com.tencent.mm.modelcontrol.c.afC();
                                        if (!com.tencent.mm.modelcontrol.c.u(Ou)) {
                                        }
                                    }
                                }
                                ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).a(Ou, new a(Ou, fI, lastVisiblePosition));
                            }
                        }
                    }
                    o.ahm().agN();
                    AppMethodBeat.o(31455);
                }
            }
            return false;
        }
    }, false);
    private com.tencent.mm.ui.chatting.gallery.g yQg = com.tencent.mm.ui.chatting.gallery.g.a.yVD;

    class a implements Runnable {
        private bi cKd;
        private int i;
        private e pza;

        a(bi biVar, e eVar, int i) {
            this.cKd = biVar;
            this.pza = eVar;
            this.i = i;
        }

        public final void run() {
            AppMethodBeat.i(31457);
            f.afx().fyQ.add("image_" + this.cKd.field_msgId);
            o.ahm().a(this.pza.fDy, this.cKd.field_msgId, 0, Integer.valueOf(this.i), R.drawable.b0p, s.this, -1, true);
            AppMethodBeat.o(31457);
        }
    }

    public s() {
        AppMethodBeat.i(31458);
        AppMethodBeat.o(31458);
    }

    public final void startTimer() {
        AppMethodBeat.i(31459);
        this.yQf.stopTimer();
        this.yQf.ae(1000, 1000);
        AppMethodBeat.o(31459);
    }

    private void stopTimer() {
        AppMethodBeat.i(31460);
        if (aw.RK()) {
            o.ahm().a((com.tencent.mm.at.d.a) this);
        }
        this.yQf.stopTimer();
        AppMethodBeat.o(31460);
    }

    private void djt() {
        AppMethodBeat.i(31461);
        stopTimer();
        com.tencent.mm.sdk.b.a.xxA.d(this.kvj);
        com.tencent.mm.ui.chatting.gallery.g gVar = this.yQg;
        gVar.mQM.clear();
        gVar.bCH();
        AppMethodBeat.o(31461);
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(31462);
        if (!com.tencent.mm.plugin.priority.a.a.a.a.bZv()) {
            o.ahm().a((com.tencent.mm.at.d.a) this);
        }
        boolean z = i3 == 0 && i4 == 0;
        ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, z, false);
        if (com.tencent.mm.plugin.priority.a.a.a.bZu()) {
            o.ahn();
            com.tencent.mm.at.b.a(j, j2, z);
        } else {
            ((com.tencent.mm.plugin.priority.a.a) g.M(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().b(j, j2, z);
        }
        aw.ZK();
        ((h) this.cgL.aF(h.class)).a(j2, com.tencent.mm.model.c.XO().jf(j2), z);
        AppMethodBeat.o(31462);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.i(31463);
        ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, false, true);
        AppMethodBeat.o(31463);
    }

    public final void m(String str, Bitmap bitmap) {
        AppMethodBeat.i(31464);
        if (bo.isNullOrNil(str) || bitmap == null || this.cgL == null) {
            AppMethodBeat.o(31464);
            return;
        }
        com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31456);
                if (s.this.cgL != null) {
                    s.this.cgL.aWv();
                }
                AppMethodBeat.o(31456);
            }
        });
        AppMethodBeat.o(31464);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(31465);
        super.onScrollStateChanged(absListView, i);
        o.ahp().cm(i);
        if (i == 0) {
            startTimer();
            AppMethodBeat.o(31465);
            return;
        }
        if (i == 2) {
            stopTimer();
        }
        AppMethodBeat.o(31465);
    }

    public final void dDh() {
        AppMethodBeat.i(31466);
        super.dDh();
        djt();
        AppMethodBeat.o(31466);
    }

    public final void dxy() {
    }

    public final void dxC() {
        AppMethodBeat.i(31470);
        djt();
        AppMethodBeat.o(31470);
    }

    public final void dxz() {
        AppMethodBeat.i(31467);
        com.tencent.mm.sdk.b.a.xxA.c(this.kvj);
        AppMethodBeat.o(31467);
    }

    public final void dxA() {
        AppMethodBeat.i(31468);
        b meVar = new me();
        meVar.cHX.cHY = true;
        meVar.cHX.talker = this.cgL.sRl.field_username;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, Looper.getMainLooper());
        x.b((com.tencent.mm.platformtools.x.a) this);
        AppMethodBeat.o(31468);
    }

    public final void dxB() {
        AppMethodBeat.i(31469);
        b meVar = new me();
        meVar.cHX.cHY = false;
        meVar.cHX.talker = this.cgL.sRl.field_username;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, Looper.getMainLooper());
        x.c((com.tencent.mm.platformtools.x.a) this);
        stopTimer();
        AppMethodBeat.o(31469);
    }

    static /* synthetic */ void a(s sVar, bi biVar, au auVar) {
        AppMethodBeat.i(31471);
        int firstVisiblePosition = sVar.cgL.getListView().getFirstVisiblePosition();
        int lastVisiblePosition = sVar.cgL.getListView().getLastVisiblePosition();
        int max = Math.max(firstVisiblePosition, 0);
        int max2 = Math.max(lastVisiblePosition, 0);
        if (max < 0 || max2 >= sVar.cgL.getListView().getAdapter().getCount()) {
            ab.i("MicroMsg.ChattingUI.GetImageComponent", "invalid position %d-%d, cnt:%d", Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(sVar.cgL.getListView().getAdapter().getCount()));
            AppMethodBeat.o(31471);
            return;
        }
        for (lastVisiblePosition = max; lastVisiblePosition <= max2; lastVisiblePosition++) {
            bi biVar2 = (bi) sVar.cgL.getListView().getAdapter().getItem(lastVisiblePosition);
            if (!(biVar == null || biVar2 == null || biVar2.field_msgId != biVar.field_msgId)) {
                View childAt = sVar.cgL.getChildAt(lastVisiblePosition - max);
                if (childAt == null) {
                    ab.e("MicroMsg.ChattingUI.GetImageComponent", "[getPhotoInfo] getChildAt(%d)", Integer.valueOf((lastVisiblePosition - max) + sVar.cgL.getHeaderViewsCount()));
                } else {
                    View view = null;
                    if (biVar.drE() || biVar.bws() || biVar.bwt()) {
                        view = childAt.findViewById(R.id.aqy);
                    } else if (biVar.dtA()) {
                        view = childAt.findViewById(R.id.apt);
                    }
                    if (view != null) {
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        auVar.ctS.ctT = iArr[0];
                        auVar.ctS.ctU = iArr[1];
                        auVar.ctS.ctV = view.getWidth();
                        auVar.ctS.ctW = view.getHeight();
                    }
                }
            }
        }
        AppMethodBeat.o(31471);
    }
}
