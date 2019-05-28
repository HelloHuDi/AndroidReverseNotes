package com.tencent.luggage.p146d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.webview.C37407a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.luggage.d.m */
public class C17820m {
    private static ConcurrentHashMap<Integer, C32186k> bPM = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(90840);
        AppMethodBeat.m2505o(90840);
    }

    private C17820m() {
    }

    /* renamed from: a */
    public static Integer m27870a(Context context, C32186k c32186k) {
        AppMethodBeat.m2504i(90837);
        c32186k.setContext(context);
        for (String str : c32186k.bPF.keySet()) {
            c32186k.bOA.bOJ.remove(str);
        }
        c32186k.bPF.clear();
        c32186k.bPz = null;
        c32186k.bPC = null;
        c32186k.bPB = true;
        bPM.put(Integer.valueOf(c32186k.hashCode()), c32186k);
        C45124d.m82930i(C17820m.class.getSimpleName(), "stash, holding size: %d", Integer.valueOf(bPM.size()));
        Integer valueOf = Integer.valueOf(c32186k.hashCode());
        AppMethodBeat.m2505o(90837);
        return valueOf;
    }

    /* renamed from: a */
    public static C32186k m27869a(Context context, Integer num) {
        AppMethodBeat.m2504i(90838);
        if (num == null || !bPM.containsKey(num)) {
            AppMethodBeat.m2505o(90838);
            return null;
        }
        C32186k c32186k = (C32186k) bPM.remove(num);
        c32186k.setContext(context);
        c32186k.mo52834xq();
        C45124d.m82930i(C17820m.class.getSimpleName(), "retrieve, holding size: %d", Integer.valueOf(bPM.size()));
        AppMethodBeat.m2505o(90838);
        return c32186k;
    }

    /* renamed from: b */
    public static C32186k m27872b(Integer num) {
        AppMethodBeat.m2504i(90839);
        if (num == null || !bPM.containsKey(num)) {
            AppMethodBeat.m2505o(90839);
            return null;
        }
        C32186k c32186k = (C32186k) bPM.remove(num);
        c32186k.mo52834xq();
        AppMethodBeat.m2505o(90839);
        return c32186k;
    }

    /* renamed from: a */
    public static Integer m27871a(Context context, Class<? extends C37407a> cls) {
        AppMethodBeat.m2504i(90836);
        C32186k c32186k = new C32186k(context, cls);
        if (!TextUtils.isEmpty(null)) {
            c32186k.loadUrl(null);
        }
        bPM.put(Integer.valueOf(c32186k.hashCode()), c32186k);
        C45124d.m82930i(C17820m.class.getSimpleName(), "preload, url: %s, holding size: %d", null, Integer.valueOf(bPM.size()));
        Integer valueOf = Integer.valueOf(c32186k.hashCode());
        AppMethodBeat.m2505o(90836);
        return valueOf;
    }
}
