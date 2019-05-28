package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public final class a {
    public static final UUID jIw = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID jIx = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public BluetoothAdapter jEU;
    public HashMap<Long, b> jFA = new HashMap();
    public final BroadcastReceiver jIA = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(18475);
            if (intent == null) {
                AppMethodBeat.o(18475);
                return;
            }
            String action = intent.getAction();
            ab.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = ".concat(String.valueOf(action)));
            BluetoothDevice bluetoothDevice;
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.getBondState() != 12) {
                    a.this.jIy.dd(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                }
                AppMethodBeat.o(18475);
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                a.this.jIy.aVx();
                AppMethodBeat.o(18475);
            } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1);
                AppMethodBeat.o(18475);
            } else {
                if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                    String address = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
                    if (a.this.jFA.containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.KK(address)))) {
                        ab.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", bluetoothDevice.getName(), address);
                        if (a.this.jIy != null) {
                            a.this.jIy.l(com.tencent.mm.plugin.exdevice.j.b.KK(address), false);
                        }
                    } else {
                        AppMethodBeat.o(18475);
                        return;
                    }
                }
                AppMethodBeat.o(18475);
            }
        }
    };
    public a jIy;
    public Context jIz;
    public ak mHandler;
    public boolean mIsInit = false;
    private Runnable mRunnable;

    public static abstract class a {
        public void g(long j, long j2, long j3) {
        }

        public void dd(String str, String str2) {
        }

        public void aVx() {
        }

        public void l(long j, boolean z) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void m(long j, boolean z) {
        }

        public void c(long j, int i, String str) {
        }
    }

    public final class b implements Runnable {
        private long jFL = 0;
        private long jFM = 0;

        public b(long j, long j2) {
            this.jFL = j;
            this.jFM = j2;
        }

        public final void run() {
            AppMethodBeat.i(18477);
            a aVar = a.this;
            b bVar = new b(this.jFL);
            long j = bVar.mSessionId;
            b bVar2 = (b) aVar.jFA.remove(Long.valueOf(j));
            if (bVar2 != null) {
                bVar2.disconnect();
            }
            aVar.jFA.put(Long.valueOf(j), bVar);
            if (a.this.jIy != null) {
                a.this.jIy.g(j, this.jFL, this.jFM);
            }
            AppMethodBeat.o(18477);
        }
    }

    static {
        AppMethodBeat.i(18482);
        AppMethodBeat.o(18482);
    }

    public a(al alVar) {
        AppMethodBeat.i(18478);
        this.mHandler = new ak(alVar.oAl.getLooper());
        this.mRunnable = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18476);
                if (a.this.jEU.isDiscovering()) {
                    a.this.jEU.cancelDiscovery();
                }
                AppMethodBeat.o(18476);
            }
        };
        AppMethodBeat.o(18478);
    }

    private boolean aVG() {
        AppMethodBeat.i(18480);
        if (!this.jEU.isDiscovering()) {
            AppMethodBeat.o(18480);
            return true;
        } else if (this.jEU.cancelDiscovery()) {
            this.mHandler.removeCallbacks(this.mRunnable);
            AppMethodBeat.o(18480);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
            AppMethodBeat.o(18480);
            return false;
        }
    }

    public final boolean fw(boolean z) {
        String str;
        AppMethodBeat.i(18481);
        String str2 = "MicroMsg.exdevice.BluetoothChatManager";
        StringBuilder stringBuilder = new StringBuilder("scanDevices");
        if (z) {
            str = "true";
        } else {
            str = "false";
        }
        ab.i(str2, stringBuilder.append(str).toString());
        Assert.assertTrue(this.mIsInit);
        if (!aVF()) {
            ab.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            AppMethodBeat.o(18481);
            return false;
        } else if (!z) {
            boolean aVG = aVG();
            AppMethodBeat.o(18481);
            return aVG;
        } else if (this.jEU.isDiscovering() && !aVG()) {
            AppMethodBeat.o(18481);
            return false;
        } else if (this.jEU.startDiscovery()) {
            this.mHandler.postDelayed(this.mRunnable, 10000);
            AppMethodBeat.o(18481);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
            AppMethodBeat.o(18481);
            return false;
        }
    }

    public final boolean aVF() {
        AppMethodBeat.i(18479);
        Assert.assertTrue(this.mIsInit);
        if (this.jEU == null) {
            AppMethodBeat.o(18479);
            return false;
        }
        AppMethodBeat.o(18479);
        return true;
    }
}
