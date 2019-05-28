package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C25405a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b.p */
public final class C37169p extends Exception {
    private static final StackTraceElement[] aBV = new StackTraceElement[0];
    private C25405a aAL;
    private final List<Throwable> aBW;
    private String aBX;
    private Class<?> aBd;
    private C0779h azP;

    /* renamed from: com.bumptech.glide.c.b.p$a */
    static final class C31945a implements Appendable {
        private final Appendable aBY;
        private boolean aBZ = true;

        C31945a(Appendable appendable) {
            this.aBY = appendable;
        }

        public final Appendable append(char c) {
            boolean z = false;
            AppMethodBeat.m2504i(91845);
            if (this.aBZ) {
                this.aBZ = false;
                this.aBY.append("  ");
            }
            if (c == 10) {
                z = true;
            }
            this.aBZ = z;
            this.aBY.append(c);
            AppMethodBeat.m2505o(91845);
            return this;
        }

        public final Appendable append(CharSequence charSequence) {
            AppMethodBeat.m2504i(91846);
            CharSequence p = C31945a.m51900p(charSequence);
            Appendable append = append(p, 0, p.length());
            AppMethodBeat.m2505o(91846);
            return append;
        }

        public final Appendable append(CharSequence charSequence, int i, int i2) {
            boolean z = false;
            AppMethodBeat.m2504i(91847);
            CharSequence p = C31945a.m51900p(charSequence);
            if (this.aBZ) {
                this.aBZ = false;
                this.aBY.append("  ");
            }
            if (p.length() > 0 && p.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.aBZ = z;
            this.aBY.append(p, i, i2);
            AppMethodBeat.m2505o(91847);
            return this;
        }

        /* renamed from: p */
        private static CharSequence m51900p(CharSequence charSequence) {
            if (charSequence == null) {
                return "";
            }
            return charSequence;
        }
    }

    public C37169p(String str) {
        this(str, Collections.emptyList());
        AppMethodBeat.m2504i(91848);
        AppMethodBeat.m2505o(91848);
    }

    public C37169p(String str, Throwable th) {
        this(str, Collections.singletonList(th));
        AppMethodBeat.m2504i(91849);
        AppMethodBeat.m2505o(91849);
    }

    public C37169p(String str, List<Throwable> list) {
        AppMethodBeat.m2504i(91850);
        this.aBX = str;
        setStackTrace(aBV);
        this.aBW = list;
        AppMethodBeat.m2505o(91850);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59252a(C0779h c0779h, C25405a c25405a, Class<?> cls) {
        this.azP = c0779h;
        this.aAL = c25405a;
        this.aBd = cls;
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    /* renamed from: mL */
    private List<Throwable> m62298mL() {
        AppMethodBeat.m2504i(91851);
        List arrayList = new ArrayList();
        m62295a((Throwable) this, arrayList);
        AppMethodBeat.m2505o(91851);
        return arrayList;
    }

    /* renamed from: mM */
    public final void mo59255mM() {
        AppMethodBeat.m2504i(91852);
        List mL = m62298mL();
        int size = mL.size();
        for (int i = 0; i < size; i++) {
            new StringBuilder("Root cause (").append(i + 1).append(" of ").append(size).append(")");
            mL.get(i);
        }
        AppMethodBeat.m2505o(91852);
    }

    /* renamed from: a */
    private void m62295a(Throwable th, List<Throwable> list) {
        AppMethodBeat.m2504i(91853);
        if (th instanceof C37169p) {
            for (Throwable a : ((C37169p) th).aBW) {
                m62295a(a, (List) list);
            }
            AppMethodBeat.m2505o(91853);
            return;
        }
        list.add(th);
        AppMethodBeat.m2505o(91853);
    }

    public final void printStackTrace() {
        AppMethodBeat.m2504i(91854);
        printStackTrace(System.err);
        AppMethodBeat.m2505o(91854);
    }

    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.m2504i(91855);
        m62293a(printStream);
        AppMethodBeat.m2505o(91855);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.m2504i(91856);
        m62293a(printWriter);
        AppMethodBeat.m2505o(91856);
    }

    /* renamed from: a */
    private void m62293a(Appendable appendable) {
        AppMethodBeat.m2504i(91857);
        C37169p.m62294a((Throwable) this, appendable);
        C37169p.m62296a(this.aBW, new C31945a(appendable));
        AppMethodBeat.m2505o(91857);
    }

    public final String getMessage() {
        AppMethodBeat.m2504i(91858);
        StringBuilder append = new StringBuilder(71).append(this.aBX).append(this.aBd != null ? ", " + this.aBd : "").append(this.aAL != null ? ", " + this.aAL : "").append(this.azP != null ? ", " + this.azP : "");
        List<Throwable> mL = m62298mL();
        String stringBuilder;
        if (mL.isEmpty()) {
            stringBuilder = append.toString();
            AppMethodBeat.m2505o(91858);
            return stringBuilder;
        }
        if (mL.size() == 1) {
            append.append("\nThere was 1 cause:");
        } else {
            append.append("\nThere were ").append(mL.size()).append(" causes:");
        }
        for (Throwable th : mL) {
            append.append(10).append(th.getClass().getName()).append('(').append(th.getMessage()).append(')');
        }
        append.append("\n call GlideException#logRootCauses(String) for more detail");
        stringBuilder = append.toString();
        AppMethodBeat.m2505o(91858);
        return stringBuilder;
    }

    /* renamed from: a */
    private static void m62294a(Throwable th, Appendable appendable) {
        AppMethodBeat.m2504i(91859);
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
            AppMethodBeat.m2505o(91859);
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(th);
            AppMethodBeat.m2505o(91859);
            throw runtimeException;
        }
    }

    /* renamed from: a */
    private static void m62296a(List<Throwable> list, Appendable appendable) {
        AppMethodBeat.m2504i(91860);
        try {
            C37169p.m62297b(list, appendable);
            AppMethodBeat.m2505o(91860);
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(91860);
            throw runtimeException;
        }
    }

    /* renamed from: b */
    private static void m62297b(List<Throwable> list, Appendable appendable) {
        AppMethodBeat.m2504i(91861);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            appendable.append("Cause (").append(String.valueOf(i + 1)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof C37169p) {
                ((C37169p) th).m62293a(appendable);
            } else {
                C37169p.m62294a(th, appendable);
            }
        }
        AppMethodBeat.m2505o(91861);
    }
}
