package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FragmentWrapper {
    private Fragment nativeFragment;
    private android.support.v4.app.Fragment supportFragment;

    public FragmentWrapper(android.support.v4.app.Fragment fragment) {
        AppMethodBeat.i(96647);
        Validate.notNull(fragment, "fragment");
        this.supportFragment = fragment;
        AppMethodBeat.o(96647);
    }

    public FragmentWrapper(Fragment fragment) {
        AppMethodBeat.i(96648);
        Validate.notNull(fragment, "fragment");
        this.nativeFragment = fragment;
        AppMethodBeat.o(96648);
    }

    public Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public android.support.v4.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.i(96649);
        if (this.supportFragment != null) {
            this.supportFragment.startActivityForResult(intent, i);
            AppMethodBeat.o(96649);
            return;
        }
        this.nativeFragment.startActivityForResult(intent, i);
        AppMethodBeat.o(96649);
    }

    public final Activity getActivity() {
        AppMethodBeat.i(96650);
        if (this.supportFragment != null) {
            FragmentActivity activity = this.supportFragment.getActivity();
            AppMethodBeat.o(96650);
            return activity;
        }
        Activity activity2 = this.nativeFragment.getActivity();
        AppMethodBeat.o(96650);
        return activity2;
    }
}
