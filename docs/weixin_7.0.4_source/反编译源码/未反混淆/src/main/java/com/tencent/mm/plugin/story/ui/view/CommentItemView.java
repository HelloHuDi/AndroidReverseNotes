package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.R;

@l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0003BCDB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u000e\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\tJ\u0006\u00106\u001a\u00020\u000fJB\u00107\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010=2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010=J\b\u0010?\u001a\u000202H\u0014J\u0006\u0010@\u001a\u000202J\u0006\u0010A\u001a\u000202R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-¨\u0006E"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView extends LinearLayout {
    public static final b siy = new b();
    public ImageView goC;
    public View iVh;
    ValueAnimator siq;
    private ValueAnimator sir;
    public ViewGroup sis;
    com.tencent.mm.plugin.story.model.b.a sit;
    private boolean siu;
    int siv;
    int siw;
    int six;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class d implements AnimatorUpdateListener {
        final /* synthetic */ CommentItemView siD;

        d(CommentItemView commentItemView) {
            this.siD = commentItemView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(110344);
            j.o(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(110344);
                throw vVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            LayoutParams layoutParams = this.siD.getLayoutParams();
            layoutParams.width = this.siD.siv + ((int) (((float) (this.siD.six - this.siD.siv)) * floatValue));
            layoutParams.height = ((int) (floatValue * ((float) (this.siD.siw - this.siD.siv)))) + this.siD.siv;
            this.siD.setLayoutParams(layoutParams);
            AppMethodBeat.o(110344);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class e implements AnimatorUpdateListener {
        final /* synthetic */ CommentItemView siD;
        final /* synthetic */ int siE;
        final /* synthetic */ int siF;
        final /* synthetic */ float siG = 0.1f;
        final /* synthetic */ a.f.b.u.c siH;
        final /* synthetic */ a.f.a.a siI;

        e(CommentItemView commentItemView, int i, int i2, a.f.b.u.c cVar, a.f.a.a aVar) {
            this.siD = commentItemView;
            this.siE = i;
            this.siF = i2;
            this.siH = cVar;
            this.siI = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(110345);
            j.o(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(110345);
                throw vVar;
            }
            a.f.a.a aVar;
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
                aVar = (a.f.a.a) this.siH.AVE;
                if (aVar != null) {
                    aVar.invoke();
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
                        ofFloat.addUpdateListener(new d(commentItemView));
                        j.o(ofFloat, "sizeAnimator");
                        ofFloat.setDuration(300);
                        ofFloat.start();
                        j = 300;
                    }
                    ViewGroup viewGroup = commentItemView.sis;
                    if (viewGroup == null) {
                        j.avw("contentLayout");
                    }
                    viewGroup.setVisibility(0);
                    viewGroup = commentItemView.sis;
                    if (viewGroup == null) {
                        j.avw("contentLayout");
                    }
                    viewGroup.setAlpha(0.0f);
                    viewGroup = commentItemView.sis;
                    if (viewGroup == null) {
                        j.avw("contentLayout");
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup, "alpha", new float[]{0.0f, 1.0f});
                    j.o(ofFloat2, "contentLayoutAnim");
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
                aVar = this.siI;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(110345);
                    return;
                }
            }
            AppMethodBeat.o(110345);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
    public static final class c implements Interpolator {
        private final PointF siA = new PointF(this.siC.x * (1.0f - this.siz), this.siC.y * (1.0f - this.siz));
        private final PointF siB = new PointF(this.siC.x + ((1.0f - this.siC.x) * this.siz), this.siC.y + ((1.0f - this.siC.y) * this.siz));
        private final PointF siC;
        private final float siz = 0.2f;

        public c(PointF pointF) {
            j.p(pointF, "divide");
            AppMethodBeat.i(110343);
            this.siC = pointF;
            AppMethodBeat.o(110343);
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

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$ArgbEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "plugin-story_release"})
    public static final class a implements TypeEvaluator<Object> {
        public final Object evaluate(float f, Object obj, Object obj2) {
            AppMethodBeat.i(110342);
            j.p(obj, "startValue");
            j.p(obj2, "endValue");
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
            AppMethodBeat.o(110342);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(110356);
        AppMethodBeat.o(110356);
    }

    public CommentItemView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110354);
        this.sit = new com.tencent.mm.plugin.story.model.b.a();
        this.siv = com.tencent.mm.bz.a.fromDPToPix(context, 48);
        AppMethodBeat.o(110354);
    }

    public CommentItemView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110355);
        AppMethodBeat.o(110355);
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
        AppMethodBeat.i(110346);
        View view = this.iVh;
        if (view == null) {
            j.avw("maskView");
        }
        AppMethodBeat.o(110346);
        return view;
    }

    public final void setMaskView(View view) {
        AppMethodBeat.i(110347);
        j.p(view, "<set-?>");
        this.iVh = view;
        AppMethodBeat.o(110347);
    }

    public final ImageView getAvatarView() {
        AppMethodBeat.i(110348);
        ImageView imageView = this.goC;
        if (imageView == null) {
            j.avw("avatarView");
        }
        AppMethodBeat.o(110348);
        return imageView;
    }

    public final void setAvatarView(ImageView imageView) {
        AppMethodBeat.i(110349);
        j.p(imageView, "<set-?>");
        this.goC = imageView;
        AppMethodBeat.o(110349);
    }

    public final ViewGroup getContentLayout() {
        AppMethodBeat.i(110350);
        ViewGroup viewGroup = this.sis;
        if (viewGroup == null) {
            j.avw("contentLayout");
        }
        AppMethodBeat.o(110350);
        return viewGroup;
    }

    public final void setContentLayout(ViewGroup viewGroup) {
        AppMethodBeat.i(110351);
        j.p(viewGroup, "<set-?>");
        this.sis = viewGroup;
        AppMethodBeat.o(110351);
    }

    public final com.tencent.mm.plugin.story.model.b.a getComment() {
        return this.sit;
    }

    public final void setComment(com.tencent.mm.plugin.story.model.b.a aVar) {
        AppMethodBeat.i(110352);
        j.p(aVar, "<set-?>");
        this.sit = aVar;
        AppMethodBeat.o(110352);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onFinishInflate() {
        AppMethodBeat.i(110353);
        super.onFinishInflate();
        View findViewById = findViewById(R.id.erh);
        if (findViewById == null) {
            findViewById = findViewById(R.id.erb);
        }
        if (findViewById == null) {
            this.iVh = this;
        } else {
            this.iVh = findViewById;
        }
        findViewById = findViewById(R.id.erc);
        j.o(findViewById, "findViewById(R.id.story_comment_item_avatar)");
        this.goC = (ImageView) findViewById;
        findViewById = findViewById(R.id.erd);
        j.o(findViewById, "findViewById(R.id.story_…ment_item_content_layout)");
        this.sis = (ViewGroup) findViewById;
        AppMethodBeat.o(110353);
    }
}
