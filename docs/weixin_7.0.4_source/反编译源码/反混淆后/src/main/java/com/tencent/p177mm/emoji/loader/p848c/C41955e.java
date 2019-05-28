package com.tencent.p177mm.emoji.loader.p848c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emoji.C38876c;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23399hv;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J*\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u001cH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000RC\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.c.e */
public final class C41955e implements C1202f {
    private final String TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    private final EmojiInfo exP;
    private final C27737e exS;
    final C31591m<Boolean, C26078d, C37091y> exT;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.c.e$a */
    static final class C9274a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C41955e exU;
        final /* synthetic */ C26078d exV;

        C9274a(C41955e c41955e, C26078d c26078d) {
            this.exU = c41955e;
            this.exV = c26078d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63185);
            this.exU.exT.mo212m(Boolean.TRUE, this.exV);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63185);
            return c37091y;
        }
    }

    public C41955e(EmojiInfo emojiInfo, C31591m<? super Boolean, ? super C26078d, C37091y> c31591m) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(c31591m, "callback");
        AppMethodBeat.m2504i(63188);
        this.exP = emojiInfo;
        this.exT = c31591m;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.exP.mo20410Aq());
        this.exS = new C27737e(linkedList);
        C26078d e = m74101e(this.exP);
        if ((((CharSequence) e.url).length() > 0 ? 1 : null) != null) {
            this.exT.mo212m(Boolean.TRUE, e);
            AppMethodBeat.m2505o(63188);
            return;
        }
        C4990ab.m7416i(this.TAG, "config retriever: db url is empty");
        C38876c.m65942hF(9);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14539a(697, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14552d((C1207m) this.exS);
        AppMethodBeat.m2505o(63188);
    }

    /* renamed from: e */
    private final C26078d m74101e(EmojiInfo emojiInfo) {
        String str;
        Object obj;
        int i = 0;
        AppMethodBeat.m2504i(63186);
        String str2 = emojiInfo.dve() + "_temp";
        if (C45307h.m83556f(emojiInfo)) {
            C4990ab.m7416i(this.TAG, "createFetcherConfig: " + emojiInfo.mo20410Aq() + " use tp url");
            str = emojiInfo.field_tpurl;
            C25052j.m39375o(str, "emojiInfo.field_tpurl");
            i = 3;
        } else if (C45307h.m83557g(emojiInfo)) {
            C4990ab.m7416i(this.TAG, "createFetcherConfig: " + emojiInfo.mo20410Aq() + " use wxam");
            str = emojiInfo.field_externUrl;
            C25052j.m39375o(str, "emojiInfo.field_externUrl");
            i = 2;
        } else if (C45307h.m83558h(emojiInfo)) {
            C4990ab.m7416i(this.TAG, "createFetcherConfig: " + emojiInfo.mo20410Aq() + " use encrypt");
            str = emojiInfo.field_encrypturl;
            C25052j.m39375o(str, "emojiInfo.field_encrypturl");
            i = 1;
        } else if (C5046bo.isNullOrNil(emojiInfo.field_cdnUrl)) {
            str = "";
        } else {
            C4990ab.m7416i(this.TAG, "createFetcherConfig: " + emojiInfo.mo20410Aq() + " use cdn url");
            str = emojiInfo.field_cdnUrl;
            C25052j.m39375o(str, "emojiInfo.field_cdnUrl");
        }
        if (emojiInfo.field_tpauthkey == null) {
            obj = "";
        } else {
            obj = emojiInfo.field_tpauthkey;
        }
        C25052j.m39375o(obj, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
        C26078d c26078d = new C26078d(emojiInfo, str, str2, obj, i);
        AppMethodBeat.m2505o(63186);
        return c26078d;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(63187);
        C25052j.m39376p(c1207m, "scene");
        int type = c1207m.getType();
        C4990ab.m7416i(this.TAG, "onSceneEnd: " + i + ", " + i2 + ", " + type);
        if (type == 697 && C25052j.m39373j(c1207m, this.exS)) {
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "network()");
            RO.mo5186Rg().mo14546b(697, (C1202f) this);
            C23399hv bku = this.exS.bku();
            Collection collection = bku != null ? bku.vKl : null;
            type = (collection == null || collection.isEmpty()) ? 1 : 0;
            if (type != 0) {
                C4990ab.m7416i(this.TAG, "onSceneEnd: response list is empty");
                C7060h.pYm.mo15421z(164, 11);
                this.exT.mo212m(Boolean.FALSE, null);
                AppMethodBeat.m2505o(63187);
                return;
            }
            C2933b.m5222a((C40588xx) bku.vKl.get(0), this.exP);
            C26078d e = m74101e(this.exP);
            if (e.url.length() > 0) {
                type = 1;
            } else {
                type = 0;
            }
            if (type != 0) {
                C1677a M = C1720g.m3530M(C6835d.class);
                C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((C6835d) M).getProvider().updateEmojiInfo(this.exP);
                C8902b.m16044a("EmojiFetcherConfigRetriever_onSceneEnd", (C31214a) new C9274a(this, e));
                AppMethodBeat.m2505o(63187);
                return;
            }
            this.exT.mo212m(Boolean.FALSE, null);
        }
        AppMethodBeat.m2505o(63187);
    }
}
