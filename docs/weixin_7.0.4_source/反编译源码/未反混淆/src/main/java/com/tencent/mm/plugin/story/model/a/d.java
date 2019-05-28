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
import com.tencent.mm.plugin.appbrand.jsapi.nfc.c;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0016H\u0016J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d extends m implements k {
    private static final String TAG = TAG;
    public static final a rUO = new a();
    public final b ehh;
    public f ehi;
    private cdv rUM;
    public final com.tencent.mm.plugin.story.model.b.a rUN;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public d(String str, cdv cdv, String str2, com.tencent.mm.plugin.story.model.b.a aVar) {
        j.p(str, Columns.CLIENTID);
        j.p(cdv, "commentDetail");
        AppMethodBeat.i(138749);
        this.rUM = cdv;
        this.rUN = aVar;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.a(new cdx());
        aVar2.b(new cdy());
        aVar2.qq("/cgi-bin/micromsg-bin/mmstorycomment");
        aVar2.kU(c.CTRL_INDEX);
        aVar2.kV(0);
        aVar2.kW(0);
        b acD = aVar2.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
            AppMethodBeat.o(138749);
            throw vVar;
        }
        cdx cdx = (cdx) acz;
        cdx.ptv = str;
        cdx.xdF = this.rUM;
        h hVar = h.scu;
        cdx.xdH = (int) h.cAs().FF();
        hVar = h.scu;
        cdx.xdI = (int) h.cAs().FG();
        cdx.vGA = str2;
        ab.i(TAG, "ClientId " + cdx.ptv + " PreviewEnterScene " + cdx.xdH + " sessionID: " + cdx.vGA + ' ');
        AppMethodBeat.o(138749);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(109213);
        j.p(eVar, "dispatcher");
        j.p(fVar, "callback");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109213);
        return a;
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        Object obj = null;
        AppMethodBeat.i(109214);
        ab.i(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        CharSequence charSequence;
        com.tencent.mm.plugin.story.g.e eVar;
        if (i2 == 0 && i3 == 0) {
            Object obj2;
            charSequence = this.rUM.ncM;
            if (charSequence == null || charSequence.length() == 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                eVar = com.tencent.mm.plugin.story.g.e.sbS;
                com.tencent.mm.plugin.story.g.e.cAb();
            } else {
                eVar = com.tencent.mm.plugin.story.g.e.sbS;
                com.tencent.mm.plugin.story.g.e.cAc();
            }
        } else {
            charSequence = this.rUM.ncM;
            if (charSequence == null || charSequence.length() == 0) {
                obj = 1;
            }
            if (obj != null) {
                eVar = com.tencent.mm.plugin.story.g.e.sbS;
                com.tencent.mm.plugin.story.g.e.cAd();
                if (i2 == 4) {
                    eVar = com.tencent.mm.plugin.story.g.e.sbS;
                    com.tencent.mm.plugin.story.g.e.cAf();
                }
            } else {
                eVar = com.tencent.mm.plugin.story.g.e.sbS;
                com.tencent.mm.plugin.story.g.e.cAe();
                if (i2 == 4) {
                    eVar = com.tencent.mm.plugin.story.g.e.sbS;
                    com.tencent.mm.plugin.story.g.e.cAg();
                }
            }
        }
        f fVar = this.ehi;
        if (fVar == null) {
            j.avw("callback");
        }
        fVar.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(109214);
    }

    static {
        AppMethodBeat.i(109216);
        AppMethodBeat.o(109216);
    }
}
