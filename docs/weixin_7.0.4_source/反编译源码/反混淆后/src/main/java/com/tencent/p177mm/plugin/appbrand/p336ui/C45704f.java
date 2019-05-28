package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.f */
final class C45704f extends C7355b implements C27333q {
    private C6750i gPI;
    private Runnable iHa;
    private C10933b isG;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.f$1 */
    class C108721 implements OnClickListener {
        C108721() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(102311);
            C33183g.m54275a(C45704f.this.gPI.mAppId, C33184d.CLOSE);
            C45704f.this.gPI.finish();
            AppMethodBeat.m2505o(102311);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.f$3 */
    class C385343 implements Runnable {
        C385343() {
        }

        public final void run() {
            AppMethodBeat.m2504i(102313);
            C45704f.this.setVisibility(8);
            if (C45704f.this.getParent() != null) {
                ((ViewGroup) C45704f.this.getParent()).removeView(C45704f.this);
            }
            AppMethodBeat.m2505o(102313);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.f$2 */
    class C457032 implements Runnable {
        C457032() {
        }

        public final void run() {
            AppMethodBeat.m2504i(102312);
            if (C45704f.this.isG != null) {
                C45704f.this.isG.setLoadingIconVisibility(true);
            }
            AppMethodBeat.m2505o(102312);
        }
    }

    public C45704f(Context context, C6750i c6750i) {
        super(context);
        AppMethodBeat.m2504i(102314);
        this.gPI = c6750i;
        this.isG = new C10933b(context);
        this.isG.setFullscreenMode(false);
        addView(this.isG.getActionView());
        this.isG.mo22482eP(false);
        C108721 c108721 = new C108721();
        this.isG.setCloseButtonClickListener(c108721);
        this.isG.setBackButtonClickListener(c108721);
        String str = "black";
        this.isG.setMainTitle(C4996ah.getContext().getString(C25738R.string.f8835gc));
        this.isG.setBackgroundColor(-1);
        this.isG.setForegroundStyle(str);
        this.isG.setNavBackOrClose(true);
        this.isG.setLoadingIconVisibility(true);
        mo15851K(-1, "black".equals(str));
        setBackgroundColor(-1);
        AppMethodBeat.m2505o(102314);
    }

    /* renamed from: cz */
    public final void mo22399cz(String str, String str2) {
        AppMethodBeat.m2504i(102315);
        this.isG.setMainTitle(C4996ah.getContext().getString(C25738R.string.f8835gc));
        AppMethodBeat.m2505o(102315);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(102316);
        super.onAttachedToWindow();
        if (this.iHa == null) {
            this.iHa = new C457032();
            postDelayed(this.iHa, 1500);
        }
        AppMethodBeat.m2505o(102316);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(102317);
        super.onDetachedFromWindow();
        removeCallbacks(this.iHa);
        AppMethodBeat.m2505o(102317);
    }

    public final void aHS() {
        AppMethodBeat.m2504i(102318);
        removeCallbacks(this.iHa);
        post(new C385343());
        AppMethodBeat.m2505o(102318);
    }

    public final void aHT() {
        AppMethodBeat.m2504i(102319);
        this.isG.setNavHidden(true);
        AppMethodBeat.m2505o(102319);
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }
}
