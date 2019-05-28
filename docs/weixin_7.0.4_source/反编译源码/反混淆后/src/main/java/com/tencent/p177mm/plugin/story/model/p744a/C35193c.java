package com.tencent.p177mm.plugin.story.model.p744a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p532h.C39882l;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cdr;
import com.tencent.p177mm.protocal.protobuf.cds;
import com.tencent.p177mm.protocal.protobuf.cdt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016J>\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.c */
public final class C35193c extends C1207m implements C1918k {
    private static final String TAG = TAG;
    public static final C13767a rUL = new C13767a();
    public final C7472b ehh;
    private C1202f ehi;
    public final String gpx;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.c$a */
    public static final class C13767a {
        private C13767a() {
        }

        public /* synthetic */ C13767a(byte b) {
            this();
        }
    }

    public C35193c(String str) {
        C25052j.m39376p(str, "chatRoom");
        AppMethodBeat.m2504i(109211);
        this.gpx = str;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new cds());
        c1196a.mo4446b(new cdt());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstorychatroomsync");
        c1196a.mo4447kU(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
            AppMethodBeat.m2505o(109211);
            throw c44941v;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t;
        cds cds;
        cds cds2 = (cds) acz;
        C4133a c4133a = C43644j.rST;
        String cnk = C4133a.cnk();
        c4133a = C43644j.rST;
        C39882l abc = C4133a.cxV().abc(this.gpx);
        cds2.jBB = cnk;
        cds2.vEf = this.gpx;
        byte[] bArr = abc.field_extbuf;
        if (bArr != null) {
            SKBuiltinBuffer_t ad = C1946aa.m4152ad(bArr);
            if (ad != null) {
                sKBuiltinBuffer_t = ad;
                cds = cds2;
                cds.xdt = sKBuiltinBuffer_t;
                C4990ab.m7416i(TAG, "req userName " + cnk + " chatRoomName " + this.gpx + " buf " + cds2.xdt);
                AppMethodBeat.m2505o(109211);
            }
        }
        sKBuiltinBuffer_t = null;
        cds = cds2;
        cds.xdt = sKBuiltinBuffer_t;
        C4990ab.m7416i(TAG, "req userName " + cnk + " chatRoomName " + this.gpx + " buf " + cds2.xdt);
        AppMethodBeat.m2505o(109211);
    }

    static {
        AppMethodBeat.m2504i(109212);
        AppMethodBeat.m2505o(109212);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(109209);
        C4990ab.m7416i(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        cdt cdt = (cdt) this.ehh.acA();
        if (cdt != null) {
            byte[] bufferToBytes;
            C4133a c4133a = C43644j.rST;
            C39882l abc = C4133a.cxV().abc(this.gpx);
            SKBuiltinBuffer_t sKBuiltinBuffer_t = cdt.xdt;
            if (sKBuiltinBuffer_t != null) {
                try {
                    bufferToBytes = sKBuiltinBuffer_t.getBufferToBytes();
                } catch (Exception e) {
                    C4990ab.m7408b("safeBufferToByte", "", e);
                    bufferToBytes = null;
                }
            } else {
                bufferToBytes = null;
            }
            abc.field_extbuf = bufferToBytes;
            C4990ab.m7416i(TAG, "onGYNetEnd: count " + cdt.xdu);
            if (obj != null) {
                abc.field_nextSyncTime = 60000 + System.currentTimeMillis();
            } else {
                abc.field_nextSyncTime = (((long) cdt.xdw) * 1000) + System.currentTimeMillis();
            }
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxV().mo10099a(abc);
            C4990ab.m7416i(TAG, "response: count " + cdt.xdu + ", interval " + cdt.xdw);
            LinkedList<cdr> linkedList = cdt.xdv;
            C25052j.m39375o(linkedList, "resp.SyncInfoList");
            for (cdr cdr : linkedList) {
                if (!((cdr != null ? cdr.jBB : null) == null || cdr.ThumbUrl == null)) {
                    C22241k c22241k = C22241k.rTc;
                    String str2 = cdr.jBB;
                    C25052j.m39375o(str2, "it.UserName");
                    C4119f aap = C22241k.aap(str2);
                    C4990ab.m7410d(TAG, "fetch " + cdr.jBB + ' ' + cdr.xdq + ' ' + cdr.xdr + ", oldId " + aap.field_syncId);
                    if (aap.field_syncId != cdr.xdq) {
                        c22241k = C22241k.rTc;
                        str2 = cdr.jBB;
                        C25052j.m39375o(str2, "it.UserName");
                        C22241k.m33917a(str2, cdr.xdq, cdr.xdr, cdr.ThumbUrl, cdr.nbr, 0);
                    }
                }
            }
        }
        C1202f c1202f = this.ehi;
        if (c1202f == null) {
            C25052j.avw("callback");
        }
        c1202f.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(109209);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109210);
        C25052j.m39376p(c1902e, "dispatcher");
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109210);
        return a;
    }

    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR;
    }
}
