package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fav.a.an */
public final class C11851an {
    private static String eSk = "";
    public static Set<String> mgy;
    public static int mgz = 1;

    /* renamed from: hg */
    private static String m19717hg(boolean z) {
        AppMethodBeat.m2504i(51353);
        String str;
        if (z) {
            str = C1720g.m3536RP().eJM;
            AppMethodBeat.m2505o(51353);
            return str;
        }
        if (C5046bo.isNullOrNil(eSk)) {
            eSk = C6457e.eSk.replace("/data/user/0", "/data/data");
        }
        str = eSk;
        AppMethodBeat.m2505o(51353);
        return str;
    }

    public static String bvi() {
        File file;
        AppMethodBeat.m2504i(51354);
        if (C5034bd.dpp() > 1048576) {
            file = new File(C11851an.m19717hg(false), "wenote/res");
        } else {
            file = new File(C6457e.eSn, "wenote/res");
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.m2505o(51354);
        return absolutePath;
    }

    public static String bvj() {
        AppMethodBeat.m2504i(51355);
        File file = new File(C11851an.m19717hg(false), "wenote/res");
        String absolutePath;
        if (new File(file, "WNNote.zip").exists()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.m2505o(51355);
            return absolutePath;
        }
        file = new File(C6457e.eSn, "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.m2505o(51355);
            return absolutePath;
        }
        absolutePath = "";
        AppMethodBeat.m2505o(51355);
        return absolutePath;
    }

    public static String bvk() {
        AppMethodBeat.m2504i(51356);
        File file = new File(C11851an.m19717hg(true), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.m2505o(51356);
        return absolutePath;
    }

    public static String bvl() {
        AppMethodBeat.m2504i(51357);
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(C11851an.m19717hg(false), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        String stringBuilder2 = stringBuilder.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
        AppMethodBeat.m2505o(51357);
        return stringBuilder2;
    }

    public static String bvm() {
        AppMethodBeat.m2504i(51358);
        File file = new File(C11851an.m19717hg(true), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.m2505o(51358);
        return absolutePath;
    }

    public static String bvn() {
        AppMethodBeat.m2504i(51359);
        File file = new File(C11851an.m19717hg(true), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.m2505o(51359);
        return absolutePath;
    }

    public static int afW() {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(51360);
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(C11851an.bvj(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        C4990ab.m7411d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        C5046bo.m7527b(fileInputStream);
                        AppMethodBeat.m2505o(51360);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    C5046bo.m7527b(fileInputStream);
                    AppMethodBeat.m2505o(51360);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(fileInputStream);
                    AppMethodBeat.m2505o(51360);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            C5046bo.m7527b(fileInputStream);
            AppMethodBeat.m2505o(51360);
            return 1;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            C5046bo.m7527b(fileInputStream);
            AppMethodBeat.m2505o(51360);
            throw th;
        }
    }

    public static int afX() {
        Closeable inputStreamReader;
        Exception e;
        Closeable closeable;
        Throwable th;
        AppMethodBeat.m2504i(51361);
        Closeable open;
        try {
            open = C4996ah.getContext().getAssets().open("wenote_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
            } catch (Exception e2) {
                e = e2;
                closeable = null;
                inputStreamReader = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    C5046bo.m7527b(open);
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(51361);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(open);
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(51361);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                inputStreamReader = null;
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(51361);
                throw th;
            }
            try {
                closeable = new BufferedReader(inputStreamReader);
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                C4990ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(51361);
                return 1;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(51361);
                throw th;
            }
            try {
                String str = "";
                while (true) {
                    String readLine = closeable.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        C4990ab.m7411d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        C5046bo.m7527b(open);
                        C5046bo.m7527b(inputStreamReader);
                        C5046bo.m7527b(closeable);
                        AppMethodBeat.m2505o(51361);
                        return r0;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                C4990ab.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                C5046bo.m7527b(open);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(51361);
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
            AppMethodBeat.m2505o(51361);
            throw th;
        }
    }
}
