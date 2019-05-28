package com.tencent.p177mm.plugin.story.p536ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.p069v7.app.C6218i;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentInputView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "getCommentInputView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "setCommentInputView", "(Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;)V", "params", "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.c */
public final class C43662c extends C6218i {
    private final LayoutParams oAD = new LayoutParams(-1, -1);
    StoryCommentInputView spp;

    public C43662c(Context context) {
        C25052j.m39376p(context, "context");
        super(context, C25738R.style.f10861gr);
        AppMethodBeat.m2504i(110341);
        this.spp = new StoryCommentInputView(context);
        mo14042fA();
        AppMethodBeat.m2505o(110341);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110340);
        setContentView(this.spp, this.oAD);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(67108864);
            window.setLayout(-1, -1);
            window.setSoftInputMode(36);
            AppMethodBeat.m2505o(110340);
            return;
        }
        AppMethodBeat.m2505o(110340);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(139087);
        super.onBackPressed();
        AppMethodBeat.m2505o(139087);
    }
}
