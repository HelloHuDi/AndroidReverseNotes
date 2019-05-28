package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.internal.measurement.zzgl;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppMeasurementContentProvider extends ContentProvider {
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        AppMethodBeat.m2504i(77160);
        super.attachInfo(context, providerInfo);
        if ("com.google.android.gms.measurement.google_measurement_service".equals(providerInfo.authority)) {
            IllegalStateException illegalStateException = new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
            AppMethodBeat.m2505o(77160);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(77160);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.m2504i(77159);
        zzgl.zzg(getContext());
        AppMethodBeat.m2505o(77159);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
