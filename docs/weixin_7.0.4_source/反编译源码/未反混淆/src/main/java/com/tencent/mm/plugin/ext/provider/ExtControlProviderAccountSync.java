package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync extends ExtContentProviderBase {
    private static final UriMatcher lQc;

    static {
        AppMethodBeat.i(20342);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
        AppMethodBeat.o(20342);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(20341);
        ab.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
        a(uri, getContext(), lQc);
        if (uri == null) {
            vf(3);
            AppMethodBeat.o(20341);
            return null;
        } else if (bo.isNullOrNil(this.lPW) || bo.isNullOrNil(brL())) {
            vf(3);
            AppMethodBeat.o(20341);
            return null;
        } else if (!aVl()) {
            vf(1);
            Cursor cursor = this.jDN;
            AppMethodBeat.o(20341);
            return cursor;
        } else if (dJ(getContext())) {
            switch (lQc.match(uri)) {
                case 1:
                    ab.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
                    if (a.xxA.m(new fm())) {
                        vf(0);
                    } else {
                        ab.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
                        vf(4);
                    }
                    AppMethodBeat.o(20341);
                    return null;
                default:
                    vf(3);
                    AppMethodBeat.o(20341);
                    return null;
            }
        } else {
            ab.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
            vf(2);
            AppMethodBeat.o(20341);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
