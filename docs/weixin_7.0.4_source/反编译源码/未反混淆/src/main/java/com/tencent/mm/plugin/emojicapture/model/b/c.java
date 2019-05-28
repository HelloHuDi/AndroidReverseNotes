package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.l;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001bR\u000e\u0010\f\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncodeThread", "Landroid/os/HandlerThread;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c {
    public static final a lit = new a();
    private final String TAG = "MicroMsg.EmojiMixGifEncoder";
    private final int height;
    private HandlerThread lin;
    ak lio;
    private com.tencent.mm.plugin.gif.a lip;
    private long liq;
    private int lir;
    private final String lis;
    private final int width;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder$Companion;", "", "()V", "EMOJI_MIX_WXAM_QP", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ c liu;
        final /* synthetic */ a.f.a.a lix;

        c(c cVar, a.f.a.a aVar) {
            this.liu = cVar;
            this.lix = aVar;
        }

        public final void run() {
            AppMethodBeat.i(2666);
            long yz = bo.yz();
            ab.i(this.liu.TAG, "finishEncode used " + bo.az(yz) + ", ret:" + this.liu.lip.bFM() + ", totally used " + bo.az(this.liu.liq) + "ms");
            this.liu.lin.quit();
            a.f.a.a aVar = this.lix;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(2666);
                return;
            }
            AppMethodBeat.o(2666);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ byte[] eXv;
        final /* synthetic */ c liu;
        final /* synthetic */ long liw = -1;

        b(c cVar, byte[] bArr) {
            this.liu = cVar;
            this.eXv = bArr;
        }

        public final void run() {
            AppMethodBeat.i(2665);
            long yz = bo.yz();
            ab.i(this.liu.TAG, "encodeRgbaFrame used " + bo.az(yz) + ", ret:" + this.liu.lip.c(this.eXv, this.liw));
            AppMethodBeat.o(2665);
        }
    }

    static {
        AppMethodBeat.i(2669);
        AppMethodBeat.o(2669);
    }

    public c(String str, int i, int i2, long j, final boolean z) {
        j.p(str, "outputPath");
        AppMethodBeat.i(2668);
        this.lis = str;
        this.width = i;
        this.height = i2;
        HandlerThread anM = d.anM("EmojiMixer_gifEncode");
        j.o(anM, "ThreadPool.newFreeHandle…d(\"EmojiMixer_gifEncode\")");
        this.lin = anM;
        this.lir = 30;
        this.lin.start();
        this.lio = new ak(this.lin.getLooper());
        this.lip = z ? new g(this.lis, this.width, this.height, j) : new com.tencent.mm.plugin.gif.j(this.lis, this.width, this.height, j);
        this.lio.post(new Runnable(this) {
            final /* synthetic */ c liu;

            public final void run() {
                AppMethodBeat.i(2664);
                boolean EK = this.liu.lip.EK();
                ab.i(this.liu.TAG, "init encoder, outputGif: " + z + " ret: " + EK);
                if (!EK) {
                    com.tencent.mm.plugin.emojicapture.model.d dVar;
                    if (z) {
                        dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                        com.tencent.mm.plugin.emojicapture.model.d.bng();
                    } else {
                        dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                        com.tencent.mm.plugin.emojicapture.model.d.bnf();
                    }
                }
                this.liu.liq = bo.yz();
                AppMethodBeat.o(2664);
            }
        });
        AppMethodBeat.o(2668);
    }
}
