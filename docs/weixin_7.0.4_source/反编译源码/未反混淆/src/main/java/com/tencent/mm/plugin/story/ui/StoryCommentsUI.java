package com.tencent.mm.plugin.story.ui;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI extends MMActivity {
    private RecyclerView seK;
    private a seL;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
    static final class b extends k implements m<Integer, com.tencent.mm.plugin.story.model.b.a, y> {
        public static final b seU = new b();

        static {
            AppMethodBeat.i(110030);
            AppMethodBeat.o(110030);
        }

        b() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(110029);
            ((Number) obj).intValue();
            j.p((com.tencent.mm.plugin.story.model.b.a) obj2, "item");
            y yVar = y.AUy;
            AppMethodBeat.o(110029);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u000bH\u0016J \u0010\u0016\u001a\u00020\u00102\u000e\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000RL\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
    public final class a extends android.support.v7.widget.RecyclerView.a<a> {
        final ArrayList<com.tencent.mm.plugin.story.model.b.a> seM = new ArrayList();
        m<? super Integer, ? super com.tencent.mm.plugin.story.model.b.a, y> seN;

        @l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "quote", "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
        public final class a extends v {
            final ImageView gvq;
            final TextView ooM;
            private final ImageView seP;
            final TextView seQ;
            private final TextView seR;
            final /* synthetic */ a seS;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.StoryCommentsUI$a$a$1 */
            static final class AnonymousClass1 implements OnClickListener {
                final /* synthetic */ a seT;

                AnonymousClass1(a aVar) {
                    this.seT = aVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(110023);
                    int kj = this.seT.kj();
                    Object obj = this.seT.seS.seM.get(kj);
                    j.o(obj, "comments[position]");
                    com.tencent.mm.plugin.story.model.b.a aVar = (com.tencent.mm.plugin.story.model.b.a) obj;
                    m mVar = this.seT.seS.seN;
                    if (mVar != null) {
                        mVar.m(Integer.valueOf(kj), aVar);
                        AppMethodBeat.o(110023);
                        return;
                    }
                    AppMethodBeat.o(110023);
                }
            }

            public a(a aVar, View view) {
                j.p(view, "itemView");
                this.seS = aVar;
                super(view);
                AppMethodBeat.i(110024);
                View findViewById = view.findViewById(R.id.erc);
                j.o(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
                this.gvq = (ImageView) findViewById;
                findViewById = view.findViewById(R.id.eri);
                j.o(findViewById, "itemView.findViewById(R.…ory_comment_item_preview)");
                this.seP = (ImageView) findViewById;
                findViewById = view.findViewById(R.id.ere);
                j.o(findViewById, "itemView.findViewById(R.…ry_comment_item_username)");
                this.seQ = (TextView) findViewById;
                findViewById = view.findViewById(R.id.erf);
                j.o(findViewById, "itemView.findViewById(R.…ory_comment_item_content)");
                this.ooM = (TextView) findViewById;
                findViewById = view.findViewById(R.id.erj);
                j.o(findViewById, "itemView.findViewById(R.…mment_item_quote_content)");
                this.seR = (TextView) findViewById;
                view.setOnClickListener(new AnonymousClass1(this));
                AppMethodBeat.o(110024);
            }
        }

        public a() {
            AppMethodBeat.i(110028);
            AppMethodBeat.o(110028);
        }

        public final int getItemCount() {
            AppMethodBeat.i(110025);
            int size = this.seM.size();
            AppMethodBeat.o(110025);
            return size;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110031);
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.erm);
        j.o(findViewById, "findViewById(R.id.story_comment_recycler)");
        this.seK = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.seK;
        if (recyclerView == null) {
            j.avw("commentRecycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.seL = new a();
        recyclerView = this.seK;
        if (recyclerView == null) {
            j.avw("commentRecycler");
        }
        a aVar = this.seL;
        if (aVar == null) {
            j.avw("commentAdapter");
        }
        recyclerView.setAdapter(aVar);
        a aVar2 = this.seL;
        if (aVar2 == null) {
            j.avw("commentAdapter");
        }
        aVar2.seN = b.seU;
        ArrayList arrayList = new ArrayList();
        aVar2 = this.seL;
        if (aVar2 == null) {
            j.avw("commentAdapter");
        }
        List list = arrayList;
        j.p(list, "storyComments");
        aVar2.seM.clear();
        aVar2.seM.addAll(list);
        aVar2.notifyDataSetChanged();
        AppMethodBeat.o(110031);
    }

    public final int getLayoutId() {
        return R.layout.ay_;
    }
}
