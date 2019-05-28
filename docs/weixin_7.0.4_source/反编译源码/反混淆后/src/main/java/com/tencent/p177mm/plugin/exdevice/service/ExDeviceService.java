package com.tencent.p177mm.plugin.exdevice.service;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C26347k;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.exdevice.service.C45893h.C27861a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.service.MMService;

@C26347k
/* renamed from: com.tencent.mm.plugin.exdevice.service.ExDeviceService */
public class ExDeviceService extends MMService {
    private C27861a lwD = null;

    public final void onCreate() {
        AppMethodBeat.m2504i(19567);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
        super.onCreate();
        AppMethodBeat.m2505o(19567);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(19568);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
        Java2CExDevice.closeBluetoothAccessoryLib();
        super.onDestroy();
        if (!ExDeviceService.bpn()) {
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
            Process.killProcess(Process.myPid());
        }
        AppMethodBeat.m2505o(19568);
    }

    private static boolean bpn() {
        boolean z;
        AppMethodBeat.m2504i(19569);
        PackageManager packageManager = C4996ah.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
            packageManager.getPackageInfo("com.google.android.wearable.app", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(19569);
        return z;
    }

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        AppMethodBeat.m2504i(19570);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
        if (this.lwD == null) {
            this.lwD = new C38963y();
        }
        C27861a c27861a = this.lwD;
        AppMethodBeat.m2505o(19570);
        return c27861a;
    }

    public final String getTag() {
        return "MicroMsg.exdevice.ExDeviceService";
    }
}
