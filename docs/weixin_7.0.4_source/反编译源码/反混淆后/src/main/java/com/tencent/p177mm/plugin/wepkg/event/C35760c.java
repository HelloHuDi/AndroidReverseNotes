package com.tencent.p177mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.wepkg.event.c */
public final class C35760c {
    private static ConcurrentLinkedQueue<WeakReference<C23201a>> uWD = new ConcurrentLinkedQueue();

    /* renamed from: com.tencent.mm.plugin.wepkg.event.c$a */
    public interface C35758a {
        void ckg();
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.event.c$b */
    static class C35759b implements C37866a {
        private C35759b() {
        }

        /* renamed from: a */
        public final void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(63468);
            Iterator it = C35760c.uWD.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((C23201a) weakReference.get()).mo38823ct(obj);
                }
            }
            c18507c.mo5960ao(null);
            AppMethodBeat.m2505o(63468);
        }
    }

    static {
        AppMethodBeat.m2504i(63473);
        AppMethodBeat.m2505o(63473);
    }

    /* renamed from: a */
    public static void m58626a(C23201a c23201a) {
        AppMethodBeat.m2504i(63469);
        uWD.add(new WeakReference(c23201a));
        AppMethodBeat.m2505o(63469);
    }

    /* renamed from: b */
    public static void m58627b(C23201a c23201a) {
        AppMethodBeat.m2504i(63470);
        Iterator it = uWD.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == c23201a) {
                uWD.remove(weakReference);
            }
        }
        AppMethodBeat.m2505o(63470);
    }

    public static void clear() {
        AppMethodBeat.m2504i(63471);
        uWD.clear();
        AppMethodBeat.m2505o(63471);
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m58625a(T t, final C35758a c35758a) {
        AppMethodBeat.m2504i(63472);
        ToolsProcessIPCService.m63913a(t, C35759b.class, new C18507c() {
            /* renamed from: ao */
            public final void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(63467);
                if (c35758a != null) {
                    c35758a.ckg();
                }
                AppMethodBeat.m2505o(63467);
            }
        });
        AppMethodBeat.m2505o(63472);
    }
}
