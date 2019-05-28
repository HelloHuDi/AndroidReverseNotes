package com.tencent.p177mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C41989eq;
import com.tencent.p177mm.plugin.exdevice.model.C20495e.C20494b;
import com.tencent.p177mm.plugin.exdevice.model.C2971d.C29802;
import com.tencent.p177mm.plugin.exdevice.model.C2971d.C29813;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27859f;
import com.tencent.p177mm.plugin.exdevice.service.C27859f.C27860a;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.plugin.exdevice.service.C34050c;
import com.tencent.p177mm.plugin.exdevice.service.C38959k.C38960a;
import com.tencent.p177mm.plugin.exdevice.service.C43000j;
import com.tencent.p177mm.plugin.exdevice.service.C43000j.C43001a;
import com.tencent.p177mm.plugin.exdevice.service.C43003s.C43004a;
import com.tencent.p177mm.plugin.exdevice.service.C43005t;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.exdevice.model.h */
public class C46907h extends C43004a {
    protected static final String TAG = C46907h.class.getName();
    private boolean lsZ = false;
    C27859f lta = new C27859f();
    private C43001a ltb = new C340361();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.h$a */
    public interface C2986a {
        /* renamed from: a */
        void mo7190a(long j, int i, int i2, int i3, long j2);
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.h$1 */
    class C340361 extends C43001a {
        C340361() {
        }

        /* renamed from: a */
        public final void mo7194a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
            AppMethodBeat.m2504i(19274);
            C4990ab.m7411d(C46907h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), C42992b.m76349aN(bArr));
            if (1 == i) {
                C45891ad.bph().mo35808o(str3, str2, false);
            } else if (2 == i) {
                C45891ad.bph().mo35808o(str3, str2, true);
            } else {
                C4990ab.m7413e(C46907h.TAG, "unknown message type %d", Integer.valueOf(i));
            }
            if (C45891ad.boW().mo45710id(C42992b.m76346KK(str2)) != null) {
                C4990ab.m7410d(C46907h.TAG, "the founded device hasn't been binded");
            }
            AppMethodBeat.m2505o(19274);
        }
    }

    public C46907h() {
        AppMethodBeat.m2504i(19276);
        AppMethodBeat.m2505o(19276);
    }

    static {
        AppMethodBeat.m2504i(19283);
        AppMethodBeat.m2505o(19283);
    }

    public final void boM() {
        AppMethodBeat.m2504i(19277);
        if (this.lsZ) {
            C4990ab.m7410d(TAG, "still scanning. return");
            AppMethodBeat.m2505o(19277);
            return;
        }
        C2971d bpd = C45891ad.bpd();
        C43000j c43000j = this.ltb;
        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
        if (bpd.lrc == null) {
            bpd.lrc = new C34050c();
            bpd.lrc.lwE = new C29802(c43000j);
            bpd.lrc.mo54583dH(C4996ah.getContext());
        } else if (C20548u.bpy().lqX == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
            if (!C20548u.bpy().lqX.mo45754a(c43000j)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
        this.lsZ = true;
        AppMethodBeat.m2505o(19277);
    }

    public final void stopScan() {
        AppMethodBeat.m2504i(19278);
        if (this.lsZ) {
            C2971d bpd = C45891ad.bpd();
            C43001a c43001a = this.ltb;
            C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
            if (bpd.lrc == null) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (C20548u.bpy().lqX == null) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!C20548u.bpy().lqX.mo45758b(c43001a)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.lsZ = false;
            AppMethodBeat.m2505o(19278);
            return;
        }
        C4990ab.m7410d(TAG, "not yet scan. return");
        AppMethodBeat.m2505o(19278);
    }

    /* renamed from: a */
    public final void mo76110a(long j, final C2986a c2986a) {
        AppMethodBeat.m2504i(19279);
        C27860a hU = this.lta.mo45722hU(j);
        if (hU == null || 2 != hU.cxs) {
            C2971d bpd = C45891ad.bpd();
            C389522 c389522 = new C38960a() {
                /* renamed from: a */
                public final void mo7187a(long j, int i, int i2, int i3, long j2) {
                    AppMethodBeat.m2504i(19275);
                    C4990ab.m7411d(C46907h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
                    C27860a hU = C46907h.this.lta.mo45722hU(j);
                    if (hU != null) {
                        hU.cxs = i2;
                        hU.jGw = j2;
                    } else {
                        C4990ab.m7417i(C46907h.TAG, "get connect state faild : %d", Long.valueOf(j));
                    }
                    c2986a.mo7190a(j, i, i2, i3, j2);
                    AppMethodBeat.m2505o(19275);
                }
            };
            C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
            if (bpd.lrc == null) {
                bpd.lrc = new C34050c();
                bpd.lrc.lwE = new C29813(j, c389522);
                bpd.lrc.mo54583dH(C4996ah.getContext());
                AppMethodBeat.m2505o(19279);
                return;
            }
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
            C27865m c27865m = C20548u.bpy().lqX;
            if (c27865m == null || !c27865m.mo45753a(j, c389522)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
            }
            AppMethodBeat.m2505o(19279);
            return;
        }
        C4990ab.m7410d(TAG, "device(" + j + ") has been connected");
        c2986a.mo7190a(j, 2, 2, 0, hU.jGw);
        AppMethodBeat.m2505o(19279);
    }

    /* renamed from: hH */
    public static void m89277hH(long j) {
        AppMethodBeat.m2504i(19280);
        C2971d bpd = C45891ad.bpd();
        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
        if (bpd.lrc == null) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            AppMethodBeat.m2505o(19280);
        } else if (C20548u.bpy().lqX == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.m2505o(19280);
        } else {
            if (!C20548u.bpy().lqX.mo45762ic(j)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
            }
            AppMethodBeat.m2505o(19280);
        }
    }

    /* renamed from: a */
    public static boolean m89276a(long j, byte[] bArr, C43005t c43005t) {
        boolean z = false;
        AppMethodBeat.m2504i(19281);
        if (bArr == null || bArr.length <= 0) {
            C4990ab.m7412e(TAG, "no data for transmit");
            AppMethodBeat.m2505o(19281);
        } else if (C20548u.bpy().lqX == null) {
            C4990ab.m7412e(TAG, "can not send data");
            AppMethodBeat.m2505o(19281);
        } else {
            z = C20548u.bpy().lqX.mo45757b(j, bArr, c43005t);
            if (!z) {
                C4990ab.m7412e(TAG, "simpleBluetoothSendData error");
            }
            AppMethodBeat.m2505o(19281);
        }
        return z;
    }

    /* renamed from: c */
    public final void mo54587c(long j, byte[] bArr) {
        AppMethodBeat.m2504i(19282);
        if (bArr == null || bArr.length <= 0) {
            C4990ab.m7412e(TAG, "data is null or nil");
            AppMethodBeat.m2505o(19282);
            return;
        }
        LinkedList<C20494b> linkedList;
        C4990ab.m7411d(TAG, "onDataRecv. mac=%d, data=%s", Long.valueOf(j), C42992b.m76349aN(bArr));
        C20495e bph = C45891ad.bph();
        String ie = C42992b.m76358ie(j);
        synchronized (bph.lrw) {
            try {
                linkedList = new LinkedList(bph.lrw);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(19282);
            }
        }
        for (C20494b b : linkedList) {
            b.mo23421b(ie, bArr, true);
        }
        linkedList.clear();
        for (C20494b b2 : bph.lrx.values()) {
            b2.mo23421b(ie, bArr, true);
        }
        C4883b c41989eq = new C41989eq();
        c41989eq.cyh.mac = ie;
        c41989eq.cyh.data = bArr;
        C4879a.xxA.mo10048a(c41989eq, Looper.getMainLooper());
    }
}
