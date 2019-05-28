package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.protocal.protobuf.C35939nv;
import com.tencent.p177mm.protocal.protobuf.C35940nw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.nio.charset.Charset;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.a */
public final class C45781a {
    private static final String TAG = TAG;
    public static final C27578a kfc = new C27578a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "saveHomePageSnapshot", "saveInvalidTicketPageSnapshot", "saveTicketPageSnapshot", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.a$a */
    public static final class C27578a {
        private C27578a() {
        }

        public /* synthetic */ C27578a(byte b) {
            this();
        }

        /* renamed from: a */
        public static boolean m43811a(C35939nv c35939nv, C35940nw c35940nw) {
            Charset charset;
            C44941v c44941v;
            byte[] bytes;
            boolean z = true;
            AppMethodBeat.m2504i(89152);
            C25052j.m39376p(c35939nv, "storeList");
            C25052j.m39376p(c35940nw, "underList");
            C4990ab.m7416i(C45781a.TAG, "load home page snapshot");
            boolean z2 = false;
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            String str = (String) RP.mo5239Ry().mo16822i(C5127a.USERINFO_CARD_STORE_LIST_STRING_SYNC);
            if (str != null) {
                charset = C17355d.ISO_8859_1;
                if (str == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.m2505o(89152);
                    throw c44941v;
                }
                bytes = str.getBytes(charset);
                C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
                c35939nv.parseFrom(bytes);
                z2 = true;
            }
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            str = (String) RP.mo5239Ry().mo16822i(C5127a.USERINFO_CARD_UNDER_LIST_STRING_SYNC);
            if (str != null) {
                charset = C17355d.ISO_8859_1;
                if (str == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.m2505o(89152);
                    throw c44941v;
                }
                bytes = str.getBytes(charset);
                C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
                c35940nw.parseFrom(bytes);
            } else {
                z = z2;
            }
            AppMethodBeat.m2505o(89152);
            return z;
        }
    }

    static {
        AppMethodBeat.m2504i(89153);
        AppMethodBeat.m2505o(89153);
    }
}
