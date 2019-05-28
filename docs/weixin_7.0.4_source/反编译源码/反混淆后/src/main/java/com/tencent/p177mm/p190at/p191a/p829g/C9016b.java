package com.tencent.p177mm.p190at.p191a.p829g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.at.a.g.b */
public final class C9016b {
    public static final String eSG = (eSn + ".tmp");
    public static long eSH = 0;
    public static final String eSl = C1448h.getExternalStorageDirectory().getAbsolutePath();
    public static final String eSn = (eSl + "/tencent/MicroMsg/");

    static {
        AppMethodBeat.m2504i(116126);
        AppMethodBeat.m2505o(116126);
    }

    /* renamed from: Ur */
    public static String m16284Ur() {
        AppMethodBeat.m2504i(116120);
        C4990ab.m7411d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", eSG + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
        C5728b c5728b = new C5728b(eSG);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(116120);
        return r0;
    }

    /* renamed from: Us */
    public static boolean m16285Us() {
        AppMethodBeat.m2504i(116121);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - eSH > 86400000) {
            C4990ab.m7410d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            eSH = currentTimeMillis;
            AppMethodBeat.m2505o(116121);
            return true;
        }
        C4990ab.m7410d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        AppMethodBeat.m2505o(116121);
        return false;
    }

    public static boolean ahJ() {
        AppMethodBeat.m2504i(116122);
        C5728b c5728b = new C5728b(eSG);
        try {
            if (c5728b.exists() && !c5728b.isFile()) {
                C9016b.m16286a(c5728b, true);
            }
            AppMethodBeat.m2505o(116122);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
            AppMethodBeat.m2505o(116122);
            return false;
        }
    }

    /* renamed from: fO */
    private static boolean m16288fO(long j) {
        AppMethodBeat.m2504i(116123);
        C4990ab.m7411d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j));
        if (System.currentTimeMillis() - j >= 259200000) {
            AppMethodBeat.m2505o(116123);
            return true;
        }
        AppMethodBeat.m2505o(116123);
        return false;
    }

    /* renamed from: e */
    private static void m16287e(C5728b c5728b) {
        AppMethodBeat.m2504i(116124);
        if (c5728b != null && c5728b.isFile() && c5728b.exists()) {
            c5728b.delete();
        }
        AppMethodBeat.m2505o(116124);
    }

    /* renamed from: a */
    private static void m16286a(C5728b c5728b, boolean z) {
        AppMethodBeat.m2504i(116125);
        if (c5728b != null && c5728b.exists() && c5728b.isDirectory()) {
            C5728b[] dMF = c5728b.dMF();
            if (dMF != null && dMF.length > 0) {
                for (C5728b c5728b2 : dMF) {
                    if (c5728b2 != null && c5728b2.exists()) {
                        if (c5728b2.isFile()) {
                            C9016b.m16287e(c5728b2);
                        } else if (C9016b.m16288fO(c5728b2.lastModified()) && z) {
                            C9016b.m16286a(c5728b2, false);
                        }
                    }
                }
            }
            c5728b.delete();
        }
        AppMethodBeat.m2505o(116125);
    }
}
