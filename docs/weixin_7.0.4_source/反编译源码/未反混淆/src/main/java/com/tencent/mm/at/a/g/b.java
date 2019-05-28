package com.tencent.mm.at.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String eSG = (eSn + ".tmp");
    public static long eSH = 0;
    public static final String eSl = h.getExternalStorageDirectory().getAbsolutePath();
    public static final String eSn = (eSl + "/tencent/MicroMsg/");

    static {
        AppMethodBeat.i(116126);
        AppMethodBeat.o(116126);
    }

    public static String Ur() {
        AppMethodBeat.i(116120);
        ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", eSG + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(eSG);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        AppMethodBeat.o(116120);
        return r0;
    }

    public static boolean Us() {
        AppMethodBeat.i(116121);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - eSH > 86400000) {
            ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            eSH = currentTimeMillis;
            AppMethodBeat.o(116121);
            return true;
        }
        ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        AppMethodBeat.o(116121);
        return false;
    }

    public static boolean ahJ() {
        AppMethodBeat.i(116122);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(eSG);
        try {
            if (bVar.exists() && !bVar.isFile()) {
                a(bVar, true);
            }
            AppMethodBeat.o(116122);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
            AppMethodBeat.o(116122);
            return false;
        }
    }

    private static boolean fO(long j) {
        AppMethodBeat.i(116123);
        ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j));
        if (System.currentTimeMillis() - j >= 259200000) {
            AppMethodBeat.o(116123);
            return true;
        }
        AppMethodBeat.o(116123);
        return false;
    }

    private static void e(com.tencent.mm.vfs.b bVar) {
        AppMethodBeat.i(116124);
        if (bVar != null && bVar.isFile() && bVar.exists()) {
            bVar.delete();
        }
        AppMethodBeat.o(116124);
    }

    private static void a(com.tencent.mm.vfs.b bVar, boolean z) {
        AppMethodBeat.i(116125);
        if (bVar != null && bVar.exists() && bVar.isDirectory()) {
            com.tencent.mm.vfs.b[] dMF = bVar.dMF();
            if (dMF != null && dMF.length > 0) {
                for (com.tencent.mm.vfs.b bVar2 : dMF) {
                    if (bVar2 != null && bVar2.exists()) {
                        if (bVar2.isFile()) {
                            e(bVar2);
                        } else if (fO(bVar2.lastModified()) && z) {
                            a(bVar2, false);
                        }
                    }
                }
            }
            bVar.delete();
        }
        AppMethodBeat.o(116125);
    }
}
