package com.tencent.p177mm.plugin.story.p536ui.album;

import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p135f.C45085h;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C22176d;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C35174c;
import com.tencent.p177mm.plugin.story.p530f.C13743a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p536ui.album.StoryFavoritePanel.C22258c;
import com.tencent.p177mm.plugin.story.p536ui.album.StoryFavoritePanel.C35235a;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "initActionBar", "initViews", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "onSelectedFav", "storyInfo", "parseIntent", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI */
public final class StoryFavSelectUI extends MMActivity implements C22176d {
    private final String TAG = "MicroMsg.StoryFavSelectUI";
    private StoryFavoritePanel sgE;
    private C35174c sgI;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI$b */
    static final class C13829b extends C25053k implements C31591m<C22258c, Integer, C37091y> {
        final /* synthetic */ StoryFavSelectUI sgJ;

        C13829b(StoryFavSelectUI storyFavSelectUI) {
            this.sgJ = storyFavSelectUI;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(138880);
            C22258c c22258c = (C22258c) obj;
            int intValue = ((Number) obj2).intValue();
            C25052j.m39376p(c22258c, "storyFavInfo");
            if (c22258c.rXz == null) {
                this.sgJ.TAG;
                C45085h.m82712dc("onSelectedFav null object, pos:".concat(String.valueOf(intValue)));
            } else {
                StoryFavSelectUI.m86798a(this.sgJ, c22258c.rXz);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138880);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$2", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI$c */
    public static final class C13830c extends C46924e {
        final /* synthetic */ StoryFavSelectUI sgJ;

        C13830c(StoryFavSelectUI storyFavSelectUI) {
            this.sgJ = storyFavSelectUI;
        }

        /* renamed from: KB */
        public final void mo17280KB() {
            AppMethodBeat.m2504i(138881);
            StoryFavSelectUI.m86799b(this.sgJ).cxk();
            AppMethodBeat.m2505o(138881);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI$a */
    static final class C29325a implements OnMenuItemClickListener {
        final /* synthetic */ StoryFavSelectUI sgJ;

        C29325a(StoryFavSelectUI storyFavSelectUI) {
            this.sgJ = storyFavSelectUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(110187);
            this.sgJ.finish();
            AppMethodBeat.m2505o(110187);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public StoryFavSelectUI() {
        AppMethodBeat.m2504i(110196);
        AppMethodBeat.m2505o(110196);
    }

    /* renamed from: b */
    public static final /* synthetic */ C35174c m86799b(StoryFavSelectUI storyFavSelectUI) {
        AppMethodBeat.m2504i(138882);
        C35174c c35174c = storyFavSelectUI.sgI;
        if (c35174c == null) {
            C25052j.avw("mPresenter");
        }
        AppMethodBeat.m2505o(138882);
        return c35174c;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110191);
        this.sgI = new C13743a(this);
        C35174c c35174c = this.sgI;
        if (c35174c == null) {
            C25052j.avw("mPresenter");
        }
        C4133a c4133a = C43644j.rST;
        c35174c.onCreate(C4133a.cnk());
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.g_i);
        setBackBtn(new C29325a(this));
        AppMethodBeat.m2505o(110191);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110192);
        super.onDestroy();
        C35174c c35174c = this.sgI;
        if (c35174c == null) {
            C25052j.avw("mPresenter");
        }
        c35174c.bMO();
        AppMethodBeat.m2505o(110192);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(110193);
        super.dealContentView(view);
        View findViewById = findViewById(2131827991);
        C25052j.m39375o(findViewById, "findViewById(R.id.album_story_favorite_panel)");
        this.sgE = (StoryFavoritePanel) findViewById;
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel == null) {
            C25052j.avw("favPanel");
        }
        C35235a c35235a = StoryFavoritePanel.sgX;
        storyFavoritePanel.setup(StoryFavoritePanel.sgW);
        StoryFavoritePanel storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 == null) {
            C25052j.avw("favPanel");
        }
        storyFavoritePanel2.setMOnFavItemClickListener(new C13829b(this));
        storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 == null) {
            C25052j.avw("favPanel");
        }
        storyFavoritePanel2.mo55872a((C41530m) new C13830c(this));
        C35174c c35174c = this.sgI;
        if (c35174c == null) {
            C25052j.avw("mPresenter");
        }
        c35174c.cxo();
        c35174c = this.sgI;
        if (c35174c == null) {
            C25052j.avw("mPresenter");
        }
        c35174c.cxl();
        AppMethodBeat.m2505o(110193);
    }

    public final int getLayoutId() {
        return 2130970850;
    }

    /* renamed from: du */
    public final void mo37733du(List<C39879j> list) {
        AppMethodBeat.m2504i(110194);
        C25052j.m39376p(list, "datas");
        new StringBuilder("onLoadFinish datas.size").append(list.size());
        C45085h.dQI();
        StoryFavoritePanel storyFavoritePanel;
        if (list.isEmpty()) {
            storyFavoritePanel = this.sgE;
            if (storyFavoritePanel == null) {
                C25052j.avw("favPanel");
            }
            AppCompatActivity dxU = dxU();
            C25052j.m39375o(dxU, "context");
            String string = dxU.getResources().getString(C25738R.string.g9x);
            C25052j.m39375o(string, "context.resources.getStr…album_favorite_empty_tip)");
            storyFavoritePanel.abd(string);
            AppMethodBeat.m2505o(110194);
            return;
        }
        storyFavoritePanel = this.sgE;
        if (storyFavoritePanel == null) {
            C25052j.avw("favPanel");
        }
        storyFavoritePanel.mo55875g(list, true);
        AppMethodBeat.m2505o(110194);
    }

    public final void cxn() {
        AppMethodBeat.m2504i(110195);
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel == null) {
            C25052j.avw("favPanel");
        }
        storyFavoritePanel.cxn();
        AppMethodBeat.m2505o(110195);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m86798a(StoryFavSelectUI storyFavSelectUI, C39879j c39879j) {
        AppMethodBeat.m2504i(110197);
        if (c39879j.cBW()) {
            C30379h.m48417J(storyFavSelectUI, storyFavSelectUI.getString(C25738R.string.g9u), "");
            AppMethodBeat.m2505o(110197);
        } else if (!c39879j.cBV() || c39879j.cBX()) {
            C35174c c35174c = storyFavSelectUI.sgI;
            if (c35174c == null) {
                C25052j.avw("mPresenter");
            }
            c35174c.mo25955a(c39879j);
            storyFavSelectUI.setResult(-1);
            storyFavSelectUI.finish();
            AppMethodBeat.m2505o(110197);
        } else {
            C30379h.m48417J(storyFavSelectUI, storyFavSelectUI.getString(C25738R.string.g9v), "");
            AppMethodBeat.m2505o(110197);
        }
    }
}
