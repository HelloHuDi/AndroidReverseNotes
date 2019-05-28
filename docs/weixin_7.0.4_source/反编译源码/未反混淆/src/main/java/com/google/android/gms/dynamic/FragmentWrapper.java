package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.IFragmentWrapper.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"NewApi"})
public final class FragmentWrapper extends Stub {
    private Fragment zzabm;

    private FragmentWrapper(Fragment fragment) {
        this.zzabm = fragment;
    }

    public static FragmentWrapper wrap(Fragment fragment) {
        AppMethodBeat.i(90342);
        if (fragment != null) {
            FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
            AppMethodBeat.o(90342);
            return fragmentWrapper;
        }
        AppMethodBeat.o(90342);
        return null;
    }

    public final IObjectWrapper getActivity() {
        AppMethodBeat.i(90343);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getActivity());
        AppMethodBeat.o(90343);
        return wrap;
    }

    public final Bundle getArguments() {
        AppMethodBeat.i(90344);
        Bundle arguments = this.zzabm.getArguments();
        AppMethodBeat.o(90344);
        return arguments;
    }

    public final int getId() {
        AppMethodBeat.i(90345);
        int id = this.zzabm.getId();
        AppMethodBeat.o(90345);
        return id;
    }

    public final IFragmentWrapper getParentFragment() {
        AppMethodBeat.i(90346);
        FragmentWrapper wrap = wrap(this.zzabm.getParentFragment());
        AppMethodBeat.o(90346);
        return wrap;
    }

    public final IObjectWrapper getResources() {
        AppMethodBeat.i(90347);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getResources());
        AppMethodBeat.o(90347);
        return wrap;
    }

    public final boolean getRetainInstance() {
        AppMethodBeat.i(90348);
        boolean retainInstance = this.zzabm.getRetainInstance();
        AppMethodBeat.o(90348);
        return retainInstance;
    }

    public final String getTag() {
        AppMethodBeat.i(90349);
        String tag = this.zzabm.getTag();
        AppMethodBeat.o(90349);
        return tag;
    }

    public final IFragmentWrapper getTargetFragment() {
        AppMethodBeat.i(90350);
        FragmentWrapper wrap = wrap(this.zzabm.getTargetFragment());
        AppMethodBeat.o(90350);
        return wrap;
    }

    public final int getTargetRequestCode() {
        AppMethodBeat.i(90351);
        int targetRequestCode = this.zzabm.getTargetRequestCode();
        AppMethodBeat.o(90351);
        return targetRequestCode;
    }

    public final boolean getUserVisibleHint() {
        AppMethodBeat.i(90352);
        boolean userVisibleHint = this.zzabm.getUserVisibleHint();
        AppMethodBeat.o(90352);
        return userVisibleHint;
    }

    public final IObjectWrapper getView() {
        AppMethodBeat.i(90353);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getView());
        AppMethodBeat.o(90353);
        return wrap;
    }

    public final boolean isAdded() {
        AppMethodBeat.i(90354);
        boolean isAdded = this.zzabm.isAdded();
        AppMethodBeat.o(90354);
        return isAdded;
    }

    public final boolean isDetached() {
        AppMethodBeat.i(90355);
        boolean isDetached = this.zzabm.isDetached();
        AppMethodBeat.o(90355);
        return isDetached;
    }

    public final boolean isHidden() {
        AppMethodBeat.i(90356);
        boolean isHidden = this.zzabm.isHidden();
        AppMethodBeat.o(90356);
        return isHidden;
    }

    public final boolean isInLayout() {
        AppMethodBeat.i(90357);
        boolean isInLayout = this.zzabm.isInLayout();
        AppMethodBeat.o(90357);
        return isInLayout;
    }

    public final boolean isRemoving() {
        AppMethodBeat.i(90358);
        boolean isRemoving = this.zzabm.isRemoving();
        AppMethodBeat.o(90358);
        return isRemoving;
    }

    public final boolean isResumed() {
        AppMethodBeat.i(90359);
        boolean isResumed = this.zzabm.isResumed();
        AppMethodBeat.o(90359);
        return isResumed;
    }

    public final boolean isVisible() {
        AppMethodBeat.i(90360);
        boolean isVisible = this.zzabm.isVisible();
        AppMethodBeat.o(90360);
        return isVisible;
    }

    public final void registerForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.i(90361);
        this.zzabm.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.o(90361);
    }

    public final void setHasOptionsMenu(boolean z) {
        AppMethodBeat.i(90362);
        this.zzabm.setHasOptionsMenu(z);
        AppMethodBeat.o(90362);
    }

    public final void setMenuVisibility(boolean z) {
        AppMethodBeat.i(90363);
        this.zzabm.setMenuVisibility(z);
        AppMethodBeat.o(90363);
    }

    public final void setRetainInstance(boolean z) {
        AppMethodBeat.i(90364);
        this.zzabm.setRetainInstance(z);
        AppMethodBeat.o(90364);
    }

    public final void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(90365);
        this.zzabm.setUserVisibleHint(z);
        AppMethodBeat.o(90365);
    }

    public final void startActivity(Intent intent) {
        AppMethodBeat.i(90366);
        this.zzabm.startActivity(intent);
        AppMethodBeat.o(90366);
    }

    public final void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.i(90367);
        this.zzabm.startActivityForResult(intent, i);
        AppMethodBeat.o(90367);
    }

    public final void unregisterForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.i(90368);
        this.zzabm.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.o(90368);
    }
}
