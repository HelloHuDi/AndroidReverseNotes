package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5225ah;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postTipIv", "Landroid/widget/ImageView;", "getPostTipIv", "()Landroid/widget/ImageView;", "setPostTipIv", "(Landroid/widget/ImageView;)V", "postTipLayout", "Landroid/widget/LinearLayout;", "getPostTipLayout", "()Landroid/widget/LinearLayout;", "setPostTipLayout", "(Landroid/widget/LinearLayout;)V", "postTipTv", "Landroid/widget/TextView;", "getPostTipTv", "()Landroid/widget/TextView;", "setPostTipTv", "(Landroid/widget/TextView;)V", "updatePostStatus", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip */
public final class StoryGalleryPostTip extends RelativeLayout {
    public static final String TAG = TAG;
    public static final C13883a spc = new C13883a();
    private LinearLayout soZ;
    private ImageView spa;
    public TextView spb;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip$a */
    public static final class C13883a {
        private C13883a() {
        }

        public /* synthetic */ C13883a(byte b) {
            this();
        }
    }

    public /* synthetic */ StoryGalleryPostTip(Context context) {
        this(context, null, 0);
    }

    public StoryGalleryPostTip(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110771);
        View.inflate(context, 2130970890, this);
        View findViewById = findViewById(2131828163);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_post_tip_iv)");
        this.spa = (ImageView) findViewById;
        findViewById = findViewById(2131828164);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_post_tip_tv)");
        this.spb = (TextView) findViewById;
        this.spa.setImageDrawable(C5225ah.m7961e(getResources().getDrawable(C1318a.icons_outlined_error), -65536));
        setVisibility(8);
        AppMethodBeat.m2505o(110771);
    }

    public final LinearLayout getPostTipLayout() {
        return this.soZ;
    }

    public final void setPostTipLayout(LinearLayout linearLayout) {
        this.soZ = linearLayout;
    }

    public final ImageView getPostTipIv() {
        return this.spa;
    }

    public final void setPostTipIv(ImageView imageView) {
        AppMethodBeat.m2504i(110769);
        C25052j.m39376p(imageView, "<set-?>");
        this.spa = imageView;
        AppMethodBeat.m2505o(110769);
    }

    public final TextView getPostTipTv() {
        return this.spb;
    }

    public final void setPostTipTv(TextView textView) {
        AppMethodBeat.m2504i(110770);
        C25052j.m39376p(textView, "<set-?>");
        this.spb = textView;
        AppMethodBeat.m2505o(110770);
    }

    static {
        AppMethodBeat.m2504i(110772);
        AppMethodBeat.m2505o(110772);
    }
}
