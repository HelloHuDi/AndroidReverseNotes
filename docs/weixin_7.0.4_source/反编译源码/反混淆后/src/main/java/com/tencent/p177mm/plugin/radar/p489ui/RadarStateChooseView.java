package com.tencent.p177mm.plugin.radar.p489ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C21557a;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u000eR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "hide", "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateChooseView */
public final class RadarStateChooseView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarStateChooseView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarStateChooseView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    public static final C12934a pCX = new C12934a();
    boolean pCS;
    private final C44856f pCT = C17344i.m26854g(new C3679c(this));
    private final C44856f pCU = C17344i.m26854g(new C3677b(this));
    boolean pCV = true;
    C21557a pCW = C21557a.UnSelected;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateChooseView$b */
    static final class C3677b extends C25053k implements C31214a<Animation> {
        final /* synthetic */ RadarStateChooseView pCZ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateChooseView$b$a */
        public static final class C3678a implements AnimationListener {
            final /* synthetic */ C3677b pDa;

            C3678a(C3677b c3677b) {
                this.pDa = c3677b;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(103017);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103017);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(103018);
                C25052j.m39376p(animation, "animation");
                this.pDa.pCZ.pCS = false;
                this.pDa.pCZ.setVisibility(8);
                AppMethodBeat.m2505o(103018);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.m2504i(103019);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103019);
            }
        }

        C3677b(RadarStateChooseView radarStateChooseView) {
            this.pCZ = radarStateChooseView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103020);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pCZ.getContext(), C25738R.anim.f8378cj);
            loadAnimation.setAnimationListener(new C3678a(this));
            C25052j.m39375o(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            AppMethodBeat.m2505o(103020);
            return loadAnimation;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateChooseView$c */
    static final class C3679c extends C25053k implements C31214a<Animation> {
        final /* synthetic */ RadarStateChooseView pCZ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateChooseView$c$a */
        public static final class C3680a implements AnimationListener {
            C3680a() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(103021);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103021);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(103022);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103022);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.m2504i(103023);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103023);
            }
        }

        C3679c(RadarStateChooseView radarStateChooseView) {
            this.pCZ = radarStateChooseView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103024);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pCZ.getContext(), C25738R.anim.f8379ck);
            loadAnimation.setAnimationListener(new C3680a());
            C25052j.m39375o(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            AppMethodBeat.m2505o(103024);
            return loadAnimation;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateChooseView$a */
    public static final class C12934a {
        private C12934a() {
        }

        public /* synthetic */ C12934a(byte b) {
            this();
        }
    }

    /* Access modifiers changed, original: final */
    public final Animation getSlideInAnim() {
        AppMethodBeat.m2504i(103027);
        Animation animation = (Animation) this.pCU.getValue();
        AppMethodBeat.m2505o(103027);
        return animation;
    }

    /* Access modifiers changed, original: final */
    public final Animation getSlideOutAnim() {
        AppMethodBeat.m2504i(103026);
        Animation animation = (Animation) this.pCT.getValue();
        AppMethodBeat.m2505o(103026);
        return animation;
    }

    public final C21557a getMStatus() {
        return this.pCW;
    }

    public final void setMStatus(C21557a c21557a) {
        AppMethodBeat.m2504i(103028);
        C25052j.m39376p(c21557a, "<set-?>");
        this.pCW = c21557a;
        AppMethodBeat.m2505o(103028);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(103030);
        AppMethodBeat.m2505o(103030);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103031);
        AppMethodBeat.m2505o(103031);
    }

    /* Access modifiers changed, original: final */
    public final void cdK() {
        AppMethodBeat.m2504i(103029);
        switch (C12944e.eQZ[this.pCW.ordinal()]) {
            case 1:
                setVisibility(4);
                AppMethodBeat.m2505o(103029);
                return;
            case 2:
                setBackgroundResource(C1318a.radar_select);
                setVisibility(0);
                AppMethodBeat.m2505o(103029);
                return;
            default:
                setVisibility(4);
                AppMethodBeat.m2505o(103029);
                return;
        }
    }

    static {
        AppMethodBeat.m2504i(103025);
        AppMethodBeat.m2505o(103025);
    }
}
