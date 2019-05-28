package com.tencent.p177mm.plugin.story.p536ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C43626e;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C43627f;
import com.tencent.p177mm.plugin.story.p530f.C29284b;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.plugin.story.p536ui.StoryBrowseUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J(\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00192\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001dj\b\u0012\u0004\u0012\u00020\u0014`\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\"\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\u0012\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\u0016\u0010/\u001a\u00020\u00162\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0016\u00103\u001a\u00020\u00162\f\u00104\u001a\b\u0012\u0004\u0012\u00020501H\u0016J\b\u00106\u001a\u000207H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.StoryAlbumUI */
public final class StoryAlbumUI extends MMFragment implements C43627f {
    private static final String TAG = TAG;
    public static final C7635a sgB = new C7635a();
    private RecyclerView aiB;
    private String igi = "";
    private C43626e sgA;
    private LinearLayout sgt;
    private LinearLayout sgu;
    private TextView sgv;
    private TextView sgw;
    private TextView sgx;
    private View sgy;
    private C29328a sgz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryAlbumUI$b */
    static final class C7634b implements OnMenuItemClickListener {
        final /* synthetic */ StoryAlbumUI sgC;

        C7634b(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(110168);
            FragmentActivity activity = this.sgC.getActivity();
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.m2505o(110168);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryAlbumUI$a */
    public static final class C7635a {
        private C7635a() {
        }

        public /* synthetic */ C7635a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryAlbumUI$c */
    static final class C7636c extends C25053k implements C17126b<C22213h, C37091y> {
        final /* synthetic */ StoryAlbumUI sgC;

        C7636c(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(110169);
            C22213h c22213h = (C22213h) obj;
            C25052j.m39376p(c22213h, "storyHistoryInfo");
            C29328a a = StoryAlbumUI.m13606a(this.sgC);
            ArrayList arrayList = new ArrayList();
            int size = a.mItemList.size();
            for (int i = 0; i < size; i++) {
                for (C22213h c22213h2 : ((C29334c) a.mItemList.get(i)).sgn) {
                    arrayList.add(c22213h2.field_date);
                    C4990ab.m7410d(C29328a.TAG, "getItemDateList add: " + c22213h2.field_date);
                }
            }
            int e = StoryAlbumUI.m13606a(this.sgC).mo47531e(c22213h.rXz);
            C7635a c7635a = StoryAlbumUI.sgB;
            C4990ab.m7416i(StoryAlbumUI.TAG, "onClickItem position=" + e + ", localId=" + ((int) c22213h.rXz.xDa) + ", storyId=" + c22213h.rXz.field_storyID + ", date=" + c22213h.field_date + ", count=" + c22213h.field_count);
            StoryAlbumUI.m13607a(this.sgC, e, arrayList);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110169);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryAlbumUI$d */
    static final class C7637d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ StoryAlbumUI sgC;

        C7637d(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(138862);
            StoryAlbumUI.m13608b(this.sgC);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138862);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryAlbumUI$e */
    public static final class C7638e extends C46924e {
        final /* synthetic */ StoryAlbumUI sgC;

        C7638e(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
        }

        /* renamed from: KB */
        public final void mo17280KB() {
            AppMethodBeat.m2504i(138863);
            StoryAlbumUI.m13609c(this.sgC).cxk();
            AppMethodBeat.m2505o(138863);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryAlbumUI$f */
    static final class C7639f implements OnClickListener {
        final /* synthetic */ StoryAlbumUI sgC;

        C7639f(StoryAlbumUI storyAlbumUI) {
            this.sgC = storyAlbumUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138864);
            StoryAlbumUI.m13608b(this.sgC);
            AppMethodBeat.m2505o(138864);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ C29328a m13606a(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.m2504i(110182);
        C29328a c29328a = storyAlbumUI.sgz;
        if (c29328a == null) {
            C25052j.avw("mStoryAlbumAdapter");
        }
        AppMethodBeat.m2505o(110182);
        return c29328a;
    }

    /* renamed from: c */
    public static final /* synthetic */ C43626e m13609c(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.m2504i(110184);
        C43626e c43626e = storyAlbumUI.sgA;
        if (c43626e == null) {
            C25052j.avw("mPresenter");
        }
        AppMethodBeat.m2505o(110184);
        return c43626e;
    }

    static {
        AppMethodBeat.m2504i(110181);
        AppMethodBeat.m2505o(110181);
    }

    private final void loadFromDB() {
        AppMethodBeat.m2504i(110173);
        C43626e c43626e = this.sgA;
        if (c43626e == null) {
            C25052j.avw("mPresenter");
        }
        c43626e.cxo();
        AppMethodBeat.m2505o(110173);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110174);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f8797f_);
        setBackBtn(new C7634b(this));
        AppMethodBeat.m2505o(110174);
    }

    /* JADX WARNING: Missing block: B:5:0x002f, code skipped:
            if (r0 == null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dealContentView(View view) {
        String stringExtra;
        AppMethodBeat.m2504i(110175);
        C25052j.m39376p(view, "v");
        super.dealContentView(view);
        this.sgA = new C29284b(this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                stringExtra = intent.getStringExtra("username");
            }
        }
        stringExtra = "";
        this.igi = stringExtra;
        C4990ab.m7416i(TAG, "initViews username=" + this.igi);
        View findViewById = view.findViewById(2131828016);
        C25052j.m39375o(findViewById, "v.findViewById(R.id.album_story_recycler)");
        this.aiB = (RecyclerView) findViewById;
        findViewById = view.findViewById(2131828006);
        C25052j.m39375o(findViewById, "v.findViewById(R.id.album_story_send_fail_layout)");
        this.sgt = (LinearLayout) findViewById;
        findViewById = view.findViewById(2131828010);
        C25052j.m39375o(findViewById, "v.findViewById(R.id.album_bubble_send_fail_layout)");
        this.sgu = (LinearLayout) findViewById;
        findViewById = view.findViewById(2131828009);
        C25052j.m39375o(findViewById, "v.findViewById(R.id.album_story_send_fail_tips)");
        this.sgv = (TextView) findViewById;
        findViewById = view.findViewById(2131828013);
        C25052j.m39375o(findViewById, "v.findViewById(R.id.album_bubble_send_fail_tips)");
        this.sgw = (TextView) findViewById;
        findViewById = view.findViewById(2131828015);
        C25052j.m39375o(findViewById, "v.findViewById(R.id.album_story_no_data_tip_tv)");
        this.sgx = (TextView) findViewById;
        findViewById = view.findViewById(2131828014);
        C25052j.m39375o(findViewById, "v.findViewById(R.id.album_story_no_data_fav_panel)");
        this.sgy = findViewById;
        this.sgz = new C29328a();
        C29328a c29328a = this.sgz;
        if (c29328a == null) {
            C25052j.avw("mStoryAlbumAdapter");
        }
        c29328a.sgd = new C7636c(this);
        c29328a = this.sgz;
        if (c29328a == null) {
            C25052j.avw("mStoryAlbumAdapter");
        }
        c29328a.sge = new C7637d(this);
        RecyclerView recyclerView = this.aiB;
        if (recyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        C29328a c29328a2 = this.sgz;
        if (c29328a2 == null) {
            C25052j.avw("mStoryAlbumAdapter");
        }
        recyclerView.setAdapter(c29328a2);
        recyclerView = this.aiB;
        if (recyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView = this.aiB;
        if (recyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        recyclerView.mo66332a((C41530m) new C7638e(this));
        View view2 = this.sgy;
        if (view2 == null) {
            C25052j.avw("mStoryFavEntrancePanel");
        }
        view2.setOnClickListener(new C7639f(this));
        C43626e c43626e = this.sgA;
        if (c43626e == null) {
            C25052j.avw("mPresenter");
        }
        c43626e.onCreate(this.igi);
        loadFromDB();
        c43626e = this.sgA;
        if (c43626e == null) {
            C25052j.avw("mPresenter");
        }
        c43626e.cxl();
        AppMethodBeat.m2505o(110175);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(110176);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7410d(TAG, "onActivityResult requestCode=" + i + " resultCode=" + i2);
        if (i == 1) {
            loadFromDB();
        }
        AppMethodBeat.m2505o(110176);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110177);
        super.onDestroy();
        C43626e c43626e = this.sgA;
        if (c43626e == null) {
            C25052j.avw("mPresenter");
        }
        c43626e.bMO();
        AppMethodBeat.m2505o(110177);
    }

    public final int getLayoutId() {
        return 2130970856;
    }

    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    /* renamed from: du */
    public final void mo17278du(List<C29334c> list) {
        View view;
        AppMethodBeat.m2504i(110178);
        C25052j.m39376p(list, "datas");
        C4990ab.m7416i(TAG, "onLoadFinish datas.size=" + list.size());
        C29328a c29328a = this.sgz;
        if (c29328a == null) {
            C25052j.avw("mStoryAlbumAdapter");
        }
        c29328a.mo47530dJ(list);
        TextView textView;
        RecyclerView recyclerView;
        if (list.isEmpty()) {
            view = this.sgy;
            if (view == null) {
                C25052j.avw("mStoryFavEntrancePanel");
            }
            view.setVisibility(0);
            textView = this.sgx;
            if (textView == null) {
                C25052j.avw("mStoryNoDataTv");
            }
            textView.setVisibility(0);
            recyclerView = this.aiB;
            if (recyclerView == null) {
                C25052j.avw("mRecyclerView");
            }
            recyclerView.setVisibility(8);
        } else {
            view = this.sgy;
            if (view == null) {
                C25052j.avw("mStoryFavEntrancePanel");
            }
            view.setVisibility(8);
            textView = this.sgx;
            if (textView == null) {
                C25052j.avw("mStoryNoDataTv");
            }
            textView.setVisibility(8);
            recyclerView = this.aiB;
            if (recyclerView == null) {
                C25052j.avw("mRecyclerView");
            }
            recyclerView.setVisibility(0);
        }
        if (!C29274a.rQZ.cwU()) {
            view = this.sgy;
            if (view == null) {
                C25052j.avw("mStoryFavEntrancePanel");
            }
            view.setVisibility(8);
        }
        AppMethodBeat.m2505o(110178);
    }

    public final void cxn() {
        AppMethodBeat.m2504i(110179);
        C29328a c29328a = this.sgz;
        if (c29328a == null) {
            C25052j.avw("mStoryAlbumAdapter");
        }
        c29328a.rFn = true;
        if (!((Collection) c29328a.mItemList).isEmpty()) {
            c29328a.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(110179);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m13607a(StoryAlbumUI storyAlbumUI, int i, ArrayList arrayList) {
        AppMethodBeat.m2504i(110183);
        Intent intent = new Intent(storyAlbumUI.getActivity(), StoryBrowseUI.class);
        intent.putExtra("username", storyAlbumUI.igi);
        intent.putExtra("user_date_list", arrayList);
        intent.putExtra("v_position", i);
        storyAlbumUI.startActivityForResult(intent, 1);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20743bG(2);
        AppMethodBeat.m2505o(110183);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m13608b(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.m2504i(138865);
        Intent intent = new Intent(storyAlbumUI.getActivity(), StoryFavAlbumUI.class);
        String str = "username";
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(2);
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.m2505o(138865);
            throw c44941v;
        }
        intent.putExtra(str, (String) obj);
        FragmentActivity activity = storyAlbumUI.getActivity();
        if (activity != null) {
            activity.startActivity(intent);
            AppMethodBeat.m2505o(138865);
            return;
        }
        AppMethodBeat.m2505o(138865);
    }
}
