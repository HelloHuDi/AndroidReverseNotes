package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e;
import junit.framework.Assert;

public abstract class a implements e {
    public boolean aJe = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.aJe;
    private final Handler awA = new Handler(Looper.getMainLooper());
    public boolean bcp = false;
    public boolean hDP = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.hDP;
    public boolean hDR = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.hDR;
    protected d hEt;
    protected b hEu;
    public b hEv;
    private Runnable hEw = new Runnable() {
        public final void run() {
            AppMethodBeat.i(94277);
            if (a.this.bcp) {
                AppMethodBeat.o(94277);
                return;
            }
            a.this.a(j.hFa);
            a.this.done();
            AppMethodBeat.o(94277);
        }
    };
    public long hEx = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.hDM;
    public long hEy = ((long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.hDV);
    public j hEz;

    public abstract void aCR();

    public abstract String getName();

    public final void a(d dVar) {
        this.hEt = dVar;
    }

    public final void a(b bVar) {
        this.hEu = bVar;
    }

    public final void aCS() {
        aCT();
        this.awA.postDelayed(this.hEw, this.hEx);
        aCR();
    }

    private void aCT() {
        Assert.assertNotNull(this.hEt);
        Assert.assertNotNull(this.hEu);
        Assert.assertNotNull(this.hEv);
    }

    public final void a(final j jVar) {
        this.hEz = jVar;
        if (this.hDP) {
            this.awA.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(94278);
                    a.this.hEv.a(jVar);
                    AppMethodBeat.o(94278);
                }
            });
        } else {
            this.hEv.a(jVar);
        }
    }

    public final void done() {
        this.awA.removeCallbacks(this.hEw);
        this.bcp = true;
        b(this.hEz);
        b bVar = this.hEu;
        j jVar = this.hEz;
        String str = "MicroMsg.Ble.BleConnectDispatcher";
        String str2 = "actionCompleteCallback action:%s result:%s";
        Object[] objArr = new Object[2];
        objArr[0] = this;
        if (jVar == null) {
            jVar = "";
        }
        objArr[1] = jVar;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, str2, objArr);
        if (this.hDR) {
            bVar.aCQ();
        } else {
            bVar.hEd.remove(this);
        }
    }

    public void b(j jVar) {
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public String toString() {
        return "Action{action='" + getName() + '\'' + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
    }
}
