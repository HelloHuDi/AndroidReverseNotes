package com.tencent.p177mm.plugin.story.model.audio;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.anm;
import com.tencent.p177mm.protocal.protobuf.ann;
import com.tencent.p177mm.protocal.protobuf.bts;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "audioCount", "", "(Ljava/util/LinkedList;FFJI)V", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.audio.d */
public final class C22220d extends C37440a<ann> {
    public /* synthetic */ C22220d(LinkedList linkedList, float f, float f2, long j, byte b) {
        this(linkedList, f, f2, j);
    }

    private C22220d(LinkedList<C1332b> linkedList, float f, float f2, long j) {
        C25052j.m39376p(linkedList, "imageData");
        AppMethodBeat.m2504i(109192);
        anm anm = new anm();
        ann ann = new ann();
        ann.setBaseResponse(new BaseResponse());
        ann.getBaseResponse().ErrMsg = new bts();
        anm.wso = linkedList;
        anm.wsn = 10;
        anm.cEB = f;
        anm.cGm = f2;
        anm.rUb = j;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(anm);
        c1196a.mo4446b(ann);
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/getrecommendedmusiclist");
        c1196a.mo4447kU(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(109192);
    }
}
