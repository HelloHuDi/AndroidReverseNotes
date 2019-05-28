package com.tencent.luggage.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public class m {
    private static ConcurrentHashMap<Integer, k> bPM = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(90840);
        AppMethodBeat.o(90840);
    }

    private m() {
    }

    public static Integer a(Context context, k kVar) {
        AppMethodBeat.i(90837);
        kVar.setContext(context);
        for (String str : kVar.bPF.keySet()) {
            kVar.bOA.bOJ.remove(str);
        }
        kVar.bPF.clear();
        kVar.bPz = null;
        kVar.bPC = null;
        kVar.bPB = true;
        bPM.put(Integer.valueOf(kVar.hashCode()), kVar);
        d.i(m.class.getSimpleName(), "stash, holding size: %d", Integer.valueOf(bPM.size()));
        Integer valueOf = Integer.valueOf(kVar.hashCode());
        AppMethodBeat.o(90837);
        return valueOf;
    }

    public static k a(Context context, Integer num) {
        AppMethodBeat.i(90838);
        if (num == null || !bPM.containsKey(num)) {
            AppMethodBeat.o(90838);
            return null;
        }
        k kVar = (k) bPM.remove(num);
        kVar.setContext(context);
        kVar.xq();
        d.i(m.class.getSimpleName(), "retrieve, holding size: %d", Integer.valueOf(bPM.size()));
        AppMethodBeat.o(90838);
        return kVar;
    }

    public static k b(Integer num) {
        AppMethodBeat.i(90839);
        if (num == null || !bPM.containsKey(num)) {
            AppMethodBeat.o(90839);
            return null;
        }
        k kVar = (k) bPM.remove(num);
        kVar.xq();
        AppMethodBeat.o(90839);
        return kVar;
    }

    public static Integer a(Context context, Class<? extends a> cls) {
        AppMethodBeat.i(90836);
        k kVar = new k(context, cls);
        if (!TextUtils.isEmpty(null)) {
            kVar.loadUrl(null);
        }
        bPM.put(Integer.valueOf(kVar.hashCode()), kVar);
        d.i(m.class.getSimpleName(), "preload, url: %s, holding size: %d", null, Integer.valueOf(bPM.size()));
        Integer valueOf = Integer.valueOf(kVar.hashCode());
        AppMethodBeat.o(90836);
        return valueOf;
    }
}
