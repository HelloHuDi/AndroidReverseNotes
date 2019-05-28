package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "()V", "reflectType", "Ljava/lang/reflect/Type;", "getReflectType", "()Ljava/lang/reflect/Type;", "equals", "", "other", "", "hashCode", "", "toString", "", "Factory", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.w */
public abstract class C31793w implements C8118v {
    public static final C25256a BOj = new C25256a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "type", "Ljava/lang/reflect/Type;", "descriptors.runtime"})
    /* renamed from: a.i.b.a.e.w$a */
    public static final class C25256a {
        private C25256a() {
        }

        public /* synthetic */ C25256a(byte b) {
            this();
        }

        /* renamed from: b */
        public static C31793w m39831b(Type type) {
            AppMethodBeat.m2504i(123116);
            C25052j.m39376p(type, "type");
            C31793w c36662v;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                c36662v = new C36662v((Class) type);
                AppMethodBeat.m2505o(123116);
                return c36662v;
            } else if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                c36662v = new C8271i(type);
                AppMethodBeat.m2505o(123116);
                return c36662v;
            } else if (type instanceof WildcardType) {
                c36662v = new C25258z((WildcardType) type);
                AppMethodBeat.m2505o(123116);
                return c36662v;
            } else {
                c36662v = new C36660l(type);
                AppMethodBeat.m2505o(123116);
                return c36662v;
            }
        }
    }

    public abstract Type ekI();

    public boolean equals(Object obj) {
        return (obj instanceof C31793w) && C25052j.m39373j(ekI(), ((C31793w) obj).ekI());
    }

    public int hashCode() {
        return ekI().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + ekI();
    }
}
