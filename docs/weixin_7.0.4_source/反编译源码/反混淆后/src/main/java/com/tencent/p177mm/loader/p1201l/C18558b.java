package com.tencent.p177mm.loader.p1201l;

import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.loader.l.b */
public final class C18558b {
    public static final String eSG = (eSn + ".tmp");
    public static long eSH = 0;
    public static final String eSl = C1448h.getExternalStorageDirectory().getAbsolutePath();
    public static final String eSn = (eSl + "/tencent/MicroMsg/");

    /* renamed from: Ur */
    public static String m28879Ur() {
        C4990ab.m7411d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", eSG + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
        C5728b c5728b = new C5728b(eSG);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        return r0;
    }

    /* renamed from: Us */
    public static boolean m28880Us() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - eSH > 86400000) {
            C4990ab.m7410d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            eSH = currentTimeMillis;
            return true;
        }
        C4990ab.m7410d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        return false;
    }
}
