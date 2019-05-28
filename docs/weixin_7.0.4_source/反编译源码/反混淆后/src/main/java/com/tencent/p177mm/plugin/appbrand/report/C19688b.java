package com.tencent.p177mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27073r;
import com.tencent.p177mm.plugin.appbrand.p329s.C10729g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p639e.C5684a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.report.b */
public final class C19688b {

    /* renamed from: com.tencent.mm.plugin.appbrand.report.b$a */
    public static final class C19689a extends C10729g implements C5684a {
        private C25697b ivC;
        private Application izY;

        public /* synthetic */ C19689a(C25697b c25697b, byte b) {
            this(c25697b);
        }

        private C19689a(C25697b c25697b) {
            AppMethodBeat.m2504i(132543);
            this.ivC = c25697b;
            this.ivC.keep(this);
            this.izY = c25697b.getContext().getApplication();
            this.izY.registerComponentCallbacks(this);
            AppMethodBeat.m2505o(132543);
        }

        @SuppressLint({"SwitchIntDef"})
        public final void onTrimMemory(int i) {
            AppMethodBeat.m2504i(132544);
            if (this.ivC == null) {
                AppMethodBeat.m2505o(132544);
                return;
            }
            switch (i) {
                case 5:
                    break;
                case 10:
                case 15:
                    C19690c.m30506pH(i);
                    break;
            }
            C25697b c25697b = this.ivC;
            C4990ab.m7417i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", c25697b.mAppId, Boolean.valueOf(c25697b.eMP), Integer.valueOf(i));
            if (c25697b.eMP) {
                HashMap hashMap = new HashMap();
                hashMap.put("level", Integer.valueOf(i));
                new C27073r().mo61031i(c25697b.mo15032xT()).mo34958t(hashMap).aCj();
            }
            AppMethodBeat.m2505o(132544);
        }

        public final void dead() {
            AppMethodBeat.m2504i(132545);
            this.izY.unregisterComponentCallbacks(this);
            this.ivC = null;
            AppMethodBeat.m2505o(132545);
        }
    }
}
