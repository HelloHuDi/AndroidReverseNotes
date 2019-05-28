package com.tencent.p177mm.plugin.story.p536ui.view;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41381u.C31596c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0003BCDB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u000e\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\tJ\u0006\u00106\u001a\u00020\u000fJB\u00107\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010=2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010=J\b\u0010?\u001a\u000202H\u0014J\u0006\u0010@\u001a\u000202J\u0006\u0010A\u001a\u000202R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-¨\u0006E"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.CommentItemView */
public final class CommentItemView extends LinearLayout {
    public static final C13850b siy = new C13850b();
    public ImageView goC;
    public View iVh;
    ValueAnimator siq;
    private ValueAnimator sir;
    public ViewGroup sis;
    C39889a sit;
    private boolean siu;
    int siv;
    int siw;
    int six;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentItemView$b */
    public static final class C13850b {
        private C13850b() {
        }

        public /* synthetic */ C13850b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentItemView$d */
    static final class C13851d implements AnimatorUpdateListener {
        final /* synthetic */ CommentItemView siD;

        C13851d(CommentItemView commentItemView) {
            this.siD = commentItemView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(110344);
            C25052j.m39375o(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.m2505o(110344);
                throw c44941v;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            LayoutParams layoutParams = this.siD.getLayoutParams();
            layoutParams.width = this.siD.siv + ((int) (((float) (this.siD.six - this.siD.siv)) * floatValue));
            layoutParams.height = ((int) (floatValue * ((float) (this.siD.siw - this.siD.siv)))) + this.siD.siv;
            this.siD.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(110344);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentItemView$e */
    static final class C13852e implements AnimatorUpdateListener {
        final /* synthetic */ CommentItemView siD;
        final /* synthetic */ int siE;
        final /* synthetic */ int siF;
        final /* synthetic */ float siG = 0.1f;
        final /* synthetic */ C31596c siH;
        final /* synthetic */ C31214a siI;

        C13852e(CommentItemView commentItemView, int i, int i2, C31596c c31596c, C31214a c31214a) {
            this.siD = commentItemView;
            this.siE = i;
            this.siF = i2;
            this.siH = c31596c;
            this.siI = c31214a;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(110345);
            C25052j.m39375o(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.m2505o(110345);
                throw c44941v;
            }
            C31214a c31214a;
            float floatValue = ((Float) animatedValue).floatValue();
            int i = (int) (((float) (this.siE - this.siF)) * (1.0f - floatValue));
            this.siD.setTranslationY((float) i);
            if (floatValue < this.siG) {
                this.siD.setScaleX(floatValue / this.siG);
                this.siD.setScaleY(floatValue / this.siG);
                this.siD.setAlpha(((floatValue / this.siG) * 0.5f) + 0.5f);
            } else {
                this.siD.setScaleX(1.0f);
                this.siD.setScaleY(1.0f);
                this.siD.setAlpha(1.0f);
                c31214a = (C31214a) this.siH.AVE;
                if (c31214a != null) {
                    c31214a.invoke();
                }
                this.siH.AVE = null;
                if (!this.siD.siu) {
                    this.siD.siu = true;
                    CommentItemView commentItemView = this.siD;
                    long j = 0;
                    if (commentItemView.sit.rVi) {
                        LayoutParams layoutParams = commentItemView.getLayoutParams();
                        layoutParams.width = commentItemView.six;
                        layoutParams.height = commentItemView.siw;
                        commentItemView.setLayoutParams(layoutParams);
                    } else {
                        ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new C13851d(commentItemView));
                        C25052j.m39375o(ofFloat, "sizeAnimator");
                        ofFloat.setDuration(300);
                        ofFloat.start();
                        j = 300;
                    }
                    ViewGroup viewGroup = commentItemView.sis;
                    if (viewGroup == null) {
                        C25052j.avw("contentLayout");
                    }
                    viewGroup.setVisibility(0);
                    viewGroup = commentItemView.sis;
                    if (viewGroup == null) {
                        C25052j.avw("contentLayout");
                    }
                    viewGroup.setAlpha(0.0f);
                    viewGroup = commentItemView.sis;
                    if (viewGroup == null) {
                        C25052j.avw("contentLayout");
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup, "alpha", new float[]{0.0f, 1.0f});
                    C25052j.m39375o(ofFloat2, "contentLayoutAnim");
                    ofFloat2.setStartDelay(j);
                    ofFloat2.setDuration(100);
                    ofFloat2.start();
                }
            }
            if (i < 100) {
                this.siD.setAlpha(((float) i) / 100.0f);
            }
            if (this.siD.getAlpha() < 0.05f) {
                ValueAnimator normalAnimator = this.siD.getNormalAnimator();
                if (normalAnimator != null) {
                    normalAnimator.removeAllUpdateListeners();
                }
                c31214a = this.siI;
                if (c31214a != null) {
                    c31214a.invoke();
                    AppMethodBeat.m2505o(110345);
                    return;
                }
            }
            AppMethodBeat.m2505o(110345);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentItemView$c */
    public static final class C29340c implements Interpolator {
        private final PointF siA = new PointF(this.siC.x * (1.0f - this.siz), this.siC.y * (1.0f - this.siz));
        private final PointF siB = new PointF(this.siC.x + ((1.0f - this.siC.x) * this.siz), this.siC.y + ((1.0f - this.siC.y) * this.siz));
        private final PointF siC;
        private final float siz = 0.2f;

        public C29340c(PointF pointF) {
            C25052j.m39376p(pointF, "divide");
            AppMethodBeat.m2504i(110343);
            this.siC = pointF;
            AppMethodBeat.m2505o(110343);
        }

        public final float getInterpolation(float f) {
            if (f < this.siA.x) {
                return (this.siC.y * f) / this.siC.x;
            }
            if (f < this.siB.x) {
                return this.siA.y + (((f - this.siA.x) / (this.siB.x - this.siA.x)) * (this.siB.y - this.siA.y));
            }
            return this.siC.y + (((f - this.siC.x) / (1.0f - this.siC.x)) * (1.0f - this.siC.y));
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$ArgbEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentItemView$a */
    public static final class C29341a implements TypeEvaluator<Object> {
        public final Object evaluate(float f, Object obj, Object obj2) {
            AppMethodBeat.m2504i(110342);
            C25052j.m39376p(obj, "startValue");
            C25052j.m39376p(obj2, "endValue");
            int intValue = ((Integer) obj).intValue();
            float f2 = ((float) ((intValue >> 24) & 255)) / 255.0f;
            float f3 = ((float) ((intValue >> 16) & 255)) / 255.0f;
            float f4 = ((float) ((intValue >> 8) & 255)) / 255.0f;
            float f5 = ((float) (intValue & 255)) / 255.0f;
            int intValue2 = ((Integer) obj2).intValue();
            float f6 = ((float) ((intValue2 >> 24) & 255)) / 255.0f;
            float f7 = ((float) ((intValue2 >> 16) & 255)) / 255.0f;
            float f8 = ((float) ((intValue2 >> 8) & 255)) / 255.0f;
            f3 = (float) Math.pow((double) f3, 2.2d);
            f4 = (float) Math.pow((double) f4, 2.2d);
            f5 = (float) Math.pow((double) f5, 2.2d);
            int round = ((Math.round((f2 + ((f6 - f2) * f)) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (f3 + ((((float) Math.pow((double) f7, 2.2d)) - f3) * f)), 0.45454545454545453d)) * 255.0f) << 16)) | (Math.round(((float) Math.pow((double) (f4 + ((((float) Math.pow((double) f8, 2.2d)) - f4) * f)), 0.45454545454545453d)) * 255.0f) << 8);
            Integer valueOf = Integer.valueOf(Math.round(((float) Math.pow((double) (f5 + ((((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - f5) * f)), 0.45454545454545453d)) * 255.0f) | round);
            AppMethodBeat.m2505o(110342);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.m2504i(110356);
        AppMethodBeat.m2505o(110356);
    }

    public CommentItemView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110354);
        this.sit = new C39889a();
        this.siv = C1338a.fromDPToPix(context, 48);
        AppMethodBeat.m2505o(110354);
    }

    public CommentItemView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110355);
        AppMethodBeat.m2505o(110355);
    }

    public final ValueAnimator getNormalAnimator() {
        return this.siq;
    }

    public final void setNormalAnimator(ValueAnimator valueAnimator) {
        this.siq = valueAnimator;
    }

    public final ValueAnimator getNormalBgAnimator() {
        return this.sir;
    }

    public final void setNormalBgAnimator(ValueAnimator valueAnimator) {
        this.sir = valueAnimator;
    }

    public final View getMaskView() {
        AppMethodBeat.m2504i(110346);
        View view = this.iVh;
        if (view == null) {
            C25052j.avw("maskView");
        }
        AppMethodBeat.m2505o(110346);
        return view;
    }

    public final void setMaskView(View view) {
        AppMethodBeat.m2504i(110347);
        C25052j.m39376p(view, "<set-?>");
        this.iVh = view;
        AppMethodBeat.m2505o(110347);
    }

    public final ImageView getAvatarView() {
        AppMethodBeat.m2504i(110348);
        ImageView imageView = this.goC;
        if (imageView == null) {
            C25052j.avw("avatarView");
        }
        AppMethodBeat.m2505o(110348);
        return imageView;
    }

    public final void setAvatarView(ImageView imageView) {
        AppMethodBeat.m2504i(110349);
        C25052j.m39376p(imageView, "<set-?>");
        this.goC = imageView;
        AppMethodBeat.m2505o(110349);
    }

    public final ViewGroup getContentLayout() {
        AppMethodBeat.m2504i(110350);
        ViewGroup viewGroup = this.sis;
        if (viewGroup == null) {
            C25052j.avw("contentLayout");
        }
        AppMethodBeat.m2505o(110350);
        return viewGroup;
    }

    public final void setContentLayout(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(110351);
        C25052j.m39376p(viewGroup, "<set-?>");
        this.sis = viewGroup;
        AppMethodBeat.m2505o(110351);
    }

    public final C39889a getComment() {
        return this.sit;
    }

    public final void setComment(C39889a c39889a) {
        AppMethodBeat.m2504i(110352);
        C25052j.m39376p(c39889a, "<set-?>");
        this.sit = c39889a;
        AppMethodBeat.m2505o(110352);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onFinishInflate() {
        AppMethodBeat.m2504i(110353);
        super.onFinishInflate();
        View findViewById = findViewById(2131828072);
        if (findViewById == null) {
            findViewById = findViewById(2131828066);
        }
        if (findViewById == null) {
            this.iVh = this;
        } else {
            this.iVh = findViewById;
        }
        findViewById = findViewById(2131828067);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_item_avatar)");
        this.goC = (ImageView) findViewById;
        findViewById = findViewById(2131828068);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…ment_item_content_layout)");
        this.sis = (ViewGroup) findViewById;
        AppMethodBeat.m2505o(110353);
    }
}
