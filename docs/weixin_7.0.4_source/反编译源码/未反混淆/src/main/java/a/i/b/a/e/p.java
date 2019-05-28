package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.n;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.e.w.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaField;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaField;", "member", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "hasConstantNotNullInitializer", "", "getHasConstantNotNullInitializer", "()Z", "initializerValue", "", "getInitializerValue", "()Ljava/lang/Void;", "isEnumEntry", "getMember", "()Ljava/lang/reflect/Field;", "type", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "descriptors.runtime"})
public final class p extends r implements n {
    public final Field BOg;

    public p(Field field) {
        j.p(field, "member");
        AppMethodBeat.i(123097);
        this.BOg = field;
        AppMethodBeat.o(123097);
    }

    public final boolean ebS() {
        AppMethodBeat.i(123095);
        boolean isEnumConstant = this.BOg.isEnumConstant();
        AppMethodBeat.o(123095);
        return isEnumConstant;
    }

    public final /* synthetic */ v ebT() {
        AppMethodBeat.i(123096);
        a aVar = w.BOj;
        Type genericType = this.BOg.getGenericType();
        j.o(genericType, "member.genericType");
        v b = a.b(genericType);
        AppMethodBeat.o(123096);
        return b;
    }

    public final /* bridge */ /* synthetic */ Member dXw() {
        return this.BOg;
    }
}
