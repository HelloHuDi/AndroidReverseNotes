package com.tencent.p177mm.plugin.story.p536ui.album;

import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\r2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0014\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "()V", "mMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDatas", "datas", "", "Companion", "StoryAlbumItemViewHolder", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.d */
public final class C39918d extends C41523a<C29336b> {
    private static final String TAG = TAG;
    public static final C29335a sgp = new C29335a();
    C17126b<? super C22213h, C37091y> sgd;
    final ArrayList<C22213h> sgo = new ArrayList();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.d$a */
    public static final class C29335a {
        private C29335a() {
        }

        public /* synthetic */ C29335a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.d$b */
    public final class C29336b extends C41531v {
        TextView nDX;
        ImageView sgq;
        ImageView sgr;
        final /* synthetic */ C39918d sgs;

        public C29336b(C39918d c39918d, View view) {
            C25052j.m39376p(view, "view");
            this.sgs = c39918d;
            super(view);
            AppMethodBeat.m2504i(110161);
            View findViewById = view.findViewById(2131828003);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.album_story_item_media_img)");
            this.sgq = (ImageView) findViewById;
            findViewById = view.findViewById(2131828004);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.a…_story_item_multiple_tip)");
            this.sgr = (ImageView) findViewById;
            findViewById = view.findViewById(2131828005);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.album_story_item_count_tv)");
            this.nDX = (TextView) findViewById;
            AppMethodBeat.m2505o(110161);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.d$c */
    static final class C39919c implements OnClickListener {
        final /* synthetic */ C39918d sgs;

        C39919c(C39918d c39918d) {
            this.sgs = c39918d;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110162);
            C25052j.m39375o(view, "view");
            if (view.getTag() != null && (view.getTag() instanceof C22213h)) {
                C17126b c17126b = this.sgs.sgd;
                if (c17126b != null) {
                    Object tag = view.getTag();
                    if (tag == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryHistoryInfo");
                        AppMethodBeat.m2505o(110162);
                        throw c44941v;
                    }
                    c17126b.mo50am((C22213h) tag);
                    AppMethodBeat.m2505o(110162);
                    return;
                }
            }
            AppMethodBeat.m2505o(110162);
        }
    }

    public C39918d() {
        AppMethodBeat.m2504i(110166);
        AppMethodBeat.m2505o(110166);
    }

    static {
        AppMethodBeat.m2504i(110167);
        AppMethodBeat.m2505o(110167);
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(110164);
        int size = this.sgo.size();
        AppMethodBeat.m2505o(110164);
        return size;
    }
}
