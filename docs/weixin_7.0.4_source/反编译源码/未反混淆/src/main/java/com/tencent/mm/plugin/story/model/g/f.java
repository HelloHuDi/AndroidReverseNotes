package com.tencent.mm.plugin.story.model.g;

import a.f.a.a;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f {
    public static final f rXY = new f();

    static {
        AppMethodBeat.i(109484);
        AppMethodBeat.o(109484);
    }

    private f() {
    }

    public static void a(j jVar, int i, String str, a<y> aVar) {
        AppMethodBeat.i(109483);
        a.f.b.j.p(jVar, "storyInfo");
        a.f.b.j.p(str, "errMsg");
        a.f.b.j.p(aVar, "block");
        ab.i("MicroMsg.StoryPostTask", "processError localId " + ((int) jVar.xDa) + " processError " + i + " errMsg: " + str);
        ab.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(i)));
        jVar.cqY();
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxT().a((int) jVar.xDa, jVar);
        com.tencent.mm.plugin.story.h.a.a aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
        if (i == com.tencent.mm.plugin.story.h.a.scR) {
            ab.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
        } else {
            aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
            if (i == com.tencent.mm.plugin.story.h.a.scS) {
                ab.e("MicroMsg.StoryPostTask", "parser protobuf error");
            } else {
                aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                if (i == com.tencent.mm.plugin.story.h.a.scT) {
                    ab.e("MicroMsg.StoryPostTask", "local id is not in db");
                } else {
                    aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                    if (i == com.tencent.mm.plugin.story.h.a.scU) {
                        ab.e("MicroMsg.StoryPostTask", "arg is error");
                    } else {
                        aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                        if (i == com.tencent.mm.plugin.story.h.a.scV) {
                            ab.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
                        } else {
                            aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                            if (i == com.tencent.mm.plugin.story.h.a.scW) {
                                ab.e("MicroMsg.StoryPostTask", "errtle  error");
                            }
                        }
                    }
                }
            }
        }
        aVar.invoke();
        AppMethodBeat.o(109483);
    }
}
