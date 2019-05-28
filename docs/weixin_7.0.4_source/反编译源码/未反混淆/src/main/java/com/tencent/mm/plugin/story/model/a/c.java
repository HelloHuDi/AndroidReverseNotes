package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016J>\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c extends m implements k {
    private static final String TAG = TAG;
    public static final a rUL = new a();
    public final b ehh;
    private f ehi;
    public final String gpx;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public c(String str) {
        j.p(str, "chatRoom");
        AppMethodBeat.i(109211);
        this.gpx = str;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(new cds());
        aVar.b(new cdt());
        aVar.qq("/cgi-bin/micromsg-bin/mmstorychatroomsync");
        aVar.kU(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        aVar.kV(0);
        aVar.kW(0);
        b acD = aVar.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
            AppMethodBeat.o(109211);
            throw vVar;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t;
        cds cds;
        cds cds2 = (cds) acz;
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        String cnk = com.tencent.mm.plugin.story.model.j.a.cnk();
        aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.l abc = com.tencent.mm.plugin.story.model.j.a.cxV().abc(this.gpx);
        cds2.jBB = cnk;
        cds2.vEf = this.gpx;
        byte[] bArr = abc.field_extbuf;
        if (bArr != null) {
            SKBuiltinBuffer_t ad = aa.ad(bArr);
            if (ad != null) {
                sKBuiltinBuffer_t = ad;
                cds = cds2;
                cds.xdt = sKBuiltinBuffer_t;
                ab.i(TAG, "req userName " + cnk + " chatRoomName " + this.gpx + " buf " + cds2.xdt);
                AppMethodBeat.o(109211);
            }
        }
        sKBuiltinBuffer_t = null;
        cds = cds2;
        cds.xdt = sKBuiltinBuffer_t;
        ab.i(TAG, "req userName " + cnk + " chatRoomName " + this.gpx + " buf " + cds2.xdt);
        AppMethodBeat.o(109211);
    }

    static {
        AppMethodBeat.i(109212);
        AppMethodBeat.o(109212);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        Object obj;
        AppMethodBeat.i(109209);
        ab.i(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        cdt cdt = (cdt) this.ehh.acA();
        if (cdt != null) {
            byte[] bufferToBytes;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.l abc = com.tencent.mm.plugin.story.model.j.a.cxV().abc(this.gpx);
            SKBuiltinBuffer_t sKBuiltinBuffer_t = cdt.xdt;
            if (sKBuiltinBuffer_t != null) {
                try {
                    bufferToBytes = sKBuiltinBuffer_t.getBufferToBytes();
                } catch (Exception e) {
                    ab.b("safeBufferToByte", "", e);
                    bufferToBytes = null;
                }
            } else {
                bufferToBytes = null;
            }
            abc.field_extbuf = bufferToBytes;
            ab.i(TAG, "onGYNetEnd: count " + cdt.xdu);
            if (obj != null) {
                abc.field_nextSyncTime = 60000 + System.currentTimeMillis();
            } else {
                abc.field_nextSyncTime = (((long) cdt.xdw) * 1000) + System.currentTimeMillis();
            }
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxV().a(abc);
            ab.i(TAG, "response: count " + cdt.xdu + ", interval " + cdt.xdw);
            LinkedList<cdr> linkedList = cdt.xdv;
            j.o(linkedList, "resp.SyncInfoList");
            for (cdr cdr : linkedList) {
                if (!((cdr != null ? cdr.jBB : null) == null || cdr.ThumbUrl == null)) {
                    com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
                    String str2 = cdr.jBB;
                    j.o(str2, "it.UserName");
                    com.tencent.mm.plugin.story.h.f aap = com.tencent.mm.plugin.story.model.k.aap(str2);
                    ab.d(TAG, "fetch " + cdr.jBB + ' ' + cdr.xdq + ' ' + cdr.xdr + ", oldId " + aap.field_syncId);
                    if (aap.field_syncId != cdr.xdq) {
                        kVar = com.tencent.mm.plugin.story.model.k.rTc;
                        str2 = cdr.jBB;
                        j.o(str2, "it.UserName");
                        com.tencent.mm.plugin.story.model.k.a(str2, cdr.xdq, cdr.xdr, cdr.ThumbUrl, cdr.nbr, 0);
                    }
                }
            }
        }
        f fVar = this.ehi;
        if (fVar == null) {
            j.avw("callback");
        }
        fVar.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(109209);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(109210);
        j.p(eVar, "dispatcher");
        j.p(fVar, "callback");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109210);
        return a;
    }

    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR;
    }
}
