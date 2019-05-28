package com.tencent.p177mm.media.p254g;

import android.media.MediaFormat;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.media.p865c.C45425b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\tJD\u0010\"\u001a\u00020\u000e2<\b\u0002\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bJ\b\u0010#\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000RB\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "", "lock", "Ljava/lang/Object;", "onDecode", "Ljava/nio/ByteBuffer;", "", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.g.d */
public final class C45430d {
    final String TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    final C17126b<MediaFormat, C37091y> eTI;
    C45425b eXA;
    boolean eXB;
    final C31591m<ByteBuffer, Long, C37091y> eXC;
    final C32742a eXD;
    C31591m<? super MediaFormat, ? super C45430d, C37091y> exT;
    final C7306ak handler;
    final Object lock = new Object();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.d$c */
    static final class C9596c extends C25053k implements C17126b<C45425b, C37091y> {
        final /* synthetic */ C45430d eXE;

        C9596c(C45430d c45430d) {
            this.eXE = c45430d;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13036);
            C45425b c45425b = (C45425b) obj;
            C25052j.m39376p(c45425b, "receiver$0");
            c45425b.eTG = this.eXE.eXC;
            c45425b.eTI = this.eXE.eTI;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13036);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.d$d */
    static final class C9597d extends C25053k implements C17126b<C45425b, C37091y> {
        final /* synthetic */ C45430d eXE;

        C9597d(C45430d c45430d) {
            this.eXE = c45430d;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13037);
            C45425b c45425b = (C45425b) obj;
            C25052j.m39376p(c45425b, "receiver$0");
            c45425b.eTG = this.eXE.eXC;
            c45425b.eTI = this.eXE.eTI;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13037);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, dWq = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    /* renamed from: com.tencent.mm.media.g.d$e */
    static final class C31558e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C45430d eXE;

        C31558e(C45430d c45430d) {
            this.eXE = c45430d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13038);
            C45425b c45425b = this.eXE.eXA;
            if (c45425b != null) {
                c45425b.mo44163UB();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(13038);
                return c37091y;
            }
            AppMethodBeat.m2505o(13038);
            return null;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.d$b */
    static final class C32747b extends C25053k implements C17126b<MediaFormat, C37091y> {
        final /* synthetic */ C45430d eXE;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
        /* renamed from: com.tencent.mm.media.g.d$b$a */
        static final class C32748a implements Runnable {
            final /* synthetic */ C32747b eXH;
            final /* synthetic */ MediaFormat eXI;

            C32748a(C32747b c32747b, MediaFormat mediaFormat) {
                this.eXH = c32747b;
                this.eXI = mediaFormat;
            }

            public final void run() {
                AppMethodBeat.m2504i(13034);
                C31591m c31591m = this.eXH.eXE.exT;
                if (c31591m != null) {
                    c31591m.mo212m(this.eXI, this.eXH.eXE);
                    AppMethodBeat.m2505o(13034);
                    return;
                }
                AppMethodBeat.m2505o(13034);
            }
        }

        C32747b(C45430d c45430d) {
            this.eXE = c45430d;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13035);
            MediaFormat mediaFormat = (MediaFormat) obj;
            C25052j.m39376p(mediaFormat, "mediaFormat");
            C4990ab.m7416i(this.eXE.TAG, "onFormatChanged, format:".concat(String.valueOf(mediaFormat)));
            synchronized (this.eXE.lock) {
                try {
                    if (!this.eXE.eXB) {
                        C45430d.m83676a(this.eXE);
                        this.eXE.handler.post(new C32748a(this, mediaFormat));
                        this.eXE.eXB = true;
                    }
                    C37091y c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(13035);
                }
            }
            Object obj2 = C37091y.AUy;
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.d$a */
    static final class C36697a extends C25053k implements C31591m<ByteBuffer, Long, C37091y> {
        final /* synthetic */ C45430d eXE;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
        /* renamed from: com.tencent.mm.media.g.d$a$a */
        static final class C18592a implements Runnable {
            final /* synthetic */ MediaFormat eXF;
            final /* synthetic */ C36697a eXG;

            C18592a(MediaFormat mediaFormat, C36697a c36697a) {
                this.eXF = mediaFormat;
                this.eXG = c36697a;
            }

            public final void run() {
                AppMethodBeat.m2504i(13032);
                C31591m c31591m = this.eXG.eXE.exT;
                if (c31591m != null) {
                    c31591m.mo212m(this.eXF, this.eXG.eXE);
                    AppMethodBeat.m2505o(13032);
                    return;
                }
                AppMethodBeat.m2505o(13032);
            }
        }

        C36697a(C45430d c45430d) {
            this.eXE = c45430d;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            Object obj3;
            MediaFormat mediaFormat = null;
            AppMethodBeat.m2504i(13033);
            long longValue = ((Number) obj2).longValue();
            String str = this.eXE.TAG;
            StringBuilder stringBuilder = new StringBuilder("onDecode, format:");
            C45425b c45425b = this.eXE.eXA;
            if (c45425b != null) {
                obj3 = c45425b.mediaFormat;
            } else {
                obj3 = null;
            }
            C4990ab.m7416i(str, stringBuilder.append(obj3).append(", pts:").append(longValue).toString());
            synchronized (this.eXE.lock) {
                try {
                    c45425b = this.eXE.eXA;
                    if (c45425b != null) {
                        mediaFormat = c45425b.mediaFormat;
                    }
                    if (!this.eXE.eXB) {
                        C45430d.m83676a(this.eXE);
                        this.eXE.handler.post(new C18592a(mediaFormat, this));
                        this.eXE.eXB = true;
                    }
                    C37091y c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(13033);
                }
            }
            obj3 = C37091y.AUy;
            return obj3;
        }
    }

    public C45430d(C32742a c32742a) {
        C25052j.m39376p(c32742a, "mediaExtractor");
        AppMethodBeat.m2504i(13039);
        this.eXD = c32742a;
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        this.handler = new C7306ak(myLooper);
        C4990ab.m7416i(this.TAG, "create MediaCodecCheckVideoCropRect");
        this.eXD.mo53290UT();
        this.eXC = new C36697a(this);
        this.eTI = new C32747b(this);
        AppMethodBeat.m2505o(13039);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m83676a(C45430d c45430d) {
        AppMethodBeat.m2504i(13040);
        C4990ab.m7416i(c45430d.TAG, "stopDecoder");
        C45425b c45425b = c45430d.eXA;
        if (c45425b != null) {
            c45425b.mo44164sI();
            AppMethodBeat.m2505o(13040);
            return;
        }
        AppMethodBeat.m2505o(13040);
    }
}
