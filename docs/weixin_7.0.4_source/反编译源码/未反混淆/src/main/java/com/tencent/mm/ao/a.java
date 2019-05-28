package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.JSONObject;

public final class a {
    private static String eSk = "";
    public static int fAH = 1;

    private static String afT() {
        AppMethodBeat.i(62273);
        if (bo.isNullOrNil(eSk)) {
            eSk = e.eSk.replace("/data/user/0", "/data/data");
        }
        String str = eSk;
        AppMethodBeat.o(62273);
        return str;
    }

    public static String afU() {
        AppMethodBeat.i(62274);
        b bVar = new b(afT(), "emoji/res");
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        String w = j.w(bVar.dMD());
        AppMethodBeat.o(62274);
        return w;
    }

    public static String afV() {
        AppMethodBeat.i(62275);
        String str = afT() + "emoji/newemoji/";
        AppMethodBeat.o(62275);
        return str;
    }

    public static int afW() {
        AppMethodBeat.i(62276);
        Closeable closeable = null;
        int i;
        try {
            closeable = com.tencent.mm.vfs.e.p(new b(afU(), "config.conf"));
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
            ab.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(i));
            return i;
        } catch (Exception e) {
            i = e;
            ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", i, i.getMessage(), new Object[0]);
            return 1;
        } finally {
            bo.b(closeable);
            AppMethodBeat.o(62276);
        }
    }

    private static int afX() {
        Closeable inputStreamReader;
        Exception e;
        Closeable closeable;
        Throwable th;
        AppMethodBeat.i(62277);
        Closeable open;
        try {
            open = ah.getContext().getAssets().open("emoji_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
            } catch (Exception e2) {
                e = e2;
                closeable = null;
                inputStreamReader = null;
                try {
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                    bo.b(open);
                    bo.b(inputStreamReader);
                    bo.b(closeable);
                    AppMethodBeat.o(62277);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(open);
                    bo.b(inputStreamReader);
                    bo.b(closeable);
                    AppMethodBeat.o(62277);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                inputStreamReader = null;
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(62277);
                throw th;
            }
            try {
                closeable = new BufferedReader(inputStreamReader);
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(62277);
                return 1;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(62277);
                throw th;
            }
            try {
                String str = "";
                while (true) {
                    String readLine = closeable.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        ab.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        bo.b(open);
                        bo.b(inputStreamReader);
                        bo.b(closeable);
                        AppMethodBeat.o(62277);
                        return r0;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(62277);
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
            bo.b(open);
            bo.b(inputStreamReader);
            bo.b(closeable);
            AppMethodBeat.o(62277);
            throw th;
        }
    }

    private static boolean rU(String str) {
        InputStream open;
        InputStream inputStream = null;
        AppMethodBeat.i(62278);
        try {
            open = ah.getContext().getAssets().open("emoji_template.zip");
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "", new Object[0]);
            open = inputStream;
        }
        if (open == null) {
            ab.e("MicroMsg.emoji.EmojiStoreExportLogic", "file inputStream not found");
            AppMethodBeat.o(62278);
            return false;
        }
        OutputStream q;
        b bVar = new b(str);
        if (bVar.exists()) {
            bVar.delete();
        }
        bVar.dMC().mkdirs();
        try {
            q = com.tencent.mm.vfs.e.q(bVar);
        } catch (FileNotFoundException e2) {
            ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "", new Object[0]);
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
                        bo.b(open);
                        bo.b(q2);
                        AppMethodBeat.o(62278);
                        return true;
                    }
                }
            } catch (IOException e3) {
                ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e3, "", new Object[0]);
                return false;
            } finally {
                bo.b(open);
                bo.b(q2);
                AppMethodBeat.o(62278);
            }
        } else {
            bo.b(open);
            AppMethodBeat.o(62278);
            return false;
        }
    }

    public static void cM(boolean z) {
        AppMethodBeat.i(62279);
        b bVar = new b(afU());
        ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", bVar.dME());
        if (d.vxr) {
            ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", Boolean.valueOf(z));
            com.tencent.mm.vfs.e.N(j.w(bVar.mUri), true);
            c(bVar);
        } else {
            fAH = afW();
            if (z) {
                ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", Integer.valueOf(afX()), Integer.valueOf(fAH));
                if (fAH < afX()) {
                    com.tencent.mm.vfs.e.N(j.w(bVar.mUri), true);
                    c(bVar);
                }
            } else if (fAH == 1) {
                ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", Integer.valueOf(fAH));
                com.tencent.mm.vfs.e.N(j.w(bVar.mUri), true);
                c(bVar);
            }
        }
        com.tencent.mm.vfs.e.N(j.w(new b(e.eSn, "emoji").mUri), true);
        AppMethodBeat.o(62279);
    }

    private static void c(b bVar) {
        AppMethodBeat.i(62280);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        b bVar2 = new b(bVar, ".nomedia");
        if (!bVar2.exists()) {
            try {
                bVar2.createNewFile();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        bVar2 = new b(bVar, "emoji_template.zip");
        if (rU(j.w(bVar2.dMD()))) {
            int iu = com.tencent.mm.vfs.e.iu(j.w(bVar2.dMD()), bVar2.getParent());
            if (iu < 0) {
                ab.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + iu + ", zipFilePath = " + j.w(bVar2.dMD()) + ", unzipPath = " + bVar2.getParent());
                AppMethodBeat.o(62280);
                return;
            }
            fAH = afW();
            ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", bVar2.getParent(), Integer.valueOf(fAH));
            AppMethodBeat.o(62280);
            return;
        }
        ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", j.w(bVar2.dMD()));
        AppMethodBeat.o(62280);
    }

    public static void d(b bVar) {
        AppMethodBeat.i(62281);
        b bVar2 = new b(afU());
        com.tencent.mm.vfs.e.N(j.w(bVar2.mUri), true);
        bVar2.mkdirs();
        b bVar3 = new b(bVar2, ".nomedia");
        if (!bVar3.exists()) {
            try {
                bVar3.createNewFile();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        bVar3 = new b(bVar2, "emoji_template.zip");
        com.tencent.mm.vfs.e.y(j.w(bVar.mUri), j.w(bVar3.mUri));
        int hU = bo.hU(j.w(bVar3.mUri), bVar3.getParent());
        if (hU < 0) {
            ab.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + hU + ", zipFilePath = " + j.w(bVar3.dMD()) + ", unzipPath = " + bVar3.getParent());
            AppMethodBeat.o(62281);
            return;
        }
        fAH = afW();
        ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", bVar3.getParent(), Integer.valueOf(fAH));
        AppMethodBeat.o(62281);
    }
}
