package com.tencent.p177mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.base.stub.MMPluginProvider */
public class MMPluginProvider extends ContentProvider {
    private static final UriMatcher jDo;
    private C33715c jDn = new C33715c();

    /* renamed from: com.tencent.mm.plugin.base.stub.MMPluginProvider$a */
    protected static abstract class C11158a {
        private Context context = null;

        protected C11158a() {
        }

        /* renamed from: dt */
        public boolean mo22856dt(Context context) {
            this.context = context;
            return true;
        }
    }

    public MMPluginProvider() {
        AppMethodBeat.m2504i(18111);
        AppMethodBeat.m2505o(18111);
    }

    static {
        AppMethodBeat.m2504i(18118);
        UriMatcher uriMatcher = new UriMatcher(-1);
        jDo = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
        AppMethodBeat.m2505o(18118);
    }

    public String getType(Uri uri) {
        AppMethodBeat.m2504i(18112);
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.m2505o(18112);
                break;
            default:
                AppMethodBeat.m2505o(18112);
                break;
        }
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.m2504i(18113);
        C4990ab.m7416i("MicroMsg.MMPluginProvider", "onCreate");
        this.jDn.mo22856dt(getContext());
        AppMethodBeat.m2505o(18113);
        return true;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.m2504i(18114);
        C4990ab.m7418v("MicroMsg.MMPluginProvider", "plugin insert".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.m2505o(18114);
                break;
            default:
                C4990ab.m7412e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.m2505o(18114);
                break;
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.m2504i(18115);
        C4990ab.m7418v("MicroMsg.MMPluginProvider", "plugin delete".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.m2505o(18115);
                break;
            default:
                C4990ab.m7412e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.m2505o(18115);
                break;
        }
        return 0;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(18116);
        C4990ab.m7416i("MicroMsg.MMPluginProvider", "plugin query".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                Cursor a = C33715c.m55096a(strArr, strArr2);
                AppMethodBeat.m2505o(18116);
                return a;
            default:
                C4990ab.m7412e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.m2505o(18116);
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.m2504i(18117);
        C4990ab.m7410d("MicroMsg.MMPluginProvider", "plugin update".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.m2505o(18117);
                break;
            default:
                C4990ab.m7412e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.m2505o(18117);
                break;
        }
        return 0;
    }
}
