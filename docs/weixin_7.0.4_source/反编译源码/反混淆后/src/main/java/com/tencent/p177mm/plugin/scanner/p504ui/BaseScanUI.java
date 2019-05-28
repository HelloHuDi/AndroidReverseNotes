package com.tencent.p177mm.plugin.scanner.p504ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18330mi;
import com.tencent.p177mm.p230g.p231a.C18367ps;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C42027mk;
import com.tencent.p177mm.p230g.p231a.C6536pq;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.history.p1291ui.ScannerHistoryUI;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13163a;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.p504ui.ScanMaskView.C34838a;
import com.tencent.p177mm.plugin.scanner.p504ui.ScannerFlashSwitcher.C131452;
import com.tencent.p177mm.plugin.scanner.p504ui.ScannerFlashSwitcher.C131461;
import com.tencent.p177mm.plugin.scanner.p504ui.SelectScanModePanel.C28912a;
import com.tencent.p177mm.plugin.scanner.p740a.C21682m;
import com.tencent.p177mm.plugin.scanner.util.C21731m;
import com.tencent.p177mm.plugin.scanner.util.C28919i;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.plugin.scanner.util.C39640h;
import com.tencent.p177mm.plugin.scanner.util.C46189e;
import com.tencent.p177mm.plugin.scanner.util.C46189e.C21729a;
import com.tencent.p177mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.p177mm.plugin.scanner.util.ScanCameraLightDetector.C131721;
import com.tencent.p177mm.plugin.scanner.util.ScanCameraLightDetector.C13174a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.view.C31128d;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@C5271a(3)
@C18524i
/* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI */
public class BaseScanUI extends MMActivity implements AutoFocusCallback, PreviewCallback, SurfaceTextureListener, C13164b {
    private final Object cli = new Object();
    private int cvH = 0;
    private int[] gCr = new int[8];
    private volatile boolean lZT = false;
    private boolean oOH = false;
    private final long qaT = 150;
    private final int qaU = 2;
    private MMTextureView qaV;
    private SurfaceTexture qaW;
    private LinearLayout qaX;
    private TextView qaY;
    private FrameLayout qaZ;
    private int qbA = 0;
    private boolean qbB = true;
    private boolean qbC = false;
    private boolean qbD = false;
    private long qbE;
    private long qbF;
    private Set<Integer> qbG = new HashSet();
    private int qbH;
    private ValueAnimator qbI;
    private C4884c<C26250ui> qbJ = new C288991();
    private C1923n qbK = new C3139412();
    private C4884c<C42027mk> qbL = new C3139622();
    protected C7306ak qbM = new C131339();
    private final int qbN = 2600;
    protected C7306ak qbO = new C751216();
    protected C7306ak qbP = new C1313017();
    private C4884c qbQ = new C3140418();
    protected C7306ak qbR = new C3139819();
    protected final int qbS = 0;
    protected final int qbT = 1;
    protected final int qbU = 2;
    private C39640h qba;
    private Point qbb;
    private SelectScanModePanel qbc;
    private ScanMaskView qbd = null;
    private ScannerFlashSwitcher qbe;
    private boolean qbf = false;
    private boolean qbg = false;
    private boolean qbh = true;
    private C13163a qbi;
    private int qbj;
    private int qbk;
    private int qbl;
    private int qbm;
    private boolean qbn = true;
    private Rect qbo = new Rect();
    private TextView qbp;
    private View qbq;
    private boolean qbr = false;
    private boolean qbs = true;
    private boolean qbt = false;
    private boolean qbu = false;
    private C46189e qbv = null;
    private TranslateAnimation qbw;
    private ImageView qbx;
    private C13161i qby;
    private int qbz = 0;
    private WakeLock wakeLock = null;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$28 */
    class C375628 implements OnClickListener {
        C375628() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80942);
            BaseScanUI.this.qbB = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(80942);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$16 */
    class C751216 extends C7306ak {
        C751216() {
        }

        public final void handleMessage(Message message) {
            C39640h a;
            AppMethodBeat.m2504i(80928);
            synchronized (BaseScanUI.this.cli) {
                try {
                    a = BaseScanUI.this.qba;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(80928);
                }
            }
            if (message == null) {
                C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
            } else if (BaseScanUI.this.oOH) {
                C4990ab.m7421w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", Integer.valueOf(message.what));
                AppMethodBeat.m2505o(80928);
            } else {
                BaseScanUI.this.oOH = true;
                if (BaseScanUI.this.qby != null) {
                    if (BaseScanUI.this.qbz == message.what) {
                        BaseScanUI.this.oOH = false;
                        AppMethodBeat.m2505o(80928);
                        return;
                    }
                    BaseScanUI.this.qby.onPause();
                    if (BaseScanUI.this.qby.cgO() != null) {
                        BaseScanUI.this.qby.cgO().mo8444sI();
                    }
                    BaseScanUI.this.qby.onDestroy();
                    BaseScanUI.this.qby = null;
                }
                if (!BaseScanUI.this.qbs || BaseScanUI.this.qbh) {
                    BaseScanUI.this.qbg = false;
                } else {
                    BaseScanUI.this.qbg = true;
                }
                if (BaseScanUI.m50738E(BaseScanUI.this) && message.what != 1) {
                    Toast.makeText(BaseScanUI.this, C25738R.string.dxf, 0).show();
                    BaseScanUI.this.mo51331X(1, 0);
                    BaseScanUI.this.oOH = false;
                    AppMethodBeat.m2505o(80928);
                } else if (BaseScanUI.this.isFinishing()) {
                    C4990ab.m7421w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler is invoke after ui was destroyed, msg.what=[%s]", Integer.valueOf(message.what));
                    AppMethodBeat.m2505o(80928);
                } else {
                    if (a != null) {
                        a.mo62594Cd(message.what);
                    }
                    BaseScanUI.this.cgZ();
                    BaseScanUI.this.qbC = false;
                    BaseScanUI.this.qbz = message.what;
                    switch (message.what) {
                        case 1:
                            if (!BaseScanUI.this.qbr) {
                                BaseScanUI.this.setMMTitle((int) C25738R.string.dxo);
                                BaseScanUI.this.qby = new C16851p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 0);
                                break;
                            }
                            BaseScanUI.this.setMMTitle((int) C25738R.string.dxn);
                            BaseScanUI.this.qby = new C16851p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 1);
                            break;
                        case 2:
                            BaseScanUI.this.setMMTitle(C28923r.m45946fT(C28923r.qiQ, BaseScanUI.this.getString(C25738R.string.dxx)));
                            BaseScanUI.this.qby = new C34839k(BaseScanUI.this, BaseScanUI.this.qbb);
                            break;
                        case 3:
                            BaseScanUI.this.setMMTitle((int) C25738R.string.dxl);
                            BaseScanUI.this.qby = new C34842o(BaseScanUI.this, BaseScanUI.this.qbb);
                            if (C28923r.cio()) {
                                Intent intent = new Intent();
                                Bitmap eB = C5056d.m7662eB(BaseScanUI.this.qaV);
                                if (eB != null) {
                                    try {
                                        CompressFormat compressFormat = CompressFormat.JPEG;
                                        C43488e.cgy();
                                        C5056d.m7625a(eB, 70, compressFormat, C43488e.m77695Wd("jpg"), true);
                                        C43488e.cgy();
                                        intent.putExtra("key_first_background", C43488e.m77695Wd("jpg"));
                                    } catch (Exception e) {
                                        C4990ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "get scan ui bg failed!", new Object[0]);
                                    }
                                }
                                intent.setClass(BaseScanUI.this, ScanTranslationCaptureUI.class);
                                BaseScanUI.this.startActivity(intent);
                                BaseScanUI.this.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
                                BaseScanUI.m50735B(BaseScanUI.this);
                                break;
                            }
                            break;
                        case 4:
                            BaseScanUI.this.setMMTitle((int) C25738R.string.dxo);
                            BaseScanUI.this.qby = new C16851p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 2);
                            break;
                        case 5:
                            BaseScanUI.this.setMMTitle((int) C25738R.string.dxp);
                            BaseScanUI.this.qby = new C7067q(BaseScanUI.this, BaseScanUI.this.qbb);
                            BaseScanUI.this.qbC = true;
                            break;
                        case 8:
                            BaseScanUI.this.setMMTitle((int) C25738R.string.dxn);
                            BaseScanUI.this.qby = new C16851p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 1);
                            break;
                    }
                    if (a != null && a.isOpen() && a.lUE) {
                        a.cic();
                        a.mo62596Cf(1);
                    }
                    C21682m.pZK.reset();
                    if (!(BaseScanUI.this.qbz == 3 && C28923r.cio())) {
                        BaseScanUI.m50742I(BaseScanUI.this);
                    }
                    BaseScanUI.this.oOH = false;
                    AppMethodBeat.m2505o(80928);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$14 */
    class C1312814 implements OnClickListener {
        C1312814() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(138470);
            BaseScanUI.this.qbg = true;
            BaseScanUI.m50735B(BaseScanUI.this);
            BaseScanUI.m50736C(BaseScanUI.this);
            BaseScanUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(138470);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$15 */
    class C1312915 implements C34838a {
        C1312915() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(138471);
            C42027mk c42027mk = new C42027mk();
            c42027mk.cIp.action = 2;
            C4879a.xxA.mo10055m(c42027mk);
            AppMethodBeat.m2505o(138471);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$17 */
    class C1313017 extends C7306ak {
        C1313017() {
            AppMethodBeat.m2504i(80929);
            AppMethodBeat.m2505o(80929);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(138472);
            if (!(BaseScanUI.this.lZT || BaseScanUI.this.qba == null || !BaseScanUI.this.qbt)) {
                BaseScanUI.this.qba.mo62597a(BaseScanUI.this);
            }
            AppMethodBeat.m2505o(138472);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$21 */
    class C1313121 implements Runnable {
        C1313121() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138479);
            BaseScanUI.this.qby.onPause();
            BaseScanUI.this.che();
            AppMethodBeat.m2505o(138479);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$27 */
    class C1313227 implements OnClickListener {
        C1313227() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80941);
            BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            BaseScanUI.this.qbB = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(80941);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$9 */
    class C131339 extends C7306ak {
        C131339() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(138463);
            if (message != null && message.what == 1) {
                if (BaseScanUI.this.qbx == null || BaseScanUI.this.qbw == null || (BaseScanUI.this.qbs && !BaseScanUI.this.qbh)) {
                    AppMethodBeat.m2505o(138463);
                    return;
                } else if (BaseScanUI.this.qby == null || BaseScanUI.this.qby.cgQ() <= 0) {
                    C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
                    BaseScanUI.this.cgZ();
                    AppMethodBeat.m2505o(138463);
                    return;
                } else {
                    BaseScanUI.this.qbx.setVisibility(0);
                    BaseScanUI.this.qbw.setRepeatCount(-1);
                    BaseScanUI.this.qbw.setDuration(2600);
                    BaseScanUI.this.qbx.startAnimation(BaseScanUI.this.qbw);
                }
            }
            AppMethodBeat.m2505o(138463);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$2 */
    class C216902 implements OnClickListener {
        C216902() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80912);
            BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            BaseScanUI.this.qbC = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(80912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$1 */
    class C288991 extends C4884c<C26250ui> {
        C288991() {
            AppMethodBeat.m2504i(138459);
            this.xxI = C26250ui.class.getName().hashCode();
            AppMethodBeat.m2505o(138459);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(138460);
            C26250ui c26250ui = (C26250ui) c4883b;
            if (c26250ui instanceof C26250ui) {
                if (!C1720g.m3531RK()) {
                    AppMethodBeat.m2505o(138460);
                    return false;
                } else if (c26250ui.cQx.cAd == 3) {
                    if (BaseScanUI.this.qba != null) {
                        BaseScanUI.this.qba.stopPreview();
                        BaseScanUI.this.qba.release();
                    }
                    BaseScanUI.this.finish();
                }
            }
            AppMethodBeat.m2505o(138460);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$3 */
    class C289023 implements OnClickListener {
        C289023() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80913);
            BaseScanUI.this.qbC = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(80913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$10 */
    class C3139010 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$10$2 */
        class C313912 implements Runnable {
            C313912() {
            }

            public final void run() {
                AppMethodBeat.m2504i(138465);
                BaseScanUI.m50782y(BaseScanUI.this);
                AppMethodBeat.m2505o(138465);
            }
        }

        /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$10$1 */
        class C313921 implements Runnable {
            C313921() {
            }

            public final void run() {
                AppMethodBeat.m2504i(138464);
                BaseScanUI.m50781x(BaseScanUI.this);
                AppMethodBeat.m2505o(138464);
            }
        }

        C3139010() {
        }

        public final void run() {
            BaseScanUI baseScanUI;
            int i;
            int i2 = 1;
            AppMethodBeat.m2504i(138466);
            try {
                if (BaseScanUI.this.qba == null) {
                    C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
                    AppMethodBeat.m2505o(138466);
                    return;
                }
                if (!BaseScanUI.this.qbt) {
                    baseScanUI = BaseScanUI.this;
                }
                if (BaseScanUI.this.qba.isOpen()) {
                    C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "camera already open");
                } else {
                    synchronized (BaseScanUI.this.cli) {
                        BaseScanUI.this.qba.open();
                        C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                        BaseScanUI.m50777t(BaseScanUI.this);
                        BaseScanUI.this.qbu = false;
                    }
                }
                C5004al.m7442n(new C313912(), 50);
                BaseScanUI.this.qba.mo62607e(BaseScanUI.this.qbb);
                BaseScanUI.this.qby.mo8431kn(BaseScanUI.this.chh());
                BaseScanUI.this.qby.mo25195f(BaseScanUI.this.qba.lUF);
                if (BaseScanUI.this.qba != null && BaseScanUI.this.qba.lUE) {
                    BaseScanUI.this.mo25215jL(0);
                }
                AppMethodBeat.m2505o(138466);
            } catch (Exception e) {
                Object[] objArr = new Object[i2];
                objArr[0] = e.toString();
                C4990ab.m7421w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", objArr);
                i = "MicroMsg.scanner.BaseScanUI";
                i2 = new Object[0];
                C4990ab.printErrStackTrace(i, e, "", i2);
                BaseScanUI.this.qbA = BaseScanUI.this.qbA + 1;
                baseScanUI = BaseScanUI.this.qbA;
                if (baseScanUI >= i) {
                    BaseScanUI.m50780w(BaseScanUI.this);
                    AppMethodBeat.m2505o(138466);
                    return;
                }
                C5004al.m7442n(new C313921(), 300);
                AppMethodBeat.m2505o(138466);
            } finally {
                i = 138466;
                AppMethodBeat.m2505o(138466);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$11 */
    class C3139311 implements PreviewCallback {
        C3139311() {
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$12 */
    class C3139412 extends C1924a {
        C3139412() {
            AppMethodBeat.m2504i(80923);
            AppMethodBeat.m2505o(80923);
        }

        /* renamed from: gl */
        public final void mo5192gl(final int i) {
            AppMethodBeat.m2504i(138468);
            if (BaseScanUI.this.qbs) {
                new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(138467);
                        if (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4) {
                            if (BaseScanUI.this.qbh) {
                                AppMethodBeat.m2505o(138467);
                                return;
                            }
                            if (!(BaseScanUI.this.qbp == null || BaseScanUI.this.qbq == null)) {
                                BaseScanUI.this.qbp.setVisibility(8);
                                BaseScanUI.this.qbq.setVisibility(8);
                            }
                            BaseScanUI.this.qbh = true;
                            BaseScanUI.this.qbg = false;
                            BaseScanUI.m50762f(BaseScanUI.this);
                        } else if (BaseScanUI.this.qbh) {
                            if (!(BaseScanUI.this.qbp == null || BaseScanUI.this.qbq == null)) {
                                BaseScanUI.this.qbp.setText(C25738R.string.dy9);
                                BaseScanUI.this.qbq.setVisibility(0);
                                BaseScanUI.this.qbp.setVisibility(0);
                            }
                            if (!(BaseScanUI.this.lZT || BaseScanUI.this.qba == null || !BaseScanUI.this.qba.otY)) {
                                BaseScanUI.this.qba.bPs();
                            }
                            if (BaseScanUI.this.qbe != null) {
                                BaseScanUI.this.qbe.chJ();
                                BaseScanUI.this.qbe.hide();
                            }
                            BaseScanUI.this.qbh = false;
                            BaseScanUI.this.qbg = true;
                            BaseScanUI.this.cgZ();
                        } else {
                            AppMethodBeat.m2505o(138467);
                            return;
                        }
                        if (BaseScanUI.this.qby != null) {
                            BaseScanUI.this.qby.cgN();
                        }
                        AppMethodBeat.m2505o(138467);
                    }
                });
                AppMethodBeat.m2505o(138468);
                return;
            }
            AppMethodBeat.m2505o(138468);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$13 */
    class C3139513 implements Runnable {
        C3139513() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138469);
            if (BaseScanUI.this.qba == null) {
                AppMethodBeat.m2505o(138469);
                return;
            }
            synchronized (BaseScanUI.this.cli) {
                try {
                    if (!(BaseScanUI.this.lZT || BaseScanUI.this.qba == null)) {
                        BaseScanUI.this.lZT = true;
                        C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "closeCamera");
                        BaseScanUI.this.qba.release();
                        BaseScanUI.this.qba = null;
                        BaseScanUI.this.lZT = false;
                        C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(138469);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$22 */
    class C3139622 extends C4884c<C42027mk> {
        C3139622() {
            AppMethodBeat.m2504i(138480);
            this.xxI = C42027mk.class.getName().hashCode();
            AppMethodBeat.m2505o(138480);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(138481);
            C42027mk c42027mk = (C42027mk) c4883b;
            if (c42027mk.cIp.action == 1) {
                C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "receive play scan rect scale anim event");
                if (BaseScanUI.this.qbz == 3) {
                    BaseScanUI.this.che();
                    BaseScanUI.this.qby.onPause();
                    BaseScanUI.this.qbI.start();
                }
            } else if (c42027mk.cIp.action == 3) {
                C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "receive play close translate anim event");
                if (BaseScanUI.this.qbz == 3) {
                    BaseScanUI.this.mo51331X(1, 0);
                    BaseScanUI.this.qbI.reverse();
                }
                AppMethodBeat.m2505o(138481);
                return true;
            }
            AppMethodBeat.m2505o(138481);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$25 */
    class C3139725 implements AnimatorUpdateListener {
        C3139725() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(138484);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseScanUI.this.qbc.setTranslationY(((float) BaseScanUI.this.qbc.getHeight()) * floatValue);
            BaseScanUI.this.getSupportActionBar().getCustomView().setTranslationY((-floatValue) * ((float) BaseScanUI.this.getSupportActionBar().getHeight()));
            AppMethodBeat.m2505o(138484);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$19 */
    class C3139819 extends C7306ak {
        C3139819() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(138475);
            if (BaseScanUI.this.qba != null && BaseScanUI.this.qbt && !BaseScanUI.this.qbg && message.what == 0) {
                BaseScanUI.this.qbF = System.currentTimeMillis();
                C39640h a = BaseScanUI.this.qba;
                BaseScanUI baseScanUI = BaseScanUI.this;
                if (a.erH != null && a.lUE) {
                    try {
                        a.cib();
                        a.erH.autoFocus(baseScanUI);
                        AppMethodBeat.m2505o(138475);
                        return;
                    } catch (RuntimeException e) {
                        C4990ab.m7420w("MicroMsg.scanner.ScanCamera", "autoFocus() " + e.getMessage());
                    }
                }
            }
            AppMethodBeat.m2505o(138475);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$23 */
    class C3139923 implements View.OnClickListener {
        C3139923() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138482);
            BaseScanUI.m50769l(BaseScanUI.this);
            AppMethodBeat.m2505o(138482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$26 */
    class C3140026 implements C28912a {
        C3140026() {
        }

        /* renamed from: BX */
        public final void mo47027BX(int i) {
            AppMethodBeat.m2504i(138485);
            BaseScanUI.this.qbG.remove(Integer.valueOf(i));
            if (i == 3) {
                C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SCAN_OCR_ENTRY_RED_DOT_STRING_SYNC);
                C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, false);
            }
            BaseScanUI.this.qbc.setShowRedDotModes(BaseScanUI.this.qbG);
            BaseScanUI.this.mo51331X(i, 50);
            AppMethodBeat.m2505o(138485);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$4 */
    class C314014 implements OnClickListener {
        C314014() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80914);
            BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            BaseScanUI.this.qbB = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(80914);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$6 */
    class C314026 implements OnClickListener {
        C314026() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80916);
            BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            BaseScanUI.this.qbC = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(80916);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$8 */
    class C314038 implements View.OnClickListener {
        C314038() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138462);
            if (BaseScanUI.this.qba != null) {
                C21682m.pZK.mo37153BV(2);
                if (BaseScanUI.this.qba.otY) {
                    BaseScanUI.this.qba.bPs();
                    BaseScanUI.this.qbe.chJ();
                } else {
                    C39640h a = BaseScanUI.this.qba;
                    C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "openFlash, camera: %s, isPreviewing: %s", a.erH, Boolean.valueOf(a.lUE));
                    if (a.erH != null && a.lUE) {
                        try {
                            a.otY = true;
                            Parameters parameters = a.erH.getParameters();
                            if (C5046bo.m7548ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                                C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
                            } else {
                                parameters.setFlashMode("torch");
                                a.erH.setParameters(parameters);
                                C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "open flash");
                            }
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "openFlash error: %s", e.getMessage());
                        }
                    }
                    ScannerFlashSwitcher h = BaseScanUI.this.qbe;
                    C4990ab.m7416i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
                    h.qgm.setImageResource(C1318a.scanner_flash_open_on);
                    AppMethodBeat.m2505o(138462);
                    return;
                }
            }
            AppMethodBeat.m2505o(138462);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$18 */
    class C3140418 extends C4884c<C6536pq> {
        C3140418() {
            AppMethodBeat.m2504i(138473);
            this.xxI = C6536pq.class.getName().hashCode();
            AppMethodBeat.m2505o(138473);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(138474);
            C6536pq c6536pq = (C6536pq) c4883b;
            if (BaseScanUI.this.qba != null && BaseScanUI.this.qba.lUE && BaseScanUI.this.qbh) {
                if (c6536pq.cLQ.cLR) {
                    String focusMode = BaseScanUI.this.qba.getFocusMode();
                    if (!C5046bo.isNullOrNil(focusMode) && focusMode.equals("continuous-video")) {
                        BaseScanUI.this.qbH = BaseScanUI.this.qbH + 1;
                        if (BaseScanUI.this.qbH >= 2) {
                            BaseScanUI.this.qbH = 0;
                        }
                    }
                    if (!(BaseScanUI.this.qbe == null || BaseScanUI.this.qbe.isShown())) {
                        ScannerFlashSwitcher h = BaseScanUI.this.qbe;
                        C4990ab.m7417i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", Boolean.valueOf(h.qgo));
                        if (h.qgo) {
                            h.qgm.setAlpha(0.0f);
                            h.qgn.setAlpha(0.0f);
                            h.setVisibility(0);
                            h.qgn.animate().alpha(1.0f).setListener(null).setDuration(500);
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                            ofFloat.addUpdateListener(new C131461());
                            ofFloat.setRepeatCount(3);
                            ofFloat.setRepeatMode(2);
                            ofFloat.setDuration(500);
                            ofFloat.addListener(new C131452());
                            ofFloat.start();
                            h.qgo = false;
                        } else {
                            h.setVisibility(0);
                            h.qgn.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                            h.qgm.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                        }
                        h.setEnabled(true);
                        C21682m.pZK.mo37153BV(1);
                        if (BaseScanUI.this.qby != null) {
                            BaseScanUI.this.qby.mo25199ko(false);
                        }
                    }
                } else {
                    BaseScanUI.this.qbH = 0;
                    if (!(BaseScanUI.this.qbe == null || BaseScanUI.this.qba.otY)) {
                        BaseScanUI.this.qbe.hide();
                        if (BaseScanUI.this.qby != null) {
                            BaseScanUI.this.qby.mo25199ko(true);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(138474);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$24 */
    class C3140524 implements OnMenuItemClickListener {
        C3140524() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(138483);
            BaseScanUI.m50769l(BaseScanUI.this);
            AppMethodBeat.m2505o(138483);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$5 */
    class C314065 implements OnClickListener {
        C314065() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80915);
            BaseScanUI.this.qbB = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(80915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$7 */
    class C314077 implements OnClickListener {
        C314077() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(138461);
            BaseScanUI.this.qbC = true;
            BaseScanUI.this.finish();
            AppMethodBeat.m2505o(138461);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BaseScanUI() {
        AppMethodBeat.m2504i(80943);
        AppMethodBeat.m2505o(80943);
    }

    /* renamed from: B */
    static /* synthetic */ void m50735B(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80996);
        baseScanUI.btW();
        AppMethodBeat.m2505o(80996);
    }

    /* renamed from: C */
    static /* synthetic */ void m50736C(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80997);
        baseScanUI.bwV();
        AppMethodBeat.m2505o(80997);
    }

    /* renamed from: E */
    static /* synthetic */ boolean m50738E(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80998);
        boolean Lt = baseScanUI.m50746Lt();
        AppMethodBeat.m2505o(80998);
        return Lt;
    }

    /* renamed from: I */
    static /* synthetic */ void m50742I(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80999);
        baseScanUI.cgW();
        AppMethodBeat.m2505o(80999);
    }

    /* renamed from: f */
    static /* synthetic */ void m50762f(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(138486);
        baseScanUI.m50760e(true, 0);
        AppMethodBeat.m2505o(138486);
    }

    /* renamed from: t */
    static /* synthetic */ void m50777t(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80992);
        baseScanUI.chc();
        AppMethodBeat.m2505o(80992);
    }

    /* renamed from: w */
    static /* synthetic */ void m50780w(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80993);
        baseScanUI.chd();
        AppMethodBeat.m2505o(80993);
    }

    /* renamed from: x */
    static /* synthetic */ void m50781x(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80994);
        baseScanUI.chb();
        AppMethodBeat.m2505o(80994);
    }

    /* renamed from: y */
    static /* synthetic */ void m50782y(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80995);
        baseScanUI.startPreview();
        AppMethodBeat.m2505o(80995);
    }

    public View findViewById(int i) {
        AppMethodBeat.m2504i(80944);
        View findViewById = super.findViewById(i);
        AppMethodBeat.m2505o(80944);
        return findViewById;
    }

    public final int getLayoutId() {
        AppMethodBeat.m2504i(80945);
        if (m50746Lt()) {
            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
            AppMethodBeat.m2505o(80945);
            return 2130970541;
        }
        C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
        AppMethodBeat.m2505o(80945);
        return 2130970540;
    }

    public final int getForceOrientation() {
        AppMethodBeat.m2504i(80946);
        if (m50746Lt()) {
            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
            AppMethodBeat.m2505o(80946);
            return 0;
        }
        C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
        AppMethodBeat.m2505o(80946);
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(80947);
        this.qbz = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        this.ylm = true;
        super.onCreate(bundle);
        C5536q.initLanguage(this);
        getWindow().addFlags(2097280);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        if (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4) {
            this.qbh = true;
        } else {
            this.qbh = false;
        }
        if (7 == this.qbz || 11 == this.qbz) {
            this.qbs = false;
        }
        C4879a.xxA.mo10052c(this.qbQ);
        C4879a.xxA.mo10052c(this.qbL);
        initView();
        this.qbE = System.currentTimeMillis();
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qia;
        try {
            scanCameraLightDetector.qie = C7305d.anM("ScanCameraLightDetector_detectThread");
            scanCameraLightDetector.qie.start();
            scanCameraLightDetector.handler = new C131721(scanCameraLightDetector.qie.getLooper());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "start error: %s", e.getMessage());
        }
        C4990ab.m7417i("MicroMsg.ScanCameraLightDetector", "start, sensorManager: %s, lightSensor: %s, isRegister: %s", scanCameraLightDetector.sensorManager, scanCameraLightDetector.qic, Boolean.valueOf(scanCameraLightDetector.qid));
        this.qbE = System.currentTimeMillis();
        C4879a.xxA.mo10052c(this.qbJ);
        AppMethodBeat.m2505o(80947);
    }

    public final void initView() {
        Button button;
        AppMethodBeat.m2504i(80948);
        if (m50746Lt()) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.mController.hideTitleView();
            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
        }
        this.qbq = findViewById(2131827193);
        this.qbp = (TextView) findViewById(2131827194);
        this.qaX = (LinearLayout) findViewById(2131827204);
        this.qaY = (TextView) findViewById(2131827205);
        this.qaZ = (FrameLayout) findViewById(2131827192);
        this.qbe = (ScannerFlashSwitcher) findViewById(2131827196);
        this.qaV = (MMTextureView) findViewById(2131827191);
        this.qaV.setOpaque(false);
        this.qaV.setSurfaceTextureListener(this);
        if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz) {
            button = (Button) findViewById(2131827206);
            button.setVisibility(0);
            findViewById(2131827198).setVisibility(8);
            findViewById(2131827201).setVisibility(8);
            if (9 == this.qbz || 10 == this.qbz) {
                LayoutParams layoutParams = button.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    button.setLayoutParams(marginLayoutParams);
                }
            }
        } else {
            button = (Button) findViewById(2131827202);
        }
        if (button != null) {
            button.setOnClickListener(new C3139923());
        } else {
            setBackBtn(new C3140524());
        }
        this.qbx = (ImageView) findViewById(2131827195);
        this.cvH = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        this.qbc = (SelectScanModePanel) findViewById(2131827197);
        this.qaZ.setVisibility(0);
        if (!(7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz || !m50746Lt())) {
            this.qbz = 1;
            this.qbr = true;
        }
        int[] intArrayExtra = getIntent().getIntArrayExtra("key_support_scan_code_type");
        Set hashSet = new HashSet();
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf : intArrayExtra) {
                hashSet.add(Integer.valueOf(valueOf));
            }
        }
        chf();
        setMMSubTitle(null);
        DisplayMetrics displayMetrics;
        if (this.qbz == 2) {
            this.qby = new C34839k(this, this.qbb);
            setMMTitle(C28923r.m45946fT(C28923r.qiQ, getString(C25738R.string.dxx)));
        } else if (this.qbz == 5) {
            this.qby = new C7067q(this, this.qbb);
            setMMTitle((int) C25738R.string.dxp);
            this.qbC = true;
        } else if (this.qbz == 3) {
            this.qby = new C34842o(this, this.qbb);
            setMMTitle((int) C25738R.string.dxl);
        } else if (this.qbz == 4 && !m50746Lt()) {
            if (hashSet.isEmpty()) {
                this.qby = new C16851p((C13164b) this, this.qbb, this.cvH, 2);
            } else {
                this.qby = new C16851p((C13164b) this, this.qbb, this.cvH, hashSet);
            }
            ((C16851p) this.qby).qfn = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.qbc.setVisibility(8);
            setMMTitle((int) C25738R.string.dxq);
        } else if (this.qbz == 8) {
            if (hashSet.isEmpty()) {
                this.qby = new C16851p((C13164b) this, this.qbb, this.cvH, 1);
            } else {
                this.qby = new C16851p((C13164b) this, this.qbb, this.cvH, hashSet);
            }
            ((C16851p) this.qby).qfn = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.qbc.setVisibility(8);
            setMMTitle((int) C25738R.string.dxn);
        } else if (7 == this.qbz) {
            boolean z;
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new C3764j(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            C3764j c3764j = (C3764j) this.qby;
            if (getIntent() == null || !getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false)) {
                z = false;
            } else {
                z = true;
            }
            c3764j.qeB = z;
            setMMTitle((int) C25738R.string.dxg);
            this.qbc.setVisibility(8);
        } else if (9 == this.qbz) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new C34841m(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle((int) C25738R.string.dxi);
            this.qbc.setVisibility(8);
        } else if (10 == this.qbz) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new C34840l(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle((int) C25738R.string.dxh);
            this.qbc.setVisibility(8);
        } else if (11 == this.qbz) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new C36805n(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle((int) C25738R.string.dxj);
            this.qbc.setVisibility(8);
        } else {
            this.qbz = 1;
            if (hashSet.isEmpty()) {
                this.qby = new C16851p((C13164b) this, this.qbb, this.cvH, m50746Lt() ? 1 : 0);
            } else {
                this.qby = new C16851p((C13164b) this, this.qbb, this.cvH, hashSet);
            }
            ((C16851p) this.qby).qfn = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            if (C17950b.ahO()) {
                this.qbr = true;
                if (C28923r.cio()) {
                    this.qbc.setDisplayModes(new int[]{1, 3});
                    this.qbc.setVisibility(0);
                } else {
                    this.qbc.setVisibility(8);
                }
            } else if (getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false)) {
                this.qbr = false;
                this.qbc.setVisibility(8);
            }
            if (this.qbr) {
                setMMTitle((int) C25738R.string.dxn);
            } else {
                setMMTitle((int) C25738R.string.dxo);
            }
        }
        if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SCAN_OCR_ENTRY_RED_DOT_STRING_SYNC)) {
            this.qbG.add(Integer.valueOf(3));
        }
        this.qbn = this.qby.cgS();
        this.qbx.setBackgroundResource(this.qbn ? C25738R.drawable.amd : C25738R.drawable.ame);
        cgV();
        if (this.qba != null) {
            this.qba.mo62594Cd(this.qbz);
        }
        cgW();
        this.qbI = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qbI.addUpdateListener(new C3139725());
        this.qbI.setDuration(300);
        mo17446xE(getResources().getColor(C25738R.color.a3p));
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", Integer.valueOf(this.cvH), Integer.valueOf(this.qbz));
        AppMethodBeat.m2505o(80948);
    }

    private void cgV() {
        AppMethodBeat.m2504i(80949);
        if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz) {
            AppMethodBeat.m2505o(80949);
            return;
        }
        this.qbc.setShowRedDotModes(this.qbG);
        this.qbc.setSelectedMode(this.qbz);
        this.qbc.setOnGridItemClickCallback(new C3140026());
        AppMethodBeat.m2505o(80949);
    }

    private void cgW() {
        AppMethodBeat.m2504i(80950);
        if (this.qby == null) {
            AppMethodBeat.m2505o(80950);
            return;
        }
        che();
        AppMethodBeat.m2505o(80950);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(80951);
        if (i == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
            this.qbg = true;
            bwV();
            overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(80951);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(80951);
        return onKeyDown;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        int i;
        boolean z;
        C21731m c21731m;
        AppMethodBeat.m2504i(80952);
        super.onResume();
        if (!this.qbD) {
            C45287c.aNX();
            this.qbD = true;
        }
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "should check camera %s, location %s", Boolean.valueOf(this.qbB), Boolean.valueOf(this.qbC));
        if (this.qbB || this.qbC) {
            if (this.qbB) {
                C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 16, null, null)));
                if (!C35805b.m58707a(this, "android.permission.CAMERA", 16, null, null)) {
                    i = 0;
                    if (i != 0) {
                        if (!C37657b.m63681Mj()) {
                            C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C1313227(), new C375628());
                        } else if (this.qbz != 5 || C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                            if (!this.qbs || this.qbh) {
                                this.qbg = false;
                                m50760e(false, 0);
                            } else {
                                this.qbg = true;
                                cgZ();
                            }
                            this.qbu = false;
                            synchronized (this.cli) {
                                try {
                                    C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
                                    int i2 = this.qbz;
                                    if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    this.qba = new C39640h(this, i2, z);
                                    chb();
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.m2505o(80952);
                                    }
                                }
                            }
                            if (!(this.qbz == 3 && C28923r.cio())) {
                                if (this.qby.cgO() != null) {
                                    this.qby.cgO().chP();
                                }
                                this.qby.onResume();
                            }
                            if (this.wakeLock == null) {
                                this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
                                this.wakeLock.acquire();
                            }
                            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
                            if (this.qbs) {
                                C1720g.m3535RO().mo5187a(this.qbK);
                            }
                            if (this.qbv != null) {
                                this.qbv.onResume();
                            }
                        } else {
                            C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C216902(), new C289023());
                        }
                    }
                    if (!this.qbg && (this.qbz == 1 || this.qbz == 8 || this.qbz == 4)) {
                        C21682m.pZK.reset();
                        C21682m.pZK.mo37152BU(C21682m.pZH);
                    }
                    c21731m = C21731m.qiz;
                    C4990ab.m7416i("MicroMsg.ScanStableDetector", "start detect scan stable");
                    if (c21731m.bCW != null) {
                        c21731m.qix = 0;
                        c21731m.qiw[0] = 0.0f;
                        c21731m.qiw[1] = 0.0f;
                        c21731m.qiw[2] = 0.0f;
                        C4990ab.m7416i("MicroMsg.ScanStableDetector", "register accelerate listener");
                        c21731m.bCW.registerListener(c21731m, c21731m.qiv, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
                    }
                    AppMethodBeat.m2505o(80952);
                }
            }
            if (this.qbC) {
                C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null)));
                if (!C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null)) {
                    i = 0;
                    if (i != 0) {
                    }
                    C21682m.pZK.reset();
                    C21682m.pZK.mo37152BU(C21682m.pZH);
                    c21731m = C21731m.qiz;
                    C4990ab.m7416i("MicroMsg.ScanStableDetector", "start detect scan stable");
                    if (c21731m.bCW != null) {
                    }
                    AppMethodBeat.m2505o(80952);
                }
            }
        }
        z = true;
        if (i != 0) {
        }
        C21682m.pZK.reset();
        C21682m.pZK.mo37152BU(C21682m.pZH);
        c21731m = C21731m.qiz;
        C4990ab.m7416i("MicroMsg.ScanStableDetector", "start detect scan stable");
        if (c21731m.bCW != null) {
        }
        AppMethodBeat.m2505o(80952);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(80953);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(80953);
            return;
        }
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.qbB = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C314014(), new C314065());
                    AppMethodBeat.m2505o(80953);
                    return;
                }
            case 76:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.qbC = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C314026(), new C314077());
                    break;
                }
        }
        AppMethodBeat.m2505o(80953);
    }

    public void onPause() {
        AppMethodBeat.m2504i(80954);
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", this.qby, this.qbv);
        this.qbg = true;
        C21731m.qiz.stop();
        if (this.qby != null) {
            this.qby.onPause();
            if (this.qby.cgO() != null) {
                this.qby.cgO().mo8444sI();
            }
        }
        if (this.qba != null) {
            String focusMode = this.qba.getFocusMode();
            if (C5046bo.isNullOrNil(focusMode) || !focusMode.equals("continuous-video")) {
                this.gCr[2] = 0;
            } else {
                this.gCr[2] = 1;
            }
        }
        btW();
        if (this.qbe != null) {
            this.qbe.chJ();
            this.qbe.hide();
        }
        if (this.wakeLock != null && this.wakeLock.isHeld()) {
            this.wakeLock.release();
            this.wakeLock = null;
        }
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        C1720g.m3535RO().mo5188b(this.qbK);
        if (this.qbv != null) {
            this.qbv.onPause();
        }
        if (this.qbz == 1 || this.qbz == 8 || this.qbz == 4) {
            C21682m.pZK.bHT();
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.qbE);
            C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "scan cost time:".concat(String.valueOf(currentTimeMillis)));
            if (C21682m.pZK.pZM) {
                this.gCr[0] = 1;
            } else {
                this.gCr[0] = 0;
            }
            this.gCr[1] = currentTimeMillis;
            this.gCr[3] = C21682m.pZK.pZN;
            if (C21731m.qiz.cil() > 0) {
                this.gCr[6] = (int) (C21731m.qiz.cil() - this.qbE);
            }
            this.gCr[7] = this.qbz;
            C7060h.pYm.mo8381e(14176, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]), Integer.valueOf(this.gCr[5]), Integer.valueOf(this.gCr[6]), Integer.valueOf(this.gCr[7]));
        }
        super.onPause();
        AppMethodBeat.m2505o(80954);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(80955);
        C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
        if (this.qby != null) {
            this.qby.onDestroy();
        }
        if (this.qbd != null) {
            this.qbd.cht();
        }
        if (this.qaV != null) {
            this.qaV.setSurfaceTextureListener(null);
        }
        C4879a.xxA.mo10053d(this.qbQ);
        C4879a.xxA.mo10053d(this.qbL);
        C4879a.xxA.mo10053d(this.qbJ);
        if (this.qbv != null) {
            this.qbv.chU();
        }
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qia;
        C4990ab.m7417i("MicroMsg.ScanCameraLightDetector", "stop, isRegister: %s, sensorManager: %s, lightSensor: %s", Boolean.valueOf(scanCameraLightDetector.qid), scanCameraLightDetector.sensorManager, scanCameraLightDetector.qic);
        try {
            scanCameraLightDetector.qib = -1;
            if (scanCameraLightDetector.qie != null) {
                scanCameraLightDetector.qie.quit();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "stop error: %s", e.getMessage());
        }
        super.onDestroy();
        AppMethodBeat.m2505o(80955);
    }

    private void cgX() {
        AppMethodBeat.m2504i(80956);
        if (this.qbe != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qbe.getLayoutParams();
            if (this.qbz == 3) {
                layoutParams.topMargin = this.qbc.getTop() - C1338a.fromDPToPix(this, 70);
            } else {
                layoutParams.topMargin = this.qbo.top + (this.qbo.height() - C1338a.fromDPToPix(this, 70));
            }
            C4990ab.m7409c("MicroMsg.scanner.BaseScanUI", "initFlashSwitcher, scanMaskRect: %s, scanLineStart: %s, scanLineEnd: %s", this.qbo, Integer.valueOf(this.qbl), Integer.valueOf(this.qbm));
            this.qbe.setLayoutParams(layoutParams);
            this.qbe.setOnClickListener(new C314038());
            if (this.qba == null || !this.qba.otY) {
                this.qbe.setVisibility(8);
            } else {
                this.qbe.setVisibility(0);
                AppMethodBeat.m2505o(80956);
                return;
            }
        }
        AppMethodBeat.m2505o(80956);
    }

    private void cgY() {
        AppMethodBeat.m2504i(80957);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qbx.getLayoutParams();
        if (this.qbn) {
            layoutParams.width = this.qbj;
            layoutParams.gravity = 1;
        } else {
            layoutParams.height = this.qbk;
            layoutParams.gravity = 48;
            layoutParams.topMargin = this.qbo.top;
        }
        this.qbx.setLayoutParams(layoutParams);
        this.qbx.invalidate();
        this.qbx.setVisibility(0);
        if (this.qbn) {
            this.qbw = new TranslateAnimation(0.0f, 0.0f, (float) this.qbl, (float) this.qbm);
            AppMethodBeat.m2505o(80957);
            return;
        }
        this.qbw = new TranslateAnimation((float) this.qbl, (float) this.qbm, 0.0f, 0.0f);
        AppMethodBeat.m2505o(80957);
    }

    /* renamed from: e */
    private void m50760e(boolean z, long j) {
        AppMethodBeat.m2504i(80958);
        if (this.qbl < 0 || this.qbm <= 0 || this.qby == null || !this.qby.cgT()) {
            cgZ();
            AppMethodBeat.m2505o(80958);
            return;
        }
        if (z) {
            cgY();
        }
        this.qbM.removeMessages(1);
        if (j <= 0) {
            this.qbM.sendEmptyMessage(1);
            AppMethodBeat.m2505o(80958);
            return;
        }
        cgZ();
        this.qbM.sendEmptyMessageDelayed(1, j);
        AppMethodBeat.m2505o(80958);
    }

    public final void cgZ() {
        AppMethodBeat.m2504i(80959);
        if (!(this.qbx == null || this.qbw == null)) {
            this.qbx.setVisibility(8);
            this.qbx.clearAnimation();
            this.qbx.setAnimation(null);
        }
        AppMethodBeat.m2505o(80959);
    }

    public final void cha() {
        AppMethodBeat.m2504i(80960);
        if (!this.qbg) {
            C35988ay.m59201au(this, C25738R.string.dgc);
        }
        AppMethodBeat.m2505o(80960);
    }

    private void chb() {
        AppMethodBeat.m2504i(80961);
        C5004al.m7442n(new C3139010(), 25);
        AppMethodBeat.m2505o(80961);
    }

    private void chc() {
        AppMethodBeat.m2504i(80962);
        this.qba.mo62597a(new C3139311());
        AppMethodBeat.m2505o(80962);
    }

    private void startPreview() {
        AppMethodBeat.m2504i(80963);
        int[] e;
        try {
            if (this.lZT || this.qba == null) {
                C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in startPreview");
                AppMethodBeat.m2505o(80963);
            } else if (!this.qba.isOpen()) {
                C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "camera not open");
                AppMethodBeat.m2505o(80963);
            } else if (this.qaW == null) {
                C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "preview surface in null in startPreview");
                AppMethodBeat.m2505o(80963);
            } else if (this.qba.lUE) {
                C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "camera is previewing");
                AppMethodBeat.m2505o(80963);
            } else {
                C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "camera startPreview.");
                Object obj = this.cli;
                synchronized (obj) {
                    chc();
                    this.qba.mo62609h(this.qaW);
                    C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "camera startPreview. done");
                    e = this.gCr;
                    if (e == null && this.qba.getFocusMode().equals("continuous-video")) {
                        e = this.qba;
                        e.cancelAutoFocus();
                        AppMethodBeat.m2505o(80963);
                    }
                    if (C1427q.etc.ers > 0) {
                        mo25214jK((long) ((int) (((float) C1427q.etc.ers) * C1947ae.gjj)));
                    }
                    mo25215jL(0);
                    AppMethodBeat.m2505o(80963);
                }
            }
        } catch (Exception e2) {
            e = e2;
            String str = "MicroMsg.scanner.BaseScanUI";
            String str2 = "Exception in scanCamera.startPreview(), [%s]";
        } finally {
            int i = 80963;
            AppMethodBeat.m2505o(80963);
        }
    }

    private void btW() {
        AppMethodBeat.m2504i(80964);
        C7305d.post(new C3139513(), "BaseScanUI_closeCamera");
        AppMethodBeat.m2505o(80964);
    }

    private void chd() {
        AppMethodBeat.m2504i(80965);
        if (this.qbf) {
            AppMethodBeat.m2505o(80965);
            return;
        }
        this.qbf = true;
        mo25216kj(true);
        C18330mi c18330mi = new C18330mi();
        c18330mi.cIm.type = 2;
        C4879a.xxA.mo10055m(c18330mi);
        if (c18330mi.cIn.cIl) {
            C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
            this.qbg = true;
            btW();
            bwV();
            overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(80965);
            return;
        }
        C5653c a = C30379h.m48438a((Context) this, getString(C25738R.string.dya), getString(C25738R.string.f9238tz), new C1312814());
        if (a == null) {
            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
            AppMethodBeat.m2505o(80965);
            return;
        }
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        a.show();
        AppMethodBeat.m2505o(80965);
    }

    public final void che() {
        AppMethodBeat.m2504i(80966);
        try {
            chf();
            if (this.qby == null) {
                C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
                AppMethodBeat.m2505o(80966);
                return;
            }
            this.qby.mo25194e(this.qbb);
            Rect H = this.qby.mo25189H(true, m50746Lt());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(H.width(), H.height(), 3);
            layoutParams.leftMargin = H.left;
            layoutParams.topMargin = H.top;
            this.qbj = H.width();
            this.qbk = H.height();
            C4990ab.m7411d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s]", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(this.qbj), Integer.valueOf(this.qbk));
            H = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + this.qbj, layoutParams.topMargin + this.qbk);
            if (this.qbb.x - H.right < H.left) {
                C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "this is a special device");
                if (this.qbb.x - H.left > H.left) {
                    H.right = this.qbb.x - H.left;
                }
            }
            if (this.qbd != null) {
                Rect maskRect = this.qbd.getMaskRect();
                this.qbd.cht();
                this.qbd = new ScanMaskView((Context) this, maskRect);
            } else {
                this.qbd = new ScanMaskView((Context) this, H);
            }
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.qbd.setLayoutParams(layoutParams);
            if (this.qbz == 3 && C28923r.cio()) {
                this.qbd.setMaskAnimaListener(new C1312915());
            }
            this.qaZ.removeAllViews();
            View.inflate(this, this.qby.cgP(), this.qaZ);
            this.qby.mo25192dw(this.qaZ.getChildAt(0));
            this.qby.cgR();
            this.qby.mo25193dx(this.qaZ);
            this.qaZ.addView(this.qbd, 0, layoutParams);
            this.qbd.mo55443k(H);
            this.qby.mo8429j(H);
            this.qbd.setBackgroundColor(0);
            C4990ab.m7411d("MicroMsg.scanner.BaseScanUI", "newRect = %s", H);
            if (this.qbn) {
                this.qbl = H.top;
                this.qbm = H.bottom - C4977b.m7371b((Context) this, 8.0f);
                this.qbo = H;
            } else {
                this.qbl = H.left;
                this.qbm = H.right - C4977b.m7371b((Context) this, 8.0f);
                this.qbo = H;
            }
            cgX();
            if (!this.qbs || this.qbh) {
                m50760e(true, ((long) this.qbd.getMaskAnimDuration()) + 150);
                if (!(this.qbp == null || this.qbq == null)) {
                    this.qbp.setVisibility(8);
                    this.qbq.setVisibility(8);
                }
            } else if (!(this.qbp == null || this.qbq == null)) {
                this.qbp.setText(C25738R.string.dy9);
                this.qbq.setVisibility(0);
                this.qbp.setVisibility(0);
            }
            if (this.qba != null && this.qba.isOpen()) {
                this.qba.mo62607e(this.qbb);
                this.qby.mo8431kn(chh());
                this.qby.mo25195f(this.qba.lUF);
            }
            AppMethodBeat.m2505o(80966);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(80966);
        }
    }

    public void onStart() {
        AppMethodBeat.m2504i(80967);
        super.onStart();
        AppMethodBeat.m2505o(80967);
    }

    private void chf() {
        AppMethodBeat.m2504i(80968);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.qbb = new Point(rect.width(), rect.height());
        C4990ab.m7411d("MicroMsg.scanner.BaseScanUI", "update visible rect:%s", this.qbb);
        AppMethodBeat.m2505o(80968);
    }

    /* renamed from: X */
    public final void mo51331X(int i, long j) {
        AppMethodBeat.m2504i(80969);
        this.qbO.removeMessages(0);
        this.qbO.sendEmptyMessageDelayed(i, j);
        this.qbc.setSelectedMode(i);
        AppMethodBeat.m2505o(80969);
    }

    /* renamed from: jK */
    public final void mo25214jK(long j) {
        AppMethodBeat.m2504i(80970);
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", Long.valueOf(j));
        this.qbP.removeMessages(0);
        if (this.qbg) {
            C4990ab.m7420w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
            AppMethodBeat.m2505o(80970);
            return;
        }
        this.qbP.sendEmptyMessageDelayed(0, j);
        AppMethodBeat.m2505o(80970);
    }

    /* renamed from: jL */
    public final void mo25215jL(long j) {
        AppMethodBeat.m2504i(80971);
        if (!(this.qba == null || this.qbg || !this.qba.lUE)) {
            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "focus delay:".concat(String.valueOf(j)));
            String focusMode = this.qba.getFocusMode();
            if (C5046bo.isNullOrNil(focusMode) || !focusMode.equals("continuous-video")) {
                this.qbR.removeMessages(0);
                this.qbR.sendEmptyMessageDelayed(0, j);
            } else {
                mo25214jK(0);
                AppMethodBeat.m2505o(80971);
                return;
            }
        }
        AppMethodBeat.m2505o(80971);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.m2504i(80972);
        String str = "MicroMsg.scanner.BaseScanUI";
        String str2 = "onPreviewFrame, data==null: %s, camera: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr == null);
        objArr[1] = camera;
        C4990ab.m7417i(str, str2, objArr);
        if (this.qbg || this.qby == null || this.qby.cgO() == null || this.qby.mo25189H(false, m50746Lt()) == null) {
            C4990ab.m7421w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", Boolean.valueOf(this.qbg));
            AppMethodBeat.m2505o(80972);
        } else if (bArr == null || bArr.length <= 0) {
            str = "MicroMsg.scanner.BaseScanUI";
            str2 = "onPreviewFrame, wrong data, data is null [%s]";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            C4990ab.m7413e(str, str2, objArr);
            chd();
            AppMethodBeat.m2505o(80972);
        } else if (this.qba == null) {
            C4990ab.m7412e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
            AppMethodBeat.m2505o(80972);
        } else {
            try {
                int i;
                if (this.qba != null) {
                    Object obj;
                    C39640h c39640h = this.qba;
                    if (c39640h.qhV < 0) {
                        c39640h.qhV = c39640h.cif() ? 1 : 0;
                    }
                    if (c39640h.qhV == 1) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (!(obj == null || this.qba.otY || !this.qbh)) {
                        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qia;
                        int i2 = this.qba.lUF.x;
                        i = this.qba.lUF.y;
                        if (scanCameraLightDetector.qib < 0 || (C5046bo.m7525az(scanCameraLightDetector.qib) >= 1000 && scanCameraLightDetector.handler != null && scanCameraLightDetector.qie != null && scanCameraLightDetector.qie.isAlive())) {
                            C13174a c13174a = new C13174a(scanCameraLightDetector, (byte) 0);
                            c13174a.ovq = bArr;
                            c13174a.width = i2;
                            c13174a.height = i;
                            Message obtain = Message.obtain();
                            obtain.what = C31128d.MIC_PTU_MEISHI;
                            obtain.obj = c13174a;
                            scanCameraLightDetector.handler.sendMessage(obtain);
                            scanCameraLightDetector.qib = C5046bo.m7588yz();
                        }
                    }
                }
                if (!(this.qba == null || this.qbg)) {
                    C13161i c13161i = this.qby;
                    Point point = this.qba.lUF;
                    i = this.qba.lUJ;
                    C39640h c39640h2 = this.qba;
                    Rect km = this.qby.mo25198km(m50746Lt());
                    int i3 = this.qbz;
                    Rect rect = new Rect();
                    C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "frame rect:%s, visibleResolution:%s, cameraResolution %s", km, c39640h2.lUH, c39640h2.lUF);
                    if (!c39640h2.lUI || c39640h2.qhS) {
                        rect.left = (int) (((float) km.left) * c39640h2.chX());
                        rect.right = (int) (((float) km.right) * c39640h2.chX());
                        rect.top = (int) (((float) km.top) * c39640h2.chY());
                        rect.bottom = (int) (((float) km.bottom) * c39640h2.chY());
                        if (rect.bottom > c39640h2.lUF.y) {
                            rect.bottom = c39640h2.lUF.y;
                        }
                        if (rect.right > c39640h2.lUF.x) {
                            rect.right = c39640h2.lUF.x;
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.scanner.ScanCamera", ", needRotate = " + c39640h2.lUI + " needLandscape = " + c39640h2.qhS);
                        rect.top = (c39640h2.lUF.x - ((int) (((float) km.height()) * c39640h2.chY()))) / 2;
                        rect.bottom = c39640h2.lUF.x - rect.top;
                        rect.left = (c39640h2.lUF.y - ((int) (((float) km.width()) * c39640h2.chX()))) / 2;
                        rect.right = c39640h2.lUF.y - rect.left;
                    }
                    if (7 == i3 || 11 == i3) {
                        int width;
                        if (!c39640h2.lUI || c39640h2.qhS) {
                            if ((((double) rect.width()) * 1.0d) / ((double) rect.height()) < 1.5859999656677246d) {
                                width = (int) (((float) rect.width()) / 1.586f);
                                rect.top = ((rect.top + rect.bottom) / 2) - (width / 2);
                                rect.bottom = width + rect.top;
                            } else {
                                width = (int) (((float) rect.height()) * 1.586f);
                                rect.left = ((rect.left + rect.right) / 2) - (width / 2);
                                rect.right = width + rect.left;
                            }
                        } else if (((float) rect.height()) / 1.586f < ((float) rect.width())) {
                            width = (int) (((float) rect.height()) / 1.586f);
                            rect.left = ((rect.left + rect.right) / 2) - (width / 2);
                            rect.right = width + rect.left;
                        } else {
                            width = (int) (((float) rect.width()) * 1.586f);
                            rect.top = ((rect.top + rect.bottom) / 2) - (width / 2);
                            rect.bottom = width + rect.top;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "resultRect %s", rect);
                    c39640h2.lQX = rect;
                    c39640h2.cib();
                    C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "scanRect:" + c39640h2.lQX);
                    c13161i.mo25190a(bArr, point, i, c39640h2.lQX);
                }
                AppMethodBeat.m2505o(80972);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "onPreviewFrame exception", new Object[0]);
                AppMethodBeat.m2505o(80972);
            }
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.m2504i(80973);
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", Boolean.valueOf(z), camera);
        this.gCr[4] = (int) (System.currentTimeMillis() - this.qbF);
        C1427q.etc.ers = (long) this.gCr[4];
        if (this.qbg) {
            AppMethodBeat.m2505o(80973);
        } else if (this.qby == null) {
            AppMethodBeat.m2505o(80973);
        } else {
            if (this.qba != null && this.qba.lUE && z) {
                mo25214jK(0);
            }
            if (this.qby.qel > 0) {
                mo25215jL(this.qby.qel);
            }
            AppMethodBeat.m2505o(80973);
        }
    }

    /* renamed from: a */
    public final void mo25202a(C13163a c13163a) {
        this.qbi = c13163a;
    }

    public final void chg() {
        AppMethodBeat.m2504i(80974);
        Intent intent = new Intent();
        intent.putExtra("preview_ui_title", C25738R.string.dys);
        C14987n.m23301a((Activity) this, 4660, intent);
        AppMethodBeat.m2505o(80974);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(80975);
        if (this.qbi != null) {
            this.qbi.mo25201c(this, i, i2, intent);
        }
        AppMethodBeat.m2505o(80975);
    }

    /* renamed from: kj */
    public final void mo25216kj(boolean z) {
        AppMethodBeat.m2504i(80976);
        this.qbg = z;
        if (z) {
            cgZ();
            if (this.qbq != null) {
                this.qbq.setVisibility(0);
                AppMethodBeat.m2505o(80976);
                return;
            }
        }
        mo25215jL(0);
        m50760e(false, 0);
        if (this.qbq != null) {
            this.qbq.setVisibility(8);
        }
        AppMethodBeat.m2505o(80976);
    }

    /* renamed from: b */
    public final void mo25205b(int i, final View.OnClickListener onClickListener) {
        AppMethodBeat.m2504i(80977);
        if (this.qaX != null) {
            if (getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
                this.qaX.setVisibility(8);
                AppMethodBeat.m2505o(80977);
                return;
            } else if (onClickListener != null) {
                this.qaX.setVisibility(i);
                this.qaX.setOnClickListener(onClickListener);
                this.qaY.setBackgroundDrawable(null);
                this.qaY.setText(getString(C25738R.string.e2f));
                AppMethodBeat.m2505o(80977);
                return;
            }
        } else if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
            if (onClickListener != null) {
                addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$20$1 */
                    class C216891 implements C36073c {
                        C216891() {
                        }

                        /* renamed from: a */
                        public final void mo5746a(C44273l c44273l) {
                            AppMethodBeat.m2504i(138476);
                            if (onClickListener != null) {
                                c44273l.mo70072hi(1, C25738R.string.e2e);
                            }
                            c44273l.mo70072hi(0, C25738R.string.f8713cu);
                            if (C28919i.cig()) {
                                c44273l.mo70072hi(2, C25738R.string.dxt);
                                C4990ab.m7416i("MicroMsg.scanner.BaseScanUI", "show history list");
                            }
                            AppMethodBeat.m2505o(138476);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.scanner.ui.BaseScanUI$20$2 */
                    class C289012 implements C5279d {
                        C289012() {
                        }

                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.m2504i(138477);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    BaseScanUI baseScanUI = BaseScanUI.this;
                                    Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                                    intent.putExtra("android.intent.extra.shortcut.NAME", baseScanUI.getString(C25738R.string.btn));
                                    intent.putExtra("duplicate", false);
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                                    intent.putExtra("shortcut_is_adaptive_icon", true);
                                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(baseScanUI, C25738R.drawable.scan_shortcut_icon));
                                    intent.putExtra("shortcut_icon_resource_id", C25738R.drawable.scan_shortcut_icon);
                                    C42781b.m75868q(baseScanUI, intent);
                                    C7060h.pYm.mo8381e(11410, new Object[0]);
                                    AppMethodBeat.m2505o(138477);
                                    return;
                                case 1:
                                    if (onClickListener != null) {
                                        onClickListener.onClick(null);
                                        AppMethodBeat.m2505o(138477);
                                        return;
                                    }
                                    break;
                                case 2:
                                    Intent intent3 = new Intent();
                                    intent3.setClass(BaseScanUI.this, ScannerHistoryUI.class);
                                    BaseScanUI.this.startActivity(intent3);
                                    C7060h.pYm.mo8381e(12684, Integer.valueOf(1), Integer.valueOf(0));
                                    break;
                            }
                            AppMethodBeat.m2505o(138477);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(138478);
                        C36356d c36356d = new C36356d(BaseScanUI.this.mController.ylL, 1, false);
                        c36356d.rBl = new C216891();
                        c36356d.rBm = new C289012();
                        c36356d.cpD();
                        AppMethodBeat.m2505o(138478);
                        return false;
                    }
                });
                AppMethodBeat.m2505o(80977);
                return;
            }
            removeOptionMenu(0);
        }
        AppMethodBeat.m2505o(80977);
    }

    public final boolean chh() {
        AppMethodBeat.m2504i(80978);
        if (this.qba == null || !this.qba.isOpen()) {
            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "scanCamera == null or scanCamera is not open, cameraNeedRotate return false");
            AppMethodBeat.m2505o(80978);
            return false;
        }
        boolean z = this.qba.lUI;
        AppMethodBeat.m2505o(80978);
        return z;
    }

    public final void chi() {
        AppMethodBeat.m2504i(80979);
        bwV();
        AppMethodBeat.m2505o(80979);
    }

    public final void chj() {
        AppMethodBeat.m2504i(80980);
        super.finish();
        AppMethodBeat.m2505o(80980);
    }

    private void bwV() {
        AppMethodBeat.m2504i(80981);
        C18367ps c18367ps = new C18367ps();
        c18367ps.cLW.bJt = 1;
        C4879a.xxA.mo10055m(c18367ps);
        setResult(0);
        finish();
        AppMethodBeat.m2505o(80981);
    }

    /* renamed from: Lt */
    private boolean m50746Lt() {
        AppMethodBeat.m2504i(80982);
        if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz || C32468d.m53154Lt()) {
            AppMethodBeat.m2505o(80982);
            return true;
        }
        AppMethodBeat.m2505o(80982);
        return false;
    }

    /* renamed from: a */
    public final void mo25203a(String str, int i, int i2, int i3, C21729a c21729a) {
        AppMethodBeat.m2504i(80983);
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s", str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.qbv != null) {
            this.qbv.chU();
        }
        Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
        this.qbv = new C46189e();
        this.qbv.mo74179a(this, str, i, i2, i3, c21729a, bundleExtra);
        if (this.qbz == 1 || this.qbz == 8 || this.qbz == 4) {
            C21682m c21682m = C21682m.pZK;
            int i4 = C21682m.pZH;
        }
        AppMethodBeat.m2505o(80983);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(80984);
        super.onConfigurationChanged(configuration);
        C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "screen orientation %d", Integer.valueOf(configuration.orientation));
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            C5004al.m7442n(new C1313121(), 100);
        }
        AppMethodBeat.m2505o(80984);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(80985);
        C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
        this.qaV.dAh();
        this.qaW = surfaceTexture;
        this.qbt = true;
        if (this.qbu) {
            chb();
            this.qbu = false;
        }
        startPreview();
        AppMethodBeat.m2505o(80985);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(80986);
        C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
        this.qaW = surfaceTexture;
        AppMethodBeat.m2505o(80986);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(80987);
        C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
        this.qbt = false;
        AppMethodBeat.m2505o(80987);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARNING: Missing block: B:31:0x0092, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(80988);
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ah */
    public final void mo25204ah(int i, int i2, int i3) {
        AppMethodBeat.m2504i(80988);
        synchronized (this.cli) {
            try {
                if (!(this.lZT || this.qba == null || !this.qba.lUE)) {
                    C4990ab.m7417i("MicroMsg.scanner.BaseScanUI", "zoom camera,action:%d,type:%d,scale:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    int cid = this.qba.cid();
                    if (this.qbz == 1 || this.qbz == 8 || this.qbz == 4) {
                        if (i2 != 1 || ((C16851p) this.qby).chy()) {
                            if (i == 6) {
                                this.qba.mo62595Ce(i3);
                            } else {
                                this.qba.mo62596Cf(i);
                            }
                            if (i2 == 2) {
                                ((C16851p) this.qby).chx();
                            }
                        } else {
                            C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "auto zoom is disable");
                        }
                    } else if (i == 6) {
                        this.qba.mo62595Ce(i3);
                    } else {
                        this.qba.mo62596Cf(i);
                    }
                    if (this.qba.cid() != cid) {
                        C21682m c21682m = C21682m.pZK;
                        this.qba.cid();
                        if (i2 == 1) {
                            c21682m.pZX |= 1;
                        } else if (i2 == 2) {
                            c21682m.pZX |= 2;
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(80988);
            }
        }
    }

    public final void chk() {
        AppMethodBeat.m2504i(80989);
        if (!(this.lZT || this.qba == null || this.qbg)) {
            String focusMode = this.qba.getFocusMode();
            if (!(C5046bo.isNullOrNil(focusMode) || focusMode.equals("auto"))) {
                C39640h c39640h = this.qba;
                try {
                    if (c39640h.erH != null && c39640h.lUE) {
                        Parameters parameters = c39640h.erH.getParameters();
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (!(supportedFocusModes == null || !supportedFocusModes.contains("auto") || C5046bo.isNullOrNil(parameters.getFocusMode()) || parameters.getFocusMode().equals("auto"))) {
                            parameters.setFocusMode("auto");
                            c39640h.erH.setParameters(parameters);
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.scanner.ScanCamera", "setFocusModeAuto %s", e.getMessage());
                }
                mo25215jL(0);
            }
        }
        AppMethodBeat.m2505o(80989);
    }

    public final /* bridge */ /* synthetic */ Activity getContext() {
        return this.mController.ylL;
    }

    /* renamed from: l */
    static /* synthetic */ void m50769l(BaseScanUI baseScanUI) {
        AppMethodBeat.m2504i(80991);
        C4990ab.m7410d("MicroMsg.scanner.BaseScanUI", "backBtn onClick");
        baseScanUI.qbg = true;
        baseScanUI.bwV();
        baseScanUI.overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(80991);
    }
}
