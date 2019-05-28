package com.tencent.mm.plugin.emojicapture.ui;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\u0006\u00102\u001a\u00020\tJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020\rJ\u0006\u00106\u001a\u00020\u000fJ\"\u00107\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0016J\u0012\u0010;\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u000108H\u0016J\"\u0010<\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0016J\u0012\u0010=\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u00020\u001dH\u0002J\u0006\u0010?\u001a\u00020\u001dJ\u000e\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020BJ\u0016\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010C\u001a\u00020\u001d2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u000e\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u000204J \u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u000f2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u000e\u0010J\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010L\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\rJ\u0006\u0010M\u001a\u00020\u000fJ\u0006\u0010N\u001a\u00020\u001dR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "TAG", "", "afterSeekPlay", "", "callback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "isMute", "isOnlineVideo", "isPrepared", "isRemoveBg", "lastSurfaceUpdatedTime", "", "needReset", "onSurfaceCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "oneTimeTextureUpdateCallback", "Lkotlin/Function0;", "", "openWithNoneSurface", "path", "pauseByDestroyed", "pauseWhenUpdated", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "removeBgEnable", "renderSurface", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "seekCompleteCallback", "Lkotlin/Function1;", "surface", "Landroid/view/Surface;", "useMp4Extrator", "videoHeight", "videoWidth", "getDuration", "getPlayRate", "", "getVideoPath", "isPlaying", "onSurfaceTextureAvailable", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "openVideo", "pause", "seekTo", "time", "", "setOneTimeVideoTextureUpdateCallback", "_callback", "setPlayRate", "rate", "setRemoveBackground", "remove", "afterDraw", "setRemoveBgEnable", "setVideoCallback", "setVideoPath", "start", "stop", "plugin-emojicapture_release"})
public final class EmojiVideoPlayTextureView extends MMTextureView implements SurfaceTextureListener {
    private final String TAG = "MicroMsg.EmojiVideoPlayTextureView";
    private boolean VN;
    private Surface aOO;
    private boolean eif;
    private boolean liA;
    public i llA;
    public boolean llB = true;
    private long llC;
    private boolean llD;
    private com.tencent.mm.pluginsdk.ui.tools.e.a llE;
    private a.f.a.a<y> llF;
    private a.f.a.b<? super Boolean, y> llG;
    private com.tencent.mm.pluginsdk.ui.tools.e.d llH;
    private boolean llI;
    private boolean llJ;
    private boolean llK;
    private boolean llL;
    private boolean llM;
    private boolean llN = true;
    private com.tencent.mm.plugin.n.c llO;
    private com.tencent.mm.plugin.emojicapture.ui.b.i llt;
    private b llz;
    private String path = "";
    private int videoHeight;
    private int videoWidth;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiVideoPlayTextureView llP;
        final /* synthetic */ a.f.a.a llS;

        d(EmojiVideoPlayTextureView emojiVideoPlayTextureView, a.f.a.a aVar) {
            this.llP = emojiVideoPlayTextureView;
            this.llS = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2912);
            a.f.a.a aVar = this.llS;
            if (aVar != null) {
                aVar.invoke();
            }
            com.tencent.mm.plugin.emojicapture.ui.b.i a = this.llP.llt;
            if (a != null) {
                a.lqm = null;
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2912);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-emojicapture_release"})
    public static final class c implements com.tencent.mm.plugin.n.c {
        final /* synthetic */ EmojiVideoPlayTextureView llP;

        c(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            this.llP = emojiVideoPlayTextureView;
        }

        public final void pL() {
            AppMethodBeat.i(2907);
            ab.i(this.llP.TAG, "onPrepared: ");
            this.llP.VN = true;
            com.tencent.mm.pluginsdk.ui.tools.e.a m = this.llP.llE;
            if (m != null) {
                m.pL();
            }
            this.llP.requestLayout();
            AppMethodBeat.o(2907);
        }

        public final void EA() {
            AppMethodBeat.i(2908);
            com.tencent.mm.pluginsdk.ui.tools.e.a m = this.llP.llE;
            if (m != null) {
                m.EA();
                AppMethodBeat.o(2908);
                return;
            }
            AppMethodBeat.o(2908);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.i(2909);
            com.tencent.mm.pluginsdk.ui.tools.e.a m = this.llP.llE;
            if (m != null) {
                m.onError(i, i2);
                AppMethodBeat.o(2909);
                return;
            }
            AppMethodBeat.o(2909);
        }

        public final void bnT() {
            AppMethodBeat.i(2910);
            a.f.a.b n = this.llP.llG;
            if (n != null) {
                n.am(Boolean.valueOf(this.llP.llB));
            }
            if (this.llP.llB) {
                String b = this.llP.TAG;
                String str = "%s player seek done";
                Object[] objArr = new Object[1];
                i f = this.llP.llA;
                objArr[0] = f != null ? f.aZm() : null;
                ab.d(b, str, objArr);
                f = this.llP.llA;
                if (f != null) {
                    f.start();
                    AppMethodBeat.o(2910);
                    return;
                }
                AppMethodBeat.o(2910);
                return;
            }
            ab.d(this.llP.TAG, "player seek done, but don't play now.");
            this.llP.llB = true;
            AppMethodBeat.o(2910);
        }

        public final void S(int i, int i2, int i3) {
            AppMethodBeat.i(2911);
            ab.i(this.llP.TAG, "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            this.llP.videoWidth = i;
            this.llP.videoHeight = i2;
            com.tencent.mm.pluginsdk.ui.tools.e.a m = this.llP.llE;
            if (m != null) {
                m.dH(this.llP.videoWidth, this.llP.videoHeight);
                AppMethodBeat.o(2911);
                return;
            }
            AppMethodBeat.o(2911);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "invoke"})
    static final class b extends k implements a.f.a.b<b, y> {
        final /* synthetic */ int eXr;
        final /* synthetic */ int eXs;
        final /* synthetic */ EmojiVideoPlayTextureView llP;
        final /* synthetic */ com.tencent.mm.plugin.emojicapture.ui.b.i llR;

        b(EmojiVideoPlayTextureView emojiVideoPlayTextureView, int i, int i2, com.tencent.mm.plugin.emojicapture.ui.b.i iVar) {
            this.llP = emojiVideoPlayTextureView;
            this.eXr = i;
            this.eXs = i2;
            this.llR = iVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2906);
            b bVar = (b) obj;
            j.p(bVar, "receiver$0");
            com.tencent.mm.plugin.emojicapture.ui.b.i a = this.llP.llt;
            if (a != null) {
                a.dY(this.eXr, this.eXs);
            }
            bVar.gF(true);
            ab.i(this.llP.TAG, "initGL finish pauseByDestroyed:" + this.llP.llL);
            this.llP.aOO = new Surface(this.llR.lql);
            if (this.llP.llA == null || !this.llP.VN) {
                EmojiVideoPlayTextureView.i(this.llP);
            } else {
                i f = this.llP.llA;
                if (f != null) {
                    f.f(this.llP.aOO);
                }
                if (this.llP.llL) {
                    f = this.llP.llA;
                    if (f != null) {
                        f.start();
                    }
                } else {
                    this.llP.llM = true;
                    this.llP.llC = 0;
                    f = this.llP.llA;
                    if (f != null) {
                        f.setMute(true);
                    }
                    f = this.llP.llA;
                    if (f != null) {
                        f.start();
                    }
                }
                this.llP.llL = false;
            }
            com.tencent.mm.pluginsdk.ui.tools.e.d l = this.llP.llH;
            if (l != null) {
                l.akY();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2906);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiVideoPlayTextureView llP;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView$a$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ a llQ;

            AnonymousClass1(a aVar) {
                this.llQ = aVar;
            }

            public final void run() {
                AppMethodBeat.i(2904);
                this.llQ.llP.setVisibility(0);
                AppMethodBeat.o(2904);
            }
        }

        a(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            this.llP = emojiVideoPlayTextureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2905);
            al.d(new AnonymousClass1(this));
            com.tencent.mm.plugin.emojicapture.ui.b.i a = this.llP.llt;
            if (a != null) {
                a.lqm = null;
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2905);
            return yVar;
        }
    }

    public static final /* synthetic */ void i(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
        AppMethodBeat.i(2932);
        emojiVideoPlayTextureView.bnS();
        AppMethodBeat.o(2932);
    }

    public EmojiVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(2929);
        setSurfaceTextureListener(this);
        setOpaque(false);
        this.llO = new c(this);
        AppMethodBeat.o(2929);
    }

    public EmojiVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(2930);
        setSurfaceTextureListener(this);
        setOpaque(false);
        this.llO = new c(this);
        AppMethodBeat.o(2930);
    }

    public EmojiVideoPlayTextureView(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(2931);
        setSurfaceTextureListener(this);
        setOpaque(false);
        this.llO = new c(this);
        AppMethodBeat.o(2931);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(2913);
        if (!(this.llA instanceof i) || this.llA == null) {
            AppMethodBeat.o(2913);
            return false;
        }
        i iVar = this.llA;
        if (iVar == null) {
            j.dWJ();
        }
        boolean isPlaying = iVar.isPlaying();
        AppMethodBeat.o(2913);
        return isPlaying;
    }

    public final void setVideoPath(String str) {
        AppMethodBeat.i(2914);
        j.p(str, "path");
        ab.i(this.TAG, "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        bnS();
        requestLayout();
        AppMethodBeat.o(2914);
    }

    public final String getVideoPath() {
        return this.path;
    }

    public final void setVideoCallback(com.tencent.mm.pluginsdk.ui.tools.e.a aVar) {
        AppMethodBeat.i(2915);
        j.p(aVar, "callback");
        this.llE = aVar;
        AppMethodBeat.o(2915);
    }

    public final void setOneTimeVideoTextureUpdateCallback(a.f.a.a<y> aVar) {
        this.llF = aVar;
    }

    public final void setPlayRate(float f) {
        AppMethodBeat.i(2916);
        i iVar = this.llA;
        if (iVar != null) {
            iVar.setPlayRate(f);
            AppMethodBeat.o(2916);
            return;
        }
        AppMethodBeat.o(2916);
    }

    public final void setRemoveBgEnable(boolean z) {
        this.llN = z;
    }

    public final void b(boolean z, a.f.a.a<y> aVar) {
        AppMethodBeat.i(2917);
        this.liA = z;
        com.tencent.mm.plugin.emojicapture.ui.b.i iVar = this.llt;
        if (iVar != null) {
            iVar.ljd = z;
        }
        com.tencent.mm.plugin.emojicapture.ui.b.i iVar2 = this.llt;
        if (iVar2 != null) {
            iVar2.lqm = new d(this, aVar);
            AppMethodBeat.o(2917);
            return;
        }
        AppMethodBeat.o(2917);
    }

    public final float getPlayRate() {
        AppMethodBeat.i(2919);
        if (this.llA != null) {
            i iVar = this.llA;
            if (iVar == null) {
                j.dWJ();
            }
            float playRate = iVar.getPlayRate();
            AppMethodBeat.o(2919);
            return playRate;
        }
        AppMethodBeat.o(2919);
        return 1.0f;
    }

    private final void bnS() {
        i iVar;
        AppMethodBeat.i(2920);
        ab.i(this.TAG, "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        if (this.llA != null) {
            iVar = this.llA;
            if (iVar != null) {
                iVar.a(null);
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.stop();
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.release();
            }
            this.llA = null;
        }
        if (bo.isNullOrNil(this.path) || this.aOO == null) {
            ab.w(this.TAG, "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
            AppMethodBeat.o(2920);
            return;
        }
        try {
            this.VN = false;
            this.llA = new i(Looper.getMainLooper());
            iVar = this.llA;
            if (iVar != null) {
                iVar.setPath(this.path);
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.setNeedResetExtractor(this.llI);
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.setIsOnlineVideoType(this.llJ);
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.a(this.llO);
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.setSurface(this.aOO);
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.iU(this.llK);
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.setMute(true);
            }
            if (this.aOO != null) {
                iVar = this.llA;
                if (iVar != null) {
                    iVar.prepare();
                    AppMethodBeat.o(2920);
                    return;
                }
                AppMethodBeat.o(2920);
                return;
            }
            if (this.llD) {
                iVar = this.llA;
                if (iVar != null) {
                    iVar.prepare();
                    AppMethodBeat.o(2920);
                    return;
                }
            }
            AppMethodBeat.o(2920);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "prepare async error %s", e.getMessage());
            com.tencent.mm.pluginsdk.ui.tools.e.a aVar = this.llE;
            if (aVar != null) {
                aVar.onError(-1, -1);
                AppMethodBeat.o(2920);
                return;
            }
            AppMethodBeat.o(2920);
        }
    }

    public final boolean start() {
        AppMethodBeat.i(2921);
        String str;
        String str2;
        Object[] objArr;
        if (this.llA == null || !this.VN) {
            boolean z;
            str = this.TAG;
            str2 = "%d player is null[%b] or it prepared [%b]";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.llA == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.VN);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(2921);
            return false;
        }
        str = this.TAG;
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.llM);
        objArr[2] = Boolean.valueOf(this.llL);
        objArr[3] = Boolean.valueOf(this.aOO != null);
        ab.i(str, str2, objArr);
        if (this.aOO == null) {
            this.llL = true;
            AppMethodBeat.o(2921);
            return true;
        } else if (this.llM) {
            this.llL = true;
            this.llM = false;
            AppMethodBeat.o(2921);
            return true;
        } else {
            i iVar = this.llA;
            if (iVar != null) {
                iVar.start();
            }
            b bVar = this.llz;
            if (bVar != null) {
                bVar.gG(false);
            }
            AppMethodBeat.o(2921);
            return true;
        }
    }

    public final void stop() {
        AppMethodBeat.i(2922);
        ab.i(this.TAG, "%d player stop [%s]", Integer.valueOf(hashCode()), bo.dpG());
        i iVar = this.llA;
        if (iVar != null) {
            iVar.a(null);
        }
        iVar = this.llA;
        if (iVar != null) {
            iVar.stop();
        }
        iVar = this.llA;
        if (iVar != null) {
            iVar.release();
        }
        this.llA = null;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.VN = false;
        this.path = "";
        this.llC = 0;
        AppMethodBeat.o(2922);
    }

    public final void pause() {
        AppMethodBeat.i(2923);
        if (this.llA != null) {
            i iVar = this.llA;
            if (iVar == null) {
                j.dWJ();
            }
            if (iVar.isPlaying()) {
                iVar = this.llA;
                if (iVar != null) {
                    iVar.pause();
                }
                b bVar = this.llz;
                if (bVar != null) {
                    bVar.gG(true);
                }
            }
        }
        this.llL = false;
        AppMethodBeat.o(2923);
    }

    public final int getDuration() {
        AppMethodBeat.i(2924);
        if (this.llA != null) {
            i iVar = this.llA;
            if (iVar == null) {
                j.dWJ();
            }
            int bPa = (int) iVar.bPa();
            AppMethodBeat.o(2924);
            return bPa;
        }
        AppMethodBeat.o(2924);
        return 0;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(2925);
        ab.i(this.TAG, "onSurfaceTextureSizeChanged " + i + ", " + i2);
        com.tencent.mm.plugin.emojicapture.ui.b.i iVar = this.llt;
        if (iVar != null) {
            iVar.dY(i, i2);
            AppMethodBeat.o(2925);
            return;
        }
        AppMethodBeat.o(2925);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(2926);
        if (this.llM && this.llC > 0) {
            i iVar = this.llA;
            if (iVar != null) {
                iVar.pause();
            }
            iVar = this.llA;
            if (iVar != null) {
                iVar.setMute(this.eif);
            }
            this.llM = false;
        }
        if (this.llC > 0 && this.llF != null) {
            ab.i(this.TAG, "%d notify surface update", Integer.valueOf(hashCode()));
            a.f.a.a aVar = this.llF;
            if (aVar != null) {
                aVar.invoke();
            }
            this.llF = null;
        }
        this.llC = System.currentTimeMillis();
        AppMethodBeat.o(2926);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(2927);
        ab.i(this.TAG, "onSurfaceTextureDestroyed");
        b bVar = this.llz;
        if (bVar != null) {
            bVar.gF(false);
        }
        b bVar2 = this.llz;
        if (bVar2 != null) {
            bVar2.b(new a(bVar2));
        }
        this.aOO = null;
        this.llL = false;
        this.llM = false;
        if (this.llA == null) {
            this.llL = false;
        } else if (isPlaying()) {
            this.llL = true;
            i iVar = this.llA;
            if (iVar != null) {
                iVar.pause();
            }
        }
        AppMethodBeat.o(2927);
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(2928);
        dAh();
        ab.i(this.TAG, "onSurfaceTextureAvailable, " + i + ", " + i2 + ", " + surfaceTexture);
        if (surfaceTexture != null) {
            try {
                com.tencent.mm.plugin.emojicapture.ui.b.i iVar = new com.tencent.mm.plugin.emojicapture.ui.b.i(this.llN);
                com.tencent.mm.plugin.emojicapture.ui.b.i iVar2 = this.llt;
                if (iVar2 != null) {
                    iVar2.release();
                }
                this.llt = iVar;
                if (this.llL) {
                    setVisibility(4);
                    iVar2 = this.llt;
                    if (iVar2 != null) {
                        iVar2.ljd = this.liA;
                    }
                    com.tencent.mm.plugin.emojicapture.ui.b.i iVar3 = this.llt;
                    if (iVar3 != null) {
                        iVar3.lqm = new a(this);
                    }
                }
                this.llz = new b(surfaceTexture, iVar, new b(this, i, i2, iVar));
                AppMethodBeat.o(2928);
                return;
            } catch (Exception e) {
                ab.i(this.TAG, "onSurfaceTextureAvailable error: ".concat(String.valueOf(e)));
            }
        }
        AppMethodBeat.o(2928);
    }
}
