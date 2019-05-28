package com.tencent.p177mm.plugin.radar.p489ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b*\u0002\u00117\u0018\u0000 S2\u00020\u0001:\u0001SB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u0006\u0010A\u001a\u00020?J\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\u0006\u0010D\u001a\u00020?J\u000e\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020\u0014J\u000e\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\u0014J\u0006\u0010I\u001a\u00020?J\u000e\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020?J\u0006\u0010N\u001a\u00020?J\u0018\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\t2\b\b\u0002\u0010Q\u001a\u00020\tJ\u0016\u0010O\u001a\u00020?2\u0006\u0010K\u001a\u00020L2\u0006\u0010Q\u001a\u00020\tJ\u0006\u0010R\u001a\u00020?R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b4\u00101R\u0010\u00106\u001a\u000207X\u0004¢\u0006\u0004\n\u0002\u00108R\u001b\u00109\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b=\u0010(\u001a\u0004\b;\u0010<¨\u0006T"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "setPressing", "(Z)V", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView */
public final class RadarTipsView extends RelativeLayout {
    static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;"))};
    private static final int pDC = 3;
    private static final int pDD = 0;
    static final int pDE = 1;
    static final int pDF = 2;
    private static final int pDG = 3;
    public static final C34769a pDH = new C34769a();
    private boolean pDA;
    int pDB = pDD;
    private final C12938b pDi = new C12938b(this);
    private final C44856f pDj = C17344i.m26854g(new C34771d(this));
    private final C44856f pDk = C17344i.m26854g(new C34772e(this));
    private final C44856f pDl = C46153i.m86149aa(this, 2131826799);
    private final C44856f pDm = C46153i.m86149aa(this, 2131826798);
    private final C44856f pDn = C46153i.m86149aa(this, 2131826800);
    private final int pDo;
    final int pDp = 1;
    final int pDq = 2;
    private final int pDr = 3;
    private final int pDs = 3;
    final C34770f pDt = new C34770f(this, Looper.getMainLooper());
    boolean pDu;
    private boolean pDv = true;
    boolean pDw;
    boolean pDx;
    private int pDy;
    private long pDz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView$b */
    public static final class C12938b extends C7306ak {
        final /* synthetic */ RadarTipsView pDI;

        C12938b(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(103053);
            C25052j.m39376p(message, "msg");
            this.pDI.setVisibility(8);
            AppMethodBeat.m2505o(103053);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView$c */
    static final class C28792c implements OnClickListener {
        final /* synthetic */ RadarTipsView pDI;

        C28792c(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(103054);
            C4990ab.m7410d(RadarTipsView.TAG, "noviceEducationTips onclick");
            this.pDI.cdO();
            AppMethodBeat.m2505o(103054);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$Companion;", "", "()V", "PressTooShortCountThreshold", "", "TAG", "", "TIPS_PURPOSE_ERROR_MESSAGE", "TIPS_PURPOSE_NORMAL", "TIPS_PURPOSE_NOVICE_EDUCATION", "TIPS_PURPOSE_SHEARING", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView$a */
    public static final class C34769a {
        private C34769a() {
        }

        public /* synthetic */ C34769a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView$f */
    public static final class C34770f extends C7306ak {
        final /* synthetic */ RadarTipsView pDI;

        C34770f(RadarTipsView radarTipsView, Looper looper) {
            this.pDI = radarTipsView;
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(103060);
            C25052j.m39376p(message, "msg");
            int i = message.what;
            if (i == this.pDI.pDo) {
                this.pDI.cdP();
                AppMethodBeat.m2505o(103060);
                return;
            }
            if (i == this.pDI.pDp) {
                if (this.pDI.pDv && this.pDI.pDx) {
                    RadarTipsView.m57108a(this.pDI);
                    AppMethodBeat.m2505o(103060);
                    return;
                }
            } else if (i == this.pDI.pDr) {
                RadarTipsView radarTipsView = this.pDI;
                radarTipsView.pDu = true;
                radarTipsView.pDB = RadarTipsView.pDF;
                C4990ab.m7410d(RadarTipsView.TAG, "showNoviceEducation");
                radarTipsView.pDw = true;
                radarTipsView.getTextTipsContainer().setVisibility(8);
                radarTipsView.getTextTipsContainer().clearAnimation();
                radarTipsView.setVisibility(0);
                radarTipsView.getNoviceEducationTips().setVisibility(0);
                radarTipsView.getNoviceEducationTips().startAnimation(radarTipsView.getTipsFadeIn());
                radarTipsView.getNoviceEducationTips().requestFocus();
                AppMethodBeat.m2505o(103060);
                return;
            } else if (i == this.pDI.pDs) {
                this.pDI.cdO();
            }
            AppMethodBeat.m2505o(103060);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView$d */
    static final class C34771d extends C25053k implements C31214a<Animation> {
        final /* synthetic */ RadarTipsView pDI;

        C34771d(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103055);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDI.getContext(), C25738R.anim.f8382cn);
            AppMethodBeat.m2505o(103055);
            return loadAnimation;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView$e */
    static final class C34772e extends C25053k implements C31214a<Animation> {
        final /* synthetic */ RadarTipsView pDI;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarTipsView$e$a */
        public static final class C34773a implements AnimationListener {
            final /* synthetic */ C34772e pDJ;

            C34773a(C34772e c34772e) {
                this.pDJ = c34772e;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(103056);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103056);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(103057);
                C25052j.m39376p(animation, "animation");
                if (!this.pDJ.pDI.pDu) {
                    this.pDJ.pDI.pDi.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(103057);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.m2504i(103058);
                C25052j.m39376p(animation, "animation");
                AppMethodBeat.m2505o(103058);
            }
        }

        C34772e(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103059);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDI.getContext(), C25738R.anim.f8383co);
            loadAnimation.setAnimationListener(new C34773a(this));
            AppMethodBeat.m2505o(103059);
            return loadAnimation;
        }
    }

    private final Animation getTipsFadeOut() {
        AppMethodBeat.m2504i(103063);
        Animation animation = (Animation) this.pDk.getValue();
        AppMethodBeat.m2505o(103063);
        return animation;
    }

    private final TextView getTvTextTips() {
        AppMethodBeat.m2504i(103064);
        TextView textView = (TextView) this.pDl.getValue();
        AppMethodBeat.m2505o(103064);
        return textView;
    }

    /* Access modifiers changed, original: final */
    public final LinearLayout getNoviceEducationTips() {
        AppMethodBeat.m2504i(103066);
        LinearLayout linearLayout = (LinearLayout) this.pDn.getValue();
        AppMethodBeat.m2505o(103066);
        return linearLayout;
    }

    /* Access modifiers changed, original: final */
    public final View getTextTipsContainer() {
        AppMethodBeat.m2504i(103065);
        View view = (View) this.pDm.getValue();
        AppMethodBeat.m2505o(103065);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final Animation getTipsFadeIn() {
        AppMethodBeat.m2504i(103062);
        Animation animation = (Animation) this.pDj.getValue();
        AppMethodBeat.m2505o(103062);
        return animation;
    }

    private final void setPressing(boolean z) {
        this.pDx = z;
    }

    public RadarTipsView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(103075);
        AppMethodBeat.m2505o(103075);
    }

    public RadarTipsView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103076);
        AppMethodBeat.m2505o(103076);
    }

    /* renamed from: cT */
    private void m57111cT(String str, int i) {
        AppMethodBeat.m2504i(103068);
        C25052j.m39376p(str, "msg");
        this.pDu = true;
        getNoviceEducationTips().setVisibility(8);
        getNoviceEducationTips().clearAnimation();
        getTvTextTips().setText(str);
        setVisibility(0);
        getTextTipsContainer().setVisibility(0);
        getTextTipsContainer().startAnimation(getTipsFadeIn());
        this.pDt.removeMessages(this.pDo);
        this.pDt.removeMessages(this.pDq);
        if (i > 0) {
            this.pDt.sendEmptyMessageDelayed(this.pDo, (long) i);
        }
        AppMethodBeat.m2505o(103068);
    }

    /* renamed from: Vz */
    public final void mo55378Vz(String str) {
        AppMethodBeat.m2504i(103069);
        C25052j.m39376p(str, "msg");
        this.pDB = pDG;
        m57111cT(str, 5000);
        AppMethodBeat.m2505o(103069);
    }

    public final void cdO() {
        AppMethodBeat.m2504i(103070);
        this.pDu = false;
        this.pDB = pDD;
        C4990ab.m7410d(TAG, "hidNoviceEducation");
        this.pDt.removeMessages(this.pDr);
        if (getVisibility() == 0 && getNoviceEducationTips().getVisibility() == 0) {
            getNoviceEducationTips().clearAnimation();
            if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
                getTextTipsContainer().clearAnimation();
            }
            C4990ab.m7410d(TAG, "hideNoviceEducation real");
            getNoviceEducationTips().startAnimation(getTipsFadeOut());
        }
        AppMethodBeat.m2505o(103070);
    }

    public final void setNoMember(boolean z) {
        AppMethodBeat.m2504i(103071);
        this.pDv = z;
        if (!this.pDv) {
            cdP();
            cdQ();
            cdO();
        }
        AppMethodBeat.m2505o(103071);
    }

    public final void setPressingDown(boolean z) {
        AppMethodBeat.m2504i(103072);
        if (this.pDz != 0) {
            this.pDB = pDD;
            cdQ();
            cdP();
            getTextTipsContainer().setVisibility(8);
            getNoviceEducationTips().setVisibility(8);
            setVisibility(8);
        }
        this.pDx = true;
        this.pDz = C5046bo.m7588yz();
        this.pDA = z;
        this.pDy++;
        AppMethodBeat.m2505o(103072);
    }

    public final void cdP() {
        AppMethodBeat.m2504i(103073);
        C4990ab.m7410d(TAG, "hideRadarTips");
        if (getVisibility() == 0 && getTextTipsContainer().getVisibility() == 0) {
            if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
                getNoviceEducationTips().clearAnimation();
            }
            getTextTipsContainer().clearAnimation();
            C4990ab.m7410d(TAG, "hideRadarTips real");
            this.pDB = pDD;
            this.pDu = false;
            getTextTipsContainer().startAnimation(getTipsFadeOut());
        }
        AppMethodBeat.m2505o(103073);
    }

    private void cdQ() {
        AppMethodBeat.m2504i(103074);
        this.pDu = false;
        C34770f c34770f = this.pDt;
        c34770f.removeMessages(this.pDp);
        c34770f.removeMessages(this.pDq);
        c34770f.removeMessages(this.pDr);
        AppMethodBeat.m2505o(103074);
    }

    static {
        AppMethodBeat.m2504i(103061);
        AppMethodBeat.m2505o(103061);
    }

    /* renamed from: a */
    public static /* synthetic */ void m57108a(RadarTipsView radarTipsView) {
        AppMethodBeat.m2504i(103067);
        String string = radarTipsView.getContext().getString(C25738R.string.dhb);
        C25052j.m39375o(string, "context.getString(res)");
        radarTipsView.m57111cT(string, -1);
        AppMethodBeat.m2505o(103067);
    }
}
