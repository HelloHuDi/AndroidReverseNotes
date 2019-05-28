package com.tencent.p177mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1380j.C45291a;
import com.tencent.p177mm.compatible.p1380j.C45291a.C41941a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoCompressUI */
public class VideoCompressUI extends MMBaseActivity {
    private static int ehv;
    private C46607d ext = new C46607d(this);
    private VideoTransPara fYK;
    private ProgressDialog ozv;
    private C43311a ozw = new C43311a(this, (byte) 0);
    private boolean ozx;
    private Runnable ozy = new C460802();
    private String thumbPath;
    private String videoPath;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoCompressUI$1 */
    class C125711 implements Runnable {
        C125711() {
        }

        public final void run() {
            AppMethodBeat.m2504i(3695);
            VideoCompressUI.this.fYK = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
            if (VideoCompressUI.this.fYK == null) {
                C4990ab.m7412e("MicroMsg.VideoCompressUI", "VideoSendPreprocessTask para is null");
                VideoCompressUI.this.setResult(0);
                VideoCompressUI.this.finish();
                AppMethodBeat.m2505o(3695);
                return;
            }
            C1427q.m3050ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
            C7305d.post(VideoCompressUI.this.ozy, "video_remuxing_if_needed");
            AppMethodBeat.m2505o(3695);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoCompressUI$a */
    class C43311a {
        public int audioBitRate;
        public String fPU;
        public String fPV;
        public int fPW;
        public int fPX;
        public int videoBitRate;
        public int videoFrameRate;
        public int videoHeight;
        public int videoWidth;

        private C43311a() {
            this.fPW = -1;
            this.videoHeight = -1;
            this.videoWidth = -1;
            this.videoBitRate = -1;
            this.fPX = -1;
            this.videoFrameRate = -1;
            this.audioBitRate = -1;
        }

        /* synthetic */ C43311a(VideoCompressUI videoCompressUI, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(3698);
            String str = "VideoAnalysisStruct{videoTrackMime='" + this.fPU + '\'' + ", audioTrackMime='" + this.fPV + '\'' + ", durationMs=" + this.fPW + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.fPX + ", videoFrameRate=" + this.videoFrameRate + ", audioBitRate=" + this.audioBitRate + '}';
            AppMethodBeat.m2505o(3698);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoCompressUI$2 */
    class C460802 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoCompressUI$2$1 */
        class C460791 implements Runnable {
            C460791() {
            }

            public final void run() {
                AppMethodBeat.m2504i(3696);
                if (VideoCompressUI.this.ozv != null) {
                    VideoCompressUI.this.ozv.dismiss();
                }
                AppMethodBeat.m2505o(3696);
            }
        }

        C460802() {
        }

        public final void run() {
            AppMethodBeat.m2504i(3697);
            try {
                VideoCompressUI.m85854a(VideoCompressUI.this, VideoCompressUI.this.videoPath);
                Intent intent = new Intent();
                Point B = VideoCompressUI.m85850B(VideoCompressUI.this.ozw.videoWidth, VideoCompressUI.this.ozw.videoHeight, VideoCompressUI.this.fYK.width, VideoCompressUI.this.fYK.height);
                if (VideoCompressUI.m85856b(VideoCompressUI.this, VideoCompressUI.this.fYK) || B != null) {
                    Point point;
                    if (B == null) {
                        point = new Point(VideoCompressUI.this.ozw.videoWidth, VideoCompressUI.this.ozw.videoHeight);
                    } else {
                        point = B;
                    }
                    VideoCompressUI.this.videoPath;
                    String bQo = VideoCompressUI.bQo();
                    boolean z = VideoCompressUI.this.ozw.videoWidth >= 2000 || VideoCompressUI.this.ozw.videoHeight >= 2000;
                    C4990ab.m7417i("MicroMsg.VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s, ish265: %s, videoSizeTooLarge:%s", Integer.valueOf(VideoCompressUI.this.ozw.videoWidth), Integer.valueOf(VideoCompressUI.this.ozw.videoHeight), point, VideoCompressUI.this.videoPath, bQo, Boolean.valueOf(VideoCompressUI.this.ozx), Boolean.valueOf(z));
                    VideoCompressUI.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 30000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.VideoCompressUI");
                    C4990ab.m7417i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(VideoCompressUI.ehv));
                    if (VideoCompressUI.this.ozx || z) {
                        C4990ab.m7416i("MicroMsg.VideoCompressUI", "ish265, transfer to h264");
                        VideoCompressUI.this.fYK.width = point.x;
                        VideoCompressUI.this.fYK.height = point.y;
                        C17987e.m28300a(VideoCompressUI.this.videoPath, bQo, VideoCompressUI.this.fYK);
                    } else {
                        SightVideoJNI.remuxing(VideoCompressUI.this.videoPath, bQo, point.x, point.y, VideoCompressUI.this.fYK.videoBitrate, VideoCompressUI.this.fYK.fzV, 8, VideoCompressUI.this.fYK.fzU, 25.0f, (float) VideoCompressUI.this.fYK.fps, null, 0, false);
                    }
                    if (VideoCompressUI.ehv != 0) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, VideoCompressUI.ehv);
                        C4990ab.m7417i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance stopPerformace %s", Integer.valueOf(VideoCompressUI.ehv));
                        VideoCompressUI.ehv = 0;
                    }
                    intent.putExtra("K_SEGMENTVIDEOPATH", bQo);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.m85853a(VideoCompressUI.this, bQo, null));
                } else {
                    C4990ab.m7416i("MicroMsg.VideoCompressUI", "no need remux, directly set result");
                    intent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.this.videoPath);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.m85853a(VideoCompressUI.this, VideoCompressUI.this.videoPath, VideoCompressUI.this.thumbPath));
                }
                VideoCompressUI.this.setResult(-1, intent);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoCompressUI", e, "video compress failed e [%s]", e.getMessage());
            } finally {
                VideoCompressUI.this.finish();
                C5004al.m7441d(new C460791());
                AppMethodBeat.m2505o(3697);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VideoCompressUI() {
        AppMethodBeat.m2504i(3699);
        AppMethodBeat.m2505o(3699);
    }

    /* renamed from: a */
    static /* synthetic */ String m85853a(VideoCompressUI videoCompressUI, String str, String str2) {
        AppMethodBeat.m2504i(3707);
        String fe = videoCompressUI.m85861fe(str, str2);
        AppMethodBeat.m2505o(3707);
        return fe;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(3700);
        super.onCreate(bundle);
        setContentView(2130968794);
        Intent intent = getIntent();
        if (intent == null || C5046bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(3700);
            return;
        }
        this.ozv = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), false, null);
        this.videoPath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
        this.thumbPath = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        this.ext.connect(new C125711());
        AppMethodBeat.m2505o(3700);
    }

    /* renamed from: fe */
    private String m85861fe(String str, String str2) {
        Exception e;
        AppMethodBeat.m2504i(3701);
        if (C5046bo.isNullOrNil(str2)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://".concat(String.valueOf(str))));
                C41941a j = C45291a.m83515j(this, intent);
                if (!(j == null || j.bitmap == null)) {
                    String str3 = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmpThumb/";
                    if (C5730e.m8628ct(str3)) {
                        C5730e.m8618N(str3, true);
                    }
                    C5730e.m8643tf(str3);
                    str3 = str3 + "video_send_preprocess_thumb_" + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
                    C4990ab.m7417i("MicroMsg.VideoCompressUI", "thumbPath: %s", str3);
                    try {
                        C5056d.m7625a(j.bitmap, 80, CompressFormat.JPEG, str3, true);
                        str2 = str3;
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str3;
                        C4990ab.printErrStackTrace("MicroMsg.VideoCompressUI", e, "get thumb error: %s", e.getMessage());
                        AppMethodBeat.m2505o(3701);
                        return str2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                C4990ab.printErrStackTrace("MicroMsg.VideoCompressUI", e, "get thumb error: %s", e.getMessage());
                AppMethodBeat.m2505o(3701);
                return str2;
            }
            AppMethodBeat.m2505o(3701);
        } else {
            AppMethodBeat.m2505o(3701);
        }
        return str2;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(3702);
        super.onDestroy();
        if (this.ext != null) {
            this.ext.release();
        }
        AppMethodBeat.m2505o(3702);
    }

    /* renamed from: B */
    static /* synthetic */ Point m85850B(int i, int i2, int i3, int i4) {
        int max;
        AppMethodBeat.m2504i(3704);
        if (i > i2 && i3 < i4) {
            max = Math.max(i3, i4);
            i4 = Math.min(i3, i4);
            i3 = max;
        }
        C4990ab.m7416i("MicroMsg.VideoCompressUI", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                max /= 2;
                int i5 = min / 2;
                Point point;
                if (max % 16 != 0 || Math.abs(max - max2) >= 16 || i5 % 16 != 0 || Math.abs(i5 - min2) >= 16) {
                    point = new Point();
                    if (i < i2) {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) max)));
                    } else {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) i5)));
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    C4990ab.m7417i("MicroMsg.VideoCompressUI", "calc scale, outputsize: %s %s", Integer.valueOf(max), Integer.valueOf(i5));
                    point.x = max;
                    point.y = i5;
                    AppMethodBeat.m2505o(3704);
                    return point;
                }
                C4990ab.m7416i("MicroMsg.VideoCompressUI", "calc scale, double ratio divide by 16");
                max = i / 2;
                i5 = i2 / 2;
                if (max % 2 != 0) {
                    max++;
                }
                if (i5 % 2 != 0) {
                    i5++;
                }
                point = new Point(max, i5);
                AppMethodBeat.m2505o(3704);
                return point;
            }
            C4990ab.m7416i("MicroMsg.VideoCompressUI", "calc scale, same len divide by 16, no need scale");
            AppMethodBeat.m2505o(3704);
            return null;
        }
        C4990ab.m7416i("MicroMsg.VideoCompressUI", "calc scale, small or equal to spec size");
        AppMethodBeat.m2505o(3704);
        return null;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m85856b(VideoCompressUI videoCompressUI, VideoTransPara videoTransPara) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.m2504i(3705);
        if (videoTransPara == null) {
            C4990ab.m7412e("MicroMsg.VideoCompressUI", "hy: given target trans param is null");
            z = false;
        } else if (videoTransPara.videoBitrate < videoCompressUI.ozw.videoBitRate) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            z3 = true;
        }
        if (!videoCompressUI.ozx) {
            z2 = z3;
        }
        AppMethodBeat.m2505o(3705);
        return z2;
    }

    static /* synthetic */ String bQo() {
        AppMethodBeat.m2504i(3706);
        String str = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmp/";
        if (C5730e.m8628ct(str)) {
            C5730e.m8618N(str, true);
        }
        C5730e.m8643tf(str);
        C4990ab.m7417i("MicroMsg.VideoCompressUI", "initAndGetTmpPath: %s", str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX);
        AppMethodBeat.m2505o(3706);
        return str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
    }
}
