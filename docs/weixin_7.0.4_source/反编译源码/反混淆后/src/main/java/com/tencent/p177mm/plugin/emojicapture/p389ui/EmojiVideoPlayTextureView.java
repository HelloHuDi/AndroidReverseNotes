package com.tencent.p177mm.plugin.emojicapture.p389ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C27809b.C27810a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C38919i;
import com.tencent.p177mm.plugin.p468n.C34602i;
import com.tencent.p177mm.plugin.p468n.C39453c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\u0006\u00102\u001a\u00020\tJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020\rJ\u0006\u00106\u001a\u00020\u000fJ\"\u00107\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0016J\u0012\u0010;\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u000108H\u0016J\"\u0010<\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0016J\u0012\u0010=\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u00020\u001dH\u0002J\u0006\u0010?\u001a\u00020\u001dJ\u000e\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020BJ\u0016\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010C\u001a\u00020\u001d2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u000e\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u000204J \u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u000f2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u000e\u0010J\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010L\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\rJ\u0006\u0010M\u001a\u00020\u000fJ\u0006\u0010N\u001a\u00020\u001dR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "TAG", "", "afterSeekPlay", "", "callback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "isMute", "isOnlineVideo", "isPrepared", "isRemoveBg", "lastSurfaceUpdatedTime", "", "needReset", "onSurfaceCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "oneTimeTextureUpdateCallback", "Lkotlin/Function0;", "", "openWithNoneSurface", "path", "pauseByDestroyed", "pauseWhenUpdated", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "removeBgEnable", "renderSurface", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "seekCompleteCallback", "Lkotlin/Function1;", "surface", "Landroid/view/Surface;", "useMp4Extrator", "videoHeight", "videoWidth", "getDuration", "getPlayRate", "", "getVideoPath", "isPlaying", "onSurfaceTextureAvailable", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "openVideo", "pause", "seekTo", "time", "", "setOneTimeVideoTextureUpdateCallback", "_callback", "setPlayRate", "rate", "setRemoveBackground", "remove", "afterDraw", "setRemoveBgEnable", "setVideoCallback", "setVideoPath", "start", "stop", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView */
public final class EmojiVideoPlayTextureView extends MMTextureView implements SurfaceTextureListener {
    private final String TAG = "MicroMsg.EmojiVideoPlayTextureView";
    /* renamed from: VN */
    private boolean f17197VN;
    private Surface aOO;
    private boolean eif;
    private boolean liA;
    public C34602i llA;
    public boolean llB = true;
    private long llC;
    private boolean llD;
    private C14981a llE;
    private C31214a<C37091y> llF;
    private C17126b<? super Boolean, C37091y> llG;
    private C14978d llH;
    private boolean llI;
    private boolean llJ;
    private boolean llK;
    private boolean llL;
    private boolean llM;
    private boolean llN = true;
    private C39453c llO;
    private C38919i llt;
    private C27809b llz;
    private String path = "";
    private int videoHeight;
    private int videoWidth;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView$d */
    static final class C20442d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiVideoPlayTextureView llP;
        final /* synthetic */ C31214a llS;

        C20442d(EmojiVideoPlayTextureView emojiVideoPlayTextureView, C31214a c31214a) {
            this.llP = emojiVideoPlayTextureView;
            this.llS = c31214a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2912);
            C31214a c31214a = this.llS;
            if (c31214a != null) {
                c31214a.invoke();
            }
            C38919i a = this.llP.llt;
            if (a != null) {
                a.lqm = null;
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2912);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView$c */
    public static final class C27805c implements C39453c {
        final /* synthetic */ EmojiVideoPlayTextureView llP;

        C27805c(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            this.llP = emojiVideoPlayTextureView;
        }

        /* renamed from: pL */
        public final void mo39086pL() {
            AppMethodBeat.m2504i(2907);
            C4990ab.m7416i(this.llP.TAG, "onPrepared: ");
            this.llP.f17197VN = true;
            C14981a m = this.llP.llE;
            if (m != null) {
                m.mo8557pL();
            }
            this.llP.requestLayout();
            AppMethodBeat.m2505o(2907);
        }

        /* renamed from: EA */
        public final void mo39082EA() {
            AppMethodBeat.m2504i(2908);
            C14981a m = this.llP.llE;
            if (m != null) {
                m.mo8553EA();
                AppMethodBeat.m2505o(2908);
                return;
            }
            AppMethodBeat.m2505o(2908);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(2909);
            C14981a m = this.llP.llE;
            if (m != null) {
                m.onError(i, i2);
                AppMethodBeat.m2505o(2909);
                return;
            }
            AppMethodBeat.m2505o(2909);
        }

        public final void bnT() {
            AppMethodBeat.m2504i(2910);
            C17126b n = this.llP.llG;
            if (n != null) {
                n.mo50am(Boolean.valueOf(this.llP.llB));
            }
            if (this.llP.llB) {
                String b = this.llP.TAG;
                String str = "%s player seek done";
                Object[] objArr = new Object[1];
                C34602i f = this.llP.llA;
                objArr[0] = f != null ? f.aZm() : null;
                C4990ab.m7411d(b, str, objArr);
                f = this.llP.llA;
                if (f != null) {
                    f.start();
                    AppMethodBeat.m2505o(2910);
                    return;
                }
                AppMethodBeat.m2505o(2910);
                return;
            }
            C4990ab.m7410d(this.llP.TAG, "player seek done, but don't play now.");
            this.llP.llB = true;
            AppMethodBeat.m2505o(2910);
        }

        /* renamed from: S */
        public final void mo39083S(int i, int i2, int i3) {
            AppMethodBeat.m2504i(2911);
            C4990ab.m7417i(this.llP.TAG, "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            this.llP.videoWidth = i;
            this.llP.videoHeight = i2;
            C14981a m = this.llP.llE;
            if (m != null) {
                m.mo8555dH(this.llP.videoWidth, this.llP.videoHeight);
                AppMethodBeat.m2505o(2911);
                return;
            }
            AppMethodBeat.m2505o(2911);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView$b */
    static final class C42977b extends C25053k implements C17126b<C27809b, C37091y> {
        final /* synthetic */ int eXr;
        final /* synthetic */ int eXs;
        final /* synthetic */ EmojiVideoPlayTextureView llP;
        final /* synthetic */ C38919i llR;

        C42977b(EmojiVideoPlayTextureView emojiVideoPlayTextureView, int i, int i2, C38919i c38919i) {
            this.llP = emojiVideoPlayTextureView;
            this.eXr = i;
            this.eXs = i2;
            this.llR = c38919i;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2906);
            C27809b c27809b = (C27809b) obj;
            C25052j.m39376p(c27809b, "receiver$0");
            C38919i a = this.llP.llt;
            if (a != null) {
                a.mo61808dY(this.eXr, this.eXs);
            }
            c27809b.mo45654gF(true);
            C4990ab.m7416i(this.llP.TAG, "initGL finish pauseByDestroyed:" + this.llP.llL);
            this.llP.aOO = new Surface(this.llR.lql);
            if (this.llP.llA == null || !this.llP.f17197VN) {
                EmojiVideoPlayTextureView.m76320i(this.llP);
            } else {
                C34602i f = this.llP.llA;
                if (f != null) {
                    f.mo55170f(this.llP.aOO);
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
            C14978d l = this.llP.llH;
            if (l != null) {
                l.akY();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2906);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView$a */
    static final class C42978a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiVideoPlayTextureView llP;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView$a$1 */
        static final class C204411 implements Runnable {
            final /* synthetic */ C42978a llQ;

            C204411(C42978a c42978a) {
                this.llQ = c42978a;
            }

            public final void run() {
                AppMethodBeat.m2504i(2904);
                this.llQ.llP.setVisibility(0);
                AppMethodBeat.m2505o(2904);
            }
        }

        C42978a(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            this.llP = emojiVideoPlayTextureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2905);
            C5004al.m7441d(new C204411(this));
            C38919i a = this.llP.llt;
            if (a != null) {
                a.lqm = null;
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2905);
            return c37091y;
        }
    }

    /* renamed from: i */
    public static final /* synthetic */ void m76320i(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
        AppMethodBeat.m2504i(2932);
        emojiVideoPlayTextureView.bnS();
        AppMethodBeat.m2505o(2932);
    }

    public EmojiVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(2929);
        setSurfaceTextureListener(this);
        setOpaque(false);
        this.llO = new C27805c(this);
        AppMethodBeat.m2505o(2929);
    }

    public EmojiVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(2930);
        setSurfaceTextureListener(this);
        setOpaque(false);
        this.llO = new C27805c(this);
        AppMethodBeat.m2505o(2930);
    }

    public EmojiVideoPlayTextureView(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(2931);
        setSurfaceTextureListener(this);
        setOpaque(false);
        this.llO = new C27805c(this);
        AppMethodBeat.m2505o(2931);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(2913);
        if (!(this.llA instanceof C34602i) || this.llA == null) {
            AppMethodBeat.m2505o(2913);
            return false;
        }
        C34602i c34602i = this.llA;
        if (c34602i == null) {
            C25052j.dWJ();
        }
        boolean isPlaying = c34602i.isPlaying();
        AppMethodBeat.m2505o(2913);
        return isPlaying;
    }

    public final void setVideoPath(String str) {
        AppMethodBeat.m2504i(2914);
        C25052j.m39376p(str, "path");
        C4990ab.m7417i(this.TAG, "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        bnS();
        requestLayout();
        AppMethodBeat.m2505o(2914);
    }

    public final String getVideoPath() {
        return this.path;
    }

    public final void setVideoCallback(C14981a c14981a) {
        AppMethodBeat.m2504i(2915);
        C25052j.m39376p(c14981a, "callback");
        this.llE = c14981a;
        AppMethodBeat.m2505o(2915);
    }

    public final void setOneTimeVideoTextureUpdateCallback(C31214a<C37091y> c31214a) {
        this.llF = c31214a;
    }

    public final void setPlayRate(float f) {
        AppMethodBeat.m2504i(2916);
        C34602i c34602i = this.llA;
        if (c34602i != null) {
            c34602i.setPlayRate(f);
            AppMethodBeat.m2505o(2916);
            return;
        }
        AppMethodBeat.m2505o(2916);
    }

    public final void setRemoveBgEnable(boolean z) {
        this.llN = z;
    }

    /* renamed from: b */
    public final void mo68506b(boolean z, C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(2917);
        this.liA = z;
        C38919i c38919i = this.llt;
        if (c38919i != null) {
            c38919i.ljd = z;
        }
        C38919i c38919i2 = this.llt;
        if (c38919i2 != null) {
            c38919i2.lqm = new C20442d(this, c31214a);
            AppMethodBeat.m2505o(2917);
            return;
        }
        AppMethodBeat.m2505o(2917);
    }

    public final float getPlayRate() {
        AppMethodBeat.m2504i(2919);
        if (this.llA != null) {
            C34602i c34602i = this.llA;
            if (c34602i == null) {
                C25052j.dWJ();
            }
            float playRate = c34602i.getPlayRate();
            AppMethodBeat.m2505o(2919);
            return playRate;
        }
        AppMethodBeat.m2505o(2919);
        return 1.0f;
    }

    private final void bnS() {
        C34602i c34602i;
        AppMethodBeat.m2504i(2920);
        C4990ab.m7417i(this.TAG, "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        if (this.llA != null) {
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.mo55166a(null);
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.stop();
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.release();
            }
            this.llA = null;
        }
        if (C5046bo.isNullOrNil(this.path) || this.aOO == null) {
            C4990ab.m7421w(this.TAG, "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(2920);
            return;
        }
        try {
            this.f17197VN = false;
            this.llA = new C34602i(Looper.getMainLooper());
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.setPath(this.path);
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.setNeedResetExtractor(this.llI);
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.setIsOnlineVideoType(this.llJ);
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.mo55166a(this.llO);
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.setSurface(this.aOO);
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.mo55172iU(this.llK);
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.setMute(true);
            }
            if (this.aOO != null) {
                c34602i = this.llA;
                if (c34602i != null) {
                    c34602i.prepare();
                    AppMethodBeat.m2505o(2920);
                    return;
                }
                AppMethodBeat.m2505o(2920);
                return;
            }
            if (this.llD) {
                c34602i = this.llA;
                if (c34602i != null) {
                    c34602i.prepare();
                    AppMethodBeat.m2505o(2920);
                    return;
                }
            }
            AppMethodBeat.m2505o(2920);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "prepare async error %s", e.getMessage());
            C14981a c14981a = this.llE;
            if (c14981a != null) {
                c14981a.onError(-1, -1);
                AppMethodBeat.m2505o(2920);
                return;
            }
            AppMethodBeat.m2505o(2920);
        }
    }

    public final boolean start() {
        AppMethodBeat.m2504i(2921);
        String str;
        String str2;
        Object[] objArr;
        if (this.llA == null || !this.f17197VN) {
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
            objArr[2] = Boolean.valueOf(this.f17197VN);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(2921);
            return false;
        }
        str = this.TAG;
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.llM);
        objArr[2] = Boolean.valueOf(this.llL);
        objArr[3] = Boolean.valueOf(this.aOO != null);
        C4990ab.m7417i(str, str2, objArr);
        if (this.aOO == null) {
            this.llL = true;
            AppMethodBeat.m2505o(2921);
            return true;
        } else if (this.llM) {
            this.llL = true;
            this.llM = false;
            AppMethodBeat.m2505o(2921);
            return true;
        } else {
            C34602i c34602i = this.llA;
            if (c34602i != null) {
                c34602i.start();
            }
            C27809b c27809b = this.llz;
            if (c27809b != null) {
                c27809b.mo45655gG(false);
            }
            AppMethodBeat.m2505o(2921);
            return true;
        }
    }

    public final void stop() {
        AppMethodBeat.m2504i(2922);
        C4990ab.m7417i(this.TAG, "%d player stop [%s]", Integer.valueOf(hashCode()), C5046bo.dpG());
        C34602i c34602i = this.llA;
        if (c34602i != null) {
            c34602i.mo55166a(null);
        }
        c34602i = this.llA;
        if (c34602i != null) {
            c34602i.stop();
        }
        c34602i = this.llA;
        if (c34602i != null) {
            c34602i.release();
        }
        this.llA = null;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.f17197VN = false;
        this.path = "";
        this.llC = 0;
        AppMethodBeat.m2505o(2922);
    }

    public final void pause() {
        AppMethodBeat.m2504i(2923);
        if (this.llA != null) {
            C34602i c34602i = this.llA;
            if (c34602i == null) {
                C25052j.dWJ();
            }
            if (c34602i.isPlaying()) {
                c34602i = this.llA;
                if (c34602i != null) {
                    c34602i.pause();
                }
                C27809b c27809b = this.llz;
                if (c27809b != null) {
                    c27809b.mo45655gG(true);
                }
            }
        }
        this.llL = false;
        AppMethodBeat.m2505o(2923);
    }

    public final int getDuration() {
        AppMethodBeat.m2504i(2924);
        if (this.llA != null) {
            C34602i c34602i = this.llA;
            if (c34602i == null) {
                C25052j.dWJ();
            }
            int bPa = (int) c34602i.bPa();
            AppMethodBeat.m2505o(2924);
            return bPa;
        }
        AppMethodBeat.m2505o(2924);
        return 0;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(2925);
        C4990ab.m7416i(this.TAG, "onSurfaceTextureSizeChanged " + i + ", " + i2);
        C38919i c38919i = this.llt;
        if (c38919i != null) {
            c38919i.mo61808dY(i, i2);
            AppMethodBeat.m2505o(2925);
            return;
        }
        AppMethodBeat.m2505o(2925);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(2926);
        if (this.llM && this.llC > 0) {
            C34602i c34602i = this.llA;
            if (c34602i != null) {
                c34602i.pause();
            }
            c34602i = this.llA;
            if (c34602i != null) {
                c34602i.setMute(this.eif);
            }
            this.llM = false;
        }
        if (this.llC > 0 && this.llF != null) {
            C4990ab.m7417i(this.TAG, "%d notify surface update", Integer.valueOf(hashCode()));
            C31214a c31214a = this.llF;
            if (c31214a != null) {
                c31214a.invoke();
            }
            this.llF = null;
        }
        this.llC = System.currentTimeMillis();
        AppMethodBeat.m2505o(2926);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(2927);
        C4990ab.m7416i(this.TAG, "onSurfaceTextureDestroyed");
        C27809b c27809b = this.llz;
        if (c27809b != null) {
            c27809b.mo45654gF(false);
        }
        C27809b c27809b2 = this.llz;
        if (c27809b2 != null) {
            c27809b2.mo45653b(new C27810a(c27809b2));
        }
        this.aOO = null;
        this.llL = false;
        this.llM = false;
        if (this.llA == null) {
            this.llL = false;
        } else if (isPlaying()) {
            this.llL = true;
            C34602i c34602i = this.llA;
            if (c34602i != null) {
                c34602i.pause();
            }
        }
        AppMethodBeat.m2505o(2927);
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(2928);
        dAh();
        C4990ab.m7416i(this.TAG, "onSurfaceTextureAvailable, " + i + ", " + i2 + ", " + surfaceTexture);
        if (surfaceTexture != null) {
            try {
                C38919i c38919i = new C38919i(this.llN);
                C38919i c38919i2 = this.llt;
                if (c38919i2 != null) {
                    c38919i2.release();
                }
                this.llt = c38919i;
                if (this.llL) {
                    setVisibility(4);
                    c38919i2 = this.llt;
                    if (c38919i2 != null) {
                        c38919i2.ljd = this.liA;
                    }
                    C38919i c38919i3 = this.llt;
                    if (c38919i3 != null) {
                        c38919i3.lqm = new C42978a(this);
                    }
                }
                this.llz = new C27809b(surfaceTexture, c38919i, new C42977b(this, i, i2, c38919i));
                AppMethodBeat.m2505o(2928);
                return;
            } catch (Exception e) {
                C4990ab.m7416i(this.TAG, "onSurfaceTextureAvailable error: ".concat(String.valueOf(e)));
            }
        }
        AppMethodBeat.m2505o(2928);
    }
}
