package com.tencent.p177mm.p612ui.p614b;

import android.app.Activity;
import android.support.p069v7.view.C0614i;
import android.view.ActionMode;
import android.view.Window.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.b.c */
public final class C15500c extends C0614i {
    private Activity mActivity;

    public C15500c(Callback callback, Activity activity) {
        super(callback);
        this.mActivity = activity;
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        AppMethodBeat.m2504i(106157);
        ActionMode onWindowStartingActionMode = this.mActivity.onWindowStartingActionMode(callback);
        AppMethodBeat.m2505o(106157);
        return onWindowStartingActionMode;
    }
}
