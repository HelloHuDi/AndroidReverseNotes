package com.tencent.mm.plugin.voip.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

public final class a {
    static BufferedOutputStream mOutputStream = null;
    private static int nCF = 0;
    public static boolean sZe = false;
    private static long sZf = 0;
    private static long sZg = 0;

    public static int getNetType(Context context) {
        AppMethodBeat.i(4983);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(4983);
                return 2;
            }
            ab.i("MicroMsg.VoipHelper", "getNetType: %s %s", Integer.valueOf(activeNetworkInfo.getType()), Integer.valueOf(activeNetworkInfo.getSubtype()));
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(4983);
                return 4;
            } else if (activeNetworkInfo.getType() != 0) {
                AppMethodBeat.o(4983);
                return 2;
            } else if (activeNetworkInfo.getSubtype() == 1) {
                AppMethodBeat.o(4983);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.o(4983);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 13 || activeNetworkInfo.getSubtype() == 19) {
                AppMethodBeat.o(4983);
                return 5;
            } else if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                AppMethodBeat.o(4983);
                return 1;
            } else {
                AppMethodBeat.o(4983);
                return 3;
            }
        } catch (NullPointerException e) {
            ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.o(4983);
            return 2;
        }
    }

    public static void cLs() {
    }

    private static void writeLogToFile(String str) {
        AppMethodBeat.i(4984);
        if (mOutputStream == null) {
            AppMethodBeat.o(4984);
            return;
        }
        try {
            mOutputStream.write(str.getBytes());
            AppMethodBeat.o(4984);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.o(4984);
        }
    }

    public static void flushLogFile() {
        AppMethodBeat.i(4985);
        if (mOutputStream == null) {
            AppMethodBeat.o(4985);
            return;
        }
        try {
            mOutputStream.flush();
            AppMethodBeat.o(4985);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.o(4985);
        }
    }

    public static int bv(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 4) {
                return i3;
            }
            i = ((bArr[i2] & 255) << (i2 * 8)) | i3;
            i2++;
        }
    }

    public static byte[] GF(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static void Loge(String str, String str2) {
        AppMethodBeat.i(4986);
        ab.e(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.o(4986);
    }

    public static void Logi(String str, String str2) {
        AppMethodBeat.i(4987);
        ab.i(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.o(4987);
    }

    public static void Logd(String str, String str2) {
        AppMethodBeat.i(4988);
        ab.d(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.o(4988);
    }

    public static void Logw(String str, String str2) {
        AppMethodBeat.i(4989);
        ab.w(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.o(4989);
    }

    public static void outputJniLog(byte[] bArr, String str, int i) {
        AppMethodBeat.i(4990);
        if (bo.cb(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            ab.e(str, str2);
        } else if (i == 2) {
            ab.i(str, str2);
        } else {
            ab.d(str, str2);
        }
        if (str.equals("MicroMsg.v2Core")) {
            writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
            AppMethodBeat.o(4990);
            return;
        }
        writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.o(4990);
    }

    public static void GG(int i) {
        AppMethodBeat.i(4991);
        try {
            Thread.sleep((long) i);
            AppMethodBeat.o(4991);
        } catch (InterruptedException e) {
            ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.o(4991);
        }
    }

    public static int[] a(cok cok) {
        int i;
        AppMethodBeat.i(4992);
        ab.d("MicroMsg.VoipHelper", "convertSvrAddr: voipAddr.Cnt " + cok.xlZ);
        if (3 >= cok.xlZ) {
            i = cok.xlZ;
        } else {
            i = 3;
        }
        ab.d("MicroMsg.VoipHelper", "convertSvrAddr: addrCnt ".concat(String.valueOf(i)));
        int[] iArr = new int[(i * 2)];
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < cok.xma.size()) {
                iArr[i2 * 2] = ((coj) cok.xma.get(i2)).xfs;
                iArr[(i2 * 2) + 1] = ((coj) cok.xma.get(i2)).wOO;
                ab.d("MicroMsg.VoipHelper", "convertSvrAddr: ip " + GH(((coj) cok.xma.get(i2)).xfs) + " Port: " + ((coj) cok.xma.get(i2)).wOO);
            }
        }
        AppMethodBeat.o(4992);
        return iArr;
    }

    public static int[] au(LinkedList<cps> linkedList) {
        AppMethodBeat.i(4993);
        int[] iArr = new int[(linkedList.size() * 5)];
        for (int i = 0; i < linkedList.size(); i++) {
            iArr[(i * 5) + 0] = ((coj) ((cps) linkedList.get(i)).xma.get(0)).xfs;
            iArr[(i * 5) + 1] = ((coj) ((cps) linkedList.get(i)).xma.get(0)).wOO;
            iArr[(i * 5) + 2] = ((coj) ((cps) linkedList.get(i)).xma.get(1)).xfs;
            iArr[(i * 5) + 3] = ((coj) ((cps) linkedList.get(i)).xma.get(1)).wOO;
            iArr[(i * 5) + 4] = ((coj) ((cps) linkedList.get(i)).xma.get(2)).wOO;
        }
        AppMethodBeat.o(4993);
        return iArr;
    }

    public static int[] a(cqe cqe) {
        int i;
        AppMethodBeat.i(4994);
        ab.d("MicroMsg.VoipHelper", "convertSpeedTestPara: testID= " + cqe.xod + " SvrListCnt= " + cqe.xoi);
        if (3 >= cqe.xoi) {
            i = cqe.xoi;
        } else {
            i = 3;
        }
        int[] iArr = new int[(i * 6)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 6] = ((ccy) cqe.xoj.get(i2)).xch.xfs;
            iArr[(i2 * 6) + 1] = ((ccy) cqe.xoj.get(i2)).xch.wOO;
            iArr[(i2 * 6) + 2] = ((ccy) cqe.xoj.get(i2)).xcg;
            iArr[(i2 * 6) + 3] = ((ccy) cqe.xoj.get(i2)).xcC;
            iArr[(i2 * 6) + 4] = ((ccy) cqe.xoj.get(i2)).xcD;
            iArr[(i2 * 6) + 5] = ((ccy) cqe.xoj.get(i2)).xcE;
            ab.d("MicroMsg.VoipHelper", "convertSpeedTestPara: ip " + GH(((ccy) cqe.xoj.get(i2)).xch.xfs) + " Port: " + ((ccy) cqe.xoj.get(i2)).xch.wOO + " TestCnt= " + ((ccy) cqe.xoj.get(i2)).xcg + " TestGap= " + ((ccy) cqe.xoj.get(i2)).xcC + " Timeout= " + ((ccy) cqe.xoj.get(i2)).xcD + " PktSize= " + ((ccy) cqe.xoj.get(i2)).xcE);
        }
        AppMethodBeat.o(4994);
        return iArr;
    }

    public static int Pz(String str) {
        AppMethodBeat.i(4996);
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                for (byte b : address) {
                    i = (i << 8) | (b & 255);
                }
                ab.d("MicroMsg.VoipHelper", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i));
                AppMethodBeat.o(4996);
                return i;
            }
        } catch (UnknownHostException e) {
            ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(4996);
        return 0;
    }

    public static void c(int i, long j, int i2, int i3) {
        AppMethodBeat.i(4997);
        if (!(b.cIj().cJZ() == 0 || b.cIj().cKa() == 0)) {
            sZf = b.cIj().cIK();
            nCF = i;
            sZg = j;
        }
        h.pYm.a(16516, true, true, Long.valueOf(sZf), Integer.valueOf(nCF), Long.valueOf(sZg), Integer.valueOf(i2), Integer.valueOf(i3));
        ab.i("MicroMsg.VoipHelper", "room type " + sZf + "room id" + nCF + "room key" + sZg + "call type " + i2 + "type " + i3);
        AppMethodBeat.o(4997);
    }

    public static void GI(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = 2;
        AppMethodBeat.i(4998);
        if (com.tencent.luggage.g.b.fP(26)) {
            i2 = com.tencent.mm.m.a.MG() ? 1 : 2;
            if (com.tencent.mm.m.a.MI()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        } else {
            if (com.tencent.mm.m.a.MN()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (com.tencent.mm.m.a.MO()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        }
        h hVar = h.pYm;
        Object[] objArr = new Object[12];
        objArr[0] = Integer.valueOf(b.cIj().cJZ());
        objArr[1] = Long.valueOf(b.cIj().cKa());
        objArr[2] = Long.valueOf(b.cIj().cIK());
        if (com.tencent.mm.an.a.isActive()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[3] = Integer.valueOf(i4);
        if (com.tencent.mm.m.a.MC()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[4] = Integer.valueOf(i4);
        if (com.tencent.mm.m.a.ME()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[5] = Integer.valueOf(i4);
        if (com.tencent.mm.m.a.MF()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[6] = Integer.valueOf(i4);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = Integer.valueOf(i3);
        if (com.tencent.mm.m.a.MH()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        objArr[9] = Integer.valueOf(i2);
        if (com.tencent.mm.m.a.MJ()) {
            i5 = 1;
        }
        objArr[10] = Integer.valueOf(i5);
        objArr[11] = Integer.valueOf(i);
        hVar.a(16366, true, true, objArr);
        AppMethodBeat.o(4998);
    }

    public static void a(int i, long j, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(4999);
        ab.i("MicroMsg.VoipHelper", "before convert, beforeNetType:%s, afterNetType:%s", Integer.valueOf(i2), Integer.valueOf(i5));
        int GJ = GJ(i2);
        int GJ2 = GJ(i3);
        ab.i("MicroMsg.VoipHelper", "after convert, beforeNetType:%s, afterNetType:%s", Integer.valueOf(GJ), Integer.valueOf(i5));
        h.pYm.a(16519, true, true, Long.valueOf(b.cIj().cIK()), Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(GJ), Integer.valueOf(GJ2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        ab.i("MicroMsg.VoipHelper", "reportVoipNetChangeCost is memberIdx =" + i + "|switchNetworkTimestamp " + j + "|beforeNetType " + GJ + "|afterNetType" + GJ2 + "|beforeNetStrength" + i4 + "|afterNetStrength" + i5 + "|avgNetStrength" + i6);
        AppMethodBeat.o(4999);
    }

    private static int GJ(int i) {
        switch (i) {
            case 2:
                return 4;
            case 3:
                return 2;
            case 4:
                return 5;
            case 5:
                return 3;
            default:
                return i;
        }
    }

    private static String GH(int i) {
        AppMethodBeat.i(4995);
        try {
            String hostAddress = InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
            AppMethodBeat.o(4995);
            return hostAddress;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.o(4995);
            return null;
        }
    }
}
