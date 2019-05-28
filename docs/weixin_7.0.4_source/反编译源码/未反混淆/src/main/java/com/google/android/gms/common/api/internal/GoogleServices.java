package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MetadataValueReader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
public final class GoogleServices {
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static GoogleServices zzku;
    private final String zzkv;
    private final Status zzkw;
    private final boolean zzkx;
    private final boolean zzky;

    static {
        AppMethodBeat.i(89479);
        AppMethodBeat.o(89479);
    }

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(Context context) {
        boolean z = true;
        AppMethodBeat.i(89470);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.zzky = z;
            z = z2;
        } else {
            this.zzky = false;
        }
        this.zzkx = z;
        CharSequence googleAppId = MetadataValueReader.getGoogleAppId(context);
        if (googleAppId == null) {
            googleAppId = new StringResourceValueReader(context).getString("google_app_id");
        }
        if (TextUtils.isEmpty(googleAppId)) {
            this.zzkw = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzkv = null;
            AppMethodBeat.o(89470);
            return;
        }
        this.zzkv = googleAppId;
        this.zzkw = Status.RESULT_SUCCESS;
        AppMethodBeat.o(89470);
    }

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(String str, boolean z) {
        AppMethodBeat.i(89471);
        this.zzkv = str;
        this.zzkw = Status.RESULT_SUCCESS;
        this.zzkx = z;
        this.zzky = !z;
        AppMethodBeat.o(89471);
    }

    @KeepForSdk
    private static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        AppMethodBeat.i(89478);
        synchronized (sLock) {
            try {
                if (zzku == null) {
                    Object illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
                    throw illegalStateException;
                }
                googleServices = zzku;
            } finally {
                AppMethodBeat.o(89478);
            }
        }
        AppMethodBeat.o(89478);
        return googleServices;
    }

    @KeepForSdk
    @VisibleForTesting
    static void clearInstanceForTest() {
        synchronized (sLock) {
            zzku = null;
        }
    }

    @KeepForSdk
    public static String getGoogleAppId() {
        AppMethodBeat.i(89475);
        String str = checkInitialized("getGoogleAppId").zzkv;
        AppMethodBeat.o(89475);
        return str;
    }

    @KeepForSdk
    public static Status initialize(Context context) {
        Status status;
        AppMethodBeat.i(89474);
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (sLock) {
            try {
                if (zzku == null) {
                    zzku = new GoogleServices(context);
                }
                status = zzku.zzkw;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(89474);
            }
        }
        return status;
    }

    @KeepForSdk
    public static Status initialize(Context context, String str, boolean z) {
        Status checkGoogleAppId;
        AppMethodBeat.i(89472);
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (sLock) {
            try {
                if (zzku != null) {
                    checkGoogleAppId = zzku.checkGoogleAppId(str);
                } else {
                    GoogleServices googleServices = new GoogleServices(str, z);
                    zzku = googleServices;
                    checkGoogleAppId = googleServices.zzkw;
                    AppMethodBeat.o(89472);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(89472);
            }
        }
        return checkGoogleAppId;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        AppMethodBeat.i(89476);
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        if (checkInitialized.zzkw.isSuccess() && checkInitialized.zzkx) {
            AppMethodBeat.o(89476);
            return true;
        }
        AppMethodBeat.o(89476);
        return false;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        AppMethodBeat.i(89477);
        boolean z = checkInitialized("isMeasurementExplicitlyDisabled").zzky;
        AppMethodBeat.o(89477);
        return z;
    }

    /* Access modifiers changed, original: final */
    @KeepForSdk
    @VisibleForTesting
    public final Status checkGoogleAppId(String str) {
        AppMethodBeat.i(89473);
        Status status;
        if (this.zzkv == null || this.zzkv.equals(str)) {
            status = Status.RESULT_SUCCESS;
            AppMethodBeat.o(89473);
            return status;
        }
        String str2 = this.zzkv;
        status = new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
        AppMethodBeat.o(89473);
        return status;
    }
}
