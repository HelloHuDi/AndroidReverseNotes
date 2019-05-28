package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ServiceLoader;
import p000a.C0219k;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C44871ac;

/* renamed from: a.i.b.a.c.a.b */
public interface C8032b {
    public static final C0021a AZL = C0021a.AZN;

    /* renamed from: a.i.b.a.c.a.b$a */
    public static final class C0021a {
        static final C44856f AZM = C17344i.m26853a(C0219k.PUBLICATION, C0020a.AZO);
        static final /* synthetic */ C0021a AZN = new C0021a();
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C0021a.class), "Instance", "getInstance()Lorg/jetbrains/kotlin/builtins/BuiltInsLoader;"))};

        /* renamed from: a.i.b.a.c.a.b$a$a */
        static final class C0020a extends C25053k implements C31214a<C8032b> {
            public static final C0020a AZO = new C0020a();

            static {
                AppMethodBeat.m2504i(119070);
                AppMethodBeat.m2505o(119070);
            }

            C0020a() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(119069);
                ServiceLoader load = ServiceLoader.load(C8032b.class, C8032b.class.getClassLoader());
                C25052j.m39375o(load, "implementations");
                C8032b c8032b = (C8032b) C25035t.m39336f(load);
                if (c8032b == null) {
                    Throwable illegalStateException = new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
                    AppMethodBeat.m2505o(119069);
                    throw illegalStateException;
                }
                AppMethodBeat.m2505o(119069);
                return c8032b;
            }
        }

        static {
            AppMethodBeat.m2504i(119071);
            AppMethodBeat.m2505o(119071);
        }

        private C0021a() {
        }
    }

    C44871ac dXE();
}
