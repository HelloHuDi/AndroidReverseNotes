package com.tencent.p177mm.plugin.story.p536ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.story.p536ui.view.StoryCommentView.C22285a;
import com.tencent.smtt.sdk.WebView;
import java.util.Random;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fJ\b\u0010+\u001a\u00020\u0015H\u0002J\u0006\u0010,\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", "origin", "notifyView", "randowmColor", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector */
public final class StoryCommentColorSelector extends LinearLayout {
    private int lnx;
    private final int siV;
    private final Drawable siW;
    private final ImageView siX;
    private final ImageView siY;
    private final ImageView siZ;
    private final LinearLayout sja;
    private final TextView sjb;
    private C17126b<? super Integer, C37091y> sjc;
    private final int strokeWidth;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector$2 */
    static final class C138582 implements OnClickListener {
        final /* synthetic */ StoryCommentColorSelector sjd;

        C138582(StoryCommentColorSelector storyCommentColorSelector) {
            this.sjd = storyCommentColorSelector;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110381);
            this.sjd.setSelectedColor(WebView.NIGHT_MODE_COLOR);
            StoryCommentColorSelector.m86801a(this.sjd);
            AppMethodBeat.m2505o(110381);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector$3 */
    static final class C138593 implements OnClickListener {
        final /* synthetic */ StoryCommentColorSelector sjd;

        C138593(StoryCommentColorSelector storyCommentColorSelector) {
            this.sjd = storyCommentColorSelector;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110382);
            this.sjd.setSelectedColor(StoryCommentColorSelector.cCn());
            StoryCommentColorSelector.m86801a(this.sjd);
            AppMethodBeat.m2505o(110382);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector$1 */
    static final class C293431 implements OnClickListener {
        final /* synthetic */ StoryCommentColorSelector sjd;

        C293431(StoryCommentColorSelector storyCommentColorSelector) {
            this.sjd = storyCommentColorSelector;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110380);
            this.sjd.setSelectedColor(-1);
            StoryCommentColorSelector.m86801a(this.sjd);
            AppMethodBeat.m2505o(110380);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m86801a(StoryCommentColorSelector storyCommentColorSelector) {
        AppMethodBeat.m2504i(110387);
        storyCommentColorSelector.cCm();
        AppMethodBeat.m2505o(110387);
    }

    public StoryCommentColorSelector(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110385);
        this.lnx = -1;
        View.inflate(context, 2130970865, this);
        setOrientation(0);
        View findViewById = findViewById(2131828050);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…ent_color_selector_white)");
        this.siX = (ImageView) findViewById;
        findViewById = findViewById(2131828051);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…ent_color_selector_black)");
        this.siY = (ImageView) findViewById;
        findViewById = findViewById(2131828053);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…lor_selector_random_icon)");
        this.siZ = (ImageView) findViewById;
        findViewById = findViewById(2131828052);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…nt_color_selector_random)");
        this.sja = (LinearLayout) findViewById;
        findViewById = findViewById(2131828054);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…lor_selector_random_text)");
        this.sjb = (TextView) findViewById;
        this.siX.setOnClickListener(new C293431(this));
        this.siY.setOnClickListener(new C138582(this));
        this.sja.setOnClickListener(new C138593(this));
        this.strokeWidth = C1338a.fromDPToPix(context, 2);
        this.siV = C1338a.fromDPToPix(context, 4);
        int[] iArr = new int[]{-372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(2);
        gradientDrawable.setStroke(this.strokeWidth, -1);
        gradientDrawable.setShape(1);
        Drawable drawable = gradientDrawable;
        C25052j.m39376p(drawable, C8741b.ORIGIN);
        this.siW = new InsetDrawable(drawable, this.siV);
        cCm();
        AppMethodBeat.m2505o(110385);
    }

    public StoryCommentColorSelector(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110386);
        AppMethodBeat.m2505o(110386);
    }

    public final int getSelectedColor() {
        return this.lnx;
    }

    public final void setSelectedColor(int i) {
        this.lnx = i;
    }

    public final C17126b<Integer, C37091y> getOnColorSelected() {
        return this.sjc;
    }

    public final void setOnColorSelected(C17126b<? super Integer, C37091y> c17126b) {
        this.sjc = c17126b;
    }

    private final void cCm() {
        AppMethodBeat.m2504i(110383);
        switch (this.lnx) {
            case WebView.NIGHT_MODE_COLOR /*-16777216*/:
                this.siX.setSelected(false);
                this.siY.setSelected(true);
                this.siZ.setImageDrawable(this.siW);
                this.sjb.setVisibility(8);
                break;
            case -1:
                this.siX.setSelected(true);
                this.siY.setSelected(false);
                this.siZ.setImageDrawable(this.siW);
                this.sjb.setVisibility(8);
                break;
            default:
                this.siX.setSelected(false);
                this.siY.setSelected(false);
                ImageView imageView = this.siZ;
                int i = this.lnx;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i);
                gradientDrawable.setStroke(this.strokeWidth, -1);
                gradientDrawable.setShape(1);
                imageView.setImageDrawable(gradientDrawable);
                this.sjb.setVisibility(0);
                break;
        }
        C17126b c17126b = this.sjc;
        if (c17126b != null) {
            c17126b.mo50am(Integer.valueOf(this.lnx));
            AppMethodBeat.m2505o(110383);
            return;
        }
        AppMethodBeat.m2505o(110383);
    }

    public static int cCn() {
        AppMethodBeat.m2504i(110384);
        Random random = new Random();
        C22285a c22285a = StoryCommentView.sjO;
        int nextInt = random.nextInt(StoryCommentView.sjN.length);
        c22285a = StoryCommentView.sjO;
        nextInt = StoryCommentView.sjN[nextInt];
        AppMethodBeat.m2505o(110384);
        return nextInt;
    }
}
