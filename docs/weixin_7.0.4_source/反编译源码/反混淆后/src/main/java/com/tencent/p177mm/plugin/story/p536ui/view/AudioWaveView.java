package com.tencent.p177mm.plugin.story.p536ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.C0884v;
import com.google.android.exoplayer2.C25533e;
import com.google.android.exoplayer2.C32067q.C32068a;
import com.google.android.exoplayer2.C45045p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020-J\b\u0010?\u001a\u000208H\u0002J\u0010\u0010@\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0015J(\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0014J\u000e\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020\tJ\u000e\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\fR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R(\u00102\u001a\u0004\u0018\u0001012\b\u00100\u001a\u0004\u0018\u000101@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006J"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWidth", "getMWidth", "setMWidth", "offset", "", "getOffset", "()F", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.AudioWaveView */
public final class AudioWaveView extends View {
    private int mWidth;
    private final float offset = C42677e.m75583cZ(getContext());
    private int shT;
    private int shU;
    private Paint shV;
    private int shW;
    private double shX;
    private boolean shY;
    private boolean shZ = true;
    private C0884v sia;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, dWq = {"com/tencent/mm/plugin/story/ui/view/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.AudioWaveView$a */
    public static final class C13847a implements C32068a {
        final /* synthetic */ AudioWaveView sib;

        C13847a(AudioWaveView audioWaveView) {
            this.sib = audioWaveView;
        }

        /* renamed from: a */
        public final void mo26015a(C45045p c45045p) {
        }

        /* renamed from: a */
        public final void mo26014a(C25533e c25533e) {
        }

        /* renamed from: aH */
        public final void mo26016aH(boolean z) {
        }

        /* renamed from: qe */
        public final void mo26018qe() {
        }

        /* renamed from: c */
        public final void mo26017c(boolean z, int i) {
            AppMethodBeat.m2504i(110285);
            if (i == 3) {
                this.sib.setPlayerLoading(false);
            }
            AppMethodBeat.m2505o(110285);
        }
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(int i) {
        this.mWidth = i;
    }

    public final int getMRectWidth() {
        return this.shT;
    }

    public final void setMRectWidth(int i) {
        this.shT = i;
    }

    public final int getMRectHeight() {
        return this.shU;
    }

    public final void setMRectHeight(int i) {
        this.shU = i;
    }

    public final Paint getMWavePaint() {
        return this.shV;
    }

    public final void setMWavePaint(Paint paint) {
        this.shV = paint;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final int getMRectCount() {
        return this.shW;
    }

    public final void setMRectCount(int i) {
        this.shW = i;
    }

    public final double getMRandom() {
        return this.shX;
    }

    public final void setMRandom(double d) {
        this.shX = d;
    }

    public final void setRunningShow(boolean z) {
        this.shY = z;
    }

    public final void setPlayerLoading(boolean z) {
        this.shZ = z;
    }

    public final C0884v getPlayer() {
        return this.sia;
    }

    public final void setPlayer(C0884v c0884v) {
        AppMethodBeat.m2504i(110286);
        if (c0884v != null) {
            this.sia = c0884v;
            C0884v c0884v2 = this.sia;
            if (c0884v2 != null) {
                c0884v2.mo2615a((C32068a) new C13847a(this));
                AppMethodBeat.m2505o(110286);
                return;
            }
        }
        AppMethodBeat.m2505o(110286);
    }

    public AudioWaveView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(110292);
        initView();
        AppMethodBeat.m2505o(110292);
    }

    public AudioWaveView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110293);
        initView();
        AppMethodBeat.m2505o(110293);
    }

    private final void initView() {
        AppMethodBeat.m2504i(110287);
        this.shW = 20;
        this.shV = new Paint();
        Paint paint = this.shV;
        if (paint == null) {
            C25052j.dWJ();
        }
        paint.setStyle(Style.FILL);
        paint = this.shV;
        if (paint == null) {
            C25052j.dWJ();
        }
        paint.setColor(-3355444);
        paint = this.shV;
        if (paint == null) {
            C25052j.dWJ();
        }
        paint.setAntiAlias(true);
        AppMethodBeat.m2505o(110287);
    }

    public final void setColor(int i) {
        AppMethodBeat.m2504i(110288);
        Paint paint = this.shV;
        if (paint == null) {
            C25052j.dWJ();
        }
        paint.setColor(i);
        AppMethodBeat.m2505o(110288);
    }

    public final void setShow(boolean z) {
        this.shY = z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(110289);
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = getWidth();
        this.shU = getHeight() / 2;
        this.shT = this.mWidth / (this.shW * 2);
        AppMethodBeat.m2505o(110289);
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(110290);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        super.onDraw(canvas);
        canvas.translate((float) (getWidth() / 2), (float) getHeight());
        int i = this.shW;
        for (int i2 = 0; i2 < i; i2++) {
            if (!this.shY || this.shZ) {
                m57858a(canvas, new RectF((float) (((double) (this.shT * i2)) + ((double) this.offset)), 0.0f, (float) (this.shT * (i2 + 1)), -0.5f));
            } else {
                this.shX = Math.random();
                m57858a(canvas, new RectF((float) (((double) (this.shT * i2)) + ((double) this.offset)), 0.0f, (float) (this.shT * (i2 + 1)), -((float) (((double) this.shU) * this.shX))));
            }
        }
        postInvalidateDelayed(100);
        AppMethodBeat.m2505o(110290);
    }

    /* renamed from: a */
    private void m57858a(Canvas canvas, RectF rectF) {
        AppMethodBeat.m2504i(110291);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(rectF, "rectF");
        canvas.drawRect(rectF, this.shV);
        AppMethodBeat.m2505o(110291);
    }
}
