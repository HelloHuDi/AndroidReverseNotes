package com.tencent.mm.plugin.d.a.b;

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
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.d.a.b.a.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public final class f {
    static int jGz = 0;
    private int aBR;
    public BluetoothDevice hGa;
    private BluetoothAdapter jEU;
    private Context jFS;
    private BluetoothGatt jFT;
    private a jFX;
    private Runnable jFY;
    private Runnable jGa;
    private final LinkedList<byte[]> jGc;
    private volatile boolean jGd;
    private volatile int jGe;
    private final BluetoothGattCallback jGf;
    private a jGs;
    private Runnable jGt;
    private f jGu;
    private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> jGv;
    private long jGw;
    private ArrayList<BluetoothGattCharacteristic> jGx;
    private boolean jGy;
    public ak mHandler;
    public long mSessionId;
    private HandlerThread mThread;

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void m(long j, boolean z) {
        }
    }

    static class b extends ak {
        private final WeakReference<f> jGh;

        public b(Looper looper, f fVar) {
            super(looper);
            AppMethodBeat.i(18424);
            this.jGh = new WeakReference(fVar);
            AppMethodBeat.o(18424);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(18425);
            f fVar = (f) this.jGh.get();
            if (fVar == null) {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
                AppMethodBeat.o(18425);
                return;
            }
            switch (message.what) {
                case 0:
                    f.a(fVar);
                    AppMethodBeat.o(18425);
                    return;
                case 1:
                    f.b(fVar);
                    AppMethodBeat.o(18425);
                    return;
                case 2:
                    f.c(fVar);
                    AppMethodBeat.o(18425);
                    return;
                case 3:
                    f.a(fVar, (byte[]) message.obj);
                    AppMethodBeat.o(18425);
                    return;
                case 4:
                    f.a(fVar, message.arg1);
                    AppMethodBeat.o(18425);
                    return;
                case 5:
                    if (!f.a(fVar, (BluetoothGatt) message.obj, message.arg1)) {
                        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
                        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(1))) {
                            ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(1));
                        }
                        AppMethodBeat.o(18425);
                        return;
                    }
                    break;
                case 6:
                    Object obj = message.obj;
                    f.b(fVar, message.arg1);
                    AppMethodBeat.o(18425);
                    return;
                case 7:
                    f.c(fVar, message.arg1);
                    AppMethodBeat.o(18425);
                    return;
                case 8:
                    f.a(fVar, (BluetoothGattCharacteristic) message.obj);
                    AppMethodBeat.o(18425);
                    return;
                case 9:
                    f.d(fVar);
                    break;
            }
            AppMethodBeat.o(18425);
        }
    }

    static /* synthetic */ void j(f fVar) {
        AppMethodBeat.i(18443);
        fVar.aVA();
        AppMethodBeat.o(18443);
    }

    static /* synthetic */ void m(f fVar) {
        AppMethodBeat.i(18444);
        fVar.releaseResources();
        AppMethodBeat.o(18444);
    }

    /* Access modifiers changed, original: final */
    public final void aVB() {
        AppMethodBeat.i(18426);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
        this.jGe = 2;
        this.mHandler.removeCallbacks(this.jGa);
        this.mHandler.removeCallbacks(this.jGt);
        aVC();
        releaseResources();
        AppMethodBeat.o(18426);
    }

    @TargetApi(18)
    public f(long j, Context context, a aVar) {
        AppMethodBeat.i(18427);
        this.jGc = new LinkedList();
        this.jGd = false;
        this.jGv = new HashMap();
        this.jGw = 0;
        this.jGx = new ArrayList();
        this.jGf = new BluetoothGattCallback() {
            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                AppMethodBeat.i(18415);
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(f.this.jGe));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(4, i2, 0))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(4));
                }
                AppMethodBeat.o(18415);
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                AppMethodBeat.i(18416);
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(5));
                }
                AppMethodBeat.o(18416);
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                AppMethodBeat.i(18417);
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(6));
                }
                AppMethodBeat.o(18417);
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                AppMethodBeat.i(18418);
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
                }
                AppMethodBeat.o(18418);
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                AppMethodBeat.i(18419);
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i));
                if (i == 0 && !f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
                }
                AppMethodBeat.o(18419);
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                AppMethodBeat.i(18420);
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(7, i, 0))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(7));
                }
                AppMethodBeat.o(18420);
            }
        };
        this.aBR = -1;
        this.aBR = hashCode();
        this.jGu = this;
        this.jGs = aVar;
        this.jFS = context;
        this.jEU = ((BluetoothManager) this.jFS.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.jGe = 3;
        this.hGa = this.jEU.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.gC(j));
        this.jFX = new a();
        this.jGy = false;
        this.mThread = d.anM("BluetoothLESimpleSession_handlerThread");
        this.mThread.start();
        this.mHandler = new b(this.mThread.getLooper(), this);
        this.jFY = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18421);
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(f.this.mSessionId), f.this.hGa.getName());
                if (f.this.jGs != null) {
                    f.this.jGs.m(f.this.mSessionId, false);
                }
                f.j(f.this);
                AppMethodBeat.o(18421);
            }
        };
        this.jGa = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18422);
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(f.this.mSessionId), f.this.hGa.getName());
                if (3 == f.this.jGe) {
                    ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
                    AppMethodBeat.o(18422);
                } else if (f.this.jGe == 1) {
                    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
                    AppMethodBeat.o(18422);
                } else {
                    f.this.aVB();
                    AppMethodBeat.o(18422);
                }
            }
        };
        this.jGt = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18423);
                if (f.this.jGy) {
                    if (f.this.jGs != null) {
                        f.this.jGs.a(f.this.mSessionId, false, f.this.jGw);
                    }
                    ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
                    f.m(f.this);
                }
                AppMethodBeat.o(18423);
            }
        };
        AppMethodBeat.o(18427);
    }

    private void releaseResources() {
        AppMethodBeat.i(18428);
        if (this.jFT == null) {
            ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
            AppMethodBeat.o(18428);
            return;
        }
        jGz--;
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), Integer.valueOf(jGz), com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
        this.jGy = false;
        this.jFT.close();
        this.mThread.quitSafely();
        this.jFT = null;
        this.mThread = null;
        AppMethodBeat.o(18428);
    }

    public final boolean connect() {
        AppMethodBeat.i(18429);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
        boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
        AppMethodBeat.o(18429);
        return sendMessage;
    }

    private void aVz() {
        AppMethodBeat.i(18430);
        this.jGd = false;
        this.jGc.clear();
        AppMethodBeat.o(18430);
    }

    private void aVC() {
        AppMethodBeat.i(18431);
        if (this.jGs == null) {
            ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
            AppMethodBeat.o(18431);
            return;
        }
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
        if (this.jGs != null) {
            this.jGs.a(this.mSessionId, false, this.jGw);
        }
        this.jGs = null;
        AppMethodBeat.o(18431);
    }

    private void aVA() {
        AppMethodBeat.i(18432);
        if (this.jGc.isEmpty()) {
            this.jGd = false;
            AppMethodBeat.o(18432);
            return;
        }
        com.tencent.mm.plugin.d.a.b.a.a at = com.tencent.mm.plugin.d.a.b.a.a.at((byte[]) this.jGc.pop());
        byte[] aVE = at.aVE();
        String str = at.jHc;
        int i = at.jHd;
        HashMap hashMap = (HashMap) this.jGv.get(c.gA(at.jGw));
        if (hashMap == null) {
            ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", r4, com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
            if (this.jGs != null) {
                this.jGs.m(this.mSessionId, false);
            }
            AppMethodBeat.o(18432);
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
            objArr[1] = com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId);
            objArr[2] = this.hGa.getName();
            ab.e(str3, str4, objArr);
            if (this.jGs != null) {
                this.jGs.m(this.mSessionId, false);
            }
            AppMethodBeat.o(18432);
        } else if (i == 8) {
            this.jFX.jFy = bluetoothGattCharacteristic;
            this.jFX.setData(aVE);
            ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.aN(this.jFX.aVu()), str, com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
            bluetoothGattCharacteristic.setValue(aVE);
            this.mHandler.postDelayed(this.jFY, 5000);
            if (this.jFT.writeCharacteristic(bluetoothGattCharacteristic)) {
                this.jGd = true;
                AppMethodBeat.o(18432);
                return;
            }
            ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
            if (this.jGs != null) {
                this.jGs.m(this.mSessionId, false);
            }
            AppMethodBeat.o(18432);
        } else {
            ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.ie(this.mSessionId), this.hGa.getName());
            if (this.jGs != null) {
                this.jGs.m(this.mSessionId, false);
            }
            AppMethodBeat.o(18432);
        }
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(18433);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
        if (1 == fVar.jGe) {
            ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
            if (fVar.jGs != null) {
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                fVar.jGs.a(fVar.mSessionId, true, fVar.jGw);
            }
            AppMethodBeat.o(18433);
        } else if (fVar.jGe == 0) {
            ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
            AppMethodBeat.o(18433);
        } else {
            fVar.aVz();
            if (fVar.jFT == null) {
                fVar.jFT = fVar.hGa.connectGatt(fVar.jFS, false, fVar.jGf);
                jGz++;
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(fVar.hashCode()), Integer.valueOf(jGz), com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
                if (fVar.jFT == null) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                    fVar.aVC();
                    AppMethodBeat.o(18433);
                    return;
                }
                fVar.jGe = 0;
                fVar.mHandler.postDelayed(fVar.jGa, 10000);
                AppMethodBeat.o(18433);
            } else if (fVar.jFT.connect()) {
                fVar.jGe = 0;
                fVar.mHandler.postDelayed(fVar.jGa, 10000);
                AppMethodBeat.o(18433);
            } else {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                fVar.aVC();
                AppMethodBeat.o(18433);
            }
        }
    }

    static /* synthetic */ boolean a(f fVar, BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(18435);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
        fVar.mHandler.removeCallbacks(fVar.jGa);
        if (3 == fVar.jGe) {
            ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
            AppMethodBeat.o(18435);
            return false;
        }
        if (1 == fVar.jGe) {
            ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
        } else if (i != 0) {
            ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
            fVar.aVB();
            AppMethodBeat.o(18435);
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
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                    obj = null;
                } else if (c.b(bluetoothGattService)) {
                    fVar.jGw |= c.a(bluetoothGattService);
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
                        ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", uuid, Integer.valueOf(properties), Integer.valueOf(permissions));
                        if (uuid == null) {
                            uuid = BuildConfig.COMMAND;
                        }
                        hashMap.put(uuid, bluetoothGattCharacteristic);
                        fVar.jGx.add(bluetoothGattCharacteristic);
                        i4 = i5 + 1;
                    }
                    fVar.jGv.put(bluetoothGattService.getUuid().toString(), hashMap);
                    obj = 1;
                } else {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                    obj = null;
                }
                if (obj == null) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", bluetoothGattService.getUuid().toString());
                }
                i2 = i3 + 1;
            }
            if (0 == fVar.jGw) {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                fVar.aVB();
                AppMethodBeat.o(18435);
                return false;
            } else if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(9));
            }
        }
        AppMethodBeat.o(18435);
        return true;
    }

    static /* synthetic */ void b(f fVar, int i) {
        AppMethodBeat.i(18436);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
            ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(9));
        }
        AppMethodBeat.o(18436);
    }

    static /* synthetic */ void b(f fVar) {
        AppMethodBeat.i(18437);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
        if (3 == fVar.jGe) {
            ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
            AppMethodBeat.o(18437);
        } else if (2 == fVar.jGe) {
            ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
            AppMethodBeat.o(18437);
        } else {
            fVar.aVz();
            if (fVar.jFT == null) {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                AppMethodBeat.o(18437);
                return;
            }
            fVar.jGe = 3;
            fVar.mHandler.removeCallbacks(fVar.jGa);
            if (fVar.jFT != null) {
                fVar.jFT.disconnect();
            }
            AppMethodBeat.o(18437);
        }
    }

    static /* synthetic */ void c(f fVar, int i) {
        AppMethodBeat.i(18439);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
        fVar.mHandler.removeCallbacks(fVar.jFY);
        if (i != 0) {
            ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: ".concat(String.valueOf(i)));
            if (fVar.jGs != null) {
                fVar.jGs.m(fVar.mSessionId, false);
            }
            fVar.aVA();
            AppMethodBeat.o(18439);
            return;
        }
        byte[] aVu = fVar.jFX.aVu();
        ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", com.tencent.mm.plugin.exdevice.j.b.aN(aVu));
        if (aVu == null) {
            ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (fVar.jGs != null) {
                fVar.jGs.m(fVar.mSessionId, true);
            }
            fVar.aVA();
            AppMethodBeat.o(18439);
            return;
        }
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        fVar.jFX.jFy.setValue(aVu);
        fVar.jFT.writeCharacteristic(fVar.jFX.jFy);
        fVar.mHandler.postDelayed(fVar.jFY, 5000);
        AppMethodBeat.o(18439);
    }

    static /* synthetic */ void c(f fVar) {
        AppMethodBeat.i(18441);
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
        if (3 == fVar.jGe) {
            ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            fVar.aVC();
            AppMethodBeat.o(18441);
            return;
        }
        fVar.aVz();
        if (fVar.jFT == null) {
            ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            fVar.aVC();
            AppMethodBeat.o(18441);
            return;
        }
        fVar.jGe = 3;
        fVar.mHandler.removeCallbacks(fVar.jGa);
        fVar.aVC();
        if (fVar.jFT != null) {
            ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ie(fVar.mSessionId), fVar.hGa.getName());
            fVar.jFT.disconnect();
            fVar.jGy = true;
            fVar.mHandler.postDelayed(fVar.jGt, 10000);
        }
        AppMethodBeat.o(18441);
    }

    static /* synthetic */ void d(f fVar) {
        AppMethodBeat.i(18442);
        while (fVar.jGx.size() > 0) {
            int i;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) fVar.jGx.remove(0);
            f fVar2 = fVar.jGu;
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 48) == 0) {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                i = 0;
            } else if (fVar2.jFT.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.jGG));
                if (descriptor == null) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                    i = 0;
                } else {
                    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
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
                        ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                        i = 0;
                    } else if (fVar2.jFT.writeDescriptor(descriptor)) {
                        i = 1;
                    } else {
                        ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                        i = 0;
                    }
                }
            } else {
                ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                i = 0;
            }
            if (i != 0) {
                break;
            }
            ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties()));
        }
        ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
        fVar.jGe = 1;
        fVar.mHandler.removeCallbacks(fVar.jGa);
        if (fVar.jGs != null) {
            fVar.jGs.a(fVar.mSessionId, true, fVar.jGw);
        }
        AppMethodBeat.o(18442);
    }
}
