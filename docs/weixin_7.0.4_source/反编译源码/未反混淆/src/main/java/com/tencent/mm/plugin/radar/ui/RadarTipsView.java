package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b*\u0002\u00117\u0018\u0000 S2\u00020\u0001:\u0001SB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u0006\u0010A\u001a\u00020?J\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\u0006\u0010D\u001a\u00020?J\u000e\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020\u0014J\u000e\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\u0014J\u0006\u0010I\u001a\u00020?J\u000e\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020?J\u0006\u0010N\u001a\u00020?J\u0018\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\t2\b\b\u0002\u0010Q\u001a\u00020\tJ\u0016\u0010O\u001a\u00020?2\u0006\u0010K\u001a\u00020L2\u0006\u0010Q\u001a\u00020\tJ\u0006\u0010R\u001a\u00020?R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b4\u00101R\u0010\u00106\u001a\u000207X\u0004¢\u0006\u0004\n\u0002\u00108R\u001b\u00109\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b=\u0010(\u001a\u0004\b;\u0010<¨\u0006T"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "setPressing", "(Z)V", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView extends RelativeLayout {
    static final String TAG = TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), v.a(new t(v.aN(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), v.a(new t(v.aN(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), v.a(new t(v.aN(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), v.a(new t(v.aN(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;"))};
    private static final int pDC = 3;
    private static final int pDD = 0;
    static final int pDE = 1;
    static final int pDF = 2;
    private static final int pDG = 3;
    public static final a pDH = new a();
    private boolean pDA;
    int pDB = pDD;
    private final b pDi = new b(this);
    private final a.f pDj = i.g(new d(this));
    private final a.f pDk = i.g(new e(this));
    private final a.f pDl = i.aa(this, R.id.du3);
    private final a.f pDm = i.aa(this, R.id.du2);
    private final a.f pDn = i.aa(this, R.id.du4);
    private final int pDo;
    final int pDp = 1;
    final int pDq = 2;
    private final int pDr = 3;
    private final int pDs = 3;
    final f pDt = new f(this, Looper.getMainLooper());
    boolean pDu;
    private boolean pDv = true;
    boolean pDw;
    boolean pDx;
    private int pDy;
    private long pDz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class b extends ak {
        final /* synthetic */ RadarTipsView pDI;

        b(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(103053);
            j.p(message, "msg");
            this.pDI.setVisibility(8);
            AppMethodBeat.o(103053);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ RadarTipsView pDI;

        c(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(103054);
            ab.d(RadarTipsView.TAG, "noviceEducationTips onclick");
            this.pDI.cdO();
            AppMethodBeat.o(103054);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$Companion;", "", "()V", "PressTooShortCountThreshold", "", "TAG", "", "TIPS_PURPOSE_ERROR_MESSAGE", "TIPS_PURPOSE_NORMAL", "TIPS_PURPOSE_NOVICE_EDUCATION", "TIPS_PURPOSE_SHEARING", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class f extends ak {
        final /* synthetic */ RadarTipsView pDI;

        f(RadarTipsView radarTipsView, Looper looper) {
            this.pDI = radarTipsView;
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(103060);
            j.p(message, "msg");
            int i = message.what;
            if (i == this.pDI.pDo) {
                this.pDI.cdP();
                AppMethodBeat.o(103060);
                return;
            }
            if (i == this.pDI.pDp) {
                if (this.pDI.pDv && this.pDI.pDx) {
                    RadarTipsView.a(this.pDI);
                    AppMethodBeat.o(103060);
                    return;
                }
            } else if (i == this.pDI.pDr) {
                RadarTipsView radarTipsView = this.pDI;
                radarTipsView.pDu = true;
                radarTipsView.pDB = RadarTipsView.pDF;
                ab.d(RadarTipsView.TAG, "showNoviceEducation");
                radarTipsView.pDw = true;
                radarTipsView.getTextTipsContainer().setVisibility(8);
                radarTipsView.getTextTipsContainer().clearAnimation();
                radarTipsView.setVisibility(0);
                radarTipsView.getNoviceEducationTips().setVisibility(0);
                radarTipsView.getNoviceEducationTips().startAnimation(radarTipsView.getTipsFadeIn());
                radarTipsView.getNoviceEducationTips().requestFocus();
                AppMethodBeat.o(103060);
                return;
            } else if (i == this.pDI.pDs) {
                this.pDI.cdO();
            }
            AppMethodBeat.o(103060);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<Animation> {
        final /* synthetic */ RadarTipsView pDI;

        d(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103055);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDI.getContext(), R.anim.cn);
            AppMethodBeat.o(103055);
            return loadAnimation;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<Animation> {
        final /* synthetic */ RadarTipsView pDI;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements AnimationListener {
            final /* synthetic */ e pDJ;

            a(e eVar) {
                this.pDJ = eVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(103056);
                j.p(animation, "animation");
                AppMethodBeat.o(103056);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(103057);
                j.p(animation, "animation");
                if (!this.pDJ.pDI.pDu) {
                    this.pDJ.pDI.pDi.sendEmptyMessage(0);
                }
                AppMethodBeat.o(103057);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(103058);
                j.p(animation, "animation");
                AppMethodBeat.o(103058);
            }
        }

        e(RadarTipsView radarTipsView) {
            this.pDI = radarTipsView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103059);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pDI.getContext(), R.anim.co);
            loadAnimation.setAnimationListener(new a(this));
            AppMethodBeat.o(103059);
            return loadAnimation;
        }
    }

    private final Animation getTipsFadeOut() {
        AppMethodBeat.i(103063);
        Animation animation = (Animation) this.pDk.getValue();
        AppMethodBeat.o(103063);
        return animation;
    }

    private final TextView getTvTextTips() {
        AppMethodBeat.i(103064);
        TextView textView = (TextView) this.pDl.getValue();
        AppMethodBeat.o(103064);
        return textView;
    }

    /* Access modifiers changed, original: final */
    public final LinearLayout getNoviceEducationTips() {
        AppMethodBeat.i(103066);
        LinearLayout linearLayout = (LinearLayout) this.pDn.getValue();
        AppMethodBeat.o(103066);
        return linearLayout;
    }

    /* Access modifiers changed, original: final */
    public final View getTextTipsContainer() {
        AppMethodBeat.i(103065);
        View view = (View) this.pDm.getValue();
        AppMethodBeat.o(103065);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final Animation getTipsFadeIn() {
        AppMethodBeat.i(103062);
        Animation animation = (Animation) this.pDj.getValue();
        AppMethodBeat.o(103062);
        return animation;
    }

    private final void setPressing(boolean z) {
        this.pDx = z;
    }

    public RadarTipsView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(103075);
        AppMethodBeat.o(103075);
    }

    public RadarTipsView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(103076);
        AppMethodBeat.o(103076);
    }

    private void cT(String str, int i) {
        AppMethodBeat.i(103068);
        j.p(str, "msg");
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
        AppMethodBeat.o(103068);
    }

    public final void Vz(String str) {
        AppMethodBeat.i(103069);
        j.p(str, "msg");
        this.pDB = pDG;
        cT(str, 5000);
        AppMethodBeat.o(103069);
    }

    public final void cdO() {
        AppMethodBeat.i(103070);
        this.pDu = false;
        this.pDB = pDD;
        ab.d(TAG, "hidNoviceEducation");
        this.pDt.removeMessages(this.pDr);
        if (getVisibility() == 0 && getNoviceEducationTips().getVisibility() == 0) {
            getNoviceEducationTips().clearAnimation();
            if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
                getTextTipsContainer().clearAnimation();
            }
            ab.d(TAG, "hideNoviceEducation real");
            getNoviceEducationTips().startAnimation(getTipsFadeOut());
        }
        AppMethodBeat.o(103070);
    }

    public final void setNoMember(boolean z) {
        AppMethodBeat.i(103071);
        this.pDv = z;
        if (!this.pDv) {
            cdP();
            cdQ();
            cdO();
        }
        AppMethodBeat.o(103071);
    }

    public final void setPressingDown(boolean z) {
        AppMethodBeat.i(103072);
        if (this.pDz != 0) {
            this.pDB = pDD;
            cdQ();
            cdP();
            getTextTipsContainer().setVisibility(8);
            getNoviceEducationTips().setVisibility(8);
            setVisibility(8);
        }
        this.pDx = true;
        this.pDz = bo.yz();
        this.pDA = z;
        this.pDy++;
        AppMethodBeat.o(103072);
    }

    public final void cdP() {
        AppMethodBeat.i(103073);
        ab.d(TAG, "hideRadarTips");
        if (getVisibility() == 0 && getTextTipsContainer().getVisibility() == 0) {
            if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
                getNoviceEducationTips().clearAnimation();
            }
            getTextTipsContainer().clearAnimation();
            ab.d(TAG, "hideRadarTips real");
            this.pDB = pDD;
            this.pDu = false;
            getTextTipsContainer().startAnimation(getTipsFadeOut());
        }
        AppMethodBeat.o(103073);
    }

    private void cdQ() {
        AppMethodBeat.i(103074);
        this.pDu = false;
        f fVar = this.pDt;
        fVar.removeMessages(this.pDp);
        fVar.removeMessages(this.pDq);
        fVar.removeMessages(this.pDr);
        AppMethodBeat.o(103074);
    }

    static {
        AppMethodBeat.i(103061);
        AppMethodBeat.o(103061);
    }

    public static /* synthetic */ void a(RadarTipsView radarTipsView) {
        AppMethodBeat.i(103067);
        String string = radarTipsView.getContext().getString(R.string.dhb);
        j.o(string, "context.getString(res)");
        radarTipsView.cT(string, -1);
        AppMethodBeat.o(103067);
    }
}
