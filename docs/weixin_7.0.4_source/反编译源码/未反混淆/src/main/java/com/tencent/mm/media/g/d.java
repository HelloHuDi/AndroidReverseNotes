package com.tencent.mm.media.g;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.media.MediaFormat;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\tJD\u0010\"\u001a\u00020\u000e2<\b\u0002\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bJ\b\u0010#\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000RB\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "", "lock", "Ljava/lang/Object;", "onDecode", "Ljava/nio/ByteBuffer;", "", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class d {
    final String TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    final a.f.a.b<MediaFormat, y> eTI;
    com.tencent.mm.media.c.b eXA;
    boolean eXB;
    final m<ByteBuffer, Long, y> eXC;
    final com.tencent.mm.media.e.a eXD;
    m<? super MediaFormat, ? super d, y> exT;
    final ak handler;
    final Object lock = new Object();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
    static final class c extends k implements a.f.a.b<com.tencent.mm.media.c.b, y> {
        final /* synthetic */ d eXE;

        c(d dVar) {
            this.eXE = dVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13036);
            com.tencent.mm.media.c.b bVar = (com.tencent.mm.media.c.b) obj;
            j.p(bVar, "receiver$0");
            bVar.eTG = this.eXE.eXC;
            bVar.eTI = this.eXE.eTI;
            y yVar = y.AUy;
            AppMethodBeat.o(13036);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
    static final class d extends k implements a.f.a.b<com.tencent.mm.media.c.b, y> {
        final /* synthetic */ d eXE;

        d(d dVar) {
            this.eXE = dVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13037);
            com.tencent.mm.media.c.b bVar = (com.tencent.mm.media.c.b) obj;
            j.p(bVar, "receiver$0");
            bVar.eTG = this.eXE.eXC;
            bVar.eTI = this.eXE.eTI;
            y yVar = y.AUy;
            AppMethodBeat.o(13037);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, dWq = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ d eXE;

        e(d dVar) {
            this.eXE = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13038);
            com.tencent.mm.media.c.b bVar = this.eXE.eXA;
            if (bVar != null) {
                bVar.UB();
                y yVar = y.AUy;
                AppMethodBeat.o(13038);
                return yVar;
            }
            AppMethodBeat.o(13038);
            return null;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
    static final class b extends k implements a.f.a.b<MediaFormat, y> {
        final /* synthetic */ d eXE;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b eXH;
            final /* synthetic */ MediaFormat eXI;

            a(b bVar, MediaFormat mediaFormat) {
                this.eXH = bVar;
                this.eXI = mediaFormat;
            }

            public final void run() {
                AppMethodBeat.i(13034);
                m mVar = this.eXH.eXE.exT;
                if (mVar != null) {
                    mVar.m(this.eXI, this.eXH.eXE);
                    AppMethodBeat.o(13034);
                    return;
                }
                AppMethodBeat.o(13034);
            }
        }

        b(d dVar) {
            this.eXE = dVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13035);
            MediaFormat mediaFormat = (MediaFormat) obj;
            j.p(mediaFormat, "mediaFormat");
            ab.i(this.eXE.TAG, "onFormatChanged, format:".concat(String.valueOf(mediaFormat)));
            synchronized (this.eXE.lock) {
                try {
                    if (!this.eXE.eXB) {
                        d.a(this.eXE);
                        this.eXE.handler.post(new a(this, mediaFormat));
                        this.eXE.eXB = true;
                    }
                    y yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(13035);
                }
            }
            Object obj2 = y.AUy;
            return obj2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "invoke"})
    static final class a extends k implements m<ByteBuffer, Long, y> {
        final /* synthetic */ d eXE;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ MediaFormat eXF;
            final /* synthetic */ a eXG;

            a(MediaFormat mediaFormat, a aVar) {
                this.eXF = mediaFormat;
                this.eXG = aVar;
            }

            public final void run() {
                AppMethodBeat.i(13032);
                m mVar = this.eXG.eXE.exT;
                if (mVar != null) {
                    mVar.m(this.eXF, this.eXG.eXE);
                    AppMethodBeat.o(13032);
                    return;
                }
                AppMethodBeat.o(13032);
            }
        }

        a(d dVar) {
            this.eXE = dVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            Object obj3;
            MediaFormat mediaFormat = null;
            AppMethodBeat.i(13033);
            long longValue = ((Number) obj2).longValue();
            String str = this.eXE.TAG;
            StringBuilder stringBuilder = new StringBuilder("onDecode, format:");
            com.tencent.mm.media.c.b bVar = this.eXE.eXA;
            if (bVar != null) {
                obj3 = bVar.mediaFormat;
            } else {
                obj3 = null;
            }
            ab.i(str, stringBuilder.append(obj3).append(", pts:").append(longValue).toString());
            synchronized (this.eXE.lock) {
                try {
                    bVar = this.eXE.eXA;
                    if (bVar != null) {
                        mediaFormat = bVar.mediaFormat;
                    }
                    if (!this.eXE.eXB) {
                        d.a(this.eXE);
                        this.eXE.handler.post(new a(mediaFormat, this));
                        this.eXE.eXB = true;
                    }
                    y yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(13033);
                }
            }
            obj3 = y.AUy;
            return obj3;
        }
    }

    public d(com.tencent.mm.media.e.a aVar) {
        j.p(aVar, "mediaExtractor");
        AppMethodBeat.i(13039);
        this.eXD = aVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        this.handler = new ak(myLooper);
        ab.i(this.TAG, "create MediaCodecCheckVideoCropRect");
        this.eXD.UT();
        this.eXC = new a(this);
        this.eTI = new b(this);
        AppMethodBeat.o(13039);
    }

    public static final /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(13040);
        ab.i(dVar.TAG, "stopDecoder");
        com.tencent.mm.media.c.b bVar = dVar.eXA;
        if (bVar != null) {
            bVar.sI();
            AppMethodBeat.o(13040);
            return;
        }
        AppMethodBeat.o(13040);
    }
}
