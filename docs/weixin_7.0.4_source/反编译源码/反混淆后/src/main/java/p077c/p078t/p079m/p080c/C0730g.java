package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

/* renamed from: c.t.m.c.g */
public class C0730g {
    /* renamed from: a */
    private static C0730g f1024a = null;
    /* renamed from: b */
    private Context f1025b;

    private C0730g(Context context) {
        this.f1025b = context;
    }

    /* renamed from: a */
    public static C0730g m1680a(Context context) {
        AppMethodBeat.m2504i(136358);
        if (f1024a == null) {
            synchronized (C0730g.class) {
                try {
                    if (f1024a == null) {
                        f1024a = new C0730g(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136358);
                    }
                }
            }
        }
        C0730g c0730g = f1024a;
        AppMethodBeat.m2505o(136358);
        return c0730g;
    }

    /* renamed from: a */
    public int mo2176a() {
        AppMethodBeat.m2504i(136359);
        String b = C37150q.m62221b(this.f1025b, "__bad_dex_info__", "preference_default");
        List b2 = C37150q.m62222b(b);
        if (b.equals("preference_default") || b2.isEmpty()) {
            AppMethodBeat.m2505o(136359);
            return 0;
        }
        C25383e.m40076a(this.f1025b).mo42397a("DGB", "badDex:".concat(String.valueOf(b)));
        List b3 = C37150q.m62222b(C37150q.m62221b(this.f1025b, "__SP_Tencent_Loc_COMP_INFO__", ""));
        b3.isEmpty();
        if (b3.isEmpty() || C0731l.m1683a(b3, b2)) {
            List b4 = C37150q.m62222b(C37150q.m62220b(this.f1025b, "TencentLocationComp" + File.separator + "comp_list"));
            b4.isEmpty();
            if (!C0731l.m1683a(b4, b2)) {
                C25383e.m40076a(this.f1025b).mo42397a("DGB", "brun<5min");
                C0731l.m1685c(this.f1025b);
                AppMethodBeat.m2505o(136359);
                return 2;
            } else if (C37150q.m62217b(this.f1025b, "__loc_sdk_run_duration__", Long.valueOf(0)).longValue() < 300000) {
                C25383e.m40076a(this.f1025b).mo42397a("DGB", "brun<5min");
                new Thread(new C31903j(this.f1025b, b2, true)).start();
                AppMethodBeat.m2505o(136359);
                return 1;
            } else {
                C25383e.m40076a(this.f1025b).mo42397a("DGB", "brun>5min");
                new Thread(new C31903j(this.f1025b, b2, true)).start();
                AppMethodBeat.m2505o(136359);
                return 4;
            }
        }
        C25383e.m40076a(this.f1025b).mo42397a("DGB", "local is ok");
        AppMethodBeat.m2505o(136359);
        return 0;
    }
}
