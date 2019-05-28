package com.tencent.p177mm.plugin.story.p530f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "", "username", "", "(Ljava/lang/String;)V", "dataState", "", "getDataState", "()I", "setDataState", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.g */
public final class C46272g {
    public static final C29289a rZw = new C29289a();
    int rZv;
    private String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/GalleryUserState$Companion;", "", "()V", "DataStateFailed", "", "DataStateLoaded", "DataStateNone", "DataStatePreload", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.g$a */
    public static final class C29289a {
        private C29289a() {
        }

        public /* synthetic */ C29289a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(109579);
        AppMethodBeat.m2505o(109579);
    }

    public C46272g(String str) {
        C25052j.m39376p(str, "username");
        AppMethodBeat.m2504i(109578);
        this.username = str;
        AppMethodBeat.m2505o(109578);
    }
}
