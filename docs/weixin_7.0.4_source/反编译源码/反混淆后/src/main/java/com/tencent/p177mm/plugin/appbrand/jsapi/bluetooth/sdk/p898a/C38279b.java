package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10343a;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b */
public final class C38279b implements C26941e {
    public Handler awA = new Handler(Looper.getMainLooper());
    public Queue<C10343a> hEb;
    C10343a hEc;
    public List<C10343a> hEd;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b$2 */
    class C332592 implements Runnable {
        C332592() {
        }

        public final void run() {
            AppMethodBeat.m2504i(94231);
            C38279b.this.hEc.aCS();
            AppMethodBeat.m2505o(94231);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b$1 */
    public class C382801 implements Runnable {
        final /* synthetic */ C10343a hEe;

        public C382801(C10343a c10343a) {
            this.hEe = c10343a;
        }

        public final void run() {
            AppMethodBeat.m2504i(94230);
            this.hEe.aCS();
            AppMethodBeat.m2505o(94230);
        }
    }

    public C38279b() {
        AppMethodBeat.m2504i(94232);
        AppMethodBeat.m2505o(94232);
    }

    public final synchronized void aCQ() {
        AppMethodBeat.m2504i(94233);
        if (this.hEc == null || this.hEc.bcp) {
            if (this.hEb != null && this.hEb.size() > 0) {
                this.hEc = (C10343a) this.hEb.poll();
                if (this.hEc == null) {
                    C26944a.m42898w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
                    AppMethodBeat.m2505o(94233);
                } else if (this.hEc.hDP) {
                    this.awA.postDelayed(new C332592(), this.hEc.hEy);
                    AppMethodBeat.m2505o(94233);
                } else {
                    this.hEc.aCS();
                }
            }
            AppMethodBeat.m2505o(94233);
        } else {
            AppMethodBeat.m2505o(94233);
        }
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94234);
        if (this.hEc != null) {
            this.hEc.onConnectionStateChange(bluetoothGatt, i, i2);
        }
        if (this.hEd != null) {
            for (C10343a c10343a : this.hEd) {
                if (c10343a.bcp) {
                    c10343a.onConnectionStateChange(bluetoothGatt, i, i2);
                }
            }
        }
        AppMethodBeat.m2505o(94234);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(94235);
        if (this.hEc != null) {
            this.hEc.onServicesDiscovered(bluetoothGatt, i);
        }
        if (this.hEd != null) {
            for (C10343a c10343a : this.hEd) {
                if (c10343a.bcp) {
                    c10343a.onServicesDiscovered(bluetoothGatt, i);
                }
            }
        }
        AppMethodBeat.m2505o(94235);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94236);
        if (this.hEc != null) {
            this.hEc.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        if (this.hEd != null) {
            for (C10343a c10343a : this.hEd) {
                if (c10343a.bcp) {
                    c10343a.onServicesDiscovered(bluetoothGatt, i);
                }
            }
        }
        AppMethodBeat.m2505o(94236);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94237);
        if (this.hEc != null) {
            this.hEc.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        if (this.hEd != null) {
            for (C10343a c10343a : this.hEd) {
                if (c10343a.bcp) {
                    c10343a.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }
        }
        AppMethodBeat.m2505o(94237);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.m2504i(94238);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.m2505o(94238);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.m2504i(94239);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.m2505o(94239);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.m2504i(94240);
        if (this.hEc != null) {
            this.hEc.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
        if (this.hEd != null) {
            for (C10343a c10343a : this.hEd) {
                if (c10343a.bcp) {
                    c10343a.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }
        }
        AppMethodBeat.m2505o(94240);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(94241);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.m2505o(94241);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94242);
        if (this.hEd != null) {
            for (C10343a c10343a : this.hEd) {
                if (c10343a.bcp) {
                    c10343a.onServicesDiscovered(bluetoothGatt, i2);
                }
            }
        }
        AppMethodBeat.m2505o(94242);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94243);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.m2505o(94243);
    }
}
