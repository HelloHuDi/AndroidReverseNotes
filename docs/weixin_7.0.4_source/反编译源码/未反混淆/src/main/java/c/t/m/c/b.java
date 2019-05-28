package c.t.m.c;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class b {
    private static b c = null;
    private Context a;
    private List<a> b = null;

    private b(Context context) {
        AppMethodBeat.i(136326);
        this.a = context;
        this.b = new ArrayList();
        AppMethodBeat.o(136326);
    }

    public static b a(Context context, List<a> list) {
        AppMethodBeat.i(136327);
        if (c == null) {
            c = new b(context);
        }
        c.a(list);
        b bVar = c;
        AppMethodBeat.o(136327);
        return bVar;
    }

    private synchronized b a(List<a> list) {
        AppMethodBeat.i(136328);
        this.b.clear();
        this.b.addAll(list);
        AppMethodBeat.o(136328);
        return this;
    }

    @TargetApi(3)
    private synchronized DexClassLoader b() {
        DexClassLoader dexClassLoader;
        AppMethodBeat.i(136329);
        l.a(this.a);
        if (this.b == null || this.b.size() <= 0) {
            AppMethodBeat.o(136329);
            dexClassLoader = null;
        } else {
            q.b = q.a(this.b);
            String str = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
            String str2 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/odex";
            StringBuilder stringBuilder = new StringBuilder();
            for (a aVar : this.b) {
                if (aVar != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(File.separator);
                    stringBuilder.append(aVar.c);
                    stringBuilder.append(File.pathSeparator);
                }
            }
            try {
                System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(stringBuilder.toString(), str2, str, getClass().getClassLoader());
                e.a(this.a).a("CPL", "suc:" + q.b);
                AppMethodBeat.o(136329);
            } catch (Exception e) {
                e.a(this.a).a("CPL", "fail:" + q.b + ",exc:" + e.toString());
                l.a(this.a);
                System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(stringBuilder.toString(), str2, str, getClass().getClassLoader());
                e.a(this.a).a("CPL", "suc:c" + q.b);
                AppMethodBeat.o(136329);
            } catch (Throwable th) {
                AppMethodBeat.o(136329);
                dexClassLoader = null;
            }
        }
        return dexClassLoader;
    }

    public DexClassLoader a() {
        AppMethodBeat.i(136330);
        int i = 0;
        DexClassLoader dexClassLoader = null;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                break;
            }
            try {
                dexClassLoader = b();
                e.a().a("CPL", "lcn:".concat(String.valueOf(i2)));
                if (dexClassLoader != null) {
                    AppMethodBeat.o(136330);
                    break;
                }
                i = i2;
            } catch (Throwable th) {
                e.a().a("CPL", "fail:" + th.toString());
            }
        }
        AppMethodBeat.o(136330);
        return dexClassLoader;
    }
}
