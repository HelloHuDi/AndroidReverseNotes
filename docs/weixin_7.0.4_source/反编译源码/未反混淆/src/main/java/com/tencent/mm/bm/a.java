package com.tencent.mm.bm;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.v2helper;

@TargetApi(3)
public final class a extends OrientationEventListener {
    private a gfP = a.NONE;
    private int gfQ = 45;
    private b gfR;

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
            AppMethodBeat.o(78997);
        }
    }

    public a(Context context, b bVar) {
        super(context);
        this.gfR = bVar;
    }

    public final void enable() {
        AppMethodBeat.i(78998);
        super.enable();
        AppMethodBeat.o(78998);
    }

    public final void disable() {
        AppMethodBeat.i(78999);
        super.disable();
        this.gfP = a.NONE;
        AppMethodBeat.o(78999);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.i(79000);
        if (i == -1) {
            AppMethodBeat.o(79000);
            return;
        }
        a aVar = this.gfP;
        if ((i >= 360 - this.gfQ && i < v2helper.VOIP_ENC_HEIGHT_LV1) || (i >= 0 && i <= this.gfQ + 0)) {
            aVar = a.PORTRAIT;
        } else if (i >= 270 - this.gfQ && i <= this.gfQ + 270) {
            aVar = a.LANDSCAPE;
        } else if (i >= 180 - this.gfQ && i <= this.gfQ + 180) {
            aVar = a.REVERSE_PORTRAIT;
        } else if (i >= 90 - this.gfQ && i <= this.gfQ + 90) {
            aVar = a.REVERSE_LANDSCAPE;
        }
        if (aVar != this.gfP) {
            if (!(this.gfR == null || this.gfP == a.NONE)) {
                this.gfR.a(this.gfP, aVar);
            }
            this.gfP = aVar;
        }
        ab.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:".concat(String.valueOf(i)));
        AppMethodBeat.o(79000);
    }
}
