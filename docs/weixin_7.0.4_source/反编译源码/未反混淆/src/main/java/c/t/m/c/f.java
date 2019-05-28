package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

public class f {
    private static DexClassLoader a;
    private static Context b;
    private static f c;

    private f(Context context) {
        AppMethodBeat.i(136354);
        b = context;
        n.a(context).a();
        e.a(context).b();
        AppMethodBeat.o(136354);
    }

    public static f a(Context context) {
        AppMethodBeat.i(136355);
        if (c == null) {
            synchronized (f.class) {
                try {
                    if (c == null) {
                        c = new f(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136355);
                    }
                }
            }
        }
        f fVar = c;
        AppMethodBeat.o(136355);
        return fVar;
    }

    public synchronized DexClassLoader a() {
        DexClassLoader dexClassLoader;
        AppMethodBeat.i(136356);
        if (a != null) {
            dexClassLoader = a;
            AppMethodBeat.o(136356);
        } else if (b == null) {
            dexClassLoader = null;
            AppMethodBeat.o(136356);
        } else {
            q.c = System.currentTimeMillis();
            d.a(b).a("load");
            ArrayList arrayList = new ArrayList();
            if (i.a(b).a()) {
                System.currentTimeMillis();
                g.a(b).a();
                List b = q.b(q.b(b, "__SP_Tencent_Loc_COMP_INFO__", ""));
                System.currentTimeMillis();
                a = b.a(b, b).a();
            }
            d.a(b).b("load");
            if (a != null) {
                e.a(b).d();
            }
            b();
            dexClassLoader = a;
            AppMethodBeat.o(136356);
        }
        return dexClassLoader;
    }

    public void b() {
        AppMethodBeat.i(136357);
        try {
            new Thread(new j(b, q.b(q.b(b, "__SP_Tencent_Loc_COMP_INFO__", "")), false)).start();
            AppMethodBeat.o(136357);
        } catch (Throwable th) {
            AppMethodBeat.o(136357);
        }
    }
}
