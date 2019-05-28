package com.tencent.mm.plugin.story.model;

import a.k.d;
import a.l;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.a.m;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n {
    private static final String TAG = TAG;
    public static final a rTi = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0014\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\bJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e2\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 2\u0006\u0010\u001c\u001a\u00020\bJ\u0016\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\bJ&\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bJ\u001e\u0010)\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0011J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bJ&\u0010,\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011J\u001a\u0010/\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u00010\u0004J2\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "storyId", "", "deleteStoryByIdBefore", "", "userName", "deleteStoryByTimeBefore", "timeStamp", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static LinkedList<j> b(String str, List<? extends cer> list, int i) {
            AppMethodBeat.i(109119);
            a.f.b.j.p(str, "userName");
            if (list == null || list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                AppMethodBeat.o(109119);
                return linkedList;
            }
            LinkedList<j> linkedList2 = new LinkedList();
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                cer cer = (cer) list.get(i2);
                ab.d(n.TAG, "storyObj.id:" + cer.vQE);
                j lt = cxT.lt(cer.vQE);
                if (lt == null) {
                    lt = new j();
                }
                if (!(a(lt, cer, i) == 0 || lt.field_storyID == 0)) {
                    linkedList2.add(lt);
                }
            }
            AppMethodBeat.o(109119);
            return linkedList2;
        }

        public static long a(j jVar, cer cer, int i) {
            AppMethodBeat.i(138748);
            a.f.b.j.p(jVar, "storyInfo");
            a.f.b.j.p(cer, "storyObj");
            long j;
            if (cer.xen == null || cer.xen.getBuffer() == null) {
                ab.i(n.TAG, "object desc is null");
                j = cer.vQE;
                AppMethodBeat.o(138748);
                return j;
            }
            byte[] toByteArray = cer.xen.getBuffer().toByteArray();
            a.f.b.j.o(toByteArray, "storyObj.ObjDesc.getBuffer().toByteArray()");
            String str = new String(toByteArray, d.UTF_8);
            ab.d(n.TAG, "from server %d \n%s", Long.valueOf(cer.vQE), str);
            com.tencent.mm.plugin.story.model.q.a aVar = q.rTk;
            cfb aaE = com.tencent.mm.plugin.story.model.q.a.aaE(str);
            if (bo.isNullOrNil(str) || aaE == null) {
                j = cer.vQE;
                AppMethodBeat.o(138748);
                return j;
            } else if (jVar.c(aaE)) {
                com.tencent.mm.plugin.story.h.a.a aVar2;
                ab.d(n.TAG, "from server xml ok %d \n ".concat(String.valueOf(str)), Long.valueOf(cer.vQE));
                cer.xen.setBuffer(new byte[0]);
                jVar.field_userName = cer.jBB;
                jVar.field_createTime = cer.pcX;
                jVar.field_storyID = cer.vQE;
                jVar.field_attrBuf = cer.toByteArray();
                if (cer.xer == 1) {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    jVar.Fc(com.tencent.mm.plugin.story.h.a.sdd);
                } else {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    jVar.Fd(com.tencent.mm.plugin.story.h.a.sdd);
                }
                if (cer.xek == 1) {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    jVar.Fc(com.tencent.mm.plugin.story.h.a.sde);
                } else {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    jVar.Fd(com.tencent.mm.plugin.story.h.a.sde);
                }
                jVar.field_favoriteTime = cer.xes;
                jVar.DF(i);
                aaE = jVar.cBR();
                aaE.jBB = cer.jBB;
                jVar.b(aaE);
                ab.d(n.TAG, "will replaceUserByPcId " + cer.vQE);
                com.tencent.mm.plugin.story.model.j.a aVar3 = j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxT().c(cer.vQE, jVar);
                j = cer.vQE;
                AppMethodBeat.o(138748);
                return j;
            } else {
                j = cer.vQE;
                AppMethodBeat.o(138748);
                return j;
            }
        }

        public static boolean dl(String str, int i) {
            AppMethodBeat.i(109121);
            a.f.b.j.p(str, "userName");
            boolean z = false;
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
            for (j cBR : cxT.a(str, bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk()), i, true)) {
                boolean z2;
                cfb cBR2 = cBR.cBR();
                if (cBR2.xeA == null || cBR2.xeA.wbK.size() == 0) {
                    z2 = z;
                } else {
                    z2 = true;
                }
                z = z2;
            }
            AppMethodBeat.o(109121);
            return z;
        }

        public static void D(long j, int i) {
            AppMethodBeat.i(109122);
            ab.d(n.TAG, "delete story item: " + i + ' ' + j);
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            arrayList.add(new m(j, com.tencent.mm.plugin.story.h.a.scL));
            b RO = g.RO();
            a.f.b.j.o(RO, "MMKernel.network()");
            RO.Rg().d((com.tencent.mm.ai.m) new com.tencent.mm.plugin.story.model.a.g(arrayList, i));
            AppMethodBeat.o(109122);
        }

        public static void EL(int i) {
            String str = null;
            AppMethodBeat.i(109123);
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(i);
            com.tencent.mm.plugin.story.e.b.a aVar2 = com.tencent.mm.plugin.story.e.b.rRO;
            String j = com.tencent.mm.plugin.story.e.b.a.j(Fe != null ? Integer.valueOf(Fe.field_createTime) : null);
            com.tencent.mm.plugin.story.model.j.a aVar3 = j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().DL(i);
            aVar3 = j.rST;
            h aaZ = com.tencent.mm.plugin.story.model.j.a.cxZ().aaZ(j);
            if (aaZ != null) {
                aaZ.field_count--;
                if (aaZ.field_count <= 0) {
                    com.tencent.mm.plugin.story.model.j.a aVar4 = j.rST;
                    i cxZ = com.tencent.mm.plugin.story.model.j.a.cxZ();
                    a.f.b.j.p(j, FFmpegMetadataRetriever.METADATA_KEY_DATE);
                    cxZ.bSd.delete(i.sdP, "date=?", new String[]{String.valueOf(j)});
                    AppMethodBeat.o(109123);
                    return;
                }
                if (Fe != null) {
                    str = Fe.field_userName;
                }
                if (!(str == null || j == null)) {
                    com.tencent.mm.plugin.story.model.j.a aVar5 = j.rST;
                    k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                    com.tencent.mm.plugin.story.e.b.a aVar6 = com.tencent.mm.plugin.story.e.b.rRO;
                    List dm = cxT.dm(str, com.tencent.mm.plugin.story.e.b.a.aah(j));
                    if (!dm.isEmpty()) {
                        j jVar = (j) dm.get(0);
                        com.tencent.mm.plugin.story.h.a.a aVar7 = com.tencent.mm.plugin.story.h.a.sdm;
                        jVar.DF(com.tencent.mm.plugin.story.h.a.scy);
                        aVar = j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxT().a((int) ((j) dm.get(0)).xDa, (j) dm.get(0));
                        ab.d(n.TAG, "update " + ((int) ((j) dm.get(0)).xDa) + "'s sourceType to " + ((j) dm.get(0)).field_sourceType + ' ');
                    }
                }
                aVar = j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxZ().a(aaZ);
            }
            AppMethodBeat.o(109123);
        }

        public static void b(long j, int i, boolean z, boolean z2) {
            AppMethodBeat.i(109124);
            ab.d(n.TAG, "setPrivacyRemote story item: " + j + " to " + z);
            ArrayList arrayList = new ArrayList();
            int i2 = z ? 1 : 0;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            arrayList.add(new com.tencent.mm.plugin.story.model.a.n(j, com.tencent.mm.plugin.story.h.a.scN, i2, z2));
            b RO = g.RO();
            a.f.b.j.o(RO, "MMKernel.network()");
            RO.Rg().d((com.tencent.mm.ai.m) new com.tencent.mm.plugin.story.model.a.g(arrayList, i));
            AppMethodBeat.o(109124);
        }

        public static void h(long j, int i, boolean z) {
            AppMethodBeat.i(109125);
            ab.d(n.TAG, "setStoryFavRemote story item: " + j + " to " + z);
            ArrayList arrayList = new ArrayList();
            int i2 = z ? 1 : 0;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            arrayList.add(new com.tencent.mm.plugin.story.model.a.l(j, com.tencent.mm.plugin.story.h.a.scO, i2));
            b RO = g.RO();
            a.f.b.j.o(RO, "MMKernel.network()");
            RO.Rg().d((com.tencent.mm.ai.m) new com.tencent.mm.plugin.story.model.a.g(arrayList, i));
            AppMethodBeat.o(109125);
        }

        public static void fJ(int i, int i2) {
            AppMethodBeat.i(109126);
            ab.d(n.TAG, "setPrivacyLocal story item: " + i + " to " + i2);
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            j Fe = cxT.Fe(i);
            if (Fe != null) {
                com.tencent.mm.plugin.story.h.a.a aVar2;
                if (i2 == 1) {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    Fe.Fc(com.tencent.mm.plugin.story.h.a.sdd);
                } else {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    Fe.Fd(com.tencent.mm.plugin.story.h.a.sdd);
                }
                cxT.a(Fe);
                AppMethodBeat.o(109126);
                return;
            }
            AppMethodBeat.o(109126);
        }

        public static void fK(int i, int i2) {
            AppMethodBeat.i(109127);
            ab.d(n.TAG, "setStoryFavLocal story item: " + i + " to " + i2);
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            j Fe = cxT.Fe(i);
            if (Fe != null) {
                com.tencent.mm.plugin.story.h.a.a aVar2;
                if (i2 == 1) {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    Fe.Fc(com.tencent.mm.plugin.story.h.a.sde);
                    Fe.field_favoriteTime = cb.aaF();
                } else {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    Fe.Fd(com.tencent.mm.plugin.story.h.a.sde);
                    Fe.field_favoriteTime = 0;
                }
                cxT.a(Fe);
                AppMethodBeat.o(109127);
                return;
            }
            AppMethodBeat.o(109127);
        }

        public static void cyo() {
            AppMethodBeat.i(109128);
            b RO = g.RO();
            a.f.b.j.o(RO, "MMKernel.network()");
            RO.Rg().cancel(764);
            AppMethodBeat.o(109128);
        }

        public static j a(String str, long j, int i, cer cer, boolean z) {
            AppMethodBeat.i(109129);
            a.f.b.j.p(str, "username");
            com.tencent.mm.plugin.story.model.j.a aVar;
            if (z) {
                aVar = j.rST;
                k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                a.f.b.j.p(str, "username");
                cxT.lw(j);
                j jVar = new j();
                jVar.field_userName = str;
                jVar.field_storyID = j;
                cxT.b("notify_story_info_delete", 1, jVar);
                AppMethodBeat.o(109129);
                return null;
            }
            int cAO;
            aVar = j.rST;
            j lt = com.tencent.mm.plugin.story.model.j.a.cxT().lt(j);
            if (lt == null) {
                lt = new j();
            }
            lt.field_storyID = j;
            lt.field_createTime = i;
            lt.field_userName = str;
            com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
            com.tencent.mm.plugin.story.h.a.a aVar3;
            if (bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                cAO = com.tencent.mm.plugin.story.h.a.scw;
            } else {
                aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                cAO = com.tencent.mm.plugin.story.h.a.scx;
            }
            lt.DF(cAO);
            if (cer != null) {
                a(lt, cer, lt.field_sourceType);
            } else {
                aVar2 = j.rST;
                lt.cNE = com.tencent.mm.plugin.story.model.j.a.cxT().d(lt);
            }
            AppMethodBeat.o(109129);
            return lt;
        }

        public static j aaB(String str) {
            AppMethodBeat.i(109130);
            a.f.b.j.p(str, "username");
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            aVar = j.rST;
            boolean isEqual = bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), str);
            a.f.b.j.p(str, "userName");
            j jVar = new j();
            Cursor a = cxT.bSd.a((("select *,rowid from MMStoryInfo " + k.bm(str, isEqual)) + (isEqual ? k.rfn : " AND " + k.seg + k.rfn)) + " limit 1", null, 2);
            if (a.moveToFirst()) {
                a.f.b.j.o(a, "cu");
                jVar.d(a);
            }
            a.close();
            AppMethodBeat.o(109130);
            return jVar;
        }
    }

    static {
        AppMethodBeat.i(109132);
        AppMethodBeat.o(109132);
    }
}
