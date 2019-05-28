package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.l;
import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.k;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class h {
    static final String TAG = TAG;
    public static final a rZx = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u0007J&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007JB\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00142\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0010J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "loadSyncData", "plugin-story_release"})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
        public static final class a extends android.support.v7.h.c.a {
            final /* synthetic */ List rZy;
            final /* synthetic */ List rZz;

            a(List list, List list2) {
                this.rZy = list;
                this.rZz = list2;
            }

            public final int fV() {
                AppMethodBeat.i(109580);
                int size = this.rZy.size();
                AppMethodBeat.o(109580);
                return size;
            }

            public final int fW() {
                AppMethodBeat.i(109581);
                int size = this.rZz.size();
                AppMethodBeat.o(109581);
                return size;
            }

            public final boolean J(int i, int i2) {
                AppMethodBeat.i(109582);
                if (((g) this.rZy.get(i)).rUJ == ((g) this.rZz.get(i2)).rUJ) {
                    AppMethodBeat.o(109582);
                    return true;
                }
                AppMethodBeat.o(109582);
                return false;
            }

            public final boolean K(int i, int i2) {
                AppMethodBeat.i(109583);
                boolean j = j.j((g) this.rZy.get(i), (g) this.rZz.get(i2));
                AppMethodBeat.o(109583);
                return j;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static g bt(String str, boolean z) {
            Object obj;
            AppMethodBeat.i(109584);
            j.p(str, "username");
            ab.i(h.TAG, "LogStory: loadSyncData ".concat(String.valueOf(str)));
            k kVar = k.rTc;
            f aap = k.aap(str);
            if (aap.field_syncId == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            com.tencent.mm.plugin.story.model.d.g.a aVar;
            g gVar;
            if (obj != null) {
                AppMethodBeat.o(109584);
                return null;
            } else if (z) {
                aVar = g.rWe;
                j.p(aap, IssueStorage.COLUMN_EXT_INFO);
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(aap.field_syncId);
                com.tencent.mm.plugin.story.h.j jVar = new com.tencent.mm.plugin.story.h.j();
                jVar.field_storyID = aap.field_syncId;
                jVar.field_createTime = aap.field_storyPostTime;
                jVar.field_userName = aap.getUserName();
                com.tencent.mm.plugin.story.model.q.a aVar3 = q.rTk;
                cfb cyq = com.tencent.mm.plugin.story.model.q.a.cyq();
                cyq.jBB = aap.getUserName();
                cyq.pcX = aap.field_storyPostTime;
                com.tencent.mm.plugin.story.model.q.a aVar4 = q.rTk;
                cek cek = new cek();
                cek.Id = "empty_" + cb.aaE();
                if (lx != null) {
                    cfb cBR = lx.cBR();
                    if (cBR != null && cBR.xeC == 0) {
                        cek.wEH = aap.cBK();
                        cek.Url = aap.cBJ();
                    }
                }
                cyq.xeA.wbK.add(cek);
                jVar.c(cyq);
                gVar = new g(jVar, cyq);
                AppMethodBeat.o(109584);
                return gVar;
            } else {
                aVar = g.rWe;
                gVar = com.tencent.mm.plugin.story.model.d.g.a.a(aap);
                AppMethodBeat.o(109584);
                return gVar;
            }
        }

        public static ArrayList<g> bu(String str, boolean z) {
            AppMethodBeat.i(109585);
            j.p(str, "username");
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.plugin.story.model.j.a aVar;
            com.tencent.mm.plugin.story.h.k cxT;
            com.tencent.mm.plugin.story.model.j.a aVar2;
            List h;
            if (z) {
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                h = cxT.h(str, bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), str), cb.aaF() - 86400);
            } else {
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                h = cxT.a(str, bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), str), cb.aaF() - 86400, true);
            }
            for (com.tencent.mm.plugin.story.h.j jVar : h) {
                cfb cBR = jVar.cBR();
                if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                    com.tencent.mm.plugin.story.model.d.g.a aVar3 = g.rWe;
                    arrayList.add(com.tencent.mm.plugin.story.model.d.g.a.c(jVar));
                    ab.i(h.TAG, "getGalleryItemsFromDb story username " + str + ' ' + arrayList.size() + ' ' + "content " + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + " id:" + jVar.field_storyID + " storyUsername: " + jVar.field_userName + " tryCount:" + jVar.cBU().eRu + " flag:" + jVar.field_localFlag);
                }
            }
            AppMethodBeat.o(109585);
            return arrayList;
        }

        public static ArrayList<g> gz(String str, String str2) {
            AppMethodBeat.i(109586);
            j.p(str, "username");
            j.p(str2, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.plugin.story.e.b.a aVar = b.rRO;
            int aah = com.tencent.mm.plugin.story.e.b.a.aah(str2);
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            for (com.tencent.mm.plugin.story.h.j jVar : com.tencent.mm.plugin.story.model.j.a.cxT().dm(str, aah)) {
                cfb cBR = jVar.cBR();
                if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                    com.tencent.mm.plugin.story.model.d.g.a aVar3 = g.rWe;
                    arrayList.add(com.tencent.mm.plugin.story.model.d.g.a.c(jVar));
                    ab.i(h.TAG, "getGalleryItemsFromDbByDate story username " + str + ' ' + arrayList.size() + ' ' + "content " + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + " id:" + jVar.field_storyID + " storyUsername: " + jVar.field_userName);
                }
            }
            AppMethodBeat.o(109586);
            return arrayList;
        }

        public static ArrayList<g> b(String str, boolean z, ArrayList<Long> arrayList) {
            AppMethodBeat.i(138806);
            j.p(str, "username");
            com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a("getGalleryItemsFromDbByStoryId");
            ArrayList arrayList2 = new ArrayList();
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            Collection arrayList3 = new ArrayList();
            for (Object next : com.tencent.mm.plugin.story.model.j.a.cxT().bw(str, z)) {
                if (arrayList != null ? arrayList.contains(Long.valueOf(((com.tencent.mm.plugin.story.h.j) next).field_storyID)) : true) {
                    arrayList3.add(next);
                }
            }
            for (com.tencent.mm.plugin.story.h.j jVar : (List) arrayList3) {
                cfb cBR = jVar.cBR();
                if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                    com.tencent.mm.plugin.story.model.d.g.a aVar3 = g.rWe;
                    arrayList2.add(com.tencent.mm.plugin.story.model.d.g.a.a(jVar, com.tencent.mm.plugin.story.model.d.h.UNREAD_FIRST));
                    ab.i(h.TAG, "getGalleryItemsFromDbByStoryId story:" + jVar + ", content:" + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + ", id:" + jVar.field_storyID + ", storyUsername:" + jVar.field_userName);
                }
            }
            aVar.SW();
            AppMethodBeat.o(138806);
            return arrayList2;
        }

        public static c.b m(List<g> list, List<g> list2) {
            AppMethodBeat.i(109587);
            j.p(list, "oldItems");
            j.p(list2, "newItems");
            c.b a = c.a(new a(list, list2), false);
            j.o(a, "DiffUtil.calculateDiff(o…  }\n            }, false)");
            AppMethodBeat.o(109587);
            return a;
        }
    }

    public void resume() {
    }

    public void pause() {
    }

    public void destroy() {
    }

    public void EO(int i) {
    }

    public void czC() {
    }

    public void czE() {
    }

    public void fM(int i, int i2) {
    }

    public void czB() {
    }

    public void fN(int i, int i2) {
    }

    public void ES(int i) {
    }

    public void ET(int i) {
    }

    public void n(int i, int i2, boolean z) {
    }

    public void o(int i, int i2, boolean z) {
    }
}
