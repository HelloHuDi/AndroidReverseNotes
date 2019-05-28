package com.tencent.p177mm.plugin.account.p275ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.account.ui.WelcomeSelectView */
public class WelcomeSelectView extends WelcomeView {
    private Context context;
    protected View gCO;
    protected Button gIv;
    protected Button gIw;
    protected TextView gIx;
    private int mHeight = 800;

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeSelectView$1 */
    class C412181 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeSelectView$1$1 */
        class C330361 implements C1835a {
            C330361() {
            }

            /* renamed from: a */
            public final void mo4918a(C1902e c1902e) {
            }
        }

        C412181() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125660);
            C1720g.m3540Rg().mo14541a(new C6668bk(new C330361(), "launch normal"), 0);
            AppMethodBeat.m2505o(125660);
        }
    }

    @TargetApi(11)
    public WelcomeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(125661);
        m71756cA(context);
        AppMethodBeat.m2505o(125661);
    }

    public WelcomeSelectView(Context context) {
        super(context);
        AppMethodBeat.m2504i(125662);
        m71756cA(context);
        AppMethodBeat.m2505o(125662);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(125663);
        super.dispatchDraw(canvas);
        AppMethodBeat.m2505o(125663);
    }

    /* Access modifiers changed, original: final */
    public final void init() {
        AppMethodBeat.m2504i(125664);
        String h = C4988aa.m7405h(this.context.getSharedPreferences(C4996ah.doA(), 0));
        this.gIx.setText(C4988aa.m7404gx(this.context));
        if (h != null && h.equals("language_default")) {
            this.gIx.setText(this.context.getString(C25738R.string.col));
        }
        this.gIv.setText(C25738R.string.ce0);
        this.gIw.setText(C25738R.string.cdz);
        AppMethodBeat.m2505o(125664);
    }

    /* renamed from: cA */
    private void m71756cA(Context context) {
        AppMethodBeat.m2504i(125665);
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(2130971229, this);
        this.gCO = inflate.findViewById(2131829217);
        this.gIv = (Button) inflate.findViewById(2131827314);
        this.gIw = (Button) inflate.findViewById(2131827313);
        this.gIx = (TextView) inflate.findViewById(2131829216);
        this.gCO.setVisibility(8);
        this.gIx.setVisibility(8);
        this.gIx.setText(C4988aa.m7404gx(context));
        this.mHeight = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.m2505o(125665);
    }

    public final void arN() {
        AppMethodBeat.m2504i(125666);
        mo60826cj(this.gCO);
        mo60826cj(this.gIx);
        this.gCO.setVisibility(0);
        this.gIx.setVisibility(0);
        C5004al.m7441d(new C412181());
        AppMethodBeat.m2505o(125666);
    }
}
