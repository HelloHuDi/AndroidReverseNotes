package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: c.t.m.c.h */
public class C31902h {
    /* renamed from: a */
    private Context f14659a;

    public C31902h(Context context) {
        this.f14659a = context;
    }

    /* renamed from: a */
    public void mo52015a() {
        AppMethodBeat.m2504i(136360);
        String str = "backup";
        if (C17500d.m27317a(this.f14659a).mo31932a(str)) {
            Object obj;
            C44972a c44972a;
            mo52016b();
            List<String> c = m51760c();
            Object obj2 = 1;
            List<C44972a> b = C37150q.m62222b(C37150q.m62221b(this.f14659a, "__SP_Tencent_Loc_COMP_INFO__", ""));
            if (c != null && c.size() != 0 && b.size() != 0) {
                Iterator it = b.iterator();
                while (true) {
                    obj = obj2;
                    if (!it.hasNext()) {
                        break;
                    }
                    c44972a = (C44972a) it.next();
                    for (String split : c) {
                        String[] split2 = split.split(",");
                        if (split2.length == 3 && c44972a.f17711c.equals(split2[0]) && String.valueOf(c44972a.f17712d).equals(split2[1]) && c44972a.f17713e.equals(split2[2])) {
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
                String str2 = this.f14659a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
                String str3 = this.f14659a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/lastComp";
                List<C44972a> arrayList = new ArrayList();
                Object obj3 = null;
                for (C44972a c44972a2 : b) {
                    File file2 = new File(str3, c44972a2.f17711c);
                    if (file2.exists()) {
                        if (c44972a2.f17713e.equals(C37150q.m62206a(file2))) {
                        }
                    }
                    if (C37150q.m62223b(this.f14659a, str2 + File.separator + c44972a2.f17711c, str3, "tmp_" + c44972a2.f17711c, (long) c44972a2.f17712d, bArr)) {
                        arrayList.add(c44972a2);
                    } else {
                        file = new File(str3 + File.separator + "tmp_" + c44972a2.f17711c);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        obj3 = 1;
                    }
                }
                if (obj3 != null) {
                    for (C44972a c44972a3 : arrayList) {
                        file = new File(str3 + File.separator + "tmp_" + c44972a3.f17711c);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                } else if (b.size() == arrayList.size()) {
                    for (C44972a c44972a32 : arrayList) {
                        file = new File(str3, c44972a32.f17711c);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        new File(str3, "tmp_" + c44972a32.f17711c).renameTo(file);
                    }
                    C37150q.m62212a(this.f14659a, "__SP_LAST_TencentLoc_COMP_INFO__", C37150q.m62208a((List) arrayList));
                    C37150q.m62212a(this.f14659a, "__SP_LAST_TencentLoc_COMP_SDK_VER__", C37149i.f15840a);
                }
            }
            C17500d.m27317a(this.f14659a).mo31933b(str);
            AppMethodBeat.m2505o(136360);
            return;
        }
        AppMethodBeat.m2505o(136360);
    }

    /* renamed from: b */
    public void mo52016b() {
        AppMethodBeat.m2504i(136361);
        File file = new File(this.f14659a.getFilesDir(), "TencentLocation/lastComp");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(136361);
    }

    /* renamed from: c */
    private List<String> m51760c() {
        AppMethodBeat.m2504i(136362);
        File file = new File(this.f14659a.getFilesDir(), "TencentLocation/comp");
        List<String> list = null;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                list = new ArrayList();
                for (File file2 : listFiles) {
                    list.add(file2.getName() + "," + file2.length() + "," + C37150q.m62206a(file2));
                }
            }
        }
        AppMethodBeat.m2505o(136362);
        return list;
    }
}
