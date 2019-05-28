package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;

public final class q implements g {
    private final MMWebView fow;
    private final MMActivity jiE;

    public q(MMActivity mMActivity, MMWebView mMWebView) {
        this.jiE = mMActivity;
        this.fow = mMWebView;
    }

    public final Activity getActivity() {
        return this.jiE;
    }

    public final Intent getIntent() {
        AppMethodBeat.i(8280);
        Intent intent = this.jiE.getIntent();
        AppMethodBeat.o(8280);
        return intent;
    }

    public final String getUrl() {
        AppMethodBeat.i(8281);
        String url = this.fow.getUrl();
        AppMethodBeat.o(8281);
        return url;
    }

    public final ViewGroup bSl() {
        AppMethodBeat.i(8282);
        ViewGroup viewGroup = (ViewGroup) this.jiE.getWindow().getDecorView();
        AppMethodBeat.o(8282);
        return viewGroup;
    }

    public final View getContentView() {
        AppMethodBeat.i(8283);
        if (this.jiE.getSwipeBackLayout() == null) {
            AppMethodBeat.o(8283);
            return null;
        }
        View targetContentView = this.jiE.getSwipeBackLayout().getTargetContentView();
        AppMethodBeat.o(8283);
        return targetContentView;
    }

    public final boolean cXe() {
        AppMethodBeat.i(8284);
        if (this.jiE.getSwipeBackLayout() != null) {
            AppMethodBeat.o(8284);
            return true;
        }
        AppMethodBeat.o(8284);
        return false;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(8285);
        if (this.jiE.getSwipeBackLayout() == null) {
            AppMethodBeat.o(8285);
            return;
        }
        this.jiE.getSwipeBackLayout().setSwipeBackListener(new b() {
            public final void bf(float f) {
                AppMethodBeat.i(8276);
                aVar.bg(f);
                AppMethodBeat.o(8276);
            }

            public final void l(MotionEvent motionEvent) {
                AppMethodBeat.i(8277);
                aVar.l(motionEvent);
                AppMethodBeat.o(8277);
            }

            public final boolean ba(boolean z) {
                AppMethodBeat.i(8278);
                boolean ba = aVar.ba(z);
                AppMethodBeat.o(8278);
                return ba;
            }
        });
        AppMethodBeat.o(8285);
    }

    public final void mu(boolean z) {
        AppMethodBeat.i(8286);
        if (z) {
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.c9);
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.s);
        } else {
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            this.jiE.getIntent().putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
        }
        this.jiE.finish();
        AppMethodBeat.o(8286);
    }

    public final void a(final g.b bVar) {
        AppMethodBeat.i(8287);
        com.tencent.mm.ui.base.b.a(this.jiE, new com.tencent.mm.ui.base.b.a() {
            public final void iH(boolean z) {
                AppMethodBeat.i(8279);
                bVar.iH(z);
                AppMethodBeat.o(8279);
            }
        });
        AppMethodBeat.o(8287);
    }
}
