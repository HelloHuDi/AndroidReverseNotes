package com.tencent.mm.plugin.account.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public class WelcomeSelectView extends WelcomeView {
    private Context context;
    protected View gCO;
    protected Button gIv;
    protected Button gIw;
    protected TextView gIx;
    private int mHeight = 800;

    @TargetApi(11)
    public WelcomeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(125661);
        cA(context);
        AppMethodBeat.o(125661);
    }

    public WelcomeSelectView(Context context) {
        super(context);
        AppMethodBeat.i(125662);
        cA(context);
        AppMethodBeat.o(125662);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(125663);
        super.dispatchDraw(canvas);
        AppMethodBeat.o(125663);
    }

    /* Access modifiers changed, original: final */
    public final void init() {
        AppMethodBeat.i(125664);
        String h = aa.h(this.context.getSharedPreferences(ah.doA(), 0));
        this.gIx.setText(aa.gx(this.context));
        if (h != null && h.equals("language_default")) {
            this.gIx.setText(this.context.getString(R.string.col));
        }
        this.gIv.setText(R.string.ce0);
        this.gIw.setText(R.string.cdz);
        AppMethodBeat.o(125664);
    }

    private void cA(Context context) {
        AppMethodBeat.i(125665);
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.b7s, this);
        this.gCO = inflate.findViewById(R.id.flf);
        this.gIv = (Button) inflate.findViewById(R.id.e80);
        this.gIw = (Button) inflate.findViewById(R.id.e7z);
        this.gIx = (TextView) inflate.findViewById(R.id.fle);
        this.gCO.setVisibility(8);
        this.gIx.setVisibility(8);
        this.gIx.setText(aa.gx(context));
        this.mHeight = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(125665);
    }

    public final void arN() {
        AppMethodBeat.i(125666);
        cj(this.gCO);
        cj(this.gIx);
        this.gCO.setVisibility(0);
        this.gIx.setVisibility(0);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(125660);
                g.Rg().a(new bk(new a() {
                    public final void a(e eVar) {
                    }
                }, "launch normal"), 0);
                AppMethodBeat.o(125660);
            }
        });
        AppMethodBeat.o(125666);
    }
}
