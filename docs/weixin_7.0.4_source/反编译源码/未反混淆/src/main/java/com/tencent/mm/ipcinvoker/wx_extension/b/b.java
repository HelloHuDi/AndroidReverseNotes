package com.tencent.mm.ipcinvoker.wx_extension.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private final List<b<a>> eGN;
    private final List<Object> eGO;

    public static final class a {
        private static b eGP = new b();

        static {
            AppMethodBeat.i(126212);
            AppMethodBeat.o(126212);
        }
    }

    static class b<T> extends WeakReference<T> {
        public b(T t) {
            super(t);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(126213);
            if (obj == this) {
                AppMethodBeat.o(126213);
                return true;
            } else if (obj instanceof b) {
                Object obj2 = ((b) obj).get();
                Object obj3 = get();
                if (obj2 == obj3 || (obj3 != null && obj3.equals(obj2))) {
                    AppMethodBeat.o(126213);
                    return true;
                }
                AppMethodBeat.o(126213);
                return false;
            } else {
                AppMethodBeat.o(126213);
                return false;
            }
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        AppMethodBeat.i(126214);
        this.eGN = new LinkedList();
        this.eGO = new LinkedList();
        AppMethodBeat.o(126214);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(126215);
        if (c(aVar)) {
            AppMethodBeat.o(126215);
            return false;
        }
        synchronized (this.eGN) {
            try {
                this.eGN.add(new b(aVar));
                PX();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(126215);
            }
        }
        return true;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(126216);
        if (aVar == null) {
            AppMethodBeat.o(126216);
            return false;
        }
        boolean remove;
        synchronized (this.eGN) {
            try {
                remove = this.eGN.remove(new b(aVar));
                PY();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(126216);
            }
        }
        return remove;
    }

    public final boolean c(a aVar) {
        AppMethodBeat.i(126217);
        if (aVar == null) {
            AppMethodBeat.o(126217);
            return false;
        }
        synchronized (this.eGN) {
            try {
                for (b bVar : this.eGN) {
                    if (bVar != null) {
                        a aVar2 = (a) bVar.get();
                        if (aVar2 != null && aVar.equals(aVar2)) {
                        }
                    }
                }
                AppMethodBeat.o(126217);
                return false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(126217);
            }
        }
        return true;
    }

    public final int size() {
        int size;
        AppMethodBeat.i(126218);
        synchronized (this.eGN) {
            try {
                size = this.eGN.size();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(126218);
            }
        }
        return size;
    }

    private synchronized void PX() {
        AppMethodBeat.i(126219);
        Iterator it = this.eGO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(126219);
    }

    private synchronized void PY() {
        AppMethodBeat.i(126220);
        Iterator it = this.eGO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(126220);
    }
}
