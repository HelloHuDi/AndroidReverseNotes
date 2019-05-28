package com.tencent.p177mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.n */
public final class C29849n {
    private final LinkedList<String> upF = new LinkedList();

    public C29849n() {
        AppMethodBeat.m2504i(7036);
        AppMethodBeat.m2505o(7036);
    }

    /* renamed from: wy */
    public final void mo48062wy(String str) {
        AppMethodBeat.m2504i(7037);
        try {
            aeV(str);
            AppMethodBeat.m2505o(7037);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewURLRouteList", "add exp = %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(7037);
        }
    }

    private void aeV(String str) {
        AppMethodBeat.m2504i(7038);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(7038);
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
                AppMethodBeat.m2505o(7038);
            }
        }
    }

    public final String[] cYO() {
        String[] strArr;
        AppMethodBeat.m2504i(7039);
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
                AppMethodBeat.m2505o(7039);
            }
        }
        return strArr;
    }

    public final void cYP() {
        AppMethodBeat.m2504i(7040);
        if (C4872b.dnO()) {
            StringBuilder stringBuilder = new StringBuilder("routeList: ");
            synchronized (this.upF) {
                try {
                    Iterator it = this.upF.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append(URLDecoder.decode((String) it.next())).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                } finally {
                    AppMethodBeat.m2505o(7040);
                }
            }
            C4990ab.m7410d("MicroMsg.WebViewURLRouteList", stringBuilder.toString());
            return;
        }
        AppMethodBeat.m2505o(7040);
    }
}
