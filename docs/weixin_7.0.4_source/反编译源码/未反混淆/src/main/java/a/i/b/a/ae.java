package a.i.b.a;

import a.a.i;
import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, dWq = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflect-api"})
public final class ae {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends k implements b<Class<?>, String> {
        public static final a AYD = new a();

        static {
            AppMethodBeat.i(118932);
            AppMethodBeat.o(118932);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(118931);
            Class cls = (Class) obj;
            j.o(cls, "it");
            String bc = a.i.b.a.e.b.bc(cls);
            AppMethodBeat.o(118931);
            return bc;
        }
    }

    static final String d(Method method) {
        AppMethodBeat.i(118933);
        StringBuilder append = new StringBuilder().append(method.getName());
        Class[] parameterTypes = method.getParameterTypes();
        j.o(parameterTypes, "parameterTypes");
        StringBuilder append2 = append.append(i.a((Object[]) parameterTypes, (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, null, (b) a.AYD, 24));
        Class returnType = method.getReturnType();
        j.o(returnType, "returnType");
        String stringBuilder = append2.append(a.i.b.a.e.b.bc(returnType)).toString();
        AppMethodBeat.o(118933);
        return stringBuilder;
    }
}
