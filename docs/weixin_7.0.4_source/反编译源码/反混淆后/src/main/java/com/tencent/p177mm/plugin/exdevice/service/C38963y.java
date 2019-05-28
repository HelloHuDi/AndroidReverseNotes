package com.tencent.p177mm.plugin.exdevice.service;

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
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.service.C34039a.C27856f;
import com.tencent.p177mm.plugin.exdevice.service.C34039a.C2987g;
import com.tencent.p177mm.plugin.exdevice.service.C45893h.C27861a;
import com.tencent.p177mm.plugin.p369d.p370a.p371a.C11457c;
import com.tencent.p177mm.plugin.p369d.p370a.p371a.C11462f;
import com.tencent.p177mm.plugin.p369d.p370a.p371a.C11462f.C114677;
import com.tencent.p177mm.plugin.p369d.p370a.p371a.C11462f.C114686;
import com.tencent.p177mm.plugin.p369d.p370a.p371a.C27698b;
import com.tencent.p177mm.plugin.p369d.p370a.p371a.C41263h;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C33889f;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C38828e;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C38828e.C388274;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C38828e.C388305;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C38828e.C38831a;
import com.tencent.p177mm.plugin.p369d.p370a.p375d.C38837a;
import com.tencent.p177mm.plugin.p369d.p370a.p375d.C38837a.C33895a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.service.y */
public final class C38963y extends C27861a implements C27698b, C33895a, C20544g {
    private C34039a lwU;
    private RemoteCallbackList<C38959k> lwV;
    private RemoteCallbackList<C11661p> lwW;
    private RemoteCallbackList<C43000j> lwX;
    private RemoteCallbackList<C38958i> lwY;
    private RemoteCallbackList<C45894q> lwZ;
    private RemoteCallbackList<C11658n> lxa;
    private final C20554l lxb;
    private int lxc;
    private final C11462f lxd;
    private final C38837a lxe;
    private RemoteCallbackList<C43000j> lxf;
    private RemoteCallbackList<C38959k> lxg;
    private RemoteCallbackList<C43003s> lxh;
    private RemoteCallbackList<C43005t> lxi;
    C38828e lxj;
    private C38831a lxk;
    private final C7306ak mHandler;

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$d */
    static final class C11664d {
        String hxN = null;
        int lqL = 0;
        int lqz = 0;
        long lwo = 0;
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$2 */
    class C205512 implements C41932a {
        C205512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19654);
            C38963y.this.lxj = new C38828e(C38963y.this.lxk);
            AppMethodBeat.m2505o(19654);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$e */
    static final class C20552e {
        public long ltB;
        public int lxn;
        public C38959k lxo;

        private C20552e() {
        }

        /* synthetic */ C20552e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$f */
    static final class C20553f {
        public long ltB;
        public byte[] mData;

        private C20553f() {
        }

        /* synthetic */ C20553f(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$l */
    static final class C20554l {
        long lwo;

        private C20554l() {
            this.lwo = 0;
        }

        /* synthetic */ C20554l(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$c */
    static final class C27870c {
        long jGw;
        long jJa;
        int lqz;
        int lwm;
        int lwn;

        private C27870c() {
            this.jJa = 0;
            this.lwm = 0;
            this.lwn = 0;
            this.lqz = 0;
            this.jGw = 0;
        }

        /* synthetic */ C27870c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$1 */
    class C340531 extends C38831a {
        C340531() {
        }

        /* renamed from: a */
        public final void mo54591a(long j, boolean z, long j2) {
            int i;
            AppMethodBeat.m2504i(19649);
            String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
            String str2 = "onConnected. seesionId=%d, connected=%s, profileType=%d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j);
            objArr[1] = z ? "true" : "false";
            objArr[2] = Long.valueOf(j2);
            C4990ab.m7411d(str, str2, objArr);
            C27870c c27870c = new C27870c();
            c27870c.jJa = j;
            if (z) {
                i = 2;
            } else {
                i = 4;
            }
            c27870c.lwn = i;
            c27870c.lwm = 1;
            c27870c.lqz = 0;
            c27870c.jGw = j2;
            if (!C38963y.this.mHandler.sendMessage(C38963y.this.mHandler.obtainMessage(9, c27870c))) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(9));
            }
            AppMethodBeat.m2505o(19649);
        }

        /* renamed from: b */
        public final void mo54594b(long j, byte[] bArr) {
            AppMethodBeat.m2504i(19650);
            C20553f c20553f = new C20553f();
            c20553f.ltB = j;
            c20553f.mData = bArr;
            if (!C38963y.this.mHandler.sendMessage(C38963y.this.mHandler.obtainMessage(12, c20553f))) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(12));
            }
            AppMethodBeat.m2505o(19650);
        }

        /* renamed from: m */
        public final void mo54595m(long j, boolean z) {
            AppMethodBeat.m2504i(19651);
            String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
            String str2 = "onSend. sessionId=%d, success=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(j);
            objArr[1] = z ? "true" : "false";
            C4990ab.m7411d(str, str2, objArr);
            C38966h c38966h = new C38966h();
            c38966h.ltB = j;
            if (z) {
                c38966h.lqL = 0;
                c38966h.lqz = 0;
            } else {
                c38966h.lqL = -1;
                c38966h.lqz = -1;
            }
            c38966h.hxN = "";
            if (!C38963y.this.mHandler.sendMessage(C38963y.this.mHandler.obtainMessage(11, c38966h))) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(11));
            }
            AppMethodBeat.m2505o(19651);
        }

        /* renamed from: a */
        public final void mo54592a(String str, String str2, int i, byte[] bArr) {
            AppMethodBeat.m2504i(19652);
            C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", str, str2);
            C38965g c38965g = new C38965g();
            c38965g.lxp = false;
            c38965g.jJe = str;
            c38965g.mDeviceName = str2;
            c38965g.hGc = i;
            c38965g.lxq = bArr;
            if (!C38963y.this.mHandler.sendMessage(C38963y.this.mHandler.obtainMessage(13, c38965g))) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(13));
            }
            AppMethodBeat.m2505o(19652);
        }

        public final void aVx() {
            AppMethodBeat.m2504i(19653);
            C4990ab.m7410d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
            C38965g c38965g = new C38965g();
            c38965g.lxp = true;
            c38965g.jJe = null;
            c38965g.mDeviceName = null;
            c38965g.hGc = 0;
            c38965g.lxq = null;
            if (!C38963y.this.mHandler.sendMessage(C38963y.this.mHandler.obtainMessage(13, c38965g))) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(13));
            }
            AppMethodBeat.m2505o(19653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$b */
    static final class C38964b {
        long jJa;
        byte[] lqA;
        short lqG;
        short lwl;
        int mErrorCode;

        private C38964b() {
            this.jJa = 0;
            this.lqG = (short) 0;
            this.lwl = (short) 0;
            this.lqA = null;
            this.mErrorCode = 0;
        }

        /* synthetic */ C38964b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$g */
    static final class C38965g {
        int hGc;
        String jJe;
        boolean lxp;
        byte[] lxq;
        String mDeviceName;

        private C38965g() {
        }

        /* synthetic */ C38965g(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$h */
    static final class C38966h {
        public String hxN;
        public int lqL;
        public int lqz;
        public long ltB;

        private C38966h() {
        }

        /* synthetic */ C38966h(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$i */
    static final class C38967i {
        public long ltB;
        public C43005t lxr;
        public byte[] mData;

        private C38967i() {
        }

        /* synthetic */ C38967i(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$k */
    static final class C38968k {
        long lwo;
        C11661p lxt;

        public C38968k(long j, C11661p c11661p) {
            this.lwo = j;
            this.lxt = c11661p;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$a */
    final class C38970a extends C7306ak {
        public C38970a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(19657);
            switch (message.what) {
                case 0:
                    C38968k c38968k = (C38968k) message.obj;
                    if (!C38963y.m66151a(C38963y.this, c38968k.lwo, c38968k.lxt)) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 1:
                    if (!C38963y.m66149a(C38963y.this, ((Long) message.obj).longValue())) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 2:
                    C11664d c11664d = (C11664d) message.obj;
                    C38963y.m66144a(C38963y.this, c11664d.lwo, c11664d.lqL, c11664d.lqz, c11664d.hxN);
                    AppMethodBeat.m2505o(19657);
                    return;
                case 3:
                    C38971j c38971j = (C38971j) message.obj;
                    if (!C38963y.m66150a(C38963y.this, c38971j.jJa, c38971j.lxs, c38971j.lxo)) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 4:
                    if (!C38963y.m66155b(C38963y.this, ((Long) message.obj).longValue())) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                        AppMethodBeat.m2505o(19657);
                        return;
                    }
                    break;
                case 5:
                    C27870c c27870c = (C27870c) message.obj;
                    C38963y.m66143a(C38963y.this, c27870c.jJa, c27870c.lwm, c27870c.lwn, c27870c.lqz);
                    AppMethodBeat.m2505o(19657);
                    return;
                case 6:
                    C38964b c38964b = (C38964b) message.obj;
                    C38963y.m66142a(C38963y.this, c38964b.mErrorCode, c38964b.jJa, c38964b.lqG, c38964b.lwl, c38964b.lqA);
                    AppMethodBeat.m2505o(19657);
                    return;
                case 7:
                    C20552e c20552e = (C20552e) message.obj;
                    if (!C38963y.this.mo61845c(c20552e.ltB, c20552e.lxn, c20552e.lxo)) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 8:
                    long longValue = ((Long) message.obj).longValue();
                    C38963y c38963y = C38963y.this;
                    C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", Long.valueOf(longValue));
                    if (c38963y.lxj != null) {
                        C38828e c38828e = c38963y.lxj;
                        C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", Long.valueOf(longValue));
                        if (c38828e.aVw()) {
                            c38828e.mo61710Q(new C388305(longValue));
                        } else {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                            AppMethodBeat.m2505o(19657);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 9:
                    C27870c c27870c2 = (C27870c) message.obj;
                    if (!C38963y.this.mo61844b(c27870c2.jJa, c27870c2.lwm, c27870c2.lwn, c27870c2.lqz, c27870c2.jGw)) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 10:
                    C38967i c38967i = (C38967i) message.obj;
                    if (!C38963y.this.mo61846c(c38967i.ltB, c38967i.mData, c38967i.lxr)) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 11:
                    C38966h c38966h = (C38966h) message.obj;
                    if (!C38963y.this.mo61848e(c38966h.ltB, c38966h.lqL, c38966h.lqz, c38966h.hxN)) {
                        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
                    }
                    AppMethodBeat.m2505o(19657);
                    return;
                case 12:
                    C20553f c20553f = (C20553f) message.obj;
                    C38963y.this.mo61847d(c20553f.ltB, c20553f.mData);
                    AppMethodBeat.m2505o(19657);
                    return;
                case 13:
                    C38963y.m66145a(C38963y.this, (C38965g) message.obj);
                    break;
            }
            AppMethodBeat.m2505o(19657);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.y$j */
    static final class C38971j {
        long jJa;
        C38959k lxo;
        int lxs;

        public C38971j(long j, int i, C38959k c38959k) {
            this.jJa = j;
            this.lxs = i;
            this.lxo = c38959k;
        }
    }

    public C38963y() {
        AppMethodBeat.m2504i(19658);
        this.lwU = null;
        this.lwV = new RemoteCallbackList();
        this.lwW = new RemoteCallbackList();
        this.lwX = new RemoteCallbackList();
        this.lwY = new RemoteCallbackList();
        this.lwZ = new RemoteCallbackList();
        this.lxa = new RemoteCallbackList();
        this.lxb = new C20554l();
        this.lxc = 0;
        this.lxf = new RemoteCallbackList();
        this.lxg = new RemoteCallbackList();
        this.lxh = new RemoteCallbackList();
        this.lxi = new RemoteCallbackList();
        this.lwU = new C34039a(this);
        this.mHandler = new C38970a(C20549v.bpz().fPG.oAl.getLooper());
        if (VERSION.SDK_INT >= 18) {
            this.lxd = new C11462f(this);
        } else {
            this.lxd = null;
        }
        this.lxe = new C38837a(this);
        this.lxk = new C340531();
        C41933a.m74069a(18, new C205512());
        AppMethodBeat.m2505o(19658);
    }

    /* renamed from: a */
    private static IInterface m66139a(long j, RemoteCallbackList remoteCallbackList, int i) {
        AppMethodBeat.m2504i(19659);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", Long.valueOf(j), Integer.valueOf(i));
        for (int i2 = 0; i2 < i; i2++) {
            HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i2);
            if (hashMap.containsKey(Long.valueOf(j))) {
                IInterface iInterface = (IInterface) hashMap.get(Long.valueOf(j));
                AppMethodBeat.m2505o(19659);
                return iInterface;
            }
        }
        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
        AppMethodBeat.m2505o(19659);
        return null;
    }

    /* renamed from: c */
    private boolean m66156c(C43000j c43000j) {
        AppMethodBeat.m2504i(19660);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
        boolean unregister = this.lwX.unregister(c43000j);
        if (unregister) {
            this.lxc--;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
        }
        AppMethodBeat.m2505o(19660);
        return unregister;
    }

    /* renamed from: b */
    public final boolean mo45736b(final int i, final C43000j c43000j) {
        AppMethodBeat.m2504i(19661);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = ".concat(String.valueOf(i)));
        if (c43000j == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            AppMethodBeat.m2505o(19661);
            return false;
        }
        boolean post = this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(19655);
                if (!C38963y.m66148a(C38963y.this, i, c43000j)) {
                    C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
                }
                AppMethodBeat.m2505o(19655);
            }
        });
        if (!post) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19661);
        return post;
    }

    /* renamed from: f */
    private boolean m66158f(int i, C43000j c43000j) {
        AppMethodBeat.m2504i(19662);
        if (c43000j == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scanImp: null == aCallback");
            AppMethodBeat.m2505o(19662);
            throw illegalArgumentException;
        }
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
        boolean register = this.lwX.register(c43000j);
        if (register) {
            this.lxc++;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
        }
        if (register) {
            boolean z;
            C43002r c43002r = this.lwU;
            C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", Integer.valueOf(i));
            if (C34044b.m55781a(i, c43002r, new int[0])) {
                z = true;
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
                z = false;
            }
            if (!z) {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
                try {
                    c43000j.mo7194a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
                if (!m66156c(c43000j)) {
                    C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                }
            }
            AppMethodBeat.m2505o(19662);
            return z;
        }
        try {
            c43000j.mo7194a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
        } catch (RemoteException e2) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e2.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        }
        AppMethodBeat.m2505o(19662);
        return false;
    }

    /* renamed from: c */
    public final boolean mo45741c(final int i, final C43000j c43000j) {
        AppMethodBeat.m2504i(19663);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = ".concat(String.valueOf(i)));
        if (c43000j == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
            AppMethodBeat.m2505o(19663);
            return false;
        }
        boolean post = this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(19656);
                if (!C38963y.m66154b(C38963y.this, i, c43000j)) {
                    C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
                }
                AppMethodBeat.m2505o(19656);
            }
        });
        if (!post) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19663);
        return post;
    }

    /* renamed from: g */
    private boolean m66159g(int i, C43000j c43000j) {
        AppMethodBeat.m2504i(19664);
        if (c43000j == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            AppMethodBeat.m2505o(19664);
            return false;
        }
        boolean uL = C34039a.m55774uL(i);
        if (!uL) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
            try {
                c43000j.mo7194a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
            } catch (RemoteException e) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        if (!m66156c(c43000j)) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        AppMethodBeat.m2505o(19664);
        return uL;
    }

    public final long[] bpl() {
        AppMethodBeat.m2504i(19665);
        long[] bpl = C34039a.bpl();
        AppMethodBeat.m2505o(19665);
        return bpl;
    }

    /* renamed from: a */
    private static boolean m66146a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface) {
        AppMethodBeat.m2504i(19666);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", Long.valueOf(j));
        if (remoteCallbackList == null || iInterface == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            AppMethodBeat.m2505o(19666);
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
            C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
            hashMap = new HashMap();
            hashMap.put(Long.valueOf(j), iInterface);
            remoteCallbackList.register(iInterface, hashMap);
            remoteCallbackList.finishBroadcast();
            AppMethodBeat.m2505o(19666);
            return true;
        }
        hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(beginBroadcast);
        if (hashMap == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            remoteCallbackList.finishBroadcast();
            AppMethodBeat.m2505o(19666);
            return false;
        }
        hashMap.put(Long.valueOf(j), iInterface);
        remoteCallbackList.finishBroadcast();
        AppMethodBeat.m2505o(19666);
        return true;
    }

    /* renamed from: a */
    private static boolean m66147a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface, int i) {
        AppMethodBeat.m2504i(19667);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", Long.valueOf(j), Integer.valueOf(i));
        if (remoteCallbackList == null || iInterface == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            AppMethodBeat.m2505o(19667);
            return false;
        }
        do {
            i--;
            if (i < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(i).asBinder().equals(iInterface.asBinder()));
        if (i < 0) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
            AppMethodBeat.m2505o(19667);
            return false;
        }
        HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i);
        if (hashMap == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            AppMethodBeat.m2505o(19667);
            return false;
        } else if (((IInterface) hashMap.remove(Long.valueOf(j))) == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
            AppMethodBeat.m2505o(19667);
            return false;
        } else if (hashMap.isEmpty()) {
            C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
            boolean unregister = remoteCallbackList.unregister(iInterface);
            if (!unregister) {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
            }
            AppMethodBeat.m2505o(19667);
            return unregister;
        } else {
            AppMethodBeat.m2505o(19667);
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo45731a(long j, int i, C38959k c38959k) {
        AppMethodBeat.m2504i(19668);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", Long.valueOf(j), Integer.valueOf(i));
        if (c38959k == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
            AppMethodBeat.m2505o(19668);
            return false;
        } else if (j < 0) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.m2505o(19668);
            return false;
        } else if (1 == i || i == 0) {
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(3, new C38971j(j, i, c38959k)))) {
                AppMethodBeat.m2505o(19668);
                return true;
            }
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", Integer.valueOf(3));
            AppMethodBeat.m2505o(19668);
            return false;
        } else {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(19668);
            return false;
        }
    }

    /* renamed from: hZ */
    public final boolean mo45744hZ(long j) {
        AppMethodBeat.m2504i(19669);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", Long.valueOf(j));
        if (j < 0) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.m2505o(19669);
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j)))) {
            AppMethodBeat.m2505o(19669);
            return true;
        } else {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", Integer.valueOf(4));
            AppMethodBeat.m2505o(19669);
            return false;
        }
    }

    /* renamed from: ia */
    public final boolean mo45745ia(long j) {
        return false;
    }

    /* renamed from: b */
    private boolean m66153b(long j, C11661p c11661p) {
        AppMethodBeat.m2504i(19670);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", Long.valueOf(j));
        if (c11661p == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            m66157d(j, -1, -1, "null == aTask");
            AppMethodBeat.m2505o(19670);
            return false;
        }
        boolean z;
        C34039a c34039a = this.lwU;
        C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(c11661p);
        if (c34039a.mHandler.sendMessage(c34039a.mHandler.obtainMessage(8, new C2987g(j, c11661p)))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startTask Failed ret = -1");
            m66157d(j, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
            AppMethodBeat.m2505o(19670);
            return false;
        } else if (C38963y.m66146a(this.lwW, j, (IInterface) c11661p)) {
            AppMethodBeat.m2505o(19670);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
            m66157d(j, -1, -1, "registerRemoteCB Fail!!!");
            AppMethodBeat.m2505o(19670);
            return false;
        }
    }

    /* renamed from: a */
    public final long mo45729a(C11661p c11661p) {
        AppMethodBeat.m2504i(19671);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
        if (c11661p == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            AppMethodBeat.m2505o(19671);
            return -1;
        }
        C20554l c20554l = this.lxb;
        if (Long.MAX_VALUE == c20554l.lwo) {
            C4990ab.m7420w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
            c20554l.lwo = 0;
        }
        long j = c20554l.lwo;
        c20554l.lwo = 1 + j;
        if (this.mHandler.sendMessage(this.mHandler.obtainMessage(0, new C38968k(j, c11661p)))) {
            AppMethodBeat.m2505o(19671);
            return j;
        }
        C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", Integer.valueOf(0));
        AppMethodBeat.m2505o(19671);
        return -1;
    }

    /* renamed from: ib */
    public final boolean mo45746ib(long j) {
        AppMethodBeat.m2504i(19672);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", Long.valueOf(j));
        if (j < 0) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            AppMethodBeat.m2505o(19672);
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(j)))) {
            AppMethodBeat.m2505o(19672);
            return true;
        } else {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", Integer.valueOf(1));
            AppMethodBeat.m2505o(19672);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo45732a(C38958i c38958i) {
        AppMethodBeat.m2504i(19673);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
        boolean register = this.lwY.register(c38958i);
        if (!register) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
        }
        AppMethodBeat.m2505o(19673);
        return register;
    }

    /* renamed from: b */
    public final boolean mo45739b(C38958i c38958i) {
        AppMethodBeat.m2504i(19674);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
        boolean unregister = this.lwY.unregister(c38958i);
        if (!unregister) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
        }
        AppMethodBeat.m2505o(19674);
        return unregister;
    }

    /* renamed from: a */
    public final void mo35817a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(19675);
        int beginBroadcast = this.lwX.beginBroadcast();
        int i4 = 0;
        while (i4 < beginBroadcast) {
            try {
                ((C43000j) this.lwX.getBroadcastItem(i4)).mo7194a(i, i2, str, str2, str3, i3, bArr);
                if (2 == i && !this.lwX.unregister(this.lwX.getBroadcastItem(i4))) {
                    C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
                }
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = ".concat(String.valueOf(i4)));
                C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            i4++;
        }
        this.lwX.finishBroadcast();
        AppMethodBeat.m2505o(19675);
    }

    /* renamed from: d */
    private void m66157d(long j, int i, int i2, String str) {
        AppMethodBeat.m2504i(19676);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        int beginBroadcast = this.lwW.beginBroadcast();
        IInterface iInterface = (C11661p) C38963y.m66139a(j, this.lwW, beginBroadcast);
        if (iInterface == null) {
            C4990ab.m7420w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = ".concat(String.valueOf(j)));
            this.lwW.finishBroadcast();
            AppMethodBeat.m2505o(19676);
            return;
        }
        try {
            iInterface.bpv().mo23407a(j, i, i2, str, iInterface);
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        if (!C38963y.m66147a(this.lwW, j, iInterface, beginBroadcast)) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
        }
        this.lwW.finishBroadcast();
        AppMethodBeat.m2505o(19676);
    }

    /* renamed from: c */
    public final void mo35820c(long j, int i, int i2, String str) {
        AppMethodBeat.m2504i(19677);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        C11664d c11664d = new C11664d();
        c11664d.lwo = j;
        c11664d.lqL = i;
        c11664d.lqz = i2;
        c11664d.hxN = str;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c11664d))) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", Integer.valueOf(2));
        }
        AppMethodBeat.m2505o(19677);
    }

    /* renamed from: a */
    public final void mo35818a(int i, long j, short s, short s2, byte[] bArr) {
        AppMethodBeat.m2504i(19678);
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        C38964b c38964b = new C38964b();
        c38964b.lwl = s2;
        c38964b.lqA = bArr;
        c38964b.jJa = j;
        c38964b.lqG = s;
        c38964b.mErrorCode = i;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, c38964b))) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(6));
        }
        AppMethodBeat.m2505o(19678);
    }

    /* renamed from: b */
    public final void mo35819b(long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(19679);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        C27870c c27870c = new C27870c();
        c27870c.jJa = j;
        c27870c.lwm = i;
        c27870c.lwn = i2;
        c27870c.lqz = i3;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, c27870c))) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", Integer.valueOf(5));
        }
        AppMethodBeat.m2505o(19679);
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        AppMethodBeat.m2504i(19680);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", Long.valueOf(j));
        C34039a c34039a = this.lwU;
        C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", Long.valueOf(j));
        if (!c34039a.mHandler.sendMessage(c34039a.mHandler.obtainMessage(10, new C27856f(j, bArr)))) {
            C4990ab.m7413e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", Integer.valueOf(10));
        }
        AppMethodBeat.m2505o(19680);
    }

    /* renamed from: a */
    public final boolean mo45734a(String str, boolean z, C45894q c45894q) {
        AppMethodBeat.m2504i(19681);
        if (VERSION.SDK_INT < 18 || this.lxd == null) {
            AppMethodBeat.m2505o(19681);
            return false;
        }
        boolean hasSystemFeature = C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!hasSystemFeature || defaultAdapter == null) {
            AppMethodBeat.m2505o(19681);
            return false;
        }
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (this.lwZ.register(c45894q)) {
            try {
                UUID fromString = UUID.fromString(str);
                C11462f c11462f = this.lxd;
                C11462f.jET = C4996ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                String str2 = "MicroMsg.exdevice.IBeaconServer";
                String str3 = "Ranging, uuid = %s, op = %s";
                Object[] objArr = new Object[2];
                objArr[0] = fromString == null ? "" : fromString.toString();
                objArr[1] = String.valueOf(z);
                C4990ab.m7411d(str2, str3, objArr);
                if (fromString == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                    hasSystemFeature = false;
                } else if (z) {
                    hasSystemFeature = c11462f.mHandler.post(new C114686(fromString));
                } else {
                    hasSystemFeature = c11462f.mHandler.post(new C114677(fromString));
                }
                if (hasSystemFeature) {
                    AppMethodBeat.m2505o(19681);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
                if (!this.lwZ.unregister(c45894q)) {
                    C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
                }
                AppMethodBeat.m2505o(19681);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", e.getMessage());
                AppMethodBeat.m2505o(19681);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
        AppMethodBeat.m2505o(19681);
        return false;
    }

    /* renamed from: a */
    public final void mo23192a(double d, C11457c c11457c) {
        AppMethodBeat.m2504i(19682);
        if (c11457c == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
            AppMethodBeat.m2505o(19682);
            return;
        }
        C41263h c41263h = c11457c.jEK.jEO;
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", Double.valueOf(d), C42992b.m76349aN(c41263h.jFp), Short.valueOf(c41263h.jFq), Short.valueOf(c41263h.jFr), Integer.valueOf(c41263h.jFr & CdnLogic.kBizGeneric));
        try {
            int beginBroadcast = this.lwZ.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((C45894q) this.lwZ.getBroadcastItem(i)).mo7191a(d, c41263h.jFq, c41263h.jFr, c41263h.jFp, c11457c.jEL, c11457c.jEK.jEO.jFs, c11457c.cbq);
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", Integer.valueOf(i), e.toString());
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", e2.toString());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        } finally {
            this.lwZ.finishBroadcast();
            AppMethodBeat.m2505o(19682);
        }
    }

    /* renamed from: rS */
    public final void mo54454rS(int i) {
        AppMethodBeat.m2504i(19683);
        C4990ab.m7417i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", Integer.valueOf(i));
        for (int beginBroadcast = this.lxa.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_state", i);
            try {
                ((C11658n) this.lxa.getBroadcastItem(beginBroadcast)).mo23409k(0, bundle);
            } catch (RemoteException e) {
                C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", Integer.valueOf(beginBroadcast));
                C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        this.lxa.finishBroadcast();
        AppMethodBeat.m2505o(19683);
    }

    /* renamed from: a */
    public final void mo45730a(C11658n c11658n) {
        AppMethodBeat.m2504i(19684);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
        if (!this.lxa.register(c11658n)) {
            C4990ab.m7416i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
        }
        AppMethodBeat.m2505o(19684);
    }

    /* renamed from: d */
    public final boolean mo45742d(int i, C43000j c43000j) {
        AppMethodBeat.m2504i(19685);
        C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", Integer.valueOf(i));
        if (c43000j == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
            AppMethodBeat.m2505o(19685);
            return false;
        } else if (i != 0) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
            AppMethodBeat.m2505o(19685);
            return false;
        } else {
            boolean register = this.lxf.register(c43000j);
            if (register) {
                C4990ab.m7410d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
            }
            if (this.lxj != null) {
                boolean a;
                C38828e c38828e = this.lxj;
                C4990ab.m7410d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
                Assert.assertTrue(c38828e.jFC != null);
                if (c38828e.aVw()) {
                    a = c38828e.jFC.mo6989a(true, c38828e.jFF);
                    if (a) {
                        c38828e.jGj.clear();
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    a = false;
                }
                if (!a) {
                    C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
                    try {
                        c43000j.mo7194a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
                    } catch (RemoteException e) {
                        C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                    if (register) {
                        this.lxf.unregister(c43000j);
                    }
                    AppMethodBeat.m2505o(19685);
                    return false;
                }
            }
            AppMethodBeat.m2505o(19685);
            return true;
        }
    }

    /* renamed from: e */
    public final boolean mo45743e(int i, C43000j c43000j) {
        AppMethodBeat.m2504i(19686);
        C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", Integer.valueOf(i));
        if (c43000j == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
            AppMethodBeat.m2505o(19686);
            return false;
        } else if (this.lxj == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
            AppMethodBeat.m2505o(19686);
            return false;
        } else {
            boolean a;
            C38828e c38828e = this.lxj;
            C4990ab.m7410d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
            Assert.assertTrue(c38828e.jFC != null);
            if (c38828e.aVw()) {
                c38828e.mHandler.removeCallbacks(c38828e.mRunnable);
                a = c38828e.jFC.mo6989a(false, c38828e.jFF);
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                a = false;
            }
            if (!a) {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                try {
                    c43000j.mo7194a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(19686);
            return a;
        }
    }

    /* renamed from: b */
    public final boolean mo45737b(long j, int i, C38959k c38959k) {
        AppMethodBeat.m2504i(19687);
        if (c38959k == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            AppMethodBeat.m2505o(19687);
            return false;
        } else if (j < 0) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.m2505o(19687);
            return false;
        } else if (i != 0) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(19687);
            return false;
        } else {
            C20552e c20552e = new C20552e();
            c20552e.ltB = j;
            c20552e.lxn = i;
            c20552e.lxo = c38959k;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(7, c20552e))) {
                AppMethodBeat.m2505o(19687);
                return true;
            }
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(7));
            AppMethodBeat.m2505o(19687);
            return false;
        }
    }

    /* renamed from: ic */
    public final boolean mo45747ic(long j) {
        AppMethodBeat.m2504i(19688);
        if (j < 0) {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            AppMethodBeat.m2505o(19688);
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j)))) {
            AppMethodBeat.m2505o(19688);
            return true;
        } else {
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(8));
            AppMethodBeat.m2505o(19688);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo45733a(C43003s c43003s) {
        AppMethodBeat.m2504i(19689);
        if (c43003s == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            AppMethodBeat.m2505o(19689);
            return false;
        }
        boolean register = this.lxh.register(c43003s);
        if (!register) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
        }
        AppMethodBeat.m2505o(19689);
        return register;
    }

    /* renamed from: b */
    public final boolean mo45738b(long j, byte[] bArr, C43005t c43005t) {
        AppMethodBeat.m2504i(19690);
        if (0 > j) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
            AppMethodBeat.m2505o(19690);
            return false;
        } else if (bArr == null || bArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
            AppMethodBeat.m2505o(19690);
            return false;
        } else if (c43005t == null) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            AppMethodBeat.m2505o(19690);
            return false;
        } else {
            C38967i c38967i = new C38967i();
            c38967i.ltB = j;
            c38967i.mData = bArr;
            c38967i.lxr = c43005t;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(10, c38967i))) {
                AppMethodBeat.m2505o(19690);
                return true;
            }
            C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(10));
            AppMethodBeat.m2505o(19690);
            return false;
        }
    }

    /* renamed from: c */
    public final boolean mo61845c(long j, int i, C38959k c38959k) {
        AppMethodBeat.m2504i(19691);
        C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", Long.valueOf(j), Integer.valueOf(i));
        if (C38963y.m66146a(this.lxg, j, (IInterface) c38959k)) {
            try {
                c38959k.mo7187a(j, -1, 1, -1, 0);
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            if (this.lxj != null) {
                boolean connect;
                C38828e c38828e = this.lxj;
                C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", Long.valueOf(j));
                if (c38828e.aVw()) {
                    C33889f c33889f = (C33889f) c38828e.jFA.get(Long.valueOf(j));
                    if (c33889f != null) {
                        C4990ab.m7410d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
                        connect = c33889f.connect();
                    } else {
                        c33889f = new C33889f(j, c38828e.f16165Gn, c38828e.jGl);
                        if (c33889f.connect()) {
                            c38828e.mo61710Q(new C388274(j, c33889f));
                            connect = true;
                        } else {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
                            connect = false;
                        }
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    connect = false;
                }
                if (!connect) {
                    C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", Long.valueOf(j));
                    if (c38959k != null) {
                        try {
                            c38959k.mo7187a(j, 1, 4, -1, 0);
                        } catch (RemoteException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(19691);
                    return false;
                }
            }
            AppMethodBeat.m2505o(19691);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
        try {
            c38959k.mo7187a(j, -1, 4, -1, 0);
        } catch (RemoteException e22) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e22, "", new Object[0]);
        }
        AppMethodBeat.m2505o(19691);
        return false;
    }

    /* renamed from: c */
    public final boolean mo61846c(long j, byte[] bArr, C43005t c43005t) {
        AppMethodBeat.m2504i(19692);
        C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", Long.valueOf(j), C42992b.m76349aN(bArr));
        if (this.lxj != null) {
            boolean z;
            C38828e c38828e = this.lxj;
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", Long.valueOf(j));
            if (c38828e.aVw()) {
                C33889f c33889f = (C33889f) c38828e.jFA.get(Long.valueOf(j));
                if (c33889f == null) {
                    C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
                    z = false;
                } else {
                    C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", Integer.valueOf(bArr.length), C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
                    z = c33889f.mHandler.sendMessage(c33889f.mHandler.obtainMessage(3, bArr));
                }
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                z = false;
            }
            if (!z) {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
                if (c43005t != null) {
                    try {
                        c43005t.mo35810b(j, -1, -1, "start write data error");
                    } catch (RemoteException e) {
                        C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(19692);
                return false;
            }
        }
        if (C38963y.m66146a(this.lxi, j, (IInterface) c43005t)) {
            AppMethodBeat.m2505o(19692);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
        AppMethodBeat.m2505o(19692);
        return false;
    }

    /* renamed from: b */
    public final boolean mo61844b(long j, int i, int i2, int i3, long j2) {
        AppMethodBeat.m2504i(19693);
        C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        C38959k c38959k = (C38959k) C38963y.m66139a(j, this.lxg, this.lxg.beginBroadcast());
        if (c38959k == null) {
            C4990ab.m7420w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(j)));
            this.lxg.finishBroadcast();
            AppMethodBeat.m2505o(19693);
            return false;
        }
        try {
            c38959k.mo7187a(j, i, i2, i3, j2);
            this.lxg.finishBroadcast();
            AppMethodBeat.m2505o(19693);
            return true;
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            this.lxg.finishBroadcast();
            AppMethodBeat.m2505o(19693);
            return false;
        } catch (Throwable th) {
            this.lxg.finishBroadcast();
            AppMethodBeat.m2505o(19693);
        }
    }

    /* renamed from: e */
    public final boolean mo61848e(long j, int i, int i2, String str) {
        AppMethodBeat.m2504i(19694);
        C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        C43005t c43005t = (C43005t) C38963y.m66139a(j, this.lxi, this.lxi.beginBroadcast());
        if (c43005t == null) {
            C4990ab.m7420w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(j)));
            this.lxi.finishBroadcast();
            AppMethodBeat.m2505o(19694);
            return false;
        }
        try {
            c43005t.mo35810b(j, i, i2, str);
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lxi.finishBroadcast();
            AppMethodBeat.m2505o(19694);
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public final boolean mo61847d(long j, byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(19695);
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "simpleBTOnRecvImpl. mac=%d, data = %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = bArr == null ? BuildConfig.COMMAND : C42992b.m76349aN(bArr);
        C4990ab.m7411d(str, str2, objArr);
        C4990ab.m7411d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "SimpleOnRecvList size = %d", Integer.valueOf(this.lxh.beginBroadcast()));
        while (i < r2) {
            try {
                C43003s c43003s = (C43003s) this.lxh.getBroadcastItem(i);
                if (c43003s != null) {
                    c43003s.mo54587c(j, bArr);
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ISimpleBTOnRecv_AIDL callback is null");
                }
                i++;
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onDataRecv Failed!!!");
                C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                this.lxh.finishBroadcast();
            } catch (Throwable th) {
                this.lxh.finishBroadcast();
                AppMethodBeat.m2505o(19695);
            }
        }
        this.lxh.finishBroadcast();
        AppMethodBeat.m2505o(19695);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m66142a(C38963y c38963y, int i, long j, short s, short s2, byte[] bArr) {
        AppMethodBeat.m2504i(19702);
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequestImp errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        int beginBroadcast = c38963y.lwY.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                C38958i c38958i = (C38958i) c38963y.lwY.getBroadcastItem(i2);
                if (c38958i != null) {
                    c38958i.mo35821a(i, j, s, s2, bArr);
                } else {
                    C4990ab.m7413e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "get req callback failed, cmdId = %d", Short.valueOf(s2));
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest Failed!!! i = ".concat(String.valueOf(i2)));
                C4990ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        c38963y.lwY.finishBroadcast();
        AppMethodBeat.m2505o(19702);
    }
}
