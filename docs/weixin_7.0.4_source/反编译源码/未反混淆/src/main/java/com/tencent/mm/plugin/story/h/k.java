package com.tencent.mm.plugin.story.h;

import a.l;
import a.y;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.h.a.c;
import com.tencent.mm.plugin.story.model.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b@\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0012J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010)\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\bJ\u0016\u0010,\u001a\u00020&2\u0006\u0010$\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u001eJ\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0012J\b\u00100\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020\bH\u0016J\u0013\u00102\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J&\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010*\u001a\u00020\b2\u0006\u00104\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u0012J\u0010\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0012J\u0010\u00107\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J.\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010/\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020&J\u0010\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u001eH\u0002J\u0012\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010=\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0016\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012J&\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\b\u0012\u0004\u0012\u00020\u0002`\u00132\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J.\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u00104\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u0012J$\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0012J\u0016\u0010C\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0012J\u0016\u0010F\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J\b\u0010G\u001a\u0004\u0018\u00010\u0002J&\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010J\u001a\u00020&J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u00104\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u0012J\u0010\u0010L\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u001eJ\u000e\u0010M\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ&\u0010N\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J(\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020&2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010Q\u001a\u00020&H\u0002J\u000e\u0010R\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010S\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010T\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010U\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0016\u0010V\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u0002J\u0016\u0010X\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u0002J\u0012\u0010Z\u001a\u00020&2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010[\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u0002J\u0018\u0010\\\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u0002H\u0016J\u0016\u0010]\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u0002J \u0010_\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0002J\u0016\u0010a\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010b\u001a\u00020\u0012J\u0016\u0010c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\u000f0\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0006¨\u0006f"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "deleteStoryByIdBefore", "id", "deleteStoryByTimeBefore", "timeStamp", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "excludePrivacy", "getCDAboveExcudeSeq", "seq", "getCDBelowExculdeSeq", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isPcIdExist", "isStoryIdExist", "removeDelList", "replaceStoryId", "storyInfo", "replaceUserByPcId", "snsInfo", "seqAvailable", "set", "update", "updateByLocal", "storyinfo", "updateFilterUserName", "conSql", "updateStoryFavorite", "favorite", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"})
public final class k extends j<j> {
    public static final String TAG = TAG;
    private static final String[] diI;
    private static final String[] fnj;
    public static String rfn = (" order by " + sdP + ".createTime desc");
    private static String rfw = null;
    private static String rfx = null;
    public static final String sdP = sdP;
    private static final String see = see;
    private static String sef = (" order by " + sdP + ".favoriteTime asc");
    public static final String seg = seg;
    private static String seh;
    private static String sei;
    private static String sej;
    public static final a sek = new a();
    public final e bSd;
    private final ArrayList<Integer> rfA;
    private final ArrayList<Integer> rfB;
    private String rfs;
    private String rft;
    private e sdO;
    private final String seb = " (storyID != 0 ) ";
    private final ArrayList<Integer> sec;
    private final List<String> sed;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$2\u0006\u0010%\u001a\u00020\u0004J$\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'J$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u000b0)j\b\u0012\u0004\u0012\u00020\u000b`*2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R!\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00040\u00040\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\u000fR\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u000e\u0010!\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage$Companion;", "", "()V", "CON_FAVORITE", "", "CON_HISTORY", "CON_NOT_VISIBLE_SELF", "CON_OTHERS", "CON_STORY_ID", "CON_USER", "EventNotifyStoryInfoDelete", "", "INDEX_CREATE", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "NotifyStoryInfoDelete", "ORDER_BY_FAV_SEQ", "getORDER_BY_FAV_SEQ", "()Ljava/lang/String;", "setORDER_BY_FAV_SEQ", "(Ljava/lang/String;)V", "ORDER_BY_SEQ", "getORDER_BY_SEQ", "setORDER_BY_SEQ", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "STORYINFO_SELECT_BEGIN", "STORYINFO_SELECT_COUNT", "TABLE", "getTABLE", "TAG", "buildLimitString", "data", "", "col", "reverse", "", "getORIntRange", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static String f(List<Integer> list, String str) {
            AppMethodBeat.i(109929);
            a.f.b.j.p(list, "data");
            a.f.b.j.p(str, "col");
            String b = b(list, str, false);
            AppMethodBeat.o(109929);
            return b;
        }

        public static String b(List<Integer> list, String str, boolean z) {
            AppMethodBeat.i(109930);
            a.f.b.j.p(list, "data");
            a.f.b.j.p(str, "col");
            StringBuilder stringBuilder = new StringBuilder("(");
            if (z) {
                stringBuilder.append(str + " not in (");
            } else {
                stringBuilder.append(str + " in (");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Number) it.next()).intValue());
                if (it.hasNext()) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append(")");
            stringBuilder.append(")");
            String stringBuilder2 = stringBuilder.toString();
            a.f.b.j.o(stringBuilder2, "sb.toString()");
            AppMethodBeat.o(109930);
            return stringBuilder2;
        }

        public static ArrayList<Integer> dm(List<Integer> list) {
            AppMethodBeat.i(109931);
            a.f.b.j.p(list, "data");
            ArrayList arrayList = new ArrayList(list);
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    int intValue = ((Integer) it2.next()).intValue();
                    a.f.b.j.o(num, "i");
                    arrayList3.add(Integer.valueOf(intValue | num.intValue()));
                }
                hashSet.addAll(new HashSet(arrayList3));
                hashSet.add(num);
            }
            hashSet.add(Integer.valueOf(0));
            arrayList2.addAll(hashSet);
            AppMethodBeat.o(109931);
            return arrayList2;
        }
    }

    public k(e eVar) {
        Integer num;
        int intValue;
        c cVar;
        com.tencent.mm.plugin.story.h.a.a aVar;
        a.f.b.j.p(eVar, "vdb");
        com.tencent.mm.plugin.story.h.j.a aVar2 = j.sea;
        super(eVar, j.ccO, sdP, diI);
        AppMethodBeat.i(109964);
        this.sdO = eVar;
        Integer[] numArr = new Integer[3];
        c cVar2 = c.sds;
        numArr[0] = Integer.valueOf(c.cBu());
        cVar2 = c.sds;
        numArr[1] = Integer.valueOf(c.cBv());
        cVar2 = c.sds;
        numArr[2] = Integer.valueOf(c.cBw());
        List asList = Arrays.asList(numArr);
        a.f.b.j.o(asList, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
        this.rfA = a.dm(asList);
        numArr = new Integer[3];
        com.tencent.mm.plugin.story.h.a.a aVar3 = a.sdm;
        numArr[0] = Integer.valueOf(a.scw);
        aVar3 = a.sdm;
        numArr[1] = Integer.valueOf(a.scx);
        aVar3 = a.sdm;
        numArr[2] = Integer.valueOf(a.scy);
        asList = Arrays.asList(numArr);
        a.f.b.j.o(asList, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
        this.rfB = a.dm(asList);
        numArr = new Integer[2];
        aVar3 = a.sdm;
        numArr[0] = Integer.valueOf(a.sdd);
        aVar3 = a.sdm;
        numArr[1] = Integer.valueOf(a.sde);
        asList = Arrays.asList(numArr);
        a.f.b.j.o(asList, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
        this.sec = a.dm(asList);
        this.bSd = this.sdO;
        this.sed = Collections.synchronizedList(new ArrayList());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.rfA.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            cVar = c.sds;
            if ((intValue & c.cBu()) != 0) {
                intValue = num.intValue();
                cVar = c.sds;
                if ((intValue & c.cBv()) == 0) {
                    arrayList.add(num);
                }
            }
        }
        this.rfs = a.f(arrayList, "localFlag");
        arrayList.clear();
        it = this.rfB.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            aVar = a.sdm;
            if ((intValue & a.scw) != 0) {
                arrayList.add(num);
            }
        }
        rfw = a.f(arrayList, "sourceType");
        arrayList.clear();
        it = this.rfB.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            aVar = a.sdm;
            if ((intValue & a.scx) != 0) {
                arrayList.add(num);
            }
        }
        rfx = a.f(arrayList, "sourceType");
        arrayList.clear();
        it = this.rfA.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            cVar = c.sds;
            if ((intValue & c.cBv()) != 0) {
                arrayList.add(num);
            }
        }
        this.rft = a.f(arrayList, "localFlag");
        arrayList.clear();
        it = this.rfB.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            aVar = a.sdm;
            if ((intValue & a.scy) != 0) {
                arrayList.add(num);
            }
        }
        sei = a.f(arrayList, "sourceType");
        arrayList.clear();
        it = this.sec.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            aVar = a.sdm;
            if ((intValue & a.sdd) != 0) {
                arrayList.add(num);
            }
        }
        seh = a.b(arrayList, "itemStoryFlag", true);
        arrayList.clear();
        it = this.sec.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            aVar = a.sdm;
            if ((intValue & a.sde) != 0) {
                arrayList.add(num);
            }
        }
        sej = a.f(arrayList, "itemStoryFlag");
        AppMethodBeat.o(109964);
    }

    public final void aba(String str) {
        AppMethodBeat.i(109932);
        a.f.b.j.p(str, "localId");
        this.sed.add(str);
        AppMethodBeat.o(109932);
    }

    public final boolean abb(String str) {
        AppMethodBeat.i(109933);
        a.f.b.j.p(str, "localId");
        boolean z = false;
        List list = this.sed;
        a.f.b.j.o(list, "delList");
        Iterable<String> iterable = list;
        synchronized (iterable) {
            try {
                for (String j : iterable) {
                    boolean z2;
                    if (a.f.b.j.j(j, str)) {
                        z2 = true;
                        ab.i(TAG, "wo wo wo ".concat(String.valueOf(str)));
                    } else {
                        z2 = z;
                    }
                    z = z2;
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(109933);
            }
        }
        return z;
    }

    static {
        AppMethodBeat.i(109965);
        r0 = new String[3];
        StringBuilder stringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        com.tencent.mm.plugin.story.h.j.a aVar = j.sea;
        r0[0] = stringBuilder.append(j.sdX).append(" ON ").append(sdP).append(" ( storyID )").toString();
        stringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        aVar = j.sea;
        r0[1] = stringBuilder.append(j.sdY).append(" ON ").append(sdP).append(" (userName,storyID, createTime)").toString();
        StringBuilder stringBuilder2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        com.tencent.mm.plugin.story.h.j.a aVar2 = j.sea;
        r0[2] = stringBuilder2.append(j.sdZ).append(" ON ").append(sdP).append(" (userName, createTime)").toString();
        diI = r0;
        r0 = new String[1];
        com.tencent.mm.plugin.story.h.j.a aVar3 = j.sea;
        r0[0] = j.a(j.ccO, sdP);
        fnj = r0;
        AppMethodBeat.o(109965);
    }

    public final boolean a(long j, j jVar) {
        AppMethodBeat.i(138843);
        a.f.b.j.p(jVar, "storyInfo");
        if (lu(j)) {
            boolean b = b(j, jVar);
            AppMethodBeat.o(138843);
            return b;
        } else if (d(jVar) != -1) {
            AppMethodBeat.o(138843);
            return true;
        } else {
            AppMethodBeat.o(138843);
            return false;
        }
    }

    private long k(String str, long j, int i) {
        AppMethodBeat.i(109934);
        a.f.b.j.p(str, "baseSql");
        if (j != 0) {
            str = str + " AND " + sdP + ".storyID < '" + j + '\'';
        }
        String str2 = str + rfn + " limit " + i;
        ab.d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(str2)));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        if (rawQuery.moveToLast()) {
            j jVar = new j();
            a.f.b.j.o(rawQuery, "cu");
            jVar.d(rawQuery);
            rawQuery.close();
            long j2 = jVar.field_storyID;
            AppMethodBeat.o(109934);
            return j2;
        }
        rawQuery.close();
        AppMethodBeat.o(109934);
        return 0;
    }

    public final boolean b(long j, j jVar) {
        AppMethodBeat.i(109935);
        a.f.b.j.p(jVar, "storyInfo");
        if (this.bSd.update(sdP, jVar.Hl(), "storyID=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.o(109935);
            return true;
        }
        AppMethodBeat.o(109935);
        return false;
    }

    public final int d(j jVar) {
        AppMethodBeat.i(109937);
        a.f.b.j.p(jVar, "storyInfo");
        ab.d(TAG, "storyInfo Insert");
        int insert = (int) this.bSd.insert(sdP, "", jVar.Hl());
        ab.d(TAG, "StoryInfo Insert result ".concat(String.valueOf(insert)));
        AppMethodBeat.o(109937);
        return insert;
    }

    public final j lt(long j) {
        AppMethodBeat.i(109938);
        j jVar = new j();
        Cursor a = this.bSd.a("select *,rowid from MMStoryInfo  where " + sdP + ".storyID=" + j + " limit 1", null, 2);
        if (a.moveToFirst()) {
            a.f.b.j.o(a, "cu");
            jVar.d(a);
            a.close();
            AppMethodBeat.o(109938);
            return jVar;
        }
        a.close();
        AppMethodBeat.o(109938);
        return null;
    }

    private boolean lu(long j) {
        AppMethodBeat.i(138844);
        Cursor rawQuery = this.bSd.rawQuery("select *,rowid from MMStoryInfo  where " + sdP + ".storyID = " + j, null);
        a.f.b.j.o(rawQuery, "cu");
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.o(138844);
            return true;
        }
        AppMethodBeat.o(138844);
        return false;
    }

    public final j cCc() {
        AppMethodBeat.i(109939);
        int aaF = cb.aaF() - 86400;
        j jVar = new j();
        StringBuilder append = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.rfs).append(" and createTime > ").append(aaF).append(" order by ").append(sdP).append('.');
        com.tencent.mm.plugin.story.h.j.a aVar = j.sea;
        String stringBuilder = append.append(j.sdW).append(" asc limit 1").toString();
        Cursor a = this.bSd.a(stringBuilder, null, 2);
        ab.d(TAG, "getLastUpload ".concat(String.valueOf(stringBuilder)));
        if (a.moveToFirst()) {
            a.f.b.j.o(a, "cr");
            jVar.d(a);
            a.close();
            AppMethodBeat.o(109939);
            return jVar;
        }
        a.close();
        AppMethodBeat.o(109939);
        return null;
    }

    public final int a(int i, j jVar) {
        AppMethodBeat.i(109940);
        a.f.b.j.p(jVar, "storyinfo");
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        if (com.tencent.mm.plugin.story.model.j.a.cxT().abb(i + '_' + jVar.field_createTime)) {
            AppMethodBeat.o(109940);
            return -1;
        }
        ContentValues Hl = jVar.Hl();
        Hl.remove("rowid");
        e eVar = this.bSd;
        String str = sdP;
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.h.j.a aVar2 = j.sea;
        int update = eVar.update(str, Hl, stringBuilder.append(j.sdW).append("=?").toString(), new String[]{String.valueOf(i)});
        AppMethodBeat.o(109940);
        return update;
    }

    public final j Fe(int i) {
        AppMethodBeat.i(109941);
        j jVar = new j();
        StringBuilder append = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(sdP).append('.');
        com.tencent.mm.plugin.story.h.j.a aVar = j.sea;
        Cursor a = this.bSd.a(append.append(j.sdW).append('=').append(i).toString(), null, 2);
        if (a.moveToFirst()) {
            a.f.b.j.o(a, "cu");
            jVar.d(a);
            a.close();
            AppMethodBeat.o(109941);
            return jVar;
        }
        a.close();
        AppMethodBeat.o(109941);
        return null;
    }

    private j lv(long j) {
        AppMethodBeat.i(109942);
        j Fe;
        if (j >= 0) {
            Fe = Fe((int) j);
            AppMethodBeat.o(109942);
            return Fe;
        }
        Fe = lx(j);
        AppMethodBeat.o(109942);
        return Fe;
    }

    public static String bm(String str, boolean z) {
        AppMethodBeat.i(109943);
        String str2;
        if (z) {
            str2 = " WHERE " + rfw;
            AppMethodBeat.o(109943);
            return str2;
        }
        str2 = " WHERE " + sdP + ".userName='" + bo.vA(str) + "' AND " + rfx;
        AppMethodBeat.o(109943);
        return str2;
    }

    private static String Ff(int i) {
        AppMethodBeat.i(109944);
        String str = sdP + ".createTime>" + i;
        AppMethodBeat.o(109944);
        return str;
    }

    private static String bv(String str, boolean z) {
        AppMethodBeat.i(109945);
        String str2 = "select *,rowid from MMStoryInfo " + bm(str, z);
        AppMethodBeat.o(109945);
        return str2;
    }

    public final long b(long j, int i, String str, boolean z) {
        AppMethodBeat.i(109946);
        a.f.b.j.p(str, "username");
        long k = k(bv(str, z), j, i);
        AppMethodBeat.o(109946);
        return k;
    }

    public final boolean c(long j, j jVar) {
        AppMethodBeat.i(109947);
        a.f.b.j.p(jVar, "snsInfo");
        if (kv(j)) {
            boolean b = b(j, jVar);
            AppMethodBeat.o(109947);
            return b;
        } else if (d(jVar) != -1) {
            AppMethodBeat.o(109947);
            return true;
        } else {
            AppMethodBeat.o(109947);
            return false;
        }
    }

    public final boolean kv(long j) {
        AppMethodBeat.i(109948);
        Cursor rawQuery = this.bSd.rawQuery("select *,rowid from MMStoryInfo  where " + sdP + ".storyID = " + j, null);
        a.f.b.j.o(rawQuery, "cu");
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.o(109948);
            return true;
        }
        AppMethodBeat.o(109948);
        return false;
    }

    public final List<j> bw(String str, boolean z) {
        AppMethodBeat.i(138845);
        a.f.b.j.p(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a(("select *,rowid from MMStoryInfo " + bm(str, z)) + (z ? rfn : " AND " + seg + rfn), null, 2);
        while (a.moveToNext()) {
            j jVar = new j();
            a.f.b.j.o(a, "cu");
            jVar.d(a);
            arrayList.add(jVar);
        }
        a.close();
        List list = arrayList;
        AppMethodBeat.o(138845);
        return list;
    }

    public static /* synthetic */ List a(k kVar, String str, long j) {
        AppMethodBeat.i(109950);
        a.f.b.j.p(str, "username");
        ArrayList arrayList = new ArrayList();
        String str2 = "select *,rowid from MMStoryInfo  WHERE " + sei;
        if (j < 0) {
            str2 = str2 + " AND storyID >= " + j;
        }
        str2 = str2 + rfn;
        ab.d(TAG, "getAlbumStoryAfterByStoryId ".concat(String.valueOf(str2)));
        Cursor a = kVar.bSd.a(str2, null, 2);
        while (a.moveToNext()) {
            j jVar = new j();
            a.f.b.j.o(a, "cu");
            jVar.d(a);
            arrayList.add(jVar);
        }
        a.close();
        List list = arrayList;
        AppMethodBeat.o(109950);
        return list;
    }

    public final List<j> a(String str, boolean z, int i, boolean z2) {
        AppMethodBeat.i(109952);
        a.f.b.j.p(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a((("select *,rowid from MMStoryInfo " + bm(str, z) + ' ') + " AND " + Ff(i)) + (z ? rfn : " AND " + seg + " AND " + seh + ' ' + rfn), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                j jVar = new j();
                jVar.d(a);
                arrayList.add(jVar);
            }
            a.close();
        }
        if (z) {
            d dVar = d.rSg;
            d.EK(arrayList.size());
        }
        if (z2) {
            Collection arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if ((!((j) next).cBV() ? 1 : null) != null) {
                    arrayList2.add(next);
                }
            }
            List list = (List) arrayList2;
            AppMethodBeat.o(109952);
            return list;
        }
        List<j> list2 = arrayList;
        AppMethodBeat.o(109952);
        return list2;
    }

    public final List<j> h(String str, boolean z, int i) {
        AppMethodBeat.i(109954);
        a.f.b.j.p(str, "userName");
        Collection arrayList = new ArrayList();
        for (Object next : a(this, str, z, i)) {
            if ((((j) next).cBR().xeC == 0 ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        AppMethodBeat.o(109954);
        return list;
    }

    public final boolean DL(int i) {
        AppMethodBeat.i(109955);
        e eVar = this.bSd;
        String str = sdP;
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.h.j.a aVar = j.sea;
        if (eVar.delete(str, stringBuilder.append(j.sdW).append("=?").toString(), new String[]{String.valueOf(i)}) > 0) {
            AppMethodBeat.o(109955);
            return true;
        }
        AppMethodBeat.o(109955);
        return false;
    }

    public final boolean lw(long j) {
        AppMethodBeat.i(109956);
        if (this.bSd.delete(sdP, "storyID=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.o(109956);
            return true;
        }
        AppMethodBeat.o(109956);
        return false;
    }

    public final j lx(long j) {
        AppMethodBeat.i(109957);
        j jVar = new j();
        Cursor a = this.bSd.a("select *,rowid from MMStoryInfo  WHERE " + sdP + ".storyID=" + j, null, 2);
        if (a.moveToFirst()) {
            a.f.b.j.o(a, "cu");
            jVar.d(a);
            a.close();
            AppMethodBeat.o(109957);
            return jVar;
        }
        a.close();
        AppMethodBeat.o(109957);
        return null;
    }

    public final void cqH() {
        AppMethodBeat.i(109958);
        ab.i(TAG, "dropTable ".concat(String.valueOf(this.bSd.delete(sdP, null, null))));
        AppMethodBeat.o(109958);
    }

    public final List<j> dm(String str, int i) {
        AppMethodBeat.i(109959);
        a.f.b.j.p(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a((("select *,rowid from MMStoryInfo " + bm(str, true)) + " AND createTime BETWEEN " + i + " AND " + ((86400 + i) - 1)) + rfn, null, 2);
        while (a.moveToNext()) {
            j jVar = new j();
            a.f.b.j.o(a, "cu");
            jVar.d(a);
            arrayList.add(jVar);
        }
        a.close();
        List list = arrayList;
        AppMethodBeat.o(109959);
        return list;
    }

    public final long E(long j, int i) {
        AppMethodBeat.i(109960);
        long k = k("select *,rowid from MMStoryInfo  WHERE " + sei, j, i);
        AppMethodBeat.o(109960);
        return k;
    }

    public final long F(long j, int i) {
        AppMethodBeat.i(138846);
        long k = k("select *,rowid from MMStoryInfo  WHERE " + sej, j, i);
        AppMethodBeat.o(138846);
        return k;
    }

    public final int ly(long j) {
        AppMethodBeat.i(109961);
        j lv = lv(j);
        if (lv != null) {
            int i = lv.field_readCount;
            AppMethodBeat.o(109961);
            return i;
        }
        AppMethodBeat.o(109961);
        return 0;
    }

    public final ArrayList<j> bx(String str, boolean z) {
        AppMethodBeat.i(109963);
        a.f.b.j.p(str, "username");
        ArrayList arrayList = new ArrayList();
        if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
            String str2 = "select *,rowid from MMStoryInfo  " + bm(str, z) + " AND " + sej + ' ' + rfn;
            ab.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(str2)));
            Cursor a = this.bSd.a(str2, null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    j jVar = new j();
                    jVar.d(a);
                    arrayList.add(jVar);
                }
                a.close();
            }
        }
        AppMethodBeat.o(109963);
        return arrayList;
    }

    public final List<j> a(String str, boolean z, long j, int i) {
        AppMethodBeat.i(138847);
        a.f.b.j.p(str, "username");
        ArrayList arrayList = new ArrayList();
        if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
            String str2 = "select *,rowid from MMStoryInfo  " + bm(str, z) + " AND " + sej + ' ';
            if (j < 0) {
                str2 = str2 + " AND storyID >= " + j;
            }
            Object obj = str2 + rfn;
            if (i > 0) {
                obj = obj + " limit " + i;
            }
            ab.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(obj)));
            Cursor a = this.bSd.a(obj, null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    j jVar = new j();
                    jVar.d(a);
                    arrayList.add(jVar);
                }
                a.close();
            }
        }
        List list = arrayList;
        AppMethodBeat.o(138847);
        return list;
    }
}
