package com.tencent.p177mm.p1177ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.ao.a */
public final class C37462a {
    private static String eSk = "";
    public static int fAH = 1;

    private static String afT() {
        AppMethodBeat.m2504i(62273);
        if (C5046bo.isNullOrNil(eSk)) {
            eSk = C6457e.eSk.replace("/data/user/0", "/data/data");
        }
        String str = eSk;
        AppMethodBeat.m2505o(62273);
        return str;
    }

    public static String afU() {
        AppMethodBeat.m2504i(62274);
        C5728b c5728b = new C5728b(C37462a.afT(), "emoji/res");
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        String w = C5736j.m8649w(c5728b.dMD());
        AppMethodBeat.m2505o(62274);
        return w;
    }

    public static String afV() {
        AppMethodBeat.m2504i(62275);
        String str = C37462a.afT() + "emoji/newemoji/";
        AppMethodBeat.m2505o(62275);
        return str;
    }

    public static int afW() {
        AppMethodBeat.m2504i(62276);
        Closeable closeable = null;
        int i;
        try {
            closeable = C5730e.m8638p(new C5728b(C37462a.afU(), "config.conf"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(closeable));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str = str + readLine;
            }
            i = new JSONObject(str).getInt("version");
            C4990ab.m7411d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(i));
            return i;
        } catch (Exception e) {
            i = e;
            C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", i, i.getMessage(), new Object[0]);
            return 1;
        } finally {
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(62276);
        }
    }

    private static int afX() {
        Closeable inputStreamReader;
        Exception e;
        Closeable closeable;
        Throwable th;
        AppMethodBeat.m2504i(62277);
        Closeable open;
        try {
            open = C4996ah.getContext().getAssets().open("emoji_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
            } catch (Exception e2) {
                e = e2;
                closeable = null;
                inputStreamReader = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                    C5046bo.m7527b(open);
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(62277);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(open);
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(62277);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                inputStreamReader = null;
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(62277);
                throw th;
            }
            try {
                closeable = new BufferedReader(inputStreamReader);
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(62277);
                return 1;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(62277);
                throw th;
            }
            try {
                String str = "";
                while (true) {
                    String readLine = closeable.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        C4990ab.m7411d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        C5046bo.m7527b(open);
                        C5046bo.m7527b(inputStreamReader);
                        C5046bo.m7527b(closeable);
                        AppMethodBeat.m2505o(62277);
                        return r0;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(62277);
                return 1;
            }
        } catch (Exception e5) {
            e = e5;
            closeable = null;
            inputStreamReader = null;
            open = null;
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStreamReader = null;
            open = null;
            C5046bo.m7527b(open);
            C5046bo.m7527b(inputStreamReader);
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(62277);
            throw th;
        }
    }

    /* renamed from: rU */
    private static boolean m63178rU(String str) {
        InputStream open;
        InputStream inputStream = null;
        AppMethodBeat.m2504i(62278);
        try {
            open = C4996ah.getContext().getAssets().open("emoji_template.zip");
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "", new Object[0]);
            open = inputStream;
        }
        if (open == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiStoreExportLogic", "file inputStream not found");
            AppMethodBeat.m2505o(62278);
            return false;
        }
        OutputStream q;
        C5728b c5728b = new C5728b(str);
        if (c5728b.exists()) {
            c5728b.delete();
        }
        c5728b.dMC().mkdirs();
        try {
            q = C5730e.m8641q(c5728b);
        } catch (FileNotFoundException e2) {
            C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "", new Object[0]);
            Object q2 = inputStream;
        }
        if (q2 != null) {
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        q2.write(bArr, 0, read);
                    } else {
                        C5046bo.m7527b(open);
                        C5046bo.m7527b(q2);
                        AppMethodBeat.m2505o(62278);
                        return true;
                    }
                }
            } catch (IOException e3) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e3, "", new Object[0]);
                return false;
            } finally {
                C5046bo.m7527b(open);
                C5046bo.m7527b(q2);
                AppMethodBeat.m2505o(62278);
            }
        } else {
            C5046bo.m7527b(open);
            AppMethodBeat.m2505o(62278);
            return false;
        }
    }

    /* renamed from: cM */
    public static void m63176cM(boolean z) {
        AppMethodBeat.m2504i(62279);
        C5728b c5728b = new C5728b(C37462a.afU());
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", c5728b.dME());
        if (C7243d.vxr) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", Boolean.valueOf(z));
            C5730e.m8618N(C5736j.m8649w(c5728b.mUri), true);
            C37462a.m63175c(c5728b);
        } else {
            fAH = C37462a.afW();
            if (z) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", Integer.valueOf(C37462a.afX()), Integer.valueOf(fAH));
                if (fAH < C37462a.afX()) {
                    C5730e.m8618N(C5736j.m8649w(c5728b.mUri), true);
                    C37462a.m63175c(c5728b);
                }
            } else if (fAH == 1) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", Integer.valueOf(fAH));
                C5730e.m8618N(C5736j.m8649w(c5728b.mUri), true);
                C37462a.m63175c(c5728b);
            }
        }
        C5730e.m8618N(C5736j.m8649w(new C5728b(C6457e.eSn, "emoji").mUri), true);
        AppMethodBeat.m2505o(62279);
    }

    /* renamed from: c */
    private static void m63175c(C5728b c5728b) {
        AppMethodBeat.m2504i(62280);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        C5728b c5728b2 = new C5728b(c5728b, ".nomedia");
        if (!c5728b2.exists()) {
            try {
                c5728b2.createNewFile();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        c5728b2 = new C5728b(c5728b, "emoji_template.zip");
        if (C37462a.m63178rU(C5736j.m8649w(c5728b2.dMD()))) {
            int iu = C5730e.m8636iu(C5736j.m8649w(c5728b2.dMD()), c5728b2.getParent());
            if (iu < 0) {
                C4990ab.m7412e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + iu + ", zipFilePath = " + C5736j.m8649w(c5728b2.dMD()) + ", unzipPath = " + c5728b2.getParent());
                AppMethodBeat.m2505o(62280);
                return;
            }
            fAH = C37462a.afW();
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", c5728b2.getParent(), Integer.valueOf(fAH));
            AppMethodBeat.m2505o(62280);
            return;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", C5736j.m8649w(c5728b2.dMD()));
        AppMethodBeat.m2505o(62280);
    }

    /* renamed from: d */
    public static void m63177d(C5728b c5728b) {
        AppMethodBeat.m2504i(62281);
        C5728b c5728b2 = new C5728b(C37462a.afU());
        C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
        c5728b2.mkdirs();
        C5728b c5728b3 = new C5728b(c5728b2, ".nomedia");
        if (!c5728b3.exists()) {
            try {
                c5728b3.createNewFile();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        c5728b3 = new C5728b(c5728b2, "emoji_template.zip");
        C5730e.m8644y(C5736j.m8649w(c5728b.mUri), C5736j.m8649w(c5728b3.mUri));
        int hU = C5046bo.m7570hU(C5736j.m8649w(c5728b3.mUri), c5728b3.getParent());
        if (hU < 0) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + hU + ", zipFilePath = " + C5736j.m8649w(c5728b3.dMD()) + ", unzipPath = " + c5728b3.getParent());
            AppMethodBeat.m2505o(62281);
            return;
        }
        fAH = C37462a.afW();
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", c5728b3.getParent(), Integer.valueOf(fAH));
        AppMethodBeat.m2505o(62281);
    }
}
