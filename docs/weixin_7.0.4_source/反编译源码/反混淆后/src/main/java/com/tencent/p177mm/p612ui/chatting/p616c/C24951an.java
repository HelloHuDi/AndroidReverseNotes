package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p203bg.C1310f;
import com.tencent.p177mm.p203bg.C32335a;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p231a.C45322ez;
import com.tencent.p177mm.p612ui.MultiTalkRoomPopupNav;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.TalkRoomPopupNav;
import com.tencent.p177mm.p612ui.base.TalkRoomPopupNav.C155274;
import com.tencent.p177mm.p612ui.base.TalkRoomPopupNav.C36068a;
import com.tencent.p177mm.p612ui.base.TalkRoomPopupNav.C52695;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40723af;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46643s;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p837bh.C17983c;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.multitalk.model.C39419a;
import com.tencent.p177mm.plugin.multitalk.model.C39419a.C39420a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

@C15590a(dFp = C40723af.class)
/* renamed from: com.tencent.mm.ui.chatting.c.an */
public class C24951an extends C44291a implements C32335a, C17983c, C39420a, C40723af {
    private final C4931a yOu = new C249551();
    public TalkRoomPopupNav ySA;
    public MultiTalkRoomPopupNav ySB;
    private C36068a ySC = new C249547();

    /* renamed from: com.tencent.mm.ui.chatting.c.an$8 */
    class C53118 implements OnClickListener {
        C53118() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31755);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(31755);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$10 */
    class C2371610 implements OnClickListener {
        C2371610() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31757);
            C42062sz c42062sz = new C42062sz();
            c42062sz.cPf.cPi = true;
            C4879a.xxA.mo10055m(c42062sz);
            C24951an.m39071a(C24951an.this, C24951an.this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31757);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$11 */
    class C2371711 implements OnClickListener {
        C2371711() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31758);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(31758);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$6 */
    class C237186 implements OnClickListener {
        C237186() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$4 */
    class C249534 implements OnClickListener {
        C249534() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31751);
            C7060h.pYm.mo8381e(10997, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(31751);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$7 */
    class C249547 implements C36068a {
        C249547() {
        }

        public final void dAt() {
            AppMethodBeat.m2504i(31753);
            if (C35973a.m59179bJ(C24951an.this.cgL.yTx.getContext()) || C35973a.m59177bH(C24951an.this.cgL.yTx.getContext())) {
                C4990ab.m7410d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
                AppMethodBeat.m2505o(31753);
                return;
            }
            LinkedList tP = C25859d.fUu.mo20564tP(C24951an.this.cgL.sRl.field_username);
            C4990ab.m7417i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", Integer.valueOf(tP.size()));
            if (C25859d.fUu.mo20565tQ(C24951an.this.cgL.sRl.field_username)) {
                C24951an.m39072b(C24951an.this);
                AppMethodBeat.m2505o(31753);
                return;
            }
            C24951an.this.mo41856qt(true);
            AppMethodBeat.m2505o(31753);
        }

        public final void dAu() {
            AppMethodBeat.m2504i(31754);
            C42062sz c42062sz = new C42062sz();
            c42062sz.cPf.cPi = true;
            C4879a.xxA.mo10055m(c42062sz);
            C24951an.m39071a(C24951an.this, C24951an.this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31754);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$1 */
    class C249551 implements C4931a {
        C249551() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(31748);
            C4990ab.m7418v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (!C5046bo.isNullOrNil(str)) {
                C24951an.m39070a(C24951an.this);
            }
            AppMethodBeat.m2505o(31748);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$12 */
    class C2495612 implements OnClickListener {
        C2495612() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31759);
            C42062sz c42062sz = new C42062sz();
            c42062sz.cPf.cPi = true;
            C4879a.xxA.mo10055m(c42062sz);
            C24951an.m39071a(C24951an.this, C24951an.this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31759);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.an$2 */
    class C249572 implements OnClickListener {
        C249572() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31749);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(31749);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m39071a(C24951an c24951an, String str) {
        AppMethodBeat.m2504i(31782);
        c24951an.ars(str);
        AppMethodBeat.m2505o(31782);
    }

    public C24951an() {
        AppMethodBeat.m2504i(31760);
        AppMethodBeat.m2505o(31760);
    }

    public final boolean dFa() {
        AppMethodBeat.m2504i(31761);
        if (this.ySA == null) {
            AppMethodBeat.m2505o(31761);
            return false;
        } else if (this.ySA.getVisibility() == 0) {
            AppMethodBeat.m2505o(31761);
            return true;
        } else {
            AppMethodBeat.m2505o(31761);
            return false;
        }
    }

    public final boolean dFb() {
        AppMethodBeat.m2504i(31762);
        if (this.ySB == null) {
            AppMethodBeat.m2505o(31762);
            return false;
        } else if (this.ySB.getVisibility() == 0) {
            AppMethodBeat.m2505o(31762);
            return true;
        } else {
            AppMethodBeat.m2505o(31762);
            return false;
        }
    }

    public final int dFc() {
        AppMethodBeat.m2504i(31763);
        if (this.ySA == null) {
            AppMethodBeat.m2505o(31763);
            return 0;
        }
        int height = this.ySA.getHeight();
        AppMethodBeat.m2505o(31763);
        return height;
    }

    /* renamed from: k */
    public final void mo14628k(String str, String str2, String str3) {
        AppMethodBeat.m2504i(31765);
        if (this.cgL != null && str.equals(this.cgL.getTalkerUserName())) {
            m39073qs(false);
        }
        AppMethodBeat.m2505o(31765);
    }

    /* renamed from: tR */
    public final void mo33527tR(String str) {
        AppMethodBeat.m2504i(31766);
        if (this.cgL != null && str.equals(this.cgL.getTalkerUserName())) {
            m39073qs(false);
        }
        AppMethodBeat.m2505o(31766);
    }

    /* renamed from: Sf */
    public final void mo41849Sf(String str) {
        AppMethodBeat.m2504i(31767);
        if (this.cgL != null && str.equals(this.cgL.getTalkerUserName())) {
            m39073qs(false);
        }
        AppMethodBeat.m2505o(31767);
    }

    /* renamed from: a */
    private void m39069a(C36068a c36068a) {
        AppMethodBeat.m2504i(31768);
        if (this.ySA == null) {
            C40729i.m70424a(this.cgL.yTx, 2131822382);
            this.ySA = (TalkRoomPopupNav) this.cgL.findViewById(2131828228);
            if (this.ySA == null) {
                AppMethodBeat.m2505o(31768);
                return;
            }
        }
        if (this.ySA != null) {
            this.ySA.setOnClickListener(c36068a);
        }
        AppMethodBeat.m2505o(31768);
    }

    private void dFd() {
        AppMethodBeat.m2504i(31769);
        if (this.ySB == null) {
            C40729i.m70424a(this.cgL.yTx, 2131822383);
            this.ySB = (MultiTalkRoomPopupNav) this.cgL.findViewById(2131826250);
        }
        AppMethodBeat.m2505o(31769);
    }

    /* renamed from: qs */
    private void m39073qs(boolean z) {
        AppMethodBeat.m2504i(31770);
        if (this.cgL == null) {
            C4990ab.m7421w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", Boolean.valueOf(z));
            AppMethodBeat.m2505o(31770);
            return;
        }
        boolean z2 = ((C7335f) this.cgL.mo74857aF(C7335f.class)).dDF() || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDs();
        if (!C1855t.m3896kH(this.cgL.getTalkerUserName()) || z2) {
            dFe();
            String str;
            if (C25859d.fUu != null && C25859d.fUu.mo20565tQ(this.cgL.sRl.field_username)) {
                m39069a(this.ySC);
                if (this.ySA == null) {
                    AppMethodBeat.m2505o(31770);
                    return;
                }
                LinkedList tP = C25859d.fUu.mo20564tP(this.cgL.sRl.field_username);
                str = "";
                if (tP == null || !tP.contains(this.cgL.dFu())) {
                    this.ySA.setIconAnim(-1);
                    this.ySA.stop();
                    this.ySA.setBgViewResource(C25738R.drawable.a3j);
                    if (tP != null && tP.size() == 1) {
                        str = this.cgL.yTx.getMMResources().getString(C25738R.string.exn, new Object[]{C1854s.m3866mJ((String) tP.get(0))});
                    } else if (tP != null) {
                        str = this.cgL.yTx.getMMResources().getString(C25738R.string.exp, new Object[]{Integer.valueOf(tP.size())});
                    }
                    this.ySA.setIconRes(C1318a.tipsbar_icon_location);
                } else {
                    this.ySA.setBgViewResource(C25738R.drawable.a3i);
                    str = this.cgL.yTx.getMMResources().getString(C25738R.string.exo);
                    this.ySA.setIconRes(C1318a.tipsbar_icon_location_lightgreen);
                    this.ySA.setIconAnim(C1318a.tipsbar_icon_location_shining);
                    this.ySA.start();
                }
                this.ySA.setVisibility(0);
                this.ySA.setNavContent(str);
                ((C46643s) this.cgL.mo74857aF(C46643s.class)).mo57041OB(1);
                AppMethodBeat.m2505o(31770);
                return;
            } else if (C32337g.fUs != null && C32337g.fUs.mo4625tN(this.cgL.getTalkerUserName())) {
                m39069a(this.ySC);
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPh = true;
                C4879a.xxA.mo10055m(c42062sz);
                if (this.cgL.getTalkerUserName().equals(c42062sz.cPg.cPj)) {
                    this.ySA.setBgViewResource(C25738R.drawable.a3i);
                } else {
                    this.ySA.setBgViewResource(C25738R.drawable.a3j);
                }
                str = this.cgL.yTx.getMMResources().getString(C25738R.string.euu, new Object[]{Integer.valueOf(C32337g.fUs.mo4624tM(this.cgL.getTalkerUserName()).size())});
                this.ySA.setIconRes(C25738R.drawable.app);
                this.ySA.setIconAnim(-1);
                this.ySA.stop();
                this.ySA.setVisibility(0);
                this.ySA.setNavContent(str);
                ((C46643s) this.cgL.mo74857aF(C46643s.class)).mo57041OB(1);
                AppMethodBeat.m2505o(31770);
                return;
            } else if (C1855t.m3896kH(this.cgL.getTalkerUserName())) {
                C1310f RW = ((C39419a) C1720g.m3528K(C39419a.class)).mo55111RW(this.cgL.getTalkerUserName());
                if (!(RW == null || RW.field_wxGroupId == null || !RW.field_wxGroupId.equals(this.cgL.getTalkerUserName()))) {
                    dFd();
                    if (this.ySB != null) {
                        C4990ab.m7416i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
                        this.ySB.setGroupUserName(this.cgL.getTalkerUserName());
                        this.ySB.setCurrentSenderUserName(this.cgL.dFu());
                        this.ySB.setInChatRoom(z2);
                        this.ySB.mo39224pV(z);
                        this.ySB.setMultiTalkInfo(RW);
                        ((C46643s) this.cgL.mo74857aF(C46643s.class)).mo57041OB(1);
                    }
                }
                AppMethodBeat.m2505o(31770);
                return;
            } else {
                dFe();
                AppMethodBeat.m2505o(31770);
                return;
            }
        }
        if (this.ySA != null) {
            this.ySA.setVisibility(8);
            ((C46643s) this.cgL.mo74857aF(C46643s.class)).mo57041OB(-1);
        }
        if (this.ySB != null) {
            this.ySB.setInChatRoom(false);
            this.ySB.setVisibility(8);
        }
        AppMethodBeat.m2505o(31770);
    }

    private void dFe() {
        AppMethodBeat.m2504i(31771);
        if (this.ySA != null) {
            this.ySA.setVisibility(8);
            this.ySA.setIconAnim(-1);
            this.ySA.stop();
            ((C46643s) this.cgL.mo74857aF(C46643s.class)).mo57041OB(-1);
        }
        if (this.ySB != null) {
            if (!((C39419a) C1720g.m3528K(C39419a.class)).mo55110RV(this.cgL.getTalkerUserName())) {
                this.ySB.dyV();
            }
            this.ySB.setVisibility(8);
            ((C46643s) this.cgL.mo74857aF(C46643s.class)).mo57041OB(-1);
        }
        AppMethodBeat.m2505o(31771);
    }

    /* renamed from: qt */
    public final void mo41856qt(final boolean z) {
        AppMethodBeat.m2504i(31772);
        int i = (((C7335f) this.cgL.mo74857aF(C7335f.class)).dDF() || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDs()) ? true : 0;
        if (C1855t.m3896kH(this.cgL.getTalkerUserName()) && i == 0) {
            C30379h.m48461b(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.eul), null, true);
            AppMethodBeat.m2505o(31772);
            return;
        }
        C42062sz c42062sz = new C42062sz();
        c42062sz.cPf.cPh = true;
        C4879a.xxA.mo10055m(c42062sz);
        if (z) {
            if (C5046bo.isNullOrNil(c42062sz.cPg.cPj) || this.cgL.getTalkerUserName().equals(c42062sz.cPg.cPj)) {
                ars(this.cgL.getTalkerUserName());
                AppMethodBeat.m2505o(31772);
            } else if (this.ySA == null || this.ySA.getVisibility() != 0) {
                C30379h.m48440a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.eub), null, new C2495612(), new C249572());
                AppMethodBeat.m2505o(31772);
            } else {
                this.ySA.setDialogContent(this.cgL.yTx.getMMResources().getString(C25738R.string.eub));
                TalkRoomPopupNav talkRoomPopupNav = this.ySA;
                if (talkRoomPopupNav.yAJ == null) {
                    talkRoomPopupNav.yAJ = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.yAL) * 1.0f) / ((float) talkRoomPopupNav.yAM), 1.0f);
                    talkRoomPopupNav.yAJ.setDuration(300);
                    talkRoomPopupNav.yAJ.setAnimationListener(new C155274());
                }
                if (talkRoomPopupNav.yAK == null) {
                    talkRoomPopupNav.yAK = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), C25738R.anim.f8333b6);
                    talkRoomPopupNav.yAK.setFillAfter(true);
                    talkRoomPopupNav.yAK.setAnimationListener(new C52695());
                }
                LayoutParams layoutParams = talkRoomPopupNav.miL.getLayoutParams();
                layoutParams.height = talkRoomPopupNav.yAM;
                talkRoomPopupNav.miL.setLayoutParams(layoutParams);
                talkRoomPopupNav.miL.startAnimation(talkRoomPopupNav.yAJ);
                talkRoomPopupNav.yoK.startAnimation(talkRoomPopupNav.yAK);
                talkRoomPopupNav.yAF.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), C25738R.anim.f8332b5));
                talkRoomPopupNav.yAF.setVisibility(0);
                AppMethodBeat.m2505o(31772);
            }
        } else if (C25859d.fUu != null && C25859d.fUu.mo20565tQ(this.cgL.sRl.field_username)) {
            String string;
            LinkedList tP = C25859d.fUu.mo20564tP(this.cgL.sRl.field_username);
            if (tP == null || !tP.contains(this.cgL.dFu())) {
                string = this.cgL.yTx.getMMResources().getString(C25738R.string.euh);
                i = C25738R.string.ck7;
            } else {
                string = this.cgL.yTx.getMMResources().getString(C25738R.string.eug);
                i = C25738R.string.bdb;
            }
            C7060h.pYm.mo8381e(10997, Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            C5652a c5652a = new C5652a(this.cgL.yTx.getContext());
            c5652a.asE(string);
            c5652a.mo11453Qc(C25738R.string.f9076or).mo11457a(new C53118());
            c5652a.mo11454Qd(i).mo11476b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(31756);
                    C24951an.this.arr(z ? "fromBanner" : "fromPluginTalk");
                    AppMethodBeat.m2505o(31756);
                }
            });
            c5652a.aMb().show();
            AppMethodBeat.m2505o(31772);
        } else if (C5046bo.isNullOrNil(c42062sz.cPg.cPj) || this.cgL.getTalkerUserName().equals(c42062sz.cPg.cPj)) {
            ars(this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31772);
        } else {
            C30379h.m48440a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.eub), null, new C2371610(), new C2371711());
            AppMethodBeat.m2505o(31772);
        }
    }

    private void dFf() {
        AppMethodBeat.m2504i(31773);
        mo41852cg("fromBanner", false);
        AppMethodBeat.m2505o(31773);
    }

    public final void arr(String str) {
        AppMethodBeat.m2504i(31775);
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 6);
        intent.putExtra("map_sender_name", this.cgL.dFu());
        intent.putExtra("map_talker_name", this.cgL.getTalkerUserName());
        intent.putExtra("fromWhereShare", str);
        C25985d.m41467b(this.cgL.yTx.getContext(), C8741b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.m2505o(31775);
    }

    private void ars(String str) {
        AppMethodBeat.m2504i(31776);
        Intent intent = new Intent();
        intent.putExtra("enter_room_username", str);
        intent.setFlags(268435456);
        C25985d.m41467b(this.cgL.yTx.getContext(), "talkroom", ".ui.TalkRoomUI", intent);
        AppMethodBeat.m2505o(31776);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31777);
        super.dDh();
        if (this.ySA != null) {
            this.ySA.stop();
        }
        AppMethodBeat.m2505o(31777);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31778);
        C4990ab.m7416i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4620a(this);
        }
        if (C25859d.fUu != null) {
            C25859d.fUu.mo20558a(this);
        }
        ((C39419a) C1720g.m3528K(C39419a.class)).mo55123a(this);
        m39073qs(true);
        AppMethodBeat.m2505o(31778);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31779);
        C4990ab.m7416i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4623b(this);
        }
        if (C25859d.fUu != null) {
            C25859d.fUu.mo20563b(this);
        }
        ((C39419a) C1720g.m3528K(C39419a.class)).mo55125b(this);
        AppMethodBeat.m2505o(31779);
    }

    public final void dxC() {
    }

    /* renamed from: ax */
    public final void mo41851ax(final Runnable runnable) {
        AppMethodBeat.m2504i(31764);
        if (C25859d.fUu == null || !C25859d.fUu.mo20560aV(this.cgL.sRl.field_username, this.cgL.dFu())) {
            runnable.run();
            AppMethodBeat.m2505o(31764);
            return;
        }
        C30379h.m48449a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.exk), this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(31752);
                runnable.run();
                C45322ez c45322ez = new C45322ez();
                c45322ez.cys.username = C24951an.this.cgL.getTalkerUserName();
                C4879a.xxA.mo10055m(c45322ez);
                AppMethodBeat.m2505o(31752);
            }
        }, new C237186());
        AppMethodBeat.m2505o(31764);
    }

    /* renamed from: cg */
    public final void mo41852cg(final String str, boolean z) {
        AppMethodBeat.m2504i(31774);
        if ((C25859d.fUu != null && C25859d.fUu.mo20565tQ(this.cgL.sRl.field_username)) || z) {
            LinkedList tP = C25859d.fUu.mo20564tP(this.cgL.sRl.field_username);
            if (tP == null || !tP.contains(this.cgL.dFu())) {
                C7060h.pYm.mo8381e(10997, Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                C30379h.m48440a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.bde), null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(31750);
                        C24951an.this.arr(str);
                        AppMethodBeat.m2505o(31750);
                    }
                }, new C249534());
                AppMethodBeat.m2505o(31774);
                return;
            }
        }
        arr(str);
        AppMethodBeat.m2505o(31774);
    }

    /* renamed from: b */
    static /* synthetic */ void m39072b(C24951an c24951an) {
        AppMethodBeat.m2504i(31781);
        boolean z = ((C7335f) c24951an.cgL.mo74857aF(C7335f.class)).dDF() || ((C36135d) c24951an.cgL.mo74857aF(C36135d.class)).dDs();
        if (!C1855t.m3896kH(c24951an.cgL.getTalkerUserName()) || z) {
            C42062sz c42062sz = new C42062sz();
            c42062sz.cPf.cPh = true;
            C4879a.xxA.mo10055m(c42062sz);
            if (C5046bo.isNullOrNil(c42062sz.cPg.cPj) || c24951an.cgL.getTalkerUserName().equals(c42062sz.cPg.cPj)) {
                c24951an.cgL.getTalkerUserName();
                c24951an.dFf();
                AppMethodBeat.m2505o(31781);
                return;
            }
            c42062sz = new C42062sz();
            c42062sz.cPf.cPi = true;
            C4879a.xxA.mo10055m(c42062sz);
            c24951an.cgL.getTalkerUserName();
            c24951an.dFf();
            AppMethodBeat.m2505o(31781);
            return;
        }
        C30379h.m48461b(c24951an.cgL.yTx.getContext(), c24951an.cgL.yTx.getMMResources().getString(C25738R.string.exm), null, true);
        AppMethodBeat.m2505o(31781);
    }
}
