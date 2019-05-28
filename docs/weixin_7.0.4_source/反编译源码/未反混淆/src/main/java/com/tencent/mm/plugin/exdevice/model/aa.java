package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa extends com.tencent.mm.plugin.exdevice.service.j.a implements f {
    static Object cli = new Object();
    private static final byte[] ltL = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static aa ltM;
    static LinkedList<String> ltQ = new LinkedList();
    private static HashMap<String, iq> ltR = new HashMap(32);
    final ap gGo = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(19358);
            ab.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
            ad.bpd().a(0, aa.this);
            AppMethodBeat.o(19358);
            return true;
        }
    }, true);
    boolean lsZ = false;
    volatile String lst;
    a ltN;
    HashMap<String, byte[]> ltO = new HashMap();
    LinkedList<m> ltP = new LinkedList();

    public interface a {
        void a(String str, byte[] bArr, boolean z);
    }

    static {
        AppMethodBeat.i(19366);
        AppMethodBeat.o(19366);
    }

    public static aa boT() {
        AppMethodBeat.i(19359);
        aa aaVar;
        if (ltM != null) {
            aaVar = ltM;
            AppMethodBeat.o(19359);
            return aaVar;
        }
        aaVar = new aa();
        ltM = aaVar;
        AppMethodBeat.o(19359);
        return aaVar;
    }

    private aa() {
        AppMethodBeat.i(19360);
        AppMethodBeat.o(19360);
    }

    public final void uK(int i) {
        AppMethodBeat.i(19361);
        ab.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", Integer.valueOf(i));
        this.gGo.stopTimer();
        if (this.lsZ) {
            ad.bpd().uJ(i);
            this.lsZ = false;
            this.lst = null;
            this.ltO.clear();
            aw.Rg().b(542, (f) this);
            Iterator it = this.ltP.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (mVar != null) {
                    aw.Rg().c(mVar);
                }
            }
            this.ltP.clear();
            if (this.ltN != null) {
                this.ltN.a(null, null, true);
            }
            this.ltN = null;
        } else {
            ab.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
        }
        synchronized (cli) {
            try {
                ltQ.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(19361);
            }
        }
    }

    /* JADX WARNING: Missing block: B:38:0x00cf, code skipped:
            r1 = new com.tencent.mm.plugin.exdevice.model.k(new java.lang.String[]{r11}, r7.lst);
     */
    /* JADX WARNING: Missing block: B:39:0x00e5, code skipped:
            if (com.tencent.mm.model.aw.Rg().a(r1, 0) == false) goto L_0x00fb;
     */
    /* JADX WARNING: Missing block: B:40:0x00e7, code skipped:
            r7.ltP.add(r1);
            com.tencent.matrix.trace.core.AppMethodBeat.o(19362);
     */
    /* JADX WARNING: Missing block: B:45:0x00fb, code skipped:
            ltQ.remove(r0);
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
            com.tencent.matrix.trace.core.AppMethodBeat.o(19362);
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:56:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        AppMethodBeat.i(19362);
        if (this.ltO.containsKey(str2)) {
            AppMethodBeat.o(19362);
        } else if (str2 == null) {
            ab.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
            AppMethodBeat.o(19362);
        } else {
            int i4;
            String replaceAll = str2.replaceAll(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "");
            byte[] bArr2 = ltL;
            if (bo.cb(bArr) || bo.cb(bArr2) || bArr2.length > bArr.length) {
                i4 = -1;
            } else {
                i4 = 0;
                while (i4 < bArr.length) {
                    if (b.c(bArr, i4, bArr2)) {
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
                ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", replaceAll, b.aN(bArr3));
                this.ltO.put(replaceAll, bArr3);
            } else {
                this.ltO.put(replaceAll, null);
            }
            String str4 = this.lst + "_" + str2;
            if (ltR.containsKey(str4)) {
                ab.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", this.lst, str2);
                a((iq) ltR.get(str4));
                AppMethodBeat.o(19362);
                return;
            }
            synchronized (cli) {
                try {
                    if (ltQ.contains(str4)) {
                        ab.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
                    } else {
                        ltQ.add(str4);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(19362);
                }
            }
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19363);
        String str2 = "MicroMsg.exdevice.ScanDeviceLogic";
        String str3 = "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s";
        Object[] objArr = new Object[4];
        objArr[0] = mVar == null ? "" : Integer.valueOf(mVar.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        ab.i(str2, str3, objArr);
        this.ltP.remove(mVar);
        if (i == 0 && i2 == 0 && mVar != null) {
            if (542 == mVar.getType()) {
                Iterator it = ((k) mVar).boO().vKJ.iterator();
                while (it.hasNext()) {
                    iq iqVar = (iq) it.next();
                    if (bo.isNullOrNil(iqVar.vKF)) {
                        ab.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
                    } else {
                        str3 = this.lst + "_" + iqVar.vKF;
                        synchronized (cli) {
                            try {
                                if (ltQ.contains(str3)) {
                                    ltQ.remove(str3);
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.o(19363);
                                }
                            }
                        }
                        if (!ltR.containsKey(str3)) {
                            ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", str3);
                            ltR.put(str3, iqVar);
                        }
                        a(iqVar);
                    }
                }
            }
            AppMethodBeat.o(19363);
            return;
        }
        ab.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
        AppMethodBeat.o(19363);
    }

    private void a(iq iqVar) {
        AppMethodBeat.i(19364);
        if (iqVar == null) {
            ab.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
            AppMethodBeat.o(19364);
        } else if (bo.isNullOrNil(iqVar.vKF)) {
            ab.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
            AppMethodBeat.o(19364);
        } else if (iqVar.Ret != 0) {
            ab.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", iqVar.vKF);
            AppMethodBeat.o(19364);
        } else if (iqVar.vKM == null || bo.isNullOrNil(iqVar.vKM.jBE)) {
            ab.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", iqVar.vKF);
            AppMethodBeat.o(19364);
        } else if (bo.isNullOrNil(iqVar.vKM.vIk) || !iqVar.vKM.vIk.equals(this.lst)) {
            ab.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", iqVar.jBF, this.lst);
            AppMethodBeat.o(19364);
        } else {
            byte[] bArr = (byte[]) this.ltO.get(iqVar.vKF);
            String str = "MicroMsg.exdevice.ScanDeviceLogic";
            String str2 = "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s";
            Object[] objArr = new Object[5];
            objArr[0] = iqVar.vKF;
            objArr[1] = iqVar.vKM.vIk;
            objArr[2] = iqVar.vKM.jBE;
            objArr[3] = iqVar.jBF;
            objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            ab.i(str, str2, objArr);
            if (this.ltN != null) {
                if (bArr != null) {
                    bArr = aM(bArr);
                } else {
                    bArr = null;
                }
                this.ltN.a(iqVar.vKM.jBE, bArr, false);
                AppMethodBeat.o(19364);
                return;
            }
            ab.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
            AppMethodBeat.o(19364);
        }
    }

    private static byte[] aM(byte[] bArr) {
        AppMethodBeat.i(19365);
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
                            ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", Integer.valueOf(b));
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
                            ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.aN(bArr3));
                            bArr2 = bArr3;
                            break;
                        default:
                            i += b - 1;
                            break;
                    }
                }
                AppMethodBeat.o(19365);
                return bArr2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", e, "", new Object[0]);
                ab.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", e.getMessage());
                AppMethodBeat.o(19365);
                return null;
            }
        }
        AppMethodBeat.o(19365);
        return bArr2;
    }
}
