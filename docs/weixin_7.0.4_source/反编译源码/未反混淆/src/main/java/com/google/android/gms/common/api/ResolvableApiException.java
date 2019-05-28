package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        AppMethodBeat.i(89446);
        PendingIntent resolution = this.mStatus.getResolution();
        AppMethodBeat.o(89446);
        return resolution;
    }

    public void startResolutionForResult(Activity activity, int i) {
        AppMethodBeat.i(89445);
        this.mStatus.startResolutionForResult(activity, i);
        AppMethodBeat.o(89445);
    }
}
