package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.View.OnClickListener;
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
import com.tencent.mm.R;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.q;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@a(3)
@i
public class BaseScanUI extends MMActivity implements AutoFocusCallback, PreviewCallback, SurfaceTextureListener, b {
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
    private c<ui> qbJ = new c<ui>() {
        {
            AppMethodBeat.i(138459);
            this.xxI = ui.class.getName().hashCode();
            AppMethodBeat.o(138459);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(138460);
            ui uiVar = (ui) bVar;
            if (uiVar instanceof ui) {
                if (!g.RK()) {
                    AppMethodBeat.o(138460);
                    return false;
                } else if (uiVar.cQx.cAd == 3) {
                    if (BaseScanUI.this.qba != null) {
                        BaseScanUI.this.qba.stopPreview();
                        BaseScanUI.this.qba.release();
                    }
                    BaseScanUI.this.finish();
                }
            }
            AppMethodBeat.o(138460);
            return true;
        }
    };
    private n qbK = new n.a() {
        {
            AppMethodBeat.i(80923);
            AppMethodBeat.o(80923);
        }

        public final void gl(final int i) {
            AppMethodBeat.i(138468);
            if (BaseScanUI.this.qbs) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(138467);
                        if (g.Rg().acS() == 6 || g.Rg().acS() == 4) {
                            if (BaseScanUI.this.qbh) {
                                AppMethodBeat.o(138467);
                                return;
                            }
                            if (!(BaseScanUI.this.qbp == null || BaseScanUI.this.qbq == null)) {
                                BaseScanUI.this.qbp.setVisibility(8);
                                BaseScanUI.this.qbq.setVisibility(8);
                            }
                            BaseScanUI.this.qbh = true;
                            BaseScanUI.this.qbg = false;
                            BaseScanUI.f(BaseScanUI.this);
                        } else if (BaseScanUI.this.qbh) {
                            if (!(BaseScanUI.this.qbp == null || BaseScanUI.this.qbq == null)) {
                                BaseScanUI.this.qbp.setText(R.string.dy9);
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
                            AppMethodBeat.o(138467);
                            return;
                        }
                        if (BaseScanUI.this.qby != null) {
                            BaseScanUI.this.qby.cgN();
                        }
                        AppMethodBeat.o(138467);
                    }
                });
                AppMethodBeat.o(138468);
                return;
            }
            AppMethodBeat.o(138468);
        }
    };
    private c<mk> qbL = new c<mk>() {
        {
            AppMethodBeat.i(138480);
            this.xxI = mk.class.getName().hashCode();
            AppMethodBeat.o(138480);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(138481);
            mk mkVar = (mk) bVar;
            if (mkVar.cIp.action == 1) {
                ab.i("MicroMsg.scanner.BaseScanUI", "receive play scan rect scale anim event");
                if (BaseScanUI.this.qbz == 3) {
                    BaseScanUI.this.che();
                    BaseScanUI.this.qby.onPause();
                    BaseScanUI.this.qbI.start();
                }
            } else if (mkVar.cIp.action == 3) {
                ab.i("MicroMsg.scanner.BaseScanUI", "receive play close translate anim event");
                if (BaseScanUI.this.qbz == 3) {
                    BaseScanUI.this.X(1, 0);
                    BaseScanUI.this.qbI.reverse();
                }
                AppMethodBeat.o(138481);
                return true;
            }
            AppMethodBeat.o(138481);
            return false;
        }
    };
    protected ak qbM = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(138463);
            if (message != null && message.what == 1) {
                if (BaseScanUI.this.qbx == null || BaseScanUI.this.qbw == null || (BaseScanUI.this.qbs && !BaseScanUI.this.qbh)) {
                    AppMethodBeat.o(138463);
                    return;
                } else if (BaseScanUI.this.qby == null || BaseScanUI.this.qby.cgQ() <= 0) {
                    ab.w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
                    BaseScanUI.this.cgZ();
                    AppMethodBeat.o(138463);
                    return;
                } else {
                    BaseScanUI.this.qbx.setVisibility(0);
                    BaseScanUI.this.qbw.setRepeatCount(-1);
                    BaseScanUI.this.qbw.setDuration(2600);
                    BaseScanUI.this.qbx.startAnimation(BaseScanUI.this.qbw);
                }
            }
            AppMethodBeat.o(138463);
        }
    };
    private final int qbN = 2600;
    protected ak qbO = new ak() {
        public final void handleMessage(Message message) {
            h a;
            AppMethodBeat.i(80928);
            synchronized (BaseScanUI.this.cli) {
                try {
                    a = BaseScanUI.this.qba;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(80928);
                }
            }
            if (message == null) {
                ab.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
            } else if (BaseScanUI.this.oOH) {
                ab.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", Integer.valueOf(message.what));
                AppMethodBeat.o(80928);
            } else {
                BaseScanUI.this.oOH = true;
                if (BaseScanUI.this.qby != null) {
                    if (BaseScanUI.this.qbz == message.what) {
                        BaseScanUI.this.oOH = false;
                        AppMethodBeat.o(80928);
                        return;
                    }
                    BaseScanUI.this.qby.onPause();
                    if (BaseScanUI.this.qby.cgO() != null) {
                        BaseScanUI.this.qby.cgO().sI();
                    }
                    BaseScanUI.this.qby.onDestroy();
                    BaseScanUI.this.qby = null;
                }
                if (!BaseScanUI.this.qbs || BaseScanUI.this.qbh) {
                    BaseScanUI.this.qbg = false;
                } else {
                    BaseScanUI.this.qbg = true;
                }
                if (BaseScanUI.E(BaseScanUI.this) && message.what != 1) {
                    Toast.makeText(BaseScanUI.this, R.string.dxf, 0).show();
                    BaseScanUI.this.X(1, 0);
                    BaseScanUI.this.oOH = false;
                    AppMethodBeat.o(80928);
                } else if (BaseScanUI.this.isFinishing()) {
                    ab.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler is invoke after ui was destroyed, msg.what=[%s]", Integer.valueOf(message.what));
                    AppMethodBeat.o(80928);
                } else {
                    if (a != null) {
                        a.Cd(message.what);
                    }
                    BaseScanUI.this.cgZ();
                    BaseScanUI.this.qbC = false;
                    BaseScanUI.this.qbz = message.what;
                    switch (message.what) {
                        case 1:
                            if (!BaseScanUI.this.qbr) {
                                BaseScanUI.this.setMMTitle((int) R.string.dxo);
                                BaseScanUI.this.qby = new p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 0);
                                break;
                            }
                            BaseScanUI.this.setMMTitle((int) R.string.dxn);
                            BaseScanUI.this.qby = new p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 1);
                            break;
                        case 2:
                            BaseScanUI.this.setMMTitle(r.fT(r.qiQ, BaseScanUI.this.getString(R.string.dxx)));
                            BaseScanUI.this.qby = new k(BaseScanUI.this, BaseScanUI.this.qbb);
                            break;
                        case 3:
                            BaseScanUI.this.setMMTitle((int) R.string.dxl);
                            BaseScanUI.this.qby = new o(BaseScanUI.this, BaseScanUI.this.qbb);
                            if (r.cio()) {
                                Intent intent = new Intent();
                                Bitmap eB = d.eB(BaseScanUI.this.qaV);
                                if (eB != null) {
                                    try {
                                        CompressFormat compressFormat = CompressFormat.JPEG;
                                        e.cgy();
                                        d.a(eB, 70, compressFormat, e.Wd("jpg"), true);
                                        e.cgy();
                                        intent.putExtra("key_first_background", e.Wd("jpg"));
                                    } catch (Exception e) {
                                        ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "get scan ui bg failed!", new Object[0]);
                                    }
                                }
                                intent.setClass(BaseScanUI.this, ScanTranslationCaptureUI.class);
                                BaseScanUI.this.startActivity(intent);
                                BaseScanUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                                BaseScanUI.B(BaseScanUI.this);
                                break;
                            }
                            break;
                        case 4:
                            BaseScanUI.this.setMMTitle((int) R.string.dxo);
                            BaseScanUI.this.qby = new p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 2);
                            break;
                        case 5:
                            BaseScanUI.this.setMMTitle((int) R.string.dxp);
                            BaseScanUI.this.qby = new q(BaseScanUI.this, BaseScanUI.this.qbb);
                            BaseScanUI.this.qbC = true;
                            break;
                        case 8:
                            BaseScanUI.this.setMMTitle((int) R.string.dxn);
                            BaseScanUI.this.qby = new p(BaseScanUI.this, BaseScanUI.this.qbb, BaseScanUI.this.cvH, 1);
                            break;
                    }
                    if (a != null && a.isOpen() && a.lUE) {
                        a.cic();
                        a.Cf(1);
                    }
                    m.pZK.reset();
                    if (!(BaseScanUI.this.qbz == 3 && r.cio())) {
                        BaseScanUI.I(BaseScanUI.this);
                    }
                    BaseScanUI.this.oOH = false;
                    AppMethodBeat.o(80928);
                }
            }
        }
    };
    protected ak qbP = new ak() {
        {
            AppMethodBeat.i(80929);
            AppMethodBeat.o(80929);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(138472);
            if (!(BaseScanUI.this.lZT || BaseScanUI.this.qba == null || !BaseScanUI.this.qbt)) {
                BaseScanUI.this.qba.a(BaseScanUI.this);
            }
            AppMethodBeat.o(138472);
        }
    };
    private c qbQ = new c<pq>() {
        {
            AppMethodBeat.i(138473);
            this.xxI = pq.class.getName().hashCode();
            AppMethodBeat.o(138473);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(138474);
            pq pqVar = (pq) bVar;
            if (BaseScanUI.this.qba != null && BaseScanUI.this.qba.lUE && BaseScanUI.this.qbh) {
                if (pqVar.cLQ.cLR) {
                    String focusMode = BaseScanUI.this.qba.getFocusMode();
                    if (!bo.isNullOrNil(focusMode) && focusMode.equals("continuous-video")) {
                        BaseScanUI.this.qbH = BaseScanUI.this.qbH + 1;
                        if (BaseScanUI.this.qbH >= 2) {
                            BaseScanUI.this.qbH = 0;
                        }
                    }
                    if (!(BaseScanUI.this.qbe == null || BaseScanUI.this.qbe.isShown())) {
                        ScannerFlashSwitcher h = BaseScanUI.this.qbe;
                        ab.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", Boolean.valueOf(h.qgo));
                        if (h.qgo) {
                            h.qgm.setAlpha(0.0f);
                            h.qgn.setAlpha(0.0f);
                            h.setVisibility(0);
                            h.qgn.animate().alpha(1.0f).setListener(null).setDuration(500);
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                            ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    AppMethodBeat.i(81319);
                                    ScannerFlashSwitcher.this.qgm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                    AppMethodBeat.o(81319);
                                }
                            });
                            ofFloat.setRepeatCount(3);
                            ofFloat.setRepeatMode(2);
                            ofFloat.setDuration(500);
                            ofFloat.addListener(new AnimatorListenerAdapter() {
                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(81320);
                                    ScannerFlashSwitcher.this.qgm.setAlpha(1.0f);
                                    AppMethodBeat.o(81320);
                                }
                            });
                            ofFloat.start();
                            h.qgo = false;
                        } else {
                            h.setVisibility(0);
                            h.qgn.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                            h.qgm.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                        }
                        h.setEnabled(true);
                        m.pZK.BV(1);
                        if (BaseScanUI.this.qby != null) {
                            BaseScanUI.this.qby.ko(false);
                        }
                    }
                } else {
                    BaseScanUI.this.qbH = 0;
                    if (!(BaseScanUI.this.qbe == null || BaseScanUI.this.qba.otY)) {
                        BaseScanUI.this.qbe.hide();
                        if (BaseScanUI.this.qby != null) {
                            BaseScanUI.this.qby.ko(true);
                        }
                    }
                }
            }
            AppMethodBeat.o(138474);
            return false;
        }
    };
    protected ak qbR = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(138475);
            if (BaseScanUI.this.qba != null && BaseScanUI.this.qbt && !BaseScanUI.this.qbg && message.what == 0) {
                BaseScanUI.this.qbF = System.currentTimeMillis();
                h a = BaseScanUI.this.qba;
                BaseScanUI baseScanUI = BaseScanUI.this;
                if (a.erH != null && a.lUE) {
                    try {
                        a.cib();
                        a.erH.autoFocus(baseScanUI);
                        AppMethodBeat.o(138475);
                        return;
                    } catch (RuntimeException e) {
                        ab.w("MicroMsg.scanner.ScanCamera", "autoFocus() " + e.getMessage());
                    }
                }
            }
            AppMethodBeat.o(138475);
        }
    };
    protected final int qbS = 0;
    protected final int qbT = 1;
    protected final int qbU = 2;
    private h qba;
    private Point qbb;
    private SelectScanModePanel qbc;
    private ScanMaskView qbd = null;
    private ScannerFlashSwitcher qbe;
    private boolean qbf = false;
    private boolean qbg = false;
    private boolean qbh = true;
    private i.a qbi;
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
    private com.tencent.mm.plugin.scanner.util.e qbv = null;
    private TranslateAnimation qbw;
    private ImageView qbx;
    private i qby;
    private int qbz = 0;
    private WakeLock wakeLock = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BaseScanUI() {
        AppMethodBeat.i(80943);
        AppMethodBeat.o(80943);
    }

    static /* synthetic */ void B(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80996);
        baseScanUI.btW();
        AppMethodBeat.o(80996);
    }

    static /* synthetic */ void C(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80997);
        baseScanUI.bwV();
        AppMethodBeat.o(80997);
    }

    static /* synthetic */ boolean E(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80998);
        boolean Lt = baseScanUI.Lt();
        AppMethodBeat.o(80998);
        return Lt;
    }

    static /* synthetic */ void I(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80999);
        baseScanUI.cgW();
        AppMethodBeat.o(80999);
    }

    static /* synthetic */ void f(BaseScanUI baseScanUI) {
        AppMethodBeat.i(138486);
        baseScanUI.e(true, 0);
        AppMethodBeat.o(138486);
    }

    static /* synthetic */ void t(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80992);
        baseScanUI.chc();
        AppMethodBeat.o(80992);
    }

    static /* synthetic */ void w(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80993);
        baseScanUI.chd();
        AppMethodBeat.o(80993);
    }

    static /* synthetic */ void x(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80994);
        baseScanUI.chb();
        AppMethodBeat.o(80994);
    }

    static /* synthetic */ void y(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80995);
        baseScanUI.startPreview();
        AppMethodBeat.o(80995);
    }

    public View findViewById(int i) {
        AppMethodBeat.i(80944);
        View findViewById = super.findViewById(i);
        AppMethodBeat.o(80944);
        return findViewById;
    }

    public final int getLayoutId() {
        AppMethodBeat.i(80945);
        if (Lt()) {
            ab.d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
            AppMethodBeat.o(80945);
            return R.layout.ap_;
        }
        ab.d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
        AppMethodBeat.o(80945);
        return R.layout.ap9;
    }

    public final int getForceOrientation() {
        AppMethodBeat.i(80946);
        if (Lt()) {
            ab.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
            AppMethodBeat.o(80946);
            return 0;
        }
        ab.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
        AppMethodBeat.o(80946);
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80947);
        this.qbz = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        this.ylm = true;
        super.onCreate(bundle);
        q.initLanguage(this);
        getWindow().addFlags(2097280);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        if (g.Rg().acS() == 6 || g.Rg().acS() == 4) {
            this.qbh = true;
        } else {
            this.qbh = false;
        }
        if (7 == this.qbz || 11 == this.qbz) {
            this.qbs = false;
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.qbQ);
        com.tencent.mm.sdk.b.a.xxA.c(this.qbL);
        initView();
        this.qbE = System.currentTimeMillis();
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qia;
        try {
            scanCameraLightDetector.qie = com.tencent.mm.sdk.g.d.anM("ScanCameraLightDetector_detectThread");
            scanCameraLightDetector.qie.start();
            scanCameraLightDetector.handler = new com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.AnonymousClass1(scanCameraLightDetector.qie.getLooper());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "start error: %s", e.getMessage());
        }
        ab.i("MicroMsg.ScanCameraLightDetector", "start, sensorManager: %s, lightSensor: %s, isRegister: %s", scanCameraLightDetector.sensorManager, scanCameraLightDetector.qic, Boolean.valueOf(scanCameraLightDetector.qid));
        this.qbE = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.xxA.c(this.qbJ);
        AppMethodBeat.o(80947);
    }

    public final void initView() {
        Button button;
        AppMethodBeat.i(80948);
        if (Lt()) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.mController.hideTitleView();
            ab.d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
        }
        this.qbq = findViewById(R.id.e4q);
        this.qbp = (TextView) findViewById(R.id.e4r);
        this.qaX = (LinearLayout) findViewById(R.id.e51);
        this.qaY = (TextView) findViewById(R.id.e52);
        this.qaZ = (FrameLayout) findViewById(R.id.e4p);
        this.qbe = (ScannerFlashSwitcher) findViewById(R.id.e4t);
        this.qaV = (MMTextureView) findViewById(R.id.e4o);
        this.qaV.setOpaque(false);
        this.qaV.setSurfaceTextureListener(this);
        if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz) {
            button = (Button) findViewById(R.id.e53);
            button.setVisibility(0);
            findViewById(R.id.e4v).setVisibility(8);
            findViewById(R.id.e4y).setVisibility(8);
            if (9 == this.qbz || 10 == this.qbz) {
                LayoutParams layoutParams = button.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    button.setLayoutParams(marginLayoutParams);
                }
            }
        } else {
            button = (Button) findViewById(R.id.e4z);
        }
        if (button != null) {
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(138482);
                    BaseScanUI.l(BaseScanUI.this);
                    AppMethodBeat.o(138482);
                }
            });
        } else {
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(138483);
                    BaseScanUI.l(BaseScanUI.this);
                    AppMethodBeat.o(138483);
                    return false;
                }
            });
        }
        this.qbx = (ImageView) findViewById(R.id.e4s);
        this.cvH = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        this.qbc = (SelectScanModePanel) findViewById(R.id.e4u);
        this.qaZ.setVisibility(0);
        if (!(7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz || !Lt())) {
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
            this.qby = new k(this, this.qbb);
            setMMTitle(r.fT(r.qiQ, getString(R.string.dxx)));
        } else if (this.qbz == 5) {
            this.qby = new q(this, this.qbb);
            setMMTitle((int) R.string.dxp);
            this.qbC = true;
        } else if (this.qbz == 3) {
            this.qby = new o(this, this.qbb);
            setMMTitle((int) R.string.dxl);
        } else if (this.qbz == 4 && !Lt()) {
            if (hashSet.isEmpty()) {
                this.qby = new p((b) this, this.qbb, this.cvH, 2);
            } else {
                this.qby = new p((b) this, this.qbb, this.cvH, hashSet);
            }
            ((p) this.qby).qfn = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.qbc.setVisibility(8);
            setMMTitle((int) R.string.dxq);
        } else if (this.qbz == 8) {
            if (hashSet.isEmpty()) {
                this.qby = new p((b) this, this.qbb, this.cvH, 1);
            } else {
                this.qby = new p((b) this, this.qbb, this.cvH, hashSet);
            }
            ((p) this.qby).qfn = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.qbc.setVisibility(8);
            setMMTitle((int) R.string.dxn);
        } else if (7 == this.qbz) {
            boolean z;
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new j(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            j jVar = (j) this.qby;
            if (getIntent() == null || !getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false)) {
                z = false;
            } else {
                z = true;
            }
            jVar.qeB = z;
            setMMTitle((int) R.string.dxg);
            this.qbc.setVisibility(8);
        } else if (9 == this.qbz) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new m(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle((int) R.string.dxi);
            this.qbc.setVisibility(8);
        } else if (10 == this.qbz) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new l(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle((int) R.string.dxh);
            this.qbc.setVisibility(8);
        } else if (11 == this.qbz) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.qby = new n(this, this.qbb, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle((int) R.string.dxj);
            this.qbc.setVisibility(8);
        } else {
            this.qbz = 1;
            if (hashSet.isEmpty()) {
                this.qby = new p((b) this, this.qbb, this.cvH, Lt() ? 1 : 0);
            } else {
                this.qby = new p((b) this, this.qbb, this.cvH, hashSet);
            }
            ((p) this.qby).qfn = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            if (com.tencent.mm.au.b.ahO()) {
                this.qbr = true;
                if (r.cio()) {
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
                setMMTitle((int) R.string.dxn);
            } else {
                setMMTitle((int) R.string.dxo);
            }
        }
        if (com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, ac.a.NEW_BANDAGE_WATCHER_SCAN_OCR_ENTRY_RED_DOT_STRING_SYNC)) {
            this.qbG.add(Integer.valueOf(3));
        }
        this.qbn = this.qby.cgS();
        this.qbx.setBackgroundResource(this.qbn ? R.drawable.amd : R.drawable.ame);
        cgV();
        if (this.qba != null) {
            this.qba.Cd(this.qbz);
        }
        cgW();
        this.qbI = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qbI.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(138484);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseScanUI.this.qbc.setTranslationY(((float) BaseScanUI.this.qbc.getHeight()) * floatValue);
                BaseScanUI.this.getSupportActionBar().getCustomView().setTranslationY((-floatValue) * ((float) BaseScanUI.this.getSupportActionBar().getHeight()));
                AppMethodBeat.o(138484);
            }
        });
        this.qbI.setDuration(300);
        xE(getResources().getColor(R.color.a3p));
        ab.i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", Integer.valueOf(this.cvH), Integer.valueOf(this.qbz));
        AppMethodBeat.o(80948);
    }

    private void cgV() {
        AppMethodBeat.i(80949);
        if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz) {
            AppMethodBeat.o(80949);
            return;
        }
        this.qbc.setShowRedDotModes(this.qbG);
        this.qbc.setSelectedMode(this.qbz);
        this.qbc.setOnGridItemClickCallback(new SelectScanModePanel.a() {
            public final void BX(int i) {
                AppMethodBeat.i(138485);
                BaseScanUI.this.qbG.remove(Integer.valueOf(i));
                if (i == 3) {
                    com.tencent.mm.x.c.PK().c(ac.a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, ac.a.NEW_BANDAGE_WATCHER_SCAN_OCR_ENTRY_RED_DOT_STRING_SYNC);
                    com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, false);
                }
                BaseScanUI.this.qbc.setShowRedDotModes(BaseScanUI.this.qbG);
                BaseScanUI.this.X(i, 50);
                AppMethodBeat.o(138485);
            }
        });
        AppMethodBeat.o(80949);
    }

    private void cgW() {
        AppMethodBeat.i(80950);
        if (this.qby == null) {
            AppMethodBeat.o(80950);
            return;
        }
        che();
        AppMethodBeat.o(80950);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(80951);
        if (i == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            ab.d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
            this.qbg = true;
            bwV();
            overridePendingTransition(0, 0);
            AppMethodBeat.o(80951);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(80951);
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
        com.tencent.mm.plugin.scanner.util.m mVar;
        AppMethodBeat.i(80952);
        super.onResume();
        if (!this.qbD) {
            com.tencent.mm.cj.c.aNX();
            this.qbD = true;
        }
        ab.i("MicroMsg.scanner.BaseScanUI", "should check camera %s, location %s", Boolean.valueOf(this.qbB), Boolean.valueOf(this.qbC));
        if (this.qbB || this.qbC) {
            if (this.qbB) {
                ab.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null)));
                if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null)) {
                    i = 0;
                    if (i != 0) {
                        if (!com.tencent.mm.compatible.f.b.Mj()) {
                            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(80941);
                                    BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                    BaseScanUI.this.qbB = true;
                                    BaseScanUI.this.finish();
                                    AppMethodBeat.o(80941);
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(80942);
                                    BaseScanUI.this.qbB = true;
                                    BaseScanUI.this.finish();
                                    AppMethodBeat.o(80942);
                                }
                            });
                        } else if (this.qbz != 5 || com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                            if (!this.qbs || this.qbh) {
                                this.qbg = false;
                                e(false, 0);
                            } else {
                                this.qbg = true;
                                cgZ();
                            }
                            this.qbu = false;
                            synchronized (this.cli) {
                                try {
                                    ab.d("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
                                    int i2 = this.qbz;
                                    if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    this.qba = new h(this, i2, z);
                                    chb();
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.o(80952);
                                    }
                                }
                            }
                            if (!(this.qbz == 3 && r.cio())) {
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
                                g.RO().a(this.qbK);
                            }
                            if (this.qbv != null) {
                                this.qbv.onResume();
                            }
                        } else {
                            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(80912);
                                    BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                    BaseScanUI.this.qbC = true;
                                    BaseScanUI.this.finish();
                                    AppMethodBeat.o(80912);
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(80913);
                                    BaseScanUI.this.qbC = true;
                                    BaseScanUI.this.finish();
                                    AppMethodBeat.o(80913);
                                }
                            });
                        }
                    }
                    if (!this.qbg && (this.qbz == 1 || this.qbz == 8 || this.qbz == 4)) {
                        m.pZK.reset();
                        m.pZK.BU(m.pZH);
                    }
                    mVar = com.tencent.mm.plugin.scanner.util.m.qiz;
                    ab.i("MicroMsg.ScanStableDetector", "start detect scan stable");
                    if (mVar.bCW != null) {
                        mVar.qix = 0;
                        mVar.qiw[0] = 0.0f;
                        mVar.qiw[1] = 0.0f;
                        mVar.qiw[2] = 0.0f;
                        ab.i("MicroMsg.ScanStableDetector", "register accelerate listener");
                        mVar.bCW.registerListener(mVar, mVar.qiv, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
                    }
                    AppMethodBeat.o(80952);
                }
            }
            if (this.qbC) {
                ab.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null)));
                if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null)) {
                    i = 0;
                    if (i != 0) {
                    }
                    m.pZK.reset();
                    m.pZK.BU(m.pZH);
                    mVar = com.tencent.mm.plugin.scanner.util.m.qiz;
                    ab.i("MicroMsg.ScanStableDetector", "start detect scan stable");
                    if (mVar.bCW != null) {
                    }
                    AppMethodBeat.o(80952);
                }
            }
        }
        z = true;
        if (i != 0) {
        }
        m.pZK.reset();
        m.pZK.BU(m.pZH);
        mVar = com.tencent.mm.plugin.scanner.util.m.qiz;
        ab.i("MicroMsg.ScanStableDetector", "start detect scan stable");
        if (mVar.bCW != null) {
        }
        AppMethodBeat.o(80952);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(80953);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.scanner.BaseScanUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(80953);
            return;
        }
        ab.i("MicroMsg.scanner.BaseScanUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.qbB = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(80914);
                            BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            BaseScanUI.this.qbB = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(80914);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(80915);
                            BaseScanUI.this.qbB = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(80915);
                        }
                    });
                    AppMethodBeat.o(80953);
                    return;
                }
            case 76:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.qbC = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(80916);
                            BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            BaseScanUI.this.qbC = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(80916);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(138461);
                            BaseScanUI.this.qbC = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(138461);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(80953);
    }

    public void onPause() {
        AppMethodBeat.i(80954);
        ab.i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", this.qby, this.qbv);
        this.qbg = true;
        com.tencent.mm.plugin.scanner.util.m.qiz.stop();
        if (this.qby != null) {
            this.qby.onPause();
            if (this.qby.cgO() != null) {
                this.qby.cgO().sI();
            }
        }
        if (this.qba != null) {
            String focusMode = this.qba.getFocusMode();
            if (bo.isNullOrNil(focusMode) || !focusMode.equals("continuous-video")) {
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
        g.RO().b(this.qbK);
        if (this.qbv != null) {
            this.qbv.onPause();
        }
        if (this.qbz == 1 || this.qbz == 8 || this.qbz == 4) {
            m.pZK.bHT();
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.qbE);
            ab.i("MicroMsg.scanner.BaseScanUI", "scan cost time:".concat(String.valueOf(currentTimeMillis)));
            if (m.pZK.pZM) {
                this.gCr[0] = 1;
            } else {
                this.gCr[0] = 0;
            }
            this.gCr[1] = currentTimeMillis;
            this.gCr[3] = m.pZK.pZN;
            if (com.tencent.mm.plugin.scanner.util.m.qiz.cil() > 0) {
                this.gCr[6] = (int) (com.tencent.mm.plugin.scanner.util.m.qiz.cil() - this.qbE);
            }
            this.gCr[7] = this.qbz;
            com.tencent.mm.plugin.report.service.h.pYm.e(14176, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]), Integer.valueOf(this.gCr[5]), Integer.valueOf(this.gCr[6]), Integer.valueOf(this.gCr[7]));
        }
        super.onPause();
        AppMethodBeat.o(80954);
    }

    public void onDestroy() {
        AppMethodBeat.i(80955);
        ab.i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
        if (this.qby != null) {
            this.qby.onDestroy();
        }
        if (this.qbd != null) {
            this.qbd.cht();
        }
        if (this.qaV != null) {
            this.qaV.setSurfaceTextureListener(null);
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.qbQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.qbL);
        com.tencent.mm.sdk.b.a.xxA.d(this.qbJ);
        if (this.qbv != null) {
            this.qbv.chU();
        }
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qia;
        ab.i("MicroMsg.ScanCameraLightDetector", "stop, isRegister: %s, sensorManager: %s, lightSensor: %s", Boolean.valueOf(scanCameraLightDetector.qid), scanCameraLightDetector.sensorManager, scanCameraLightDetector.qic);
        try {
            scanCameraLightDetector.qib = -1;
            if (scanCameraLightDetector.qie != null) {
                scanCameraLightDetector.qie.quit();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "stop error: %s", e.getMessage());
        }
        super.onDestroy();
        AppMethodBeat.o(80955);
    }

    private void cgX() {
        AppMethodBeat.i(80956);
        if (this.qbe != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qbe.getLayoutParams();
            if (this.qbz == 3) {
                layoutParams.topMargin = this.qbc.getTop() - com.tencent.mm.bz.a.fromDPToPix(this, 70);
            } else {
                layoutParams.topMargin = this.qbo.top + (this.qbo.height() - com.tencent.mm.bz.a.fromDPToPix(this, 70));
            }
            ab.c("MicroMsg.scanner.BaseScanUI", "initFlashSwitcher, scanMaskRect: %s, scanLineStart: %s, scanLineEnd: %s", this.qbo, Integer.valueOf(this.qbl), Integer.valueOf(this.qbm));
            this.qbe.setLayoutParams(layoutParams);
            this.qbe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(138462);
                    if (BaseScanUI.this.qba != null) {
                        m.pZK.BV(2);
                        if (BaseScanUI.this.qba.otY) {
                            BaseScanUI.this.qba.bPs();
                            BaseScanUI.this.qbe.chJ();
                        } else {
                            h a = BaseScanUI.this.qba;
                            ab.i("MicroMsg.scanner.ScanCamera", "openFlash, camera: %s, isPreviewing: %s", a.erH, Boolean.valueOf(a.lUE));
                            if (a.erH != null && a.lUE) {
                                try {
                                    a.otY = true;
                                    Parameters parameters = a.erH.getParameters();
                                    if (bo.ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                                        ab.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
                                    } else {
                                        parameters.setFlashMode("torch");
                                        a.erH.setParameters(parameters);
                                        ab.i("MicroMsg.scanner.ScanCamera", "open flash");
                                    }
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "openFlash error: %s", e.getMessage());
                                }
                            }
                            ScannerFlashSwitcher h = BaseScanUI.this.qbe;
                            ab.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
                            h.qgm.setImageResource(R.raw.scanner_flash_open_on);
                            AppMethodBeat.o(138462);
                            return;
                        }
                    }
                    AppMethodBeat.o(138462);
                }
            });
            if (this.qba == null || !this.qba.otY) {
                this.qbe.setVisibility(8);
            } else {
                this.qbe.setVisibility(0);
                AppMethodBeat.o(80956);
                return;
            }
        }
        AppMethodBeat.o(80956);
    }

    private void cgY() {
        AppMethodBeat.i(80957);
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
            AppMethodBeat.o(80957);
            return;
        }
        this.qbw = new TranslateAnimation((float) this.qbl, (float) this.qbm, 0.0f, 0.0f);
        AppMethodBeat.o(80957);
    }

    private void e(boolean z, long j) {
        AppMethodBeat.i(80958);
        if (this.qbl < 0 || this.qbm <= 0 || this.qby == null || !this.qby.cgT()) {
            cgZ();
            AppMethodBeat.o(80958);
            return;
        }
        if (z) {
            cgY();
        }
        this.qbM.removeMessages(1);
        if (j <= 0) {
            this.qbM.sendEmptyMessage(1);
            AppMethodBeat.o(80958);
            return;
        }
        cgZ();
        this.qbM.sendEmptyMessageDelayed(1, j);
        AppMethodBeat.o(80958);
    }

    public final void cgZ() {
        AppMethodBeat.i(80959);
        if (!(this.qbx == null || this.qbw == null)) {
            this.qbx.setVisibility(8);
            this.qbx.clearAnimation();
            this.qbx.setAnimation(null);
        }
        AppMethodBeat.o(80959);
    }

    public final void cha() {
        AppMethodBeat.i(80960);
        if (!this.qbg) {
            ay.au(this, R.string.dgc);
        }
        AppMethodBeat.o(80960);
    }

    private void chb() {
        AppMethodBeat.i(80961);
        al.n(new Runnable() {
            public final void run() {
                BaseScanUI baseScanUI;
                int i;
                int i2 = 1;
                AppMethodBeat.i(138466);
                try {
                    if (BaseScanUI.this.qba == null) {
                        ab.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
                        AppMethodBeat.o(138466);
                        return;
                    }
                    if (!BaseScanUI.this.qbt) {
                        baseScanUI = BaseScanUI.this;
                    }
                    if (BaseScanUI.this.qba.isOpen()) {
                        ab.d("MicroMsg.scanner.BaseScanUI", "camera already open");
                    } else {
                        synchronized (BaseScanUI.this.cli) {
                            BaseScanUI.this.qba.open();
                            ab.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                            BaseScanUI.t(BaseScanUI.this);
                            BaseScanUI.this.qbu = false;
                        }
                    }
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(138465);
                            BaseScanUI.y(BaseScanUI.this);
                            AppMethodBeat.o(138465);
                        }
                    }, 50);
                    BaseScanUI.this.qba.e(BaseScanUI.this.qbb);
                    BaseScanUI.this.qby.kn(BaseScanUI.this.chh());
                    BaseScanUI.this.qby.f(BaseScanUI.this.qba.lUF);
                    if (BaseScanUI.this.qba != null && BaseScanUI.this.qba.lUE) {
                        BaseScanUI.this.jL(0);
                    }
                    AppMethodBeat.o(138466);
                } catch (Exception e) {
                    Object[] objArr = new Object[i2];
                    objArr[0] = e.toString();
                    ab.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", objArr);
                    i = "MicroMsg.scanner.BaseScanUI";
                    i2 = new Object[0];
                    ab.printErrStackTrace(i, e, "", i2);
                    BaseScanUI.this.qbA = BaseScanUI.this.qbA + 1;
                    baseScanUI = BaseScanUI.this.qbA;
                    if (baseScanUI >= i) {
                        BaseScanUI.w(BaseScanUI.this);
                        AppMethodBeat.o(138466);
                        return;
                    }
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(138464);
                            BaseScanUI.x(BaseScanUI.this);
                            AppMethodBeat.o(138464);
                        }
                    }, 300);
                    AppMethodBeat.o(138466);
                } finally {
                    i = 138466;
                    AppMethodBeat.o(138466);
                }
            }
        }, 25);
        AppMethodBeat.o(80961);
    }

    private void chc() {
        AppMethodBeat.i(80962);
        this.qba.a(new PreviewCallback() {
            public final void onPreviewFrame(byte[] bArr, Camera camera) {
            }
        });
        AppMethodBeat.o(80962);
    }

    private void startPreview() {
        AppMethodBeat.i(80963);
        int[] e;
        try {
            if (this.lZT || this.qba == null) {
                ab.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in startPreview");
                AppMethodBeat.o(80963);
            } else if (!this.qba.isOpen()) {
                ab.w("MicroMsg.scanner.BaseScanUI", "camera not open");
                AppMethodBeat.o(80963);
            } else if (this.qaW == null) {
                ab.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in startPreview");
                AppMethodBeat.o(80963);
            } else if (this.qba.lUE) {
                ab.w("MicroMsg.scanner.BaseScanUI", "camera is previewing");
                AppMethodBeat.o(80963);
            } else {
                ab.d("MicroMsg.scanner.BaseScanUI", "camera startPreview.");
                Object obj = this.cli;
                synchronized (obj) {
                    chc();
                    this.qba.h(this.qaW);
                    ab.d("MicroMsg.scanner.BaseScanUI", "camera startPreview. done");
                    e = this.gCr;
                    if (e == null && this.qba.getFocusMode().equals("continuous-video")) {
                        e = this.qba;
                        e.cancelAutoFocus();
                        AppMethodBeat.o(80963);
                    }
                    if (com.tencent.mm.compatible.e.q.etc.ers > 0) {
                        jK((long) ((int) (((float) com.tencent.mm.compatible.e.q.etc.ers) * ae.gjj)));
                    }
                    jL(0);
                    AppMethodBeat.o(80963);
                }
            }
        } catch (Exception e2) {
            e = e2;
            String str = "MicroMsg.scanner.BaseScanUI";
            String str2 = "Exception in scanCamera.startPreview(), [%s]";
        } finally {
            int i = 80963;
            AppMethodBeat.o(80963);
        }
    }

    private void btW() {
        AppMethodBeat.i(80964);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138469);
                if (BaseScanUI.this.qba == null) {
                    AppMethodBeat.o(138469);
                    return;
                }
                synchronized (BaseScanUI.this.cli) {
                    try {
                        if (!(BaseScanUI.this.lZT || BaseScanUI.this.qba == null)) {
                            BaseScanUI.this.lZT = true;
                            ab.i("MicroMsg.scanner.BaseScanUI", "closeCamera");
                            BaseScanUI.this.qba.release();
                            BaseScanUI.this.qba = null;
                            BaseScanUI.this.lZT = false;
                            ab.i("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(138469);
                    }
                }
            }
        }, "BaseScanUI_closeCamera");
        AppMethodBeat.o(80964);
    }

    private void chd() {
        AppMethodBeat.i(80965);
        if (this.qbf) {
            AppMethodBeat.o(80965);
            return;
        }
        this.qbf = true;
        kj(true);
        mi miVar = new mi();
        miVar.cIm.type = 2;
        com.tencent.mm.sdk.b.a.xxA.m(miVar);
        if (miVar.cIn.cIl) {
            ab.i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
            this.qbg = true;
            btW();
            bwV();
            overridePendingTransition(0, 0);
            AppMethodBeat.o(80965);
            return;
        }
        com.tencent.mm.ui.widget.a.c a = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dya), getString(R.string.tz), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(138470);
                BaseScanUI.this.qbg = true;
                BaseScanUI.B(BaseScanUI.this);
                BaseScanUI.C(BaseScanUI.this);
                BaseScanUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(138470);
            }
        });
        if (a == null) {
            ab.d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
            AppMethodBeat.o(80965);
            return;
        }
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        a.show();
        AppMethodBeat.o(80965);
    }

    public final void che() {
        AppMethodBeat.i(80966);
        try {
            chf();
            if (this.qby == null) {
                ab.d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
                AppMethodBeat.o(80966);
                return;
            }
            this.qby.e(this.qbb);
            Rect H = this.qby.H(true, Lt());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(H.width(), H.height(), 3);
            layoutParams.leftMargin = H.left;
            layoutParams.topMargin = H.top;
            this.qbj = H.width();
            this.qbk = H.height();
            ab.d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s]", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(this.qbj), Integer.valueOf(this.qbk));
            H = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + this.qbj, layoutParams.topMargin + this.qbk);
            if (this.qbb.x - H.right < H.left) {
                ab.w("MicroMsg.scanner.BaseScanUI", "this is a special device");
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
            if (this.qbz == 3 && r.cio()) {
                this.qbd.setMaskAnimaListener(new a() {
                    public final void onAnimationEnd() {
                        AppMethodBeat.i(138471);
                        mk mkVar = new mk();
                        mkVar.cIp.action = 2;
                        com.tencent.mm.sdk.b.a.xxA.m(mkVar);
                        AppMethodBeat.o(138471);
                    }
                });
            }
            this.qaZ.removeAllViews();
            View.inflate(this, this.qby.cgP(), this.qaZ);
            this.qby.dw(this.qaZ.getChildAt(0));
            this.qby.cgR();
            this.qby.dx(this.qaZ);
            this.qaZ.addView(this.qbd, 0, layoutParams);
            this.qbd.k(H);
            this.qby.j(H);
            this.qbd.setBackgroundColor(0);
            ab.d("MicroMsg.scanner.BaseScanUI", "newRect = %s", H);
            if (this.qbn) {
                this.qbl = H.top;
                this.qbm = H.bottom - BackwardSupportUtil.b.b((Context) this, 8.0f);
                this.qbo = H;
            } else {
                this.qbl = H.left;
                this.qbm = H.right - BackwardSupportUtil.b.b((Context) this, 8.0f);
                this.qbo = H;
            }
            cgX();
            if (!this.qbs || this.qbh) {
                e(true, ((long) this.qbd.getMaskAnimDuration()) + 150);
                if (!(this.qbp == null || this.qbq == null)) {
                    this.qbp.setVisibility(8);
                    this.qbq.setVisibility(8);
                }
            } else if (!(this.qbp == null || this.qbq == null)) {
                this.qbp.setText(R.string.dy9);
                this.qbq.setVisibility(0);
                this.qbp.setVisibility(0);
            }
            if (this.qba != null && this.qba.isOpen()) {
                this.qba.e(this.qbb);
                this.qby.kn(chh());
                this.qby.f(this.qba.lUF);
            }
            AppMethodBeat.o(80966);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
            AppMethodBeat.o(80966);
        }
    }

    public void onStart() {
        AppMethodBeat.i(80967);
        super.onStart();
        AppMethodBeat.o(80967);
    }

    private void chf() {
        AppMethodBeat.i(80968);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.qbb = new Point(rect.width(), rect.height());
        ab.d("MicroMsg.scanner.BaseScanUI", "update visible rect:%s", this.qbb);
        AppMethodBeat.o(80968);
    }

    public final void X(int i, long j) {
        AppMethodBeat.i(80969);
        this.qbO.removeMessages(0);
        this.qbO.sendEmptyMessageDelayed(i, j);
        this.qbc.setSelectedMode(i);
        AppMethodBeat.o(80969);
    }

    public final void jK(long j) {
        AppMethodBeat.i(80970);
        ab.i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", Long.valueOf(j));
        this.qbP.removeMessages(0);
        if (this.qbg) {
            ab.w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
            AppMethodBeat.o(80970);
            return;
        }
        this.qbP.sendEmptyMessageDelayed(0, j);
        AppMethodBeat.o(80970);
    }

    public final void jL(long j) {
        AppMethodBeat.i(80971);
        if (!(this.qba == null || this.qbg || !this.qba.lUE)) {
            ab.d("MicroMsg.scanner.BaseScanUI", "focus delay:".concat(String.valueOf(j)));
            String focusMode = this.qba.getFocusMode();
            if (bo.isNullOrNil(focusMode) || !focusMode.equals("continuous-video")) {
                this.qbR.removeMessages(0);
                this.qbR.sendEmptyMessageDelayed(0, j);
            } else {
                jK(0);
                AppMethodBeat.o(80971);
                return;
            }
        }
        AppMethodBeat.o(80971);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(80972);
        String str = "MicroMsg.scanner.BaseScanUI";
        String str2 = "onPreviewFrame, data==null: %s, camera: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr == null);
        objArr[1] = camera;
        ab.i(str, str2, objArr);
        if (this.qbg || this.qby == null || this.qby.cgO() == null || this.qby.H(false, Lt()) == null) {
            ab.w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", Boolean.valueOf(this.qbg));
            AppMethodBeat.o(80972);
        } else if (bArr == null || bArr.length <= 0) {
            str = "MicroMsg.scanner.BaseScanUI";
            str2 = "onPreviewFrame, wrong data, data is null [%s]";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            ab.e(str, str2, objArr);
            chd();
            AppMethodBeat.o(80972);
        } else if (this.qba == null) {
            ab.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
            AppMethodBeat.o(80972);
        } else {
            try {
                int i;
                if (this.qba != null) {
                    Object obj;
                    h hVar = this.qba;
                    if (hVar.qhV < 0) {
                        hVar.qhV = hVar.cif() ? 1 : 0;
                    }
                    if (hVar.qhV == 1) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (!(obj == null || this.qba.otY || !this.qbh)) {
                        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.qia;
                        int i2 = this.qba.lUF.x;
                        i = this.qba.lUF.y;
                        if (scanCameraLightDetector.qib < 0 || (bo.az(scanCameraLightDetector.qib) >= 1000 && scanCameraLightDetector.handler != null && scanCameraLightDetector.qie != null && scanCameraLightDetector.qie.isAlive())) {
                            ScanCameraLightDetector.a aVar = new ScanCameraLightDetector.a(scanCameraLightDetector, (byte) 0);
                            aVar.ovq = bArr;
                            aVar.width = i2;
                            aVar.height = i;
                            Message obtain = Message.obtain();
                            obtain.what = com.tencent.view.d.MIC_PTU_MEISHI;
                            obtain.obj = aVar;
                            scanCameraLightDetector.handler.sendMessage(obtain);
                            scanCameraLightDetector.qib = bo.yz();
                        }
                    }
                }
                if (!(this.qba == null || this.qbg)) {
                    i iVar = this.qby;
                    Point point = this.qba.lUF;
                    i = this.qba.lUJ;
                    h hVar2 = this.qba;
                    Rect km = this.qby.km(Lt());
                    int i3 = this.qbz;
                    Rect rect = new Rect();
                    ab.i("MicroMsg.scanner.ScanCamera", "frame rect:%s, visibleResolution:%s, cameraResolution %s", km, hVar2.lUH, hVar2.lUF);
                    if (!hVar2.lUI || hVar2.qhS) {
                        rect.left = (int) (((float) km.left) * hVar2.chX());
                        rect.right = (int) (((float) km.right) * hVar2.chX());
                        rect.top = (int) (((float) km.top) * hVar2.chY());
                        rect.bottom = (int) (((float) km.bottom) * hVar2.chY());
                        if (rect.bottom > hVar2.lUF.y) {
                            rect.bottom = hVar2.lUF.y;
                        }
                        if (rect.right > hVar2.lUF.x) {
                            rect.right = hVar2.lUF.x;
                        }
                    } else {
                        ab.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + hVar2.lUI + " needLandscape = " + hVar2.qhS);
                        rect.top = (hVar2.lUF.x - ((int) (((float) km.height()) * hVar2.chY()))) / 2;
                        rect.bottom = hVar2.lUF.x - rect.top;
                        rect.left = (hVar2.lUF.y - ((int) (((float) km.width()) * hVar2.chX()))) / 2;
                        rect.right = hVar2.lUF.y - rect.left;
                    }
                    if (7 == i3 || 11 == i3) {
                        int width;
                        if (!hVar2.lUI || hVar2.qhS) {
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
                    ab.i("MicroMsg.scanner.ScanCamera", "resultRect %s", rect);
                    hVar2.lQX = rect;
                    hVar2.cib();
                    ab.i("MicroMsg.scanner.ScanCamera", "scanRect:" + hVar2.lQX);
                    iVar.a(bArr, point, i, hVar2.lQX);
                }
                AppMethodBeat.o(80972);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "onPreviewFrame exception", new Object[0]);
                AppMethodBeat.o(80972);
            }
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.i(80973);
        ab.i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", Boolean.valueOf(z), camera);
        this.gCr[4] = (int) (System.currentTimeMillis() - this.qbF);
        com.tencent.mm.compatible.e.q.etc.ers = (long) this.gCr[4];
        if (this.qbg) {
            AppMethodBeat.o(80973);
        } else if (this.qby == null) {
            AppMethodBeat.o(80973);
        } else {
            if (this.qba != null && this.qba.lUE && z) {
                jK(0);
            }
            if (this.qby.qel > 0) {
                jL(this.qby.qel);
            }
            AppMethodBeat.o(80973);
        }
    }

    public final void a(i.a aVar) {
        this.qbi = aVar;
    }

    public final void chg() {
        AppMethodBeat.i(80974);
        Intent intent = new Intent();
        intent.putExtra("preview_ui_title", R.string.dys);
        com.tencent.mm.pluginsdk.ui.tools.n.a((Activity) this, 4660, intent);
        AppMethodBeat.o(80974);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(80975);
        if (this.qbi != null) {
            this.qbi.c(this, i, i2, intent);
        }
        AppMethodBeat.o(80975);
    }

    public final void kj(boolean z) {
        AppMethodBeat.i(80976);
        this.qbg = z;
        if (z) {
            cgZ();
            if (this.qbq != null) {
                this.qbq.setVisibility(0);
                AppMethodBeat.o(80976);
                return;
            }
        }
        jL(0);
        e(false, 0);
        if (this.qbq != null) {
            this.qbq.setVisibility(8);
        }
        AppMethodBeat.o(80976);
    }

    public final void b(int i, final OnClickListener onClickListener) {
        AppMethodBeat.i(80977);
        if (this.qaX != null) {
            if (getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
                this.qaX.setVisibility(8);
                AppMethodBeat.o(80977);
                return;
            } else if (onClickListener != null) {
                this.qaX.setVisibility(i);
                this.qaX.setOnClickListener(onClickListener);
                this.qaY.setBackgroundDrawable(null);
                this.qaY.setText(getString(R.string.e2f));
                AppMethodBeat.o(80977);
                return;
            }
        } else if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
            if (onClickListener != null) {
                addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(138478);
                        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(BaseScanUI.this.mController.ylL, 1, false);
                        dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                            public final void a(l lVar) {
                                AppMethodBeat.i(138476);
                                if (onClickListener != null) {
                                    lVar.hi(1, R.string.e2e);
                                }
                                lVar.hi(0, R.string.cu);
                                if (com.tencent.mm.plugin.scanner.util.i.cig()) {
                                    lVar.hi(2, R.string.dxt);
                                    ab.i("MicroMsg.scanner.BaseScanUI", "show history list");
                                }
                                AppMethodBeat.o(138476);
                            }
                        };
                        dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(138477);
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        BaseScanUI baseScanUI = BaseScanUI.this;
                                        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                                        intent.putExtra("android.intent.extra.shortcut.NAME", baseScanUI.getString(R.string.btn));
                                        intent.putExtra("duplicate", false);
                                        Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                        intent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                                        intent2.addFlags(67108864);
                                        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                                        intent.putExtra("shortcut_is_adaptive_icon", true);
                                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(baseScanUI, R.drawable.scan_shortcut_icon));
                                        intent.putExtra("shortcut_icon_resource_id", R.drawable.scan_shortcut_icon);
                                        com.tencent.mm.plugin.base.model.b.q(baseScanUI, intent);
                                        com.tencent.mm.plugin.report.service.h.pYm.e(11410, new Object[0]);
                                        AppMethodBeat.o(138477);
                                        return;
                                    case 1:
                                        if (onClickListener != null) {
                                            onClickListener.onClick(null);
                                            AppMethodBeat.o(138477);
                                            return;
                                        }
                                        break;
                                    case 2:
                                        Intent intent3 = new Intent();
                                        intent3.setClass(BaseScanUI.this, ScannerHistoryUI.class);
                                        BaseScanUI.this.startActivity(intent3);
                                        com.tencent.mm.plugin.report.service.h.pYm.e(12684, Integer.valueOf(1), Integer.valueOf(0));
                                        break;
                                }
                                AppMethodBeat.o(138477);
                            }
                        };
                        dVar.cpD();
                        AppMethodBeat.o(138478);
                        return false;
                    }
                });
                AppMethodBeat.o(80977);
                return;
            }
            removeOptionMenu(0);
        }
        AppMethodBeat.o(80977);
    }

    public final boolean chh() {
        AppMethodBeat.i(80978);
        if (this.qba == null || !this.qba.isOpen()) {
            ab.d("MicroMsg.scanner.BaseScanUI", "scanCamera == null or scanCamera is not open, cameraNeedRotate return false");
            AppMethodBeat.o(80978);
            return false;
        }
        boolean z = this.qba.lUI;
        AppMethodBeat.o(80978);
        return z;
    }

    public final void chi() {
        AppMethodBeat.i(80979);
        bwV();
        AppMethodBeat.o(80979);
    }

    public final void chj() {
        AppMethodBeat.i(80980);
        super.finish();
        AppMethodBeat.o(80980);
    }

    private void bwV() {
        AppMethodBeat.i(80981);
        ps psVar = new ps();
        psVar.cLW.bJt = 1;
        com.tencent.mm.sdk.b.a.xxA.m(psVar);
        setResult(0);
        finish();
        AppMethodBeat.o(80981);
    }

    private boolean Lt() {
        AppMethodBeat.i(80982);
        if (7 == this.qbz || 9 == this.qbz || 10 == this.qbz || 11 == this.qbz || com.tencent.mm.compatible.e.d.Lt()) {
            AppMethodBeat.o(80982);
            return true;
        }
        AppMethodBeat.o(80982);
        return false;
    }

    public final void a(String str, int i, int i2, int i3, com.tencent.mm.plugin.scanner.util.e.a aVar) {
        AppMethodBeat.i(80983);
        ab.i("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s", str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.qbv != null) {
            this.qbv.chU();
        }
        Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
        this.qbv = new com.tencent.mm.plugin.scanner.util.e();
        this.qbv.a(this, str, i, i2, i3, aVar, bundleExtra);
        if (this.qbz == 1 || this.qbz == 8 || this.qbz == 4) {
            m mVar = m.pZK;
            int i4 = m.pZH;
        }
        AppMethodBeat.o(80983);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(80984);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.scanner.BaseScanUI", "screen orientation %d", Integer.valueOf(configuration.orientation));
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(138479);
                    BaseScanUI.this.qby.onPause();
                    BaseScanUI.this.che();
                    AppMethodBeat.o(138479);
                }
            }, 100);
        }
        AppMethodBeat.o(80984);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(80985);
        ab.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
        this.qaV.dAh();
        this.qaW = surfaceTexture;
        this.qbt = true;
        if (this.qbu) {
            chb();
            this.qbu = false;
        }
        startPreview();
        AppMethodBeat.o(80985);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(80986);
        ab.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
        this.qaW = surfaceTexture;
        AppMethodBeat.o(80986);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(80987);
        ab.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
        this.qbt = false;
        AppMethodBeat.o(80987);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARNING: Missing block: B:31:0x0092, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(80988);
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ah(int i, int i2, int i3) {
        AppMethodBeat.i(80988);
        synchronized (this.cli) {
            try {
                if (!(this.lZT || this.qba == null || !this.qba.lUE)) {
                    ab.i("MicroMsg.scanner.BaseScanUI", "zoom camera,action:%d,type:%d,scale:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    int cid = this.qba.cid();
                    if (this.qbz == 1 || this.qbz == 8 || this.qbz == 4) {
                        if (i2 != 1 || ((p) this.qby).chy()) {
                            if (i == 6) {
                                this.qba.Ce(i3);
                            } else {
                                this.qba.Cf(i);
                            }
                            if (i2 == 2) {
                                ((p) this.qby).chx();
                            }
                        } else {
                            ab.d("MicroMsg.scanner.BaseScanUI", "auto zoom is disable");
                        }
                    } else if (i == 6) {
                        this.qba.Ce(i3);
                    } else {
                        this.qba.Cf(i);
                    }
                    if (this.qba.cid() != cid) {
                        m mVar = m.pZK;
                        this.qba.cid();
                        if (i2 == 1) {
                            mVar.pZX |= 1;
                        } else if (i2 == 2) {
                            mVar.pZX |= 2;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(80988);
            }
        }
    }

    public final void chk() {
        AppMethodBeat.i(80989);
        if (!(this.lZT || this.qba == null || this.qbg)) {
            String focusMode = this.qba.getFocusMode();
            if (!(bo.isNullOrNil(focusMode) || focusMode.equals("auto"))) {
                h hVar = this.qba;
                try {
                    if (hVar.erH != null && hVar.lUE) {
                        Parameters parameters = hVar.erH.getParameters();
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (!(supportedFocusModes == null || !supportedFocusModes.contains("auto") || bo.isNullOrNil(parameters.getFocusMode()) || parameters.getFocusMode().equals("auto"))) {
                            parameters.setFocusMode("auto");
                            hVar.erH.setParameters(parameters);
                        }
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.scanner.ScanCamera", "setFocusModeAuto %s", e.getMessage());
                }
                jL(0);
            }
        }
        AppMethodBeat.o(80989);
    }

    public final /* bridge */ /* synthetic */ Activity getContext() {
        return this.mController.ylL;
    }

    static /* synthetic */ void l(BaseScanUI baseScanUI) {
        AppMethodBeat.i(80991);
        ab.d("MicroMsg.scanner.BaseScanUI", "backBtn onClick");
        baseScanUI.qbg = true;
        baseScanUI.bwV();
        baseScanUI.overridePendingTransition(0, 0);
        AppMethodBeat.o(80991);
    }
}
