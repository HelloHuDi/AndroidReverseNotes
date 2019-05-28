package com.tencent.p177mm.plugin.radar.p489ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioPlayer", "Landroid/media/MediaPlayer;", "rotateAnim", "Landroid/view/animation/Animation;", "rotateWaveIV", "Landroid/view/View;", "init", "", "release", "startWaves", "stopWaves", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarWaveView */
public final class RadarWaveView extends RelativeLayout {
    static final String TAG = TAG;
    public static final C3682a pEC = new C3682a();
    View pEA;
    Animation pEB;
    MediaPlayer pEz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarWaveView$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarWaveView$a */
    public static final class C3682a {
        private C3682a() {
        }

        public /* synthetic */ C3682a(byte b) {
            this();
        }
    }

    public RadarWaveView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(103136);
        AppMethodBeat.m2505o(103136);
    }

    public final void cdU() {
        AppMethodBeat.m2504i(103134);
        C4990ab.m7410d(TAG, "start wave animation");
        setVisibility(0);
        View view = this.pEA;
        if (view == null) {
            C25052j.dWJ();
        }
        view.startAnimation(this.pEB);
        AppMethodBeat.m2505o(103134);
    }

    public final void cdV() {
        AppMethodBeat.m2504i(103135);
        C4990ab.m7411d(TAG, "stop wave animation. forces, %d, %d", Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()));
        setVisibility(4);
        View view = this.pEA;
        if (view == null) {
            C25052j.dWJ();
        }
        view.clearAnimation();
        AppMethodBeat.m2505o(103135);
    }

    static {
        AppMethodBeat.m2504i(103137);
        AppMethodBeat.m2505o(103137);
    }
}
