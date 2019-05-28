package com.tencent.p177mm.plugin.story.p536ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.story.api.C13736l;
import com.tencent.p177mm.plugin.story.api.C29268i;
import com.tencent.p177mm.plugin.story.model.C43648r;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintBgColor", "hintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "tagName", "", "withHintBg", "", "getWithHintBg", "()Z", "setWithHintBg", "(Z)V", "bindUsername", "", "userName", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onNotifyStoryStatusChanged", "username", "isRead", "setShowStoryHint", "show", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView */
public final class CommentAvatarImageView extends ImageView implements C13736l {
    public final C29268i rDe;
    public String rMJ;
    private final int sio;
    private boolean sip;

    public CommentAvatarImageView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110334);
        this.rMJ = "";
        setLayerType(1, null);
        this.rDe = C43648r.rTS.mo69259eW(context);
        this.rDe.mo9014aR(this);
        this.sio = getResources().getColor(C25738R.color.a1r);
        AppMethodBeat.m2505o(110334);
    }

    public CommentAvatarImageView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110335);
        AppMethodBeat.m2505o(110335);
    }

    public final boolean getWithHintBg() {
        return this.sip;
    }

    public final void setWithHintBg(boolean z) {
        this.sip = z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        int i;
        AppMethodBeat.m2504i(110331);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        super.onDraw(canvas);
        C29268i c29268i = this.rDe;
        if (this.sip) {
            i = this.sio;
        } else {
            i = 0;
        }
        c29268i.mo9013a(canvas, false, i);
        AppMethodBeat.m2505o(110331);
    }

    public final void setShowStoryHint(boolean z) {
        AppMethodBeat.m2504i(110332);
        this.rDe.setShowStoryHint(z);
        AppMethodBeat.m2505o(110332);
    }

    /* renamed from: br */
    public final void mo25937br(String str, boolean z) {
        AppMethodBeat.m2504i(110333);
        C25052j.m39376p(str, "username");
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.m2505o(110333);
            return;
        }
        if (C25052j.m39373j(str, this.rMJ)) {
            setShowStoryHint(!z);
        }
        AppMethodBeat.m2505o(110333);
    }
}
