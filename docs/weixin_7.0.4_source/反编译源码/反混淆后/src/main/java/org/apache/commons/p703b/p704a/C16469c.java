package org.apache.commons.p703b.p704a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: org.apache.commons.b.a.c */
public final class C16469c implements Serializable {
    public static boolean BYA = true;
    public static boolean BYy = true;
    public static boolean BYz = true;
    private Throwable BYx = null;

    public C16469c(C16468b c16468b) {
        AppMethodBeat.m2504i(116944);
        this.BYx = (Throwable) c16468b;
        AppMethodBeat.m2505o(116944);
    }

    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.m2504i(116945);
        synchronized (printStream) {
            try {
                PrintWriter printWriter = new PrintWriter(printStream, false);
                printStackTrace(printWriter);
                printWriter.flush();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(116945);
            }
        }
    }

    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.m2504i(116946);
        Throwable th = this.BYx;
        if (!C6121a.emS()) {
            ArrayList arrayList = new ArrayList();
            for (Throwable th2 = th; th2 != null; th2 = C6121a.m9684C(th2)) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter2 = new PrintWriter(stringWriter, true);
                if (th2 instanceof C16468b) {
                    ((C16468b) th2).mo13556b(printWriter2);
                } else {
                    th2.printStackTrace(printWriter2);
                }
                arrayList.add(C6121a.awP(stringWriter.getBuffer().toString()));
            }
            String str = "Caused by: ";
            if (!BYy) {
                str = "Rethrown as: ";
                Collections.reverse(arrayList);
            }
            String str2 = str;
            if (BYz) {
                C16469c.m25278gd(arrayList);
            }
            synchronized (printWriter) {
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        for (String println : (String[]) it.next()) {
                            printWriter.println(println);
                        }
                        if (it.hasNext()) {
                            printWriter.print(str2);
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(116946);
                }
            }
        } else if (th instanceof C16468b) {
            ((C16468b) th).mo13556b(printWriter);
            AppMethodBeat.m2505o(116946);
        } else {
            th.printStackTrace(printWriter);
            AppMethodBeat.m2505o(116946);
        }
    }

    /* renamed from: gd */
    private static void m25278gd(List list) {
        AppMethodBeat.m2504i(116947);
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            String[] strArr2 = (String[]) list.get(size - 1);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            C6121a.m9688v(arrayList, new ArrayList(Arrays.asList(strArr2)));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                arrayList.add(new StringBuffer("\t... ").append(length).append(" more").toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
        AppMethodBeat.m2505o(116947);
    }
}
