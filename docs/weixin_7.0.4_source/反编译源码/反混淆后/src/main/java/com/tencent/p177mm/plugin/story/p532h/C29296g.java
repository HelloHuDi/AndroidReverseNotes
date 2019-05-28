package com.tencent.p177mm.plugin.story.p532h;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p230g.p711c.C18476er;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.story.api.C13736l;
import com.tencent.p177mm.plugin.story.model.C35200b;
import com.tencent.p177mm.plugin.story.p532h.C4119f.C4120a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001BB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u000bJ\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u000bJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bJ\u001c\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0016J\u000e\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0013J\u0006\u00101\u001a\u00020\u0013J\u0016\u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0002H\u0002J\u0016\u00107\u001a\u00020,2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0002J\u000e\u00108\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u000bJ\u001a\u00109\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010:\u001a\u0004\u0018\u00010;J6\u0010<\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u000204R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006C"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "db", "extLruMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "notifyListener", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "userUpdateMap", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "addStoryStatusNotifyListener", "", "listener", "droptable", "dumpinfo", "get", "userName", "getAllData", "", "getAllUserStatus", "getFavoriteMd5", "getFromCache", "username", "getFromDb", "getMd5", "getStoryStatus", "insertFavMd5", "", "md5", "insertMd5", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "removeStoryStatusNotifyListener", "replace", "", "item", "set", "info", "startNotifyListener", "stopNotifyListener", "updateByLocal", "id", "", "extinfo", "updateCache", "updatePreCache", "updateReadIdWithNotify", "updateStoryUserInfo", "storyUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "updateSyncIdWithNotify", "syncId", "createTime", "thumb", "videoUrl", "duration", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.g */
public final class C29296g extends C7563j<C4119f> implements C4931a {
    private static final String TAG = TAG;
    private static final String[] fnj;
    private static final String sdP = sdP;
    private static final String sdQ = ("select *, rowid from " + sdP + ' ');
    private static final String sdR = ("select * from " + sdP);
    public static final C29297a sdS = new C29297a();
    private final C4927e bSd = this.sdO;
    public final ArrayList<C13736l> sdL = new ArrayList();
    private final C7598c<String, C4119f> sdM = new C7598c(1000);
    private C7598c<String, C4119f> sdN = new C7598c(1000);
    private final C4927e sdO;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\n0\n0\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage$Companion;", "", "()V", "EventNotifyStoryInvalid", "", "EventNotifyStoryPreLoad", "EventNotifyStoryRead", "EventNotifyStoryUnread", "EventNotifyStoryValid", "NotifyStoryInvalid", "", "NotifyStoryPreLoad", "NotifyStoryRead", "NotifyStoryUnread", "NotifyStoryValid", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "STORYEXT_SELECT_ALL_STATUS_BEGIN", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.g$a */
    public static final class C29297a {
        private C29297a() {
        }

        public /* synthetic */ C29297a(byte b) {
            this();
        }
    }

    public C29296g(C4927e c4927e) {
        C25052j.m39376p(c4927e, "vdb");
        C4120a c4120a = C4119f.sdJ;
        super(c4927e, C4119f.ccO, sdP, C18476er.diI);
        AppMethodBeat.m2504i(109899);
        this.sdO = c4927e;
        AppMethodBeat.m2505o(109899);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo10099a(C4925c c4925c) {
        AppMethodBeat.m2504i(109890);
        C4119f c4119f = (C4119f) c4925c;
        C25052j.m39376p(c4119f, "item");
        boolean a = super.mo10099a(c4119f);
        m46512c(c4119f);
        AppMethodBeat.m2505o(109890);
        return a;
    }

    static {
        AppMethodBeat.m2504i(109900);
        String[] strArr = new String[1];
        C4120a c4120a = C4119f.sdJ;
        strArr[0] = C7563j.m13217a(C4119f.ccO, sdP);
        fnj = strArr;
        AppMethodBeat.m2505o(109900);
    }

    public final C4119f aaU(String str) {
        AppMethodBeat.m2504i(109883);
        C4119f c4119f = new C4119f();
        c4119f.field_userName = str;
        super.mo10102b((C4925c) c4119f, dpX());
        AppMethodBeat.m2505o(109883);
        return c4119f;
    }

    public final C4119f aap(String str) {
        AppMethodBeat.m2504i(109884);
        C25052j.m39376p(str, "userName");
        C4119f aaW = aaW(str);
        if (aaW != null) {
            AppMethodBeat.m2505o(109884);
            return aaW;
        }
        aaW = aaU(str);
        AppMethodBeat.m2505o(109884);
        return aaW;
    }

    /* renamed from: b */
    public final boolean mo47501b(C4119f c4119f) {
        AppMethodBeat.m2504i(109885);
        C25052j.m39376p(c4119f, "info");
        m46512c(c4119f);
        boolean a = super.mo10099a(c4119f);
        AppMethodBeat.m2505o(109885);
        return a;
    }

    /* renamed from: a */
    public final boolean mo47494a(long j, C4119f c4119f) {
        AppMethodBeat.m2504i(109886);
        C25052j.m39376p(c4119f, Constants.EXTINFO);
        if (mo47500b(j, c4119f) >= 0) {
            mo15641b("notify_story_preload", 3, c4119f);
        }
        AppMethodBeat.m2505o(109886);
        return true;
    }

    public final String aaV(String str) {
        AppMethodBeat.m2504i(109887);
        C25052j.m39376p(str, "userName");
        String str2 = aaU(str).field_md5;
        AppMethodBeat.m2505o(109887);
        return str2;
    }

    /* renamed from: gB */
    public final int mo47505gB(String str, String str2) {
        AppMethodBeat.m2504i(109888);
        C25052j.m39376p(str, "userName");
        C25052j.m39376p(str2, "md5");
        C4119f aaU = aaU(str);
        aaU.field_md5 = str2;
        super.mo10099a(aaU);
        AppMethodBeat.m2505o(109888);
        return 0;
    }

    /* renamed from: gC */
    public final int mo47506gC(String str, String str2) {
        AppMethodBeat.m2504i(109889);
        C25052j.m39376p(str, "userName");
        C25052j.m39376p(str2, "md5");
        C4119f aaU = aaU(str);
        aaU.field_favoriteMd5 = str2;
        super.mo10099a(aaU);
        AppMethodBeat.m2505o(109889);
        return 0;
    }

    /* renamed from: c */
    private final void m46512c(C4119f c4119f) {
        AppMethodBeat.m2504i(109891);
        if (c4119f != null) {
            CharSequence userName = c4119f.getUserName();
            Object obj = (userName == null || userName.length() == 0) ? 1 : null;
            if (obj == null) {
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                if (((C6982j) K).mo15369XM().aoJ(c4119f.getUserName())) {
                    this.sdM.put(c4119f.getUserName(), c4119f);
                    this.sdN.remove(c4119f.getUserName());
                    AppMethodBeat.m2505o(109891);
                    return;
                }
                this.sdM.remove(c4119f.getUserName());
                this.sdN.put(c4119f.getUserName(), c4119f);
                AppMethodBeat.m2505o(109891);
                return;
            }
        }
        AppMethodBeat.m2505o(109891);
    }

    public final List<C4119f> cBP() {
        AppMethodBeat.m2504i(109892);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a(sdQ, null, 2);
        a.moveToFirst();
        do {
            C4119f c4119f = new C4119f();
            C25052j.m39375o(a, "cu");
            c4119f.mo8995d(a);
            arrayList.add(c4119f);
        } while (a.moveToNext());
        a.close();
        List list = arrayList;
        AppMethodBeat.m2505o(109892);
        return list;
    }

    public final List<C4119f> cBC() {
        AppMethodBeat.m2504i(109893);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a(sdR, null, 2);
        a.moveToFirst();
        do {
            C4119f c4119f = new C4119f();
            C25052j.m39375o(a, "cu");
            c4119f.mo8995d(a);
            arrayList.add(c4119f);
        } while (a.moveToNext());
        a.close();
        List list = arrayList;
        AppMethodBeat.m2505o(109893);
        return list;
    }

    public final C4119f aaW(String str) {
        AppMethodBeat.m2504i(109894);
        C25052j.m39376p(str, "username");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            AppMethodBeat.m2505o(109894);
            return null;
        }
        C4119f c4119f = (C4119f) this.sdM.get(str);
        if (c4119f == null) {
            c4119f = (C4119f) this.sdN.get(str);
            if (c4119f == null) {
                c4119f = aaU(str);
                m46512c(c4119f);
            }
        }
        AppMethodBeat.m2505o(109894);
        return c4119f;
    }

    public final C4119f aaX(String str) {
        AppMethodBeat.m2504i(109895);
        C25052j.m39376p(str, "username");
        C4119f c4119f = (C4119f) this.sdN.get(str);
        if (c4119f == null) {
            c4119f = aaU(str);
            m46512c(c4119f);
        }
        AppMethodBeat.m2505o(109895);
        return c4119f;
    }

    /* renamed from: b */
    public final int mo47500b(long j, C4119f c4119f) {
        AppMethodBeat.m2504i(109896);
        C25052j.m39376p(c4119f, Constants.EXTINFO);
        ContentValues Hl = c4119f.mo10098Hl();
        Hl.remove("rowid");
        m46512c(c4119f);
        int update = this.bSd.update(sdP, Hl, "rowid=?", new String[]{String.valueOf(j)});
        AppMethodBeat.m2505o(109896);
        return update;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(109897);
        if (!(str == null || c4935m == null)) {
            Object obj;
            C44941v c44941v;
            String userName;
            C35200b c35200b;
            if (C25052j.m39373j(str, "notify_story_read") && (c4935m.obj instanceof C4119f)) {
                obj = c4935m.obj;
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.m2505o(109897);
                    throw c44941v;
                }
                userName = ((C4119f) obj).getUserName();
                for (C13736l br : this.sdL) {
                    br.mo25937br(userName, true);
                }
                c35200b = C35200b.rSa;
                C35200b.cxt();
                AppMethodBeat.m2505o(109897);
                return;
            } else if (C25052j.m39373j(str, "notify_story_unread") && (c4935m.obj instanceof C4119f)) {
                obj = c4935m.obj;
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.m2505o(109897);
                    throw c44941v;
                }
                userName = ((C4119f) obj).getUserName();
                for (C13736l br2 : this.sdL) {
                    br2.mo25937br(userName, false);
                }
                c35200b = C35200b.rSa;
                C35200b.cxt();
                AppMethodBeat.m2505o(109897);
                return;
            } else if (C25052j.m39373j(str, "notify_story_invalid") && (c4935m.obj instanceof C4119f)) {
                obj = c4935m.obj;
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.m2505o(109897);
                    throw c44941v;
                }
                userName = ((C4119f) obj).getUserName();
                for (C13736l br22 : this.sdL) {
                    br22.mo25937br(userName, true);
                }
                c35200b = C35200b.rSa;
                C35200b.cxt();
                AppMethodBeat.m2505o(109897);
                return;
            } else if (C25052j.m39373j(str, "notify_story_valid") && (c4935m.obj instanceof C4119f)) {
                obj = c4935m.obj;
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.m2505o(109897);
                    throw c44941v;
                }
                userName = ((C4119f) obj).getUserName();
                for (C13736l br222 : this.sdL) {
                    br222.mo25937br(userName, true);
                }
                c35200b = C35200b.rSa;
                C35200b.cxt();
                AppMethodBeat.m2505o(109897);
                return;
            } else {
                C4990ab.m7410d(TAG, "unknown event ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.m2505o(109897);
    }

    public final void cqH() {
        AppMethodBeat.m2504i(109898);
        C4990ab.m7416i(TAG, "dropTable ".concat(String.valueOf(this.bSd.delete(sdP, null, null))));
        AppMethodBeat.m2505o(109898);
    }
}
