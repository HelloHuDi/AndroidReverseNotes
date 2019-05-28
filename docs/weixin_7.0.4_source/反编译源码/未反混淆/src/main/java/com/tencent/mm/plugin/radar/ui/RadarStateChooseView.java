package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u000eR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "hide", "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"})
public final class RadarStateChooseView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(RadarStateChooseView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), v.a(new t(v.aN(RadarStateChooseView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    public static final a pCX = new a();
    boolean pCS;
    private final f pCT = i.g(new c(this));
    private final f pCU = i.g(new b(this));
    boolean pCV = true;
    com.tencent.mm.plugin.radar.b.e.a pCW = com.tencent.mm.plugin.radar.b.e.a.UnSelected;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<Animation> {
        final /* synthetic */ RadarStateChooseView pCZ;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements AnimationListener {
            final /* synthetic */ b pDa;

            a(b bVar) {
                this.pDa = bVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(103017);
                j.p(animation, "animation");
                AppMethodBeat.o(103017);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(103018);
                j.p(animation, "animation");
                this.pDa.pCZ.pCS = false;
                this.pDa.pCZ.setVisibility(8);
                AppMethodBeat.o(103018);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(103019);
                j.p(animation, "animation");
                AppMethodBeat.o(103019);
            }
        }

        b(RadarStateChooseView radarStateChooseView) {
            this.pCZ = radarStateChooseView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103020);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pCZ.getContext(), R.anim.cj);
            loadAnimation.setAnimationListener(new a(this));
            j.o(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            AppMethodBeat.o(103020);
            return loadAnimation;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<Animation> {
        final /* synthetic */ RadarStateChooseView pCZ;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements AnimationListener {
            a() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(103021);
                j.p(animation, "animation");
                AppMethodBeat.o(103021);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(103022);
                j.p(animation, "animation");
                AppMethodBeat.o(103022);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(103023);
                j.p(animation, "animation");
                AppMethodBeat.o(103023);
            }
        }

        c(RadarStateChooseView radarStateChooseView) {
            this.pCZ = radarStateChooseView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103024);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pCZ.getContext(), R.anim.ck);
            loadAnimation.setAnimationListener(new a());
            j.o(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            AppMethodBeat.o(103024);
            return loadAnimation;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* Access modifiers changed, original: final */
    public final Animation getSlideInAnim() {
        AppMethodBeat.i(103027);
        Animation animation = (Animation) this.pCU.getValue();
        AppMethodBeat.o(103027);
        return animation;
    }

    /* Access modifiers changed, original: final */
    public final Animation getSlideOutAnim() {
        AppMethodBeat.i(103026);
        Animation animation = (Animation) this.pCT.getValue();
        AppMethodBeat.o(103026);
        return animation;
    }

    public final com.tencent.mm.plugin.radar.b.e.a getMStatus() {
        return this.pCW;
    }

    public final void setMStatus(com.tencent.mm.plugin.radar.b.e.a aVar) {
        AppMethodBeat.i(103028);
        j.p(aVar, "<set-?>");
        this.pCW = aVar;
        AppMethodBeat.o(103028);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(103030);
        AppMethodBeat.o(103030);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(103031);
        AppMethodBeat.o(103031);
    }

    /* Access modifiers changed, original: final */
    public final void cdK() {
        AppMethodBeat.i(103029);
        switch (e.eQZ[this.pCW.ordinal()]) {
            case 1:
                setVisibility(4);
                AppMethodBeat.o(103029);
                return;
            case 2:
                setBackgroundResource(R.raw.radar_select);
                setVisibility(0);
                AppMethodBeat.o(103029);
                return;
            default:
                setVisibility(4);
                AppMethodBeat.o(103029);
                return;
        }
    }

    static {
        AppMethodBeat.i(103025);
        AppMethodBeat.o(103025);
    }
}
