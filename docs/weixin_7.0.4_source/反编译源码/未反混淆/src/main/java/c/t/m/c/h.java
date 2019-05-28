package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h {
    private Context a;

    public h(Context context) {
        this.a = context;
    }

    public void a() {
        AppMethodBeat.i(136360);
        String str = "backup";
        if (d.a(this.a).a(str)) {
            Object obj;
            a aVar;
            b();
            List<String> c = c();
            Object obj2 = 1;
            List<a> b = q.b(q.b(this.a, "__SP_Tencent_Loc_COMP_INFO__", ""));
            if (c != null && c.size() != 0 && b.size() != 0) {
                Iterator it = b.iterator();
                while (true) {
                    obj = obj2;
                    if (!it.hasNext()) {
                        break;
                    }
                    aVar = (a) it.next();
                    for (String split : c) {
                        String[] split2 = split.split(",");
                        if (split2.length == 3 && aVar.c.equals(split2[0]) && String.valueOf(aVar.d).equals(split2[1]) && aVar.e.equals(split2[2])) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        obj2 = null;
                    } else {
                        obj2 = obj;
                    }
                }
            } else {
                obj = null;
            }
            if (obj != null) {
                File file;
                byte[] bArr = new byte[2048];
                String str2 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
                String str3 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/lastComp";
                List<a> arrayList = new ArrayList();
                Object obj3 = null;
                for (a aVar2 : b) {
                    File file2 = new File(str3, aVar2.c);
                    if (file2.exists()) {
                        if (aVar2.e.equals(q.a(file2))) {
                        }
                    }
                    if (q.b(this.a, str2 + File.separator + aVar2.c, str3, "tmp_" + aVar2.c, (long) aVar2.d, bArr)) {
                        arrayList.add(aVar2);
                    } else {
                        file = new File(str3 + File.separator + "tmp_" + aVar2.c);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        obj3 = 1;
                    }
                }
                if (obj3 != null) {
                    for (a aVar3 : arrayList) {
                        file = new File(str3 + File.separator + "tmp_" + aVar3.c);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                } else if (b.size() == arrayList.size()) {
                    for (a aVar32 : arrayList) {
                        file = new File(str3, aVar32.c);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        new File(str3, "tmp_" + aVar32.c).renameTo(file);
                    }
                    q.a(this.a, "__SP_LAST_TencentLoc_COMP_INFO__", q.a((List) arrayList));
                    q.a(this.a, "__SP_LAST_TencentLoc_COMP_SDK_VER__", i.a);
                }
            }
            d.a(this.a).b(str);
            AppMethodBeat.o(136360);
            return;
        }
        AppMethodBeat.o(136360);
    }

    public void b() {
        AppMethodBeat.i(136361);
        File file = new File(this.a.getFilesDir(), "TencentLocation/lastComp");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(136361);
    }

    private List<String> c() {
        AppMethodBeat.i(136362);
        File file = new File(this.a.getFilesDir(), "TencentLocation/comp");
        List<String> list = null;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                list = new ArrayList();
                for (File file2 : listFiles) {
                    list.add(file2.getName() + "," + file2.length() + "," + q.a(file2));
                }
            }
        }
        AppMethodBeat.o(136362);
        return list;
    }
}
