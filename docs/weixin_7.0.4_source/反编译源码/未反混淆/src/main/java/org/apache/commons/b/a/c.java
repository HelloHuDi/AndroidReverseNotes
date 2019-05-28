package org.apache.commons.b.a;

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

public final class c implements Serializable {
    public static boolean BYA = true;
    public static boolean BYy = true;
    public static boolean BYz = true;
    private Throwable BYx = null;

    public c(b bVar) {
        AppMethodBeat.i(116944);
        this.BYx = (Throwable) bVar;
        AppMethodBeat.o(116944);
    }

    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(116945);
        synchronized (printStream) {
            try {
                PrintWriter printWriter = new PrintWriter(printStream, false);
                printStackTrace(printWriter);
                printWriter.flush();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(116945);
            }
        }
    }

    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(116946);
        Throwable th = this.BYx;
        if (!a.emS()) {
            ArrayList arrayList = new ArrayList();
            for (Throwable th2 = th; th2 != null; th2 = a.C(th2)) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter2 = new PrintWriter(stringWriter, true);
                if (th2 instanceof b) {
                    ((b) th2).b(printWriter2);
                } else {
                    th2.printStackTrace(printWriter2);
                }
                arrayList.add(a.awP(stringWriter.getBuffer().toString()));
            }
            String str = "Caused by: ";
            if (!BYy) {
                str = "Rethrown as: ";
                Collections.reverse(arrayList);
            }
            String str2 = str;
            if (BYz) {
                gd(arrayList);
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
                    AppMethodBeat.o(116946);
                }
            }
        } else if (th instanceof b) {
            ((b) th).b(printWriter);
            AppMethodBeat.o(116946);
        } else {
            th.printStackTrace(printWriter);
            AppMethodBeat.o(116946);
        }
    }

    private static void gd(List list) {
        AppMethodBeat.i(116947);
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            String[] strArr2 = (String[]) list.get(size - 1);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            a.v(arrayList, new ArrayList(Arrays.asList(strArr2)));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                arrayList.add(new StringBuffer("\t... ").append(length).append(" more").toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
        AppMethodBeat.o(116947);
    }
}
