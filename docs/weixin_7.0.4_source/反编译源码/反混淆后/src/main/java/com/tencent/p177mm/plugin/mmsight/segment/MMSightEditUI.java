package com.tencent.p177mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.p1490a.C34537a;
import com.tencent.p177mm.plugin.mmsight.p1490a.C34537a.C34538a;
import com.tencent.p177mm.plugin.mmsight.p458ui.C12597b;
import com.tencent.p177mm.plugin.mmsight.p458ui.C12597b.C12615a;
import com.tencent.p177mm.plugin.mmsight.p458ui.VideoSeekBarEditorView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.mmsight.segment.MMSightEditUI */
public class MMSightEditUI extends MMActivity {
    private C46607d ext = new C46607d(C4996ah.getContext());
    private ViewGroup lYe;
    private String lis;
    private VideoTransPara ouc;
    private VideoPlayerTextureView oxL;
    private VideoSeekBarEditorView oxM;
    private String oxN;
    private C12597b oxO;
    private boolean oxP = false;
    private boolean oxQ = true;
    private boolean oxR = false;
    private C14981a oxS = new C393943();
    private String thumbPath;
    private String videoPath;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.MMSightEditUI$2 */
    class C393912 implements C12615a {

        /* renamed from: com.tencent.mm.plugin.mmsight.segment.MMSightEditUI$2$1 */
        class C393921 implements Runnable {
            C393921() {
            }

            public final void run() {
                AppMethodBeat.m2504i(54960);
                Toast.makeText(MMSightEditUI.this, C25738R.string.d01, 1).show();
                AppMethodBeat.m2505o(54960);
            }
        }

        C393912() {
        }

        public final void bQf() {
            AppMethodBeat.m2504i(54961);
            C4990ab.m7416i("MicroMsg.MMSightEditUI", "onEditFinish");
            try {
                MMSightEditUI.this.oxR = true;
                long j = (long) MMSightEditUI.this.oxO.oBC;
                long j2 = (long) MMSightEditUI.this.oxO.oBD;
                if (MMSightEditUI.this.oxO != null) {
                    MMSightEditUI.this.oxO.mo24540n(false, "");
                    MMSightEditUI.this.oxO.release();
                    MMSightEditUI.this.oxO = null;
                }
                if (MMSightEditUI.this.oxQ) {
                    Bitmap tv = C3475d.m5784tv(MMSightEditUI.this.lis);
                    if (tv != null) {
                        PInt pInt = new PInt();
                        PInt pInt2 = new PInt();
                        if (C3475d.m5770a(tv.getWidth(), tv.getHeight(), MMSightEditUI.this.ouc.fAf, pInt, pInt2)) {
                            tv = Bitmap.createScaledBitmap(tv, pInt.value, pInt2.value, true);
                        }
                        C4990ab.m7417i("MicroMsg.MMSightEditUI", "getBitmap size = [%d, %d]", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                        C5056d.m7625a(tv, 80, CompressFormat.JPEG, MMSightEditUI.this.thumbPath, true);
                        Intent intent = new Intent();
                        intent.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.this.lis);
                        intent.putExtra("KSEGMENTVIDEOTHUMBPATH", MMSightEditUI.this.thumbPath);
                        MMSightEditUI.this.setResult(-1, intent);
                        MMSightEditUI.this.finish();
                        AppMethodBeat.m2505o(54961);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.MMSightEditUI", "getVideoThumb failed!");
                    AppMethodBeat.m2505o(54961);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.this.videoPath);
                intent2.putExtra("key_seek_look_start_time", j);
                intent2.putExtra("key_seek_end_time", j2);
                MMSightEditUI.this.setResult(-1, intent2);
                MMSightEditUI.this.finish();
                AppMethodBeat.m2505o(54961);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightEditUI", e, "save video thumb error", new Object[0]);
                Toast.makeText(MMSightEditUI.this, C25738R.string.d01, 1).show();
                MMSightEditUI.this.finish();
                AppMethodBeat.m2505o(54961);
            }
        }

        public final void bQg() {
            AppMethodBeat.m2504i(54962);
            C4990ab.m7416i("MicroMsg.MMSightEditUI", "onExitEdit");
            if (MMSightEditUI.this.oxO != null) {
                MMSightEditUI.this.oxO.mo24540n(true, "");
                MMSightEditUI.this.oxO.release();
                MMSightEditUI.this.oxO = null;
            }
            MMSightEditUI.this.finish();
            AppMethodBeat.m2505o(54962);
        }

        public final void onError() {
            AppMethodBeat.m2504i(54963);
            if (MMSightEditUI.this.oxO != null) {
                MMSightEditUI.this.oxO.release();
                MMSightEditUI.this.oxO = null;
            }
            C5004al.m7441d(new C393921());
            AppMethodBeat.m2505o(54963);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.MMSightEditUI$3 */
    class C393943 implements C14981a {

        /* renamed from: com.tencent.mm.plugin.mmsight.segment.MMSightEditUI$3$1 */
        class C393951 implements Runnable {
            C393951() {
            }

            public final void run() {
                AppMethodBeat.m2504i(54964);
                MMSightEditUI.m67232k(MMSightEditUI.this);
                AppMethodBeat.m2505o(54964);
            }
        }

        C393943() {
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(54965);
            C4990ab.m7413e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", Integer.valueOf(MMSightEditUI.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(54965);
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(54966);
            if (MMSightEditUI.this.oxL != null) {
                MMSightEditUI.this.oxL.start();
                MMSightEditUI.this.oxL.setLoop(true);
                MMSightEditUI.this.oxL.setAlpha(1.0f);
                C5004al.m7442n(new C393951(), 300);
            }
            AppMethodBeat.m2505o(54966);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(54967);
            MMSightEditUI.this.oxL.mo27356d(0.0d, true);
            AppMethodBeat.m2505o(54967);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MMSightEditUI() {
        AppMethodBeat.m2504i(54968);
        AppMethodBeat.m2505o(54968);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(54969);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        if (C1443d.m3068iW(19)) {
            getWindow().setFlags(201327616, 201327616);
            C3475d.m5783iV(true);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            C3475d.m5783iV(false);
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        final long yz = C5046bo.m7588yz();
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(54959);
                C4990ab.m7417i("MicroMsg.MMSightEditUI", "connect cost %sms", Long.valueOf(C5046bo.m7525az(yz)));
                if (CaptureMMProxy.getInstance() != null) {
                    C1427q.m3050ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                MMSightEditUI.m67222a(MMSightEditUI.this);
                AppMethodBeat.m2505o(54959);
            }
        });
        AppMethodBeat.m2505o(54969);
    }

    public final int getLayoutId() {
        return 2130970234;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(54970);
        if (this.oxO == null || !this.oxO.mo24542wY()) {
            super.onBackPressed();
            AppMethodBeat.m2505o(54970);
            return;
        }
        AppMethodBeat.m2505o(54970);
    }

    public void onPause() {
        AppMethodBeat.m2504i(54971);
        super.onPause();
        if (this.oxL != null) {
            this.oxL.pause();
        }
        AppMethodBeat.m2505o(54971);
    }

    public void onResume() {
        AppMethodBeat.m2504i(54972);
        super.onResume();
        if (this.oxL != null) {
            this.oxL.start();
        }
        AppMethodBeat.m2505o(54972);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54973);
        super.onDestroy();
        if (this.oxL != null) {
            this.oxL.stop();
        }
        if (this.oxO != null) {
            if (this.oxR) {
                C34537a.m56629a(new C34538a(this.oxO.scene));
            }
            this.oxO.release();
        }
        AppMethodBeat.m2505o(54973);
    }

    /* renamed from: a */
    static /* synthetic */ void m67222a(MMSightEditUI mMSightEditUI) {
        AppMethodBeat.m2504i(54974);
        if (C5230ak.m7991hw(mMSightEditUI)) {
            mMSightEditUI.dyg();
            mMSightEditUI.mo17375Ne(0);
        }
        mMSightEditUI.lYe = (ViewGroup) mMSightEditUI.findViewById(2131820987);
        mMSightEditUI.oxL = (VideoPlayerTextureView) mMSightEditUI.findViewById(2131826115);
        mMSightEditUI.oxM = (VideoSeekBarEditorView) mMSightEditUI.findViewById(2131821717);
        mMSightEditUI.oxN = mMSightEditUI.getIntent().getStringExtra("key_text_color");
        mMSightEditUI.oxM.setTextColor(mMSightEditUI.oxN);
        mMSightEditUI.videoPath = mMSightEditUI.getIntent().getStringExtra("key_video_path");
        mMSightEditUI.ouc = (VideoTransPara) mMSightEditUI.getIntent().getParcelableExtra("key_video_para");
        mMSightEditUI.oxP = mMSightEditUI.getIntent().getBooleanExtra("key_need_clip_video_first", false);
        mMSightEditUI.oxQ = mMSightEditUI.getIntent().getBooleanExtra("key_need_remux_video", true);
        int intExtra = mMSightEditUI.getIntent().getIntExtra("key_max_duration_seconds", 0);
        C4990ab.m7417i("MicroMsg.MMSightEditUI", "maxDurationSeconds: %s", Integer.valueOf(intExtra));
        if (!mMSightEditUI.oxQ) {
            mMSightEditUI.oxP = true;
        }
        if (C5046bo.isNullOrNil(mMSightEditUI.videoPath)) {
            C4990ab.m7412e("MicroMsg.MMSightEditUI", "error!, videoPath is null!!");
            AppMethodBeat.m2505o(54974);
            return;
        }
        if (mMSightEditUI.ouc == null) {
            C4990ab.m7412e("MicroMsg.MMSightEditUI", "videoTransPara is null!, use SnsAlbumVideoTransPara");
            mMSightEditUI.ouc = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        }
        if (mMSightEditUI.ouc == null) {
            C4990ab.m7412e("MicroMsg.MMSightEditUI", "videoTransPara still null!!!");
            mMSightEditUI.ouc = new VideoTransPara();
        }
        if (intExtra > 0) {
            mMSightEditUI.ouc.duration = intExtra;
        }
        C4990ab.m7417i("MicroMsg.MMSightEditUI", "videoTransPara: %s", mMSightEditUI.ouc);
        mMSightEditUI.oxL.setAlpha(0.0f);
        mMSightEditUI.oxL.setVideoPath(mMSightEditUI.videoPath);
        mMSightEditUI.oxL.setLoop(true);
        mMSightEditUI.oxL.setForceScaleFullScreen(true);
        mMSightEditUI.oxL.setVideoCallback(mMSightEditUI.oxS);
        mMSightEditUI.lis = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
        mMSightEditUI.thumbPath = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
        if (C5230ak.m7991hw(mMSightEditUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) mMSightEditUI.oxM.getLayoutParams();
            marginLayoutParams.bottomMargin += C5230ak.m7988fr(mMSightEditUI);
            mMSightEditUI.oxM.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.m2505o(54974);
    }

    /* renamed from: k */
    static /* synthetic */ void m67232k(MMSightEditUI mMSightEditUI) {
        AppMethodBeat.m2504i(54975);
        mMSightEditUI.oxO = new C12597b();
        mMSightEditUI.oxO.oBN = true;
        mMSightEditUI.oxO.oBR = 2;
        mMSightEditUI.oxO.oBU = mMSightEditUI.oxQ;
        mMSightEditUI.oxO.oBL = new C393912();
        mMSightEditUI.oxO.oBQ = mMSightEditUI.lis;
        mMSightEditUI.oxO.oBT = true;
        mMSightEditUI.oxO.mo24539a(mMSightEditUI, 512, mMSightEditUI.videoPath, mMSightEditUI.oxM, mMSightEditUI.oxL, mMSightEditUI.lYe, mMSightEditUI.ouc, mMSightEditUI.oxP);
        AppMethodBeat.m2505o(54975);
    }
}
