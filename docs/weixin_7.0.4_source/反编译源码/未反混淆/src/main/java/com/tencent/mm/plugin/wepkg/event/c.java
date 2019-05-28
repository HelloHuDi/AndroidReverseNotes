package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c {
    private static ConcurrentLinkedQueue<WeakReference<a>> uWD = new ConcurrentLinkedQueue();

    public interface a {
        void ckg();
    }

    static class b implements com.tencent.mm.ipcinvoker.a {
        private b() {
        }

        public final void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(63468);
            Iterator it = c.uWD.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((a) weakReference.get()).ct(obj);
                }
            }
            cVar.ao(null);
            AppMethodBeat.o(63468);
        }
    }

    static {
        AppMethodBeat.i(63473);
        AppMethodBeat.o(63473);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(63469);
        uWD.add(new WeakReference(aVar));
        AppMethodBeat.o(63469);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(63470);
        Iterator it = uWD.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == aVar) {
                uWD.remove(weakReference);
            }
        }
        AppMethodBeat.o(63470);
    }

    public static void clear() {
        AppMethodBeat.i(63471);
        uWD.clear();
        AppMethodBeat.o(63471);
    }

    public static <T extends Parcelable> void a(T t, final a aVar) {
        AppMethodBeat.i(63472);
        ToolsProcessIPCService.a(t, b.class, new com.tencent.mm.ipcinvoker.c() {
            public final void ao(Object obj) {
                AppMethodBeat.i(63467);
                if (aVar != null) {
                    aVar.ckg();
                }
                AppMethodBeat.o(63467);
            }
        });
        AppMethodBeat.o(63472);
    }
}
