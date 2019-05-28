package com.tencent.mm.plugin.story.ui.album;

import a.f.a.m;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0005j\b\u0012\u0004\u0012\u00020\u000f`\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\b\u0010 \u001a\u00020\u0015H\u0016J\u001e\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#2\u0006\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u0015H\u0014R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
public final class StoryFavAlbumUI extends MMActivity implements com.tencent.mm.plugin.story.d.a.b {
    private static final String TAG = TAG;
    public static final a sgG = new a();
    private boolean czr = true;
    private TextView gJE;
    private String igi = "";
    private ArrayList<j> sgD = new ArrayList();
    private StoryFavoritePanel sgE;
    private com.tencent.mm.plugin.story.d.a.a sgF;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements OnMenuItemClickListener {
        final /* synthetic */ StoryFavAlbumUI sgH;

        b(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(138866);
            this.sgH.finish();
            AppMethodBeat.o(138866);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
    static final class d extends k implements a.f.a.b<com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c, y> {
        final /* synthetic */ StoryFavAlbumUI sgH;

        d(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(138868);
            a.f.b.j.p((com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c) obj, "storyFavInfo");
            StoryFavAlbumUI.b(this.sgH);
            y yVar = y.AUy;
            AppMethodBeat.o(138868);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ StoryFavAlbumUI sgH;

        c(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138867);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.sgH.igi);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
            com.tencent.mm.bp.d.b((Context) this.sgH, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(138867);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
    static final class e extends k implements m<com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c, Integer, y> {
        final /* synthetic */ StoryFavAlbumUI sgH;

        e(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(138869);
            com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c cVar = (com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.c) obj;
            ((Number) obj2).intValue();
            a.f.b.j.p(cVar, "storyFavInfo");
            ArrayList arrayList = new ArrayList();
            int size = this.sgH.sgD.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (cVar.rXz != null && cVar.rXz.field_storyID == ((j) this.sgH.sgD.get(i)).field_storyID) {
                    i2 = i;
                }
                com.tencent.mm.plugin.story.e.b.a aVar = com.tencent.mm.plugin.story.e.b.rRO;
                arrayList.add(com.tencent.mm.plugin.story.e.b.a.j(Integer.valueOf(((j) this.sgH.sgD.get(i)).field_createTime)));
                i++;
            }
            StoryFavAlbumUI.a(this.sgH, i2, arrayList);
            y yVar = y.AUy;
            AppMethodBeat.o(138869);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    public static final class f extends e {
        final /* synthetic */ StoryFavAlbumUI sgH;

        f(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
        }

        public final void KB() {
            AppMethodBeat.i(138870);
            StoryFavAlbumUI.d(this.sgH).cxk();
            AppMethodBeat.o(138870);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StoryFavAlbumUI() {
        AppMethodBeat.i(138876);
        AppMethodBeat.o(138876);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.story.d.a.a d(StoryFavAlbumUI storyFavAlbumUI) {
        AppMethodBeat.i(138879);
        com.tencent.mm.plugin.story.d.a.a aVar = storyFavAlbumUI.sgF;
        if (aVar == null) {
            a.f.b.j.avw("mPresenter");
        }
        AppMethodBeat.o(138879);
        return aVar;
    }

    static {
        AppMethodBeat.i(138107);
        AppMethodBeat.o(138107);
    }

    public final int getLayoutId() {
        return R.layout.axl;
    }

    /* JADX WARNING: Missing block: B:3:0x0019, code skipped:
            if (r0 == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(Bundle bundle) {
        String stringExtra;
        AppMethodBeat.i(138871);
        dxR();
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            stringExtra = intent.getStringExtra("username");
        }
        stringExtra = "";
        this.igi = stringExtra;
        ab.i(TAG, "initViews username=" + this.igi);
        Object obj = g.RP().Ry().get(2);
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(138871);
            throw vVar;
        }
        this.czr = bo.isEqual((String) obj, this.igi);
        if (this.czr) {
            setMMTitle((int) R.string.g9y);
        } else {
            CharSequence charSequence;
            View findViewById;
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(this.igi);
            Context dxU = dxU();
            if (aoO != null) {
                String Oj = aoO.Oj();
                if (Oj != null) {
                    charSequence = Oj;
                    findViewById = findViewById(16908308);
                    a.f.b.j.o(findViewById, "findViewById<TextView>(android.R.id.text1)");
                    setMMTitle(com.tencent.mm.pluginsdk.ui.e.j.b(dxU, charSequence, ((TextView) findViewById).getTextSize()) + getString(R.string.g9z));
                }
            }
            charSequence = "";
            findViewById = findViewById(16908308);
            a.f.b.j.o(findViewById, "findViewById<TextView>(android.R.id.text1)");
            setMMTitle(com.tencent.mm.pluginsdk.ui.e.j.b(dxU, charSequence, ((TextView) findViewById).getTextSize()) + getString(R.string.g9z));
        }
        setBackBtn(new b(this));
        this.sgF = new com.tencent.mm.plugin.story.f.m(this);
        com.tencent.mm.plugin.story.d.a.a aVar = this.sgF;
        if (aVar == null) {
            a.f.b.j.avw("mPresenter");
        }
        aVar.onCreate(this.igi);
        this.gJE = (TextView) findViewById(R.id.ep_);
        TextView textView;
        if (this.czr) {
            textView = this.gJE;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.gJE;
            if (textView2 != null) {
                textView2.setText(Html.fromHtml(getResources().getString(R.string.g9s)));
            }
            textView2 = this.gJE;
            if (textView2 != null) {
                textView2.setOnClickListener(new c(this));
            }
        } else {
            textView = this.gJE;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        this.sgE = (StoryFavoritePanel) findViewById(R.id.epa);
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel != null) {
            com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.a aVar2 = StoryFavoritePanel.sgX;
            storyFavoritePanel.setup(StoryFavoritePanel.sgV);
        }
        StoryFavoritePanel storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 != null) {
            storyFavoritePanel2.setMOnAddItemClickListener(new d(this));
        }
        storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 != null) {
            storyFavoritePanel2.setMOnFavItemClickListener(new e(this));
        }
        storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 != null) {
            storyFavoritePanel2.a((RecyclerView.m) new f(this));
        }
        aVar = this.sgF;
        if (aVar == null) {
            a.f.b.j.avw("mPresenter");
        }
        aVar.cxl();
        aVar = this.sgF;
        if (aVar == null) {
            a.f.b.j.avw("mPresenter");
        }
        aVar.cxm();
        AppMethodBeat.o(138871);
    }

    public final void onResume() {
        AppMethodBeat.i(138872);
        super.onResume();
        com.tencent.mm.plugin.story.d.a.a aVar = this.sgF;
        if (aVar == null) {
            a.f.b.j.avw("mPresenter");
        }
        aVar.cxm();
        AppMethodBeat.o(138872);
    }

    public final void onDestroy() {
        AppMethodBeat.i(138873);
        super.onDestroy();
        com.tencent.mm.plugin.story.d.a.a aVar = this.sgF;
        if (aVar == null) {
            a.f.b.j.avw("mPresenter");
        }
        aVar.bMO();
        AppMethodBeat.o(138873);
    }

    public final void f(List<j> list, boolean z) {
        AppMethodBeat.i(138874);
        a.f.b.j.p(list, "datas");
        StoryFavoritePanel storyFavoritePanel;
        if ((!((Collection) list).isEmpty() ? 1 : null) == null && z) {
            this.sgD.clear();
            TextView textView = this.gJE;
            if (textView != null) {
                textView.setVisibility(8);
            }
            storyFavoritePanel = this.sgE;
            if (storyFavoritePanel != null) {
                AppCompatActivity dxU = dxU();
                a.f.b.j.o(dxU, "context");
                String string = dxU.getResources().getString(R.string.g9x);
                a.f.b.j.o(string, "context.resources.getStr…album_favorite_empty_tip)");
                storyFavoritePanel.abd(string);
                AppMethodBeat.o(138874);
                return;
            }
            AppMethodBeat.o(138874);
            return;
        }
        this.sgD.clear();
        this.sgD.addAll(list);
        storyFavoritePanel = this.sgE;
        if (storyFavoritePanel != null) {
            storyFavoritePanel.g(list, this.czr);
            AppMethodBeat.o(138874);
            return;
        }
        AppMethodBeat.o(138874);
    }

    public final void cxn() {
        AppMethodBeat.i(138875);
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel != null) {
            storyFavoritePanel.cxn();
            AppMethodBeat.o(138875);
            return;
        }
        AppMethodBeat.o(138875);
    }

    public static final /* synthetic */ void b(StoryFavAlbumUI storyFavAlbumUI) {
        AppMethodBeat.i(138877);
        storyFavAlbumUI.startActivityForResult(new Intent(storyFavAlbumUI, StoryFavSelectUI.class), 2);
        AppMethodBeat.o(138877);
    }

    public static final /* synthetic */ void a(StoryFavAlbumUI storyFavAlbumUI, int i, ArrayList arrayList) {
        AppMethodBeat.i(138878);
        long i2 = o.rQN.i(arrayList, storyFavAlbumUI.igi);
        Intent intent = new Intent(storyFavAlbumUI, StoryBrowseUI.class);
        intent.putExtra("data_seed_key", i2);
        intent.putExtra("username", storyFavAlbumUI.igi);
        intent.putExtra("v_position", i);
        intent.putExtra("gallery_story_need_action", false);
        storyFavAlbumUI.startActivityForResult(intent, 3);
        h hVar = h.scu;
        h.cAs().bG(15);
        AppMethodBeat.o(138878);
    }
}
