package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

public final class bs extends k {
    private z xZX = null;

    public bs(z zVar) {
        this.xZX = zVar;
    }

    public final void duo() {
        AppMethodBeat.i(59007);
        ab.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", Integer.valueOf(duq()));
        AppMethodBeat.o(59007);
    }

    private boolean dup() {
        AppMethodBeat.i(59008);
        String str = (String) this.xZX.get(77825, null);
        ab.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml ".concat(String.valueOf(str)));
        if (!bo.isNullOrNil(str)) {
            super.anF(str);
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59008);
            return false;
        }
        AppMethodBeat.o(59008);
        return true;
    }

    private int duq() {
        AppMethodBeat.i(59009);
        if (dup()) {
            ab.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
            AppMethodBeat.o(59009);
            return 0;
        }
        String str = ac.eSj + "deviceconfig.cfg";
        if (e.ct(str)) {
            byte[] f = e.f(str, 0, -1);
            if (bo.cb(f)) {
                AppMethodBeat.o(59009);
                return -2;
            }
            str = new String(f, Charset.defaultCharset());
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(59009);
                return -3;
            }
            ab.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", str);
            apV(str);
            AppMethodBeat.o(59009);
            return 0;
        }
        AppMethodBeat.o(59009);
        return -1;
    }

    public final String dur() {
        AppMethodBeat.i(59010);
        String str = (String) this.xZX.get(77825, null);
        ab.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
        AppMethodBeat.o(59010);
        return str;
    }

    public final int apV(String str) {
        AppMethodBeat.i(59011);
        ab.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", str);
        this.xZX.set(77825, (Object) str);
        apX(str);
        super.anF(str);
        AppMethodBeat.o(59011);
        return 0;
    }

    public static String dus() {
        AppMethodBeat.i(59012);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = Build.FINGERPRINT;
        if (obj != null) {
            obj = obj.replace("/", VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        }
        linkedHashMap.put(FingerprintManagerProxy.FINGERPRINT_SERVICE, obj);
        linkedHashMap.put("manufacturer", Build.MANUFACTURER);
        linkedHashMap.put("device", Build.DEVICE);
        linkedHashMap.put("model", Build.MODEL);
        linkedHashMap.put("product", Build.PRODUCT);
        linkedHashMap.put("board", Build.BOARD);
        linkedHashMap.put("release", VERSION.RELEASE);
        linkedHashMap.put("codename", VERSION.CODENAME);
        linkedHashMap.put("incremental", VERSION.INCREMENTAL);
        linkedHashMap.put(ServerProtocol.DIALOG_PARAM_DISPLAY, Build.DISPLAY);
        String a = bo.a(linkedHashMap);
        ab.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  ".concat(String.valueOf(a)));
        AppMethodBeat.o(59012);
        return a;
    }

    public static String dut() {
        AppMethodBeat.i(59013);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<deviceinfo>");
        stringBuffer.append("<MANUFACTURER name=\"");
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append("\">");
        stringBuffer.append("<MODEL name=\"");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_RELEASE name=\"");
        stringBuffer.append(VERSION.RELEASE);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_INCREMENTAL name=\"");
        stringBuffer.append(VERSION.INCREMENTAL);
        stringBuffer.append("\">");
        stringBuffer.append("<DISPLAY name=\"");
        stringBuffer.append(Build.DISPLAY);
        stringBuffer.append("\">");
        stringBuffer.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        ab.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(59013);
        return stringBuffer2;
    }

    public static boolean apW(String str) {
        AppMethodBeat.i(59014);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59014);
            return false;
        }
        try {
            if (br.z(str, "deviceinfoconfig") == null) {
                AppMethodBeat.o(59014);
                return false;
            } else if (g.RK()) {
                g.RQ();
                g.RP().Rz().apV(str);
                AppMethodBeat.o(59014);
                return true;
            } else {
                AppMethodBeat.o(59014);
                return false;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bo.l(e));
            AppMethodBeat.o(59014);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094 A:{SYNTHETIC, Splitter:B:21:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094 A:{SYNTHETIC, Splitter:B:21:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0 A:{SYNTHETIC, Splitter:B:28:0x00b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean apX(String str) {
        Throwable e;
        boolean z;
        Throwable th;
        boolean z2 = true;
        AppMethodBeat.i(59015);
        File file = new File(ac.eSj);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileWriter fileWriter = null;
        FileWriter fileWriter2;
        try {
            ab.i("MicroMsg.ServerConfigInfoStorage", "writeConfigToLocalFile, path: %s, info:%s", ac.eSj + "deviceconfig.cfg", str);
            fileWriter2 = new FileWriter(ac.eSj + "deviceconfig.cfg");
            try {
                fileWriter2.write(str);
                try {
                    fileWriter2.close();
                    try {
                        fileWriter2.close();
                    } catch (IOException e2) {
                        ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bo.l(e2));
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = true;
                    try {
                        ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bo.l(e));
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                                z2 = z;
                            } catch (IOException e4) {
                                ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bo.l(e4));
                                z2 = z;
                            }
                        } else {
                            z2 = z;
                        }
                        AppMethodBeat.o(59015);
                        return z2;
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e42) {
                                ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bo.l(e42));
                            }
                        }
                        AppMethodBeat.o(59015);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                z = false;
                ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bo.l(e));
                if (fileWriter2 != null) {
                }
                AppMethodBeat.o(59015);
                return z2;
            }
        } catch (Exception e6) {
            e = e6;
            fileWriter2 = null;
            z = false;
            ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bo.l(e));
            if (fileWriter2 != null) {
            }
            AppMethodBeat.o(59015);
            return z2;
        } catch (Throwable th3) {
            th = th3;
            if (fileWriter != null) {
            }
            AppMethodBeat.o(59015);
            throw th;
        }
        AppMethodBeat.o(59015);
        return z2;
    }
}
