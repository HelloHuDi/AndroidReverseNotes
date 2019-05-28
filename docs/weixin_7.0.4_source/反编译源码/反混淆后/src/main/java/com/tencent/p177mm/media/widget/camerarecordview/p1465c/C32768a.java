package com.tencent.p177mm.media.widget.camerarecordview.p1465c;

import android.content.Context;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.widget.camerarecordview.p258a.C42176b;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.media.widget.p257b.C1788b;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "", "enableCameraOrientationFit", "", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "useCpuCrop", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.c.a */
public interface C32768a {
    /* renamed from: DX */
    boolean mo45656DX();

    /* renamed from: WD */
    boolean mo45657WD();

    /* renamed from: WE */
    boolean mo45658WE();

    C1791c getCameraPreviewView();

    Context getContext();

    C42176b getEncodeConfig();

    C37897a getPreviewRenderer();

    C37897a getRecordRenderer();

    C1788b getRecorder();

    int getResolutionLimit();

    VideoTransPara getVideoTransPara();
}
