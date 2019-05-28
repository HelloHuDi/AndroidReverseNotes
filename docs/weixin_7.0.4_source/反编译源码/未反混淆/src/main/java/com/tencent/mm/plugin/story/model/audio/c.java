package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqk;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, dWq = {"dump", "", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicFeedback;", "plugin-story_release"})
public final class c {
    public static final String a(bqk bqk) {
        AppMethodBeat.i(109191);
        j.p(bqk, "receiver$0");
        String str = bqk.wSJ + ' ' + bqk.wSK + ' ' + bqk.wSL + ' ' + bqk.wSM;
        AppMethodBeat.o(109191);
        return str;
    }
}
