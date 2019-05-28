package com.tencent.mm.plugin.sysvideo.ui.video;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI extends MMActivity {
    private long duration = -1;
    private VideoView swA;
    private String swB = null;
    private final int swC = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private ak swD = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25631);
            VideoRecorderPreviewUI.this.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            VideoRecorderPreviewUI.this.mController.hideTitleView();
            AppMethodBeat.o(25631);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoRecorderPreviewUI() {
        AppMethodBeat.i(25636);
        AppMethodBeat.o(25636);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25637);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.swB = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        setMMTitle((int) R.string.f1m);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25630);
                VideoRecorderPreviewUI.this.finish();
                VideoRecorderPreviewUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(25630);
                return true;
            }
        });
        bSZ();
        AppMethodBeat.o(25637);
    }

    public void onStart() {
        AppMethodBeat.i(25638);
        super.onStart();
        AppMethodBeat.o(25638);
    }

    public final void initView() {
        AppMethodBeat.i(139023);
        bSZ();
        AppMethodBeat.o(139023);
    }

    public void onPause() {
        AppMethodBeat.i(25640);
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
        AppMethodBeat.o(25640);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(25641);
        ae.h(ae.a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.o(25641);
    }

    private void bSZ() {
        AppMethodBeat.i(25642);
        this.swA = (VideoView) findViewById(R.id.f0v);
        this.swA.setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(25632);
                VideoRecorderPreviewUI.this.swA.stopPlayback();
                h.g(VideoRecorderPreviewUI.this, R.string.f1l, R.string.f1j);
                AppMethodBeat.o(25632);
                return false;
            }
        });
        this.swA.setOnPreparedListener(new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(25633);
                ab.d("MicroMsg.VideoRecorderPreviewUI", g.Mp() + " onPrepared");
                ab.d("MicroMsg.VideoRecorderPreviewUI", g.Mp() + " onPrepared");
                VideoView a = VideoRecorderPreviewUI.this.swA;
                if (a.ieC == null || !a.vvE) {
                    a.ief = true;
                } else {
                    a.ieC.start();
                    a.ief = false;
                }
                VideoRecorderPreviewUI.this.swD.sendEmptyMessageDelayed(0, 3000);
                AppMethodBeat.o(25633);
            }
        });
        findViewById(R.id.f0u).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25634);
                VideoRecorderPreviewUI.this.swD.removeMessages(0);
                if (VideoRecorderPreviewUI.this.mController.isTitleShowing()) {
                    VideoRecorderPreviewUI.this.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    VideoRecorderPreviewUI.this.mController.hideTitleView();
                    AppMethodBeat.o(25634);
                    return;
                }
                VideoRecorderPreviewUI.this.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                VideoRecorderPreviewUI.this.mController.showTitleView();
                VideoRecorderPreviewUI.this.swD.removeMessages(0);
                VideoRecorderPreviewUI.this.swD.sendEmptyMessageDelayed(0, 3000);
                AppMethodBeat.o(25634);
            }
        });
        this.swA.setOnCompletionListener(new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(25635);
                VideoRecorderPreviewUI.this.finish();
                VideoRecorderPreviewUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(25635);
            }
        });
        if (this.swB != null) {
            this.swA.stopPlayback();
            this.swA.setVideoURI(this.swB);
        }
        AppMethodBeat.o(25642);
    }

    public final int getLayoutId() {
        return R.layout.b1j;
    }
}
