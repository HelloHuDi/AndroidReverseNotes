package com.tencent.p177mm.plugin.story.p536ui.view;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.C18532d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.story.api.AbsStoryPreference;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.api.C4109d;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1304c.C22226a;
import com.tencent.p177mm.plugin.story.model.p1304c.C24833d;
import com.tencent.p177mm.plugin.story.model.p744a.C35194j;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.plugin.story.p536ui.StoryBrowseUI;
import com.tencent.p177mm.protocal.protobuf.cea;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020#0&H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u000fH\u0014J\u0012\u0010.\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u00010#H\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001dH\u0014J\b\u00102\u001a\u00020(H\u0016J,\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010#2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010;\u001a\u00020(H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPreference */
public final class StoryPreference extends AbsStoryPreference implements C1202f {
    /* renamed from: TF */
    private TextView f17908TF;
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
    private ArrayList<C39879j> skj;
    private C4109d skk;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPreference$1 */
    static final class C222911 implements OnClickListener {
        final /* synthetic */ StoryPreference skl;

        C222911(StoryPreference storyPreference) {
            this.skl = storyPreference;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110451);
            StoryPreference.m86831a(this.skl, 0);
            AppMethodBeat.m2505o(110451);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPreference$3 */
    static final class C222923 implements OnClickListener {
        final /* synthetic */ StoryPreference skl;

        C222923(StoryPreference storyPreference) {
            this.skl = storyPreference;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110453);
            StoryPreference.m86831a(this.skl, 2);
            AppMethodBeat.m2505o(110453);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPreference$2 */
    static final class C293462 implements OnClickListener {
        final /* synthetic */ StoryPreference skl;

        C293462(StoryPreference storyPreference) {
            this.skl = storyPreference;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110452);
            StoryPreference.m86831a(this.skl, 1);
            AppMethodBeat.m2505o(110452);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m86831a(StoryPreference storyPreference, int i) {
        AppMethodBeat.m2504i(110465);
        storyPreference.m86830Fi(i);
        AppMethodBeat.m2505o(110465);
    }

    public StoryPreference(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110463);
        AppMethodBeat.m2505o(110463);
    }

    public StoryPreference(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110464);
        View inflate = View.inflate(getContext(), 2130970899, null);
        C25052j.m39375o(inflate, "View.inflate(context, R.…e_fav_panel_layout, null)");
        this.mView = inflate;
        this.skj = new ArrayList();
        this.igi = "";
        inflate = this.mView.findViewById(16908310);
        C25052j.m39375o(inflate, "mView.findViewById(android.R.id.title)");
        this.f17908TF = (TextView) inflate;
        inflate = this.mView.findViewById(2131828181);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…eference_story_image_iv1)");
        this.ska = (StoryRoundImageView) inflate;
        inflate = this.mView.findViewById(2131828184);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…eference_story_image_iv2)");
        this.skb = (StoryRoundImageView) inflate;
        inflate = this.mView.findViewById(2131828187);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…eference_story_image_iv3)");
        this.skc = (StoryRoundImageView) inflate;
        inflate = this.mView.findViewById(2131828182);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…erence_story_image_icon1)");
        this.skd = (ImageView) inflate;
        inflate = this.mView.findViewById(2131828185);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…erence_story_image_icon2)");
        this.ske = (ImageView) inflate;
        inflate = this.mView.findViewById(2131828188);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…erence_story_image_icon3)");
        this.skf = (ImageView) inflate;
        inflate = this.mView.findViewById(2131828180);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
        this.skg = (ViewGroup) inflate;
        inflate = this.mView.findViewById(2131828183);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
        this.skh = (ViewGroup) inflate;
        inflate = this.mView.findViewById(2131828186);
        C25052j.m39375o(inflate, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
        this.ski = (ViewGroup) inflate;
        int fromDPToPix = C1338a.fromDPToPix(getContext(), 8);
        this.ska.setRound(fromDPToPix);
        this.skb.setRound(fromDPToPix);
        this.skc.setRound(fromDPToPix);
        Drawable f = C5225ah.m7962f(getContext(), C1318a.icons_filled_play, -1);
        this.skd.setImageDrawable(f);
        this.ske.setImageDrawable(f);
        this.skf.setImageDrawable(f);
        this.ska.setOnClickListener(new C222911(this));
        this.skb.setOnClickListener(new C293462(this));
        this.skc.setOnClickListener(new C222923(this));
        AppMethodBeat.m2505o(110464);
    }

    public final void onCreate(String str) {
        AppMethodBeat.m2504i(110455);
        if (str == null) {
            str = "";
        }
        this.igi = str;
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(273, (C1202f) this);
        AppMethodBeat.m2505o(110455);
    }

    public final void cwO() {
        AppMethodBeat.m2504i(110456);
        C29311a c29311a = C29310n.rTi;
        String str = this.igi;
        C25052j.m39376p(str, "username");
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        C6300p Rg = RO.mo5186Rg();
        C4133a c4133a = C43644j.rST;
        C35184a c35184a = C35183a.sdm;
        Rg.mo14552d((C1207m) new C35194j(str, 0, C5046bo.isEqual(str, C4133a.cnk()), "", C35183a.sdl));
        AppMethodBeat.m2505o(110456);
    }

    public final void cwP() {
        int i = 1;
        AppMethodBeat.m2504i(110457);
        LayoutParams layoutParams = this.f17908TF.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = C1338a.m2856al(getContext(), C25738R.dimen.f9862i8);
        }
        this.f17908TF.setLayoutParams(layoutParams);
        this.skj.clear();
        ArrayList arrayList = this.skj;
        C4133a c4133a = C43644j.rST;
        C46275k cxT = C4133a.cxT();
        String str = this.igi;
        String str2 = this.igi;
        C4133a c4133a2 = C43644j.rST;
        arrayList.addAll(cxT.mo74400a(str, C5046bo.isEqual(str2, C4133a.cnk()), 0, 3));
        this.skg.setVisibility(8);
        this.skh.setVisibility(8);
        this.ski.setVisibility(8);
        if ((!((Collection) this.skj).isEmpty() ? 1 : 0) != 0) {
            TextView textView = this.f17908TF;
            Context context = getContext();
            C25052j.m39375o(context, "context");
            textView.setText(context.getResources().getString(C25738R.string.g6m));
        } else {
            this.f17908TF.setText("");
        }
        cea cea;
        LinkedList linkedList;
        C18532d cyc;
        Object obj;
        cek cek;
        String str3;
        C44222az c44222az;
        C24833d c24833d;
        StoryRoundImageView storyRoundImageView;
        ImageView imageView;
        C4133a c4133a3;
        if (this.skj.size() == 1) {
            this.f17908TF.setVisibility(0);
            this.skg.setVisibility(0);
            cea = ((C39879j) this.skj.get(0)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                C25052j.m39375o(linkedList, "obj.MediaObjList");
                if (linkedList.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    c4133a = C43644j.rST;
                    cyc = C4133a.cyc();
                    obj = cea.wbK.get(0);
                    C25052j.m39375o(obj, "obj.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((C39879j) this.skj.get(0)).field_userName;
                    c44222az = C44222az.xYY;
                    C25052j.m39375o(c44222az, "FROM_SCENE.storyalbum");
                    c24833d = new C24833d(cek, str3, c44222az);
                    storyRoundImageView = this.ska;
                    if (storyRoundImageView == null) {
                        C25052j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    c4133a3 = C43644j.rST;
                    cyc.mo33784a(c24833d, imageView, C4133a.m6464a(C22226a.COMMON_SCENE));
                }
            }
        } else if (this.skj.size() == 2) {
            this.f17908TF.setVisibility(0);
            this.skg.setVisibility(0);
            this.skh.setVisibility(0);
            cea = ((C39879j) this.skj.get(0)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                C25052j.m39375o(linkedList, "obj1.MediaObjList");
                if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                    c4133a = C43644j.rST;
                    cyc = C4133a.cyc();
                    obj = cea.wbK.get(0);
                    C25052j.m39375o(obj, "obj1.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((C39879j) this.skj.get(0)).field_userName;
                    c44222az = C44222az.xYY;
                    C25052j.m39375o(c44222az, "FROM_SCENE.storyalbum");
                    c24833d = new C24833d(cek, str3, c44222az);
                    storyRoundImageView = this.ska;
                    if (storyRoundImageView == null) {
                        C25052j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    c4133a3 = C43644j.rST;
                    cyc.mo33784a(c24833d, imageView, C4133a.m6464a(C22226a.COMMON_SCENE));
                }
            }
            cea = ((C39879j) this.skj.get(1)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                C25052j.m39375o(linkedList, "obj2.MediaObjList");
                if (linkedList.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    c4133a = C43644j.rST;
                    cyc = C4133a.cyc();
                    obj = cea.wbK.get(0);
                    C25052j.m39375o(obj, "obj2.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((C39879j) this.skj.get(0)).field_userName;
                    c44222az = C44222az.xYY;
                    C25052j.m39375o(c44222az, "FROM_SCENE.storyalbum");
                    c24833d = new C24833d(cek, str3, c44222az);
                    storyRoundImageView = this.skb;
                    if (storyRoundImageView == null) {
                        C25052j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    c4133a3 = C43644j.rST;
                    cyc.mo33784a(c24833d, imageView, C4133a.m6464a(C22226a.COMMON_SCENE));
                }
            }
        } else if (this.skj.size() >= 3) {
            int i2;
            this.f17908TF.setVisibility(0);
            this.skg.setVisibility(0);
            this.skh.setVisibility(0);
            this.ski.setVisibility(0);
            cea = ((C39879j) this.skj.get(0)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                C25052j.m39375o(linkedList, "obj1.MediaObjList");
                if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                    c4133a = C43644j.rST;
                    cyc = C4133a.cyc();
                    obj = cea.wbK.get(0);
                    C25052j.m39375o(obj, "obj1.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((C39879j) this.skj.get(0)).field_userName;
                    c44222az = C44222az.xYY;
                    C25052j.m39375o(c44222az, "FROM_SCENE.storyalbum");
                    c24833d = new C24833d(cek, str3, c44222az);
                    storyRoundImageView = this.ska;
                    if (storyRoundImageView == null) {
                        C25052j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    c4133a3 = C43644j.rST;
                    cyc.mo33784a(c24833d, imageView, C4133a.m6464a(C22226a.COMMON_SCENE));
                }
            }
            cea = ((C39879j) this.skj.get(1)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                C25052j.m39375o(linkedList, "obj2.MediaObjList");
                if (linkedList.isEmpty()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    c4133a = C43644j.rST;
                    cyc = C4133a.cyc();
                    obj = cea.wbK.get(0);
                    C25052j.m39375o(obj, "obj2.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((C39879j) this.skj.get(0)).field_userName;
                    c44222az = C44222az.xYY;
                    C25052j.m39375o(c44222az, "FROM_SCENE.storyalbum");
                    c24833d = new C24833d(cek, str3, c44222az);
                    storyRoundImageView = this.skb;
                    if (storyRoundImageView == null) {
                        C25052j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    c4133a3 = C43644j.rST;
                    cyc.mo33784a(c24833d, imageView, C4133a.m6464a(C22226a.COMMON_SCENE));
                }
            }
            cea = ((C39879j) this.skj.get(2)).cBR().xeA;
            if (cea != null) {
                linkedList = cea.wbK;
                C25052j.m39375o(linkedList, "obj3.MediaObjList");
                if (linkedList.isEmpty()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    c4133a = C43644j.rST;
                    cyc = C4133a.cyc();
                    obj = cea.wbK.get(0);
                    C25052j.m39375o(obj, "obj3.MediaObjList[0]");
                    cek = (cek) obj;
                    str3 = ((C39879j) this.skj.get(0)).field_userName;
                    c44222az = C44222az.xYY;
                    C25052j.m39375o(c44222az, "FROM_SCENE.storyalbum");
                    c24833d = new C24833d(cek, str3, c44222az);
                    storyRoundImageView = this.skc;
                    if (storyRoundImageView == null) {
                        C25052j.dWJ();
                    }
                    imageView = storyRoundImageView;
                    c4133a3 = C43644j.rST;
                    cyc.mo33784a(c24833d, imageView, C4133a.m6464a(C22226a.COMMON_SCENE));
                }
            }
        }
        C4109d c4109d = this.skk;
        if (c4109d != null) {
            c4109d.mo8985cA(this.skj);
            AppMethodBeat.m2505o(110457);
            return;
        }
        AppMethodBeat.m2505o(110457);
    }

    public final void cwQ() {
        int i;
        AppMethodBeat.m2504i(110458);
        if (this.skj.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            m86830Fi(0);
        }
        AppMethodBeat.m2505o(110458);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110459);
        this.skk = null;
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(273, (C1202f) this);
        AppMethodBeat.m2505o(110459);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(110460);
        if (c1207m instanceof C35194j) {
            int i3 = ((C35194j) c1207m).cvd;
            C35184a c35184a = C35183a.sdm;
            if (i3 == C35183a.sdl && C5046bo.isEqual(((C35194j) c1207m).userName, this.igi) && i == 0) {
                cwP();
            }
        }
        AppMethodBeat.m2505o(110460);
    }

    /* renamed from: a */
    public final void mo41694a(C4109d c4109d) {
        this.skk = c4109d;
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(110461);
        C25052j.m39376p(viewGroup, "parent");
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            this.mView.setId(2131820982);
            viewGroup2.addView(this.mView, new LayoutParams(-1, -2));
            this.omq = onCreateView;
        }
        View view = this.omq;
        if (view == null) {
            C25052j.dWJ();
        }
        AppMethodBeat.m2505o(110461);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(110462);
        C25052j.m39376p(view, "view");
        super.onBindView(view);
        cwP();
        AppMethodBeat.m2505o(110462);
    }

    /* renamed from: Fi */
    private final void m86830Fi(int i) {
        AppMethodBeat.m2504i(110454);
        ArrayList arrayList = new ArrayList();
        for (C39879j c39879j : this.skj) {
            C22178a c22178a = C22177b.rRO;
            arrayList.add(C22178a.m33804j(Integer.valueOf(c39879j.field_createTime)));
        }
        long i2 = C39864o.rQN.mo55837i(arrayList, this.igi);
        Intent intent = new Intent(getContext(), StoryBrowseUI.class);
        intent.putExtra("username", this.igi);
        intent.putExtra("data_seed_key", i2);
        intent.putExtra("v_position", i);
        intent.putExtra("gallery_story_need_action", true);
        getContext().startActivity(intent);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20743bG(14);
        AppMethodBeat.m2505o(110454);
    }
}
