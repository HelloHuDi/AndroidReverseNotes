package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class i {
    public static String a = "6.4.9";
    private static i c = null;
    private Context b;
    private List<a> d = new ArrayList();

    private i(Context context) {
        AppMethodBeat.i(136363);
        this.b = context;
        AppMethodBeat.o(136363);
    }

    public static i a(Context context) {
        AppMethodBeat.i(136364);
        if (c == null) {
            synchronized (i.class) {
                try {
                    if (c == null) {
                        c = new i(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136364);
                    }
                }
            }
        }
        i iVar = c;
        AppMethodBeat.o(136364);
        return iVar;
    }

    public boolean a() {
        boolean z;
        AppMethodBeat.i(136365);
        b();
        String str = a;
        String b = q.b(this.b, "__Tencent_Cover_SDK_Version__", "");
        e.a(this.b).a("DCV", b + "_" + str);
        if (!str.equals(b)) {
            System.currentTimeMillis();
            if (l.c(this.b)) {
                q.a(this.b, "__Tencent_Cover_SDK_Version__", str);
            } else {
                AppMethodBeat.o(136365);
                return false;
            }
        }
        b = q.b(this.b, "__SP_Tencent_Loc_COMP_INFO__", "");
        e.a(this.b).a("DLC", b);
        this.d = q.b(b);
        if (this.d.size() == 0) {
            e.a(this.b).a("DLC", "localComp parse error");
        }
        List<String> c = q.c(this.b);
        if (c == null || c.size() == 0 || this.d.size() == 0) {
            e.a(this.b).a("DLC", "localComp file error");
            z = false;
        } else {
            System.currentTimeMillis();
            z = true;
            for (a aVar : this.d) {
                int i;
                for (String split : c) {
                    String[] split2 = split.split(",");
                    if (split2.length == 2 && aVar.c.equals(split2[0]) && String.valueOf(aVar.d).equals(split2[1])) {
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
            e.a(this.b).a("DCR", "goback");
            System.currentTimeMillis();
            if (!l.b(this.b)) {
                e.a(this.b).a("DCR", "copy from asset");
                if (l.c(this.b)) {
                    q.a(this.b, "__Tencent_Cover_SDK_Version__", str);
                } else {
                    e.a(this.b).a("DCR", "copy from asset failed");
                    AppMethodBeat.o(136365);
                    return false;
                }
            }
        }
        AppMethodBeat.o(136365);
        return true;
    }

    private void b() {
        AppMethodBeat.i(136366);
        File file = new File(this.b.getFilesDir(), "TencentLocation/comp");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.b.getFilesDir(), "TencentLocation/odex");
        if (!file.exists()) {
            file.mkdirs();
        }
        l.a(this.b);
        AppMethodBeat.o(136366);
    }
}
