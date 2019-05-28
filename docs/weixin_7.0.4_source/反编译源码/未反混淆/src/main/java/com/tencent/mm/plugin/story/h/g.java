package com.tencent.mm.plugin.story.h;

import a.l;
import a.v;
import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.er;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.story.model.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001BB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u000bJ\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u000bJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bJ\u001c\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0016J\u000e\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0013J\u0006\u00101\u001a\u00020\u0013J\u0016\u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0002H\u0002J\u0016\u00107\u001a\u00020,2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0002J\u000e\u00108\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u000bJ\u001a\u00109\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010:\u001a\u0004\u0018\u00010;J6\u0010<\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u000204R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006C"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "db", "extLruMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "notifyListener", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "userUpdateMap", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "addStoryStatusNotifyListener", "", "listener", "droptable", "dumpinfo", "get", "userName", "getAllData", "", "getAllUserStatus", "getFavoriteMd5", "getFromCache", "username", "getFromDb", "getMd5", "getStoryStatus", "insertFavMd5", "", "md5", "insertMd5", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "removeStoryStatusNotifyListener", "replace", "", "item", "set", "info", "startNotifyListener", "stopNotifyListener", "updateByLocal", "id", "", "extinfo", "updateCache", "updatePreCache", "updateReadIdWithNotify", "updateStoryUserInfo", "storyUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "updateSyncIdWithNotify", "syncId", "createTime", "thumb", "videoUrl", "duration", "Companion", "plugin-story_release"})
public final class g extends j<f> implements com.tencent.mm.sdk.e.k.a {
    private static final String TAG = TAG;
    private static final String[] fnj;
    private static final String sdP = sdP;
    private static final String sdQ = ("select *, rowid from " + sdP + ' ');
    private static final String sdR = ("select * from " + sdP);
    public static final a sdS = new a();
    private final e bSd = this.sdO;
    public final ArrayList<com.tencent.mm.plugin.story.api.l> sdL = new ArrayList();
    private final c<String, f> sdM = new c(1000);
    private c<String, f> sdN = new c(1000);
    private final e sdO;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\n0\n0\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage$Companion;", "", "()V", "EventNotifyStoryInvalid", "", "EventNotifyStoryPreLoad", "EventNotifyStoryRead", "EventNotifyStoryUnread", "EventNotifyStoryValid", "NotifyStoryInvalid", "", "NotifyStoryPreLoad", "NotifyStoryRead", "NotifyStoryUnread", "NotifyStoryValid", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "STORYEXT_SELECT_ALL_STATUS_BEGIN", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public g(e eVar) {
        a.f.b.j.p(eVar, "vdb");
        com.tencent.mm.plugin.story.h.f.a aVar = f.sdJ;
        super(eVar, f.ccO, sdP, er.diI);
        AppMethodBeat.i(109899);
        this.sdO = eVar;
        AppMethodBeat.o(109899);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar) {
        AppMethodBeat.i(109890);
        f fVar = (f) cVar;
        a.f.b.j.p(fVar, "item");
        boolean a = super.a(fVar);
        c(fVar);
        AppMethodBeat.o(109890);
        return a;
    }

    static {
        AppMethodBeat.i(109900);
        String[] strArr = new String[1];
        com.tencent.mm.plugin.story.h.f.a aVar = f.sdJ;
        strArr[0] = j.a(f.ccO, sdP);
        fnj = strArr;
        AppMethodBeat.o(109900);
    }

    public final f aaU(String str) {
        AppMethodBeat.i(109883);
        f fVar = new f();
        fVar.field_userName = str;
        super.b((com.tencent.mm.sdk.e.c) fVar, dpX());
        AppMethodBeat.o(109883);
        return fVar;
    }

    public final f aap(String str) {
        AppMethodBeat.i(109884);
        a.f.b.j.p(str, "userName");
        f aaW = aaW(str);
        if (aaW != null) {
            AppMethodBeat.o(109884);
            return aaW;
        }
        aaW = aaU(str);
        AppMethodBeat.o(109884);
        return aaW;
    }

    public final boolean b(f fVar) {
        AppMethodBeat.i(109885);
        a.f.b.j.p(fVar, "info");
        c(fVar);
        boolean a = super.a(fVar);
        AppMethodBeat.o(109885);
        return a;
    }

    public final boolean a(long j, f fVar) {
        AppMethodBeat.i(109886);
        a.f.b.j.p(fVar, Constants.EXTINFO);
        if (b(j, fVar) >= 0) {
            b("notify_story_preload", 3, fVar);
        }
        AppMethodBeat.o(109886);
        return true;
    }

    public final String aaV(String str) {
        AppMethodBeat.i(109887);
        a.f.b.j.p(str, "userName");
        String str2 = aaU(str).field_md5;
        AppMethodBeat.o(109887);
        return str2;
    }

    public final int gB(String str, String str2) {
        AppMethodBeat.i(109888);
        a.f.b.j.p(str, "userName");
        a.f.b.j.p(str2, "md5");
        f aaU = aaU(str);
        aaU.field_md5 = str2;
        super.a(aaU);
        AppMethodBeat.o(109888);
        return 0;
    }

    public final int gC(String str, String str2) {
        AppMethodBeat.i(109889);
        a.f.b.j.p(str, "userName");
        a.f.b.j.p(str2, "md5");
        f aaU = aaU(str);
        aaU.field_favoriteMd5 = str2;
        super.a(aaU);
        AppMethodBeat.o(109889);
        return 0;
    }

    private final void c(f fVar) {
        AppMethodBeat.i(109891);
        if (fVar != null) {
            CharSequence userName = fVar.getUserName();
            Object obj = (userName == null || userName.length() == 0) ? 1 : null;
            if (obj == null) {
                com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                if (((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoJ(fVar.getUserName())) {
                    this.sdM.put(fVar.getUserName(), fVar);
                    this.sdN.remove(fVar.getUserName());
                    AppMethodBeat.o(109891);
                    return;
                }
                this.sdM.remove(fVar.getUserName());
                this.sdN.put(fVar.getUserName(), fVar);
                AppMethodBeat.o(109891);
                return;
            }
        }
        AppMethodBeat.o(109891);
    }

    public final List<f> cBP() {
        AppMethodBeat.i(109892);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a(sdQ, null, 2);
        a.moveToFirst();
        do {
            f fVar = new f();
            a.f.b.j.o(a, "cu");
            fVar.d(a);
            arrayList.add(fVar);
        } while (a.moveToNext());
        a.close();
        List list = arrayList;
        AppMethodBeat.o(109892);
        return list;
    }

    public final List<f> cBC() {
        AppMethodBeat.i(109893);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a(sdR, null, 2);
        a.moveToFirst();
        do {
            f fVar = new f();
            a.f.b.j.o(a, "cu");
            fVar.d(a);
            arrayList.add(fVar);
        } while (a.moveToNext());
        a.close();
        List list = arrayList;
        AppMethodBeat.o(109893);
        return list;
    }

    public final f aaW(String str) {
        AppMethodBeat.i(109894);
        a.f.b.j.p(str, "username");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            AppMethodBeat.o(109894);
            return null;
        }
        f fVar = (f) this.sdM.get(str);
        if (fVar == null) {
            fVar = (f) this.sdN.get(str);
            if (fVar == null) {
                fVar = aaU(str);
                c(fVar);
            }
        }
        AppMethodBeat.o(109894);
        return fVar;
    }

    public final f aaX(String str) {
        AppMethodBeat.i(109895);
        a.f.b.j.p(str, "username");
        f fVar = (f) this.sdN.get(str);
        if (fVar == null) {
            fVar = aaU(str);
            c(fVar);
        }
        AppMethodBeat.o(109895);
        return fVar;
    }

    public final int b(long j, f fVar) {
        AppMethodBeat.i(109896);
        a.f.b.j.p(fVar, Constants.EXTINFO);
        ContentValues Hl = fVar.Hl();
        Hl.remove("rowid");
        c(fVar);
        int update = this.bSd.update(sdP, Hl, "rowid=?", new String[]{String.valueOf(j)});
        AppMethodBeat.o(109896);
        return update;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(109897);
        if (!(str == null || mVar == null)) {
            Object obj;
            v vVar;
            String userName;
            b bVar;
            if (a.f.b.j.j(str, "notify_story_read") && (mVar.obj instanceof f)) {
                obj = mVar.obj;
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(109897);
                    throw vVar;
                }
                userName = ((f) obj).getUserName();
                for (com.tencent.mm.plugin.story.api.l br : this.sdL) {
                    br.br(userName, true);
                }
                bVar = b.rSa;
                b.cxt();
                AppMethodBeat.o(109897);
                return;
            } else if (a.f.b.j.j(str, "notify_story_unread") && (mVar.obj instanceof f)) {
                obj = mVar.obj;
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(109897);
                    throw vVar;
                }
                userName = ((f) obj).getUserName();
                for (com.tencent.mm.plugin.story.api.l br2 : this.sdL) {
                    br2.br(userName, false);
                }
                bVar = b.rSa;
                b.cxt();
                AppMethodBeat.o(109897);
                return;
            } else if (a.f.b.j.j(str, "notify_story_invalid") && (mVar.obj instanceof f)) {
                obj = mVar.obj;
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(109897);
                    throw vVar;
                }
                userName = ((f) obj).getUserName();
                for (com.tencent.mm.plugin.story.api.l br22 : this.sdL) {
                    br22.br(userName, true);
                }
                bVar = b.rSa;
                b.cxt();
                AppMethodBeat.o(109897);
                return;
            } else if (a.f.b.j.j(str, "notify_story_valid") && (mVar.obj instanceof f)) {
                obj = mVar.obj;
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(109897);
                    throw vVar;
                }
                userName = ((f) obj).getUserName();
                for (com.tencent.mm.plugin.story.api.l br222 : this.sdL) {
                    br222.br(userName, true);
                }
                bVar = b.rSa;
                b.cxt();
                AppMethodBeat.o(109897);
                return;
            } else {
                ab.d(TAG, "unknown event ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(109897);
    }

    public final void cqH() {
        AppMethodBeat.i(109898);
        ab.i(TAG, "dropTable ".concat(String.valueOf(this.bSd.delete(sdP, null, null))));
        AppMethodBeat.o(109898);
    }
}
