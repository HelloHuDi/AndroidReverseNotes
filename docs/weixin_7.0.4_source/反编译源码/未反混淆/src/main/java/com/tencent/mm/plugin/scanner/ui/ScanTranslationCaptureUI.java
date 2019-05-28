package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.b.a.r;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.n.b;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI extends MMActivity implements PreviewCallback, SurfaceTextureListener, f, b {
    private SurfaceTexture bsb;
    private int cvd = 0;
    private int eYR = 0;
    private String fWz;
    private int fwt;
    private View gnR;
    private boolean gwZ = true;
    private int iev;
    private int qbA = 0;
    private c<mk> qbL = new c<mk>() {
        {
            AppMethodBeat.i(81253);
            this.xxI = mk.class.getName().hashCode();
            AppMethodBeat.o(81253);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(81254);
            if (((mk) bVar).cIp.action == 2) {
                ab.i("MicroMsg.ScanTranslationCaptureUI", "receive play open translate anim event");
                String stringExtra = ScanTranslationCaptureUI.this.getIntent().getStringExtra("key_first_background");
                if (!bo.isNullOrNil(stringExtra)) {
                    Bitmap decodeFile = d.decodeFile(stringExtra, new Options());
                    if (decodeFile != null) {
                        ScanTranslationCaptureUI.this.qfY.setVisibility(0);
                        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, decodeFile);
                        FileOp.deleteFile(stringExtra);
                    }
                }
                ScanTranslationCaptureUI.this.gnR.setAlpha(1.0f);
                ScanTranslationCaptureUI.this.qga.start();
                ScanTranslationCaptureUI.this.qfI.setVisibility(0);
                ScanTranslationCaptureUI.this.qgd = true;
                AppMethodBeat.o(81254);
                return true;
            }
            AppMethodBeat.o(81254);
            return false;
        }
    };
    private h qba;
    private ImageView qbx;
    private MMTextureView qfI;
    private View qfJ;
    private View qfK;
    private View qfL;
    private View qfM;
    private View qfN;
    private ImageView qfO;
    private View qfP;
    private View qfQ;
    private View qfR;
    private TextView qfS;
    private Bitmap qfT;
    private Bitmap qfU;
    private String qfV;
    private String qfW;
    private a qfX;
    private MMGestureGallery qfY;
    private ValueAnimator qfZ;
    private ValueAnimator qga;
    private int qgb;
    private String qgc;
    private boolean qgd;
    private r qge = new r();
    private long[] qgf = new long[2];
    private n qgg = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(81268);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(81267);
                    if (!(g.Rg().acS() == 6 || g.Rg().acS() == 4 || ScanTranslationCaptureUI.this.fwt != 1)) {
                        com.tencent.mm.ui.base.h.b(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.dy9), "", true);
                        ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                    }
                    AppMethodBeat.o(81267);
                }
            });
            AppMethodBeat.o(81268);
        }
    };

    class a extends BaseAdapter {
        Bitmap bitmap;

        private a() {
        }

        /* synthetic */ a(ScanTranslationCaptureUI scanTranslationCaptureUI, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            MultiTouchImageView multiTouchImageView;
            AppMethodBeat.i(138497);
            if (view == null) {
                multiTouchImageView = new MultiTouchImageView(ScanTranslationCaptureUI.this, 0, 0);
                multiTouchImageView.setLayoutParams(new LayoutParams(-1, -1));
            } else {
                multiTouchImageView = (MultiTouchImageView) view;
            }
            if (this.bitmap != null) {
                multiTouchImageView.setImageBitmap(this.bitmap);
                multiTouchImageView.bW(this.bitmap.getWidth(), this.bitmap.getHeight());
                multiTouchImageView.dzA();
            }
            AppMethodBeat.o(138497);
            return multiTouchImageView;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ScanTranslationCaptureUI() {
        AppMethodBeat.i(81283);
        AppMethodBeat.o(81283);
    }

    static /* synthetic */ void A(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(81317);
        scanTranslationCaptureUI.chC();
        AppMethodBeat.o(81317);
    }

    static /* synthetic */ void f(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(81314);
        scanTranslationCaptureUI.chG();
        AppMethodBeat.o(81314);
    }

    static /* synthetic */ void g(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(138500);
        scanTranslationCaptureUI.goBack();
        AppMethodBeat.o(138500);
    }

    static /* synthetic */ void v(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(138501);
        scanTranslationCaptureUI.chH();
        AppMethodBeat.o(138501);
    }

    static /* synthetic */ void z(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(138502);
        scanTranslationCaptureUI.btW();
        AppMethodBeat.o(138502);
    }

    public final void initView() {
        AppMethodBeat.i(81285);
        this.gnR = findViewById(R.id.bhm);
        this.gnR.setAlpha(0.0f);
        this.qfI = (MMTextureView) findViewById(R.id.e5c);
        this.qfI.setOpaque(false);
        this.qfI.setSurfaceTextureListener(this);
        this.qfY = (MMGestureGallery) findViewById(R.id.e5d);
        this.qfX = new a(this, (byte) 0);
        this.qfY.setAdapter(this.qfX);
        this.qfM = findViewById(R.id.e5h);
        this.qfJ = findViewById(R.id.ch8);
        this.qfJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81275);
                ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
                AppMethodBeat.o(81275);
            }
        });
        this.qfK = findViewById(R.id.e5i);
        this.qfK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81276);
                ScanTranslationCaptureUI.this.qba.a(ScanTranslationCaptureUI.this);
                ScanTranslationCaptureUI.this.qge.cWW = (long) ((int) (System.currentTimeMillis() - ScanTranslationCaptureUI.this.qgf[0]));
                ScanTranslationCaptureUI.this.qge.cWV = 1;
                AppMethodBeat.o(81276);
            }
        });
        this.qfK.setEnabled(false);
        this.qfS = (TextView) findViewById(R.id.e5g);
        this.qfL = findViewById(R.id.e5j);
        this.qfL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81277);
                com.tencent.mm.pluginsdk.ui.tools.n.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, null);
                AppMethodBeat.o(81277);
            }
        });
        this.qfN = findViewById(R.id.e5k);
        this.qfO = (ImageView) this.qfN.findViewById(R.id.e5l);
        this.qfO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81278);
                if (ScanTranslationCaptureUI.this.fwt == 3) {
                    if (ScanTranslationCaptureUI.this.qfT != null) {
                        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.qfT);
                    }
                    if (ScanTranslationCaptureUI.this.qgc.equalsIgnoreCase("zh_CN")) {
                        ScanTranslationCaptureUI.this.qfO.setImageResource(R.raw.translation_result_chinese_highlighted);
                    } else {
                        ScanTranslationCaptureUI.this.qfO.setImageResource(R.raw.translation_result_english_highlighted);
                    }
                    ScanTranslationCaptureUI.this.fwt = 2;
                    ScanTranslationCaptureUI.this.qge.cXb++;
                    AppMethodBeat.o(81278);
                    return;
                }
                if (ScanTranslationCaptureUI.this.fwt == 2) {
                    if (ScanTranslationCaptureUI.this.qfU != null) {
                        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.qfU);
                    }
                    if (ScanTranslationCaptureUI.this.qgc.equalsIgnoreCase("zh_CN")) {
                        ScanTranslationCaptureUI.this.qfO.setImageResource(R.drawable.a47);
                    } else {
                        ScanTranslationCaptureUI.this.qfO.setImageResource(R.drawable.a49);
                    }
                    ScanTranslationCaptureUI.this.fwt = 3;
                }
                AppMethodBeat.o(81278);
            }
        });
        this.qfQ = findViewById(R.id.e5e);
        this.qfR = findViewById(R.id.e5f);
        this.mController.hideTitleView();
        setMMTitle((int) R.string.dxl);
        xE(getResources().getColor(R.color.a3p));
        this.qbx = (ImageView) findViewById(R.id.e4s);
        this.qfP = this.qfN.findViewById(R.id.e5m);
        this.qfP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81279);
                if (ScanTranslationCaptureUI.this.fwt == 2) {
                    try {
                        ScanTranslationCaptureUI.this.qge.cXd = 1;
                        q.a(ScanTranslationCaptureUI.this.fWz, ScanTranslationCaptureUI.this, false, -1);
                        com.tencent.mm.ui.widget.snackbar.b.i(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.dyy));
                        AppMethodBeat.o(81279);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "copy to gallery error", new Object[0]);
                        AppMethodBeat.o(81279);
                        return;
                    }
                }
                if (ScanTranslationCaptureUI.this.fwt == 3) {
                    try {
                        ScanTranslationCaptureUI.this.qge.cXc = 1;
                        if (ScanTranslationCaptureUI.this.cvd == 0) {
                            try {
                                ScanTranslationCaptureUI scanTranslationCaptureUI = ScanTranslationCaptureUI.this;
                                e.cgy();
                                scanTranslationCaptureUI.qfV = e.Wb("jpg");
                                d.a(ScanTranslationCaptureUI.this.qfU, 80, CompressFormat.JPEG, ScanTranslationCaptureUI.this.qfV, false);
                            } catch (IOException e2) {
                                ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e2, "save translate result file error", new Object[0]);
                            }
                        }
                        q.a(ScanTranslationCaptureUI.this.qfV, ScanTranslationCaptureUI.this, false, -1);
                        com.tencent.mm.ui.widget.snackbar.b.i(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.dyy));
                        AppMethodBeat.o(81279);
                        return;
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e3, "save to gallery error", new Object[0]);
                    }
                }
                AppMethodBeat.o(81279);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(81280);
                ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
                AppMethodBeat.o(81280);
                return true;
            }
        });
        this.iev = getWindowManager().getDefaultDisplay().getHeight();
        this.qfZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qfZ.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(81281);
                ScanTranslationCaptureUI.this.qbx.setAlpha(0.0f);
                AppMethodBeat.o(81281);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(81282);
                ScanTranslationCaptureUI.this.qbx.setAlpha(0.0f);
                AppMethodBeat.o(81282);
            }
        });
        this.qfZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(81255);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue <= 0.1f) {
                    ScanTranslationCaptureUI.this.qbx.setAlpha(floatValue * 10.0f);
                } else if (floatValue >= 0.9f) {
                    ScanTranslationCaptureUI.this.qbx.setAlpha((1.0f - floatValue) * 10.0f);
                }
                ScanTranslationCaptureUI.this.qbx.setTranslationY(floatValue * ((float) (ScanTranslationCaptureUI.this.iev - ScanTranslationCaptureUI.this.qbx.getHeight())));
                AppMethodBeat.o(81255);
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qfN.getLayoutParams();
        layoutParams.bottomMargin += ae.fr(this);
        this.qfN.setLayoutParams(layoutParams);
        this.qfZ.setDuration(5000);
        com.tencent.mm.ui.base.b.a(this, null);
        this.gnR.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(81257);
                if (ScanTranslationCaptureUI.this.fwt == 0 && view == ScanTranslationCaptureUI.this.gnR) {
                    if (motionEvent.getAction() == 0) {
                        ab.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                        float x = motionEvent.getX() / ((float) ScanTranslationCaptureUI.this.gnR.getWidth());
                        float y = motionEvent.getY() / ((float) ScanTranslationCaptureUI.this.gnR.getHeight());
                        h h = ScanTranslationCaptureUI.this.qba;
                        AnonymousClass1 anonymousClass1 = new AutoFocusCallback() {
                            public final void onAutoFocus(boolean z, Camera camera) {
                                AppMethodBeat.i(81256);
                                ab.i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
                                ScanTranslationCaptureUI.this.qba.cancelAutoFocus();
                                ScanTranslationCaptureUI.this.qba.cie();
                                AppMethodBeat.o(81256);
                            }
                        };
                        int i = (int) (2000.0f * x);
                        int i2 = (int) (2000.0f * y);
                        try {
                            ab.i("MicroMsg.scanner.ScanCamera", "fx %f, fy %f, x %d, y %d", Float.valueOf(x), Float.valueOf(y), Integer.valueOf(i), Integer.valueOf(i2));
                            Rect rect = new Rect();
                            if (!h.lUI || h.qhS) {
                                rect.left = (i - 1000) - 250;
                                rect.right = (i - 1000) + 250;
                                rect.top = (i2 - 1000) - 250;
                                rect.bottom = (i2 - 1000) + 250;
                            } else {
                                rect.left = (i2 - 1000) - 250;
                                rect.right = (i2 - 1000) + 250;
                                rect.top = ((2000 - i) - 1000) - 250;
                                rect.bottom = ((2000 - i) - 1000) + 250;
                            }
                            Parameters parameters = h.erH.getParameters();
                            if (rect.left < -1000) {
                                rect.left = -1000;
                            }
                            if (rect.right > 1000) {
                                rect.right = 1000;
                            }
                            if (rect.top < -1000) {
                                rect.top = -1000;
                            }
                            if (rect.bottom > 1000) {
                                rect.bottom = 1000;
                            }
                            ab.i("MicroMsg.scanner.ScanCamera", "focus area, %s", rect);
                            Rect rect2 = new Rect(rect);
                            if (parameters.getMaxNumMeteringAreas() > 0) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(new Area(rect2, 1000));
                                parameters.setMeteringAreas(arrayList);
                                if (parameters.getMaxNumFocusAreas() > 0) {
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(new Area(rect, 1000));
                                    parameters.setFocusAreas(arrayList2);
                                    h.erH.cancelAutoFocus();
                                    if (h.erH != null && h.lUE) {
                                        List supportedFocusModes = parameters.getSupportedFocusModes();
                                        if (!(supportedFocusModes == null || !supportedFocusModes.contains("auto") || bo.isNullOrNil(parameters.getFocusMode()) || parameters.getFocusMode().equals("auto"))) {
                                            parameters.setFocusMode("auto");
                                        }
                                    }
                                    h.erH.setParameters(parameters);
                                    h.erH.autoFocus(anonymousClass1);
                                } else {
                                    ab.i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support area focus");
                                }
                            } else {
                                ab.i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support set metering area");
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea error: %s", e.getMessage());
                        }
                    }
                    AppMethodBeat.o(81257);
                    return true;
                }
                AppMethodBeat.o(81257);
                return false;
            }
        });
        chB();
        this.qga = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.qga.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(81258);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int height = ((RelativeLayout.LayoutParams) ScanTranslationCaptureUI.this.qfM.getLayoutParams()).bottomMargin + ScanTranslationCaptureUI.this.qfM.getHeight();
                ScanTranslationCaptureUI.this.qfM.setTranslationY(((float) height) * floatValue);
                ScanTranslationCaptureUI.this.qfS.setTranslationY(((float) (((RelativeLayout.LayoutParams) ScanTranslationCaptureUI.this.qfS.getLayoutParams()).bottomMargin + (ScanTranslationCaptureUI.this.qfS.getHeight() + height))) * floatValue);
                AppMethodBeat.o(81258);
            }
        });
        this.qga.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(81259);
                ScanTranslationCaptureUI.this.qgd = false;
                ScanTranslationCaptureUI.this.qfY.setVisibility(8);
                AppMethodBeat.o(81259);
            }
        });
        this.qga.setDuration(300);
        mk mkVar = new mk();
        mkVar.cIp.action = 1;
        com.tencent.mm.sdk.b.a.xxA.m(mkVar);
        AppMethodBeat.o(81285);
    }

    private void chB() {
        AppMethodBeat.i(81286);
        aa.dor().equalsIgnoreCase("zh_CN");
        this.qgc = aa.gw(this);
        ab.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", this.qgc);
        AppMethodBeat.o(81286);
    }

    public void onResume() {
        AppMethodBeat.i(81288);
        super.onResume();
        aFH();
        g.Rg().a((int) com.tencent.view.d.MIC_PTU_WU, (f) this);
        g.RO().a(this.qgg);
        if (this.gwZ) {
            ab.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null)));
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null)) {
                cdJ();
                AppMethodBeat.o(81288);
                return;
            }
            AppMethodBeat.o(81288);
            return;
        }
        chD();
        AppMethodBeat.o(81288);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(81289);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(81289);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(81289);
        return onKeyDown;
    }

    public void onStop() {
        AppMethodBeat.i(81290);
        super.onStop();
        btW();
        g.Rg().b((int) com.tencent.view.d.MIC_PTU_WU, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.qbL);
        g.RO().b(this.qgg);
        AppMethodBeat.o(81290);
    }

    public void onDestroy() {
        AppMethodBeat.i(81291);
        super.onDestroy();
        this.qga.removeAllUpdateListeners();
        this.qfZ.removeAllUpdateListeners();
        AppMethodBeat.o(81291);
    }

    private void goBack() {
        AppMethodBeat.i(81292);
        e.cgy().pYN.cim();
        if (this.fwt != 0) {
            if (this.fwt == 1 || this.fwt == 2 || this.fwt == 3) {
                if (this.fwt == 1) {
                    this.qge.cXa = (long) ((int) (System.currentTimeMillis() - this.qgf[1]));
                }
                if (this.qge.cWX != 0) {
                    this.qge.ajK();
                }
                chG();
            }
            AppMethodBeat.o(81292);
        } else if (this.qgd) {
            ab.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
            AppMethodBeat.o(81292);
        } else {
            this.qga.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(138493);
                    mk mkVar = new mk();
                    mkVar.cIp.action = 3;
                    com.tencent.mm.sdk.b.a.xxA.m(mkVar);
                    ScanTranslationCaptureUI.this.qgd = false;
                    ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
                    ScanTranslationCaptureUI.this.finish();
                    AppMethodBeat.o(138493);
                }
            });
            this.qga.reverse();
            this.qgd = true;
            AppMethodBeat.o(81292);
        }
    }

    private void cdJ() {
        AppMethodBeat.i(81293);
        if (com.tencent.mm.compatible.f.b.Mj()) {
            chD();
            AppMethodBeat.o(81293);
            return;
        }
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.tu), getString(R.string.rx), getString(R.string.ry), true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(138494);
                com.tencent.mm.compatible.f.b.bE(ScanTranslationCaptureUI.this);
                ScanTranslationCaptureUI.this.finish();
                AppMethodBeat.o(138494);
            }
        });
        AppMethodBeat.o(81293);
    }

    private void chC() {
        AppMethodBeat.i(81294);
        try {
            if (!this.qba.isOpen()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.qba.open();
                this.qba.a(new PreviewCallback() {
                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    }
                });
                ab.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.qbA));
                this.qba.cie();
                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.qba.e(new Point(rect.width(), rect.height()));
                if (this.fwt == 0) {
                    chG();
                }
                this.qbA = 0;
            }
            AppMethodBeat.o(81294);
        } catch (Exception e) {
            ab.e("MicroMsg.ScanTranslationCaptureUI", e.getMessage());
            this.qbA++;
            if (this.qbA >= 5) {
                chd();
                AppMethodBeat.o(81294);
                return;
            }
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(138495);
                    ScanTranslationCaptureUI.A(ScanTranslationCaptureUI.this);
                    AppMethodBeat.o(138495);
                }
            }, 30);
            AppMethodBeat.o(81294);
        }
    }

    private void btW() {
        AppMethodBeat.i(81295);
        stopPreview();
        this.qba.release();
        AppMethodBeat.o(81295);
    }

    private void stopPreview() {
        AppMethodBeat.i(81296);
        try {
            if (this.qba.lUE) {
                this.qba.stopPreview();
            }
            AppMethodBeat.o(81296);
        } catch (Exception e) {
            ab.e("MicroMsg.ScanTranslationCaptureUI", e.getMessage());
            chd();
            AppMethodBeat.o(81296);
        }
    }

    private void startPreview() {
        AppMethodBeat.i(81297);
        try {
            if (this.bsb == null || !this.qba.isOpen() || this.qba.lUE) {
                ab.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
                AppMethodBeat.o(81297);
                return;
            }
            ab.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
            this.qba.h(this.bsb);
            this.qfK.setEnabled(true);
            AppMethodBeat.o(81297);
        } catch (Exception e) {
            ab.e("MicroMsg.ScanTranslationCaptureUI", e.getMessage());
            chd();
            AppMethodBeat.o(81297);
        }
    }

    private void chd() {
        AppMethodBeat.i(81298);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dya), getString(R.string.tz), false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(138496);
                ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
                ScanTranslationCaptureUI.this.finish();
                ScanTranslationCaptureUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(138496);
            }
        });
        AppMethodBeat.o(81298);
    }

    private void chD() {
        AppMethodBeat.i(81299);
        ab.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", Integer.valueOf(this.fwt));
        if (!this.qba.isOpen()) {
            chC();
        }
        if (this.fwt == 0 && this.qba.isOpen()) {
            chG();
        }
        AppMethodBeat.o(81299);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(81300);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(81300);
            return;
        }
        ab.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    this.gwZ = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(81270);
                            ScanTranslationCaptureUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            ScanTranslationCaptureUI.this.gwZ = true;
                            ScanTranslationCaptureUI.this.finish();
                            AppMethodBeat.o(81270);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(81271);
                            ScanTranslationCaptureUI.this.gwZ = true;
                            ScanTranslationCaptureUI.this.finish();
                            AppMethodBeat.o(81271);
                        }
                    });
                    break;
                }
                cdJ();
                AppMethodBeat.o(81300);
                return;
                break;
        }
        AppMethodBeat.o(81300);
    }

    private void aFH() {
        AppMethodBeat.i(81301);
        getWindow().addFlags(2097280);
        int i = 1542;
        if (VERSION.SDK_INT >= 19) {
            i = 5638;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
        AppMethodBeat.o(81301);
    }

    private void chE() {
        AppMethodBeat.i(81302);
        getWindow().getDecorView().setSystemUiVisibility(1540);
        AppMethodBeat.o(81302);
    }

    private void chF() {
        AppMethodBeat.i(81303);
        stopPreview();
        if (g.Rg().acS() == 6 || g.Rg().acS() == 4) {
            this.qge.cWX = 2;
            this.qgb = (int) ((((long) com.tencent.mm.model.r.Yz().hashCode()) + System.currentTimeMillis()) & -1);
            this.fwt = 1;
            this.mController.showTitleView();
            chE();
            chB();
            if (this.qgc.equalsIgnoreCase("zh_CN")) {
                this.qfO.setImageResource(R.raw.translation_result_chinese);
            } else {
                this.qfO.setImageResource(R.raw.translation_result_english);
            }
            this.qfQ.setVisibility(0);
            this.qfR.setVisibility(0);
            this.qfN.setVisibility(8);
            this.qbx.setVisibility(0);
            this.qfM.setVisibility(8);
            this.qfY.setVisibility(0);
            this.qfS.setVisibility(8);
            this.qfZ.setRepeatMode(1);
            this.qfZ.setRepeatCount(-1);
            this.qfZ.start();
            try {
                if (!(bo.isNullOrNil(this.fWz) || this.qfT == null)) {
                    this.qfW = p.Wr(this.fWz);
                    String str = this.fWz;
                    long currentTimeMillis;
                    if (this.cvd == 0) {
                        currentTimeMillis = System.currentTimeMillis();
                        d.a(this.qfT, 80, CompressFormat.JPEG, this.fWz, false);
                        ab.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                        ab.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", Long.valueOf(com.tencent.mm.vfs.e.asZ(this.fWz)));
                    } else if (this.cvd == 1) {
                        eb Wf = e.cgy().cgD().Wf(ag.ck(this.fWz + com.tencent.mm.vfs.e.ata(this.fWz)));
                        if (Wf != null) {
                            ab.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
                            this.qfV = Wf.field_resultFile;
                            this.qfU = d.decodeFile(this.qfV, new Options());
                            if (this.qfU != null) {
                                al.n(new Runnable() {
                                    {
                                        AppMethodBeat.i(81260);
                                        AppMethodBeat.o(81260);
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(138488);
                                        ScanTranslationCaptureUI.v(ScanTranslationCaptureUI.this);
                                        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.qfU);
                                        AppMethodBeat.o(138488);
                                    }
                                }, 500);
                            } else {
                                ab.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
                            }
                        }
                        if (this.eYR != 0) {
                            currentTimeMillis = System.currentTimeMillis();
                            e.cgy();
                            str = e.Wc("jpg");
                            d.a(this.qfT, 80, CompressFormat.JPEG, str, false);
                            ab.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                            ab.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", Long.valueOf(com.tencent.mm.vfs.e.asZ(str)));
                        }
                    }
                    this.qgf[1] = System.currentTimeMillis();
                    e.cgy().pYM.a(this.qfW, str, com.tencent.mm.i.a.MediaType_IMAGE, new com.tencent.mm.plugin.scanner.util.p.a() {
                        public final void a(String str, p.b bVar) {
                            AppMethodBeat.i(138492);
                            if (!bo.isNullOrNil(str) && str.equals(ScanTranslationCaptureUI.this.qfW)) {
                                ScanTranslationCaptureUI.this.qge.cWY = (long) ((int) (System.currentTimeMillis() - ScanTranslationCaptureUI.this.qgf[1]));
                                ab.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", Long.valueOf(ScanTranslationCaptureUI.this.qge.cWY));
                                switch (bVar.errCode) {
                                    case -21009:
                                    case -21000:
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(138491);
                                                com.tencent.mm.ui.base.h.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.bss), ScanTranslationCaptureUI.this.getString(R.string.tz), new DialogInterface.OnClickListener() {
                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.i(138490);
                                                        ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                                                        AppMethodBeat.o(138490);
                                                    }
                                                });
                                                AppMethodBeat.o(138491);
                                            }
                                        });
                                        ScanTranslationCaptureUI.this.qge.cWX = 3;
                                        break;
                                    case 0:
                                        if (!bo.Q(bVar.fileId, bVar.aeskey)) {
                                            ab.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", bVar.fileId);
                                            g.Rg().a(new com.tencent.mm.plugin.scanner.a.e(ScanTranslationCaptureUI.this.qgb, com.tencent.mm.a.e.cs(str), bVar.fileId, bVar.aeskey), 0);
                                            break;
                                        }
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(138489);
                                                ScanTranslationCaptureUI.this.qge.cWX = 3;
                                                com.tencent.mm.ui.base.h.bQ(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.dyv));
                                                AppMethodBeat.o(138489);
                                            }
                                        });
                                        break;
                                }
                                if (ScanTranslationCaptureUI.this.fwt == 1 && ScanTranslationCaptureUI.this.eYR != 0) {
                                    ab.i("delete tmp path %s", str);
                                    com.tencent.mm.vfs.e.deleteFile(str);
                                }
                            }
                            AppMethodBeat.o(138492);
                        }
                    });
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "", new Object[0]);
            }
            g.Rg().a((int) com.tencent.view.d.MIC_PTU_WU, (f) this);
            AppMethodBeat.o(81303);
            return;
        }
        com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.dy9), "", true);
        chG();
        AppMethodBeat.o(81303);
    }

    private void chG() {
        AppMethodBeat.i(81304);
        aFH();
        startPreview();
        this.mController.hideTitleView();
        this.qgf[0] = System.currentTimeMillis();
        if (this.cvd == 0 && !bo.isNullOrNil(this.fWz)) {
            com.tencent.mm.vfs.e.deleteFile(this.fWz);
        }
        this.qba.cancelAutoFocus();
        this.fwt = 0;
        this.cvd = 0;
        this.fWz = null;
        this.qfV = null;
        this.qfT = null;
        this.qfU = null;
        this.eYR = 0;
        this.qfQ.setVisibility(8);
        this.qfR.setVisibility(8);
        this.qfM.setVisibility(0);
        this.qfN.setVisibility(8);
        this.qfY.setVisibility(8);
        this.qfI.setVisibility(0);
        this.qfS.setVisibility(0);
        this.qbx.setVisibility(8);
        chI();
        g.Rg().b((int) com.tencent.view.d.MIC_PTU_WU, (f) this);
        AppMethodBeat.o(81304);
    }

    private void chH() {
        AppMethodBeat.i(81305);
        chE();
        this.fwt = 3;
        this.qfN.setVisibility(0);
        if (this.qgc.equalsIgnoreCase("zh_CN")) {
            this.qfO.setImageResource(R.drawable.a47);
        } else {
            this.qfO.setImageResource(R.drawable.a49);
        }
        this.qbx.setVisibility(8);
        chI();
        if (this.cvd == 1 && bo.isNullOrNil(this.qfV)) {
            e.cgy();
            this.qfV = e.Wb("jpg");
            try {
                d.a(this.qfU, 80, CompressFormat.JPEG, this.qfV, false);
                com.tencent.mm.plugin.scanner.a.p pVar = new com.tencent.mm.plugin.scanner.a.p();
                pVar.field_originMD5 = ag.ck(this.fWz + com.tencent.mm.vfs.e.ata(this.fWz));
                pVar.field_resultFile = this.qfV;
                ab.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", this.qfV);
                e.cgy().cgD().b((com.tencent.mm.sdk.e.c) pVar);
                AppMethodBeat.o(81305);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "save translate result file error", new Object[0]);
            }
        }
        AppMethodBeat.o(81305);
    }

    private void chI() {
        AppMethodBeat.i(81306);
        this.qfZ.setRepeatMode(1);
        this.qfZ.setRepeatCount(0);
        this.qfZ.end();
        AppMethodBeat.o(81306);
    }

    public final int getLayoutId() {
        return R.layout.apk;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(81307);
        ab.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
        this.qfI.dAh();
        this.bsb = surfaceTexture;
        if (this.gwZ) {
            ab.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null)));
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null)) {
                cdJ();
                AppMethodBeat.o(81307);
                return;
            }
            AppMethodBeat.o(81307);
        } else if (this.qba.isOpen()) {
            chG();
            AppMethodBeat.o(81307);
        } else {
            chC();
            AppMethodBeat.o(81307);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(81308);
        ab.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", Integer.valueOf(bArr.length));
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    this.qfT = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    Point point = this.qba.lUF;
                    YuvImage yuvImage = new YuvImage(bArr, 17, point.x, point.y, null);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, point.x, point.y), 100, byteArrayOutputStream);
                    Bitmap bQ = d.bQ(byteArrayOutputStream.toByteArray());
                    int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    if (bQ != null) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        this.qfT = d.b(bQ, (float) this.qba.lUJ);
                        int currentTimeMillis4 = (int) (System.currentTimeMillis() - currentTimeMillis3);
                        ab.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", Integer.valueOf(currentTimeMillis2), Integer.valueOf(currentTimeMillis4));
                        if (this.qfT != null) {
                            e.cgy();
                            this.fWz = e.cgA() + String.format("%s_%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
                            chF();
                            R(this.qfT);
                        }
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "", new Object[0]);
                AppMethodBeat.o(81308);
                return;
            }
        }
        AppMethodBeat.o(81308);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81309);
        ab.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            List list = ((com.tencent.mm.plugin.scanner.a.e) mVar).pZB;
            if (list != null && ((com.tencent.mm.plugin.scanner.a.e) mVar).ctE == this.qgb) {
                this.qge.cWZ = (long) ((int) (System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.a.e) mVar).pZC));
                ab.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", Float.valueOf(((com.tencent.mm.plugin.scanner.a.e) mVar).angle), Integer.valueOf(list.size()));
                if (list.size() > 0) {
                    this.qge.cWX = 1;
                    com.tencent.mm.plugin.scanner.util.n nVar = e.cgy().pYN;
                    int i3 = this.qgb;
                    float f = ((com.tencent.mm.plugin.scanner.a.e) mVar).angle;
                    Bitmap bitmap = this.qfT;
                    if (!(i3 == 0 || list == null || list.size() <= 0)) {
                        if (!(nVar.qiA == 0 || i3 == nVar.qiA)) {
                            ab.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", Integer.valueOf(nVar.qiA), Integer.valueOf(i3));
                            nVar.cim();
                        }
                        nVar.qiA = i3;
                        nVar.qiB = this;
                        nVar.qiC = new com.tencent.mm.plugin.scanner.util.n.a(i3, list, f, bitmap);
                        nVar.qiC.u(new Void[0]);
                    }
                    if (!bo.isNullOrNil(((com.tencent.mm.plugin.scanner.a.e) mVar).cgF())) {
                        this.qgc = ((com.tencent.mm.plugin.scanner.a.e) mVar).cgF();
                        AppMethodBeat.o(81309);
                        return;
                    }
                }
                this.qge.cXa = (long) ((int) (System.currentTimeMillis() - this.qgf[1]));
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dyv), "", false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(81272);
                        ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                        AppMethodBeat.o(81272);
                    }
                });
            }
            AppMethodBeat.o(81309);
            return;
        }
        this.qge.cWX = 5;
        this.qge.cXa = (long) ((int) (System.currentTimeMillis() - this.qgf[1]));
        String string = getString(R.string.dyv);
        if (bo.isNullOrNil(str)) {
            str = string;
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(81273);
                ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                AppMethodBeat.o(81273);
            }
        });
        AppMethodBeat.o(81309);
    }

    private void R(Bitmap bitmap) {
        AppMethodBeat.i(138498);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(138498);
            return;
        }
        this.qfX.bitmap = bitmap;
        this.qfX.notifyDataSetChanged();
        AppMethodBeat.o(138498);
    }

    public final void b(int i, Bitmap bitmap) {
        AppMethodBeat.i(81311);
        if (bitmap != null && i == this.qgb) {
            this.qge.cXa = (long) ((int) (System.currentTimeMillis() - this.qgf[1]));
            this.qfU = bitmap;
            chH();
            R(this.qfU);
        }
        AppMethodBeat.o(81311);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(81312);
        super.onActivityResult(i, i2, intent);
        if (i == 561 && i2 == -1) {
            String i3 = com.tencent.mm.ui.tools.a.i(this, intent, com.tencent.mm.plugin.i.c.XW());
            ab.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", i3);
            if (!bo.isNullOrNil(i3)) {
                this.fWz = i3;
                this.cvd = 1;
                this.qge.cWV = 2;
                this.eYR = Exif.fromFile(i3).getOrientationInDegree();
                ab.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", Integer.valueOf(this.eYR));
                Bitmap decodeFile = d.decodeFile(i3, new Options());
                if (decodeFile != null) {
                    this.qfT = d.b(decodeFile, (float) this.eYR);
                    chF();
                    R(this.qfT);
                }
            }
        }
        AppMethodBeat.o(81312);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(81284);
        this.ylm = true;
        super.onCreate(bundle);
        this.qba = new h(this, 3, false);
        initView();
        com.tencent.mm.sdk.b.a.xxA.c(this.qbL);
        this.qge.cWV = 3;
        AppMethodBeat.o(81284);
    }
}
