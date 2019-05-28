package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c {
    public static final boolean zzP;
    @SuppressLint({"StaticFieldLeak"})
    private static final c zzT = new c() {
        public final void a(a aVar) {
        }
    };
    private static final WeakHashMap<Activity, c> zzU = new WeakHashMap();
    private final WeakReference<Activity> mActivityRef;
    private final Set<WeakReference<a>> zzQ;
    private boolean zzR;
    int zzS;

    public interface a {
        void pO(int i);
    }

    /* synthetic */ c() {
        this(null);
    }

    static {
        boolean z;
        AppMethodBeat.i(67849);
        if (VERSION.SDK_INT < 21 || com.tencent.mm.sdk.h.c.dqy()) {
            z = false;
        } else {
            z = true;
        }
        zzP = z;
        AppMethodBeat.o(67849);
    }

    private c(Activity activity) {
        AppMethodBeat.i(67845);
        this.zzQ = new HashSet();
        this.zzR = false;
        this.zzS = 0;
        this.mActivityRef = new WeakReference(activity);
        AppMethodBeat.o(67845);
    }

    public static c az(Activity activity) {
        AppMethodBeat.i(67847);
        c cVar;
        if (!zzP || activity == null) {
            cVar = zzT;
            AppMethodBeat.o(67847);
            return cVar;
        }
        cVar = (c) zzU.get(activity);
        if (cVar == null) {
            cVar = new c(activity);
            zzU.put(activity, cVar);
        }
        AppMethodBeat.o(67847);
        return cVar;
    }

    public void a(a aVar) {
        AppMethodBeat.i(67846);
        if (!this.zzR) {
            this.zzR = true;
            Activity activity = (Activity) this.mActivityRef.get();
            if (!(activity == null || activity.getWindow() == null)) {
                try {
                    View view = (ViewGroup) activity.getWindow().getDecorView();
                    if (view.getChildCount() == 1) {
                        view = view.getChildAt(0);
                    }
                    view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            AppMethodBeat.i(67844);
                            c.b(c.this, c.this.zzS = windowInsets.getSystemWindowInsetTop());
                            WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
                            AppMethodBeat.o(67844);
                            return consumeSystemWindowInsets;
                        }
                    });
                    view.requestApplyInsets();
                } catch (Exception e) {
                    ab.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", e);
                }
            }
        }
        this.zzQ.add(new WeakReference(aVar));
        if (this.zzS > 0) {
            aVar.pO(this.zzS);
        }
        AppMethodBeat.o(67846);
    }

    static /* synthetic */ void b(c cVar, int i) {
        AppMethodBeat.i(67848);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(cVar.zzQ);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.pO(i);
            } else {
                cVar.zzQ.remove(weakReference);
            }
        }
        AppMethodBeat.o(67848);
    }
}
