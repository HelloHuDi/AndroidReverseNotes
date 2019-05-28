package com.tencent.p177mm.p612ui.chatting;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23275s;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23275s.C23280a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44086g;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.ag */
public final class C44800ag implements C44086g {
    private C46650a cgL;

    /* renamed from: com.tencent.mm.ui.chatting.ag$1 */
    class C155751 implements C23280a {
        C155751() {
        }

        /* renamed from: bD */
        public final void mo27248bD(boolean z) {
        }
    }

    public C44800ag(C46650a c46650a) {
        this.cgL = c46650a;
    }

    /* renamed from: a */
    public final Object mo27726a(C14932m c14932m) {
        AppMethodBeat.m2504i(30955);
        C14991i.m23324Lt(6);
        Object talkerUserName;
        switch (c14932m.type) {
            case 1:
                talkerUserName = this.cgL.getTalkerUserName();
                AppMethodBeat.m2505o(30955);
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
                if (C1855t.m3901mN(this.cgL.getTalkerUserName())) {
                    lastIndexOf = c14932m.url.lastIndexOf("/");
                    if (lastIndexOf >= 0) {
                        linkedList.add(c14932m.url.substring(lastIndexOf + 1));
                    }
                } else {
                    linkedList.add(this.cgL.getTalkerUserName());
                }
                LinkedList linkedList2 = new LinkedList();
                for (lastIndexOf = 0; lastIndexOf < linkedList.size(); lastIndexOf++) {
                    linkedList2.add(Integer.valueOf(6));
                }
                new C23275s(this.cgL.yTx.getContext(), new C155751()).mo38981g(linkedList, linkedList2);
                break;
            case 25:
            case 30:
            case 31:
            case 33:
                talkerUserName = this.cgL.getTalkerUserName();
                AppMethodBeat.m2505o(30955);
                return talkerUserName;
        }
        AppMethodBeat.m2505o(30955);
        return null;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final Object mo27727b(C14932m c14932m) {
        AppMethodBeat.m2504i(30956);
        switch (c14932m.type) {
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                if (C9638aw.m17179RK()) {
                    if (!C17903f.m28103kq(this.cgL.getTalkerUserName())) {
                        if (!C17903f.m28109rc(this.cgL.getTalkerUserName())) {
                            if (C17903f.m28108rb(this.cgL.getTalkerUserName())) {
                                AppMethodBeat.m2505o(30956);
                                break;
                            }
                        }
                        AppMethodBeat.m2505o(30956);
                        break;
                    }
                    AppMethodBeat.m2505o(30956);
                    break;
                }
                C4990ab.m7417i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new String(Base64.decode(c14932m.url, 0)), new String(Base64.decode(C5046bo.m7532bc((String) c14932m.mo27270au(String.class), ""), 0)));
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG;
                appBrandStatObject.cst = this.cgL.getTalkerUserName();
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(this.cgL.yTx.getContext(), null, r3, 0, 0, r6, appBrandStatObject);
            default:
                AppMethodBeat.m2505o(30956);
                break;
        }
        return null;
    }
}
