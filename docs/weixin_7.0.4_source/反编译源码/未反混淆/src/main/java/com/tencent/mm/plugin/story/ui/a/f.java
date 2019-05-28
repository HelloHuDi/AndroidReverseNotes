package com.tencent.mm.plugin.story.ui.a;

import a.f.a.m;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.v;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 -2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004,-./B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u001c\u0010!\u001a\u00020\u00192\n\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u0005H\u0016J\u001c\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0016J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0007J\u0014\u0010)\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0+R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RL\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
public final class f extends android.support.v7.widget.RecyclerView.a<a> {
    private static final int llW = 0;
    private static final int sfJ = 1;
    public static final b sfK = new b();
    private final ArrayList<com.tencent.mm.plugin.story.model.b.a> seM = new ArrayList();
    public boolean sfG;
    public j sfH;
    public m<? super com.tencent.mm.plugin.story.model.b.a, ? super Boolean, y> sfI;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class c extends a {
        final /* synthetic */ f sfM;

        public c(f fVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.sfM = fVar;
            super(fVar, view);
            AppMethodBeat.i(138854);
            AppMethodBeat.o(138854);
        }

        public final View cCh() {
            AppMethodBeat.i(138852);
            View findViewById = this.apJ.findViewById(R.id.erh);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…omment_bubble_background)");
            AppMethodBeat.o(138852);
            return findViewById;
        }

        public final void a(int i, com.tencent.mm.plugin.story.model.b.a aVar) {
            AppMethodBeat.i(138853);
            a.f.b.j.p(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            super.a(i, aVar);
            if (aVar.rVi) {
                com.tencent.mm.ab.b.f(this.seQ);
            }
            AppMethodBeat.o(138853);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$Companion;", "", "()V", "ViewTypeBubble", "", "ViewTypeNormal", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
    public final class d extends a {
        private final TextView rhT;
        final /* synthetic */ f sfM;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.model.b.a sfO;
            final /* synthetic */ d sfP;

            a(d dVar, com.tencent.mm.plugin.story.model.b.a aVar) {
                this.sfP = dVar;
                this.sfO = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(138855);
                if (com.tencent.mm.plugin.story.c.a.a.rQZ.cxi()) {
                    com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                    if (!bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), this.sfO.cEV)) {
                        m mVar = this.sfP.sfM.sfI;
                        if (mVar != null) {
                            mVar.m(this.sfO, Boolean.TRUE);
                            AppMethodBeat.o(138855);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(138855);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.model.b.a sfO;
            final /* synthetic */ d sfP;

            b(d dVar, com.tencent.mm.plugin.story.model.b.a aVar) {
                this.sfP = dVar;
                this.sfO = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(138856);
                m mVar = this.sfP.sfM.sfI;
                if (mVar != null) {
                    mVar.m(this.sfO, Boolean.FALSE);
                    AppMethodBeat.o(138856);
                    return;
                }
                AppMethodBeat.o(138856);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class c implements OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.model.b.a sfO;
            final /* synthetic */ d sfP;

            c(d dVar, com.tencent.mm.plugin.story.model.b.a aVar) {
                this.sfP = dVar;
                this.sfO = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(138857);
                m mVar = this.sfP.sfM.sfI;
                if (mVar != null) {
                    mVar.m(this.sfO, Boolean.TRUE);
                    AppMethodBeat.o(138857);
                    return;
                }
                AppMethodBeat.o(138857);
            }
        }

        public d(f fVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.sfM = fVar;
            super(fVar, view);
            AppMethodBeat.i(110124);
            View findViewById = view.findViewById(R.id.erg);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…story_comment_item_op_tv)");
            this.rhT = (TextView) findViewById;
            AppMethodBeat.o(110124);
        }

        public final View cCh() {
            AppMethodBeat.i(138858);
            View findViewById = this.apJ.findViewById(R.id.erb);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…mment_content_background)");
            AppMethodBeat.o(138858);
            return findViewById;
        }

        /* JADX WARNING: Missing block: B:19:0x009a, code skipped:
            if (r0.cBX() == false) goto L_0x009c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int i, com.tencent.mm.plugin.story.model.b.a aVar) {
            AppMethodBeat.i(138859);
            a.f.b.j.p(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            super.a(i, aVar);
            if (aVar.rVi) {
                com.tencent.mm.ab.b.f(this.seQ);
            }
            if (!aVar.rVi) {
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                boolean isEqual = bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), aVar.cEV);
                this.rhT.setVisibility(0);
                TextView textView;
                View view;
                Context context;
                if (isEqual) {
                    this.rhT.setOnClickListener(new b(this, aVar));
                    textView = this.rhT;
                    view = this.apJ;
                    a.f.b.j.o(view, "itemView");
                    context = view.getContext();
                    a.f.b.j.o(context, "itemView.context");
                    textView.setText(context.getResources().getString(R.string.g_3));
                    this.rhT.setTextColor(-1);
                    com.tencent.mm.ab.b.f(this.rhT);
                } else if (com.tencent.mm.plugin.story.c.a.a.rQZ.cxi()) {
                    j jVar = this.sfM.sfH;
                    if (jVar == null || !jVar.cBW()) {
                        jVar = this.sfM.sfH;
                        if (jVar != null) {
                        }
                    }
                    this.rhT.setOnClickListener(new c(this, aVar));
                    textView = this.rhT;
                    view = this.apJ;
                    a.f.b.j.o(view, "itemView");
                    context = view.getContext();
                    a.f.b.j.o(context, "itemView.context");
                    textView.setText(context.getResources().getString(R.string.g_4));
                    this.rhT.setTextColor(-1);
                    com.tencent.mm.ab.b.f(this.rhT);
                }
                this.apJ.setOnClickListener(new a(this, aVar));
                AppMethodBeat.o(138859);
            }
            this.rhT.setVisibility(8);
            this.apJ.setOnClickListener(new a(this, aVar));
            AppMethodBeat.o(138859);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
    public abstract class a extends v {
        private View iVh = cCh();
        private final TextView ooM;
        final TextView seQ;
        private final CommentAvatarImageView sfL;
        final /* synthetic */ f sfM;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements OnClickListener {
            final /* synthetic */ a sfN;
            final /* synthetic */ com.tencent.mm.plugin.story.model.b.a sfO;

            b(a aVar, com.tencent.mm.plugin.story.model.b.a aVar2) {
                this.sfN = aVar;
                this.sfO = aVar2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(138851);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.sfO.cEV);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
                View view2 = this.sfN.apJ;
                a.f.b.j.o(view2, "itemView");
                com.tencent.mm.bp.d.b(view2.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(138851);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ a sfN;

            a(a aVar) {
                this.sfN = aVar;
            }

            public final void run() {
                AppMethodBeat.i(138850);
                View view = this.sfN.apJ;
                a.f.b.j.o(view, "itemView");
                view.setVisibility(0);
                AppMethodBeat.o(138850);
            }
        }

        public abstract View cCh();

        public a(f fVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.sfM = fVar;
            super(view);
            View findViewById = view.findViewById(R.id.erc);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
            this.sfL = (CommentAvatarImageView) findViewById;
            findViewById = view.findViewById(R.id.ere);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…ry_comment_item_username)");
            this.seQ = (TextView) findViewById;
            findViewById = view.findViewById(R.id.erf);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…ory_comment_item_content)");
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
        public void a(int i, com.tencent.mm.plugin.story.model.b.a aVar) {
            CharSequence charSequence;
            SpannableString b;
            Context context;
            SpannableString b2;
            boolean z;
            TextView textView;
            com.tencent.mm.plugin.story.model.j.a aVar2;
            com.tencent.mm.plugin.story.h.f aaX;
            CommentAvatarImageView commentAvatarImageView;
            String str;
            boolean z2 = false;
            a.f.b.j.p(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            if (this.apJ instanceof CommentItemView) {
                ((CommentItemView) this.apJ).setComment(aVar);
            }
            View view = this.apJ;
            a.f.b.j.o(view, "itemView");
            view.setVisibility(4);
            this.apJ.post(new a(this));
            if (this.apJ instanceof CommentItemView) {
                Drawable background;
                Context context2;
                if (aVar.rVh) {
                    background = this.iVh.getBackground();
                    a.f.b.j.o(background, "bg");
                    context2 = ((CommentItemView) this.apJ).getContext();
                    a.f.b.j.o(context2, "itemView.context");
                    background.setColorFilter(new PorterDuffColorFilter(context2.getResources().getColor(R.color.bb), Mode.SRC_ATOP));
                    aVar.rVh = false;
                } else {
                    background = this.iVh.getBackground();
                    a.f.b.j.o(background, "bg");
                    context2 = ((CommentItemView) this.apJ).getContext();
                    a.f.b.j.o(context2, "itemView.context");
                    background.setColorFilter(new PorterDuffColorFilter(context2.getResources().getColor(R.color.a1r), Mode.SRC_ATOP));
                    aVar.rVh = false;
                }
            }
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(aVar.cEV);
            Context context3 = this.seQ.getContext();
            if (aoO != null) {
                String Oj = aoO.Oj();
                if (Oj != null) {
                    charSequence = Oj;
                    b = com.tencent.mm.pluginsdk.ui.e.j.b(context3, charSequence, this.seQ.getTextSize());
                    K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                    a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                    aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(aVar.toUser);
                    context = this.seQ.getContext();
                    if (aoO != null) {
                        Oj = aoO.Oj();
                        if (Oj != null) {
                            charSequence = Oj;
                            b2 = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, this.seQ.getTextSize());
                            if (aVar.rVm != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            textView = this.seQ;
                            if (z) {
                                StringBuilder append = new StringBuilder().append(b).append(' ');
                                context3 = this.seQ.getContext();
                                a.f.b.j.o(context3, "fromUser.context");
                                charSequence = append.append(context3.getResources().getString(R.string.t8)).append(' ').append(b2).toString();
                            } else {
                                charSequence = b;
                            }
                            textView.setText(charSequence);
                            this.ooM.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.ooM.getContext(), (CharSequence) aVar.content, this.ooM.getTextSize()));
                            com.tencent.mm.pluginsdk.ui.a.b.r(this.sfL, aVar.cEV);
                            aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                            aaX = com.tencent.mm.plugin.story.model.j.a.cxU().aaX(aVar.cEV);
                            if (aaX != null) {
                                z2 = aaX.cBN();
                            }
                            this.sfL.setShowStoryHint(z2);
                            commentAvatarImageView = this.sfL;
                            str = aVar.cEV;
                            a.f.b.j.p(str, "userName");
                            commentAvatarImageView.rDe.dk(str, 6);
                            if (!TextUtils.equals(commentAvatarImageView.rMJ, str)) {
                                commentAvatarImageView.rMJ = str;
                            }
                            this.sfL.setWithHintBg(aVar.rVi);
                            this.sfL.setOnClickListener(new b(this, aVar));
                        }
                    }
                    charSequence = "";
                    b2 = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, this.seQ.getTextSize());
                    if (aVar.rVm != 0) {
                    }
                    textView = this.seQ;
                    if (z) {
                    }
                    textView.setText(charSequence);
                    this.ooM.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.ooM.getContext(), (CharSequence) aVar.content, this.ooM.getTextSize()));
                    com.tencent.mm.pluginsdk.ui.a.b.r(this.sfL, aVar.cEV);
                    aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                    aaX = com.tencent.mm.plugin.story.model.j.a.cxU().aaX(aVar.cEV);
                    if (aaX != null) {
                    }
                    this.sfL.setShowStoryHint(z2);
                    commentAvatarImageView = this.sfL;
                    str = aVar.cEV;
                    a.f.b.j.p(str, "userName");
                    commentAvatarImageView.rDe.dk(str, 6);
                    if (TextUtils.equals(commentAvatarImageView.rMJ, str)) {
                    }
                    this.sfL.setWithHintBg(aVar.rVi);
                    this.sfL.setOnClickListener(new b(this, aVar));
                }
            }
            charSequence = "";
            b = com.tencent.mm.pluginsdk.ui.e.j.b(context3, charSequence, this.seQ.getTextSize());
            K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
            aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(aVar.toUser);
            context = this.seQ.getContext();
            if (aoO != null) {
            }
            charSequence = "";
            b2 = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, this.seQ.getTextSize());
            if (aVar.rVm != 0) {
            }
            textView = this.seQ;
            if (z) {
            }
            textView.setText(charSequence);
            this.ooM.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.ooM.getContext(), (CharSequence) aVar.content, this.ooM.getTextSize()));
            com.tencent.mm.pluginsdk.ui.a.b.r(this.sfL, aVar.cEV);
            aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            aaX = com.tencent.mm.plugin.story.model.j.a.cxU().aaX(aVar.cEV);
            if (aaX != null) {
            }
            this.sfL.setShowStoryHint(z2);
            commentAvatarImageView = this.sfL;
            str = aVar.cEV;
            a.f.b.j.p(str, "userName");
            commentAvatarImageView.rDe.dk(str, 6);
            if (TextUtils.equals(commentAvatarImageView.rMJ, str)) {
            }
            this.sfL.setWithHintBg(aVar.rVi);
            this.sfL.setOnClickListener(new b(this, aVar));
        }
    }

    public f() {
        AppMethodBeat.i(110129);
        AppMethodBeat.o(110129);
    }

    static {
        AppMethodBeat.i(110130);
        AppMethodBeat.o(110130);
    }

    public final void dI(List<com.tencent.mm.plugin.story.model.b.a> list) {
        AppMethodBeat.i(138860);
        a.f.b.j.p(list, "storyComments");
        this.seM.clear();
        this.seM.addAll(list);
        AppMethodBeat.o(138860);
    }

    public final int getItemCount() {
        AppMethodBeat.i(110125);
        int size = this.seM.size();
        AppMethodBeat.o(110125);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(110126);
        int i2;
        if (((com.tencent.mm.plugin.story.model.b.a) this.seM.get(i)).rVi) {
            i2 = sfJ;
            AppMethodBeat.o(110126);
            return i2;
        }
        i2 = llW;
        AppMethodBeat.o(110126);
        return i2;
    }
}
