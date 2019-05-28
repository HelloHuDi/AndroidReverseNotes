package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14849a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.tencent.mm.pluginsdk.g.a.c.r */
public final class C46489r {
    private static final HashMap<Integer, C4721g> vfB;
    private static volatile List<C4721g> vfC = null;

    static {
        AppMethodBeat.m2504i(79626);
        HashMap hashMap = new HashMap(2);
        vfB = hashMap;
        hashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new C14849a());
        try {
            vfB.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (C4721g) Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderPluginMap", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(79626);
    }

    public static void init() {
    }

    public static Collection<C4721g> diz() {
        AppMethodBeat.m2504i(79625);
        if (vfC != null) {
            List list = vfC;
            AppMethodBeat.m2505o(79625);
            return list;
        }
        LinkedList linkedList = new LinkedList();
        for (Integer intValue : vfB.keySet()) {
            C4721g c4721g = (C4721g) vfB.get(Integer.valueOf(intValue.intValue()));
            if (c4721g != null) {
                linkedList.add(c4721g);
            }
        }
        vfC = linkedList;
        AppMethodBeat.m2505o(79625);
        return linkedList;
    }
}
