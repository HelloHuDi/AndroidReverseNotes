package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "closeBtn", "Landroid/widget/Button;", "root", "Landroid/view/View;", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPPreviewBar */
public final class MPPreviewBar extends RelativeLayout {
    private Button jWG;
    private View jWH;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPPreviewBar$1 */
    static final class C337421 implements OnClickListener {
        final /* synthetic */ MPPreviewBar jWI;

        C337421(MPPreviewBar mPPreviewBar) {
            this.jWI = mPPreviewBar;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15224);
            this.jWI.jWH.setVisibility(8);
            AppMethodBeat.m2505o(15224);
        }
    }

    public MPPreviewBar(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.m2504i(15225);
        View.inflate(context, 2130970250, this);
        View findViewById = findViewById(2131826163);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_close_btn)");
        this.jWG = (Button) findViewById;
        findViewById = findViewById(2131826162);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_preview_layout)");
        this.jWH = findViewById;
        this.jWG.setOnClickListener(new C337421(this));
        AppMethodBeat.m2505o(15225);
    }
}
