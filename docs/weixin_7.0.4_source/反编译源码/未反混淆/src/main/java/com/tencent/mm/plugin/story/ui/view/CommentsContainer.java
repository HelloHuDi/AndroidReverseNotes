package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010(\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\u0006\u0010.\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u0018J\u0006\u00100\u001a\u00020\u0018J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\tJ\u0014\u00103\u001a\u00020\u00182\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f05R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u000e\u0010%\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "currIndex", "isPause", "", "()Z", "setPause", "(Z)V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "nextItemDelay", "", "nextItemDuration", "nextRunnable", "Ljava/lang/Runnable;", "onLoop", "getOnLoop", "setOnLoop", "onLoopRunnable", "random", "Ljava/util/Random;", "animNext", "getItemView", "Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "comment", "nextDelay", "nextDuration", "pause", "restart", "resume", "shakeIndex", "index", "update", "storyComments", "", "Companion", "plugin-story_release"})
public final class CommentsContainer extends RelativeLayout {
    public static final a siP = new a();
    private final String TAG;
    boolean cAY;
    private int eUk;
    private Random random;
    private final ArrayList<com.tencent.mm.plugin.story.model.b.a> seM;
    private long siJ;
    private long siK;
    private a.f.a.a<y> siL;
    private a.f.a.a<y> siM;
    private final Runnable siN;
    private final Runnable siO;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.story.model.b.a sfO;
        final /* synthetic */ int siE;
        final /* synthetic */ CommentsContainer siQ;
        final /* synthetic */ CommentItemView siR;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$b$1 */
        static final class AnonymousClass1 extends k implements a.f.a.a<y> {
            final /* synthetic */ b siS;

            AnonymousClass1(b bVar) {
                this.siS = bVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110366);
                ab.i(this.siS.siQ.TAG, "LogStory: comment appear " + this.siS.sfO.rVj);
                if (this.siS.sfO.rVj) {
                    this.siS.sfO.rVj = false;
                }
                if (this.siS.sfO.rVh) {
                    CommentItemView commentItemView = this.siS.siR;
                    View view = commentItemView.iVh;
                    if (view == null) {
                        j.avw("maskView");
                    }
                    Drawable background = view.getBackground();
                    if (background instanceof GradientDrawable) {
                        int color = commentItemView.getResources().getColor(R.color.bb);
                        Context context = commentItemView.getContext();
                        j.o(context, "context");
                        int color2 = context.getResources().getColor(R.color.a1r);
                        ObjectAnimator ofInt = ObjectAnimator.ofInt(background, "color", new int[]{color, color2});
                        ofInt.setEvaluator(new com.tencent.mm.plugin.story.ui.view.CommentItemView.a());
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
                y yVar = y.AUy;
                AppMethodBeat.o(110366);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.CommentsContainer$b$2 */
        static final class AnonymousClass2 extends k implements a.f.a.a<y> {
            final /* synthetic */ b siS;

            AnonymousClass2(b bVar) {
                this.siS = bVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110367);
                ab.i(this.siS.siQ.TAG, "LogStory: remove " + this.siS.siR + ' ' + this.siS.siR.getParent());
                this.siS.siQ.removeView(this.siS.siR);
                y yVar = y.AUy;
                AppMethodBeat.o(110367);
                return yVar;
            }
        }

        b(CommentsContainer commentsContainer, CommentItemView commentItemView, com.tencent.mm.plugin.story.model.b.a aVar, int i) {
            this.siQ = commentsContainer;
            this.siR = commentItemView;
            this.sfO = aVar;
            this.siE = i;
        }

        public final void run() {
            AppMethodBeat.i(110368);
            View maskView = this.siR.getMaskView();
            a aVar = CommentsContainer.siP;
            Context context = this.siQ.getContext();
            j.o(context, "context");
            com.tencent.mm.plugin.story.model.b.a aVar2 = this.sfO;
            j.p(context, "context");
            j.p(aVar2, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            int color = context.getResources().getColor(R.color.bb);
            int color2 = context.getResources().getColor(R.color.a1r);
            if (aVar2.rVh) {
                color2 = color;
            }
            float fromDPToPix = (float) com.tencent.mm.bz.a.fromDPToPix(context, 24);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(color2);
            gradientDrawable.setCornerRadius(fromDPToPix);
            maskView.setBackground(gradientDrawable);
            this.siR.setVisibility(0);
            int measuredHeight = this.siR.getMeasuredHeight();
            this.siQ.siK = ((long) com.tencent.mm.bz.a.ao(this.siQ.getContext(), this.siE - this.siQ.getPaddingBottom())) * 9;
            if (this.siQ.siK <= 0) {
                this.siQ.siK = 4000;
            }
            CommentItemView commentItemView = this.siR;
            long a = this.siQ.siK;
            int paddingBottom = this.siQ.getPaddingBottom();
            int i = this.siE - (measuredHeight / 2);
            a.f.a.a anonymousClass1 = new AnonymousClass1(this);
            a.f.a.a anonymousClass2 = new AnonymousClass2(this);
            commentItemView.six = commentItemView.getMeasuredWidth();
            commentItemView.siw = commentItemView.getMeasuredHeight();
            ViewGroup viewGroup = commentItemView.sis;
            if (viewGroup == null) {
                j.avw("contentLayout");
            }
            viewGroup.setVisibility(8);
            LayoutParams layoutParams = commentItemView.getLayoutParams();
            layoutParams.height = commentItemView.siv;
            layoutParams.width = commentItemView.siv;
            commentItemView.setLayoutParams(layoutParams);
            ab.i("MicroMsg.CommentItemView", "LogStory: animation start " + commentItemView.siv + ", " + commentItemView.six + ' ' + commentItemView.siw);
            a.f.b.u.c cVar = new a.f.b.u.c();
            cVar.AVE = anonymousClass1;
            com.tencent.mm.plugin.story.ui.view.CommentItemView.c cVar2 = new com.tencent.mm.plugin.story.ui.view.CommentItemView.c(new PointF(0.05f, 0.1f));
            commentItemView.siq = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ValueAnimator valueAnimator = commentItemView.siq;
            if (valueAnimator != null) {
                valueAnimator.setInterpolator(cVar2);
            }
            ValueAnimator valueAnimator2 = commentItemView.siq;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(a);
            }
            valueAnimator = commentItemView.siq;
            if (valueAnimator != null) {
                valueAnimator.addUpdateListener(new e(commentItemView, i, paddingBottom, cVar, anonymousClass2));
            }
            valueAnimator2 = commentItemView.siq;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
            this.siQ.siJ = ((long) (com.tencent.mm.bz.a.ao(this.siQ.getContext(), measuredHeight) + 96)) * 6;
            if (this.siQ.eUk == this.siQ.seM.size() - 1) {
                this.siQ.siJ = this.siQ.siK;
                this.siQ.postDelayed(this.siQ.siO, this.siQ.siJ);
            }
            this.siQ.postDelayed(this.siQ.siN, this.siQ.siJ);
            AppMethodBeat.o(110368);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ CommentsContainer siQ;

        c(CommentsContainer commentsContainer) {
            this.siQ = commentsContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138894);
            a.f.a.a itemClickListener = this.siQ.getItemClickListener();
            if (itemClickListener != null) {
                itemClickListener.invoke();
                AppMethodBeat.o(138894);
                return;
            }
            AppMethodBeat.o(138894);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ CommentsContainer siQ;

        e(CommentsContainer commentsContainer) {
            this.siQ = commentsContainer;
        }

        public final void run() {
            AppMethodBeat.i(138895);
            a.f.a.a onLoop = this.siQ.getOnLoop();
            if (onLoop != null) {
                onLoop.invoke();
                AppMethodBeat.o(138895);
                return;
            }
            AppMethodBeat.o(138895);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ CommentsContainer siQ;

        d(CommentsContainer commentsContainer) {
            this.siQ = commentsContainer;
        }

        public final void run() {
            AppMethodBeat.i(110369);
            CommentsContainer.h(this.siQ);
            AppMethodBeat.o(110369);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer$Companion;", "", "()V", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "context", "Landroid/content/Context;", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(110375);
        AppMethodBeat.o(110375);
    }

    public CommentsContainer(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110373);
        this.TAG = "MicroMsg.CommentsContainer";
        this.seM = new ArrayList();
        this.eUk = -1;
        this.random = new Random();
        this.cAY = true;
        this.siN = new d(this);
        this.siO = new e(this);
        AppMethodBeat.o(110373);
    }

    public CommentsContainer(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110374);
        AppMethodBeat.o(110374);
    }

    public final void setPause(boolean z) {
        this.cAY = z;
    }

    public final a.f.a.a<y> getItemClickListener() {
        return this.siL;
    }

    public final void setItemClickListener(a.f.a.a<y> aVar) {
        this.siL = aVar;
    }

    public final a.f.a.a<y> getOnLoop() {
        return this.siM;
    }

    public final void setOnLoop(a.f.a.a<y> aVar) {
        this.siM = aVar;
    }

    public final void dI(List<com.tencent.mm.plugin.story.model.b.a> list) {
        AppMethodBeat.i(110370);
        j.p(list, "storyComments");
        this.seM.clear();
        this.seM.addAll(list);
        this.eUk = -1;
        this.siK = 4000;
        AppMethodBeat.o(110370);
    }

    public final void restart() {
        AppMethodBeat.i(138896);
        ab.i(this.TAG, "LogStory: restart ".concat(String.valueOf(this)));
        resume();
        AppMethodBeat.o(138896);
    }

    public final void resume() {
        AppMethodBeat.i(110371);
        ab.i(this.TAG, "LogStory: resume ".concat(String.valueOf(this)));
        this.cAY = false;
        if (this.eUk != 0) {
            removeCallbacks(this.siN);
            removeCallbacks(this.siO);
            removeAllViews();
            this.eUk = -1;
            postDelayed(this.siN, 300);
        }
        AppMethodBeat.o(110371);
    }

    public final void pause() {
        AppMethodBeat.i(110372);
        ab.i(this.TAG, "LogStory: pause ".concat(String.valueOf(this)));
        this.cAY = true;
        removeCallbacks(this.siN);
        removeCallbacks(this.siO);
        removeAllViews();
        this.eUk = -1;
        AppMethodBeat.o(110372);
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
    public static final /* synthetic */ void h(CommentsContainer commentsContainer) {
        AppMethodBeat.i(110376);
        ab.i(commentsContainer.TAG, "LogStory: animNext " + commentsContainer.eUk + ' ' + commentsContainer.cAY + ' ' + commentsContainer.seM.size());
        if (commentsContainer.cAY || commentsContainer.seM.size() <= 0) {
            AppMethodBeat.o(110376);
            return;
        }
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
        int i = commentsContainer.eUk;
        Object obj = commentsContainer.seM.get(i);
        j.o(obj, "comments[itemIndex]");
        com.tencent.mm.plugin.story.model.b.a aVar = (com.tencent.mm.plugin.story.model.b.a) obj;
        View inflate = LayoutInflater.from(commentsContainer.getContext()).inflate(aVar.rVi ? R.layout.ay7 : R.layout.ay6, commentsContainer, false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        j.o(inflate, "itemView");
        inflate.setLayoutParams(layoutParams2);
        View findViewById = inflate.findViewById(R.id.erc);
        j.o(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ere);
        j.o(findViewById2, "itemView.findViewById(R.…ry_comment_item_username)");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.erf);
        j.o(findViewById3, "itemView.findViewById(R.…ory_comment_item_content)");
        TextView textView2 = (TextView) findViewById3;
        imageView.setClickable(false);
        com.tencent.mm.pluginsdk.ui.a.b.r(imageView, aVar.cEV);
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(aVar.cEV);
        Context context2 = textView.getContext();
        if (aoO != null) {
            String Oj = aoO.Oj();
            if (Oj != null) {
                charSequence = Oj;
                b = com.tencent.mm.pluginsdk.ui.e.j.b(context2, charSequence, textView.getTextSize());
                K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(aVar.toUser);
                context = textView.getContext();
                if (aoO != null) {
                    Oj = aoO.Oj();
                    if (Oj != null) {
                        charSequence = Oj;
                        b2 = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, textView.getTextSize());
                        if (aVar.rVm != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            StringBuilder append = new StringBuilder().append(b).append(' ');
                            context2 = textView.getContext();
                            j.o(context2, "fromUser.context");
                            charSequence = append.append(context2.getResources().getString(R.string.t8)).append(' ').append(b2).toString();
                        } else {
                            charSequence = b;
                        }
                        textView.setText(charSequence);
                        if (aVar.rVi) {
                            textView2.setVisibility(8);
                            com.tencent.mm.ab.b.f(textView);
                        } else {
                            textView2.setText(com.tencent.mm.pluginsdk.ui.e.j.b(textView2.getContext(), (CharSequence) aVar.content, textView2.getTextSize()));
                        }
                        inflate.setOnClickListener(new c(commentsContainer));
                        commentItemView = (CommentItemView) inflate;
                        measuredHeight = (commentsContainer.getMeasuredHeight() * 2) / 3;
                        ab.i(commentsContainer.TAG, "LogStory: is enhance comment " + aVar.rVk);
                        commentItemView.setId(i);
                        commentItemView.setVisibility(4);
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.topMargin = commentsContainer.getMeasuredHeight() - measuredHeight;
                        commentsContainer.addView(commentItemView, layoutParams);
                        commentsContainer.post(new b(commentsContainer, commentItemView, aVar, measuredHeight));
                        AppMethodBeat.o(110376);
                    }
                }
                charSequence = "";
                b2 = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, textView.getTextSize());
                if (aVar.rVm != 0) {
                }
                if (z) {
                }
                textView.setText(charSequence);
                if (aVar.rVi) {
                }
                inflate.setOnClickListener(new c(commentsContainer));
                commentItemView = (CommentItemView) inflate;
                measuredHeight = (commentsContainer.getMeasuredHeight() * 2) / 3;
                ab.i(commentsContainer.TAG, "LogStory: is enhance comment " + aVar.rVk);
                commentItemView.setId(i);
                commentItemView.setVisibility(4);
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = commentsContainer.getMeasuredHeight() - measuredHeight;
                commentsContainer.addView(commentItemView, layoutParams);
                commentsContainer.post(new b(commentsContainer, commentItemView, aVar, measuredHeight));
                AppMethodBeat.o(110376);
            }
        }
        charSequence = "";
        b = com.tencent.mm.pluginsdk.ui.e.j.b(context2, charSequence, textView.getTextSize());
        K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(aVar.toUser);
        context = textView.getContext();
        if (aoO != null) {
        }
        charSequence = "";
        b2 = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, textView.getTextSize());
        if (aVar.rVm != 0) {
        }
        if (z) {
        }
        textView.setText(charSequence);
        if (aVar.rVi) {
        }
        inflate.setOnClickListener(new c(commentsContainer));
        commentItemView = (CommentItemView) inflate;
        measuredHeight = (commentsContainer.getMeasuredHeight() * 2) / 3;
        ab.i(commentsContainer.TAG, "LogStory: is enhance comment " + aVar.rVk);
        commentItemView.setId(i);
        commentItemView.setVisibility(4);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = commentsContainer.getMeasuredHeight() - measuredHeight;
        commentsContainer.addView(commentItemView, layoutParams);
        commentsContainer.post(new b(commentsContainer, commentItemView, aVar, measuredHeight));
        AppMethodBeat.o(110376);
    }
}
