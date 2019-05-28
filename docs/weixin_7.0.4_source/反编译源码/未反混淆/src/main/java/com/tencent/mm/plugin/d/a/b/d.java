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
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d {
    private int aBR;
    BluetoothDevice hGa;
    private BluetoothAdapter jEU;
    Context jFS;
    BluetoothGatt jFT;
    b jFU;
    BluetoothGattCharacteristic jFV;
    BluetoothGattCharacteristic jFW;
    a jFX;
    Runnable jFY;
    Runnable jFZ;
    Runnable jGa;
    d jGb;
    final LinkedList<byte[]> jGc;
    volatile boolean jGd;
    int jGe;
    final BluetoothGattCallback jGf;
    public ak mHandler;
    long mSessionId;
    private HandlerThread mThread;

    static class a extends ak {
        private final WeakReference<d> jGh;

        public a(Looper looper, d dVar) {
            super(looper);
            AppMethodBeat.i(18396);
            this.jGh = new WeakReference(dVar);
            AppMethodBeat.o(18396);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(18397);
            d dVar = (d) this.jGh.get();
            if (dVar == null) {
                ab.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
                AppMethodBeat.o(18397);
                return;
            }
            byte[] aVu;
            int i;
            int i2;
            switch (message.what) {
                case 0:
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                    if (1 == dVar.jGe) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                        AppMethodBeat.o(18397);
                        return;
                    } else if (dVar.jGe == 0) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                        AppMethodBeat.o(18397);
                        return;
                    } else {
                        dVar.aVz();
                        if (dVar.jFT == null) {
                            dVar.jFT = dVar.hGa.connectGatt(dVar.jFS, false, dVar.jGf);
                            if (dVar.jFT == null) {
                                ab.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                                if (dVar.jFU != null) {
                                    dVar.jFU.jFz.l(dVar.mSessionId, false);
                                }
                                AppMethodBeat.o(18397);
                                return;
                            }
                            dVar.jGe = 0;
                            dVar.mHandler.postDelayed(dVar.jGa, 10000);
                            AppMethodBeat.o(18397);
                            return;
                        } else if (dVar.jFT.connect()) {
                            dVar.jGe = 0;
                            dVar.mHandler.postDelayed(dVar.jGa, 10000);
                            AppMethodBeat.o(18397);
                            return;
                        } else {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                            if (dVar.jFU != null) {
                                dVar.jFU.jFz.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(18397);
                            return;
                        }
                    }
                case 1:
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                    if (3 == dVar.jGe) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                        AppMethodBeat.o(18397);
                        return;
                    }
                    dVar.aVz();
                    if (dVar.jFT == null) {
                        ab.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                        AppMethodBeat.o(18397);
                        return;
                    }
                    dVar.jGe = 3;
                    dVar.mHandler.removeCallbacks(dVar.jGa);
                    dVar.mHandler.removeCallbacks(dVar.jFZ);
                    dVar.jFT.disconnect();
                    AppMethodBeat.o(18397);
                    return;
                case 2:
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                    if (3 != dVar.jGe) {
                        dVar.aVz();
                        if (dVar.jFT != null) {
                            dVar.jGe = 3;
                            dVar.jFT.disconnect();
                            dVar.jFT.close();
                            dVar.jFT = null;
                            break;
                        }
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                        AppMethodBeat.o(18397);
                        return;
                    }
                    ab.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                    AppMethodBeat.o(18397);
                    return;
                case 3:
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", Integer.valueOf(((byte[]) message.obj).length));
                    if (1 != dVar.jGe) {
                        ab.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", Integer.valueOf(dVar.jGe));
                        if (dVar.jFU != null) {
                            dVar.jFU.jFz.m(dVar.mSessionId, false);
                        }
                        AppMethodBeat.o(18397);
                        return;
                    }
                    boolean z2 = (dVar.jFT == null || dVar.jFW == null) ? false : true;
                    Assert.assertTrue(z2);
                    dVar.jGc.add(aVu);
                    if (!dVar.jGd) {
                        if (1 != dVar.jGc.size()) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        dVar.aVA();
                    }
                    AppMethodBeat.o(18397);
                    return;
                case 4:
                    i = message.arg1;
                    String str = "MicroMsg.exdevice.BluetoothLESession";
                    String str2 = "------onConnectionStateChangeImp------ aState = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = i == 2 ? "Connected" : "Disconnected";
                    ab.i(str, str2, objArr);
                    if (i == 2) {
                        ab.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", Integer.valueOf(dVar.jGe));
                        if (3 == dVar.jGe) {
                            ab.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            AppMethodBeat.o(18397);
                            return;
                        } else if (1 == dVar.jGe) {
                            ab.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            AppMethodBeat.o(18397);
                            return;
                        } else if (dVar.jFT.discoverServices()) {
                            ab.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                            AppMethodBeat.o(18397);
                            return;
                        } else {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            dVar.jGe = 2;
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            if (dVar.jFU != null) {
                                dVar.jFU.jFz.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(18397);
                            return;
                        }
                    }
                    if (i == 0) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                        dVar.jGe = 2;
                        dVar.mHandler.removeCallbacks(dVar.jGa);
                        if (dVar.jFU != null) {
                            dVar.jFU.jFz.l(dVar.mSessionId, false);
                        }
                    }
                    AppMethodBeat.o(18397);
                    return;
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", Integer.valueOf(message.arg1));
                    if (3 == dVar.jGe) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.jGa);
                        AppMethodBeat.o(18397);
                        return;
                    } else if (1 == dVar.jGe) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.jGa);
                        AppMethodBeat.o(18397);
                        return;
                    } else if (i != 0) {
                        ab.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                        dVar.jGe = 2;
                        dVar.mHandler.removeCallbacks(dVar.jGa);
                        if (dVar.jFU != null) {
                            dVar.jFU.jFz.l(dVar.mSessionId, false);
                        }
                        AppMethodBeat.o(18397);
                        return;
                    } else {
                        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(h.jGH));
                        if (service == null) {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                            dVar.jGe = 2;
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            if (dVar.jFU != null) {
                                dVar.jFU.jFz.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(18397);
                            return;
                        }
                        dVar.jFV = service.getCharacteristic(UUID.fromString(h.jGJ));
                        if (dVar.jFV == null) {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                            dVar.jGe = 2;
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            if (dVar.jFU != null) {
                                dVar.jFU.jFz.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(18397);
                            return;
                        }
                        dVar.jFW = service.getCharacteristic(UUID.fromString(h.jGI));
                        if (dVar.jFW == null) {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                            dVar.jGe = 2;
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            if (dVar.jFU != null) {
                                dVar.jFU.jFz.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(18397);
                            return;
                        }
                        ab.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", Integer.valueOf(dVar.jFV.getProperties()));
                        if ((dVar.jFV.getProperties() & 32) == 0) {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                            dVar.jGe = 2;
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            if (dVar.jFU != null) {
                                dVar.jFU.jFz.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(18397);
                            return;
                        }
                        ab.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                        d dVar2 = dVar.jGb;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = dVar.jFV;
                        if (dVar2.jFT.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.jGG));
                            if (descriptor == null) {
                                ab.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                                z = false;
                            } else {
                                ab.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                                if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                    ab.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                    z = false;
                                } else if (dVar2.jFT.writeDescriptor(descriptor)) {
                                    dVar2.mHandler.postDelayed(dVar2.jFZ, 5000);
                                } else {
                                    ab.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                    z = false;
                                }
                            }
                        } else {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                            z = false;
                        }
                        if (!z) {
                            ab.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                            dVar.jGe = 2;
                            dVar.mHandler.removeCallbacks(dVar.jGa);
                            if (dVar.jFU != null) {
                                dVar.jFU.jFz.l(dVar.mSessionId, false);
                            }
                        }
                        AppMethodBeat.o(18397);
                        return;
                    }
                case 6:
                    Object obj = message.obj;
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", Integer.valueOf(message.arg1));
                    dVar.mHandler.removeCallbacks(dVar.jFZ);
                    dVar.mHandler.removeCallbacks(dVar.jGa);
                    if (3 == dVar.jGe) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        AppMethodBeat.o(18397);
                        return;
                    } else if (1 == dVar.jGe) {
                        ab.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        AppMethodBeat.o(18397);
                        return;
                    } else if (i2 != 0) {
                        ab.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                        dVar.jGe = 2;
                        if (dVar.jFU != null) {
                            dVar.jFU.jFz.l(dVar.mSessionId, false);
                        }
                        AppMethodBeat.o(18397);
                        return;
                    } else {
                        dVar.jGe = 1;
                        if (dVar.jFU != null) {
                            dVar.jFU.jFz.l(dVar.mSessionId, true);
                        }
                        ab.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", Integer.valueOf(dVar.jGe));
                        AppMethodBeat.o(18397);
                        return;
                    }
                case 7:
                    i2 = message.arg1;
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", Integer.valueOf(i2));
                    dVar.mHandler.removeCallbacks(dVar.jFY);
                    if (i2 != 0) {
                        ab.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i2)));
                        if (dVar.jFU != null) {
                            dVar.jFU.jFz.m(dVar.mSessionId, false);
                        }
                        dVar.aVA();
                        AppMethodBeat.o(18397);
                        return;
                    }
                    aVu = dVar.jFX.aVu();
                    ab.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", b.aN(aVu));
                    if (aVu == null) {
                        ab.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                        if (dVar.jFU != null) {
                            dVar.jFU.jFz.m(dVar.mSessionId, true);
                        }
                        dVar.aVA();
                        AppMethodBeat.o(18397);
                        return;
                    }
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                    dVar.jFW.setValue(aVu);
                    dVar.jFT.writeCharacteristic(dVar.jFW);
                    dVar.mHandler.postDelayed(dVar.jFY, 5000);
                    AppMethodBeat.o(18397);
                    return;
                case 8:
                    aVu = (byte[]) message.obj;
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                    if (bo.cb(aVu)) {
                        ab.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                        AppMethodBeat.o(18397);
                        return;
                    }
                    String S = b.S(aVu, aVu.length);
                    ab.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", Integer.valueOf(aVu.length));
                    ab.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", S);
                    if (dVar.jFU != null) {
                        dVar.jFU.jFz.b(dVar.mSessionId, aVu);
                    }
                    AppMethodBeat.o(18397);
                    return;
            }
            AppMethodBeat.o(18397);
        }
    }

    @TargetApi(18)
    public d(long j, Context context, b bVar) {
        AppMethodBeat.i(18398);
        this.jGc = new LinkedList();
        this.jGd = false;
        this.jGf = new BluetoothGattCallback() {
            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                AppMethodBeat.i(18387);
                ab.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(d.this.jGe));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, i2, 0))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(4));
                }
                AppMethodBeat.o(18387);
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                AppMethodBeat.i(18388);
                ab.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(5));
                }
                AppMethodBeat.o(18388);
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                AppMethodBeat.i(18389);
                ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(6));
                }
                AppMethodBeat.o(18389);
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                AppMethodBeat.i(18390);
                ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic.getValue()))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
                }
                AppMethodBeat.o(18390);
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                AppMethodBeat.i(18391);
                ab.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i));
                AppMethodBeat.o(18391);
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                AppMethodBeat.i(18392);
                ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, i, 0))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(7));
                }
                AppMethodBeat.o(18392);
            }
        };
        this.aBR = -1;
        this.aBR = hashCode();
        this.jGb = this;
        this.jFU = bVar;
        this.jFS = context;
        this.jEU = ((BluetoothManager) this.jFS.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.jGe = 3;
        this.hGa = this.jEU.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.gC(j));
        this.jFV = null;
        this.jFW = null;
        this.jFX = new a();
        this.mThread = com.tencent.mm.sdk.g.d.anM("BluetoothLESession_handlerThread");
        this.mThread.start();
        this.mHandler = new a(this.mThread.getLooper(), this);
        this.jFY = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18393);
                ab.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
                if (d.this.jFU != null) {
                    d.this.jFU.jFz.m(d.this.mSessionId, false);
                }
                d.this.aVA();
                AppMethodBeat.o(18393);
            }
        };
        this.jFZ = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18394);
                ab.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
                if (3 == d.this.jGe) {
                    ab.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    AppMethodBeat.o(18394);
                    return;
                }
                d.this.mHandler.removeCallbacks(d.this.jGa);
                d.this.jGe = 2;
                if (d.this.jFU != null) {
                    d.this.jFU.jFz.l(d.this.mSessionId, false);
                }
                AppMethodBeat.o(18394);
            }
        };
        this.jGa = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18395);
                ab.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
                if (3 == d.this.jGe) {
                    ab.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    AppMethodBeat.o(18395);
                    return;
                }
                d.this.mHandler.removeCallbacks(d.this.jFZ);
                d.this.jGe = 2;
                if (d.this.jFU != null) {
                    d.this.jFU.jFz.l(d.this.mSessionId, false);
                }
                AppMethodBeat.o(18395);
            }
        };
        AppMethodBeat.o(18398);
    }

    public final boolean connect() {
        AppMethodBeat.i(18399);
        ab.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
        AppMethodBeat.o(18399);
        return sendMessage;
    }

    public final void close() {
        AppMethodBeat.i(18400);
        ab.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(2));
        }
        this.mThread.quitSafely();
        AppMethodBeat.o(18400);
    }

    /* Access modifiers changed, original: final */
    public final void aVz() {
        AppMethodBeat.i(18401);
        this.jGd = false;
        this.jGc.clear();
        AppMethodBeat.o(18401);
    }

    /* Access modifiers changed, original: final */
    public final void aVA() {
        AppMethodBeat.i(18402);
        if (this.jGc.isEmpty()) {
            this.jGd = false;
            AppMethodBeat.o(18402);
            return;
        }
        this.jFX.setData((byte[]) this.jGc.pop());
        ab.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", b.aN(this.jFX.aVu()));
        this.jFW.setValue(r0);
        this.mHandler.postDelayed(this.jFY, 5000);
        if (!this.jFT.writeCharacteristic(this.jFW)) {
            ab.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.jGd = true;
        AppMethodBeat.o(18402);
    }
}
