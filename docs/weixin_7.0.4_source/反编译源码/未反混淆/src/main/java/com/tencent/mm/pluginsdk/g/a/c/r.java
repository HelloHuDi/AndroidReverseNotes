package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class r {
    private static final HashMap<Integer, g> vfB;
    private static volatile List<g> vfC = null;

    static {
        AppMethodBeat.i(79626);
        HashMap hashMap = new HashMap(2);
        vfB = hashMap;
        hashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new a());
        try {
            vfB.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (g) Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ResDownloaderPluginMap", e, "", new Object[0]);
        }
        AppMethodBeat.o(79626);
    }

    public static void init() {
    }

    public static Collection<g> diz() {
        AppMethodBeat.i(79625);
        if (vfC != null) {
            List list = vfC;
            AppMethodBeat.o(79625);
            return list;
        }
        LinkedList linkedList = new LinkedList();
        for (Integer intValue : vfB.keySet()) {
            g gVar = (g) vfB.get(Integer.valueOf(intValue.intValue()));
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        vfC = linkedList;
        AppMethodBeat.o(79625);
        return linkedList;
    }
}
