package com.tencent.p177mm.plugin.story.p536ui.album;

import android.content.Context;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.GridLayoutManager.C8440b;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.loader.C18532d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1304c.C22226a;
import com.tencent.p177mm.plugin.story.model.p1304c.C24833d;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.protocal.protobuf.cea;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0006HIJKLMB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020/H\u0002J\u0006\u0010@\u001a\u00020/J\u000e\u0010A\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\fJ\u001c\u0010D\u001a\u00020/2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00060#R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR7\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103RL\u00104\u001a4\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020/\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\tXD¢\u0006\u0002\n\u0000¨\u0006N"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "VIEW_TYPE_ADD_FAV", "VIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL_FAV", "dp", "", "fromScene", "getFromScene", "()I", "setFromScene", "(I)V", "isSelf", "", "()Z", "setSelf", "(Z)V", "mDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "Lkotlin/collections/ArrayList;", "mEmptyTipTv", "Landroid/widget/TextView;", "mFavAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "mFavRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mFavTitleTv", "mIsAll", "getMIsAll", "setMIsAll", "mOnAddItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "storyFavInfo", "", "getMOnAddItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnAddItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mOnFavItemClickListener", "Lkotlin/Function2;", "position", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "spanCount", "addOnScrollListener", "listener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "init", "onIsAll", "setup", "showEmptyTip", "tip", "updateFavStory", "favoriteStory", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Companion", "StoryAlbumLoadingHolder", "StoryFavInfo", "StoryFavoriteAdapter", "StoryFavoriteAddHolder", "StoryFavoriteNormalHolder", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel */
public final class StoryFavoritePanel extends RelativeLayout {
    private static final int sgV = 0;
    private static final int sgW = 1;
    public static final C35235a sgX = new C35235a();
    private final String TAG = "MicroMsg.StoryFavoritePanel";
    private boolean czr;
    private int fromScene = sgV;
    private boolean rFn;
    private final int rUf = 2;
    private final int sgK;
    private final int sgL = 1;
    private TextView sgM;
    private TextView sgN;
    private RecyclerView sgO;
    private C35234d sgP = new C35234d();
    private final ArrayList<C22258c> sgQ = new ArrayList();
    private final float sgR = (C1338a.getDensity(getContext()) * 1.0f);
    private final int sgS = 4;
    private C31591m<? super C22258c, ? super Integer, C37091y> sgT;
    private C17126b<? super C22258c, C37091y> sgU;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "type", "", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;I)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getType", "()I", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$c */
    public static final class C22258c {
        final C39879j rXz;
        final int type;

        public C22258c(C39879j c39879j, int i) {
            this.rXz = c39879j;
            this.type = i;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAddHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$e */
    public final class C22259e extends C41531v {
        ImageView iNr;
        final /* synthetic */ StoryFavoritePanel sgY;

        public C22259e(StoryFavoritePanel storyFavoritePanel, View view) {
            C25052j.m39376p(view, "itemView");
            this.sgY = storyFavoritePanel;
            super(view);
            AppMethodBeat.m2504i(110204);
            View findViewById = view.findViewById(2131827985);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…y_album_fav_item_add_img)");
            this.iNr = (ImageView) findViewById;
            AppMethodBeat.m2505o(110204);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryAlbumLoadingHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$b */
    public final class C29326b extends C41531v {
        final /* synthetic */ StoryFavoritePanel sgY;
        ViewGroup sgi;
        ImageView sgj;

        public C29326b(StoryFavoritePanel storyFavoritePanel, View view) {
            C25052j.m39376p(view, "view");
            this.sgY = storyFavoritePanel;
            super(view);
            AppMethodBeat.m2504i(138883);
            View findViewById = view.findViewById(2131822250);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.loading_more_state)");
            this.sgi = (ViewGroup) findViewById;
            findViewById = view.findViewById(2131828002);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.album_is_all_view)");
            this.sgj = (ImageView) findViewById;
            AppMethodBeat.m2505o(138883);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$d */
    public final class C35234d extends C41523a<C41531v> {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$d$a */
        static final class C13831a implements OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ C35234d sgZ;

            C13831a(C35234d c35234d, int i) {
                this.sgZ = c35234d;
                this.exi = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(110198);
                C17126b mOnAddItemClickListener = StoryFavoritePanel.this.getMOnAddItemClickListener();
                if (mOnAddItemClickListener != null) {
                    Object obj = StoryFavoritePanel.this.sgQ.get(this.exi);
                    C25052j.m39375o(obj, "mDatas[position]");
                    mOnAddItemClickListener.mo50am(obj);
                    AppMethodBeat.m2505o(110198);
                    return;
                }
                AppMethodBeat.m2505o(110198);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$d$b */
        static final class C29327b implements OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ C35234d sgZ;

            C29327b(C35234d c35234d, int i) {
                this.sgZ = c35234d;
                this.exi = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(110199);
                C31591m mOnFavItemClickListener = StoryFavoritePanel.this.getMOnFavItemClickListener();
                if (mOnFavItemClickListener != null) {
                    Object obj = StoryFavoritePanel.this.sgQ.get(this.exi);
                    C25052j.m39375o(obj, "mDatas[position]");
                    mOnFavItemClickListener.mo212m(obj, Integer.valueOf(this.exi));
                    AppMethodBeat.m2505o(110199);
                    return;
                }
                AppMethodBeat.m2505o(110199);
            }
        }

        /* renamed from: a */
        public final C41531v mo4976a(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(110200);
            C25052j.m39376p(viewGroup, "parent");
            View inflate;
            StoryFavoritePanel storyFavoritePanel;
            C41531v c22259e;
            if (i == StoryFavoritePanel.this.sgK) {
                inflate = C5616v.m8409hu(StoryFavoritePanel.this.getContext()).inflate(2130970846, viewGroup, false);
                storyFavoritePanel = StoryFavoritePanel.this;
                C25052j.m39375o(inflate, "itemView");
                c22259e = new C22259e(storyFavoritePanel, inflate);
                AppMethodBeat.m2505o(110200);
                return c22259e;
            } else if (i == StoryFavoritePanel.this.rUf) {
                StoryFavoritePanel storyFavoritePanel2 = StoryFavoritePanel.this;
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(2130970854, viewGroup, false);
                C25052j.m39375o(inflate2, "LayoutInflater.from(pare…ng_layout, parent, false)");
                c22259e = new C29326b(storyFavoritePanel2, inflate2);
                AppMethodBeat.m2505o(110200);
                return c22259e;
            } else {
                inflate = C5616v.m8409hu(StoryFavoritePanel.this.getContext()).inflate(2130970847, viewGroup, false);
                storyFavoritePanel = StoryFavoritePanel.this;
                C25052j.m39375o(inflate, "itemView");
                c22259e = new C35236f(storyFavoritePanel, inflate);
                AppMethodBeat.m2505o(110200);
                return c22259e;
            }
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(110201);
            int i2 = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).type;
            AppMethodBeat.m2505o(110201);
            return i2;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(110202);
            int size = StoryFavoritePanel.this.sgQ.size();
            AppMethodBeat.m2505o(110202);
            return size;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x016f  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0142  */
        /* JADX WARNING: Missing block: B:18:0x00ab, code skipped:
            if (r0.cBX() == false) goto L_0x00ad;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo4977a(C41531v c41531v, int i) {
            Integer num = null;
            AppMethodBeat.m2504i(110203);
            C25052j.m39376p(c41531v, "holder");
            ImageView imageView;
            if (c41531v instanceof C22259e) {
                imageView = ((C22259e) c41531v).iNr;
                Context context = StoryFavoritePanel.this.getContext();
                Context context2 = StoryFavoritePanel.this.getContext();
                C25052j.m39375o(context2, "context");
                imageView.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_star, context2.getResources().getColor(C25738R.color.a24)));
                c41531v.apJ.setOnClickListener(new C13831a(this, i));
                AppMethodBeat.m2505o(110203);
                return;
            }
            if (c41531v instanceof C35236f) {
                C39879j c39879j;
                cea cea;
                int i2;
                C22178a c22178a;
                String j;
                ((C35236f) c41531v).mom.setVisibility(8);
                int fromScene = StoryFavoritePanel.this.getFromScene();
                C35235a c35235a = StoryFavoritePanel.sgX;
                if (fromScene == StoryFavoritePanel.sgW) {
                    c39879j = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                    if (c39879j == null || !c39879j.cBW()) {
                        c39879j = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                        if (c39879j != null && c39879j.cBV()) {
                            c39879j = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                            if (c39879j != null) {
                            }
                        }
                    }
                    ((C35236f) c41531v).mom.setVisibility(0);
                }
                c41531v.apJ.setOnClickListener(new C29327b(this, i));
                c39879j = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                if (c39879j != null) {
                    cfb cBR = c39879j.cBR();
                    if (cBR != null) {
                        cea = cBR.xeA;
                        if (cea != null) {
                            LinkedList linkedList = cea.wbK;
                            C25052j.m39375o(linkedList, "obj.MediaObjList");
                            if (linkedList.isEmpty()) {
                                fromScene = 0;
                            } else {
                                fromScene = 1;
                            }
                            if (fromScene != 0) {
                                String str;
                                C4133a c4133a = C43644j.rST;
                                C18532d cyc = C4133a.cyc();
                                Object obj = cea.wbK.get(0);
                                C25052j.m39375o(obj, "obj.MediaObjList[0]");
                                cek cek = (cek) obj;
                                C39879j c39879j2 = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                                if (c39879j2 != null) {
                                    str = c39879j2.field_userName;
                                } else {
                                    str = null;
                                }
                                C44222az c44222az = C44222az.xYY;
                                C25052j.m39375o(c44222az, "FROM_SCENE.storyalbum");
                                C24833d c24833d = new C24833d(cek, str, c44222az);
                                imageView = ((C35236f) c41531v).sgq;
                                C4133a c4133a2 = C43644j.rST;
                                cyc.mo33784a(c24833d, imageView, C4133a.m6464a(C22226a.FAV_SCENE));
                            }
                        }
                        c39879j = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                        if (c39879j == null) {
                            i2 = c39879j.field_createTime;
                        } else {
                            i2 = 0;
                        }
                        c22178a = C22177b.rRO;
                        j = C22178a.m33804j(Integer.valueOf(i2));
                        if (i2 != 0 || C5046bo.isNullOrNil(j)) {
                            ((C35236f) c41531v).gnf.setText("");
                            AppMethodBeat.m2505o(110203);
                            return;
                        }
                        C8902b.m16047f(((C35236f) c41531v).gnf);
                        TextView textView = ((C35236f) c41531v).gnf;
                        c22178a = C22177b.rRO;
                        Integer valueOf = Integer.valueOf(i2);
                        String format = new SimpleDateFormat(C4996ah.getContext().getString(C25738R.string.g9r)).format(new Date((valueOf != null ? (long) valueOf.intValue() : 0) * 1000));
                        C25052j.m39375o(format, "simpleDateFormat.format(date)");
                        textView.setText(format);
                        if (i - 1 >= 0 && ((C22258c) StoryFavoritePanel.this.sgQ.get(i - 1)).rXz != null) {
                            c22178a = C22177b.rRO;
                            c39879j = ((C22258c) StoryFavoritePanel.this.sgQ.get(i - 1)).rXz;
                            if (c39879j != null) {
                                num = Integer.valueOf(c39879j.field_createTime);
                            }
                            if (C5046bo.isEqual(j, C22178a.m33804j(num))) {
                                ((C35236f) c41531v).gnf.setText("");
                                AppMethodBeat.m2505o(110203);
                                return;
                            }
                        }
                    }
                }
                cea = null;
                if (cea != null) {
                }
                c39879j = ((C22258c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                if (c39879j == null) {
                }
                c22178a = C22177b.rRO;
                j = C22178a.m33804j(Integer.valueOf(i2));
                if (i2 != 0) {
                }
                ((C35236f) c41531v).gnf.setText("");
                AppMethodBeat.m2505o(110203);
                return;
            } else if (c41531v instanceof C29326b) {
                if (StoryFavoritePanel.this.getMIsAll()) {
                    ((C29326b) c41531v).sgi.setVisibility(8);
                    ((C29326b) c41531v).sgj.setVisibility(0);
                    AppMethodBeat.m2505o(110203);
                    return;
                }
                ((C29326b) c41531v).sgi.setVisibility(0);
                ((C29326b) c41531v).sgj.setVisibility(8);
            }
            AppMethodBeat.m2505o(110203);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$Companion;", "", "()V", "FAV_ALBUM_UI", "", "getFAV_ALBUM_UI", "()I", "FAV_SELECT_UI", "getFAV_SELECT_UI", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$a */
    public static final class C35235a {
        private C35235a() {
        }

        public /* synthetic */ C35235a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteNormalHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "setDateTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "mask", "getMask", "setMask", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$f */
    public final class C35236f extends C41531v {
        TextView gnf;
        ImageView mom;
        final /* synthetic */ StoryFavoritePanel sgY;
        ImageView sgq;

        public C35236f(StoryFavoritePanel storyFavoritePanel, View view) {
            C25052j.m39376p(view, "itemView");
            this.sgY = storyFavoritePanel;
            super(view);
            AppMethodBeat.m2504i(110205);
            View findViewById = view.findViewById(2131827987);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…lbum_fav_item_normal_img)");
            this.sgq = (ImageView) findViewById;
            findViewById = view.findViewById(2131827989);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…album_fav_item_normal_tv)");
            this.gnf = (TextView) findViewById;
            findViewById = view.findViewById(2131827988);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…bum_fav_item_normal_mask)");
            this.mom = (ImageView) findViewById;
            AppMethodBeat.m2505o(110205);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$init$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$g */
    public static final class C35237g extends C8440b {
        final /* synthetic */ StoryFavoritePanel sgY;

        C35237g(StoryFavoritePanel storyFavoritePanel) {
            this.sgY = storyFavoritePanel;
        }

        /* renamed from: bU */
        public final int mo18459bU(int i) {
            AppMethodBeat.m2504i(138884);
            if (this.sgY.sgP.getItemViewType(i) == this.sgY.rUf) {
                int e = this.sgY.sgS;
                AppMethodBeat.m2505o(138884);
                return e;
            }
            AppMethodBeat.m2505o(138884);
            return 1;
        }
    }

    static {
        AppMethodBeat.m2504i(138889);
        AppMethodBeat.m2505o(138889);
    }

    public final C31591m<C22258c, Integer, C37091y> getMOnFavItemClickListener() {
        return this.sgT;
    }

    public final void setMOnFavItemClickListener(C31591m<? super C22258c, ? super Integer, C37091y> c31591m) {
        this.sgT = c31591m;
    }

    public final C17126b<C22258c, C37091y> getMOnAddItemClickListener() {
        return this.sgU;
    }

    public final void setMOnAddItemClickListener(C17126b<? super C22258c, C37091y> c17126b) {
        this.sgU = c17126b;
    }

    public final boolean getMIsAll() {
        return this.rFn;
    }

    public final void setMIsAll(boolean z) {
        this.rFn = z;
    }

    public final void setSelf(boolean z) {
        this.czr = z;
    }

    public final int getFromScene() {
        return this.fromScene;
    }

    public final void setFromScene(int i) {
        this.fromScene = i;
    }

    public StoryFavoritePanel(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(110207);
        init();
        AppMethodBeat.m2505o(110207);
    }

    public StoryFavoritePanel(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110208);
        init();
        AppMethodBeat.m2505o(110208);
    }

    private final void init() {
        AppMethodBeat.m2504i(110206);
        View.inflate(getContext(), 2130970851, this);
        this.sgM = (TextView) findViewById(2131827993);
        this.sgN = (TextView) findViewById(2131827994);
        this.sgO = (RecyclerView) findViewById(2131827995);
        getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.sgS);
        gridLayoutManager.mo51941a((C8440b) new C35237g(this));
        RecyclerView recyclerView = this.sgO;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        RecyclerView recyclerView2 = this.sgO;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.sgP);
        }
        recyclerView2 = this.sgO;
        if (recyclerView2 != null) {
            recyclerView2.mo66346b((C25373h) new C13832b());
            AppMethodBeat.m2505o(110206);
            return;
        }
        AppMethodBeat.m2505o(110206);
    }

    public final void setup(int i) {
        this.fromScene = i;
    }

    /* renamed from: g */
    public final void mo55875g(List<C39879j> list, boolean z) {
        AppMethodBeat.m2504i(138885);
        C25052j.m39376p(list, "favoriteStory");
        C4990ab.m7416i(this.TAG, "updateFavStory " + list.size());
        TextView textView = this.sgN;
        if (textView != null) {
            textView.setVisibility(8);
        }
        textView = this.sgM;
        if (textView != null) {
            textView.setVisibility(0);
        }
        RecyclerView recyclerView = this.sgO;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        this.czr = z;
        this.sgQ.clear();
        if (z && this.fromScene != sgW) {
            this.sgQ.add(new C22258c(null, this.sgK));
        }
        for (C39879j c22258c : list) {
            this.sgQ.add(new C22258c(c22258c, this.sgL));
        }
        this.sgQ.add(new C22258c(null, this.rUf));
        this.sgP.notifyDataSetChanged();
        AppMethodBeat.m2505o(138885);
    }

    public final void abd(String str) {
        AppMethodBeat.m2504i(138886);
        C25052j.m39376p(str, "tip");
        TextView textView = this.sgN;
        if (textView != null) {
            textView.setVisibility(0);
        }
        textView = this.sgM;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RecyclerView recyclerView = this.sgO;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        textView = this.sgN;
        if (textView != null) {
            textView.setText(str);
            AppMethodBeat.m2505o(138886);
            return;
        }
        AppMethodBeat.m2505o(138886);
    }

    /* renamed from: a */
    public final void mo55872a(C41530m c41530m) {
        AppMethodBeat.m2504i(138887);
        C25052j.m39376p(c41530m, CastExtraArgs.LISTENER);
        RecyclerView recyclerView = this.sgO;
        if (recyclerView != null) {
            recyclerView.mo66332a(c41530m);
            AppMethodBeat.m2505o(138887);
            return;
        }
        AppMethodBeat.m2505o(138887);
    }

    public final void cxn() {
        AppMethodBeat.m2504i(138888);
        this.rFn = true;
        if (!((Collection) this.sgQ).isEmpty()) {
            this.sgP.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(138888);
    }
}
