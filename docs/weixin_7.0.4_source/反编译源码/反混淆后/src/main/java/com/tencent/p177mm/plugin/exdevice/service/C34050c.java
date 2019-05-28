package com.tencent.p177mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.model.C34033a;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p952b.C45877a;
import com.tencent.p177mm.plugin.exdevice.service.C45893h.C27861a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.service.c */
public final class C34050c implements ServiceConnection {
    public C27858a lwE;
    public volatile boolean lwF;
    private List<Runnable> lwG = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.exdevice.service.c$a */
    public static abstract class C27858a {
        public int cxI;

        public abstract void onServiceConnected();

        public C27858a(int i) {
            this.cxI = i;
        }
    }

    public C34050c() {
        AppMethodBeat.m2504i(19571);
        AppMethodBeat.m2505o(19571);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(19572);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        C34052x c34052x = new C34052x(C27861a.m44294u(iBinder));
        C20548u.m31750a(c34052x);
        C4996ah.doH();
        c34052x.mo54588a(C45877a.bop());
        c34052x.mo54590b(C34033a.boA());
        if (!c34052x.mo54589a(C45891ad.bpi())) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.lwE != null) {
            this.lwE.onServiceConnected();
        }
        this.lwF = true;
        synchronized (this.lwG) {
            try {
                arrayList = new ArrayList(this.lwG);
                this.lwG.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(19572);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            Runnable runnable = (Runnable) arrayList.get(i2);
            if (runnable != null) {
                runnable.run();
            }
            i = i2 + 1;
        }
        arrayList.clear();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.m2504i(19573);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.lwF = false;
        C20548u.m31750a(null);
        C4996ah.doH();
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
            AppMethodBeat.m2505o(19573);
            return;
        }
        mo54583dH(C4996ah.getContext());
        AppMethodBeat.m2505o(19573);
    }

    /* renamed from: dH */
    public final void mo54583dH(Context context) {
        AppMethodBeat.m2504i(19574);
        if (!C11656d.m19470dI(context)) {
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
            AppMethodBeat.m2505o(19574);
        } else if (C25985d.m41462a(new Intent(context, ExDeviceService.class), (ServiceConnection) this, "exdevice")) {
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
            AppMethodBeat.m2505o(19574);
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
            AppMethodBeat.m2505o(19574);
        }
    }

    /* renamed from: U */
    public final boolean mo54582U(Runnable runnable) {
        AppMethodBeat.m2504i(19575);
        if (runnable == null) {
            AppMethodBeat.m2505o(19575);
            return false;
        }
        if (this.lwF) {
            runnable.run();
        } else {
            synchronized (this.lwG) {
                try {
                    this.lwG.add(runnable);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(19575);
                }
            }
        }
        AppMethodBeat.m2505o(19575);
        return true;
    }
}
