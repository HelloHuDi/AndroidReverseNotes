package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.story.e.c;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u001cR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "useFakeImage", "videoPlaying", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "stopFakeLayer", "plugin-story_release"})
public final class o extends RelativeLayout {
    private final String TAG = "MicroMsg.StoryVideoViewFakeLayer";
    private long eDL;
    private v rYo;
    private cee sqN;
    private AudioCacheInfo sqO;
    boolean sqP;
    private ImageView sqQ;
    private com.tencent.mm.plugin.story.model.e.a sqR;
    private boolean sqS;
    private boolean sqT;
    private long startTime;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer$requestLoopFakeFrame$2$1"})
    static final class a implements Runnable {
        final /* synthetic */ o sqU;
        final /* synthetic */ com.tencent.mm.plugin.story.model.e.a sqV;

        a(o oVar, com.tencent.mm.plugin.story.model.e.a aVar) {
            this.sqU = oVar;
            this.sqV = aVar;
        }

        public final void run() {
            AppMethodBeat.i(110953);
            o.a(this.sqU, this.sqV);
            AppMethodBeat.o(110953);
        }
    }

    public o(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(110960);
        AppMethodBeat.o(110960);
    }

    public static final /* synthetic */ void a(o oVar, com.tencent.mm.plugin.story.model.e.a aVar) {
        AppMethodBeat.i(110961);
        oVar.a(aVar);
        AppMethodBeat.o(110961);
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
        AppMethodBeat.i(110954);
        j.p(cee, "fakeVideoInfo");
        ab.i(this.TAG, "LogStory: setFakeVideoInfo " + cee.timeStamp);
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
                com.tencent.mm.plugin.story.e.c.a aVar = c.rRS;
                com.tencent.mm.plugin.story.e.c.a.a aaj = com.tencent.mm.plugin.story.e.c.a.aaj(str);
                z = aaj != null ? aaj.rRT : false;
                z2 = cee.fbV && !z;
                this.sqT = z2;
                ab.i(this.TAG, "useFakeImage:" + this.sqT + ", isCaptureVideo:" + cee.fbV + ", matchScreenRatio:" + z);
                if (this.sqT) {
                    com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
                    Context context = getContext();
                    j.o(context, "context");
                    com.tencent.mm.plugin.story.f.l.a(cee, context, this);
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
                AppMethodBeat.o(110954);
            }
        }
        z = false;
        if (cee.fbV) {
        }
        this.sqT = z2;
        ab.i(this.TAG, "useFakeImage:" + this.sqT + ", isCaptureVideo:" + cee.fbV + ", matchScreenRatio:" + z);
        if (this.sqT) {
        }
        if (cee.eYi == null) {
        }
        z3 = false;
        this.sqP = z3;
        this.startTime = cee.startTime;
        this.eDL = cee.endTime;
        this.sqS = false;
        AppMethodBeat.o(110954);
    }

    private final void a(com.tencent.mm.plugin.story.model.e.a aVar) {
        AppMethodBeat.i(110955);
        if (!this.sqS) {
            ab.i(this.TAG, "requestLoopFakeFrame stop");
            AppMethodBeat.o(110955);
        } else if ((j.j(aVar, this.sqR) ^ 1) != 0) {
            ab.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
            AppMethodBeat.o(110955);
        } else {
            cee cee = this.sqN;
            if ((cee == null || !cee.fbV) && this.sqT) {
                com.tencent.mm.media.f.c UX = aVar.UX();
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
                    int i = (1 <= longValue && 1000 >= longValue && this.sqS && j.j(aVar, this.sqR)) ? 1 : 0;
                    Long l = i != 0 ? valueOf : null;
                    if (l != null) {
                        long longValue2 = l.longValue();
                        ImageView imageView3 = this.sqQ;
                        if (imageView3 != null) {
                            imageView3.postDelayed(new a(this, aVar), longValue2);
                            AppMethodBeat.o(110955);
                            return;
                        }
                        AppMethodBeat.o(110955);
                        return;
                    }
                }
                AppMethodBeat.o(110955);
                return;
            }
            ab.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
            AppMethodBeat.o(110955);
        }
    }

    public final void lW(boolean z) {
        AppMethodBeat.i(110956);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("LogStory: playFakeLayer ");
        cee cee = this.sqN;
        ab.i(str, stringBuilder.append(cee != null ? Long.valueOf(cee.timeStamp) : null).toString());
        v vVar = this.rYo;
        if (vVar != null) {
            vVar.stop();
        }
        vVar = this.rYo;
        if (vVar != null) {
            vVar.release();
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
                com.tencent.mm.plugin.story.model.e.a aVar = this.sqR;
                if (aVar != null) {
                    aVar.destroy();
                }
                ImageView imageView = this.sqQ;
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
                com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
                Context context = getContext();
                j.o(context, "context");
                this.sqR = com.tencent.mm.plugin.story.f.l.b(cee, context);
                com.tencent.mm.plugin.story.model.e.a aVar2 = this.sqR;
                if (aVar2 != null) {
                    aVar2.start();
                    this.sqS = true;
                    a(aVar2);
                    AppMethodBeat.o(110956);
                    return;
                }
                AppMethodBeat.o(110956);
                return;
            }
        }
        AppMethodBeat.o(110956);
    }

    public final void cDc() {
        Object valueOf;
        AppMethodBeat.i(110957);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
        cee cee = this.sqN;
        if (cee != null) {
            valueOf = Long.valueOf(cee.timeStamp);
        } else {
            valueOf = null;
        }
        ab.i(str, stringBuilder.append(valueOf).toString());
        v vVar = this.rYo;
        if (vVar != null) {
            vVar.aE(false);
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
        com.tencent.mm.plugin.story.model.e.a aVar = this.sqR;
        if (aVar != null) {
            aVar.destroy();
        }
        this.sqR = null;
        AppMethodBeat.o(110957);
    }

    public final void cDd() {
        Object valueOf;
        AppMethodBeat.i(110958);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
        cee cee = this.sqN;
        if (cee != null) {
            valueOf = Long.valueOf(cee.timeStamp);
        } else {
            valueOf = null;
        }
        ab.i(str, stringBuilder.append(valueOf).toString());
        v vVar = this.rYo;
        if (vVar != null) {
            vVar.stop();
        }
        vVar = this.rYo;
        if (vVar != null) {
            vVar.release();
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
        com.tencent.mm.plugin.story.model.e.a aVar = this.sqR;
        if (aVar != null) {
            aVar.destroy();
        }
        this.sqR = null;
        AppMethodBeat.o(110958);
    }

    private final void playAudio() {
        AppMethodBeat.i(110959);
        com.google.android.exoplayer2.g.c cVar = new com.google.android.exoplayer2.g.c(new com.google.android.exoplayer2.g.a.a(new k()));
        String i = com.google.android.exoplayer2.i.v.i(getContext(), getContext().getString(R.string.ru));
        this.rYo = g.a(getContext(), cVar);
        try {
            com.tencent.mm.plugin.story.model.audio.g.a aVar = com.tencent.mm.plugin.story.model.audio.g.rUG;
            AudioCacheInfo audioCacheInfo = this.sqO;
            if (audioCacheInfo == null) {
                j.dWJ();
            }
            j.o(i, "userAgent");
            d dVar = new d(com.tencent.mm.plugin.story.model.audio.g.a.a(audioCacheInfo, i), this.startTime, this.eDL * 1000);
            v vVar = this.rYo;
            if (vVar != null) {
                vVar.aE(true);
            }
            vVar = this.rYo;
            if (vVar != null) {
                vVar.a((i) dVar);
            }
            v vVar2 = this.rYo;
            if (vVar2 != null) {
                vVar2.setRepeatMode(2);
                AppMethodBeat.o(110959);
                return;
            }
            AppMethodBeat.o(110959);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            AppMethodBeat.o(110959);
        }
    }
}
