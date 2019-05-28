package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    private static LinkedList<WeakReference<a>> zOe = new LinkedList();

    public interface a {
        boolean forceRemoveNoMatchOnPath();

        void onSettle(boolean z, int i);

        void onSwipe(float f);
    }

    static {
        AppMethodBeat.i(107977);
        AppMethodBeat.o(107977);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(107973);
        ab.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", Integer.valueOf(zOe.size()), aVar);
        zOe.add(0, new WeakReference(aVar));
        AppMethodBeat.o(107973);
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(107974);
        ab.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", Integer.valueOf(zOe.size()), aVar);
        if (aVar == null) {
            AppMethodBeat.o(107974);
            return true;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < zOe.size(); i++) {
            if (aVar == ((WeakReference) zOe.get(i)).get()) {
                zOe.remove(i);
                ab.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", Integer.valueOf(i));
                break;
            }
            linkedList.add(0, Integer.valueOf(i));
        }
        if (aVar.forceRemoveNoMatchOnPath() || linkedList.size() != r4) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) zOe.remove(((Integer) it.next()).intValue());
                String str = "MicroMsg.SwipeBackHelper";
                String str2 = "popCallback, popup %s";
                Object[] objArr = new Object[1];
                objArr[0] = weakReference != null ? weakReference.get() : "NULL-CALLBACK";
                ab.d(str, str2, objArr);
            }
            boolean isEmpty = linkedList.isEmpty();
            AppMethodBeat.o(107974);
            return isEmpty;
        }
        ab.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        AppMethodBeat.o(107974);
        return false;
    }

    public static void bq(float f) {
        AppMethodBeat.i(107975);
        if (zOe.size() <= 0) {
            ab.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", Float.valueOf(f));
            AppMethodBeat.o(107975);
            return;
        }
        a aVar = (a) ((WeakReference) zOe.get(0)).get();
        if (aVar == null) {
            ab.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", Float.valueOf(f));
            AppMethodBeat.o(107975);
            return;
        }
        aVar.onSwipe(f);
        ab.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", Float.valueOf(f), aVar);
        AppMethodBeat.o(107975);
    }

    public static void J(boolean z, int i) {
        AppMethodBeat.i(107976);
        if (zOe.size() <= 0) {
            ab.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            AppMethodBeat.o(107976);
            return;
        }
        a aVar = (a) ((WeakReference) zOe.get(0)).get();
        if (aVar == null) {
            ab.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            AppMethodBeat.o(107976);
            return;
        }
        aVar.onSettle(z, i);
        ab.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(i), aVar);
        AppMethodBeat.o(107976);
    }
}
