package com.tencent.p177mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C45323fm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderAccountSync */
public class ExtControlProviderAccountSync extends ExtContentProviderBase {
    private static final UriMatcher lQc;

    static {
        AppMethodBeat.m2504i(20342);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
        AppMethodBeat.m2505o(20342);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(20341);
        C4990ab.m7410d("MicroMsg.ExtControlAccountSyncProvider", "query()");
        mo61884a(uri, getContext(), lQc);
        if (uri == null) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20341);
            return null;
        } else if (C5046bo.isNullOrNil(this.lPW) || C5046bo.isNullOrNil(brL())) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20341);
            return null;
        } else if (!aVl()) {
            mo61890vf(1);
            Cursor cursor = this.jDN;
            AppMethodBeat.m2505o(20341);
            return cursor;
        } else if (mo61888dJ(getContext())) {
            switch (lQc.match(uri)) {
                case 1:
                    C4990ab.m7416i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
                    if (C4879a.xxA.mo10055m(new C45323fm())) {
                        mo61890vf(0);
                    } else {
                        C4990ab.m7412e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
                        mo61890vf(4);
                    }
                    AppMethodBeat.m2505o(20341);
                    return null;
                default:
                    mo61890vf(3);
                    AppMethodBeat.m2505o(20341);
                    return null;
            }
        } else {
            C4990ab.m7420w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
            mo61890vf(2);
            AppMethodBeat.m2505o(20341);
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
