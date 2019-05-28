package com.tencent.p177mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.report.service.f */
public final class C3745f {
    private static String filePath = (C3745f.getAppFilePath() + "/kvcomm/exception/");
    private static Byte pYa = Byte.valueOf((byte) 0);

    static {
        AppMethodBeat.m2504i(72739);
        if (!C1173e.m2561ct(filePath)) {
            C1173e.m2564cw(filePath);
        }
        AppMethodBeat.m2505o(72739);
    }

    private static String getAppFilePath() {
        String str = null;
        AppMethodBeat.m2504i(72733);
        Context context = C4996ah.getContext();
        if (context == null) {
            AppMethodBeat.m2505o(72733);
        } else {
            try {
                File filesDir = context.getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.createNewFile();
                }
                str = filesDir.toString();
                AppMethodBeat.m2505o(72733);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", e.getMessage());
                AppMethodBeat.m2505o(72733);
            }
        }
        return str;
    }

    public static void cgq() {
        int i;
        AppMethodBeat.m2504i(72734);
        if (C1173e.m2561ct(filePath)) {
            File[] listFiles = new File(filePath).listFiles();
            if (listFiles == null) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
                AppMethodBeat.m2505o(72734);
                return;
            }
            synchronized (pYa) {
                int i2;
                try {
                    for (File file : listFiles) {
                        if (file == null) {
                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
                        } else {
                            String absolutePath = file.getAbsolutePath();
                            i2 = 0;
                            int cs = C1173e.m2560cs(absolutePath);
                            C4990ab.m7410d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + file.getAbsolutePath() + ", filelenth:" + cs);
                            while (i2 < cs) {
                                byte[] e = C1173e.m2569e(absolutePath, i2, 4);
                                if (e == null) {
                                    C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:".concat(String.valueOf(absolutePath)));
                                    break;
                                }
                                i2 += 4;
                                int bf = C3745f.m6065bf(e);
                                byte[] e2 = C1173e.m2569e(absolutePath, i2, bf);
                                if (e2 == null) {
                                    C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:".concat(String.valueOf(absolutePath)));
                                    break;
                                }
                                i = i2 + bf;
                                long j;
                                if (!absolutePath.contains(".statictis_new2")) {
                                    C7055b c7055b;
                                    if (!absolutePath.contains(".monitor")) {
                                        if (!absolutePath.contains(".group_monitor")) {
                                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(absolutePath)));
                                            break;
                                        }
                                        C7054a c7054a = new C7054a();
                                        try {
                                            c7054a.parseFrom(e2);
                                            ArrayList arrayList = new ArrayList();
                                            boolean z = false;
                                            Iterator it = c7054a.pXB.iterator();
                                            while (it.hasNext()) {
                                                c7055b = (C7055b) it.next();
                                                IDKey iDKey = new IDKey(c7055b.f1968ID, c7055b.pXC, c7055b.pXD);
                                                boolean z2 = c7055b.pXE;
                                                arrayList.add(iDKey);
                                                C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + c7055b.f1968ID + ", key:" + c7055b.pXC + ", value:" + c7055b.pXD + ", isImportant" + z2);
                                                z = z2;
                                            }
                                            C7060h.pYm.mo8379b(arrayList, z);
                                        } catch (IOException e3) {
                                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e3.getMessage());
                                            i2 = i;
                                        }
                                    } else {
                                        c7055b = new C7055b();
                                        try {
                                            c7055b.parseFrom(e2);
                                            j = (long) c7055b.f1968ID;
                                            long j2 = (long) c7055b.pXC;
                                            long j3 = (long) c7055b.pXD;
                                            boolean z3 = c7055b.pXE;
                                            C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + j + ", key:" + j2 + ", value:" + j3 + ", isImportant" + z3);
                                            C7060h.pYm.mo8378a(j, j2, j3, z3);
                                        } catch (IOException e32) {
                                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e32.getMessage());
                                            i2 = i;
                                        }
                                    }
                                } else {
                                    C7056c c7056c = new C7056c();
                                    c7056c.parseFrom(e2);
                                    bf = c7056c.pXL;
                                    int i3 = c7056c.jCt;
                                    String str = c7056c.pXM;
                                    boolean z4 = c7056c.pXE;
                                    boolean z5 = c7056c.pXN;
                                    boolean z6 = c7056c.pXO;
                                    C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + bf + ", type:" + i3 + ", value:" + str + ", isReportNow:" + z5 + ", isImportant" + z4);
                                    C7060h c7060h = C7060h.pYm;
                                    if (!C4996ah.bqo()) {
                                        C7060h.m11790a(bf, i3, str, z5, z6);
                                    } else if (C3730c.pXd) {
                                        long j4 = (long) bf;
                                        j = (long) i3;
                                        z5 = C3730c.pXe;
                                        C3744e.m6057a(j4, j, str, z5, z5, z6);
                                    } else {
                                        C3744e.m6057a((long) bf, (long) i3, str, z5, false, z6);
                                    }
                                }
                                C4990ab.m7410d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i)));
                                i2 = i;
                            }
                            C4990ab.m7410d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(absolutePath)));
                            C1173e.deleteFile(absolutePath);
                        }
                    }
                } catch (IOException e322) {
                    C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + e322.getMessage());
                    i2 = i;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(72734);
                }
            }
            AppMethodBeat.m2505o(72734);
            return;
        }
        C4990ab.m7420w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
        AppMethodBeat.m2505o(72734);
    }

    /* JADX WARNING: Missing block: B:25:0x01d7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(72735);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m6064a(int i, int i2, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(72735);
        if (C1173e.m2561ct(filePath)) {
            C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + i + ", type:" + i2 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + "," + z3);
            String cgr = C3745f.cgr();
            if ("MM".equals(cgr)) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + cgr + ", logId:" + i + ", type:" + i2 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + ", ignoreFreqLimit:" + z3);
                AppMethodBeat.m2505o(72735);
                return;
            }
            cgr = filePath + cgr + ".statictis_new2";
            C7056c c7056c = new C7056c();
            c7056c.pXL = i;
            c7056c.jCt = i2;
            c7056c.pXM = str;
            c7056c.pXE = z2;
            c7056c.pXN = z;
            c7056c.pXO = z3;
            try {
                byte[] toByteArray = c7056c.toByteArray();
                if (toByteArray == null) {
                    C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
                    AppMethodBeat.m2505o(72735);
                    return;
                }
                synchronized (pYa) {
                    try {
                        if (C1173e.m2568e(cgr, C3745f.intToByteArray(toByteArray.length)) != 0) {
                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + cgr + " fail.");
                        } else if (C1173e.m2568e(cgr, toByteArray) != 0) {
                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + cgr + " fail.");
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(72735);
                    }
                }
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e.getMessage());
                AppMethodBeat.m2505o(72735);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + i + ", type:" + i2 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + ", ignoreFreqLimit:" + z3);
        AppMethodBeat.m2505o(72735);
    }

    /* renamed from: d */
    public static void m6066d(int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(72736);
        C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
        if (C1173e.m2561ct(filePath)) {
            String cgr = C3745f.cgr();
            if ("MM".equals(cgr)) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + cgr + ", id:" + i + ", key:" + i2 + ", val:" + i3 + ", isImportant:" + z);
                AppMethodBeat.m2505o(72736);
                return;
            }
            cgr = filePath + cgr + ".monitor";
            C7055b c7055b = new C7055b();
            c7055b.f1968ID = i;
            c7055b.pXC = i2;
            c7055b.pXD = i3;
            c7055b.pXE = z;
            try {
                byte[] toByteArray = c7055b.toByteArray();
                if (toByteArray == null) {
                    C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
                    AppMethodBeat.m2505o(72736);
                    return;
                }
                synchronized (pYa) {
                    try {
                        if (C1173e.m2568e(cgr, C3745f.intToByteArray(toByteArray.length)) != 0) {
                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + cgr + " fail.");
                        } else {
                            if (C1173e.m2568e(cgr, toByteArray) != 0) {
                                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + cgr + " fail.");
                            }
                            C4990ab.m7410d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + C1173e.m2560cs(cgr));
                            AppMethodBeat.m2505o(72736);
                            return;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(72736);
                    }
                }
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e.getMessage());
                AppMethodBeat.m2505o(72736);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
        AppMethodBeat.m2505o(72736);
    }

    /* JADX WARNING: Missing block: B:32:0x0187, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(72737);
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public static void m6067e(ArrayList<IDKey> arrayList, boolean z) {
        IDKey iDKey;
        AppMethodBeat.m2504i(72737);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iDKey = (IDKey) it.next();
            C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + iDKey.GetID() + ", key:" + iDKey.GetKey() + ", value:" + iDKey.GetValue() + ", isImportant:" + z);
        }
        if (C1173e.m2561ct(filePath)) {
            String cgr = C3745f.cgr();
            if ("MM".equals(cgr)) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(cgr)));
                AppMethodBeat.m2505o(72737);
                return;
            }
            String str = filePath + cgr + ".group_monitor";
            C7054a c7054a = new C7054a();
            c7054a.jBv = arrayList.size();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                iDKey = (IDKey) it2.next();
                C7055b c7055b = new C7055b();
                c7055b.f1968ID = (int) iDKey.GetID();
                c7055b.pXC = (int) iDKey.GetKey();
                c7055b.pXD = (int) iDKey.GetValue();
                c7055b.pXE = z;
                c7054a.pXB.add(c7055b);
            }
            try {
                byte[] toByteArray = c7054a.toByteArray();
                if (toByteArray == null) {
                    C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
                    AppMethodBeat.m2505o(72737);
                    return;
                }
                synchronized (pYa) {
                    try {
                        if (C1173e.m2568e(str, C3745f.intToByteArray(toByteArray.length)) != 0) {
                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + str + " fail.");
                        } else if (C1173e.m2568e(str, toByteArray) != 0) {
                            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + str + " fail.");
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(72737);
                    }
                }
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + e.getMessage());
                AppMethodBeat.m2505o(72737);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
        AppMethodBeat.m2505o(72737);
    }

    private static String cgr() {
        AppMethodBeat.m2504i(72738);
        String processName = C4996ah.getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = "MM";
            AppMethodBeat.m2505o(72738);
            return processName;
        }
        String[] split = processName.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (split.length <= 1) {
            processName = "MM";
            AppMethodBeat.m2505o(72738);
            return processName;
        }
        processName = split[1];
        AppMethodBeat.m2505o(72738);
        return processName;
    }

    private static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: bf */
    private static int m6065bf(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 4) {
                return i3;
            }
            i = ((bArr[i2] & 255) << ((3 - i2) * 8)) + i3;
            i2++;
        }
    }
}
