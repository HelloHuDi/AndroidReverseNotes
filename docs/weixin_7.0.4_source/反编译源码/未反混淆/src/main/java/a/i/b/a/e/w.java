package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.v;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "()V", "reflectType", "Ljava/lang/reflect/Type;", "getReflectType", "()Ljava/lang/reflect/Type;", "equals", "", "other", "", "hashCode", "", "toString", "", "Factory", "descriptors.runtime"})
public abstract class w implements v {
    public static final a BOj = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "type", "Ljava/lang/reflect/Type;", "descriptors.runtime"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static w b(Type type) {
            AppMethodBeat.i(123116);
            j.p(type, "type");
            w vVar;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                vVar = new v((Class) type);
                AppMethodBeat.o(123116);
                return vVar;
            } else if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                vVar = new i(type);
                AppMethodBeat.o(123116);
                return vVar;
            } else if (type instanceof WildcardType) {
                vVar = new z((WildcardType) type);
                AppMethodBeat.o(123116);
                return vVar;
            } else {
                vVar = new l(type);
                AppMethodBeat.o(123116);
                return vVar;
            }
        }
    }

    public abstract Type ekI();

    public boolean equals(Object obj) {
        return (obj instanceof w) && j.j(ekI(), ((w) obj).ekI());
    }

    public int hashCode() {
        return ekI().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + ekI();
    }
}
