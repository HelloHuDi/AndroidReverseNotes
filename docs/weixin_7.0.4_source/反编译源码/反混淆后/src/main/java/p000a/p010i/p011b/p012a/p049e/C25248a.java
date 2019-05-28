package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader;", "", "()V", "cache", "Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "getCache", "()Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "setCache", "(Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;)V", "buildCache", "member", "Ljava/lang/reflect/Member;", "loadParameterNames", "", "", "Cache", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.a */
final class C25248a {
    private static C8267a BNI;
    public static final C25248a BNJ = new C25248a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "", "getParameters", "Ljava/lang/reflect/Method;", "getName", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetName", "()Ljava/lang/reflect/Method;", "getGetParameters", "descriptors.runtime"})
    /* renamed from: a.i.b.a.e.a$a */
    public static final class C8267a {
        final Method BNK;
        final Method BNL;

        public C8267a(Method method, Method method2) {
            this.BNK = method;
            this.BNL = method2;
        }
    }

    static {
        AppMethodBeat.m2504i(123009);
        AppMethodBeat.m2505o(123009);
    }

    private C25248a() {
    }

    /* renamed from: a */
    private static C8267a m39823a(Member member) {
        AppMethodBeat.m2504i(123007);
        C25052j.m39376p(member, "member");
        Class cls = member.getClass();
        C8267a c8267a;
        try {
            c8267a = new C8267a(cls.getMethod("getParameters", new Class[0]), C37076b.m62032aX(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
            AppMethodBeat.m2505o(123007);
            return c8267a;
        } catch (NoSuchMethodException e) {
            c8267a = new C8267a(null, null);
            AppMethodBeat.m2505o(123007);
            return c8267a;
        }
    }

    /* renamed from: b */
    public static List<String> m39824b(Member member) {
        AppMethodBeat.m2504i(123008);
        C25052j.m39376p(member, "member");
        C8267a c8267a = BNI;
        if (c8267a == null) {
            c8267a = C25248a.m39823a(member);
            BNI = c8267a;
        }
        Method method = c8267a.BNK;
        if (method == null) {
            AppMethodBeat.m2505o(123008);
            return null;
        }
        Method method2 = c8267a.BNL;
        if (method2 == null) {
            AppMethodBeat.m2505o(123008);
            return null;
        }
        Object invoke = method.invoke(member, new Object[0]);
        C44941v c44941v;
        if (invoke == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<*>");
            AppMethodBeat.m2505o(123008);
            throw c44941v;
        }
        Object[] objArr = (Object[]) invoke;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object invoke2 : objArr) {
            Object invoke22 = method2.invoke(invoke22, new Object[0]);
            if (invoke22 == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.m2505o(123008);
                throw c44941v;
            }
            arrayList.add((String) invoke22);
        }
        List<String> list = (List) arrayList;
        AppMethodBeat.m2505o(123008);
        return list;
    }
}
