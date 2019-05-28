package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42008in;
import com.tencent.p177mm.p230g.p231a.C42026mj;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMNewPhotoEditUI;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.plugin.mmsight.model.C12558a;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.model.C21302c;
import com.tencent.p177mm.plugin.mmsight.model.C21302c.C21303a;
import com.tencent.p177mm.plugin.mmsight.model.C34549k;
import com.tencent.p177mm.plugin.mmsight.model.C39385e;
import com.tencent.p177mm.plugin.mmsight.model.C39385e.C34548b;
import com.tencent.p177mm.plugin.mmsight.model.C39385e.C39384a;
import com.tencent.p177mm.plugin.mmsight.model.C46078i;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C12543a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C34543c;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43306k;
import com.tencent.p177mm.plugin.mmsight.p1490a.C34537a;
import com.tencent.p177mm.plugin.mmsight.p1490a.C34537a.C34538a;
import com.tencent.p177mm.plugin.mmsight.p458ui.C12597b.C12615a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCaptureTouchView.C43316a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCircularProgressBar.C3497a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C12584d;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C39408a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C39409b;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C39410c;
import com.tencent.p177mm.plugin.mmsight.p458ui.cameraglview.C21318a;
import com.tencent.p177mm.plugin.mmsight.p458ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.video.C35339b;
import com.tencent.p177mm.plugin.video.ObservableTextureView;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.view.C31128d;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI */
public class SightCaptureUI extends MMActivity implements C12543a, C21303a {
    private String cMW = "";
    private C46607d ext = new C46607d(C4996ah.getContext());
    private VideoTransPara fcY;
    private ObservableTextureView gLR;
    private C43304d gLs;
    private C45293b gar;
    private int hGH = -1;
    private boolean hGI = false;
    private long hGJ = -1;
    private MMSightCaptureTouchView lmm;
    private View nPr;
    private TextView oCA;
    private View oCB;
    private C12597b oCC;
    private boolean oCD = true;
    private baa oCE = new baa();
    private byte[] oCF;
    private int oCG;
    private int oCH;
    private int oCI;
    private int oCJ;
    private byte[] oCK;
    private int oCL;
    private C21302c oCM;
    private boolean oCN = false;
    private boolean oCO = false;
    private boolean oCP = false;
    private int oCQ = 0;
    private int oCR = 0;
    private Thread oCS = null;
    private long oCT = -1;
    private boolean oCU = false;
    private boolean oCV = false;
    private Boolean oCW = Boolean.FALSE;
    private Point oCX;
    private C4884c oCY = new C1683012();
    private Runnable oCZ = new C1258918();
    private int oCj = 1;
    private boolean oCk = true;
    private C39385e oCl;
    private ViewGroup oCm;
    private MMSightRecordButton oCn;
    private View oCo;
    private View oCp;
    private ViewGroup oCq;
    private ViewGroup oCr;
    private ImageView oCs;
    private ImageView oCt;
    private SurfaceTexture oCu;
    CameraFrontSightView oCv;
    private ViewGroup oCw;
    private ImageView oCx;
    private MMSightCameraGLSurfaceView oCy;
    private C21318a oCz;
    private String oDa;
    private String oDb;
    private boolean oDc;
    private Bundle oDd;
    private Runnable oDe = new C1681619();
    private int osJ = 2;
    private SightParams owm;
    private VideoPlayerTextureView oxL;
    private VideoSeekBarEditorView oxM;
    private C14981a oxS = new C1680820();

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$15 */
    class C1258515 implements C12615a {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$15$1 */
        class C125861 implements Runnable {
            C125861() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55202);
                SightCaptureUI.m25906V(SightCaptureUI.this);
                AppMethodBeat.m2505o(55202);
            }
        }

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$15$2 */
        class C125872 implements Runnable {
            C125872() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55203);
                Toast.makeText(SightCaptureUI.this, C25738R.string.d01, 1).show();
                SightCaptureUI.this.mo17375Ne(8);
                SightCaptureUI.this.oCo.setVisibility(0);
                SightCaptureUI.this.nPr.setVisibility(0);
                SightCaptureUI.this.oCt.setVisibility(0);
                AppMethodBeat.m2505o(55203);
            }
        }

        C1258515() {
        }

        public final void bQf() {
            AppMethodBeat.m2504i(55204);
            C4990ab.m7416i("MicroMsg.SightCaptureUI", "on video edit finish");
            if (SightCaptureUI.this.oCC != null) {
                SightCaptureUI.this.cMW = C5046bo.m7532bc(SightCaptureUI.this.oCC.cvZ, "");
                SightCaptureUI.this.oCC.mo24540n(false, SightCaptureUI.this.owm.osR);
                SightCaptureUI.this.oCC.release();
                SightCaptureUI.this.oCC = null;
            }
            SightCaptureUI.this.oCo.setVisibility(0);
            SightCaptureUI.this.nPr.setVisibility(0);
            SightCaptureUI.this.oCt.setVisibility(0);
            SightCaptureUI.this.oxL.stop();
            SightCaptureUI.this.oxL.setVideoPath(SightCaptureUI.this.gLs.getFilePath());
            SightCaptureUI.this.oxL.setLoop(true);
            SightCaptureUI.this.oxL.setForceScaleFullScreen(true);
            SightCaptureUI.this.oxL.setVideoCallback(SightCaptureUI.this.oxS);
            SightCaptureUI.this.mo17375Ne(8);
            C7305d.post(new C125861(), "SightCaptureUI_edit_finish_save_new_thumb");
            SightCaptureUI.this.oCU = true;
            AppMethodBeat.m2505o(55204);
        }

        public final void bQg() {
            AppMethodBeat.m2504i(55205);
            C4990ab.m7416i("MicroMsg.SightCaptureUI", "on video edit exit");
            if (SightCaptureUI.this.oCC != null) {
                SightCaptureUI.this.oCC.mo24540n(true, SightCaptureUI.this.owm.osR);
                SightCaptureUI.this.oCC.release();
                SightCaptureUI.this.oCC = null;
            }
            SightCaptureUI.this.mo17375Ne(8);
            SightCaptureUI.this.oCo.setVisibility(0);
            SightCaptureUI.this.nPr.setVisibility(0);
            SightCaptureUI.this.oCt.setVisibility(0);
            AppMethodBeat.m2505o(55205);
        }

        public final void onError() {
            AppMethodBeat.m2504i(55206);
            C4990ab.m7416i("MicroMsg.SightCaptureUI", "on video edit error");
            if (SightCaptureUI.this.oCC != null) {
                SightCaptureUI.this.oCC.release();
                SightCaptureUI.this.oCC = null;
            }
            C5004al.m7441d(new C125872());
            AppMethodBeat.m2505o(55206);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$17 */
    class C1258817 extends AnimatorListenerAdapter {
        C1258817() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(55209);
            SightCaptureUI.this.nPr.setEnabled(true);
            AppMethodBeat.m2505o(55209);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(55210);
            SightCaptureUI.this.nPr.setEnabled(false);
            AppMethodBeat.m2505o(55210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$18 */
    class C1258918 implements Runnable {
        C1258918() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55211);
            if (SightCaptureUI.this.hGH == 7 && SightCaptureUI.this.oCn != null) {
                C4990ab.m7416i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
                SightCaptureUI.this.oCn.bQs();
            }
            AppMethodBeat.m2505o(55211);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$20 */
    class C1680820 implements C14981a {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$20$1 */
        class C34981 implements C14980e {

            /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$20$1$1 */
            class C34991 implements Runnable {
                C34991() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(55213);
                    C4990ab.m7416i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                    if (SightCaptureUI.this.oxL == null) {
                        AppMethodBeat.m2505o(55213);
                        return;
                    }
                    SightCaptureUI.this.oxL.setAlpha(1.0f);
                    SightCaptureUI.m25928g(SightCaptureUI.this, 4);
                    SightCaptureUI.m25891G(SightCaptureUI.this);
                    AppMethodBeat.m2505o(55213);
                }
            }

            C34981() {
            }

            public final void bQL() {
                AppMethodBeat.m2504i(55214);
                C5004al.m7442n(new C34991(), 50);
                SightCaptureUI.this.oCt.setVisibility(0);
                AppMethodBeat.m2505o(55214);
            }
        }

        C1680820() {
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(55215);
            C4990ab.m7413e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(55215);
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(55216);
            if (SightCaptureUI.this.oxL != null) {
                SightCaptureUI.this.oxL.start();
                SightCaptureUI.this.oxL.setLoop(true);
            }
            C5004al.m7439af(SightCaptureUI.this.oDe);
            SightCaptureUI.this.oxL.setOneTimeVideoTextureUpdateCallback(new C34981());
            AppMethodBeat.m2505o(55216);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(55217);
            SightCaptureUI.this.oxL.mo27356d(0.0d, true);
            AppMethodBeat.m2505o(55217);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$22 */
    class C1680922 implements OnClickListener {
        C1680922() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55219);
            if (SightCaptureUI.this.hGH == 3) {
                SightCaptureUI.m25929h(SightCaptureUI.this);
                AppMethodBeat.m2505o(55219);
                return;
            }
            if (SightCaptureUI.this.hGH == 4) {
                SightCaptureUI.m25930i(SightCaptureUI.this);
            }
            AppMethodBeat.m2505o(55219);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$23 */
    class C1681023 implements C39409b {
        C1681023() {
        }

        public final void bnV() {
            AppMethodBeat.m2504i(55220);
            C4990ab.m7417i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", Integer.valueOf(SightCaptureUI.this.hGH));
            if (SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null || !SightCaptureUI.this.oCl.bPu()) {
                AppMethodBeat.m2505o(55220);
                return;
            }
            int[] iArr = new int[2];
            SightCaptureUI.this.oCn.getLocationOnScreen(iArr);
            SightCaptureUI.this.oCl.mo62301kj(iArr[1]);
            if (SightCaptureUI.this.oCj == 0) {
                SightCaptureUI.this.oCR = SightCaptureUI.m25936m(SightCaptureUI.this);
            }
            AppMethodBeat.m2505o(55220);
        }

        /* renamed from: if */
        public final void mo30800if() {
            AppMethodBeat.m2504i(55221);
            if (SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null || !SightCaptureUI.this.oCl.bPu()) {
                AppMethodBeat.m2505o(55221);
                return;
            }
            SightCaptureUI.m25937n(SightCaptureUI.this);
            C4990ab.m7417i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", C5046bo.dpG().toString());
            SightCaptureUI.m25938o(SightCaptureUI.this);
            AppMethodBeat.m2505o(55221);
        }

        public final void bnU() {
            AppMethodBeat.m2504i(55222);
            String str = "MicroMsg.TestCaptureUiEvent";
            String str2 = "onLongPressFinish %s, recorder: %s, recordTime: %s";
            Object[] objArr = new Object[3];
            objArr[0] = C5046bo.dpG().toString();
            objArr[1] = SightCaptureUI.this.gLs;
            objArr[2] = Long.valueOf(SightCaptureUI.this.gLs != null ? SightCaptureUI.this.gLs.mo14837WK() : 0);
            C4990ab.m7417i(str, str2, objArr);
            if (SightCaptureUI.this.oCj == 0) {
                if (SightCaptureUI.this.gLs == null || SightCaptureUI.this.gLs.mo14837WK() > 1000 || SightCaptureUI.this.gLs.mo14838WL() != C34543c.Start) {
                    SightCaptureUI.m25941r(SightCaptureUI.this);
                    AppMethodBeat.m2505o(55222);
                    return;
                }
                C4990ab.m7416i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
                SightCaptureUI.this.gLs.cancel();
                if (SightCaptureUI.this.oCj == 0) {
                    SightCaptureUI.m25940q(SightCaptureUI.this);
                    AppMethodBeat.m2505o(55222);
                    return;
                }
            } else if (SightCaptureUI.this.oCj == 1) {
                if ((SightCaptureUI.this.gLs == null || SightCaptureUI.this.gLs.mo14837WK() > 1000) && SightCaptureUI.this.gLs != null) {
                    SightCaptureUI.m25941r(SightCaptureUI.this);
                } else {
                    C4990ab.m7416i("MicroMsg.SightCaptureUI", "video record too short");
                    Toast.makeText(SightCaptureUI.this, C25738R.string.d00, 1).show();
                    SightCaptureUI.m25942s(SightCaptureUI.this);
                    AppMethodBeat.m2505o(55222);
                    return;
                }
            }
            AppMethodBeat.m2505o(55222);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$3 */
    class C168113 implements OnClickListener {
        C168113() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55182);
            if (SightCaptureUI.this.gar != null) {
                SightCaptureUI.this.gar.mo73178Mm();
            }
            SightCaptureUI.m25942s(SightCaptureUI.this);
            SightCaptureUI.m25913a(SightCaptureUI.this, true);
            AppMethodBeat.m2505o(55182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$4 */
    class C168124 implements OnClickListener {
        C168124() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55183);
            if (SightCaptureUI.m25946w(SightCaptureUI.this)) {
                SightCaptureUI.this.finish();
                SightCaptureUI.this.overridePendingTransition(-1, C25738R.anim.f8399d_);
                AppMethodBeat.m2505o(55183);
                return;
            }
            AppMethodBeat.m2505o(55183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$16 */
    class C1681516 extends AnimatorListenerAdapter {
        C1681516() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(55207);
            SightCaptureUI.this.oCo.setEnabled(true);
            AppMethodBeat.m2505o(55207);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(55208);
            SightCaptureUI.this.oCo.setEnabled(false);
            AppMethodBeat.m2505o(55208);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$19 */
    class C1681619 implements Runnable {
        C1681619() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55212);
            if (SightCaptureUI.this.hGH != 4) {
                C4990ab.m7412e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
                SightCaptureUI.m25928g(SightCaptureUI.this, 9);
            }
            AppMethodBeat.m2505o(55212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$21 */
    class C1681821 implements C35339b {
        C1681821() {
        }

        /* renamed from: e */
        public final void mo30809e(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(55218);
            SightCaptureUI.this.oCz.mo36738WB();
            SightCaptureUI.this.gLR.setTextureChangeCallback(null);
            AppMethodBeat.m2505o(55218);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$2 */
    class C168192 implements OnClickListener {
        C168192() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55181);
            if (SightCaptureUI.this.hGH == 4) {
                SightCaptureUI.m25943t(SightCaptureUI.this);
                AppMethodBeat.m2505o(55181);
                return;
            }
            if (SightCaptureUI.this.hGH == 3) {
                SightCaptureUI.m25944u(SightCaptureUI.this);
                SightCaptureUI.m25913a(SightCaptureUI.this, false);
            }
            AppMethodBeat.m2505o(55181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$11 */
    class C1682111 implements Runnable {
        C1682111() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55197);
            String RK = C3475d.m5763RK(SightCaptureUI.this.gLs.getFilePath());
            if (C5046bo.isNullOrNil(RK)) {
                AppMethodBeat.m2505o(55197);
                return;
            }
            RK = ((RK + IOUtils.LINE_SEPARATOR_UNIX + String.format("FPS: %s", new Object[]{Float.valueOf(SightCaptureUI.this.gLs.mo14836WJ())})) + IOUtils.LINE_SEPARATOR_UNIX + String.format("TIME_RECODER_2_PLAY: %s", new Object[]{Long.valueOf(C3475d.m5766RN("TIME_RECODER_2_PLAY"))})) + IOUtils.LINE_SEPARATOR_UNIX + String.format("CPU: cur %s max:%s", new Object[]{C45290m.m83512Lz(), C45290m.m83510Lx()});
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(55196);
                    C4990ab.m7417i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", RK);
                    C43306k.bPR();
                    if (C43306k.isDebug()) {
                        TextView textView = (TextView) SightCaptureUI.this.findViewById(2131821713);
                        textView.setVisibility(0);
                        textView.setText(RK);
                        AppMethodBeat.m2505o(55196);
                        return;
                    }
                    AppMethodBeat.m2505o(55196);
                }
            });
            AppMethodBeat.m2505o(55197);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$26 */
    class C1682326 implements C12584d {
        C1682326() {
        }

        public final void bnX() {
            AppMethodBeat.m2504i(55226);
            C4990ab.m7419v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", C5046bo.dpG().toString());
            if (SightCaptureUI.this.gLs != null) {
                C4990ab.m7417i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", SightCaptureUI.this.gLs.mo14838WL());
                SightCaptureUI.this.gLs.cancel();
            }
            C3475d.m5765RM("TIME_RECODER_2_PLAY");
            SightCaptureUI.m25940q(SightCaptureUI.this);
            AppMethodBeat.m2505o(55226);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$27 */
    class C1682427 implements OnClickListener {
        C1682427() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55227);
            if (SightCaptureUI.this.oCl != null) {
                SightCaptureUI.m25922d(SightCaptureUI.this);
            }
            AppMethodBeat.m2505o(55227);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$7 */
    class C168257 extends AnimatorListenerAdapter {
        C168257() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(55191);
            SightCaptureUI.this.oCA.setVisibility(8);
            AppMethodBeat.m2505o(55191);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$8 */
    class C168268 implements C35339b {
        C168268() {
        }

        /* renamed from: e */
        public final void mo30809e(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(55192);
            C4990ab.m7417i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", surfaceTexture);
            SightCaptureUI.this.oCu = surfaceTexture;
            if (SightCaptureUI.m25894J(SightCaptureUI.this)) {
                SightCaptureUI.m25928g(SightCaptureUI.this, 1);
                AppMethodBeat.m2505o(55192);
                return;
            }
            SightCaptureUI.m25928g(SightCaptureUI.this, 8);
            AppMethodBeat.m2505o(55192);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$9 */
    class C168279 implements C3497a {
        C168279() {
        }

        public final void bnW() {
            AppMethodBeat.m2504i(55193);
            SightCaptureUI.m25941r(SightCaptureUI.this);
            AppMethodBeat.m2505o(55193);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$24 */
    class C1682824 implements C39408a {
        C1682824() {
        }

        public final void bQu() {
            AppMethodBeat.m2504i(55223);
            C4990ab.m7417i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", C5046bo.dpG().toString());
            if (SightCaptureUI.this.gLs != null) {
                SightCaptureUI.this.gLs.cancel();
                if (SightCaptureUI.this.oCj == 0) {
                    SightCaptureUI.m25940q(SightCaptureUI.this);
                }
            }
            AppMethodBeat.m2505o(55223);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$5 */
    class C168295 implements C43316a {
        C168295() {
        }

        /* renamed from: P */
        public final void mo30817P(float f, float f2) {
            AppMethodBeat.m2504i(55184);
            if (!(SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.hGH == 3 || SightCaptureUI.this.hGH == 4 || SightCaptureUI.this.oCy == null)) {
                SightCaptureUI.this.oCl.mo62284b(f, f2, SightCaptureUI.this.oCy.getWidth(), SightCaptureUI.this.oCy.getHeight());
                SightCaptureUI sightCaptureUI = SightCaptureUI.this;
                if (sightCaptureUI.oCv != null) {
                    LayoutParams layoutParams = (LayoutParams) sightCaptureUI.oCv.getLayoutParams();
                    layoutParams.leftMargin = ((int) f) - (sightCaptureUI.oCv.mWidth / 2);
                    layoutParams.topMargin = ((int) f2) - (sightCaptureUI.oCv.mHeight / 2);
                    sightCaptureUI.oCv.setLayoutParams(layoutParams);
                    sightCaptureUI.oCv.bQr();
                }
            }
            AppMethodBeat.m2505o(55184);
        }

        public final void bnY() {
            AppMethodBeat.m2504i(55185);
            if (SightCaptureUI.this.hGH != 0 && SightCaptureUI.this.oCQ > 1) {
                SightCaptureUI.this.oCl.oug.removeMessages(4354);
                SightCaptureUI.m25922d(SightCaptureUI.this);
            }
            AppMethodBeat.m2505o(55185);
        }

        public final void asx() {
            AppMethodBeat.m2504i(55186);
            if (!(SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null)) {
                SightCaptureUI.this.oCl.mo62296d(true, false, 1);
            }
            AppMethodBeat.m2505o(55186);
        }

        public final void asy() {
            AppMethodBeat.m2504i(55187);
            if (!(SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null)) {
                SightCaptureUI.this.oCl.mo62296d(false, false, 1);
            }
            AppMethodBeat.m2505o(55187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$12 */
    class C1683012 extends C4884c<C42008in> {
        C1683012() {
            AppMethodBeat.m2504i(55198);
            this.xxI = C42008in.class.getName().hashCode();
            AppMethodBeat.m2505o(55198);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55199);
            C42008in c42008in = (C42008in) c4883b;
            if (!(c42008in == null || c42008in.cDG == null)) {
                C4990ab.m7417i("MicroMsg.SightCaptureUI", "summerhardcoder system event [%s] backCamera[%s]", Integer.valueOf(c42008in.cDG.keycode), Boolean.valueOf(SightCaptureUI.this.oCD));
                if (c42008in.cDG.keycode == 1 && SightCaptureUI.this.oCD) {
                    SightCaptureUI.m25922d(SightCaptureUI.this);
                }
            }
            AppMethodBeat.m2505o(55199);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$14 */
    class C1683114 implements Runnable {
        C1683114() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55201);
            SightCaptureUI.m25899O(SightCaptureUI.this);
            AppMethodBeat.m2505o(55201);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$25 */
    class C1683225 implements C39410c {
        C1683225() {
        }

        /* renamed from: uF */
        public final void mo30822uF(int i) {
            AppMethodBeat.m2504i(55224);
            if (SightCaptureUI.this.oCl != null) {
                SightCaptureUI.this.oCl.mo62296d(true, true, i);
            }
            AppMethodBeat.m2505o(55224);
        }

        /* renamed from: uG */
        public final void mo30823uG(int i) {
            AppMethodBeat.m2504i(55225);
            if (SightCaptureUI.this.oCl != null) {
                SightCaptureUI.this.oCl.mo62296d(false, true, i);
            }
            AppMethodBeat.m2505o(55225);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$6 */
    class C168336 implements C34548b {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$6$2 */
        class C168342 implements Runnable {
            C168342() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55189);
                SightCaptureUI.m25891G(SightCaptureUI.this);
                AppMethodBeat.m2505o(55189);
            }
        }

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$6$1 */
        class C168351 implements Runnable {
            C168351() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55188);
                SightCaptureUI.m25888D(SightCaptureUI.this);
                AppMethodBeat.m2505o(55188);
            }
        }

        C168336() {
        }

        /* renamed from: a */
        public final void mo30824a(byte[] bArr, int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(55190);
            if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
                C4990ab.m7412e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!!");
                SightCaptureUI.this.hGI = false;
                AppMethodBeat.m2505o(55190);
                return;
            }
            int i5;
            C4990ab.m7417i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            SightCaptureUI.m25885A(SightCaptureUI.this);
            SightCaptureUI.m25886B(SightCaptureUI.this);
            SightCaptureUI.this.oCG = i;
            SightCaptureUI.this.oCH = i2;
            SightCaptureUI.this.oCI = i3;
            SightCaptureUI.this.oCJ = i4;
            if (SightCaptureUI.this.oCF != null) {
                C43305j.owk.mo68845g(SightCaptureUI.this.oCF);
                SightCaptureUI.this.oCF = null;
            }
            SightCaptureUI.this.oCF = C43305j.owk.mo68846g(Integer.valueOf(bArr.length));
            System.arraycopy(bArr, 0, SightCaptureUI.this.oCF, 0, bArr.length);
            SightCaptureUI.this.oCS = C7305d.m12301h(new C168351(), "SightCaptureUI_saveCaptureBitmap");
            SightCaptureUI.this.oCS.start();
            C34549k.m56643d(true, C3475d.m5766RN("TIME_RECODER_2_PLAY"));
            if (SightCaptureUI.this.oCP) {
                if (Math.abs(i3 - i4) == 0) {
                    i5 = 180;
                } else {
                    i5 = 0;
                }
                bArr = C3475d.m5776c(bArr, i, i2, i5 % v2helper.VOIP_ENC_HEIGHT_LV1);
                SightCaptureUI.this.oCz.mo36739a(bArr, true, 0);
            } else {
                if (i4 == 180) {
                    i5 = i3 + i4;
                } else {
                    i5 = i3;
                }
                if (i5 > v2helper.VOIP_ENC_HEIGHT_LV1) {
                    i5 -= 360;
                }
                SightCaptureUI.this.oCz.mo36739a(bArr, false, i5);
            }
            SightCaptureUI.this.oCK = bArr;
            SightCaptureUI.this.oCL = i5;
            SightCaptureUI.m25928g(SightCaptureUI.this, 3);
            SightCaptureUI.this.oCo.post(new C168342());
            if (SightCaptureUI.this.owm.scene == 1 || SightCaptureUI.this.owm.scene == 2 || SightCaptureUI.this.owm.scene == 7) {
                C7060h.pYm.mo8381e(13819, Integer.valueOf(1), Integer.valueOf(SightCaptureUI.this.owm.scene), SightCaptureUI.this.owm.osR, Long.valueOf(C5046bo.anT()));
            }
            AppMethodBeat.m2505o(55190);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SightCaptureUI() {
        AppMethodBeat.m2504i(55228);
        AppMethodBeat.m2505o(55228);
    }

    /* renamed from: B */
    static /* synthetic */ void m25886B(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55269);
        sightCaptureUI.bQI();
        AppMethodBeat.m2505o(55269);
    }

    /* renamed from: J */
    static /* synthetic */ boolean m25894J(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55273);
        boolean jb = sightCaptureUI.m25932jb(false);
        AppMethodBeat.m2505o(55273);
        return jb;
    }

    /* renamed from: d */
    static /* synthetic */ void m25922d(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55255);
        sightCaptureUI.bQA();
        AppMethodBeat.m2505o(55255);
    }

    /* renamed from: g */
    static /* synthetic */ void m25928g(SightCaptureUI sightCaptureUI, int i) {
        AppMethodBeat.m2504i(55271);
        sightCaptureUI.updateState(i);
        AppMethodBeat.m2505o(55271);
    }

    /* renamed from: m */
    static /* synthetic */ int m25936m(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55258);
        int bQD = sightCaptureUI.bQD();
        AppMethodBeat.m2505o(55258);
        return bQD;
    }

    /* renamed from: r */
    static /* synthetic */ void m25941r(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55262);
        sightCaptureUI.stopRecord();
        AppMethodBeat.m2505o(55262);
    }

    /* renamed from: s */
    static /* synthetic */ void m25942s(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55263);
        sightCaptureUI.bQC();
        AppMethodBeat.m2505o(55263);
    }

    /* renamed from: w */
    static /* synthetic */ boolean m25946w(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55267);
        boolean bQK = sightCaptureUI.bQK();
        AppMethodBeat.m2505o(55267);
        return bQK;
    }

    /* renamed from: zb */
    static /* synthetic */ String m25951zb(int i) {
        AppMethodBeat.m2504i(55274);
        String za = SightCaptureUI.m25950za(i);
        AppMethodBeat.m2505o(55274);
        return za;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55229);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        this.owm = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.owm == null) {
            C4990ab.m7412e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            AppMethodBeat.m2505o(55229);
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        final long yz = C5046bo.m7588yz();
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(55180);
                C4990ab.m7417i("MicroMsg.SightCaptureUI", "connect cost %sms", Long.valueOf(C5046bo.m7525az(yz)));
                C12563j.m20499c(SightCaptureUI.this.owm.fcY);
                SightCaptureUI.m25917b(SightCaptureUI.this);
                AppMethodBeat.m2505o(55180);
            }
        });
        C4879a.xxA.mo10052c(this.oCY);
        AppMethodBeat.m2505o(55229);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(55230);
        if (C1427q.etc.eqV == 1 && i == 700 && this.oCD) {
            bQA();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(55230);
        return onKeyDown;
    }

    public void onPause() {
        AppMethodBeat.m2504i(55231);
        super.onPause();
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", SightCaptureUI.m25950za(this.hGH));
        if (this.hGH == 2) {
            stopRecord();
        } else if (this.hGH == 1) {
            bQI();
        } else if (this.hGH == 4 && this.oxL != null) {
            this.oxL.pause();
        }
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(55231);
    }

    public void onResume() {
        boolean z = false;
        AppMethodBeat.m2504i(55232);
        super.onResume();
        mo17375Ne(8);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "onResume, currentState: %s, textureview available: %s";
        Object[] objArr = new Object[2];
        objArr[0] = SightCaptureUI.m25950za(this.hGH);
        if (this.gLR != null && this.gLR.isAvailable()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (this.hGH == 2 || this.hGH == 1) {
            bQC();
        } else if (this.hGH == 4) {
            if (this.gLR != null) {
                if (this.gLR.isAvailable()) {
                    this.oCz.mo36738WB();
                } else {
                    this.gLR.setTextureChangeCallback(new C1681821());
                }
            }
            if (this.oxL != null) {
                this.oxL.start();
            }
        } else if (this.hGH == 3) {
            if (this.gLR != null) {
                this.gLR.setTextureChangeCallback(null);
            }
            this.oCz.mo36739a(this.oCK, this.oCP, this.oCL);
        }
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(55232);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(55233);
        super.onConfigurationChanged(configuration);
        if (this.oCW.booleanValue() && C1443d.m3068iW(13)) {
            Point point = new Point(configuration.screenWidthDp, configuration.screenHeightDp);
            if (this.oCX == null || !this.oCX.equals(point)) {
                this.oCX = point;
                bQC();
            }
        }
        AppMethodBeat.m2505o(55233);
    }

    private void bQA() {
        AppMethodBeat.m2504i(55234);
        if (this.oCT <= 0 || C5046bo.m7525az(this.oCT) > 500) {
            C4990ab.m7419v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", C5046bo.dpG().toString(), Integer.valueOf(this.hGH));
            bQG();
            this.oCN = true;
            if (this.hGH == 2) {
                if (this.gLs == null || !this.gLs.mo14842WP()) {
                    C4990ab.m7416i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    bQJ();
                    this.oCO = true;
                }
            } else if (this.hGH == 1) {
                updateState(6);
                if (m25932jb(true)) {
                    updateState(1);
                }
            }
            bQH();
            this.oCT = C5046bo.m7588yz();
            AppMethodBeat.m2505o(55234);
            return;
        }
        C4990ab.m7416i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
        AppMethodBeat.m2505o(55234);
    }

    private void stopRecord() {
        AppMethodBeat.m2504i(55235);
        C4990ab.m7409c("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", Integer.valueOf(this.hGH));
        if (this.hGH == 2) {
            bQF();
        }
        AppMethodBeat.m2505o(55235);
    }

    private void bQB() {
        AppMethodBeat.m2504i(55236);
        try {
            ViewGroup.LayoutParams layoutParams = this.oxL.getLayoutParams();
            this.oCq.removeView(this.oxL);
            this.oCq.addView(this.oxL, 0, layoutParams);
            AppMethodBeat.m2505o(55236);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", e.getMessage());
            AppMethodBeat.m2505o(55236);
        }
    }

    private void bQC() {
        AppMethodBeat.m2504i(55237);
        updateState(0);
        this.oCR = 0;
        this.hGI = false;
        this.oCV = false;
        if (this.oxL != null) {
            this.oxL.stop();
            this.oxL.setVideoCallback(null);
            bQB();
        }
        if (this.oCC != null) {
            this.oCC.release();
            this.oCC = null;
        }
        if (this.oCy != null) {
            this.oCy.setVisibility(0);
        }
        this.oCx.setImageBitmap(null);
        bQI();
        this.oCl = new C39385e(this.fcY, this.owm.scene);
        this.oCl.mo62281a(this.oCz.fcA);
        if (this.oCl.mo62304v(this, this.oCD)) {
            if (this.gLR.isAvailable()) {
                this.oCu = this.gLR.getSurfaceTexture();
                C4990ab.m7417i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", this.oCu);
                if (m25932jb(false)) {
                    updateState(1);
                } else {
                    updateState(8);
                }
            } else {
                this.gLR.setTextureChangeCallback(new C168268());
            }
            if (this.oCA != null && this.oCk) {
                this.oCA.setAlpha(1.0f);
                this.oCA.setVisibility(0);
            }
            this.oCM.reset();
            this.oCN = false;
            this.oCO = false;
            AppMethodBeat.m2505o(55237);
            return;
        }
        updateState(8);
        AppMethodBeat.m2505o(55237);
    }

    /* renamed from: jb */
    private boolean m25932jb(boolean z) {
        AppMethodBeat.m2504i(55238);
        C4990ab.m7408b("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", this.oCu);
        this.oCV = false;
        if (this.gLs != null) {
            if (this.oCl != null) {
                this.oCl.mo62285b(this.gLs.getFrameDataCallback());
            }
            this.gLs.cancel();
        }
        if (this.oCl == null) {
            AppMethodBeat.m2505o(55238);
            return false;
        }
        boolean a;
        this.oCE = new baa();
        this.oCE.wDP = true;
        this.oCE.wDO = C12563j.ouz.ouO;
        if (this.owm != null) {
            this.oCE.wDR = this.owm.scene;
        }
        if (z) {
            a = this.oCl.mo62283a((Context) this, this.oCu, true);
            this.oCD = this.oCl.bPv();
            if (!a) {
                AppMethodBeat.m2505o(55238);
                return false;
            }
        } else if (this.oCl.mo62278a(this.oCu, true) < 0) {
            AppMethodBeat.m2505o(55238);
            return false;
        }
        if (this.oCl.getEncodeVideoBestSize() == null) {
            AppMethodBeat.m2505o(55238);
            return false;
        }
        C43306k.bPR();
        this.gLs = C43306k.m77221p(this.fcY);
        if (this.gLs == null) {
            C4990ab.m7412e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            this.oCV = true;
            AppMethodBeat.m2505o(55238);
            return false;
        }
        C3475d.m5769a(this.gLs, this.owm);
        this.gLs.mo14846a(this);
        this.oCl.mo62281a(this.gLs.getFrameDataCallback());
        if (this.oCz != null) {
            this.oCz.mo36740ab(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getOrientation());
        }
        this.gLs.mo14862s(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getEncodeVideoBestSize().x, this.oCl.getEncodeVideoBestSize().y);
        a = this.gLs.mo14856ko(this.oCl.getOrientation());
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "preInit result: %s", Boolean.valueOf(a));
        if (!a) {
            this.oCV = true;
        }
        AppMethodBeat.m2505o(55238);
        return a;
    }

    private int bQD() {
        AppMethodBeat.m2504i(55239);
        C4990ab.m7416i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int b = this.gLs.mo14848b(this.oCl.getOrientation(), this.oCM.isLandscape(), this.oCM.getOrientation());
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", Integer.valueOf(b));
        if (b >= 0) {
            this.oCl.mo62279a(C39384a.Recording);
        }
        AppMethodBeat.m2505o(55239);
        return b;
    }

    private void bQE() {
        AppMethodBeat.m2504i(55240);
        this.oCV = true;
        updateState(8);
        if (this.gLs != null) {
            try {
                this.gLs.cancel();
                this.gLs = null;
                AppMethodBeat.m2505o(55240);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(55240);
    }

    private void bQF() {
        AppMethodBeat.m2504i(55241);
        updateState(7);
        this.oCn.setTouchEnable(false);
        final int previewWidth = this.oCl.getPreviewWidth();
        final int previewHeight = this.oCl.getPreviewHeight();
        this.gLs.mo14865v(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(55195);
                C4990ab.m7409c("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", SightCaptureUI.m25951zb(SightCaptureUI.this.hGH));
                SightCaptureUI.this.oCl.mo62279a(C39384a.Stoping);
                SightCaptureUI.m25886B(SightCaptureUI.this);
                final long RN = C3475d.m5766RN("TIME_RECODER_2_PLAY");
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(55194);
                        String filePath = SightCaptureUI.this.gLs.getFilePath();
                        baa K = SightCaptureUI.this.oCE;
                        try {
                            if (!C5046bo.isNullOrNil(filePath) && C5730e.m8628ct(filePath)) {
                                int i;
                                int i2;
                                int i3;
                                int i4;
                                int i5;
                                C7060h.pYm.mo8378a(440, 87, 1, false);
                                JSONObject jSONObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(filePath));
                                int i6 = (int) jSONObject.getDouble("videoFPS");
                                int optInt = jSONObject.optInt("videoBitrate");
                                C4990ab.m7417i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s", Integer.valueOf(i6), Integer.valueOf(optInt));
                                C12558a bPi = C12558a.bPi();
                                bPi.otv = C12563j.ouz.etz;
                                bPi.videoBitrate = C12563j.ouz.videoBitrate;
                                bPi.etA = C12563j.ouz.ouL ? 1 : 0;
                                bPi.otw = C12563j.ouz.ouM ? 1 : 0;
                                bPi.fay = C12563j.ouz.fay;
                                bPi.otx = i6;
                                bPi.fileSize = C5730e.asZ(filePath);
                                C43528a WR = C21846d.m33388WR(filePath);
                                if (WR != null) {
                                    bPi.otA = WR.width;
                                    bPi.otB = WR.height;
                                    bPi.otC = WR.videoBitrate;
                                    bPi.oty = WR.eWK;
                                }
                                if (C12563j.ouz.etz == 1) {
                                    C7060h.pYm.mo8378a(440, 89, 1, false);
                                    C7060h.pYm.mo8378a(440, 49, (long) i6, false);
                                    i = 93;
                                    i2 = 73;
                                    i3 = 69;
                                } else {
                                    C7060h.pYm.mo8378a(440, 88, 1, false);
                                    C7060h.pYm.mo8378a(440, 48, (long) i6, false);
                                    i = 90;
                                    i2 = 54;
                                    i3 = 50;
                                }
                                if (C12563j.ouz.fay == 720) {
                                    i++;
                                    i4 = i2 + 6;
                                    i5 = i3 + 6;
                                } else if (C12563j.ouz.bPI()) {
                                    i += 2;
                                    i4 = i2 + 12;
                                    i5 = i3 + 12;
                                } else {
                                    i4 = i2;
                                    i5 = i3;
                                }
                                C7060h.pYm.mo8378a(440, (long) i4, (long) i6, false);
                                C7060h.pYm.mo8378a(440, (long) i, 1, false);
                                C7060h.pYm.mo8378a(440, 47, (long) i6, false);
                                C4990ab.m7417i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", filePath, Integer.valueOf(i5));
                                if (i6 >= 0 && i6 <= 10) {
                                    C7060h.pYm.mo8378a(440, (long) i5, 1, false);
                                } else if (i6 > 10 && i6 <= 15) {
                                    C7060h.pYm.mo8378a(440, (long) (i5 + 1), 1, false);
                                } else if (i6 > 15 && i6 <= 20) {
                                    C7060h.pYm.mo8378a(440, (long) (i5 + 2), 1, false);
                                } else if (i6 > 20 && i6 <= 30) {
                                    C7060h.pYm.mo8378a(440, (long) (i5 + 3), 1, false);
                                }
                                if (optInt > 0) {
                                    if (C12563j.ouz.etz == 2) {
                                        C7060h.pYm.mo8378a(440, 175, (long) optInt, false);
                                        C7060h.pYm.mo8378a(440, 176, 1, false);
                                        if (K != null) {
                                            if (K.wDR == 1) {
                                                C7060h.pYm.mo8378a(440, 184, (long) optInt, false);
                                                C7060h.pYm.mo8378a(440, 185, 1, false);
                                            } else if (K.wDR == 2) {
                                                C7060h.pYm.mo8378a(440, 194, (long) optInt, false);
                                                C7060h.pYm.mo8378a(440, 195, 1, false);
                                            }
                                        }
                                    } else {
                                        C7060h.pYm.mo8378a(440, 179, (long) optInt, false);
                                        C7060h.pYm.mo8378a(440, 180, 1, false);
                                        if (K != null) {
                                            if (K.wDR == 1) {
                                                C7060h.pYm.mo8378a(440, 189, (long) optInt, false);
                                                C7060h.pYm.mo8378a(440, 190, 1, false);
                                            } else if (K.wDR == 2) {
                                                C7060h.pYm.mo8378a(440, 199, (long) optInt, false);
                                                C7060h.pYm.mo8378a(440, 200, 1, false);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", e.getMessage());
                        }
                        C34549k.m56643d(false, RN);
                        AppMethodBeat.m2505o(55194);
                    }
                }, "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
                C4990ab.m7419v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", C5046bo.dpG().toString());
                C4990ab.m7417i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", SightCaptureUI.this.gLs.getFilePath(), Long.valueOf(C5730e.asZ(SightCaptureUI.this.gLs.getFilePath())), Long.valueOf(RN));
                SightCaptureUI.this.cMW = SightCaptureUI.this.gLs.mo14833Aq();
                SightCaptureUI.m25885A(SightCaptureUI.this);
                SightCaptureUI.m25896L(SightCaptureUI.this);
                SightCaptureUI.m25897M(SightCaptureUI.this);
                C5004al.m7442n(SightCaptureUI.this.oDe, 1000);
                if (SightCaptureUI.this.owm.scene == 1 || SightCaptureUI.this.owm.scene == 2 || SightCaptureUI.this.owm.scene == 7) {
                    C7060h.pYm.mo8381e(13819, Integer.valueOf(2), Integer.valueOf(SightCaptureUI.this.owm.scene), SightCaptureUI.this.owm.osR, Long.valueOf(C5046bo.anT()));
                }
                AppMethodBeat.m2505o(55195);
            }
        });
        AppMethodBeat.m2505o(55241);
    }

    private void bQG() {
        AppMethodBeat.m2504i(55242);
        C43306k.bPR();
        if (C43306k.isDebug()) {
            TextView textView = (TextView) findViewById(2131821713);
            textView.setVisibility(8);
            textView.setText("");
            AppMethodBeat.m2505o(55242);
            return;
        }
        AppMethodBeat.m2505o(55242);
    }

    private void bQH() {
        AppMethodBeat.m2504i(55243);
        C43306k.bPR();
        if (C43306k.isDebug()) {
            C4990ab.m7416i("MicroMsg.SightCaptureUI", "test for debug " + C5046bo.dpG().toString());
            C46078i.m85849S(new C1683114());
            AppMethodBeat.m2505o(55243);
            return;
        }
        AppMethodBeat.m2505o(55243);
    }

    /* renamed from: aU */
    private String m25915aU(String str, boolean z) {
        String RL;
        AppMethodBeat.m2504i(55244);
        boolean z2 = CaptureMMProxy.getInstance().getBoolean(C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        boolean z3 = CaptureMMProxy.getInstance().getBoolean(C5127a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
        if (z) {
            RL = C3475d.m5764RL("jpg");
        } else {
            RL = C3475d.m5764RL("mp4");
        }
        if ((z2 && z) || (z3 && !z)) {
            C4990ab.m7417i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", str, RL, Boolean.valueOf(z2), Boolean.valueOf(z3));
            C5730e.m8644y(str, RL);
            C40612a.m70043a(RL, this);
        }
        AppMethodBeat.m2505o(55244);
        return RL;
    }

    private void bQI() {
        AppMethodBeat.m2504i(55245);
        if (this.gLR != null) {
            this.gLR.setTextureChangeCallback(null);
        }
        if (this.oCl != null) {
            this.oCD = this.oCl.bPv();
            this.oCl.bPq();
            this.oCT = -1;
            this.hGJ = -1;
        }
        AppMethodBeat.m2505o(55245);
    }

    private void bQJ() {
        AppMethodBeat.m2504i(55246);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.hGH);
        objArr[1] = this.gLs != null ? this.gLs.mo14838WL() : "";
        C4990ab.m7417i(str, str2, objArr);
        if (this.hGH == 2 && this.gLs != null && this.gLs.mo14838WL() == C34543c.Start) {
            this.gLs.pause();
            this.oCl.mo62283a((Context) this, this.oCu, false);
            this.oCD = this.oCl.bPv();
            if (this.oCz != null) {
                this.oCz.mo36740ab(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getOrientation());
            }
            if (this.gLs.mo14838WL() != C34543c.Pause) {
                C4990ab.m7413e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", this.gLs.mo14838WL());
                AppMethodBeat.m2505o(55246);
                return;
            }
            int previewWidth = this.oCl.getPreviewWidth();
            int previewHeight = this.oCl.getPreviewHeight();
            int orientation = this.oCl.getOrientation();
            Point WN = this.gLs.mo14840WN();
            C4990ab.m7417i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), WN, Integer.valueOf(orientation), Integer.valueOf(this.gLs.mo14841WO()));
            if (!(this.gLs.mo14841WO() == orientation && WN.x == previewWidth && WN.y == previewHeight)) {
                C4990ab.m7412e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
            }
            this.gLs.mo14862s(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getEncodeVideoBestSize().x, this.oCl.getEncodeVideoBestSize().y);
            this.gLs.mo14834G(orientation, this.oCl.getEncodeVideoBestSize().x, this.oCl.getEncodeVideoBestSize().y);
        }
        AppMethodBeat.m2505o(55246);
    }

    public void onDestroy() {
        Object obj;
        AppMethodBeat.m2504i(55247);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.SightCaptureUI", "onDestroy");
        this.ext.release();
        if (this.gLs != null) {
            this.gLs.mo14846a(null);
            this.gLs.mo14865v(null);
            this.gLs.clear();
        }
        if (this.hGH == -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            bQI();
            if (this.oxL != null) {
                this.oxL.stop();
                this.oxL.setVideoCallback(null);
            }
            if (this.gar != null) {
                this.gar.mo73178Mm();
            }
            if (this.oCC != null) {
                this.oCC.release();
                this.oCC = null;
            }
        }
        if (this.oCM != null) {
            this.oCM.disable();
            this.oCM.otK = null;
            this.oCM = null;
        }
        C43305j.owk.mo45830WY();
        C4879a.xxA.mo10053d(this.oCY);
        AppMethodBeat.m2505o(55247);
    }

    public final int getLayoutId() {
        return 2130968833;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(55248);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "[onActivityResult] requestCode:%s  resultCode:%s data is null?:";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7417i(str, str2, objArr);
        switch (i) {
            case 4369:
                C4990ab.m7417i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", Integer.valueOf(i2));
                if (!(i2 != -1 || intent == null || this.gLs == null)) {
                    this.oDc = true;
                    this.oDd = intent.getBundleExtra("report_info");
                    this.oDa = intent.getStringExtra("raw_photo_path");
                    this.oDb = intent.getStringExtra("after_photo_edit");
                    C4990ab.m7417i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", this.oDa, this.oDb, Boolean.valueOf(CaptureMMProxy.getInstance().getBoolean(C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)));
                    if (CaptureMMProxy.getInstance().getBoolean(C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)) {
                        this.gLs.mo14859mc(this.oDb);
                    } else {
                        String subCoreImageFullPath = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
                        C4990ab.m7417i("MicroMsg.SightCaptureUI", "saveFullPath:%s", subCoreImageFullPath);
                        C5730e.m8644y(this.oDb, subCoreImageFullPath);
                        C5730e.deleteFile(this.oDb);
                        C40612a.m70043a(this.oDb, this);
                        this.gLs.mo14859mc(subCoreImageFullPath);
                        this.oDb = subCoreImageFullPath;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.oDb, options);
                    C4990ab.m7417i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    Bitmap ao = C5056d.m7641ao(this.oDb, options.outHeight, options.outWidth);
                    this.oCx.setVisibility(0);
                    this.oCx.setImageBitmap(ao);
                    this.oCy.setVisibility(8);
                    break;
                }
        }
        AppMethodBeat.m2505o(55248);
    }

    /* renamed from: za */
    private static String m25950za(int i) {
        if (i == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i == 6) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i == 7) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i == 8) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i == 9) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void updateState(int i) {
        AppMethodBeat.m2504i(55249);
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", Integer.valueOf(this.hGH), SightCaptureUI.m25950za(this.hGH), Integer.valueOf(i), SightCaptureUI.m25950za(i));
        C4990ab.m7417i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", Integer.valueOf(this.hGH), SightCaptureUI.m25950za(this.hGH), Integer.valueOf(i), SightCaptureUI.m25950za(i), C5046bo.dpG().toString());
        if (i == this.hGH) {
            AppMethodBeat.m2505o(55249);
        } else if (this.oCq == null) {
            AppMethodBeat.m2505o(55249);
        } else {
            C3475d.m5765RM("TIME_RECODER_2_PLAY");
            this.hGH = i;
            if (this.hGH != 7) {
                C5004al.m7439af(this.oCZ);
            }
            if (this.hGH == 0) {
                this.oCq.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCr.setVisibility(8);
                this.oCx.setVisibility(8);
                this.oCw.setVisibility(0);
                if (this.oCQ > 1) {
                    this.oCs.setVisibility(0);
                }
                if (this.oCl != null) {
                    this.oCl.mo62279a(C39384a.Preview);
                }
                C12558a.reset();
                if (this.oCS != null) {
                    try {
                        this.oCS.interrupt();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "update to state init, interrupt failed: %s", e.getMessage());
                    }
                    this.oCS = null;
                    AppMethodBeat.m2505o(55249);
                    return;
                }
            } else if (this.hGH == 1 || this.hGH == 2) {
                this.oCq.setVisibility(0);
                this.oCt.setVisibility(8);
                this.oCr.setVisibility(0);
                this.oCr.setClipChildren(false);
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCp.setVisibility(0);
                this.oCn.setVisibility(0);
                this.oxL.setVisibility(8);
                if (this.hGH == 1) {
                    this.oCn.reset();
                } else {
                    this.oCn.setTouchEnable(true);
                    this.oCn.bQt();
                }
                this.oCB.setVisibility(8);
                this.oCx.setVisibility(8);
                this.lmm.setVisibility(0);
                if (this.oCQ > 1) {
                    this.oCs.setVisibility(0);
                }
                this.lmm.bringToFront();
                this.oCs.bringToFront();
                bQG();
                bQH();
                AppMethodBeat.m2505o(55249);
                return;
            } else if (this.hGH == 4 || this.hGH == 3) {
                this.oCq.setVisibility(0);
                this.oCr.setVisibility(8);
                this.oCr.setClipChildren(false);
                this.oCo.setVisibility(0);
                this.nPr.setVisibility(0);
                this.oCp.setVisibility(8);
                this.oCn.setVisibility(8);
                if (this.hGH == 3) {
                    this.oCt.setVisibility(0);
                    this.oCx.setVisibility(0);
                    this.oxL.setVisibility(8);
                } else {
                    this.oCx.setVisibility(8);
                    this.oxL.setVisibility(0);
                    this.oxL.setForceScaleFullScreen(true);
                    ViewGroup.LayoutParams layoutParams = this.oxL.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.oxL.setLayoutParams(layoutParams);
                    if (this.gLs.isLandscape()) {
                        this.oCz.mo36738WB();
                    }
                    this.oCw.setVisibility(8);
                }
                this.lmm.setVisibility(8);
                AppMethodBeat.m2505o(55249);
                return;
            } else if (this.hGH == 6) {
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCp.setVisibility(8);
                this.oCn.setVisibility(8);
                AppMethodBeat.m2505o(55249);
                return;
            } else if (this.hGH == 7) {
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCp.setVisibility(8);
                this.oCs.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCn.setTouchEnable(false);
                C5004al.m7442n(this.oCZ, 1500);
                this.oCn.bgk();
                AppMethodBeat.m2505o(55249);
                return;
            } else if (this.hGH == 8) {
                this.oCq.setVisibility(0);
                this.oCr.setVisibility(0);
                this.oCr.setClipChildren(false);
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCp.setVisibility(0);
                if (this.oCQ > 1) {
                    this.oCs.setVisibility(0);
                }
                this.oCn.setVisibility(0);
                this.lmm.setVisibility(0);
                this.oxL.setVisibility(8);
                this.oCB.setVisibility(8);
                this.oCx.setVisibility(8);
                if (this.oCV) {
                    Toast.makeText(this, C25738R.string.czu, 1).show();
                } else {
                    Toast.makeText(this, C25738R.string.czz, 1).show();
                }
                this.oCn.setTouchEnable(false);
                this.oCn.setEnabled(false);
                AppMethodBeat.m2505o(55249);
                return;
            } else if (this.hGH == 9) {
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCp.setVisibility(0);
                this.oCs.setVisibility(8);
                this.oCn.reset();
                this.oCn.setTouchEnable(false);
                this.oCn.setEnabled(false);
                Toast.makeText(this, C25738R.string.czv, 1).show();
            }
            AppMethodBeat.m2505o(55249);
        }
    }

    /* renamed from: jc */
    private void m25933jc(boolean z) {
        AppMethodBeat.m2504i(55250);
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", Boolean.valueOf(z), this.oDb, this.oDa);
        if (!C5046bo.isNullOrNil(this.oDb) && z) {
            C5730e.deleteFile(this.oDb);
        }
        if (!C5046bo.isNullOrNil(this.oDa)) {
            C5730e.deleteFile(this.oDa);
        }
        this.oDb = null;
        this.oDa = null;
        C42026mj c42026mj = new C42026mj();
        c42026mj.cIo.cuy = 0;
        C4879a.xxA.mo10055m(c42026mj);
        AppMethodBeat.m2505o(55250);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(55251);
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "onBackPressed %d", Integer.valueOf(this.hGH));
        if (this.oCC != null && this.oCC.mo24542wY()) {
            AppMethodBeat.m2505o(55251);
        } else if (this.oCC != null) {
            this.oCC.release();
            this.oCC = null;
            mo17375Ne(8);
            this.oCo.setVisibility(0);
            this.nPr.setVisibility(0);
            this.oCt.setVisibility(0);
            AppMethodBeat.m2505o(55251);
        } else {
            if (bQK()) {
                super.onBackPressed();
                overridePendingTransition(-1, C25738R.anim.f8399d_);
                m25933jc(true);
            }
            AppMethodBeat.m2505o(55251);
        }
    }

    private boolean bQK() {
        return this.hGH == 4 || this.hGH == 3 || this.hGH == 1 || this.hGH == 8 || this.hGH == 9;
    }

    /* renamed from: yR */
    public final void mo30796yR(int i) {
        AppMethodBeat.m2504i(55252);
        if (this.oCQ <= 1) {
            AppMethodBeat.m2505o(55252);
        } else if (this.hGH == 2) {
            AppMethodBeat.m2505o(55252);
        } else {
            C4990ab.m7417i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", Integer.valueOf(i));
            if (i < 0) {
                AppMethodBeat.m2505o(55252);
                return;
            }
            float f;
            if (i != 90 && i != 270) {
                f = (float) i;
            } else if (i == 270) {
                f = 90.0f;
            } else {
                f = -90.0f;
            }
            if (this.oCs.getRotation() == f) {
                AppMethodBeat.m2505o(55252);
                return;
            }
            this.oCs.animate().rotation(f).setDuration(100).start();
            AppMethodBeat.m2505o(55252);
        }
    }

    public final void asv() {
        AppMethodBeat.m2504i(55253);
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "onError: %s", Integer.valueOf(1));
        try {
            if (this.gLs != null) {
                this.gLs.reset();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", e.getMessage());
        }
        updateState(9);
        AppMethodBeat.m2505o(55253);
    }

    /* renamed from: b */
    static /* synthetic */ void m25917b(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55254);
        sightCaptureUI.dyg();
        sightCaptureUI.mo17375Ne(8);
        if (sightCaptureUI.owm == null) {
            C4990ab.m7412e("MicroMsg.SightCaptureUI", "sightParams error!");
            AppMethodBeat.m2505o(55254);
            return;
        }
        sightCaptureUI.oCQ = C32468d.getNumberOfCameras();
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", Integer.valueOf(sightCaptureUI.oCQ));
        sightCaptureUI.gar = new C45293b(sightCaptureUI);
        sightCaptureUI.oCk = sightCaptureUI.owm.osP;
        sightCaptureUI.osJ = sightCaptureUI.owm.osJ;
        sightCaptureUI.oCD = sightCaptureUI.osJ == 2;
        C43306k.bPR().owm = sightCaptureUI.owm;
        sightCaptureUI.oCj = sightCaptureUI.owm.mode;
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", Integer.valueOf(sightCaptureUI.oCj), Boolean.valueOf(sightCaptureUI.oCk), Integer.valueOf(sightCaptureUI.osJ), Integer.valueOf(sightCaptureUI.owm.scene));
        sightCaptureUI.fcY = sightCaptureUI.owm.fcY;
        if (sightCaptureUI.fcY == null) {
            C4990ab.m7412e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            AppMethodBeat.m2505o(55254);
            return;
        }
        C4990ab.m7417i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", sightCaptureUI.fcY);
        sightCaptureUI.getWindow().addFlags(2097280);
        if (C1443d.m3068iW(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            C3475d.m5783iV(true);
        } else {
            sightCaptureUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            C3475d.m5783iV(false);
        }
        if (VERSION.SDK_INT >= 21) {
            sightCaptureUI.getWindow().addFlags(67108864);
        }
        sightCaptureUI.oCM = new C21302c(sightCaptureUI);
        sightCaptureUI.oCM.otK = sightCaptureUI;
        sightCaptureUI.oCM.enable();
        sightCaptureUI.oCm = (ViewGroup) sightCaptureUI.findViewById(2131820987);
        sightCaptureUI.oCq = (ViewGroup) sightCaptureUI.findViewById(2131821708);
        sightCaptureUI.oCr = (ViewGroup) sightCaptureUI.findViewById(2131821720);
        sightCaptureUI.oCv = (CameraFrontSightView) sightCaptureUI.findViewById(2131821707);
        sightCaptureUI.gLR = (ObservableTextureView) sightCaptureUI.findViewById(2131821723);
        sightCaptureUI.oCn = (MMSightRecordButton) sightCaptureUI.findViewById(2131821721);
        sightCaptureUI.oCo = sightCaptureUI.findViewById(2131821715);
        sightCaptureUI.nPr = sightCaptureUI.findViewById(2131821716);
        sightCaptureUI.oCp = sightCaptureUI.findViewById(2131821714);
        sightCaptureUI.oCw = (ViewGroup) sightCaptureUI.findViewById(2131821705);
        sightCaptureUI.oCA = (TextView) sightCaptureUI.findViewById(2131821722);
        if (sightCaptureUI.oCj == 2) {
            sightCaptureUI.oCA.setText(C25738R.string.czx);
        } else if (sightCaptureUI.oCj == 1) {
            sightCaptureUI.oCA.setText(C25738R.string.czy);
        } else if (sightCaptureUI.oCj == 0) {
            sightCaptureUI.oCA.setText(C25738R.string.czw);
        }
        sightCaptureUI.oxL = (VideoPlayerTextureView) sightCaptureUI.findViewById(2131821710);
        sightCaptureUI.oCs = (ImageView) sightCaptureUI.findViewById(2131821719);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) sightCaptureUI.oCs.getLayoutParams();
        int i = layoutParams.topMargin;
        if (C5222ae.m7950hD(sightCaptureUI.mController.ylL)) {
            i += C5222ae.m7949hC(sightCaptureUI.mController.ylL);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        sightCaptureUI.oCs.setLayoutParams(layoutParams);
        sightCaptureUI.oCt = (ImageView) sightCaptureUI.findViewById(2131821712);
        sightCaptureUI.oCt.setOnClickListener(new C1680922());
        sightCaptureUI.oCx = (ImageView) sightCaptureUI.findViewById(2131821711);
        sightCaptureUI.oCy = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(2131821706);
        sightCaptureUI.lmm = (MMSightCaptureTouchView) sightCaptureUI.findViewById(2131821718);
        sightCaptureUI.oCB = sightCaptureUI.findViewById(2131821709);
        sightCaptureUI.oCz = new C21318a(sightCaptureUI.oCy);
        if (sightCaptureUI.oCk) {
            sightCaptureUI.oCA.setVisibility(0);
        } else {
            sightCaptureUI.oCA.setVisibility(8);
        }
        int fromDPToPix = C1338a.fromDPToPix(sightCaptureUI.mController.ylL, 120);
        sightCaptureUI.oCv.mo36728ez(fromDPToPix, fromDPToPix);
        if (C1443d.m3068iW(19)) {
            i = Math.max(C5230ak.m7988fr(sightCaptureUI), C5230ak.m7992hx(sightCaptureUI));
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCn.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCn.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCp.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCp.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCo.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCo.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCt.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCt.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.nPr.getLayoutParams();
            marginLayoutParams.bottomMargin = i + marginLayoutParams.bottomMargin;
            sightCaptureUI.nPr.setLayoutParams(marginLayoutParams);
        }
        if (sightCaptureUI.oCj == 1 || sightCaptureUI.oCj == 0) {
            sightCaptureUI.oCn.setLongPressCallback(new C1681023());
            sightCaptureUI.oCn.setErrorPressCallback(new C1682824());
            sightCaptureUI.oCn.setLongPressScrollCallback(new C1683225());
        }
        if (sightCaptureUI.oCj == 0 || sightCaptureUI.oCj == 2) {
            sightCaptureUI.oCn.setSimpleTapCallback(new C1682326());
        }
        if (sightCaptureUI.oCQ > 1) {
            sightCaptureUI.oCs.setOnClickListener(new C1682427());
        } else {
            sightCaptureUI.oCs.setVisibility(8);
        }
        sightCaptureUI.nPr.setOnClickListener(new C168192());
        sightCaptureUI.oCo.setOnClickListener(new C168113());
        sightCaptureUI.oCp.setOnClickListener(new C168124());
        sightCaptureUI.lmm.setTouchCallback(new C168295());
        sightCaptureUI.updateState(0);
        sightCaptureUI.bQC();
        sightCaptureUI.oCW = Boolean.TRUE;
        AppMethodBeat.m2505o(55254);
    }

    /* renamed from: h */
    static /* synthetic */ void m25929h(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55256);
        C4990ab.m7416i("MicroMsg.SightCaptureUI", "[gotoPhotoEditUI]");
        if (sightCaptureUI.gLs == null) {
            C4990ab.m7412e("MicroMsg.SightCaptureUI", "mediaRecorder == NULL");
            AppMethodBeat.m2505o(55256);
            return;
        }
        String stringExtra = sightCaptureUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = sightCaptureUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        if (sightCaptureUI.owm.scene == 1) {
            intent.putExtra("from_scene", 290);
        } else if (sightCaptureUI.owm.scene == 2) {
            intent.putExtra("from_scene", C31128d.MIC_PTU_ZIRAN);
        }
        intent.putExtra("raw_photo_path", C5046bo.isNullOrNil(sightCaptureUI.oDa) ? sightCaptureUI.gLs.mo14835WI() : sightCaptureUI.oDa);
        intent.putExtra("after_photo_edit", sightCaptureUI.oDb);
        intent.setClass(sightCaptureUI, MMNewPhotoEditUI.class);
        sightCaptureUI.startActivityForResult(intent, 4369);
        AppMethodBeat.m2505o(55256);
    }

    /* renamed from: i */
    static /* synthetic */ void m25930i(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55257);
        if (C5230ak.m7991hw(sightCaptureUI)) {
            sightCaptureUI.mo17375Ne(0);
        }
        sightCaptureUI.oxM = (VideoSeekBarEditorView) sightCaptureUI.findViewById(2131821717);
        if (C5230ak.m7991hw(sightCaptureUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oxM.getLayoutParams();
            marginLayoutParams.bottomMargin = Math.max(C5230ak.m7988fr(sightCaptureUI), C5230ak.m7992hx(sightCaptureUI));
            sightCaptureUI.oxM.setLayoutParams(marginLayoutParams);
        }
        sightCaptureUI.oCC = new C12597b();
        sightCaptureUI.oCC.oBR = 2;
        sightCaptureUI.oCC.oBN = true;
        sightCaptureUI.oCC.mo24539a(sightCaptureUI, sightCaptureUI.owm.scene, sightCaptureUI.gLs.getFilePath(), sightCaptureUI.oxM, sightCaptureUI.oxL, sightCaptureUI.oCq, sightCaptureUI.fcY, false);
        sightCaptureUI.oCC.oBL = new C1258515();
        sightCaptureUI.oCo.setVisibility(8);
        sightCaptureUI.nPr.setVisibility(8);
        sightCaptureUI.oCt.setVisibility(8);
        AppMethodBeat.m2505o(55257);
    }

    /* renamed from: n */
    static /* synthetic */ void m25937n(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55259);
        if (sightCaptureUI.oCA != null && sightCaptureUI.oCk) {
            sightCaptureUI.oCA.animate().alpha(0.0f).setDuration(100).setListener(new C168257()).start();
        }
        AppMethodBeat.m2505o(55259);
    }

    /* renamed from: o */
    static /* synthetic */ void m25938o(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55260);
        if (sightCaptureUI.gLs != null) {
            C4990ab.m7419v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", sightCaptureUI.gLs.mo14838WL(), C5046bo.dpG().toString());
            sightCaptureUI.updateState(6);
            if (sightCaptureUI.gLs.mo14838WL() == C34543c.Stop) {
                sightCaptureUI.oCR = sightCaptureUI.bQD();
                if (sightCaptureUI.oCR < 0) {
                    sightCaptureUI.bQE();
                    AppMethodBeat.m2505o(55260);
                    return;
                }
            } else if (sightCaptureUI.oCR < 0) {
                sightCaptureUI.bQE();
                AppMethodBeat.m2505o(55260);
                return;
            }
            sightCaptureUI.updateState(2);
            if (sightCaptureUI.oCl != null) {
                sightCaptureUI.oCl.bPm();
            }
            sightCaptureUI.oCn.mo62335a((sightCaptureUI.fcY.duration * 1000) - 500, 0, new C168279());
        }
        AppMethodBeat.m2505o(55260);
    }

    /* renamed from: q */
    static /* synthetic */ void m25940q(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55261);
        if (!(sightCaptureUI.oCl == null || !sightCaptureUI.oCl.bPu() || sightCaptureUI.oCM == null || sightCaptureUI.hGI || (sightCaptureUI.hGJ >= 0 && C5046bo.m7525az(sightCaptureUI.hGJ) > 300))) {
            sightCaptureUI.hGI = true;
            if (sightCaptureUI.oCA != null && sightCaptureUI.oCk) {
                sightCaptureUI.oCA.setVisibility(8);
            }
            sightCaptureUI.updateState(7);
            sightCaptureUI.oCn.setTouchEnable(false);
            sightCaptureUI.oCP = sightCaptureUI.oCM.isLandscape();
            sightCaptureUI.oCK = null;
            sightCaptureUI.oCL = -1;
            sightCaptureUI.oCl.mo62280a(new C168336(), sightCaptureUI.oCP, sightCaptureUI.oCM.getOrientation());
            sightCaptureUI.hGJ = C5046bo.m7588yz();
        }
        AppMethodBeat.m2505o(55261);
    }

    /* renamed from: t */
    static /* synthetic */ void m25943t(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55264);
        if (sightCaptureUI.owm.scene == 1 || sightCaptureUI.owm.scene == 2 || sightCaptureUI.owm.scene == 7) {
            int i = sightCaptureUI.oCN ? sightCaptureUI.oCO ? 2 : 1 : 0;
            C7060h.pYm.mo8381e(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.owm.scene), sightCaptureUI.owm.osR, Long.valueOf(C5046bo.anT()));
        }
        if (sightCaptureUI.owm != null && sightCaptureUI.oCU) {
            C34537a.m56629a(new C34538a(sightCaptureUI.owm.scene));
        }
        Intent intent = new Intent();
        String filePath = sightCaptureUI.gLs.getFilePath();
        String WO = C21846d.m33385WO(filePath);
        if (sightCaptureUI.owm.osQ) {
            sightCaptureUI.m25915aU(filePath, false);
        }
        if (C12558a.bPi() != null) {
            sightCaptureUI.oCE.wDS = C12558a.bPi().bPj();
        }
        int WM = sightCaptureUI.gLs.mo14839WM();
        if (sightCaptureUI.oCU) {
            C43528a WR = C21846d.m33388WR(sightCaptureUI.gLs.getFilePath());
            if (WR != null) {
                WM = Math.round(((float) WR.eWK) / 1000.0f);
            }
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oCl.bPv(), filePath, WO, sightCaptureUI.gLs.getFileName(), sightCaptureUI.cMW, WM, sightCaptureUI.oCE));
        intent.putExtra("KSessionID", sightCaptureUI.owm.osR);
        intent.putExtra("latitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 181.0d));
        intent.putExtra("longitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 91.0d));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
        AppMethodBeat.m2505o(55264);
    }

    /* renamed from: u */
    static /* synthetic */ void m25944u(SightCaptureUI sightCaptureUI) {
        Object obj;
        AppMethodBeat.m2504i(55265);
        if (sightCaptureUI.oCS != null && sightCaptureUI.oCS.isAlive()) {
            try {
                sightCaptureUI.oCS.join();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "wait saveCaptureImageThread error: %s", e.getMessage());
            }
        }
        if (sightCaptureUI.owm.scene == 1 || sightCaptureUI.owm.scene == 2 || sightCaptureUI.owm.scene == 7) {
            int i = 0;
            if (sightCaptureUI.oCN) {
                i = 1;
            }
            C7060h.pYm.mo8381e(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.owm.scene), sightCaptureUI.owm.osR, Long.valueOf(C5046bo.anT()));
        }
        if (sightCaptureUI.owm.scene == 1) {
            C7060h.pYm.mo8381e(13858, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        } else if (sightCaptureUI.owm.scene == 2) {
            C7060h.pYm.mo8381e(13858, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        }
        Intent intent = new Intent();
        if (C5046bo.isNullOrNil(sightCaptureUI.oDb) || sightCaptureUI.gLs == null || !sightCaptureUI.oDb.equals(sightCaptureUI.gLs.mo14835WI())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null && sightCaptureUI.owm.osQ) {
            C4990ab.m7416i("MicroMsg.SightCaptureUI", "is not Photo editted!");
            sightCaptureUI.m25915aU(sightCaptureUI.gLs.mo14835WI(), true);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oCl.bPv(), sightCaptureUI.gLs.mo14835WI()));
        intent.putExtra("KSessionID", sightCaptureUI.owm.osR);
        intent.putExtra("latitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 181.0d));
        intent.putExtra("longitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 91.0d));
        sightCaptureUI.setResult(-1, intent);
        Bundle bundle = sightCaptureUI.oDd;
        if (bundle == null) {
            C4990ab.m7412e("MicroMsg.SightCaptureUI", "[reportPhotoEdit] date == null");
        } else if (sightCaptureUI.oDc) {
            int i2 = bundle.getInt("report_info_emotion_count");
            int i3 = bundle.getInt("report_info_text_count");
            int i4 = bundle.getInt("report_info_mosaic_count");
            int i5 = bundle.getInt("report_info_doodle_count");
            boolean z = bundle.getBoolean("report_info_iscrop");
            int i6 = bundle.getInt("report_info_undo_count");
            boolean z2 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.SightCaptureUI";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i4);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            objArr[5] = Integer.valueOf(i6);
            objArr[6] = Boolean.valueOf(z2);
            C4990ab.m7417i(str, str2, objArr);
            C7060h c7060h = C7060h.pYm;
            objArr = new Object[12];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i5);
            objArr[6] = Integer.valueOf(z ? 1 : 0);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = Integer.valueOf(3);
            objArr[9] = Integer.valueOf(z2 ? 1 : 0);
            objArr[10] = sightCaptureUI.owm.osR;
            objArr[11] = Long.valueOf(C5046bo.anT());
            c7060h.mo8381e(13857, objArr);
        } else {
            C4990ab.m7416i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] reportPhotoEdit == false");
        }
        sightCaptureUI.finish();
        AppMethodBeat.m2505o(55265);
    }

    /* renamed from: A */
    static /* synthetic */ void m25885A(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55268);
        C4990ab.m7416i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        if (sightCaptureUI.oCt.getVisibility() == 8) {
            sightCaptureUI.lmm.setVisibility(8);
        } else {
            sightCaptureUI.lmm.setVisibility(0);
        }
        Point eu = C3475d.m5780eu(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(C25738R.dimen.a65);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(C25738R.dimen.a67);
        sightCaptureUI.oCn.getX();
        sightCaptureUI.oCo.setTranslationX(((((float) eu.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.nPr.setTranslationX(((((float) (-eu.x)) / 2.0f) + ((float) dimensionPixelSize2)) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.oCo.setEnabled(false);
        sightCaptureUI.nPr.setEnabled(false);
        AppMethodBeat.m2505o(55268);
    }

    /* renamed from: D */
    static /* synthetic */ void m25888D(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55270);
        if (C5046bo.m7540cb(sightCaptureUI.oCF) || sightCaptureUI.oCH <= 0 || sightCaptureUI.oCG <= 0) {
            C4990ab.m7412e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                Bitmap b;
                YuvImage yuvImage = new YuvImage(sightCaptureUI.oCF, 17, sightCaptureUI.oCG, sightCaptureUI.oCH, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.oCG, sightCaptureUI.oCH), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                if (!sightCaptureUI.oCP || sightCaptureUI.oCJ == 180) {
                    int i = sightCaptureUI.oCI;
                    if (sightCaptureUI.oCJ == 180) {
                        i += 180;
                        if (i > v2helper.VOIP_ENC_HEIGHT_LV1) {
                            i -= 360;
                        }
                    }
                    b = C5056d.m7648b(decodeByteArray, (float) i);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.oCI - sightCaptureUI.oCJ) == 0) {
                    b = C5056d.m7648b(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    b = decodeByteArray;
                }
                try {
                    C5056d.m7625a(b, 90, CompressFormat.JPEG, sightCaptureUI.gLs.mo14835WI(), false);
                    C4990ab.m7417i("MicroMsg.SightCaptureUI", "bitmap filelen %s", Long.valueOf(C5730e.asZ(r1)));
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", e.getMessage());
                }
                C43305j.owk.mo68845g(sightCaptureUI.oCF);
                sightCaptureUI.oCH = 0;
                sightCaptureUI.oCG = 0;
                sightCaptureUI.oCJ = 0;
                sightCaptureUI.oCI = 0;
                sightCaptureUI.oCF = null;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "saveCaptureYuvDataToBitmap error: %s", e2.getMessage());
            }
        }
        sightCaptureUI.hGI = false;
        AppMethodBeat.m2505o(55270);
    }

    /* renamed from: G */
    static /* synthetic */ void m25891G(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55272);
        sightCaptureUI.oCo.animate().translationX(0.0f).setDuration(200).setListener(new C1681516()).start();
        sightCaptureUI.nPr.animate().translationX(0.0f).setDuration(200).setListener(new C1258817()).start();
        AppMethodBeat.m2505o(55272);
    }

    /* renamed from: L */
    static /* synthetic */ void m25896L(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55275);
        C46078i.m85848R(new C1682111());
        AppMethodBeat.m2505o(55275);
    }

    /* renamed from: M */
    static /* synthetic */ void m25897M(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55276);
        C4990ab.m7416i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.gar != null) {
            sightCaptureUI.gar.requestFocus();
        }
        sightCaptureUI.oxL.setVisibility(0);
        sightCaptureUI.oxL.setAlpha(0.0f);
        sightCaptureUI.oxL.setVideoPath(sightCaptureUI.gLs.getFilePath());
        sightCaptureUI.oxL.setLoop(true);
        sightCaptureUI.oxL.setForceScaleFullScreen(true);
        sightCaptureUI.oxL.setVideoCallback(sightCaptureUI.oxS);
        AppMethodBeat.m2505o(55276);
    }

    /* renamed from: O */
    static /* synthetic */ void m25899O(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55277);
        if (sightCaptureUI.hGH == 1 || sightCaptureUI.hGH == 2) {
            String bPo = sightCaptureUI.oCl.bPo();
            if (!C5046bo.isNullOrNil(bPo)) {
                StringBuilder append = new StringBuilder().append(bPo + IOUtils.LINE_SEPARATOR_UNIX + String.format("CPU: cur %s max:%s", new Object[]{C45290m.m83512Lz(), C45290m.m83510Lx()})).append(IOUtils.LINE_SEPARATOR_UNIX);
                Object[] objArr = new Object[1];
                C43306k.bPR();
                objArr[0] = C43306k.bPV();
                bPo = append.append(String.format("RecorderType %s", objArr)).toString() + IOUtils.LINE_SEPARATOR_UNIX + String.format("MemoryClass: %sMB, TotalMem: %sMB", new Object[]{Integer.valueOf(((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass()), Integer.valueOf(C3475d.m5782ev(sightCaptureUI))});
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(55200);
                        C4990ab.m7417i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", bPo);
                        C43306k.bPR();
                        if (C43306k.isDebug()) {
                            TextView textView = (TextView) SightCaptureUI.this.findViewById(2131821713);
                            textView.setVisibility(0);
                            textView.setText(bPo);
                            AppMethodBeat.m2505o(55200);
                            return;
                        }
                        AppMethodBeat.m2505o(55200);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(55277);
    }

    /* renamed from: V */
    static /* synthetic */ void m25906V(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.m2504i(55278);
        try {
            Bitmap tv = C3475d.m5784tv(sightCaptureUI.gLs.getFilePath());
            if (!(tv == null || sightCaptureUI.fcY == null || Math.min(tv.getWidth(), tv.getHeight()) <= sightCaptureUI.fcY.fAf)) {
                int width = tv.getWidth();
                int height = tv.getHeight();
                int i = sightCaptureUI.fcY.fAf > 0 ? sightCaptureUI.fcY.fAf : sightCaptureUI.fcY.width;
                if (width < height) {
                    width = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i)));
                    height = i;
                } else {
                    height = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i)));
                    width = i;
                }
                C5056d.m7625a(Bitmap.createScaledBitmap(tv, height, width, true), 60, CompressFormat.JPEG, sightCaptureUI.gLs.mo14845Wy(), true);
            }
            AppMethodBeat.m2505o(55278);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "saveNewThumbAfterEdit error: %s", e.getMessage());
            AppMethodBeat.m2505o(55278);
        }
    }
}
