package com.tencent.p177mm.plugin.emojicapture.p949c;

import com.tencent.p177mm.plugin.emojicapture.model.p950a.C27800a;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.capture.CaptureDecoration;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract;", "", "IPresenter", "IView", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.c.a */
public interface C27793a {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "stopRecord", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.c.a$a */
    public interface C27794a {
        /* renamed from: EB */
        boolean mo45630EB();

        /* renamed from: a */
        void mo45631a(C27800a c27800a);

        /* renamed from: a */
        void mo45632a(C42971b c42971b);

        void aDm();

        void destroy();

        void exit();

        /* renamed from: pk */
        void mo45636pk();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J/\u0010\f\u001a\u00020\r2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fH&J\b\u0010\u0014\u001a\u00020\rH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\rH&¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "onDestroy", "onPause", "onResume", "startRecord", "stopRecord", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleVoiceDetect", "useBackGroundCamera", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.c.a$b */
    public interface C27795b {
        /* renamed from: a */
        void mo45637a(C42971b c42971b);

        /* renamed from: gB */
        void mo45638gB(boolean z);

        CaptureDecoration getDecoration();
    }
}
