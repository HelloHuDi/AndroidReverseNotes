package com.tencent.mm.plugin.story.h;

import a.l;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ep;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J$\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_UNREAD", "", "commentFlagSet", "Ljava/util/ArrayList;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "buildLimitString", "data", "", "col", "reverse", "", "getAllData", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getAllUnreadSync", "getByStoryId", "storyId", "", "getORIntRange", "Companion", "plugin-story_release"})
public final class b extends j<ep> {
    private static final String TAG = TAG;
    private static final String[] fnj;
    public static final String sdC = sdC;
    public static final a sdD = new a();
    public final e bSd;
    private final ArrayList<Integer> sdA;
    public String sdB;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R!\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00070\u00070\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage$Companion;", "", "()V", "EventNotifyCommentRead", "", "EventNotifyCommentUnread", "NotifyCommentRead", "", "NotifyCommentUnread", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SqlSelectAll", "TAG", "Table", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public b(e eVar) {
        Iterator it;
        a.f.b.j.p(eVar, UserDataStore.DATE_OF_BIRTH);
        com.tencent.mm.plugin.story.h.c.a aVar = c.sdE;
        super(eVar, c.ccO, "StoryCommentSync", ep.diI);
        AppMethodBeat.i(109857);
        this.bSd = eVar;
        Integer[] numArr = new Integer[1];
        com.tencent.mm.plugin.story.h.a.b bVar = com.tencent.mm.plugin.story.h.a.b.sdo;
        numArr[0] = Integer.valueOf(com.tencent.mm.plugin.story.h.a.b.cBt());
        List asList = Arrays.asList(numArr);
        a.f.b.j.o(asList, "Arrays.asList(ConstantsS…COMMENT_SYNC_FLAG_UNREAD)");
        a.f.b.j.p(asList, "data");
        ArrayList arrayList = new ArrayList(asList);
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            arrayList = new ArrayList();
            it = hashSet.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                a.f.b.j.o(num, "i");
                arrayList.add(Integer.valueOf(intValue | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList));
            hashSet.add(num);
        }
        hashSet.add(Integer.valueOf(0));
        arrayList2.addAll(hashSet);
        this.sdA = arrayList2;
        this.sdB = "";
        arrayList = new ArrayList();
        it = this.sdA.iterator();
        while (it.hasNext()) {
            Integer num2 = (Integer) it.next();
            int intValue2 = num2.intValue();
            com.tencent.mm.plugin.story.h.a.b bVar2 = com.tencent.mm.plugin.story.h.a.b.sdo;
            if ((intValue2 & com.tencent.mm.plugin.story.h.a.b.cBt()) != 0) {
                arrayList.add(num2);
            }
        }
        com.tencent.mm.plugin.story.h.k.a aVar2 = k.sek;
        this.sdB = com.tencent.mm.plugin.story.h.k.a.f(arrayList, "commentFlag");
        AppMethodBeat.o(109857);
    }

    static {
        AppMethodBeat.i(109858);
        String[] strArr = new String[1];
        com.tencent.mm.plugin.story.h.c.a aVar = c.sdE;
        strArr[0] = j.a(c.ccO, "StoryCommentSync");
        fnj = strArr;
        AppMethodBeat.o(109858);
    }

    public final c lr(long j) {
        c cVar = null;
        AppMethodBeat.i(109855);
        Cursor rawQuery = this.bSd.rawQuery("select * from StoryCommentSync  where storyId = " + j + ' ', null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.d(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(109855);
        return cVar;
    }

    public final List<c> cBC() {
        AppMethodBeat.i(109856);
        String str = sdC;
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                c cVar = new c();
                cVar.d(rawQuery);
                arrayList.add(cVar);
            }
            rawQuery.close();
        }
        List list = arrayList;
        AppMethodBeat.o(109856);
        return list;
    }
}
