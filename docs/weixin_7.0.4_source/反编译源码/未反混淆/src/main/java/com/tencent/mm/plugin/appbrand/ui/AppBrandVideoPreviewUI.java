package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\nH\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mVideoUrl", "", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "getLayoutId", "", "initVideoView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "plugin-appbrand-integration_release"})
public final class AppBrandVideoPreviewUI extends MMActivity {
    private String iJx;
    private AppBrandVideoView iJy;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandVideoPreviewUI iJz;

        a(AppBrandVideoPreviewUI appBrandVideoPreviewUI) {
            this.iJz = appBrandVideoPreviewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(135003);
            this.iJz.onBackPressed();
            AppMethodBeat.o(135003);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.du;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(135004);
        super.onCreate(bundle);
        this.iJx = getIntent().getStringExtra("key_video_url");
        if (bo.isNullOrNil(this.iJx)) {
            finish();
            AppMethodBeat.o(135004);
            return;
        }
        setBackBtn(new a(this));
        setMMTitle("");
        dyb();
        xE(WebView.NIGHT_MODE_COLOR);
        AppBrandVideoWrapper appBrandVideoWrapper = new AppBrandVideoWrapper(this);
        this.iJy = new AppBrandVideoView((Context) this, (View) appBrandVideoWrapper);
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = new AppBrandVideoViewControlBar(this);
        AppBrandVideoView appBrandVideoView = this.iJy;
        if (appBrandVideoView != null) {
            appBrandVideoView.a((com.tencent.mm.plugin.appbrand.jsapi.video.d.a) appBrandVideoViewControlBar);
        }
        appBrandVideoWrapper.setVideoFooterView(appBrandVideoViewControlBar);
        ((FrameLayout) findViewById(R.id.wv)).addView(this.iJy, new LayoutParams(-2, -2));
        if (!(bo.isNullOrNil(this.iJx) || this.iJy == null)) {
            AppBrandVideoView appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setAutoPlay(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setLoop(false);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setMute(false);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setCookieData(null);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setCover$16da05f7(null);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setShowDanmakuBtn(false);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setShowMuteBtn(false);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setShowPlayBtn(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setShowProgress(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setShowFullScreenBtn(false);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setIsShowBasicControls(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setShowCenterPlayBtn(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setShowControlProgress(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.setPageGesture(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.eq(true);
            }
            appBrandVideoView2 = this.iJy;
            if (appBrandVideoView2 != null) {
                appBrandVideoView2.e(this.iJx, false, 0);
                AppMethodBeat.o(135004);
                return;
            }
        }
        AppMethodBeat.o(135004);
    }

    public final boolean apx() {
        return true;
    }

    public final void onResume() {
        AppMethodBeat.i(135005);
        super.onResume();
        AppBrandVideoView appBrandVideoView = this.iJy;
        if (appBrandVideoView != null) {
            appBrandVideoView.akW();
            AppMethodBeat.o(135005);
            return;
        }
        AppMethodBeat.o(135005);
    }

    public final void onPause() {
        AppMethodBeat.i(135006);
        super.onPause();
        AppBrandVideoView appBrandVideoView = this.iJy;
        if (appBrandVideoView != null) {
            appBrandVideoView.ow(3);
            AppMethodBeat.o(135006);
            return;
        }
        AppMethodBeat.o(135006);
    }

    public final void onDestroy() {
        AppMethodBeat.i(135007);
        super.onDestroy();
        AppBrandVideoView appBrandVideoView = this.iJy;
        if (appBrandVideoView != null) {
            appBrandVideoView.aEX();
            AppMethodBeat.o(135007);
            return;
        }
        AppMethodBeat.o(135007);
    }
}
