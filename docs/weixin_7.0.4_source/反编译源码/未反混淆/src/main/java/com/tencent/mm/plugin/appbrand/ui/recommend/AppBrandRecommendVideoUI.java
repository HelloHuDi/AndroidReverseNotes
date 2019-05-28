package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(19)
@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "videoUrl", "", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandRecommendVideoUI extends MMActivity {
    public static final a iQM = new a();
    private CommonVideoView iQL;
    public String videoUrl;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI$Companion;", "", "()V", "KEY_VIDEO_URL", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(135211);
        AppMethodBeat.o(135211);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(135208);
        super.onCreate(bundle);
        hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        View findViewById = findViewById(R.id.v5);
        j.o(findViewById, "findViewById(R.id.app_brand_recommend_player)");
        this.iQL = (CommonVideoView) findViewById;
        String stringExtra = getIntent().getStringExtra("1");
        j.o(stringExtra, "intent.getStringExtra(KEY_VIDEO_URL)");
        this.videoUrl = stringExtra;
        CommonVideoView commonVideoView = this.iQL;
        if (commonVideoView == null) {
            j.avw("videoView");
        }
        String str = this.videoUrl;
        if (str == null) {
            j.avw("videoUrl");
        }
        commonVideoView.c(true, str, 1000);
        commonVideoView = this.iQL;
        if (commonVideoView == null) {
            j.avw("videoView");
        }
        commonVideoView.start();
        AppMethodBeat.o(135208);
    }

    public final int getLayoutId() {
        return R.layout.dd;
    }

    public final void finish() {
        AppMethodBeat.i(135209);
        CommonVideoView commonVideoView = this.iQL;
        if (commonVideoView == null) {
            j.avw("videoView");
        }
        if (commonVideoView.isPlaying()) {
            commonVideoView = this.iQL;
            if (commonVideoView == null) {
                j.avw("videoView");
            }
            commonVideoView.pause();
        }
        super.finish();
        AppMethodBeat.o(135209);
    }

    public final void onPause() {
        AppMethodBeat.i(135210);
        super.onPause();
        AppMethodBeat.o(135210);
    }
}
