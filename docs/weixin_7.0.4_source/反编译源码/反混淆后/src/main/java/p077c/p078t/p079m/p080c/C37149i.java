package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: c.t.m.c.i */
public class C37149i {
    /* renamed from: a */
    public static String f15840a = "6.4.9";
    /* renamed from: c */
    private static C37149i f15841c = null;
    /* renamed from: b */
    private Context f15842b;
    /* renamed from: d */
    private List<C44972a> f15843d = new ArrayList();

    private C37149i(Context context) {
        AppMethodBeat.m2504i(136363);
        this.f15842b = context;
        AppMethodBeat.m2505o(136363);
    }

    /* renamed from: a */
    public static C37149i m62199a(Context context) {
        AppMethodBeat.m2504i(136364);
        if (f15841c == null) {
            synchronized (C37149i.class) {
                try {
                    if (f15841c == null) {
                        f15841c = new C37149i(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136364);
                    }
                }
            }
        }
        C37149i c37149i = f15841c;
        AppMethodBeat.m2505o(136364);
        return c37149i;
    }

    /* renamed from: a */
    public boolean mo59231a() {
        boolean z;
        AppMethodBeat.m2504i(136365);
        m62200b();
        String str = f15840a;
        String b = C37150q.m62221b(this.f15842b, "__Tencent_Cover_SDK_Version__", "");
        C25383e.m40076a(this.f15842b).mo42397a("DCV", b + "_" + str);
        if (!str.equals(b)) {
            System.currentTimeMillis();
            if (C0731l.m1685c(this.f15842b)) {
                C37150q.m62212a(this.f15842b, "__Tencent_Cover_SDK_Version__", str);
            } else {
                AppMethodBeat.m2505o(136365);
                return false;
            }
        }
        b = C37150q.m62221b(this.f15842b, "__SP_Tencent_Loc_COMP_INFO__", "");
        C25383e.m40076a(this.f15842b).mo42397a("DLC", b);
        this.f15843d = C37150q.m62222b(b);
        if (this.f15843d.size() == 0) {
            C25383e.m40076a(this.f15842b).mo42397a("DLC", "localComp parse error");
        }
        List<String> c = C37150q.m62228c(this.f15842b);
        if (c == null || c.size() == 0 || this.f15843d.size() == 0) {
            C25383e.m40076a(this.f15842b).mo42397a("DLC", "localComp file error");
            z = false;
        } else {
            System.currentTimeMillis();
            z = true;
            for (C44972a c44972a : this.f15843d) {
                int i;
                for (String split : c) {
                    String[] split2 = split.split(",");
                    if (split2.length == 2 && c44972a.f17711c.equals(split2[0]) && String.valueOf(c44972a.f17712d).equals(split2[1])) {
                        i = 1;
                        break;
                    }
                }
                boolean i2 = false;
                if (i2 == 0) {
                    i2 = false;
                } else {
                    i2 = z;
                }
                z = i2;
            }
        }
        if (!z) {
            C25383e.m40076a(this.f15842b).mo42397a("DCR", "goback");
            System.currentTimeMillis();
            if (!C0731l.m1684b(this.f15842b)) {
                C25383e.m40076a(this.f15842b).mo42397a("DCR", "copy from asset");
                if (C0731l.m1685c(this.f15842b)) {
                    C37150q.m62212a(this.f15842b, "__Tencent_Cover_SDK_Version__", str);
                } else {
                    C25383e.m40076a(this.f15842b).mo42397a("DCR", "copy from asset failed");
                    AppMethodBeat.m2505o(136365);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(136365);
        return true;
    }

    /* renamed from: b */
    private void m62200b() {
        AppMethodBeat.m2504i(136366);
        File file = new File(this.f15842b.getFilesDir(), "TencentLocation/comp");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.f15842b.getFilesDir(), "TencentLocation/odex");
        if (!file.exists()) {
            file.mkdirs();
        }
        C0731l.m1682a(this.f15842b);
        AppMethodBeat.m2505o(136366);
    }
}
