package com.tencent.p177mm.plugin.story.p1032c.p1033a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p1032c.C46271b;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import p000a.C0220l;
import p000a.p001a.C31586ag;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.c.a.d */
public final class C39867d extends C46271b<C39866a> {
    public static final C39867d rRo = new C39867d();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "Lkotlin/collections/HashSet;", "()V", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a.d$a */
    public static final class C39866a extends HashSet<C39868b> {
        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.m2504i(108969);
            if (obj instanceof C39868b) {
                boolean contains = super.contains((C39868b) obj);
                AppMethodBeat.m2505o(108969);
                return contains;
            }
            AppMethodBeat.m2505o(108969);
            return false;
        }

        public final /* bridge */ boolean remove(Object obj) {
            AppMethodBeat.m2504i(108970);
            if (obj instanceof C39868b) {
                boolean remove = super.remove((C39868b) obj);
                AppMethodBeat.m2505o(108970);
                return remove;
            }
            AppMethodBeat.m2505o(108970);
            return false;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.m2504i(108971);
            int size = super.size();
            AppMethodBeat.m2505o(108971);
            return size;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a.d$b */
    public enum C39868b {
        DEFAULT(-1),
        CONTACT_PAGE(0),
        TIMELINE_LIKE(1),
        TIMELINE_DETAIL(2),
        TIMELINE_COMMENT(3),
        TIMELINE_USER_HEAD(4),
        CHATTING_ROOM(5),
        MESSAGE_PAGE(6);
        
        private static final Map<Integer, C39868b> map = null;
        public static final C13741a rRy = null;
        private final int value;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType$Companion;", "", "()V", "map", "", "", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "fromInt", "type", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.c.a.d$b$a */
        public static final class C13741a {
            private C13741a() {
            }

            public /* synthetic */ C13741a(byte b) {
                this();
            }
        }

        private C39868b(int i) {
            this.value = i;
        }

        static {
            rRy = new C13741a();
            C39868b[] values = C39868b.values();
            Map linkedHashMap = new LinkedHashMap(C0016h.m19im(C31586ag.m51047SI(values.length), 16));
            int length = values.length;
            int i;
            while (i < length) {
                C39868b c39868b = values[i];
                linkedHashMap.put(Integer.valueOf(c39868b.value), c39868b);
                i++;
            }
            map = linkedHashMap;
            AppMethodBeat.m2505o(108972);
        }
    }

    static {
        AppMethodBeat.m2504i(108978);
        AppMethodBeat.m2505o(108978);
    }

    private C39867d() {
    }

    public static boolean aac(String str) {
        AppMethodBeat.m2504i(108975);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(108975);
            return false;
        } else if (C1855t.m3905mR(str) || C1855t.m3913mZ(str) || C1855t.m3908mU(str) || C1855t.m3909mV(str) || C1855t.m3934nc(str) || C1855t.m3935nd(str) || C1855t.m3918nD(str) || C1855t.m3923nI(str) || C1855t.m3946no(str) || C1855t.m3903mP(str) || C1855t.m3902mO(str)) {
            AppMethodBeat.m2505o(108975);
            return false;
        } else {
            AppMethodBeat.m2505o(108975);
            return true;
        }
    }

    /* renamed from: Uv */
    public final void mo25945Uv() {
        AppMethodBeat.m2504i(108977);
        ((C39866a) mo53287Ut()).clear();
        if (C46270n.isShowStoryCheck()) {
            ((C39866a) mo53287Ut()).add(C39868b.CONTACT_PAGE);
            ((C39866a) mo53287Ut()).add(C39868b.TIMELINE_LIKE);
            ((C39866a) mo53287Ut()).add(C39868b.TIMELINE_DETAIL);
            ((C39866a) mo53287Ut()).add(C39868b.TIMELINE_COMMENT);
            ((C39866a) mo53287Ut()).add(C39868b.TIMELINE_USER_HEAD);
            ((C39866a) mo53287Ut()).add(C39868b.MESSAGE_PAGE);
            ((C39866a) mo53287Ut()).add(C39868b.CHATTING_ROOM);
            AppMethodBeat.m2505o(108977);
            return;
        }
        AppMethodBeat.m2505o(108977);
    }

    /* renamed from: Uu */
    public final /* synthetic */ Object mo25944Uu() {
        AppMethodBeat.m2504i(108976);
        C39866a c39866a = new C39866a();
        AppMethodBeat.m2505o(108976);
        return c39866a;
    }
}
