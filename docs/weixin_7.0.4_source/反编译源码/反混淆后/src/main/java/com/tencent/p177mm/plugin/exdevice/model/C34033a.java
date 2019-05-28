package com.tencent.p177mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C6475dz;
import com.tencent.p177mm.plugin.exdevice.service.C11658n.C11659a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.a */
public final class C34033a extends C11659a {
    private static final C34033a lqV = new C34033a();

    static {
        AppMethodBeat.m2504i(19088);
        AppMethodBeat.m2505o(19088);
    }

    private C34033a() {
    }

    public static C34033a boA() {
        return lqV;
    }

    /* renamed from: k */
    public final Bundle mo23409k(int i, Bundle bundle) {
        AppMethodBeat.m2504i(19087);
        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", Integer.valueOf(i));
        if (bundle != null) {
            switch (i) {
                case 0:
                    if (bundle == null) {
                        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
                    } else {
                        int i2 = bundle.getInt("key_state");
                        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", Integer.valueOf(i2));
                        if (-1 == i2) {
                            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
                        } else {
                            C6475dz c6475dz = new C6475dz();
                            c6475dz.cxz.cxA = i2;
                            if (!C4879a.xxA.mo10055m(c6475dz)) {
                                C4990ab.m7412e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
                            }
                        }
                    }
                    AppMethodBeat.m2505o(19087);
                    break;
                default:
                    AppMethodBeat.m2505o(19087);
                    break;
            }
        }
        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
        AppMethodBeat.m2505o(19087);
        return null;
    }
}
