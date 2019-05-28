package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C33743f;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "errIv", "Landroid/widget/ImageView;", "errTv", "Landroid/widget/TextView;", "root", "Landroid/view/View;", "init", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "aniHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "setCigError", "errMsg", "errCode", "", "setPlayError", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView */
public final class MPVideoErrorView extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoErrorView";
    View jWH;
    TextView jXp;
    ImageView jXq;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView$a */
    static final class C20092a implements OnClickListener {
        final /* synthetic */ MPVideoErrorView jXr;
        final /* synthetic */ C45767b jXs;
        final /* synthetic */ C33743f jXt;

        C20092a(MPVideoErrorView mPVideoErrorView, C45767b c45767b, C33743f c33743f) {
            this.jXr = mPVideoErrorView;
            this.jXs = c45767b;
            this.jXt = c33743f;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15247);
            this.jXr.setVisibility(8);
            this.jXs.aYm();
            C33743f c33743f = this.jXt;
            if (c33743f != null) {
                c33743f.jYH = false;
                if (c33743f.enable) {
                    View view2 = c33743f.jYF;
                    if (view2 == null) {
                        C25052j.avw("animationView");
                    }
                    view2.setVisibility(0);
                }
                AppMethodBeat.m2505o(15247);
                return;
            }
            AppMethodBeat.m2505o(15247);
        }
    }

    public MPVideoErrorView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.m2504i(15250);
        View.inflate(context, 2130970254, this);
        View findViewById = findViewById(2131826174);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_play_err_info_tv)");
        this.jXp = (TextView) findViewById;
        findViewById = findViewById(2131826173);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_play_err_info_iv)");
        this.jXq = (ImageView) findViewById;
        findViewById = findViewById(2131820987);
        C25052j.m39375o(findViewById, "findViewById(R.id.root)");
        this.jWH = findViewById;
        AppMethodBeat.m2505o(15250);
    }

    public final void setPlayError$505cff1c(String str) {
        AppMethodBeat.m2504i(15248);
        this.jXq.setBackgroundResource(C25738R.drawable.axs);
        this.jXp.setText(str);
        this.jWH.setClickable(false);
        AppMethodBeat.m2505o(15248);
    }

    public final void setCigError$505cff1c(String str) {
        AppMethodBeat.m2504i(138971);
        this.jXq.setBackgroundResource(C25738R.drawable.axu);
        if (C5046bo.isNullOrNil(str)) {
            this.jXp.setText(getContext().getString(C25738R.string.g83));
        } else {
            this.jXp.setText(getContext().getString(C25738R.string.g83) + ' ' + str);
        }
        this.jWH.setClickable(true);
        AppMethodBeat.m2505o(138971);
    }
}
