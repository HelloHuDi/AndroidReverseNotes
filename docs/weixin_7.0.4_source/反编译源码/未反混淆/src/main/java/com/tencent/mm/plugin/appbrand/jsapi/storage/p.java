package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class p {
    public static int m(String... strArr) {
        AppMethodBeat.i(102091);
        int i = 0;
        for (String str : strArr) {
            if (str != null) {
                i += str.length();
            }
        }
        AppMethodBeat.o(102091);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A:{SYNTHETIC, Splitter:B:20:0x0042} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String I(File file) {
        IOException e;
        Throwable th;
        AppMethodBeat.i(102092);
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
                                AppMethodBeat.o(102092);
                                return stringBuffer;
                            } catch (Exception e2) {
                                AppMethodBeat.o(102092);
                                throw e2;
                            }
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        AppMethodBeat.o(102092);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e22) {
                                AppMethodBeat.o(102092);
                                throw e22;
                            }
                        }
                        AppMethodBeat.o(102092);
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                AppMethodBeat.o(102092);
                throw e;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(102092);
                throw th;
            }
        }
        stringBuffer = "";
        AppMethodBeat.o(102092);
        return stringBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A:{SYNTHETIC, Splitter:B:16:0x0035} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(String str, String... strArr) {
        Throwable th;
        AppMethodBeat.i(102093);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(new File(ah.getContext().getCacheDir(), str));
            try {
                for (String write : strArr) {
                    fileWriter.write(write);
                }
                try {
                    fileWriter.close();
                    AppMethodBeat.o(102093);
                } catch (IOException e) {
                    AppMethodBeat.o(102093);
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                }
                AppMethodBeat.o(102093);
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
            AppMethodBeat.o(102093);
            throw th;
        }
    }

    public static String BL(String str) {
        AppMethodBeat.i(102094);
        String I = I(new File(ah.getContext().getCacheDir(), str));
        AppMethodBeat.o(102094);
        return I;
    }

    public static void BM(String str) {
        AppMethodBeat.i(102095);
        ab.i("MicroMsg.JsApiStorageHelper", "deleteTmpFile: " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + new File(ah.getContext().getCacheDir(), str).delete());
        AppMethodBeat.o(102095);
    }

    static String a(a aVar) {
        if (aVar == a.NONE) {
            return "ok";
        }
        if (aVar == a.QUOTA_REACHED) {
            return "fail:quota reached";
        }
        return "fail:internal error set DB data fail";
    }
}
