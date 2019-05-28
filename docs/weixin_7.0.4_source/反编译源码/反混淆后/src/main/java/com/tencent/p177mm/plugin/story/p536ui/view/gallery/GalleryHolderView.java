package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.model.C13774d;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C35251l.C35259a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001eH\u0002J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u001eR\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView */
public final class GalleryHolderView extends RelativeLayout {
    static final String TAG = TAG;
    public static final C4166a snO = new C4166a();
    TextView iDT;
    LinearLayout snI;
    private ImageView snJ;
    private ImageView snK;
    private boolean snL;
    int snM;
    float snN;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView$a */
    public static final class C4166a {
        private C4166a() {
        }

        public /* synthetic */ C4166a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView$1 */
    static final class C293651 implements OnClickListener {
        final /* synthetic */ GalleryHolderView snP;

        C293651(GalleryHolderView galleryHolderView) {
            this.snP = galleryHolderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110713);
            GalleryHolderView.m46625a(this.snP);
            AppMethodBeat.m2505o(110713);
        }
    }

    public GalleryHolderView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110716);
        View.inflate(context, 2130970887, this);
        View findViewById = findViewById(2131828153);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…ery_holder_action_layout)");
        this.snI = (LinearLayout) findViewById;
        findViewById = findViewById(2131828154);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_holder_action_iv)");
        this.snJ = (ImageView) findViewById;
        findViewById = findViewById(2131828151);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_holder_bubble)");
        this.snK = (ImageView) findViewById;
        findViewById = findViewById(2131828152);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_holder_title_tv)");
        this.iDT = (TextView) findViewById;
        this.snI.setVisibility(4);
        this.snJ.setImageDrawable(C5225ah.m7961e(context.getResources().getDrawable(C1318a.icons_filled_camera), context.getResources().getColor(C25738R.color.a2_)));
        this.snI.setOnClickListener(new C293651(this));
        setBackgroundColor(context.getResources().getColor(C25738R.color.a27));
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(C5127a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.TRUE);
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.m2505o(110716);
            throw c44941v;
        }
        this.snL = ((Boolean) obj).booleanValue();
        if (this.snL) {
            this.iDT.setTextColor(getResources().getColor(C25738R.color.a1k));
            TextView textView = this.iDT;
            C35259a c35259a = C35251l.spJ;
            String string = getResources().getString(C25738R.string.esx);
            C25052j.m39375o(string, "resources.getString(R.st…ory_gallery_holder_title)");
            textView.setText(C35259a.m57931l(string, getResources().getColor(C25738R.color.a1k)));
        } else {
            this.iDT.setTextColor(getResources().getColor(C25738R.color.a28));
            this.iDT.setText(getResources().getString(C25738R.string.g_n));
        }
        this.snN = 1.0f;
        AppMethodBeat.m2505o(110716);
    }

    public GalleryHolderView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110717);
        AppMethodBeat.m2505o(110717);
    }

    public final int getInitMargin() {
        return this.snM;
    }

    public final void setInitMargin(int i) {
        this.snM = i;
    }

    static {
        AppMethodBeat.m2504i(110718);
        AppMethodBeat.m2505o(110718);
    }

    public final void cCE() {
        AppMethodBeat.m2504i(110714);
        AnimatorSet animatorSet = new AnimatorSet();
        r2 = new Animator[2];
        r2[0] = ObjectAnimator.ofFloat(this.iDT, "alpha", new float[]{this.iDT.getAlpha(), 0.0f});
        r2[1] = ObjectAnimator.ofFloat(this.snI, "alpha", new float[]{this.snI.getAlpha(), 1.0f});
        animatorSet.playTogether(r2);
        animatorSet.setDuration(100);
        animatorSet.start();
        AppMethodBeat.m2505o(110714);
    }

    public final void cCF() {
        AppMethodBeat.m2504i(110715);
        this.snI.setVisibility(0);
        this.iDT.setVisibility(4);
        if (this.snL) {
            this.snL = false;
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.FALSE);
        }
        this.iDT.setTextColor(getResources().getColor(C25738R.color.a28));
        this.iDT.setText(getResources().getString(C25738R.string.g_n));
        AppMethodBeat.m2505o(110715);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m46625a(GalleryHolderView galleryHolderView) {
        AppMethodBeat.m2504i(110719);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
        C44941v c44941v;
        if (obj == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.m2505o(110719);
            throw c44941v;
        }
        if (((Boolean) obj).booleanValue()) {
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
        }
        C13774d c13774d = C13774d.rSg;
        if (C13774d.canPostStory()) {
            Context context = galleryHolderView.getContext();
            C22212h c22212h = C22212h.scu;
            C46270n.m86708n(context, C22212h.cAI());
            AppMethodBeat.m2505o(110719);
            return;
        }
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        obj = RP.mo5239Ry().get(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.m2505o(110719);
            throw c44941v;
        }
        int intValue = ((Integer) obj).intValue();
        Context context2 = galleryHolderView.getContext();
        C25052j.m39375o(context2, "context");
        C30379h.m48417J(galleryHolderView.getContext(), "", context2.getResources().getString(C25738R.string.et6, new Object[]{Integer.valueOf(intValue)}));
        AppMethodBeat.m2505o(110719);
    }
}
