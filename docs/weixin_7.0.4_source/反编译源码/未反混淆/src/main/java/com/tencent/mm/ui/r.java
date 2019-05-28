package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class r extends q implements a {
    private ActionBar mActionBar;
    public MMFragment ymV = null;
    public b ymW;

    public final ActionMode startActionMode(Callback callback) {
        AppMethodBeat.i(106027);
        ActionMode startActionMode = this.ymW.startActionMode(callback);
        AppMethodBeat.o(106027);
        return startActionMode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        AppMethodBeat.i(106028);
        if (this.ymV != null) {
            int layoutId = this.ymV.getLayoutId();
            AppMethodBeat.o(106028);
            return layoutId;
        }
        AppMethodBeat.o(106028);
        return -1;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dealContentView(View view) {
        AppMethodBeat.i(106029);
        if (this.ymV != null) {
            this.ymV.dealContentView(view);
        }
        AppMethodBeat.o(106029);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bJj() {
        AppMethodBeat.i(106030);
        if (this.ymV != null) {
            String identityString = this.ymV.getIdentityString();
            AppMethodBeat.o(106030);
            return identityString;
        }
        AppMethodBeat.o(106030);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final View getLayoutView() {
        AppMethodBeat.i(106031);
        if (this.ymV != null) {
            View layoutView = this.ymV.getLayoutView();
            AppMethodBeat.o(106031);
            return layoutView;
        }
        AppMethodBeat.o(106031);
        return null;
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(106032);
        if (this.ymV != null) {
            this.ymV.onKeyboardStateChanged();
        }
        AppMethodBeat.o(106032);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(106033);
        if (this.ymV != null) {
            this.ymV.onCreateBeforeSetContentView();
        }
        AppMethodBeat.o(106033);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getClassName() {
        AppMethodBeat.i(106034);
        String name = this.ymV.getClass().getName();
        AppMethodBeat.o(106034);
        return name;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dxT() {
        return false;
    }

    public final ActionBar getSupportActionBar() {
        AppMethodBeat.i(106035);
        if (this.mActionBar == null) {
            this.mActionBar = this.ymW.dzl();
        }
        ActionBar actionBar = this.mActionBar;
        AppMethodBeat.o(106035);
        return actionBar;
    }

    public final boolean interceptSupportInvalidateOptionsMenu() {
        return true;
    }

    public final void supportInvalidateOptionsMenu() {
        AppMethodBeat.i(106036);
        this.ymW.supportInvalidateOptionsMenu();
        AppMethodBeat.o(106036);
    }

    public final boolean c(Menu menu) {
        AppMethodBeat.i(106037);
        if (this.ymV != null) {
            this.ymV.onPrepareOptionsMenu(menu);
        }
        AppMethodBeat.o(106037);
        return true;
    }

    public final boolean d(Menu menu) {
        AppMethodBeat.i(106038);
        MMFragment mMFragment = this.ymV;
        b bVar = this.ymW;
        if (bVar.mY == null) {
            ActionBar supportActionBar = bVar.getSupportActionBar();
            if (supportActionBar != null) {
                bVar.mY = new g(supportActionBar.getThemedContext());
            } else {
                bVar.mY = new g(bVar.mActivity);
            }
        }
        mMFragment.onCreateOptionsMenu(menu, bVar.mY);
        AppMethodBeat.o(106038);
        return true;
    }

    public final boolean h(MenuItem menuItem) {
        AppMethodBeat.i(106039);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(106039);
        return onOptionsItemSelected;
    }
}
