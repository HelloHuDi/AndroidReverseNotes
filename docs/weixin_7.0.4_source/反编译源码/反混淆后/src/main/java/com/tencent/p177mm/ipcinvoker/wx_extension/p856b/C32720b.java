package com.tencent.p177mm.ipcinvoker.wx_extension.p856b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.b.b */
public final class C32720b {
    private final List<C9559b<C32719a>> eGN;
    private final List<Object> eGO;

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.b.b$a */
    public static final class C9558a {
        private static C32720b eGP = new C32720b();

        static {
            AppMethodBeat.m2504i(126212);
            AppMethodBeat.m2505o(126212);
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.b.b$b */
    static class C9559b<T> extends WeakReference<T> {
        public C9559b(T t) {
            super(t);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(126213);
            if (obj == this) {
                AppMethodBeat.m2505o(126213);
                return true;
            } else if (obj instanceof C9559b) {
                Object obj2 = ((C9559b) obj).get();
                Object obj3 = get();
                if (obj2 == obj3 || (obj3 != null && obj3.equals(obj2))) {
                    AppMethodBeat.m2505o(126213);
                    return true;
                }
                AppMethodBeat.m2505o(126213);
                return false;
            } else {
                AppMethodBeat.m2505o(126213);
                return false;
            }
        }
    }

    /* synthetic */ C32720b(byte b) {
        this();
    }

    private C32720b() {
        AppMethodBeat.m2504i(126214);
        this.eGN = new LinkedList();
        this.eGO = new LinkedList();
        AppMethodBeat.m2505o(126214);
    }

    /* renamed from: a */
    public final boolean mo53237a(C32719a c32719a) {
        AppMethodBeat.m2504i(126215);
        if (mo53239c(c32719a)) {
            AppMethodBeat.m2505o(126215);
            return false;
        }
        synchronized (this.eGN) {
            try {
                this.eGN.add(new C9559b(c32719a));
                m53389PX();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(126215);
            }
        }
        return true;
    }

    /* renamed from: b */
    public final boolean mo53238b(C32719a c32719a) {
        AppMethodBeat.m2504i(126216);
        if (c32719a == null) {
            AppMethodBeat.m2505o(126216);
            return false;
        }
        boolean remove;
        synchronized (this.eGN) {
            try {
                remove = this.eGN.remove(new C9559b(c32719a));
                m53390PY();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(126216);
            }
        }
        return remove;
    }

    /* renamed from: c */
    public final boolean mo53239c(C32719a c32719a) {
        AppMethodBeat.m2504i(126217);
        if (c32719a == null) {
            AppMethodBeat.m2505o(126217);
            return false;
        }
        synchronized (this.eGN) {
            try {
                for (C9559b c9559b : this.eGN) {
                    if (c9559b != null) {
                        C32719a c32719a2 = (C32719a) c9559b.get();
                        if (c32719a2 != null && c32719a.equals(c32719a2)) {
                        }
                    }
                }
                AppMethodBeat.m2505o(126217);
                return false;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(126217);
            }
        }
        return true;
    }

    public final int size() {
        int size;
        AppMethodBeat.m2504i(126218);
        synchronized (this.eGN) {
            try {
                size = this.eGN.size();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(126218);
            }
        }
        return size;
    }

    /* renamed from: PX */
    private synchronized void m53389PX() {
        AppMethodBeat.m2504i(126219);
        Iterator it = this.eGO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(126219);
    }

    /* renamed from: PY */
    private synchronized void m53390PY() {
        AppMethodBeat.m2504i(126220);
        Iterator it = this.eGO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(126220);
    }
}
