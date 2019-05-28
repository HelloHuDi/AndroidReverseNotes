package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.plugin.exdevice.service.n.a {
    private static final a lqV = new a();

    static {
        AppMethodBeat.i(19088);
        AppMethodBeat.o(19088);
    }

    private a() {
    }

    public static a boA() {
        return lqV;
    }

    public final Bundle k(int i, Bundle bundle) {
        AppMethodBeat.i(19087);
        ab.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", Integer.valueOf(i));
        if (bundle != null) {
            switch (i) {
                case 0:
                    if (bundle == null) {
                        ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
                    } else {
                        int i2 = bundle.getInt("key_state");
                        ab.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", Integer.valueOf(i2));
                        if (-1 == i2) {
                            ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
                        } else {
                            dz dzVar = new dz();
                            dzVar.cxz.cxA = i2;
                            if (!com.tencent.mm.sdk.b.a.xxA.m(dzVar)) {
                                ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
                            }
                        }
                    }
                    AppMethodBeat.o(19087);
                    break;
                default:
                    AppMethodBeat.o(19087);
                    break;
            }
        }
        ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
        AppMethodBeat.o(19087);
        return null;
    }
}
