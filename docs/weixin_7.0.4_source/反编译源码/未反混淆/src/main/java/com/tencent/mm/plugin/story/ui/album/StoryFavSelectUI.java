package com.tencent.mm.plugin.story.ui.album;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "initActionBar", "initViews", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "onSelectedFav", "storyInfo", "parseIntent", "plugin-story_release"})
public final class StoryFavSelectUI extends MMActivity implements d {
    private final String TAG = "MicroMsg.StoryFavSelectUI";
    private StoryFavoritePanel sgE;
    private com.tencent.mm.plugin.story.d.a.c sgI;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
    static final class b extends k implements m<com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c, Integer, y> {
        final /* synthetic */ StoryFavSelectUI sgJ;

        b(StoryFavSelectUI storyFavSelectUI) {
            this.sgJ = storyFavSelectUI;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(138880);
            com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c cVar = (com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c) obj;
            int intValue = ((Number) obj2).intValue();
            j.p(cVar, "storyFavInfo");
            if (cVar.rXz == null) {
                this.sgJ.TAG;
                h.dc("onSelectedFav null object, pos:".concat(String.valueOf(intValue)));
            } else {
                StoryFavSelectUI.a(this.sgJ, cVar.rXz);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138880);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$2", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    public static final class c extends e {
        final /* synthetic */ StoryFavSelectUI sgJ;

        c(StoryFavSelectUI storyFavSelectUI) {
            this.sgJ = storyFavSelectUI;
        }

        public final void KB() {
            AppMethodBeat.i(138881);
            StoryFavSelectUI.b(this.sgJ).cxk();
            AppMethodBeat.o(138881);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements OnMenuItemClickListener {
        final /* synthetic */ StoryFavSelectUI sgJ;

        a(StoryFavSelectUI storyFavSelectUI) {
            this.sgJ = storyFavSelectUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(110187);
            this.sgJ.finish();
            AppMethodBeat.o(110187);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StoryFavSelectUI() {
        AppMethodBeat.i(110196);
        AppMethodBeat.o(110196);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.story.d.a.c b(StoryFavSelectUI storyFavSelectUI) {
        AppMethodBeat.i(138882);
        com.tencent.mm.plugin.story.d.a.c cVar = storyFavSelectUI.sgI;
        if (cVar == null) {
            j.avw("mPresenter");
        }
        AppMethodBeat.o(138882);
        return cVar;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110191);
        this.sgI = new com.tencent.mm.plugin.story.f.a(this);
        com.tencent.mm.plugin.story.d.a.c cVar = this.sgI;
        if (cVar == null) {
            j.avw("mPresenter");
        }
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        cVar.onCreate(com.tencent.mm.plugin.story.model.j.a.cnk());
        super.onCreate(bundle);
        setMMTitle((int) R.string.g_i);
        setBackBtn(new a(this));
        AppMethodBeat.o(110191);
    }

    public final void onDestroy() {
        AppMethodBeat.i(110192);
        super.onDestroy();
        com.tencent.mm.plugin.story.d.a.c cVar = this.sgI;
        if (cVar == null) {
            j.avw("mPresenter");
        }
        cVar.bMO();
        AppMethodBeat.o(110192);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(110193);
        super.dealContentView(view);
        View findViewById = findViewById(R.id.epa);
        j.o(findViewById, "findViewById(R.id.album_story_favorite_panel)");
        this.sgE = (StoryFavoritePanel) findViewById;
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel == null) {
            j.avw("favPanel");
        }
        com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.a aVar = StoryFavoritePanel.sgX;
        storyFavoritePanel.setup(StoryFavoritePanel.sgW);
        StoryFavoritePanel storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 == null) {
            j.avw("favPanel");
        }
        storyFavoritePanel2.setMOnFavItemClickListener(new b(this));
        storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 == null) {
            j.avw("favPanel");
        }
        storyFavoritePanel2.a((RecyclerView.m) new c(this));
        com.tencent.mm.plugin.story.d.a.c cVar = this.sgI;
        if (cVar == null) {
            j.avw("mPresenter");
        }
        cVar.cxo();
        cVar = this.sgI;
        if (cVar == null) {
            j.avw("mPresenter");
        }
        cVar.cxl();
        AppMethodBeat.o(110193);
    }

    public final int getLayoutId() {
        return R.layout.axn;
    }

    public final void du(List<com.tencent.mm.plugin.story.h.j> list) {
        AppMethodBeat.i(110194);
        j.p(list, "datas");
        new StringBuilder("onLoadFinish datas.size").append(list.size());
        h.dQI();
        StoryFavoritePanel storyFavoritePanel;
        if (list.isEmpty()) {
            storyFavoritePanel = this.sgE;
            if (storyFavoritePanel == null) {
                j.avw("favPanel");
            }
            AppCompatActivity dxU = dxU();
            j.o(dxU, "context");
            String string = dxU.getResources().getString(R.string.g9x);
            j.o(string, "context.resources.getStr…album_favorite_empty_tip)");
            storyFavoritePanel.abd(string);
            AppMethodBeat.o(110194);
            return;
        }
        storyFavoritePanel = this.sgE;
        if (storyFavoritePanel == null) {
            j.avw("favPanel");
        }
        storyFavoritePanel.g(list, true);
        AppMethodBeat.o(110194);
    }

    public final void cxn() {
        AppMethodBeat.i(110195);
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel == null) {
            j.avw("favPanel");
        }
        storyFavoritePanel.cxn();
        AppMethodBeat.o(110195);
    }

    public static final /* synthetic */ void a(StoryFavSelectUI storyFavSelectUI, com.tencent.mm.plugin.story.h.j jVar) {
        AppMethodBeat.i(110197);
        if (jVar.cBW()) {
            com.tencent.mm.ui.base.h.J(storyFavSelectUI, storyFavSelectUI.getString(R.string.g9u), "");
            AppMethodBeat.o(110197);
        } else if (!jVar.cBV() || jVar.cBX()) {
            com.tencent.mm.plugin.story.d.a.c cVar = storyFavSelectUI.sgI;
            if (cVar == null) {
                j.avw("mPresenter");
            }
            cVar.a(jVar);
            storyFavSelectUI.setResult(-1);
            storyFavSelectUI.finish();
            AppMethodBeat.o(110197);
        } else {
            com.tencent.mm.ui.base.h.J(storyFavSelectUI, storyFavSelectUI.getString(R.string.g9v), "");
            AppMethodBeat.o(110197);
        }
    }
}
