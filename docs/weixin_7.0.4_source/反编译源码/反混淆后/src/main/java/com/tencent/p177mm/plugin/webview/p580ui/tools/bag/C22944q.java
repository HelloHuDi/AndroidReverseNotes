package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.C5274b.C5272a;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout.C5629b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g.C43944b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g.C43946a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.q */
public final class C22944q implements C43945g {
    private final MMWebView fow;
    private final MMActivity jiE;

    public C22944q(MMActivity mMActivity, MMWebView mMWebView) {
        this.jiE = mMActivity;
        this.fow = mMWebView;
    }

    public final Activity getActivity() {
        return this.jiE;
    }

    public final Intent getIntent() {
        AppMethodBeat.m2504i(8280);
        Intent intent = this.jiE.getIntent();
        AppMethodBeat.m2505o(8280);
        return intent;
    }

    public final String getUrl() {
        AppMethodBeat.m2504i(8281);
        String url = this.fow.getUrl();
        AppMethodBeat.m2505o(8281);
        return url;
    }

    public final ViewGroup bSl() {
        AppMethodBeat.m2504i(8282);
        ViewGroup viewGroup = (ViewGroup) this.jiE.getWindow().getDecorView();
        AppMethodBeat.m2505o(8282);
        return viewGroup;
    }

    public final View getContentView() {
        AppMethodBeat.m2504i(8283);
        if (this.jiE.getSwipeBackLayout() == null) {
            AppMethodBeat.m2505o(8283);
            return null;
        }
        View targetContentView = this.jiE.getSwipeBackLayout().getTargetContentView();
        AppMethodBeat.m2505o(8283);
        return targetContentView;
    }

    public final boolean cXe() {
        AppMethodBeat.m2504i(8284);
        if (this.jiE.getSwipeBackLayout() != null) {
            AppMethodBeat.m2505o(8284);
            return true;
        }
        AppMethodBeat.m2505o(8284);
        return false;
    }

    /* renamed from: a */
    public final void mo38458a(final C43946a c43946a) {
        AppMethodBeat.m2504i(8285);
        if (this.jiE.getSwipeBackLayout() == null) {
            AppMethodBeat.m2505o(8285);
            return;
        }
        this.jiE.getSwipeBackLayout().setSwipeBackListener(new C5629b() {
            /* renamed from: bf */
            public final void mo11404bf(float f) {
                AppMethodBeat.m2504i(8276);
                c43946a.mo26833bg(f);
                AppMethodBeat.m2505o(8276);
            }

            /* renamed from: l */
            public final void mo11405l(MotionEvent motionEvent) {
                AppMethodBeat.m2504i(8277);
                c43946a.mo26834l(motionEvent);
                AppMethodBeat.m2505o(8277);
            }

            /* renamed from: ba */
            public final boolean mo11403ba(boolean z) {
                AppMethodBeat.m2504i(8278);
                boolean ba = c43946a.mo26832ba(z);
                AppMethodBeat.m2505o(8278);
                return ba;
            }
        });
        AppMethodBeat.m2505o(8285);
    }

    /* renamed from: mu */
    public final void mo38466mu(boolean z) {
        AppMethodBeat.m2504i(8286);
        if (z) {
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8367c9);
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8293s);
        } else {
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
        }
        this.jiE.finish();
        AppMethodBeat.m2505o(8286);
    }

    /* renamed from: a */
    public final void mo38459a(final C43944b c43944b) {
        AppMethodBeat.m2504i(8287);
        C5274b.m8045a(this.jiE, new C5272a() {
            /* renamed from: iH */
            public final void mo10877iH(boolean z) {
                AppMethodBeat.m2504i(8279);
                c43944b.mo56357iH(z);
                AppMethodBeat.m2505o(8279);
            }
        });
        AppMethodBeat.m2505o(8287);
    }
}
