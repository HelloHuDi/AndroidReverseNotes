package com.tencent.tencentmap.mapsdk.maps.p667a;

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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ma */
public final class C46805ma extends RuntimeException {
    /* renamed from: a */
    private final List<Throwable> f18264a;
    /* renamed from: b */
    private final String f18265b;
    /* renamed from: c */
    private Throwable f18266c;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ma$a */
    static final class C36537a extends RuntimeException {
        /* renamed from: a */
        static String f15450a = "Chain of Causes for CompositeException In Order Received =>";

        C36537a() {
        }

        public final String getMessage() {
            return f15450a;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ma$b */
    static abstract class C36538b {
        /* renamed from: a */
        public abstract Object mo57776a();

        /* renamed from: a */
        public abstract void mo57777a(Object obj);

        private C36538b() {
        }

        /* synthetic */ C36538b(C468041 c468041) {
            this();
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ma$c */
    static class C36905c extends C36538b {
        /* renamed from: a */
        private final PrintStream f15627a;

        C36905c(PrintStream printStream) {
            super();
            this.f15627a = printStream;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public Object mo57776a() {
            return this.f15627a;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo57777a(Object obj) {
            AppMethodBeat.m2504i(100491);
            this.f15627a.println(obj);
            AppMethodBeat.m2505o(100491);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ma$d */
    static class C36906d extends C36538b {
        /* renamed from: a */
        private final PrintWriter f15628a;

        C36906d(PrintWriter printWriter) {
            super();
            this.f15628a = printWriter;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public Object mo57776a() {
            return this.f15628a;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo57777a(Object obj) {
            AppMethodBeat.m2504i(100492);
            this.f15628a.println(obj);
            AppMethodBeat.m2505o(100492);
        }
    }

    public C46805ma(String str, Collection<? extends Throwable> collection) {
        AppMethodBeat.m2504i(100493);
        this.f18266c = null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (Throwable th : collection) {
            if (th instanceof C46805ma) {
                linkedHashSet.addAll(((C46805ma) th).mo75534a());
            } else {
                linkedHashSet.add(th);
            }
        }
        arrayList.addAll(linkedHashSet);
        this.f18264a = Collections.unmodifiableList(arrayList);
        this.f18265b = this.f18264a.size() + " exceptions occurred. ";
        AppMethodBeat.m2505o(100493);
    }

    public C46805ma(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    /* renamed from: a */
    public final List<Throwable> mo75534a() {
        return this.f18264a;
    }

    public final String getMessage() {
        return this.f18265b;
    }

    public final synchronized Throwable getCause() {
        Throwable th;
        AppMethodBeat.m2504i(100494);
        if (this.f18266c == null) {
            Throwable c36537a = new C36537a();
            HashSet hashSet = new HashSet();
            Throwable th2 = c36537a;
            for (Throwable th3 : this.f18264a) {
                if (!hashSet.contains(th3)) {
                    hashSet.add(th3);
                    Throwable th4 = th3;
                    for (Throwable th32 : m89010a(th32)) {
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
            this.f18266c = c36537a;
        }
        th32 = this.f18266c;
        AppMethodBeat.m2505o(100494);
        return th32;
    }

    public final void printStackTrace() {
        AppMethodBeat.m2504i(100495);
        printStackTrace(System.err);
        AppMethodBeat.m2505o(100495);
    }

    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.m2504i(100496);
        m89011a(new C36905c(printStream));
        AppMethodBeat.m2505o(100496);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.m2504i(100497);
        m89011a(new C36906d(printWriter));
        AppMethodBeat.m2505o(100497);
    }

    /* renamed from: a */
    private void m89011a(C36538b c36538b) {
        AppMethodBeat.m2504i(100498);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this).append(IOUtils.LINE_SEPARATOR_UNIX);
        for (Object append : getStackTrace()) {
            stringBuilder.append("\tat ").append(append).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        int i = 1;
        Iterator it = this.f18264a.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            Throwable th = (Throwable) it.next();
            stringBuilder.append("  ComposedException ").append(i2).append(" :\n");
            m89012a(stringBuilder, th, "\t");
            i = i2 + 1;
        }
        synchronized (c36538b.mo57776a()) {
            try {
                c36538b.mo57777a(stringBuilder.toString());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100498);
            }
        }
    }

    /* renamed from: a */
    private void m89012a(StringBuilder stringBuilder, Throwable th, String str) {
        AppMethodBeat.m2504i(100499);
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
                AppMethodBeat.m2505o(100499);
                return;
            }
        }
    }

    /* renamed from: a */
    private final List<Throwable> m89010a(Throwable th) {
        AppMethodBeat.m2504i(100500);
        ArrayList arrayList = new ArrayList();
        Object cause = th.getCause();
        if (cause == null) {
            AppMethodBeat.m2505o(100500);
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            if (cause.getCause() == null) {
                AppMethodBeat.m2505o(100500);
                return arrayList;
            }
            cause = cause.getCause();
        }
    }
}
