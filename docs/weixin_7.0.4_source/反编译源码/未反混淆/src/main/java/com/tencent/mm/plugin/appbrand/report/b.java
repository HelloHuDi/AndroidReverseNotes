package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b {

    public static final class a extends g implements com.tencent.mm.vending.e.a {
        private com.tencent.luggage.sdk.b.b ivC;
        private Application izY;

        public /* synthetic */ a(com.tencent.luggage.sdk.b.b bVar, byte b) {
            this(bVar);
        }

        private a(com.tencent.luggage.sdk.b.b bVar) {
            AppMethodBeat.i(132543);
            this.ivC = bVar;
            this.ivC.keep(this);
            this.izY = bVar.getContext().getApplication();
            this.izY.registerComponentCallbacks(this);
            AppMethodBeat.o(132543);
        }

        @SuppressLint({"SwitchIntDef"})
        public final void onTrimMemory(int i) {
            AppMethodBeat.i(132544);
            if (this.ivC == null) {
                AppMethodBeat.o(132544);
                return;
            }
            switch (i) {
                case 5:
                    break;
                case 10:
                case 15:
                    c.pH(i);
                    break;
            }
            com.tencent.luggage.sdk.b.b bVar = this.ivC;
            ab.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", bVar.mAppId, Boolean.valueOf(bVar.eMP), Integer.valueOf(i));
            if (bVar.eMP) {
                HashMap hashMap = new HashMap();
                hashMap.put("level", Integer.valueOf(i));
                new r().i(bVar.xT()).t(hashMap).aCj();
            }
            AppMethodBeat.o(132544);
        }

        public final void dead() {
            AppMethodBeat.i(132545);
            this.izY.unregisterComponentCallbacks(this);
            this.ivC = null;
            AppMethodBeat.o(132545);
        }
    }
}
