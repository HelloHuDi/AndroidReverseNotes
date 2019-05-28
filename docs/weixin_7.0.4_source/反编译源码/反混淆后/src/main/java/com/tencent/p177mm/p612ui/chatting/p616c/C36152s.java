package com.tencent.p177mm.p612ui.chatting.p616c;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelcontrol.C37938c;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25820b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18322me;
import com.tencent.p177mm.p230g.p231a.C41968au;
import com.tencent.p177mm.p612ui.chatting.gallery.C15656g;
import com.tencent.p177mm.p612ui.chatting.gallery.C15656g.C5340a;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30470q;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.plugin.priority.p1407a.C43371a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.C43370a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.p1409a.C39485a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;

@C15590a(dFp = C30470q.class)
/* renamed from: com.tencent.mm.ui.chatting.c.s */
public class C36152s extends C44291a implements C9017a, C18765a, C30470q {
    private C4884c kvj = new C304891();
    private C7564ap yQf = new C7564ap(new C237622(), false);
    private C15656g yQg = C5340a.yVD;

    /* renamed from: com.tencent.mm.ui.chatting.c.s$2 */
    class C237622 implements C5015a {
        C237622() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(31455);
            if (C36152s.this.cgL == null) {
                AppMethodBeat.m2505o(31455);
            } else {
                boolean bZv = C39485a.bZv();
                int lastVisiblePosition = C36152s.this.cgL.getLastVisiblePosition() - C36152s.this.cgL.getHeaderViewsCount();
                C15612h c15612h = (C15612h) C36152s.this.cgL.mo74857aF(C15612h.class);
                int max = Math.max(C36152s.this.cgL.getFirstVisiblePosition() - C36152s.this.cgL.getHeaderViewsCount(), 0);
                int max2 = Math.max(Math.min(lastVisiblePosition, c15612h.getCount()), 0);
                C4990ab.m7410d("MicroMsg.ChattingUI.GetImageComponent", "first: " + max + " last: " + max2);
                if (max2 < max) {
                    C4990ab.m7410d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
                    C36152s.this.yQf.mo16770ae(1000, 1000);
                    AppMethodBeat.m2505o(31455);
                } else {
                    C32291o.ahm().fDr = true;
                    for (lastVisiblePosition = max; lastVisiblePosition <= max2; lastVisiblePosition++) {
                        C7620bi Ou = c15612h.mo27798Ou(lastVisiblePosition);
                        if (Ou != null && Ou.field_isSend == 0 && Ou.drE()) {
                            C25822e fI = C32291o.ahl().mo73112fI(Ou.field_msgSvrId);
                            if (!(fI.agP() || Ou.dJF == 2)) {
                                if (Ou.dJF != 1) {
                                    if (bZv) {
                                        C37938c.afC();
                                        if (!C37938c.m64122u(Ou)) {
                                        }
                                    }
                                }
                                ((C20286b) C1720g.m3528K(C20286b.class)).mo35524a(Ou, new C36151a(Ou, fI, lastVisiblePosition));
                            }
                        }
                    }
                    C32291o.ahm().agN();
                    AppMethodBeat.m2505o(31455);
                }
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.s$1 */
    class C304891 extends C4884c<C41968au> {
        C304891() {
            AppMethodBeat.m2504i(31453);
            this.xxI = C41968au.class.getName().hashCode();
            AppMethodBeat.m2505o(31453);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(31454);
            C41968au c41968au = (C41968au) c4883b;
            if (c41968au instanceof C41968au) {
                C36152s.m59504a(C36152s.this, c41968au.ctR.csG, c41968au);
            }
            AppMethodBeat.m2505o(31454);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.s$3 */
    class C304903 implements Runnable {
        C304903() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31456);
            if (C36152s.this.cgL != null) {
                C36152s.this.cgL.aWv();
            }
            AppMethodBeat.m2505o(31456);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.s$a */
    class C36151a implements Runnable {
        private C7620bi cKd;
        /* renamed from: i */
        private int f15086i;
        private C25822e pza;

        C36151a(C7620bi c7620bi, C25822e c25822e, int i) {
            this.cKd = c7620bi;
            this.pza = c25822e;
            this.f15086i = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(31457);
            C37461f.afx().fyQ.add("image_" + this.cKd.field_msgId);
            C32291o.ahm().mo33463a(this.pza.fDy, this.cKd.field_msgId, 0, Integer.valueOf(this.f15086i), C25738R.drawable.b0p, C36152s.this, -1, true);
            AppMethodBeat.m2505o(31457);
        }
    }

    public C36152s() {
        AppMethodBeat.m2504i(31458);
        AppMethodBeat.m2505o(31458);
    }

    public final void startTimer() {
        AppMethodBeat.m2504i(31459);
        this.yQf.stopTimer();
        this.yQf.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(31459);
    }

    private void stopTimer() {
        AppMethodBeat.m2504i(31460);
        if (C9638aw.m17179RK()) {
            C32291o.ahm().mo33465a((C9017a) this);
        }
        this.yQf.stopTimer();
        AppMethodBeat.m2505o(31460);
    }

    private void djt() {
        AppMethodBeat.m2504i(31461);
        stopTimer();
        C4879a.xxA.mo10053d(this.kvj);
        C15656g c15656g = this.yQg;
        c15656g.mQM.clear();
        c15656g.bCH();
        AppMethodBeat.m2505o(31461);
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(31462);
        if (!C39485a.bZv()) {
            C32291o.ahm().mo33465a((C9017a) this);
        }
        boolean z = i3 == 0 && i4 == 0;
        ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, z, false);
        if (C43370a.bZu()) {
            C32291o.ahn();
            C25820b.m41100a(j, j2, z);
        } else {
            ((C43371a) C1720g.m3530M(C43371a.class)).getC2CImgAutoDownloader().mo46809b(j, j2, z);
        }
        C9638aw.m17190ZK();
        ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27802a(j2, C18628c.m29080XO().mo15340jf(j2), z);
        AppMethodBeat.m2505o(31462);
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(31463);
        ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, false, true);
        AppMethodBeat.m2505o(31463);
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(31464);
        if (C5046bo.isNullOrNil(str) || bitmap == null || this.cgL == null) {
            AppMethodBeat.m2505o(31464);
            return;
        }
        C46650a.dFz().post(new C304903());
        AppMethodBeat.m2505o(31464);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(31465);
        super.onScrollStateChanged(absListView, i);
        C32291o.ahp().mo43773cm(i);
        if (i == 0) {
            startTimer();
            AppMethodBeat.m2505o(31465);
            return;
        }
        if (i == 2) {
            stopTimer();
        }
        AppMethodBeat.m2505o(31465);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31466);
        super.dDh();
        djt();
        AppMethodBeat.m2505o(31466);
    }

    public final void dxy() {
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31470);
        djt();
        AppMethodBeat.m2505o(31470);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31467);
        C4879a.xxA.mo10052c(this.kvj);
        AppMethodBeat.m2505o(31467);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31468);
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = true;
        c18322me.cHX.talker = this.cgL.sRl.field_username;
        C4879a.xxA.mo10048a(c18322me, Looper.getMainLooper());
        C18764x.m29328b((C18765a) this);
        AppMethodBeat.m2505o(31468);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31469);
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = false;
        c18322me.cHX.talker = this.cgL.sRl.field_username;
        C4879a.xxA.mo10048a(c18322me, Looper.getMainLooper());
        C18764x.m29330c((C18765a) this);
        stopTimer();
        AppMethodBeat.m2505o(31469);
    }

    /* renamed from: a */
    static /* synthetic */ void m59504a(C36152s c36152s, C7620bi c7620bi, C41968au c41968au) {
        AppMethodBeat.m2504i(31471);
        int firstVisiblePosition = c36152s.cgL.getListView().getFirstVisiblePosition();
        int lastVisiblePosition = c36152s.cgL.getListView().getLastVisiblePosition();
        int max = Math.max(firstVisiblePosition, 0);
        int max2 = Math.max(lastVisiblePosition, 0);
        if (max < 0 || max2 >= c36152s.cgL.getListView().getAdapter().getCount()) {
            C4990ab.m7417i("MicroMsg.ChattingUI.GetImageComponent", "invalid position %d-%d, cnt:%d", Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(c36152s.cgL.getListView().getAdapter().getCount()));
            AppMethodBeat.m2505o(31471);
            return;
        }
        for (lastVisiblePosition = max; lastVisiblePosition <= max2; lastVisiblePosition++) {
            C7620bi c7620bi2 = (C7620bi) c36152s.cgL.getListView().getAdapter().getItem(lastVisiblePosition);
            if (!(c7620bi == null || c7620bi2 == null || c7620bi2.field_msgId != c7620bi.field_msgId)) {
                View childAt = c36152s.cgL.getChildAt(lastVisiblePosition - max);
                if (childAt == null) {
                    C4990ab.m7413e("MicroMsg.ChattingUI.GetImageComponent", "[getPhotoInfo] getChildAt(%d)", Integer.valueOf((lastVisiblePosition - max) + c36152s.cgL.getHeaderViewsCount()));
                } else {
                    View view = null;
                    if (c7620bi.drE() || c7620bi.bws() || c7620bi.bwt()) {
                        view = childAt.findViewById(2131822578);
                    } else if (c7620bi.dtA()) {
                        view = childAt.findViewById(2131822536);
                    }
                    if (view != null) {
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        c41968au.ctS.ctT = iArr[0];
                        c41968au.ctS.ctU = iArr[1];
                        c41968au.ctS.ctV = view.getWidth();
                        c41968au.ctS.ctW = view.getHeight();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(31471);
    }
}
