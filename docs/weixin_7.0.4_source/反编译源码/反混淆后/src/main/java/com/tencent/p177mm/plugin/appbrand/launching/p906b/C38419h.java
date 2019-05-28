package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.C27157aa;
import com.tencent.p177mm.plugin.appbrand.service.C42686d.C38509a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.h */
public final class C38419h {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.b.h$a */
    public interface C27162a {
        void aHG();

        void aHH();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.b.h$1 */
    static class C384201 implements C38509a {
        final /* synthetic */ C27162a ijt;
        final /* synthetic */ C27157aa iju;

        C384201(C27162a c27162a, C27157aa c27157aa) {
            this.ijt = c27162a;
            this.iju = c27157aa;
        }

        /* renamed from: d */
        public final void mo21701d(WxaAttributes wxaAttributes) {
            AppMethodBeat.m2504i(132044);
            if (wxaAttributes == null) {
                C4990ab.m7416i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, get contact info fail");
                C38419h.m65005a(this.ijt);
                AppMethodBeat.m2505o(132044);
                return;
            }
            boolean xy = wxaAttributes.ayJ().mo21563xy();
            if (!(this.iju.mo44828Cj("banJumpGame") && xy) && (!this.iju.mo44828Cj("banJumpApp") || xy)) {
                C4990ab.m7416i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no need to ban jump");
                C38419h.m65005a(this.ijt);
                AppMethodBeat.m2505o(132044);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, return should ban jump");
            C27162a c27162a = this.ijt;
            if (c27162a != null) {
                c27162a.aHG();
            }
            AppMethodBeat.m2505o(132044);
        }
    }

    /* renamed from: a */
    static void m65005a(C27162a c27162a) {
        AppMethodBeat.m2504i(132045);
        if (c27162a != null) {
            c27162a.aHH();
        }
        AppMethodBeat.m2505o(132045);
    }
}
