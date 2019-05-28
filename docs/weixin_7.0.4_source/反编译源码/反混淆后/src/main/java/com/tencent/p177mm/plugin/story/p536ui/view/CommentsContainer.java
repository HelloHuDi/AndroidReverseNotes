package com.tencent.p177mm.plugin.story.p536ui.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.p536ui.view.CommentItemView.C13852e;
import com.tencent.p177mm.plugin.story.p536ui.view.CommentItemView.C29340c;
import com.tencent.p177mm.plugin.story.p536ui.view.CommentItemView.C29341a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C31596c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010(\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\u0006\u0010.\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u0018J\u0006\u00100\u001a\u00020\u0018J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\tJ\u0014\u00103\u001a\u00020\u00182\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f05R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u000e\u0010%\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "currIndex", "isPause", "", "()Z", "setPause", "(Z)V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "nextItemDelay", "", "nextItemDuration", "nextRunnable", "Ljava/lang/Runnable;", "onLoop", "getOnLoop", "setOnLoop", "onLoopRunnable", "random", "Ljava/util/Random;", "animNext", "getItemView", "Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "comment", "nextDelay", "nextDuration", "pause", "restart", "resume", "shakeIndex", "index", "update", "storyComments", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer */
public final class CommentsContainer extends RelativeLayout {
    public static final C43654a siP = new C43654a();
    private final String TAG;
    boolean cAY;
    private int eUk;
    private Random random;
    private final ArrayList<C39889a> seM;
    private long siJ;
    private long siK;
    private C31214a<C37091y> siL;
    private C31214a<C37091y> siM;
    private final Runnable siN;
    private final Runnable siO;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$b */
    static final class C13853b implements Runnable {
        final /* synthetic */ C39889a sfO;
        final /* synthetic */ int siE;
        final /* synthetic */ CommentsContainer siQ;
        final /* synthetic */ CommentItemView siR;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$b$1 */
        static final class C138541 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C13853b siS;

            C138541(C13853b c13853b) {
                this.siS = c13853b;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110366);
                C4990ab.m7416i(this.siS.siQ.TAG, "LogStory: comment appear " + this.siS.sfO.rVj);
                if (this.siS.sfO.rVj) {
                    this.siS.sfO.rVj = false;
                }
                if (this.siS.sfO.rVh) {
                    CommentItemView commentItemView = this.siS.siR;
                    View view = commentItemView.iVh;
                    if (view == null) {
                        C25052j.avw("maskView");
                    }
                    Drawable background = view.getBackground();
                    if (background instanceof GradientDrawable) {
                        int color = commentItemView.getResources().getColor(C25738R.color.f11659bb);
                        Context context = commentItemView.getContext();
                        C25052j.m39375o(context, "context");
                        int color2 = context.getResources().getColor(C25738R.color.a1r);
                        ObjectAnimator ofInt = ObjectAnimator.ofInt(background, "color", new int[]{color, color2});
                        ofInt.setEvaluator(new C29341a());
                        if (ofInt != null) {
                            ofInt.setStartDelay(400);
                        }
                        if (ofInt != null) {
                            ofInt.setDuration(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                        }
                        if (ofInt != null) {
                            ofInt.start();
                        }
                    }
                    this.siS.sfO.rVh = false;
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110366);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$b$2 */
        static final class C138552 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C13853b siS;

            C138552(C13853b c13853b) {
                this.siS = c13853b;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110367);
                C4990ab.m7416i(this.siS.siQ.TAG, "LogStory: remove " + this.siS.siR + ' ' + this.siS.siR.getParent());
                this.siS.siQ.removeView(this.siS.siR);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110367);
                return c37091y;
            }
        }

        C13853b(CommentsContainer commentsContainer, CommentItemView commentItemView, C39889a c39889a, int i) {
            this.siQ = commentsContainer;
            this.siR = commentItemView;
            this.sfO = c39889a;
            this.siE = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(110368);
            View maskView = this.siR.getMaskView();
            C43654a c43654a = CommentsContainer.siP;
            Context context = this.siQ.getContext();
            C25052j.m39375o(context, "context");
            C39889a c39889a = this.sfO;
            C25052j.m39376p(context, "context");
            C25052j.m39376p(c39889a, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            int color = context.getResources().getColor(C25738R.color.f11659bb);
            int color2 = context.getResources().getColor(C25738R.color.a1r);
            if (c39889a.rVh) {
                color2 = color;
            }
            float fromDPToPix = (float) C1338a.fromDPToPix(context, 24);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(color2);
            gradientDrawable.setCornerRadius(fromDPToPix);
            maskView.setBackground(gradientDrawable);
            this.siR.setVisibility(0);
            int measuredHeight = this.siR.getMeasuredHeight();
            this.siQ.siK = ((long) C1338a.m2859ao(this.siQ.getContext(), this.siE - this.siQ.getPaddingBottom())) * 9;
            if (this.siQ.siK <= 0) {
                this.siQ.siK = 4000;
            }
            CommentItemView commentItemView = this.siR;
            long a = this.siQ.siK;
            int paddingBottom = this.siQ.getPaddingBottom();
            int i = this.siE - (measuredHeight / 2);
            C31214a c138541 = new C138541(this);
            C31214a c138552 = new C138552(this);
            commentItemView.six = commentItemView.getMeasuredWidth();
            commentItemView.siw = commentItemView.getMeasuredHeight();
            ViewGroup viewGroup = commentItemView.sis;
            if (viewGroup == null) {
                C25052j.avw("contentLayout");
            }
            viewGroup.setVisibility(8);
            LayoutParams layoutParams = commentItemView.getLayoutParams();
            layoutParams.height = commentItemView.siv;
            layoutParams.width = commentItemView.siv;
            commentItemView.setLayoutParams(layoutParams);
            C4990ab.m7416i("MicroMsg.CommentItemView", "LogStory: animation start " + commentItemView.siv + ", " + commentItemView.six + ' ' + commentItemView.siw);
            C31596c c31596c = new C31596c();
            c31596c.AVE = c138541;
            C29340c c29340c = new C29340c(new PointF(0.05f, 0.1f));
            commentItemView.siq = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ValueAnimator valueAnimator = commentItemView.siq;
            if (valueAnimator != null) {
                valueAnimator.setInterpolator(c29340c);
            }
            ValueAnimator valueAnimator2 = commentItemView.siq;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(a);
            }
            valueAnimator = commentItemView.siq;
            if (valueAnimator != null) {
                valueAnimator.addUpdateListener(new C13852e(commentItemView, i, paddingBottom, c31596c, c138552));
            }
            valueAnimator2 = commentItemView.siq;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
            this.siQ.siJ = ((long) (C1338a.m2859ao(this.siQ.getContext(), measuredHeight) + 96)) * 6;
            if (this.siQ.eUk == this.siQ.seM.size() - 1) {
                this.siQ.siJ = this.siQ.siK;
                this.siQ.postDelayed(this.siQ.siO, this.siQ.siJ);
            }
            this.siQ.postDelayed(this.siQ.siN, this.siQ.siJ);
            AppMethodBeat.m2505o(110368);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$c */
    static final class C13856c implements OnClickListener {
        final /* synthetic */ CommentsContainer siQ;

        C13856c(CommentsContainer commentsContainer) {
            this.siQ = commentsContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138894);
            C31214a itemClickListener = this.siQ.getItemClickListener();
            if (itemClickListener != null) {
                itemClickListener.invoke();
                AppMethodBeat.m2505o(138894);
                return;
            }
            AppMethodBeat.m2505o(138894);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$e */
    static final class C13857e implements Runnable {
        final /* synthetic */ CommentsContainer siQ;

        C13857e(CommentsContainer commentsContainer) {
            this.siQ = commentsContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(138895);
            C31214a onLoop = this.siQ.getOnLoop();
            if (onLoop != null) {
                onLoop.invoke();
                AppMethodBeat.m2505o(138895);
                return;
            }
            AppMethodBeat.m2505o(138895);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$d */
    static final class C29342d implements Runnable {
        final /* synthetic */ CommentsContainer siQ;

        C29342d(CommentsContainer commentsContainer) {
            this.siQ = commentsContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(110369);
            CommentsContainer.m78187h(this.siQ);
            AppMethodBeat.m2505o(110369);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer$Companion;", "", "()V", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "context", "Landroid/content/Context;", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$a */
    public static final class C43654a {
        private C43654a() {
        }

        public /* synthetic */ C43654a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(110375);
        AppMethodBeat.m2505o(110375);
    }

    public CommentsContainer(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110373);
        this.TAG = "MicroMsg.CommentsContainer";
        this.seM = new ArrayList();
        this.eUk = -1;
        this.random = new Random();
        this.cAY = true;
        this.siN = new C29342d(this);
        this.siO = new C13857e(this);
        AppMethodBeat.m2505o(110373);
    }

    public CommentsContainer(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110374);
        AppMethodBeat.m2505o(110374);
    }

    public final void setPause(boolean z) {
        this.cAY = z;
    }

    public final C31214a<C37091y> getItemClickListener() {
        return this.siL;
    }

    public final void setItemClickListener(C31214a<C37091y> c31214a) {
        this.siL = c31214a;
    }

    public final C31214a<C37091y> getOnLoop() {
        return this.siM;
    }

    public final void setOnLoop(C31214a<C37091y> c31214a) {
        this.siM = c31214a;
    }

    /* renamed from: dI */
    public final void mo69274dI(List<C39889a> list) {
        AppMethodBeat.m2504i(110370);
        C25052j.m39376p(list, "storyComments");
        this.seM.clear();
        this.seM.addAll(list);
        this.eUk = -1;
        this.siK = 4000;
        AppMethodBeat.m2505o(110370);
    }

    public final void restart() {
        AppMethodBeat.m2504i(138896);
        C4990ab.m7416i(this.TAG, "LogStory: restart ".concat(String.valueOf(this)));
        resume();
        AppMethodBeat.m2505o(138896);
    }

    public final void resume() {
        AppMethodBeat.m2504i(110371);
        C4990ab.m7416i(this.TAG, "LogStory: resume ".concat(String.valueOf(this)));
        this.cAY = false;
        if (this.eUk != 0) {
            removeCallbacks(this.siN);
            removeCallbacks(this.siO);
            removeAllViews();
            this.eUk = -1;
            postDelayed(this.siN, 300);
        }
        AppMethodBeat.m2505o(110371);
    }

    public final void pause() {
        AppMethodBeat.m2504i(110372);
        C4990ab.m7416i(this.TAG, "LogStory: pause ".concat(String.valueOf(this)));
        this.cAY = true;
        removeCallbacks(this.siN);
        removeCallbacks(this.siO);
        removeAllViews();
        this.eUk = -1;
        AppMethodBeat.m2505o(110372);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public static final /* synthetic */ void m78187h(CommentsContainer commentsContainer) {
        AppMethodBeat.m2504i(110376);
        C4990ab.m7416i(commentsContainer.TAG, "LogStory: animNext " + commentsContainer.eUk + ' ' + commentsContainer.cAY + ' ' + commentsContainer.seM.size());
        if (commentsContainer.cAY || commentsContainer.seM.size() <= 0) {
            AppMethodBeat.m2505o(110376);
            return;
        }
        int i;
        CharSequence charSequence;
        SpannableString b;
        Context context;
        SpannableString b2;
        boolean z;
        CommentItemView commentItemView;
        int measuredHeight;
        RelativeLayout.LayoutParams layoutParams;
        commentsContainer.eUk++;
        commentsContainer.eUk %= commentsContainer.seM.size();
        int i2 = commentsContainer.eUk;
        Object obj = commentsContainer.seM.get(i2);
        C25052j.m39375o(obj, "comments[itemIndex]");
        C39889a c39889a = (C39889a) obj;
        LayoutInflater from = LayoutInflater.from(commentsContainer.getContext());
        if (c39889a.rVi) {
            i = 2130970870;
        } else {
            i = 2130970869;
        }
        View inflate = from.inflate(i, commentsContainer, false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        C25052j.m39375o(inflate, "itemView");
        inflate.setLayoutParams(layoutParams2);
        View findViewById = inflate.findViewById(2131828067);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(2131828069);
        C25052j.m39375o(findViewById2, "itemView.findViewById(R.…ry_comment_item_username)");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(2131828070);
        C25052j.m39375o(findViewById3, "itemView.findViewById(R.…ory_comment_item_content)");
        TextView textView2 = (TextView) findViewById3;
        imageView.setClickable(false);
        C40460b.m69437r(imageView, c39889a.cEV);
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        C7616ad aoO = ((C6982j) K).mo15369XM().aoO(c39889a.cEV);
        Context context2 = textView.getContext();
        if (aoO != null) {
            String Oj = aoO.mo16707Oj();
            if (Oj != null) {
                charSequence = Oj;
                b = C44089j.m79293b(context2, charSequence, textView.getTextSize());
                K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                aoO = ((C6982j) K).mo15369XM().aoO(c39889a.toUser);
                context = textView.getContext();
                if (aoO != null) {
                    Oj = aoO.mo16707Oj();
                    if (Oj != null) {
                        charSequence = Oj;
                        b2 = C44089j.m79293b(context, charSequence, textView.getTextSize());
                        if (c39889a.rVm != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            StringBuilder append = new StringBuilder().append(b).append(' ');
                            context2 = textView.getContext();
                            C25052j.m39375o(context2, "fromUser.context");
                            charSequence = append.append(context2.getResources().getString(C25738R.string.f9214t8)).append(' ').append(b2).toString();
                        } else {
                            charSequence = b;
                        }
                        textView.setText(charSequence);
                        if (c39889a.rVi) {
                            textView2.setVisibility(8);
                            C8902b.m16047f(textView);
                        } else {
                            textView2.setText(C44089j.m79293b(textView2.getContext(), (CharSequence) c39889a.content, textView2.getTextSize()));
                        }
                        inflate.setOnClickListener(new C13856c(commentsContainer));
                        commentItemView = (CommentItemView) inflate;
                        measuredHeight = (commentsContainer.getMeasuredHeight() * 2) / 3;
                        C4990ab.m7416i(commentsContainer.TAG, "LogStory: is enhance comment " + c39889a.rVk);
                        commentItemView.setId(i2);
                        commentItemView.setVisibility(4);
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.topMargin = commentsContainer.getMeasuredHeight() - measuredHeight;
                        commentsContainer.addView(commentItemView, layoutParams);
                        commentsContainer.post(new C13853b(commentsContainer, commentItemView, c39889a, measuredHeight));
                        AppMethodBeat.m2505o(110376);
                    }
                }
                charSequence = "";
                b2 = C44089j.m79293b(context, charSequence, textView.getTextSize());
                if (c39889a.rVm != 0) {
                }
                if (z) {
                }
                textView.setText(charSequence);
                if (c39889a.rVi) {
                }
                inflate.setOnClickListener(new C13856c(commentsContainer));
                commentItemView = (CommentItemView) inflate;
                measuredHeight = (commentsContainer.getMeasuredHeight() * 2) / 3;
                C4990ab.m7416i(commentsContainer.TAG, "LogStory: is enhance comment " + c39889a.rVk);
                commentItemView.setId(i2);
                commentItemView.setVisibility(4);
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = commentsContainer.getMeasuredHeight() - measuredHeight;
                commentsContainer.addView(commentItemView, layoutParams);
                commentsContainer.post(new C13853b(commentsContainer, commentItemView, c39889a, measuredHeight));
                AppMethodBeat.m2505o(110376);
            }
        }
        charSequence = "";
        b = C44089j.m79293b(context2, charSequence, textView.getTextSize());
        K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        aoO = ((C6982j) K).mo15369XM().aoO(c39889a.toUser);
        context = textView.getContext();
        if (aoO != null) {
        }
        charSequence = "";
        b2 = C44089j.m79293b(context, charSequence, textView.getTextSize());
        if (c39889a.rVm != 0) {
        }
        if (z) {
        }
        textView.setText(charSequence);
        if (c39889a.rVi) {
        }
        inflate.setOnClickListener(new C13856c(commentsContainer));
        commentItemView = (CommentItemView) inflate;
        measuredHeight = (commentsContainer.getMeasuredHeight() * 2) / 3;
        C4990ab.m7416i(commentsContainer.TAG, "LogStory: is enhance comment " + c39889a.rVk);
        commentItemView.setId(i2);
        commentItemView.setVisibility(4);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = commentsContainer.getMeasuredHeight() - measuredHeight;
        commentsContainer.addView(commentItemView, layoutParams);
        commentsContainer.post(new C13853b(commentsContainer, commentItemView, c39889a, measuredHeight));
        AppMethodBeat.m2505o(110376);
    }
}
