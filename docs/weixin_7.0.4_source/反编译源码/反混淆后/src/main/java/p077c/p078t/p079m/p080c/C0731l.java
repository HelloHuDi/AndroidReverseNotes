package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: c.t.m.c.l */
public class C0731l {
    /* renamed from: a */
    public static void m1682a(Context context) {
        AppMethodBeat.m2504i(136377);
        try {
            File file = new File(context.getFilesDir(), "TencentLocation/odex");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.canRead() && file.canWrite() && file.canExecute()) {
                C25383e.m40075a().mo42397a("DMK", "ods:ok");
                AppMethodBeat.m2505o(136377);
                return;
            }
            boolean readable = file.setReadable(true);
            C25383e.m40075a().mo42397a("DMK", "ods:" + file.setWritable(true) + "_" + readable + "_" + file.setExecutable(true));
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.canExecute()) {
                        C25383e.m40075a().mo42397a("DMK", "ofs:ok");
                    } else {
                        C25383e.m40075a().mo42397a("DMK", "ofs:" + file2.setWritable(true) + "_" + file2.setReadable(true) + "_" + file2.setExecutable(true));
                    }
                }
            }
            AppMethodBeat.m2505o(136377);
        } catch (Throwable th) {
            C25383e.m40075a().mo42397a("DMK", "exp:" + th.toString());
            AppMethodBeat.m2505o(136377);
        }
    }

    /* renamed from: b */
    public static boolean m1684b(Context context) {
        AppMethodBeat.m2504i(136378);
        if (C37150q.m62221b(context, "__SP_LAST_TencentLoc_COMP_SDK_VER__", "").equals(C37149i.f15840a)) {
            String b = C37150q.m62221b(context, "__SP_LAST_TencentLoc_COMP_INFO__", "");
            C25383e.m40076a(context).mo42397a("DBC", b);
            if (b == null || b.equals("")) {
                AppMethodBeat.m2505o(136378);
                return false;
            }
            List<C44972a> b2 = C37150q.m62222b(b);
            if (b2 == null || b2.isEmpty()) {
                AppMethodBeat.m2505o(136378);
                return false;
            }
            byte[] bArr = new byte[2048];
            String str = context.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/lastComp";
            List<C44972a> arrayList = new ArrayList();
            Object obj = 1;
            for (C44972a c44972a : b2) {
                if (C37150q.m62223b(context, str2 + File.separator + c44972a.f17711c, str, "tmp_backup_" + c44972a.f17711c, (long) c44972a.f17712d, bArr)) {
                    arrayList.add(c44972a);
                } else {
                    File file = new File(str + File.separator + "tmp_backup_" + c44972a.f17711c);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    obj = null;
                }
            }
            File file2;
            if (obj == null) {
                for (C44972a c44972a2 : arrayList) {
                    file2 = new File(str + File.separator + "tmp_backup_" + c44972a2.f17711c);
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
                arrayList.clear();
                AppMethodBeat.m2505o(136378);
                return false;
            } else if (b2.size() == arrayList.size()) {
                for (C44972a c44972a22 : arrayList) {
                    file2 = new File(str, c44972a22.f17711c);
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                    new File(str, "tmp_backup_" + c44972a22.f17711c).renameTo(file2);
                }
                String a = C37150q.m62208a((List) arrayList);
                C37150q.m62212a(context, "__SP_Tencent_Loc_COMP_INFO__", a);
                C25383e.m40076a(context).mo42397a("DBC", a);
                AppMethodBeat.m2505o(136378);
                return true;
            } else {
                AppMethodBeat.m2505o(136378);
                return false;
            }
        }
        AppMethodBeat.m2505o(136378);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static boolean m1685c(Context context) {
        Object obj;
        AppMethodBeat.m2504i(136379);
        String b = C37150q.m62219b(context);
        C37150q.m62233e(b);
        List<C44972a> b2 = C37150q.m62222b(C37150q.m62220b(context, "TencentLocationComp" + File.separator + "comp_list"));
        byte[] bArr = new byte[2048];
        ArrayList arrayList = new ArrayList();
        for (C44972a c44972a : b2) {
            String str = "TencentLocationComp" + File.separator + c44972a.f17711c;
            c44972a.f17711c += ".dex";
            String str2 = "tmp_asset_" + c44972a.f17711c;
            if (C37150q.m62213a(context, str, b, str2, (long) c44972a.f17712d, bArr)) {
                arrayList.add(c44972a);
            } else {
                File file = new File(b + File.separator + str2);
                if (file.exists() && file.isFile()) {
                    file.delete();
                    obj = null;
                } else {
                    obj = null;
                }
                Iterator it;
                File file2;
                if (obj != null) {
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        file2 = new File(b + File.separator + "tmp_asset_" + ((C44972a) it.next()).f17711c);
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    }
                    AppMethodBeat.m2505o(136379);
                    return false;
                } else if (arrayList.size() == b2.size()) {
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        C44972a c44972a2 = (C44972a) it.next();
                        file2 = new File(b, c44972a2.f17711c);
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                        new File(b, "tmp_asset_" + c44972a2.f17711c).renameTo(file2);
                    }
                    C37150q.m62212a(context, "__SP_Tencent_Loc_COMP_INFO__", C37150q.m62208a((List) b2));
                    AppMethodBeat.m2505o(136379);
                    return true;
                } else {
                    AppMethodBeat.m2505o(136379);
                    return false;
                }
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
        }
    }

    /* renamed from: a */
    public static boolean m1683a(List<C44972a> list, List<C44972a> list2) {
        AppMethodBeat.m2504i(136380);
        boolean z = true;
        for (C44972a c44972a : list) {
            Object obj;
            boolean z2;
            if (!c44972a.f17711c.contains(".dex")) {
                c44972a.f17711c += ".dex";
            }
            for (C44972a c44972a2 : list2) {
                if (!c44972a2.f17711c.contains(".dex")) {
                    c44972a2.f17711c += ".dex";
                }
                if (c44972a.f17711c.equals(c44972a2.f17711c) && c44972a.f17712d == c44972a2.f17712d && c44972a.f17713e.equals(c44972a2.f17713e)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                z2 = false;
            } else {
                z2 = z;
            }
            z = z2;
        }
        AppMethodBeat.m2505o(136380);
        return z;
    }
}
