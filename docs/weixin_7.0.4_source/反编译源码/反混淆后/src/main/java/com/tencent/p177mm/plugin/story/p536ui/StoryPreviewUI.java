package com.tencent.p177mm.plugin.story.p536ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.p177mm.plugin.story.proxy.StoryAudioManagerProxy.C22248a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "videoCallBack", "com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.StoryPreviewUI */
public final class StoryPreviewUI extends MMActivity {
    private final String TAG = "MicroMsg.StoryPreviewUI";
    private VideoPlayerTextureView oxL;
    private final C35219b seV = new C35219b(this);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryPreviewUI$b */
    public static final class C35219b implements C14981a {
        final /* synthetic */ StoryPreviewUI seW;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTextureUpdate"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StoryPreviewUI$b$a */
        static final class C4153a implements C14980e {
            final /* synthetic */ C35219b seX;

            C4153a(C35219b c35219b) {
                this.seX = c35219b;
            }

            public final void bQL() {
                AppMethodBeat.m2504i(110033);
                StoryPreviewUI.m78157a(this.seX.seW).setVisibility(0);
                StoryPreviewUI.m78157a(this.seX.seW).setAlpha(1.0f);
                AppMethodBeat.m2505o(110033);
            }
        }

        C35219b(StoryPreviewUI storyPreviewUI) {
            this.seW = storyPreviewUI;
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(110034);
            StoryPreviewUI.m78157a(this.seW).setOneTimeVideoTextureUpdateCallback(new C4153a(this));
            StoryPreviewUI.m78157a(this.seW).start();
            AppMethodBeat.m2505o(110034);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(110035);
            StoryPreviewUI.m78157a(this.seW).mo27356d(0.0d, true);
            AppMethodBeat.m2505o(110035);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryPreviewUI$a */
    static final class C39914a implements OnClickListener {
        final /* synthetic */ StoryPreviewUI seW;

        C39914a(StoryPreviewUI storyPreviewUI) {
            this.seW = storyPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110032);
            this.seW.finish();
            AppMethodBeat.m2505o(110032);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public StoryPreviewUI() {
        AppMethodBeat.m2504i(110038);
        AppMethodBeat.m2505o(110038);
    }

    /* renamed from: a */
    public static final /* synthetic */ VideoPlayerTextureView m78157a(StoryPreviewUI storyPreviewUI) {
        AppMethodBeat.m2504i(110039);
        VideoPlayerTextureView videoPlayerTextureView = storyPreviewUI.oxL;
        if (videoPlayerTextureView == null) {
            C25052j.avw("videoPlayView");
        }
        AppMethodBeat.m2505o(110039);
        return videoPlayerTextureView;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110036);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        mo17375Ne(8);
        getWindow().addFlags(2097280);
        if (C1443d.m3068iW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        String stringExtra = getIntent().getStringExtra("video_path");
        View findViewById = findViewById(2131828189);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_preview_play_view)");
        this.oxL = (VideoPlayerTextureView) findViewById;
        VideoPlayerTextureView videoPlayerTextureView = this.oxL;
        if (videoPlayerTextureView == null) {
            C25052j.avw("videoPlayView");
        }
        videoPlayerTextureView.setVideoPath(stringExtra);
        VideoPlayerTextureView videoPlayerTextureView2 = this.oxL;
        if (videoPlayerTextureView2 == null) {
            C25052j.avw("videoPlayView");
        }
        videoPlayerTextureView2.setVideoCallback(this.seV);
        videoPlayerTextureView = this.oxL;
        if (videoPlayerTextureView == null) {
            C25052j.avw("videoPlayView");
        }
        videoPlayerTextureView.setAlpha(0.0f);
        findViewById(2131828190).setOnClickListener(new C39914a(this));
        AppMethodBeat.m2505o(110036);
    }

    public final int getLayoutId() {
        return 2130970900;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110037);
        super.onDestroy();
        VideoPlayerTextureView videoPlayerTextureView = this.oxL;
        if (videoPlayerTextureView == null) {
            C25052j.avw("videoPlayView");
        }
        videoPlayerTextureView.stop();
        C22248a c22248a = StoryAudioManagerProxy.sas;
        StoryAudioManagerProxy.access$getInstance$cp().cancelAll();
        AppMethodBeat.m2505o(110037);
    }
}
