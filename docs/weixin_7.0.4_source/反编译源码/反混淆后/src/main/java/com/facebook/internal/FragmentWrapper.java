package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.p057v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FragmentWrapper {
    private Fragment nativeFragment;
    private android.support.p057v4.app.Fragment supportFragment;

    public FragmentWrapper(android.support.p057v4.app.Fragment fragment) {
        AppMethodBeat.m2504i(96647);
        Validate.notNull(fragment, "fragment");
        this.supportFragment = fragment;
        AppMethodBeat.m2505o(96647);
    }

    public FragmentWrapper(Fragment fragment) {
        AppMethodBeat.m2504i(96648);
        Validate.notNull(fragment, "fragment");
        this.nativeFragment = fragment;
        AppMethodBeat.m2505o(96648);
    }

    public Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public android.support.p057v4.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.m2504i(96649);
        if (this.supportFragment != null) {
            this.supportFragment.startActivityForResult(intent, i);
            AppMethodBeat.m2505o(96649);
            return;
        }
        this.nativeFragment.startActivityForResult(intent, i);
        AppMethodBeat.m2505o(96649);
    }

    public final Activity getActivity() {
        AppMethodBeat.m2504i(96650);
        if (this.supportFragment != null) {
            FragmentActivity activity = this.supportFragment.getActivity();
            AppMethodBeat.m2505o(96650);
            return activity;
        }
        Activity activity2 = this.nativeFragment.getActivity();
        AppMethodBeat.m2505o(96650);
        return activity2;
    }
}
