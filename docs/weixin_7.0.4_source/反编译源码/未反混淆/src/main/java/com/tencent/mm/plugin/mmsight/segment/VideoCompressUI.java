package com.tencent.mm.plugin.mmsight.segment;

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
import com.tencent.mm.R;
import com.tencent.mm.bj.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

@TargetApi(16)
public class VideoCompressUI extends MMBaseActivity {
    private static int ehv;
    private d ext = new d(this);
    private VideoTransPara fYK;
    private ProgressDialog ozv;
    private a ozw = new a(this, (byte) 0);
    private boolean ozx;
    private Runnable ozy = new Runnable() {
        public final void run() {
            AppMethodBeat.i(3697);
            try {
                VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.this.videoPath);
                Intent intent = new Intent();
                Point B = VideoCompressUI.B(VideoCompressUI.this.ozw.videoWidth, VideoCompressUI.this.ozw.videoHeight, VideoCompressUI.this.fYK.width, VideoCompressUI.this.fYK.height);
                if (VideoCompressUI.b(VideoCompressUI.this, VideoCompressUI.this.fYK) || B != null) {
                    Point point;
                    if (B == null) {
                        point = new Point(VideoCompressUI.this.ozw.videoWidth, VideoCompressUI.this.ozw.videoHeight);
                    } else {
                        point = B;
                    }
                    VideoCompressUI.this.videoPath;
                    String bQo = VideoCompressUI.bQo();
                    boolean z = VideoCompressUI.this.ozw.videoWidth >= 2000 || VideoCompressUI.this.ozw.videoHeight >= 2000;
                    ab.i("MicroMsg.VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s, ish265: %s, videoSizeTooLarge:%s", Integer.valueOf(VideoCompressUI.this.ozw.videoWidth), Integer.valueOf(VideoCompressUI.this.ozw.videoHeight), point, VideoCompressUI.this.videoPath, bQo, Boolean.valueOf(VideoCompressUI.this.ozx), Boolean.valueOf(z));
                    VideoCompressUI.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 30000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.VideoCompressUI");
                    ab.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(VideoCompressUI.ehv));
                    if (VideoCompressUI.this.ozx || z) {
                        ab.i("MicroMsg.VideoCompressUI", "ish265, transfer to h264");
                        VideoCompressUI.this.fYK.width = point.x;
                        VideoCompressUI.this.fYK.height = point.y;
                        e.a(VideoCompressUI.this.videoPath, bQo, VideoCompressUI.this.fYK);
                    } else {
                        SightVideoJNI.remuxing(VideoCompressUI.this.videoPath, bQo, point.x, point.y, VideoCompressUI.this.fYK.videoBitrate, VideoCompressUI.this.fYK.fzV, 8, VideoCompressUI.this.fYK.fzU, 25.0f, (float) VideoCompressUI.this.fYK.fps, null, 0, false);
                    }
                    if (VideoCompressUI.ehv != 0) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, VideoCompressUI.ehv);
                        ab.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance stopPerformace %s", Integer.valueOf(VideoCompressUI.ehv));
                        VideoCompressUI.ehv = 0;
                    }
                    intent.putExtra("K_SEGMENTVIDEOPATH", bQo);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, bQo, null));
                } else {
                    ab.i("MicroMsg.VideoCompressUI", "no need remux, directly set result");
                    intent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.this.videoPath);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.this.videoPath, VideoCompressUI.this.thumbPath));
                }
                VideoCompressUI.this.setResult(-1, intent);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VideoCompressUI", e, "video compress failed e [%s]", e.getMessage());
            } finally {
                VideoCompressUI.this.finish();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(3696);
                        if (VideoCompressUI.this.ozv != null) {
                            VideoCompressUI.this.ozv.dismiss();
                        }
                        AppMethodBeat.o(3696);
                    }
                });
                AppMethodBeat.o(3697);
            }
        }
    };
    private String thumbPath;
    private String videoPath;

    class a {
        public int audioBitRate;
        public String fPU;
        public String fPV;
        public int fPW;
        public int fPX;
        public int videoBitRate;
        public int videoFrameRate;
        public int videoHeight;
        public int videoWidth;

        private a() {
            this.fPW = -1;
            this.videoHeight = -1;
            this.videoWidth = -1;
            this.videoBitRate = -1;
            this.fPX = -1;
            this.videoFrameRate = -1;
            this.audioBitRate = -1;
        }

        /* synthetic */ a(VideoCompressUI videoCompressUI, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(3698);
            String str = "VideoAnalysisStruct{videoTrackMime='" + this.fPU + '\'' + ", audioTrackMime='" + this.fPV + '\'' + ", durationMs=" + this.fPW + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.fPX + ", videoFrameRate=" + this.videoFrameRate + ", audioBitRate=" + this.audioBitRate + '}';
            AppMethodBeat.o(3698);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoCompressUI() {
        AppMethodBeat.i(3699);
        AppMethodBeat.o(3699);
    }

    static /* synthetic */ String a(VideoCompressUI videoCompressUI, String str, String str2) {
        AppMethodBeat.i(3707);
        String fe = videoCompressUI.fe(str, str2);
        AppMethodBeat.o(3707);
        return fe;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(3700);
        super.onCreate(bundle);
        setContentView(R.layout.f7);
        Intent intent = getIntent();
        if (intent == null || bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
            setResult(0);
            finish();
            AppMethodBeat.o(3700);
            return;
        }
        this.ozv = h.b((Context) this, getString(R.string.un), false, null);
        this.videoPath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
        this.thumbPath = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(3695);
                VideoCompressUI.this.fYK = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
                if (VideoCompressUI.this.fYK == null) {
                    ab.e("MicroMsg.VideoCompressUI", "VideoSendPreprocessTask para is null");
                    VideoCompressUI.this.setResult(0);
                    VideoCompressUI.this.finish();
                    AppMethodBeat.o(3695);
                    return;
                }
                q.ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                com.tencent.mm.sdk.g.d.post(VideoCompressUI.this.ozy, "video_remuxing_if_needed");
                AppMethodBeat.o(3695);
            }
        });
        AppMethodBeat.o(3700);
    }

    private String fe(String str, String str2) {
        Exception e;
        AppMethodBeat.i(3701);
        if (bo.isNullOrNil(str2)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://".concat(String.valueOf(str))));
                com.tencent.mm.compatible.j.a.a j = com.tencent.mm.compatible.j.a.j(this, intent);
                if (!(j == null || j.bitmap == null)) {
                    String str3 = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmpThumb/";
                    if (com.tencent.mm.vfs.e.ct(str3)) {
                        com.tencent.mm.vfs.e.N(str3, true);
                    }
                    com.tencent.mm.vfs.e.tf(str3);
                    str3 = str3 + "video_send_preprocess_thumb_" + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
                    ab.i("MicroMsg.VideoCompressUI", "thumbPath: %s", str3);
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 80, CompressFormat.JPEG, str3, true);
                        str2 = str3;
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str3;
                        ab.printErrStackTrace("MicroMsg.VideoCompressUI", e, "get thumb error: %s", e.getMessage());
                        AppMethodBeat.o(3701);
                        return str2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                ab.printErrStackTrace("MicroMsg.VideoCompressUI", e, "get thumb error: %s", e.getMessage());
                AppMethodBeat.o(3701);
                return str2;
            }
            AppMethodBeat.o(3701);
        } else {
            AppMethodBeat.o(3701);
        }
        return str2;
    }

    public void onDestroy() {
        AppMethodBeat.i(3702);
        super.onDestroy();
        if (this.ext != null) {
            this.ext.release();
        }
        AppMethodBeat.o(3702);
    }

    static /* synthetic */ Point B(int i, int i2, int i3, int i4) {
        int max;
        AppMethodBeat.i(3704);
        if (i > i2 && i3 < i4) {
            max = Math.max(i3, i4);
            i4 = Math.min(i3, i4);
            i3 = max;
        }
        ab.i("MicroMsg.VideoCompressUI", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
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
                    ab.i("MicroMsg.VideoCompressUI", "calc scale, outputsize: %s %s", Integer.valueOf(max), Integer.valueOf(i5));
                    point.x = max;
                    point.y = i5;
                    AppMethodBeat.o(3704);
                    return point;
                }
                ab.i("MicroMsg.VideoCompressUI", "calc scale, double ratio divide by 16");
                max = i / 2;
                i5 = i2 / 2;
                if (max % 2 != 0) {
                    max++;
                }
                if (i5 % 2 != 0) {
                    i5++;
                }
                point = new Point(max, i5);
                AppMethodBeat.o(3704);
                return point;
            }
            ab.i("MicroMsg.VideoCompressUI", "calc scale, same len divide by 16, no need scale");
            AppMethodBeat.o(3704);
            return null;
        }
        ab.i("MicroMsg.VideoCompressUI", "calc scale, small or equal to spec size");
        AppMethodBeat.o(3704);
        return null;
    }

    static /* synthetic */ boolean b(VideoCompressUI videoCompressUI, VideoTransPara videoTransPara) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(3705);
        if (videoTransPara == null) {
            ab.e("MicroMsg.VideoCompressUI", "hy: given target trans param is null");
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
        AppMethodBeat.o(3705);
        return z2;
    }

    static /* synthetic */ String bQo() {
        AppMethodBeat.i(3706);
        String str = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmp/";
        if (com.tencent.mm.vfs.e.ct(str)) {
            com.tencent.mm.vfs.e.N(str, true);
        }
        com.tencent.mm.vfs.e.tf(str);
        ab.i("MicroMsg.VideoCompressUI", "initAndGetTmpPath: %s", str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX);
        AppMethodBeat.o(3706);
        return str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
    }
}
