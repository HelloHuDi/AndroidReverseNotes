package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J(\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00192\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001dj\b\u0012\u0004\u0012\u00020\u0014`\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\"\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\u0012\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\u0016\u0010/\u001a\u00020\u00162\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0016\u00103\u001a\u00020\u00162\f\u00104\u001a\b\u0012\u0004\u0012\u00020501H\u0016J\b\u00106\u001a\u000207H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "", "Companion", "plugin-story_release"})
public final class StoryAlbumUI extends MMFragment implements com.tencent.mm.plugin.story.d.a.f {
    private static final String TAG = TAG;
    public static final a sgB = new a();
    private RecyclerView aiB;
    private String igi = "";
    private com.tencent.mm.plugin.story.d.a.e sgA;
    private LinearLayout sgt;
    private LinearLayout sgu;
    private TextView sgv;
    private TextView sgw;
    private TextView sgx;
    private View sgy;
    private a sgz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements OnMenuItemClickListener {
        final /* synthetic */ StoryAlbumUI sgC;

        b(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(110168);
            FragmentActivity activity = this.sgC.getActivity();
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.o(110168);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "invoke"})
    static final class c extends k implements a.f.a.b<h, y> {
        final /* synthetic */ StoryAlbumUI sgC;

        c(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(110169);
            h hVar = (h) obj;
            j.p(hVar, "storyHistoryInfo");
            a a = StoryAlbumUI.a(this.sgC);
            ArrayList arrayList = new ArrayList();
            int size = a.mItemList.size();
            for (int i = 0; i < size; i++) {
                for (h hVar2 : ((c) a.mItemList.get(i)).sgn) {
                    arrayList.add(hVar2.field_date);
                    ab.d(a.TAG, "getItemDateList add: " + hVar2.field_date);
                }
            }
            int e = StoryAlbumUI.a(this.sgC).e(hVar.rXz);
            a aVar = StoryAlbumUI.sgB;
            ab.i(StoryAlbumUI.TAG, "onClickItem position=" + e + ", localId=" + ((int) hVar.rXz.xDa) + ", storyId=" + hVar.rXz.field_storyID + ", date=" + hVar.field_date + ", count=" + hVar.field_count);
            StoryAlbumUI.a(this.sgC, e, arrayList);
            y yVar = y.AUy;
            AppMethodBeat.o(110169);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ StoryAlbumUI sgC;

        d(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138862);
            StoryAlbumUI.b(this.sgC);
            y yVar = y.AUy;
            AppMethodBeat.o(138862);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    public static final class e extends e {
        final /* synthetic */ StoryAlbumUI sgC;

        e(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
        }

        public final void KB() {
            AppMethodBeat.i(138863);
            StoryAlbumUI.c(this.sgC).cxk();
            AppMethodBeat.o(138863);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements OnClickListener {
        final /* synthetic */ StoryAlbumUI sgC;

        f(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138864);
            StoryAlbumUI.b(this.sgC);
            AppMethodBeat.o(138864);
        }
    }

    public static final /* synthetic */ a a(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.i(110182);
        a aVar = storyAlbumUI.sgz;
        if (aVar == null) {
            j.avw("mStoryAlbumAdapter");
        }
        AppMethodBeat.o(110182);
        return aVar;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.story.d.a.e c(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.i(110184);
        com.tencent.mm.plugin.story.d.a.e eVar = storyAlbumUI.sgA;
        if (eVar == null) {
            j.avw("mPresenter");
        }
        AppMethodBeat.o(110184);
        return eVar;
    }

    static {
        AppMethodBeat.i(110181);
        AppMethodBeat.o(110181);
    }

    private final void loadFromDB() {
        AppMethodBeat.i(110173);
        com.tencent.mm.plugin.story.d.a.e eVar = this.sgA;
        if (eVar == null) {
            j.avw("mPresenter");
        }
        eVar.cxo();
        AppMethodBeat.o(110173);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110174);
        super.onCreate(bundle);
        setMMTitle((int) R.string.f_);
        setBackBtn(new b(this));
        AppMethodBeat.o(110174);
    }

    /* JADX WARNING: Missing block: B:5:0x002f, code skipped:
            if (r0 == null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dealContentView(View view) {
        String stringExtra;
        AppMethodBeat.i(110175);
        j.p(view, "v");
        super.dealContentView(view);
        this.sgA = new com.tencent.mm.plugin.story.f.b(this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                stringExtra = intent.getStringExtra("username");
            }
        }
        stringExtra = "";
        this.igi = stringExtra;
        ab.i(TAG, "initViews username=" + this.igi);
        View findViewById = view.findViewById(R.id.epz);
        j.o(findViewById, "v.findViewById(R.id.album_story_recycler)");
        this.aiB = (RecyclerView) findViewById;
        findViewById = view.findViewById(R.id.epp);
        j.o(findViewById, "v.findViewById(R.id.album_story_send_fail_layout)");
        this.sgt = (LinearLayout) findViewById;
        findViewById = view.findViewById(R.id.ept);
        j.o(findViewById, "v.findViewById(R.id.album_bubble_send_fail_layout)");
        this.sgu = (LinearLayout) findViewById;
        findViewById = view.findViewById(R.id.eps);
        j.o(findViewById, "v.findViewById(R.id.album_story_send_fail_tips)");
        this.sgv = (TextView) findViewById;
        findViewById = view.findViewById(R.id.epw);
        j.o(findViewById, "v.findViewById(R.id.album_bubble_send_fail_tips)");
        this.sgw = (TextView) findViewById;
        findViewById = view.findViewById(R.id.epy);
        j.o(findViewById, "v.findViewById(R.id.album_story_no_data_tip_tv)");
        this.sgx = (TextView) findViewById;
        findViewById = view.findViewById(R.id.epx);
        j.o(findViewById, "v.findViewById(R.id.album_story_no_data_fav_panel)");
        this.sgy = findViewById;
        this.sgz = new a();
        a aVar = this.sgz;
        if (aVar == null) {
            j.avw("mStoryAlbumAdapter");
        }
        aVar.sgd = new c(this);
        aVar = this.sgz;
        if (aVar == null) {
            j.avw("mStoryAlbumAdapter");
        }
        aVar.sge = new d(this);
        RecyclerView recyclerView = this.aiB;
        if (recyclerView == null) {
            j.avw("mRecyclerView");
        }
        a aVar2 = this.sgz;
        if (aVar2 == null) {
            j.avw("mStoryAlbumAdapter");
        }
        recyclerView.setAdapter(aVar2);
        recyclerView = this.aiB;
        if (recyclerView == null) {
            j.avw("mRecyclerView");
        }
        getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView = this.aiB;
        if (recyclerView == null) {
            j.avw("mRecyclerView");
        }
        recyclerView.a((m) new e(this));
        View view2 = this.sgy;
        if (view2 == null) {
            j.avw("mStoryFavEntrancePanel");
        }
        view2.setOnClickListener(new f(this));
        com.tencent.mm.plugin.story.d.a.e eVar = this.sgA;
        if (eVar == null) {
            j.avw("mPresenter");
        }
        eVar.onCreate(this.igi);
        loadFromDB();
        eVar = this.sgA;
        if (eVar == null) {
            j.avw("mPresenter");
        }
        eVar.cxl();
        AppMethodBeat.o(110175);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(110176);
        super.onActivityResult(i, i2, intent);
        ab.d(TAG, "onActivityResult requestCode=" + i + " resultCode=" + i2);
        if (i == 1) {
            loadFromDB();
        }
        AppMethodBeat.o(110176);
    }

    public final void onDestroy() {
        AppMethodBeat.i(110177);
        super.onDestroy();
        com.tencent.mm.plugin.story.d.a.e eVar = this.sgA;
        if (eVar == null) {
            j.avw("mPresenter");
        }
        eVar.bMO();
        AppMethodBeat.o(110177);
    }

    public final int getLayoutId() {
        return R.layout.axt;
    }

    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    public final void du(List<c> list) {
        View view;
        AppMethodBeat.i(110178);
        j.p(list, "datas");
        ab.i(TAG, "onLoadFinish datas.size=" + list.size());
        a aVar = this.sgz;
        if (aVar == null) {
            j.avw("mStoryAlbumAdapter");
        }
        aVar.dJ(list);
        TextView textView;
        RecyclerView recyclerView;
        if (list.isEmpty()) {
            view = this.sgy;
            if (view == null) {
                j.avw("mStoryFavEntrancePanel");
            }
            view.setVisibility(0);
            textView = this.sgx;
            if (textView == null) {
                j.avw("mStoryNoDataTv");
            }
            textView.setVisibility(0);
            recyclerView = this.aiB;
            if (recyclerView == null) {
                j.avw("mRecyclerView");
            }
            recyclerView.setVisibility(8);
        } else {
            view = this.sgy;
            if (view == null) {
                j.avw("mStoryFavEntrancePanel");
            }
            view.setVisibility(8);
            textView = this.sgx;
            if (textView == null) {
                j.avw("mStoryNoDataTv");
            }
            textView.setVisibility(8);
            recyclerView = this.aiB;
            if (recyclerView == null) {
                j.avw("mRecyclerView");
            }
            recyclerView.setVisibility(0);
        }
        if (!com.tencent.mm.plugin.story.c.a.a.rQZ.cwU()) {
            view = this.sgy;
            if (view == null) {
                j.avw("mStoryFavEntrancePanel");
            }
            view.setVisibility(8);
        }
        AppMethodBeat.o(110178);
    }

    public final void cxn() {
        AppMethodBeat.i(110179);
        a aVar = this.sgz;
        if (aVar == null) {
            j.avw("mStoryAlbumAdapter");
        }
        aVar.rFn = true;
        if (!((Collection) aVar.mItemList).isEmpty()) {
            aVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(110179);
    }

    public static final /* synthetic */ void a(StoryAlbumUI storyAlbumUI, int i, ArrayList arrayList) {
        AppMethodBeat.i(110183);
        Intent intent = new Intent(storyAlbumUI.getActivity(), StoryBrowseUI.class);
        intent.putExtra("username", storyAlbumUI.igi);
        intent.putExtra("user_date_list", arrayList);
        intent.putExtra("v_position", i);
        storyAlbumUI.startActivityForResult(intent, 1);
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAs().bG(2);
        AppMethodBeat.o(110183);
    }

    public static final /* synthetic */ void b(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.i(138865);
        Intent intent = new Intent(storyAlbumUI.getActivity(), StoryFavAlbumUI.class);
        String str = "username";
        com.tencent.mm.kernel.e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(2);
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(138865);
            throw vVar;
        }
        intent.putExtra(str, (String) obj);
        FragmentActivity activity = storyAlbumUI.getActivity();
        if (activity != null) {
            activity.startActivity(intent);
            AppMethodBeat.o(138865);
            return;
        }
        AppMethodBeat.o(138865);
    }
}
