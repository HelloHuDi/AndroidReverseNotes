package p000a.p010i.p011b.p012a.p013a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H&¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, dWq = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.a.d */
public interface C36943d<M extends Member> {

    @C0220l(dWo = {1, 1, 13})
    /* renamed from: a.i.b.a.a.d$a */
    public static final class C36942a {
        /* renamed from: a */
        public static <M extends Member> void m61718a(C36943d<? extends M> c36943d, Object[] objArr) {
            AppMethodBeat.m2504i(118971);
            C25052j.m39376p(objArr, "args");
            if (C25069f.m39387a(c36943d) != objArr.length) {
                Throwable illegalArgumentException = new IllegalArgumentException("Callable expects " + C25069f.m39387a(c36943d) + " arguments, but " + objArr.length + " were provided.");
                AppMethodBeat.m2505o(118971);
                throw illegalArgumentException;
            }
            AppMethodBeat.m2505o(118971);
        }
    }

    /* renamed from: W */
    Object mo17818W(Object[] objArr);

    M dXw();

    Type dXx();

    List<Type> dXy();
}
