package com.tencent.p177mm.p612ui.chatting.p616c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C41908x;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30469p;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40723af;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46643s;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;

@C15590a(dFp = C46643s.class)
/* renamed from: com.tencent.mm.ui.chatting.c.u */
public class C36155u extends C44291a implements C46643s {
    private Runnable auF;
    private View yQJ;
    private TextView yQK;
    private int yQL;
    private int yQM = 0;

    /* renamed from: com.tencent.mm.ui.chatting.c.u$2 */
    class C361572 implements Runnable {
        C361572() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31541);
            C4990ab.m7416i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
            C36155u.this.yQJ.setVisibility(0);
            C36155u.this.yQM = 1;
            if (((C40723af) C36155u.this.cgL.mo74857aF(C40723af.class)).dFa()) {
                C36155u.this.mo57041OB(1);
            } else if (C36155u.m59513b(C36155u.this)) {
                C36155u.this.mo57041OB(3);
            } else {
                C36155u.this.mo57041OB(0);
            }
            TranslateAnimation translateAnimation = new TranslateAnimation((float) C36155u.this.yQJ.getWidth(), 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(C36155u.this.cgL.yTx.getContext(), 17432581));
            C36155u.this.yQJ.startAnimation(translateAnimation);
            AppMethodBeat.m2505o(31541);
        }
    }

    public final int dEy() {
        return this.yQL;
    }

    public final void dEz() {
        AppMethodBeat.m2504i(31542);
        if (this.yQJ == null) {
            AppMethodBeat.m2505o(31542);
            return;
        }
        this.yQL = -1;
        if (this.yQJ.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.yQJ.getWidth(), 0.0f, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.cgL.yTx.getContext(), 17432581));
            this.yQJ.startAnimation(translateAnimation);
        }
        this.yQJ.setVisibility(8);
        AppMethodBeat.m2505o(31542);
    }

    public final void dEA() {
        AppMethodBeat.m2504i(31543);
        int i = dED() ? 5 : 10;
        if (this.yQL <= i) {
            C4990ab.m7420w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
            this.yQJ.setVisibility(8);
            AppMethodBeat.m2505o(31543);
        } else if (this.yQJ.getVisibility() == 0) {
            C4990ab.m7420w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
            AppMethodBeat.m2505o(31543);
        } else {
            this.yQJ.removeCallbacks(this.auF);
            View view = this.yQJ;
            C361572 c361572 = new C361572();
            this.auF = c361572;
            view.postDelayed(c361572, 100);
            AppMethodBeat.m2505o(31543);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(31544);
        super.onScroll(absListView, i, i2, i3);
        if (this.yQL > 0 && i3 - (i + 1) >= this.yQL && this.yQJ != null && this.yQJ.getVisibility() == 0) {
            C4990ab.m7417i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", Integer.valueOf(this.yQL), Integer.valueOf(i3), Integer.valueOf(i));
            dEz();
        }
        AppMethodBeat.m2505o(31544);
    }

    public final void dEB() {
        this.yQM = 0;
    }

    public final int dEC() {
        return this.yQM;
    }

    /* renamed from: OB */
    public final void mo57041OB(int i) {
        AppMethodBeat.m2504i(31545);
        if (this.yQL < (dED() ? 5 : 10) || this.yQJ == null) {
            AppMethodBeat.m2505o(31545);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) this.yQJ.getLayoutParams();
        switch (i) {
            case -2:
                if (!((C40723af) this.cgL.mo74857aF(C40723af.class)).dFa()) {
                    layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9948l5), 0, 0);
                    break;
                }
                break;
            case 0:
                layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9948l5), 0, 0);
                AppMethodBeat.m2505o(31545);
                return;
            case 1:
                int dFc;
                int dimensionPixelSize;
                C40723af c40723af = (C40723af) this.cgL.mo74857aF(C40723af.class);
                if (c40723af.dFa()) {
                    dFc = c40723af.dFc();
                } else {
                    dFc = 0;
                }
                if (c40723af.dFb()) {
                    dimensionPixelSize = this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9975lz);
                } else {
                    dimensionPixelSize = 0;
                }
                if (dimensionPixelSize > dFc) {
                    dFc = dimensionPixelSize;
                }
                layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9948l5) + dFc, 0, 0);
                AppMethodBeat.m2505o(31545);
                return;
            case 3:
                layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9948l5) * 3, 0, 0);
                AppMethodBeat.m2505o(31545);
                return;
        }
        AppMethodBeat.m2505o(31545);
    }

    private boolean dED() {
        AppMethodBeat.m2504i(31546);
        C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
        if (C1855t.m3918nD(this.cgL.getTalkerUserName())) {
            AppMethodBeat.m2505o(31546);
            return true;
        } else if (!this.cgL.sRl.dsf() || c36135d.dDj() == null || ((!c36135d.dDj().adN() || ((C20023b) C1720g.m3528K(C20023b.class)).aVO()) && !c36135d.dDj().adM())) {
            AppMethodBeat.m2505o(31546);
            return false;
        } else {
            AppMethodBeat.m2505o(31546);
            return true;
        }
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31547);
        super.dxx();
        this.yQJ = this.cgL.findViewById(2131822388);
        this.yQJ.setVisibility(8);
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
        if (aoZ != null) {
            this.yQL = aoZ.field_unReadCount;
            C4990ab.m7417i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] getUnDeliverCount:%s mUnreadMessageCount:%s", Integer.valueOf(aoZ.field_UnDeliverCount), Integer.valueOf(this.yQL));
        }
        AppMethodBeat.m2505o(31547);
    }

    public final void dxz() {
        int i;
        AppMethodBeat.m2504i(31548);
        super.dxz();
        C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
        if (c36135d.dDm()) {
            this.yQL = c36135d.dDv();
        }
        C36135d c36135d2 = (C36135d) this.cgL.mo74857aF(C36135d.class);
        if ((!C5046bo.isNullOrNil(this.cgL.getTalkerUserName()) && !this.cgL.dFv() && !C1855t.m3921nG(this.cgL.getTalkerUserName()) && !C1855t.m3913mZ(this.cgL.getTalkerUserName()) && !C1855t.m3916nB(this.cgL.getTalkerUserName()) && !C1855t.m3934nc(this.cgL.getTalkerUserName())) || this.cgL.dFw() || c36135d2.dDm() || dED()) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            C4990ab.m7421w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", this.cgL.getTalkerUserName(), Integer.valueOf(this.yQL), Boolean.valueOf(c36135d.dDm()));
            this.yQJ.setVisibility(8);
            this.yQM = 0;
            AppMethodBeat.m2505o(31548);
            return;
        }
        int i2 = this.yQL;
        C4990ab.m7417i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", Integer.valueOf(dED() ? 5 : 10), Integer.valueOf(i2));
        if (i2 >= (dED() ? 5 : 10)) {
            int aQ;
            C4990ab.m7416i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
            this.yQK = (TextView) this.cgL.findViewById(2131822389);
            C41908x c41908x = C41908x.ecN;
            if (c41908x.ecR == null) {
                c41908x.ecS = 1;
            } else {
                c41908x.ecR.edj = 1;
            }
            if (i2 > 999) {
                this.yQK.setText(String.format(this.cgL.yTx.getMMResources().getString(C25738R.string.al6), new Object[]{Integer.valueOf(999)}));
            } else {
                this.yQK.setText(String.format(this.cgL.yTx.getMMResources().getString(C25738R.string.al6), new Object[]{Integer.valueOf(i2)}));
            }
            if (c36135d.dDm()) {
                C9638aw.m17190ZK();
                aQ = C18628c.m29081XP().mo74796aQ(this.cgL.getTalkerUserName(), c36135d.dDz()) - this.yQL;
            } else {
                C9638aw.m17190ZK();
                aQ = C18628c.m29080XO().mo15262Rp(this.cgL.getTalkerUserName()) - this.yQL;
            }
            this.yQJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(31540);
                    C36155u.this.yQM = 2;
                    C41908x c41908x = C41908x.ecN;
                    if (c41908x.ecR != null) {
                        c41908x.ecR.edj = 2;
                    }
                    if (((C30469p) C36155u.this.cgL.mo74857aF(C30469p.class)).dEi()) {
                        ((C30469p) C36155u.this.cgL.mo74857aF(C30469p.class)).dEj();
                        AppMethodBeat.m2505o(31540);
                        return;
                    }
                    C36155u.m59512b(C36155u.this, aQ);
                    AppMethodBeat.m2505o(31540);
                }
            });
            if (!((C30469p) this.cgL.mo74857aF(C30469p.class)).dEi()) {
                dEA();
            }
        }
        AppMethodBeat.m2505o(31548);
    }

    /* renamed from: b */
    static /* synthetic */ void m59512b(C36155u c36155u, int i) {
        AppMethodBeat.m2504i(31549);
        ((C15612h) c36155u.cgL.mo74857aF(C15612h.class)).mo27801a(i, C40749a.ACTION_POSITION);
        c36155u.dEz();
        AppMethodBeat.m2505o(31549);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m59513b(C36155u c36155u) {
        AppMethodBeat.m2504i(31550);
        if (!C1855t.m3923nI(c36155u.cgL.getTalkerUserName()) && C1855t.m3896kH(c36155u.cgL.getTalkerUserName())) {
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(c36155u.cgL.getTalkerUserName());
            if (aoZ == null || (aoZ.field_showTips & 1) > 0) {
                AppMethodBeat.m2505o(31550);
                return false;
            }
            C9638aw.m17190ZK();
            if (C18628c.m29078XM().aoO(c36155u.cgL.getTalkerUserName()).dua == 1 && ((C40726v) c36155u.cgL.mo74857aF(C40726v.class)).mo64242Nr() >= 40) {
                AppMethodBeat.m2505o(31550);
                return true;
            }
        }
        AppMethodBeat.m2505o(31550);
        return false;
    }
}
