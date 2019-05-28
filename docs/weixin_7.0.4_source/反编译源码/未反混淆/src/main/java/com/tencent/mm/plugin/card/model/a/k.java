package com.tencent.mm.plugin.card.model.a;

import a.f.b.j;
import a.l;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.btd;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
public abstract class k<_Resp extends btd> extends a<_Resp> {
    public final void a(bsr bsr, btd btd, int i, String str) {
        j.p(bsr, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        j.p(btd, "response");
        j.p(str, ShareConstants.MEDIA_URI);
        b.a aVar = new b.a();
        aVar.a(bsr);
        aVar.b(btd);
        aVar.kU(i);
        aVar.qq(str);
        aVar.kV(0);
        aVar.kW(0);
        a(aVar.acD());
    }
}
