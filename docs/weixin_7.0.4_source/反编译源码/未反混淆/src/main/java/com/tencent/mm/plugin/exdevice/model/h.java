package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.d.AnonymousClass3;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public class h extends com.tencent.mm.plugin.exdevice.service.s.a {
    protected static final String TAG = h.class.getName();
    private boolean lsZ = false;
    f lta = new f();
    private com.tencent.mm.plugin.exdevice.service.j.a ltb = new com.tencent.mm.plugin.exdevice.service.j.a() {
        public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
            AppMethodBeat.i(19274);
            ab.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), b.aN(bArr));
            if (1 == i) {
                ad.bph().o(str3, str2, false);
            } else if (2 == i) {
                ad.bph().o(str3, str2, true);
            } else {
                ab.e(h.TAG, "unknown message type %d", Integer.valueOf(i));
            }
            if (ad.boW().id(b.KK(str2)) != null) {
                ab.d(h.TAG, "the founded device hasn't been binded");
            }
            AppMethodBeat.o(19274);
        }
    };

    public interface a {
        void a(long j, int i, int i2, int i3, long j2);
    }

    public h() {
        AppMethodBeat.i(19276);
        AppMethodBeat.o(19276);
    }

    static {
        AppMethodBeat.i(19283);
        AppMethodBeat.o(19283);
    }

    public final void boM() {
        AppMethodBeat.i(19277);
        if (this.lsZ) {
            ab.d(TAG, "still scanning. return");
            AppMethodBeat.o(19277);
            return;
        }
        d bpd = ad.bpd();
        j jVar = this.ltb;
        ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
        if (bpd.lrc == null) {
            bpd.lrc = new c();
            bpd.lrc.lwE = new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass2(jVar);
            bpd.lrc.dH(ah.getContext());
        } else if (u.bpy().lqX == null) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
            if (!u.bpy().lqX.a(jVar)) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
        this.lsZ = true;
        AppMethodBeat.o(19277);
    }

    public final void stopScan() {
        AppMethodBeat.i(19278);
        if (this.lsZ) {
            d bpd = ad.bpd();
            com.tencent.mm.plugin.exdevice.service.j.a aVar = this.ltb;
            ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
            if (bpd.lrc == null) {
                ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.bpy().lqX == null) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.bpy().lqX.b(aVar)) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.lsZ = false;
            AppMethodBeat.o(19278);
            return;
        }
        ab.d(TAG, "not yet scan. return");
        AppMethodBeat.o(19278);
    }

    public final void a(long j, final a aVar) {
        AppMethodBeat.i(19279);
        com.tencent.mm.plugin.exdevice.service.f.a hU = this.lta.hU(j);
        if (hU == null || 2 != hU.cxs) {
            d bpd = ad.bpd();
            AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.exdevice.service.k.a() {
                public final void a(long j, int i, int i2, int i3, long j2) {
                    AppMethodBeat.i(19275);
                    ab.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
                    com.tencent.mm.plugin.exdevice.service.f.a hU = h.this.lta.hU(j);
                    if (hU != null) {
                        hU.cxs = i2;
                        hU.jGw = j2;
                    } else {
                        ab.i(h.TAG, "get connect state faild : %d", Long.valueOf(j));
                    }
                    aVar.a(j, i, i2, i3, j2);
                    AppMethodBeat.o(19275);
                }
            };
            ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
            if (bpd.lrc == null) {
                bpd.lrc = new c();
                bpd.lrc.lwE = new AnonymousClass3(j, anonymousClass2);
                bpd.lrc.dH(ah.getContext());
                AppMethodBeat.o(19279);
                return;
            }
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
            m mVar = u.bpy().lqX;
            if (mVar == null || !mVar.a(j, anonymousClass2)) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
            }
            AppMethodBeat.o(19279);
            return;
        }
        ab.d(TAG, "device(" + j + ") has been connected");
        aVar.a(j, 2, 2, 0, hU.jGw);
        AppMethodBeat.o(19279);
    }

    public static void hH(long j) {
        AppMethodBeat.i(19280);
        d bpd = ad.bpd();
        ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
        if (bpd.lrc == null) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            AppMethodBeat.o(19280);
        } else if (u.bpy().lqX == null) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.o(19280);
        } else {
            if (!u.bpy().lqX.ic(j)) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
            }
            AppMethodBeat.o(19280);
        }
    }

    public static boolean a(long j, byte[] bArr, t tVar) {
        boolean z = false;
        AppMethodBeat.i(19281);
        if (bArr == null || bArr.length <= 0) {
            ab.e(TAG, "no data for transmit");
            AppMethodBeat.o(19281);
        } else if (u.bpy().lqX == null) {
            ab.e(TAG, "can not send data");
            AppMethodBeat.o(19281);
        } else {
            z = u.bpy().lqX.b(j, bArr, tVar);
            if (!z) {
                ab.e(TAG, "simpleBluetoothSendData error");
            }
            AppMethodBeat.o(19281);
        }
        return z;
    }

    public final void c(long j, byte[] bArr) {
        AppMethodBeat.i(19282);
        if (bArr == null || bArr.length <= 0) {
            ab.e(TAG, "data is null or nil");
            AppMethodBeat.o(19282);
            return;
        }
        LinkedList<e.b> linkedList;
        ab.d(TAG, "onDataRecv. mac=%d, data=%s", Long.valueOf(j), b.aN(bArr));
        e bph = ad.bph();
        String ie = b.ie(j);
        synchronized (bph.lrw) {
            try {
                linkedList = new LinkedList(bph.lrw);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(19282);
            }
        }
        for (e.b b : linkedList) {
            b.b(ie, bArr, true);
        }
        linkedList.clear();
        for (e.b b2 : bph.lrx.values()) {
            b2.b(ie, bArr, true);
        }
        com.tencent.mm.sdk.b.b eqVar = new eq();
        eqVar.cyh.mac = ie;
        eqVar.cyh.data = bArr;
        com.tencent.mm.sdk.b.a.xxA.a(eqVar, Looper.getMainLooper());
    }
}
