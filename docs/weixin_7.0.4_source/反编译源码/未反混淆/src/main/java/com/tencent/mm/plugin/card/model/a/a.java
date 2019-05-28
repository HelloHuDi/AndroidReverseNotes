package com.tencent.mm.plugin.card.model.a;

import a.f.b.j;
import a.k.d;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.charset.Charset;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a {
    private static final String TAG = TAG;
    public static final a kfc = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "saveHomePageSnapshot", "saveInvalidTicketPageSnapshot", "saveTicketPageSnapshot", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static boolean a(nv nvVar, nw nwVar) {
            Charset charset;
            v vVar;
            byte[] bytes;
            boolean z = true;
            AppMethodBeat.i(89152);
            j.p(nvVar, "storeList");
            j.p(nwVar, "underList");
            ab.i(a.TAG, "load home page snapshot");
            boolean z2 = false;
            e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            String str = (String) RP.Ry().i(com.tencent.mm.storage.ac.a.USERINFO_CARD_STORE_LIST_STRING_SYNC);
            if (str != null) {
                charset = d.ISO_8859_1;
                if (str == null) {
                    vVar = new v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(89152);
                    throw vVar;
                }
                bytes = str.getBytes(charset);
                j.o(bytes, "(this as java.lang.String).getBytes(charset)");
                nvVar.parseFrom(bytes);
                z2 = true;
            }
            RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            str = (String) RP.Ry().i(com.tencent.mm.storage.ac.a.USERINFO_CARD_UNDER_LIST_STRING_SYNC);
            if (str != null) {
                charset = d.ISO_8859_1;
                if (str == null) {
                    vVar = new v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(89152);
                    throw vVar;
                }
                bytes = str.getBytes(charset);
                j.o(bytes, "(this as java.lang.String).getBytes(charset)");
                nwVar.parseFrom(bytes);
            } else {
                z = z2;
            }
            AppMethodBeat.o(89152);
            return z;
        }
    }

    static {
        AppMethodBeat.i(89153);
        AppMethodBeat.o(89153);
    }
}
