package com.tencent.p177mm.plugin.story.p536ui.album;

import android.content.SharedPreferences;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 ?2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005?@ABCB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020\u001aJ\u000e\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\rJ\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\u000eJ\b\u0010/\u001a\u00020\u0005H\u0016J\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\u000eJ\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0016J \u00103\u001a\u00020\u00102\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\u001c\u00105\u001a\u00020\u001a2\n\u00106\u001a\u00060\u0002R\u00020\u00002\u0006\u00102\u001a\u00020\u0005H\u0016J\u001c\u00107\u001a\u00060\u0002R\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u001aJ\u0014\u0010<\u001a\u00020\u001a2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170=J\u001e\u0010>\u001a\u00020\u001a2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\fj\b\u0012\u0004\u0012\u00020\u0017`\u000eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR7\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.a */
public final class C29328a extends C41523a<C22260e> {
    static final String TAG = TAG;
    public static final C29330a sgf = new C29330a();
    ArrayList<C29334c> mItemList = new ArrayList();
    private final int rFe = 1;
    boolean rFn;
    private final String sfV = "loadingMore";
    private final String sfW = "favorite";
    private final int sfX;
    private final int sfY = 2;
    private ArrayList<C39879j> sfZ = new ArrayList();
    private final int sga;
    private int sgb;
    boolean sgc;
    C17126b<? super C22213h, C37091y> sgd;
    C31214a<C37091y> sge;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.a$e */
    public abstract class C22260e extends C41531v {
        final /* synthetic */ C29328a sgg;

        /* renamed from: Fh */
        public abstract void mo37785Fh(int i);

        public C22260e(C29328a c29328a, View view) {
            C25052j.m39376p(view, "view");
            this.sgg = c29328a;
            super(view);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.a$c */
    public final class C29329c extends C22260e {
        final /* synthetic */ C29328a sgg;
        private ViewGroup sgi;
        private ImageView sgj;

        public C29329c(C29328a c29328a, View view) {
            C25052j.m39376p(view, "view");
            this.sgg = c29328a;
            super(c29328a, view);
            AppMethodBeat.m2504i(110144);
            View findViewById = view.findViewById(2131822250);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.loading_more_state)");
            this.sgi = (ViewGroup) findViewById;
            findViewById = view.findViewById(2131828002);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.album_is_all_view)");
            this.sgj = (ImageView) findViewById;
            AppMethodBeat.m2505o(110144);
        }

        /* renamed from: Fh */
        public final void mo37785Fh(int i) {
            AppMethodBeat.m2504i(110143);
            if (this.sgg.rFn) {
                this.sgi.setVisibility(8);
                this.sgj.setVisibility(0);
                AppMethodBeat.m2505o(110143);
                return;
            }
            this.sgg.sgb;
            C4133a c4133a = C43644j.rST;
            if (C4133a.cyd().qMA <= 0) {
                C29283a c29283a = C29282c.rRS;
                SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
                String cxs = C29282c.rRR;
                C35184a c35184a = C35183a.sdm;
                sharedPreferences.getInt(cxs, C35183a.scA);
            }
            this.sgi.setVisibility(0);
            this.sgj.setVisibility(8);
            AppMethodBeat.m2505o(110143);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.a$a */
    public static final class C29330a {
        private C29330a() {
        }

        public /* synthetic */ C29330a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.a$b */
    public final class C29331b extends C22260e {
        final /* synthetic */ C29328a sgg;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.album.a$b$a */
        static final class C29332a implements OnClickListener {
            final /* synthetic */ C29331b sgh;

            C29332a(C29331b c29331b) {
                this.sgh = c29331b;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(138861);
                C31214a c31214a = this.sgh.sgg.sge;
                if (c31214a != null) {
                    c31214a.invoke();
                    AppMethodBeat.m2505o(138861);
                    return;
                }
                AppMethodBeat.m2505o(138861);
            }
        }

        public C29331b(C29328a c29328a, View view) {
            C25052j.m39376p(view, "view");
            this.sgg = c29328a;
            super(c29328a, view);
            AppMethodBeat.m2504i(110142);
            AppMethodBeat.m2505o(110142);
        }

        /* renamed from: Fh */
        public final void mo37785Fh(int i) {
            AppMethodBeat.m2504i(110141);
            this.apJ.setOnClickListener(new C29332a(this));
            AppMethodBeat.m2505o(110141);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002J \u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020)H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroid/support/v7/widget/RecyclerView;", "getGridView", "()Landroid/support/v7/widget/RecyclerView;", "setGridView", "(Landroid/support/v7/widget/RecyclerView;)V", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.a$d */
    public final class C29333d extends C22260e {
        private TextView rvH;
        private TextView rvJ;
        final /* synthetic */ C29328a sgg;
        RecyclerView sgk;
        private C39918d sgl = new C39918d();
        private GridLayoutManager sgm;

        public C29333d(C29328a c29328a, View view) {
            C25052j.m39376p(view, "view");
            this.sgg = c29328a;
            super(c29328a, view);
            AppMethodBeat.m2504i(110146);
            View findViewById = view.findViewById(2131827997);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.a…_item_decoration_year_tv)");
            this.rvJ = (TextView) findViewById;
            findViewById = view.findViewById(2131827999);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.a…item_decoration_month_tv)");
            this.rvH = (TextView) findViewById;
            findViewById = view.findViewById(2131828001);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.a…tem_decoration_grid_view)");
            this.sgk = (RecyclerView) findViewById;
            view.getContext();
            this.sgm = new GridLayoutManager(4);
            AppMethodBeat.m2505o(110146);
        }

        /* renamed from: Fh */
        public final void mo37785Fh(int i) {
            C29334c c29334c;
            AppMethodBeat.m2504i(110145);
            Object obj = this.sgg.mItemList.get(i);
            C25052j.m39375o(obj, "mItemList[position]");
            C29334c c29334c2 = (C29334c) obj;
            if (i <= 0 || C5046bo.isEqual(((C29334c) this.sgg.mItemList.get(i - 1)).label, this.sgg.sfW)) {
                c29334c = null;
            } else {
                c29334c = (C29334c) this.sgg.mItemList.get(i - 1);
            }
            if (!this.sgg.sgc) {
                this.rvH.setVisibility(0);
                String str = c29334c2.label;
                if (C31820v.m51518a((CharSequence) str, VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 0, false, 6) != -1) {
                    List a = C31820v.m51524a((CharSequence) str, new String[]{VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D});
                    if (a.size() == 2) {
                        int i2;
                        this.rvH.setText((CharSequence) a.get(1));
                        if (c29334c == null || c29334c.sgn.isEmpty()) {
                            i2 = 0;
                        } else {
                            i2 = ((C22213h) c29334c.sgn.get(0)).rXz.sdV;
                        }
                        String str2 = (String) a.get(0);
                        i2 /= Downloads.MIN_WAIT_FOR_NETWORK;
                        int i3 = ((C22213h) c29334c2.sgn.get(0)).rXz.sdV / Downloads.MIN_WAIT_FOR_NETWORK;
                        if ((i2 != 0 || i3 == this.sgg.sga) && (i2 == 0 || i3 == i2)) {
                            this.rvJ.setVisibility(8);
                        } else {
                            this.rvJ.setVisibility(0);
                            this.rvJ.setText(str2);
                        }
                    }
                } else {
                    this.rvH.setText(str);
                    this.rvJ.setVisibility(8);
                }
            }
            this.sgk.setLayoutManager(this.sgm);
            this.sgk.setAdapter(this.sgl);
            this.sgl.sgd = this.sgg.sgd;
            C39918d c39918d = this.sgl;
            List list = c29334c2.sgn;
            C25052j.m39376p(list, "datas");
            c39918d.sgo.clear();
            c39918d.sgo.addAll(list);
            c39918d.notifyDataSetChanged();
            AppMethodBeat.m2505o(110145);
        }
    }

    public C29328a() {
        AppMethodBeat.m2504i(110155);
        C22178a c22178a = C22177b.rRO;
        this.sga = new GregorianCalendar().get(1);
        AppMethodBeat.m2505o(110155);
    }

    static {
        AppMethodBeat.m2504i(110156);
        AppMethodBeat.m2505o(110156);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(110149);
        int i2;
        if (C5046bo.isEqual(((C29334c) this.mItemList.get(i)).label, this.sfV)) {
            i2 = this.rFe;
            AppMethodBeat.m2505o(110149);
            return i2;
        } else if (C5046bo.isEqual(((C29334c) this.mItemList.get(i)).label, this.sfW)) {
            i2 = this.sfY;
            AppMethodBeat.m2505o(110149);
            return i2;
        } else {
            i2 = this.sfX;
            AppMethodBeat.m2505o(110149);
            return i2;
        }
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(110150);
        int size = this.mItemList.size();
        AppMethodBeat.m2505o(110150);
        return size;
    }

    /* renamed from: dJ */
    public final void mo47530dJ(List<C29334c> list) {
        AppMethodBeat.m2504i(110151);
        C25052j.m39376p(list, "datas");
        C4990ab.m7416i(TAG, "updateDatas");
        this.mItemList.clear();
        if (C29274a.rQZ.cwU() && !this.sgc) {
            this.mItemList.add(new C29334c(this.sfW, null, 2));
            C4990ab.m7416i(TAG, "updateDatas add fav");
        }
        this.mItemList.addAll(list);
        for (C29334c c29334c : this.mItemList) {
            this.sgb = c29334c.sgn.size() + this.sgb;
        }
        if (!list.isEmpty()) {
            this.mItemList.add(new C29334c(this.sfV, null, 2));
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(110151);
    }

    /* renamed from: e */
    public final int mo47531e(C39879j c39879j) {
        AppMethodBeat.m2504i(110154);
        C25052j.m39376p(c39879j, "storyInfo");
        C4990ab.m7410d(TAG, "storyLocalId=" + ((int) c39879j.xDa));
        int size = this.mItemList.size();
        int i = 0;
        loop0:
        for (int i2 = 0; i2 < size; i2++) {
            for (C22213h c22213h : ((C29334c) this.mItemList.get(i2)).sgn) {
                if (((int) c22213h.rXz.xDa) == ((int) c39879j.xDa)) {
                    C4990ab.m7411d(TAG, "findPositionInGallery index=%s", Integer.valueOf(i));
                    AppMethodBeat.m2505o(110154);
                    break loop0;
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(110154);
        return i;
    }
}
