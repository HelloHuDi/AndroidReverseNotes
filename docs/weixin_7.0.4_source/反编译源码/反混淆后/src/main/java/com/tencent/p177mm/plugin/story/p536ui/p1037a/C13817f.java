package com.tencent.p177mm.plugin.story.p536ui.p1037a;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p536ui.view.CommentAvatarImageView;
import com.tencent.p177mm.plugin.story.p536ui.view.CommentItemView;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 -2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004,-./B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u001c\u0010!\u001a\u00020\u00192\n\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u0005H\u0016J\u001c\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0016J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0007J\u0014\u0010)\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0+R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RL\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.a.f */
public final class C13817f extends C41523a<C13823a> {
    private static final int llW = 0;
    private static final int sfJ = 1;
    public static final C13818b sfK = new C13818b();
    private final ArrayList<C39889a> seM = new ArrayList();
    public boolean sfG;
    public C39879j sfH;
    public C31591m<? super C39889a, ? super Boolean, C37091y> sfI;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.f$c */
    public final class C13816c extends C13823a {
        final /* synthetic */ C13817f sfM;

        public C13816c(C13817f c13817f, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfM = c13817f;
            super(c13817f, view);
            AppMethodBeat.m2504i(138854);
            AppMethodBeat.m2505o(138854);
        }

        public final View cCh() {
            AppMethodBeat.m2504i(138852);
            View findViewById = this.apJ.findViewById(2131828072);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…omment_bubble_background)");
            AppMethodBeat.m2505o(138852);
            return findViewById;
        }

        /* renamed from: a */
        public final void mo25995a(int i, C39889a c39889a) {
            AppMethodBeat.m2504i(138853);
            C25052j.m39376p(c39889a, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            super.mo25995a(i, c39889a);
            if (c39889a.rVi) {
                C8902b.m16047f(this.seQ);
            }
            AppMethodBeat.m2505o(138853);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$Companion;", "", "()V", "ViewTypeBubble", "", "ViewTypeNormal", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.f$b */
    public static final class C13818b {
        private C13818b() {
        }

        public /* synthetic */ C13818b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.f$d */
    public final class C13819d extends C13823a {
        private final TextView rhT;
        final /* synthetic */ C13817f sfM;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.f$d$a */
        static final class C13820a implements OnClickListener {
            final /* synthetic */ C39889a sfO;
            final /* synthetic */ C13819d sfP;

            C13820a(C13819d c13819d, C39889a c39889a) {
                this.sfP = c13819d;
                this.sfO = c39889a;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(138855);
                if (C29274a.rQZ.cxi()) {
                    C4133a c4133a = C43644j.rST;
                    if (!C5046bo.isEqual(C4133a.cnk(), this.sfO.cEV)) {
                        C31591m c31591m = this.sfP.sfM.sfI;
                        if (c31591m != null) {
                            c31591m.mo212m(this.sfO, Boolean.TRUE);
                            AppMethodBeat.m2505o(138855);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(138855);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.f$d$b */
        static final class C13821b implements OnClickListener {
            final /* synthetic */ C39889a sfO;
            final /* synthetic */ C13819d sfP;

            C13821b(C13819d c13819d, C39889a c39889a) {
                this.sfP = c13819d;
                this.sfO = c39889a;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(138856);
                C31591m c31591m = this.sfP.sfM.sfI;
                if (c31591m != null) {
                    c31591m.mo212m(this.sfO, Boolean.FALSE);
                    AppMethodBeat.m2505o(138856);
                    return;
                }
                AppMethodBeat.m2505o(138856);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.f$d$c */
        static final class C13822c implements OnClickListener {
            final /* synthetic */ C39889a sfO;
            final /* synthetic */ C13819d sfP;

            C13822c(C13819d c13819d, C39889a c39889a) {
                this.sfP = c13819d;
                this.sfO = c39889a;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(138857);
                C31591m c31591m = this.sfP.sfM.sfI;
                if (c31591m != null) {
                    c31591m.mo212m(this.sfO, Boolean.TRUE);
                    AppMethodBeat.m2505o(138857);
                    return;
                }
                AppMethodBeat.m2505o(138857);
            }
        }

        public C13819d(C13817f c13817f, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfM = c13817f;
            super(c13817f, view);
            AppMethodBeat.m2504i(110124);
            View findViewById = view.findViewById(2131828071);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…story_comment_item_op_tv)");
            this.rhT = (TextView) findViewById;
            AppMethodBeat.m2505o(110124);
        }

        public final View cCh() {
            AppMethodBeat.m2504i(138858);
            View findViewById = this.apJ.findViewById(2131828066);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…mment_content_background)");
            AppMethodBeat.m2505o(138858);
            return findViewById;
        }

        /* JADX WARNING: Missing block: B:19:0x009a, code skipped:
            if (r0.cBX() == false) goto L_0x009c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo25995a(int i, C39889a c39889a) {
            AppMethodBeat.m2504i(138859);
            C25052j.m39376p(c39889a, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            super.mo25995a(i, c39889a);
            if (c39889a.rVi) {
                C8902b.m16047f(this.seQ);
            }
            if (!c39889a.rVi) {
                C4133a c4133a = C43644j.rST;
                boolean isEqual = C5046bo.isEqual(C4133a.cnk(), c39889a.cEV);
                this.rhT.setVisibility(0);
                TextView textView;
                View view;
                Context context;
                if (isEqual) {
                    this.rhT.setOnClickListener(new C13821b(this, c39889a));
                    textView = this.rhT;
                    view = this.apJ;
                    C25052j.m39375o(view, "itemView");
                    context = view.getContext();
                    C25052j.m39375o(context, "itemView.context");
                    textView.setText(context.getResources().getString(C25738R.string.g_3));
                    this.rhT.setTextColor(-1);
                    C8902b.m16047f(this.rhT);
                } else if (C29274a.rQZ.cxi()) {
                    C39879j c39879j = this.sfM.sfH;
                    if (c39879j == null || !c39879j.cBW()) {
                        c39879j = this.sfM.sfH;
                        if (c39879j != null) {
                        }
                    }
                    this.rhT.setOnClickListener(new C13822c(this, c39889a));
                    textView = this.rhT;
                    view = this.apJ;
                    C25052j.m39375o(view, "itemView");
                    context = view.getContext();
                    C25052j.m39375o(context, "itemView.context");
                    textView.setText(context.getResources().getString(C25738R.string.g_4));
                    this.rhT.setTextColor(-1);
                    C8902b.m16047f(this.rhT);
                }
                this.apJ.setOnClickListener(new C13820a(this, c39889a));
                AppMethodBeat.m2505o(138859);
            }
            this.rhT.setVisibility(8);
            this.apJ.setOnClickListener(new C13820a(this, c39889a));
            AppMethodBeat.m2505o(138859);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.f$a */
    public abstract class C13823a extends C41531v {
        private View iVh = cCh();
        private final TextView ooM;
        final TextView seQ;
        private final CommentAvatarImageView sfL;
        final /* synthetic */ C13817f sfM;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.f$a$b */
        static final class C13824b implements OnClickListener {
            final /* synthetic */ C13823a sfN;
            final /* synthetic */ C39889a sfO;

            C13824b(C13823a c13823a, C39889a c39889a) {
                this.sfN = c13823a;
                this.sfO = c39889a;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(138851);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.sfO.cEV);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
                View view2 = this.sfN.apJ;
                C25052j.m39375o(view2, "itemView");
                C25985d.m41467b(view2.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(138851);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.f$a$a */
        static final class C13825a implements Runnable {
            final /* synthetic */ C13823a sfN;

            C13825a(C13823a c13823a) {
                this.sfN = c13823a;
            }

            public final void run() {
                AppMethodBeat.m2504i(138850);
                View view = this.sfN.apJ;
                C25052j.m39375o(view, "itemView");
                view.setVisibility(0);
                AppMethodBeat.m2505o(138850);
            }
        }

        public abstract View cCh();

        public C13823a(C13817f c13817f, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfM = c13817f;
            super(view);
            View findViewById = view.findViewById(2131828067);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
            this.sfL = (CommentAvatarImageView) findViewById;
            findViewById = view.findViewById(2131828069);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…ry_comment_item_username)");
            this.seQ = (TextView) findViewById;
            findViewById = view.findViewById(2131828070);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…ory_comment_item_content)");
            this.ooM = (TextView) findViewById;
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x01c4  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x01c7  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00d9  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0144  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x016a  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x01c4  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00d9  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x01c7  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0144  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x016a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void mo25995a(int i, C39889a c39889a) {
            CharSequence charSequence;
            SpannableString b;
            Context context;
            SpannableString b2;
            boolean z;
            TextView textView;
            C4133a c4133a;
            C4119f aaX;
            CommentAvatarImageView commentAvatarImageView;
            String str;
            boolean z2 = false;
            C25052j.m39376p(c39889a, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            if (this.apJ instanceof CommentItemView) {
                ((CommentItemView) this.apJ).setComment(c39889a);
            }
            View view = this.apJ;
            C25052j.m39375o(view, "itemView");
            view.setVisibility(4);
            this.apJ.post(new C13825a(this));
            if (this.apJ instanceof CommentItemView) {
                Drawable background;
                Context context2;
                if (c39889a.rVh) {
                    background = this.iVh.getBackground();
                    C25052j.m39375o(background, "bg");
                    context2 = ((CommentItemView) this.apJ).getContext();
                    C25052j.m39375o(context2, "itemView.context");
                    background.setColorFilter(new PorterDuffColorFilter(context2.getResources().getColor(C25738R.color.f11659bb), Mode.SRC_ATOP));
                    c39889a.rVh = false;
                } else {
                    background = this.iVh.getBackground();
                    C25052j.m39375o(background, "bg");
                    context2 = ((CommentItemView) this.apJ).getContext();
                    C25052j.m39375o(context2, "itemView.context");
                    background.setColorFilter(new PorterDuffColorFilter(context2.getResources().getColor(C25738R.color.a1r), Mode.SRC_ATOP));
                    c39889a.rVh = false;
                }
            }
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
            C7616ad aoO = ((C6982j) K).mo15369XM().aoO(c39889a.cEV);
            Context context3 = this.seQ.getContext();
            if (aoO != null) {
                String Oj = aoO.mo16707Oj();
                if (Oj != null) {
                    charSequence = Oj;
                    b = C44089j.m79293b(context3, charSequence, this.seQ.getTextSize());
                    K = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                    aoO = ((C6982j) K).mo15369XM().aoO(c39889a.toUser);
                    context = this.seQ.getContext();
                    if (aoO != null) {
                        Oj = aoO.mo16707Oj();
                        if (Oj != null) {
                            charSequence = Oj;
                            b2 = C44089j.m79293b(context, charSequence, this.seQ.getTextSize());
                            if (c39889a.rVm != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            textView = this.seQ;
                            if (z) {
                                StringBuilder append = new StringBuilder().append(b).append(' ');
                                context3 = this.seQ.getContext();
                                C25052j.m39375o(context3, "fromUser.context");
                                charSequence = append.append(context3.getResources().getString(C25738R.string.f9214t8)).append(' ').append(b2).toString();
                            } else {
                                charSequence = b;
                            }
                            textView.setText(charSequence);
                            this.ooM.setText(C44089j.m79293b(this.ooM.getContext(), (CharSequence) c39889a.content, this.ooM.getTextSize()));
                            C40460b.m69437r(this.sfL, c39889a.cEV);
                            c4133a = C43644j.rST;
                            aaX = C4133a.cxU().aaX(c39889a.cEV);
                            if (aaX != null) {
                                z2 = aaX.cBN();
                            }
                            this.sfL.setShowStoryHint(z2);
                            commentAvatarImageView = this.sfL;
                            str = c39889a.cEV;
                            C25052j.m39376p(str, "userName");
                            commentAvatarImageView.rDe.mo9016dk(str, 6);
                            if (!TextUtils.equals(commentAvatarImageView.rMJ, str)) {
                                commentAvatarImageView.rMJ = str;
                            }
                            this.sfL.setWithHintBg(c39889a.rVi);
                            this.sfL.setOnClickListener(new C13824b(this, c39889a));
                        }
                    }
                    charSequence = "";
                    b2 = C44089j.m79293b(context, charSequence, this.seQ.getTextSize());
                    if (c39889a.rVm != 0) {
                    }
                    textView = this.seQ;
                    if (z) {
                    }
                    textView.setText(charSequence);
                    this.ooM.setText(C44089j.m79293b(this.ooM.getContext(), (CharSequence) c39889a.content, this.ooM.getTextSize()));
                    C40460b.m69437r(this.sfL, c39889a.cEV);
                    c4133a = C43644j.rST;
                    aaX = C4133a.cxU().aaX(c39889a.cEV);
                    if (aaX != null) {
                    }
                    this.sfL.setShowStoryHint(z2);
                    commentAvatarImageView = this.sfL;
                    str = c39889a.cEV;
                    C25052j.m39376p(str, "userName");
                    commentAvatarImageView.rDe.mo9016dk(str, 6);
                    if (TextUtils.equals(commentAvatarImageView.rMJ, str)) {
                    }
                    this.sfL.setWithHintBg(c39889a.rVi);
                    this.sfL.setOnClickListener(new C13824b(this, c39889a));
                }
            }
            charSequence = "";
            b = C44089j.m79293b(context3, charSequence, this.seQ.getTextSize());
            K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
            aoO = ((C6982j) K).mo15369XM().aoO(c39889a.toUser);
            context = this.seQ.getContext();
            if (aoO != null) {
            }
            charSequence = "";
            b2 = C44089j.m79293b(context, charSequence, this.seQ.getTextSize());
            if (c39889a.rVm != 0) {
            }
            textView = this.seQ;
            if (z) {
            }
            textView.setText(charSequence);
            this.ooM.setText(C44089j.m79293b(this.ooM.getContext(), (CharSequence) c39889a.content, this.ooM.getTextSize()));
            C40460b.m69437r(this.sfL, c39889a.cEV);
            c4133a = C43644j.rST;
            aaX = C4133a.cxU().aaX(c39889a.cEV);
            if (aaX != null) {
            }
            this.sfL.setShowStoryHint(z2);
            commentAvatarImageView = this.sfL;
            str = c39889a.cEV;
            C25052j.m39376p(str, "userName");
            commentAvatarImageView.rDe.mo9016dk(str, 6);
            if (TextUtils.equals(commentAvatarImageView.rMJ, str)) {
            }
            this.sfL.setWithHintBg(c39889a.rVi);
            this.sfL.setOnClickListener(new C13824b(this, c39889a));
        }
    }

    public C13817f() {
        AppMethodBeat.m2504i(110129);
        AppMethodBeat.m2505o(110129);
    }

    static {
        AppMethodBeat.m2504i(110130);
        AppMethodBeat.m2505o(110130);
    }

    /* renamed from: dI */
    public final void mo25997dI(List<C39889a> list) {
        AppMethodBeat.m2504i(138860);
        C25052j.m39376p(list, "storyComments");
        this.seM.clear();
        this.seM.addAll(list);
        AppMethodBeat.m2505o(138860);
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(110125);
        int size = this.seM.size();
        AppMethodBeat.m2505o(110125);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(110126);
        int i2;
        if (((C39889a) this.seM.get(i)).rVi) {
            i2 = sfJ;
            AppMethodBeat.m2505o(110126);
            return i2;
        }
        i2 = llW;
        AppMethodBeat.m2505o(110126);
        return i2;
    }
}
