package com.tencent.mm.plugin.story.ui.view;

import a.a.t;
import a.f.a.m;
import a.f.a.q;
import a.y;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ak;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 u2\u00020\u00012\u00020\u0002:\u0001uB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010]\u001a\u00020$J\b\u0010^\u001a\u00020$H\u0002J\b\u0010_\u001a\u00020$H\u0016J\b\u0010`\u001a\u00020$H\u0002J\b\u0010a\u001a\u00020#H\u0016J\u0006\u0010b\u001a\u00020$J\u0010\u0010c\u001a\u00020$2\u0006\u0010d\u001a\u00020#H\u0002J\u0006\u0010e\u001a\u00020$J\b\u0010f\u001a\u00020$H\u0002J&\u0010g\u001a\u00020$2\u0006\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u00105\u001a\u00020#J\b\u0010m\u001a\u00020$H\u0016J\b\u0010n\u001a\u00020$H\u0002J\b\u0010o\u001a\u00020$H\u0002J\u0006\u0010p\u001a\u00020$J\u0010\u0010q\u001a\u00020$2\u0006\u0010T\u001a\u00020\nH\u0016J\u0006\u0010r\u001a\u00020$J\u000e\u0010s\u001a\u00020$2\u0006\u0010t\u001a\u00020#R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R&\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R \u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0EX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R.\u0010H\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010G0\u0012j\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010G`\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R7\u0010P\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(T\u0012\u0004\u0012\u00020$\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020ZX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/CommentContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarConfetti", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiManager;", "avatarConfettiIndex", "avatarGenerator", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiGenerator;", "avatarMap", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Landroid/graphics/drawable/LayerDrawable;", "Lkotlin/collections/LinkedHashMap;", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentClickHelper", "Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "commentData", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentDialog", "Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "commentHint", "Landroid/widget/TextView;", "commentInputCallback", "Lkotlin/Function3;", "", "", "", "commentInputSuccess", "commentOtherGroup", "Landroid/view/View;", "commentOthersBubbleIv", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentOthersInputIv", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "commentSelfActionIv", "commentSelfGroup", "contentView", "currState", "generator", "hasConfetti", "hideHintRunnable", "Ljava/lang/Runnable;", "isActive", "isBubbled", "isContact", "isSelf", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "maskView", "outsideClickListener", "Lkotlin/Function0;", "getOutsideClickListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "replyCommentId", "replyIndex", "replyInputCallback", "Lkotlin/Function2;", "saveContent", "", "saveReplyContentCache", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "smallConfetti", "smallGenerator", "stateChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "getStateChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setStateChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "storyId", "", "storyOwner", "toUser", "destroy", "emitClickBubble", "hide", "hideItemContainer", "onBack", "pause", "postBubble", "isBtn", "resume", "saveReplyContent", "setup", "comment", "scene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "show", "showBubbleHint", "showItemContainer", "switchImageMode", "switchState", "switchVideoMode", "toggleActiveState", "active", "Companion", "plugin-story_release"})
public final class StoryCommentView extends RelativeLayout {
    private static final String TAG = TAG;
    private static final int[] sjN = new int[]{-372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008};
    public static final a sjO = new a();
    private final View contentView;
    public boolean csi;
    private String cvF;
    public boolean czr;
    private int fnH;
    private final View iVh;
    private final Runnable lmq;
    public long rUJ;
    public String rVl;
    public int rVm;
    private final RecyclerView seK;
    public boolean sjA;
    private c sjB;
    private boolean sjC;
    public CharSequence sjD;
    private final com.tencent.mm.plugin.luckymoney.particles.b sjE;
    private final com.tencent.mm.plugin.luckymoney.particles.b sjF;
    private com.tencent.mm.plugin.luckymoney.particles.b sjG;
    private boolean sjH;
    private int sjI;
    private final LinkedHashMap<com.tencent.mm.plugin.story.model.b.a, LayerDrawable> sjJ;
    public final h sjK;
    private a.f.a.b<? super Integer, y> sjL;
    private a.f.a.a<Boolean> sjM;
    public final CommentsContainer sjq;
    public final com.tencent.mm.plugin.story.ui.a.f sjr;
    private final TextView sjs;
    private final StoryCommentBubbleView sjt;
    private final StoryCommentBubbleView sju;
    private final StoryCommentBubbleView sjv;
    public final View sjw;
    public final View sjx;
    public boolean sjy;
    public com.tencent.mm.plugin.story.model.d.f sjz;
    public LinkedHashMap<String, CharSequence> srA;
    private final q<String, Boolean, Boolean, y> sry;
    private int tBo;
    private final m<com.tencent.mm.plugin.story.model.b.a, Boolean, y> tBp;
    public String toUser;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView$Companion;", "", "()V", "ColorArray", "", "getColorArray", "()[I", "TAG", "", "TypeAll", "", "TypeReply", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class c extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ StoryCommentView sjP;

        public c(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(139102);
            ab.i(StoryCommentView.TAG, "itemContainer.onLoop callback currState:" + this.sjP.fnH + ", itemContainer.isPause:" + this.sjP.sjq.cAY + ' ' + this.sjP.sjq);
            this.sjP.sjq.dI(this.sjP.sjz.rrj);
            if (this.sjP.fnH == 2 && !this.sjP.sjq.cAY) {
                this.sjP.sjq.setOnLoop(null);
                this.sjP.sjq.pause();
                this.sjP.sjq.restart();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(139102);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class h implements OnDismissListener {
        final /* synthetic */ StoryCommentView sjP;

        h(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(139104);
            if (!this.sjP.sjC) {
                StoryCommentView.p(this.sjP);
            }
            this.sjP.oE(2);
            c o = this.sjP.sjB;
            if (o != null) {
                StoryCommentInputView storyCommentInputView = o.spp;
                if (storyCommentInputView != null) {
                    storyCommentInputView.destroy();
                    AppMethodBeat.o(139104);
                    return;
                }
            }
            AppMethodBeat.o(139104);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        i(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(110422);
            this.sjP.seK.setVisibility(8);
            this.sjP.seK.setAlpha(1.0f);
            AppMethodBeat.o(110422);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class j implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        j(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(138920);
            this.sjP.sjq.pause();
            this.sjP.sjq.setAlpha(1.0f);
            AppMethodBeat.o(138920);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        l(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(139105);
            this.sjP.sjr.sfG = false;
            ab.i(StoryCommentView.TAG, "LogStory: comment recycler count is " + this.sjP.seK.getChildCount());
            int childCount = this.sjP.seK.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.sjP.seK.getChildAt(i);
                if (childAt instanceof CommentItemView) {
                    CommentItemView commentItemView = (CommentItemView) childAt;
                    int childCount2 = this.sjP.seK.getChildCount() - i;
                    long j = ((long) childCount2) * 30;
                    float fromDPToPix = ((float) (childCount2 + 1)) * ((float) com.tencent.mm.bz.a.fromDPToPix(commentItemView.getContext(), 16));
                    commentItemView.setAlpha(0.0f);
                    commentItemView.setTranslationY(fromDPToPix);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(commentItemView, "translationY", new float[]{fromDPToPix, 0.0f});
                    a.f.b.j.o(ofFloat, "transAnim");
                    ofFloat.setDuration(150);
                    ofFloat.setStartDelay(j);
                    ofFloat.start();
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(commentItemView, "alpha", new float[]{0.0f, 1.0f});
                    a.f.b.j.o(ofFloat2, "alphaAnim");
                    ofFloat2.setDuration(150);
                    ofFloat2.setStartDelay(j);
                    ofFloat2.start();
                }
            }
            AppMethodBeat.o(139105);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
    public static final class k extends a.f.b.k implements a.f.a.b<View, y> {
        final /* synthetic */ StoryCommentView sjP;

        public k(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(139103);
            a.f.b.j.p((View) obj, "it");
            StoryCommentView.a(this.sjP, false);
            y yVar = y.AUy;
            AppMethodBeat.o(139103);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$5 */
    static final class AnonymousClass5 extends a.f.b.k implements m<com.tencent.mm.plugin.story.model.b.a, Boolean, y> {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass5(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(138907);
            com.tencent.mm.plugin.story.model.b.a aVar = (com.tencent.mm.plugin.story.model.b.a) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            a.f.b.j.p(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            if (booleanValue) {
                this.sjP.toUser = aVar.cEV;
                this.sjP.rVm = aVar.rVd;
                this.sjP.tBo = this.sjP.sjz.rrj.indexOf(aVar);
                this.sjP.oE(5);
            } else {
                com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
                com.tencent.mm.plugin.story.model.b.b.b(aVar.rUJ, aVar.rVd, this.sjP.getSessionId(), aVar.content);
                int i = 0;
                for (com.tencent.mm.plugin.story.model.b.a aVar2 : this.sjP.sjz.rrj) {
                    booleanValue = aVar2.rVd == 0 ? bo.isEqual(aVar2.content, aVar.content) : aVar2.rVd == aVar.rVd;
                    if (booleanValue) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    this.sjP.sjz.rrj.remove(i);
                    this.sjP.sjq.dI(this.sjP.sjz.rrj);
                    this.sjP.sjr.dI(this.sjP.sjz.rrj);
                    this.sjP.sjr.ci(i);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138907);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "content", "", "success", "", "isReply", "invoke"})
    static final class b extends a.f.b.k implements q<String, Boolean, Boolean, y> {
        final /* synthetic */ StoryCommentView sjP;

        b(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(3);
        }

        public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(139099);
            String str = (String) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            boolean booleanValue2 = ((Boolean) obj3).booleanValue();
            a.f.b.j.p(str, com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
            this.sjP.sjC = booleanValue;
            if (booleanValue) {
                if (booleanValue2) {
                    this.sjP.srA.remove(this.sjP.toUser);
                } else {
                    this.sjP.sjD = null;
                }
                com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
                long l = this.sjP.rUJ;
                String g = this.sjP.toUser;
                String sessionId = this.sjP.getSessionId();
                String n = this.sjP.rVl;
                int h = this.sjP.rVm;
                a.f.b.j.p(str, com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
                a.f.b.j.p(g, "toUsername");
                a.f.b.j.p(n, "storyOwner");
                ab.i(com.tencent.mm.plugin.story.model.b.b.TAG, "postComment: " + l + ' ' + str + ' ' + g);
                this.sjP.sjz.rrj.add(com.tencent.mm.plugin.story.model.b.b.a(l, g, str, false, sessionId, n, h));
                this.sjP.sjq.dI(this.sjP.sjz.rrj);
                this.sjP.sjq.restart();
            }
            c o = this.sjP.sjB;
            if (o != null) {
                o.dismiss();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(139099);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$1 */
    static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass1(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138903);
            this.sjP.oE(3);
            y yVar = y.AUy;
            AppMethodBeat.o(138903);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$3 */
    static final class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass3(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.i(138905);
            h m = this.sjP.sjK;
            m.isRecording = true;
            m.skt++;
            if (!((m.skt == 1 && m.skr == null && m.sks == null) || ((m.skt == 2 && m.sks == null) || m.skt == 3))) {
                z = false;
            }
            if (z) {
                m.cCq();
            }
            al.af(m.skv);
            al.n(m.skv, m.sku);
            AppMethodBeat.o(138905);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$4 */
    static final class AnonymousClass4 implements OnLongClickListener {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass4(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(138906);
            if (this.sjP.fnH == 3) {
                AppMethodBeat.o(138906);
                return false;
            }
            a.f.a.a outsideClickListener = this.sjP.getOutsideClickListener();
            if (outsideClickListener != null) {
                Boolean bool = (Boolean) outsideClickListener.invoke();
                if (bool != null) {
                    boolean booleanValue = bool.booleanValue();
                    AppMethodBeat.o(138906);
                    return booleanValue;
                }
            }
            AppMethodBeat.o(138906);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$10 */
    static final class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass10(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110412);
            if (!this.sjP.sjz.rrj.isEmpty()) {
                com.tencent.mm.plugin.story.g.h hVar;
                if (this.sjP.fnH == 3) {
                    this.sjP.oE(2);
                    hVar = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.EX(1);
                    AppMethodBeat.o(110412);
                    return;
                }
                this.sjP.oE(3);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.EX(2);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAw().bE(4);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAw().fz(String.valueOf(this.sjP.rUJ));
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAx();
            }
            AppMethodBeat.o(110412);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$11 */
    static final class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass11(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138913);
            ab.i(StoryCommentView.TAG, "CommentBubble click");
            StoryCommentView.a(this.sjP, true);
            AppMethodBeat.o(138913);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$12 */
    static final class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass12(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138914);
            ab.i(StoryCommentView.TAG, "commentEditGroup click");
            this.sjP.oE(1);
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EX(8);
            AppMethodBeat.o(138914);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
    static final class d extends a.f.b.k implements m<com.tencent.mm.plugin.story.model.b.a, Boolean, y> {
        final /* synthetic */ StoryCommentView sjP;

        d(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(139100);
            com.tencent.mm.plugin.story.model.b.a aVar = (com.tencent.mm.plugin.story.model.b.a) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            a.f.b.j.p(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            c o;
            if (booleanValue) {
                StoryCommentView.p(this.sjP);
                this.sjP.toUser = aVar.cEV;
                this.sjP.rVm = aVar.rVd;
                o = this.sjP.sjB;
                if (o != null) {
                    StoryCommentInputView storyCommentInputView = o.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.e((CharSequence) this.sjP.srA.get(this.sjP.toUser), this.sjP.toUser);
                    }
                }
            } else {
                com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
                com.tencent.mm.plugin.story.model.b.b.b(aVar.rUJ, aVar.rVd, this.sjP.getSessionId(), aVar.content);
                int i = 0;
                for (com.tencent.mm.plugin.story.model.b.a aVar2 : this.sjP.sjz.rrj) {
                    booleanValue = aVar2.rVd == 0 ? bo.isEqual(aVar2.content, aVar.content) : aVar2.rVd == aVar.rVd;
                    if (booleanValue) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    this.sjP.sjz.rrj.remove(i);
                    this.sjP.sjq.dI(this.sjP.sjz.rrj);
                    o = this.sjP.sjB;
                    if (o != null) {
                        StoryCommentInputView storyCommentInputView2 = o.spp;
                        if (storyCommentInputView2 != null) {
                            storyCommentInputView2.ge(this.sjP.sjz.rrj);
                        }
                    }
                    o = this.sjP.sjB;
                    if (o != null) {
                        StoryCommentInputView storyCommentInputView3 = o.spp;
                        if (storyCommentInputView3 != null) {
                            storyCommentInputView3.sjr.ci(i);
                        }
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(139100);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ StoryCommentView sjP;
        final /* synthetic */ com.tencent.mm.plugin.story.model.d.f tBq;

        public e(StoryCommentView storyCommentView, com.tencent.mm.plugin.story.model.d.f fVar) {
            this.sjP = storyCommentView;
            this.tBq = fVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Object obj;
            boolean z;
            AppMethodBeat.i(139101);
            com.tencent.mm.plugin.story.model.d.f fVar = this.tBq;
            Iterable<com.tencent.mm.plugin.story.model.b.a> iterable = this.sjP.sjz.rrj;
            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                for (com.tencent.mm.plugin.story.model.b.a aVar : iterable) {
                    if (aVar.rVh) {
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                if (this.sjP.sjz.rrj.isEmpty()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    z = true;
                    fVar.rVh = z;
                    if (this.tBq.rVh) {
                        this.sjP.oE(2);
                        AppMethodBeat.o(139101);
                        return;
                    }
                    this.sjP.oE(3);
                    this.sjP.seK.getLayoutManager().bY(this.tBq.rrj.size() - 1);
                    AppMethodBeat.o(139101);
                    return;
                }
            }
            z = false;
            fVar = fVar;
            fVar.rVh = z;
            if (this.tBq.rVh) {
            }
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class f implements OnDismissListener {
        final /* synthetic */ StoryCommentView sjP;

        f(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            c o;
            StoryCommentInputView storyCommentInputView;
            AppMethodBeat.i(110419);
            this.sjP.oE(2);
            if (!this.sjP.sjC) {
                CharSequence content;
                StoryCommentView storyCommentView = this.sjP;
                o = this.sjP.sjB;
                if (o != null) {
                    storyCommentInputView = o.spp;
                    if (storyCommentInputView != null) {
                        content = storyCommentInputView.getContent();
                        storyCommentView.sjD = content;
                    }
                }
                content = null;
                storyCommentView.sjD = content;
            }
            o = this.sjP.sjB;
            if (o != null) {
                storyCommentInputView = o.spp;
                if (storyCommentInputView != null) {
                    storyCommentInputView.destroy();
                    AppMethodBeat.o(110419);
                    return;
                }
            }
            AppMethodBeat.o(110419);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        g(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(110420);
            this.sjP.seK.setVisibility(8);
            this.sjP.seK.setAlpha(1.0f);
            AppMethodBeat.o(110420);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$2 */
    static final class AnonymousClass2 extends a.f.b.k implements a.f.a.b<View, y> {
        final /* synthetic */ StoryCommentView sjP;

        AnonymousClass2(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(138904);
            a.f.b.j.p((View) obj, "it");
            if (this.sjP.fnH == 3) {
                this.sjP.oE(2);
            } else {
                a.f.a.a outsideClickListener = this.sjP.getOutsideClickListener();
                if (outsideClickListener != null) {
                    outsideClickListener.invoke();
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138904);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$9 */
    static final class AnonymousClass9 implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$9$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ AnonymousClass9 sjR;

            AnonymousClass1(AnonymousClass9 anonymousClass9) {
                this.sjR = anonymousClass9;
            }

            public final void run() {
                AppMethodBeat.i(138911);
                this.sjR.sjP.sjs.setVisibility(8);
                AppMethodBeat.o(138911);
            }
        }

        AnonymousClass9(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(138912);
            this.sjP.sjs.animate().cancel();
            this.sjP.sjs.animate().alpha(0.0f).withEndAction(new AnonymousClass1(this)).start();
            AppMethodBeat.o(138912);
        }
    }

    public StoryCommentView(final Context context, AttributeSet attributeSet, int i) {
        a.f.b.j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110434);
        this.rVl = "";
        this.sjz = new com.tencent.mm.plugin.story.model.d.f();
        this.fnH = 2;
        this.srA = new LinkedHashMap();
        this.sjH = true;
        this.toUser = "";
        this.tBo = -1;
        this.sjJ = new LinkedHashMap();
        View.inflate(context, R.layout.aya, this);
        View findViewById = findViewById(R.id.erq);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_comment_item_container)");
        this.sjq = (CommentsContainer) findViewById;
        findViewById = findViewById(R.id.erm);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_comment_recycler)");
        this.seK = (RecyclerView) findViewById;
        findViewById = findViewById(R.id.ero);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_comment_mask_view)");
        this.iVh = findViewById;
        findViewById = findViewById(R.id.erx);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_comment_hint)");
        this.sjs = (TextView) findViewById;
        findViewById = findViewById(R.id.ern);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_comment_root_view)");
        this.contentView = findViewById;
        findViewById = findViewById(R.id.erw);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_comment_self_bubble_icon)");
        this.sjt = (StoryCommentBubbleView) findViewById;
        findViewById = findViewById(R.id.ert);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_…mment_others_bubble_icon)");
        this.sju = (StoryCommentBubbleView) findViewById;
        findViewById = findViewById(R.id.eru);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_…ment_others_comment_icon)");
        this.sjv = (StoryCommentBubbleView) findViewById;
        findViewById = findViewById(R.id.erv);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_comment_self_action_group)");
        this.sjw = findViewById;
        findViewById = findViewById(R.id.ers);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_…ment_others_action_group)");
        this.sjx = findViewById;
        com.tencent.mm.ab.b.f(this.sjs);
        this.iVh.setVisibility(8);
        this.sjq.setItemClickListener(new AnonymousClass1(this));
        this.sjt.setImageDrawable(ah.f(context, R.raw.icons_filled_chats, -1));
        this.sjv.setImageDrawable(ah.f(context, R.raw.icons_filled_chats, -1));
        this.sjr = new com.tencent.mm.plugin.story.ui.a.f();
        this.seK.setLayoutManager(new LinearLayoutManager());
        this.seK.setAdapter(this.sjr);
        this.seK.setVisibility(8);
        this.seK.setFocusable(false);
        this.sjr.sfI = new AnonymousClass5(this);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.ap4);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 48);
        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, fromDPToPix, fromDPToPix, true);
        this.sjE = new com.tencent.mm.plugin.luckymoney.particles.b() {
            public final /* synthetic */ com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
                AppMethodBeat.i(138908);
                Bitmap bitmap = createScaledBitmap;
                a.f.b.j.o(bitmap, "scaled");
                com.tencent.mm.plugin.luckymoney.particles.a.b bVar = new b(bitmap);
                AppMethodBeat.o(138908);
                return bVar;
            }
        };
        this.sjF = new com.tencent.mm.plugin.luckymoney.particles.b() {
            public final /* synthetic */ com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
                AppMethodBeat.i(138909);
                Bitmap bitmap = createScaledBitmap;
                a.f.b.j.o(bitmap, "scaled");
                com.tencent.mm.plugin.luckymoney.particles.a.b dVar = new d(bitmap);
                AppMethodBeat.o(138909);
                return dVar;
            }
        };
        this.sjG = new com.tencent.mm.plugin.luckymoney.particles.b(this) {
            final /* synthetic */ StoryCommentView sjP;

            public final /* synthetic */ com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
                Object obj;
                AppMethodBeat.i(138910);
                int size = this.sjP.sjJ.size();
                StoryCommentView storyCommentView = this.sjP;
                storyCommentView.sjI = storyCommentView.sjI % size;
                Set entrySet = this.sjP.sjJ.entrySet();
                a.f.b.j.o(entrySet, "avatarMap.entries");
                Iterable iterable = entrySet;
                int j = this.sjP.sjI;
                a.f.b.j.p(iterable, "receiver$0");
                if (iterable instanceof List) {
                    obj = ((List) iterable).get(j);
                } else {
                    a.f.a.b bVar = new a.a.t.b(j);
                    a.f.b.j.p(iterable, "receiver$0");
                    a.f.b.j.p(bVar, "defaultValue");
                    if (iterable instanceof List) {
                        List list = (List) iterable;
                        obj = (j < 0 || j > a.a.l.fH(list)) ? bVar.am(Integer.valueOf(j)) : list.get(j);
                    } else {
                        if (j >= 0) {
                            size = 0;
                            for (Object next : iterable) {
                                int i = size + 1;
                                if (j == size) {
                                    obj = next;
                                    break;
                                }
                                size = i;
                            }
                        }
                        obj = bVar.am(Integer.valueOf(j));
                    }
                }
                a.f.b.j.o(obj, "avatarMap.entries.elementAt(avatarConfettiIndex)");
                Entry entry = (Entry) obj;
                boolean z = ((com.tencent.mm.plugin.story.model.b.a) entry.getKey()).rVh;
                Object value = entry.getValue();
                a.f.b.j.o(value, "entry.value");
                LayerDrawable layerDrawable = (LayerDrawable) value;
                if (z) {
                    layerDrawable.getDrawable(0).setColorFilter(context.getResources().getColor(R.color.bb), Mode.SRC_ATOP);
                    ((com.tencent.mm.plugin.story.model.b.a) entry.getKey()).rVh = false;
                } else {
                    layerDrawable.getDrawable(0).setColorFilter(context.getResources().getColor(R.color.a1r), Mode.SRC_ATOP);
                }
                StoryCommentView storyCommentView2 = this.sjP;
                storyCommentView2.sjI = storyCommentView2.sjI + 1;
                com.tencent.mm.plugin.luckymoney.particles.a.b aVar = new a(layerDrawable);
                AppMethodBeat.o(138910);
                return aVar;
            }
        };
        this.lmq = new AnonymousClass9(this);
        this.sjt.setOnClickListener(new AnonymousClass10(this));
        this.sju.setOnClickListener(new AnonymousClass11(this));
        this.sjv.setOnClickListener(new AnonymousClass12(this));
        this.sjK = new h(this);
        this.sjK.skq = new AnonymousClass2(this);
        setOnClickListener(new AnonymousClass3(this));
        setOnLongClickListener(new AnonymousClass4(this));
        int fr = ak.fr(context);
        ab.i(TAG, "LogStory: navigationHeight ".concat(String.valueOf(fr)));
        findViewById(R.id.erp).setPadding(0, 0, 0, fr);
        this.sry = new b(this);
        this.tBp = new d(this);
        AppMethodBeat.o(110434);
    }

    public StoryCommentView(Context context, AttributeSet attributeSet) {
        a.f.b.j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110435);
        AppMethodBeat.o(110435);
    }

    public StoryCommentView(Context context) {
        a.f.b.j.p(context, "context");
        this(context, null);
        AppMethodBeat.i(110436);
        AppMethodBeat.o(110436);
    }

    static {
        AppMethodBeat.i(110437);
        AppMethodBeat.o(110437);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final void setSessionId(String str) {
        this.cvF = str;
    }

    public final a.f.a.b<Integer, y> getStateChangeCallback() {
        return this.sjL;
    }

    public final void setStateChangeCallback(a.f.a.b<? super Integer, y> bVar) {
        this.sjL = bVar;
    }

    public final a.f.a.a<Boolean> getOutsideClickListener() {
        return this.sjM;
    }

    public final void setOutsideClickListener(a.f.a.a<Boolean> aVar) {
        this.sjM = aVar;
    }

    public final void show() {
        AppMethodBeat.i(110429);
        this.contentView.setVisibility(0);
        if (this.contentView.getVisibility() == 0 && this.fnH == 2 && this.sjq.cAY) {
            this.sjz.rVh = false;
            this.sjq.resume();
            if (!this.czr && this.sjy) {
                com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
                a.f.b.j.o(RP, "storage()");
                int i = RP.Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_STORY_BUBBLE_COUNT_INT, 0);
                if (i < 3) {
                    com.tencent.mm.kernel.e RP2 = com.tencent.mm.kernel.g.RP();
                    a.f.b.j.o(RP2, "storage()");
                    RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(i + 1));
                    this.sjs.animate().cancel();
                    this.sjs.setVisibility(0);
                    this.sjs.animate().alpha(1.0f).start();
                    al.af(this.lmq);
                    al.n(this.lmq, 3000);
                }
            }
        }
        AppMethodBeat.o(110429);
    }

    public final boolean Ab() {
        AppMethodBeat.i(110426);
        if (this.fnH == 1) {
            oE(2);
            AppMethodBeat.o(110426);
            return true;
        } else if (this.fnH == 3) {
            oE(2);
            AppMethodBeat.o(110426);
            return true;
        } else if (this.fnH == 5) {
            oE(2);
            AppMethodBeat.o(110426);
            return true;
        } else {
            AppMethodBeat.o(110426);
            return false;
        }
    }

    public static void resume() {
        AppMethodBeat.i(110427);
        ab.i(TAG, "LogStory: resume");
        AppMethodBeat.o(110427);
    }

    public static void pause() {
        AppMethodBeat.i(110428);
        ab.i(TAG, "LogStory: pause");
        AppMethodBeat.o(110428);
    }

    public final void destroy() {
        AppMethodBeat.i(138921);
        this.sjq.pause();
        this.sjJ.clear();
        this.srA.clear();
        AppMethodBeat.o(138921);
    }

    public final void oE(int i) {
        AppMethodBeat.i(110430);
        ab.i(TAG, "switchState " + i + ' ' + bo.dpG());
        if (this.fnH == i) {
            AppMethodBeat.o(110430);
            return;
        }
        this.fnH = i;
        Context context;
        c cVar;
        StoryCommentInputView storyCommentInputView;
        c cVar2;
        switch (i) {
            case 1:
                this.toUser = this.rVl;
                this.rVm = 0;
                this.sjq.pause();
                this.seK.setVisibility(8);
                this.sjq.setVisibility(8);
                context = getContext();
                a.f.b.j.o(context, "context");
                this.sjB = new c(context);
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setHostStory(this.sjr.sfH);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setReply(false);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setCommentInputCallback(this.sry);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        StoryCommentInputView.a(storyCommentInputView, this.sjD);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.rh(false);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    cVar.show();
                }
                this.sjC = false;
                cVar2 = this.sjB;
                if (cVar2 != null) {
                    cVar2.setOnDismissListener(new f(this));
                    break;
                }
                break;
            case 2:
                this.toUser = this.rVl;
                this.rVm = 0;
                if (this.czr) {
                    this.sjw.setVisibility(0);
                    this.sjx.setVisibility(8);
                } else {
                    this.sjw.setVisibility(8);
                    this.sjx.setVisibility(0);
                }
                this.iVh.animate().cancel();
                this.iVh.animate().alpha(0.0f).start();
                this.seK.animate().alpha(0.0f).withEndAction(new i(this)).start();
                this.sjq.animate().cancel();
                this.sjq.setVisibility(0);
                this.sjq.setAlpha(1.0f);
                if (this.csi) {
                    this.sjq.resume();
                }
                cVar = this.sjB;
                if (cVar != null) {
                    cVar.dismiss();
                    break;
                }
                break;
            case 3:
                this.toUser = this.rVl;
                this.rVm = 0;
                this.iVh.animate().cancel();
                this.iVh.setVisibility(0);
                this.iVh.animate().alpha(1.0f).start();
                this.sjq.animate().alpha(0.0f).withEndAction(new j(this)).start();
                this.seK.animate().cancel();
                this.seK.setVisibility(0);
                this.seK.setAlpha(1.0f);
                this.sjr.dI(this.sjz.rrj);
                this.sjr.notifyDataSetChanged();
                this.sjr.sfG = true;
                this.seK.setAdapter(this.sjr);
                this.seK.bY(this.sjz.rrj.size() - 1);
                this.seK.post(new l(this));
                break;
            case 5:
                StoryCommentInputView storyCommentInputView2;
                this.sjq.pause();
                this.sjq.setVisibility(8);
                this.seK.animate().alpha(0.0f).withEndAction(new g(this)).start();
                context = getContext();
                a.f.b.j.o(context, "context");
                this.sjB = new c(context);
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setHostStory(this.sjr.sfH);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setReply(true);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setCommentInputCallback(this.sry);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setCommentReplyCallback(this.tBp);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView2 = cVar.spp;
                    if (storyCommentInputView2 != null) {
                        storyCommentInputView2.e((CharSequence) this.srA.get(this.toUser), this.toUser);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.rh(true);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView2 = cVar.spp;
                    if (storyCommentInputView2 != null) {
                        storyCommentInputView2.ge(this.sjz.rrj);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.sjr.notifyDataSetChanged();
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    storyCommentInputView = cVar.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.bY(this.tBo);
                    }
                }
                cVar = this.sjB;
                if (cVar != null) {
                    cVar.show();
                }
                this.sjC = false;
                cVar2 = this.sjB;
                if (cVar2 != null) {
                    cVar2.setOnDismissListener(new h(this));
                    break;
                }
                break;
        }
        a.f.a.b bVar = this.sjL;
        if (bVar != null) {
            bVar.am(Integer.valueOf(this.fnH));
            AppMethodBeat.o(110430);
            return;
        }
        AppMethodBeat.o(110430);
    }

    public final void lL(boolean z) {
        AppMethodBeat.i(138922);
        ab.i(TAG, "toggleActiveState ".concat(String.valueOf(z)));
        if (z) {
            show();
            AppMethodBeat.o(138922);
            return;
        }
        hide();
        AppMethodBeat.o(138922);
    }

    public final void hide() {
        AppMethodBeat.i(110425);
        this.sjq.pause();
        this.contentView.setVisibility(8);
        AppMethodBeat.o(110425);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void p(StoryCommentView storyCommentView) {
        Object content;
        AppMethodBeat.i(139106);
        Map map = storyCommentView.srA;
        String str = storyCommentView.toUser;
        c cVar = storyCommentView.sjB;
        if (cVar != null) {
            StoryCommentInputView storyCommentInputView = cVar.spp;
            if (storyCommentInputView != null) {
                content = storyCommentInputView.getContent();
                map.put(str, content);
                if (storyCommentView.srA.size() > 3) {
                    LinkedHashMap linkedHashMap = storyCommentView.srA;
                    Set keySet = storyCommentView.srA.keySet();
                    a.f.b.j.o(keySet, "saveReplyContentCache.keys");
                    Object obj = (String) t.f(keySet);
                    if (obj == null) {
                        obj = "";
                    }
                    linkedHashMap.remove(obj);
                }
                AppMethodBeat.o(139106);
            }
        }
        content = null;
        map.put(str, content);
        if (storyCommentView.srA.size() > 3) {
        }
        AppMethodBeat.o(139106);
    }
}
