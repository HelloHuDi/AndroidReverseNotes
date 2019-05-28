package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class b implements e {
    public Handler awA = new Handler(Looper.getMainLooper());
    public Queue<a> hEb;
    a hEc;
    public List<a> hEd;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ a hEe;

        public AnonymousClass1(a aVar) {
            this.hEe = aVar;
        }

        public final void run() {
            AppMethodBeat.i(94230);
            this.hEe.aCS();
            AppMethodBeat.o(94230);
        }
    }

    public b() {
        AppMethodBeat.i(94232);
        AppMethodBeat.o(94232);
    }

    public final synchronized void aCQ() {
        AppMethodBeat.i(94233);
        if (this.hEc == null || this.hEc.bcp) {
            if (this.hEb != null && this.hEb.size() > 0) {
                this.hEc = (a) this.hEb.poll();
                if (this.hEc == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
                    AppMethodBeat.o(94233);
                } else if (this.hEc.hDP) {
                    this.awA.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(94231);
                            b.this.hEc.aCS();
                            AppMethodBeat.o(94231);
                        }
                    }, this.hEc.hEy);
                    AppMethodBeat.o(94233);
                } else {
                    this.hEc.aCS();
                }
            }
            AppMethodBeat.o(94233);
        } else {
            AppMethodBeat.o(94233);
        }
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94234);
        if (this.hEc != null) {
            this.hEc.onConnectionStateChange(bluetoothGatt, i, i2);
        }
        if (this.hEd != null) {
            for (a aVar : this.hEd) {
                if (aVar.bcp) {
                    aVar.onConnectionStateChange(bluetoothGatt, i, i2);
                }
            }
        }
        AppMethodBeat.o(94234);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(94235);
        if (this.hEc != null) {
            this.hEc.onServicesDiscovered(bluetoothGatt, i);
        }
        if (this.hEd != null) {
            for (a aVar : this.hEd) {
                if (aVar.bcp) {
                    aVar.onServicesDiscovered(bluetoothGatt, i);
                }
            }
        }
        AppMethodBeat.o(94235);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94236);
        if (this.hEc != null) {
            this.hEc.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        if (this.hEd != null) {
            for (a aVar : this.hEd) {
                if (aVar.bcp) {
                    aVar.onServicesDiscovered(bluetoothGatt, i);
                }
            }
        }
        AppMethodBeat.o(94236);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94237);
        if (this.hEc != null) {
            this.hEc.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        if (this.hEd != null) {
            for (a aVar : this.hEd) {
                if (aVar.bcp) {
                    aVar.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }
        }
        AppMethodBeat.o(94237);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.i(94238);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(94238);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.i(94239);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(94239);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.i(94240);
        if (this.hEc != null) {
            this.hEc.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
        if (this.hEd != null) {
            for (a aVar : this.hEd) {
                if (aVar.bcp) {
                    aVar.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }
        }
        AppMethodBeat.o(94240);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(94241);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(94241);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94242);
        if (this.hEd != null) {
            for (a aVar : this.hEd) {
                if (aVar.bcp) {
                    aVar.onServicesDiscovered(bluetoothGatt, i2);
                }
            }
        }
        AppMethodBeat.o(94242);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94243);
        if (this.hEd != null) {
            Iterator it = this.hEd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(94243);
    }
}
