package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class p extends Exception {
    private static final StackTraceElement[] aBV = new StackTraceElement[0];
    private com.bumptech.glide.c.a aAL;
    private final List<Throwable> aBW;
    private String aBX;
    private Class<?> aBd;
    private h azP;

    static final class a implements Appendable {
        private final Appendable aBY;
        private boolean aBZ = true;

        a(Appendable appendable) {
            this.aBY = appendable;
        }

        public final Appendable append(char c) {
            boolean z = false;
            AppMethodBeat.i(91845);
            if (this.aBZ) {
                this.aBZ = false;
                this.aBY.append("  ");
            }
            if (c == 10) {
                z = true;
            }
            this.aBZ = z;
            this.aBY.append(c);
            AppMethodBeat.o(91845);
            return this;
        }

        public final Appendable append(CharSequence charSequence) {
            AppMethodBeat.i(91846);
            CharSequence p = p(charSequence);
            Appendable append = append(p, 0, p.length());
            AppMethodBeat.o(91846);
            return append;
        }

        public final Appendable append(CharSequence charSequence, int i, int i2) {
            boolean z = false;
            AppMethodBeat.i(91847);
            CharSequence p = p(charSequence);
            if (this.aBZ) {
                this.aBZ = false;
                this.aBY.append("  ");
            }
            if (p.length() > 0 && p.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.aBZ = z;
            this.aBY.append(p, i, i2);
            AppMethodBeat.o(91847);
            return this;
        }

        private static CharSequence p(CharSequence charSequence) {
            if (charSequence == null) {
                return "";
            }
            return charSequence;
        }
    }

    public p(String str) {
        this(str, Collections.emptyList());
        AppMethodBeat.i(91848);
        AppMethodBeat.o(91848);
    }

    public p(String str, Throwable th) {
        this(str, Collections.singletonList(th));
        AppMethodBeat.i(91849);
        AppMethodBeat.o(91849);
    }

    public p(String str, List<Throwable> list) {
        AppMethodBeat.i(91850);
        this.aBX = str;
        setStackTrace(aBV);
        this.aBW = list;
        AppMethodBeat.o(91850);
    }

    /* Access modifiers changed, original: final */
    public final void a(h hVar, com.bumptech.glide.c.a aVar, Class<?> cls) {
        this.azP = hVar;
        this.aAL = aVar;
        this.aBd = cls;
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    private List<Throwable> mL() {
        AppMethodBeat.i(91851);
        List arrayList = new ArrayList();
        a((Throwable) this, arrayList);
        AppMethodBeat.o(91851);
        return arrayList;
    }

    public final void mM() {
        AppMethodBeat.i(91852);
        List mL = mL();
        int size = mL.size();
        for (int i = 0; i < size; i++) {
            new StringBuilder("Root cause (").append(i + 1).append(" of ").append(size).append(")");
            mL.get(i);
        }
        AppMethodBeat.o(91852);
    }

    private void a(Throwable th, List<Throwable> list) {
        AppMethodBeat.i(91853);
        if (th instanceof p) {
            for (Throwable a : ((p) th).aBW) {
                a(a, (List) list);
            }
            AppMethodBeat.o(91853);
            return;
        }
        list.add(th);
        AppMethodBeat.o(91853);
    }

    public final void printStackTrace() {
        AppMethodBeat.i(91854);
        printStackTrace(System.err);
        AppMethodBeat.o(91854);
    }

    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(91855);
        a(printStream);
        AppMethodBeat.o(91855);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(91856);
        a(printWriter);
        AppMethodBeat.o(91856);
    }

    private void a(Appendable appendable) {
        AppMethodBeat.i(91857);
        a((Throwable) this, appendable);
        a(this.aBW, new a(appendable));
        AppMethodBeat.o(91857);
    }

    public final String getMessage() {
        AppMethodBeat.i(91858);
        StringBuilder append = new StringBuilder(71).append(this.aBX).append(this.aBd != null ? ", " + this.aBd : "").append(this.aAL != null ? ", " + this.aAL : "").append(this.azP != null ? ", " + this.azP : "");
        List<Throwable> mL = mL();
        String stringBuilder;
        if (mL.isEmpty()) {
            stringBuilder = append.toString();
            AppMethodBeat.o(91858);
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
        AppMethodBeat.o(91858);
        return stringBuilder;
    }

    private static void a(Throwable th, Appendable appendable) {
        AppMethodBeat.i(91859);
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
            AppMethodBeat.o(91859);
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(th);
            AppMethodBeat.o(91859);
            throw runtimeException;
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        AppMethodBeat.i(91860);
        try {
            b(list, appendable);
            AppMethodBeat.o(91860);
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(91860);
            throw runtimeException;
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        AppMethodBeat.i(91861);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            appendable.append("Cause (").append(String.valueOf(i + 1)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof p) {
                ((p) th).a(appendable);
            } else {
                a(th, appendable);
            }
        }
        AppMethodBeat.o(91861);
    }
}
