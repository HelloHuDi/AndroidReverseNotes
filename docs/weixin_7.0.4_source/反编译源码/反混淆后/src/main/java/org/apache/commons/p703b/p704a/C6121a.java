package org.apache.commons.p703b.p704a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.p703b.C16470a;
import org.apache.commons.p703b.C41169f;

/* renamed from: org.apache.commons.b.a.a */
public final class C6121a {
    private static final Object BYs = new Object();
    private static String[] BYt = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    private static final Method BYu;
    private static final Method BYv;
    static Class BYw;

    static {
        Class awQ;
        Method method;
        Method method2 = null;
        AppMethodBeat.m2504i(116943);
        try {
            if (BYw == null) {
                awQ = C6121a.awQ("java.lang.Throwable");
                BYw = awQ;
            } else {
                awQ = BYw;
            }
            method = awQ.getMethod("getCause", null);
        } catch (Exception e) {
            method = null;
        }
        BYu = method;
        try {
            Class cls;
            if (BYw == null) {
                awQ = C6121a.awQ("java.lang.Throwable");
                BYw = awQ;
                cls = awQ;
            } else {
                cls = BYw;
            }
            String str = "initCause";
            Class[] clsArr = new Class[1];
            if (BYw == null) {
                awQ = C6121a.awQ("java.lang.Throwable");
                BYw = awQ;
            } else {
                awQ = BYw;
            }
            clsArr[0] = awQ;
            method2 = cls.getMethod(str, clsArr);
        } catch (Exception e2) {
        }
        BYv = method2;
        AppMethodBeat.m2505o(116943);
    }

    private static Class awQ(String str) {
        AppMethodBeat.m2504i(116942);
        try {
            Class cls = Class.forName(str);
            AppMethodBeat.m2505o(116942);
            return cls;
        } catch (ClassNotFoundException e) {
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(e.getMessage());
            AppMethodBeat.m2505o(116942);
            throw noClassDefFoundError;
        }
    }

    /* renamed from: C */
    public static Throwable m9684C(Throwable th) {
        Throwable a;
        AppMethodBeat.m2504i(116936);
        synchronized (BYs) {
            try {
                a = C6121a.m9685a(th, BYt);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(116936);
            }
        }
        return a;
    }

    /* renamed from: a */
    private static Throwable m9685a(Throwable th, String[] strArr) {
        Throwable th2 = null;
        AppMethodBeat.m2504i(116937);
        if (th == null) {
            AppMethodBeat.m2505o(116937);
        } else {
            if (th instanceof C16468b) {
                th2 = ((C16468b) th).getCause();
            } else if (th instanceof SQLException) {
                th2 = ((SQLException) th).getNextException();
            } else if (th instanceof InvocationTargetException) {
                th2 = ((InvocationTargetException) th).getTargetException();
            }
            if (th2 == null) {
                if (strArr == null) {
                    synchronized (BYs) {
                        try {
                            strArr = BYt;
                        } catch (Throwable th3) {
                            while (true) {
                                AppMethodBeat.m2505o(116937);
                            }
                        }
                    }
                }
                for (String str : strArr) {
                    if (str != null) {
                        th2 = C6121a.m9686d(th, str);
                        if (th2 != null) {
                            break;
                        }
                    }
                }
                if (th2 == null) {
                    th2 = C6121a.m9687e(th, "detail");
                }
            }
            AppMethodBeat.m2505o(116937);
        }
        return th2;
    }

    /* renamed from: d */
    private static Throwable m9686d(Throwable th, String str) {
        Method method;
        AppMethodBeat.m2504i(116938);
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException e) {
            method = null;
        } catch (SecurityException e2) {
            method = null;
        }
        if (method != null) {
            Class awQ;
            if (BYw == null) {
                awQ = C6121a.awQ("java.lang.Throwable");
                BYw = awQ;
            } else {
                awQ = BYw;
            }
            if (awQ.isAssignableFrom(method.getReturnType())) {
                try {
                    Throwable th2 = (Throwable) method.invoke(th, C16470a.BWE);
                    AppMethodBeat.m2505o(116938);
                    return th2;
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                }
            }
        }
        AppMethodBeat.m2505o(116938);
        return null;
    }

    /* renamed from: e */
    private static Throwable m9687e(Throwable th, String str) {
        Field field;
        AppMethodBeat.m2504i(116939);
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException e) {
            field = null;
        } catch (SecurityException e2) {
            field = null;
        }
        if (field != null) {
            Class awQ;
            if (BYw == null) {
                awQ = C6121a.awQ("java.lang.Throwable");
                BYw = awQ;
            } else {
                awQ = BYw;
            }
            if (awQ.isAssignableFrom(field.getType())) {
                try {
                    Throwable th2 = (Throwable) field.get(th);
                    AppMethodBeat.m2505o(116939);
                    return th2;
                } catch (IllegalAccessException | IllegalArgumentException e3) {
                }
            }
        }
        AppMethodBeat.m2505o(116939);
        return null;
    }

    public static boolean emS() {
        return BYu != null;
    }

    /* renamed from: v */
    public static void m9688v(List list, List list2) {
        AppMethodBeat.m2504i(116940);
        int size = list2.size() - 1;
        for (int size2 = list.size() - 1; size2 >= 0 && size >= 0; size2--) {
            if (((String) list.get(size2)).equals((String) list2.get(size))) {
                list.remove(size2);
            }
            size--;
        }
        AppMethodBeat.m2505o(116940);
    }

    static String[] awP(String str) {
        AppMethodBeat.m2504i(116941);
        StringTokenizer stringTokenizer = new StringTokenizer(str, C41169f.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.m2505o(116941);
        return strArr;
    }
}
