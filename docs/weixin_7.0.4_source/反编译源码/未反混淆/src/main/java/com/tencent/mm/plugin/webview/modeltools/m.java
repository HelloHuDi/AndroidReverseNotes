package com.tencent.mm.plugin.webview.modeltools;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public final class m extends j<i> {
    public static final String[] fnj = new String[]{j.a(i.ccO, "WebViewHostsFilter")};
    private final e bSd;

    static {
        AppMethodBeat.i(7035);
        AppMethodBeat.o(7035);
    }

    public m(e eVar) {
        this(eVar, i.ccO, "WebViewHostsFilter");
    }

    private m(e eVar, a aVar, String str) {
        super(eVar, aVar, str, null);
        this.bSd = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Set<String> cYN() {
        AppMethodBeat.i(7034);
        long anT = bo.anT();
        ab.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = ".concat(String.valueOf(anT)));
        boolean hY = hY("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < ".concat(String.valueOf(anT)));
        ab.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", Boolean.valueOf(hY));
        Cursor a = this.bSd.a(getTableName(), new String[]{"host"}, null, null, null, null, null, 2);
        HashSet hashSet = new HashSet();
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(7034);
            return hashSet;
        }
        do {
            String string = a.getString(0);
            if (!bo.isNullOrNil(string)) {
                hashSet.add(string);
                ab.d("MicroMsg.WebViewStorage", "webview hijack gethost = ".concat(String.valueOf(string)));
            }
        } while (a.moveToNext());
        if (a != null) {
        }
        AppMethodBeat.o(7034);
        return hashSet;
    }
}
