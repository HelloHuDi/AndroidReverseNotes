package com.tencent.mm.plugin.card.model.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiBatchDeleteCardInInvalid;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/BatchDeleteCardInInvalidListResponse;", "cardIds", "", "", "(Ljava/util/List;)V", "Companion", "plugin-card_release"})
public final class b extends k<hr> {
    private static String TAG = "MicroMsg.CgiBatchDeleteCardInInvalid";
    public static final a kfd = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiBatchDeleteCardInInvalid$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public b(List<String> list) {
        j.p(list, "cardIds");
        AppMethodBeat.i(89154);
        hq hqVar = new hq();
        hr hrVar = new hr();
        hqVar.vKi = new LinkedList(list);
        a(hqVar, hrVar, 2850, "/cgi-bin/mmpay-bin/mktbatchdeletecardininvalidlist");
        ab.i(TAG, "cardIds: %s", Integer.valueOf(list.size()));
        AppMethodBeat.o(89154);
    }

    static {
        AppMethodBeat.i(89155);
        AppMethodBeat.o(89155);
    }
}
