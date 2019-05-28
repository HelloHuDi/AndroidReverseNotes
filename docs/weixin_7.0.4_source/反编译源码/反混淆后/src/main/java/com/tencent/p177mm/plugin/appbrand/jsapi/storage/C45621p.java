package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.p */
public final class C45621p {
    /* renamed from: m */
    public static int m84208m(String... strArr) {
        AppMethodBeat.m2504i(102091);
        int i = 0;
        for (String str : strArr) {
            if (str != null) {
                i += str.length();
            }
        }
        AppMethodBeat.m2505o(102091);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A:{SYNTHETIC, Splitter:B:20:0x0042} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: I */
    private static String m84205I(File file) {
        IOException e;
        Throwable th;
        AppMethodBeat.m2504i(102092);
        String stringBuffer;
        if (file.exists()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    char[] cArr = new char[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read != -1) {
                            stringBuffer2.append(String.valueOf(cArr, 0, read));
                        } else {
                            try {
                                bufferedReader.close();
                                stringBuffer = stringBuffer2.toString();
                                AppMethodBeat.m2505o(102092);
                                return stringBuffer;
                            } catch (Exception e2) {
                                AppMethodBeat.m2505o(102092);
                                throw e2;
                            }
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        AppMethodBeat.m2505o(102092);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e22) {
                                AppMethodBeat.m2505o(102092);
                                throw e22;
                            }
                        }
                        AppMethodBeat.m2505o(102092);
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                AppMethodBeat.m2505o(102092);
                throw e;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(102092);
                throw th;
            }
        }
        stringBuffer = "";
        AppMethodBeat.m2505o(102092);
        return stringBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A:{SYNTHETIC, Splitter:B:16:0x0035} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public static void m84207g(String str, String... strArr) {
        Throwable th;
        AppMethodBeat.m2504i(102093);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(new File(C4996ah.getContext().getCacheDir(), str));
            try {
                for (String write : strArr) {
                    fileWriter.write(write);
                }
                try {
                    fileWriter.close();
                    AppMethodBeat.m2505o(102093);
                } catch (IOException e) {
                    AppMethodBeat.m2505o(102093);
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                }
                AppMethodBeat.m2505o(102093);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(102093);
            throw th;
        }
    }

    /* renamed from: BL */
    public static String m84203BL(String str) {
        AppMethodBeat.m2504i(102094);
        String I = C45621p.m84205I(new File(C4996ah.getContext().getCacheDir(), str));
        AppMethodBeat.m2505o(102094);
        return I;
    }

    /* renamed from: BM */
    public static void m84204BM(String str) {
        AppMethodBeat.m2504i(102095);
        C4990ab.m7416i("MicroMsg.JsApiStorageHelper", "deleteTmpFile: " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + new File(C4996ah.getContext().getCacheDir(), str).delete());
        AppMethodBeat.m2505o(102095);
    }

    /* renamed from: a */
    static String m84206a(C10107a c10107a) {
        if (c10107a == C10107a.NONE) {
            return "ok";
        }
        if (c10107a == C10107a.QUOTA_REACHED) {
            return "fail:quota reached";
        }
        return "fail:internal error set DB data fail";
    }
}
