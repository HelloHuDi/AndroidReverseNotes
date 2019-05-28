package a.i.b.a.b;

import a.f.b.j;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, dWq = {"Lkotlin/reflect/jvm/internal/components/SignatureSerializer;", "", "()V", "constructorDesc", "", "constructor", "Ljava/lang/reflect/Constructor;", "fieldDesc", "field", "Ljava/lang/reflect/Field;", "methodDesc", "method", "Ljava/lang/reflect/Method;", "descriptors.runtime"})
final class l {
    public static final l AZG = new l();

    static {
        AppMethodBeat.i(119065);
        AppMethodBeat.o(119065);
    }

    private l() {
    }

    public static String e(Method method) {
        AppMethodBeat.i(119062);
        j.p(method, b.METHOD);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Object obj : method.getParameterTypes()) {
            j.o(obj, "parameterType");
            stringBuilder.append(a.i.b.a.e.b.bc(obj));
        }
        stringBuilder.append(")");
        Class returnType = method.getReturnType();
        j.o(returnType, "method.returnType");
        stringBuilder.append(a.i.b.a.e.b.bc(returnType));
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "sb.toString()");
        AppMethodBeat.o(119062);
        return stringBuilder2;
    }

    public static String a(Constructor<?> constructor) {
        AppMethodBeat.i(119063);
        j.p(constructor, "constructor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Object obj : constructor.getParameterTypes()) {
            j.o(obj, "parameterType");
            stringBuilder.append(a.i.b.a.e.b.bc(obj));
        }
        stringBuilder.append(")V");
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "sb.toString()");
        AppMethodBeat.o(119063);
        return stringBuilder2;
    }

    public static String d(Field field) {
        AppMethodBeat.i(119064);
        j.p(field, "field");
        Class type = field.getType();
        j.o(type, "field.type");
        String bc = a.i.b.a.e.b.bc(type);
        AppMethodBeat.o(119064);
        return bc;
    }
}
