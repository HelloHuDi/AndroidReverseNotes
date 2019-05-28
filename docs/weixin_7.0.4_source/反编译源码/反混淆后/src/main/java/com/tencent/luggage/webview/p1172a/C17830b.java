package com.tencent.luggage.webview.p1172a;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

/* renamed from: com.tencent.luggage.webview.a.b */
public final class C17830b {
    private final LinkedList<Pair<C17831c, Pattern>> bRO = new LinkedList();

    public C17830b() {
        AppMethodBeat.m2504i(90944);
        AppMethodBeat.m2505o(90944);
    }

    /* renamed from: a */
    public final void mo33005a(C17831c c17831c) {
        Object obj;
        AppMethodBeat.m2504i(90945);
        String yk = c17831c.mo23954yk();
        if (TextUtils.isEmpty(yk)) {
            obj = null;
        } else {
            obj = Pattern.compile(yk);
        }
        this.bRO.add(new Pair(c17831c, obj));
        AppMethodBeat.m2505o(90945);
    }

    /* renamed from: bR */
    public final WebResourceResponse mo33006bR(String str) {
        AppMethodBeat.m2504i(90946);
        Iterator it = this.bRO.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            C17831c c17831c = (C17831c) pair.first;
            Pattern pattern = (Pattern) pair.second;
            if (pattern != null && pattern.matcher(str).matches()) {
                WebResourceResponse bG = c17831c.mo23953bG(str);
                if (bG != null) {
                    AppMethodBeat.m2505o(90946);
                    return bG;
                }
            }
        }
        AppMethodBeat.m2505o(90946);
        return null;
    }
}
