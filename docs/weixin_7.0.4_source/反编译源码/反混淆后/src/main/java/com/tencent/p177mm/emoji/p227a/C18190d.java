package com.tencent.p177mm.emoji.p227a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C1506c.C1507b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002 !B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedEmojiMD5", "", "", "imitateMd5", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getAttachedEmojiMD5", "()Ljava/util/List;", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "getImitateMd5", "()Ljava/lang/String;", "dealSaveSuccess", "", "gifMd5", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.a.d */
public final class C18190d {
    public static final C18192a eyZ = new C18192a();
    EmojiInfo exP;
    final String eyL;
    private final C44795d eyW;
    final List<String> eyX;
    C18191b eyY;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.a.d$b */
    public interface C18191b {
        /* renamed from: f */
        void mo33667f(int i, String str, String str2);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$Companion;", "", "()V", "CAPTURE_EMOJI_UPLOAD_MAX_COUNT", "", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.a.d$a */
    public static final class C18192a {
        private C18192a() {
        }

        public /* synthetic */ C18192a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.emoji.a.d$c */
    static final class C18193c implements Runnable {
        final /* synthetic */ C18190d eza;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "gifMd5", "isTooLarge", "", "onUploadEnd"})
        /* renamed from: com.tencent.mm.emoji.a.d$c$1 */
        static final class C92691 implements C1507b {
            final /* synthetic */ C18193c ezb;

            C92691(C18193c c18193c) {
                this.ezb = c18193c;
            }

            /* renamed from: b */
            public final void mo4971b(int i, int i2, String str, boolean z) {
                AppMethodBeat.m2504i(63245);
                C18191b c18191b;
                C1677a M;
                if (i == 0 && i2 == 0) {
                    C18190d.m28628a(this.ezb.eza, str);
                    AppMethodBeat.m2505o(63245);
                } else if (5 == i2) {
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(5, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else if (6 == i2) {
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(6, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else if (7 == i2) {
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(7, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else if (4 == i2) {
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(4, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else if (-434 == i2) {
                    if (5 > this.ezb.eza.exP.dva()) {
                        this.ezb.eza.exP.dvb();
                        M = C1720g.m3530M(C6835d.class);
                        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                        ((C6835d) M).getEmojiMgr().updateEmojiInfo(this.ezb.eza.exP);
                        c18191b = this.ezb.eza.eyY;
                        if (c18191b != null) {
                            c18191b.mo33667f(3, null, null);
                            AppMethodBeat.m2505o(63245);
                            return;
                        }
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(9, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else if (z) {
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(2, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else if (-24 == i2) {
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(8, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else if (5 > this.ezb.eza.exP.dva()) {
                    this.ezb.eza.exP.dvb();
                    M = C1720g.m3530M(C6835d.class);
                    C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    ((C6835d) M).getEmojiMgr().updateEmojiInfo(this.ezb.eza.exP);
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(1, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                } else {
                    c18191b = this.ezb.eza.eyY;
                    if (c18191b != null) {
                        c18191b.mo33667f(9, null, null);
                        AppMethodBeat.m2505o(63245);
                        return;
                    }
                    AppMethodBeat.m2505o(63245);
                }
            }
        }

        C18193c(C18190d c18190d) {
            this.eza = c18190d;
        }

        public final void run() {
            AppMethodBeat.m2504i(63246);
            new C1506c(this.eza.exP, true, true, this.eza.exP.field_attachedText, this.eza.eyX, this.eza.eyL).mo4970a((C1507b) new C92691(this));
            AppMethodBeat.m2505o(63246);
        }
    }

    static {
        AppMethodBeat.m2504i(63248);
        AppMethodBeat.m2505o(63248);
    }

    public C18190d(EmojiInfo emojiInfo, List<String> list, String str, C18191b c18191b) {
        boolean z;
        C25052j.m39376p(emojiInfo, "emojiInfo");
        AppMethodBeat.m2504i(63247);
        this.exP = emojiInfo;
        this.eyX = list;
        this.eyL = str;
        this.eyY = c18191b;
        C1677a M = C1720g.m3530M(C6835d.class);
        C25052j.m39375o(M, "plugin(IPluginEmoji::class.java)");
        this.eyW = ((C6835d) M).getEmojiMgr();
        C18191b c18191b2;
        if (!C5730e.m8628ct(this.exP.dve())) {
            c18191b2 = this.eyY;
            if (c18191b2 != null) {
                c18191b2.mo33667f(10, null, null);
            }
            z = false;
        } else if (C5730e.asZ(this.exP.dve()) > ((long) this.eyW.mo35643d(this.exP, true))) {
            c18191b2 = this.eyY;
            if (c18191b2 != null) {
                c18191b2.mo33667f(2, null, null);
            }
            z = false;
        } else {
            C32498b c32498b = C32498b.eyD;
            if (C32498b.m53214OF()) {
                if (5 > this.exP.dva()) {
                    this.exP.dvb();
                    M = C1720g.m3530M(C6835d.class);
                    C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    ((C6835d) M).getEmojiMgr().updateEmojiInfo(this.exP);
                    c18191b2 = this.eyY;
                    if (c18191b2 != null) {
                        c18191b2.mo33667f(3, null, null);
                    }
                } else {
                    c18191b2 = this.eyY;
                    if (c18191b2 != null) {
                        c18191b2.mo33667f(9, null, null);
                    }
                }
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            C4990ab.m7416i("MicroMsg.EmojiUploadLogic", "start upload emoji");
            C1720g.m3539RS().mo10302aa(new C18193c(this));
        }
        AppMethodBeat.m2505o(63247);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m28628a(C18190d c18190d, String str) {
        AppMethodBeat.m2504i(63249);
        C4990ab.m7416i("MicroMsg.EmojiUploadLogic", "deal success ".concat(String.valueOf(str)));
        if (!(str == null || (C25052j.m39373j(str, c18190d.exP.mo20410Aq()) ^ 1) == 0)) {
            EmojiInfo Je = c18190d.eyW.mo35597Je(str);
            C25052j.m39375o(Je, "emojiMgr.getEmojiByMd5(gifMd5)");
            c18190d.exP = Je;
        }
        C1677a M = C1720g.m3530M(C6835d.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((C6835d) M).getProvider().mo35661q(c18190d.exP);
        c18190d.eyW.mo35642c(c18190d.exP, false);
        C18191b c18191b = c18190d.eyY;
        if (c18191b != null) {
            c18191b.mo33667f(0, str, c18190d.exP.field_activityid);
            AppMethodBeat.m2505o(63249);
            return;
        }
        AppMethodBeat.m2505o(63249);
    }
}
