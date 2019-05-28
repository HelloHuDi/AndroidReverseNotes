package com.tencent.p177mm.plugin.story.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.model.p744a.C29300n;
import com.tencent.p177mm.plugin.story.model.p744a.C35197l;
import com.tencent.p177mm.plugin.story.model.p744a.C35198m;
import com.tencent.p177mm.plugin.story.model.p744a.C7138g;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46274i;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.n */
public final class C29310n {
    private static final String TAG = TAG;
    public static final C29311a rTi = new C29311a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0014\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\bJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e2\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 2\u0006\u0010\u001c\u001a\u00020\bJ\u0016\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\bJ&\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bJ\u001e\u0010)\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0011J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bJ&\u0010,\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011J\u001a\u0010/\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u00010\u0004J2\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "storyId", "", "deleteStoryByIdBefore", "", "userName", "deleteStoryByTimeBefore", "timeStamp", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.n$a */
    public static final class C29311a {
        private C29311a() {
        }

        public /* synthetic */ C29311a(byte b) {
            this();
        }

        /* renamed from: b */
        public static LinkedList<C39879j> m46534b(String str, List<? extends cer> list, int i) {
            AppMethodBeat.m2504i(109119);
            C25052j.m39376p(str, "userName");
            if (list == null || list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                AppMethodBeat.m2505o(109119);
                return linkedList;
            }
            LinkedList<C39879j> linkedList2 = new LinkedList();
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                cer cer = (cer) list.get(i2);
                C4990ab.m7410d(C29310n.TAG, "storyObj.id:" + cer.vQE);
                C39879j lt = cxT.mo74415lt(cer.vQE);
                if (lt == null) {
                    lt = new C39879j();
                }
                if (!(C29311a.m46532a(lt, cer, i) == 0 || lt.field_storyID == 0)) {
                    linkedList2.add(lt);
                }
            }
            AppMethodBeat.m2505o(109119);
            return linkedList2;
        }

        /* renamed from: a */
        public static long m46532a(C39879j c39879j, cer cer, int i) {
            AppMethodBeat.m2504i(138748);
            C25052j.m39376p(c39879j, "storyInfo");
            C25052j.m39376p(cer, "storyObj");
            long j;
            if (cer.xen == null || cer.xen.getBuffer() == null) {
                C4990ab.m7416i(C29310n.TAG, "object desc is null");
                j = cer.vQE;
                AppMethodBeat.m2505o(138748);
                return j;
            }
            byte[] toByteArray = cer.xen.getBuffer().toByteArray();
            C25052j.m39375o(toByteArray, "storyObj.ObjDesc.getBuffer().toByteArray()");
            String str = new String(toByteArray, C17355d.UTF_8);
            C4990ab.m7411d(C29310n.TAG, "from server %d \n%s", Long.valueOf(cer.vQE), str);
            C39911a c39911a = C43647q.rTk;
            cfb aaE = C39911a.aaE(str);
            if (C5046bo.isNullOrNil(str) || aaE == null) {
                j = cer.vQE;
                AppMethodBeat.m2505o(138748);
                return j;
            } else if (c39879j.mo63084c(aaE)) {
                C35184a c35184a;
                C4990ab.m7411d(C29310n.TAG, "from server xml ok %d \n ".concat(String.valueOf(str)), Long.valueOf(cer.vQE));
                cer.xen.setBuffer(new byte[0]);
                c39879j.field_userName = cer.jBB;
                c39879j.field_createTime = cer.pcX;
                c39879j.field_storyID = cer.vQE;
                c39879j.field_attrBuf = cer.toByteArray();
                if (cer.xer == 1) {
                    c35184a = C35183a.sdm;
                    c39879j.mo63080Fc(C35183a.sdd);
                } else {
                    c35184a = C35183a.sdm;
                    c39879j.mo63081Fd(C35183a.sdd);
                }
                if (cer.xek == 1) {
                    c35184a = C35183a.sdm;
                    c39879j.mo63080Fc(C35183a.sde);
                } else {
                    c35184a = C35183a.sdm;
                    c39879j.mo63081Fd(C35183a.sde);
                }
                c39879j.field_favoriteTime = cer.xes;
                c39879j.mo63079DF(i);
                aaE = c39879j.cBR();
                aaE.jBB = cer.jBB;
                c39879j.mo63082b(aaE);
                C4990ab.m7410d(C29310n.TAG, "will replaceUserByPcId " + cer.vQE);
                C4133a c4133a = C43644j.rST;
                C4133a.cxT().mo74408c(cer.vQE, c39879j);
                j = cer.vQE;
                AppMethodBeat.m2505o(138748);
                return j;
            } else {
                j = cer.vQE;
                AppMethodBeat.m2505o(138748);
                return j;
            }
        }

        /* renamed from: dl */
        public static boolean m46536dl(String str, int i) {
            AppMethodBeat.m2504i(109121);
            C25052j.m39376p(str, "userName");
            boolean z = false;
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            C4133a c4133a2 = C43644j.rST;
            for (C39879j cBR : cxT.mo74399a(str, C5046bo.isEqual(str, C4133a.cnk()), i, true)) {
                boolean z2;
                cfb cBR2 = cBR.cBR();
                if (cBR2.xeA == null || cBR2.xeA.wbK.size() == 0) {
                    z2 = z;
                } else {
                    z2 = true;
                }
                z = z2;
            }
            AppMethodBeat.m2505o(109121);
            return z;
        }

        /* renamed from: D */
        public static void m46530D(long j, int i) {
            AppMethodBeat.m2504i(109122);
            C4990ab.m7410d(C29310n.TAG, "delete story item: " + i + ' ' + j);
            ArrayList arrayList = new ArrayList();
            C35184a c35184a = C35183a.sdm;
            arrayList.add(new C35198m(j, C35183a.scL));
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().mo14552d((C1207m) new C7138g(arrayList, i));
            AppMethodBeat.m2505o(109122);
        }

        /* renamed from: EL */
        public static void m46531EL(int i) {
            String str = null;
            AppMethodBeat.m2504i(109123);
            C4133a c4133a = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe(i);
            C22178a c22178a = C22177b.rRO;
            String j = C22178a.m33804j(Fe != null ? Integer.valueOf(Fe.field_createTime) : null);
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxT().mo74394DL(i);
            c4133a2 = C43644j.rST;
            C22213h aaZ = C4133a.cxZ().aaZ(j);
            if (aaZ != null) {
                aaZ.field_count--;
                if (aaZ.field_count <= 0) {
                    C4133a c4133a3 = C43644j.rST;
                    C46274i cxZ = C4133a.cxZ();
                    C25052j.m39376p(j, FFmpegMetadataRetriever.METADATA_KEY_DATE);
                    cxZ.bSd.delete(C46274i.sdP, "date=?", new String[]{String.valueOf(j)});
                    AppMethodBeat.m2505o(109123);
                    return;
                }
                if (Fe != null) {
                    str = Fe.field_userName;
                }
                if (!(str == null || j == null)) {
                    C4133a c4133a4 = C43644j.rST;
                    C46275k cxT = C4133a.cxT();
                    C22178a c22178a2 = C22177b.rRO;
                    List dm = cxT.mo74412dm(str, C22178a.aah(j));
                    if (!dm.isEmpty()) {
                        C39879j c39879j = (C39879j) dm.get(0);
                        C35184a c35184a = C35183a.sdm;
                        c39879j.mo63079DF(C35183a.scy);
                        c4133a = C43644j.rST;
                        C4133a.cxT().mo74398a((int) ((C39879j) dm.get(0)).xDa, (C39879j) dm.get(0));
                        C4990ab.m7410d(C29310n.TAG, "update " + ((int) ((C39879j) dm.get(0)).xDa) + "'s sourceType to " + ((C39879j) dm.get(0)).field_sourceType + ' ');
                    }
                }
                c4133a = C43644j.rST;
                C4133a.cxZ().mo74392a(aaZ);
            }
            AppMethodBeat.m2505o(109123);
        }

        /* renamed from: b */
        public static void m46535b(long j, int i, boolean z, boolean z2) {
            AppMethodBeat.m2504i(109124);
            C4990ab.m7410d(C29310n.TAG, "setPrivacyRemote story item: " + j + " to " + z);
            ArrayList arrayList = new ArrayList();
            int i2 = z ? 1 : 0;
            C35184a c35184a = C35183a.sdm;
            arrayList.add(new C29300n(j, C35183a.scN, i2, z2));
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().mo14552d((C1207m) new C7138g(arrayList, i));
            AppMethodBeat.m2505o(109124);
        }

        /* renamed from: h */
        public static void m46539h(long j, int i, boolean z) {
            AppMethodBeat.m2504i(109125);
            C4990ab.m7410d(C29310n.TAG, "setStoryFavRemote story item: " + j + " to " + z);
            ArrayList arrayList = new ArrayList();
            int i2 = z ? 1 : 0;
            C35184a c35184a = C35183a.sdm;
            arrayList.add(new C35197l(j, C35183a.scO, i2));
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().mo14552d((C1207m) new C7138g(arrayList, i));
            AppMethodBeat.m2505o(109125);
        }

        /* renamed from: fJ */
        public static void m46537fJ(int i, int i2) {
            AppMethodBeat.m2504i(109126);
            C4990ab.m7410d(C29310n.TAG, "setPrivacyLocal story item: " + i + " to " + i2);
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            C39879j Fe = cxT.mo74397Fe(i);
            if (Fe != null) {
                C35184a c35184a;
                if (i2 == 1) {
                    c35184a = C35183a.sdm;
                    Fe.mo63080Fc(C35183a.sdd);
                } else {
                    c35184a = C35183a.sdm;
                    Fe.mo63081Fd(C35183a.sdd);
                }
                cxT.mo10099a(Fe);
                AppMethodBeat.m2505o(109126);
                return;
            }
            AppMethodBeat.m2505o(109126);
        }

        /* renamed from: fK */
        public static void m46538fK(int i, int i2) {
            AppMethodBeat.m2504i(109127);
            C4990ab.m7410d(C29310n.TAG, "setStoryFavLocal story item: " + i + " to " + i2);
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            C39879j Fe = cxT.mo74397Fe(i);
            if (Fe != null) {
                C35184a c35184a;
                if (i2 == 1) {
                    c35184a = C35183a.sdm;
                    Fe.mo63080Fc(C35183a.sde);
                    Fe.field_favoriteTime = C1839cb.aaF();
                } else {
                    c35184a = C35183a.sdm;
                    Fe.mo63081Fd(C35183a.sde);
                    Fe.field_favoriteTime = 0;
                }
                cxT.mo10099a(Fe);
                AppMethodBeat.m2505o(109127);
                return;
            }
            AppMethodBeat.m2505o(109127);
        }

        public static void cyo() {
            AppMethodBeat.m2504i(109128);
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().cancel(764);
            AppMethodBeat.m2505o(109128);
        }

        /* renamed from: a */
        public static C39879j m46533a(String str, long j, int i, cer cer, boolean z) {
            AppMethodBeat.m2504i(109129);
            C25052j.m39376p(str, "username");
            C4133a c4133a;
            if (z) {
                c4133a = C43644j.rST;
                C46275k cxT = C4133a.cxT();
                C25052j.m39376p(str, "username");
                cxT.mo74416lw(j);
                C39879j c39879j = new C39879j();
                c39879j.field_userName = str;
                c39879j.field_storyID = j;
                cxT.mo15641b("notify_story_info_delete", 1, c39879j);
                AppMethodBeat.m2505o(109129);
                return null;
            }
            int cAO;
            c4133a = C43644j.rST;
            C39879j lt = C4133a.cxT().mo74415lt(j);
            if (lt == null) {
                lt = new C39879j();
            }
            lt.field_storyID = j;
            lt.field_createTime = i;
            lt.field_userName = str;
            C4133a c4133a2 = C43644j.rST;
            C35184a c35184a;
            if (C5046bo.isEqual(str, C4133a.cnk())) {
                c35184a = C35183a.sdm;
                cAO = C35183a.scw;
            } else {
                c35184a = C35183a.sdm;
                cAO = C35183a.scx;
            }
            lt.mo63079DF(cAO);
            if (cer != null) {
                C29311a.m46532a(lt, cer, lt.field_sourceType);
            } else {
                c4133a2 = C43644j.rST;
                lt.cNE = C4133a.cxT().mo74411d(lt);
            }
            AppMethodBeat.m2505o(109129);
            return lt;
        }

        public static C39879j aaB(String str) {
            AppMethodBeat.m2504i(109130);
            C25052j.m39376p(str, "username");
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            c4133a = C43644j.rST;
            boolean isEqual = C5046bo.isEqual(C4133a.cnk(), str);
            C25052j.m39376p(str, "userName");
            C39879j c39879j = new C39879j();
            Cursor a = cxT.bSd.mo10104a((("select *,rowid from MMStoryInfo " + C46275k.m86721bm(str, isEqual)) + (isEqual ? C46275k.rfn : " AND " + C46275k.seg + C46275k.rfn)) + " limit 1", null, 2);
            if (a.moveToFirst()) {
                C25052j.m39375o(a, "cu");
                c39879j.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(109130);
            return c39879j;
        }
    }

    static {
        AppMethodBeat.m2504i(109132);
        AppMethodBeat.m2505o(109132);
    }
}
