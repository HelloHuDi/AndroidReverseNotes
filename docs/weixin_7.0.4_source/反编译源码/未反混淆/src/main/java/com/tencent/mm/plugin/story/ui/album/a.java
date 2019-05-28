package com.tencent.mm.plugin.story.ui.album;

import a.l;
import a.y;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 ?2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005?@ABCB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020\u001aJ\u000e\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\rJ\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\u000eJ\b\u0010/\u001a\u00020\u0005H\u0016J\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\u000eJ\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0016J \u00103\u001a\u00020\u00102\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\u001c\u00105\u001a\u00020\u001a2\n\u00106\u001a\u00060\u0002R\u00020\u00002\u0006\u00102\u001a\u00020\u0005H\u0016J\u001c\u00107\u001a\u00060\u0002R\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u001aJ\u0014\u0010<\u001a\u00020\u001a2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170=J\u001e\u0010>\u001a\u00020\u001a2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\fj\b\u0012\u0004\u0012\u00020\u0017`\u000eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR7\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
public final class a extends android.support.v7.widget.RecyclerView.a<e> {
    static final String TAG = TAG;
    public static final a sgf = new a();
    ArrayList<c> mItemList = new ArrayList();
    private final int rFe = 1;
    boolean rFn;
    private final String sfV = "loadingMore";
    private final String sfW = "favorite";
    private final int sfX;
    private final int sfY = 2;
    private ArrayList<j> sfZ = new ArrayList();
    private final int sga;
    private int sgb;
    boolean sgc;
    a.f.a.b<? super h, y> sgd;
    a.f.a.a<y> sge;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
    public abstract class e extends v {
        final /* synthetic */ a sgg;

        public abstract void Fh(int i);

        public e(a aVar, View view) {
            a.f.b.j.p(view, "view");
            this.sgg = aVar;
            super(view);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
    public final class c extends e {
        final /* synthetic */ a sgg;
        private ViewGroup sgi;
        private ImageView sgj;

        public c(a aVar, View view) {
            a.f.b.j.p(view, "view");
            this.sgg = aVar;
            super(aVar, view);
            AppMethodBeat.i(110144);
            View findViewById = view.findViewById(R.id.ai3);
            a.f.b.j.o(findViewById, "view.findViewById(R.id.loading_more_state)");
            this.sgi = (ViewGroup) findViewById;
            findViewById = view.findViewById(R.id.epl);
            a.f.b.j.o(findViewById, "view.findViewById(R.id.album_is_all_view)");
            this.sgj = (ImageView) findViewById;
            AppMethodBeat.o(110144);
        }

        public final void Fh(int i) {
            AppMethodBeat.i(110143);
            if (this.sgg.rFn) {
                this.sgi.setVisibility(8);
                this.sgj.setVisibility(0);
                AppMethodBeat.o(110143);
                return;
            }
            this.sgg.sgb;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (com.tencent.mm.plugin.story.model.j.a.cyd().qMA <= 0) {
                com.tencent.mm.plugin.story.e.c.a aVar2 = com.tencent.mm.plugin.story.e.c.rRS;
                SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
                String cxs = com.tencent.mm.plugin.story.e.c.rRR;
                com.tencent.mm.plugin.story.h.a.a aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                sharedPreferences.getInt(cxs, com.tencent.mm.plugin.story.h.a.scA);
            }
            this.sgi.setVisibility(0);
            this.sgj.setVisibility(8);
            AppMethodBeat.o(110143);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
    public final class b extends e {
        final /* synthetic */ a sgg;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements OnClickListener {
            final /* synthetic */ b sgh;

            a(b bVar) {
                this.sgh = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(138861);
                a.f.a.a aVar = this.sgh.sgg.sge;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(138861);
                    return;
                }
                AppMethodBeat.o(138861);
            }
        }

        public b(a aVar, View view) {
            a.f.b.j.p(view, "view");
            this.sgg = aVar;
            super(aVar, view);
            AppMethodBeat.i(110142);
            AppMethodBeat.o(110142);
        }

        public final void Fh(int i) {
            AppMethodBeat.i(110141);
            this.apJ.setOnClickListener(new a(this));
            AppMethodBeat.o(110141);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002J \u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020)H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroid/support/v7/widget/RecyclerView;", "getGridView", "()Landroid/support/v7/widget/RecyclerView;", "setGridView", "(Landroid/support/v7/widget/RecyclerView;)V", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
    public final class d extends e {
        private TextView rvH;
        private TextView rvJ;
        final /* synthetic */ a sgg;
        RecyclerView sgk;
        private d sgl = new d();
        private GridLayoutManager sgm;

        public d(a aVar, View view) {
            a.f.b.j.p(view, "view");
            this.sgg = aVar;
            super(aVar, view);
            AppMethodBeat.i(110146);
            View findViewById = view.findViewById(R.id.epg);
            a.f.b.j.o(findViewById, "view.findViewById(R.id.a…_item_decoration_year_tv)");
            this.rvJ = (TextView) findViewById;
            findViewById = view.findViewById(R.id.epi);
            a.f.b.j.o(findViewById, "view.findViewById(R.id.a…item_decoration_month_tv)");
            this.rvH = (TextView) findViewById;
            findViewById = view.findViewById(R.id.epk);
            a.f.b.j.o(findViewById, "view.findViewById(R.id.a…tem_decoration_grid_view)");
            this.sgk = (RecyclerView) findViewById;
            view.getContext();
            this.sgm = new GridLayoutManager(4);
            AppMethodBeat.o(110146);
        }

        public final void Fh(int i) {
            c cVar;
            AppMethodBeat.i(110145);
            Object obj = this.sgg.mItemList.get(i);
            a.f.b.j.o(obj, "mItemList[position]");
            c cVar2 = (c) obj;
            if (i <= 0 || bo.isEqual(((c) this.sgg.mItemList.get(i - 1)).label, this.sgg.sfW)) {
                cVar = null;
            } else {
                cVar = (c) this.sgg.mItemList.get(i - 1);
            }
            if (!this.sgg.sgc) {
                this.rvH.setVisibility(0);
                String str = cVar2.label;
                if (a.k.v.a((CharSequence) str, VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 0, false, 6) != -1) {
                    List a = a.k.v.a((CharSequence) str, new String[]{VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D});
                    if (a.size() == 2) {
                        int i2;
                        this.rvH.setText((CharSequence) a.get(1));
                        if (cVar == null || cVar.sgn.isEmpty()) {
                            i2 = 0;
                        } else {
                            i2 = ((h) cVar.sgn.get(0)).rXz.sdV;
                        }
                        String str2 = (String) a.get(0);
                        i2 /= Downloads.MIN_WAIT_FOR_NETWORK;
                        int i3 = ((h) cVar2.sgn.get(0)).rXz.sdV / Downloads.MIN_WAIT_FOR_NETWORK;
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
            d dVar = this.sgl;
            List list = cVar2.sgn;
            a.f.b.j.p(list, "datas");
            dVar.sgo.clear();
            dVar.sgo.addAll(list);
            dVar.notifyDataSetChanged();
            AppMethodBeat.o(110145);
        }
    }

    public a() {
        AppMethodBeat.i(110155);
        com.tencent.mm.plugin.story.e.b.a aVar = com.tencent.mm.plugin.story.e.b.rRO;
        this.sga = new GregorianCalendar().get(1);
        AppMethodBeat.o(110155);
    }

    static {
        AppMethodBeat.i(110156);
        AppMethodBeat.o(110156);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(110149);
        int i2;
        if (bo.isEqual(((c) this.mItemList.get(i)).label, this.sfV)) {
            i2 = this.rFe;
            AppMethodBeat.o(110149);
            return i2;
        } else if (bo.isEqual(((c) this.mItemList.get(i)).label, this.sfW)) {
            i2 = this.sfY;
            AppMethodBeat.o(110149);
            return i2;
        } else {
            i2 = this.sfX;
            AppMethodBeat.o(110149);
            return i2;
        }
    }

    public final int getItemCount() {
        AppMethodBeat.i(110150);
        int size = this.mItemList.size();
        AppMethodBeat.o(110150);
        return size;
    }

    public final void dJ(List<c> list) {
        AppMethodBeat.i(110151);
        a.f.b.j.p(list, "datas");
        ab.i(TAG, "updateDatas");
        this.mItemList.clear();
        if (com.tencent.mm.plugin.story.c.a.a.rQZ.cwU() && !this.sgc) {
            this.mItemList.add(new c(this.sfW, null, 2));
            ab.i(TAG, "updateDatas add fav");
        }
        this.mItemList.addAll(list);
        for (c cVar : this.mItemList) {
            this.sgb = cVar.sgn.size() + this.sgb;
        }
        if (!list.isEmpty()) {
            this.mItemList.add(new c(this.sfV, null, 2));
        }
        notifyDataSetChanged();
        AppMethodBeat.o(110151);
    }

    public final int e(j jVar) {
        AppMethodBeat.i(110154);
        a.f.b.j.p(jVar, "storyInfo");
        ab.d(TAG, "storyLocalId=" + ((int) jVar.xDa));
        int size = this.mItemList.size();
        int i = 0;
        loop0:
        for (int i2 = 0; i2 < size; i2++) {
            for (h hVar : ((c) this.mItemList.get(i2)).sgn) {
                if (((int) hVar.rXz.xDa) == ((int) jVar.xDa)) {
                    ab.d(TAG, "findPositionInGallery index=%s", Integer.valueOf(i));
                    AppMethodBeat.o(110154);
                    break loop0;
                }
                i++;
            }
        }
        AppMethodBeat.o(110154);
        return i;
    }
}
