package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8117n;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p049e.C31793w.C25256a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaField;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaField;", "member", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "hasConstantNotNullInitializer", "", "getHasConstantNotNullInitializer", "()Z", "initializerValue", "", "getInitializerValue", "()Ljava/lang/Void;", "isEnumEntry", "getMember", "()Ljava/lang/reflect/Field;", "type", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.p */
public final class C0177p extends C17334r implements C8117n {
    public final Field BOg;

    public C0177p(Field field) {
        C25052j.m39376p(field, "member");
        AppMethodBeat.m2504i(123097);
        this.BOg = field;
        AppMethodBeat.m2505o(123097);
    }

    public final boolean ebS() {
        AppMethodBeat.m2504i(123095);
        boolean isEnumConstant = this.BOg.isEnumConstant();
        AppMethodBeat.m2505o(123095);
        return isEnumConstant;
    }

    public final /* synthetic */ C8118v ebT() {
        AppMethodBeat.m2504i(123096);
        C25256a c25256a = C31793w.BOj;
        Type genericType = this.BOg.getGenericType();
        C25052j.m39375o(genericType, "member.genericType");
        C8118v b = C25256a.m39831b(genericType);
        AppMethodBeat.m2505o(123096);
        return b;
    }

    public final /* bridge */ /* synthetic */ Member dXw() {
        return this.BOg;
    }
}
