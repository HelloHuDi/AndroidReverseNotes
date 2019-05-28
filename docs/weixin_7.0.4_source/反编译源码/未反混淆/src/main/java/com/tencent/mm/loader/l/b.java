package com.tencent.mm.loader.l;

import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String eSG = (eSn + ".tmp");
    public static long eSH = 0;
    public static final String eSl = h.getExternalStorageDirectory().getAbsolutePath();
    public static final String eSn = (eSl + "/tencent/MicroMsg/");

    public static String Ur() {
        ab.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", eSG + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(eSG);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        return r0;
    }

    public static boolean Us() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - eSH > 86400000) {
            ab.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            eSH = currentTimeMillis;
            return true;
        }
        ab.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        return false;
    }
}
