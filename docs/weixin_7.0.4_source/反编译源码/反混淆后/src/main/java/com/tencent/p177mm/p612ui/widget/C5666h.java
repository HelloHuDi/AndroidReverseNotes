package com.tencent.p177mm.p612ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.widget.h */
public final class C5666h {
    private static LinkedList<WeakReference<C5665a>> zOe = new LinkedList();

    /* renamed from: com.tencent.mm.ui.widget.h$a */
    public interface C5665a {
        boolean forceRemoveNoMatchOnPath();

        void onSettle(boolean z, int i);

        void onSwipe(float f);
    }

    static {
        AppMethodBeat.m2504i(107977);
        AppMethodBeat.m2505o(107977);
    }

    /* renamed from: a */
    public static void m8512a(C5665a c5665a) {
        AppMethodBeat.m2504i(107973);
        C4990ab.m7411d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", Integer.valueOf(zOe.size()), c5665a);
        zOe.add(0, new WeakReference(c5665a));
        AppMethodBeat.m2505o(107973);
    }

    /* renamed from: b */
    public static boolean m8513b(C5665a c5665a) {
        AppMethodBeat.m2504i(107974);
        C4990ab.m7411d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", Integer.valueOf(zOe.size()), c5665a);
        if (c5665a == null) {
            AppMethodBeat.m2505o(107974);
            return true;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < zOe.size(); i++) {
            if (c5665a == ((WeakReference) zOe.get(i)).get()) {
                zOe.remove(i);
                C4990ab.m7411d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", Integer.valueOf(i));
                break;
            }
            linkedList.add(0, Integer.valueOf(i));
        }
        if (c5665a.forceRemoveNoMatchOnPath() || linkedList.size() != r4) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) zOe.remove(((Integer) it.next()).intValue());
                String str = "MicroMsg.SwipeBackHelper";
                String str2 = "popCallback, popup %s";
                Object[] objArr = new Object[1];
                objArr[0] = weakReference != null ? weakReference.get() : "NULL-CALLBACK";
                C4990ab.m7411d(str, str2, objArr);
            }
            boolean isEmpty = linkedList.isEmpty();
            AppMethodBeat.m2505o(107974);
            return isEmpty;
        }
        C4990ab.m7410d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        AppMethodBeat.m2505o(107974);
        return false;
    }

    /* renamed from: bq */
    public static void m8514bq(float f) {
        AppMethodBeat.m2504i(107975);
        if (zOe.size() <= 0) {
            C4990ab.m7421w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", Float.valueOf(f));
            AppMethodBeat.m2505o(107975);
            return;
        }
        C5665a c5665a = (C5665a) ((WeakReference) zOe.get(0)).get();
        if (c5665a == null) {
            C4990ab.m7421w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", Float.valueOf(f));
            AppMethodBeat.m2505o(107975);
            return;
        }
        c5665a.onSwipe(f);
        C4990ab.m7419v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", Float.valueOf(f), c5665a);
        AppMethodBeat.m2505o(107975);
    }

    /* renamed from: J */
    public static void m8511J(boolean z, int i) {
        AppMethodBeat.m2504i(107976);
        if (zOe.size() <= 0) {
            C4990ab.m7421w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            AppMethodBeat.m2505o(107976);
            return;
        }
        C5665a c5665a = (C5665a) ((WeakReference) zOe.get(0)).get();
        if (c5665a == null) {
            C4990ab.m7421w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            AppMethodBeat.m2505o(107976);
            return;
        }
        c5665a.onSettle(z, i);
        C4990ab.m7419v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(i), c5665a);
        AppMethodBeat.m2505o(107976);
    }
}
