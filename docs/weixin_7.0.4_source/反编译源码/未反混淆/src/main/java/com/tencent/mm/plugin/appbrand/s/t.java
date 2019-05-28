package com.tencent.mm.plugin.appbrand.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.v2helper;

@TargetApi(3)
public final class t extends OrientationEventListener {
    private int gfQ = 45;
    private a iRL = a.NONE;
    private b iRM;

    public interface b {
        void a(a aVar, a aVar2);
    }

    public enum a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE;

        static {
            AppMethodBeat.o(126640);
        }
    }

    public t(Context context, b bVar) {
        super(context);
        this.iRM = bVar;
    }

    public final void enable() {
        AppMethodBeat.i(126641);
        super.enable();
        AppMethodBeat.o(126641);
    }

    public final void disable() {
        AppMethodBeat.i(126642);
        super.disable();
        this.iRL = a.NONE;
        AppMethodBeat.o(126642);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.i(126643);
        if (i == -1) {
            AppMethodBeat.o(126643);
            return;
        }
        a aVar = this.iRL;
        if ((i >= 360 - this.gfQ && i < v2helper.VOIP_ENC_HEIGHT_LV1) || (i >= 0 && i <= this.gfQ + 0)) {
            aVar = a.PORTRAIT;
        } else if (i >= 270 - this.gfQ && i <= this.gfQ + 270) {
            aVar = a.LANDSCAPE;
        } else if (i >= 180 - this.gfQ && i <= this.gfQ + 180) {
            aVar = a.REVERSE_PORTRAIT;
        } else if (i >= 90 - this.gfQ && i <= this.gfQ + 90) {
            aVar = a.REVERSE_LANDSCAPE;
        }
        if (aVar != this.iRL) {
            if (!(this.iRM == null || this.iRL == a.NONE)) {
                this.iRM.a(this.iRL, aVar);
            }
            this.iRL = aVar;
        }
        ab.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:".concat(String.valueOf(i)));
        AppMethodBeat.o(126643);
    }
}
