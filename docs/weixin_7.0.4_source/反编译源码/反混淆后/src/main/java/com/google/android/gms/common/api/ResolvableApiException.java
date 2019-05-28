package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        AppMethodBeat.m2504i(89446);
        PendingIntent resolution = this.mStatus.getResolution();
        AppMethodBeat.m2505o(89446);
        return resolution;
    }

    public void startResolutionForResult(Activity activity, int i) {
        AppMethodBeat.m2504i(89445);
        this.mStatus.startResolutionForResult(activity, i);
        AppMethodBeat.m2505o(89445);
    }
}
