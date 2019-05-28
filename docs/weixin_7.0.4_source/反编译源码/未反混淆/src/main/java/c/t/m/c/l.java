package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l {
    public static void a(Context context) {
        AppMethodBeat.i(136377);
        try {
            File file = new File(context.getFilesDir(), "TencentLocation/odex");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.canRead() && file.canWrite() && file.canExecute()) {
                e.a().a("DMK", "ods:ok");
                AppMethodBeat.o(136377);
                return;
            }
            boolean readable = file.setReadable(true);
            e.a().a("DMK", "ods:" + file.setWritable(true) + "_" + readable + "_" + file.setExecutable(true));
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.canExecute()) {
                        e.a().a("DMK", "ofs:ok");
                    } else {
                        e.a().a("DMK", "ofs:" + file2.setWritable(true) + "_" + file2.setReadable(true) + "_" + file2.setExecutable(true));
                    }
                }
            }
            AppMethodBeat.o(136377);
        } catch (Throwable th) {
            e.a().a("DMK", "exp:" + th.toString());
            AppMethodBeat.o(136377);
        }
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(136378);
        if (q.b(context, "__SP_LAST_TencentLoc_COMP_SDK_VER__", "").equals(i.a)) {
            String b = q.b(context, "__SP_LAST_TencentLoc_COMP_INFO__", "");
            e.a(context).a("DBC", b);
            if (b == null || b.equals("")) {
                AppMethodBeat.o(136378);
                return false;
            }
            List<a> b2 = q.b(b);
            if (b2 == null || b2.isEmpty()) {
                AppMethodBeat.o(136378);
                return false;
            }
            byte[] bArr = new byte[2048];
            String str = context.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/lastComp";
            List<a> arrayList = new ArrayList();
            Object obj = 1;
            for (a aVar : b2) {
                if (q.b(context, str2 + File.separator + aVar.c, str, "tmp_backup_" + aVar.c, (long) aVar.d, bArr)) {
                    arrayList.add(aVar);
                } else {
                    File file = new File(str + File.separator + "tmp_backup_" + aVar.c);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    obj = null;
                }
            }
            File file2;
            if (obj == null) {
                for (a aVar2 : arrayList) {
                    file2 = new File(str + File.separator + "tmp_backup_" + aVar2.c);
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
                arrayList.clear();
                AppMethodBeat.o(136378);
                return false;
            } else if (b2.size() == arrayList.size()) {
                for (a aVar22 : arrayList) {
                    file2 = new File(str, aVar22.c);
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                    new File(str, "tmp_backup_" + aVar22.c).renameTo(file2);
                }
                String a = q.a((List) arrayList);
                q.a(context, "__SP_Tencent_Loc_COMP_INFO__", a);
                e.a(context).a("DBC", a);
                AppMethodBeat.o(136378);
                return true;
            } else {
                AppMethodBeat.o(136378);
                return false;
            }
        }
        AppMethodBeat.o(136378);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(Context context) {
        Object obj;
        AppMethodBeat.i(136379);
        String b = q.b(context);
        q.e(b);
        List<a> b2 = q.b(q.b(context, "TencentLocationComp" + File.separator + "comp_list"));
        byte[] bArr = new byte[2048];
        ArrayList arrayList = new ArrayList();
        for (a aVar : b2) {
            String str = "TencentLocationComp" + File.separator + aVar.c;
            aVar.c += ".dex";
            String str2 = "tmp_asset_" + aVar.c;
            if (q.a(context, str, b, str2, (long) aVar.d, bArr)) {
                arrayList.add(aVar);
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
                        file2 = new File(b + File.separator + "tmp_asset_" + ((a) it.next()).c);
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    }
                    AppMethodBeat.o(136379);
                    return false;
                } else if (arrayList.size() == b2.size()) {
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        a aVar2 = (a) it.next();
                        file2 = new File(b, aVar2.c);
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                        new File(b, "tmp_asset_" + aVar2.c).renameTo(file2);
                    }
                    q.a(context, "__SP_Tencent_Loc_COMP_INFO__", q.a((List) b2));
                    AppMethodBeat.o(136379);
                    return true;
                } else {
                    AppMethodBeat.o(136379);
                    return false;
                }
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
        }
    }

    public static boolean a(List<a> list, List<a> list2) {
        AppMethodBeat.i(136380);
        boolean z = true;
        for (a aVar : list) {
            Object obj;
            boolean z2;
            if (!aVar.c.contains(".dex")) {
                aVar.c += ".dex";
            }
            for (a aVar2 : list2) {
                if (!aVar2.c.contains(".dex")) {
                    aVar2.c += ".dex";
                }
                if (aVar.c.equals(aVar2.c) && aVar.d == aVar2.d && aVar.e.equals(aVar2.e)) {
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
        AppMethodBeat.o(136380);
        return z;
    }
}
