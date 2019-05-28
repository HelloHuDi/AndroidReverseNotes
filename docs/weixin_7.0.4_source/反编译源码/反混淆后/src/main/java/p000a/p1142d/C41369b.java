package p000a.p1142d;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"})
/* renamed from: a.d.b */
public final class C41369b {
    public static final C41368a AVu;

    static {
        Object newInstance;
        C44941v c44941v;
        C41368a c41368a;
        ClassLoader classLoader;
        Throwable initCause;
        AppMethodBeat.m2504i(56014);
        int dWA = C41369b.dWA();
        if (dWA >= NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST) {
            try {
                newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                C25052j.m39375o(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    AppMethodBeat.m2505o(56014);
                    throw c44941v;
                }
                c41368a = (C41368a) newInstance;
                AVu = c41368a;
                AppMethodBeat.m2505o(56014);
            } catch (ClassCastException e) {
                classLoader = newInstance.getClass().getClassLoader();
                initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + C41368a.class.getClassLoader()).initCause(e);
                C25052j.m39375o(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                AppMethodBeat.m2505o(56014);
                throw initCause;
            } catch (ClassNotFoundException e2) {
                try {
                    newInstance = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    C25052j.m39375o(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance == null) {
                        try {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            AppMethodBeat.m2505o(56014);
                            throw c44941v;
                        } catch (ClassCastException e3) {
                            classLoader = newInstance.getClass().getClassLoader();
                            initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + C41368a.class.getClassLoader()).initCause(e3);
                            C25052j.m39375o(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            AppMethodBeat.m2505o(56014);
                            throw initCause;
                        }
                    }
                    c41368a = (C41368a) newInstance;
                } catch (ClassNotFoundException e4) {
                }
            }
        }
        if (dWA >= NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY) {
            try {
                newInstance = Class.forName("a.d.a.a").newInstance();
                C25052j.m39375o(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    AppMethodBeat.m2505o(56014);
                    throw c44941v;
                }
                c41368a = (C41368a) newInstance;
                AVu = c41368a;
                AppMethodBeat.m2505o(56014);
            } catch (ClassCastException e32) {
                classLoader = newInstance.getClass().getClassLoader();
                initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + C41368a.class.getClassLoader()).initCause(e32);
                C25052j.m39375o(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                AppMethodBeat.m2505o(56014);
                throw initCause;
            } catch (ClassNotFoundException e5) {
                try {
                    newInstance = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    C25052j.m39375o(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance == null) {
                        try {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            AppMethodBeat.m2505o(56014);
                            throw c44941v;
                        } catch (ClassCastException e322) {
                            classLoader = newInstance.getClass().getClassLoader();
                            initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + C41368a.class.getClassLoader()).initCause(e322);
                            C25052j.m39375o(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            AppMethodBeat.m2505o(56014);
                            throw initCause;
                        }
                    }
                    c41368a = (C41368a) newInstance;
                } catch (ClassNotFoundException e6) {
                }
            }
        }
        c41368a = new C41368a();
        AVu = c41368a;
        AppMethodBeat.m2505o(56014);
    }

    private static final int dWA() {
        int i = NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        AppMethodBeat.m2504i(56013);
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            AppMethodBeat.m2505o(56013);
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int a = C31820v.m51514a((CharSequence) property, '.', 0, 6);
        int parseInt;
        if (a < 0) {
            try {
                parseInt = Integer.parseInt(property) * 65536;
            } catch (NumberFormatException e) {
                parseInt = NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
            AppMethodBeat.m2505o(56013);
            return parseInt;
        }
        parseInt = C31820v.m51514a((CharSequence) property, '.', a + 1, 4);
        if (parseInt < 0) {
            parseInt = property.length();
        }
        C44941v c44941v;
        if (property == null) {
            c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(56013);
            throw c44941v;
        }
        String substring = property.substring(0, a);
        C25052j.m39375o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        a++;
        if (property == null) {
            c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(56013);
            throw c44941v;
        }
        String substring2 = property.substring(a, parseInt);
        C25052j.m39375o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            i = (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException e2) {
        }
        AppMethodBeat.m2505o(56013);
        return i;
    }
}
