package com.tencent.p177mm.plugin.appbrand.p336ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.plugin.appbrand.C42641p;
import com.tencent.p177mm.plugin.appbrand.C6750i;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.g */
public final class C42694g extends C7355b implements C27333q {
    private final C6750i gPI;
    private final Bitmap iIr;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.g$1 */
    class C335551 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.g$1$1 */
        class C335561 implements Runnable {
            C335561() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133087);
                C42694g.m75612a(C42694g.this);
                AppMethodBeat.m2505o(133087);
            }
        }

        C335551() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133089);
            final C42694g c42694g = C42694g.this;
            if (c42694g.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup) c42694g.getParent();
                c42694g.animate().alpha(0.0f).withEndAction(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(133088);
                        c42694g.setVisibility(8);
                        viewGroup.removeView(c42694g);
                        AppMethodBeat.m2505o(133088);
                    }
                }).withStartAction(new C335561()).start();
            }
            AppMethodBeat.m2505o(133089);
        }
    }

    public C42694g(Context context, C6750i c6750i, Bitmap bitmap) {
        super(context);
        AppMethodBeat.m2504i(133090);
        this.iIr = bitmap;
        this.gPI = c6750i;
        setupFullscreen(C42641p.m75512k(this.gPI));
        mo15854qM(true);
        setBackground(new BitmapDrawable(getResources(), bitmap));
        View inflate = LayoutInflater.from(context).inflate(2130968735, this, false);
        addView(inflate, new LayoutParams(-2, -2, 17));
        ((TextView) inflate.findViewById(2131820678)).setText(C25738R.string.f8947ka);
        inflate.findViewById(2131821371).setVisibility(8);
        AppMethodBeat.m2505o(133090);
    }

    private void setupFullscreen(boolean z) {
        AppMethodBeat.m2504i(133091);
        C42696n.m75623q(getContext(), z);
        AppMethodBeat.m2505o(133091);
    }

    /* renamed from: cz */
    public final void mo22399cz(String str, String str2) {
    }

    public final void aHS() {
        AppMethodBeat.m2504i(133092);
        post(new C335551());
        AppMethodBeat.m2505o(133092);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(133093);
        super.onDetachedFromWindow();
        this.iIr.recycle();
        AppMethodBeat.m2505o(133093);
    }

    public final void aHT() {
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }

    /* renamed from: a */
    static /* synthetic */ void m75612a(C42694g c42694g) {
        AppMethodBeat.m2504i(133094);
        ProgressBar progressBar = (ProgressBar) c42694g.findViewById(2131821370);
        if (progressBar != null && (progressBar.getIndeterminateDrawable() instanceof Animatable)) {
            ((Animatable) progressBar.getIndeterminateDrawable()).stop();
        }
        AppMethodBeat.m2505o(133094);
    }
}
