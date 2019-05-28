package com.tencent.mm.plugin.d.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b {
    public com.tencent.mm.plugin.d.a.b.b jIV = null;
    public com.tencent.mm.plugin.d.a.c.a jIW = null;
    c jIX = null;
    final HashSet<String> jIY = new HashSet();
    private ak mHandler = null;

    class b extends com.tencent.mm.plugin.d.a.b.b.a {
        b() {
        }

        public final void g(long j, long j2, long j3) {
            AppMethodBeat.i(18505);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(b.a(b.this, 6, 0, new d(j, j2, j3)));
            AppMethodBeat.o(18505);
        }

        public final void aVx() {
            AppMethodBeat.i(18506);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
            b.this.jIY.clear();
            Assert.assertTrue(b.a(b.this, 2, 0, null));
            AppMethodBeat.o(18506);
        }

        public final void a(String str, String str2, int i, byte[] bArr) {
            AppMethodBeat.i(18507);
            ab.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", str, str2);
            Assert.assertTrue(b.a(b.this, 3, 0, new i(str, str2, i, bArr)));
            AppMethodBeat.o(18507);
        }

        public final void l(long j, boolean z) {
            AppMethodBeat.i(18508);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(b.a(b.this, 4, 0, new f(j, z)));
            AppMethodBeat.o(18508);
        }

        public final void b(long j, byte[] bArr) {
            AppMethodBeat.i(18509);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(j)));
            Assert.assertTrue(b.a(b.this, 1, 0, new h(j, bArr)));
            AppMethodBeat.o(18509);
        }

        public final void m(long j, boolean z) {
            AppMethodBeat.i(18510);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(b.a(b.this, 0, 0, new j(j, z)));
            AppMethodBeat.o(18510);
        }
    }

    static class e {
        long jJb;
        boolean jJc;

        public e(long j, boolean z) {
            this.jJb = j;
            this.jJc = z;
        }
    }

    static final class f extends e {
        public f(long j, boolean z) {
            super(j, z);
        }
    }

    static class c extends ak {
        private WeakReference<b> jGh = null;

        public c(Looper looper, b bVar) {
            super(looper);
            AppMethodBeat.i(18511);
            this.jGh = new WeakReference(bVar);
            AppMethodBeat.o(18511);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(18512);
            b bVar = (b) this.jGh.get();
            if (bVar == null) {
                ab.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
                AppMethodBeat.o(18512);
                return;
            }
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
            switch (message.what) {
                case 0:
                    j jVar = (j) message.obj;
                    bVar.jIX.m(jVar.jJb, jVar.jJc);
                    AppMethodBeat.o(18512);
                    return;
                case 1:
                    h hVar = (h) message.obj;
                    bVar.jIX.b(hVar.mSessionId, hVar.mData);
                    AppMethodBeat.o(18512);
                    return;
                case 2:
                    bVar.jIX.rQ(message.arg1);
                    AppMethodBeat.o(18512);
                    return;
                case 3:
                    i iVar = (i) message.obj;
                    bVar.jIX.a(iVar.jJe, iVar.mDeviceName, message.arg1, iVar.hGc, iVar.jJf);
                    AppMethodBeat.o(18512);
                    return;
                case 4:
                    f fVar = (f) message.obj;
                    bVar.jIX.l(fVar.jJb, fVar.jJc);
                    AppMethodBeat.o(18512);
                    return;
                case 5:
                    bVar.jIX.gB(((g) message.obj).mSessionId);
                    AppMethodBeat.o(18512);
                    return;
                case 6:
                    d dVar = (d) message.obj;
                    bVar.jIX.g(dVar.mSessionId, dVar.jJa, dVar.jFM);
                    break;
            }
            AppMethodBeat.o(18512);
        }
    }

    class a extends com.tencent.mm.plugin.d.a.c.a.a {
        a() {
        }

        public final void g(long j, long j2, long j3) {
            AppMethodBeat.i(18498);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(b.a(b.this, 6, 1, new d(j, j2, j3)));
            AppMethodBeat.o(18498);
        }

        public final void aVx() {
            AppMethodBeat.i(18499);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
            b.this.jIY.clear();
            Assert.assertTrue(b.a(b.this, 2, 1, null));
            AppMethodBeat.o(18499);
        }

        public final void dd(String str, String str2) {
            int i;
            AppMethodBeat.i(18500);
            b bVar = b.this;
            if (str == null) {
                ab.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
                i = 0;
            } else if (bVar.jIY.contains(str)) {
                i = 0;
            } else {
                bVar.jIY.add(str);
                i = 1;
            }
            if (i == 0) {
                AppMethodBeat.o(18500);
                return;
            }
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
            Assert.assertTrue(b.a(b.this, 3, 1, new i(str, str2, 0, null)));
            AppMethodBeat.o(18500);
        }

        public final void l(long j, boolean z) {
            AppMethodBeat.i(18501);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(b.a(b.this, 4, 1, new f(j, z)));
            AppMethodBeat.o(18501);
        }

        public final void b(long j, byte[] bArr) {
            AppMethodBeat.i(18502);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(j)));
            Assert.assertTrue(b.a(b.this, 1, 1, new h(j, bArr)));
            AppMethodBeat.o(18502);
        }

        public final void m(long j, boolean z) {
            AppMethodBeat.i(18503);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(b.a(b.this, 0, 1, new j(j, z)));
            AppMethodBeat.o(18503);
        }

        public final void c(long j, int i, String str) {
            AppMethodBeat.i(18504);
            ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j + " errorCode = " + i + " errorInfo = " + str);
            Assert.assertTrue(b.a(b.this, 5, 1, new g(j, i, str)));
            AppMethodBeat.o(18504);
        }
    }

    static final class d {
        long jFM;
        long jJa;
        long mSessionId;

        public d(long j, long j2, long j3) {
            this.mSessionId = j;
            this.jJa = j2;
            this.jFM = j3;
        }
    }

    static final class g {
        private String jJd;
        private int mErrorCode;
        long mSessionId;

        public g(long j, int i, String str) {
            this.mSessionId = j;
            this.mErrorCode = i;
            this.jJd = str;
        }
    }

    static final class i {
        int hGc;
        String jJe;
        byte[] jJf;
        String mDeviceName;

        public i(String str, String str2, int i, byte[] bArr) {
            this.jJe = str;
            this.mDeviceName = str2;
            this.hGc = i;
            this.jJf = bArr;
        }
    }

    static final class h {
        byte[] mData;
        long mSessionId;

        public h(long j, byte[] bArr) {
            this.mSessionId = j;
            this.mData = bArr;
        }
    }

    static final class j extends e {
        public j(long j, boolean z) {
            super(j, z);
        }
    }

    public b(Context context, c cVar, al alVar) {
        AppMethodBeat.i(18513);
        this.jIW = new com.tencent.mm.plugin.d.a.c.a(alVar);
        if (VERSION.SDK_INT >= 18) {
            this.jIV = new com.tencent.mm.plugin.d.a.b.b(alVar);
            com.tencent.mm.plugin.d.a.b.b bVar = this.jIV;
            b bVar2 = new b();
            ab.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(bVar2);
            if (!bVar.mIsInit) {
                bVar.mIsInit = true;
                bVar.Gn = context;
                bVar.jFz = bVar2;
                bVar.jFC = com.tencent.mm.plugin.d.a.b.c.aVy();
                if (com.tencent.mm.compatible.util.d.iW(21)) {
                    bVar.jFD = com.tencent.mm.plugin.d.a.b.g.aVD();
                }
                if (bVar.aVw()) {
                    bVar.jEU = ((BluetoothManager) bVar.Gn.getSystemService("bluetooth")).getAdapter();
                } else {
                    ab.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                }
            }
        }
        com.tencent.mm.plugin.d.a.c.a aVar = this.jIW;
        a aVar2 = new a();
        ab.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(aVar2);
        if (!aVar.mIsInit) {
            aVar.mIsInit = true;
            aVar.jIy = aVar2;
            aVar.jIz = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            aVar.jIz.registerReceiver(aVar.jIA, intentFilter);
            aVar.jEU = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new c(v.bpz().fPG.oAl.getLooper(), this);
        this.jIX = cVar;
        AppMethodBeat.o(18513);
    }

    public final boolean d(int i, int... iArr) {
        AppMethodBeat.i(18514);
        ab.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(i)));
        boolean a;
        switch (i) {
            case 0:
                if (this.jIV == null) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    AppMethodBeat.o(18514);
                    return false;
                } else if (iArr == null) {
                    a = this.jIV.a(true, new int[0]);
                    AppMethodBeat.o(18514);
                    return a;
                } else {
                    a = this.jIV.a(true, iArr);
                    AppMethodBeat.o(18514);
                    return a;
                }
            case 1:
                if (this.jIW == null) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    AppMethodBeat.o(18514);
                    return false;
                }
                a = this.jIW.fw(true);
                AppMethodBeat.o(18514);
                return a;
            default:
                Assert.assertTrue(false);
                AppMethodBeat.o(18514);
                return false;
        }
    }

    public final void c(long j, long j2, int i) {
        AppMethodBeat.i(18515);
        ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j + "aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.jIV == null) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    AppMethodBeat.o(18515);
                    return;
                }
                com.tencent.mm.plugin.d.a.b.b bVar = this.jIV;
                ab.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", Long.valueOf(j), Long.valueOf(j2));
                Assert.assertTrue(bVar.mIsInit);
                if (bVar.aVw()) {
                    Assert.assertTrue(bVar.mHandler.post(new com.tencent.mm.plugin.d.a.b.b.b(j, j2)));
                    AppMethodBeat.o(18515);
                    return;
                }
                ab.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                AppMethodBeat.o(18515);
                return;
            case 1:
                if (this.jIW == null) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    AppMethodBeat.o(18515);
                    return;
                }
                com.tencent.mm.plugin.d.a.c.a aVar = this.jIW;
                ab.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(aVar.mIsInit);
                if (aVar.aVF()) {
                    Assert.assertTrue(aVar.mHandler.post(new com.tencent.mm.plugin.d.a.c.a.b(j, j2)));
                    AppMethodBeat.o(18515);
                    return;
                }
                ab.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                AppMethodBeat.o(18515);
                return;
            default:
                Assert.assertTrue(false);
                AppMethodBeat.o(18515);
                return;
        }
    }

    static /* synthetic */ boolean a(b bVar, int i, int i2, Object obj) {
        AppMethodBeat.i(18516);
        boolean sendMessage = bVar.mHandler.sendMessage(bVar.mHandler.obtainMessage(i, i2, 0, obj));
        AppMethodBeat.o(18516);
        return sendMessage;
    }
}
