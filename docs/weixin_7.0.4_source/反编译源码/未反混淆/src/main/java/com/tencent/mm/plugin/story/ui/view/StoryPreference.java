package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.d;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.ah;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020#0&H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u000fH\u0014J\u0012\u0010.\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u00010#H\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001dH\u0014J\b\u00102\u001a\u00020(H\u0016J,\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010#2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010;\u001a\u00020(H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference extends AbsStoryPreference implements f {
    private TextView TF;
    private String igi;
    private View mView;
    private View omq;
    private StoryRoundImageView ska;
    private StoryRoundImageView skb;
    private StoryRoundImageView skc;
    private ImageView skd;
    private ImageView ske;
    private ImageView skf;
    private ViewGroup skg;
    private ViewGroup skh;
    private ViewGroup ski;
    private ArrayList<j> skj;
    private d skk;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPreference$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ StoryPreference skl;

        AnonymousClass1(StoryPreference storyPreference) {
            this.skl = storyPreference;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110451);
            StoryPreference.a(this.skl, 0);
            AppMethodBeat.o(110451);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPreference$3 */
    static final class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ StoryPreference skl;

        AnonymousClass3(StoryPreference storyPreference) {
            this.skl = storyPreference;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110453);
            StoryPreference.a(this.skl, 2);
            AppMethodBeat.o(110453);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPreference$2 */
    static final class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ StoryPreference skl;

        AnonymousClass2(StoryPreference storyPreference) {
            this.skl = storyPreference;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110452);
            StoryPreference.a(this.skl, 1);
            AppMethodBeat.o(110452);
        }
    }

    public static final /* synthetic */ void a(StoryPreference storyPreference, int i) {
        AppMethodBeat.i(110465);
        storyPreference.Fi(i);
        AppMethodBeat.o(110465);
    }

    public StoryPreference(Context context, AttributeSet attributeSet) {
        a.f.b.j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110463);
        AppMethodBeat.o(110463);
    }

    public StoryPreference(Context context, AttributeSet attributeSet, int i) {
        a.f.b.j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110464);
        View inflate = View.inflate(getContext(), R.layout.ayz, null);
        a.f.b.j.o(inflate, "View.inflate(context, R.…e_fav_panel_layout, null)");
        this.mView = inflate;
        this.skj = new ArrayList();
        this.igi = "";
        inflate = this.mView.findViewById(16908310);
        a.f.b.j.o(inflate, "mView.findViewById(android.R.id.title)");
        this.TF = (TextView) inflate;
        inflate = this.mView.findViewById(R.id.euf);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…eference_story_image_iv1)");
        this.ska = (StoryRoundImageView) inflate;
        inflate = this.mView.findViewById(R.id.eui);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…eference_story_image_iv2)");
        this.skb = (StoryRoundImageView) inflate;
        inflate = this.mView.findViewById(R.id.eul);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…eference_story_image_iv3)");
        this.skc = (StoryRoundImageView) inflate;
        inflate = this.mView.findViewById(R.id.eug);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…erence_story_image_icon1)");
        this.skd = (ImageView) inflate;
        inflate = this.mView.findViewById(R.id.euj);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…erence_story_image_icon2)");
        this.ske = (ImageView) inflate;
        inflate = this.mView.findViewById(R.id.eum);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…erence_story_image_icon3)");
        this.skf = (ImageView) inflate;
        inflate = this.mView.findViewById(R.id.eue);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
        this.skg = (ViewGroup) inflate;
        inflate = this.mView.findViewById(R.id.euh);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
        this.skh = (ViewGroup) inflate;
        inflate = this.mView.findViewById(R.id.euk);
        a.f.b.j.o(inflate, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
        this.ski = (ViewGroup) inflate;
        int fromDPToPix = a.fromDPToPix(getContext(), 8);
        this.ska.setRound(fromDPToPix);
        this.skb.setRound(fromDPToPix);
        this.skc.setRound(fromDPToPix);
        Drawable f = ah.f(getContext(), R.raw.icons_filled_play, -1);
        this.skd.setImageDrawable(f);
        this.ske.setImageDrawable(f);
        this.skf.setImageDrawable(f);
        this.ska.setOnClickListener(new AnonymousClass1(this));
        this.skb.setOnClickListener(new AnonymousClass2(this));
        this.skc.setOnClickListener(new AnonymousClass3(this));
        AppMethodBeat.o(110464);
    }

    public final void onCreate(String str) {
        AppMethodBeat.i(110455);
        if (str == null) {
            str = "";
        }
        this.igi = str;
        b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(273, (f) this);
        AppMethodBeat.o(110455);
    }

    public final void cwO() {
        AppMethodBeat.i(110456);
        n.a aVar = n.rTi;
        String str = this.igi;
        a.f.b.j.p(str, "username");
        b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        p Rg = RO.Rg();
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.a.a aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
        Rg.d((m) new com.tencent.mm.plugin.story.model.a.j(str, 0, bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk()), "", com.tencent.mm.plugin.story.h.a.sdl));
        AppMethodBeat.o(110456);
    }

    public final void cwP() {
        int i = 1;
        AppMethodBeat.i(110457);
        LayoutParams layoutParams = this.TF.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = a.al(getContext(), R.dimen.i8);
        }
        this.TF.setLayoutParams(layoutParams);
        this.skj.clear();
        ArrayList arrayList = this.skj;
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
        String str = this.igi;
        String str2 = this.igi;
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        arrayList.addAll(cxT.a(str, bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk()), 0, 3));
        this.skg.setVisibility(8);
        this.skh.setVisibility(8);
        this.ski.setVisibility(8);
        if ((!((Collection) this.skj).isEmpty() ? 1 : 0) != 0) {
            TextView textView = this.TF;
            Context context = getContext();
            a.f.b.j.o(context, "context");
            textView.setText(context.getResources().getString(R.string.g6m));
        } else {
            this.TF.setText("");
        }
        cea cea;
        LinkedList linkedList;
        com.tencent.mm.loader.d cyc;
        Object obj;
        cek cek;
        String str3;
        az azVar;
        com.tencent.mm.plugin.story.model.c.d dVar;
        StoryRoundImageView storyRoundImageView;
        ImageView imageView;
        com.tencent.mm.plugin.story.model.j.a aVar3;
        if (this.skj.size() == 1) {
            this.TF.setVisibility(0);
            this.skg.setVisibility(0);
            cea = ((j) this.skj.get(0)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                a.f.b.j.o(linkedList, "obj.MediaObjList");
                if (linkedList.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                    obj = cea.wbK.get(0);
                    a.f.b.j.o(obj, "obj.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((j) this.skj.get(0)).field_userName;
                    azVar = az.xYY;
                    a.f.b.j.o(azVar, "FROM_SCENE.storyalbum");
                    dVar = new com.tencent.mm.plugin.story.model.c.d(cek, str3, azVar);
                    storyRoundImageView = this.ska;
                    if (storyRoundImageView == null) {
                        a.f.b.j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                    cyc.a(dVar, imageView, com.tencent.mm.plugin.story.model.j.a.a(com.tencent.mm.plugin.story.model.c.a.COMMON_SCENE));
                }
            }
        } else if (this.skj.size() == 2) {
            this.TF.setVisibility(0);
            this.skg.setVisibility(0);
            this.skh.setVisibility(0);
            cea = ((j) this.skj.get(0)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                a.f.b.j.o(linkedList, "obj1.MediaObjList");
                if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                    obj = cea.wbK.get(0);
                    a.f.b.j.o(obj, "obj1.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((j) this.skj.get(0)).field_userName;
                    azVar = az.xYY;
                    a.f.b.j.o(azVar, "FROM_SCENE.storyalbum");
                    dVar = new com.tencent.mm.plugin.story.model.c.d(cek, str3, azVar);
                    storyRoundImageView = this.ska;
                    if (storyRoundImageView == null) {
                        a.f.b.j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                    cyc.a(dVar, imageView, com.tencent.mm.plugin.story.model.j.a.a(com.tencent.mm.plugin.story.model.c.a.COMMON_SCENE));
                }
            }
            cea = ((j) this.skj.get(1)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                a.f.b.j.o(linkedList, "obj2.MediaObjList");
                if (linkedList.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                    obj = cea.wbK.get(0);
                    a.f.b.j.o(obj, "obj2.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((j) this.skj.get(0)).field_userName;
                    azVar = az.xYY;
                    a.f.b.j.o(azVar, "FROM_SCENE.storyalbum");
                    dVar = new com.tencent.mm.plugin.story.model.c.d(cek, str3, azVar);
                    storyRoundImageView = this.skb;
                    if (storyRoundImageView == null) {
                        a.f.b.j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                    cyc.a(dVar, imageView, com.tencent.mm.plugin.story.model.j.a.a(com.tencent.mm.plugin.story.model.c.a.COMMON_SCENE));
                }
            }
        } else if (this.skj.size() >= 3) {
            int i2;
            this.TF.setVisibility(0);
            this.skg.setVisibility(0);
            this.skh.setVisibility(0);
            this.ski.setVisibility(0);
            cea = ((j) this.skj.get(0)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                a.f.b.j.o(linkedList, "obj1.MediaObjList");
                if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                    obj = cea.wbK.get(0);
                    a.f.b.j.o(obj, "obj1.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((j) this.skj.get(0)).field_userName;
                    azVar = az.xYY;
                    a.f.b.j.o(azVar, "FROM_SCENE.storyalbum");
                    dVar = new com.tencent.mm.plugin.story.model.c.d(cek, str3, azVar);
                    storyRoundImageView = this.ska;
                    if (storyRoundImageView == null) {
                        a.f.b.j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                    cyc.a(dVar, imageView, com.tencent.mm.plugin.story.model.j.a.a(com.tencent.mm.plugin.story.model.c.a.COMMON_SCENE));
                }
            }
            cea = ((j) this.skj.get(1)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                a.f.b.j.o(linkedList, "obj2.MediaObjList");
                if (linkedList.isEmpty()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                    obj = cea.wbK.get(0);
                    a.f.b.j.o(obj, "obj2.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((j) this.skj.get(0)).field_userName;
                    azVar = az.xYY;
                    a.f.b.j.o(azVar, "FROM_SCENE.storyalbum");
                    dVar = new com.tencent.mm.plugin.story.model.c.d(cek, str3, azVar);
                    storyRoundImageView = this.skb;
                    if (storyRoundImageView == null) {
                        a.f.b.j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                    cyc.a(dVar, imageView, com.tencent.mm.plugin.story.model.j.a.a(com.tencent.mm.plugin.story.model.c.a.COMMON_SCENE));
                }
            }
            cea = ((j) this.skj.get(2)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                a.f.b.j.o(linkedList, "obj3.MediaObjList");
                if (linkedList.isEmpty()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                    obj = cea.wbK.get(0);
                    a.f.b.j.o(obj, "obj3.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((j) this.skj.get(0)).field_userName;
                    azVar = az.xYY;
                    a.f.b.j.o(azVar, "FROM_SCENE.storyalbum");
                    dVar = new com.tencent.mm.plugin.story.model.c.d(cek, str3, azVar);
                    storyRoundImageView = this.skc;
                    if (storyRoundImageView == null) {
                        a.f.b.j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                    cyc.a(dVar, imageView, com.tencent.mm.plugin.story.model.j.a.a(com.tencent.mm.plugin.story.model.c.a.COMMON_SCENE));
                }
            }
        }
        d dVar2 = this.skk;
        if (dVar2 != null) {
            dVar2.cA(this.skj);
            AppMethodBeat.o(110457);
            return;
        }
        AppMethodBeat.o(110457);
    }

    public final void cwQ() {
        int i;
        AppMethodBeat.i(110458);
        if (this.skj.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            Fi(0);
        }
        AppMethodBeat.o(110458);
    }

    public final void onDestroy() {
        AppMethodBeat.i(110459);
        this.skk = null;
        b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(273, (f) this);
        AppMethodBeat.o(110459);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(110460);
        if (mVar instanceof com.tencent.mm.plugin.story.model.a.j) {
            int i3 = ((com.tencent.mm.plugin.story.model.a.j) mVar).cvd;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            if (i3 == com.tencent.mm.plugin.story.h.a.sdl && bo.isEqual(((com.tencent.mm.plugin.story.model.a.j) mVar).userName, this.igi) && i == 0) {
                cwP();
            }
        }
        AppMethodBeat.o(110460);
    }

    public final void a(d dVar) {
        this.skk = dVar;
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(110461);
        a.f.b.j.p(viewGroup, "parent");
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            this.mView.setId(R.id.l5);
            viewGroup2.addView(this.mView, new LayoutParams(-1, -2));
            this.omq = onCreateView;
        }
        View view = this.omq;
        if (view == null) {
            a.f.b.j.dWJ();
        }
        AppMethodBeat.o(110461);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(110462);
        a.f.b.j.p(view, "view");
        super.onBindView(view);
        cwP();
        AppMethodBeat.o(110462);
    }

    private final void Fi(int i) {
        AppMethodBeat.i(110454);
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.skj) {
            com.tencent.mm.plugin.story.e.b.a aVar = com.tencent.mm.plugin.story.e.b.rRO;
            arrayList.add(com.tencent.mm.plugin.story.e.b.a.j(Integer.valueOf(jVar.field_createTime)));
        }
        long i2 = o.rQN.i(arrayList, this.igi);
        Intent intent = new Intent(getContext(), StoryBrowseUI.class);
        intent.putExtra("username", this.igi);
        intent.putExtra("data_seed_key", i2);
        intent.putExtra("v_position", i);
        intent.putExtra("gallery_story_need_action", true);
        getContext().startActivity(intent);
        h hVar = h.scu;
        h.cAs().bG(14);
        AppMethodBeat.o(110454);
    }
}
