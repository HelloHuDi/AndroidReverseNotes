package kotlinx.coroutines.android;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, dWq = {"getter", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"})
/* renamed from: kotlinx.coroutines.android.a */
public final class C24587a {
    private static final Method BQW;

    static {
        Method declaredMethod;
        Object obj = null;
        AppMethodBeat.m2504i(118246);
        try {
            declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            C25052j.m39375o(declaredMethod, "it");
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                obj = 1;
            }
            if (obj == null) {
                declaredMethod = null;
            }
        } catch (Throwable th) {
            declaredMethod = null;
        }
        BQW = declaredMethod;
        AppMethodBeat.m2505o(118246);
    }
}
