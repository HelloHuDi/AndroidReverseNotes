package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J>\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryAudioReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "feedbackList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicFeedback;", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b extends m implements k {
    private static final String TAG = TAG;
    public static final a rUK = new a();
    private final com.tencent.mm.ai.b ehh;
    private f ehi;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryAudioReport$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public b(long j, List<? extends bqk> list) {
        j.p(list, "feedbackList");
        AppMethodBeat.i(109207);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(new bsh());
        aVar.b(new bsi());
        aVar.qq("/cgi-bin/micromsg-bin/reportrecommendedmusicfeedback");
        aVar.kU(298);
        com.tencent.mm.ai.b acD = aVar.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ReportRecommendedMusicFeedbackRequest");
            AppMethodBeat.o(109207);
            throw vVar;
        }
        bsh bsh = (bsh) acz;
        bsh.rUb = j;
        bsh.wUm.addAll(list);
        ab.i(TAG, "LogStory: report music " + j + ' ' + list.size());
        AppMethodBeat.o(109207);
    }

    static {
        AppMethodBeat.i(109208);
        AppMethodBeat.o(109208);
    }

    public final int getType() {
        return 298;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(109205);
        j.p(eVar, "dispatcher");
        j.p(fVar, "callback");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109205);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(109206);
        ab.i(TAG, "onGYNetEnd " + i + ", " + i2 + ", " + i3 + ", " + str);
        f fVar = this.ehi;
        if (fVar != null) {
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109206);
            return;
        }
        AppMethodBeat.o(109206);
    }
}
