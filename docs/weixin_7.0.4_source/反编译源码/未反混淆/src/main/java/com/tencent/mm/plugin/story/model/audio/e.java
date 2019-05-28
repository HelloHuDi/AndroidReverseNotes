package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.protocal.protobuf.jc;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-story_release"})
public final class e extends a<jc> {
    private e(long j, String str, int i, long j2) {
        j.p(str, SearchIntents.EXTRA_QUERY);
        AppMethodBeat.i(109193);
        jb jbVar = new jb();
        jc jcVar = new jc();
        jcVar.setBaseResponse(new BaseResponse());
        jcVar.getBaseResponse().ErrMsg = new bts();
        j.o(g.RN(), "MMKernel.account()");
        jbVar.vKU = (long) com.tencent.mm.kernel.a.QF();
        jbVar.vKV = j;
        jbVar.query = str;
        jbVar.offset = i;
        jbVar.vKW = 10;
        jbVar.vKX = j2;
        b.a aVar = new b.a();
        aVar.a(jbVar);
        aVar.b(jcVar);
        aVar.qq("/cgi-bin/micromsg-bin/sprbgmsearch");
        aVar.kU(3645);
        a(aVar.acD());
        AppMethodBeat.o(109193);
    }

    public /* synthetic */ e(long j, String str, int i, long j2, byte b) {
        this(j, str, i, j2);
    }
}
