package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.a.t;
import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020#H\u0016J.\u0010$\u001a\u00020#2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*J\u0006\u0010+\u001a\u00020#J\u000e\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\nJ\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020*2\u0006\u0010)\u001a\u00020/H\u0002J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resumeScroll", "setShow", "isShow", "spanForQuery", "", "source", "startScroll", "stopScroll", "plugin-story_release"})
@SuppressLint({"AppCompatCustomView"})
public final class MusicLrcView extends TextView {
    private Scroller mScroller;
    boolean shY;
    private v sia;
    private int snd;
    int sne;
    boolean snf;
    private int sng;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-story_release"})
    public static final class a implements com.google.android.exoplayer2.q.a {
        final /* synthetic */ MusicLrcView snh;

        a(MusicLrcView musicLrcView) {
            this.snh = musicLrcView;
        }

        public final void a(p pVar) {
        }

        public final void a(e eVar) {
        }

        public final void aH(boolean z) {
        }

        public final void qe() {
        }

        public final void c(boolean z, int i) {
            Long l = null;
            AppMethodBeat.i(110677);
            if (i == 3) {
                MusicLrcView musicLrcView = this.snh;
                if (musicLrcView.shY) {
                    musicLrcView.sne = musicLrcView.getWidth();
                    musicLrcView.snf = true;
                    musicLrcView.cCC();
                }
                v player = this.snh.getPlayer();
                Long valueOf = player != null ? Long.valueOf(player.getDuration()) : null;
                if (valueOf == null) {
                    j.dWJ();
                }
                if (valueOf.longValue() < ((long) this.snh.getRndDuration())) {
                    musicLrcView = this.snh;
                    v player2 = this.snh.getPlayer();
                    if (player2 != null) {
                        l = Long.valueOf(player2.getDuration());
                    }
                    if (l == null) {
                        j.dWJ();
                    }
                    musicLrcView.setRndDuration((int) l.longValue());
                }
            }
            AppMethodBeat.o(110677);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ MusicLrcView snh;
        final /* synthetic */ int sni;
        final /* synthetic */ int snj;

        b(MusicLrcView musicLrcView, int i, int i2) {
            this.snh = musicLrcView;
            this.sni = i;
            this.snj = i2;
        }

        public final void run() {
            AppMethodBeat.i(110678);
            Scroller a = this.snh.mScroller;
            if (a == null) {
                j.dWJ();
            }
            a.startScroll(this.snh.sne, 0, this.sni, 0, this.snj);
            this.snh.invalidate();
            AppMethodBeat.o(110678);
        }
    }

    public MusicLrcView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    public MusicLrcView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110686);
        this.snd = Downloads.MIN_WAIT_FOR_NETWORK;
        this.sne = -getWidth();
        this.snf = true;
        AppMethodBeat.o(110686);
    }

    public final v getPlayer() {
        return this.sia;
    }

    public final void setPlayer(v vVar) {
        AppMethodBeat.i(110679);
        if (vVar != null) {
            this.sia = vVar;
            v vVar2 = this.sia;
            if (vVar2 != null) {
                vVar2.a((com.google.android.exoplayer2.q.a) new a(this));
                AppMethodBeat.o(110679);
                return;
            }
        }
        AppMethodBeat.o(110679);
    }

    public final void setRunningShow(boolean z) {
        this.shY = z;
    }

    public final int getRndDuration() {
        return this.snd;
    }

    public final void setRndDuration(int i) {
        this.snd = i;
    }

    public final int getScrollFirstDelay() {
        return this.sng;
    }

    public final void setScrollFirstDelay(int i) {
        this.sng = i;
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(110680);
        this.shY = z;
        if (!(this.shY || this.mScroller == null)) {
            Scroller scroller = this.mScroller;
            if (scroller == null) {
                j.dWJ();
            }
            scroller.startScroll(0, 0, 0, 0, 0);
        }
        AppMethodBeat.o(110680);
    }

    public final void cCC() {
        AppMethodBeat.i(110681);
        if (this.shY) {
            int width;
            this.sne = -getWidth();
            setHorizontallyScrolling(true);
            if (this.mScroller == null) {
                this.mScroller = new Scroller(getContext(), new LinearInterpolator());
                setScroller(this.mScroller);
            }
            TextPaint paint = getPaint();
            Rect rect = new Rect();
            String obj = getText().toString();
            paint.getTextBounds(obj, 0, obj.length(), rect);
            if (rect.width() > 0) {
                width = rect.width();
            } else {
                width = getWidth();
            }
            int i = width - ((this.sne * 3) / 4);
            if (i != 0) {
                int i2 = (this.snd * i) / width;
                if (this.snf) {
                    postDelayed(new b(this, i, i2), (long) this.sng);
                    AppMethodBeat.o(110681);
                    return;
                }
                Scroller scroller = this.mScroller;
                if (scroller == null) {
                    j.dWJ();
                }
                scroller.startScroll(this.sne, 0, i, 0, i2);
                invalidate();
            }
            AppMethodBeat.o(110681);
            return;
        }
        AppMethodBeat.o(110681);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(ArrayList<d> arrayList, String str) {
        AppMethodBeat.i(110682);
        if (arrayList != null) {
            boolean z;
            if (arrayList.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                CharSequence a;
                MusicLrcView musicLrcView;
                StringBuilder stringBuilder = new StringBuilder();
                for (d dVar : arrayList) {
                    stringBuilder.append(dVar.snb).append("  ");
                }
                if (str != null) {
                    if (((CharSequence) str).length() > 0) {
                        String stringBuilder2 = stringBuilder.toString();
                        j.o(stringBuilder2, "sb.toString()");
                        if (a.k.v.a((CharSequence) stringBuilder2, (CharSequence) str, false)) {
                            stringBuilder2 = stringBuilder.toString();
                            j.o(stringBuilder2, "sb.toString()");
                            a = a(stringBuilder2, (CharSequence) str);
                            musicLrcView = this;
                            musicLrcView.setText(a);
                            this.snd = ((d) t.fL(arrayList)).snc - ((d) t.fJ(arrayList)).startTime;
                            if (this.snd == 0) {
                                this.snd = Downloads.MIN_WAIT_FOR_NETWORK;
                            }
                        }
                    }
                }
                musicLrcView = this;
                a = stringBuilder.toString();
                musicLrcView.setText(a);
                this.snd = ((d) t.fL(arrayList)).snc - ((d) t.fJ(arrayList)).startTime;
                if (this.snd == 0) {
                }
            }
        }
        AppMethodBeat.o(110682);
    }

    private final CharSequence a(String str, CharSequence charSequence) {
        AppMethodBeat.i(110684);
        SpannableString spannableString = new SpannableString(str);
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2;
            int a = a.k.v.a((CharSequence) str, charSequence.toString(), i, false);
            if (a != -1) {
                i += a + length;
                if (isSelected()) {
                    i2 = WebView.NIGHT_MODE_COLOR;
                } else {
                    i2 = -1;
                }
                spannableString.setSpan(new ForegroundColorSpan(i2), a, a + length, 33);
            }
            i2 = i;
            if (a == -1) {
                CharSequence charSequence2 = spannableString;
                AppMethodBeat.o(110684);
                return charSequence2;
            }
            i = i2;
        }
    }

    public final void computeScroll() {
        AppMethodBeat.i(110685);
        super.computeScroll();
        if (this.mScroller == null) {
            AppMethodBeat.o(110685);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null) {
            j.dWJ();
        }
        if (scroller.isFinished()) {
            this.sne = -getWidth();
            this.snf = false;
            cCC();
        }
        AppMethodBeat.o(110685);
    }
}
