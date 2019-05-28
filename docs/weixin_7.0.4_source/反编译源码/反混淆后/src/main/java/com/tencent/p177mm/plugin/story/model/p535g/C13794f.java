package com.tencent.p177mm.plugin.story.model.p535g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.g.f */
public final class C13794f {
    public static final C13794f rXY = new C13794f();

    static {
        AppMethodBeat.m2504i(109484);
        AppMethodBeat.m2505o(109484);
    }

    private C13794f() {
    }

    /* renamed from: a */
    public static void m21945a(C39879j c39879j, int i, String str, C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(109483);
        C25052j.m39376p(c39879j, "storyInfo");
        C25052j.m39376p(str, "errMsg");
        C25052j.m39376p(c31214a, "block");
        C4990ab.m7416i("MicroMsg.StoryPostTask", "processError localId " + ((int) c39879j.xDa) + " processError " + i + " errMsg: " + str);
        C4990ab.m7410d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(i)));
        c39879j.cqY();
        C4133a c4133a = C43644j.rST;
        C4133a.cxT().mo74398a((int) c39879j.xDa, c39879j);
        C35184a c35184a = C35183a.sdm;
        if (i == C35183a.scR) {
            C4990ab.m7412e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
        } else {
            c35184a = C35183a.sdm;
            if (i == C35183a.scS) {
                C4990ab.m7412e("MicroMsg.StoryPostTask", "parser protobuf error");
            } else {
                c35184a = C35183a.sdm;
                if (i == C35183a.scT) {
                    C4990ab.m7412e("MicroMsg.StoryPostTask", "local id is not in db");
                } else {
                    c35184a = C35183a.sdm;
                    if (i == C35183a.scU) {
                        C4990ab.m7412e("MicroMsg.StoryPostTask", "arg is error");
                    } else {
                        c35184a = C35183a.sdm;
                        if (i == C35183a.scV) {
                            C4990ab.m7412e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
                        } else {
                            c35184a = C35183a.sdm;
                            if (i == C35183a.scW) {
                                C4990ab.m7412e("MicroMsg.StoryPostTask", "errtle  error");
                            }
                        }
                    }
                }
            }
        }
        c31214a.invoke();
        AppMethodBeat.m2505o(109483);
    }
}
