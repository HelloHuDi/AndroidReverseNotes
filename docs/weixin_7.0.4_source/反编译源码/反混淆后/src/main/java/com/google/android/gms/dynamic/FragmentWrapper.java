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
        AppMethodBeat.m2504i(90342);
        if (fragment != null) {
            FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
            AppMethodBeat.m2505o(90342);
            return fragmentWrapper;
        }
        AppMethodBeat.m2505o(90342);
        return null;
    }

    public final IObjectWrapper getActivity() {
        AppMethodBeat.m2504i(90343);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getActivity());
        AppMethodBeat.m2505o(90343);
        return wrap;
    }

    public final Bundle getArguments() {
        AppMethodBeat.m2504i(90344);
        Bundle arguments = this.zzabm.getArguments();
        AppMethodBeat.m2505o(90344);
        return arguments;
    }

    public final int getId() {
        AppMethodBeat.m2504i(90345);
        int id = this.zzabm.getId();
        AppMethodBeat.m2505o(90345);
        return id;
    }

    public final IFragmentWrapper getParentFragment() {
        AppMethodBeat.m2504i(90346);
        FragmentWrapper wrap = wrap(this.zzabm.getParentFragment());
        AppMethodBeat.m2505o(90346);
        return wrap;
    }

    public final IObjectWrapper getResources() {
        AppMethodBeat.m2504i(90347);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getResources());
        AppMethodBeat.m2505o(90347);
        return wrap;
    }

    public final boolean getRetainInstance() {
        AppMethodBeat.m2504i(90348);
        boolean retainInstance = this.zzabm.getRetainInstance();
        AppMethodBeat.m2505o(90348);
        return retainInstance;
    }

    public final String getTag() {
        AppMethodBeat.m2504i(90349);
        String tag = this.zzabm.getTag();
        AppMethodBeat.m2505o(90349);
        return tag;
    }

    public final IFragmentWrapper getTargetFragment() {
        AppMethodBeat.m2504i(90350);
        FragmentWrapper wrap = wrap(this.zzabm.getTargetFragment());
        AppMethodBeat.m2505o(90350);
        return wrap;
    }

    public final int getTargetRequestCode() {
        AppMethodBeat.m2504i(90351);
        int targetRequestCode = this.zzabm.getTargetRequestCode();
        AppMethodBeat.m2505o(90351);
        return targetRequestCode;
    }

    public final boolean getUserVisibleHint() {
        AppMethodBeat.m2504i(90352);
        boolean userVisibleHint = this.zzabm.getUserVisibleHint();
        AppMethodBeat.m2505o(90352);
        return userVisibleHint;
    }

    public final IObjectWrapper getView() {
        AppMethodBeat.m2504i(90353);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getView());
        AppMethodBeat.m2505o(90353);
        return wrap;
    }

    public final boolean isAdded() {
        AppMethodBeat.m2504i(90354);
        boolean isAdded = this.zzabm.isAdded();
        AppMethodBeat.m2505o(90354);
        return isAdded;
    }

    public final boolean isDetached() {
        AppMethodBeat.m2504i(90355);
        boolean isDetached = this.zzabm.isDetached();
        AppMethodBeat.m2505o(90355);
        return isDetached;
    }

    public final boolean isHidden() {
        AppMethodBeat.m2504i(90356);
        boolean isHidden = this.zzabm.isHidden();
        AppMethodBeat.m2505o(90356);
        return isHidden;
    }

    public final boolean isInLayout() {
        AppMethodBeat.m2504i(90357);
        boolean isInLayout = this.zzabm.isInLayout();
        AppMethodBeat.m2505o(90357);
        return isInLayout;
    }

    public final boolean isRemoving() {
        AppMethodBeat.m2504i(90358);
        boolean isRemoving = this.zzabm.isRemoving();
        AppMethodBeat.m2505o(90358);
        return isRemoving;
    }

    public final boolean isResumed() {
        AppMethodBeat.m2504i(90359);
        boolean isResumed = this.zzabm.isResumed();
        AppMethodBeat.m2505o(90359);
        return isResumed;
    }

    public final boolean isVisible() {
        AppMethodBeat.m2504i(90360);
        boolean isVisible = this.zzabm.isVisible();
        AppMethodBeat.m2505o(90360);
        return isVisible;
    }

    public final void registerForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.m2504i(90361);
        this.zzabm.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.m2505o(90361);
    }

    public final void setHasOptionsMenu(boolean z) {
        AppMethodBeat.m2504i(90362);
        this.zzabm.setHasOptionsMenu(z);
        AppMethodBeat.m2505o(90362);
    }

    public final void setMenuVisibility(boolean z) {
        AppMethodBeat.m2504i(90363);
        this.zzabm.setMenuVisibility(z);
        AppMethodBeat.m2505o(90363);
    }

    public final void setRetainInstance(boolean z) {
        AppMethodBeat.m2504i(90364);
        this.zzabm.setRetainInstance(z);
        AppMethodBeat.m2505o(90364);
    }

    public final void setUserVisibleHint(boolean z) {
        AppMethodBeat.m2504i(90365);
        this.zzabm.setUserVisibleHint(z);
        AppMethodBeat.m2505o(90365);
    }

    public final void startActivity(Intent intent) {
        AppMethodBeat.m2504i(90366);
        this.zzabm.startActivity(intent);
        AppMethodBeat.m2505o(90366);
    }

    public final void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.m2504i(90367);
        this.zzabm.startActivityForResult(intent, i);
        AppMethodBeat.m2505o(90367);
    }

    public final void unregisterForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.m2504i(90368);
        this.zzabm.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.m2505o(90368);
    }
}
