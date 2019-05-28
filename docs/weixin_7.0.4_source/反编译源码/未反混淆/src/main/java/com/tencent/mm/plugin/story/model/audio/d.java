package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.bts;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "audioCount", "", "(Ljava/util/LinkedList;FFJI)V", "plugin-story_release"})
public final class d extends a<ann> {
    public /* synthetic */ d(LinkedList linkedList, float f, float f2, long j, byte b) {
        this(linkedList, f, f2, j);
    }

    private d(LinkedList<b> linkedList, float f, float f2, long j) {
        j.p(linkedList, "imageData");
        AppMethodBeat.i(109192);
        anm anm = new anm();
        ann ann = new ann();
        ann.setBaseResponse(new BaseResponse());
        ann.getBaseResponse().ErrMsg = new bts();
        anm.wso = linkedList;
        anm.wsn = 10;
        anm.cEB = f;
        anm.cGm = f2;
        anm.rUb = j;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(anm);
        aVar.b(ann);
        aVar.qq("/cgi-bin/micromsg-bin/getrecommendedmusiclist");
        aVar.kU(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
        a(aVar.acD());
        AppMethodBeat.o(109192);
    }
}
