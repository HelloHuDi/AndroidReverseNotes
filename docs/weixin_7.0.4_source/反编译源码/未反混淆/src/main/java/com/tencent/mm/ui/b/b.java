package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.h;
import android.support.v7.widget.x;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends a implements android.support.v7.view.menu.h.a, android.support.v7.view.menu.o.a {
    public ViewGroup SW;
    private boolean Vo;
    private h lo;
    a yrc;
    boolean yrd;
    private final Runnable yre = new Runnable() {
        public final void run() {
            AppMethodBeat.i(106149);
            android.support.v7.view.menu.h.a aVar = b.this;
            Context context = aVar.mActivity;
            ActionBar supportActionBar = aVar.getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            }
            h hVar = new h(context);
            hVar.a(aVar);
            if (b.this.yrc != null) {
                b.this.yrc.d(hVar);
                b.this.yrc.c(hVar);
                b.a(b.this, hVar);
            } else {
                b.a(b.this, null);
            }
            hVar.p(true);
            b.this.yrd = false;
            AppMethodBeat.o(106149);
        }
    };

    public interface a {
        boolean c(Menu menu);

        boolean d(Menu menu);

        boolean h(MenuItem menuItem);
    }

    public b(Activity activity, a aVar) {
        super(activity);
        AppMethodBeat.i(106150);
        this.yrc = aVar;
        AppMethodBeat.o(106150);
    }

    public final ActionBar dzl() {
        AppMethodBeat.i(106151);
        fr();
        if (this.mActionBar == null) {
            this.mActionBar = new d(this.mActivity, this.SW);
        }
        ActionBar actionBar = this.mActionBar;
        AppMethodBeat.o(106151);
        return actionBar;
    }

    private void fr() {
        AppMethodBeat.i(106152);
        if (!this.Vo) {
            this.Vo = true;
            supportInvalidateOptionsMenu();
        }
        AppMethodBeat.o(106152);
    }

    public final boolean a(h hVar, MenuItem menuItem) {
        AppMethodBeat.i(106153);
        if (this.yrc != null) {
            boolean h = this.yrc.h(menuItem);
            AppMethodBeat.o(106153);
            return h;
        }
        AppMethodBeat.o(106153);
        return false;
    }

    public final void a(h hVar, boolean z) {
    }

    public final boolean d(h hVar) {
        return false;
    }

    public final void supportInvalidateOptionsMenu() {
        AppMethodBeat.i(106155);
        if (!this.yrd) {
            this.yrd = true;
            this.yre.run();
        }
        AppMethodBeat.o(106155);
    }

    public final void b(h hVar) {
        AppMethodBeat.i(106154);
        if (this.mActionBar != null) {
            x xVar = ((d) this.mActionBar).Wk;
            if (xVar != null && xVar.gV()) {
                if (xVar.isOverflowMenuShowing()) {
                    xVar.hideOverflowMenu();
                } else if (xVar.getVisibility() == 0) {
                    xVar.showOverflowMenu();
                    AppMethodBeat.o(106154);
                    return;
                }
                AppMethodBeat.o(106154);
                return;
            }
        }
        hVar.close();
        AppMethodBeat.o(106154);
    }
}
