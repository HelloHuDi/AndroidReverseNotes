package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.k.q;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0004J\u0014\u0010\u0014\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eJ\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J<\u0010\u0016\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "updateUserReadIds", "usernames", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
public final class k {
    private static final String TAG = TAG;
    public static final k rTc = new k();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ long rTd;
        final /* synthetic */ long rTe;
        final /* synthetic */ ArrayList rTf;

        a(long j, long j2, ArrayList arrayList) {
            this.rTd = j;
            this.rTe = j2;
            this.rTf = arrayList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            k kVar;
            AppMethodBeat.i(109088);
            com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a("reportWaitPlayList");
            aw awVar = new aw();
            awVar.ch(this.rTd);
            awVar.ci(this.rTe);
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder stringBuilder3 = new StringBuilder();
            Iterator it = this.rTf.iterator();
            int i = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                k kVar2 = k.rTc;
                j.o(str, "username");
                long j = k.aap(str).field_syncId;
                int length = String.valueOf(j).length();
                if (stringBuilder.length() + length < 1000) {
                    stringBuilder.append(j).append("|");
                } else if (stringBuilder2.length() + length < 1000) {
                    stringBuilder2.append(j).append("|");
                } else if (length + stringBuilder3.length() < 1000) {
                    stringBuilder3.append(j).append("|");
                } else {
                    awVar.fK(stringBuilder.substring(0, stringBuilder.length()).toString());
                    awVar.fL(stringBuilder2.substring(0, stringBuilder2.length()).toString());
                    awVar.fM(stringBuilder3.substring(0, stringBuilder3.length()).toString());
                    awVar.cj((long) i);
                    kVar = k.rTc;
                    ab.i(k.TAG, "split reportWaitPlayList " + this.rTd + ' ' + i + ' ' + awVar.FZ().length() + ' ' + awVar.FZ() + awVar.Ga().length() + ' ' + awVar.Ga() + awVar.Gb().length() + ' ' + awVar.Gb());
                    awVar.ajK();
                    awVar = new aw();
                    awVar.ch(this.rTd);
                    awVar.ci(this.rTe);
                    length = i + 1;
                    q.h(stringBuilder);
                    q.h(stringBuilder2);
                    q.h(stringBuilder3);
                    i = length;
                }
            }
            awVar.fK(stringBuilder.substring(0, stringBuilder.length()).toString());
            awVar.fL(stringBuilder2.substring(0, stringBuilder2.length()).toString());
            awVar.fM(stringBuilder3.substring(0, stringBuilder3.length()).toString());
            awVar.cj((long) i);
            kVar = k.rTc;
            ab.i(k.TAG, "final reportWaitPlayList " + this.rTd + ' ' + i + ' ' + awVar.FZ().length() + ' ' + awVar.FZ() + awVar.Ga().length() + ' ' + awVar.Ga() + awVar.Gb().length() + ' ' + awVar.Gb());
            awVar.ajK();
            aw awVar2 = new aw();
            aVar.SW();
            y yVar = y.AUy;
            AppMethodBeat.o(109088);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(109096);
        AppMethodBeat.o(109096);
    }

    private k() {
    }

    public static /* synthetic */ void aan(String str) {
        AppMethodBeat.i(109090);
        a(str, 0, 0, null, null, 0);
        AppMethodBeat.o(109090);
    }

    public static void a(String str, long j, int i, String str2, String str3, long j2) {
        f aaU;
        AppMethodBeat.i(109089);
        j.p(str, "username");
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        j.p(str, "userName");
        j.p(str2, "thumb");
        j.p(str3, "videoUrl");
        f aaW = cxU.aaW(str);
        if (aaW == null) {
            aaU = cxU.aaU(str);
        } else {
            aaU = aaW;
        }
        boolean cBN = aaU.cBN();
        boolean isValid = aaU.isValid();
        com.tencent.mm.plugin.story.h.f.a aVar2 = f.sdJ;
        if (((Boolean) f.sdI.m(Long.valueOf(aaU.field_syncId), Long.valueOf(j))).booleanValue()) {
            aaU.field_updateTime = ((long) i) * 1000;
        }
        aaU.field_syncId = j;
        if (aaU.field_preloadStoryId != aaU.field_syncId) {
            aaU.field_preloadStoryId = 0;
            aaU.aaT("");
            aaU.field_preLoadResource = 0;
        }
        aaU.field_storyPostTime = i;
        j.p(str2, "value");
        aaU.field_newThumbUrl = str2;
        j.p(str3, "value");
        aaU.field_newVideoUrl = str3;
        aaU.field_duration = j2;
        boolean b = cxU.b(aaU);
        boolean cBN2 = aaU.cBN();
        boolean isValid2 = aaU.isValid();
        if (b && isValid && !isValid2) {
            cxU.b("notify_story_invalid", 4, aaU);
            AppMethodBeat.o(109089);
        } else if (b && !cBN && cBN2) {
            cxU.b("notify_story_unread", 2, aaU);
            AppMethodBeat.o(109089);
        } else if (b && cBN && !cBN2) {
            cxU.b("notify_story_unread", 1, aaU);
            AppMethodBeat.o(109089);
        } else {
            if (b && !isValid && isValid2) {
                cxU.b("notify_story_valid", 5, aaU);
            }
            AppMethodBeat.o(109089);
        }
    }

    public static void a(String str, com.tencent.mm.plugin.story.h.j jVar) {
        AppMethodBeat.i(109091);
        j.p(str, "username");
        if (jVar != null) {
            cfb cBR = jVar.cBR();
            if (!(cBR == null || cBR.xeA.wbK.size() <= 0 || ((cek) cBR.xeA.wbK.get(0)).wEH == null || ((cek) cBR.xeA.wbK.get(0)).Url == null)) {
                a(str, jVar.field_storyID, jVar.field_createTime, ((cek) cBR.xeA.wbK.get(0)).wEH, ((cek) cBR.xeA.wbK.get(0)).Url, (long) (((cek) cBR.xeA.wbK.get(0)).duration * 1000.0f));
            }
            AppMethodBeat.o(109091);
            return;
        }
        AppMethodBeat.o(109091);
    }

    public static void aao(String str) {
        AppMethodBeat.i(109092);
        j.p(str, "username");
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        j.p(str, "username");
        f aaU = cxU.aaU(str);
        boolean cBN = aaU.cBN();
        if (aaU.field_readId != aaU.field_syncId) {
            aaU.field_readId = aaU.field_syncId;
            aaU.field_readTime = cb.aaE();
            boolean b = cxU.b(aaU);
            boolean cBN2 = aaU.cBN();
            if (b && cBN && !cBN2) {
                cxU.b("notify_story_read", 1, aaU);
            }
        }
        AppMethodBeat.o(109092);
    }

    public static f aap(String str) {
        AppMethodBeat.i(109093);
        j.p(str, "userName");
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap(str);
        AppMethodBeat.o(109093);
        return aap;
    }

    public static boolean aaq(String str) {
        boolean z;
        AppMethodBeat.i(109094);
        if (str != null) {
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            f aaX = com.tencent.mm.plugin.story.model.j.a.cxU().aaX(str);
            if (aaX != null && aaX.cBN()) {
                z = true;
                ab.d(TAG, "getWithNotify ".concat(String.valueOf(z)));
                AppMethodBeat.o(109094);
                return z;
            }
        }
        z = false;
        ab.d(TAG, "getWithNotify ".concat(String.valueOf(z)));
        AppMethodBeat.o(109094);
        return z;
    }

    public static void reportWaitPlayList(List<String> list, long j) {
        AppMethodBeat.i(109095);
        j.p(list, "srcuserList");
        h hVar = h.scu;
        long FH = h.cAs().FH();
        ArrayList arrayList = new ArrayList();
        Iterable<String> iterable = list;
        synchronized (iterable) {
            try {
                for (String add : iterable) {
                    arrayList.add(add);
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(109095);
            }
        }
        b.a("reportWaitPlayList", (a.f.a.a) new a(FH, j, arrayList));
    }
}
