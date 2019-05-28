package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {

    public interface a {
        void aHG();

        void aHH();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.b.h$1 */
    static class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.service.d.a {
        final /* synthetic */ a ijt;
        final /* synthetic */ aa iju;

        AnonymousClass1(a aVar, aa aaVar) {
            this.ijt = aVar;
            this.iju = aaVar;
        }

        public final void d(WxaAttributes wxaAttributes) {
            AppMethodBeat.i(132044);
            if (wxaAttributes == null) {
                ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, get contact info fail");
                h.a(this.ijt);
                AppMethodBeat.o(132044);
                return;
            }
            boolean xy = wxaAttributes.ayJ().xy();
            if (!(this.iju.Cj("banJumpGame") && xy) && (!this.iju.Cj("banJumpApp") || xy)) {
                ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no need to ban jump");
                h.a(this.ijt);
                AppMethodBeat.o(132044);
                return;
            }
            ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, return should ban jump");
            a aVar = this.ijt;
            if (aVar != null) {
                aVar.aHG();
            }
            AppMethodBeat.o(132044);
        }
    }

    static void a(a aVar) {
        AppMethodBeat.i(132045);
        if (aVar != null) {
            aVar.aHH();
        }
        AppMethodBeat.o(132045);
    }
}
