package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.mmsight.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

@a(3)
public class MMSightEditUI extends MMActivity {
    private d ext = new d(ah.getContext());
    private ViewGroup lYe;
    private String lis;
    private VideoTransPara ouc;
    private VideoPlayerTextureView oxL;
    private VideoSeekBarEditorView oxM;
    private String oxN;
    private b oxO;
    private boolean oxP = false;
    private boolean oxQ = true;
    private boolean oxR = false;
    private e.a oxS = new e.a() {
        public final void onError(int i, int i2) {
            AppMethodBeat.i(54965);
            ab.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", Integer.valueOf(MMSightEditUI.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(54965);
        }

        public final void pL() {
            AppMethodBeat.i(54966);
            if (MMSightEditUI.this.oxL != null) {
                MMSightEditUI.this.oxL.start();
                MMSightEditUI.this.oxL.setLoop(true);
                MMSightEditUI.this.oxL.setAlpha(1.0f);
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(54964);
                        MMSightEditUI.k(MMSightEditUI.this);
                        AppMethodBeat.o(54964);
                    }
                }, 300);
            }
            AppMethodBeat.o(54966);
        }

        public final void EA() {
            AppMethodBeat.i(54967);
            MMSightEditUI.this.oxL.d(0.0d, true);
            AppMethodBeat.o(54967);
        }

        public final int dG(int i, int i2) {
            return 0;
        }

        public final void dH(int i, int i2) {
        }
    };
    private String thumbPath;
    private String videoPath;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMSightEditUI() {
        AppMethodBeat.i(54968);
        AppMethodBeat.o(54968);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(54969);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.iV(true);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            com.tencent.mm.plugin.mmsight.d.iV(false);
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        final long yz = bo.yz();
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54959);
                ab.i("MicroMsg.MMSightEditUI", "connect cost %sms", Long.valueOf(bo.az(yz)));
                if (CaptureMMProxy.getInstance() != null) {
                    q.ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                MMSightEditUI.a(MMSightEditUI.this);
                AppMethodBeat.o(54959);
            }
        });
        AppMethodBeat.o(54969);
    }

    public final int getLayoutId() {
        return R.layout.ah0;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onBackPressed() {
        AppMethodBeat.i(54970);
        if (this.oxO == null || !this.oxO.wY()) {
            super.onBackPressed();
            AppMethodBeat.o(54970);
            return;
        }
        AppMethodBeat.o(54970);
    }

    public void onPause() {
        AppMethodBeat.i(54971);
        super.onPause();
        if (this.oxL != null) {
            this.oxL.pause();
        }
        AppMethodBeat.o(54971);
    }

    public void onResume() {
        AppMethodBeat.i(54972);
        super.onResume();
        if (this.oxL != null) {
            this.oxL.start();
        }
        AppMethodBeat.o(54972);
    }

    public void onDestroy() {
        AppMethodBeat.i(54973);
        super.onDestroy();
        if (this.oxL != null) {
            this.oxL.stop();
        }
        if (this.oxO != null) {
            if (this.oxR) {
                com.tencent.mm.plugin.mmsight.a.a.a(new com.tencent.mm.plugin.mmsight.a.a.a(this.oxO.scene));
            }
            this.oxO.release();
        }
        AppMethodBeat.o(54973);
    }

    static /* synthetic */ void a(MMSightEditUI mMSightEditUI) {
        AppMethodBeat.i(54974);
        if (ak.hw(mMSightEditUI)) {
            mMSightEditUI.dyg();
            mMSightEditUI.Ne(0);
        }
        mMSightEditUI.lYe = (ViewGroup) mMSightEditUI.findViewById(R.id.l_);
        mMSightEditUI.oxL = (VideoPlayerTextureView) mMSightEditUI.findViewById(R.id.dbl);
        mMSightEditUI.oxM = (VideoSeekBarEditorView) mMSightEditUI.findViewById(R.id.a4o);
        mMSightEditUI.oxN = mMSightEditUI.getIntent().getStringExtra("key_text_color");
        mMSightEditUI.oxM.setTextColor(mMSightEditUI.oxN);
        mMSightEditUI.videoPath = mMSightEditUI.getIntent().getStringExtra("key_video_path");
        mMSightEditUI.ouc = (VideoTransPara) mMSightEditUI.getIntent().getParcelableExtra("key_video_para");
        mMSightEditUI.oxP = mMSightEditUI.getIntent().getBooleanExtra("key_need_clip_video_first", false);
        mMSightEditUI.oxQ = mMSightEditUI.getIntent().getBooleanExtra("key_need_remux_video", true);
        int intExtra = mMSightEditUI.getIntent().getIntExtra("key_max_duration_seconds", 0);
        ab.i("MicroMsg.MMSightEditUI", "maxDurationSeconds: %s", Integer.valueOf(intExtra));
        if (!mMSightEditUI.oxQ) {
            mMSightEditUI.oxP = true;
        }
        if (bo.isNullOrNil(mMSightEditUI.videoPath)) {
            ab.e("MicroMsg.MMSightEditUI", "error!, videoPath is null!!");
            AppMethodBeat.o(54974);
            return;
        }
        if (mMSightEditUI.ouc == null) {
            ab.e("MicroMsg.MMSightEditUI", "videoTransPara is null!, use SnsAlbumVideoTransPara");
            mMSightEditUI.ouc = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        }
        if (mMSightEditUI.ouc == null) {
            ab.e("MicroMsg.MMSightEditUI", "videoTransPara still null!!!");
            mMSightEditUI.ouc = new VideoTransPara();
        }
        if (intExtra > 0) {
            mMSightEditUI.ouc.duration = intExtra;
        }
        ab.i("MicroMsg.MMSightEditUI", "videoTransPara: %s", mMSightEditUI.ouc);
        mMSightEditUI.oxL.setAlpha(0.0f);
        mMSightEditUI.oxL.setVideoPath(mMSightEditUI.videoPath);
        mMSightEditUI.oxL.setLoop(true);
        mMSightEditUI.oxL.setForceScaleFullScreen(true);
        mMSightEditUI.oxL.setVideoCallback(mMSightEditUI.oxS);
        mMSightEditUI.lis = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
        mMSightEditUI.thumbPath = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
        if (ak.hw(mMSightEditUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) mMSightEditUI.oxM.getLayoutParams();
            marginLayoutParams.bottomMargin += ak.fr(mMSightEditUI);
            mMSightEditUI.oxM.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(54974);
    }

    static /* synthetic */ void k(MMSightEditUI mMSightEditUI) {
        AppMethodBeat.i(54975);
        mMSightEditUI.oxO = new b();
        mMSightEditUI.oxO.oBN = true;
        mMSightEditUI.oxO.oBR = 2;
        mMSightEditUI.oxO.oBU = mMSightEditUI.oxQ;
        mMSightEditUI.oxO.oBL = new b.a() {
            public final void bQf() {
                AppMethodBeat.i(54961);
                ab.i("MicroMsg.MMSightEditUI", "onEditFinish");
                try {
                    MMSightEditUI.this.oxR = true;
                    long j = (long) MMSightEditUI.this.oxO.oBC;
                    long j2 = (long) MMSightEditUI.this.oxO.oBD;
                    if (MMSightEditUI.this.oxO != null) {
                        MMSightEditUI.this.oxO.n(false, "");
                        MMSightEditUI.this.oxO.release();
                        MMSightEditUI.this.oxO = null;
                    }
                    if (MMSightEditUI.this.oxQ) {
                        Bitmap tv = com.tencent.mm.plugin.mmsight.d.tv(MMSightEditUI.this.lis);
                        if (tv != null) {
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            if (com.tencent.mm.plugin.mmsight.d.a(tv.getWidth(), tv.getHeight(), MMSightEditUI.this.ouc.fAf, pInt, pInt2)) {
                                tv = Bitmap.createScaledBitmap(tv, pInt.value, pInt2.value, true);
                            }
                            ab.i("MicroMsg.MMSightEditUI", "getBitmap size = [%d, %d]", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                            com.tencent.mm.sdk.platformtools.d.a(tv, 80, CompressFormat.JPEG, MMSightEditUI.this.thumbPath, true);
                            Intent intent = new Intent();
                            intent.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.this.lis);
                            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", MMSightEditUI.this.thumbPath);
                            MMSightEditUI.this.setResult(-1, intent);
                            MMSightEditUI.this.finish();
                            AppMethodBeat.o(54961);
                            return;
                        }
                        ab.e("MicroMsg.MMSightEditUI", "getVideoThumb failed!");
                        AppMethodBeat.o(54961);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.this.videoPath);
                    intent2.putExtra("key_seek_look_start_time", j);
                    intent2.putExtra("key_seek_end_time", j2);
                    MMSightEditUI.this.setResult(-1, intent2);
                    MMSightEditUI.this.finish();
                    AppMethodBeat.o(54961);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MMSightEditUI", e, "save video thumb error", new Object[0]);
                    Toast.makeText(MMSightEditUI.this, R.string.d01, 1).show();
                    MMSightEditUI.this.finish();
                    AppMethodBeat.o(54961);
                }
            }

            public final void bQg() {
                AppMethodBeat.i(54962);
                ab.i("MicroMsg.MMSightEditUI", "onExitEdit");
                if (MMSightEditUI.this.oxO != null) {
                    MMSightEditUI.this.oxO.n(true, "");
                    MMSightEditUI.this.oxO.release();
                    MMSightEditUI.this.oxO = null;
                }
                MMSightEditUI.this.finish();
                AppMethodBeat.o(54962);
            }

            public final void onError() {
                AppMethodBeat.i(54963);
                if (MMSightEditUI.this.oxO != null) {
                    MMSightEditUI.this.oxO.release();
                    MMSightEditUI.this.oxO = null;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(54960);
                        Toast.makeText(MMSightEditUI.this, R.string.d01, 1).show();
                        AppMethodBeat.o(54960);
                    }
                });
                AppMethodBeat.o(54963);
            }
        };
        mMSightEditUI.oxO.oBQ = mMSightEditUI.lis;
        mMSightEditUI.oxO.oBT = true;
        mMSightEditUI.oxO.a(mMSightEditUI, 512, mMSightEditUI.videoPath, mMSightEditUI.oxM, mMSightEditUI.oxL, mMSightEditUI.lYe, mMSightEditUI.ouc, mMSightEditUI.oxP);
        AppMethodBeat.o(54975);
    }
}
