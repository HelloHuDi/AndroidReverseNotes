package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.d.a.a.f.AnonymousClass6;
import com.tencent.mm.plugin.d.a.a.f.AnonymousClass7;
import com.tencent.mm.plugin.d.a.b.e.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

public final class y extends com.tencent.mm.plugin.exdevice.service.h.a implements com.tencent.mm.plugin.d.a.a.b, com.tencent.mm.plugin.d.a.d.a.a, g {
    private a lwU;
    private RemoteCallbackList<k> lwV;
    private RemoteCallbackList<p> lwW;
    private RemoteCallbackList<j> lwX;
    private RemoteCallbackList<i> lwY;
    private RemoteCallbackList<q> lwZ;
    private RemoteCallbackList<n> lxa;
    private final l lxb;
    private int lxc;
    private final com.tencent.mm.plugin.d.a.a.f lxd;
    private final com.tencent.mm.plugin.d.a.d.a lxe;
    private RemoteCallbackList<j> lxf;
    private RemoteCallbackList<k> lxg;
    private RemoteCallbackList<s> lxh;
    private RemoteCallbackList<t> lxi;
    com.tencent.mm.plugin.d.a.b.e lxj;
    private com.tencent.mm.plugin.d.a.b.e.a lxk;
    private final ak mHandler;

    static final class d {
        String hxN = null;
        int lqL = 0;
        int lqz = 0;
        long lwo = 0;
    }

    static final class e {
        public long ltB;
        public int lxn;
        public k lxo;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    static final class f {
        public long ltB;
        public byte[] mData;

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    static final class l {
        long lwo;

        private l() {
            this.lwo = 0;
        }

        /* synthetic */ l(byte b) {
            this();
        }
    }

    static final class c {
        long jGw;
        long jJa;
        int lqz;
        int lwm;
        int lwn;

        private c() {
            this.jJa = 0;
            this.lwm = 0;
            this.lwn = 0;
            this.lqz = 0;
            this.jGw = 0;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static final class b {
        long jJa;
        byte[] lqA;
        short lqG;
        short lwl;
        int mErrorCode;

        private b() {
            this.jJa = 0;
            this.lqG = (short) 0;
            this.lwl = (short) 0;
            this.lqA = null;
            this.mErrorCode = 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class g {
        int hGc;
        String jJe;
        boolean lxp;
        byte[] lxq;
        String mDeviceName;

        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    static final class h {
        public String hxN;
        public int lqL;
        public int lqz;
        public long ltB;

        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }
    }

    static final class i {
        public long ltB;
        public t lxr;
        public byte[] mData;

        private i() {
        }

        /* synthetic */ i(byte b) {
            this();
        }
    }

    static final class k {
        long lwo;
        p lxt;

        public k(long j, p pVar) {
            this.lwo = j;
            this.lxt = pVar;
        }
    }

    final class a extends ak {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(19657);
            switch (message.what) {
                case 0:
                    k kVar = (k) message.obj;
                    if (!y.a(y.this, kVar.lwo, kVar.lxt)) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 1:
                    if (!y.a(y.this, ((Long) message.obj).longValue())) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 2:
                    d dVar = (d) message.obj;
                    y.a(y.this, dVar.lwo, dVar.lqL, dVar.lqz, dVar.hxN);
                    AppMethodBeat.o(19657);
                    return;
                case 3:
                    j jVar = (j) message.obj;
                    if (!y.a(y.this, jVar.jJa, jVar.lxs, jVar.lxo)) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 4:
                    if (!y.b(y.this, ((Long) message.obj).longValue())) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                        AppMethodBeat.o(19657);
                        return;
                    }
                    break;
                case 5:
                    c cVar = (c) message.obj;
                    y.a(y.this, cVar.jJa, cVar.lwm, cVar.lwn, cVar.lqz);
                    AppMethodBeat.o(19657);
                    return;
                case 6:
                    b bVar = (b) message.obj;
                    y.a(y.this, bVar.mErrorCode, bVar.jJa, bVar.lqG, bVar.lwl, bVar.lqA);
                    AppMethodBeat.o(19657);
                    return;
                case 7:
                    e eVar = (e) message.obj;
                    if (!y.this.c(eVar.ltB, eVar.lxn, eVar.lxo)) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 8:
                    long longValue = ((Long) message.obj).longValue();
                    y yVar = y.this;
                    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", Long.valueOf(longValue));
                    if (yVar.lxj != null) {
                        com.tencent.mm.plugin.d.a.b.e eVar2 = yVar.lxj;
                        ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", Long.valueOf(longValue));
                        if (eVar2.aVw()) {
                            eVar2.Q(new AnonymousClass5(longValue));
                        } else {
                            ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                            AppMethodBeat.o(19657);
                            return;
                        }
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 9:
                    c cVar2 = (c) message.obj;
                    if (!y.this.b(cVar2.jJa, cVar2.lwm, cVar2.lwn, cVar2.lqz, cVar2.jGw)) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 10:
                    i iVar = (i) message.obj;
                    if (!y.this.c(iVar.ltB, iVar.mData, iVar.lxr)) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 11:
                    h hVar = (h) message.obj;
                    if (!y.this.e(hVar.ltB, hVar.lqL, hVar.lqz, hVar.hxN)) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
                    }
                    AppMethodBeat.o(19657);
                    return;
                case 12:
                    f fVar = (f) message.obj;
                    y.this.d(fVar.ltB, fVar.mData);
                    AppMethodBeat.o(19657);
                    return;
                case 13:
                    y.a(y.this, (g) message.obj);
                    break;
            }
            AppMethodBeat.o(19657);
        }
    }

    static final class j {
        long jJa;
        k lxo;
        int lxs;

        public j(long j, int i, k kVar) {
            this.jJa = j;
            this.lxs = i;
            this.lxo = kVar;
        }
    }

    public y() {
        AppMethodBeat.i(19658);
        this.lwU = null;
        this.lwV = new RemoteCallbackList();
        this.lwW = new RemoteCallbackList();
        this.lwX = new RemoteCallbackList();
        this.lwY = new RemoteCallbackList();
        this.lwZ = new RemoteCallbackList();
        this.lxa = new RemoteCallbackList();
        this.lxb = new l();
        this.lxc = 0;
        this.lxf = new RemoteCallbackList();
        this.lxg = new RemoteCallbackList();
        this.lxh = new RemoteCallbackList();
        this.lxi = new RemoteCallbackList();
        this.lwU = new a(this);
        this.mHandler = new a(v.bpz().fPG.oAl.getLooper());
        if (VERSION.SDK_INT >= 18) {
            this.lxd = new com.tencent.mm.plugin.d.a.a.f(this);
        } else {
            this.lxd = null;
        }
        this.lxe = new com.tencent.mm.plugin.d.a.d.a(this);
        this.lxk = new com.tencent.mm.plugin.d.a.b.e.a() {
            public final void a(long j, boolean z, long j2) {
                int i;
                AppMethodBeat.i(19649);
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onConnected. seesionId=%d, connected=%s, profileType=%d";
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                objArr[2] = Long.valueOf(j2);
                ab.d(str, str2, objArr);
                c cVar = new c();
                cVar.jJa = j;
                if (z) {
                    i = 2;
                } else {
                    i = 4;
                }
                cVar.lwn = i;
                cVar.lwm = 1;
                cVar.lqz = 0;
                cVar.jGw = j2;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(9, cVar))) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(9));
                }
                AppMethodBeat.o(19649);
            }

            public final void b(long j, byte[] bArr) {
                AppMethodBeat.i(19650);
                f fVar = new f();
                fVar.ltB = j;
                fVar.mData = bArr;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(12, fVar))) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(12));
                }
                AppMethodBeat.o(19650);
            }

            public final void m(long j, boolean z) {
                AppMethodBeat.i(19651);
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onSend. sessionId=%d, success=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                ab.d(str, str2, objArr);
                h hVar = new h();
                hVar.ltB = j;
                if (z) {
                    hVar.lqL = 0;
                    hVar.lqz = 0;
                } else {
                    hVar.lqL = -1;
                    hVar.lqz = -1;
                }
                hVar.hxN = "";
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(11, hVar))) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(11));
                }
                AppMethodBeat.o(19651);
            }

            public final void a(String str, String str2, int i, byte[] bArr) {
                AppMethodBeat.i(19652);
                ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", str, str2);
                g gVar = new g();
                gVar.lxp = false;
                gVar.jJe = str;
                gVar.mDeviceName = str2;
                gVar.hGc = i;
                gVar.lxq = bArr;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(13, gVar))) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(13));
                }
                AppMethodBeat.o(19652);
            }

            public final void aVx() {
                AppMethodBeat.i(19653);
                ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
                g gVar = new g();
                gVar.lxp = true;
                gVar.jJe = null;
                gVar.mDeviceName = null;
                gVar.hGc = 0;
                gVar.lxq = null;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(13, gVar))) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(13));
                }
                AppMethodBeat.o(19653);
            }
        };
        com.tencent.mm.compatible.a.a.a(18, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                AppMethodBeat.i(19654);
                y.this.lxj = new com.tencent.mm.plugin.d.a.b.e(y.this.lxk);
                AppMethodBeat.o(19654);
            }
        });
        AppMethodBeat.o(19658);
    }

    private static IInterface a(long j, RemoteCallbackList remoteCallbackList, int i) {
        AppMethodBeat.i(19659);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", Long.valueOf(j), Integer.valueOf(i));
        for (int i2 = 0; i2 < i; i2++) {
            HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i2);
            if (hashMap.containsKey(Long.valueOf(j))) {
                IInterface iInterface = (IInterface) hashMap.get(Long.valueOf(j));
                AppMethodBeat.o(19659);
                return iInterface;
            }
        }
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
        AppMethodBeat.o(19659);
        return null;
    }

    private boolean c(j jVar) {
        AppMethodBeat.i(19660);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
        boolean unregister = this.lwX.unregister(jVar);
        if (unregister) {
            this.lxc--;
        } else {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
        }
        AppMethodBeat.o(19660);
        return unregister;
    }

    public final boolean b(final int i, final j jVar) {
        AppMethodBeat.i(19661);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = ".concat(String.valueOf(i)));
        if (jVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            AppMethodBeat.o(19661);
            return false;
        }
        boolean post = this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19655);
                if (!y.a(y.this, i, jVar)) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
                }
                AppMethodBeat.o(19655);
            }
        });
        if (!post) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
        }
        AppMethodBeat.o(19661);
        return post;
    }

    private boolean f(int i, j jVar) {
        AppMethodBeat.i(19662);
        if (jVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scanImp: null == aCallback");
            AppMethodBeat.o(19662);
            throw illegalArgumentException;
        }
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
        boolean register = this.lwX.register(jVar);
        if (register) {
            this.lxc++;
        } else {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
        }
        if (register) {
            boolean z;
            r rVar = this.lwU;
            ab.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", Integer.valueOf(i));
            if (b.a(i, rVar, new int[0])) {
                z = true;
            } else {
                ab.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
                z = false;
            }
            if (!z) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
                try {
                    jVar.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
                if (!c(jVar)) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                }
            }
            AppMethodBeat.o(19662);
            return z;
        }
        try {
            jVar.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
        } catch (RemoteException e2) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e2.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        }
        AppMethodBeat.o(19662);
        return false;
    }

    public final boolean c(final int i, final j jVar) {
        AppMethodBeat.i(19663);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = ".concat(String.valueOf(i)));
        if (jVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
            AppMethodBeat.o(19663);
            return false;
        }
        boolean post = this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19656);
                if (!y.b(y.this, i, jVar)) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
                }
                AppMethodBeat.o(19656);
            }
        });
        if (!post) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
        }
        AppMethodBeat.o(19663);
        return post;
    }

    private boolean g(int i, j jVar) {
        AppMethodBeat.i(19664);
        if (jVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            AppMethodBeat.o(19664);
            return false;
        }
        boolean uL = a.uL(i);
        if (!uL) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
            try {
                jVar.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
            } catch (RemoteException e) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        if (!c(jVar)) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        AppMethodBeat.o(19664);
        return uL;
    }

    public final long[] bpl() {
        AppMethodBeat.i(19665);
        long[] bpl = a.bpl();
        AppMethodBeat.o(19665);
        return bpl;
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface) {
        AppMethodBeat.i(19666);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", Long.valueOf(j));
        if (remoteCallbackList == null || iInterface == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            AppMethodBeat.o(19666);
            return false;
        }
        int beginBroadcast = remoteCallbackList.beginBroadcast();
        do {
            beginBroadcast--;
            if (beginBroadcast < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(beginBroadcast).asBinder().equals(iInterface.asBinder()));
        HashMap hashMap;
        if (beginBroadcast < 0) {
            ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
            hashMap = new HashMap();
            hashMap.put(Long.valueOf(j), iInterface);
            remoteCallbackList.register(iInterface, hashMap);
            remoteCallbackList.finishBroadcast();
            AppMethodBeat.o(19666);
            return true;
        }
        hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(beginBroadcast);
        if (hashMap == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            remoteCallbackList.finishBroadcast();
            AppMethodBeat.o(19666);
            return false;
        }
        hashMap.put(Long.valueOf(j), iInterface);
        remoteCallbackList.finishBroadcast();
        AppMethodBeat.o(19666);
        return true;
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface, int i) {
        AppMethodBeat.i(19667);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", Long.valueOf(j), Integer.valueOf(i));
        if (remoteCallbackList == null || iInterface == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            AppMethodBeat.o(19667);
            return false;
        }
        do {
            i--;
            if (i < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(i).asBinder().equals(iInterface.asBinder()));
        if (i < 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
            AppMethodBeat.o(19667);
            return false;
        }
        HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i);
        if (hashMap == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            AppMethodBeat.o(19667);
            return false;
        } else if (((IInterface) hashMap.remove(Long.valueOf(j))) == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
            AppMethodBeat.o(19667);
            return false;
        } else if (hashMap.isEmpty()) {
            ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
            boolean unregister = remoteCallbackList.unregister(iInterface);
            if (!unregister) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
            }
            AppMethodBeat.o(19667);
            return unregister;
        } else {
            AppMethodBeat.o(19667);
            return true;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        AppMethodBeat.i(19668);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", Long.valueOf(j), Integer.valueOf(i));
        if (kVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
            AppMethodBeat.o(19668);
            return false;
        } else if (j < 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.o(19668);
            return false;
        } else if (1 == i || i == 0) {
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(3, new j(j, i, kVar)))) {
                AppMethodBeat.o(19668);
                return true;
            }
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", Integer.valueOf(3));
            AppMethodBeat.o(19668);
            return false;
        } else {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i));
            AppMethodBeat.o(19668);
            return false;
        }
    }

    public final boolean hZ(long j) {
        AppMethodBeat.i(19669);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", Long.valueOf(j));
        if (j < 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.o(19669);
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j)))) {
            AppMethodBeat.o(19669);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", Integer.valueOf(4));
            AppMethodBeat.o(19669);
            return false;
        }
    }

    public final boolean ia(long j) {
        return false;
    }

    private boolean b(long j, p pVar) {
        AppMethodBeat.i(19670);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", Long.valueOf(j));
        if (pVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            d(j, -1, -1, "null == aTask");
            AppMethodBeat.o(19670);
            return false;
        }
        boolean z;
        a aVar = this.lwU;
        ab.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(pVar);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(8, new g(j, pVar)))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startTask Failed ret = -1");
            d(j, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
            AppMethodBeat.o(19670);
            return false;
        } else if (a(this.lwW, j, (IInterface) pVar)) {
            AppMethodBeat.o(19670);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
            d(j, -1, -1, "registerRemoteCB Fail!!!");
            AppMethodBeat.o(19670);
            return false;
        }
    }

    public final long a(p pVar) {
        AppMethodBeat.i(19671);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
        if (pVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            AppMethodBeat.o(19671);
            return -1;
        }
        l lVar = this.lxb;
        if (Long.MAX_VALUE == lVar.lwo) {
            ab.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
            lVar.lwo = 0;
        }
        long j = lVar.lwo;
        lVar.lwo = 1 + j;
        if (this.mHandler.sendMessage(this.mHandler.obtainMessage(0, new k(j, pVar)))) {
            AppMethodBeat.o(19671);
            return j;
        }
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", Integer.valueOf(0));
        AppMethodBeat.o(19671);
        return -1;
    }

    public final boolean ib(long j) {
        AppMethodBeat.i(19672);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", Long.valueOf(j));
        if (j < 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            AppMethodBeat.o(19672);
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(j)))) {
            AppMethodBeat.o(19672);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", Integer.valueOf(1));
            AppMethodBeat.o(19672);
            return false;
        }
    }

    public final boolean a(i iVar) {
        AppMethodBeat.i(19673);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
        boolean register = this.lwY.register(iVar);
        if (!register) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
        }
        AppMethodBeat.o(19673);
        return register;
    }

    public final boolean b(i iVar) {
        AppMethodBeat.i(19674);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
        boolean unregister = this.lwY.unregister(iVar);
        if (!unregister) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
        }
        AppMethodBeat.o(19674);
        return unregister;
    }

    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        AppMethodBeat.i(19675);
        int beginBroadcast = this.lwX.beginBroadcast();
        int i4 = 0;
        while (i4 < beginBroadcast) {
            try {
                ((j) this.lwX.getBroadcastItem(i4)).a(i, i2, str, str2, str3, i3, bArr);
                if (2 == i && !this.lwX.unregister(this.lwX.getBroadcastItem(i4))) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
                }
            } catch (RemoteException e) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = ".concat(String.valueOf(i4)));
                ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            i4++;
        }
        this.lwX.finishBroadcast();
        AppMethodBeat.o(19675);
    }

    private void d(long j, int i, int i2, String str) {
        AppMethodBeat.i(19676);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        int beginBroadcast = this.lwW.beginBroadcast();
        IInterface iInterface = (p) a(j, this.lwW, beginBroadcast);
        if (iInterface == null) {
            ab.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = ".concat(String.valueOf(j)));
            this.lwW.finishBroadcast();
            AppMethodBeat.o(19676);
            return;
        }
        try {
            iInterface.bpv().a(j, i, i2, str, iInterface);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        if (!a(this.lwW, j, iInterface, beginBroadcast)) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
        }
        this.lwW.finishBroadcast();
        AppMethodBeat.o(19676);
    }

    public final void c(long j, int i, int i2, String str) {
        AppMethodBeat.i(19677);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        d dVar = new d();
        dVar.lwo = j;
        dVar.lqL = i;
        dVar.lqz = i2;
        dVar.hxN = str;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, dVar))) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", Integer.valueOf(2));
        }
        AppMethodBeat.o(19677);
    }

    public final void a(int i, long j, short s, short s2, byte[] bArr) {
        AppMethodBeat.i(19678);
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        b bVar = new b();
        bVar.lwl = s2;
        bVar.lqA = bArr;
        bVar.jJa = j;
        bVar.lqG = s;
        bVar.mErrorCode = i;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, bVar))) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(6));
        }
        AppMethodBeat.o(19678);
    }

    public final void b(long j, int i, int i2, int i3) {
        AppMethodBeat.i(19679);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        c cVar = new c();
        cVar.jJa = j;
        cVar.lwm = i;
        cVar.lwn = i2;
        cVar.lqz = i3;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, cVar))) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", Integer.valueOf(5));
        }
        AppMethodBeat.o(19679);
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        AppMethodBeat.i(19680);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", Long.valueOf(j));
        a aVar = this.lwU;
        ab.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", Long.valueOf(j));
        if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(10, new f(j, bArr)))) {
            ab.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", Integer.valueOf(10));
        }
        AppMethodBeat.o(19680);
    }

    public final boolean a(String str, boolean z, q qVar) {
        AppMethodBeat.i(19681);
        if (VERSION.SDK_INT < 18 || this.lxd == null) {
            AppMethodBeat.o(19681);
            return false;
        }
        boolean hasSystemFeature = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!hasSystemFeature || defaultAdapter == null) {
            AppMethodBeat.o(19681);
            return false;
        }
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (this.lwZ.register(qVar)) {
            try {
                UUID fromString = UUID.fromString(str);
                com.tencent.mm.plugin.d.a.a.f fVar = this.lxd;
                com.tencent.mm.plugin.d.a.a.f.jET = ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                String str2 = "MicroMsg.exdevice.IBeaconServer";
                String str3 = "Ranging, uuid = %s, op = %s";
                Object[] objArr = new Object[2];
                objArr[0] = fromString == null ? "" : fromString.toString();
                objArr[1] = String.valueOf(z);
                ab.d(str2, str3, objArr);
                if (fromString == null) {
                    ab.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                    hasSystemFeature = false;
                } else if (z) {
                    hasSystemFeature = fVar.mHandler.post(new AnonymousClass6(fromString));
                } else {
                    hasSystemFeature = fVar.mHandler.post(new AnonymousClass7(fromString));
                }
                if (hasSystemFeature) {
                    AppMethodBeat.o(19681);
                    return true;
                }
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
                if (!this.lwZ.unregister(qVar)) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
                }
                AppMethodBeat.o(19681);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", e.getMessage());
                AppMethodBeat.o(19681);
                return false;
            }
        }
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
        AppMethodBeat.o(19681);
        return false;
    }

    public final void a(double d, com.tencent.mm.plugin.d.a.a.c cVar) {
        AppMethodBeat.i(19682);
        if (cVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
            AppMethodBeat.o(19682);
            return;
        }
        com.tencent.mm.plugin.d.a.a.h hVar = cVar.jEK.jEO;
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", Double.valueOf(d), com.tencent.mm.plugin.exdevice.j.b.aN(hVar.jFp), Short.valueOf(hVar.jFq), Short.valueOf(hVar.jFr), Integer.valueOf(hVar.jFr & CdnLogic.kBizGeneric));
        try {
            int beginBroadcast = this.lwZ.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((q) this.lwZ.getBroadcastItem(i)).a(d, hVar.jFq, hVar.jFr, hVar.jFp, cVar.jEL, cVar.jEK.jEO.jFs, cVar.cbq);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", Integer.valueOf(i), e.toString());
                    ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", e2.toString());
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        } finally {
            this.lwZ.finishBroadcast();
            AppMethodBeat.o(19682);
        }
    }

    public final void rS(int i) {
        AppMethodBeat.i(19683);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", Integer.valueOf(i));
        for (int beginBroadcast = this.lxa.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_state", i);
            try {
                ((n) this.lxa.getBroadcastItem(beginBroadcast)).k(0, bundle);
            } catch (RemoteException e) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", Integer.valueOf(beginBroadcast));
                ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        this.lxa.finishBroadcast();
        AppMethodBeat.o(19683);
    }

    public final void a(n nVar) {
        AppMethodBeat.i(19684);
        ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
        if (!this.lxa.register(nVar)) {
            ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
        }
        AppMethodBeat.o(19684);
    }

    public final boolean d(int i, j jVar) {
        AppMethodBeat.i(19685);
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", Integer.valueOf(i));
        if (jVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
            AppMethodBeat.o(19685);
            return false;
        } else if (i != 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
            AppMethodBeat.o(19685);
            return false;
        } else {
            boolean register = this.lxf.register(jVar);
            if (register) {
                ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
            } else {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
            }
            if (this.lxj != null) {
                boolean a;
                com.tencent.mm.plugin.d.a.b.e eVar = this.lxj;
                ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
                Assert.assertTrue(eVar.jFC != null);
                if (eVar.aVw()) {
                    a = eVar.jFC.a(true, eVar.jFF);
                    if (a) {
                        eVar.jGj.clear();
                    }
                } else {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    a = false;
                }
                if (!a) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
                    try {
                        jVar.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", e.getMessage());
                        ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                    if (register) {
                        this.lxf.unregister(jVar);
                    }
                    AppMethodBeat.o(19685);
                    return false;
                }
            }
            AppMethodBeat.o(19685);
            return true;
        }
    }

    public final boolean e(int i, j jVar) {
        AppMethodBeat.i(19686);
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", Integer.valueOf(i));
        if (jVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
            AppMethodBeat.o(19686);
            return false;
        } else if (this.lxj == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
            AppMethodBeat.o(19686);
            return false;
        } else {
            boolean a;
            com.tencent.mm.plugin.d.a.b.e eVar = this.lxj;
            ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
            Assert.assertTrue(eVar.jFC != null);
            if (eVar.aVw()) {
                eVar.mHandler.removeCallbacks(eVar.mRunnable);
                a = eVar.jFC.a(false, eVar.jFF);
            } else {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                a = false;
            }
            if (!a) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                try {
                    jVar.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(19686);
            return a;
        }
    }

    public final boolean b(long j, int i, k kVar) {
        AppMethodBeat.i(19687);
        if (kVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            AppMethodBeat.o(19687);
            return false;
        } else if (j < 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.o(19687);
            return false;
        } else if (i != 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i));
            AppMethodBeat.o(19687);
            return false;
        } else {
            e eVar = new e();
            eVar.ltB = j;
            eVar.lxn = i;
            eVar.lxo = kVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(7, eVar))) {
                AppMethodBeat.o(19687);
                return true;
            }
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(7));
            AppMethodBeat.o(19687);
            return false;
        }
    }

    public final boolean ic(long j) {
        AppMethodBeat.i(19688);
        if (j < 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.o(19688);
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j)))) {
            AppMethodBeat.o(19688);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(8));
            AppMethodBeat.o(19688);
            return false;
        }
    }

    public final boolean a(s sVar) {
        AppMethodBeat.i(19689);
        if (sVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            AppMethodBeat.o(19689);
            return false;
        }
        boolean register = this.lxh.register(sVar);
        if (!register) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
        }
        AppMethodBeat.o(19689);
        return register;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        AppMethodBeat.i(19690);
        if (0 > j) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
            AppMethodBeat.o(19690);
            return false;
        } else if (bArr == null || bArr.length <= 0) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
            AppMethodBeat.o(19690);
            return false;
        } else if (tVar == null) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            AppMethodBeat.o(19690);
            return false;
        } else {
            i iVar = new i();
            iVar.ltB = j;
            iVar.mData = bArr;
            iVar.lxr = tVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(10, iVar))) {
                AppMethodBeat.o(19690);
                return true;
            }
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(10));
            AppMethodBeat.o(19690);
            return false;
        }
    }

    public final boolean c(long j, int i, k kVar) {
        AppMethodBeat.i(19691);
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", Long.valueOf(j), Integer.valueOf(i));
        if (a(this.lxg, j, (IInterface) kVar)) {
            try {
                kVar.a(j, -1, 1, -1, 0);
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            if (this.lxj != null) {
                boolean connect;
                com.tencent.mm.plugin.d.a.b.e eVar = this.lxj;
                ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", Long.valueOf(j));
                if (eVar.aVw()) {
                    com.tencent.mm.plugin.d.a.b.f fVar = (com.tencent.mm.plugin.d.a.b.f) eVar.jFA.get(Long.valueOf(j));
                    if (fVar != null) {
                        ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
                        connect = fVar.connect();
                    } else {
                        fVar = new com.tencent.mm.plugin.d.a.b.f(j, eVar.Gn, eVar.jGl);
                        if (fVar.connect()) {
                            eVar.Q(new com.tencent.mm.plugin.d.a.b.e.AnonymousClass4(j, fVar));
                            connect = true;
                        } else {
                            ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
                            connect = false;
                        }
                    }
                } else {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    connect = false;
                }
                if (!connect) {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", Long.valueOf(j));
                    if (kVar != null) {
                        try {
                            kVar.a(j, 1, 4, -1, 0);
                        } catch (RemoteException e2) {
                            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(19691);
                    return false;
                }
            }
            AppMethodBeat.o(19691);
            return true;
        }
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
        try {
            kVar.a(j, -1, 4, -1, 0);
        } catch (RemoteException e22) {
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e22, "", new Object[0]);
        }
        AppMethodBeat.o(19691);
        return false;
    }

    public final boolean c(long j, byte[] bArr, t tVar) {
        AppMethodBeat.i(19692);
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", Long.valueOf(j), com.tencent.mm.plugin.exdevice.j.b.aN(bArr));
        if (this.lxj != null) {
            boolean z;
            com.tencent.mm.plugin.d.a.b.e eVar = this.lxj;
            ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", Long.valueOf(j));
            if (eVar.aVw()) {
                com.tencent.mm.plugin.d.a.b.f fVar = (com.tencent.mm.plugin.d.a.b.f) eVar.jFA.get(Long.valueOf(j));
                if (fVar == null) {
                    ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
                    z = false;
                } else {
                    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
                    z = fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(3, bArr));
                }
            } else {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                z = false;
            }
            if (!z) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
                if (tVar != null) {
                    try {
                        tVar.b(j, -1, -1, "start write data error");
                    } catch (RemoteException e) {
                        ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(19692);
                return false;
            }
        }
        if (a(this.lxi, j, (IInterface) tVar)) {
            AppMethodBeat.o(19692);
            return true;
        }
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
        AppMethodBeat.o(19692);
        return false;
    }

    public final boolean b(long j, int i, int i2, int i3, long j2) {
        AppMethodBeat.i(19693);
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        k kVar = (k) a(j, this.lxg, this.lxg.beginBroadcast());
        if (kVar == null) {
            ab.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(j)));
            this.lxg.finishBroadcast();
            AppMethodBeat.o(19693);
            return false;
        }
        try {
            kVar.a(j, i, i2, i3, j2);
            this.lxg.finishBroadcast();
            AppMethodBeat.o(19693);
            return true;
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            this.lxg.finishBroadcast();
            AppMethodBeat.o(19693);
            return false;
        } catch (Throwable th) {
            this.lxg.finishBroadcast();
            AppMethodBeat.o(19693);
        }
    }

    public final boolean e(long j, int i, int i2, String str) {
        AppMethodBeat.i(19694);
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        t tVar = (t) a(j, this.lxi, this.lxi.beginBroadcast());
        if (tVar == null) {
            ab.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(j)));
            this.lxi.finishBroadcast();
            AppMethodBeat.o(19694);
            return false;
        }
        try {
            tVar.b(j, i, i2, str);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lxi.finishBroadcast();
            AppMethodBeat.o(19694);
            return false;
        }
        return true;
    }

    public final boolean d(long j, byte[] bArr) {
        int i = 0;
        AppMethodBeat.i(19695);
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "simpleBTOnRecvImpl. mac=%d, data = %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = bArr == null ? BuildConfig.COMMAND : com.tencent.mm.plugin.exdevice.j.b.aN(bArr);
        ab.d(str, str2, objArr);
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "SimpleOnRecvList size = %d", Integer.valueOf(this.lxh.beginBroadcast()));
        while (i < r2) {
            try {
                s sVar = (s) this.lxh.getBroadcastItem(i);
                if (sVar != null) {
                    sVar.c(j, bArr);
                } else {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ISimpleBTOnRecv_AIDL callback is null");
                }
                i++;
            } catch (RemoteException e) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onDataRecv Failed!!!");
                ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                this.lxh.finishBroadcast();
            } catch (Throwable th) {
                this.lxh.finishBroadcast();
                AppMethodBeat.o(19695);
            }
        }
        this.lxh.finishBroadcast();
        AppMethodBeat.o(19695);
        return true;
    }

    static /* synthetic */ void a(y yVar, int i, long j, short s, short s2, byte[] bArr) {
        AppMethodBeat.i(19702);
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequestImp errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        int beginBroadcast = yVar.lwY.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                i iVar = (i) yVar.lwY.getBroadcastItem(i2);
                if (iVar != null) {
                    iVar.a(i, j, s, s2, bArr);
                } else {
                    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "get req callback failed, cmdId = %d", Short.valueOf(s2));
                }
            } catch (Exception e) {
                ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest Failed!!! i = ".concat(String.valueOf(i2)));
                ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        yVar.lwY.finishBroadcast();
        AppMethodBeat.o(19702);
    }
}
