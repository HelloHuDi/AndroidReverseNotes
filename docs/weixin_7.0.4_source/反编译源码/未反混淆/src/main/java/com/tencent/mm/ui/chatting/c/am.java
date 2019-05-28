package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.o;

public class am extends a implements v {
    private View ySs;
    private ViewGroup ySt;
    private boolean ySu;
    private boolean ySv;
    private final long ySw = 259200000;
    private c ySx = new c() {
        public final void a(Boolean bool, Boolean bool2) {
            AppMethodBeat.i(31740);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    am amVar = am.this;
                    Boolean bool3 = Boolean.TRUE;
                    am.a(amVar, bool3, bool3);
                    AppMethodBeat.o(31740);
                    return;
                }
                am.a(am.this, Boolean.FALSE, Boolean.TRUE);
            }
            AppMethodBeat.o(31740);
        }

        public final void b(Boolean bool, Boolean bool2) {
            AppMethodBeat.i(31741);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    am.a(am.this, Boolean.TRUE, Boolean.FALSE);
                    AppMethodBeat.o(31741);
                    return;
                }
                am amVar = am.this;
                Boolean bool3 = Boolean.FALSE;
                am.a(amVar, bool3, bool3);
            }
            AppMethodBeat.o(31741);
        }
    };

    public am() {
        AppMethodBeat.i(31742);
        AppMethodBeat.o(31742);
    }

    static /* synthetic */ void a(am amVar, Boolean bool, Boolean bool2) {
        AppMethodBeat.i(31747);
        amVar.c(bool, bool2);
        AppMethodBeat.o(31747);
    }

    private void k(final Boolean bool) {
        LayoutParams layoutParams;
        AppMethodBeat.i(31743);
        this.ySt = (ViewGroup) this.cgL.findViewById(R.id.ali);
        this.ySs = View.inflate(this.cgL.yTx.getContext(), R.layout.aix, null);
        TextView textView = (TextView) this.ySs.findViewById(R.id.di4);
        if (bool.booleanValue()) {
            textView.setText(this.cgL.yTx.getContext().getString(R.string.e3e));
            this.ySs.setBackgroundResource(R.drawable.bdu);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
        } else {
            textView.setText(this.cgL.yTx.getContext().getString(R.string.e3i));
            this.ySs.setBackgroundResource(R.drawable.bdt);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        }
        if (!(this.ySt == null || this.ySs == null)) {
            this.ySt.addView(this.ySs, layoutParams);
            this.ySs.startAnimation(AnimationUtils.loadAnimation(this.cgL.yTx.getContext(), R.anim.d4));
            this.ySs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31739);
                    if (bool.booleanValue()) {
                        am amVar = am.this;
                        Boolean bool = Boolean.TRUE;
                        am.a(amVar, bool, bool);
                        ((o) am.this.cgL.aF(o.class)).dDX().dkc();
                        AppMethodBeat.o(31739);
                        return;
                    }
                    am.a(am.this, Boolean.TRUE, Boolean.FALSE);
                    ((o) am.this.cgL.aF(o.class)).dDX().setMode(2);
                    AppMethodBeat.o(31739);
                }
            });
        }
        AppMethodBeat.o(31743);
    }

    private void c(Boolean bool, Boolean bool2) {
        AppMethodBeat.i(31744);
        if (this.ySs != null) {
            this.ySs.clearAnimation();
            this.ySs.setVisibility(8);
            if (bool2.booleanValue()) {
                if (bool.booleanValue()) {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(340228, Boolean.TRUE);
                    h.pYm.a(232, 1, 1, false);
                    AppMethodBeat.o(31744);
                    return;
                }
            } else if (bool.booleanValue()) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(340229, Boolean.TRUE);
                h.pYm.a(232, 2, 1, false);
            }
        }
        AppMethodBeat.o(31744);
    }

    public final void dxA() {
        AppMethodBeat.i(31745);
        if (r.Zf().booleanValue()) {
            if (!this.cgL.sRl.dsf()) {
                aw.ZK();
                this.ySu = bo.e((Boolean) com.tencent.mm.model.c.Ry().get(340228, null));
                if (!(this.ySu || ((f) this.cgL.aF(f.class)).dDF() || ((d) this.cgL.aF(d.class)).dDs())) {
                    k(Boolean.TRUE);
                }
                aw.ZK();
                this.ySv = bo.e((Boolean) com.tencent.mm.model.c.Ry().get(340229, null));
                long currentTimeMillis = System.currentTimeMillis();
                aw.ZK();
                long a = currentTimeMillis - bo.a((Long) com.tencent.mm.model.c.Ry().get(340240, null), 0);
                if (this.ySu && !this.ySv && a >= 259200000) {
                    k(Boolean.FALSE);
                }
            }
            if (((o) this.cgL.aF(o.class)).dDX() != null) {
                ((o) this.cgL.aF(o.class)).dDX().setTipsShowCallback(this.ySx);
            }
        }
        AppMethodBeat.o(31745);
    }

    public final void dxB() {
        AppMethodBeat.i(31746);
        if (!this.cgL.sRl.dsf() && r.Zf().booleanValue()) {
            Boolean bool = Boolean.FALSE;
            c(bool, bool);
        }
        AppMethodBeat.o(31746);
    }
}
