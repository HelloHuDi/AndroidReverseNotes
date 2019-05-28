package com.tencent.mm.plugin.story.model.a;

import a.a.t;
import a.f.b.j;
import a.f.b.u;
import a.l;
import a.v;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cez;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002)*B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0012J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010&\u001a\u00020\u0004H\u0014J\u0012\u0010'\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0019H\u0014R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class i extends m implements k {
    private static final String TAG = TAG;
    private static final LinkedList<Object> rUW = new LinkedList();
    public static final a rUX = new a();
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    private b rUU = new b();
    private final int rUV = 10;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$Companion;", "", "()V", "MM_STORY_SYNCCMD_COMMENT", "", "MM_STORY_SYNCCMD_COMMENT_DEL", "MM_STORY_SYNCCMD_POST", "MM_STORY_SYNCCMD_POST_DEL", "TAG", "", "notifyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/IOnStoryNotify;", "addNotifyListener", "", "listener", "removeNotifyListener", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
    public final class b {
        LinkedList<tb> mgm;
        ak mgn = new a(this);

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
        public static final class a extends ak {
            final /* synthetic */ b rUZ;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            static final class d implements Runnable {
                final /* synthetic */ a rVa;
                final /* synthetic */ tb rVb;

                d(a aVar, tb tbVar) {
                    this.rVa = aVar;
                    this.rVb = tbVar;
                }

                public final void run() {
                    AppMethodBeat.i(109242);
                    tb tbVar = this.rVb;
                    j.o(tbVar, "item");
                    if (!i.f(tbVar, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(109242);
                }
            }

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            static final class b implements Runnable {
                final /* synthetic */ a rVa;
                final /* synthetic */ tb rVb;

                b(a aVar, tb tbVar) {
                    this.rVa = aVar;
                    this.rVb = tbVar;
                }

                public final void run() {
                    AppMethodBeat.i(109240);
                    tb tbVar = this.rVb;
                    j.o(tbVar, "item");
                    if (!i.d(tbVar, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(109240);
                }
            }

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            static final class c implements Runnable {
                final /* synthetic */ a rVa;
                final /* synthetic */ tb rVb;

                c(a aVar, tb tbVar) {
                    this.rVa = aVar;
                    this.rVb = tbVar;
                }

                public final void run() {
                    AppMethodBeat.i(109241);
                    tb tbVar = this.rVb;
                    j.o(tbVar, "item");
                    if (!i.e(tbVar, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(109241);
                }
            }

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            static final class a implements Runnable {
                final /* synthetic */ a rVa;
                final /* synthetic */ tb rVb;

                a(a aVar, tb tbVar) {
                    this.rVa = aVar;
                    this.rVb = tbVar;
                }

                public final void run() {
                    AppMethodBeat.i(109239);
                    tb tbVar = this.rVb;
                    j.o(tbVar, "item");
                    if (!i.c(tbVar, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(109239);
                }
            }

            a(b bVar) {
                this.rUZ = bVar;
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.i(109243);
                j.p(message, "msg");
                if (g.RN().QY()) {
                    if (this.rUZ.mgm != null) {
                        LinkedList linkedList = this.rUZ.mgm;
                        if (linkedList == null) {
                            j.dWJ();
                        }
                        if (!linkedList.isEmpty()) {
                            linkedList = this.rUZ.mgm;
                            if (linkedList == null) {
                                j.dWJ();
                            }
                            tb tbVar = (tb) linkedList.getFirst();
                            ab.d(i.TAG, "cmdId = " + tbVar.wat);
                            LinkedList linkedList2 = this.rUZ.mgm;
                            if (linkedList2 == null) {
                                j.dWJ();
                            }
                            linkedList2.removeFirst();
                            com.tencent.mm.plugin.story.model.j.a aVar;
                            switch (tbVar.wat) {
                                case 1:
                                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                                    com.tencent.mm.plugin.story.model.j.a.cno().post(new a(this, tbVar));
                                    AppMethodBeat.o(109243);
                                    return;
                                case 2:
                                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                                    com.tencent.mm.plugin.story.model.j.a.cno().post(new b(this, tbVar));
                                    AppMethodBeat.o(109243);
                                    return;
                                case 3:
                                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                                    com.tencent.mm.plugin.story.model.j.a.cno().post(new c(this, tbVar));
                                    AppMethodBeat.o(109243);
                                    return;
                                case 4:
                                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                                    com.tencent.mm.plugin.story.model.j.a.cno().post(new d(this, tbVar));
                                    AppMethodBeat.o(109243);
                                    return;
                                default:
                                    sendEmptyMessage(0);
                                    AppMethodBeat.o(109243);
                                    return;
                            }
                        }
                    }
                    i.this.cyY();
                    AppMethodBeat.o(109243);
                    return;
                }
                AppMethodBeat.o(109243);
            }
        }

        public b() {
            AppMethodBeat.i(109244);
            AppMethodBeat.o(109244);
        }
    }

    public i() {
        AppMethodBeat.i(109252);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(new cez());
        aVar.b(new cfa());
        aVar.qq("/cgi-bin/micromsg-bin/mmstorysync");
        aVar.kU(513);
        aVar.kV(0);
        aVar.kW(0);
        com.tencent.mm.ai.b acD = aVar.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(109252);
            throw vVar;
        }
        ((cez) acz).vTN = 128;
        AppMethodBeat.o(109252);
    }

    static {
        AppMethodBeat.i(109253);
        AppMethodBeat.o(109253);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c7 A:{LOOP_END, LOOP:0: B:16:0x00c1->B:18:0x00c7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(tb tbVar, ak akVar) {
        AppMethodBeat.i(109245);
        j.p(tbVar, "item");
        j.p(akVar, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = tbVar.wau;
            j.o(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bt.a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(109245);
                throw vVar;
            }
            Object valueOf;
            Iterator it;
            cex = (cex) parseFrom;
            String str = cex.xex.ndG;
            int i = cex.xex.pcX;
            long j = cex.vQE;
            com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
            j.o(str, "username");
            com.tencent.mm.plugin.story.h.j a = com.tencent.mm.plugin.story.model.n.a.a(str, j, i, cex.xex.xdJ, false);
            com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
            com.tencent.mm.plugin.story.model.k.a(str, a);
            str = TAG;
            StringBuilder append = new StringBuilder("processStoryPost username:").append(cex.xex.ndG).append(" createTime:").append(cex.xex.pcX).append(" id:").append(cex.vQE).append(" scope:");
            if (a != null) {
                cfb cBR = a.cBR();
                if (cBR != null) {
                    valueOf = Integer.valueOf(cBR.xeC);
                    ab.i(str, append.append(valueOf).toString());
                    it = rUW.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    akVar.sendEmptyMessage(0);
                    AppMethodBeat.o(109245);
                    return true;
                }
            }
            valueOf = null;
            ab.i(str, append.append(valueOf).toString());
            it = rUW.iterator();
            while (it.hasNext()) {
            }
            akVar.sendEmptyMessage(0);
            AppMethodBeat.o(109245);
            return true;
        } catch (Exception e) {
            ab.w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.o(109245);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A:{LOOP_END, LOOP:0: B:32:0x0117->B:34:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009e A:{Catch:{ Exception -> 0x003c }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A:{LOOP_END, LOOP:0: B:32:0x0117->B:34:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089 A:{Catch:{ Exception -> 0x003c }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009e A:{Catch:{ Exception -> 0x003c }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A:{LOOP_END, LOOP:0: B:32:0x0117->B:34:0x011d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(tb tbVar, ak akVar) {
        AppMethodBeat.i(109246);
        j.p(tbVar, "item");
        j.p(akVar, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = tbVar.wau;
            j.o(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bt.a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(109246);
                throw vVar;
            }
            String str;
            String str2;
            float f;
            com.tencent.mm.plugin.story.model.k kVar;
            Iterator it;
            cex = (cex) parseFrom;
            String str3 = cex.xex.ndG;
            int i = cex.xex.pcX;
            long j = cex.vQE;
            com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
            j.o(str3, "username");
            com.tencent.mm.plugin.story.model.n.a.a(str3, j, i, null, true);
            aVar = n.rTi;
            com.tencent.mm.plugin.story.h.j aaB = com.tencent.mm.plugin.story.model.n.a.aaB(str3);
            cfb cBR = aaB.cBR();
            cea cea = cBR.xeA;
            if (cea != null) {
                LinkedList linkedList = cea.wbK;
                if (linkedList != null) {
                    cek cek = (cek) t.x(linkedList, 0);
                    if (cek != null) {
                        str = cek.wEH;
                        cea = cBR.xeA;
                        if (cea != null) {
                            linkedList = cea.wbK;
                            if (linkedList != null) {
                                cek = (cek) t.x(linkedList, 0);
                                if (cek != null) {
                                    str2 = cek.Url;
                                    cea = cBR.xeA;
                                    if (cea != null) {
                                        linkedList = cea.wbK;
                                        if (linkedList != null) {
                                            cek = (cek) t.x(linkedList, 0);
                                            if (cek != null) {
                                                f = cek.duration;
                                                kVar = com.tencent.mm.plugin.story.model.k.rTc;
                                                com.tencent.mm.plugin.story.model.k.a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
                                                ab.i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + com.tencent.mm.ab.b.fe(j));
                                                it = rUW.iterator();
                                                while (it.hasNext()) {
                                                    it.next();
                                                }
                                                akVar.sendEmptyMessage(0);
                                                AppMethodBeat.o(109246);
                                                return true;
                                            }
                                        }
                                    }
                                    f = 0.0f;
                                    kVar = com.tencent.mm.plugin.story.model.k.rTc;
                                    com.tencent.mm.plugin.story.model.k.a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
                                    ab.i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + com.tencent.mm.ab.b.fe(j));
                                    it = rUW.iterator();
                                    while (it.hasNext()) {
                                    }
                                    akVar.sendEmptyMessage(0);
                                    AppMethodBeat.o(109246);
                                    return true;
                                }
                            }
                        }
                        str2 = null;
                        cea = cBR.xeA;
                        if (cea != null) {
                        }
                        f = 0.0f;
                        kVar = com.tencent.mm.plugin.story.model.k.rTc;
                        com.tencent.mm.plugin.story.model.k.a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
                        ab.i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + com.tencent.mm.ab.b.fe(j));
                        it = rUW.iterator();
                        while (it.hasNext()) {
                        }
                        akVar.sendEmptyMessage(0);
                        AppMethodBeat.o(109246);
                        return true;
                    }
                }
            }
            str = null;
            cea = cBR.xeA;
            if (cea != null) {
            }
            str2 = null;
            cea = cBR.xeA;
            if (cea != null) {
            }
            f = 0.0f;
            kVar = com.tencent.mm.plugin.story.model.k.rTc;
            com.tencent.mm.plugin.story.model.k.a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
            ab.i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + com.tencent.mm.ab.b.fe(j));
            it = rUW.iterator();
            while (it.hasNext()) {
            }
            akVar.sendEmptyMessage(0);
            AppMethodBeat.o(109246);
            return true;
        } catch (Exception e) {
            ab.w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.o(109246);
            return false;
        }
    }

    public static boolean e(tb tbVar, ak akVar) {
        AppMethodBeat.i(109247);
        j.p(tbVar, "item");
        j.p(akVar, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = tbVar.wau;
            j.o(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bt.a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(109247);
                throw vVar;
            }
            c cVar;
            cex = (cex) parseFrom;
            String str = cex.xex.ndG;
            int i = cex.xex.pcX;
            long j = cex.vQE;
            ab.i(TAG, "processStoryComment username:" + str + " createTime:" + i + " id:" + j + " ulonglong " + com.tencent.mm.ab.b.fe(j));
            com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
            j.p(cex, "syncMsg");
            ab.i(com.tencent.mm.plugin.story.model.b.b.TAG, "addSyncComment " + cex.vQE + ' ' + cex.xex.wZG + ' ' + cex.xex.pcX);
            u.c cVar2 = new u.c();
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            cVar2.AVE = com.tencent.mm.plugin.story.model.j.a.cxW().lr(cex.xex.vQE);
            if (((c) cVar2.AVE) == null) {
                cVar2.AVE = new c();
                ((c) cVar2.AVE).field_storyId = cex.vQE;
            }
            com.tencent.mm.plugin.story.model.b.b.a(cex);
            if (((c) cVar2.AVE).field_readCommentTime == 0) {
                Integer valueOf;
                LinkedList linkedList;
                cdv cdv;
                if (bo.isNullOrNil(cex.xex.ncM)) {
                    linkedList = cex.xex.xdJ.xeq;
                    j.o(linkedList, "bubbleList");
                    cdv = (cdv) t.x(linkedList, linkedList.size() - 2);
                    valueOf = cdv != null ? Integer.valueOf(cdv.pcX) : null;
                } else {
                    linkedList = cex.xex.xdJ.xeo;
                    j.o(linkedList, "commentList");
                    cdv = (cdv) t.x(linkedList, linkedList.size() - 2);
                    valueOf = cdv != null ? Integer.valueOf(cdv.pcX) : null;
                }
                cVar = (c) cVar2.AVE;
                if (valueOf != null) {
                    i = valueOf.intValue();
                } else {
                    i = 1;
                }
                cVar.field_readCommentTime = i;
            }
            cVar = (c) cVar2.AVE;
            String str2 = cex.xex.ndG;
            j.o(str2, "syncMsg.SyncMsgDetail.FromUserName");
            cVar.aaS(str2);
            cVar = (c) cVar2.AVE;
            str2 = cex.xex.xdJ.jBB;
            j.o(str2, "syncMsg.SyncMsgDetail.StoryObject.UserName");
            cVar.aaG(str2);
            ((c) cVar2.AVE).field_syncCommentId = cex.xex.wZG;
            ((c) cVar2.AVE).field_syncCommentTime = cex.xex.pcX;
            c cVar3 = (c) cVar2.AVE;
            int i2 = cVar3.field_commentFlag;
            com.tencent.mm.plugin.story.h.a.b bVar2 = com.tencent.mm.plugin.story.h.a.b.sdo;
            cVar3.field_commentFlag = i2 | com.tencent.mm.plugin.story.h.a.b.cBt();
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxW().a((c) cVar2.AVE);
            com.tencent.mm.ab.b.a(new com.tencent.mm.plugin.story.model.b.b.a(cVar2));
            Iterator it = rUW.iterator();
            while (it.hasNext()) {
                it.next();
            }
            akVar.sendEmptyMessage(0);
            AppMethodBeat.o(109247);
            return true;
        } catch (Exception e) {
            ab.w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.o(109247);
            return false;
        }
    }

    public static boolean f(tb tbVar, ak akVar) {
        AppMethodBeat.i(109248);
        j.p(tbVar, "item");
        j.p(akVar, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = tbVar.wau;
            j.o(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bt.a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(109248);
                throw vVar;
            }
            cex = (cex) parseFrom;
            String str = cex.xex.ndG;
            int i = cex.xex.pcX;
            ab.i(TAG, "processStoryCommentDel username:" + str + " createTime:" + i + " id:" + cex.vQE);
            com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
            j.p(cex, "syncMsg");
            ab.i(com.tencent.mm.plugin.story.model.b.b.TAG, "delSyncComment " + cex.vQE + ' ' + cex.xex.wZG);
            com.tencent.mm.plugin.story.model.b.b.g(cex.xex.vQE, cex.xex.wZG, cex.xex.ncM);
            com.tencent.mm.plugin.story.model.b.b.ld(cex.xex.vQE);
            Iterator it = rUW.iterator();
            while (it.hasNext()) {
                it.next();
            }
            akVar.sendEmptyMessage(0);
            AppMethodBeat.o(109248);
            return true;
        } catch (Exception e) {
            ab.w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.o(109248);
            return false;
        }
    }

    public final void cyY() {
        AppMethodBeat.i(109249);
        com.tencent.mm.bt.a acA = this.ehh.acA();
        v vVar;
        if (acA == null) {
            vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(109249);
            throw vVar;
        }
        cfa cfa = (cfa) acA;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(109249);
            throw vVar;
        }
        cez cez = (cez) acz;
        byte[] j = aa.j(cez.vTO.getBuffer().toByteArray(), cfa.vTO.getBuffer().toByteArray());
        if (j != null && j.length > 0) {
            e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(8195, bo.cd(j));
        }
        cez.vTO.setBuffer(j);
        if ((cfa.vQe & cez.vTN) == 0) {
            f fVar = this.ehi;
            if (fVar == null) {
                j.avw("callback");
            }
            fVar.onSceneEnd(0, 0, "", this);
            AppMethodBeat.o(109249);
            return;
        }
        com.tencent.mm.network.e acL = acL();
        j.o(acL, "dispatcher()");
        f fVar2 = this.ehi;
        if (fVar2 == null) {
            j.avw("callback");
        }
        a(acL, fVar2);
        AppMethodBeat.o(109249);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(109250);
        j.p(eVar, "dispatcher");
        j.p(fVar, "callback");
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        byte[] anf = bo.anf(bo.nullAsNil((String) RP.Ry().get(8195)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(anf);
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(109250);
            throw vVar;
        }
        ((cez) acz).vTO = sKBuiltinBuffer_t;
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109250);
        return a;
    }

    public final int getType() {
        return 513;
    }

    /* JADX WARNING: Missing block: B:14:0x0071, code skipped:
            if (r1 == null) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(109251);
        ab.d(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        f fVar;
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.bt.a acA = this.ehh.acA();
            v vVar;
            if (acA == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
                AppMethodBeat.o(109251);
                throw vVar;
            }
            LinkedList linkedList;
            cfa cfa = (cfa) acA;
            tc tcVar = cfa.vTR;
            if (tcVar != null) {
                linkedList = tcVar.jBw;
            }
            linkedList = new LinkedList();
            if (linkedList.size() > 0) {
                b bVar = this.rUU;
                j.p(linkedList, "cmdList");
                bVar.mgm = linkedList;
                bVar.mgn.sendEmptyMessage(0);
                AppMethodBeat.o(109251);
                return;
            }
            if (cfa.vTO != null) {
                SKBuiltinBuffer_t sKBuiltinBuffer_t = cfa.vTO;
                j.o(sKBuiltinBuffer_t, "resp.KeyBuf");
                if (sKBuiltinBuffer_t.getBuffer() != null) {
                    SKBuiltinBuffer_t sKBuiltinBuffer_t2 = cfa.vTO;
                    j.o(sKBuiltinBuffer_t2, "resp.KeyBuf");
                    byte[] toByteArray = sKBuiltinBuffer_t2.getBuffer().toByteArray();
                    acA = this.ehh.acz();
                    if (acA == null) {
                        vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
                        AppMethodBeat.o(109251);
                        throw vVar;
                    }
                    toByteArray = aa.j(((cez) acA).vTO.getBuffer().toByteArray(), toByteArray);
                    if (toByteArray != null) {
                        if (((toByteArray.length == 0 ? 1 : 0) == 0 ? 1 : 0) != 0) {
                            e RP = g.RP();
                            j.o(RP, "MMKernel.storage()");
                            RP.Ry().set(8195, bo.cd(toByteArray));
                        }
                    }
                }
            }
            fVar = this.ehi;
            if (fVar == null) {
                j.avw("callback");
            }
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109251);
            return;
        }
        fVar = this.ehi;
        if (fVar == null) {
            j.avw("callback");
        }
        fVar.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(109251);
    }

    public final int acn() {
        return this.rUV;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }
}
