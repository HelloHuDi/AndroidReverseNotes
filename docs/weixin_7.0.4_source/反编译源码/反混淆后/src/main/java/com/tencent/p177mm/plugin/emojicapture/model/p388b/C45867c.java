package com.tencent.p177mm.plugin.emojicapture.model.p388b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.gif.C3277g;
import com.tencent.p177mm.plugin.gif.C34326j;
import com.tencent.p177mm.plugin.gif.C39242a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import p000a.C0220l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001bR\u000e\u0010\f\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncodeThread", "Landroid/os/HandlerThread;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.c */
public final class C45867c {
    public static final C20428a lit = new C20428a();
    private final String TAG = "MicroMsg.EmojiMixGifEncoder";
    private final int height;
    private HandlerThread lin;
    C7306ak lio;
    private C39242a lip;
    private long liq;
    private int lir;
    private final String lis;
    private final int width;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder$Companion;", "", "()V", "EMOJI_MIX_WXAM_QP", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.c$a */
    public static final class C20428a {
        private C20428a() {
        }

        public /* synthetic */ C20428a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.c$c */
    static final class C38910c implements Runnable {
        final /* synthetic */ C45867c liu;
        final /* synthetic */ C31214a lix;

        C38910c(C45867c c45867c, C31214a c31214a) {
            this.liu = c45867c;
            this.lix = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(2666);
            long yz = C5046bo.m7588yz();
            C4990ab.m7416i(this.liu.TAG, "finishEncode used " + C5046bo.m7525az(yz) + ", ret:" + this.liu.lip.bFM() + ", totally used " + C5046bo.m7525az(this.liu.liq) + "ms");
            this.liu.lin.quit();
            C31214a c31214a = this.lix;
            if (c31214a != null) {
                c31214a.invoke();
                AppMethodBeat.m2505o(2666);
                return;
            }
            AppMethodBeat.m2505o(2666);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.c$b */
    static final class C45866b implements Runnable {
        final /* synthetic */ byte[] eXv;
        final /* synthetic */ C45867c liu;
        final /* synthetic */ long liw = -1;

        C45866b(C45867c c45867c, byte[] bArr) {
            this.liu = c45867c;
            this.eXv = bArr;
        }

        public final void run() {
            AppMethodBeat.m2504i(2665);
            long yz = C5046bo.m7588yz();
            C4990ab.m7416i(this.liu.TAG, "encodeRgbaFrame used " + C5046bo.m7525az(yz) + ", ret:" + this.liu.lip.mo7646c(this.eXv, this.liw));
            AppMethodBeat.m2505o(2665);
        }
    }

    static {
        AppMethodBeat.m2504i(2669);
        AppMethodBeat.m2505o(2669);
    }

    public C45867c(String str, int i, int i2, long j, final boolean z) {
        C25052j.m39376p(str, "outputPath");
        AppMethodBeat.m2504i(2668);
        this.lis = str;
        this.width = i;
        this.height = i2;
        HandlerThread anM = C7305d.anM("EmojiMixer_gifEncode");
        C25052j.m39375o(anM, "ThreadPool.newFreeHandle…d(\"EmojiMixer_gifEncode\")");
        this.lin = anM;
        this.lir = 30;
        this.lin.start();
        this.lio = new C7306ak(this.lin.getLooper());
        this.lip = z ? new C3277g(this.lis, this.width, this.height, j) : new C34326j(this.lis, this.width, this.height, j);
        this.lio.post(new Runnable(this) {
            final /* synthetic */ C45867c liu;

            public final void run() {
                AppMethodBeat.m2504i(2664);
                boolean EK = this.liu.lip.mo7644EK();
                C4990ab.m7416i(this.liu.TAG, "init encoder, outputGif: " + z + " ret: " + EK);
                if (!EK) {
                    C34007d c34007d;
                    if (z) {
                        c34007d = C34007d.lhz;
                        C34007d.bng();
                    } else {
                        c34007d = C34007d.lhz;
                        C34007d.bnf();
                    }
                }
                this.liu.liq = C5046bo.m7588yz();
                AppMethodBeat.m2505o(2664);
            }
        });
        AppMethodBeat.m2505o(2668);
    }
}
