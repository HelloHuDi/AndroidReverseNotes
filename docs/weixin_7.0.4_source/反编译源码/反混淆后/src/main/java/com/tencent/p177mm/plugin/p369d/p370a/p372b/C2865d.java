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
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.b.d */
public final class C2865d {
    private int aBR;
    BluetoothDevice hGa;
    private BluetoothAdapter jEU;
    Context jFS;
    BluetoothGatt jFT;
    C2852b jFU;
    BluetoothGattCharacteristic jFV;
    BluetoothGattCharacteristic jFW;
    C20288a jFX;
    Runnable jFY;
    Runnable jFZ;
    Runnable jGa;
    C2865d jGb;
    final LinkedList<byte[]> jGc;
    volatile boolean jGd;
    int jGe;
    final BluetoothGattCallback jGf;
    public C7306ak mHandler;
    long mSessionId;
    private HandlerThread mThread;

    /* renamed from: com.tencent.mm.plugin.d.a.b.d$2 */
    class C28662 implements Runnable {
        C28662() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18393);
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
            if (C2865d.this.jFU != null) {
                C2865d.this.jFU.jFz.mo6980m(C2865d.this.mSessionId, false);
            }
            C2865d.this.aVA();
            AppMethodBeat.m2505o(18393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.d$4 */
    class C28674 implements Runnable {
        C28674() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18395);
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
            if (3 == C2865d.this.jGe) {
                C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                AppMethodBeat.m2505o(18395);
                return;
            }
            C2865d.this.mHandler.removeCallbacks(C2865d.this.jFZ);
            C2865d.this.jGe = 2;
            if (C2865d.this.jFU != null) {
                C2865d.this.jFU.jFz.mo6979l(C2865d.this.mSessionId, false);
            }
            AppMethodBeat.m2505o(18395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.d$1 */
    class C28681 extends BluetoothGattCallback {
        C28681() {
        }

        public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            AppMethodBeat.m2504i(18387);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(C2865d.this.jGe));
            if (!C2865d.this.mHandler.sendMessage(C2865d.this.mHandler.obtainMessage(4, i2, 0))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(4));
            }
            AppMethodBeat.m2505o(18387);
        }

        public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            AppMethodBeat.m2504i(18388);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i));
            if (!C2865d.this.mHandler.sendMessage(C2865d.this.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(5));
            }
            AppMethodBeat.m2505o(18388);
        }

        public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            AppMethodBeat.m2504i(18389);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i));
            if (!C2865d.this.mHandler.sendMessage(C2865d.this.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(6));
            }
            AppMethodBeat.m2505o(18389);
        }

        public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            AppMethodBeat.m2504i(18390);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
            if (!C2865d.this.mHandler.sendMessage(C2865d.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic.getValue()))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
            }
            AppMethodBeat.m2505o(18390);
        }

        public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            AppMethodBeat.m2504i(18391);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(18391);
        }

        public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            AppMethodBeat.m2504i(18392);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i));
            if (!C2865d.this.mHandler.sendMessage(C2865d.this.mHandler.obtainMessage(7, i, 0))) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(7));
            }
            AppMethodBeat.m2505o(18392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.d$3 */
    class C28693 implements Runnable {
        C28693() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18394);
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
            if (3 == C2865d.this.jGe) {
                C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                AppMethodBeat.m2505o(18394);
                return;
            }
            C2865d.this.mHandler.removeCallbacks(C2865d.this.jGa);
            C2865d.this.jGe = 2;
            if (C2865d.this.jFU != null) {
                C2865d.this.jFU.jFz.mo6979l(C2865d.this.mSessionId, false);
            }
            AppMethodBeat.m2505o(18394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.d$a */
    static class C2870a extends C7306ak {
        private final WeakReference<C2865d> jGh;

        public C2870a(Looper looper, C2865d c2865d) {
            super(looper);
            AppMethodBeat.m2504i(18396);
            this.jGh = new WeakReference(c2865d);
            AppMethodBeat.m2505o(18396);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.m2504i(18397);
            C2865d c2865d = (C2865d) this.jGh.get();
            if (c2865d == null) {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
                AppMethodBeat.m2505o(18397);
                return;
            }
            byte[] aVu;
            int i;
            int i2;
            switch (message.what) {
                case 0:
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                    if (1 == c2865d.jGe) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else if (c2865d.jGe == 0) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else {
                        c2865d.aVz();
                        if (c2865d.jFT == null) {
                            c2865d.jFT = c2865d.hGa.connectGatt(c2865d.jFS, false, c2865d.jGf);
                            if (c2865d.jFT == null) {
                                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                                if (c2865d.jFU != null) {
                                    c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                                }
                                AppMethodBeat.m2505o(18397);
                                return;
                            }
                            c2865d.jGe = 0;
                            c2865d.mHandler.postDelayed(c2865d.jGa, 10000);
                            AppMethodBeat.m2505o(18397);
                            return;
                        } else if (c2865d.jFT.connect()) {
                            c2865d.jGe = 0;
                            c2865d.mHandler.postDelayed(c2865d.jGa, 10000);
                            AppMethodBeat.m2505o(18397);
                            return;
                        } else {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                            if (c2865d.jFU != null) {
                                c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                            }
                            AppMethodBeat.m2505o(18397);
                            return;
                        }
                    }
                case 1:
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                    if (3 == c2865d.jGe) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                    c2865d.aVz();
                    if (c2865d.jFT == null) {
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                    c2865d.jGe = 3;
                    c2865d.mHandler.removeCallbacks(c2865d.jGa);
                    c2865d.mHandler.removeCallbacks(c2865d.jFZ);
                    c2865d.jFT.disconnect();
                    AppMethodBeat.m2505o(18397);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                    if (3 != c2865d.jGe) {
                        c2865d.aVz();
                        if (c2865d.jFT != null) {
                            c2865d.jGe = 3;
                            c2865d.jFT.disconnect();
                            c2865d.jFT.close();
                            c2865d.jFT = null;
                            break;
                        }
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                    AppMethodBeat.m2505o(18397);
                    return;
                case 3:
                    C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", Integer.valueOf(((byte[]) message.obj).length));
                    if (1 != c2865d.jGe) {
                        C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", Integer.valueOf(c2865d.jGe));
                        if (c2865d.jFU != null) {
                            c2865d.jFU.jFz.mo6980m(c2865d.mSessionId, false);
                        }
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                    boolean z2 = (c2865d.jFT == null || c2865d.jFW == null) ? false : true;
                    Assert.assertTrue(z2);
                    c2865d.jGc.add(aVu);
                    if (!c2865d.jGd) {
                        if (1 != c2865d.jGc.size()) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        c2865d.aVA();
                    }
                    AppMethodBeat.m2505o(18397);
                    return;
                case 4:
                    i = message.arg1;
                    String str = "MicroMsg.exdevice.BluetoothLESession";
                    String str2 = "------onConnectionStateChangeImp------ aState = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = i == 2 ? "Connected" : "Disconnected";
                    C4990ab.m7417i(str, str2, objArr);
                    if (i == 2) {
                        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", Integer.valueOf(c2865d.jGe));
                        if (3 == c2865d.jGe) {
                            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            AppMethodBeat.m2505o(18397);
                            return;
                        } else if (1 == c2865d.jGe) {
                            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            AppMethodBeat.m2505o(18397);
                            return;
                        } else if (c2865d.jFT.discoverServices()) {
                            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                            AppMethodBeat.m2505o(18397);
                            return;
                        } else {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            c2865d.jGe = 2;
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            if (c2865d.jFU != null) {
                                c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                            }
                            AppMethodBeat.m2505o(18397);
                            return;
                        }
                    }
                    if (i == 0) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                        c2865d.jGe = 2;
                        c2865d.mHandler.removeCallbacks(c2865d.jGa);
                        if (c2865d.jFU != null) {
                            c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                        }
                    }
                    AppMethodBeat.m2505o(18397);
                    return;
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", Integer.valueOf(message.arg1));
                    if (3 == c2865d.jGe) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        c2865d.mHandler.removeCallbacks(c2865d.jGa);
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else if (1 == c2865d.jGe) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        c2865d.mHandler.removeCallbacks(c2865d.jGa);
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else if (i != 0) {
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                        c2865d.jGe = 2;
                        c2865d.mHandler.removeCallbacks(c2865d.jGa);
                        if (c2865d.jFU != null) {
                            c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                        }
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else {
                        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(C38832h.jGH));
                        if (service == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                            c2865d.jGe = 2;
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            if (c2865d.jFU != null) {
                                c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                            }
                            AppMethodBeat.m2505o(18397);
                            return;
                        }
                        c2865d.jFV = service.getCharacteristic(UUID.fromString(C38832h.jGJ));
                        if (c2865d.jFV == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                            c2865d.jGe = 2;
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            if (c2865d.jFU != null) {
                                c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                            }
                            AppMethodBeat.m2505o(18397);
                            return;
                        }
                        c2865d.jFW = service.getCharacteristic(UUID.fromString(C38832h.jGI));
                        if (c2865d.jFW == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                            c2865d.jGe = 2;
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            if (c2865d.jFU != null) {
                                c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                            }
                            AppMethodBeat.m2505o(18397);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", Integer.valueOf(c2865d.jFV.getProperties()));
                        if ((c2865d.jFV.getProperties() & 32) == 0) {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                            c2865d.jGe = 2;
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            if (c2865d.jFU != null) {
                                c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                            }
                            AppMethodBeat.m2505o(18397);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                        C2865d c2865d2 = c2865d.jGb;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = c2865d.jFV;
                        if (c2865d2.jFT.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(C38832h.jGG));
                            if (descriptor == null) {
                                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                                z = false;
                            } else {
                                C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                                if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                    z = false;
                                } else if (c2865d2.jFT.writeDescriptor(descriptor)) {
                                    c2865d2.mHandler.postDelayed(c2865d2.jFZ, 5000);
                                } else {
                                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                    z = false;
                                }
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                            z = false;
                        }
                        if (!z) {
                            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                            c2865d.jGe = 2;
                            c2865d.mHandler.removeCallbacks(c2865d.jGa);
                            if (c2865d.jFU != null) {
                                c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                            }
                        }
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                case 6:
                    Object obj = message.obj;
                    C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", Integer.valueOf(message.arg1));
                    c2865d.mHandler.removeCallbacks(c2865d.jFZ);
                    c2865d.mHandler.removeCallbacks(c2865d.jGa);
                    if (3 == c2865d.jGe) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else if (1 == c2865d.jGe) {
                        C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else if (i2 != 0) {
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                        c2865d.jGe = 2;
                        if (c2865d.jFU != null) {
                            c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, false);
                        }
                        AppMethodBeat.m2505o(18397);
                        return;
                    } else {
                        c2865d.jGe = 1;
                        if (c2865d.jFU != null) {
                            c2865d.jFU.jFz.mo6979l(c2865d.mSessionId, true);
                        }
                        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", Integer.valueOf(c2865d.jGe));
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                case 7:
                    i2 = message.arg1;
                    C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", Integer.valueOf(i2));
                    c2865d.mHandler.removeCallbacks(c2865d.jFY);
                    if (i2 != 0) {
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i2)));
                        if (c2865d.jFU != null) {
                            c2865d.jFU.jFz.mo6980m(c2865d.mSessionId, false);
                        }
                        c2865d.aVA();
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                    aVu = c2865d.jFX.aVu();
                    C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", C42992b.m76349aN(aVu));
                    if (aVu == null) {
                        C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                        if (c2865d.jFU != null) {
                            c2865d.jFU.jFz.mo6980m(c2865d.mSessionId, true);
                        }
                        c2865d.aVA();
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                    c2865d.jFW.setValue(aVu);
                    c2865d.jFT.writeCharacteristic(c2865d.jFW);
                    c2865d.mHandler.postDelayed(c2865d.jFY, 5000);
                    AppMethodBeat.m2505o(18397);
                    return;
                case 8:
                    aVu = (byte[]) message.obj;
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                    if (C5046bo.m7540cb(aVu)) {
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                        AppMethodBeat.m2505o(18397);
                        return;
                    }
                    String S = C42992b.m76348S(aVu, aVu.length);
                    C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", Integer.valueOf(aVu.length));
                    C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", S);
                    if (c2865d.jFU != null) {
                        c2865d.jFU.jFz.mo6977b(c2865d.mSessionId, aVu);
                    }
                    AppMethodBeat.m2505o(18397);
                    return;
            }
            AppMethodBeat.m2505o(18397);
        }
    }

    @TargetApi(18)
    public C2865d(long j, Context context, C2852b c2852b) {
        AppMethodBeat.m2504i(18398);
        this.jGc = new LinkedList();
        this.jGd = false;
        this.jGf = new C28681();
        this.aBR = -1;
        this.aBR = hashCode();
        this.jGb = this;
        this.jFU = c2852b;
        this.jFS = context;
        this.jEU = ((BluetoothManager) this.jFS.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.jGe = 3;
        this.hGa = this.jEU.getRemoteDevice(C42904a.m76179gC(j));
        this.jFV = null;
        this.jFW = null;
        this.jFX = new C20288a();
        this.mThread = C7305d.anM("BluetoothLESession_handlerThread");
        this.mThread.start();
        this.mHandler = new C2870a(this.mThread.getLooper(), this);
        this.jFY = new C28662();
        this.jFZ = new C28693();
        this.jGa = new C28674();
        AppMethodBeat.m2505o(18398);
    }

    public final boolean connect() {
        AppMethodBeat.m2504i(18399);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
        AppMethodBeat.m2505o(18399);
        return sendMessage;
    }

    public final void close() {
        AppMethodBeat.m2504i(18400);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(2));
        }
        this.mThread.quitSafely();
        AppMethodBeat.m2505o(18400);
    }

    /* Access modifiers changed, original: final */
    public final void aVz() {
        AppMethodBeat.m2504i(18401);
        this.jGd = false;
        this.jGc.clear();
        AppMethodBeat.m2505o(18401);
    }

    /* Access modifiers changed, original: final */
    public final void aVA() {
        AppMethodBeat.m2504i(18402);
        if (this.jGc.isEmpty()) {
            this.jGd = false;
            AppMethodBeat.m2505o(18402);
            return;
        }
        this.jFX.setData((byte[]) this.jGc.pop());
        C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", C42992b.m76349aN(this.jFX.aVu()));
        this.jFW.setValue(r0);
        this.mHandler.postDelayed(this.jFY, 5000);
        if (!this.jFT.writeCharacteristic(this.jFW)) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.jGd = true;
        AppMethodBeat.m2505o(18402);
    }
}
