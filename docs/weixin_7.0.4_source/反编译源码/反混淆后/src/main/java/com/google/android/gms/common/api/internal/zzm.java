package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm implements Runnable {
    private final zzl zzev;
    final /* synthetic */ zzk zzew;

    zzm(zzk zzk, zzl zzl) {
        this.zzew = zzk;
        this.zzev = zzl;
    }

    public final void run() {
        AppMethodBeat.m2504i(60940);
        if (this.zzew.mStarted) {
            ConnectionResult connectionResult = this.zzev.getConnectionResult();
            if (connectionResult.hasResolution()) {
                this.zzew.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zza(this.zzew.getActivity(), connectionResult.getResolution(), this.zzev.zzu(), false), 1);
                AppMethodBeat.m2505o(60940);
                return;
            } else if (this.zzew.zzdg.isUserResolvableError(connectionResult.getErrorCode())) {
                this.zzew.zzdg.showErrorDialogFragment(this.zzew.getActivity(), this.zzew.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.zzew);
                AppMethodBeat.m2505o(60940);
                return;
            } else if (connectionResult.getErrorCode() == 18) {
                this.zzew.zzdg.registerCallbackOnUpdate(this.zzew.getActivity().getApplicationContext(), new zzn(this, this.zzew.zzdg.showUpdatingDialog(this.zzew.getActivity(), this.zzew)));
                AppMethodBeat.m2505o(60940);
                return;
            } else {
                this.zzew.zza(connectionResult, this.zzev.zzu());
                AppMethodBeat.m2505o(60940);
                return;
            }
        }
        AppMethodBeat.m2505o(60940);
    }
}
