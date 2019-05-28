package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: c.t.m.c.f */
public class C8477f {
    /* renamed from: a */
    private static DexClassLoader f2415a;
    /* renamed from: b */
    private static Context f2416b;
    /* renamed from: c */
    private static C8477f f2417c;

    private C8477f(Context context) {
        AppMethodBeat.m2504i(136354);
        f2416b = context;
        C25385n.m40087a(context).mo42404a();
        C25383e.m40076a(context).mo42399b();
        AppMethodBeat.m2505o(136354);
    }

    /* renamed from: a */
    public static C8477f m15035a(Context context) {
        AppMethodBeat.m2504i(136355);
        if (f2417c == null) {
            synchronized (C8477f.class) {
                try {
                    if (f2417c == null) {
                        f2417c = new C8477f(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136355);
                    }
                }
            }
        }
        C8477f c8477f = f2417c;
        AppMethodBeat.m2505o(136355);
        return c8477f;
    }

    /* renamed from: a */
    public synchronized DexClassLoader mo18530a() {
        DexClassLoader dexClassLoader;
        AppMethodBeat.m2504i(136356);
        if (f2415a != null) {
            dexClassLoader = f2415a;
            AppMethodBeat.m2505o(136356);
        } else if (f2416b == null) {
            dexClassLoader = null;
            AppMethodBeat.m2505o(136356);
        } else {
            C37150q.f15846c = System.currentTimeMillis();
            C17500d.m27317a(f2416b).mo31932a("load");
            ArrayList arrayList = new ArrayList();
            if (C37149i.m62199a(f2416b).mo59231a()) {
                System.currentTimeMillis();
                C0730g.m1680a(f2416b).mo2176a();
                List b = C37150q.m62222b(C37150q.m62221b(f2416b, "__SP_Tencent_Loc_COMP_INFO__", ""));
                System.currentTimeMillis();
                f2415a = C37148b.m62195a(f2416b, b).mo59230a();
            }
            C17500d.m27317a(f2416b).mo31933b("load");
            if (f2415a != null) {
                C25383e.m40076a(f2416b).mo42401d();
            }
            mo18531b();
            dexClassLoader = f2415a;
            AppMethodBeat.m2505o(136356);
        }
        return dexClassLoader;
    }

    /* renamed from: b */
    public void mo18531b() {
        AppMethodBeat.m2504i(136357);
        try {
            new Thread(new C31903j(f2416b, C37150q.m62222b(C37150q.m62221b(f2416b, "__SP_Tencent_Loc_COMP_INFO__", "")), false)).start();
            AppMethodBeat.m2505o(136357);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136357);
        }
    }
}
