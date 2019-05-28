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
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33379c;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C46273e;
import com.tencent.p177mm.protocal.protobuf.cdv;
import com.tencent.p177mm.protocal.protobuf.cdx;
import com.tencent.p177mm.protocal.protobuf.cdy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0016H\u0016J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.d */
public final class C39887d extends C1207m implements C1918k {
    private static final String TAG = TAG;
    public static final C22218a rUO = new C22218a();
    public final C7472b ehh;
    public C1202f ehi;
    private cdv rUM;
    public final C39889a rUN;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.d$a */
    public static final class C22218a {
        private C22218a() {
        }

        public /* synthetic */ C22218a(byte b) {
            this();
        }
    }

    public C39887d(String str, cdv cdv, String str2, C39889a c39889a) {
        C25052j.m39376p(str, Columns.CLIENTID);
        C25052j.m39376p(cdv, "commentDetail");
        AppMethodBeat.m2504i(138749);
        this.rUM = cdv;
        this.rUN = c39889a;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new cdx());
        c1196a.mo4446b(new cdy());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstorycomment");
        c1196a.mo4447kU(C33379c.CTRL_INDEX);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
            AppMethodBeat.m2505o(138749);
            throw c44941v;
        }
        cdx cdx = (cdx) acz;
        cdx.ptv = str;
        cdx.xdF = this.rUM;
        C22212h c22212h = C22212h.scu;
        cdx.xdH = (int) C22212h.cAs().mo20732FF();
        c22212h = C22212h.scu;
        cdx.xdI = (int) C22212h.cAs().mo20733FG();
        cdx.vGA = str2;
        C4990ab.m7416i(TAG, "ClientId " + cdx.ptv + " PreviewEnterScene " + cdx.xdH + " sessionID: " + cdx.vGA + ' ');
        AppMethodBeat.m2505o(138749);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109213);
        C25052j.m39376p(c1902e, "dispatcher");
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109213);
        return a;
    }

    public final int getType() {
        return C33379c.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        Object obj = null;
        AppMethodBeat.m2504i(109214);
        C4990ab.m7416i(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        CharSequence charSequence;
        C46273e c46273e;
        if (i2 == 0 && i3 == 0) {
            Object obj2;
            charSequence = this.rUM.ncM;
            if (charSequence == null || charSequence.length() == 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                c46273e = C46273e.sbS;
                C46273e.cAb();
            } else {
                c46273e = C46273e.sbS;
                C46273e.cAc();
            }
        } else {
            charSequence = this.rUM.ncM;
            if (charSequence == null || charSequence.length() == 0) {
                obj = 1;
            }
            if (obj != null) {
                c46273e = C46273e.sbS;
                C46273e.cAd();
                if (i2 == 4) {
                    c46273e = C46273e.sbS;
                    C46273e.cAf();
                }
            } else {
                c46273e = C46273e.sbS;
                C46273e.cAe();
                if (i2 == 4) {
                    c46273e = C46273e.sbS;
                    C46273e.cAg();
                }
            }
        }
        C1202f c1202f = this.ehi;
        if (c1202f == null) {
            C25052j.avw("callback");
        }
        c1202f.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(109214);
    }

    static {
        AppMethodBeat.m2504i(109216);
        AppMethodBeat.m2505o(109216);
    }
}
