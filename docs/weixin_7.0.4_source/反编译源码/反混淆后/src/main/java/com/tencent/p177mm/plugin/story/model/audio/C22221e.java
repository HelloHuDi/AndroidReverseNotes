package com.tencent.p177mm.plugin.story.model.audio;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.C30193jb;
import com.tencent.p177mm.protocal.protobuf.C30194jc;
import com.tencent.p177mm.protocal.protobuf.bts;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.audio.e */
public final class C22221e extends C37440a<C30194jc> {
    private C22221e(long j, String str, int i, long j2) {
        C25052j.m39376p(str, SearchIntents.EXTRA_QUERY);
        AppMethodBeat.m2504i(109193);
        C30193jb c30193jb = new C30193jb();
        C30194jc c30194jc = new C30194jc();
        c30194jc.setBaseResponse(new BaseResponse());
        c30194jc.getBaseResponse().ErrMsg = new bts();
        C25052j.m39375o(C1720g.m3534RN(), "MMKernel.account()");
        c30193jb.vKU = (long) C1668a.m3383QF();
        c30193jb.vKV = j;
        c30193jb.query = str;
        c30193jb.offset = i;
        c30193jb.vKW = 10;
        c30193jb.vKX = j2;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c30193jb);
        c1196a.mo4446b(c30194jc);
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/sprbgmsearch");
        c1196a.mo4447kU(3645);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(109193);
    }

    public /* synthetic */ C22221e(long j, String str, int i, long j2, byte b) {
        this(j, str, i, j2);
    }
}
