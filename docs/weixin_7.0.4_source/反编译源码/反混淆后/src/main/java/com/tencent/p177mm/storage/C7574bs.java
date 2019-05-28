package com.tencent.p177mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

/* renamed from: com.tencent.mm.storage.bs */
public final class C7574bs extends C7296k {
    private C7580z xZX = null;

    public C7574bs(C7580z c7580z) {
        this.xZX = c7580z;
    }

    public final void duo() {
        AppMethodBeat.m2504i(59007);
        C4990ab.m7417i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", Integer.valueOf(duq()));
        AppMethodBeat.m2505o(59007);
    }

    private boolean dup() {
        AppMethodBeat.m2504i(59008);
        String str = (String) this.xZX.get(77825, null);
        C4990ab.m7416i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml ".concat(String.valueOf(str)));
        if (!C5046bo.isNullOrNil(str)) {
            super.anF(str);
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59008);
            return false;
        }
        AppMethodBeat.m2505o(59008);
        return true;
    }

    private int duq() {
        AppMethodBeat.m2504i(59009);
        if (dup()) {
            C4990ab.m7416i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
            AppMethodBeat.m2505o(59009);
            return 0;
        }
        String str = C5128ac.eSj + "deviceconfig.cfg";
        if (C1173e.m2561ct(str)) {
            byte[] f = C1173e.m2571f(str, 0, -1);
            if (C5046bo.m7540cb(f)) {
                AppMethodBeat.m2505o(59009);
                return -2;
            }
            str = new String(f, Charset.defaultCharset());
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(59009);
                return -3;
            }
            C4990ab.m7417i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", str);
            apV(str);
            AppMethodBeat.m2505o(59009);
            return 0;
        }
        AppMethodBeat.m2505o(59009);
        return -1;
    }

    public final String dur() {
        AppMethodBeat.m2504i(59010);
        String str = (String) this.xZX.get(77825, null);
        C4990ab.m7410d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
        AppMethodBeat.m2505o(59010);
        return str;
    }

    public final int apV(String str) {
        AppMethodBeat.m2504i(59011);
        C4990ab.m7411d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", str);
        this.xZX.set(77825, (Object) str);
        C7574bs.apX(str);
        super.anF(str);
        AppMethodBeat.m2505o(59011);
        return 0;
    }

    public static String dus() {
        AppMethodBeat.m2504i(59012);
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
        String a = C5046bo.m7516a(linkedHashMap);
        C4990ab.m7410d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  ".concat(String.valueOf(a)));
        AppMethodBeat.m2505o(59012);
        return a;
    }

    public static String dut() {
        AppMethodBeat.m2504i(59013);
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
        C4990ab.m7410d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(59013);
        return stringBuffer2;
    }

    public static boolean apW(String str) {
        AppMethodBeat.m2504i(59014);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59014);
            return false;
        }
        try {
            if (C5049br.m7595z(str, "deviceinfoconfig") == null) {
                AppMethodBeat.m2505o(59014);
                return false;
            } else if (C1720g.m3531RK()) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5240Rz().apV(str);
                AppMethodBeat.m2505o(59014);
                return true;
            } else {
                AppMethodBeat.m2505o(59014);
                return false;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ServerConfigInfoStorage", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(59014);
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
        AppMethodBeat.m2504i(59015);
        File file = new File(C5128ac.eSj);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileWriter fileWriter = null;
        FileWriter fileWriter2;
        try {
            C4990ab.m7417i("MicroMsg.ServerConfigInfoStorage", "writeConfigToLocalFile, path: %s, info:%s", C5128ac.eSj + "deviceconfig.cfg", str);
            fileWriter2 = new FileWriter(C5128ac.eSj + "deviceconfig.cfg");
            try {
                fileWriter2.write(str);
                try {
                    fileWriter2.close();
                    try {
                        fileWriter2.close();
                    } catch (IOException e2) {
                        C4990ab.m7413e("MicroMsg.ServerConfigInfoStorage", "exception:%s", C5046bo.m7574l(e2));
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = true;
                    try {
                        C4990ab.m7413e("MicroMsg.ServerConfigInfoStorage", "exception:%s", C5046bo.m7574l(e));
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                                z2 = z;
                            } catch (IOException e4) {
                                C4990ab.m7413e("MicroMsg.ServerConfigInfoStorage", "exception:%s", C5046bo.m7574l(e4));
                                z2 = z;
                            }
                        } else {
                            z2 = z;
                        }
                        AppMethodBeat.m2505o(59015);
                        return z2;
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e42) {
                                C4990ab.m7413e("MicroMsg.ServerConfigInfoStorage", "exception:%s", C5046bo.m7574l(e42));
                            }
                        }
                        AppMethodBeat.m2505o(59015);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                z = false;
                C4990ab.m7413e("MicroMsg.ServerConfigInfoStorage", "exception:%s", C5046bo.m7574l(e));
                if (fileWriter2 != null) {
                }
                AppMethodBeat.m2505o(59015);
                return z2;
            }
        } catch (Exception e6) {
            e = e6;
            fileWriter2 = null;
            z = false;
            C4990ab.m7413e("MicroMsg.ServerConfigInfoStorage", "exception:%s", C5046bo.m7574l(e));
            if (fileWriter2 != null) {
            }
            AppMethodBeat.m2505o(59015);
            return z2;
        } catch (Throwable th3) {
            th = th3;
            if (fileWriter != null) {
            }
            AppMethodBeat.m2505o(59015);
            throw th;
        }
        AppMethodBeat.m2505o(59015);
        return z2;
    }
}
