package p000a.p010i.p011b.p012a.p014b;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p049e.C37076b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, dWq = {"Lkotlin/reflect/jvm/internal/components/SignatureSerializer;", "", "()V", "constructorDesc", "", "constructor", "Ljava/lang/reflect/Constructor;", "fieldDesc", "field", "Ljava/lang/reflect/Field;", "methodDesc", "method", "Ljava/lang/reflect/Method;", "descriptors.runtime"})
/* renamed from: a.i.b.a.b.l */
final class C25074l {
    public static final C25074l AZG = new C25074l();

    static {
        AppMethodBeat.m2504i(119065);
        AppMethodBeat.m2505o(119065);
    }

    private C25074l() {
    }

    /* renamed from: e */
    public static String m39405e(Method method) {
        AppMethodBeat.m2504i(119062);
        C25052j.m39376p(method, C8741b.METHOD);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Object obj : method.getParameterTypes()) {
            C25052j.m39375o(obj, "parameterType");
            stringBuilder.append(C37076b.m62037bc(obj));
        }
        stringBuilder.append(")");
        Class returnType = method.getReturnType();
        C25052j.m39375o(returnType, "method.returnType");
        stringBuilder.append(C37076b.m62037bc(returnType));
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "sb.toString()");
        AppMethodBeat.m2505o(119062);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static String m39403a(Constructor<?> constructor) {
        AppMethodBeat.m2504i(119063);
        C25052j.m39376p(constructor, "constructor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Object obj : constructor.getParameterTypes()) {
            C25052j.m39375o(obj, "parameterType");
            stringBuilder.append(C37076b.m62037bc(obj));
        }
        stringBuilder.append(")V");
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "sb.toString()");
        AppMethodBeat.m2505o(119063);
        return stringBuilder2;
    }

    /* renamed from: d */
    public static String m39404d(Field field) {
        AppMethodBeat.m2504i(119064);
        C25052j.m39376p(field, "field");
        Class type = field.getType();
        C25052j.m39375o(type, "field.type");
        String bc = C37076b.m62037bc(type);
        AppMethodBeat.m2505o(119064);
        return bc;
    }
}
