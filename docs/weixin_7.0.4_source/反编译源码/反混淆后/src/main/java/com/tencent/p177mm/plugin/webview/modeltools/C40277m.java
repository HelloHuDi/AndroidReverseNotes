package com.tencent.p177mm.plugin.webview.modeltools;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.m */
public final class C40277m extends C7563j<C16930i> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C16930i.ccO, "WebViewHostsFilter")};
    private final C4927e bSd;

    static {
        AppMethodBeat.m2504i(7035);
        AppMethodBeat.m2505o(7035);
    }

    public C40277m(C4927e c4927e) {
        this(c4927e, C16930i.ccO, "WebViewHostsFilter");
    }

    private C40277m(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        this.bSd = c4927e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Set<String> cYN() {
        AppMethodBeat.m2504i(7034);
        long anT = C5046bo.anT();
        C4990ab.m7410d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = ".concat(String.valueOf(anT)));
        boolean hY = mo16768hY("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < ".concat(String.valueOf(anT)));
        C4990ab.m7417i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", Boolean.valueOf(hY));
        Cursor a = this.bSd.mo10105a(getTableName(), new String[]{"host"}, null, null, null, null, null, 2);
        HashSet hashSet = new HashSet();
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(7034);
            return hashSet;
        }
        do {
            String string = a.getString(0);
            if (!C5046bo.isNullOrNil(string)) {
                hashSet.add(string);
                C4990ab.m7410d("MicroMsg.WebViewStorage", "webview hijack gethost = ".concat(String.valueOf(string)));
            }
        } while (a.moveToNext());
        if (a != null) {
        }
        AppMethodBeat.m2505o(7034);
        return hashSet;
    }
}
