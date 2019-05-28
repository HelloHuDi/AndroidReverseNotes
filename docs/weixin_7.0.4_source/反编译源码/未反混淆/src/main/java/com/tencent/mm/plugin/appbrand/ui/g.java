package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.ui.statusbar.b;

public final class g extends b implements q {
    private final i gPI;
    private final Bitmap iIr;

    public g(Context context, i iVar, Bitmap bitmap) {
        super(context);
        AppMethodBeat.i(133090);
        this.iIr = bitmap;
        this.gPI = iVar;
        setupFullscreen(p.k(this.gPI));
        qM(true);
        setBackground(new BitmapDrawable(getResources(), bitmap));
        View inflate = LayoutInflater.from(context).inflate(R.layout.dl, this, false);
        addView(inflate, new LayoutParams(-2, -2, 17));
        ((TextView) inflate.findViewById(R.id.cx)).setText(R.string.ka);
        inflate.findViewById(R.id.vn).setVisibility(8);
        AppMethodBeat.o(133090);
    }

    private void setupFullscreen(boolean z) {
        AppMethodBeat.i(133091);
        n.q(getContext(), z);
        AppMethodBeat.o(133091);
    }

    public final void cz(String str, String str2) {
    }

    public final void aHS() {
        AppMethodBeat.i(133092);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133089);
                final g gVar = g.this;
                if (gVar.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup = (ViewGroup) gVar.getParent();
                    gVar.animate().alpha(0.0f).withEndAction(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133088);
                            gVar.setVisibility(8);
                            viewGroup.removeView(gVar);
                            AppMethodBeat.o(133088);
                        }
                    }).withStartAction(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133087);
                            g.a(g.this);
                            AppMethodBeat.o(133087);
                        }
                    }).start();
                }
                AppMethodBeat.o(133089);
            }
        });
        AppMethodBeat.o(133092);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(133093);
        super.onDetachedFromWindow();
        this.iIr.recycle();
        AppMethodBeat.o(133093);
    }

    public final void aHT() {
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(133094);
        ProgressBar progressBar = (ProgressBar) gVar.findViewById(R.id.vm);
        if (progressBar != null && (progressBar.getIndeterminateDrawable() instanceof Animatable)) {
            ((Animatable) progressBar.getIndeterminateDrawable()).stop();
        }
        AppMethodBeat.o(133094);
    }
}
