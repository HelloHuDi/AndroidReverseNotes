package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class f {
    private static String filePath = (getAppFilePath() + "/kvcomm/exception/");
    private static Byte pYa = Byte.valueOf((byte) 0);

    static {
        AppMethodBeat.i(72739);
        if (!e.ct(filePath)) {
            e.cw(filePath);
        }
        AppMethodBeat.o(72739);
    }

    private static String getAppFilePath() {
        String str = null;
        AppMethodBeat.i(72733);
        Context context = ah.getContext();
        if (context == null) {
            AppMethodBeat.o(72733);
        } else {
            try {
                File filesDir = context.getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.createNewFile();
                }
                str = filesDir.toString();
                AppMethodBeat.o(72733);
            } catch (Exception e) {
                ab.e("MicroMsg.ReportManagerKvCheck", e.getMessage());
                AppMethodBeat.o(72733);
            }
        }
        return str;
    }

    public static void cgq() {
        int i;
        AppMethodBeat.i(72734);
        if (e.ct(filePath)) {
            File[] listFiles = new File(filePath).listFiles();
            if (listFiles == null) {
                ab.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
                AppMethodBeat.o(72734);
                return;
            }
            synchronized (pYa) {
                int i2;
                try {
                    for (File file : listFiles) {
                        if (file == null) {
                            ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
                        } else {
                            String absolutePath = file.getAbsolutePath();
                            i2 = 0;
                            int cs = e.cs(absolutePath);
                            ab.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + file.getAbsolutePath() + ", filelenth:" + cs);
                            while (i2 < cs) {
                                byte[] e = e.e(absolutePath, i2, 4);
                                if (e == null) {
                                    ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:".concat(String.valueOf(absolutePath)));
                                    break;
                                }
                                i2 += 4;
                                int bf = bf(e);
                                byte[] e2 = e.e(absolutePath, i2, bf);
                                if (e2 == null) {
                                    ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:".concat(String.valueOf(absolutePath)));
                                    break;
                                }
                                i = i2 + bf;
                                long j;
                                if (!absolutePath.contains(".statictis_new2")) {
                                    b bVar;
                                    if (!absolutePath.contains(".monitor")) {
                                        if (!absolutePath.contains(".group_monitor")) {
                                            ab.e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(absolutePath)));
                                            break;
                                        }
                                        a aVar = new a();
                                        try {
                                            aVar.parseFrom(e2);
                                            ArrayList arrayList = new ArrayList();
                                            boolean z = false;
                                            Iterator it = aVar.pXB.iterator();
                                            while (it.hasNext()) {
                                                bVar = (b) it.next();
                                                IDKey iDKey = new IDKey(bVar.ID, bVar.pXC, bVar.pXD);
                                                boolean z2 = bVar.pXE;
                                                arrayList.add(iDKey);
                                                ab.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + bVar.ID + ", key:" + bVar.pXC + ", value:" + bVar.pXD + ", isImportant" + z2);
                                                z = z2;
                                            }
                                            h.pYm.b(arrayList, z);
                                        } catch (IOException e3) {
                                            ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e3.getMessage());
                                            i2 = i;
                                        }
                                    } else {
                                        bVar = new b();
                                        try {
                                            bVar.parseFrom(e2);
                                            j = (long) bVar.ID;
                                            long j2 = (long) bVar.pXC;
                                            long j3 = (long) bVar.pXD;
                                            boolean z3 = bVar.pXE;
                                            ab.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + j + ", key:" + j2 + ", value:" + j3 + ", isImportant" + z3);
                                            h.pYm.a(j, j2, j3, z3);
                                        } catch (IOException e32) {
                                            ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e32.getMessage());
                                            i2 = i;
                                        }
                                    }
                                } else {
                                    c cVar = new c();
                                    cVar.parseFrom(e2);
                                    bf = cVar.pXL;
                                    int i3 = cVar.jCt;
                                    String str = cVar.pXM;
                                    boolean z4 = cVar.pXE;
                                    boolean z5 = cVar.pXN;
                                    boolean z6 = cVar.pXO;
                                    ab.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + bf + ", type:" + i3 + ", value:" + str + ", isReportNow:" + z5 + ", isImportant" + z4);
                                    h hVar = h.pYm;
                                    if (!ah.bqo()) {
                                        h.a(bf, i3, str, z5, z6);
                                    } else if (c.pXd) {
                                        long j4 = (long) bf;
                                        j = (long) i3;
                                        z5 = c.pXe;
                                        e.a(j4, j, str, z5, z5, z6);
                                    } else {
                                        e.a((long) bf, (long) i3, str, z5, false, z6);
                                    }
                                }
                                ab.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i)));
                                i2 = i;
                            }
                            ab.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(absolutePath)));
                            e.deleteFile(absolutePath);
                        }
                    }
                } catch (IOException e322) {
                    ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + e322.getMessage());
                    i2 = i;
                } catch (Throwable th) {
                    AppMethodBeat.o(72734);
                }
            }
            AppMethodBeat.o(72734);
            return;
        }
        ab.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
        AppMethodBeat.o(72734);
    }

    /* JADX WARNING: Missing block: B:25:0x01d7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(72735);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int i, int i2, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(72735);
        if (e.ct(filePath)) {
            ab.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + i + ", type:" + i2 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + "," + z3);
            String cgr = cgr();
            if ("MM".equals(cgr)) {
                ab.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + cgr + ", logId:" + i + ", type:" + i2 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + ", ignoreFreqLimit:" + z3);
                AppMethodBeat.o(72735);
                return;
            }
            cgr = filePath + cgr + ".statictis_new2";
            c cVar = new c();
            cVar.pXL = i;
            cVar.jCt = i2;
            cVar.pXM = str;
            cVar.pXE = z2;
            cVar.pXN = z;
            cVar.pXO = z3;
            try {
                byte[] toByteArray = cVar.toByteArray();
                if (toByteArray == null) {
                    ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
                    AppMethodBeat.o(72735);
                    return;
                }
                synchronized (pYa) {
                    try {
                        if (e.e(cgr, intToByteArray(toByteArray.length)) != 0) {
                            ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + cgr + " fail.");
                        } else if (e.e(cgr, toByteArray) != 0) {
                            ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + cgr + " fail.");
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(72735);
                    }
                }
            } catch (IOException e) {
                ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e.getMessage());
                AppMethodBeat.o(72735);
                return;
            }
        }
        ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + i + ", type:" + i2 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + ", ignoreFreqLimit:" + z3);
        AppMethodBeat.o(72735);
    }

    public static void d(int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(72736);
        ab.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
        if (e.ct(filePath)) {
            String cgr = cgr();
            if ("MM".equals(cgr)) {
                ab.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + cgr + ", id:" + i + ", key:" + i2 + ", val:" + i3 + ", isImportant:" + z);
                AppMethodBeat.o(72736);
                return;
            }
            cgr = filePath + cgr + ".monitor";
            b bVar = new b();
            bVar.ID = i;
            bVar.pXC = i2;
            bVar.pXD = i3;
            bVar.pXE = z;
            try {
                byte[] toByteArray = bVar.toByteArray();
                if (toByteArray == null) {
                    ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
                    AppMethodBeat.o(72736);
                    return;
                }
                synchronized (pYa) {
                    try {
                        if (e.e(cgr, intToByteArray(toByteArray.length)) != 0) {
                            ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + cgr + " fail.");
                        } else {
                            if (e.e(cgr, toByteArray) != 0) {
                                ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + cgr + " fail.");
                            }
                            ab.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + e.cs(cgr));
                            AppMethodBeat.o(72736);
                            return;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(72736);
                    }
                }
            } catch (IOException e) {
                ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e.getMessage());
                AppMethodBeat.o(72736);
                return;
            }
        }
        ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
        AppMethodBeat.o(72736);
    }

    /* JADX WARNING: Missing block: B:32:0x0187, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(72737);
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(ArrayList<IDKey> arrayList, boolean z) {
        IDKey iDKey;
        AppMethodBeat.i(72737);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iDKey = (IDKey) it.next();
            ab.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + iDKey.GetID() + ", key:" + iDKey.GetKey() + ", value:" + iDKey.GetValue() + ", isImportant:" + z);
        }
        if (e.ct(filePath)) {
            String cgr = cgr();
            if ("MM".equals(cgr)) {
                ab.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(cgr)));
                AppMethodBeat.o(72737);
                return;
            }
            String str = filePath + cgr + ".group_monitor";
            a aVar = new a();
            aVar.jBv = arrayList.size();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                iDKey = (IDKey) it2.next();
                b bVar = new b();
                bVar.ID = (int) iDKey.GetID();
                bVar.pXC = (int) iDKey.GetKey();
                bVar.pXD = (int) iDKey.GetValue();
                bVar.pXE = z;
                aVar.pXB.add(bVar);
            }
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (toByteArray == null) {
                    ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
                    AppMethodBeat.o(72737);
                    return;
                }
                synchronized (pYa) {
                    try {
                        if (e.e(str, intToByteArray(toByteArray.length)) != 0) {
                            ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + str + " fail.");
                        } else if (e.e(str, toByteArray) != 0) {
                            ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + str + " fail.");
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(72737);
                    }
                }
            } catch (IOException e) {
                ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + e.getMessage());
                AppMethodBeat.o(72737);
                return;
            }
        }
        ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
        AppMethodBeat.o(72737);
    }

    private static String cgr() {
        AppMethodBeat.i(72738);
        String processName = ah.getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = "MM";
            AppMethodBeat.o(72738);
            return processName;
        }
        String[] split = processName.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (split.length <= 1) {
            processName = "MM";
            AppMethodBeat.o(72738);
            return processName;
        }
        processName = split[1];
        AppMethodBeat.o(72738);
        return processName;
    }

    private static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static int bf(byte[] bArr) {
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
