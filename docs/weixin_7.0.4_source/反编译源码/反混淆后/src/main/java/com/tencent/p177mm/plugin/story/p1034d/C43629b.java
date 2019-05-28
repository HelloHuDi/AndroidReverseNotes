package com.tencent.p177mm.plugin.story.p1034d;

import com.google.android.exoplayer2.C0884v;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.EditorItemContainer;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.protocal.protobuf.cei;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/EditorContract;", "", "IPresenter", "IView", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.d.b */
public interface C43629b {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\"\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH&J0\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"H&J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0003H&J*\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H&¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "", "back", "", "checkLocation", "", "destroy", "getItemContainer", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "getLocation", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "getMusicRequestId", "", "getVideoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "isShow", "isShowSmileyPanel", "isShowTextEditor", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "reset", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setup", "videoPath", "", "startTime", "endTime", "videoPreparedCallback", "Lkotlin/Function0;", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "textBgColor", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.d.b$b */
    public interface C13742b {
        /* renamed from: a */
        void mo25946a(String str, long j, long j2, C31214a<C37091y> c31214a);

        boolean aFF();

        boolean cxq();

        void destroy();

        EditorItemContainer getItemContainer();

        cei getLocation();

        VideoPlayerTextureView getVideoPlayView();

        void reset();

        void setMusicPlayer(C0884v c0884v);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "", "destroy", "", "mix", "muteOrigin", "mute", "", "notifyFavorite", "isFavorite", "notifyMoment", "isNotify", "onBack", "onPlayerRepeat", "pause", "pauseAudio", "playAudio", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "prepareReport", "resume", "setup", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.d.b$a */
    public interface C29280a {
        /* renamed from: Ab */
        boolean mo47474Ab();

        /* renamed from: a */
        void mo47475a(AudioCacheInfo audioCacheInfo);

        void bmz();

        void cxp();

        /* renamed from: lt */
        void mo47478lt(boolean z);

        /* renamed from: lu */
        void mo47479lu(boolean z);

        /* renamed from: lv */
        void mo47480lv(boolean z);

        void pauseAudio();
    }
}
