package com.tencent.luggage.webview.a;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public final class b {
    private final LinkedList<Pair<c, Pattern>> bRO = new LinkedList();

    public b() {
        AppMethodBeat.i(90944);
        AppMethodBeat.o(90944);
    }

    public final void a(c cVar) {
        Object obj;
        AppMethodBeat.i(90945);
        String yk = cVar.yk();
        if (TextUtils.isEmpty(yk)) {
            obj = null;
        } else {
            obj = Pattern.compile(yk);
        }
        this.bRO.add(new Pair(cVar, obj));
        AppMethodBeat.o(90945);
    }

    public final WebResourceResponse bR(String str) {
        AppMethodBeat.i(90946);
        Iterator it = this.bRO.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c cVar = (c) pair.first;
            Pattern pattern = (Pattern) pair.second;
            if (pattern != null && pattern.matcher(str).matches()) {
                WebResourceResponse bG = cVar.bG(str);
                if (bG != null) {
                    AppMethodBeat.o(90946);
                    return bG;
                }
            }
        }
        AppMethodBeat.o(90946);
        return null;
    }
}
