package p000a.p010i.p011b.p012a.p013a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.a.i */
public final class C17142i implements C36943d {
    public static final C17142i AZo = new C17142i();

    static {
        AppMethodBeat.m2504i(119018);
        AppMethodBeat.m2505o(119018);
    }

    private C17142i() {
    }

    public final /* bridge */ /* synthetic */ Member dXw() {
        return null;
    }

    public final Type dXx() {
        AppMethodBeat.m2504i(119016);
        Class cls = Void.TYPE;
        C25052j.m39375o(cls, "Void.TYPE");
        Type type = cls;
        AppMethodBeat.m2505o(119016);
        return type;
    }

    /* renamed from: W */
    public final Object mo17818W(Object[] objArr) {
        AppMethodBeat.m2504i(119017);
        C25052j.m39376p(objArr, "args");
        Throwable unsupportedOperationException = new UnsupportedOperationException("call/callBy are not supported for this declaration.");
        AppMethodBeat.m2505o(119017);
        throw unsupportedOperationException;
    }

    public final List<Type> dXy() {
        return C17115v.AUP;
    }
}
