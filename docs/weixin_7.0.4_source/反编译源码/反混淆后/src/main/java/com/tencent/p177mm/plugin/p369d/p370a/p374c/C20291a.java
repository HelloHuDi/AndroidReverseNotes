package com.tencent.p177mm.plugin.p369d.p370a.p374c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
/* renamed from: com.tencent.mm.plugin.d.a.c.a */
public final class C20291a {
    public static final UUID jIw = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID jIx = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public BluetoothAdapter jEU;
    public HashMap<Long, C27699b> jFA = new HashMap();
    public final BroadcastReceiver jIA = new C202921();
    public C2873a jIy;
    public Context jIz;
    public C7306ak mHandler;
    public boolean mIsInit = false;
    private Runnable mRunnable;

    /* renamed from: com.tencent.mm.plugin.d.a.c.a$a */
    public static abstract class C2873a {
        /* renamed from: g */
        public void mo7009g(long j, long j2, long j3) {
        }

        /* renamed from: dd */
        public void mo7008dd(String str, String str2) {
        }

        public void aVx() {
        }

        /* renamed from: l */
        public void mo7010l(long j, boolean z) {
        }

        /* renamed from: b */
        public void mo7006b(long j, byte[] bArr) {
        }

        /* renamed from: m */
        public void mo7011m(long j, boolean z) {
        }

        /* renamed from: c */
        public void mo7007c(long j, int i, String str) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.c.a$b */
    public final class C2874b implements Runnable {
        private long jFL = 0;
        private long jFM = 0;

        public C2874b(long j, long j2) {
            this.jFL = j;
            this.jFM = j2;
        }

        public final void run() {
            AppMethodBeat.m2504i(18477);
            C20291a c20291a = C20291a.this;
            C27699b c27699b = new C27699b(this.jFL);
            long j = c27699b.mSessionId;
            C27699b c27699b2 = (C27699b) c20291a.jFA.remove(Long.valueOf(j));
            if (c27699b2 != null) {
                c27699b2.disconnect();
            }
            c20291a.jFA.put(Long.valueOf(j), c27699b);
            if (C20291a.this.jIy != null) {
                C20291a.this.jIy.mo7009g(j, this.jFL, this.jFM);
            }
            AppMethodBeat.m2505o(18477);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.c.a$1 */
    class C202921 extends BroadcastReceiver {
        C202921() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(18475);
            if (intent == null) {
                AppMethodBeat.m2505o(18475);
                return;
            }
            String action = intent.getAction();
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = ".concat(String.valueOf(action)));
            BluetoothDevice bluetoothDevice;
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.getBondState() != 12) {
                    C20291a.this.jIy.mo7008dd(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                }
                AppMethodBeat.m2505o(18475);
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                C20291a.this.jIy.aVx();
                AppMethodBeat.m2505o(18475);
            } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1);
                AppMethodBeat.m2505o(18475);
            } else {
                if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                    String address = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
                    if (C20291a.this.jFA.containsKey(Long.valueOf(C42992b.m76346KK(address)))) {
                        C4990ab.m7417i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", bluetoothDevice.getName(), address);
                        if (C20291a.this.jIy != null) {
                            C20291a.this.jIy.mo7010l(C42992b.m76346KK(address), false);
                        }
                    } else {
                        AppMethodBeat.m2505o(18475);
                        return;
                    }
                }
                AppMethodBeat.m2505o(18475);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.c.a$2 */
    class C202932 implements Runnable {
        C202932() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18476);
            if (C20291a.this.jEU.isDiscovering()) {
                C20291a.this.jEU.cancelDiscovery();
            }
            AppMethodBeat.m2505o(18476);
        }
    }

    static {
        AppMethodBeat.m2504i(18482);
        AppMethodBeat.m2505o(18482);
    }

    public C20291a(C5004al c5004al) {
        AppMethodBeat.m2504i(18478);
        this.mHandler = new C7306ak(c5004al.oAl.getLooper());
        this.mRunnable = new C202932();
        AppMethodBeat.m2505o(18478);
    }

    private boolean aVG() {
        AppMethodBeat.m2504i(18480);
        if (!this.jEU.isDiscovering()) {
            AppMethodBeat.m2505o(18480);
            return true;
        } else if (this.jEU.cancelDiscovery()) {
            this.mHandler.removeCallbacks(this.mRunnable);
            AppMethodBeat.m2505o(18480);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
            AppMethodBeat.m2505o(18480);
            return false;
        }
    }

    /* renamed from: fw */
    public final boolean mo35532fw(boolean z) {
        String str;
        AppMethodBeat.m2504i(18481);
        String str2 = "MicroMsg.exdevice.BluetoothChatManager";
        StringBuilder stringBuilder = new StringBuilder("scanDevices");
        if (z) {
            str = "true";
        } else {
            str = "false";
        }
        C4990ab.m7416i(str2, stringBuilder.append(str).toString());
        Assert.assertTrue(this.mIsInit);
        if (!aVF()) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            AppMethodBeat.m2505o(18481);
            return false;
        } else if (!z) {
            boolean aVG = aVG();
            AppMethodBeat.m2505o(18481);
            return aVG;
        } else if (this.jEU.isDiscovering() && !aVG()) {
            AppMethodBeat.m2505o(18481);
            return false;
        } else if (this.jEU.startDiscovery()) {
            this.mHandler.postDelayed(this.mRunnable, 10000);
            AppMethodBeat.m2505o(18481);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
            AppMethodBeat.m2505o(18481);
            return false;
        }
    }

    public final boolean aVF() {
        AppMethodBeat.m2504i(18479);
        Assert.assertTrue(this.mIsInit);
        if (this.jEU == null) {
            AppMethodBeat.m2505o(18479);
            return false;
        }
        AppMethodBeat.m2505o(18479);
        return true;
    }
}
