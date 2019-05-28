package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p230g.p232b.p233a.C37822aw;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p532h.C4119f.C4120a;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C31819q;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0004J\u0014\u0010\u0014\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eJ\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J<\u0010\u0016\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "updateUserReadIds", "usernames", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.k */
public final class C22241k {
    private static final String TAG = TAG;
    public static final C22241k rTc = new C22241k();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.k$a */
    static final class C13797a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ long rTd;
        final /* synthetic */ long rTe;
        final /* synthetic */ ArrayList rTf;

        C13797a(long j, long j2, ArrayList arrayList) {
            this.rTd = j;
            this.rTe = j2;
            this.rTf = arrayList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            C22241k c22241k;
            AppMethodBeat.m2504i(109088);
            C8901a c8901a = new C8901a("reportWaitPlayList");
            C37822aw c37822aw = new C37822aw();
            c37822aw.mo60522ch(this.rTd);
            c37822aw.mo60523ci(this.rTe);
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder stringBuilder3 = new StringBuilder();
            Iterator it = this.rTf.iterator();
            int i = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                C22241k c22241k2 = C22241k.rTc;
                C25052j.m39375o(str, "username");
                long j = C22241k.aap(str).field_syncId;
                int length = String.valueOf(j).length();
                if (stringBuilder.length() + length < 1000) {
                    stringBuilder.append(j).append("|");
                } else if (stringBuilder2.length() + length < 1000) {
                    stringBuilder2.append(j).append("|");
                } else if (length + stringBuilder3.length() < 1000) {
                    stringBuilder3.append(j).append("|");
                } else {
                    c37822aw.mo60525fK(stringBuilder.substring(0, stringBuilder.length()).toString());
                    c37822aw.mo60526fL(stringBuilder2.substring(0, stringBuilder2.length()).toString());
                    c37822aw.mo60527fM(stringBuilder3.substring(0, stringBuilder3.length()).toString());
                    c37822aw.mo60524cj((long) i);
                    c22241k = C22241k.rTc;
                    C4990ab.m7416i(C22241k.TAG, "split reportWaitPlayList " + this.rTd + ' ' + i + ' ' + c37822aw.mo60519FZ().length() + ' ' + c37822aw.mo60519FZ() + c37822aw.mo60520Ga().length() + ' ' + c37822aw.mo60520Ga() + c37822aw.mo60521Gb().length() + ' ' + c37822aw.mo60521Gb());
                    c37822aw.ajK();
                    c37822aw = new C37822aw();
                    c37822aw.mo60522ch(this.rTd);
                    c37822aw.mo60523ci(this.rTe);
                    length = i + 1;
                    C31819q.m51510h(stringBuilder);
                    C31819q.m51510h(stringBuilder2);
                    C31819q.m51510h(stringBuilder3);
                    i = length;
                }
            }
            c37822aw.mo60525fK(stringBuilder.substring(0, stringBuilder.length()).toString());
            c37822aw.mo60526fL(stringBuilder2.substring(0, stringBuilder2.length()).toString());
            c37822aw.mo60527fM(stringBuilder3.substring(0, stringBuilder3.length()).toString());
            c37822aw.mo60524cj((long) i);
            c22241k = C22241k.rTc;
            C4990ab.m7416i(C22241k.TAG, "final reportWaitPlayList " + this.rTd + ' ' + i + ' ' + c37822aw.mo60519FZ().length() + ' ' + c37822aw.mo60519FZ() + c37822aw.mo60520Ga().length() + ' ' + c37822aw.mo60520Ga() + c37822aw.mo60521Gb().length() + ' ' + c37822aw.mo60521Gb());
            c37822aw.ajK();
            C37822aw c37822aw2 = new C37822aw();
            c8901a.mo20314SW();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109088);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(109096);
        AppMethodBeat.m2505o(109096);
    }

    private C22241k() {
    }

    public static /* synthetic */ void aan(String str) {
        AppMethodBeat.m2504i(109090);
        C22241k.m33917a(str, 0, 0, null, null, 0);
        AppMethodBeat.m2505o(109090);
    }

    /* renamed from: a */
    public static void m33917a(String str, long j, int i, String str2, String str3, long j2) {
        C4119f aaU;
        AppMethodBeat.m2504i(109089);
        C25052j.m39376p(str, "username");
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        C25052j.m39376p(str, "userName");
        C25052j.m39376p(str2, "thumb");
        C25052j.m39376p(str3, "videoUrl");
        C4119f aaW = cxU.aaW(str);
        if (aaW == null) {
            aaU = cxU.aaU(str);
        } else {
            aaU = aaW;
        }
        boolean cBN = aaU.cBN();
        boolean isValid = aaU.isValid();
        C4120a c4120a = C4119f.sdJ;
        if (((Boolean) C4119f.sdI.mo212m(Long.valueOf(aaU.field_syncId), Long.valueOf(j))).booleanValue()) {
            aaU.field_updateTime = ((long) i) * 1000;
        }
        aaU.field_syncId = j;
        if (aaU.field_preloadStoryId != aaU.field_syncId) {
            aaU.field_preloadStoryId = 0;
            aaU.aaT("");
            aaU.field_preLoadResource = 0;
        }
        aaU.field_storyPostTime = i;
        C25052j.m39376p(str2, "value");
        aaU.field_newThumbUrl = str2;
        C25052j.m39376p(str3, "value");
        aaU.field_newVideoUrl = str3;
        aaU.field_duration = j2;
        boolean b = cxU.mo47501b(aaU);
        boolean cBN2 = aaU.cBN();
        boolean isValid2 = aaU.isValid();
        if (b && isValid && !isValid2) {
            cxU.mo15641b("notify_story_invalid", 4, aaU);
            AppMethodBeat.m2505o(109089);
        } else if (b && !cBN && cBN2) {
            cxU.mo15641b("notify_story_unread", 2, aaU);
            AppMethodBeat.m2505o(109089);
        } else if (b && cBN && !cBN2) {
            cxU.mo15641b("notify_story_unread", 1, aaU);
            AppMethodBeat.m2505o(109089);
        } else {
            if (b && !isValid && isValid2) {
                cxU.mo15641b("notify_story_valid", 5, aaU);
            }
            AppMethodBeat.m2505o(109089);
        }
    }

    /* renamed from: a */
    public static void m33918a(String str, C39879j c39879j) {
        AppMethodBeat.m2504i(109091);
        C25052j.m39376p(str, "username");
        if (c39879j != null) {
            cfb cBR = c39879j.cBR();
            if (!(cBR == null || cBR.xeA.wbK.size() <= 0 || ((cek) cBR.xeA.wbK.get(0)).wEH == null || ((cek) cBR.xeA.wbK.get(0)).Url == null)) {
                C22241k.m33917a(str, c39879j.field_storyID, c39879j.field_createTime, ((cek) cBR.xeA.wbK.get(0)).wEH, ((cek) cBR.xeA.wbK.get(0)).Url, (long) (((cek) cBR.xeA.wbK.get(0)).duration * 1000.0f));
            }
            AppMethodBeat.m2505o(109091);
            return;
        }
        AppMethodBeat.m2505o(109091);
    }

    public static void aao(String str) {
        AppMethodBeat.m2504i(109092);
        C25052j.m39376p(str, "username");
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        C25052j.m39376p(str, "username");
        C4119f aaU = cxU.aaU(str);
        boolean cBN = aaU.cBN();
        if (aaU.field_readId != aaU.field_syncId) {
            aaU.field_readId = aaU.field_syncId;
            aaU.field_readTime = C1839cb.aaE();
            boolean b = cxU.mo47501b(aaU);
            boolean cBN2 = aaU.cBN();
            if (b && cBN && !cBN2) {
                cxU.mo15641b("notify_story_read", 1, aaU);
            }
        }
        AppMethodBeat.m2505o(109092);
    }

    public static C4119f aap(String str) {
        AppMethodBeat.m2504i(109093);
        C25052j.m39376p(str, "userName");
        C4133a c4133a = C43644j.rST;
        C4119f aap = C4133a.cxU().aap(str);
        AppMethodBeat.m2505o(109093);
        return aap;
    }

    public static boolean aaq(String str) {
        boolean z;
        AppMethodBeat.m2504i(109094);
        if (str != null) {
            C4133a c4133a = C43644j.rST;
            C4119f aaX = C4133a.cxU().aaX(str);
            if (aaX != null && aaX.cBN()) {
                z = true;
                C4990ab.m7410d(TAG, "getWithNotify ".concat(String.valueOf(z)));
                AppMethodBeat.m2505o(109094);
                return z;
            }
        }
        z = false;
        C4990ab.m7410d(TAG, "getWithNotify ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(109094);
        return z;
    }

    public static void reportWaitPlayList(List<String> list, long j) {
        AppMethodBeat.m2504i(109095);
        C25052j.m39376p(list, "srcuserList");
        C22212h c22212h = C22212h.scu;
        long FH = C22212h.cAs().mo20734FH();
        ArrayList arrayList = new ArrayList();
        Iterable<String> iterable = list;
        synchronized (iterable) {
            try {
                for (String add : iterable) {
                    arrayList.add(add);
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(109095);
            }
        }
        C8902b.m16044a("reportWaitPlayList", (C31214a) new C13797a(FH, j, arrayList));
    }
}
