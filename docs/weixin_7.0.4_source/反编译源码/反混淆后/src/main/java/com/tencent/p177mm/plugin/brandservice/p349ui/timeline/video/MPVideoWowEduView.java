package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWowEduView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "root", "Landroid/view/View;", "setPosition", "", "position", "", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWowEduView */
public final class MPVideoWowEduView extends RelativeLayout {
    private View jWH;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWowEduView$1 */
    static final class C112611 implements OnClickListener {
        final /* synthetic */ MPVideoWowEduView jXT;

        C112611(MPVideoWowEduView mPVideoWowEduView) {
            this.jXT = mPVideoWowEduView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15272);
            this.jXT.jWH.setVisibility(8);
            ViewParent parent = this.jXT.jWH.getParent();
            C25052j.m39375o(parent, "root.parent");
            parent = parent.getParent();
            if (parent == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.m2505o(15272);
                throw c44941v;
            }
            ((ViewGroup) parent).setVisibility(8);
            AppMethodBeat.m2505o(15272);
        }
    }

    public MPVideoWowEduView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.m2504i(15274);
        View.inflate(context, 2130970257, this);
        View findViewById = findViewById(2131826193);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_video_wow_edu_root_layout)");
        this.jWH = findViewById;
        ((Button) findViewById(2131826194)).setOnClickListener(new C112611(this));
        AppMethodBeat.m2505o(15274);
    }

    public final void setPosition(float f) {
        AppMethodBeat.m2504i(15273);
        ViewParent parent = this.jWH.getParent();
        C25052j.m39375o(parent, "root.parent");
        parent = parent.getParent();
        if (parent == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.m2505o(15273);
            throw c44941v;
        }
        ((ViewGroup) parent).setVisibility(0);
        this.jWH.setVisibility(0);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        this.jWH.setPadding(0, (int) (f - ((float) context.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo))), 0, 0);
        postInvalidate();
        AppMethodBeat.m2505o(15273);
    }
}
