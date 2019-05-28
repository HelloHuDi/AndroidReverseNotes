package com.tencent.p177mm.plugin.story.p536ui.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C22175b;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C29279a;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p530f.C43633m;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p536ui.StoryBrowseUI;
import com.tencent.p177mm.plugin.story.p536ui.album.StoryFavoritePanel.C22258c;
import com.tencent.p177mm.plugin.story.p536ui.album.StoryFavoritePanel.C35235a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0005j\b\u0012\u0004\u0012\u00020\u000f`\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\b\u0010 \u001a\u00020\u0015H\u0016J\u001e\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#2\u0006\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u0015H\u0014R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI */
public final class StoryFavAlbumUI extends MMActivity implements C22175b {
    private static final String TAG = TAG;
    public static final C4159a sgG = new C4159a();
    private boolean czr = true;
    private TextView gJE;
    private String igi = "";
    private ArrayList<C39879j> sgD = new ArrayList();
    private StoryFavoritePanel sgE;
    private C29279a sgF;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI$a */
    public static final class C4159a {
        private C4159a() {
        }

        public /* synthetic */ C4159a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI$b */
    static final class C4160b implements OnMenuItemClickListener {
        final /* synthetic */ StoryFavAlbumUI sgH;

        C4160b(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(138866);
            this.sgH.finish();
            AppMethodBeat.m2505o(138866);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI$d */
    static final class C4161d extends C25053k implements C17126b<C22258c, C37091y> {
        final /* synthetic */ StoryFavAlbumUI sgH;

        C4161d(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(138868);
            C25052j.m39376p((C22258c) obj, "storyFavInfo");
            StoryFavAlbumUI.m21975b(this.sgH);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138868);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI$c */
    static final class C13826c implements OnClickListener {
        final /* synthetic */ StoryFavAlbumUI sgH;

        C13826c(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138867);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.sgH.igi);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
            C25985d.m41467b((Context) this.sgH, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.m2505o(138867);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI$e */
    static final class C13827e extends C25053k implements C31591m<C22258c, Integer, C37091y> {
        final /* synthetic */ StoryFavAlbumUI sgH;

        C13827e(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(138869);
            C22258c c22258c = (C22258c) obj;
            ((Number) obj2).intValue();
            C25052j.m39376p(c22258c, "storyFavInfo");
            ArrayList arrayList = new ArrayList();
            int size = this.sgH.sgD.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (c22258c.rXz != null && c22258c.rXz.field_storyID == ((C39879j) this.sgH.sgD.get(i)).field_storyID) {
                    i2 = i;
                }
                C22178a c22178a = C22177b.rRO;
                arrayList.add(C22178a.m33804j(Integer.valueOf(((C39879j) this.sgH.sgD.get(i)).field_createTime)));
                i++;
            }
            StoryFavAlbumUI.m21974a(this.sgH, i2, arrayList);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138869);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI$f */
    public static final class C13828f extends C46924e {
        final /* synthetic */ StoryFavAlbumUI sgH;

        C13828f(StoryFavAlbumUI storyFavAlbumUI) {
            this.sgH = storyFavAlbumUI;
        }

        /* renamed from: KB */
        public final void mo17280KB() {
            AppMethodBeat.m2504i(138870);
            StoryFavAlbumUI.m21977d(this.sgH).cxk();
            AppMethodBeat.m2505o(138870);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public StoryFavAlbumUI() {
        AppMethodBeat.m2504i(138876);
        AppMethodBeat.m2505o(138876);
    }

    /* renamed from: d */
    public static final /* synthetic */ C29279a m21977d(StoryFavAlbumUI storyFavAlbumUI) {
        AppMethodBeat.m2504i(138879);
        C29279a c29279a = storyFavAlbumUI.sgF;
        if (c29279a == null) {
            C25052j.avw("mPresenter");
        }
        AppMethodBeat.m2505o(138879);
        return c29279a;
    }

    static {
        AppMethodBeat.m2504i(138107);
        AppMethodBeat.m2505o(138107);
    }

    public final int getLayoutId() {
        return 2130970848;
    }

    /* JADX WARNING: Missing block: B:3:0x0019, code skipped:
            if (r0 == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(Bundle bundle) {
        String stringExtra;
        AppMethodBeat.m2504i(138871);
        dxR();
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            stringExtra = intent.getStringExtra("username");
        }
        stringExtra = "";
        this.igi = stringExtra;
        C4990ab.m7416i(TAG, "initViews username=" + this.igi);
        Object obj = C1720g.m3536RP().mo5239Ry().get(2);
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.m2505o(138871);
            throw c44941v;
        }
        this.czr = C5046bo.isEqual((String) obj, this.igi);
        if (this.czr) {
            setMMTitle((int) C25738R.string.g9y);
        } else {
            CharSequence charSequence;
            View findViewById;
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
            C7616ad aoO = ((C6982j) K).mo15369XM().aoO(this.igi);
            Context dxU = dxU();
            if (aoO != null) {
                String Oj = aoO.mo16707Oj();
                if (Oj != null) {
                    charSequence = Oj;
                    findViewById = findViewById(16908308);
                    C25052j.m39375o(findViewById, "findViewById<TextView>(android.R.id.text1)");
                    setMMTitle(C44089j.m79293b(dxU, charSequence, ((TextView) findViewById).getTextSize()) + getString(C25738R.string.g9z));
                }
            }
            charSequence = "";
            findViewById = findViewById(16908308);
            C25052j.m39375o(findViewById, "findViewById<TextView>(android.R.id.text1)");
            setMMTitle(C44089j.m79293b(dxU, charSequence, ((TextView) findViewById).getTextSize()) + getString(C25738R.string.g9z));
        }
        setBackBtn(new C4160b(this));
        this.sgF = new C43633m(this);
        C29279a c29279a = this.sgF;
        if (c29279a == null) {
            C25052j.avw("mPresenter");
        }
        c29279a.onCreate(this.igi);
        this.gJE = (TextView) findViewById(2131827990);
        TextView textView;
        if (this.czr) {
            textView = this.gJE;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.gJE;
            if (textView2 != null) {
                textView2.setText(Html.fromHtml(getResources().getString(C25738R.string.g9s)));
            }
            textView2 = this.gJE;
            if (textView2 != null) {
                textView2.setOnClickListener(new C13826c(this));
            }
        } else {
            textView = this.gJE;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        this.sgE = (StoryFavoritePanel) findViewById(2131827991);
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel != null) {
            C35235a c35235a = StoryFavoritePanel.sgX;
            storyFavoritePanel.setup(StoryFavoritePanel.sgV);
        }
        StoryFavoritePanel storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 != null) {
            storyFavoritePanel2.setMOnAddItemClickListener(new C4161d(this));
        }
        storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 != null) {
            storyFavoritePanel2.setMOnFavItemClickListener(new C13827e(this));
        }
        storyFavoritePanel2 = this.sgE;
        if (storyFavoritePanel2 != null) {
            storyFavoritePanel2.mo55872a((C41530m) new C13828f(this));
        }
        c29279a = this.sgF;
        if (c29279a == null) {
            C25052j.avw("mPresenter");
        }
        c29279a.cxl();
        c29279a = this.sgF;
        if (c29279a == null) {
            C25052j.avw("mPresenter");
        }
        c29279a.cxm();
        AppMethodBeat.m2505o(138871);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(138872);
        super.onResume();
        C29279a c29279a = this.sgF;
        if (c29279a == null) {
            C25052j.avw("mPresenter");
        }
        c29279a.cxm();
        AppMethodBeat.m2505o(138872);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(138873);
        super.onDestroy();
        C29279a c29279a = this.sgF;
        if (c29279a == null) {
            C25052j.avw("mPresenter");
        }
        c29279a.bMO();
        AppMethodBeat.m2505o(138873);
    }

    /* renamed from: f */
    public final void mo26005f(List<C39879j> list, boolean z) {
        AppMethodBeat.m2504i(138874);
        C25052j.m39376p(list, "datas");
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
                C25052j.m39375o(dxU, "context");
                String string = dxU.getResources().getString(C25738R.string.g9x);
                C25052j.m39375o(string, "context.resources.getStr…album_favorite_empty_tip)");
                storyFavoritePanel.abd(string);
                AppMethodBeat.m2505o(138874);
                return;
            }
            AppMethodBeat.m2505o(138874);
            return;
        }
        this.sgD.clear();
        this.sgD.addAll(list);
        storyFavoritePanel = this.sgE;
        if (storyFavoritePanel != null) {
            storyFavoritePanel.mo55875g(list, this.czr);
            AppMethodBeat.m2505o(138874);
            return;
        }
        AppMethodBeat.m2505o(138874);
    }

    public final void cxn() {
        AppMethodBeat.m2504i(138875);
        StoryFavoritePanel storyFavoritePanel = this.sgE;
        if (storyFavoritePanel != null) {
            storyFavoritePanel.cxn();
            AppMethodBeat.m2505o(138875);
            return;
        }
        AppMethodBeat.m2505o(138875);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m21975b(StoryFavAlbumUI storyFavAlbumUI) {
        AppMethodBeat.m2504i(138877);
        storyFavAlbumUI.startActivityForResult(new Intent(storyFavAlbumUI, StoryFavSelectUI.class), 2);
        AppMethodBeat.m2505o(138877);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m21974a(StoryFavAlbumUI storyFavAlbumUI, int i, ArrayList arrayList) {
        AppMethodBeat.m2504i(138878);
        long i2 = C39864o.rQN.mo55837i(arrayList, storyFavAlbumUI.igi);
        Intent intent = new Intent(storyFavAlbumUI, StoryBrowseUI.class);
        intent.putExtra("data_seed_key", i2);
        intent.putExtra("username", storyFavAlbumUI.igi);
        intent.putExtra("v_position", i);
        intent.putExtra("gallery_story_need_action", false);
        storyFavAlbumUI.startActivityForResult(intent, 3);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20743bG(15);
        AppMethodBeat.m2505o(138878);
    }
}
