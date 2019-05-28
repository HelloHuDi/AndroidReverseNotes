package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p297h.C45565p;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21287f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.d */
final class C33271d implements C21287f {
    final C45565p hGU = ((C45565p) this.hzz.aBx().mo14970af(C45565p.class));
    boolean hGV;
    int hGW = C8415j.INVALID_ID;
    private final C2241c hzz;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.d$a */
    public class C19352a extends C42467ah {
        private static final int CTRL_INDEX = 637;
        public static final String NAME = "onCameraFrame";
    }

    public C33271d(C2241c c2241c) {
        AppMethodBeat.m2504i(130968);
        this.hzz = c2241c;
        AppMethodBeat.m2505o(130968);
    }

    /* renamed from: a */
    public final void mo53797a(MMSightRecordView mMSightRecordView) {
        AppMethodBeat.m2504i(130969);
        this.hGV = false;
        if (mMSightRecordView != null) {
            mMSightRecordView.mo36650a(null, null);
        }
        if (this.hGW != C8415j.INVALID_ID) {
            this.hGU.mo30584oQ(this.hGW);
            this.hGW = C8415j.INVALID_ID;
        }
        AppMethodBeat.m2505o(130969);
    }

    public final void aDr() {
        AppMethodBeat.m2504i(130970);
        if (this.hGV) {
            this.hzz.mo6108a(new C19352a());
            AppMethodBeat.m2505o(130970);
            return;
        }
        C4990ab.m7416i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
        AppMethodBeat.m2505o(130970);
    }
}
