package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.C41642a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FirebaseInitProvider extends ContentProvider {
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        AppMethodBeat.m2504i(10637);
        Preconditions.checkNotNull(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if ("com.google.firebase.firebaseinitprovider".equals(providerInfo.authority)) {
            IllegalStateException illegalStateException = new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
            AppMethodBeat.m2505o(10637);
            throw illegalStateException;
        }
        super.attachInfo(context, providerInfo);
        AppMethodBeat.m2505o(10637);
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
        AppMethodBeat.m2504i(10638);
        C41642a.m73005ak(getContext());
        AppMethodBeat.m2505o(10638);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
