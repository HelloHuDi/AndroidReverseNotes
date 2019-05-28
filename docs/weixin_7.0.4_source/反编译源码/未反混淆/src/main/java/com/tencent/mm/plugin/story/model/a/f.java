package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.k.d;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u001a\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0002J>\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006<"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f extends m implements k {
    private static final String TAG = TAG;
    public static final a rUR = new a();
    private int cvp;
    private boolean czr;
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public boolean qIW;
    private long qIX;
    private long qIY;
    private String qJA = "";
    public long qKi;
    private long rUP;
    public String userName;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public f(String str, long j, boolean z) {
        long j2 = 0;
        int i = 0;
        j.p(str, "userName");
        AppMethodBeat.i(109228);
        this.userName = str;
        this.qIX = j;
        this.czr = z;
        if (this.qIX == 0) {
            ab.i(TAG, "fp mUserName " + this.userName);
        } else {
            ab.i(TAG, "np mUserName " + this.userName);
        }
        com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
        int cAQ = com.tencent.mm.plugin.story.h.a.scy;
        com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
        this.cvp = cAQ | com.tencent.mm.plugin.story.h.a.scw;
        com.tencent.mm.ai.b.a aVar3 = new com.tencent.mm.ai.b.a();
        aVar3.a(new ceg());
        aVar3.b(new ceh());
        aVar3.qq("/cgi-bin/micromsg-bin/mmstoryhistorypage");
        aVar3.kU(191);
        aVar3.kV(0);
        aVar3.kW(0);
        b acD = aVar3.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
            AppMethodBeat.o(109228);
            throw vVar;
        }
        ceg ceg;
        ceg ceg2 = (ceg) acz;
        ceg2.jBB = this.userName;
        ceg2.wZU = this.qIX;
        this.qIW = this.qIX == 0;
        com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cyd();
        int aaC = com.tencent.mm.plugin.story.model.o.a.aaC(this.userName);
        com.tencent.mm.plugin.story.model.j.a aVar5 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
        if (!this.qIW) {
            j2 = this.qIX;
        }
        this.qIY = cxT.E(j2, aaC);
        ceg2.xbw = this.qIY;
        ceg2.xbx = 0;
        try {
            String dpA = bo.dpA();
            j.o(dpA, "Util.getTimeZoneOffset()");
            i = (int) Float.parseFloat(dpA);
            ceg = ceg2;
        } catch (Exception e) {
            ceg = ceg2;
        }
        ceg.lvg = i;
        if (this.qIW) {
            aVar4 = com.tencent.mm.plugin.story.model.j.rST;
            g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
            com.tencent.mm.plugin.story.h.a.a aVar6 = com.tencent.mm.plugin.story.h.a.sdm;
            this.qJA = cxU.aaV(com.tencent.mm.plugin.story.h.a.scD);
            if (this.qJA == null) {
                this.qJA = "";
            }
            ceg2.wZT = this.qJA;
        }
        this.rUP = this.qIX;
        ab.i(TAG, "req.mUserName:" + ceg2.jBB + " req.MaxId:" + ceg2.wZU + " req.MinFilterId:" + ceg2.xbw + " req.LastRequestTime:" + ceg2.xbx + " req.FirstPageMd5:" + ceg2.wZT + " req.TimeZone:" + ceg2.lvg);
        AppMethodBeat.o(109228);
    }

    static {
        AppMethodBeat.i(109229);
        AppMethodBeat.o(109229);
    }

    public final int getType() {
        return 191;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(109225);
        j.p(fVar, "callback");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109225);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(109226);
        ab.d(TAG, "netId=" + i + " errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        com.tencent.mm.bt.a acA = this.ehh.acA();
        if (acA == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
            AppMethodBeat.o(109226);
            throw vVar;
        }
        ceh ceh = (ceh) acA;
        this.qKi = ceh.xdM;
        String str2 = ceh.wZT;
        if (str2 == null) {
            str2 = "";
        }
        ab.i(TAG, "objCount:" + ceh.xec + " firstPageMd5:" + str2 + ", expiredTime:" + ceh.vAR);
        com.tencent.mm.ai.f fVar;
        if (ceh.xed.isEmpty()) {
            ab.d(TAG, "error: server give size zero");
            fVar = this.ehi;
            if (fVar == null) {
                j.avw("callback");
            }
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109226);
            return;
        }
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
        cxU.gB(com.tencent.mm.plugin.story.h.a.scD, str2);
        if (this.qIX == 0) {
            Object obj;
            long j = ((cef) ceh.xed.get(ceh.xed.size() - 1)).vQE;
            com.tencent.mm.plugin.story.model.n.a aVar3 = n.rTi;
            if (j > com.tencent.mm.plugin.story.model.n.a.aaB(this.userName).field_storyID) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                j = ((cef) ceh.xed.get(ceh.xed.size() - 1)).vQE;
                str2 = this.userName;
                com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                if (bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                    aVar3 = n.rTi;
                    str2 = this.userName;
                    j.p(str2, "userName");
                    aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.h.k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                    j.p(str2, "userName");
                    ab.d(com.tencent.mm.plugin.story.h.k.TAG, "deleteStoryByIdBefore " + str2 + ' ' + j + " res " + cxT.bSd.hY(com.tencent.mm.plugin.story.h.k.sdP, "DELETE FROM " + com.tencent.mm.plugin.story.h.k.sdP + " where " + com.tencent.mm.plugin.story.h.k.sdP + ".userName='" + bo.vA(str2) + "' AND " + com.tencent.mm.plugin.story.h.k.sdP + ".storyID<" + j));
                }
            }
        }
        a(ceh);
        fVar = this.ehi;
        if (fVar == null) {
            j.avw("callback");
        }
        fVar.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(109226);
    }

    private final void a(ceh ceh) {
        LinkedList linkedList;
        AppMethodBeat.i(109227);
        LinkedList<cef> linkedList2 = ceh.xed;
        j.o(linkedList2, "resp.HistoryItemList");
        for (cef cef : linkedList2) {
            ab.d(TAG, "date=" + cef.xdK + " count=" + cef.xds + " id=" + cef.vQE);
            com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
            String str = this.userName;
            cer cer = cef.xdJ;
            j.o(cer, "it.StoryObject");
            int i = this.cvp;
            j.p(str, "userName");
            j.p(cer, "storyObj");
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            ab.d(n.TAG, "insertStory storyObj.id:" + cer.vQE);
            com.tencent.mm.plugin.story.h.j lt = cxT.lt(cer.vQE);
            if (lt == null) {
                lt = new com.tencent.mm.plugin.story.h.j();
            }
            j.p(lt, "storyInfo");
            j.p(cer, "storyObj");
            j.p(str, "userName");
            if (cer.xen == null || cer.xen.getBuffer() == null) {
                ab.i(n.TAG, "object desc is null");
            } else {
                byte[] toByteArray = cer.xen.getBuffer().toByteArray();
                j.o(toByteArray, "storyObj.ObjDesc.getBuffer().toByteArray()");
                String str2 = new String(toByteArray, d.UTF_8);
                ab.d(n.TAG, "from server %d \n%s", Long.valueOf(cer.vQE), str2);
                com.tencent.mm.plugin.story.model.q.a aVar3 = com.tencent.mm.plugin.story.model.q.rTk;
                cfb aaE = com.tencent.mm.plugin.story.model.q.a.aaE(str2);
                if (!(bo.isNullOrNil(str2) || aaE == null || !lt.c(aaE))) {
                    ab.d(n.TAG, "from server xml ok %d \n ".concat(String.valueOf(str2)), Long.valueOf(cer.vQE));
                    cer.xen.setBuffer(new byte[0]);
                    lt.field_userName = cer.jBB;
                    lt.field_createTime = cer.pcX;
                    lt.field_storyID = cer.vQE;
                    if (!cer.xeo.isEmpty()) {
                        lt.field_attrBuf = cer.toByteArray();
                    }
                    ab.i(n.TAG, "id:" + lt.field_storyID + " createTime:" + lt.field_createTime + " CommentListSize:" + cer.xeo.size() + " BubbleListSize:" + cer.xeq.size());
                    lt.DF(i);
                    aaE = lt.cBR();
                    aaE.jBB = cer.jBB;
                    lt.b(aaE);
                    com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                    if (com.tencent.mm.plugin.story.model.j.a.cxT().kv(cer.vQE)) {
                        aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxT().b(cer.vQE, lt);
                        aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxT().lx(cer.vQE);
                    } else {
                        aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxT().d(lt);
                    }
                }
            }
            com.tencent.mm.plugin.story.model.m.a aVar5 = com.tencent.mm.plugin.story.model.m.rTh;
            j.o(cef, "it");
            j.p(cef, "item");
            com.tencent.mm.plugin.story.h.h.a aVar6 = h.sdT;
            j.p(cef, "item");
            h hVar = new h();
            String str3 = cef.xdK;
            if (str3 == null) {
                str3 = "";
            }
            hVar.field_date = str3;
            hVar.field_count = cef.xds;
            com.tencent.mm.plugin.story.model.j.a aVar7 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxZ().a(hVar);
        }
        if (this.qIX == 0) {
            linkedList = ceh.xed;
            j.o(linkedList, "resp.HistoryItemList");
            this.qIX = ((cef) linkedList.getFirst()).vQE;
        }
        linkedList = ceh.xed;
        j.o(linkedList, "resp.HistoryItemList");
        this.qIY = ((cef) linkedList.getLast()).vQE;
        ab.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", this.userName, Long.valueOf(this.qIX), Long.valueOf(this.qIY), Integer.valueOf(ceh.xbC));
        AppMethodBeat.o(109227);
    }
}
