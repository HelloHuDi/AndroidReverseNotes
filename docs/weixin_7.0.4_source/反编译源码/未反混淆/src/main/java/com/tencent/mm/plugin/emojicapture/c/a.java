package com.tencent.mm.plugin.emojicapture.c;

import a.l;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract;", "", "IPresenter", "IView", "plugin-emojicapture_release"})
public interface a {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "stopRecord", "", "plugin-emojicapture_release"})
    public interface a {
        boolean EB();

        void a(com.tencent.mm.plugin.emojicapture.model.a.a aVar);

        void a(com.tencent.mm.plugin.emojicapture.model.a.b bVar);

        void aDm();

        void destroy();

        void exit();

        void pk();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J/\u0010\f\u001a\u00020\r2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fH&J\b\u0010\u0014\u001a\u00020\rH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\rH&¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "onDestroy", "onPause", "onResume", "startRecord", "stopRecord", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleVoiceDetect", "useBackGroundCamera", "plugin-emojicapture_release"})
    public interface b {
        void a(com.tencent.mm.plugin.emojicapture.model.a.b bVar);

        void gB(boolean z);

        CaptureDecoration getDecoration();
    }
}
