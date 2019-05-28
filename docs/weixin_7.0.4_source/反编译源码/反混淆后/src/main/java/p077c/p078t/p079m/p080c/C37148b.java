package p077c.p078t.p079m.p080c;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: c.t.m.c.b */
public class C37148b {
    /* renamed from: c */
    private static C37148b f15837c = null;
    /* renamed from: a */
    private Context f15838a;
    /* renamed from: b */
    private List<C44972a> f15839b = null;

    private C37148b(Context context) {
        AppMethodBeat.m2504i(136326);
        this.f15838a = context;
        this.f15839b = new ArrayList();
        AppMethodBeat.m2505o(136326);
    }

    /* renamed from: a */
    public static C37148b m62195a(Context context, List<C44972a> list) {
        AppMethodBeat.m2504i(136327);
        if (f15837c == null) {
            f15837c = new C37148b(context);
        }
        f15837c.m62196a(list);
        C37148b c37148b = f15837c;
        AppMethodBeat.m2505o(136327);
        return c37148b;
    }

    /* renamed from: a */
    private synchronized C37148b m62196a(List<C44972a> list) {
        AppMethodBeat.m2504i(136328);
        this.f15839b.clear();
        this.f15839b.addAll(list);
        AppMethodBeat.m2505o(136328);
        return this;
    }

    @TargetApi(3)
    /* renamed from: b */
    private synchronized DexClassLoader m62197b() {
        DexClassLoader dexClassLoader;
        AppMethodBeat.m2504i(136329);
        C0731l.m1682a(this.f15838a);
        if (this.f15839b == null || this.f15839b.size() <= 0) {
            AppMethodBeat.m2505o(136329);
            dexClassLoader = null;
        } else {
            C37150q.f15845b = C37150q.m62208a(this.f15839b);
            String str = this.f15838a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
            String str2 = this.f15838a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/odex";
            StringBuilder stringBuilder = new StringBuilder();
            for (C44972a c44972a : this.f15839b) {
                if (c44972a != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(File.separator);
                    stringBuilder.append(c44972a.f17711c);
                    stringBuilder.append(File.pathSeparator);
                }
            }
            try {
                System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(stringBuilder.toString(), str2, str, getClass().getClassLoader());
                C25383e.m40076a(this.f15838a).mo42397a("CPL", "suc:" + C37150q.f15845b);
                AppMethodBeat.m2505o(136329);
            } catch (Exception e) {
                C25383e.m40076a(this.f15838a).mo42397a("CPL", "fail:" + C37150q.f15845b + ",exc:" + e.toString());
                C0731l.m1682a(this.f15838a);
                System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(stringBuilder.toString(), str2, str, getClass().getClassLoader());
                C25383e.m40076a(this.f15838a).mo42397a("CPL", "suc:c" + C37150q.f15845b);
                AppMethodBeat.m2505o(136329);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(136329);
                dexClassLoader = null;
            }
        }
        return dexClassLoader;
    }

    /* renamed from: a */
    public DexClassLoader mo59230a() {
        AppMethodBeat.m2504i(136330);
        int i = 0;
        DexClassLoader dexClassLoader = null;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                break;
            }
            try {
                dexClassLoader = m62197b();
                C25383e.m40075a().mo42397a("CPL", "lcn:".concat(String.valueOf(i2)));
                if (dexClassLoader != null) {
                    AppMethodBeat.m2505o(136330);
                    break;
                }
                i = i2;
            } catch (Throwable th) {
                C25383e.m40075a().mo42397a("CPL", "fail:" + th.toString());
            }
        }
        AppMethodBeat.m2505o(136330);
        return dexClassLoader;
    }
}
