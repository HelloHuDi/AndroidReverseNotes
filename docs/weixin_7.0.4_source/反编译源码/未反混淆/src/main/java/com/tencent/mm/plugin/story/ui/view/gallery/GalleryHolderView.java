package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.d;
import com.tencent.mm.ui.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001eH\u0002J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u001eR\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "Companion", "plugin-story_release"})
public final class GalleryHolderView extends RelativeLayout {
    static final String TAG = TAG;
    public static final a snO = new a();
    TextView iDT;
    LinearLayout snI;
    private ImageView snJ;
    private ImageView snK;
    private boolean snL;
    int snM;
    float snN;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ GalleryHolderView snP;

        AnonymousClass1(GalleryHolderView galleryHolderView) {
            this.snP = galleryHolderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110713);
            GalleryHolderView.a(this.snP);
            AppMethodBeat.o(110713);
        }
    }

    public GalleryHolderView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110716);
        View.inflate(context, R.layout.ayn, this);
        View findViewById = findViewById(R.id.eto);
        j.o(findViewById, "findViewById(R.id.story_…ery_holder_action_layout)");
        this.snI = (LinearLayout) findViewById;
        findViewById = findViewById(R.id.etp);
        j.o(findViewById, "findViewById(R.id.story_gallery_holder_action_iv)");
        this.snJ = (ImageView) findViewById;
        findViewById = findViewById(R.id.etm);
        j.o(findViewById, "findViewById(R.id.story_gallery_holder_bubble)");
        this.snK = (ImageView) findViewById;
        findViewById = findViewById(R.id.etn);
        j.o(findViewById, "findViewById(R.id.story_gallery_holder_title_tv)");
        this.iDT = (TextView) findViewById;
        this.snI.setVisibility(4);
        this.snJ.setImageDrawable(ah.e(context.getResources().getDrawable(R.raw.icons_filled_camera), context.getResources().getColor(R.color.a2_)));
        this.snI.setOnClickListener(new AnonymousClass1(this));
        setBackgroundColor(context.getResources().getColor(R.color.a27));
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.TRUE);
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(110716);
            throw vVar;
        }
        this.snL = ((Boolean) obj).booleanValue();
        if (this.snL) {
            this.iDT.setTextColor(getResources().getColor(R.color.a1k));
            TextView textView = this.iDT;
            com.tencent.mm.plugin.story.ui.view.gallery.l.a aVar = l.spJ;
            String string = getResources().getString(R.string.esx);
            j.o(string, "resources.getString(R.st…ory_gallery_holder_title)");
            textView.setText(com.tencent.mm.plugin.story.ui.view.gallery.l.a.l(string, getResources().getColor(R.color.a1k)));
        } else {
            this.iDT.setTextColor(getResources().getColor(R.color.a28));
            this.iDT.setText(getResources().getString(R.string.g_n));
        }
        this.snN = 1.0f;
        AppMethodBeat.o(110716);
    }

    public GalleryHolderView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110717);
        AppMethodBeat.o(110717);
    }

    public final int getInitMargin() {
        return this.snM;
    }

    public final void setInitMargin(int i) {
        this.snM = i;
    }

    static {
        AppMethodBeat.i(110718);
        AppMethodBeat.o(110718);
    }

    public final void cCE() {
        AppMethodBeat.i(110714);
        AnimatorSet animatorSet = new AnimatorSet();
        r2 = new Animator[2];
        r2[0] = ObjectAnimator.ofFloat(this.iDT, "alpha", new float[]{this.iDT.getAlpha(), 0.0f});
        r2[1] = ObjectAnimator.ofFloat(this.snI, "alpha", new float[]{this.snI.getAlpha(), 1.0f});
        animatorSet.playTogether(r2);
        animatorSet.setDuration(100);
        animatorSet.start();
        AppMethodBeat.o(110714);
    }

    public final void cCF() {
        AppMethodBeat.i(110715);
        this.snI.setVisibility(0);
        this.iDT.setVisibility(4);
        if (this.snL) {
            this.snL = false;
            e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.FALSE);
        }
        this.iDT.setTextColor(getResources().getColor(R.color.a28));
        this.iDT.setText(getResources().getString(R.string.g_n));
        AppMethodBeat.o(110715);
    }

    public static final /* synthetic */ void a(GalleryHolderView galleryHolderView) {
        AppMethodBeat.i(110719);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
        v vVar;
        if (obj == null) {
            vVar = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(110719);
            throw vVar;
        }
        if (((Boolean) obj).booleanValue()) {
            RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
        }
        d dVar = d.rSg;
        if (d.canPostStory()) {
            Context context = galleryHolderView.getContext();
            h hVar = h.scu;
            n.n(context, h.cAI());
            AppMethodBeat.o(110719);
            return;
        }
        RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        obj = RP.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            vVar = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(110719);
            throw vVar;
        }
        int intValue = ((Integer) obj).intValue();
        Context context2 = galleryHolderView.getContext();
        j.o(context2, "context");
        com.tencent.mm.ui.base.h.J(galleryHolderView.getContext(), "", context2.getResources().getString(R.string.et6, new Object[]{Integer.valueOf(intValue)}));
        AppMethodBeat.o(110719);
    }
}
