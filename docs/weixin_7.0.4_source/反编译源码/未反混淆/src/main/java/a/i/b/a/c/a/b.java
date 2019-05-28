package a.i.b.a.c.a;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.b.a.c.b.ac;
import a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ServiceLoader;

public interface b {
    public static final a AZL = a.AZN;

    public static final class a {
        static final f AZM = i.a(k.PUBLICATION, a.AZO);
        static final /* synthetic */ a AZN = new a();
        static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(a.class), "Instance", "getInstance()Lorg/jetbrains/kotlin/builtins/BuiltInsLoader;"))};

        static final class a extends a.f.b.k implements a.f.a.a<b> {
            public static final a AZO = new a();

            static {
                AppMethodBeat.i(119070);
                AppMethodBeat.o(119070);
            }

            a() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119069);
                ServiceLoader load = ServiceLoader.load(b.class, b.class.getClassLoader());
                j.o(load, "implementations");
                b bVar = (b) a.a.t.f(load);
                if (bVar == null) {
                    Throwable illegalStateException = new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
                    AppMethodBeat.o(119069);
                    throw illegalStateException;
                }
                AppMethodBeat.o(119069);
                return bVar;
            }
        }

        static {
            AppMethodBeat.i(119071);
            AppMethodBeat.o(119071);
        }

        private a() {
        }
    }

    ac dXE();
}
