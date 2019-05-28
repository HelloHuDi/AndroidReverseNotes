package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class n {
    private final LinkedList<String> upF = new LinkedList();

    public n() {
        AppMethodBeat.i(7036);
        AppMethodBeat.o(7036);
    }

    public final void wy(String str) {
        AppMethodBeat.i(7037);
        try {
            aeV(str);
            AppMethodBeat.o(7037);
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewURLRouteList", "add exp = %s", bo.l(e));
            AppMethodBeat.o(7037);
        }
    }

    private void aeV(String str) {
        AppMethodBeat.i(7038);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(7038);
            return;
        }
        synchronized (this.upF) {
            try {
                String str2 = (String) this.upF.peekLast();
                String encode = URLEncoder.encode(str);
                if (str2 == null || !str2.equals(encode)) {
                    this.upF.addLast(encode);
                }
                if (this.upF.size() > 10) {
                    this.upF.removeFirst();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(7038);
            }
        }
    }

    public final String[] cYO() {
        String[] strArr;
        AppMethodBeat.i(7039);
        synchronized (this.upF) {
            try {
                strArr = new String[this.upF.size()];
                Iterator it = this.upF.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    strArr[i] = (String) it.next();
                    i = i2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(7039);
            }
        }
        return strArr;
    }

    public final void cYP() {
        AppMethodBeat.i(7040);
        if (b.dnO()) {
            StringBuilder stringBuilder = new StringBuilder("routeList: ");
            synchronized (this.upF) {
                try {
                    Iterator it = this.upF.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append(URLDecoder.decode((String) it.next())).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                } finally {
                    AppMethodBeat.o(7040);
                }
            }
            ab.d("MicroMsg.WebViewURLRouteList", stringBuilder.toString());
            return;
        }
        AppMethodBeat.o(7040);
    }
}
