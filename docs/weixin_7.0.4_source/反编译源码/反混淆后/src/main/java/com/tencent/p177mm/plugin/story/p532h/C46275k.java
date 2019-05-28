package com.tencent.p177mm.plugin.story.p532h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.plugin.story.model.C13774d;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35187c;
import com.tencent.p177mm.plugin.story.p532h.C39879j.C22215a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b@\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0012J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010)\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\bJ\u0016\u0010,\u001a\u00020&2\u0006\u0010$\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u001eJ\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0012J\b\u00100\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020\bH\u0016J\u0013\u00102\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J&\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010*\u001a\u00020\b2\u0006\u00104\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u0012J\u0010\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0012J\u0010\u00107\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J.\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010/\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020&J\u0010\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u001eH\u0002J\u0012\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010=\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0016\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012J&\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\b\u0012\u0004\u0012\u00020\u0002`\u00132\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J.\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u00104\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u0012J$\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0012J\u0016\u0010C\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0012J\u0016\u0010F\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J\b\u0010G\u001a\u0004\u0018\u00010\u0002J&\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010J\u001a\u00020&J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u00104\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u0012J\u0010\u0010L\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u001eJ\u000e\u0010M\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ&\u0010N\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J(\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020&2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010Q\u001a\u00020&H\u0002J\u000e\u0010R\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010S\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010T\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010U\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0016\u0010V\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u0002J\u0016\u0010X\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u0002J\u0012\u0010Z\u001a\u00020&2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010[\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u0002J\u0018\u0010\\\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u0002H\u0016J\u0016\u0010]\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u0002J \u0010_\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0002J\u0016\u0010a\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010b\u001a\u00020\u0012J\u0016\u0010c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0018\u00010\u000f0\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0006¨\u0006f"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "deleteStoryByIdBefore", "id", "deleteStoryByTimeBefore", "timeStamp", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "excludePrivacy", "getCDAboveExcudeSeq", "seq", "getCDBelowExculdeSeq", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isPcIdExist", "isStoryIdExist", "removeDelList", "replaceStoryId", "storyInfo", "replaceUserByPcId", "snsInfo", "seqAvailable", "set", "update", "updateByLocal", "storyinfo", "updateFilterUserName", "conSql", "updateStoryFavorite", "favorite", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.k */
public final class C46275k extends C7563j<C39879j> {
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
    public static final C39880a sek = new C39880a();
    public final C4927e bSd;
    private final ArrayList<Integer> rfA;
    private final ArrayList<Integer> rfB;
    private String rfs;
    private String rft;
    private C4927e sdO;
    private final String seb = " (storyID != 0 ) ";
    private final ArrayList<Integer> sec;
    private final List<String> sed;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$2\u0006\u0010%\u001a\u00020\u0004J$\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'J$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u000b0)j\b\u0012\u0004\u0012\u00020\u000b`*2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R!\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00040\u00040\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\u000fR\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u000e\u0010!\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage$Companion;", "", "()V", "CON_FAVORITE", "", "CON_HISTORY", "CON_NOT_VISIBLE_SELF", "CON_OTHERS", "CON_STORY_ID", "CON_USER", "EventNotifyStoryInfoDelete", "", "INDEX_CREATE", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "NotifyStoryInfoDelete", "ORDER_BY_FAV_SEQ", "getORDER_BY_FAV_SEQ", "()Ljava/lang/String;", "setORDER_BY_FAV_SEQ", "(Ljava/lang/String;)V", "ORDER_BY_SEQ", "getORDER_BY_SEQ", "setORDER_BY_SEQ", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "STORYINFO_SELECT_BEGIN", "STORYINFO_SELECT_COUNT", "TABLE", "getTABLE", "TAG", "buildLimitString", "data", "", "col", "reverse", "", "getORIntRange", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.k$a */
    public static final class C39880a {
        private C39880a() {
        }

        public /* synthetic */ C39880a(byte b) {
            this();
        }

        /* renamed from: f */
        public static String m68308f(List<Integer> list, String str) {
            AppMethodBeat.m2504i(109929);
            C25052j.m39376p(list, "data");
            C25052j.m39376p(str, "col");
            String b = C39880a.m68306b(list, str, false);
            AppMethodBeat.m2505o(109929);
            return b;
        }

        /* renamed from: b */
        public static String m68306b(List<Integer> list, String str, boolean z) {
            AppMethodBeat.m2504i(109930);
            C25052j.m39376p(list, "data");
            C25052j.m39376p(str, "col");
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
            C25052j.m39375o(stringBuilder2, "sb.toString()");
            AppMethodBeat.m2505o(109930);
            return stringBuilder2;
        }

        /* renamed from: dm */
        public static ArrayList<Integer> m68307dm(List<Integer> list) {
            AppMethodBeat.m2504i(109931);
            C25052j.m39376p(list, "data");
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
                    C25052j.m39375o(num, "i");
                    arrayList3.add(Integer.valueOf(intValue | num.intValue()));
                }
                hashSet.addAll(new HashSet(arrayList3));
                hashSet.add(num);
            }
            hashSet.add(Integer.valueOf(0));
            arrayList2.addAll(hashSet);
            AppMethodBeat.m2505o(109931);
            return arrayList2;
        }
    }

    public C46275k(C4927e c4927e) {
        Integer num;
        int intValue;
        C35187c c35187c;
        C35184a c35184a;
        C25052j.m39376p(c4927e, "vdb");
        C22215a c22215a = C39879j.sea;
        super(c4927e, C39879j.ccO, sdP, diI);
        AppMethodBeat.m2504i(109964);
        this.sdO = c4927e;
        Integer[] numArr = new Integer[3];
        C35187c c35187c2 = C35187c.sds;
        numArr[0] = Integer.valueOf(C35187c.cBu());
        c35187c2 = C35187c.sds;
        numArr[1] = Integer.valueOf(C35187c.cBv());
        c35187c2 = C35187c.sds;
        numArr[2] = Integer.valueOf(C35187c.cBw());
        List asList = Arrays.asList(numArr);
        C25052j.m39375o(asList, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
        this.rfA = C39880a.m68307dm(asList);
        numArr = new Integer[3];
        C35184a c35184a2 = C35183a.sdm;
        numArr[0] = Integer.valueOf(C35183a.scw);
        c35184a2 = C35183a.sdm;
        numArr[1] = Integer.valueOf(C35183a.scx);
        c35184a2 = C35183a.sdm;
        numArr[2] = Integer.valueOf(C35183a.scy);
        asList = Arrays.asList(numArr);
        C25052j.m39375o(asList, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
        this.rfB = C39880a.m68307dm(asList);
        numArr = new Integer[2];
        c35184a2 = C35183a.sdm;
        numArr[0] = Integer.valueOf(C35183a.sdd);
        c35184a2 = C35183a.sdm;
        numArr[1] = Integer.valueOf(C35183a.sde);
        asList = Arrays.asList(numArr);
        C25052j.m39375o(asList, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
        this.sec = C39880a.m68307dm(asList);
        this.bSd = this.sdO;
        this.sed = Collections.synchronizedList(new ArrayList());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.rfA.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            c35187c = C35187c.sds;
            if ((intValue & C35187c.cBu()) != 0) {
                intValue = num.intValue();
                c35187c = C35187c.sds;
                if ((intValue & C35187c.cBv()) == 0) {
                    arrayList.add(num);
                }
            }
        }
        this.rfs = C39880a.m68308f(arrayList, "localFlag");
        arrayList.clear();
        it = this.rfB.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            c35184a = C35183a.sdm;
            if ((intValue & C35183a.scw) != 0) {
                arrayList.add(num);
            }
        }
        rfw = C39880a.m68308f(arrayList, "sourceType");
        arrayList.clear();
        it = this.rfB.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            c35184a = C35183a.sdm;
            if ((intValue & C35183a.scx) != 0) {
                arrayList.add(num);
            }
        }
        rfx = C39880a.m68308f(arrayList, "sourceType");
        arrayList.clear();
        it = this.rfA.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            c35187c = C35187c.sds;
            if ((intValue & C35187c.cBv()) != 0) {
                arrayList.add(num);
            }
        }
        this.rft = C39880a.m68308f(arrayList, "localFlag");
        arrayList.clear();
        it = this.rfB.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            c35184a = C35183a.sdm;
            if ((intValue & C35183a.scy) != 0) {
                arrayList.add(num);
            }
        }
        sei = C39880a.m68308f(arrayList, "sourceType");
        arrayList.clear();
        it = this.sec.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            c35184a = C35183a.sdm;
            if ((intValue & C35183a.sdd) != 0) {
                arrayList.add(num);
            }
        }
        seh = C39880a.m68306b(arrayList, "itemStoryFlag", true);
        arrayList.clear();
        it = this.sec.iterator();
        while (it.hasNext()) {
            num = (Integer) it.next();
            intValue = num.intValue();
            c35184a = C35183a.sdm;
            if ((intValue & C35183a.sde) != 0) {
                arrayList.add(num);
            }
        }
        sej = C39880a.m68308f(arrayList, "itemStoryFlag");
        AppMethodBeat.m2505o(109964);
    }

    public final void aba(String str) {
        AppMethodBeat.m2504i(109932);
        C25052j.m39376p(str, "localId");
        this.sed.add(str);
        AppMethodBeat.m2505o(109932);
    }

    public final boolean abb(String str) {
        AppMethodBeat.m2504i(109933);
        C25052j.m39376p(str, "localId");
        boolean z = false;
        List list = this.sed;
        C25052j.m39375o(list, "delList");
        Iterable<String> iterable = list;
        synchronized (iterable) {
            try {
                for (String j : iterable) {
                    boolean z2;
                    if (C25052j.m39373j(j, str)) {
                        z2 = true;
                        C4990ab.m7416i(TAG, "wo wo wo ".concat(String.valueOf(str)));
                    } else {
                        z2 = z;
                    }
                    z = z2;
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(109933);
            }
        }
        return z;
    }

    static {
        AppMethodBeat.m2504i(109965);
        r0 = new String[3];
        StringBuilder stringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        C22215a c22215a = C39879j.sea;
        r0[0] = stringBuilder.append(C39879j.sdX).append(" ON ").append(sdP).append(" ( storyID )").toString();
        stringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        c22215a = C39879j.sea;
        r0[1] = stringBuilder.append(C39879j.sdY).append(" ON ").append(sdP).append(" (userName,storyID, createTime)").toString();
        StringBuilder stringBuilder2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        C22215a c22215a2 = C39879j.sea;
        r0[2] = stringBuilder2.append(C39879j.sdZ).append(" ON ").append(sdP).append(" (userName, createTime)").toString();
        diI = r0;
        r0 = new String[1];
        C22215a c22215a3 = C39879j.sea;
        r0[0] = C7563j.m13217a(C39879j.ccO, sdP);
        fnj = r0;
        AppMethodBeat.m2505o(109965);
    }

    /* renamed from: a */
    public final boolean mo74401a(long j, C39879j c39879j) {
        AppMethodBeat.m2504i(138843);
        C25052j.m39376p(c39879j, "storyInfo");
        if (m86724lu(j)) {
            boolean b = mo74405b(j, c39879j);
            AppMethodBeat.m2505o(138843);
            return b;
        } else if (mo74411d(c39879j) != -1) {
            AppMethodBeat.m2505o(138843);
            return true;
        } else {
            AppMethodBeat.m2505o(138843);
            return false;
        }
    }

    /* renamed from: k */
    private long m86723k(String str, long j, int i) {
        AppMethodBeat.m2504i(109934);
        C25052j.m39376p(str, "baseSql");
        if (j != 0) {
            str = str + " AND " + sdP + ".storyID < '" + j + '\'';
        }
        String str2 = str + rfn + " limit " + i;
        C4990ab.m7410d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(str2)));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        if (rawQuery.moveToLast()) {
            C39879j c39879j = new C39879j();
            C25052j.m39375o(rawQuery, "cu");
            c39879j.mo8995d(rawQuery);
            rawQuery.close();
            long j2 = c39879j.field_storyID;
            AppMethodBeat.m2505o(109934);
            return j2;
        }
        rawQuery.close();
        AppMethodBeat.m2505o(109934);
        return 0;
    }

    /* renamed from: b */
    public final boolean mo74405b(long j, C39879j c39879j) {
        AppMethodBeat.m2504i(109935);
        C25052j.m39376p(c39879j, "storyInfo");
        if (this.bSd.update(sdP, c39879j.mo10098Hl(), "storyID=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.m2505o(109935);
            return true;
        }
        AppMethodBeat.m2505o(109935);
        return false;
    }

    /* renamed from: d */
    public final int mo74411d(C39879j c39879j) {
        AppMethodBeat.m2504i(109937);
        C25052j.m39376p(c39879j, "storyInfo");
        C4990ab.m7410d(TAG, "storyInfo Insert");
        int insert = (int) this.bSd.insert(sdP, "", c39879j.mo10098Hl());
        C4990ab.m7410d(TAG, "StoryInfo Insert result ".concat(String.valueOf(insert)));
        AppMethodBeat.m2505o(109937);
        return insert;
    }

    /* renamed from: lt */
    public final C39879j mo74415lt(long j) {
        AppMethodBeat.m2504i(109938);
        C39879j c39879j = new C39879j();
        Cursor a = this.bSd.mo10104a("select *,rowid from MMStoryInfo  where " + sdP + ".storyID=" + j + " limit 1", null, 2);
        if (a.moveToFirst()) {
            C25052j.m39375o(a, "cu");
            c39879j.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(109938);
            return c39879j;
        }
        a.close();
        AppMethodBeat.m2505o(109938);
        return null;
    }

    /* renamed from: lu */
    private boolean m86724lu(long j) {
        AppMethodBeat.m2504i(138844);
        Cursor rawQuery = this.bSd.rawQuery("select *,rowid from MMStoryInfo  where " + sdP + ".storyID = " + j, null);
        C25052j.m39375o(rawQuery, "cu");
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.m2505o(138844);
            return true;
        }
        AppMethodBeat.m2505o(138844);
        return false;
    }

    public final C39879j cCc() {
        AppMethodBeat.m2504i(109939);
        int aaF = C1839cb.aaF() - 86400;
        C39879j c39879j = new C39879j();
        StringBuilder append = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.rfs).append(" and createTime > ").append(aaF).append(" order by ").append(sdP).append('.');
        C22215a c22215a = C39879j.sea;
        String stringBuilder = append.append(C39879j.sdW).append(" asc limit 1").toString();
        Cursor a = this.bSd.mo10104a(stringBuilder, null, 2);
        C4990ab.m7410d(TAG, "getLastUpload ".concat(String.valueOf(stringBuilder)));
        if (a.moveToFirst()) {
            C25052j.m39375o(a, "cr");
            c39879j.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(109939);
            return c39879j;
        }
        a.close();
        AppMethodBeat.m2505o(109939);
        return null;
    }

    /* renamed from: a */
    public final int mo74398a(int i, C39879j c39879j) {
        AppMethodBeat.m2504i(109940);
        C25052j.m39376p(c39879j, "storyinfo");
        C4133a c4133a = C43644j.rST;
        if (C4133a.cxT().abb(i + '_' + c39879j.field_createTime)) {
            AppMethodBeat.m2505o(109940);
            return -1;
        }
        ContentValues Hl = c39879j.mo10098Hl();
        Hl.remove("rowid");
        C4927e c4927e = this.bSd;
        String str = sdP;
        StringBuilder stringBuilder = new StringBuilder();
        C22215a c22215a = C39879j.sea;
        int update = c4927e.update(str, Hl, stringBuilder.append(C39879j.sdW).append("=?").toString(), new String[]{String.valueOf(i)});
        AppMethodBeat.m2505o(109940);
        return update;
    }

    /* renamed from: Fe */
    public final C39879j mo74397Fe(int i) {
        AppMethodBeat.m2504i(109941);
        C39879j c39879j = new C39879j();
        StringBuilder append = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(sdP).append('.');
        C22215a c22215a = C39879j.sea;
        Cursor a = this.bSd.mo10104a(append.append(C39879j.sdW).append('=').append(i).toString(), null, 2);
        if (a.moveToFirst()) {
            C25052j.m39375o(a, "cu");
            c39879j.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(109941);
            return c39879j;
        }
        a.close();
        AppMethodBeat.m2505o(109941);
        return null;
    }

    /* renamed from: lv */
    private C39879j m86725lv(long j) {
        AppMethodBeat.m2504i(109942);
        C39879j Fe;
        if (j >= 0) {
            Fe = mo74397Fe((int) j);
            AppMethodBeat.m2505o(109942);
            return Fe;
        }
        Fe = mo74417lx(j);
        AppMethodBeat.m2505o(109942);
        return Fe;
    }

    /* renamed from: bm */
    public static String m86721bm(String str, boolean z) {
        AppMethodBeat.m2504i(109943);
        String str2;
        if (z) {
            str2 = " WHERE " + rfw;
            AppMethodBeat.m2505o(109943);
            return str2;
        }
        str2 = " WHERE " + sdP + ".userName='" + C5046bo.m7586vA(str) + "' AND " + rfx;
        AppMethodBeat.m2505o(109943);
        return str2;
    }

    /* renamed from: Ff */
    private static String m86715Ff(int i) {
        AppMethodBeat.m2504i(109944);
        String str = sdP + ".createTime>" + i;
        AppMethodBeat.m2505o(109944);
        return str;
    }

    /* renamed from: bv */
    private static String m86722bv(String str, boolean z) {
        AppMethodBeat.m2504i(109945);
        String str2 = "select *,rowid from MMStoryInfo " + C46275k.m86721bm(str, z);
        AppMethodBeat.m2505o(109945);
        return str2;
    }

    /* renamed from: b */
    public final long mo74404b(long j, int i, String str, boolean z) {
        AppMethodBeat.m2504i(109946);
        C25052j.m39376p(str, "username");
        long k = m86723k(C46275k.m86722bv(str, z), j, i);
        AppMethodBeat.m2505o(109946);
        return k;
    }

    /* renamed from: c */
    public final boolean mo74408c(long j, C39879j c39879j) {
        AppMethodBeat.m2504i(109947);
        C25052j.m39376p(c39879j, "snsInfo");
        if (mo74414kv(j)) {
            boolean b = mo74405b(j, c39879j);
            AppMethodBeat.m2505o(109947);
            return b;
        } else if (mo74411d(c39879j) != -1) {
            AppMethodBeat.m2505o(109947);
            return true;
        } else {
            AppMethodBeat.m2505o(109947);
            return false;
        }
    }

    /* renamed from: kv */
    public final boolean mo74414kv(long j) {
        AppMethodBeat.m2504i(109948);
        Cursor rawQuery = this.bSd.rawQuery("select *,rowid from MMStoryInfo  where " + sdP + ".storyID = " + j, null);
        C25052j.m39375o(rawQuery, "cu");
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.m2505o(109948);
            return true;
        }
        AppMethodBeat.m2505o(109948);
        return false;
    }

    /* renamed from: bw */
    public final List<C39879j> mo74406bw(String str, boolean z) {
        AppMethodBeat.m2504i(138845);
        C25052j.m39376p(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a(("select *,rowid from MMStoryInfo " + C46275k.m86721bm(str, z)) + (z ? rfn : " AND " + seg + rfn), null, 2);
        while (a.moveToNext()) {
            C39879j c39879j = new C39879j();
            C25052j.m39375o(a, "cu");
            c39879j.mo8995d(a);
            arrayList.add(c39879j);
        }
        a.close();
        List list = arrayList;
        AppMethodBeat.m2505o(138845);
        return list;
    }

    /* renamed from: a */
    public static /* synthetic */ List m86717a(C46275k c46275k, String str, long j) {
        AppMethodBeat.m2504i(109950);
        C25052j.m39376p(str, "username");
        ArrayList arrayList = new ArrayList();
        String str2 = "select *,rowid from MMStoryInfo  WHERE " + sei;
        if (j < 0) {
            str2 = str2 + " AND storyID >= " + j;
        }
        str2 = str2 + rfn;
        C4990ab.m7410d(TAG, "getAlbumStoryAfterByStoryId ".concat(String.valueOf(str2)));
        Cursor a = c46275k.bSd.mo10104a(str2, null, 2);
        while (a.moveToNext()) {
            C39879j c39879j = new C39879j();
            C25052j.m39375o(a, "cu");
            c39879j.mo8995d(a);
            arrayList.add(c39879j);
        }
        a.close();
        List list = arrayList;
        AppMethodBeat.m2505o(109950);
        return list;
    }

    /* renamed from: a */
    public final List<C39879j> mo74399a(String str, boolean z, int i, boolean z2) {
        AppMethodBeat.m2504i(109952);
        C25052j.m39376p(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a((("select *,rowid from MMStoryInfo " + C46275k.m86721bm(str, z) + ' ') + " AND " + C46275k.m86715Ff(i)) + (z ? rfn : " AND " + seg + " AND " + seh + ' ' + rfn), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                C39879j c39879j = new C39879j();
                c39879j.mo8995d(a);
                arrayList.add(c39879j);
            }
            a.close();
        }
        if (z) {
            C13774d c13774d = C13774d.rSg;
            C13774d.m21935EK(arrayList.size());
        }
        if (z2) {
            Collection arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if ((!((C39879j) next).cBV() ? 1 : null) != null) {
                    arrayList2.add(next);
                }
            }
            List list = (List) arrayList2;
            AppMethodBeat.m2505o(109952);
            return list;
        }
        List<C39879j> list2 = arrayList;
        AppMethodBeat.m2505o(109952);
        return list2;
    }

    /* renamed from: h */
    public final List<C39879j> mo74413h(String str, boolean z, int i) {
        AppMethodBeat.m2504i(109954);
        C25052j.m39376p(str, "userName");
        Collection arrayList = new ArrayList();
        for (Object next : C46275k.m86718a(this, str, z, i)) {
            if ((((C39879j) next).cBR().xeC == 0 ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(109954);
        return list;
    }

    /* renamed from: DL */
    public final boolean mo74394DL(int i) {
        AppMethodBeat.m2504i(109955);
        C4927e c4927e = this.bSd;
        String str = sdP;
        StringBuilder stringBuilder = new StringBuilder();
        C22215a c22215a = C39879j.sea;
        if (c4927e.delete(str, stringBuilder.append(C39879j.sdW).append("=?").toString(), new String[]{String.valueOf(i)}) > 0) {
            AppMethodBeat.m2505o(109955);
            return true;
        }
        AppMethodBeat.m2505o(109955);
        return false;
    }

    /* renamed from: lw */
    public final boolean mo74416lw(long j) {
        AppMethodBeat.m2504i(109956);
        if (this.bSd.delete(sdP, "storyID=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.m2505o(109956);
            return true;
        }
        AppMethodBeat.m2505o(109956);
        return false;
    }

    /* renamed from: lx */
    public final C39879j mo74417lx(long j) {
        AppMethodBeat.m2504i(109957);
        C39879j c39879j = new C39879j();
        Cursor a = this.bSd.mo10104a("select *,rowid from MMStoryInfo  WHERE " + sdP + ".storyID=" + j, null, 2);
        if (a.moveToFirst()) {
            C25052j.m39375o(a, "cu");
            c39879j.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(109957);
            return c39879j;
        }
        a.close();
        AppMethodBeat.m2505o(109957);
        return null;
    }

    public final void cqH() {
        AppMethodBeat.m2504i(109958);
        C4990ab.m7416i(TAG, "dropTable ".concat(String.valueOf(this.bSd.delete(sdP, null, null))));
        AppMethodBeat.m2505o(109958);
    }

    /* renamed from: dm */
    public final List<C39879j> mo74412dm(String str, int i) {
        AppMethodBeat.m2504i(109959);
        C25052j.m39376p(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a((("select *,rowid from MMStoryInfo " + C46275k.m86721bm(str, true)) + " AND createTime BETWEEN " + i + " AND " + ((86400 + i) - 1)) + rfn, null, 2);
        while (a.moveToNext()) {
            C39879j c39879j = new C39879j();
            C25052j.m39375o(a, "cu");
            c39879j.mo8995d(a);
            arrayList.add(c39879j);
        }
        a.close();
        List list = arrayList;
        AppMethodBeat.m2505o(109959);
        return list;
    }

    /* renamed from: E */
    public final long mo74395E(long j, int i) {
        AppMethodBeat.m2504i(109960);
        long k = m86723k("select *,rowid from MMStoryInfo  WHERE " + sei, j, i);
        AppMethodBeat.m2505o(109960);
        return k;
    }

    /* renamed from: F */
    public final long mo74396F(long j, int i) {
        AppMethodBeat.m2504i(138846);
        long k = m86723k("select *,rowid from MMStoryInfo  WHERE " + sej, j, i);
        AppMethodBeat.m2505o(138846);
        return k;
    }

    /* renamed from: ly */
    public final int mo74418ly(long j) {
        AppMethodBeat.m2504i(109961);
        C39879j lv = m86725lv(j);
        if (lv != null) {
            int i = lv.field_readCount;
            AppMethodBeat.m2505o(109961);
            return i;
        }
        AppMethodBeat.m2505o(109961);
        return 0;
    }

    /* renamed from: bx */
    public final ArrayList<C39879j> mo74407bx(String str, boolean z) {
        AppMethodBeat.m2504i(109963);
        C25052j.m39376p(str, "username");
        ArrayList arrayList = new ArrayList();
        if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
            String str2 = "select *,rowid from MMStoryInfo  " + C46275k.m86721bm(str, z) + " AND " + sej + ' ' + rfn;
            C4990ab.m7410d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(str2)));
            Cursor a = this.bSd.mo10104a(str2, null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    C39879j c39879j = new C39879j();
                    c39879j.mo8995d(a);
                    arrayList.add(c39879j);
                }
                a.close();
            }
        }
        AppMethodBeat.m2505o(109963);
        return arrayList;
    }

    /* renamed from: a */
    public final List<C39879j> mo74400a(String str, boolean z, long j, int i) {
        AppMethodBeat.m2504i(138847);
        C25052j.m39376p(str, "username");
        ArrayList arrayList = new ArrayList();
        if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
            String str2 = "select *,rowid from MMStoryInfo  " + C46275k.m86721bm(str, z) + " AND " + sej + ' ';
            if (j < 0) {
                str2 = str2 + " AND storyID >= " + j;
            }
            Object obj = str2 + rfn;
            if (i > 0) {
                obj = obj + " limit " + i;
            }
            C4990ab.m7410d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(obj)));
            Cursor a = this.bSd.mo10104a(obj, null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    C39879j c39879j = new C39879j();
                    c39879j.mo8995d(a);
                    arrayList.add(c39879j);
                }
                a.close();
            }
        }
        List list = arrayList;
        AppMethodBeat.m2505o(138847);
        return list;
    }
}
