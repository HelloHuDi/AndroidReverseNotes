package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzb {
    private SharedPreferences zzs;

    public zzb(Context context) {
        AppMethodBeat.i(115340);
        try {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            this.zzs = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
            AppMethodBeat.o(115340);
        } catch (Throwable th) {
            this.zzs = null;
            AppMethodBeat.o(115340);
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(115341);
        try {
            if (this.zzs == null) {
                AppMethodBeat.o(115341);
            } else {
                z2 = this.zzs.getBoolean(str, false);
                AppMethodBeat.o(115341);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(115341);
        }
        return z2;
    }

    /* Access modifiers changed, original: final */
    public final float getFloat(String str, float f) {
        float f2 = 0.0f;
        AppMethodBeat.i(115342);
        try {
            if (this.zzs == null) {
                AppMethodBeat.o(115342);
            } else {
                f2 = this.zzs.getFloat(str, 0.0f);
                AppMethodBeat.o(115342);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(115342);
        }
        return f2;
    }

    /* Access modifiers changed, original: final */
    public final String getString(String str, String str2) {
        AppMethodBeat.i(115343);
        try {
            if (this.zzs == null) {
                AppMethodBeat.o(115343);
            } else {
                str2 = this.zzs.getString(str, str2);
                AppMethodBeat.o(115343);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(115343);
        }
        return str2;
    }
}
