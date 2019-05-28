package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C44126hq;
import com.tencent.p177mm.protocal.protobuf.C44127hr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiBatchDeleteCardInInvalid;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/BatchDeleteCardInInvalidListResponse;", "cardIds", "", "", "(Ljava/util/List;)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.b */
public final class C42846b extends C11283k<C44127hr> {
    private static String TAG = "MicroMsg.CgiBatchDeleteCardInInvalid";
    public static final C27579a kfd = new C27579a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiBatchDeleteCardInInvalid$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.b$a */
    public static final class C27579a {
        private C27579a() {
        }

        public /* synthetic */ C27579a(byte b) {
            this();
        }
    }

    public C42846b(List<String> list) {
        C25052j.m39376p(list, "cardIds");
        AppMethodBeat.m2504i(89154);
        C44126hq c44126hq = new C44126hq();
        C44127hr c44127hr = new C44127hr();
        c44126hq.vKi = new LinkedList(list);
        mo22982a(c44126hq, c44127hr, 2850, "/cgi-bin/mmpay-bin/mktbatchdeletecardininvalidlist");
        C4990ab.m7417i(TAG, "cardIds: %s", Integer.valueOf(list.size()));
        AppMethodBeat.m2505o(89154);
    }

    static {
        AppMethodBeat.m2504i(89155);
        AppMethodBeat.m2505o(89155);
    }
}
