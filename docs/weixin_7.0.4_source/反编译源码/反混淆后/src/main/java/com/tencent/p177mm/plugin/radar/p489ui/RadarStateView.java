package com.tencent.p177mm.plugin.radar.p489ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C21556e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b*\u0001$\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J\b\u0010,\u001a\u00020(H\u0002J\u0006\u0010-\u001a\u00020(J\u0006\u0010&\u001a\u00020(J\u000e\u0010.\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u00020$X\u0004¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "setShowing", "(Z)V", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateView */
public final class RadarStateView extends RelativeLayout {
    static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    static final int pDe = 300;
    public static final C12935a pDf = new C12935a();
    C21556e pBL = C21556e.Stranger;
    boolean pCS;
    private final C44856f pCT = C17344i.m26854g(new C21562c(this));
    private final C44856f pCU = C17344i.m26854g(new C12937b(this));
    boolean pDb = true;
    final C21563d pDc = new C21563d(this);
    private ImageView pDd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateView$Companion;", "", "()V", "SlideAnimationDuring", "", "getSlideAnimationDuring", "()I", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateView$a */
    public static final class C12935a {
        private C12935a() {
        }

        public /* synthetic */ C12935a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateView$b */
    static final class C12937b extends C25053k implements C31214a<Animation> {
        final /* synthetic */ RadarStateView pDg;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateView$b$a */
        public static final class C12936a implements AnimationListener {
            final /* synthetic */ C12937b pDh;

            C12936a(C12937b c12937b) {
                this.pDh = c12937b;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(103033);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103033);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(103034);
                C25052j.m39376p(animation, "animation");
                this.pDh.pDg.pCS = false;
                this.pDh.pDg.setVisibility(8);
                AppMethodBeat.m2505o(103034);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.m2504i(103035);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103035);
            }
        }

        C12937b(RadarStateView radarStateView) {
            this.pDg = radarStateView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103036);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDg.getContext(), C25738R.anim.f8380cl);
            loadAnimation.setAnimationListener(new C12936a(this));
            AppMethodBeat.m2505o(103036);
            return loadAnimation;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateView$c */
    static final class C21562c extends C25053k implements C31214a<Animation> {
        final /* synthetic */ RadarStateView pDg;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateView$c$a */
        public static final class C3681a implements AnimationListener {
            C3681a() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(103037);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103037);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(103038);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103038);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.m2504i(103039);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103039);
            }
        }

        C21562c(RadarStateView radarStateView) {
            this.pDg = radarStateView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103040);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDg.getContext(), C25738R.anim.f8381cm);
            loadAnimation.setAnimationListener(new C3681a());
            AppMethodBeat.m2505o(103040);
            return loadAnimation;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarStateView$d */
    public static final class C21563d extends C7306ak {
        final /* synthetic */ RadarStateView pDg;

        C21563d(RadarStateView radarStateView) {
            this.pDg = radarStateView;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(103041);
            C25052j.m39376p(message, "msg");
            RadarStateView.m33017a(this.pDg);
            this.pDg.cdL();
            AppMethodBeat.m2505o(103041);
        }
    }

    private final Animation getSlideInAnim() {
        AppMethodBeat.m2504i(103045);
        Animation animation = (Animation) this.pCU.getValue();
        AppMethodBeat.m2505o(103045);
        return animation;
    }

    private final Animation getSlideOutAnim() {
        AppMethodBeat.m2504i(103044);
        Animation animation = (Animation) this.pCT.getValue();
        AppMethodBeat.m2505o(103044);
        return animation;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m33017a(RadarStateView radarStateView) {
        AppMethodBeat.m2504i(103052);
        radarStateView.cdK();
        AppMethodBeat.m2505o(103052);
    }

    public final C21556e getState() {
        return this.pBL;
    }

    public final void setState(C21556e c21556e) {
        AppMethodBeat.m2504i(103043);
        C25052j.m39376p(c21556e, "<set-?>");
        this.pBL = c21556e;
        AppMethodBeat.m2505o(103043);
    }

    private final void setShowing(boolean z) {
        this.pCS = z;
    }

    public RadarStateView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(103050);
        AppMethodBeat.m2505o(103050);
    }

    public RadarStateView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103051);
        AppMethodBeat.m2505o(103051);
    }

    /* Access modifiers changed, original: final */
    public final void cdK() {
        AppMethodBeat.m2504i(103046);
        C4990ab.m7410d(TAG, " state : " + this.pBL);
        if (this.pDb) {
            ImageView imageView;
            switch (C28793f.eQZ[this.pBL.ordinal()]) {
                case 1:
                    setVisibility(8);
                    AppMethodBeat.m2505o(103046);
                    return;
                case 2:
                    setBackgroundResource(C1318a.radar_search_blue_bg);
                    imageView = this.pDd;
                    if (imageView == null) {
                        C25052j.dWJ();
                    }
                    imageView.setImageResource(C1318a.radar_search_waiting);
                    setVisibility(0);
                    AppMethodBeat.m2505o(103046);
                    return;
                case 3:
                    setBackgroundResource(C1318a.radar_search_green_bg);
                    imageView = this.pDd;
                    if (imageView == null) {
                        C25052j.dWJ();
                    }
                    imageView.setImageResource(C1318a.radar_search_ok);
                    setVisibility(0);
                    AppMethodBeat.m2505o(103046);
                    return;
                case 4:
                    setBackgroundResource(C1318a.radar_search_green_bg);
                    imageView = this.pDd;
                    if (imageView == null) {
                        C25052j.dWJ();
                    }
                    imageView.setImageResource(C1318a.radar_search_hi);
                    setVisibility(0);
                    break;
            }
            AppMethodBeat.m2505o(103046);
            return;
        }
        setVisibility(8);
        AppMethodBeat.m2505o(103046);
    }

    /* Access modifiers changed, original: final */
    public final void init() {
        AppMethodBeat.m2504i(103047);
        if (this.pDd == null) {
            this.pDd = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, C1338a.fromDPToPix(getContext(), 5), C1338a.fromDPToPix(getContext(), 2));
            ImageView imageView = this.pDd;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.pDd);
        }
        AppMethodBeat.m2505o(103047);
    }

    public final void cdL() {
        AppMethodBeat.m2504i(103048);
        if (this.pDb) {
            init();
            cdK();
            this.pCS = true;
            startAnimation(getSlideOutAnim());
            AppMethodBeat.m2505o(103048);
            return;
        }
        AppMethodBeat.m2505o(103048);
    }

    public final void cdM() {
        AppMethodBeat.m2504i(103049);
        if (this.pDb) {
            init();
            cdK();
            startAnimation(getSlideInAnim());
            AppMethodBeat.m2505o(103049);
            return;
        }
        AppMethodBeat.m2505o(103049);
    }

    static {
        AppMethodBeat.m2504i(103042);
        AppMethodBeat.m2505o(103042);
    }
}
