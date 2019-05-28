package com.tencent.p177mm.plugin.p369d.p370a.p375d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.exdevice.service.C20549v;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C2852b;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C2852b.C2853b;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C2852b.C2854a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C2861c;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C33891g;
import com.tencent.p177mm.plugin.p369d.p370a.p374c.C20291a;
import com.tencent.p177mm.plugin.p369d.p370a.p374c.C20291a.C2873a;
import com.tencent.p177mm.plugin.p369d.p370a.p374c.C20291a.C2874b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.d.a.d.b */
public final class C45825b {
    public C2852b jIV = null;
    public C20291a jIW = null;
    C38840c jIX = null;
    final HashSet<String> jIY = new HashSet();
    private C7306ak mHandler = null;

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$b */
    class C2876b extends C2854a {
        C2876b() {
        }

        /* renamed from: g */
        public final void mo6978g(long j, long j2, long j3) {
            AppMethodBeat.m2504i(18505);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 6, 0, new C33897d(j, j2, j3)));
            AppMethodBeat.m2505o(18505);
        }

        public final void aVx() {
            AppMethodBeat.m2504i(18506);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
            C45825b.this.jIY.clear();
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 2, 0, null));
            AppMethodBeat.m2505o(18506);
        }

        /* renamed from: a */
        public final void mo6975a(String str, String str2, int i, byte[] bArr) {
            AppMethodBeat.m2504i(18507);
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", str, str2);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 3, 0, new C33899i(str, str2, i, bArr)));
            AppMethodBeat.m2505o(18507);
        }

        /* renamed from: l */
        public final void mo6979l(long j, boolean z) {
            AppMethodBeat.m2504i(18508);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 4, 0, new C6831f(j, z)));
            AppMethodBeat.m2505o(18508);
        }

        /* renamed from: b */
        public final void mo6977b(long j, byte[] bArr) {
            AppMethodBeat.m2504i(18509);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(j)));
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 1, 0, new C38838h(j, bArr)));
            AppMethodBeat.m2505o(18509);
        }

        /* renamed from: m */
        public final void mo6980m(long j, boolean z) {
            AppMethodBeat.m2504i(18510);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 0, 0, new C38839j(j, z)));
            AppMethodBeat.m2505o(18510);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$e */
    static class C2877e {
        long jJb;
        boolean jJc;

        public C2877e(long j, boolean z) {
            this.jJb = j;
            this.jJc = z;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$f */
    static final class C6831f extends C2877e {
        public C6831f(long j, boolean z) {
            super(j, z);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$c */
    static class C7501c extends C7306ak {
        private WeakReference<C45825b> jGh = null;

        public C7501c(Looper looper, C45825b c45825b) {
            super(looper);
            AppMethodBeat.m2504i(18511);
            this.jGh = new WeakReference(c45825b);
            AppMethodBeat.m2505o(18511);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(18512);
            C45825b c45825b = (C45825b) this.jGh.get();
            if (c45825b == null) {
                C4990ab.m7420w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
                AppMethodBeat.m2505o(18512);
                return;
            }
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
            switch (message.what) {
                case 0:
                    C38839j c38839j = (C38839j) message.obj;
                    c45825b.jIX.mo54575m(c38839j.jJb, c38839j.jJc);
                    AppMethodBeat.m2505o(18512);
                    return;
                case 1:
                    C38838h c38838h = (C38838h) message.obj;
                    c45825b.jIX.mo54571b(c38838h.mSessionId, c38838h.mData);
                    AppMethodBeat.m2505o(18512);
                    return;
                case 2:
                    c45825b.jIX.mo54576rQ(message.arg1);
                    AppMethodBeat.m2505o(18512);
                    return;
                case 3:
                    C33899i c33899i = (C33899i) message.obj;
                    c45825b.jIX.mo54570a(c33899i.jJe, c33899i.mDeviceName, message.arg1, c33899i.hGc, c33899i.jJf);
                    AppMethodBeat.m2505o(18512);
                    return;
                case 4:
                    C6831f c6831f = (C6831f) message.obj;
                    c45825b.jIX.mo54574l(c6831f.jJb, c6831f.jJc);
                    AppMethodBeat.m2505o(18512);
                    return;
                case 5:
                    c45825b.jIX.mo54573gB(((C33898g) message.obj).mSessionId);
                    AppMethodBeat.m2505o(18512);
                    return;
                case 6:
                    C33897d c33897d = (C33897d) message.obj;
                    c45825b.jIX.mo54572g(c33897d.mSessionId, c33897d.jJa, c33897d.jFM);
                    break;
            }
            AppMethodBeat.m2505o(18512);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$a */
    class C33896a extends C2873a {
        C33896a() {
        }

        /* renamed from: g */
        public final void mo7009g(long j, long j2, long j3) {
            AppMethodBeat.m2504i(18498);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 6, 1, new C33897d(j, j2, j3)));
            AppMethodBeat.m2505o(18498);
        }

        public final void aVx() {
            AppMethodBeat.m2504i(18499);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
            C45825b.this.jIY.clear();
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 2, 1, null));
            AppMethodBeat.m2505o(18499);
        }

        /* renamed from: dd */
        public final void mo7008dd(String str, String str2) {
            int i;
            AppMethodBeat.m2504i(18500);
            C45825b c45825b = C45825b.this;
            if (str == null) {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
                i = 0;
            } else if (c45825b.jIY.contains(str)) {
                i = 0;
            } else {
                c45825b.jIY.add(str);
                i = 1;
            }
            if (i == 0) {
                AppMethodBeat.m2505o(18500);
                return;
            }
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 3, 1, new C33899i(str, str2, 0, null)));
            AppMethodBeat.m2505o(18500);
        }

        /* renamed from: l */
        public final void mo7010l(long j, boolean z) {
            AppMethodBeat.m2504i(18501);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 4, 1, new C6831f(j, z)));
            AppMethodBeat.m2505o(18501);
        }

        /* renamed from: b */
        public final void mo7006b(long j, byte[] bArr) {
            AppMethodBeat.m2504i(18502);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(j)));
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 1, 1, new C38838h(j, bArr)));
            AppMethodBeat.m2505o(18502);
        }

        /* renamed from: m */
        public final void mo7011m(long j, boolean z) {
            AppMethodBeat.m2504i(18503);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 0, 1, new C38839j(j, z)));
            AppMethodBeat.m2505o(18503);
        }

        /* renamed from: c */
        public final void mo7007c(long j, int i, String str) {
            AppMethodBeat.m2504i(18504);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j + " errorCode = " + i + " errorInfo = " + str);
            Assert.assertTrue(C45825b.m84813a(C45825b.this, 5, 1, new C33898g(j, i, str)));
            AppMethodBeat.m2505o(18504);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$d */
    static final class C33897d {
        long jFM;
        long jJa;
        long mSessionId;

        public C33897d(long j, long j2, long j3) {
            this.mSessionId = j;
            this.jJa = j2;
            this.jFM = j3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$g */
    static final class C33898g {
        private String jJd;
        private int mErrorCode;
        long mSessionId;

        public C33898g(long j, int i, String str) {
            this.mSessionId = j;
            this.mErrorCode = i;
            this.jJd = str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$i */
    static final class C33899i {
        int hGc;
        String jJe;
        byte[] jJf;
        String mDeviceName;

        public C33899i(String str, String str2, int i, byte[] bArr) {
            this.jJe = str;
            this.mDeviceName = str2;
            this.hGc = i;
            this.jJf = bArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$h */
    static final class C38838h {
        byte[] mData;
        long mSessionId;

        public C38838h(long j, byte[] bArr) {
            this.mSessionId = j;
            this.mData = bArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$j */
    static final class C38839j extends C2877e {
        public C38839j(long j, boolean z) {
            super(j, z);
        }
    }

    public C45825b(Context context, C38840c c38840c, C5004al c5004al) {
        AppMethodBeat.m2504i(18513);
        this.jIW = new C20291a(c5004al);
        if (VERSION.SDK_INT >= 18) {
            this.jIV = new C2852b(c5004al);
            C2852b c2852b = this.jIV;
            C2876b c2876b = new C2876b();
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(c2876b);
            if (!c2852b.mIsInit) {
                c2852b.mIsInit = true;
                c2852b.f1263Gn = context;
                c2852b.jFz = c2876b;
                c2852b.jFC = C2861c.aVy();
                if (C1443d.m3068iW(21)) {
                    c2852b.jFD = C33891g.aVD();
                }
                if (c2852b.aVw()) {
                    c2852b.jEU = ((BluetoothManager) c2852b.f1263Gn.getSystemService("bluetooth")).getAdapter();
                } else {
                    C4990ab.m7420w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                }
            }
        }
        C20291a c20291a = this.jIW;
        C33896a c33896a = new C33896a();
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(c33896a);
        if (!c20291a.mIsInit) {
            c20291a.mIsInit = true;
            c20291a.jIy = c33896a;
            c20291a.jIz = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            c20291a.jIz.registerReceiver(c20291a.jIA, intentFilter);
            c20291a.jEU = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new C7501c(C20549v.bpz().fPG.oAl.getLooper(), this);
        this.jIX = c38840c;
        AppMethodBeat.m2505o(18513);
    }

    /* renamed from: d */
    public final boolean mo73627d(int i, int... iArr) {
        AppMethodBeat.m2504i(18514);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(i)));
        boolean a;
        switch (i) {
            case 0:
                if (this.jIV == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    AppMethodBeat.m2505o(18514);
                    return false;
                } else if (iArr == null) {
                    a = this.jIV.mo6969a(true, new int[0]);
                    AppMethodBeat.m2505o(18514);
                    return a;
                } else {
                    a = this.jIV.mo6969a(true, iArr);
                    AppMethodBeat.m2505o(18514);
                    return a;
                }
            case 1:
                if (this.jIW == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    AppMethodBeat.m2505o(18514);
                    return false;
                }
                a = this.jIW.mo35532fw(true);
                AppMethodBeat.m2505o(18514);
                return a;
            default:
                Assert.assertTrue(false);
                AppMethodBeat.m2505o(18514);
                return false;
        }
    }

    /* renamed from: c */
    public final void mo73626c(long j, long j2, int i) {
        AppMethodBeat.m2504i(18515);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j + "aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.jIV == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    AppMethodBeat.m2505o(18515);
                    return;
                }
                C2852b c2852b = this.jIV;
                C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", Long.valueOf(j), Long.valueOf(j2));
                Assert.assertTrue(c2852b.mIsInit);
                if (c2852b.aVw()) {
                    Assert.assertTrue(c2852b.mHandler.post(new C2853b(j, j2)));
                    AppMethodBeat.m2505o(18515);
                    return;
                }
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                AppMethodBeat.m2505o(18515);
                return;
            case 1:
                if (this.jIW == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    AppMethodBeat.m2505o(18515);
                    return;
                }
                C20291a c20291a = this.jIW;
                C4990ab.m7416i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(c20291a.mIsInit);
                if (c20291a.aVF()) {
                    Assert.assertTrue(c20291a.mHandler.post(new C2874b(j, j2)));
                    AppMethodBeat.m2505o(18515);
                    return;
                }
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                AppMethodBeat.m2505o(18515);
                return;
            default:
                Assert.assertTrue(false);
                AppMethodBeat.m2505o(18515);
                return;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m84813a(C45825b c45825b, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(18516);
        boolean sendMessage = c45825b.mHandler.sendMessage(c45825b.mHandler.obtainMessage(i, i2, 0, obj));
        AppMethodBeat.m2505o(18516);
        return sendMessage;
    }
}
