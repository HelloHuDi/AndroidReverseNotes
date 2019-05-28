package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.p;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.ab;

final class d implements f {
    final p hGU = ((p) this.hzz.aBx().af(p.class));
    boolean hGV;
    int hGW = j.INVALID_ID;
    private final c hzz;

    public class a extends ah {
        private static final int CTRL_INDEX = 637;
        public static final String NAME = "onCameraFrame";
    }

    public d(c cVar) {
        AppMethodBeat.i(130968);
        this.hzz = cVar;
        AppMethodBeat.o(130968);
    }

    public final void a(MMSightRecordView mMSightRecordView) {
        AppMethodBeat.i(130969);
        this.hGV = false;
        if (mMSightRecordView != null) {
            mMSightRecordView.a(null, null);
        }
        if (this.hGW != j.INVALID_ID) {
            this.hGU.oQ(this.hGW);
            this.hGW = j.INVALID_ID;
        }
        AppMethodBeat.o(130969);
    }

    public final void aDr() {
        AppMethodBeat.i(130970);
        if (this.hGV) {
            this.hzz.a(new a());
            AppMethodBeat.o(130970);
            return;
        }
        ab.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
        AppMethodBeat.o(130970);
    }
}
