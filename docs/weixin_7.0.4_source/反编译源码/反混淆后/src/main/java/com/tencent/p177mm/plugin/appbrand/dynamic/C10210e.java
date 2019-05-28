package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.e */
public class C10210e {
    private static volatile C10210e hly;
    public Map<String, WeakReference<View>> hlz = new ConcurrentHashMap();

    private C10210e() {
        AppMethodBeat.m2504i(10678);
        AppMethodBeat.m2505o(10678);
    }

    public static C10210e azz() {
        AppMethodBeat.m2504i(10679);
        if (hly == null) {
            synchronized (C10210e.class) {
                try {
                    if (hly == null) {
                        hly = new C10210e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10679);
                    }
                }
            }
        }
        C10210e c10210e = hly;
        AppMethodBeat.m2505o(10679);
        return c10210e;
    }

    /* renamed from: b */
    public final boolean mo21626b(String str, View view) {
        AppMethodBeat.m2504i(10680);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
            AppMethodBeat.m2505o(10680);
            return false;
        } else if (view == null) {
            C4990ab.m7420w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
            AppMethodBeat.m2505o(10680);
            return false;
        } else {
            WeakReference weakReference = (WeakReference) this.hlz.put(str, new WeakReference(view));
            if (!(weakReference == null || weakReference.get() == null)) {
                C4990ab.m7417i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", str);
            }
            AppMethodBeat.m2505o(10680);
            return true;
        }
    }

    /* renamed from: zS */
    public final View mo21627zS(String str) {
        AppMethodBeat.m2504i(10681);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
            AppMethodBeat.m2505o(10681);
            return null;
        }
        WeakReference weakReference = (WeakReference) this.hlz.get(str);
        if (weakReference != null) {
            View view = (View) weakReference.get();
            AppMethodBeat.m2505o(10681);
            return view;
        }
        AppMethodBeat.m2505o(10681);
        return null;
    }
}
