package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.story.api.C46269m.C29273a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C13814d;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C16874c;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C46285b;
import com.tencent.p177mm.plugin.story.p536ui.p1305b.C22261a;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0001CB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010-\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020/J\b\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u00020 H\u0002J\u000e\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\tJ\u0016\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020 J\u0014\u0010:\u001a\u00020 2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100<J\u000e\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020/J\u000e\u0010?\u001a\u00020 2\u0006\u0010>\u001a\u00020/J\u000e\u0010@\u001a\u00020 2\u0006\u0010>\u001a\u00020/J\u000e\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020/R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u000e\u0010+\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "snsIcon", "initWithGalleryType", "needAction", "", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showSnsIcon", "toggleActiveState", "active", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView */
public final class GalleryVerticalControlView extends RelativeLayout {
    private static final String TAG = TAG;
    public static final C22311a soK = new C22311a();
    private String gpx;
    private final ImageView qzh;
    final ImageView sif;
    private final ImageView snq;
    final ImageView soB;
    final RecyclerView soC;
    private final ImageView soD;
    C29273a soE;
    C13814d<?> soF;
    C22261a soG;
    private C31214a<C37091y> soH;
    private C31214a<C37091y> soI;
    private C31214a<C37091y> soJ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView$a */
    public static final class C22311a {
        private C22311a() {
        }

        public /* synthetic */ C22311a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView$1 */
    static final class C352431 implements OnClickListener {
        final /* synthetic */ GalleryVerticalControlView soL;

        C352431(GalleryVerticalControlView galleryVerticalControlView) {
            this.soL = galleryVerticalControlView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110750);
            C31214a onClose = this.soL.getOnClose();
            if (onClose != null) {
                onClose.invoke();
                AppMethodBeat.m2505o(110750);
                return;
            }
            AppMethodBeat.m2505o(110750);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView$3 */
    static final class C352443 implements OnClickListener {
        final /* synthetic */ GalleryVerticalControlView soL;

        C352443(GalleryVerticalControlView galleryVerticalControlView) {
            this.soL = galleryVerticalControlView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138936);
            C31214a onAllFav = this.soL.getOnAllFav();
            if (onAllFav != null) {
                onAllFav.invoke();
                AppMethodBeat.m2505o(138936);
                return;
            }
            AppMethodBeat.m2505o(138936);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView$2 */
    static final class C352452 implements OnClickListener {
        final /* synthetic */ GalleryVerticalControlView soL;

        C352452(GalleryVerticalControlView galleryVerticalControlView) {
            this.soL = galleryVerticalControlView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110751);
            C31214a onMenu = this.soL.getOnMenu();
            if (onMenu != null) {
                onMenu.invoke();
                AppMethodBeat.m2505o(110751);
                return;
            }
            AppMethodBeat.m2505o(110751);
        }
    }

    public GalleryVerticalControlView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110757);
        View.inflate(context, 2130970904, this);
        View findViewById = findViewById(2131828198);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_close)");
        this.sif = (ImageView) findViewById;
        findViewById = findViewById(2131828202);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_privacy)");
        this.snq = (ImageView) findViewById;
        findViewById = findViewById(2131828201);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_avatar_recycler)");
        this.soC = (RecyclerView) findViewById;
        findViewById = findViewById(2131828199);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_menu)");
        this.qzh = (ImageView) findViewById;
        findViewById = findViewById(2131828203);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_sns)");
        this.soB = (ImageView) findViewById;
        findViewById = findViewById(2131828200);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_all_fav)");
        this.soD = (ImageView) findViewById;
        this.soC.setItemAnimator(null);
        this.qzh.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_more, -1));
        this.soD.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_contents, -1));
        this.sif.setOnClickListener(new C352431(this));
        this.qzh.setOnClickListener(new C352452(this));
        this.soD.setOnClickListener(new C352443(this));
        AppMethodBeat.m2505o(110757);
    }

    public GalleryVerticalControlView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110758);
        AppMethodBeat.m2505o(110758);
    }

    static {
        AppMethodBeat.m2504i(110759);
        AppMethodBeat.m2505o(110759);
    }

    public final String getChatRoom() {
        return this.gpx;
    }

    public final void setChatRoom(String str) {
        this.gpx = str;
        C13814d c13814d = this.soF;
        if (!(c13814d instanceof C46285b)) {
            c13814d = null;
        }
        C46285b c46285b = (C46285b) c13814d;
        if (c46285b != null) {
            c46285b.gpx = str;
        }
    }

    public final C31214a<C37091y> getOnClose() {
        return this.soH;
    }

    public final void setOnClose(C31214a<C37091y> c31214a) {
        this.soH = c31214a;
    }

    public final C31214a<C37091y> getOnMenu() {
        return this.soI;
    }

    public final void setOnMenu(C31214a<C37091y> c31214a) {
        this.soI = c31214a;
    }

    public final C31214a<C37091y> getOnAllFav() {
        return this.soJ;
    }

    public final void setOnAllFav(C31214a<C37091y> c31214a) {
        this.soJ = c31214a;
    }

    private final void cCH() {
        AppMethodBeat.m2504i(138937);
        LayoutParams layoutParams = this.soC.getLayoutParams();
        if (layoutParams == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.m2505o(138937);
            throw c44941v;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = C1338a.fromDPToPix(getContext(), 96);
        layoutParams2.setMarginStart(0);
        layoutParams2.setMarginEnd(0);
        layoutParams2.removeRule(17);
        layoutParams2.removeRule(21);
        layoutParams2.addRule(13);
        AppMethodBeat.m2505o(138937);
    }

    /* renamed from: a */
    public final void mo55910a(C29273a c29273a, boolean z) {
        AppMethodBeat.m2504i(138938);
        C25052j.m39376p(c29273a, "galleryType");
        this.soE = c29273a;
        Context context;
        LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        C44941v c44941v;
        switch (C4183i.eQZ[c29273a.ordinal()]) {
            case 1:
                this.soF = new C46285b();
                context = getContext();
                C25052j.m39375o(context, "context");
                this.soG = new C22261a(context);
                this.qzh.setVisibility(8);
                layoutParams = this.soC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(C1338a.fromDPToPix(getContext(), 64));
                    layoutParams2.setMarginEnd(C1338a.fromDPToPix(getContext(), 20));
                    layoutParams2.addRule(17, this.sif.getId());
                    layoutParams2.addRule(21);
                    break;
                }
                c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.m2505o(138938);
                throw c44941v;
            case 2:
                this.soF = new C16874c();
                context = getContext();
                C25052j.m39375o(context, "context");
                this.soG = new C22261a(context);
                this.qzh.setVisibility(8);
                if (z) {
                    this.soD.setVisibility(0);
                } else {
                    this.soD.setVisibility(8);
                }
                cCH();
                break;
            case 3:
                this.soF = new C16874c();
                context = getContext();
                C25052j.m39375o(context, "context");
                this.soG = new C22261a(context);
                this.qzh.bringToFront();
                if (z) {
                    this.soD.setVisibility(0);
                } else {
                    this.soD.setVisibility(8);
                }
                layoutParams = this.soD.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.removeRule(21);
                    layoutParams2.addRule(16, this.qzh.getId());
                    layoutParams2.setMarginEnd(C1338a.fromDPToPix(getContext(), 4));
                    cCH();
                    break;
                }
                c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.m2505o(138938);
                throw c44941v;
            case 4:
                this.soF = new C16874c();
                context = getContext();
                C25052j.m39375o(context, "context");
                this.soG = new C22261a(context);
                this.qzh.bringToFront();
                cCH();
                break;
            case 5:
                this.qzh.setVisibility(8);
                break;
        }
        this.soC.setLayoutManager(this.soG);
        this.soC.setAdapter(this.soF);
        this.soC.setFocusable(false);
        AppMethodBeat.m2505o(138938);
    }

    public final void setUserList(List<String> list) {
        AppMethodBeat.m2504i(110754);
        C25052j.m39376p(list, "userList");
        C13814d c13814d = this.soF;
        if (c13814d != null) {
            C25052j.m39376p(list, "users");
            c13814d.iLD.clear();
            c13814d.iLD.add("");
            c13814d.iLD.addAll(list);
            c13814d.iLD.add("");
        }
        c13814d = this.soF;
        if (c13814d != null) {
            c13814d.notifyDataSetChanged();
            AppMethodBeat.m2505o(110754);
            return;
        }
        AppMethodBeat.m2505o(110754);
    }

    /* renamed from: lT */
    public final void mo55916lT(boolean z) {
        AppMethodBeat.m2504i(110755);
        if (z) {
            this.snq.setVisibility(0);
            this.snq.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_filled_lock, getResources().getColor(C25738R.color.a29)));
            AppMethodBeat.m2505o(110755);
            return;
        }
        this.snq.setVisibility(8);
        AppMethodBeat.m2505o(110755);
    }

    /* renamed from: lU */
    public final void mo55917lU(boolean z) {
        AppMethodBeat.m2504i(110756);
        if (z && C29274a.rQZ.cwU()) {
            this.snq.setVisibility(0);
            this.snq.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_filled_star, getResources().getColor(C25738R.color.a29)));
            AppMethodBeat.m2505o(110756);
            return;
        }
        this.snq.setVisibility(8);
        AppMethodBeat.m2505o(110756);
    }

    /* renamed from: lL */
    public final void mo55915lL(boolean z) {
        AppMethodBeat.m2504i(138940);
        if (z) {
            setVisibility(0);
            AppMethodBeat.m2505o(138940);
            return;
        }
        setVisibility(8);
        AppMethodBeat.m2505o(138940);
    }
}
