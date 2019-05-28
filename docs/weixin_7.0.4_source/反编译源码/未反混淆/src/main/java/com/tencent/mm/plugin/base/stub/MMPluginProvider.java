package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class MMPluginProvider extends ContentProvider {
    private static final UriMatcher jDo;
    private c jDn = new c();

    protected static abstract class a {
        private Context context = null;

        protected a() {
        }

        public boolean dt(Context context) {
            this.context = context;
            return true;
        }
    }

    public MMPluginProvider() {
        AppMethodBeat.i(18111);
        AppMethodBeat.o(18111);
    }

    static {
        AppMethodBeat.i(18118);
        UriMatcher uriMatcher = new UriMatcher(-1);
        jDo = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
        AppMethodBeat.o(18118);
    }

    public String getType(Uri uri) {
        AppMethodBeat.i(18112);
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.o(18112);
                break;
            default:
                AppMethodBeat.o(18112);
                break;
        }
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.i(18113);
        ab.i("MicroMsg.MMPluginProvider", "onCreate");
        this.jDn.dt(getContext());
        AppMethodBeat.o(18113);
        return true;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(18114);
        ab.v("MicroMsg.MMPluginProvider", "plugin insert".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.o(18114);
                break;
            default:
                ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(18114);
                break;
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(18115);
        ab.v("MicroMsg.MMPluginProvider", "plugin delete".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.o(18115);
                break;
            default:
                ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(18115);
                break;
        }
        return 0;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(18116);
        ab.i("MicroMsg.MMPluginProvider", "plugin query".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                Cursor a = c.a(strArr, strArr2);
                AppMethodBeat.o(18116);
                return a;
            default:
                ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(18116);
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(18117);
        ab.d("MicroMsg.MMPluginProvider", "plugin update".concat(String.valueOf(uri)));
        switch (jDo.match(uri)) {
            case 2:
                AppMethodBeat.o(18117);
                break;
            default:
                ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(18117);
                break;
        }
        return 0;
    }
}
