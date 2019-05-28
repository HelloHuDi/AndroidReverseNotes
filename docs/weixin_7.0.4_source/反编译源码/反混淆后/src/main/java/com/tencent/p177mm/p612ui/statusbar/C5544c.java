package com.tencent.p177mm.p612ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p609h.C4972c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.tencent.mm.ui.statusbar.c */
public class C5544c {
    public static final boolean zzP;
    @SuppressLint({"StaticFieldLeak"})
    private static final C5544c zzT = new C55452();
    private static final WeakHashMap<Activity, C5544c> zzU = new WeakHashMap();
    private final WeakReference<Activity> mActivityRef;
    private final Set<WeakReference<C5543a>> zzQ;
    private boolean zzR;
    int zzS;

    /* renamed from: com.tencent.mm.ui.statusbar.c$1 */
    class C55421 implements OnApplyWindowInsetsListener {
        C55421() {
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            AppMethodBeat.m2504i(67844);
            C5544c.m8365b(C5544c.this, C5544c.this.zzS = windowInsets.getSystemWindowInsetTop());
            WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
            AppMethodBeat.m2505o(67844);
            return consumeSystemWindowInsets;
        }
    }

    /* renamed from: com.tencent.mm.ui.statusbar.c$a */
    public interface C5543a {
        /* renamed from: pO */
        void mo11252pO(int i);
    }

    /* renamed from: com.tencent.mm.ui.statusbar.c$2 */
    static class C55452 extends C5544c {
        C55452() {
        }

        /* renamed from: a */
        public final void mo11253a(C5543a c5543a) {
        }
    }

    /* synthetic */ C5544c() {
        this(null);
    }

    static {
        boolean z;
        AppMethodBeat.m2504i(67849);
        if (VERSION.SDK_INT < 21 || C4972c.dqy()) {
            z = false;
        } else {
            z = true;
        }
        zzP = z;
        AppMethodBeat.m2505o(67849);
    }

    private C5544c(Activity activity) {
        AppMethodBeat.m2504i(67845);
        this.zzQ = new HashSet();
        this.zzR = false;
        this.zzS = 0;
        this.mActivityRef = new WeakReference(activity);
        AppMethodBeat.m2505o(67845);
    }

    /* renamed from: az */
    public static C5544c m8364az(Activity activity) {
        AppMethodBeat.m2504i(67847);
        C5544c c5544c;
        if (!zzP || activity == null) {
            c5544c = zzT;
            AppMethodBeat.m2505o(67847);
            return c5544c;
        }
        c5544c = (C5544c) zzU.get(activity);
        if (c5544c == null) {
            c5544c = new C5544c(activity);
            zzU.put(activity, c5544c);
        }
        AppMethodBeat.m2505o(67847);
        return c5544c;
    }

    /* renamed from: a */
    public void mo11253a(C5543a c5543a) {
        AppMethodBeat.m2504i(67846);
        if (!this.zzR) {
            this.zzR = true;
            Activity activity = (Activity) this.mActivityRef.get();
            if (!(activity == null || activity.getWindow() == null)) {
                try {
                    View view = (ViewGroup) activity.getWindow().getDecorView();
                    if (view.getChildCount() == 1) {
                        view = view.getChildAt(0);
                    }
                    view.setOnApplyWindowInsetsListener(new C55421());
                    view.requestApplyInsets();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", e);
                }
            }
        }
        this.zzQ.add(new WeakReference(c5543a));
        if (this.zzS > 0) {
            c5543a.mo11252pO(this.zzS);
        }
        AppMethodBeat.m2505o(67846);
    }

    /* renamed from: b */
    static /* synthetic */ void m8365b(C5544c c5544c, int i) {
        AppMethodBeat.m2504i(67848);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(c5544c.zzQ);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C5543a c5543a = (C5543a) weakReference.get();
            if (c5543a != null) {
                c5543a.mo11252pO(i);
            } else {
                c5544c.zzQ.remove(weakReference);
            }
        }
        AppMethodBeat.m2505o(67848);
    }
}
