package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.pluginsdk.ui.e.g;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

public final class ag implements g {
    private a cgL;

    public ag(a aVar) {
        this.cgL = aVar;
    }

    public final Object a(m mVar) {
        AppMethodBeat.i(30955);
        i.Lt(6);
        Object talkerUserName;
        switch (mVar.type) {
            case 1:
                talkerUserName = this.cgL.getTalkerUserName();
                AppMethodBeat.o(30955);
                return talkerUserName;
            case 2:
            case 6:
            case 7:
            case 9:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
                this.cgL.yTx.dBP();
                break;
            case 4:
                int lastIndexOf;
                LinkedList linkedList = new LinkedList();
                if (t.mN(this.cgL.getTalkerUserName())) {
                    lastIndexOf = mVar.url.lastIndexOf("/");
                    if (lastIndexOf >= 0) {
                        linkedList.add(mVar.url.substring(lastIndexOf + 1));
                    }
                } else {
                    linkedList.add(this.cgL.getTalkerUserName());
                }
                LinkedList linkedList2 = new LinkedList();
                for (lastIndexOf = 0; lastIndexOf < linkedList.size(); lastIndexOf++) {
                    linkedList2.add(Integer.valueOf(6));
                }
                new s(this.cgL.yTx.getContext(), new s.a() {
                    public final void bD(boolean z) {
                    }
                }).g(linkedList, linkedList2);
                break;
            case 25:
            case 30:
            case 31:
            case 33:
                talkerUserName = this.cgL.getTalkerUserName();
                AppMethodBeat.o(30955);
                return talkerUserName;
        }
        AppMethodBeat.o(30955);
        return null;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Object b(m mVar) {
        AppMethodBeat.i(30956);
        switch (mVar.type) {
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                if (aw.RK()) {
                    if (!f.kq(this.cgL.getTalkerUserName())) {
                        if (!f.rc(this.cgL.getTalkerUserName())) {
                            if (f.rb(this.cgL.getTalkerUserName())) {
                                AppMethodBeat.o(30956);
                                break;
                            }
                        }
                        AppMethodBeat.o(30956);
                        break;
                    }
                    AppMethodBeat.o(30956);
                    break;
                }
                ab.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new String(Base64.decode(mVar.url, 0)), new String(Base64.decode(bo.bc((String) mVar.au(String.class), ""), 0)));
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG;
                appBrandStatObject.cst = this.cgL.getTalkerUserName();
                ((e) com.tencent.mm.kernel.g.K(e.class)).a(this.cgL.yTx.getContext(), null, r3, 0, 0, r6, appBrandStatObject);
            default:
                AppMethodBeat.o(30956);
                break;
        }
        return null;
    }
}
