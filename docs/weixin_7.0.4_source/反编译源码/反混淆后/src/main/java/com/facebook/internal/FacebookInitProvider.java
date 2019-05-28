package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FacebookInitProvider extends ContentProvider {
    private static final String TAG = FacebookInitProvider.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(72280);
        AppMethodBeat.m2505o(72280);
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(72279);
        try {
            FacebookSdk.sdkInitialize(getContext());
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(72279);
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
