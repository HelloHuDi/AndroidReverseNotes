package com.tencent.p177mm.plugin.story.p530f;

import android.support.p069v7.p075h.C0595c;
import android.support.p069v7.p075h.C0595c.C0597a;
import android.support.p069v7.p075h.C0595c.C0601b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43647q;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.model.p533d.C22234h;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g.C4126a;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.h */
public abstract class C39876h {
    static final String TAG = TAG;
    public static final C29290a rZx = new C29290a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u0007J&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007JB\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00142\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0010J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "loadSyncData", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.h$a */
    public static final class C29290a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.f.h$a$a */
        public static final class C4112a extends C0597a {
            final /* synthetic */ List rZy;
            final /* synthetic */ List rZz;

            C4112a(List list, List list2) {
                this.rZy = list;
                this.rZz = list2;
            }

            /* renamed from: fV */
            public final int mo1477fV() {
                AppMethodBeat.m2504i(109580);
                int size = this.rZy.size();
                AppMethodBeat.m2505o(109580);
                return size;
            }

            /* renamed from: fW */
            public final int mo1478fW() {
                AppMethodBeat.m2504i(109581);
                int size = this.rZz.size();
                AppMethodBeat.m2505o(109581);
                return size;
            }

            /* renamed from: J */
            public final boolean mo1474J(int i, int i2) {
                AppMethodBeat.m2504i(109582);
                if (((C43640g) this.rZy.get(i)).rUJ == ((C43640g) this.rZz.get(i2)).rUJ) {
                    AppMethodBeat.m2505o(109582);
                    return true;
                }
                AppMethodBeat.m2505o(109582);
                return false;
            }

            /* renamed from: K */
            public final boolean mo1475K(int i, int i2) {
                AppMethodBeat.m2504i(109583);
                boolean j = C25052j.m39373j((C43640g) this.rZy.get(i), (C43640g) this.rZz.get(i2));
                AppMethodBeat.m2505o(109583);
                return j;
            }
        }

        private C29290a() {
        }

        public /* synthetic */ C29290a(byte b) {
            this();
        }

        /* renamed from: bt */
        public static C43640g m46505bt(String str, boolean z) {
            Object obj;
            AppMethodBeat.m2504i(109584);
            C25052j.m39376p(str, "username");
            C4990ab.m7416i(C39876h.TAG, "LogStory: loadSyncData ".concat(String.valueOf(str)));
            C22241k c22241k = C22241k.rTc;
            C4119f aap = C22241k.aap(str);
            if (aap.field_syncId == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            C4126a c4126a;
            C43640g c43640g;
            if (obj != null) {
                AppMethodBeat.m2505o(109584);
                return null;
            } else if (z) {
                c4126a = C43640g.rWe;
                C25052j.m39376p(aap, IssueStorage.COLUMN_EXT_INFO);
                C4133a c4133a = C43644j.rST;
                C39879j lx = C4133a.cxT().mo74417lx(aap.field_syncId);
                C39879j c39879j = new C39879j();
                c39879j.field_storyID = aap.field_syncId;
                c39879j.field_createTime = aap.field_storyPostTime;
                c39879j.field_userName = aap.getUserName();
                C39911a c39911a = C43647q.rTk;
                cfb cyq = C39911a.cyq();
                cyq.jBB = aap.getUserName();
                cyq.pcX = aap.field_storyPostTime;
                C39911a c39911a2 = C43647q.rTk;
                cek cek = new cek();
                cek.f4416Id = "empty_" + C1839cb.aaE();
                if (lx != null) {
                    cfb cBR = lx.cBR();
                    if (cBR != null && cBR.xeC == 0) {
                        cek.wEH = aap.cBK();
                        cek.Url = aap.cBJ();
                    }
                }
                cyq.xeA.wbK.add(cek);
                c39879j.mo63084c(cyq);
                c43640g = new C43640g(c39879j, cyq);
                AppMethodBeat.m2505o(109584);
                return c43640g;
            } else {
                c4126a = C43640g.rWe;
                c43640g = C4126a.m6451a(aap);
                AppMethodBeat.m2505o(109584);
                return c43640g;
            }
        }

        /* renamed from: bu */
        public static ArrayList<C43640g> m46506bu(String str, boolean z) {
            AppMethodBeat.m2504i(109585);
            C25052j.m39376p(str, "username");
            ArrayList arrayList = new ArrayList();
            C4133a c4133a;
            C46275k cxT;
            C4133a c4133a2;
            List h;
            if (z) {
                c4133a = C43644j.rST;
                cxT = C4133a.cxT();
                c4133a2 = C43644j.rST;
                h = cxT.mo74413h(str, C5046bo.isEqual(C4133a.cnk(), str), C1839cb.aaF() - 86400);
            } else {
                c4133a = C43644j.rST;
                cxT = C4133a.cxT();
                c4133a2 = C43644j.rST;
                h = cxT.mo74399a(str, C5046bo.isEqual(C4133a.cnk(), str), C1839cb.aaF() - 86400, true);
            }
            for (C39879j c39879j : h) {
                cfb cBR = c39879j.cBR();
                if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                    C4126a c4126a = C43640g.rWe;
                    arrayList.add(C4126a.m6453c(c39879j));
                    C4990ab.m7416i(C39876h.TAG, "getGalleryItemsFromDb story username " + str + ' ' + arrayList.size() + ' ' + "content " + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + " id:" + c39879j.field_storyID + " storyUsername: " + c39879j.field_userName + " tryCount:" + c39879j.cBU().eRu + " flag:" + c39879j.field_localFlag);
                }
            }
            AppMethodBeat.m2505o(109585);
            return arrayList;
        }

        /* renamed from: gz */
        public static ArrayList<C43640g> m46507gz(String str, String str2) {
            AppMethodBeat.m2504i(109586);
            C25052j.m39376p(str, "username");
            C25052j.m39376p(str2, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            ArrayList arrayList = new ArrayList();
            C22178a c22178a = C22177b.rRO;
            int aah = C22178a.aah(str2);
            C4133a c4133a = C43644j.rST;
            for (C39879j c39879j : C4133a.cxT().mo74412dm(str, aah)) {
                cfb cBR = c39879j.cBR();
                if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                    C4126a c4126a = C43640g.rWe;
                    arrayList.add(C4126a.m6453c(c39879j));
                    C4990ab.m7416i(C39876h.TAG, "getGalleryItemsFromDbByDate story username " + str + ' ' + arrayList.size() + ' ' + "content " + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + " id:" + c39879j.field_storyID + " storyUsername: " + c39879j.field_userName);
                }
            }
            AppMethodBeat.m2505o(109586);
            return arrayList;
        }

        /* renamed from: b */
        public static ArrayList<C43640g> m46504b(String str, boolean z, ArrayList<Long> arrayList) {
            AppMethodBeat.m2504i(138806);
            C25052j.m39376p(str, "username");
            C8901a c8901a = new C8901a("getGalleryItemsFromDbByStoryId");
            ArrayList arrayList2 = new ArrayList();
            C4133a c4133a = C43644j.rST;
            Collection arrayList3 = new ArrayList();
            for (Object next : C4133a.cxT().mo74406bw(str, z)) {
                if (arrayList != null ? arrayList.contains(Long.valueOf(((C39879j) next).field_storyID)) : true) {
                    arrayList3.add(next);
                }
            }
            for (C39879j c39879j : (List) arrayList3) {
                cfb cBR = c39879j.cBR();
                if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                    C4126a c4126a = C43640g.rWe;
                    arrayList2.add(C4126a.m6452a(c39879j, C22234h.UNREAD_FIRST));
                    C4990ab.m7416i(C39876h.TAG, "getGalleryItemsFromDbByStoryId story:" + c39879j + ", content:" + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + ", id:" + c39879j.field_storyID + ", storyUsername:" + c39879j.field_userName);
                }
            }
            c8901a.mo20314SW();
            AppMethodBeat.m2505o(138806);
            return arrayList2;
        }

        /* renamed from: m */
        public static C0601b m46508m(List<C43640g> list, List<C43640g> list2) {
            AppMethodBeat.m2504i(109587);
            C25052j.m39376p(list, "oldItems");
            C25052j.m39376p(list2, "newItems");
            C0601b a = C0595c.m1289a(new C4112a(list, list2), false);
            C25052j.m39375o(a, "DiffUtil.calculateDiff(o…  }\n            }, false)");
            AppMethodBeat.m2505o(109587);
            return a;
        }
    }

    public void resume() {
    }

    public void pause() {
    }

    public void destroy() {
    }

    /* renamed from: EO */
    public void mo37740EO(int i) {
    }

    public void czC() {
    }

    public void czE() {
    }

    /* renamed from: fM */
    public void mo37746fM(int i, int i2) {
    }

    public void czB() {
    }

    /* renamed from: fN */
    public void mo37747fN(int i, int i2) {
    }

    /* renamed from: ES */
    public void mo37741ES(int i) {
    }

    /* renamed from: ET */
    public void mo37742ET(int i) {
    }

    /* renamed from: n */
    public void mo37753n(int i, int i2, boolean z) {
    }

    /* renamed from: o */
    public void mo37754o(int i, int i2, boolean z) {
    }
}
