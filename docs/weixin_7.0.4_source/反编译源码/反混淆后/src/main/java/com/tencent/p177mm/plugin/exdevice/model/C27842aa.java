package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.service.C43000j.C43001a;
import com.tencent.p177mm.protocal.protobuf.C15350iq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.exdevice.model.aa */
public final class C27842aa extends C43001a implements C1202f {
    static Object cli = new Object();
    private static final byte[] ltL = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static C27842aa ltM;
    static LinkedList<String> ltQ = new LinkedList();
    private static HashMap<String, C15350iq> ltR = new HashMap(32);
    final C7564ap gGo = new C7564ap(new C278411(), true);
    boolean lsZ = false;
    volatile String lst;
    C27843a ltN;
    HashMap<String, byte[]> ltO = new HashMap();
    LinkedList<C1207m> ltP = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.aa$1 */
    class C278411 implements C5015a {
        C278411() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(19358);
            C4990ab.m7416i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
            C45891ad.bpd().mo7176a(0, C27842aa.this);
            AppMethodBeat.m2505o(19358);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.aa$a */
    public interface C27843a {
        /* renamed from: a */
        void mo35798a(String str, byte[] bArr, boolean z);
    }

    static {
        AppMethodBeat.m2504i(19366);
        AppMethodBeat.m2505o(19366);
    }

    public static C27842aa boT() {
        AppMethodBeat.m2504i(19359);
        C27842aa c27842aa;
        if (ltM != null) {
            c27842aa = ltM;
            AppMethodBeat.m2505o(19359);
            return c27842aa;
        }
        c27842aa = new C27842aa();
        ltM = c27842aa;
        AppMethodBeat.m2505o(19359);
        return c27842aa;
    }

    private C27842aa() {
        AppMethodBeat.m2504i(19360);
        AppMethodBeat.m2505o(19360);
    }

    /* renamed from: uK */
    public final void mo45714uK(int i) {
        AppMethodBeat.m2504i(19361);
        C4990ab.m7417i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", Integer.valueOf(i));
        this.gGo.stopTimer();
        if (this.lsZ) {
            C45891ad.bpd().mo7183uJ(i);
            this.lsZ = false;
            this.lst = null;
            this.ltO.clear();
            C9638aw.m17182Rg().mo14546b(542, (C1202f) this);
            Iterator it = this.ltP.iterator();
            while (it.hasNext()) {
                C1207m c1207m = (C1207m) it.next();
                if (c1207m != null) {
                    C9638aw.m17182Rg().mo14547c(c1207m);
                }
            }
            this.ltP.clear();
            if (this.ltN != null) {
                this.ltN.mo35798a(null, null, true);
            }
            this.ltN = null;
        } else {
            C4990ab.m7416i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
        }
        synchronized (cli) {
            try {
                ltQ.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(19361);
            }
        }
    }

    /* JADX WARNING: Missing block: B:38:0x00cf, code skipped:
            r1 = new com.tencent.p177mm.plugin.exdevice.model.C42994k(new java.lang.String[]{r11}, r7.lst);
     */
    /* JADX WARNING: Missing block: B:39:0x00e5, code skipped:
            if (com.tencent.p177mm.model.C9638aw.m17182Rg().mo14541a(r1, 0) == false) goto L_0x00fb;
     */
    /* JADX WARNING: Missing block: B:40:0x00e7, code skipped:
            r7.ltP.add(r1);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(19362);
     */
    /* JADX WARNING: Missing block: B:45:0x00fb, code skipped:
            ltQ.remove(r0);
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(19362);
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:56:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo7194a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(19362);
        if (this.ltO.containsKey(str2)) {
            AppMethodBeat.m2505o(19362);
        } else if (str2 == null) {
            C4990ab.m7420w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
            AppMethodBeat.m2505o(19362);
        } else {
            int i4;
            String replaceAll = str2.replaceAll(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "");
            byte[] bArr2 = ltL;
            if (C5046bo.m7540cb(bArr) || C5046bo.m7540cb(bArr2) || bArr2.length > bArr.length) {
                i4 = -1;
            } else {
                i4 = 0;
                while (i4 < bArr.length) {
                    if (C42992b.m76354c(bArr, i4, bArr2)) {
                        break;
                    }
                    i4++;
                }
                i4 = -1;
            }
            if (i4 == -1) {
                this.ltO.put(replaceAll, null);
            } else if (i4 + 9 <= bArr.length) {
                byte[] bArr3 = new byte[(i4 + 9)];
                System.arraycopy(bArr, 0, bArr3, 0, bArr3.length);
                C4990ab.m7417i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", replaceAll, C42992b.m76349aN(bArr3));
                this.ltO.put(replaceAll, bArr3);
            } else {
                this.ltO.put(replaceAll, null);
            }
            String str4 = this.lst + "_" + str2;
            if (ltR.containsKey(str4)) {
                C4990ab.m7411d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", this.lst, str2);
                m44263a((C15350iq) ltR.get(str4));
                AppMethodBeat.m2505o(19362);
                return;
            }
            synchronized (cli) {
                try {
                    if (ltQ.contains(str4)) {
                        C4990ab.m7410d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
                    } else {
                        ltQ.add(str4);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(19362);
                }
            }
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19363);
        String str2 = "MicroMsg.exdevice.ScanDeviceLogic";
        String str3 = "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s";
        Object[] objArr = new Object[4];
        objArr[0] = c1207m == null ? "" : Integer.valueOf(c1207m.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        C4990ab.m7417i(str2, str3, objArr);
        this.ltP.remove(c1207m);
        if (i == 0 && i2 == 0 && c1207m != null) {
            if (542 == c1207m.getType()) {
                Iterator it = ((C42994k) c1207m).boO().vKJ.iterator();
                while (it.hasNext()) {
                    C15350iq c15350iq = (C15350iq) it.next();
                    if (C5046bo.isNullOrNil(c15350iq.vKF)) {
                        C4990ab.m7412e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
                    } else {
                        str3 = this.lst + "_" + c15350iq.vKF;
                        synchronized (cli) {
                            try {
                                if (ltQ.contains(str3)) {
                                    ltQ.remove(str3);
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.m2505o(19363);
                                }
                            }
                        }
                        if (!ltR.containsKey(str3)) {
                            C4990ab.m7417i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", str3);
                            ltR.put(str3, c15350iq);
                        }
                        m44263a(c15350iq);
                    }
                }
            }
            AppMethodBeat.m2505o(19363);
            return;
        }
        C4990ab.m7412e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
        AppMethodBeat.m2505o(19363);
    }

    /* renamed from: a */
    private void m44263a(C15350iq c15350iq) {
        AppMethodBeat.m2504i(19364);
        if (c15350iq == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
            AppMethodBeat.m2505o(19364);
        } else if (C5046bo.isNullOrNil(c15350iq.vKF)) {
            C4990ab.m7412e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
            AppMethodBeat.m2505o(19364);
        } else if (c15350iq.Ret != 0) {
            C4990ab.m7413e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", c15350iq.vKF);
            AppMethodBeat.m2505o(19364);
        } else if (c15350iq.vKM == null || C5046bo.isNullOrNil(c15350iq.vKM.jBE)) {
            C4990ab.m7413e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", c15350iq.vKF);
            AppMethodBeat.m2505o(19364);
        } else if (C5046bo.isNullOrNil(c15350iq.vKM.vIk) || !c15350iq.vKM.vIk.equals(this.lst)) {
            C4990ab.m7413e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", c15350iq.jBF, this.lst);
            AppMethodBeat.m2505o(19364);
        } else {
            byte[] bArr = (byte[]) this.ltO.get(c15350iq.vKF);
            String str = "MicroMsg.exdevice.ScanDeviceLogic";
            String str2 = "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s";
            Object[] objArr = new Object[5];
            objArr[0] = c15350iq.vKF;
            objArr[1] = c15350iq.vKM.vIk;
            objArr[2] = c15350iq.vKM.jBE;
            objArr[3] = c15350iq.jBF;
            objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            C4990ab.m7417i(str, str2, objArr);
            if (this.ltN != null) {
                if (bArr != null) {
                    bArr = C27842aa.m44264aM(bArr);
                } else {
                    bArr = null;
                }
                this.ltN.mo35798a(c15350iq.vKM.jBE, bArr, false);
                AppMethodBeat.m2505o(19364);
                return;
            }
            C4990ab.m7412e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
            AppMethodBeat.m2505o(19364);
        }
    }

    /* renamed from: aM */
    private static byte[] m44264aM(byte[] bArr) {
        AppMethodBeat.m2504i(19365);
        byte[] bArr2 = null;
        int i = 0;
        int i2 = 0;
        while (i < bArr.length - 2) {
            try {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b != (byte) 0) {
                    i = i3 + 1;
                    switch (bArr[i3]) {
                        case (byte) -1:
                            C4990ab.m7417i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", Integer.valueOf(b));
                            byte[] bArr3 = new byte[(b - 1)];
                            int i4 = b;
                            while (i4 > 1) {
                                int i5;
                                int i6;
                                if (i2 >= 32 || i2 >= bArr3.length) {
                                    i5 = i;
                                    i6 = i2;
                                } else {
                                    i6 = i2 + 1;
                                    i5 = i + 1;
                                    bArr3[i2] = bArr[i];
                                }
                                i4--;
                                i = i5;
                                i2 = i6;
                            }
                            C4990ab.m7416i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + C42992b.m76349aN(bArr3));
                            bArr2 = bArr3;
                            break;
                        default:
                            i += b - 1;
                            break;
                    }
                }
                AppMethodBeat.m2505o(19365);
                return bArr2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", e.getMessage());
                AppMethodBeat.m2505o(19365);
                return null;
            }
        }
        AppMethodBeat.m2505o(19365);
        return bArr2;
    }
}
