package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C38281a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C10341d;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C26941e;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C38279b;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a */
public abstract class C10343a implements C26941e {
    public boolean aJe = C38281a.hDK.aJe;
    private final Handler awA = new Handler(Looper.getMainLooper());
    public boolean bcp = false;
    public boolean hDP = C38281a.hDK.hDP;
    public boolean hDR = C38281a.hDK.hDR;
    protected C10341d hEt;
    protected C38279b hEu;
    public C2237b hEv;
    private Runnable hEw = new C103421();
    public long hEx = C38281a.hDK.hDM;
    public long hEy = ((long) C38281a.hDK.hDV);
    public C26942j hEz;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a$1 */
    class C103421 implements Runnable {
        C103421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(94277);
            if (C10343a.this.bcp) {
                AppMethodBeat.m2505o(94277);
                return;
            }
            C10343a.this.mo21808a(C26942j.hFa);
            C10343a.this.done();
            AppMethodBeat.m2505o(94277);
        }
    }

    public abstract void aCR();

    public abstract String getName();

    /* renamed from: a */
    public final void mo21807a(C10341d c10341d) {
        this.hEt = c10341d;
    }

    /* renamed from: a */
    public final void mo21806a(C38279b c38279b) {
        this.hEu = c38279b;
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

    /* renamed from: a */
    public final void mo21808a(final C26942j c26942j) {
        this.hEz = c26942j;
        if (this.hDP) {
            this.awA.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(94278);
                    C10343a.this.hEv.mo6097a(c26942j);
                    AppMethodBeat.m2505o(94278);
                }
            });
        } else {
            this.hEv.mo6097a(c26942j);
        }
    }

    public final void done() {
        this.awA.removeCallbacks(this.hEw);
        this.bcp = true;
        mo21811b(this.hEz);
        C38279b c38279b = this.hEu;
        C26942j c26942j = this.hEz;
        String str = "MicroMsg.Ble.BleConnectDispatcher";
        String str2 = "actionCompleteCallback action:%s result:%s";
        Object[] objArr = new Object[2];
        objArr[0] = this;
        if (c26942j == null) {
            c26942j = "";
        }
        objArr[1] = c26942j;
        C26944a.m42897i(str, str2, objArr);
        if (this.hDR) {
            c38279b.aCQ();
        } else {
            c38279b.hEd.remove(this);
        }
    }

    /* renamed from: b */
    public void mo21811b(C26942j c26942j) {
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
