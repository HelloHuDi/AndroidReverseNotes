package com.tencent.p177mm.plugin.emojicapture.p949c;

import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C27800a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiVideoPlayTextureView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EditorItemContainer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract;", "", "IPresenter", "IView", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.c.b */
public interface C11605b {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\tH&J\"\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH&¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "destroy", "mix", "onBack", "", "onVoiceTextFinished", "voiceText", "", "pause", "removeBg", "resume", "setup", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "speedUp", "updateText", "text", "color", "", "change", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.c.b$a */
    public interface C11606a {
        /* renamed from: Ab */
        boolean mo23335Ab();

        /* renamed from: JZ */
        void mo23336JZ(String str);

        /* renamed from: b */
        void mo23337b(C27800a c27800a);

        boolean bmx();

        boolean bmy();

        void bmz();

        /* renamed from: c */
        void mo23341c(C8955k c8955k);

        void destroy();

        /* renamed from: n */
        void mo23343n(String str, int i, boolean z);

        void pause();

        void resume();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0003H&J8\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH&J\"\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0003H&¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "", "destroy", "", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getVideoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setup", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "videoPath", "", "removeBgEnable", "removeBg", "videoPreparedCallback", "Lkotlin/Function0;", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "", "viewPrepared", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.c.b$b */
    public interface C11607b {
        /* renamed from: a */
        void mo23346a(C27800a c27800a, String str, boolean z, boolean z2, C31214a<C37091y> c31214a);

        /* renamed from: a */
        void mo23347a(boolean z, CharSequence charSequence, int i);

        boolean aFF();

        void bmA();

        boolean bmB();

        boolean bmC();

        void destroy();

        /* renamed from: gC */
        void mo23353gC(boolean z);

        EditorItemContainer getItemContainer();

        EmojiVideoPlayTextureView getVideoPlayView();

        void reset();
    }
}
