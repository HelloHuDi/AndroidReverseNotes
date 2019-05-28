package com.tencent.p177mm.p612ui.chatting.p616c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C35866c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.chatting.c.am */
public class C30464am extends C44291a implements C5326v {
    private View ySs;
    private ViewGroup ySt;
    private boolean ySu;
    private boolean ySv;
    private final long ySw = 259200000;
    private C35866c ySx = new C156092();

    /* renamed from: com.tencent.mm.ui.chatting.c.am$2 */
    class C156092 implements C35866c {
        C156092() {
        }

        /* renamed from: a */
        public final void mo27786a(Boolean bool, Boolean bool2) {
            AppMethodBeat.m2504i(31740);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    C30464am c30464am = C30464am.this;
                    Boolean bool3 = Boolean.TRUE;
                    C30464am.m48570a(c30464am, bool3, bool3);
                    AppMethodBeat.m2505o(31740);
                    return;
                }
                C30464am.m48570a(C30464am.this, Boolean.FALSE, Boolean.TRUE);
            }
            AppMethodBeat.m2505o(31740);
        }

        /* renamed from: b */
        public final void mo27787b(Boolean bool, Boolean bool2) {
            AppMethodBeat.m2504i(31741);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    C30464am.m48570a(C30464am.this, Boolean.TRUE, Boolean.FALSE);
                    AppMethodBeat.m2505o(31741);
                    return;
                }
                C30464am c30464am = C30464am.this;
                Boolean bool3 = Boolean.FALSE;
                C30464am.m48570a(c30464am, bool3, bool3);
            }
            AppMethodBeat.m2505o(31741);
        }
    }

    public C30464am() {
        AppMethodBeat.m2504i(31742);
        AppMethodBeat.m2505o(31742);
    }

    /* renamed from: a */
    static /* synthetic */ void m48570a(C30464am c30464am, Boolean bool, Boolean bool2) {
        AppMethodBeat.m2504i(31747);
        c30464am.m48571c(bool, bool2);
        AppMethodBeat.m2505o(31747);
    }

    /* renamed from: k */
    private void m48572k(final Boolean bool) {
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(31743);
        this.ySt = (ViewGroup) this.cgL.findViewById(2131822377);
        this.ySs = View.inflate(this.cgL.yTx.getContext(), 2130970305, null);
        TextView textView = (TextView) this.ySs.findViewById(2131826356);
        if (bool.booleanValue()) {
            textView.setText(this.cgL.yTx.getContext().getString(C25738R.string.e3e));
            this.ySs.setBackgroundResource(C25738R.drawable.bdu);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
        } else {
            textView.setText(this.cgL.yTx.getContext().getString(C25738R.string.e3i));
            this.ySs.setBackgroundResource(C25738R.drawable.bdt);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        }
        if (!(this.ySt == null || this.ySs == null)) {
            this.ySt.addView(this.ySs, layoutParams);
            this.ySs.startAnimation(AnimationUtils.loadAnimation(this.cgL.yTx.getContext(), C25738R.anim.f8396d4));
            this.ySs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(31739);
                    if (bool.booleanValue()) {
                        C30464am c30464am = C30464am.this;
                        Boolean bool = Boolean.TRUE;
                        C30464am.m48570a(c30464am, bool, bool);
                        ((C15614o) C30464am.this.cgL.mo74857aF(C15614o.class)).dDX().dkc();
                        AppMethodBeat.m2505o(31739);
                        return;
                    }
                    C30464am.m48570a(C30464am.this, Boolean.TRUE, Boolean.FALSE);
                    ((C15614o) C30464am.this.cgL.mo74857aF(C15614o.class)).dDX().setMode(2);
                    AppMethodBeat.m2505o(31739);
                }
            });
        }
        AppMethodBeat.m2505o(31743);
    }

    /* renamed from: c */
    private void m48571c(Boolean bool, Boolean bool2) {
        AppMethodBeat.m2504i(31744);
        if (this.ySs != null) {
            this.ySs.clearAnimation();
            this.ySs.setVisibility(8);
            if (bool2.booleanValue()) {
                if (bool.booleanValue()) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(340228, Boolean.TRUE);
                    C7060h.pYm.mo8378a(232, 1, 1, false);
                    AppMethodBeat.m2505o(31744);
                    return;
                }
            } else if (bool.booleanValue()) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(340229, Boolean.TRUE);
                C7060h.pYm.mo8378a(232, 2, 1, false);
            }
        }
        AppMethodBeat.m2505o(31744);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31745);
        if (C1853r.m3852Zf().booleanValue()) {
            if (!this.cgL.sRl.dsf()) {
                C9638aw.m17190ZK();
                this.ySu = C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(340228, null));
                if (!(this.ySu || ((C7335f) this.cgL.mo74857aF(C7335f.class)).dDF() || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDs())) {
                    m48572k(Boolean.TRUE);
                }
                C9638aw.m17190ZK();
                this.ySv = C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(340229, null));
                long currentTimeMillis = System.currentTimeMillis();
                C9638aw.m17190ZK();
                long a = currentTimeMillis - C5046bo.m7514a((Long) C18628c.m29072Ry().get(340240, null), 0);
                if (this.ySu && !this.ySv && a >= 259200000) {
                    m48572k(Boolean.FALSE);
                }
            }
            if (((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX() != null) {
                ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX().setTipsShowCallback(this.ySx);
            }
        }
        AppMethodBeat.m2505o(31745);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31746);
        if (!this.cgL.sRl.dsf() && C1853r.m3852Zf().booleanValue()) {
            Boolean bool = Boolean.FALSE;
            m48571c(bool, bool);
        }
        AppMethodBeat.m2505o(31746);
    }
}
