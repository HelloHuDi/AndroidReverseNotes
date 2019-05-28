package com.tencent.p177mm.plugin.story.p536ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.luckymoney.particles.C34448b;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p533d.C43639f;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C13817f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p001a.C25035t.C7990b;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 u2\u00020\u00012\u00020\u0002:\u0001uB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010]\u001a\u00020$J\b\u0010^\u001a\u00020$H\u0002J\b\u0010_\u001a\u00020$H\u0016J\b\u0010`\u001a\u00020$H\u0002J\b\u0010a\u001a\u00020#H\u0016J\u0006\u0010b\u001a\u00020$J\u0010\u0010c\u001a\u00020$2\u0006\u0010d\u001a\u00020#H\u0002J\u0006\u0010e\u001a\u00020$J\b\u0010f\u001a\u00020$H\u0002J&\u0010g\u001a\u00020$2\u0006\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u00105\u001a\u00020#J\b\u0010m\u001a\u00020$H\u0016J\b\u0010n\u001a\u00020$H\u0002J\b\u0010o\u001a\u00020$H\u0002J\u0006\u0010p\u001a\u00020$J\u0010\u0010q\u001a\u00020$2\u0006\u0010T\u001a\u00020\nH\u0016J\u0006\u0010r\u001a\u00020$J\u000e\u0010s\u001a\u00020$2\u0006\u0010t\u001a\u00020#R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R&\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R \u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0EX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R.\u0010H\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010G0\u0012j\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010G`\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R7\u0010P\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(T\u0012\u0004\u0012\u00020$\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020ZX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/CommentContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarConfetti", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiManager;", "avatarConfettiIndex", "avatarGenerator", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiGenerator;", "avatarMap", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Landroid/graphics/drawable/LayerDrawable;", "Lkotlin/collections/LinkedHashMap;", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentClickHelper", "Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "commentData", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentDialog", "Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "commentHint", "Landroid/widget/TextView;", "commentInputCallback", "Lkotlin/Function3;", "", "", "", "commentInputSuccess", "commentOtherGroup", "Landroid/view/View;", "commentOthersBubbleIv", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentOthersInputIv", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "commentSelfActionIv", "commentSelfGroup", "contentView", "currState", "generator", "hasConfetti", "hideHintRunnable", "Ljava/lang/Runnable;", "isActive", "isBubbled", "isContact", "isSelf", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "maskView", "outsideClickListener", "Lkotlin/Function0;", "getOutsideClickListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "replyCommentId", "replyIndex", "replyInputCallback", "Lkotlin/Function2;", "saveContent", "", "saveReplyContentCache", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "smallConfetti", "smallGenerator", "stateChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "getStateChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setStateChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "storyId", "", "storyOwner", "toUser", "destroy", "emitClickBubble", "hide", "hideItemContainer", "onBack", "pause", "postBubble", "isBtn", "resume", "saveReplyContent", "setup", "comment", "scene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "show", "showBubbleHint", "showItemContainer", "switchImageMode", "switchState", "switchVideoMode", "toggleActiveState", "active", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView */
public final class StoryCommentView extends RelativeLayout {
    private static final String TAG = TAG;
    private static final int[] sjN = new int[]{-372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008};
    public static final C22285a sjO = new C22285a();
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
    private C43662c sjB;
    private boolean sjC;
    public CharSequence sjD;
    private final C34448b sjE;
    private final C34448b sjF;
    private C34448b sjG;
    private boolean sjH;
    private int sjI;
    private final LinkedHashMap<C39889a, LayerDrawable> sjJ;
    public final C22325h sjK;
    private C17126b<? super Integer, C37091y> sjL;
    private C31214a<Boolean> sjM;
    public final CommentsContainer sjq;
    public final C13817f sjr;
    private final TextView sjs;
    private final StoryCommentBubbleView sjt;
    private final StoryCommentBubbleView sju;
    private final StoryCommentBubbleView sjv;
    public final View sjw;
    public final View sjx;
    public boolean sjy;
    public C43639f sjz;
    public LinkedHashMap<String, CharSequence> srA;
    private final C36933q<String, Boolean, Boolean, C37091y> sry;
    private int tBo;
    private final C31591m<C39889a, Boolean, C37091y> tBp;
    public String toUser;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView$Companion;", "", "()V", "ColorArray", "", "getColorArray", "()[I", "TAG", "", "TypeAll", "", "TypeReply", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$a */
    public static final class C22285a {
        private C22285a() {
        }

        public /* synthetic */ C22285a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$c */
    public static final class C22286c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ StoryCommentView sjP;

        public C22286c(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(139102);
            C4990ab.m7416i(StoryCommentView.TAG, "itemContainer.onLoop callback currState:" + this.sjP.fnH + ", itemContainer.isPause:" + this.sjP.sjq.cAY + ' ' + this.sjP.sjq);
            this.sjP.sjq.mo69274dI(this.sjP.sjz.rrj);
            if (this.sjP.fnH == 2 && !this.sjP.sjq.cAY) {
                this.sjP.sjq.setOnLoop(null);
                this.sjP.sjq.pause();
                this.sjP.sjq.restart();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(139102);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$h */
    static final class C22287h implements OnDismissListener {
        final /* synthetic */ StoryCommentView sjP;

        C22287h(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(139104);
            if (!this.sjP.sjC) {
                StoryCommentView.m86825p(this.sjP);
            }
            this.sjP.mo74436oE(2);
            C43662c o = this.sjP.sjB;
            if (o != null) {
                StoryCommentInputView storyCommentInputView = o.spp;
                if (storyCommentInputView != null) {
                    storyCommentInputView.destroy();
                    AppMethodBeat.m2505o(139104);
                    return;
                }
            }
            AppMethodBeat.m2505o(139104);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$i */
    static final class C22288i implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        C22288i(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110422);
            this.sjP.seK.setVisibility(8);
            this.sjP.seK.setAlpha(1.0f);
            AppMethodBeat.m2505o(110422);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$j */
    static final class C22289j implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        C22289j(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.m2504i(138920);
            this.sjP.sjq.pause();
            this.sjP.sjq.setAlpha(1.0f);
            AppMethodBeat.m2505o(138920);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$l */
    static final class C22290l implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        C22290l(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.m2504i(139105);
            this.sjP.sjr.sfG = false;
            C4990ab.m7416i(StoryCommentView.TAG, "LogStory: comment recycler count is " + this.sjP.seK.getChildCount());
            int childCount = this.sjP.seK.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.sjP.seK.getChildAt(i);
                if (childAt instanceof CommentItemView) {
                    CommentItemView commentItemView = (CommentItemView) childAt;
                    int childCount2 = this.sjP.seK.getChildCount() - i;
                    long j = ((long) childCount2) * 30;
                    float fromDPToPix = ((float) (childCount2 + 1)) * ((float) C1338a.fromDPToPix(commentItemView.getContext(), 16));
                    commentItemView.setAlpha(0.0f);
                    commentItemView.setTranslationY(fromDPToPix);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(commentItemView, "translationY", new float[]{fromDPToPix, 0.0f});
                    C25052j.m39375o(ofFloat, "transAnim");
                    ofFloat.setDuration(150);
                    ofFloat.setStartDelay(j);
                    ofFloat.start();
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(commentItemView, "alpha", new float[]{0.0f, 1.0f});
                    C25052j.m39375o(ofFloat2, "alphaAnim");
                    ofFloat2.setDuration(150);
                    ofFloat2.setStartDelay(j);
                    ofFloat2.start();
                }
            }
            AppMethodBeat.m2505o(139105);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$k */
    public static final class C24835k extends C25053k implements C17126b<View, C37091y> {
        final /* synthetic */ StoryCommentView sjP;

        public C24835k(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(139103);
            C25052j.m39376p((View) obj, "it");
            StoryCommentView.m86807a(this.sjP, false);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(139103);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$5 */
    static final class C314395 extends C25053k implements C31591m<C39889a, Boolean, C37091y> {
        final /* synthetic */ StoryCommentView sjP;

        C314395(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(138907);
            C39889a c39889a = (C39889a) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            C25052j.m39376p(c39889a, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            if (booleanValue) {
                this.sjP.toUser = c39889a.cEV;
                this.sjP.rVm = c39889a.rVd;
                this.sjP.tBo = this.sjP.sjz.rrj.indexOf(c39889a);
                this.sjP.mo74436oE(5);
            } else {
                C46279b c46279b = C46279b.rVw;
                C46279b.m86762b(c39889a.rUJ, c39889a.rVd, this.sjP.getSessionId(), c39889a.content);
                int i = 0;
                for (C39889a c39889a2 : this.sjP.sjz.rrj) {
                    booleanValue = c39889a2.rVd == 0 ? C5046bo.isEqual(c39889a2.content, c39889a.content) : c39889a2.rVd == c39889a.rVd;
                    if (booleanValue) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    this.sjP.sjz.rrj.remove(i);
                    this.sjP.sjq.mo69274dI(this.sjP.sjz.rrj);
                    this.sjP.sjr.mo25997dI(this.sjP.sjz.rrj);
                    this.sjP.sjr.mo66318ci(i);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138907);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "content", "", "success", "", "isReply", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$b */
    static final class C31440b extends C25053k implements C36933q<String, Boolean, Boolean, C37091y> {
        final /* synthetic */ StoryCommentView sjP;

        C31440b(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(3);
        }

        /* renamed from: g */
        public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(139099);
            String str = (String) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            boolean booleanValue2 = ((Boolean) obj3).booleanValue();
            C25052j.m39376p(str, C8741b.CONTENT);
            this.sjP.sjC = booleanValue;
            if (booleanValue) {
                if (booleanValue2) {
                    this.sjP.srA.remove(this.sjP.toUser);
                } else {
                    this.sjP.sjD = null;
                }
                C46279b c46279b = C46279b.rVw;
                long l = this.sjP.rUJ;
                String g = this.sjP.toUser;
                String sessionId = this.sjP.getSessionId();
                String n = this.sjP.rVl;
                int h = this.sjP.rVm;
                C25052j.m39376p(str, C8741b.CONTENT);
                C25052j.m39376p(g, "toUsername");
                C25052j.m39376p(n, "storyOwner");
                C4990ab.m7416i(C46279b.TAG, "postComment: " + l + ' ' + str + ' ' + g);
                this.sjP.sjz.rrj.add(C46279b.m86754a(l, g, str, false, sessionId, n, h));
                this.sjP.sjq.mo69274dI(this.sjP.sjz.rrj);
                this.sjP.sjq.restart();
            }
            C43662c o = this.sjP.sjB;
            if (o != null) {
                o.dismiss();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(139099);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$1 */
    static final class C399261 extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ StoryCommentView sjP;

        C399261(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(138903);
            this.sjP.mo74436oE(3);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138903);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$3 */
    static final class C399273 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        C399273(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.m2504i(138905);
            C22325h m = this.sjP.sjK;
            m.isRecording = true;
            m.skt++;
            if (!((m.skt == 1 && m.skr == null && m.sks == null) || ((m.skt == 2 && m.sks == null) || m.skt == 3))) {
                z = false;
            }
            if (z) {
                m.cCq();
            }
            C5004al.m7439af(m.skv);
            C5004al.m7442n(m.skv, m.sku);
            AppMethodBeat.m2505o(138905);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$4 */
    static final class C399284 implements OnLongClickListener {
        final /* synthetic */ StoryCommentView sjP;

        C399284(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(138906);
            if (this.sjP.fnH == 3) {
                AppMethodBeat.m2505o(138906);
                return false;
            }
            C31214a outsideClickListener = this.sjP.getOutsideClickListener();
            if (outsideClickListener != null) {
                Boolean bool = (Boolean) outsideClickListener.invoke();
                if (bool != null) {
                    boolean booleanValue = bool.booleanValue();
                    AppMethodBeat.m2505o(138906);
                    return booleanValue;
                }
            }
            AppMethodBeat.m2505o(138906);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$10 */
    static final class C4365510 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        C4365510(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110412);
            if (!this.sjP.sjz.rrj.isEmpty()) {
                C22212h c22212h;
                if (this.sjP.fnH == 3) {
                    this.sjP.mo74436oE(2);
                    c22212h = C22212h.scu;
                    C22212h.m33888EX(1);
                    AppMethodBeat.m2505o(110412);
                    return;
                }
                this.sjP.mo74436oE(3);
                c22212h = C22212h.scu;
                C22212h.m33888EX(2);
                c22212h = C22212h.scu;
                C22212h.cAw().mo60517bE(4);
                c22212h = C22212h.scu;
                C22212h.cAw().mo60518fz(String.valueOf(this.sjP.rUJ));
                c22212h = C22212h.scu;
                C22212h.cAx();
            }
            AppMethodBeat.m2505o(110412);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$11 */
    static final class C4365611 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        C4365611(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138913);
            C4990ab.m7416i(StoryCommentView.TAG, "CommentBubble click");
            StoryCommentView.m86807a(this.sjP, true);
            AppMethodBeat.m2505o(138913);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$12 */
    static final class C4365712 implements OnClickListener {
        final /* synthetic */ StoryCommentView sjP;

        C4365712(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138914);
            C4990ab.m7416i(StoryCommentView.TAG, "commentEditGroup click");
            this.sjP.mo74436oE(1);
            C22212h c22212h = C22212h.scu;
            C22212h.m33888EX(8);
            AppMethodBeat.m2505o(138914);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$d */
    static final class C43658d extends C25053k implements C31591m<C39889a, Boolean, C37091y> {
        final /* synthetic */ StoryCommentView sjP;

        C43658d(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(139100);
            C39889a c39889a = (C39889a) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            C25052j.m39376p(c39889a, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            C43662c o;
            if (booleanValue) {
                StoryCommentView.m86825p(this.sjP);
                this.sjP.toUser = c39889a.cEV;
                this.sjP.rVm = c39889a.rVd;
                o = this.sjP.sjB;
                if (o != null) {
                    StoryCommentInputView storyCommentInputView = o.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.mo63112e((CharSequence) this.sjP.srA.get(this.sjP.toUser), this.sjP.toUser);
                    }
                }
            } else {
                C46279b c46279b = C46279b.rVw;
                C46279b.m86762b(c39889a.rUJ, c39889a.rVd, this.sjP.getSessionId(), c39889a.content);
                int i = 0;
                for (C39889a c39889a2 : this.sjP.sjz.rrj) {
                    booleanValue = c39889a2.rVd == 0 ? C5046bo.isEqual(c39889a2.content, c39889a.content) : c39889a2.rVd == c39889a.rVd;
                    if (booleanValue) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    this.sjP.sjz.rrj.remove(i);
                    this.sjP.sjq.mo69274dI(this.sjP.sjz.rrj);
                    o = this.sjP.sjB;
                    if (o != null) {
                        StoryCommentInputView storyCommentInputView2 = o.spp;
                        if (storyCommentInputView2 != null) {
                            storyCommentInputView2.mo63113ge(this.sjP.sjz.rrj);
                        }
                    }
                    o = this.sjP.sjB;
                    if (o != null) {
                        StoryCommentInputView storyCommentInputView3 = o.spp;
                        if (storyCommentInputView3 != null) {
                            storyCommentInputView3.sjr.mo66318ci(i);
                        }
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(139100);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$e */
    public static final class C43659e implements Runnable {
        final /* synthetic */ StoryCommentView sjP;
        final /* synthetic */ C43639f tBq;

        public C43659e(StoryCommentView storyCommentView, C43639f c43639f) {
            this.sjP = storyCommentView;
            this.tBq = c43639f;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Object obj;
            boolean z;
            AppMethodBeat.m2504i(139101);
            C43639f c43639f = this.tBq;
            Iterable<C39889a> iterable = this.sjP.sjz.rrj;
            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                for (C39889a c39889a : iterable) {
                    if (c39889a.rVh) {
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
                    c43639f.rVh = z;
                    if (this.tBq.rVh) {
                        this.sjP.mo74436oE(2);
                        AppMethodBeat.m2505o(139101);
                        return;
                    }
                    this.sjP.mo74436oE(3);
                    this.sjP.seK.getLayoutManager().mo1762bY(this.tBq.rrj.size() - 1);
                    AppMethodBeat.m2505o(139101);
                    return;
                }
            }
            z = false;
            c43639f = c43639f;
            c43639f.rVh = z;
            if (this.tBq.rVh) {
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$f */
    static final class C43660f implements OnDismissListener {
        final /* synthetic */ StoryCommentView sjP;

        C43660f(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C43662c o;
            StoryCommentInputView storyCommentInputView;
            AppMethodBeat.m2504i(110419);
            this.sjP.mo74436oE(2);
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
                    AppMethodBeat.m2505o(110419);
                    return;
                }
            }
            AppMethodBeat.m2505o(110419);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$g */
    static final class C43661g implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        C43661g(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110420);
            this.sjP.seK.setVisibility(8);
            this.sjP.seK.setAlpha(1.0f);
            AppMethodBeat.m2505o(110420);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$2 */
    static final class C462862 extends C25053k implements C17126b<View, C37091y> {
        final /* synthetic */ StoryCommentView sjP;

        C462862(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(138904);
            C25052j.m39376p((View) obj, "it");
            if (this.sjP.fnH == 3) {
                this.sjP.mo74436oE(2);
            } else {
                C31214a outsideClickListener = this.sjP.getOutsideClickListener();
                if (outsideClickListener != null) {
                    outsideClickListener.invoke();
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138904);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$9 */
    static final class C462879 implements Runnable {
        final /* synthetic */ StoryCommentView sjP;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentView$9$1 */
        static final class C222841 implements Runnable {
            final /* synthetic */ C462879 sjR;

            C222841(C462879 c462879) {
                this.sjR = c462879;
            }

            public final void run() {
                AppMethodBeat.m2504i(138911);
                this.sjR.sjP.sjs.setVisibility(8);
                AppMethodBeat.m2505o(138911);
            }
        }

        C462879(StoryCommentView storyCommentView) {
            this.sjP = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.m2504i(138912);
            this.sjP.sjs.animate().cancel();
            this.sjP.sjs.animate().alpha(0.0f).withEndAction(new C222841(this)).start();
            AppMethodBeat.m2505o(138912);
        }
    }

    public StoryCommentView(final Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110434);
        this.rVl = "";
        this.sjz = new C43639f();
        this.fnH = 2;
        this.srA = new LinkedHashMap();
        this.sjH = true;
        this.toUser = "";
        this.tBo = -1;
        this.sjJ = new LinkedHashMap();
        View.inflate(context, 2130970874, this);
        View findViewById = findViewById(2131828081);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_item_container)");
        this.sjq = (CommentsContainer) findViewById;
        findViewById = findViewById(2131828077);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_recycler)");
        this.seK = (RecyclerView) findViewById;
        findViewById = findViewById(2131828079);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_mask_view)");
        this.iVh = findViewById;
        findViewById = findViewById(2131828088);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_hint)");
        this.sjs = (TextView) findViewById;
        findViewById = findViewById(2131828078);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_root_view)");
        this.contentView = findViewById;
        findViewById = findViewById(2131828087);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_self_bubble_icon)");
        this.sjt = (StoryCommentBubbleView) findViewById;
        findViewById = findViewById(2131828084);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…mment_others_bubble_icon)");
        this.sju = (StoryCommentBubbleView) findViewById;
        findViewById = findViewById(2131828085);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…ment_others_comment_icon)");
        this.sjv = (StoryCommentBubbleView) findViewById;
        findViewById = findViewById(2131828086);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_self_action_group)");
        this.sjw = findViewById;
        findViewById = findViewById(2131828083);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…ment_others_action_group)");
        this.sjx = findViewById;
        C8902b.m16047f(this.sjs);
        this.iVh.setVisibility(8);
        this.sjq.setItemClickListener(new C399261(this));
        this.sjt.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_chats, -1));
        this.sjv.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_chats, -1));
        this.sjr = new C13817f();
        this.seK.setLayoutManager(new LinearLayoutManager());
        this.seK.setAdapter(this.sjr);
        this.seK.setVisibility(8);
        this.seK.setFocusable(false);
        this.sjr.sfI = new C314395(this);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C25738R.drawable.ap4);
        int fromDPToPix = C1338a.fromDPToPix(context, 48);
        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, fromDPToPix, fromDPToPix, true);
        this.sjE = new C34448b() {
            /* renamed from: b */
            public final /* synthetic */ C28430b mo24309b(Random random) {
                AppMethodBeat.m2504i(138908);
                Bitmap bitmap = createScaledBitmap;
                C25052j.m39375o(bitmap, "scaled");
                C28430b c13862b = new C13862b(bitmap);
                AppMethodBeat.m2505o(138908);
                return c13862b;
            }
        };
        this.sjF = new C34448b() {
            /* renamed from: b */
            public final /* synthetic */ C28430b mo24309b(Random random) {
                AppMethodBeat.m2504i(138909);
                Bitmap bitmap = createScaledBitmap;
                C25052j.m39375o(bitmap, "scaled");
                C28430b c39929d = new C39929d(bitmap);
                AppMethodBeat.m2505o(138909);
                return c39929d;
            }
        };
        this.sjG = new C34448b(this) {
            final /* synthetic */ StoryCommentView sjP;

            /* renamed from: b */
            public final /* synthetic */ C28430b mo24309b(Random random) {
                Object obj;
                AppMethodBeat.m2504i(138910);
                int size = this.sjP.sjJ.size();
                StoryCommentView storyCommentView = this.sjP;
                storyCommentView.sjI = storyCommentView.sjI % size;
                Set entrySet = this.sjP.sjJ.entrySet();
                C25052j.m39375o(entrySet, "avatarMap.entries");
                Iterable iterable = entrySet;
                int j = this.sjP.sjI;
                C25052j.m39376p(iterable, "receiver$0");
                if (iterable instanceof List) {
                    obj = ((List) iterable).get(j);
                } else {
                    C17126b c7990b = new C7990b(j);
                    C25052j.m39376p(iterable, "receiver$0");
                    C25052j.m39376p(c7990b, "defaultValue");
                    if (iterable instanceof List) {
                        List list = (List) iterable;
                        obj = (j < 0 || j > C7987l.m14172fH(list)) ? c7990b.mo50am(Integer.valueOf(j)) : list.get(j);
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
                        obj = c7990b.mo50am(Integer.valueOf(j));
                    }
                }
                C25052j.m39375o(obj, "avatarMap.entries.elementAt(avatarConfettiIndex)");
                Entry entry = (Entry) obj;
                boolean z = ((C39889a) entry.getKey()).rVh;
                Object value = entry.getValue();
                C25052j.m39375o(value, "entry.value");
                LayerDrawable layerDrawable = (LayerDrawable) value;
                if (z) {
                    layerDrawable.getDrawable(0).setColorFilter(context.getResources().getColor(C25738R.color.f11659bb), Mode.SRC_ATOP);
                    ((C39889a) entry.getKey()).rVh = false;
                } else {
                    layerDrawable.getDrawable(0).setColorFilter(context.getResources().getColor(C25738R.color.a1r), Mode.SRC_ATOP);
                }
                StoryCommentView storyCommentView2 = this.sjP;
                storyCommentView2.sjI = storyCommentView2.sjI + 1;
                C28430b c31441a = new C31441a(layerDrawable);
                AppMethodBeat.m2505o(138910);
                return c31441a;
            }
        };
        this.lmq = new C462879(this);
        this.sjt.setOnClickListener(new C4365510(this));
        this.sju.setOnClickListener(new C4365611(this));
        this.sjv.setOnClickListener(new C4365712(this));
        this.sjK = new C22325h(this);
        this.sjK.skq = new C462862(this);
        setOnClickListener(new C399273(this));
        setOnLongClickListener(new C399284(this));
        int fr = C5230ak.m7988fr(context);
        C4990ab.m7416i(TAG, "LogStory: navigationHeight ".concat(String.valueOf(fr)));
        findViewById(2131828080).setPadding(0, 0, 0, fr);
        this.sry = new C31440b(this);
        this.tBp = new C43658d(this);
        AppMethodBeat.m2505o(110434);
    }

    public StoryCommentView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110435);
        AppMethodBeat.m2505o(110435);
    }

    public StoryCommentView(Context context) {
        C25052j.m39376p(context, "context");
        this(context, null);
        AppMethodBeat.m2504i(110436);
        AppMethodBeat.m2505o(110436);
    }

    static {
        AppMethodBeat.m2504i(110437);
        AppMethodBeat.m2505o(110437);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final void setSessionId(String str) {
        this.cvF = str;
    }

    public final C17126b<Integer, C37091y> getStateChangeCallback() {
        return this.sjL;
    }

    public final void setStateChangeCallback(C17126b<? super Integer, C37091y> c17126b) {
        this.sjL = c17126b;
    }

    public final C31214a<Boolean> getOutsideClickListener() {
        return this.sjM;
    }

    public final void setOutsideClickListener(C31214a<Boolean> c31214a) {
        this.sjM = c31214a;
    }

    public final void show() {
        AppMethodBeat.m2504i(110429);
        this.contentView.setVisibility(0);
        if (this.contentView.getVisibility() == 0 && this.fnH == 2 && this.sjq.cAY) {
            this.sjz.rVh = false;
            this.sjq.resume();
            if (!this.czr && this.sjy) {
                C1706e RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "storage()");
                int i = RP.mo5239Ry().getInt(C5127a.USERINFO_STORY_BUBBLE_COUNT_INT, 0);
                if (i < 3) {
                    C1706e RP2 = C1720g.m3536RP();
                    C25052j.m39375o(RP2, "storage()");
                    RP2.mo5239Ry().set(C5127a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(i + 1));
                    this.sjs.animate().cancel();
                    this.sjs.setVisibility(0);
                    this.sjs.animate().alpha(1.0f).start();
                    C5004al.m7439af(this.lmq);
                    C5004al.m7442n(this.lmq, 3000);
                }
            }
        }
        AppMethodBeat.m2505o(110429);
    }

    /* renamed from: Ab */
    public final boolean mo74429Ab() {
        AppMethodBeat.m2504i(110426);
        if (this.fnH == 1) {
            mo74436oE(2);
            AppMethodBeat.m2505o(110426);
            return true;
        } else if (this.fnH == 3) {
            mo74436oE(2);
            AppMethodBeat.m2505o(110426);
            return true;
        } else if (this.fnH == 5) {
            mo74436oE(2);
            AppMethodBeat.m2505o(110426);
            return true;
        } else {
            AppMethodBeat.m2505o(110426);
            return false;
        }
    }

    public static void resume() {
        AppMethodBeat.m2504i(110427);
        C4990ab.m7416i(TAG, "LogStory: resume");
        AppMethodBeat.m2505o(110427);
    }

    public static void pause() {
        AppMethodBeat.m2504i(110428);
        C4990ab.m7416i(TAG, "LogStory: pause");
        AppMethodBeat.m2505o(110428);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(138921);
        this.sjq.pause();
        this.sjJ.clear();
        this.srA.clear();
        AppMethodBeat.m2505o(138921);
    }

    /* renamed from: oE */
    public final void mo74436oE(int i) {
        AppMethodBeat.m2504i(110430);
        C4990ab.m7416i(TAG, "switchState " + i + ' ' + C5046bo.dpG());
        if (this.fnH == i) {
            AppMethodBeat.m2505o(110430);
            return;
        }
        this.fnH = i;
        Context context;
        C43662c c43662c;
        StoryCommentInputView storyCommentInputView;
        C43662c c43662c2;
        switch (i) {
            case 1:
                this.toUser = this.rVl;
                this.rVm = 0;
                this.sjq.pause();
                this.seK.setVisibility(8);
                this.sjq.setVisibility(8);
                context = getContext();
                C25052j.m39375o(context, "context");
                this.sjB = new C43662c(context);
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setHostStory(this.sjr.sfH);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setReply(false);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setCommentInputCallback(this.sry);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        StoryCommentInputView.m68351a(storyCommentInputView, this.sjD);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.mo63117rh(false);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    c43662c.show();
                }
                this.sjC = false;
                c43662c2 = this.sjB;
                if (c43662c2 != null) {
                    c43662c2.setOnDismissListener(new C43660f(this));
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
                this.seK.animate().alpha(0.0f).withEndAction(new C22288i(this)).start();
                this.sjq.animate().cancel();
                this.sjq.setVisibility(0);
                this.sjq.setAlpha(1.0f);
                if (this.csi) {
                    this.sjq.resume();
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    c43662c.dismiss();
                    break;
                }
                break;
            case 3:
                this.toUser = this.rVl;
                this.rVm = 0;
                this.iVh.animate().cancel();
                this.iVh.setVisibility(0);
                this.iVh.animate().alpha(1.0f).start();
                this.sjq.animate().alpha(0.0f).withEndAction(new C22289j(this)).start();
                this.seK.animate().cancel();
                this.seK.setVisibility(0);
                this.seK.setAlpha(1.0f);
                this.sjr.mo25997dI(this.sjz.rrj);
                this.sjr.notifyDataSetChanged();
                this.sjr.sfG = true;
                this.seK.setAdapter(this.sjr);
                this.seK.mo61465bY(this.sjz.rrj.size() - 1);
                this.seK.post(new C22290l(this));
                break;
            case 5:
                StoryCommentInputView storyCommentInputView2;
                this.sjq.pause();
                this.sjq.setVisibility(8);
                this.seK.animate().alpha(0.0f).withEndAction(new C43661g(this)).start();
                context = getContext();
                C25052j.m39375o(context, "context");
                this.sjB = new C43662c(context);
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setHostStory(this.sjr.sfH);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setReply(true);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setCommentInputCallback(this.sry);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.setCommentReplyCallback(this.tBp);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView2 = c43662c.spp;
                    if (storyCommentInputView2 != null) {
                        storyCommentInputView2.mo63112e((CharSequence) this.srA.get(this.toUser), this.toUser);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.mo63117rh(true);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView2 = c43662c.spp;
                    if (storyCommentInputView2 != null) {
                        storyCommentInputView2.mo63113ge(this.sjz.rrj);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.sjr.notifyDataSetChanged();
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    storyCommentInputView = c43662c.spp;
                    if (storyCommentInputView != null) {
                        storyCommentInputView.mo63110bY(this.tBo);
                    }
                }
                c43662c = this.sjB;
                if (c43662c != null) {
                    c43662c.show();
                }
                this.sjC = false;
                c43662c2 = this.sjB;
                if (c43662c2 != null) {
                    c43662c2.setOnDismissListener(new C22287h(this));
                    break;
                }
                break;
        }
        C17126b c17126b = this.sjL;
        if (c17126b != null) {
            c17126b.mo50am(Integer.valueOf(this.fnH));
            AppMethodBeat.m2505o(110430);
            return;
        }
        AppMethodBeat.m2505o(110430);
    }

    /* renamed from: lL */
    public final void mo74435lL(boolean z) {
        AppMethodBeat.m2504i(138922);
        C4990ab.m7416i(TAG, "toggleActiveState ".concat(String.valueOf(z)));
        if (z) {
            show();
            AppMethodBeat.m2505o(138922);
            return;
        }
        hide();
        AppMethodBeat.m2505o(138922);
    }

    public final void hide() {
        AppMethodBeat.m2504i(110425);
        this.sjq.pause();
        this.contentView.setVisibility(8);
        AppMethodBeat.m2505o(110425);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: p */
    public static final /* synthetic */ void m86825p(StoryCommentView storyCommentView) {
        Object content;
        AppMethodBeat.m2504i(139106);
        Map map = storyCommentView.srA;
        String str = storyCommentView.toUser;
        C43662c c43662c = storyCommentView.sjB;
        if (c43662c != null) {
            StoryCommentInputView storyCommentInputView = c43662c.spp;
            if (storyCommentInputView != null) {
                content = storyCommentInputView.getContent();
                map.put(str, content);
                if (storyCommentView.srA.size() > 3) {
                    LinkedHashMap linkedHashMap = storyCommentView.srA;
                    Set keySet = storyCommentView.srA.keySet();
                    C25052j.m39375o(keySet, "saveReplyContentCache.keys");
                    Object obj = (String) C25035t.m39336f(keySet);
                    if (obj == null) {
                        obj = "";
                    }
                    linkedHashMap.remove(obj);
                }
                AppMethodBeat.m2505o(139106);
            }
        }
        content = null;
        map.put(str, content);
        if (storyCommentView.srA.size() > 3) {
        }
        AppMethodBeat.m2505o(139106);
    }
}
