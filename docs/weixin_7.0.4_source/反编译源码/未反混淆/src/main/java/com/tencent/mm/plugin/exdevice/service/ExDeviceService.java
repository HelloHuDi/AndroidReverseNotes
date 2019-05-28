package com.tencent.mm.plugin.exdevice.service;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.service.MMService;

@k
public class ExDeviceService extends MMService {
    private a lwD = null;

    public final void onCreate() {
        AppMethodBeat.i(19567);
        ab.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
        super.onCreate();
        AppMethodBeat.o(19567);
    }

    public final void onDestroy() {
        AppMethodBeat.i(19568);
        ab.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
        Java2CExDevice.closeBluetoothAccessoryLib();
        super.onDestroy();
        if (!bpn()) {
            ab.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
            Process.killProcess(Process.myPid());
        }
        AppMethodBeat.o(19568);
    }

    private static boolean bpn() {
        boolean z;
        AppMethodBeat.i(19569);
        PackageManager packageManager = ah.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
            packageManager.getPackageInfo("com.google.android.wearable.app", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        ab.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", Boolean.valueOf(z));
        AppMethodBeat.o(19569);
        return z;
    }

    public final IBinder Iu() {
        AppMethodBeat.i(19570);
        ab.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
        if (this.lwD == null) {
            this.lwD = new y();
        }
        a aVar = this.lwD;
        AppMethodBeat.o(19570);
        return aVar;
    }

    public final String getTag() {
        return "MicroMsg.exdevice.ExDeviceService";
    }
}
