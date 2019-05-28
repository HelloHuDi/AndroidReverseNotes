package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.pluginsdk.p597ui.CommonVideoView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C5271a(19)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "videoUrl", "", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendVideoUI */
public final class AppBrandRecommendVideoUI extends MMActivity {
    public static final C27342a iQM = new C27342a();
    private CommonVideoView iQL;
    public String videoUrl;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI$Companion;", "", "()V", "KEY_VIDEO_URL", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendVideoUI$a */
    public static final class C27342a {
        private C27342a() {
        }

        public /* synthetic */ C27342a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(135211);
        AppMethodBeat.m2505o(135211);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(135208);
        super.onCreate(bundle);
        hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        View findViewById = findViewById(2131821352);
        C25052j.m39375o(findViewById, "findViewById(R.id.app_brand_recommend_player)");
        this.iQL = (CommonVideoView) findViewById;
        String stringExtra = getIntent().getStringExtra("1");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(KEY_VIDEO_URL)");
        this.videoUrl = stringExtra;
        CommonVideoView commonVideoView = this.iQL;
        if (commonVideoView == null) {
            C25052j.avw("videoView");
        }
        String str = this.videoUrl;
        if (str == null) {
            C25052j.avw("videoUrl");
        }
        commonVideoView.mo9063c(true, str, 1000);
        commonVideoView = this.iQL;
        if (commonVideoView == null) {
            C25052j.avw("videoView");
        }
        commonVideoView.start();
        AppMethodBeat.m2505o(135208);
    }

    public final int getLayoutId() {
        return 2130968727;
    }

    public final void finish() {
        AppMethodBeat.m2504i(135209);
        CommonVideoView commonVideoView = this.iQL;
        if (commonVideoView == null) {
            C25052j.avw("videoView");
        }
        if (commonVideoView.isPlaying()) {
            commonVideoView = this.iQL;
            if (commonVideoView == null) {
                C25052j.avw("videoView");
            }
            commonVideoView.pause();
        }
        super.finish();
        AppMethodBeat.m2505o(135209);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(135210);
        super.onPause();
        AppMethodBeat.m2505o(135210);
    }
}
