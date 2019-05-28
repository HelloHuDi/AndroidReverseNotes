package com.tencent.mm.plugin.story.ui.album;

import a.f.a.m;
import a.l;
import a.y;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.ah;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0006HIJKLMB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020/H\u0002J\u0006\u0010@\u001a\u00020/J\u000e\u0010A\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\fJ\u001c\u0010D\u001a\u00020/2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00060#R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR7\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103RL\u00104\u001a4\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020/\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\tXD¢\u0006\u0002\n\u0000¨\u0006N"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "VIEW_TYPE_ADD_FAV", "VIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL_FAV", "dp", "", "fromScene", "getFromScene", "()I", "setFromScene", "(I)V", "isSelf", "", "()Z", "setSelf", "(Z)V", "mDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "Lkotlin/collections/ArrayList;", "mEmptyTipTv", "Landroid/widget/TextView;", "mFavAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "mFavRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mFavTitleTv", "mIsAll", "getMIsAll", "setMIsAll", "mOnAddItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "storyFavInfo", "", "getMOnAddItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnAddItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mOnFavItemClickListener", "Lkotlin/Function2;", "position", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "spanCount", "addOnScrollListener", "listener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "init", "onIsAll", "setup", "showEmptyTip", "tip", "updateFavStory", "favoriteStory", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Companion", "StoryAlbumLoadingHolder", "StoryFavInfo", "StoryFavoriteAdapter", "StoryFavoriteAddHolder", "StoryFavoriteNormalHolder", "plugin-story_release"})
public final class StoryFavoritePanel extends RelativeLayout {
    private static final int sgV = 0;
    private static final int sgW = 1;
    public static final a sgX = new a();
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
    private d sgP = new d();
    private final ArrayList<c> sgQ = new ArrayList();
    private final float sgR = (com.tencent.mm.bz.a.getDensity(getContext()) * 1.0f);
    private final int sgS = 4;
    private m<? super c, ? super Integer, y> sgT;
    private a.f.a.b<? super c, y> sgU;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "type", "", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;I)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getType", "()I", "plugin-story_release"})
    public static final class c {
        final j rXz;
        final int type;

        public c(j jVar, int i) {
            this.rXz = jVar;
            this.type = i;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAddHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "plugin-story_release"})
    public final class e extends v {
        ImageView iNr;
        final /* synthetic */ StoryFavoritePanel sgY;

        public e(StoryFavoritePanel storyFavoritePanel, View view) {
            a.f.b.j.p(view, "itemView");
            this.sgY = storyFavoritePanel;
            super(view);
            AppMethodBeat.i(110204);
            View findViewById = view.findViewById(R.id.ep5);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…y_album_fav_item_add_img)");
            this.iNr = (ImageView) findViewById;
            AppMethodBeat.o(110204);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryAlbumLoadingHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "plugin-story_release"})
    public final class b extends v {
        final /* synthetic */ StoryFavoritePanel sgY;
        ViewGroup sgi;
        ImageView sgj;

        public b(StoryFavoritePanel storyFavoritePanel, View view) {
            a.f.b.j.p(view, "view");
            this.sgY = storyFavoritePanel;
            super(view);
            AppMethodBeat.i(138883);
            View findViewById = view.findViewById(R.id.ai3);
            a.f.b.j.o(findViewById, "view.findViewById(R.id.loading_more_state)");
            this.sgi = (ViewGroup) findViewById;
            findViewById = view.findViewById(R.id.epl);
            a.f.b.j.o(findViewById, "view.findViewById(R.id.album_is_all_view)");
            this.sgj = (ImageView) findViewById;
            AppMethodBeat.o(138883);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-story_release"})
    public final class d extends android.support.v7.widget.RecyclerView.a<v> {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ d sgZ;

            a(d dVar, int i) {
                this.sgZ = dVar;
                this.exi = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(110198);
                a.f.a.b mOnAddItemClickListener = StoryFavoritePanel.this.getMOnAddItemClickListener();
                if (mOnAddItemClickListener != null) {
                    Object obj = StoryFavoritePanel.this.sgQ.get(this.exi);
                    a.f.b.j.o(obj, "mDatas[position]");
                    mOnAddItemClickListener.am(obj);
                    AppMethodBeat.o(110198);
                    return;
                }
                AppMethodBeat.o(110198);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ d sgZ;

            b(d dVar, int i) {
                this.sgZ = dVar;
                this.exi = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(110199);
                m mOnFavItemClickListener = StoryFavoritePanel.this.getMOnFavItemClickListener();
                if (mOnFavItemClickListener != null) {
                    Object obj = StoryFavoritePanel.this.sgQ.get(this.exi);
                    a.f.b.j.o(obj, "mDatas[position]");
                    mOnFavItemClickListener.m(obj, Integer.valueOf(this.exi));
                    AppMethodBeat.o(110199);
                    return;
                }
                AppMethodBeat.o(110199);
            }
        }

        public final v a(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(110200);
            a.f.b.j.p(viewGroup, "parent");
            View inflate;
            StoryFavoritePanel storyFavoritePanel;
            v eVar;
            if (i == StoryFavoritePanel.this.sgK) {
                inflate = com.tencent.mm.ui.v.hu(StoryFavoritePanel.this.getContext()).inflate(R.layout.axj, viewGroup, false);
                storyFavoritePanel = StoryFavoritePanel.this;
                a.f.b.j.o(inflate, "itemView");
                eVar = new e(storyFavoritePanel, inflate);
                AppMethodBeat.o(110200);
                return eVar;
            } else if (i == StoryFavoritePanel.this.rUf) {
                StoryFavoritePanel storyFavoritePanel2 = StoryFavoritePanel.this;
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.axr, viewGroup, false);
                a.f.b.j.o(inflate2, "LayoutInflater.from(pare…ng_layout, parent, false)");
                eVar = new b(storyFavoritePanel2, inflate2);
                AppMethodBeat.o(110200);
                return eVar;
            } else {
                inflate = com.tencent.mm.ui.v.hu(StoryFavoritePanel.this.getContext()).inflate(R.layout.axk, viewGroup, false);
                storyFavoritePanel = StoryFavoritePanel.this;
                a.f.b.j.o(inflate, "itemView");
                eVar = new f(storyFavoritePanel, inflate);
                AppMethodBeat.o(110200);
                return eVar;
            }
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(110201);
            int i2 = ((c) StoryFavoritePanel.this.sgQ.get(i)).type;
            AppMethodBeat.o(110201);
            return i2;
        }

        public final int getItemCount() {
            AppMethodBeat.i(110202);
            int size = StoryFavoritePanel.this.sgQ.size();
            AppMethodBeat.o(110202);
            return size;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x016f  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0142  */
        /* JADX WARNING: Missing block: B:18:0x00ab, code skipped:
            if (r0.cBX() == false) goto L_0x00ad;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(v vVar, int i) {
            Integer num = null;
            AppMethodBeat.i(110203);
            a.f.b.j.p(vVar, "holder");
            ImageView imageView;
            if (vVar instanceof e) {
                imageView = ((e) vVar).iNr;
                Context context = StoryFavoritePanel.this.getContext();
                Context context2 = StoryFavoritePanel.this.getContext();
                a.f.b.j.o(context2, "context");
                imageView.setImageDrawable(ah.f(context, R.raw.icons_filled_star, context2.getResources().getColor(R.color.a24)));
                vVar.apJ.setOnClickListener(new a(this, i));
                AppMethodBeat.o(110203);
                return;
            }
            if (vVar instanceof f) {
                j jVar;
                cea cea;
                int i2;
                com.tencent.mm.plugin.story.e.b.a aVar;
                String j;
                ((f) vVar).mom.setVisibility(8);
                int fromScene = StoryFavoritePanel.this.getFromScene();
                a aVar2 = StoryFavoritePanel.sgX;
                if (fromScene == StoryFavoritePanel.sgW) {
                    jVar = ((c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                    if (jVar == null || !jVar.cBW()) {
                        jVar = ((c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                        if (jVar != null && jVar.cBV()) {
                            jVar = ((c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                            if (jVar != null) {
                            }
                        }
                    }
                    ((f) vVar).mom.setVisibility(0);
                }
                vVar.apJ.setOnClickListener(new b(this, i));
                jVar = ((c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                if (jVar != null) {
                    cfb cBR = jVar.cBR();
                    if (cBR != null) {
                        cea = cBR.xeA;
                        if (cea != null) {
                            LinkedList linkedList = cea.wbK;
                            a.f.b.j.o(linkedList, "obj.MediaObjList");
                            if (linkedList.isEmpty()) {
                                fromScene = 0;
                            } else {
                                fromScene = 1;
                            }
                            if (fromScene != 0) {
                                String str;
                                com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                                com.tencent.mm.loader.d cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                                Object obj = cea.wbK.get(0);
                                a.f.b.j.o(obj, "obj.MediaObjList[0]");
                                cek cek = (cek) obj;
                                j jVar2 = ((c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                                if (jVar2 != null) {
                                    str = jVar2.field_userName;
                                } else {
                                    str = null;
                                }
                                az azVar = az.xYY;
                                a.f.b.j.o(azVar, "FROM_SCENE.storyalbum");
                                com.tencent.mm.plugin.story.model.c.d dVar = new com.tencent.mm.plugin.story.model.c.d(cek, str, azVar);
                                imageView = ((f) vVar).sgq;
                                com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                                cyc.a(dVar, imageView, com.tencent.mm.plugin.story.model.j.a.a(com.tencent.mm.plugin.story.model.c.a.FAV_SCENE));
                            }
                        }
                        jVar = ((c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                        if (jVar == null) {
                            i2 = jVar.field_createTime;
                        } else {
                            i2 = 0;
                        }
                        aVar = com.tencent.mm.plugin.story.e.b.rRO;
                        j = com.tencent.mm.plugin.story.e.b.a.j(Integer.valueOf(i2));
                        if (i2 != 0 || bo.isNullOrNil(j)) {
                            ((f) vVar).gnf.setText("");
                            AppMethodBeat.o(110203);
                            return;
                        }
                        com.tencent.mm.ab.b.f(((f) vVar).gnf);
                        TextView textView = ((f) vVar).gnf;
                        aVar = com.tencent.mm.plugin.story.e.b.rRO;
                        Integer valueOf = Integer.valueOf(i2);
                        String format = new SimpleDateFormat(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.g9r)).format(new Date((valueOf != null ? (long) valueOf.intValue() : 0) * 1000));
                        a.f.b.j.o(format, "simpleDateFormat.format(date)");
                        textView.setText(format);
                        if (i - 1 >= 0 && ((c) StoryFavoritePanel.this.sgQ.get(i - 1)).rXz != null) {
                            aVar = com.tencent.mm.plugin.story.e.b.rRO;
                            jVar = ((c) StoryFavoritePanel.this.sgQ.get(i - 1)).rXz;
                            if (jVar != null) {
                                num = Integer.valueOf(jVar.field_createTime);
                            }
                            if (bo.isEqual(j, com.tencent.mm.plugin.story.e.b.a.j(num))) {
                                ((f) vVar).gnf.setText("");
                                AppMethodBeat.o(110203);
                                return;
                            }
                        }
                    }
                }
                cea = null;
                if (cea != null) {
                }
                jVar = ((c) StoryFavoritePanel.this.sgQ.get(i)).rXz;
                if (jVar == null) {
                }
                aVar = com.tencent.mm.plugin.story.e.b.rRO;
                j = com.tencent.mm.plugin.story.e.b.a.j(Integer.valueOf(i2));
                if (i2 != 0) {
                }
                ((f) vVar).gnf.setText("");
                AppMethodBeat.o(110203);
                return;
            } else if (vVar instanceof b) {
                if (StoryFavoritePanel.this.getMIsAll()) {
                    ((b) vVar).sgi.setVisibility(8);
                    ((b) vVar).sgj.setVisibility(0);
                    AppMethodBeat.o(110203);
                    return;
                }
                ((b) vVar).sgi.setVisibility(0);
                ((b) vVar).sgj.setVisibility(8);
            }
            AppMethodBeat.o(110203);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$Companion;", "", "()V", "FAV_ALBUM_UI", "", "getFAV_ALBUM_UI", "()I", "FAV_SELECT_UI", "getFAV_SELECT_UI", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteNormalHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "setDateTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "mask", "getMask", "setMask", "plugin-story_release"})
    public final class f extends v {
        TextView gnf;
        ImageView mom;
        final /* synthetic */ StoryFavoritePanel sgY;
        ImageView sgq;

        public f(StoryFavoritePanel storyFavoritePanel, View view) {
            a.f.b.j.p(view, "itemView");
            this.sgY = storyFavoritePanel;
            super(view);
            AppMethodBeat.i(110205);
            View findViewById = view.findViewById(R.id.ep7);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…lbum_fav_item_normal_img)");
            this.sgq = (ImageView) findViewById;
            findViewById = view.findViewById(R.id.ep9);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…album_fav_item_normal_tv)");
            this.gnf = (TextView) findViewById;
            findViewById = view.findViewById(R.id.ep8);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…bum_fav_item_normal_mask)");
            this.mom = (ImageView) findViewById;
            AppMethodBeat.o(110205);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$init$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-story_release"})
    public static final class g extends android.support.v7.widget.GridLayoutManager.b {
        final /* synthetic */ StoryFavoritePanel sgY;

        g(StoryFavoritePanel storyFavoritePanel) {
            this.sgY = storyFavoritePanel;
        }

        public final int bU(int i) {
            AppMethodBeat.i(138884);
            if (this.sgY.sgP.getItemViewType(i) == this.sgY.rUf) {
                int e = this.sgY.sgS;
                AppMethodBeat.o(138884);
                return e;
            }
            AppMethodBeat.o(138884);
            return 1;
        }
    }

    static {
        AppMethodBeat.i(138889);
        AppMethodBeat.o(138889);
    }

    public final m<c, Integer, y> getMOnFavItemClickListener() {
        return this.sgT;
    }

    public final void setMOnFavItemClickListener(m<? super c, ? super Integer, y> mVar) {
        this.sgT = mVar;
    }

    public final a.f.a.b<c, y> getMOnAddItemClickListener() {
        return this.sgU;
    }

    public final void setMOnAddItemClickListener(a.f.a.b<? super c, y> bVar) {
        this.sgU = bVar;
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
        a.f.b.j.p(context, "context");
        a.f.b.j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(110207);
        init();
        AppMethodBeat.o(110207);
    }

    public StoryFavoritePanel(Context context, AttributeSet attributeSet, int i) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(110208);
        init();
        AppMethodBeat.o(110208);
    }

    private final void init() {
        AppMethodBeat.i(110206);
        View.inflate(getContext(), R.layout.axo, this);
        this.sgM = (TextView) findViewById(R.id.epc);
        this.sgN = (TextView) findViewById(R.id.epd);
        this.sgO = (RecyclerView) findViewById(R.id.epe);
        getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.sgS);
        gridLayoutManager.a((android.support.v7.widget.GridLayoutManager.b) new g(this));
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
            recyclerView2.b((h) new b());
            AppMethodBeat.o(110206);
            return;
        }
        AppMethodBeat.o(110206);
    }

    public final void setup(int i) {
        this.fromScene = i;
    }

    public final void g(List<j> list, boolean z) {
        AppMethodBeat.i(138885);
        a.f.b.j.p(list, "favoriteStory");
        ab.i(this.TAG, "updateFavStory " + list.size());
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
            this.sgQ.add(new c(null, this.sgK));
        }
        for (j cVar : list) {
            this.sgQ.add(new c(cVar, this.sgL));
        }
        this.sgQ.add(new c(null, this.rUf));
        this.sgP.notifyDataSetChanged();
        AppMethodBeat.o(138885);
    }

    public final void abd(String str) {
        AppMethodBeat.i(138886);
        a.f.b.j.p(str, "tip");
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
            AppMethodBeat.o(138886);
            return;
        }
        AppMethodBeat.o(138886);
    }

    public final void a(RecyclerView.m mVar) {
        AppMethodBeat.i(138887);
        a.f.b.j.p(mVar, CastExtraArgs.LISTENER);
        RecyclerView recyclerView = this.sgO;
        if (recyclerView != null) {
            recyclerView.a(mVar);
            AppMethodBeat.o(138887);
            return;
        }
        AppMethodBeat.o(138887);
    }

    public final void cxn() {
        AppMethodBeat.i(138888);
        this.rFn = true;
        if (!((Collection) this.sgQ).isEmpty()) {
            this.sgP.notifyDataSetChanged();
        }
        AppMethodBeat.o(138888);
    }
}
