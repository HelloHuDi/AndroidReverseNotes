package com.tencent.mm.emoji.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002 !B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedEmojiMD5", "", "", "imitateMd5", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getAttachedEmojiMD5", "()Ljava/util/List;", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "getImitateMd5", "()Ljava/lang/String;", "dealSaveSuccess", "", "gifMd5", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
public final class d {
    public static final a eyZ = new a();
    EmojiInfo exP;
    final String eyL;
    private final com.tencent.mm.pluginsdk.a.d eyW;
    final List<String> eyX;
    b eyY;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
    public interface b {
        void f(int i, String str, String str2);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$Companion;", "", "()V", "CAPTURE_EMOJI_UPLOAD_MAX_COUNT", "", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ d eza;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "gifMd5", "isTooLarge", "", "onUploadEnd"})
        /* renamed from: com.tencent.mm.emoji.a.d$c$1 */
        static final class AnonymousClass1 implements com.tencent.mm.emoji.a.c.b {
            final /* synthetic */ c ezb;

            AnonymousClass1(c cVar) {
                this.ezb = cVar;
            }

            public final void b(int i, int i2, String str, boolean z) {
                AppMethodBeat.i(63245);
                b bVar;
                com.tencent.mm.kernel.b.a M;
                if (i == 0 && i2 == 0) {
                    d.a(this.ezb.eza, str);
                    AppMethodBeat.o(63245);
                } else if (5 == i2) {
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(5, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else if (6 == i2) {
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(6, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else if (7 == i2) {
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(7, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else if (4 == i2) {
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(4, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else if (-434 == i2) {
                    if (5 > this.ezb.eza.exP.dva()) {
                        this.ezb.eza.exP.dvb();
                        M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
                        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                        ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().updateEmojiInfo(this.ezb.eza.exP);
                        bVar = this.ezb.eza.eyY;
                        if (bVar != null) {
                            bVar.f(3, null, null);
                            AppMethodBeat.o(63245);
                            return;
                        }
                        AppMethodBeat.o(63245);
                        return;
                    }
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(9, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else if (z) {
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(2, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else if (-24 == i2) {
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(8, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else if (5 > this.ezb.eza.exP.dva()) {
                    this.ezb.eza.exP.dvb();
                    M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
                    j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().updateEmojiInfo(this.ezb.eza.exP);
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(1, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                } else {
                    bVar = this.ezb.eza.eyY;
                    if (bVar != null) {
                        bVar.f(9, null, null);
                        AppMethodBeat.o(63245);
                        return;
                    }
                    AppMethodBeat.o(63245);
                }
            }
        }

        c(d dVar) {
            this.eza = dVar;
        }

        public final void run() {
            AppMethodBeat.i(63246);
            new c(this.eza.exP, true, true, this.eza.exP.field_attachedText, this.eza.eyX, this.eza.eyL).a((com.tencent.mm.emoji.a.c.b) new AnonymousClass1(this));
            AppMethodBeat.o(63246);
        }
    }

    static {
        AppMethodBeat.i(63248);
        AppMethodBeat.o(63248);
    }

    public d(EmojiInfo emojiInfo, List<String> list, String str, b bVar) {
        boolean z;
        j.p(emojiInfo, "emojiInfo");
        AppMethodBeat.i(63247);
        this.exP = emojiInfo;
        this.eyX = list;
        this.eyL = str;
        this.eyY = bVar;
        com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
        j.o(M, "plugin(IPluginEmoji::class.java)");
        this.eyW = ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr();
        b bVar2;
        if (!e.ct(this.exP.dve())) {
            bVar2 = this.eyY;
            if (bVar2 != null) {
                bVar2.f(10, null, null);
            }
            z = false;
        } else if (e.asZ(this.exP.dve()) > ((long) this.eyW.d(this.exP, true))) {
            bVar2 = this.eyY;
            if (bVar2 != null) {
                bVar2.f(2, null, null);
            }
            z = false;
        } else {
            b bVar3 = b.eyD;
            if (b.OF()) {
                if (5 > this.exP.dva()) {
                    this.exP.dvb();
                    M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
                    j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().updateEmojiInfo(this.exP);
                    bVar2 = this.eyY;
                    if (bVar2 != null) {
                        bVar2.f(3, null, null);
                    }
                } else {
                    bVar2 = this.eyY;
                    if (bVar2 != null) {
                        bVar2.f(9, null, null);
                    }
                }
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            ab.i("MicroMsg.EmojiUploadLogic", "start upload emoji");
            g.RS().aa(new c(this));
        }
        AppMethodBeat.o(63247);
    }

    public static final /* synthetic */ void a(d dVar, String str) {
        AppMethodBeat.i(63249);
        ab.i("MicroMsg.EmojiUploadLogic", "deal success ".concat(String.valueOf(str)));
        if (!(str == null || (j.j(str, dVar.exP.Aq()) ^ 1) == 0)) {
            EmojiInfo Je = dVar.eyW.Je(str);
            j.o(Je, "emojiMgr.getEmojiByMd5(gifMd5)");
            dVar.exP = Je;
        }
        com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().q(dVar.exP);
        dVar.eyW.c(dVar.exP, false);
        b bVar = dVar.eyY;
        if (bVar != null) {
            bVar.f(0, str, dVar.exP.field_activityid);
            AppMethodBeat.o(63249);
            return;
        }
        AppMethodBeat.o(63249);
    }
}
