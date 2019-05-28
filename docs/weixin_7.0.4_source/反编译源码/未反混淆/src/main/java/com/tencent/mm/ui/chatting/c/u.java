package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.p;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.c.b.v;

@a(dFp = s.class)
public class u extends a implements s {
    private Runnable auF;
    private View yQJ;
    private TextView yQK;
    private int yQL;
    private int yQM = 0;

    public final int dEy() {
        return this.yQL;
    }

    public final void dEz() {
        AppMethodBeat.i(31542);
        if (this.yQJ == null) {
            AppMethodBeat.o(31542);
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
        AppMethodBeat.o(31542);
    }

    public final void dEA() {
        AppMethodBeat.i(31543);
        int i = dED() ? 5 : 10;
        if (this.yQL <= i) {
            ab.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i)));
            this.yQJ.setVisibility(8);
            AppMethodBeat.o(31543);
        } else if (this.yQJ.getVisibility() == 0) {
            ab.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
            AppMethodBeat.o(31543);
        } else {
            this.yQJ.removeCallbacks(this.auF);
            View view = this.yQJ;
            AnonymousClass2 anonymousClass2 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31541);
                    ab.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
                    u.this.yQJ.setVisibility(0);
                    u.this.yQM = 1;
                    if (((af) u.this.cgL.aF(af.class)).dFa()) {
                        u.this.OB(1);
                    } else if (u.b(u.this)) {
                        u.this.OB(3);
                    } else {
                        u.this.OB(0);
                    }
                    TranslateAnimation translateAnimation = new TranslateAnimation((float) u.this.yQJ.getWidth(), 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300);
                    translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(u.this.cgL.yTx.getContext(), 17432581));
                    u.this.yQJ.startAnimation(translateAnimation);
                    AppMethodBeat.o(31541);
                }
            };
            this.auF = anonymousClass2;
            view.postDelayed(anonymousClass2, 100);
            AppMethodBeat.o(31543);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(31544);
        super.onScroll(absListView, i, i2, i3);
        if (this.yQL > 0 && i3 - (i + 1) >= this.yQL && this.yQJ != null && this.yQJ.getVisibility() == 0) {
            ab.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", Integer.valueOf(this.yQL), Integer.valueOf(i3), Integer.valueOf(i));
            dEz();
        }
        AppMethodBeat.o(31544);
    }

    public final void dEB() {
        this.yQM = 0;
    }

    public final int dEC() {
        return this.yQM;
    }

    public final void OB(int i) {
        AppMethodBeat.i(31545);
        if (this.yQL < (dED() ? 5 : 10) || this.yQJ == null) {
            AppMethodBeat.o(31545);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) this.yQJ.getLayoutParams();
        switch (i) {
            case -2:
                if (!((af) this.cgL.aF(af.class)).dFa()) {
                    layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.l5), 0, 0);
                    break;
                }
                break;
            case 0:
                layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.l5), 0, 0);
                AppMethodBeat.o(31545);
                return;
            case 1:
                int dFc;
                int dimensionPixelSize;
                af afVar = (af) this.cgL.aF(af.class);
                if (afVar.dFa()) {
                    dFc = afVar.dFc();
                } else {
                    dFc = 0;
                }
                if (afVar.dFb()) {
                    dimensionPixelSize = this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.lz);
                } else {
                    dimensionPixelSize = 0;
                }
                if (dimensionPixelSize > dFc) {
                    dFc = dimensionPixelSize;
                }
                layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.l5) + dFc, 0, 0);
                AppMethodBeat.o(31545);
                return;
            case 3:
                layoutParams.setMargins(0, this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.l5) * 3, 0, 0);
                AppMethodBeat.o(31545);
                return;
        }
        AppMethodBeat.o(31545);
    }

    private boolean dED() {
        AppMethodBeat.i(31546);
        d dVar = (d) this.cgL.aF(d.class);
        if (t.nD(this.cgL.getTalkerUserName())) {
            AppMethodBeat.o(31546);
            return true;
        } else if (!this.cgL.sRl.dsf() || dVar.dDj() == null || ((!dVar.dDj().adN() || ((b) g.K(b.class)).aVO()) && !dVar.dDj().adM())) {
            AppMethodBeat.o(31546);
            return false;
        } else {
            AppMethodBeat.o(31546);
            return true;
        }
    }

    public final void dxx() {
        AppMethodBeat.i(31547);
        super.dxx();
        this.yQJ = this.cgL.findViewById(R.id.alt);
        this.yQJ.setVisibility(8);
        aw.ZK();
        ak aoZ = c.XR().aoZ(this.cgL.getTalkerUserName());
        if (aoZ != null) {
            this.yQL = aoZ.field_unReadCount;
            ab.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] getUnDeliverCount:%s mUnreadMessageCount:%s", Integer.valueOf(aoZ.field_UnDeliverCount), Integer.valueOf(this.yQL));
        }
        AppMethodBeat.o(31547);
    }

    public final void dxz() {
        int i;
        AppMethodBeat.i(31548);
        super.dxz();
        d dVar = (d) this.cgL.aF(d.class);
        if (dVar.dDm()) {
            this.yQL = dVar.dDv();
        }
        d dVar2 = (d) this.cgL.aF(d.class);
        if ((!bo.isNullOrNil(this.cgL.getTalkerUserName()) && !this.cgL.dFv() && !t.nG(this.cgL.getTalkerUserName()) && !t.mZ(this.cgL.getTalkerUserName()) && !t.nB(this.cgL.getTalkerUserName()) && !t.nc(this.cgL.getTalkerUserName())) || this.cgL.dFw() || dVar2.dDm() || dED()) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            ab.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", this.cgL.getTalkerUserName(), Integer.valueOf(this.yQL), Boolean.valueOf(dVar.dDm()));
            this.yQJ.setVisibility(8);
            this.yQM = 0;
            AppMethodBeat.o(31548);
            return;
        }
        int i2 = this.yQL;
        ab.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", Integer.valueOf(dED() ? 5 : 10), Integer.valueOf(i2));
        if (i2 >= (dED() ? 5 : 10)) {
            int aQ;
            ab.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
            this.yQK = (TextView) this.cgL.findViewById(R.id.alu);
            x xVar = x.ecN;
            if (xVar.ecR == null) {
                xVar.ecS = 1;
            } else {
                xVar.ecR.edj = 1;
            }
            if (i2 > 999) {
                this.yQK.setText(String.format(this.cgL.yTx.getMMResources().getString(R.string.al6), new Object[]{Integer.valueOf(999)}));
            } else {
                this.yQK.setText(String.format(this.cgL.yTx.getMMResources().getString(R.string.al6), new Object[]{Integer.valueOf(i2)}));
            }
            if (dVar.dDm()) {
                aw.ZK();
                aQ = c.XP().aQ(this.cgL.getTalkerUserName(), dVar.dDz()) - this.yQL;
            } else {
                aw.ZK();
                aQ = c.XO().Rp(this.cgL.getTalkerUserName()) - this.yQL;
            }
            this.yQJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31540);
                    u.this.yQM = 2;
                    x xVar = x.ecN;
                    if (xVar.ecR != null) {
                        xVar.ecR.edj = 2;
                    }
                    if (((p) u.this.cgL.aF(p.class)).dEi()) {
                        ((p) u.this.cgL.aF(p.class)).dEj();
                        AppMethodBeat.o(31540);
                        return;
                    }
                    u.b(u.this, aQ);
                    AppMethodBeat.o(31540);
                }
            });
            if (!((p) this.cgL.aF(p.class)).dEi()) {
                dEA();
            }
        }
        AppMethodBeat.o(31548);
    }

    static /* synthetic */ void b(u uVar, int i) {
        AppMethodBeat.i(31549);
        ((h) uVar.cgL.aF(h.class)).a(i, com.tencent.mm.ui.chatting.f.d.a.ACTION_POSITION);
        uVar.dEz();
        AppMethodBeat.o(31549);
    }

    static /* synthetic */ boolean b(u uVar) {
        AppMethodBeat.i(31550);
        if (!t.nI(uVar.cgL.getTalkerUserName()) && t.kH(uVar.cgL.getTalkerUserName())) {
            aw.ZK();
            ak aoZ = c.XR().aoZ(uVar.cgL.getTalkerUserName());
            if (aoZ == null || (aoZ.field_showTips & 1) > 0) {
                AppMethodBeat.o(31550);
                return false;
            }
            aw.ZK();
            if (c.XM().aoO(uVar.cgL.getTalkerUserName()).dua == 1 && ((v) uVar.cgL.aF(v.class)).Nr() >= 40) {
                AppMethodBeat.o(31550);
                return true;
            }
        }
        AppMethodBeat.o(31550);
        return false;
    }
}
