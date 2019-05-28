package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e hly;
    public Map<String, WeakReference<View>> hlz = new ConcurrentHashMap();

    private e() {
        AppMethodBeat.i(10678);
        AppMethodBeat.o(10678);
    }

    public static e azz() {
        AppMethodBeat.i(10679);
        if (hly == null) {
            synchronized (e.class) {
                try {
                    if (hly == null) {
                        hly = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10679);
                    }
                }
            }
        }
        e eVar = hly;
        AppMethodBeat.o(10679);
        return eVar;
    }

    public final boolean b(String str, View view) {
        AppMethodBeat.i(10680);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
            AppMethodBeat.o(10680);
            return false;
        } else if (view == null) {
            ab.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
            AppMethodBeat.o(10680);
            return false;
        } else {
            WeakReference weakReference = (WeakReference) this.hlz.put(str, new WeakReference(view));
            if (!(weakReference == null || weakReference.get() == null)) {
                ab.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", str);
            }
            AppMethodBeat.o(10680);
            return true;
        }
    }

    public final View zS(String str) {
        AppMethodBeat.i(10681);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
            AppMethodBeat.o(10681);
            return null;
        }
        WeakReference weakReference = (WeakReference) this.hlz.get(str);
        if (weakReference != null) {
            View view = (View) weakReference.get();
            AppMethodBeat.o(10681);
            return view;
        }
        AppMethodBeat.o(10681);
        return null;
    }
}
