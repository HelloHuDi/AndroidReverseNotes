package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.ui.a.b;
import com.tencent.mm.plugin.story.ui.a.c;
import com.tencent.mm.plugin.story.ui.a.d;
import com.tencent.mm.ui.ah;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0001CB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010-\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020/J\b\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u00020 H\u0002J\u000e\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\tJ\u0016\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020 J\u0014\u0010:\u001a\u00020 2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100<J\u000e\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020/J\u000e\u0010?\u001a\u00020 2\u0006\u0010>\u001a\u00020/J\u000e\u0010@\u001a\u00020 2\u0006\u0010>\u001a\u00020/J\u000e\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020/R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u000e\u0010+\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "snsIcon", "initWithGalleryType", "needAction", "", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showSnsIcon", "toggleActiveState", "active", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView extends RelativeLayout {
    private static final String TAG = TAG;
    public static final a soK = new a();
    private String gpx;
    private final ImageView qzh;
    final ImageView sif;
    private final ImageView snq;
    final ImageView soB;
    final RecyclerView soC;
    private final ImageView soD;
    com.tencent.mm.plugin.story.api.m.a soE;
    d<?> soF;
    com.tencent.mm.plugin.story.ui.b.a soG;
    private a.f.a.a<y> soH;
    private a.f.a.a<y> soI;
    private a.f.a.a<y> soJ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ GalleryVerticalControlView soL;

        AnonymousClass1(GalleryVerticalControlView galleryVerticalControlView) {
            this.soL = galleryVerticalControlView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110750);
            a.f.a.a onClose = this.soL.getOnClose();
            if (onClose != null) {
                onClose.invoke();
                AppMethodBeat.o(110750);
                return;
            }
            AppMethodBeat.o(110750);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView$3 */
    static final class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ GalleryVerticalControlView soL;

        AnonymousClass3(GalleryVerticalControlView galleryVerticalControlView) {
            this.soL = galleryVerticalControlView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138936);
            a.f.a.a onAllFav = this.soL.getOnAllFav();
            if (onAllFav != null) {
                onAllFav.invoke();
                AppMethodBeat.o(138936);
                return;
            }
            AppMethodBeat.o(138936);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView$2 */
    static final class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ GalleryVerticalControlView soL;

        AnonymousClass2(GalleryVerticalControlView galleryVerticalControlView) {
            this.soL = galleryVerticalControlView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110751);
            a.f.a.a onMenu = this.soL.getOnMenu();
            if (onMenu != null) {
                onMenu.invoke();
                AppMethodBeat.o(110751);
                return;
            }
            AppMethodBeat.o(110751);
        }
    }

    public GalleryVerticalControlView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110757);
        View.inflate(context, R.layout.az4, this);
        View findViewById = findViewById(R.id.euw);
        j.o(findViewById, "findViewById(R.id.story_gallery_close)");
        this.sif = (ImageView) findViewById;
        findViewById = findViewById(R.id.ev0);
        j.o(findViewById, "findViewById(R.id.story_gallery_privacy)");
        this.snq = (ImageView) findViewById;
        findViewById = findViewById(R.id.euz);
        j.o(findViewById, "findViewById(R.id.story_gallery_avatar_recycler)");
        this.soC = (RecyclerView) findViewById;
        findViewById = findViewById(R.id.eux);
        j.o(findViewById, "findViewById(R.id.story_gallery_menu)");
        this.qzh = (ImageView) findViewById;
        findViewById = findViewById(R.id.ev1);
        j.o(findViewById, "findViewById(R.id.story_gallery_sns)");
        this.soB = (ImageView) findViewById;
        findViewById = findViewById(R.id.euy);
        j.o(findViewById, "findViewById(R.id.story_gallery_all_fav)");
        this.soD = (ImageView) findViewById;
        this.soC.setItemAnimator(null);
        this.qzh.setImageDrawable(ah.f(context, R.raw.icons_filled_more, -1));
        this.soD.setImageDrawable(ah.f(context, R.raw.icons_filled_contents, -1));
        this.sif.setOnClickListener(new AnonymousClass1(this));
        this.qzh.setOnClickListener(new AnonymousClass2(this));
        this.soD.setOnClickListener(new AnonymousClass3(this));
        AppMethodBeat.o(110757);
    }

    public GalleryVerticalControlView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110758);
        AppMethodBeat.o(110758);
    }

    static {
        AppMethodBeat.i(110759);
        AppMethodBeat.o(110759);
    }

    public final String getChatRoom() {
        return this.gpx;
    }

    public final void setChatRoom(String str) {
        this.gpx = str;
        d dVar = this.soF;
        if (!(dVar instanceof b)) {
            dVar = null;
        }
        b bVar = (b) dVar;
        if (bVar != null) {
            bVar.gpx = str;
        }
    }

    public final a.f.a.a<y> getOnClose() {
        return this.soH;
    }

    public final void setOnClose(a.f.a.a<y> aVar) {
        this.soH = aVar;
    }

    public final a.f.a.a<y> getOnMenu() {
        return this.soI;
    }

    public final void setOnMenu(a.f.a.a<y> aVar) {
        this.soI = aVar;
    }

    public final a.f.a.a<y> getOnAllFav() {
        return this.soJ;
    }

    public final void setOnAllFav(a.f.a.a<y> aVar) {
        this.soJ = aVar;
    }

    private final void cCH() {
        AppMethodBeat.i(138937);
        LayoutParams layoutParams = this.soC.getLayoutParams();
        if (layoutParams == null) {
            v vVar = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(138937);
            throw vVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = com.tencent.mm.bz.a.fromDPToPix(getContext(), 96);
        layoutParams2.setMarginStart(0);
        layoutParams2.setMarginEnd(0);
        layoutParams2.removeRule(17);
        layoutParams2.removeRule(21);
        layoutParams2.addRule(13);
        AppMethodBeat.o(138937);
    }

    public final void a(com.tencent.mm.plugin.story.api.m.a aVar, boolean z) {
        AppMethodBeat.i(138938);
        j.p(aVar, "galleryType");
        this.soE = aVar;
        Context context;
        LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        v vVar;
        switch (i.eQZ[aVar.ordinal()]) {
            case 1:
                this.soF = new b();
                context = getContext();
                j.o(context, "context");
                this.soG = new com.tencent.mm.plugin.story.ui.b.a(context);
                this.qzh.setVisibility(8);
                layoutParams = this.soC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(com.tencent.mm.bz.a.fromDPToPix(getContext(), 64));
                    layoutParams2.setMarginEnd(com.tencent.mm.bz.a.fromDPToPix(getContext(), 20));
                    layoutParams2.addRule(17, this.sif.getId());
                    layoutParams2.addRule(21);
                    break;
                }
                vVar = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(138938);
                throw vVar;
            case 2:
                this.soF = new c();
                context = getContext();
                j.o(context, "context");
                this.soG = new com.tencent.mm.plugin.story.ui.b.a(context);
                this.qzh.setVisibility(8);
                if (z) {
                    this.soD.setVisibility(0);
                } else {
                    this.soD.setVisibility(8);
                }
                cCH();
                break;
            case 3:
                this.soF = new c();
                context = getContext();
                j.o(context, "context");
                this.soG = new com.tencent.mm.plugin.story.ui.b.a(context);
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
                    layoutParams2.setMarginEnd(com.tencent.mm.bz.a.fromDPToPix(getContext(), 4));
                    cCH();
                    break;
                }
                vVar = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(138938);
                throw vVar;
            case 4:
                this.soF = new c();
                context = getContext();
                j.o(context, "context");
                this.soG = new com.tencent.mm.plugin.story.ui.b.a(context);
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
        AppMethodBeat.o(138938);
    }

    public final void setUserList(List<String> list) {
        AppMethodBeat.i(110754);
        j.p(list, "userList");
        d dVar = this.soF;
        if (dVar != null) {
            j.p(list, "users");
            dVar.iLD.clear();
            dVar.iLD.add("");
            dVar.iLD.addAll(list);
            dVar.iLD.add("");
        }
        dVar = this.soF;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
            AppMethodBeat.o(110754);
            return;
        }
        AppMethodBeat.o(110754);
    }

    public final void lT(boolean z) {
        AppMethodBeat.i(110755);
        if (z) {
            this.snq.setVisibility(0);
            this.snq.setImageDrawable(ah.f(getContext(), R.raw.icons_filled_lock, getResources().getColor(R.color.a29)));
            AppMethodBeat.o(110755);
            return;
        }
        this.snq.setVisibility(8);
        AppMethodBeat.o(110755);
    }

    public final void lU(boolean z) {
        AppMethodBeat.i(110756);
        if (z && com.tencent.mm.plugin.story.c.a.a.rQZ.cwU()) {
            this.snq.setVisibility(0);
            this.snq.setImageDrawable(ah.f(getContext(), R.raw.icons_filled_star, getResources().getColor(R.color.a29)));
            AppMethodBeat.o(110756);
            return;
        }
        this.snq.setVisibility(8);
        AppMethodBeat.o(110756);
    }

    public final void lL(boolean z) {
        AppMethodBeat.i(138940);
        if (z) {
            setVisibility(0);
            AppMethodBeat.o(138940);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(138940);
    }
}
