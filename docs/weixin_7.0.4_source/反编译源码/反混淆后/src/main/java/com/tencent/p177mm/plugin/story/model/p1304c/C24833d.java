package com.tencent.p177mm.plugin.story.model.p1304c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p1197h.p1198a.C18544c;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.storage.C44222az;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;Ljava/lang/String;Lcom/tencent/mm/storage/FROM_SCENE;)V", "getFromscene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setFromscene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "uniqueValue", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.c.d */
public final class C24833d implements C18544c {
    private C44222az qNW;
    cek rVQ;
    String username;

    public C24833d(cek cek, String str, C44222az c44222az) {
        C25052j.m39376p(cek, "mediaObj");
        C25052j.m39376p(c44222az, "fromscene");
        AppMethodBeat.m2504i(109300);
        this.rVQ = cek;
        this.username = str;
        this.qNW = c44222az;
        AppMethodBeat.m2505o(109300);
    }

    /* renamed from: Ui */
    public final String mo33795Ui() {
        AppMethodBeat.m2504i(109299);
        CharSequence charSequence = this.rVQ.wEH;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        String str;
        if (obj != null) {
            str = this.rVQ.f4416Id + '_' + this.qNW.tag;
            AppMethodBeat.m2505o(109299);
            return str;
        }
        str = this.rVQ.wEH + '_' + this.qNW.tag;
        AppMethodBeat.m2505o(109299);
        return str;
    }
}
