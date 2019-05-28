package com.tencent.p177mm.plugin.story.p536ui;

import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.StoryCommentsUI */
public final class StoryCommentsUI extends MMActivity {
    private RecyclerView seK;
    private C13808a seL;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCommentsUI$b */
    static final class C13807b extends C25053k implements C31591m<Integer, C39889a, C37091y> {
        public static final C13807b seU = new C13807b();

        static {
            AppMethodBeat.m2504i(110030);
            AppMethodBeat.m2505o(110030);
        }

        C13807b() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(110029);
            ((Number) obj).intValue();
            C25052j.m39376p((C39889a) obj2, "item");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110029);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u000bH\u0016J \u0010\u0016\u001a\u00020\u00102\u000e\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000RL\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCommentsUI$a */
    public final class C13808a extends C41523a<C4151a> {
        final ArrayList<C39889a> seM = new ArrayList();
        C31591m<? super Integer, ? super C39889a, C37091y> seN;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StoryCommentsUI$a$a */
        public final class C4151a extends C41531v {
            final ImageView gvq;
            final TextView ooM;
            private final ImageView seP;
            final TextView seQ;
            private final TextView seR;
            final /* synthetic */ C13808a seS;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.StoryCommentsUI$a$a$1 */
            static final class C41521 implements OnClickListener {
                final /* synthetic */ C4151a seT;

                C41521(C4151a c4151a) {
                    this.seT = c4151a;
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(110023);
                    int kj = this.seT.mo66454kj();
                    Object obj = this.seT.seS.seM.get(kj);
                    C25052j.m39375o(obj, "comments[position]");
                    C39889a c39889a = (C39889a) obj;
                    C31591m c31591m = this.seT.seS.seN;
                    if (c31591m != null) {
                        c31591m.mo212m(Integer.valueOf(kj), c39889a);
                        AppMethodBeat.m2505o(110023);
                        return;
                    }
                    AppMethodBeat.m2505o(110023);
                }
            }

            public C4151a(C13808a c13808a, View view) {
                C25052j.m39376p(view, "itemView");
                this.seS = c13808a;
                super(view);
                AppMethodBeat.m2504i(110024);
                View findViewById = view.findViewById(2131828067);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
                this.gvq = (ImageView) findViewById;
                findViewById = view.findViewById(2131828073);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.…ory_comment_item_preview)");
                this.seP = (ImageView) findViewById;
                findViewById = view.findViewById(2131828069);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.…ry_comment_item_username)");
                this.seQ = (TextView) findViewById;
                findViewById = view.findViewById(2131828070);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.…ory_comment_item_content)");
                this.ooM = (TextView) findViewById;
                findViewById = view.findViewById(2131828074);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.…mment_item_quote_content)");
                this.seR = (TextView) findViewById;
                view.setOnClickListener(new C41521(this));
                AppMethodBeat.m2505o(110024);
            }
        }

        public C13808a() {
            AppMethodBeat.m2504i(110028);
            AppMethodBeat.m2505o(110028);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(110025);
            int size = this.seM.size();
            AppMethodBeat.m2505o(110025);
            return size;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110031);
        super.onCreate(bundle);
        View findViewById = findViewById(2131828077);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_recycler)");
        this.seK = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.seK;
        if (recyclerView == null) {
            C25052j.avw("commentRecycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.seL = new C13808a();
        recyclerView = this.seK;
        if (recyclerView == null) {
            C25052j.avw("commentRecycler");
        }
        C13808a c13808a = this.seL;
        if (c13808a == null) {
            C25052j.avw("commentAdapter");
        }
        recyclerView.setAdapter(c13808a);
        C13808a c13808a2 = this.seL;
        if (c13808a2 == null) {
            C25052j.avw("commentAdapter");
        }
        c13808a2.seN = C13807b.seU;
        ArrayList arrayList = new ArrayList();
        c13808a2 = this.seL;
        if (c13808a2 == null) {
            C25052j.avw("commentAdapter");
        }
        List list = arrayList;
        C25052j.m39376p(list, "storyComments");
        c13808a2.seM.clear();
        c13808a2.seM.addAll(list);
        c13808a2.notifyDataSetChanged();
        AppMethodBeat.m2505o(110031);
    }

    public final int getLayoutId() {
        return 2130970873;
    }
}
