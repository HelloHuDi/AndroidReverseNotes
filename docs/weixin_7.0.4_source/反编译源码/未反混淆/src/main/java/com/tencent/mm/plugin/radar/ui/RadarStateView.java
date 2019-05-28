package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

@l(dWo = {1, 1, 13}, dWp = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b*\u0001$\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J\b\u0010,\u001a\u00020(H\u0002J\u0006\u0010-\u001a\u00020(J\u0006\u0010&\u001a\u00020(J\u000e\u0010.\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u00020$X\u0004¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "setShowing", "(Z)V", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView extends RelativeLayout {
    static final String TAG = TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), v.a(new t(v.aN(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    static final int pDe = 300;
    public static final a pDf = new a();
    e pBL = e.Stranger;
    boolean pCS;
    private final f pCT = i.g(new c(this));
    private final f pCU = i.g(new b(this));
    boolean pDb = true;
    final d pDc = new d(this);
    private ImageView pDd;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateView$Companion;", "", "()V", "SlideAnimationDuring", "", "getSlideAnimationDuring", "()I", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<Animation> {
        final /* synthetic */ RadarStateView pDg;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements AnimationListener {
            final /* synthetic */ b pDh;

            a(b bVar) {
                this.pDh = bVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(103033);
                j.p(animation, "animation");
                AppMethodBeat.o(103033);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(103034);
                j.p(animation, "animation");
                this.pDh.pDg.pCS = false;
                this.pDh.pDg.setVisibility(8);
                AppMethodBeat.o(103034);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(103035);
                j.p(animation, "animation");
                AppMethodBeat.o(103035);
            }
        }

        b(RadarStateView radarStateView) {
            this.pDg = radarStateView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103036);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDg.getContext(), R.anim.cl);
            loadAnimation.setAnimationListener(new a(this));
            AppMethodBeat.o(103036);
            return loadAnimation;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<Animation> {
        final /* synthetic */ RadarStateView pDg;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements AnimationListener {
            a() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(103037);
                j.p(animation, "animation");
                AppMethodBeat.o(103037);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(103038);
                j.p(animation, "animation");
                AppMethodBeat.o(103038);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(103039);
                j.p(animation, "animation");
                AppMethodBeat.o(103039);
            }
        }

        c(RadarStateView radarStateView) {
            this.pDg = radarStateView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103040);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDg.getContext(), R.anim.cm);
            loadAnimation.setAnimationListener(new a());
            AppMethodBeat.o(103040);
            return loadAnimation;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class d extends ak {
        final /* synthetic */ RadarStateView pDg;

        d(RadarStateView radarStateView) {
            this.pDg = radarStateView;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(103041);
            j.p(message, "msg");
            RadarStateView.a(this.pDg);
            this.pDg.cdL();
            AppMethodBeat.o(103041);
        }
    }

    private final Animation getSlideInAnim() {
        AppMethodBeat.i(103045);
        Animation animation = (Animation) this.pCU.getValue();
        AppMethodBeat.o(103045);
        return animation;
    }

    private final Animation getSlideOutAnim() {
        AppMethodBeat.i(103044);
        Animation animation = (Animation) this.pCT.getValue();
        AppMethodBeat.o(103044);
        return animation;
    }

    public static final /* synthetic */ void a(RadarStateView radarStateView) {
        AppMethodBeat.i(103052);
        radarStateView.cdK();
        AppMethodBeat.o(103052);
    }

    public final e getState() {
        return this.pBL;
    }

    public final void setState(e eVar) {
        AppMethodBeat.i(103043);
        j.p(eVar, "<set-?>");
        this.pBL = eVar;
        AppMethodBeat.o(103043);
    }

    private final void setShowing(boolean z) {
        this.pCS = z;
    }

    public RadarStateView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(103050);
        AppMethodBeat.o(103050);
    }

    public RadarStateView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(103051);
        AppMethodBeat.o(103051);
    }

    /* Access modifiers changed, original: final */
    public final void cdK() {
        AppMethodBeat.i(103046);
        ab.d(TAG, " state : " + this.pBL);
        if (this.pDb) {
            ImageView imageView;
            switch (f.eQZ[this.pBL.ordinal()]) {
                case 1:
                    setVisibility(8);
                    AppMethodBeat.o(103046);
                    return;
                case 2:
                    setBackgroundResource(R.raw.radar_search_blue_bg);
                    imageView = this.pDd;
                    if (imageView == null) {
                        j.dWJ();
                    }
                    imageView.setImageResource(R.raw.radar_search_waiting);
                    setVisibility(0);
                    AppMethodBeat.o(103046);
                    return;
                case 3:
                    setBackgroundResource(R.raw.radar_search_green_bg);
                    imageView = this.pDd;
                    if (imageView == null) {
                        j.dWJ();
                    }
                    imageView.setImageResource(R.raw.radar_search_ok);
                    setVisibility(0);
                    AppMethodBeat.o(103046);
                    return;
                case 4:
                    setBackgroundResource(R.raw.radar_search_green_bg);
                    imageView = this.pDd;
                    if (imageView == null) {
                        j.dWJ();
                    }
                    imageView.setImageResource(R.raw.radar_search_hi);
                    setVisibility(0);
                    break;
            }
            AppMethodBeat.o(103046);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(103046);
    }

    /* Access modifiers changed, original: final */
    public final void init() {
        AppMethodBeat.i(103047);
        if (this.pDd == null) {
            this.pDd = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, com.tencent.mm.bz.a.fromDPToPix(getContext(), 5), com.tencent.mm.bz.a.fromDPToPix(getContext(), 2));
            ImageView imageView = this.pDd;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.pDd);
        }
        AppMethodBeat.o(103047);
    }

    public final void cdL() {
        AppMethodBeat.i(103048);
        if (this.pDb) {
            init();
            cdK();
            this.pCS = true;
            startAnimation(getSlideOutAnim());
            AppMethodBeat.o(103048);
            return;
        }
        AppMethodBeat.o(103048);
    }

    public final void cdM() {
        AppMethodBeat.i(103049);
        if (this.pDb) {
            init();
            cdK();
            startAnimation(getSlideInAnim());
            AppMethodBeat.o(103049);
            return;
        }
        AppMethodBeat.o(103049);
    }

    static {
        AppMethodBeat.i(103042);
        AppMethodBeat.o(103042);
    }
}
