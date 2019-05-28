package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import org.json.JSONObject;

public final class an {
    private static String eSk = "";
    public static Set<String> mgy;
    public static int mgz = 1;

    private static String hg(boolean z) {
        AppMethodBeat.i(51353);
        String str;
        if (z) {
            str = g.RP().eJM;
            AppMethodBeat.o(51353);
            return str;
        }
        if (bo.isNullOrNil(eSk)) {
            eSk = e.eSk.replace("/data/user/0", "/data/data");
        }
        str = eSk;
        AppMethodBeat.o(51353);
        return str;
    }

    public static String bvi() {
        File file;
        AppMethodBeat.i(51354);
        if (bd.dpp() > 1048576) {
            file = new File(hg(false), "wenote/res");
        } else {
            file = new File(e.eSn, "wenote/res");
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(51354);
        return absolutePath;
    }

    public static String bvj() {
        AppMethodBeat.i(51355);
        File file = new File(hg(false), "wenote/res");
        String absolutePath;
        if (new File(file, "WNNote.zip").exists()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(51355);
            return absolutePath;
        }
        file = new File(e.eSn, "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(51355);
            return absolutePath;
        }
        absolutePath = "";
        AppMethodBeat.o(51355);
        return absolutePath;
    }

    public static String bvk() {
        AppMethodBeat.i(51356);
        File file = new File(hg(true), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(51356);
        return absolutePath;
    }

    public static String bvl() {
        AppMethodBeat.i(51357);
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(hg(false), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        String stringBuilder2 = stringBuilder.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
        AppMethodBeat.o(51357);
        return stringBuilder2;
    }

    public static String bvm() {
        AppMethodBeat.i(51358);
        File file = new File(hg(true), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(51358);
        return absolutePath;
    }

    public static String bvn() {
        AppMethodBeat.i(51359);
        File file = new File(hg(true), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(51359);
        return absolutePath;
    }

    public static int afW() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(51360);
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(bvj(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        ab.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        bo.b(fileInputStream);
                        AppMethodBeat.o(51360);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    bo.b(fileInputStream);
                    AppMethodBeat.o(51360);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(fileInputStream);
                    AppMethodBeat.o(51360);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            bo.b(fileInputStream);
            AppMethodBeat.o(51360);
            return 1;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            bo.b(fileInputStream);
            AppMethodBeat.o(51360);
            throw th;
        }
    }

    public static int afX() {
        Closeable inputStreamReader;
        Exception e;
        Closeable closeable;
        Throwable th;
        AppMethodBeat.i(51361);
        Closeable open;
        try {
            open = ah.getContext().getAssets().open("wenote_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
            } catch (Exception e2) {
                e = e2;
                closeable = null;
                inputStreamReader = null;
                try {
                    ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    bo.b(open);
                    bo.b(inputStreamReader);
                    bo.b(closeable);
                    AppMethodBeat.o(51361);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(open);
                    bo.b(inputStreamReader);
                    bo.b(closeable);
                    AppMethodBeat.o(51361);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                inputStreamReader = null;
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(51361);
                throw th;
            }
            try {
                closeable = new BufferedReader(inputStreamReader);
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(51361);
                return 1;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(51361);
                throw th;
            }
            try {
                String str = "";
                while (true) {
                    String readLine = closeable.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        ab.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        bo.b(open);
                        bo.b(inputStreamReader);
                        bo.b(closeable);
                        AppMethodBeat.o(51361);
                        return r0;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                bo.b(open);
                bo.b(inputStreamReader);
                bo.b(closeable);
                AppMethodBeat.o(51361);
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
            AppMethodBeat.o(51361);
            throw th;
        }
    }
}
