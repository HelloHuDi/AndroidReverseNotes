package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic;", "", "()V", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.f */
public final class C13785f {
    public static final C13786a rSp = new C13786a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic$Companion;", "", "()V", "AVATAR_FLAG_DEFAULT", "", "AVATAR_FLAG_READ", "AVATAR_FLAG_UNREAD", "isStoryUnread", "", "userName", "", "updateStoryStatus", "", "storyId", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.f$a */
    public static final class C13786a {
        private C13786a() {
        }

        public /* synthetic */ C13786a(byte b) {
            this();
        }

        public static boolean isStoryUnread(String str) {
            AppMethodBeat.m2504i(109022);
            if (str == null) {
                AppMethodBeat.m2505o(109022);
                return false;
            } else if (C46270n.isShowStoryCheck()) {
                C4133a c4133a = C43644j.rST;
                C4119f aap = C4133a.cxU().aap(str);
                if (aap.isValid() && aap.cBN()) {
                    AppMethodBeat.m2505o(109022);
                    return true;
                }
                AppMethodBeat.m2505o(109022);
                return false;
            } else {
                AppMethodBeat.m2505o(109022);
                return false;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(109023);
        AppMethodBeat.m2505o(109023);
    }
}
