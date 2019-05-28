package com.tencent.p177mm.plugin.normsg.p474b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.normsg.b.f */
public final class C43349f {
    private static String[] oVc = new String[]{C43349f.decodeString(C4996ah.getContext().getFilesDir().getParent() + "/dumeq/tekcos/ved/"), C43349f.decodeString(C4996ah.getContext().getFilesDir().getParent() + "/epip_umeq/ved/")};
    private static String[] oVd = new String[]{C43349f.decodeString(C4996ah.getContext().getFilesDir().getParent() + "/hsifdlog")};
    private static String[] oVe = new String[]{C43349f.decodeString(C4996ah.getContext().getFilesDir().getParent() + "/os.umeq_gubed_collam_cbil/bil/metsys/"), C43349f.decodeString(C4996ah.getContext().getFilesDir().getParent() + "/ecart_umeq/sys/"), C43349f.decodeString(C4996ah.getContext().getFilesDir().getParent() + "/sporp-umeq/nib/metsys/")};
    public static boolean oVf;
    public static boolean oVg;
    public static boolean oVh;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x017a A:{SYNTHETIC, Splitter:B:32:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0185 A:{SYNTHETIC, Splitter:B:38:0x0185} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        Throwable th;
        InputStream inputStream;
        AppMethodBeat.m2504i(10440);
        oVf = false;
        oVg = false;
        oVh = false;
        for (String file : oVc) {
            if (new File(file).exists()) {
                oVf = true;
                break;
            }
        }
        File file2 = new File("/proc/tty/drivers");
        if (file2.exists() && file2.canRead() && file2.length() > 0) {
            String str;
            byte[] bArr = new byte[((int) file2.length())];
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.m2505o(10440);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                if (inputStream != null) {
                }
                AppMethodBeat.m2505o(10440);
                throw th;
            }
            str = new String(bArr);
            for (CharSequence contains : oVd) {
                if (str.contains(contains)) {
                    oVg = true;
                    break;
                }
            }
        }
        for (String file3 : oVe) {
            if (new File(file3).exists()) {
                oVh = true;
                AppMethodBeat.m2505o(10440);
                return;
            }
        }
        AppMethodBeat.m2505o(10440);
    }

    private static String decodeString(String str) {
        AppMethodBeat.m2504i(10439);
        String[] strArr = new String[]{C4996ah.getContext().getFilesDir().getParent(), str, C43349f.class.toString()};
        String stringBuilder = new StringBuilder(strArr[1].substring(strArr[0].length() + 1)).reverse().toString();
        AppMethodBeat.m2505o(10439);
        return stringBuilder;
    }
}
