package com.tencent.p177mm.plugin.voip.p1417a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.protocal.protobuf.ccy;
import com.tencent.p177mm.protocal.protobuf.coj;
import com.tencent.p177mm.protocal.protobuf.cok;
import com.tencent.p177mm.protocal.protobuf.cps;
import com.tencent.p177mm.protocal.protobuf.cqe;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.voip.a.a */
public final class C46317a {
    static BufferedOutputStream mOutputStream = null;
    private static int nCF = 0;
    public static boolean sZe = false;
    private static long sZf = 0;
    private static long sZg = 0;

    public static int getNetType(Context context) {
        AppMethodBeat.m2504i(4983);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(4983);
                return 2;
            }
            C4990ab.m7417i("MicroMsg.VoipHelper", "getNetType: %s %s", Integer.valueOf(activeNetworkInfo.getType()), Integer.valueOf(activeNetworkInfo.getSubtype()));
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(4983);
                return 4;
            } else if (activeNetworkInfo.getType() != 0) {
                AppMethodBeat.m2505o(4983);
                return 2;
            } else if (activeNetworkInfo.getSubtype() == 1) {
                AppMethodBeat.m2505o(4983);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.m2505o(4983);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 13 || activeNetworkInfo.getSubtype() == 19) {
                AppMethodBeat.m2505o(4983);
                return 5;
            } else if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                AppMethodBeat.m2505o(4983);
                return 1;
            } else {
                AppMethodBeat.m2505o(4983);
                return 3;
            }
        } catch (NullPointerException e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(4983);
            return 2;
        }
    }

    public static void cLs() {
    }

    private static void writeLogToFile(String str) {
        AppMethodBeat.m2504i(4984);
        if (mOutputStream == null) {
            AppMethodBeat.m2505o(4984);
            return;
        }
        try {
            mOutputStream.write(str.getBytes());
            AppMethodBeat.m2505o(4984);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(4984);
        }
    }

    public static void flushLogFile() {
        AppMethodBeat.m2504i(4985);
        if (mOutputStream == null) {
            AppMethodBeat.m2505o(4985);
            return;
        }
        try {
            mOutputStream.flush();
            AppMethodBeat.m2505o(4985);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(4985);
        }
    }

    /* renamed from: bv */
    public static int m86990bv(byte[] bArr) {
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

    /* renamed from: GF */
    public static byte[] m86980GF(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static void Loge(String str, String str2) {
        AppMethodBeat.m2504i(4986);
        C4990ab.m7412e(str, "[" + Thread.currentThread().getId() + "]" + str2);
        C46317a.writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.m2505o(4986);
    }

    public static void Logi(String str, String str2) {
        AppMethodBeat.m2504i(4987);
        C4990ab.m7416i(str, "[" + Thread.currentThread().getId() + "]" + str2);
        C46317a.writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.m2505o(4987);
    }

    public static void Logd(String str, String str2) {
        AppMethodBeat.m2504i(4988);
        C4990ab.m7410d(str, "[" + Thread.currentThread().getId() + "]" + str2);
        C46317a.writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.m2505o(4988);
    }

    public static void Logw(String str, String str2) {
        AppMethodBeat.m2504i(4989);
        C4990ab.m7420w(str, "[" + Thread.currentThread().getId() + "]" + str2);
        C46317a.writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.m2505o(4989);
    }

    public static void outputJniLog(byte[] bArr, String str, int i) {
        AppMethodBeat.m2504i(4990);
        if (C5046bo.m7540cb(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            C4990ab.m7412e(str, str2);
        } else if (i == 2) {
            C4990ab.m7416i(str, str2);
        } else {
            C4990ab.m7410d(str, str2);
        }
        if (str.equals("MicroMsg.v2Core")) {
            C46317a.writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
            AppMethodBeat.m2505o(4990);
            return;
        }
        C46317a.writeLogToFile(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " \n");
        AppMethodBeat.m2505o(4990);
    }

    /* renamed from: GG */
    public static void m86981GG(int i) {
        AppMethodBeat.m2504i(4991);
        try {
            Thread.sleep((long) i);
            AppMethodBeat.m2505o(4991);
        } catch (InterruptedException e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(4991);
        }
    }

    /* renamed from: a */
    public static int[] m86987a(cok cok) {
        int i;
        AppMethodBeat.m2504i(4992);
        C4990ab.m7410d("MicroMsg.VoipHelper", "convertSvrAddr: voipAddr.Cnt " + cok.xlZ);
        if (3 >= cok.xlZ) {
            i = cok.xlZ;
        } else {
            i = 3;
        }
        C4990ab.m7410d("MicroMsg.VoipHelper", "convertSvrAddr: addrCnt ".concat(String.valueOf(i)));
        int[] iArr = new int[(i * 2)];
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < cok.xma.size()) {
                iArr[i2 * 2] = ((coj) cok.xma.get(i2)).xfs;
                iArr[(i2 * 2) + 1] = ((coj) cok.xma.get(i2)).wOO;
                C4990ab.m7410d("MicroMsg.VoipHelper", "convertSvrAddr: ip " + C46317a.m86982GH(((coj) cok.xma.get(i2)).xfs) + " Port: " + ((coj) cok.xma.get(i2)).wOO);
            }
        }
        AppMethodBeat.m2505o(4992);
        return iArr;
    }

    /* renamed from: au */
    public static int[] m86989au(LinkedList<cps> linkedList) {
        AppMethodBeat.m2504i(4993);
        int[] iArr = new int[(linkedList.size() * 5)];
        for (int i = 0; i < linkedList.size(); i++) {
            iArr[(i * 5) + 0] = ((coj) ((cps) linkedList.get(i)).xma.get(0)).xfs;
            iArr[(i * 5) + 1] = ((coj) ((cps) linkedList.get(i)).xma.get(0)).wOO;
            iArr[(i * 5) + 2] = ((coj) ((cps) linkedList.get(i)).xma.get(1)).xfs;
            iArr[(i * 5) + 3] = ((coj) ((cps) linkedList.get(i)).xma.get(1)).wOO;
            iArr[(i * 5) + 4] = ((coj) ((cps) linkedList.get(i)).xma.get(2)).wOO;
        }
        AppMethodBeat.m2505o(4993);
        return iArr;
    }

    /* renamed from: a */
    public static int[] m86988a(cqe cqe) {
        int i;
        AppMethodBeat.m2504i(4994);
        C4990ab.m7410d("MicroMsg.VoipHelper", "convertSpeedTestPara: testID= " + cqe.xod + " SvrListCnt= " + cqe.xoi);
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
            C4990ab.m7410d("MicroMsg.VoipHelper", "convertSpeedTestPara: ip " + C46317a.m86982GH(((ccy) cqe.xoj.get(i2)).xch.xfs) + " Port: " + ((ccy) cqe.xoj.get(i2)).xch.wOO + " TestCnt= " + ((ccy) cqe.xoj.get(i2)).xcg + " TestGap= " + ((ccy) cqe.xoj.get(i2)).xcC + " Timeout= " + ((ccy) cqe.xoj.get(i2)).xcD + " PktSize= " + ((ccy) cqe.xoj.get(i2)).xcE);
        }
        AppMethodBeat.m2505o(4994);
        return iArr;
    }

    /* renamed from: Pz */
    public static int m86985Pz(String str) {
        AppMethodBeat.m2504i(4996);
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                for (byte b : address) {
                    i = (i << 8) | (b & 255);
                }
                C4990ab.m7411d("MicroMsg.VoipHelper", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i));
                AppMethodBeat.m2505o(4996);
                return i;
            }
        } catch (UnknownHostException e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(4996);
        return 0;
    }

    /* renamed from: c */
    public static void m86991c(int i, long j, int i2, int i3) {
        AppMethodBeat.m2504i(4997);
        if (!(C43727b.cIj().cJZ() == 0 || C43727b.cIj().cKa() == 0)) {
            sZf = C43727b.cIj().cIK();
            nCF = i;
            sZg = j;
        }
        C7060h.pYm.mo8377a(16516, true, true, Long.valueOf(sZf), Integer.valueOf(nCF), Long.valueOf(sZg), Integer.valueOf(i2), Integer.valueOf(i3));
        C4990ab.m7416i("MicroMsg.VoipHelper", "room type " + sZf + "room id" + nCF + "room key" + sZg + "call type " + i2 + "type " + i3);
        AppMethodBeat.m2505o(4997);
    }

    /* renamed from: GI */
    public static void m86983GI(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = 2;
        AppMethodBeat.m2504i(4998);
        if (C41711b.m73393fP(26)) {
            i2 = C37885a.m63954MG() ? 1 : 2;
            if (C37885a.m63956MI()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        } else {
            if (C37885a.m63961MN()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (C37885a.m63962MO()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[12];
        objArr[0] = Integer.valueOf(C43727b.cIj().cJZ());
        objArr[1] = Long.valueOf(C43727b.cIj().cKa());
        objArr[2] = Long.valueOf(C43727b.cIj().cIK());
        if (C41753a.isActive()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[3] = Integer.valueOf(i4);
        if (C37885a.m63950MC()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[4] = Integer.valueOf(i4);
        if (C37885a.m63952ME()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[5] = Integer.valueOf(i4);
        if (C37885a.m63953MF()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        objArr[6] = Integer.valueOf(i4);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = Integer.valueOf(i3);
        if (C37885a.m63955MH()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        objArr[9] = Integer.valueOf(i2);
        if (C37885a.m63957MJ()) {
            i5 = 1;
        }
        objArr[10] = Integer.valueOf(i5);
        objArr[11] = Integer.valueOf(i);
        c7060h.mo8377a(16366, true, true, objArr);
        AppMethodBeat.m2505o(4998);
    }

    /* renamed from: a */
    public static void m86986a(int i, long j, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(4999);
        C4990ab.m7417i("MicroMsg.VoipHelper", "before convert, beforeNetType:%s, afterNetType:%s", Integer.valueOf(i2), Integer.valueOf(i5));
        int GJ = C46317a.m86984GJ(i2);
        int GJ2 = C46317a.m86984GJ(i3);
        C4990ab.m7417i("MicroMsg.VoipHelper", "after convert, beforeNetType:%s, afterNetType:%s", Integer.valueOf(GJ), Integer.valueOf(i5));
        C7060h.pYm.mo8377a(16519, true, true, Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(GJ), Integer.valueOf(GJ2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        C4990ab.m7416i("MicroMsg.VoipHelper", "reportVoipNetChangeCost is memberIdx =" + i + "|switchNetworkTimestamp " + j + "|beforeNetType " + GJ + "|afterNetType" + GJ2 + "|beforeNetStrength" + i4 + "|afterNetStrength" + i5 + "|avgNetStrength" + i6);
        AppMethodBeat.m2505o(4999);
    }

    /* renamed from: GJ */
    private static int m86984GJ(int i) {
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

    /* renamed from: GH */
    private static String m86982GH(int i) {
        AppMethodBeat.m2504i(4995);
        try {
            String hostAddress = InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
            AppMethodBeat.m2505o(4995);
            return hostAddress;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(4995);
            return null;
        }
    }
}
