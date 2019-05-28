package com.tencent.p177mm.plugin.card.model.p353a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bsr;
import com.tencent.p177mm.protocal.protobuf.btd;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.k */
public abstract class C11283k<_Resp extends btd> extends C37440a<_Resp> {
    /* renamed from: a */
    public final void mo22982a(bsr bsr, btd btd, int i, String str) {
        C25052j.m39376p(bsr, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        C25052j.m39376p(btd, "response");
        C25052j.m39376p(str, ShareConstants.MEDIA_URI);
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(bsr);
        c1196a.mo4446b(btd);
        c1196a.mo4447kU(i);
        c1196a.mo4450qq(str);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        mo60331a(c1196a.acD());
    }
}
