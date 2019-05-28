package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p049e.C37076b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, dWq = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.ae */
public final class C44862ae {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: a.i.b.a.ae$a */
    static final class C31603a extends C25053k implements C17126b<Class<?>, String> {
        public static final C31603a AYD = new C31603a();

        static {
            AppMethodBeat.m2504i(118932);
            AppMethodBeat.m2505o(118932);
        }

        C31603a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(118931);
            Class cls = (Class) obj;
            C25052j.m39375o(cls, "it");
            String bc = C37076b.m62037bc(cls);
            AppMethodBeat.m2505o(118931);
            return bc;
        }
    }

    /* renamed from: d */
    static final String m82059d(Method method) {
        AppMethodBeat.m2504i(118933);
        StringBuilder append = new StringBuilder().append(method.getName());
        Class[] parameterTypes = method.getParameterTypes();
        C25052j.m39375o(parameterTypes, "parameterTypes");
        StringBuilder append2 = append.append(C36913i.m61690a((Object[]) parameterTypes, (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, null, (C17126b) C31603a.AYD, 24));
        Class returnType = method.getReturnType();
        C25052j.m39375o(returnType, "returnType");
        String stringBuilder = append2.append(C37076b.m62037bc(returnType)).toString();
        AppMethodBeat.m2505o(118933);
        return stringBuilder;
    }
}
