package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
@l(dWo = {1, 1, 13}, dWp = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "videoCallBack", "com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-story_release"})
public final class StoryPreviewUI extends MMActivity {
    private final String TAG = "MicroMsg.StoryPreviewUI";
    private VideoPlayerTextureView oxL;
    private final b seV = new b(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    public static final class b implements com.tencent.mm.pluginsdk.ui.tools.e.a {
        final /* synthetic */ StoryPreviewUI seW;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTextureUpdate"})
        static final class a implements e {
            final /* synthetic */ b seX;

            a(b bVar) {
                this.seX = bVar;
            }

            public final void bQL() {
                AppMethodBeat.i(110033);
                StoryPreviewUI.a(this.seX.seW).setVisibility(0);
                StoryPreviewUI.a(this.seX.seW).setAlpha(1.0f);
                AppMethodBeat.o(110033);
            }
        }

        b(StoryPreviewUI storyPreviewUI) {
            this.seW = storyPreviewUI;
        }

        public final void pL() {
            AppMethodBeat.i(110034);
            StoryPreviewUI.a(this.seW).setOneTimeVideoTextureUpdateCallback(new a(this));
            StoryPreviewUI.a(this.seW).start();
            AppMethodBeat.o(110034);
        }

        public final void EA() {
            AppMethodBeat.i(110035);
            StoryPreviewUI.a(this.seW).d(0.0d, true);
            AppMethodBeat.o(110035);
        }

        public final int dG(int i, int i2) {
            return 0;
        }

        public final void dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements OnClickListener {
        final /* synthetic */ StoryPreviewUI seW;

        a(StoryPreviewUI storyPreviewUI) {
            this.seW = storyPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110032);
            this.seW.finish();
            AppMethodBeat.o(110032);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StoryPreviewUI() {
        AppMethodBeat.i(110038);
        AppMethodBeat.o(110038);
    }

    public static final /* synthetic */ VideoPlayerTextureView a(StoryPreviewUI storyPreviewUI) {
        AppMethodBeat.i(110039);
        VideoPlayerTextureView videoPlayerTextureView = storyPreviewUI.oxL;
        if (videoPlayerTextureView == null) {
            j.avw("videoPlayView");
        }
        AppMethodBeat.o(110039);
        return videoPlayerTextureView;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110036);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        Ne(8);
        getWindow().addFlags(2097280);
        if (d.iW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        String stringExtra = getIntent().getStringExtra("video_path");
        View findViewById = findViewById(R.id.eun);
        j.o(findViewById, "findViewById(R.id.story_preview_play_view)");
        this.oxL = (VideoPlayerTextureView) findViewById;
        VideoPlayerTextureView videoPlayerTextureView = this.oxL;
        if (videoPlayerTextureView == null) {
            j.avw("videoPlayView");
        }
        videoPlayerTextureView.setVideoPath(stringExtra);
        VideoPlayerTextureView videoPlayerTextureView2 = this.oxL;
        if (videoPlayerTextureView2 == null) {
            j.avw("videoPlayView");
        }
        videoPlayerTextureView2.setVideoCallback(this.seV);
        videoPlayerTextureView = this.oxL;
        if (videoPlayerTextureView == null) {
            j.avw("videoPlayView");
        }
        videoPlayerTextureView.setAlpha(0.0f);
        findViewById(R.id.euo).setOnClickListener(new a(this));
        AppMethodBeat.o(110036);
    }

    public final int getLayoutId() {
        return R.layout.az0;
    }

    public final void onDestroy() {
        AppMethodBeat.i(110037);
        super.onDestroy();
        VideoPlayerTextureView videoPlayerTextureView = this.oxL;
        if (videoPlayerTextureView == null) {
            j.avw("videoPlayView");
        }
        videoPlayerTextureView.stop();
        com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a aVar = StoryAudioManagerProxy.sas;
        StoryAudioManagerProxy.access$getInstance$cp().cancelAll();
        AppMethodBeat.o(110037);
    }
}
