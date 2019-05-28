package com.tencent.mm.emoji.loader.c;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J*\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u001cH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000RC\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class e implements f {
    private final String TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    private final EmojiInfo exP;
    private final com.tencent.mm.plugin.emoji.f.e exS;
    final m<Boolean, d, y> exT;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ e exU;
        final /* synthetic */ d exV;

        a(e eVar, d dVar) {
            this.exU = eVar;
            this.exV = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63185);
            this.exU.exT.m(Boolean.TRUE, this.exV);
            y yVar = y.AUy;
            AppMethodBeat.o(63185);
            return yVar;
        }
    }

    public e(EmojiInfo emojiInfo, m<? super Boolean, ? super d, y> mVar) {
        j.p(emojiInfo, "emojiInfo");
        j.p(mVar, "callback");
        AppMethodBeat.i(63188);
        this.exP = emojiInfo;
        this.exT = mVar;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.exP.Aq());
        this.exS = new com.tencent.mm.plugin.emoji.f.e(linkedList);
        d e = e(this.exP);
        if ((((CharSequence) e.url).length() > 0 ? 1 : null) != null) {
            this.exT.m(Boolean.TRUE, e);
            AppMethodBeat.o(63188);
            return;
        }
        ab.i(this.TAG, "config retriever: db url is empty");
        c.hF(9);
        b RO = g.RO();
        j.o(RO, "network()");
        RO.Rg().a(697, (f) this);
        RO = g.RO();
        j.o(RO, "MMKernel.network()");
        RO.Rg().d((com.tencent.mm.ai.m) this.exS);
        AppMethodBeat.o(63188);
    }

    private final d e(EmojiInfo emojiInfo) {
        String str;
        Object obj;
        int i = 0;
        AppMethodBeat.i(63186);
        String str2 = emojiInfo.dve() + "_temp";
        if (h.f(emojiInfo)) {
            ab.i(this.TAG, "createFetcherConfig: " + emojiInfo.Aq() + " use tp url");
            str = emojiInfo.field_tpurl;
            j.o(str, "emojiInfo.field_tpurl");
            i = 3;
        } else if (h.g(emojiInfo)) {
            ab.i(this.TAG, "createFetcherConfig: " + emojiInfo.Aq() + " use wxam");
            str = emojiInfo.field_externUrl;
            j.o(str, "emojiInfo.field_externUrl");
            i = 2;
        } else if (h.h(emojiInfo)) {
            ab.i(this.TAG, "createFetcherConfig: " + emojiInfo.Aq() + " use encrypt");
            str = emojiInfo.field_encrypturl;
            j.o(str, "emojiInfo.field_encrypturl");
            i = 1;
        } else if (bo.isNullOrNil(emojiInfo.field_cdnUrl)) {
            str = "";
        } else {
            ab.i(this.TAG, "createFetcherConfig: " + emojiInfo.Aq() + " use cdn url");
            str = emojiInfo.field_cdnUrl;
            j.o(str, "emojiInfo.field_cdnUrl");
        }
        if (emojiInfo.field_tpauthkey == null) {
            obj = "";
        } else {
            obj = emojiInfo.field_tpauthkey;
        }
        j.o(obj, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
        d dVar = new d(emojiInfo, str, str2, obj, i);
        AppMethodBeat.o(63186);
        return dVar;
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(63187);
        j.p(mVar, "scene");
        int type = mVar.getType();
        ab.i(this.TAG, "onSceneEnd: " + i + ", " + i2 + ", " + type);
        if (type == 697 && j.j(mVar, this.exS)) {
            b RO = g.RO();
            j.o(RO, "network()");
            RO.Rg().b(697, (f) this);
            hv bku = this.exS.bku();
            Collection collection = bku != null ? bku.vKl : null;
            type = (collection == null || collection.isEmpty()) ? 1 : 0;
            if (type != 0) {
                ab.i(this.TAG, "onSceneEnd: response list is empty");
                h.pYm.z(164, 11);
                this.exT.m(Boolean.FALSE, null);
                AppMethodBeat.o(63187);
                return;
            }
            com.tencent.mm.plugin.emoji.h.b.a((xx) bku.vKl.get(0), this.exP);
            d e = e(this.exP);
            if (e.url.length() > 0) {
                type = 1;
            } else {
                type = 0;
            }
            if (type != 0) {
                com.tencent.mm.kernel.b.a M = g.M(d.class);
                j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((d) M).getProvider().updateEmojiInfo(this.exP);
                com.tencent.mm.ab.b.a("EmojiFetcherConfigRetriever_onSceneEnd", (a.f.a.a) new a(this, e));
                AppMethodBeat.o(63187);
                return;
            }
            this.exT.m(Boolean.FALSE, null);
        }
        AppMethodBeat.o(63187);
    }
}
