package com.tencent.p177mm.p612ui;

import android.support.p069v7.app.ActionBar;
import android.support.p069v7.view.C0611g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.p614b.C7318b;
import com.tencent.p177mm.p612ui.p614b.C7318b.C5239a;

/* renamed from: com.tencent.mm.ui.r */
public final class C7354r extends C5536q implements C5239a {
    private ActionBar mActionBar;
    public MMFragment ymV = null;
    public C7318b ymW;

    public final ActionMode startActionMode(Callback callback) {
        AppMethodBeat.m2504i(106027);
        ActionMode startActionMode = this.ymW.startActionMode(callback);
        AppMethodBeat.m2505o(106027);
        return startActionMode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        AppMethodBeat.m2504i(106028);
        if (this.ymV != null) {
            int layoutId = this.ymV.getLayoutId();
            AppMethodBeat.m2505o(106028);
            return layoutId;
        }
        AppMethodBeat.m2505o(106028);
        return -1;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(106029);
        if (this.ymV != null) {
            this.ymV.dealContentView(view);
        }
        AppMethodBeat.m2505o(106029);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bJj() {
        AppMethodBeat.m2504i(106030);
        if (this.ymV != null) {
            String identityString = this.ymV.getIdentityString();
            AppMethodBeat.m2505o(106030);
            return identityString;
        }
        AppMethodBeat.m2505o(106030);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final View getLayoutView() {
        AppMethodBeat.m2504i(106031);
        if (this.ymV != null) {
            View layoutView = this.ymV.getLayoutView();
            AppMethodBeat.m2505o(106031);
            return layoutView;
        }
        AppMethodBeat.m2505o(106031);
        return null;
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(106032);
        if (this.ymV != null) {
            this.ymV.onKeyboardStateChanged();
        }
        AppMethodBeat.m2505o(106032);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(106033);
        if (this.ymV != null) {
            this.ymV.onCreateBeforeSetContentView();
        }
        AppMethodBeat.m2505o(106033);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getClassName() {
        AppMethodBeat.m2504i(106034);
        String name = this.ymV.getClass().getName();
        AppMethodBeat.m2505o(106034);
        return name;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dxT() {
        return false;
    }

    public final ActionBar getSupportActionBar() {
        AppMethodBeat.m2504i(106035);
        if (this.mActionBar == null) {
            this.mActionBar = this.ymW.dzl();
        }
        ActionBar actionBar = this.mActionBar;
        AppMethodBeat.m2505o(106035);
        return actionBar;
    }

    public final boolean interceptSupportInvalidateOptionsMenu() {
        return true;
    }

    public final void supportInvalidateOptionsMenu() {
        AppMethodBeat.m2504i(106036);
        this.ymW.supportInvalidateOptionsMenu();
        AppMethodBeat.m2505o(106036);
    }

    /* renamed from: c */
    public final boolean mo10745c(Menu menu) {
        AppMethodBeat.m2504i(106037);
        if (this.ymV != null) {
            this.ymV.onPrepareOptionsMenu(menu);
        }
        AppMethodBeat.m2505o(106037);
        return true;
    }

    /* renamed from: d */
    public final boolean mo10746d(Menu menu) {
        AppMethodBeat.m2504i(106038);
        MMFragment mMFragment = this.ymV;
        C7318b c7318b = this.ymW;
        if (c7318b.f1300mY == null) {
            ActionBar supportActionBar = c7318b.getSupportActionBar();
            if (supportActionBar != null) {
                c7318b.f1300mY = new C0611g(supportActionBar.getThemedContext());
            } else {
                c7318b.f1300mY = new C0611g(c7318b.mActivity);
            }
        }
        mMFragment.onCreateOptionsMenu(menu, c7318b.f1300mY);
        AppMethodBeat.m2505o(106038);
        return true;
    }

    /* renamed from: h */
    public final boolean mo10747h(MenuItem menuItem) {
        AppMethodBeat.m2504i(106039);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.m2505o(106039);
        return onOptionsItemSelected;
    }
}
