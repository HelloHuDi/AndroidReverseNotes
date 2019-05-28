package a.i.b.a.e;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader;", "", "()V", "cache", "Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "getCache", "()Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "setCache", "(Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;)V", "buildCache", "member", "Ljava/lang/reflect/Member;", "loadParameterNames", "", "", "Cache", "descriptors.runtime"})
final class a {
    private static a BNI;
    public static final a BNJ = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "", "getParameters", "Ljava/lang/reflect/Method;", "getName", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetName", "()Ljava/lang/reflect/Method;", "getGetParameters", "descriptors.runtime"})
    public static final class a {
        final Method BNK;
        final Method BNL;

        public a(Method method, Method method2) {
            this.BNK = method;
            this.BNL = method2;
        }
    }

    static {
        AppMethodBeat.i(123009);
        AppMethodBeat.o(123009);
    }

    private a() {
    }

    private static a a(Member member) {
        AppMethodBeat.i(123007);
        j.p(member, "member");
        Class cls = member.getClass();
        a aVar;
        try {
            aVar = new a(cls.getMethod("getParameters", new Class[0]), b.aX(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
            AppMethodBeat.o(123007);
            return aVar;
        } catch (NoSuchMethodException e) {
            aVar = new a(null, null);
            AppMethodBeat.o(123007);
            return aVar;
        }
    }

    public static List<String> b(Member member) {
        AppMethodBeat.i(123008);
        j.p(member, "member");
        a aVar = BNI;
        if (aVar == null) {
            aVar = a(member);
            BNI = aVar;
        }
        Method method = aVar.BNK;
        if (method == null) {
            AppMethodBeat.o(123008);
            return null;
        }
        Method method2 = aVar.BNL;
        if (method2 == null) {
            AppMethodBeat.o(123008);
            return null;
        }
        Object invoke = method.invoke(member, new Object[0]);
        v vVar;
        if (invoke == null) {
            vVar = new v("null cannot be cast to non-null type kotlin.Array<*>");
            AppMethodBeat.o(123008);
            throw vVar;
        }
        Object[] objArr = (Object[]) invoke;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object invoke2 : objArr) {
            Object invoke22 = method2.invoke(invoke22, new Object[0]);
            if (invoke22 == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(123008);
                throw vVar;
            }
            arrayList.add((String) invoke22);
        }
        List<String> list = (List) arrayList;
        AppMethodBeat.o(123008);
        return list;
    }
}
