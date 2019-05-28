package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class ma extends RuntimeException {
    private final List<Throwable> a;
    private final String b;
    private Throwable c;

    static final class a extends RuntimeException {
        static String a = "Chain of Causes for CompositeException In Order Received =>";

        a() {
        }

        public final String getMessage() {
            return a;
        }
    }

    static abstract class b {
        public abstract Object a();

        public abstract void a(Object obj);

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static class c extends b {
        private final PrintStream a;

        c(PrintStream printStream) {
            super();
            this.a = printStream;
        }

        /* Access modifiers changed, original: 0000 */
        public Object a() {
            return this.a;
        }

        /* Access modifiers changed, original: 0000 */
        public void a(Object obj) {
            AppMethodBeat.i(100491);
            this.a.println(obj);
            AppMethodBeat.o(100491);
        }
    }

    static class d extends b {
        private final PrintWriter a;

        d(PrintWriter printWriter) {
            super();
            this.a = printWriter;
        }

        /* Access modifiers changed, original: 0000 */
        public Object a() {
            return this.a;
        }

        /* Access modifiers changed, original: 0000 */
        public void a(Object obj) {
            AppMethodBeat.i(100492);
            this.a.println(obj);
            AppMethodBeat.o(100492);
        }
    }

    public ma(String str, Collection<? extends Throwable> collection) {
        AppMethodBeat.i(100493);
        this.c = null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (Throwable th : collection) {
            if (th instanceof ma) {
                linkedHashSet.addAll(((ma) th).a());
            } else {
                linkedHashSet.add(th);
            }
        }
        arrayList.addAll(linkedHashSet);
        this.a = Collections.unmodifiableList(arrayList);
        this.b = this.a.size() + " exceptions occurred. ";
        AppMethodBeat.o(100493);
    }

    public ma(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    public final List<Throwable> a() {
        return this.a;
    }

    public final String getMessage() {
        return this.b;
    }

    public final synchronized Throwable getCause() {
        Throwable th;
        AppMethodBeat.i(100494);
        if (this.c == null) {
            Throwable aVar = new a();
            HashSet hashSet = new HashSet();
            Throwable th2 = aVar;
            for (Throwable th3 : this.a) {
                if (!hashSet.contains(th3)) {
                    hashSet.add(th3);
                    Throwable th4 = th3;
                    for (Throwable th32 : a(th32)) {
                        if (hashSet.contains(th32)) {
                            th4 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th32);
                        }
                    }
                    try {
                        th2.initCause(th4);
                    } catch (Throwable th5) {
                    }
                    th2 = th2.getCause();
                }
            }
            this.c = aVar;
        }
        th32 = this.c;
        AppMethodBeat.o(100494);
        return th32;
    }

    public final void printStackTrace() {
        AppMethodBeat.i(100495);
        printStackTrace(System.err);
        AppMethodBeat.o(100495);
    }

    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(100496);
        a(new c(printStream));
        AppMethodBeat.o(100496);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(100497);
        a(new d(printWriter));
        AppMethodBeat.o(100497);
    }

    private void a(b bVar) {
        AppMethodBeat.i(100498);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this).append(IOUtils.LINE_SEPARATOR_UNIX);
        for (Object append : getStackTrace()) {
            stringBuilder.append("\tat ").append(append).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        int i = 1;
        Iterator it = this.a.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            Throwable th = (Throwable) it.next();
            stringBuilder.append("  ComposedException ").append(i2).append(" :\n");
            a(stringBuilder, th, "\t");
            i = i2 + 1;
        }
        synchronized (bVar.a()) {
            try {
                bVar.a(stringBuilder.toString());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100498);
            }
        }
    }

    private void a(StringBuilder stringBuilder, Throwable th, String str) {
        AppMethodBeat.i(100499);
        while (true) {
            Object th2;
            stringBuilder.append(str).append(th2).append(IOUtils.LINE_SEPARATOR_UNIX);
            for (Object append : th2.getStackTrace()) {
                stringBuilder.append("\t\tat ").append(append).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (th2.getCause() != null) {
                stringBuilder.append("\tCaused by: ");
                th2 = th2.getCause();
                str = "";
            } else {
                AppMethodBeat.o(100499);
                return;
            }
        }
    }

    private final List<Throwable> a(Throwable th) {
        AppMethodBeat.i(100500);
        ArrayList arrayList = new ArrayList();
        Object cause = th.getCause();
        if (cause == null) {
            AppMethodBeat.o(100500);
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            if (cause.getCause() == null) {
                AppMethodBeat.o(100500);
                return arrayList;
            }
            cause = cause.getCause();
        }
    }
}
