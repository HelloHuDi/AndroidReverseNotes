package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.exoplayer2.C0884v;
import com.google.android.exoplayer2.C45036g;
import com.google.android.exoplayer2.p109g.C32051a.C25537a;
import com.google.android.exoplayer2.p109g.C45034c;
import com.google.android.exoplayer2.p110h.C37261k;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.source.C25558d;
import com.google.android.exoplayer2.source.C45052i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.media.p253f.C1778c;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.C46277g;
import com.tencent.p177mm.plugin.story.model.audio.C46277g.C4125a;
import com.tencent.p177mm.plugin.story.model.p1036e.C13775a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a.C29281a;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u001cR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "useFakeImage", "videoPlaying", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "stopFakeLayer", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.o */
public final class C35263o extends RelativeLayout {
    private final String TAG = "MicroMsg.StoryVideoViewFakeLayer";
    private long eDL;
    private C0884v rYo;
    private cee sqN;
    private AudioCacheInfo sqO;
    boolean sqP;
    private ImageView sqQ;
    private C13775a sqR;
    private boolean sqS;
    private boolean sqT;
    private long startTime;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer$requestLoopFakeFrame$2$1"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.o$a */
    static final class C35264a implements Runnable {
        final /* synthetic */ C35263o sqU;
        final /* synthetic */ C13775a sqV;

        C35264a(C35263o c35263o, C13775a c13775a) {
            this.sqU = c35263o;
            this.sqV = c13775a;
        }

        public final void run() {
            AppMethodBeat.m2504i(110953);
            C35263o.m57935a(this.sqU, this.sqV);
            AppMethodBeat.m2505o(110953);
        }
    }

    public C35263o(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(110960);
        AppMethodBeat.m2505o(110960);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m57935a(C35263o c35263o, C13775a c13775a) {
        AppMethodBeat.m2504i(110961);
        c35263o.m57934a(c13775a);
        AppMethodBeat.m2505o(110961);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setFakeVideoInfo(cee cee) {
        ImageView imageView;
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.m2504i(110954);
        C25052j.m39376p(cee, "fakeVideoInfo");
        C4990ab.m7416i(this.TAG, "LogStory: setFakeVideoInfo " + cee.timeStamp);
        this.sqN = cee;
        if (this.sqQ == null) {
            imageView = new ImageView(getContext());
            imageView.setScaleType(ScaleType.CENTER_CROP);
            this.sqQ = imageView;
        }
        removeAllViews();
        cee cee2 = this.sqN;
        if (cee2 != null) {
            String str = cee2.videoPath;
            if (str != null) {
                C29283a c29283a = C29282c.rRS;
                C29281a aaj = C29283a.aaj(str);
                z = aaj != null ? aaj.rRT : false;
                z2 = cee.fbV && !z;
                this.sqT = z2;
                C4990ab.m7416i(this.TAG, "useFakeImage:" + this.sqT + ", isCaptureVideo:" + cee.fbV + ", matchScreenRatio:" + z);
                if (this.sqT) {
                    C22210l c22210l = C22210l.sac;
                    Context context = getContext();
                    C25052j.m39375o(context, "context");
                    C22210l.m33874a(cee, context, this);
                    imageView = this.sqQ;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                } else {
                    addView(this.sqQ, new LayoutParams(-1, -1));
                    imageView = this.sqQ;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                }
                if (cee.eYi == null) {
                    AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
                    audioCacheInfo.rTW = cee.rTW;
                    audioCacheInfo.aIM = cee.aIM;
                    audioCacheInfo.cachePath = cee.eYi;
                    audioCacheInfo.musicUrl = cee.musicUrl;
                    this.sqO = audioCacheInfo;
                } else {
                    this.sqO = null;
                }
                if (!(cee.eTb == 0 || cee.eTb == 2)) {
                    z3 = false;
                }
                this.sqP = z3;
                this.startTime = cee.startTime;
                this.eDL = cee.endTime;
                this.sqS = false;
                AppMethodBeat.m2505o(110954);
            }
        }
        z = false;
        if (cee.fbV) {
        }
        this.sqT = z2;
        C4990ab.m7416i(this.TAG, "useFakeImage:" + this.sqT + ", isCaptureVideo:" + cee.fbV + ", matchScreenRatio:" + z);
        if (this.sqT) {
        }
        if (cee.eYi == null) {
        }
        z3 = false;
        this.sqP = z3;
        this.startTime = cee.startTime;
        this.eDL = cee.endTime;
        this.sqS = false;
        AppMethodBeat.m2505o(110954);
    }

    /* renamed from: a */
    private final void m57934a(C13775a c13775a) {
        AppMethodBeat.m2504i(110955);
        if (!this.sqS) {
            C4990ab.m7416i(this.TAG, "requestLoopFakeFrame stop");
            AppMethodBeat.m2505o(110955);
        } else if ((C25052j.m39373j(c13775a, this.sqR) ^ 1) != 0) {
            C4990ab.m7416i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
            AppMethodBeat.m2505o(110955);
        } else {
            cee cee = this.sqN;
            if ((cee == null || !cee.fbV) && this.sqT) {
                C1778c UX = c13775a.mo5327UX();
                ImageView imageView = this.sqQ;
                if (imageView != null) {
                    Bitmap bitmap;
                    if (UX != null) {
                        bitmap = UX.bitmap;
                    } else {
                        bitmap = null;
                    }
                    imageView.setImageBitmap(bitmap);
                }
                ImageView imageView2 = this.sqQ;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                if (UX != null) {
                    Long valueOf = Long.valueOf(UX.eWH);
                    long longValue = valueOf.longValue();
                    int i = (1 <= longValue && 1000 >= longValue && this.sqS && C25052j.m39373j(c13775a, this.sqR)) ? 1 : 0;
                    Long l = i != 0 ? valueOf : null;
                    if (l != null) {
                        long longValue2 = l.longValue();
                        ImageView imageView3 = this.sqQ;
                        if (imageView3 != null) {
                            imageView3.postDelayed(new C35264a(this, c13775a), longValue2);
                            AppMethodBeat.m2505o(110955);
                            return;
                        }
                        AppMethodBeat.m2505o(110955);
                        return;
                    }
                }
                AppMethodBeat.m2505o(110955);
                return;
            }
            C4990ab.m7416i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
            AppMethodBeat.m2505o(110955);
        }
    }

    /* renamed from: lW */
    public final void mo55978lW(boolean z) {
        AppMethodBeat.m2504i(110956);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("LogStory: playFakeLayer ");
        cee cee = this.sqN;
        C4990ab.m7416i(str, stringBuilder.append(cee != null ? Long.valueOf(cee.timeStamp) : null).toString());
        C0884v c0884v = this.rYo;
        if (c0884v != null) {
            c0884v.stop();
        }
        c0884v = this.rYo;
        if (c0884v != null) {
            c0884v.release();
        }
        if (!(this.sqO == null || z)) {
            playAudio();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof MMAnimateView) {
                ((MMAnimateView) childAt).resume();
            }
        }
        if (this.sqT) {
            cee = this.sqN;
            if (cee != null) {
                C13775a c13775a = this.sqR;
                if (c13775a != null) {
                    c13775a.destroy();
                }
                ImageView imageView = this.sqQ;
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
                C22210l c22210l = C22210l.sac;
                Context context = getContext();
                C25052j.m39375o(context, "context");
                this.sqR = C22210l.m33879b(cee, context);
                C13775a c13775a2 = this.sqR;
                if (c13775a2 != null) {
                    c13775a2.start();
                    this.sqS = true;
                    m57934a(c13775a2);
                    AppMethodBeat.m2505o(110956);
                    return;
                }
                AppMethodBeat.m2505o(110956);
                return;
            }
        }
        AppMethodBeat.m2505o(110956);
    }

    public final void cDc() {
        Object valueOf;
        AppMethodBeat.m2504i(110957);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
        cee cee = this.sqN;
        if (cee != null) {
            valueOf = Long.valueOf(cee.timeStamp);
        } else {
            valueOf = null;
        }
        C4990ab.m7416i(str, stringBuilder.append(valueOf).toString());
        C0884v c0884v = this.rYo;
        if (c0884v != null) {
            c0884v.mo2618aE(false);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof MMAnimateView) {
                ((MMAnimateView) childAt).pause();
            }
        }
        this.sqS = false;
        ImageView imageView = this.sqQ;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        imageView = this.sqQ;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        C13775a c13775a = this.sqR;
        if (c13775a != null) {
            c13775a.destroy();
        }
        this.sqR = null;
        AppMethodBeat.m2505o(110957);
    }

    public final void cDd() {
        Object valueOf;
        AppMethodBeat.m2504i(110958);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
        cee cee = this.sqN;
        if (cee != null) {
            valueOf = Long.valueOf(cee.timeStamp);
        } else {
            valueOf = null;
        }
        C4990ab.m7416i(str, stringBuilder.append(valueOf).toString());
        C0884v c0884v = this.rYo;
        if (c0884v != null) {
            c0884v.stop();
        }
        c0884v = this.rYo;
        if (c0884v != null) {
            c0884v.release();
        }
        this.rYo = null;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof MMAnimateView) {
                ((MMAnimateView) childAt).stop();
            }
        }
        this.sqS = false;
        ImageView imageView = this.sqQ;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        imageView = this.sqQ;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        C13775a c13775a = this.sqR;
        if (c13775a != null) {
            c13775a.destroy();
        }
        this.sqR = null;
        AppMethodBeat.m2505o(110958);
    }

    private final void playAudio() {
        AppMethodBeat.m2504i(110959);
        C45034c c45034c = new C45034c(new C25537a(new C37261k()));
        String i = C17675v.m27573i(getContext(), getContext().getString(C25738R.string.f9176ru));
        this.rYo = C45036g.m82561a(getContext(), c45034c);
        try {
            C4125a c4125a = C46277g.rUG;
            AudioCacheInfo audioCacheInfo = this.sqO;
            if (audioCacheInfo == null) {
                C25052j.dWJ();
            }
            C25052j.m39375o(i, "userAgent");
            C25558d c25558d = new C25558d(C4125a.m6450a(audioCacheInfo, i), this.startTime, this.eDL * 1000);
            C0884v c0884v = this.rYo;
            if (c0884v != null) {
                c0884v.mo2618aE(true);
            }
            c0884v = this.rYo;
            if (c0884v != null) {
                c0884v.mo2616a((C45052i) c25558d);
            }
            C0884v c0884v2 = this.rYo;
            if (c0884v2 != null) {
                c0884v2.setRepeatMode(2);
                AppMethodBeat.m2505o(110959);
                return;
            }
            AppMethodBeat.m2505o(110959);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(110959);
        }
    }
}
