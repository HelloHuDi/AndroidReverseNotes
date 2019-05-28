package com.tencent.p177mm.plugin.sysvideo.p1040ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.video.VideoView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI */
public class VideoRecorderPreviewUI extends MMActivity {
    private long duration = -1;
    private VideoView swA;
    private String swB = null;
    private final int swC = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private C7306ak swD = new C294102();

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI$4 */
    class C223694 implements OnPreparedListener {
        C223694() {
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(25633);
            C4990ab.m7410d("MicroMsg.VideoRecorderPreviewUI", C1447g.m3074Mp() + " onPrepared");
            C4990ab.m7410d("MicroMsg.VideoRecorderPreviewUI", C1447g.m3074Mp() + " onPrepared");
            VideoView a = VideoRecorderPreviewUI.this.swA;
            if (a.ieC == null || !a.vvE) {
                a.ief = true;
            } else {
                a.ieC.start();
                a.ief = false;
            }
            VideoRecorderPreviewUI.this.swD.sendEmptyMessageDelayed(0, 3000);
            AppMethodBeat.m2505o(25633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI$6 */
    class C223706 implements OnCompletionListener {
        C223706() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(25635);
            VideoRecorderPreviewUI.this.finish();
            VideoRecorderPreviewUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(25635);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI$5 */
    class C294085 implements OnClickListener {
        C294085() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25634);
            VideoRecorderPreviewUI.this.swD.removeMessages(0);
            if (VideoRecorderPreviewUI.this.mController.isTitleShowing()) {
                VideoRecorderPreviewUI.this.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                VideoRecorderPreviewUI.this.mController.hideTitleView();
                AppMethodBeat.m2505o(25634);
                return;
            }
            VideoRecorderPreviewUI.this.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            VideoRecorderPreviewUI.this.mController.showTitleView();
            VideoRecorderPreviewUI.this.swD.removeMessages(0);
            VideoRecorderPreviewUI.this.swD.sendEmptyMessageDelayed(0, 3000);
            AppMethodBeat.m2505o(25634);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI$1 */
    class C294091 implements OnMenuItemClickListener {
        C294091() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25630);
            VideoRecorderPreviewUI.this.finish();
            VideoRecorderPreviewUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(25630);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI$2 */
    class C294102 extends C7306ak {
        C294102() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(25631);
            VideoRecorderPreviewUI.this.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            VideoRecorderPreviewUI.this.mController.hideTitleView();
            AppMethodBeat.m2505o(25631);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI$3 */
    class C294113 implements OnErrorListener {
        C294113() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(25632);
            VideoRecorderPreviewUI.this.swA.stopPlayback();
            C30379h.m48467g(VideoRecorderPreviewUI.this, C25738R.string.f1l, C25738R.string.f1j);
            AppMethodBeat.m2505o(25632);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VideoRecorderPreviewUI() {
        AppMethodBeat.m2504i(25636);
        AppMethodBeat.m2505o(25636);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25637);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.swB = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        setMMTitle((int) C25738R.string.f1m);
        setBackBtn(new C294091());
        bSZ();
        AppMethodBeat.m2505o(25637);
    }

    public void onStart() {
        AppMethodBeat.m2504i(25638);
        super.onStart();
        AppMethodBeat.m2505o(25638);
    }

    public final void initView() {
        AppMethodBeat.m2504i(139023);
        bSZ();
        AppMethodBeat.m2505o(139023);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25640);
        super.onPause();
        if (this.swA.isPlaying()) {
            VideoView videoView = this.swA;
            if (videoView.ieC != null && videoView.vvE && videoView.ieC.isPlaying()) {
                videoView.ieC.pause();
            }
            videoView.ief = false;
        }
        finish();
        overridePendingTransition(0, 0);
        this.swD.removeMessages(0);
        AppMethodBeat.m2505o(25640);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(25641);
        C5222ae.m7946h(C5222ae.m7934a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.m2505o(25641);
    }

    private void bSZ() {
        AppMethodBeat.m2504i(25642);
        this.swA = (VideoView) findViewById(2131828419);
        this.swA.setOnErrorListener(new C294113());
        this.swA.setOnPreparedListener(new C223694());
        findViewById(2131828418).setOnClickListener(new C294085());
        this.swA.setOnCompletionListener(new C223706());
        if (this.swB != null) {
            this.swA.stopPlayback();
            this.swA.setVideoURI(this.swB);
        }
        AppMethodBeat.m2505o(25642);
    }

    public final int getLayoutId() {
        return 2130970996;
    }
}
