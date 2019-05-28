package a.f.b;

import a.e;
import a.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public class j {
    private j() {
    }

    public static String u(String str, Object obj) {
        AppMethodBeat.i(55862);
        String str2 = str + obj;
        AppMethodBeat.o(55862);
        return str2;
    }

    public static void dWJ() {
        AppMethodBeat.i(55863);
        e eVar = (e) o(new e());
        AppMethodBeat.o(55863);
        throw eVar;
    }

    public static void avw(String str) {
        AppMethodBeat.i(55864);
        x xVar = (x) o(new x("lateinit property " + str + " has not been initialized"));
        AppMethodBeat.o(55864);
        throw xVar;
    }

    public static void o(Object obj, String str) {
        AppMethodBeat.i(55865);
        if (obj == null) {
            IllegalStateException illegalStateException = (IllegalStateException) o(new IllegalStateException(str + " must not be null"));
            AppMethodBeat.o(55865);
            throw illegalStateException;
        }
        AppMethodBeat.o(55865);
    }

    public static void p(Object obj, String str) {
        AppMethodBeat.i(55866);
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            IllegalArgumentException illegalArgumentException = (IllegalArgumentException) o(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str));
            AppMethodBeat.o(55866);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(55866);
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static boolean j(Object obj, Object obj2) {
        AppMethodBeat.i(55867);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(55867);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(55867);
            return true;
        } else {
            AppMethodBeat.o(55867);
            return false;
        }
    }

    private static <T extends Throwable> T o(T t) {
        AppMethodBeat.i(55868);
        Throwable b = b(t, j.class.getName());
        AppMethodBeat.o(55868);
        return b;
    }

    static <T extends Throwable> T b(T t, String str) {
        AppMethodBeat.i(55869);
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        AppMethodBeat.o(55869);
        return t;
    }
}
