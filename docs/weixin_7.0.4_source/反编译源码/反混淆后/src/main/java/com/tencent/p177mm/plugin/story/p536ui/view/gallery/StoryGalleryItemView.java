package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.plugin.story.model.p533d.C35201i;
import com.tencent.p177mm.plugin.story.p531g.C35180c;
import com.tencent.p177mm.plugin.story.p531g.C4116b;
import com.tencent.p177mm.plugin.story.p536ui.view.StoryCommentView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.WebView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010#J\u0010\u00101\u001a\u0002022\b\u00100\u001a\u0004\u0018\u00010#J\b\u00103\u001a\u00020/H\u0002J\b\u00104\u001a\u00020/H\u0014J\u0006\u00105\u001a\u00020/J\u000e\u00106\u001a\u00020/2\u0006\u00107\u001a\u000202J\u0010\u00108\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u00109\u001a\u00020/J\u0006\u0010:\u001a\u00020/R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "changeVideoItem", "", "item", "getPlayStatus", "", "initPostTipView", "onDetachedFromWindow", "reBindBitmap", "setMute", "isMute", "setVideoViewMgr", "switchImageMode", "switchVideoMode", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView */
public final class StoryGalleryItemView extends RelativeLayout {
    final String TAG;
    final ImageView mmB;
    private final LayoutParams oAD;
    int position;
    C35201i rVZ;
    final StoryCommentView sfS;
    private StoryGalleryPostTip sfT;
    ViewGroup soW;
    final FrameLayout.LayoutParams soX;
    C22319p soY;

    public /* synthetic */ StoryGalleryItemView(Context context) {
        this(context, null, 0);
    }

    public StoryGalleryItemView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110768);
        this.TAG = "MircoMsg.StoryGalleryItemView";
        this.oAD = new LayoutParams(-1, -1);
        this.soX = new FrameLayout.LayoutParams(-1, -1);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.soW = new FrameLayout(context);
        this.mmB = new ImageView(context);
        this.mmB.setScaleType(ScaleType.CENTER_CROP);
        addView(this.mmB, this.oAD);
        addView(this.soW, this.oAD);
        this.sfS = new StoryCommentView(context);
        addView(this.sfS, this.oAD);
        Context context2 = getContext();
        C25052j.m39375o(context2, "context");
        this.sfT = new StoryGalleryPostTip(context2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C5230ak.m7987de(getContext()) + C5230ak.m7989hF(getContext()));
        layoutParams.addRule(10);
        addView(this.sfT, layoutParams);
        AppMethodBeat.m2505o(110768);
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final ImageView getThumbView() {
        return this.mmB;
    }

    public final StoryCommentView getCommentView() {
        return this.sfS;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final C35201i getVideoItem() {
        return this.rVZ;
    }

    public final void setVideoItem(C35201i c35201i) {
        this.rVZ = c35201i;
    }

    public final StoryGalleryPostTip getPostTipView() {
        return this.sfT;
    }

    public final void setPostTipView(StoryGalleryPostTip storyGalleryPostTip) {
        this.sfT = storyGalleryPostTip;
    }

    public final void setVideoViewMgr(C22319p c22319p) {
        this.soY = c22319p;
    }

    /* renamed from: d */
    public final boolean mo26089d(C35201i c35201i) {
        AppMethodBeat.m2504i(110764);
        if (c35201i != null) {
            Boolean bool;
            C22319p c22319p = this.soY;
            if (c22319p != null) {
                C25052j.m39376p(c35201i, "item");
                if (c22319p.sqW != null) {
                    StoryVideoView storyVideoView = c22319p.sqW;
                    if (storyVideoView != null) {
                        storyVideoView.isPlaying();
                    }
                }
                bool = Boolean.FALSE;
            } else {
                bool = null;
            }
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                AppMethodBeat.m2505o(110764);
                return booleanValue;
            }
            AppMethodBeat.m2505o(110764);
            return false;
        }
        AppMethodBeat.m2505o(110764);
        return false;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(110765);
        C22319p c22319p = this.soY;
        if (c22319p != null) {
            c22319p.setMute(z);
            AppMethodBeat.m2505o(110765);
            return;
        }
        AppMethodBeat.m2505o(110765);
    }

    public final void cCI() {
        AppMethodBeat.m2504i(110766);
        C4990ab.m7416i(this.TAG, "switchVideoMode");
        C22319p c22319p = this.soY;
        if (c22319p != null) {
            c22319p.mo37855a(this.soW, this.soX);
        }
        C35201i c35201i = this.rVZ;
        if (c35201i != null) {
            c22319p = this.soY;
            if (c22319p != null) {
                c22319p.mo37862o(c35201i);
            }
        }
        this.soW.setVisibility(0);
        this.sfS.show();
        c35201i = this.rVZ;
        if (c35201i != null) {
            C35180c c35180c = C35180c.sbQ;
            C35180c.m57806ar(c35201i.username, c35201i.rUJ);
            C4116b c4116b = C4116b.sbw;
            C4116b.m6440j(c35201i.username, c35201i.rUJ, -1);
            AppMethodBeat.m2505o(110766);
            return;
        }
        AppMethodBeat.m2505o(110766);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(110767);
        C4990ab.m7410d(this.TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        this.soY = null;
        AppMethodBeat.m2505o(110767);
    }
}
