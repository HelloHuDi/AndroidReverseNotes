package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

public class g {
    private static g a = null;
    private Context b;

    private g(Context context) {
        this.b = context;
    }

    public static g a(Context context) {
        AppMethodBeat.i(136358);
        if (a == null) {
            synchronized (g.class) {
                try {
                    if (a == null) {
                        a = new g(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136358);
                    }
                }
            }
        }
        g gVar = a;
        AppMethodBeat.o(136358);
        return gVar;
    }

    public int a() {
        AppMethodBeat.i(136359);
        String b = q.b(this.b, "__bad_dex_info__", "preference_default");
        List b2 = q.b(b);
        if (b.equals("preference_default") || b2.isEmpty()) {
            AppMethodBeat.o(136359);
            return 0;
        }
        e.a(this.b).a("DGB", "badDex:".concat(String.valueOf(b)));
        List b3 = q.b(q.b(this.b, "__SP_Tencent_Loc_COMP_INFO__", ""));
        b3.isEmpty();
        if (b3.isEmpty() || l.a(b3, b2)) {
            List b4 = q.b(q.b(this.b, "TencentLocationComp" + File.separator + "comp_list"));
            b4.isEmpty();
            if (!l.a(b4, b2)) {
                e.a(this.b).a("DGB", "brun<5min");
                l.c(this.b);
                AppMethodBeat.o(136359);
                return 2;
            } else if (q.b(this.b, "__loc_sdk_run_duration__", Long.valueOf(0)).longValue() < 300000) {
                e.a(this.b).a("DGB", "brun<5min");
                new Thread(new j(this.b, b2, true)).start();
                AppMethodBeat.o(136359);
                return 1;
            } else {
                e.a(this.b).a("DGB", "brun>5min");
                new Thread(new j(this.b, b2, true)).start();
                AppMethodBeat.o(136359);
                return 4;
            }
        }
        e.a(this.b).a("DGB", "local is ok");
        AppMethodBeat.o(136359);
        return 0;
    }
}
