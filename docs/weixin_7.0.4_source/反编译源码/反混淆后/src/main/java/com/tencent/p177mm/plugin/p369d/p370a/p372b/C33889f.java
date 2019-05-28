package com.tencent.p177mm.plugin.p369d.p370a.p372b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C20287a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C38826c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.b.f */
public final class C33889f {
    static int jGz = 0;
    private int aBR;
    public BluetoothDevice hGa;
    private BluetoothAdapter jEU;
    private Context jFS;
    private BluetoothGatt jFT;
    private C20288a jFX;
    private Runnable jFY;
    private Runnable jGa;
    private final LinkedList<byte[]> jGc;
    private volatile boolean jGd;
    private volatile int jGe;
    private final BluetoothGattCallback jGf;
    private C11472a jGs;
    private Runnable jGt;
    private C33889f jGu;
    private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> jGv;
    private long jGw;
    private ArrayList<BluetoothGattCharacteristic> jGx;
    private boolean jGy;
    public C7306ak mHandler;
    public long mSessionId;
    private HandlerThread mThread;

    /* renamed from: com.tencent.mm.plugin.d.a.b.f$a */
    public static abstract class C11472a {
        /* renamed from: a */
        public void mo23199a(long j, boolean z, long j2) {
        }

        /* renamed from: b */
        public void mo23200b(long j, byte[] bArr) {
        }

        /* renamed from: m */
        public void mo23201m(long j, boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.f$b */
    static class C11473b extends C7306ak {
        private final WeakReference<C33889f> jGh;

        public C11473b(Looper looper, C33889f c33889f) {
            super(looper);
            AppMethodBeat.m2504i(18424);
            this.jGh = new WeakReference(c33889f);
            AppMethodBeat.m2505o(18424);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(18425);
            C33889f c33889f = (C33889f) this.jGh.get();
            if (c33889f == null) {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
                AppMethodBeat.m2505o(18425);
                return;
            }
            switch (message.what) {
                case 0:
                    C33889f.m55444a(c33889f);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 1:
                    C33889f.m55449b(c33889f);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 2:
                    C33889f.m55451c(c33889f);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 3:
                    C33889f.m55447a(c33889f, (byte[]) message.obj);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 4:
                    C33889f.m55445a(c33889f, message.arg1);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 5:
                    if (!C33889f.m55448a(c33889f, (BluetoothGatt) message.obj, message.arg1)) {
                        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
                        if (!c33889f.mHandler.sendMessage(c33889f.mHandler.obtainMessage(1))) {
                            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(1));
                        }
                        AppMethodBeat.m2505o(18425);
                        return;
                    }
                    break;
                case 6:
                    Object obj = message.obj;
                    C33889f.m55450b(c33889f, message.arg1);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 7:
                    C33889f.m55452c(c33889f, message.arg1);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 8:
                    C33889f.m55446a(c33889f, (BluetoothGattCharacteristic) message.obj);
                    AppMethodBeat.m2505o(18425);
                    return;
                case 9:
                    C33889f.m55453d(c33889f);
                    break;
            }
            AppMethodBeat.m2505o(18425);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.f$1 */
    class C338861 extends BluetoothGattCallback {
        C338861() {
        }

        public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            AppMethodBeat.m2504i(18415);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(C33889f.this.jGe));
            if (!C33889f.this.mHandler.sendMessage(C33889f.this.mHandler.obtainMessage(4, i2, 0))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(4));
            }
            AppMethodBeat.m2505o(18415);
        }

        public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            AppMethodBeat.m2504i(18416);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i));
            if (!C33889f.this.mHandler.sendMessage(C33889f.this.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(5));
            }
            AppMethodBeat.m2505o(18416);
        }

        public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            AppMethodBeat.m2504i(18417);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i));
            if (!C33889f.this.mHandler.sendMessage(C33889f.this.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(6));
            }
            AppMethodBeat.m2505o(18417);
        }

        public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            AppMethodBeat.m2504i(18418);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
            if (!C33889f.this.mHandler.sendMessage(C33889f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
            }
            AppMethodBeat.m2505o(18418);
        }

        public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            AppMethodBeat.m2504i(18419);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i));
            if (i == 0 && !C33889f.this.mHandler.sendMessage(C33889f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
            }
            AppMethodBeat.m2505o(18419);
        }

        public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            AppMethodBeat.m2504i(18420);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i));
            if (!C33889f.this.mHandler.sendMessage(C33889f.this.mHandler.obtainMessage(7, i, 0))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(7));
            }
            AppMethodBeat.m2505o(18420);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.f$2 */
    class C338872 implements Runnable {
        C338872() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18421);
            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", C42992b.m76358ie(C33889f.this.mSessionId), C33889f.this.hGa.getName());
            if (C33889f.this.jGs != null) {
                C33889f.this.jGs.mo23201m(C33889f.this.mSessionId, false);
            }
            C33889f.m55459j(C33889f.this);
            AppMethodBeat.m2505o(18421);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.f$4 */
    class C338884 implements Runnable {
        C338884() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18423);
            if (C33889f.this.jGy) {
                if (C33889f.this.jGs != null) {
                    C33889f.this.jGs.mo23199a(C33889f.this.mSessionId, false, C33889f.this.jGw);
                }
                C4990ab.m7410d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
                C33889f.m55462m(C33889f.this);
            }
            AppMethodBeat.m2505o(18423);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.f$3 */
    class C338903 implements Runnable {
        C338903() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18422);
            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", C42992b.m76358ie(C33889f.this.mSessionId), C33889f.this.hGa.getName());
            if (3 == C33889f.this.jGe) {
                C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
                AppMethodBeat.m2505o(18422);
            } else if (C33889f.this.jGe == 1) {
                C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
                AppMethodBeat.m2505o(18422);
            } else {
                C33889f.this.aVB();
                AppMethodBeat.m2505o(18422);
            }
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m55459j(C33889f c33889f) {
        AppMethodBeat.m2504i(18443);
        c33889f.aVA();
        AppMethodBeat.m2505o(18443);
    }

    /* renamed from: m */
    static /* synthetic */ void m55462m(C33889f c33889f) {
        AppMethodBeat.m2504i(18444);
        c33889f.releaseResources();
        AppMethodBeat.m2505o(18444);
    }

    /* Access modifiers changed, original: final */
    public final void aVB() {
        AppMethodBeat.m2504i(18426);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", C42992b.m76358ie(this.mSessionId), this.hGa.getName());
        this.jGe = 2;
        this.mHandler.removeCallbacks(this.jGa);
        this.mHandler.removeCallbacks(this.jGt);
        aVC();
        releaseResources();
        AppMethodBeat.m2505o(18426);
    }

    @TargetApi(18)
    public C33889f(long j, Context context, C11472a c11472a) {
        AppMethodBeat.m2504i(18427);
        this.jGc = new LinkedList();
        this.jGd = false;
        this.jGv = new HashMap();
        this.jGw = 0;
        this.jGx = new ArrayList();
        this.jGf = new C338861();
        this.aBR = -1;
        this.aBR = hashCode();
        this.jGu = this;
        this.jGs = c11472a;
        this.jFS = context;
        this.jEU = ((BluetoothManager) this.jFS.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.jGe = 3;
        this.hGa = this.jEU.getRemoteDevice(C42904a.m76179gC(j));
        this.jFX = new C20288a();
        this.jGy = false;
        this.mThread = C7305d.anM("BluetoothLESimpleSession_handlerThread");
        this.mThread.start();
        this.mHandler = new C11473b(this.mThread.getLooper(), this);
        this.jFY = new C338872();
        this.jGa = new C338903();
        this.jGt = new C338884();
        AppMethodBeat.m2505o(18427);
    }

    private void releaseResources() {
        AppMethodBeat.m2504i(18428);
        if (this.jFT == null) {
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), C42992b.m76358ie(this.mSessionId), this.hGa.getName());
            AppMethodBeat.m2505o(18428);
            return;
        }
        jGz--;
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), Integer.valueOf(jGz), C42992b.m76358ie(this.mSessionId), this.hGa.getName());
        this.jGy = false;
        this.jFT.close();
        this.mThread.quitSafely();
        this.jFT = null;
        this.mThread = null;
        AppMethodBeat.m2505o(18428);
    }

    public final boolean connect() {
        AppMethodBeat.m2504i(18429);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", C42992b.m76358ie(this.mSessionId), this.hGa.getName());
        boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
        AppMethodBeat.m2505o(18429);
        return sendMessage;
    }

    private void aVz() {
        AppMethodBeat.m2504i(18430);
        this.jGd = false;
        this.jGc.clear();
        AppMethodBeat.m2505o(18430);
    }

    private void aVC() {
        AppMethodBeat.m2504i(18431);
        if (this.jGs == null) {
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", C42992b.m76358ie(this.mSessionId), this.hGa.getName());
            AppMethodBeat.m2505o(18431);
            return;
        }
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", C42992b.m76358ie(this.mSessionId), this.hGa.getName());
        if (this.jGs != null) {
            this.jGs.mo23199a(this.mSessionId, false, this.jGw);
        }
        this.jGs = null;
        AppMethodBeat.m2505o(18431);
    }

    private void aVA() {
        AppMethodBeat.m2504i(18432);
        if (this.jGc.isEmpty()) {
            this.jGd = false;
            AppMethodBeat.m2505o(18432);
            return;
        }
        C20287a at = C20287a.m31370at((byte[]) this.jGc.pop());
        byte[] aVE = at.aVE();
        String str = at.jHc;
        int i = at.jHd;
        HashMap hashMap = (HashMap) this.jGv.get(C38826c.m65878gA(at.jGw));
        if (hashMap == null) {
            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", r4, C42992b.m76358ie(this.mSessionId), this.hGa.getName());
            if (this.jGs != null) {
                this.jGs.mo23201m(this.mSessionId, false);
            }
            AppMethodBeat.m2505o(18432);
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        if (bluetoothGattCharacteristic == null) {
            String str2;
            String str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            String str4 = "characteristic(%s) not found, mac=%s, name=%s";
            Object[] objArr = new Object[3];
            if (str == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = str;
            }
            objArr[0] = str2;
            objArr[1] = C42992b.m76358ie(this.mSessionId);
            objArr[2] = this.hGa.getName();
            C4990ab.m7413e(str3, str4, objArr);
            if (this.jGs != null) {
                this.jGs.mo23201m(this.mSessionId, false);
            }
            AppMethodBeat.m2505o(18432);
        } else if (i == 8) {
            this.jFX.jFy = bluetoothGattCharacteristic;
            this.jFX.setData(aVE);
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", C42992b.m76349aN(this.jFX.aVu()), str, C42992b.m76358ie(this.mSessionId), this.hGa.getName());
            bluetoothGattCharacteristic.setValue(aVE);
            this.mHandler.postDelayed(this.jFY, 5000);
            if (this.jFT.writeCharacteristic(bluetoothGattCharacteristic)) {
                this.jGd = true;
                AppMethodBeat.m2505o(18432);
                return;
            }
            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", C42992b.m76358ie(this.mSessionId), this.hGa.getName());
            if (this.jGs != null) {
                this.jGs.mo23201m(this.mSessionId, false);
            }
            AppMethodBeat.m2505o(18432);
        } else {
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", Integer.valueOf(i), C42992b.m76358ie(this.mSessionId), this.hGa.getName());
            if (this.jGs != null) {
                this.jGs.mo23201m(this.mSessionId, false);
            }
            AppMethodBeat.m2505o(18432);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m55444a(C33889f c33889f) {
        AppMethodBeat.m2504i(18433);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
        if (1 == c33889f.jGe) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
            if (c33889f.jGs != null) {
                C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                c33889f.jGs.mo23199a(c33889f.mSessionId, true, c33889f.jGw);
            }
            AppMethodBeat.m2505o(18433);
        } else if (c33889f.jGe == 0) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
            AppMethodBeat.m2505o(18433);
        } else {
            c33889f.aVz();
            if (c33889f.jFT == null) {
                c33889f.jFT = c33889f.hGa.connectGatt(c33889f.jFS, false, c33889f.jGf);
                jGz++;
                C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(c33889f.hashCode()), Integer.valueOf(jGz), C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
                if (c33889f.jFT == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                    c33889f.aVC();
                    AppMethodBeat.m2505o(18433);
                    return;
                }
                c33889f.jGe = 0;
                c33889f.mHandler.postDelayed(c33889f.jGa, 10000);
                AppMethodBeat.m2505o(18433);
            } else if (c33889f.jFT.connect()) {
                c33889f.jGe = 0;
                c33889f.mHandler.postDelayed(c33889f.jGa, 10000);
                AppMethodBeat.m2505o(18433);
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                c33889f.aVC();
                AppMethodBeat.m2505o(18433);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m55448a(C33889f c33889f, BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(18435);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", Integer.valueOf(i), C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
        c33889f.mHandler.removeCallbacks(c33889f.jGa);
        if (3 == c33889f.jGe) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
            AppMethodBeat.m2505o(18435);
            return false;
        }
        if (1 == c33889f.jGe) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
        } else if (i != 0) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
            c33889f.aVB();
            AppMethodBeat.m2505o(18435);
            return false;
        } else {
            List services = bluetoothGatt.getServices();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= services.size()) {
                    break;
                }
                Object obj;
                BluetoothGattService bluetoothGattService = (BluetoothGattService) services.get(i3);
                if (bluetoothGattService == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                    obj = null;
                } else if (C38826c.m65877b(bluetoothGattService)) {
                    c33889f.jGw |= C38826c.m65874a(bluetoothGattService);
                    HashMap hashMap = new HashMap();
                    List characteristics = bluetoothGattService.getCharacteristics();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= characteristics.size()) {
                            break;
                        }
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristics.get(i5);
                        Object uuid = bluetoothGattCharacteristic.getUuid().toString();
                        int properties = bluetoothGattCharacteristic.getProperties();
                        int permissions = bluetoothGattCharacteristic.getPermissions();
                        C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", uuid, Integer.valueOf(properties), Integer.valueOf(permissions));
                        if (uuid == null) {
                            uuid = BuildConfig.COMMAND;
                        }
                        hashMap.put(uuid, bluetoothGattCharacteristic);
                        c33889f.jGx.add(bluetoothGattCharacteristic);
                        i4 = i5 + 1;
                    }
                    c33889f.jGv.put(bluetoothGattService.getUuid().toString(), hashMap);
                    obj = 1;
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                    obj = null;
                }
                if (obj == null) {
                    C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", bluetoothGattService.getUuid().toString());
                }
                i2 = i3 + 1;
            }
            if (0 == c33889f.jGw) {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                c33889f.aVB();
                AppMethodBeat.m2505o(18435);
                return false;
            } else if (!c33889f.mHandler.sendMessage(c33889f.mHandler.obtainMessage(9))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(9));
            }
        }
        AppMethodBeat.m2505o(18435);
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ void m55450b(C33889f c33889f, int i) {
        AppMethodBeat.m2504i(18436);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i), C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
        if (!c33889f.mHandler.sendMessage(c33889f.mHandler.obtainMessage(9))) {
            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(9));
        }
        AppMethodBeat.m2505o(18436);
    }

    /* renamed from: b */
    static /* synthetic */ void m55449b(C33889f c33889f) {
        AppMethodBeat.m2504i(18437);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
        if (3 == c33889f.jGe) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
            AppMethodBeat.m2505o(18437);
        } else if (2 == c33889f.jGe) {
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
            AppMethodBeat.m2505o(18437);
        } else {
            c33889f.aVz();
            if (c33889f.jFT == null) {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                AppMethodBeat.m2505o(18437);
                return;
            }
            c33889f.jGe = 3;
            c33889f.mHandler.removeCallbacks(c33889f.jGa);
            if (c33889f.jFT != null) {
                c33889f.jFT.disconnect();
            }
            AppMethodBeat.m2505o(18437);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m55452c(C33889f c33889f, int i) {
        AppMethodBeat.m2504i(18439);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i), C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
        c33889f.mHandler.removeCallbacks(c33889f.jFY);
        if (i != 0) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: ".concat(String.valueOf(i)));
            if (c33889f.jGs != null) {
                c33889f.jGs.mo23201m(c33889f.mSessionId, false);
            }
            c33889f.aVA();
            AppMethodBeat.m2505o(18439);
            return;
        }
        byte[] aVu = c33889f.jFX.aVu();
        C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", C42992b.m76349aN(aVu));
        if (aVu == null) {
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (c33889f.jGs != null) {
                c33889f.jGs.mo23201m(c33889f.mSessionId, true);
            }
            c33889f.aVA();
            AppMethodBeat.m2505o(18439);
            return;
        }
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        c33889f.jFX.jFy.setValue(aVu);
        c33889f.jFT.writeCharacteristic(c33889f.jFX.jFy);
        c33889f.mHandler.postDelayed(c33889f.jFY, 5000);
        AppMethodBeat.m2505o(18439);
    }

    /* renamed from: c */
    static /* synthetic */ void m55451c(C33889f c33889f) {
        AppMethodBeat.m2504i(18441);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
        if (3 == c33889f.jGe) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            c33889f.aVC();
            AppMethodBeat.m2505o(18441);
            return;
        }
        c33889f.aVz();
        if (c33889f.jFT == null) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            c33889f.aVC();
            AppMethodBeat.m2505o(18441);
            return;
        }
        c33889f.jGe = 3;
        c33889f.mHandler.removeCallbacks(c33889f.jGa);
        c33889f.aVC();
        if (c33889f.jFT != null) {
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
            c33889f.jFT.disconnect();
            c33889f.jGy = true;
            c33889f.mHandler.postDelayed(c33889f.jGt, 10000);
        }
        AppMethodBeat.m2505o(18441);
    }

    /* renamed from: d */
    static /* synthetic */ void m55453d(C33889f c33889f) {
        AppMethodBeat.m2504i(18442);
        while (c33889f.jGx.size() > 0) {
            int i;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) c33889f.jGx.remove(0);
            C33889f c33889f2 = c33889f.jGu;
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 48) == 0) {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                i = 0;
            } else if (c33889f2.jFT.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(C38832h.jGG));
                if (descriptor == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                    i = 0;
                } else {
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
                    byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                    if ((properties & 32) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]);
                    }
                    if ((properties & 16) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[1]);
                    }
                    if (!descriptor.setValue(bArr)) {
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                        i = 0;
                    } else if (c33889f2.jFT.writeDescriptor(descriptor)) {
                        i = 1;
                    } else {
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                        i = 0;
                    }
                }
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                i = 0;
            }
            if (i != 0) {
                break;
            }
            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties()));
        }
        C4990ab.m7410d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
        c33889f.jGe = 1;
        c33889f.mHandler.removeCallbacks(c33889f.jGa);
        if (c33889f.jGs != null) {
            c33889f.jGs.mo23199a(c33889f.mSessionId, true, c33889f.jGw);
        }
        AppMethodBeat.m2505o(18442);
    }
}
