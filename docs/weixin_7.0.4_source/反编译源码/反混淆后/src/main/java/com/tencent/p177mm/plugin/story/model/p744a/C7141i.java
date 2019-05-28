package com.tencent.p177mm.plugin.story.model.p744a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b.C22224a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35185b;
import com.tencent.p177mm.plugin.story.p532h.C35191c;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.protobuf.C35956tc;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cdv;
import com.tencent.p177mm.protocal.protobuf.cea;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cex;
import com.tencent.p177mm.protocal.protobuf.cez;
import com.tencent.p177mm.protocal.protobuf.cfa;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41381u.C31596c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002)*B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0012J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010&\u001a\u00020\u0004H\u0014J\u0012\u0010'\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0019H\u0014R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.i */
public final class C7141i extends C1207m implements C1918k {
    private static final String TAG = TAG;
    private static final LinkedList<Object> rUW = new LinkedList();
    public static final C7142a rUX = new C7142a();
    private final C7472b ehh;
    private C1202f ehi;
    private C7143b rUU = new C7143b();
    private final int rUV = 10;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$Companion;", "", "()V", "MM_STORY_SYNCCMD_COMMENT", "", "MM_STORY_SYNCCMD_COMMENT_DEL", "MM_STORY_SYNCCMD_POST", "MM_STORY_SYNCCMD_POST_DEL", "TAG", "", "notifyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/IOnStoryNotify;", "addNotifyListener", "", "listener", "removeNotifyListener", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.i$a */
    public static final class C7142a {
        private C7142a() {
        }

        public /* synthetic */ C7142a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.i$b */
    public final class C7143b {
        LinkedList<C40573tb> mgm;
        C7306ak mgn = new C7144a(this);

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.model.a.i$b$a */
        public static final class C7144a extends C7306ak {
            final /* synthetic */ C7143b rUZ;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.model.a.i$b$a$d */
            static final class C7145d implements Runnable {
                final /* synthetic */ C7144a rVa;
                final /* synthetic */ C40573tb rVb;

                C7145d(C7144a c7144a, C40573tb c40573tb) {
                    this.rVa = c7144a;
                    this.rVb = c40573tb;
                }

                public final void run() {
                    AppMethodBeat.m2504i(109242);
                    C40573tb c40573tb = this.rVb;
                    C25052j.m39375o(c40573tb, "item");
                    if (!C7141i.m11955f(c40573tb, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.m2505o(109242);
                }
            }

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.model.a.i$b$a$b */
            static final class C7146b implements Runnable {
                final /* synthetic */ C7144a rVa;
                final /* synthetic */ C40573tb rVb;

                C7146b(C7144a c7144a, C40573tb c40573tb) {
                    this.rVa = c7144a;
                    this.rVb = c40573tb;
                }

                public final void run() {
                    AppMethodBeat.m2504i(109240);
                    C40573tb c40573tb = this.rVb;
                    C25052j.m39375o(c40573tb, "item");
                    if (!C7141i.m11953d(c40573tb, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.m2505o(109240);
                }
            }

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.model.a.i$b$a$c */
            static final class C7147c implements Runnable {
                final /* synthetic */ C7144a rVa;
                final /* synthetic */ C40573tb rVb;

                C7147c(C7144a c7144a, C40573tb c40573tb) {
                    this.rVa = c7144a;
                    this.rVb = c40573tb;
                }

                public final void run() {
                    AppMethodBeat.m2504i(109241);
                    C40573tb c40573tb = this.rVb;
                    C25052j.m39375o(c40573tb, "item");
                    if (!C7141i.m11954e(c40573tb, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.m2505o(109241);
                }
            }

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.model.a.i$b$a$a */
            static final class C7148a implements Runnable {
                final /* synthetic */ C7144a rVa;
                final /* synthetic */ C40573tb rVb;

                C7148a(C7144a c7144a, C40573tb c40573tb) {
                    this.rVa = c7144a;
                    this.rVb = c40573tb;
                }

                public final void run() {
                    AppMethodBeat.m2504i(109239);
                    C40573tb c40573tb = this.rVb;
                    C25052j.m39375o(c40573tb, "item");
                    if (!C7141i.m11952c(c40573tb, this.rVa)) {
                        this.rVa.sendEmptyMessage(0);
                    }
                    AppMethodBeat.m2505o(109239);
                }
            }

            C7144a(C7143b c7143b) {
                this.rUZ = c7143b;
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(109243);
                C25052j.m39376p(message, "msg");
                if (C1720g.m3534RN().mo5161QY()) {
                    if (this.rUZ.mgm != null) {
                        LinkedList linkedList = this.rUZ.mgm;
                        if (linkedList == null) {
                            C25052j.dWJ();
                        }
                        if (!linkedList.isEmpty()) {
                            linkedList = this.rUZ.mgm;
                            if (linkedList == null) {
                                C25052j.dWJ();
                            }
                            C40573tb c40573tb = (C40573tb) linkedList.getFirst();
                            C4990ab.m7410d(C7141i.TAG, "cmdId = " + c40573tb.wat);
                            LinkedList linkedList2 = this.rUZ.mgm;
                            if (linkedList2 == null) {
                                C25052j.dWJ();
                            }
                            linkedList2.removeFirst();
                            C4133a c4133a;
                            switch (c40573tb.wat) {
                                case 1:
                                    c4133a = C43644j.rST;
                                    C4133a.cno().post(new C7148a(this, c40573tb));
                                    AppMethodBeat.m2505o(109243);
                                    return;
                                case 2:
                                    c4133a = C43644j.rST;
                                    C4133a.cno().post(new C7146b(this, c40573tb));
                                    AppMethodBeat.m2505o(109243);
                                    return;
                                case 3:
                                    c4133a = C43644j.rST;
                                    C4133a.cno().post(new C7147c(this, c40573tb));
                                    AppMethodBeat.m2505o(109243);
                                    return;
                                case 4:
                                    c4133a = C43644j.rST;
                                    C4133a.cno().post(new C7145d(this, c40573tb));
                                    AppMethodBeat.m2505o(109243);
                                    return;
                                default:
                                    sendEmptyMessage(0);
                                    AppMethodBeat.m2505o(109243);
                                    return;
                            }
                        }
                    }
                    C7141i.this.cyY();
                    AppMethodBeat.m2505o(109243);
                    return;
                }
                AppMethodBeat.m2505o(109243);
            }
        }

        public C7143b() {
            AppMethodBeat.m2504i(109244);
            AppMethodBeat.m2505o(109244);
        }
    }

    public C7141i() {
        AppMethodBeat.m2504i(109252);
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new cez());
        c1196a.mo4446b(new cfa());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstorysync");
        c1196a.mo4447kU(513);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.m2505o(109252);
            throw c44941v;
        }
        ((cez) acz).vTN = 128;
        AppMethodBeat.m2505o(109252);
    }

    static {
        AppMethodBeat.m2504i(109253);
        AppMethodBeat.m2505o(109253);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c7 A:{LOOP_END, LOOP:0: B:16:0x00c1->B:18:0x00c7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static boolean m11952c(C40573tb c40573tb, C7306ak c7306ak) {
        AppMethodBeat.m2504i(109245);
        C25052j.m39376p(c40573tb, "item");
        C25052j.m39376p(c7306ak, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = c40573tb.wau;
            C25052j.m39375o(sKBuiltinBuffer_t, "item.CmdBuf");
            C1331a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.m2505o(109245);
                throw c44941v;
            }
            Object valueOf;
            Iterator it;
            cex = (cex) parseFrom;
            String str = cex.xex.ndG;
            int i = cex.xex.pcX;
            long j = cex.vQE;
            C29311a c29311a = C29310n.rTi;
            C25052j.m39375o(str, "username");
            C39879j a = C29311a.m46533a(str, j, i, cex.xex.xdJ, false);
            C22241k c22241k = C22241k.rTc;
            C22241k.m33918a(str, a);
            str = TAG;
            StringBuilder append = new StringBuilder("processStoryPost username:").append(cex.xex.ndG).append(" createTime:").append(cex.xex.pcX).append(" id:").append(cex.vQE).append(" scope:");
            if (a != null) {
                cfb cBR = a.cBR();
                if (cBR != null) {
                    valueOf = Integer.valueOf(cBR.xeC);
                    C4990ab.m7416i(str, append.append(valueOf).toString());
                    it = rUW.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    c7306ak.sendEmptyMessage(0);
                    AppMethodBeat.m2505o(109245);
                    return true;
                }
            }
            valueOf = null;
            C4990ab.m7416i(str, append.append(valueOf).toString());
            it = rUW.iterator();
            while (it.hasNext()) {
            }
            c7306ak.sendEmptyMessage(0);
            AppMethodBeat.m2505o(109245);
            return true;
        } catch (Exception e) {
            C4990ab.m7420w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.m2505o(109245);
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
    /* renamed from: d */
    public static boolean m11953d(C40573tb c40573tb, C7306ak c7306ak) {
        AppMethodBeat.m2504i(109246);
        C25052j.m39376p(c40573tb, "item");
        C25052j.m39376p(c7306ak, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = c40573tb.wau;
            C25052j.m39375o(sKBuiltinBuffer_t, "item.CmdBuf");
            C1331a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.m2505o(109246);
                throw c44941v;
            }
            String str;
            String str2;
            float f;
            C22241k c22241k;
            Iterator it;
            cex = (cex) parseFrom;
            String str3 = cex.xex.ndG;
            int i = cex.xex.pcX;
            long j = cex.vQE;
            C29311a c29311a = C29310n.rTi;
            C25052j.m39375o(str3, "username");
            C29311a.m46533a(str3, j, i, null, true);
            c29311a = C29310n.rTi;
            C39879j aaB = C29311a.aaB(str3);
            cfb cBR = aaB.cBR();
            cea cea = cBR.xeA;
            if (cea != null) {
                LinkedList linkedList = cea.wbK;
                if (linkedList != null) {
                    cek cek = (cek) C25035t.m39361x(linkedList, 0);
                    if (cek != null) {
                        str = cek.wEH;
                        cea = cBR.xeA;
                        if (cea != null) {
                            linkedList = cea.wbK;
                            if (linkedList != null) {
                                cek = (cek) C25035t.m39361x(linkedList, 0);
                                if (cek != null) {
                                    str2 = cek.Url;
                                    cea = cBR.xeA;
                                    if (cea != null) {
                                        linkedList = cea.wbK;
                                        if (linkedList != null) {
                                            cek = (cek) C25035t.m39361x(linkedList, 0);
                                            if (cek != null) {
                                                f = cek.duration;
                                                c22241k = C22241k.rTc;
                                                C22241k.m33917a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
                                                C4990ab.m7416i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + C8902b.m16048fe(j));
                                                it = rUW.iterator();
                                                while (it.hasNext()) {
                                                    it.next();
                                                }
                                                c7306ak.sendEmptyMessage(0);
                                                AppMethodBeat.m2505o(109246);
                                                return true;
                                            }
                                        }
                                    }
                                    f = 0.0f;
                                    c22241k = C22241k.rTc;
                                    C22241k.m33917a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
                                    C4990ab.m7416i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + C8902b.m16048fe(j));
                                    it = rUW.iterator();
                                    while (it.hasNext()) {
                                    }
                                    c7306ak.sendEmptyMessage(0);
                                    AppMethodBeat.m2505o(109246);
                                    return true;
                                }
                            }
                        }
                        str2 = null;
                        cea = cBR.xeA;
                        if (cea != null) {
                        }
                        f = 0.0f;
                        c22241k = C22241k.rTc;
                        C22241k.m33917a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
                        C4990ab.m7416i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + C8902b.m16048fe(j));
                        it = rUW.iterator();
                        while (it.hasNext()) {
                        }
                        c7306ak.sendEmptyMessage(0);
                        AppMethodBeat.m2505o(109246);
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
            c22241k = C22241k.rTc;
            C22241k.m33917a(str3, aaB.field_storyID, aaB.field_createTime, str, str2, (long) (f * 1000.0f));
            C4990ab.m7416i(TAG, "processStoryPostDel username:" + str3 + " createTime:" + i + " id:" + j + " lastCreateTime:" + aaB.field_createTime + " lastId:" + aaB.field_storyID + "   ulonglong " + C8902b.m16048fe(j));
            it = rUW.iterator();
            while (it.hasNext()) {
            }
            c7306ak.sendEmptyMessage(0);
            AppMethodBeat.m2505o(109246);
            return true;
        } catch (Exception e) {
            C4990ab.m7420w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.m2505o(109246);
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m11954e(C40573tb c40573tb, C7306ak c7306ak) {
        AppMethodBeat.m2504i(109247);
        C25052j.m39376p(c40573tb, "item");
        C25052j.m39376p(c7306ak, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = c40573tb.wau;
            C25052j.m39375o(sKBuiltinBuffer_t, "item.CmdBuf");
            C1331a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.m2505o(109247);
                throw c44941v;
            }
            C35191c c35191c;
            cex = (cex) parseFrom;
            String str = cex.xex.ndG;
            int i = cex.xex.pcX;
            long j = cex.vQE;
            C4990ab.m7416i(TAG, "processStoryComment username:" + str + " createTime:" + i + " id:" + j + " ulonglong " + C8902b.m16048fe(j));
            C46279b c46279b = C46279b.rVw;
            C25052j.m39376p(cex, "syncMsg");
            C4990ab.m7416i(C46279b.TAG, "addSyncComment " + cex.vQE + ' ' + cex.xex.wZG + ' ' + cex.xex.pcX);
            C31596c c31596c = new C31596c();
            C4133a c4133a = C43644j.rST;
            c31596c.AVE = C4133a.cxW().mo55842lr(cex.xex.vQE);
            if (((C35191c) c31596c.AVE) == null) {
                c31596c.AVE = new C35191c();
                ((C35191c) c31596c.AVE).field_storyId = cex.vQE;
            }
            C46279b.m86760a(cex);
            if (((C35191c) c31596c.AVE).field_readCommentTime == 0) {
                Integer valueOf;
                LinkedList linkedList;
                cdv cdv;
                if (C5046bo.isNullOrNil(cex.xex.ncM)) {
                    linkedList = cex.xex.xdJ.xeq;
                    C25052j.m39375o(linkedList, "bubbleList");
                    cdv = (cdv) C25035t.m39361x(linkedList, linkedList.size() - 2);
                    valueOf = cdv != null ? Integer.valueOf(cdv.pcX) : null;
                } else {
                    linkedList = cex.xex.xdJ.xeo;
                    C25052j.m39375o(linkedList, "commentList");
                    cdv = (cdv) C25035t.m39361x(linkedList, linkedList.size() - 2);
                    valueOf = cdv != null ? Integer.valueOf(cdv.pcX) : null;
                }
                c35191c = (C35191c) c31596c.AVE;
                if (valueOf != null) {
                    i = valueOf.intValue();
                } else {
                    i = 1;
                }
                c35191c.field_readCommentTime = i;
            }
            c35191c = (C35191c) c31596c.AVE;
            String str2 = cex.xex.ndG;
            C25052j.m39375o(str2, "syncMsg.SyncMsgDetail.FromUserName");
            c35191c.aaS(str2);
            c35191c = (C35191c) c31596c.AVE;
            str2 = cex.xex.xdJ.jBB;
            C25052j.m39375o(str2, "syncMsg.SyncMsgDetail.StoryObject.UserName");
            c35191c.aaG(str2);
            ((C35191c) c31596c.AVE).field_syncCommentId = cex.xex.wZG;
            ((C35191c) c31596c.AVE).field_syncCommentTime = cex.xex.pcX;
            C35191c c35191c2 = (C35191c) c31596c.AVE;
            int i2 = c35191c2.field_commentFlag;
            C35185b c35185b = C35185b.sdo;
            c35191c2.field_commentFlag = i2 | C35185b.cBt();
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxW().mo10099a((C35191c) c31596c.AVE);
            C8902b.m16042a(new C22224a(c31596c));
            Iterator it = rUW.iterator();
            while (it.hasNext()) {
                it.next();
            }
            c7306ak.sendEmptyMessage(0);
            AppMethodBeat.m2505o(109247);
            return true;
        } catch (Exception e) {
            C4990ab.m7420w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.m2505o(109247);
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m11955f(C40573tb c40573tb, C7306ak c7306ak) {
        AppMethodBeat.m2504i(109248);
        C25052j.m39376p(c40573tb, "item");
        C25052j.m39376p(c7306ak, "h");
        try {
            cex cex = new cex();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = c40573tb.wau;
            C25052j.m39375o(sKBuiltinBuffer_t, "item.CmdBuf");
            C1331a parseFrom = cex.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.m2505o(109248);
                throw c44941v;
            }
            cex = (cex) parseFrom;
            String str = cex.xex.ndG;
            int i = cex.xex.pcX;
            C4990ab.m7416i(TAG, "processStoryCommentDel username:" + str + " createTime:" + i + " id:" + cex.vQE);
            C46279b c46279b = C46279b.rVw;
            C25052j.m39376p(cex, "syncMsg");
            C4990ab.m7416i(C46279b.TAG, "delSyncComment " + cex.vQE + ' ' + cex.xex.wZG);
            C46279b.m86766g(cex.xex.vQE, cex.xex.wZG, cex.xex.ncM);
            C46279b.m86769ld(cex.xex.vQE);
            Iterator it = rUW.iterator();
            while (it.hasNext()) {
                it.next();
            }
            c7306ak.sendEmptyMessage(0);
            AppMethodBeat.m2505o(109248);
            return true;
        } catch (Exception e) {
            C4990ab.m7420w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.m2505o(109248);
            return false;
        }
    }

    public final void cyY() {
        AppMethodBeat.m2504i(109249);
        C1331a acA = this.ehh.acA();
        C44941v c44941v;
        if (acA == null) {
            c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.m2505o(109249);
            throw c44941v;
        }
        cfa cfa = (cfa) acA;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.m2505o(109249);
            throw c44941v;
        }
        cez cez = (cez) acz;
        byte[] j = C44098aa.m79382j(cez.vTO.getBuffer().toByteArray(), cfa.vTO.getBuffer().toByteArray());
        if (j != null && j.length > 0) {
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(8195, C5046bo.m7543cd(j));
        }
        cez.vTO.setBuffer(j);
        if ((cfa.vQe & cez.vTN) == 0) {
            C1202f c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(0, 0, "", this);
            AppMethodBeat.m2505o(109249);
            return;
        }
        C1902e acL = acL();
        C25052j.m39375o(acL, "dispatcher()");
        C1202f c1202f2 = this.ehi;
        if (c1202f2 == null) {
            C25052j.avw("callback");
        }
        mo4456a(acL, c1202f2);
        AppMethodBeat.m2505o(109249);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109250);
        C25052j.m39376p(c1902e, "dispatcher");
        C25052j.m39376p(c1202f, "callback");
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        byte[] anf = C5046bo.anf(C5046bo.nullAsNil((String) RP.mo5239Ry().get(8195)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(anf);
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.m2505o(109250);
            throw c44941v;
        }
        ((cez) acz).vTO = sKBuiltinBuffer_t;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109250);
        return a;
    }

    public final int getType() {
        return 513;
    }

    /* JADX WARNING: Missing block: B:14:0x0071, code skipped:
            if (r1 == null) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(109251);
        C4990ab.m7410d(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        C1202f c1202f;
        if (i2 == 0 && i3 == 0) {
            C1331a acA = this.ehh.acA();
            C44941v c44941v;
            if (acA == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
                AppMethodBeat.m2505o(109251);
                throw c44941v;
            }
            LinkedList linkedList;
            cfa cfa = (cfa) acA;
            C35956tc c35956tc = cfa.vTR;
            if (c35956tc != null) {
                linkedList = c35956tc.jBw;
            }
            linkedList = new LinkedList();
            if (linkedList.size() > 0) {
                C7143b c7143b = this.rUU;
                C25052j.m39376p(linkedList, "cmdList");
                c7143b.mgm = linkedList;
                c7143b.mgn.sendEmptyMessage(0);
                AppMethodBeat.m2505o(109251);
                return;
            }
            if (cfa.vTO != null) {
                SKBuiltinBuffer_t sKBuiltinBuffer_t = cfa.vTO;
                C25052j.m39375o(sKBuiltinBuffer_t, "resp.KeyBuf");
                if (sKBuiltinBuffer_t.getBuffer() != null) {
                    SKBuiltinBuffer_t sKBuiltinBuffer_t2 = cfa.vTO;
                    C25052j.m39375o(sKBuiltinBuffer_t2, "resp.KeyBuf");
                    byte[] toByteArray = sKBuiltinBuffer_t2.getBuffer().toByteArray();
                    acA = this.ehh.acz();
                    if (acA == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
                        AppMethodBeat.m2505o(109251);
                        throw c44941v;
                    }
                    toByteArray = C44098aa.m79382j(((cez) acA).vTO.getBuffer().toByteArray(), toByteArray);
                    if (toByteArray != null) {
                        if (((toByteArray.length == 0 ? 1 : 0) == 0 ? 1 : 0) != 0) {
                            C1706e RP = C1720g.m3536RP();
                            C25052j.m39375o(RP, "MMKernel.storage()");
                            RP.mo5239Ry().set(8195, C5046bo.m7543cd(toByteArray));
                        }
                    }
                }
            }
            c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(109251);
            return;
        }
        c1202f = this.ehi;
        if (c1202f == null) {
            C25052j.avw("callback");
        }
        c1202f.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(109251);
    }

    public final int acn() {
        return this.rUV;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }
}
