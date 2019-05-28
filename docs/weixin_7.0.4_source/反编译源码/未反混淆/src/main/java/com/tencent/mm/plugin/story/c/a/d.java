package com.tencent.mm.plugin.story.c.a;

import a.a.ag;
import a.h.h;
import a.l;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.n;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d extends com.tencent.mm.plugin.story.c.b<a> {
    public static final d rRo = new d();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "Lkotlin/collections/HashSet;", "()V", "plugin-story_release"})
    public static final class a extends HashSet<b> {
        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(108969);
            if (obj instanceof b) {
                boolean contains = super.contains((b) obj);
                AppMethodBeat.o(108969);
                return contains;
            }
            AppMethodBeat.o(108969);
            return false;
        }

        public final /* bridge */ boolean remove(Object obj) {
            AppMethodBeat.i(108970);
            if (obj instanceof b) {
                boolean remove = super.remove((b) obj);
                AppMethodBeat.o(108970);
                return remove;
            }
            AppMethodBeat.o(108970);
            return false;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(108971);
            int size = super.size();
            AppMethodBeat.o(108971);
            return size;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"})
    public enum b {
        DEFAULT(-1),
        CONTACT_PAGE(0),
        TIMELINE_LIKE(1),
        TIMELINE_DETAIL(2),
        TIMELINE_COMMENT(3),
        TIMELINE_USER_HEAD(4),
        CHATTING_ROOM(5),
        MESSAGE_PAGE(6);
        
        private static final Map<Integer, b> map = null;
        public static final a rRy = null;
        private final int value;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType$Companion;", "", "()V", "map", "", "", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "fromInt", "type", "plugin-story_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        private b(int i) {
            this.value = i;
        }

        static {
            rRy = new a();
            b[] values = values();
            Map linkedHashMap = new LinkedHashMap(h.im(ag.SI(values.length), 16));
            int length = values.length;
            int i;
            while (i < length) {
                b bVar = values[i];
                linkedHashMap.put(Integer.valueOf(bVar.value), bVar);
                i++;
            }
            map = linkedHashMap;
            AppMethodBeat.o(108972);
        }
    }

    static {
        AppMethodBeat.i(108978);
        AppMethodBeat.o(108978);
    }

    private d() {
    }

    public static boolean aac(String str) {
        AppMethodBeat.i(108975);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(108975);
            return false;
        } else if (t.mR(str) || t.mZ(str) || t.mU(str) || t.mV(str) || t.nc(str) || t.nd(str) || t.nD(str) || t.nI(str) || t.no(str) || t.mP(str) || t.mO(str)) {
            AppMethodBeat.o(108975);
            return false;
        } else {
            AppMethodBeat.o(108975);
            return true;
        }
    }

    public final void Uv() {
        AppMethodBeat.i(108977);
        ((a) Ut()).clear();
        if (n.isShowStoryCheck()) {
            ((a) Ut()).add(b.CONTACT_PAGE);
            ((a) Ut()).add(b.TIMELINE_LIKE);
            ((a) Ut()).add(b.TIMELINE_DETAIL);
            ((a) Ut()).add(b.TIMELINE_COMMENT);
            ((a) Ut()).add(b.TIMELINE_USER_HEAD);
            ((a) Ut()).add(b.MESSAGE_PAGE);
            ((a) Ut()).add(b.CHATTING_ROOM);
            AppMethodBeat.o(108977);
            return;
        }
        AppMethodBeat.o(108977);
    }

    public final /* synthetic */ Object Uu() {
        AppMethodBeat.i(108976);
        a aVar = new a();
        AppMethodBeat.o(108976);
        return aVar;
    }
}
