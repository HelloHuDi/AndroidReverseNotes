package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.statusbar.b;

@SuppressLint({"ViewConstructor"})
final class f extends b implements q {
    private i gPI;
    private Runnable iHa;
    private com.tencent.mm.plugin.appbrand.widget.actionbar.b isG;

    public f(Context context, i iVar) {
        super(context);
        AppMethodBeat.i(102314);
        this.gPI = iVar;
        this.isG = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(context);
        this.isG.setFullscreenMode(false);
        addView(this.isG.getActionView());
        this.isG.eP(false);
        AnonymousClass1 anonymousClass1 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(102311);
                g.a(f.this.gPI.mAppId, d.CLOSE);
                f.this.gPI.finish();
                AppMethodBeat.o(102311);
            }
        };
        this.isG.setCloseButtonClickListener(anonymousClass1);
        this.isG.setBackButtonClickListener(anonymousClass1);
        String str = "black";
        this.isG.setMainTitle(ah.getContext().getString(R.string.gc));
        this.isG.setBackgroundColor(-1);
        this.isG.setForegroundStyle(str);
        this.isG.setNavBackOrClose(true);
        this.isG.setLoadingIconVisibility(true);
        K(-1, "black".equals(str));
        setBackgroundColor(-1);
        AppMethodBeat.o(102314);
    }

    public final void cz(String str, String str2) {
        AppMethodBeat.i(102315);
        this.isG.setMainTitle(ah.getContext().getString(R.string.gc));
        AppMethodBeat.o(102315);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(102316);
        super.onAttachedToWindow();
        if (this.iHa == null) {
            this.iHa = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102312);
                    if (f.this.isG != null) {
                        f.this.isG.setLoadingIconVisibility(true);
                    }
                    AppMethodBeat.o(102312);
                }
            };
            postDelayed(this.iHa, 1500);
        }
        AppMethodBeat.o(102316);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(102317);
        super.onDetachedFromWindow();
        removeCallbacks(this.iHa);
        AppMethodBeat.o(102317);
    }

    public final void aHS() {
        AppMethodBeat.i(102318);
        removeCallbacks(this.iHa);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102313);
                f.this.setVisibility(8);
                if (f.this.getParent() != null) {
                    ((ViewGroup) f.this.getParent()).removeView(f.this);
                }
                AppMethodBeat.o(102313);
            }
        });
        AppMethodBeat.o(102318);
    }

    public final void aHT() {
        AppMethodBeat.i(102319);
        this.isG.setNavHidden(true);
        AppMethodBeat.o(102319);
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }
}
