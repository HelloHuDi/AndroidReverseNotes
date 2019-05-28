package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C35963wl;
import com.tencent.p177mm.protocal.protobuf.C46596wm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.c */
public final class C27580c extends C11283k<C46596wm> {
    private static String TAG = "MicroMsg.CgiDeleteCardInInvalidList";
    public static final C27581a kfe = new C27581a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.c$a */
    public static final class C27581a {
        private C27581a() {
        }

        public /* synthetic */ C27581a(byte b) {
            this();
        }
    }

    public C27580c(String str) {
        C25052j.m39376p(str, "cardId");
        AppMethodBeat.m2504i(89156);
        C35963wl c35963wl = new C35963wl();
        C46596wm c46596wm = new C46596wm();
        c35963wl.vCb = str;
        mo22982a(c35963wl, c46596wm, 2707, "/cgi-bin/mmpay-bin/mktdeletecardininvalidlist");
        C4990ab.m7417i(TAG, "cardid: %s", str);
        AppMethodBeat.m2505o(89156);
    }

    static {
        AppMethodBeat.m2504i(89157);
        AppMethodBeat.m2505o(89157);
    }
}
