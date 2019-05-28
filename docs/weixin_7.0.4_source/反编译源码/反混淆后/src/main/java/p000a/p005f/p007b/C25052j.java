package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import p000a.C31590e;
import p000a.C44942x;

/* renamed from: a.f.b.j */
public class C25052j {
    private C25052j() {
    }

    /* renamed from: u */
    public static String m39377u(String str, Object obj) {
        AppMethodBeat.m2504i(55862);
        String str2 = str + obj;
        AppMethodBeat.m2505o(55862);
        return str2;
    }

    public static void dWJ() {
        AppMethodBeat.m2504i(55863);
        C31590e c31590e = (C31590e) C25052j.m39374o(new C31590e());
        AppMethodBeat.m2505o(55863);
        throw c31590e;
    }

    public static void avw(String str) {
        AppMethodBeat.m2504i(55864);
        C44942x c44942x = (C44942x) C25052j.m39374o(new C44942x("lateinit property " + str + " has not been initialized"));
        AppMethodBeat.m2505o(55864);
        throw c44942x;
    }

    /* renamed from: o */
    public static void m39375o(Object obj, String str) {
        AppMethodBeat.m2504i(55865);
        if (obj == null) {
            IllegalStateException illegalStateException = (IllegalStateException) C25052j.m39374o(new IllegalStateException(str + " must not be null"));
            AppMethodBeat.m2505o(55865);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(55865);
    }

    /* renamed from: p */
    public static void m39376p(Object obj, String str) {
        AppMethodBeat.m2504i(55866);
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            IllegalArgumentException illegalArgumentException = (IllegalArgumentException) C25052j.m39374o(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str));
            AppMethodBeat.m2505o(55866);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(55866);
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: j */
    public static boolean m39373j(Object obj, Object obj2) {
        AppMethodBeat.m2504i(55867);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.m2505o(55867);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.m2505o(55867);
            return true;
        } else {
            AppMethodBeat.m2505o(55867);
            return false;
        }
    }

    /* renamed from: o */
    private static <T extends Throwable> T m39374o(T t) {
        AppMethodBeat.m2504i(55868);
        Throwable b = C25052j.m39372b(t, C25052j.class.getName());
        AppMethodBeat.m2505o(55868);
        return b;
    }

    /* renamed from: b */
    static <T extends Throwable> T m39372b(T t, String str) {
        AppMethodBeat.m2504i(55869);
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
        AppMethodBeat.m2505o(55869);
        return t;
    }
}
