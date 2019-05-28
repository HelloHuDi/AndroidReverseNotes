package com.tencent.p177mm.plugin.scanner.p504ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42027mk;
import com.tencent.p177mm.p230g.p232b.p233a.C1600r;
import com.tencent.p177mm.p230g.p711c.C9529eb;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.p740a.C21679e;
import com.tencent.p177mm.plugin.scanner.p740a.C46181p;
import com.tencent.p177mm.plugin.scanner.util.C39640h;
import com.tencent.p177mm.plugin.scanner.util.C43497p;
import com.tencent.p177mm.plugin.scanner.util.C43497p.C39642a;
import com.tencent.p177mm.plugin.scanner.util.C43497p.C43496b;
import com.tencent.p177mm.plugin.scanner.util.C46190n;
import com.tencent.p177mm.plugin.scanner.util.C46190n.C24823a;
import com.tencent.p177mm.plugin.scanner.util.C46190n.C34843b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI */
public class ScanTranslationCaptureUI extends MMActivity implements PreviewCallback, SurfaceTextureListener, C1202f, C34843b {
    private SurfaceTexture bsb;
    private int cvd = 0;
    private int eYR = 0;
    private String fWz;
    private int fwt;
    private View gnR;
    private boolean gwZ = true;
    private int iev;
    private int qbA = 0;
    private C4884c<C42027mk> qbL = new C217201();
    private C39640h qba;
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
    private C21709a qfX;
    private MMGestureGallery qfY;
    private ValueAnimator qfZ;
    private ValueAnimator qga;
    private int qgb;
    private String qgc;
    private boolean qgd;
    private C1600r qge = new C1600r();
    private long[] qgf = new long[2];
    private C1923n qgg = new C2170312();

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$11 */
    class C376111 implements Runnable {
        C376111() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138495);
            ScanTranslationCaptureUI.m33225A(ScanTranslationCaptureUI.this);
            AppMethodBeat.m2505o(138495);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$14 */
    class C1313714 implements OnClickListener {
        C1313714() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81270);
            ScanTranslationCaptureUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            ScanTranslationCaptureUI.this.gwZ = true;
            ScanTranslationCaptureUI.this.finish();
            AppMethodBeat.m2505o(81270);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$15 */
    class C1313815 implements OnClickListener {
        C1313815() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81271);
            ScanTranslationCaptureUI.this.gwZ = true;
            ScanTranslationCaptureUI.this.finish();
            AppMethodBeat.m2505o(81271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$5 */
    class C131395 extends AnimatorListenerAdapter {
        C131395() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(81259);
            ScanTranslationCaptureUI.this.qgd = false;
            ScanTranslationCaptureUI.this.qfY.setVisibility(8);
            AppMethodBeat.m2505o(81259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$12 */
    class C2170312 extends C1924a {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$12$1 */
        class C217021 implements Runnable {
            C217021() {
            }

            public final void run() {
                AppMethodBeat.m2504i(81267);
                if (!(C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4 || ScanTranslationCaptureUI.this.fwt != 1)) {
                    C30379h.m48461b(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(C25738R.string.dy9), "", true);
                    ScanTranslationCaptureUI.m33237f(ScanTranslationCaptureUI.this);
                }
                AppMethodBeat.m2505o(81267);
            }
        }

        C2170312() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(81268);
            C5004al.m7441d(new C217021());
            AppMethodBeat.m2505o(81268);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$13 */
    class C2170413 implements OnClickListener {
        C2170413() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(138496);
            ScanTranslationCaptureUI.m33257z(ScanTranslationCaptureUI.this);
            ScanTranslationCaptureUI.this.finish();
            ScanTranslationCaptureUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(138496);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$3 */
    class C217053 implements OnTouchListener {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$3$1 */
        class C217061 implements AutoFocusCallback {
            C217061() {
            }

            public final void onAutoFocus(boolean z, Camera camera) {
                AppMethodBeat.m2504i(81256);
                C4990ab.m7416i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
                ScanTranslationCaptureUI.this.qba.cancelAutoFocus();
                ScanTranslationCaptureUI.this.qba.cie();
                AppMethodBeat.m2505o(81256);
            }
        }

        C217053() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(81257);
            if (ScanTranslationCaptureUI.this.fwt == 0 && view == ScanTranslationCaptureUI.this.gnR) {
                if (motionEvent.getAction() == 0) {
                    C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                    float x = motionEvent.getX() / ((float) ScanTranslationCaptureUI.this.gnR.getWidth());
                    float y = motionEvent.getY() / ((float) ScanTranslationCaptureUI.this.gnR.getHeight());
                    C39640h h = ScanTranslationCaptureUI.this.qba;
                    C217061 c217061 = new C217061();
                    int i = (int) (2000.0f * x);
                    int i2 = (int) (2000.0f * y);
                    try {
                        C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "fx %f, fy %f, x %d, y %d", Float.valueOf(x), Float.valueOf(y), Integer.valueOf(i), Integer.valueOf(i2));
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
                        C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "focus area, %s", rect);
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
                                    if (!(supportedFocusModes == null || !supportedFocusModes.contains("auto") || C5046bo.isNullOrNil(parameters.getFocusMode()) || parameters.getFocusMode().equals("auto"))) {
                                        parameters.setFocusMode("auto");
                                    }
                                }
                                h.erH.setParameters(parameters);
                                h.erH.autoFocus(c217061);
                            } else {
                                C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support area focus");
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support set metering area");
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea error: %s", e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(81257);
                return true;
            }
            AppMethodBeat.m2505o(81257);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$4 */
    class C217074 implements AnimatorUpdateListener {
        C217074() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(81258);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int height = ((LayoutParams) ScanTranslationCaptureUI.this.qfM.getLayoutParams()).bottomMargin + ScanTranslationCaptureUI.this.qfM.getHeight();
            ScanTranslationCaptureUI.this.qfM.setTranslationY(((float) height) * floatValue);
            ScanTranslationCaptureUI.this.qfS.setTranslationY(((float) (((LayoutParams) ScanTranslationCaptureUI.this.qfS.getLayoutParams()).bottomMargin + (ScanTranslationCaptureUI.this.qfS.getHeight() + height))) * floatValue);
            AppMethodBeat.m2505o(81258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$6 */
    class C217086 implements Runnable {
        C217086() {
            AppMethodBeat.m2504i(81260);
            AppMethodBeat.m2505o(81260);
        }

        public final void run() {
            AppMethodBeat.m2504i(138488);
            ScanTranslationCaptureUI.m33253v(ScanTranslationCaptureUI.this);
            ScanTranslationCaptureUI.m33231a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.qfU);
            AppMethodBeat.m2505o(138488);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$a */
    class C21709a extends BaseAdapter {
        Bitmap bitmap;

        private C21709a() {
        }

        /* synthetic */ C21709a(ScanTranslationCaptureUI scanTranslationCaptureUI, byte b) {
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
            AppMethodBeat.m2504i(138497);
            if (view == null) {
                multiTouchImageView = new MultiTouchImageView(ScanTranslationCaptureUI.this, 0, 0);
                multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            } else {
                multiTouchImageView = (MultiTouchImageView) view;
            }
            if (this.bitmap != null) {
                multiTouchImageView.setImageBitmap(this.bitmap);
                multiTouchImageView.mo71980bW(this.bitmap.getWidth(), this.bitmap.getHeight());
                multiTouchImageView.dzA();
            }
            AppMethodBeat.m2505o(138497);
            return multiTouchImageView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$10 */
    class C2171010 implements PreviewCallback {
        C2171010() {
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$20 */
    class C2171120 implements View.OnClickListener {
        C2171120() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81277);
            C14987n.m23295a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, null);
            AppMethodBeat.m2505o(81277);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$16 */
    class C2171216 implements OnClickListener {
        C2171216() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81272);
            ScanTranslationCaptureUI.m33237f(ScanTranslationCaptureUI.this);
            AppMethodBeat.m2505o(81272);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$17 */
    class C2171317 implements OnClickListener {
        C2171317() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81273);
            ScanTranslationCaptureUI.m33237f(ScanTranslationCaptureUI.this);
            AppMethodBeat.m2505o(81273);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$19 */
    class C2171419 implements View.OnClickListener {
        C2171419() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81276);
            ScanTranslationCaptureUI.this.qba.mo62597a(ScanTranslationCaptureUI.this);
            ScanTranslationCaptureUI.this.qge.cWW = (long) ((int) (System.currentTimeMillis() - ScanTranslationCaptureUI.this.qgf[0]));
            ScanTranslationCaptureUI.this.qge.cWV = 1;
            AppMethodBeat.m2505o(81276);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$21 */
    class C2171521 implements View.OnClickListener {
        C2171521() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81278);
            if (ScanTranslationCaptureUI.this.fwt == 3) {
                if (ScanTranslationCaptureUI.this.qfT != null) {
                    ScanTranslationCaptureUI.m33231a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.qfT);
                }
                if (ScanTranslationCaptureUI.this.qgc.equalsIgnoreCase("zh_CN")) {
                    ScanTranslationCaptureUI.this.qfO.setImageResource(C1318a.translation_result_chinese_highlighted);
                } else {
                    ScanTranslationCaptureUI.this.qfO.setImageResource(C1318a.translation_result_english_highlighted);
                }
                ScanTranslationCaptureUI.this.fwt = 2;
                ScanTranslationCaptureUI.this.qge.cXb++;
                AppMethodBeat.m2505o(81278);
                return;
            }
            if (ScanTranslationCaptureUI.this.fwt == 2) {
                if (ScanTranslationCaptureUI.this.qfU != null) {
                    ScanTranslationCaptureUI.m33231a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.qfU);
                }
                if (ScanTranslationCaptureUI.this.qgc.equalsIgnoreCase("zh_CN")) {
                    ScanTranslationCaptureUI.this.qfO.setImageResource(C25738R.drawable.a47);
                } else {
                    ScanTranslationCaptureUI.this.qfO.setImageResource(C25738R.drawable.a49);
                }
                ScanTranslationCaptureUI.this.fwt = 3;
            }
            AppMethodBeat.m2505o(81278);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$23 */
    class C2171623 implements OnMenuItemClickListener {
        C2171623() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81280);
            ScanTranslationCaptureUI.m33238g(ScanTranslationCaptureUI.this);
            AppMethodBeat.m2505o(81280);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$2 */
    class C217172 implements AnimatorUpdateListener {
        C217172() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(81255);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue <= 0.1f) {
                ScanTranslationCaptureUI.this.qbx.setAlpha(floatValue * 10.0f);
            } else if (floatValue >= 0.9f) {
                ScanTranslationCaptureUI.this.qbx.setAlpha((1.0f - floatValue) * 10.0f);
            }
            ScanTranslationCaptureUI.this.qbx.setTranslationY(floatValue * ((float) (ScanTranslationCaptureUI.this.iev - ScanTranslationCaptureUI.this.qbx.getHeight())));
            AppMethodBeat.m2505o(81255);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$9 */
    class C217189 implements OnClickListener {
        C217189() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(138494);
            C37657b.m63683bE(ScanTranslationCaptureUI.this);
            ScanTranslationCaptureUI.this.finish();
            AppMethodBeat.m2505o(138494);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$18 */
    class C2171918 implements View.OnClickListener {
        C2171918() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81275);
            ScanTranslationCaptureUI.m33238g(ScanTranslationCaptureUI.this);
            AppMethodBeat.m2505o(81275);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$1 */
    class C217201 extends C4884c<C42027mk> {
        C217201() {
            AppMethodBeat.m2504i(81253);
            this.xxI = C42027mk.class.getName().hashCode();
            AppMethodBeat.m2505o(81253);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(81254);
            if (((C42027mk) c4883b).cIp.action == 2) {
                C4990ab.m7416i("MicroMsg.ScanTranslationCaptureUI", "receive play open translate anim event");
                String stringExtra = ScanTranslationCaptureUI.this.getIntent().getStringExtra("key_first_background");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    Bitmap decodeFile = C5056d.decodeFile(stringExtra, new Options());
                    if (decodeFile != null) {
                        ScanTranslationCaptureUI.this.qfY.setVisibility(0);
                        ScanTranslationCaptureUI.m33231a(ScanTranslationCaptureUI.this, decodeFile);
                        FileOp.deleteFile(stringExtra);
                    }
                }
                ScanTranslationCaptureUI.this.gnR.setAlpha(1.0f);
                ScanTranslationCaptureUI.this.qga.start();
                ScanTranslationCaptureUI.this.qfI.setVisibility(0);
                ScanTranslationCaptureUI.this.qgd = true;
                AppMethodBeat.m2505o(81254);
                return true;
            }
            AppMethodBeat.m2505o(81254);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$22 */
    class C2172122 implements View.OnClickListener {
        C2172122() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81279);
            if (ScanTranslationCaptureUI.this.fwt == 2) {
                try {
                    ScanTranslationCaptureUI.this.qge.cXd = 1;
                    C45477q.m83807a(ScanTranslationCaptureUI.this.fWz, ScanTranslationCaptureUI.this, false, -1);
                    C5670b.m8523i(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(C25738R.string.dyy));
                    AppMethodBeat.m2505o(81279);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "copy to gallery error", new Object[0]);
                    AppMethodBeat.m2505o(81279);
                    return;
                }
            }
            if (ScanTranslationCaptureUI.this.fwt == 3) {
                try {
                    ScanTranslationCaptureUI.this.qge.cXc = 1;
                    if (ScanTranslationCaptureUI.this.cvd == 0) {
                        try {
                            ScanTranslationCaptureUI scanTranslationCaptureUI = ScanTranslationCaptureUI.this;
                            C43488e.cgy();
                            scanTranslationCaptureUI.qfV = C43488e.m77693Wb("jpg");
                            C5056d.m7625a(ScanTranslationCaptureUI.this.qfU, 80, CompressFormat.JPEG, ScanTranslationCaptureUI.this.qfV, false);
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e2, "save translate result file error", new Object[0]);
                        }
                    }
                    C45477q.m83807a(ScanTranslationCaptureUI.this.qfV, ScanTranslationCaptureUI.this, false, -1);
                    C5670b.m8523i(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(C25738R.string.dyy));
                    AppMethodBeat.m2505o(81279);
                    return;
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e3, "save to gallery error", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(81279);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$24 */
    class C2172224 extends AnimatorListenerAdapter {
        C2172224() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(81281);
            ScanTranslationCaptureUI.this.qbx.setAlpha(0.0f);
            AppMethodBeat.m2505o(81281);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(81282);
            ScanTranslationCaptureUI.this.qbx.setAlpha(0.0f);
            AppMethodBeat.m2505o(81282);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$8 */
    class C217238 extends AnimatorListenerAdapter {
        C217238() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(138493);
            C42027mk c42027mk = new C42027mk();
            c42027mk.cIp.action = 3;
            C4879a.xxA.mo10055m(c42027mk);
            ScanTranslationCaptureUI.this.qgd = false;
            ScanTranslationCaptureUI.m33257z(ScanTranslationCaptureUI.this);
            ScanTranslationCaptureUI.this.finish();
            AppMethodBeat.m2505o(138493);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ScanTranslationCaptureUI() {
        AppMethodBeat.m2504i(81283);
        AppMethodBeat.m2505o(81283);
    }

    /* renamed from: A */
    static /* synthetic */ void m33225A(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.m2504i(81317);
        scanTranslationCaptureUI.chC();
        AppMethodBeat.m2505o(81317);
    }

    /* renamed from: f */
    static /* synthetic */ void m33237f(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.m2504i(81314);
        scanTranslationCaptureUI.chG();
        AppMethodBeat.m2505o(81314);
    }

    /* renamed from: g */
    static /* synthetic */ void m33238g(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.m2504i(138500);
        scanTranslationCaptureUI.goBack();
        AppMethodBeat.m2505o(138500);
    }

    /* renamed from: v */
    static /* synthetic */ void m33253v(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.m2504i(138501);
        scanTranslationCaptureUI.chH();
        AppMethodBeat.m2505o(138501);
    }

    /* renamed from: z */
    static /* synthetic */ void m33257z(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.m2504i(138502);
        scanTranslationCaptureUI.btW();
        AppMethodBeat.m2505o(138502);
    }

    public final void initView() {
        AppMethodBeat.m2504i(81285);
        this.gnR = findViewById(2131823601);
        this.gnR.setAlpha(0.0f);
        this.qfI = (MMTextureView) findViewById(2131827216);
        this.qfI.setOpaque(false);
        this.qfI.setSurfaceTextureListener(this);
        this.qfY = (MMGestureGallery) findViewById(2131827217);
        this.qfX = new C21709a(this, (byte) 0);
        this.qfY.setAdapter(this.qfX);
        this.qfM = findViewById(2131827221);
        this.qfJ = findViewById(2131824955);
        this.qfJ.setOnClickListener(new C2171918());
        this.qfK = findViewById(2131827222);
        this.qfK.setOnClickListener(new C2171419());
        this.qfK.setEnabled(false);
        this.qfS = (TextView) findViewById(2131827220);
        this.qfL = findViewById(2131827223);
        this.qfL.setOnClickListener(new C2171120());
        this.qfN = findViewById(2131827224);
        this.qfO = (ImageView) this.qfN.findViewById(2131827225);
        this.qfO.setOnClickListener(new C2171521());
        this.qfQ = findViewById(2131827218);
        this.qfR = findViewById(2131827219);
        this.mController.hideTitleView();
        setMMTitle((int) C25738R.string.dxl);
        mo17446xE(getResources().getColor(C25738R.color.a3p));
        this.qbx = (ImageView) findViewById(2131827195);
        this.qfP = this.qfN.findViewById(2131827226);
        this.qfP.setOnClickListener(new C2172122());
        setBackBtn(new C2171623());
        this.iev = getWindowManager().getDefaultDisplay().getHeight();
        this.qfZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qfZ.addListener(new C2172224());
        this.qfZ.addUpdateListener(new C217172());
        LayoutParams layoutParams = (LayoutParams) this.qfN.getLayoutParams();
        layoutParams.bottomMargin += C5222ae.m7944fr(this);
        this.qfN.setLayoutParams(layoutParams);
        this.qfZ.setDuration(5000);
        C5274b.m8045a(this, null);
        this.gnR.setOnTouchListener(new C217053());
        chB();
        this.qga = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.qga.addUpdateListener(new C217074());
        this.qga.addListener(new C131395());
        this.qga.setDuration(300);
        C42027mk c42027mk = new C42027mk();
        c42027mk.cIp.action = 1;
        C4879a.xxA.mo10055m(c42027mk);
        AppMethodBeat.m2505o(81285);
    }

    private void chB() {
        AppMethodBeat.m2504i(81286);
        C4988aa.dor().equalsIgnoreCase("zh_CN");
        this.qgc = C4988aa.m7403gw(this);
        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", this.qgc);
        AppMethodBeat.m2505o(81286);
    }

    public void onResume() {
        AppMethodBeat.m2504i(81288);
        super.onResume();
        aFH();
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_WU, (C1202f) this);
        C1720g.m3535RO().mo5187a(this.qgg);
        if (this.gwZ) {
            C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 16, null, null)));
            if (C35805b.m58707a(this, "android.permission.CAMERA", 16, null, null)) {
                cdJ();
                AppMethodBeat.m2505o(81288);
                return;
            }
            AppMethodBeat.m2505o(81288);
            return;
        }
        chD();
        AppMethodBeat.m2505o(81288);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(81289);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(81289);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(81289);
        return onKeyDown;
    }

    public void onStop() {
        AppMethodBeat.m2504i(81290);
        super.onStop();
        btW();
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_WU, (C1202f) this);
        C4879a.xxA.mo10053d(this.qbL);
        C1720g.m3535RO().mo5188b(this.qgg);
        AppMethodBeat.m2505o(81290);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(81291);
        super.onDestroy();
        this.qga.removeAllUpdateListeners();
        this.qfZ.removeAllUpdateListeners();
        AppMethodBeat.m2505o(81291);
    }

    private void goBack() {
        AppMethodBeat.m2504i(81292);
        C43488e.cgy().pYN.cim();
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
            AppMethodBeat.m2505o(81292);
        } else if (this.qgd) {
            C4990ab.m7416i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
            AppMethodBeat.m2505o(81292);
        } else {
            this.qga.addListener(new C217238());
            this.qga.reverse();
            this.qgd = true;
            AppMethodBeat.m2505o(81292);
        }
    }

    private void cdJ() {
        AppMethodBeat.m2504i(81293);
        if (C37657b.m63681Mj()) {
            chD();
            AppMethodBeat.m2505o(81293);
            return;
        }
        C30379h.m48447a((Context) this, getString(C25738R.string.f9233tu), getString(C25738R.string.f9178rx), getString(C25738R.string.f9179ry), true, new C217189());
        AppMethodBeat.m2505o(81293);
    }

    private void chC() {
        AppMethodBeat.m2504i(81294);
        try {
            if (!this.qba.isOpen()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.qba.open();
                this.qba.mo62597a(new C2171010());
                C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.qbA));
                this.qba.cie();
                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.qba.mo62607e(new Point(rect.width(), rect.height()));
                if (this.fwt == 0) {
                    chG();
                }
                this.qbA = 0;
            }
            AppMethodBeat.m2505o(81294);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ScanTranslationCaptureUI", e.getMessage());
            this.qbA++;
            if (this.qbA >= 5) {
                chd();
                AppMethodBeat.m2505o(81294);
                return;
            }
            C5004al.m7442n(new C376111(), 30);
            AppMethodBeat.m2505o(81294);
        }
    }

    private void btW() {
        AppMethodBeat.m2504i(81295);
        stopPreview();
        this.qba.release();
        AppMethodBeat.m2505o(81295);
    }

    private void stopPreview() {
        AppMethodBeat.m2504i(81296);
        try {
            if (this.qba.lUE) {
                this.qba.stopPreview();
            }
            AppMethodBeat.m2505o(81296);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ScanTranslationCaptureUI", e.getMessage());
            chd();
            AppMethodBeat.m2505o(81296);
        }
    }

    private void startPreview() {
        AppMethodBeat.m2504i(81297);
        try {
            if (this.bsb == null || !this.qba.isOpen() || this.qba.lUE) {
                C4990ab.m7416i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
                AppMethodBeat.m2505o(81297);
                return;
            }
            C4990ab.m7416i("MicroMsg.ScanTranslationCaptureUI", "start preview");
            this.qba.mo62609h(this.bsb);
            this.qfK.setEnabled(true);
            AppMethodBeat.m2505o(81297);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ScanTranslationCaptureUI", e.getMessage());
            chd();
            AppMethodBeat.m2505o(81297);
        }
    }

    private void chd() {
        AppMethodBeat.m2504i(81298);
        C30379h.m48448a((Context) this, getString(C25738R.string.dya), getString(C25738R.string.f9238tz), false, new C2170413());
        AppMethodBeat.m2505o(81298);
    }

    private void chD() {
        AppMethodBeat.m2504i(81299);
        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "curState %d", Integer.valueOf(this.fwt));
        if (!this.qba.isOpen()) {
            chC();
        }
        if (this.fwt == 0 && this.qba.isOpen()) {
            chG();
        }
        AppMethodBeat.m2505o(81299);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(81300);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(81300);
            return;
        }
        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    this.gwZ = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C1313714(), new C1313815());
                    break;
                }
                cdJ();
                AppMethodBeat.m2505o(81300);
                return;
                break;
        }
        AppMethodBeat.m2505o(81300);
    }

    private void aFH() {
        AppMethodBeat.m2504i(81301);
        getWindow().addFlags(2097280);
        int i = 1542;
        if (VERSION.SDK_INT >= 19) {
            i = 5638;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
        AppMethodBeat.m2505o(81301);
    }

    private void chE() {
        AppMethodBeat.m2504i(81302);
        getWindow().getDecorView().setSystemUiVisibility(1540);
        AppMethodBeat.m2505o(81302);
    }

    private void chF() {
        AppMethodBeat.m2504i(81303);
        stopPreview();
        if (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4) {
            this.qge.cWX = 2;
            this.qgb = (int) ((((long) C1853r.m3846Yz().hashCode()) + System.currentTimeMillis()) & -1);
            this.fwt = 1;
            this.mController.showTitleView();
            chE();
            chB();
            if (this.qgc.equalsIgnoreCase("zh_CN")) {
                this.qfO.setImageResource(C1318a.translation_result_chinese);
            } else {
                this.qfO.setImageResource(C1318a.translation_result_english);
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
                if (!(C5046bo.isNullOrNil(this.fWz) || this.qfT == null)) {
                    this.qfW = C43497p.m77717Wr(this.fWz);
                    String str = this.fWz;
                    long currentTimeMillis;
                    if (this.cvd == 0) {
                        currentTimeMillis = System.currentTimeMillis();
                        C5056d.m7625a(this.qfT, 80, CompressFormat.JPEG, this.fWz, false);
                        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", Long.valueOf(C5730e.asZ(this.fWz)));
                    } else if (this.cvd == 1) {
                        C9529eb Wf = C43488e.cgy().cgD().mo25148Wf(C4995ag.m7428ck(this.fWz + C5730e.ata(this.fWz)));
                        if (Wf != null) {
                            C4990ab.m7416i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
                            this.qfV = Wf.field_resultFile;
                            this.qfU = C5056d.decodeFile(this.qfV, new Options());
                            if (this.qfU != null) {
                                C5004al.m7442n(new C217086(), 500);
                            } else {
                                C4990ab.m7420w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
                            }
                        }
                        if (this.eYR != 0) {
                            currentTimeMillis = System.currentTimeMillis();
                            C43488e.cgy();
                            str = C43488e.m77694Wc("jpg");
                            C5056d.m7625a(this.qfT, 80, CompressFormat.JPEG, str, false);
                            C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                            C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", Long.valueOf(C5730e.asZ(str)));
                        }
                    }
                    this.qgf[1] = System.currentTimeMillis();
                    C43488e.cgy().pYM.mo69045a(this.qfW, str, C42129a.MediaType_IMAGE, new C39642a() {

                        /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$7$1 */
                        class C131411 implements Runnable {
                            C131411() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(138489);
                                ScanTranslationCaptureUI.this.qge.cWX = 3;
                                C30379h.m48465bQ(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(C25738R.string.dyv));
                                AppMethodBeat.m2505o(138489);
                            }
                        }

                        /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$7$2 */
                        class C131422 implements Runnable {

                            /* renamed from: com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI$7$2$1 */
                            class C131431 implements OnClickListener {
                                C131431() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(138490);
                                    ScanTranslationCaptureUI.m33237f(ScanTranslationCaptureUI.this);
                                    AppMethodBeat.m2505o(138490);
                                }
                            }

                            C131422() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(138491);
                                C30379h.m48438a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(C25738R.string.bss), ScanTranslationCaptureUI.this.getString(C25738R.string.f9238tz), new C131431());
                                AppMethodBeat.m2505o(138491);
                            }
                        }

                        /* renamed from: a */
                        public final void mo25164a(String str, C43496b c43496b) {
                            AppMethodBeat.m2504i(138492);
                            if (!C5046bo.isNullOrNil(str) && str.equals(ScanTranslationCaptureUI.this.qfW)) {
                                ScanTranslationCaptureUI.this.qge.cWY = (long) ((int) (System.currentTimeMillis() - ScanTranslationCaptureUI.this.qgf[1]));
                                C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", Long.valueOf(ScanTranslationCaptureUI.this.qge.cWY));
                                switch (c43496b.errCode) {
                                    case -21009:
                                    case -21000:
                                        C5004al.m7441d(new C131422());
                                        ScanTranslationCaptureUI.this.qge.cWX = 3;
                                        break;
                                    case 0:
                                        if (!C5046bo.m7510Q(c43496b.fileId, c43496b.aeskey)) {
                                            C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", c43496b.fileId);
                                            C1720g.m3540Rg().mo14541a(new C21679e(ScanTranslationCaptureUI.this.qgb, C1173e.m2560cs(str), c43496b.fileId, c43496b.aeskey), 0);
                                            break;
                                        }
                                        C5004al.m7441d(new C131411());
                                        break;
                                }
                                if (ScanTranslationCaptureUI.this.fwt == 1 && ScanTranslationCaptureUI.this.eYR != 0) {
                                    C4990ab.m7416i("delete tmp path %s", str);
                                    C5730e.deleteFile(str);
                                }
                            }
                            AppMethodBeat.m2505o(138492);
                        }
                    });
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "", new Object[0]);
            }
            C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_WU, (C1202f) this);
            AppMethodBeat.m2505o(81303);
            return;
        }
        C30379h.m48461b((Context) this, getString(C25738R.string.dy9), "", true);
        chG();
        AppMethodBeat.m2505o(81303);
    }

    private void chG() {
        AppMethodBeat.m2504i(81304);
        aFH();
        startPreview();
        this.mController.hideTitleView();
        this.qgf[0] = System.currentTimeMillis();
        if (this.cvd == 0 && !C5046bo.isNullOrNil(this.fWz)) {
            C5730e.deleteFile(this.fWz);
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
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_WU, (C1202f) this);
        AppMethodBeat.m2505o(81304);
    }

    private void chH() {
        AppMethodBeat.m2504i(81305);
        chE();
        this.fwt = 3;
        this.qfN.setVisibility(0);
        if (this.qgc.equalsIgnoreCase("zh_CN")) {
            this.qfO.setImageResource(C25738R.drawable.a47);
        } else {
            this.qfO.setImageResource(C25738R.drawable.a49);
        }
        this.qbx.setVisibility(8);
        chI();
        if (this.cvd == 1 && C5046bo.isNullOrNil(this.qfV)) {
            C43488e.cgy();
            this.qfV = C43488e.m77693Wb("jpg");
            try {
                C5056d.m7625a(this.qfU, 80, CompressFormat.JPEG, this.qfV, false);
                C46181p c46181p = new C46181p();
                c46181p.field_originMD5 = C4995ag.m7428ck(this.fWz + C5730e.ata(this.fWz));
                c46181p.field_resultFile = this.qfV;
                C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", this.qfV);
                C43488e.cgy().cgD().mo10101b((C4925c) c46181p);
                AppMethodBeat.m2505o(81305);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "save translate result file error", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(81305);
    }

    private void chI() {
        AppMethodBeat.m2504i(81306);
        this.qfZ.setRepeatMode(1);
        this.qfZ.setRepeatCount(0);
        this.qfZ.end();
        AppMethodBeat.m2505o(81306);
    }

    public final int getLayoutId() {
        return 2130970552;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(81307);
        C4990ab.m7416i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
        this.qfI.dAh();
        this.bsb = surfaceTexture;
        if (this.gwZ) {
            C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 16, null, null)));
            if (C35805b.m58707a(this, "android.permission.CAMERA", 16, null, null)) {
                cdJ();
                AppMethodBeat.m2505o(81307);
                return;
            }
            AppMethodBeat.m2505o(81307);
        } else if (this.qba.isOpen()) {
            chG();
            AppMethodBeat.m2505o(81307);
        } else {
            chC();
            AppMethodBeat.m2505o(81307);
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
        AppMethodBeat.m2504i(81308);
        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", Integer.valueOf(bArr.length));
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    this.qfT = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    Point point = this.qba.lUF;
                    YuvImage yuvImage = new YuvImage(bArr, 17, point.x, point.y, null);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, point.x, point.y), 100, byteArrayOutputStream);
                    Bitmap bQ = C5056d.m7652bQ(byteArrayOutputStream.toByteArray());
                    int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    if (bQ != null) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        this.qfT = C5056d.m7648b(bQ, (float) this.qba.lUJ);
                        int currentTimeMillis4 = (int) (System.currentTimeMillis() - currentTimeMillis3);
                        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", Integer.valueOf(currentTimeMillis2), Integer.valueOf(currentTimeMillis4));
                        if (this.qfT != null) {
                            C43488e.cgy();
                            this.fWz = C43488e.cgA() + String.format("%s_%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
                            chF();
                            m33227R(this.qfT);
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(81308);
                return;
            }
        }
        AppMethodBeat.m2505o(81308);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81309);
        C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            List list = ((C21679e) c1207m).pZB;
            if (list != null && ((C21679e) c1207m).ctE == this.qgb) {
                this.qge.cWZ = (long) ((int) (System.currentTimeMillis() - ((C21679e) c1207m).pZC));
                C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", Float.valueOf(((C21679e) c1207m).angle), Integer.valueOf(list.size()));
                if (list.size() > 0) {
                    this.qge.cWX = 1;
                    C46190n c46190n = C43488e.cgy().pYN;
                    int i3 = this.qgb;
                    float f = ((C21679e) c1207m).angle;
                    Bitmap bitmap = this.qfT;
                    if (!(i3 == 0 || list == null || list.size() <= 0)) {
                        if (!(c46190n.qiA == 0 || i3 == c46190n.qiA)) {
                            C4990ab.m7417i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", Integer.valueOf(c46190n.qiA), Integer.valueOf(i3));
                            c46190n.cim();
                        }
                        c46190n.qiA = i3;
                        c46190n.qiB = this;
                        c46190n.qiC = new C24823a(i3, list, f, bitmap);
                        c46190n.qiC.mo38881u(new Void[0]);
                    }
                    if (!C5046bo.isNullOrNil(((C21679e) c1207m).cgF())) {
                        this.qgc = ((C21679e) c1207m).cgF();
                        AppMethodBeat.m2505o(81309);
                        return;
                    }
                }
                this.qge.cXa = (long) ((int) (System.currentTimeMillis() - this.qgf[1]));
                C30379h.m48448a((Context) this, getString(C25738R.string.dyv), "", false, new C2171216());
            }
            AppMethodBeat.m2505o(81309);
            return;
        }
        this.qge.cWX = 5;
        this.qge.cXa = (long) ((int) (System.currentTimeMillis() - this.qgf[1]));
        String string = getString(C25738R.string.dyv);
        if (C5046bo.isNullOrNil(str)) {
            str = string;
        }
        C30379h.m48448a((Context) this, str, "", false, new C2171317());
        AppMethodBeat.m2505o(81309);
    }

    /* renamed from: R */
    private void m33227R(Bitmap bitmap) {
        AppMethodBeat.m2504i(138498);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(138498);
            return;
        }
        this.qfX.bitmap = bitmap;
        this.qfX.notifyDataSetChanged();
        AppMethodBeat.m2505o(138498);
    }

    /* renamed from: b */
    public final void mo37175b(int i, Bitmap bitmap) {
        AppMethodBeat.m2504i(81311);
        if (bitmap != null && i == this.qgb) {
            this.qge.cXa = (long) ((int) (System.currentTimeMillis() - this.qgf[1]));
            this.qfU = bitmap;
            chH();
            m33227R(this.qfU);
        }
        AppMethodBeat.m2505o(81311);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(81312);
        super.onActivityResult(i, i2, intent);
        if (i == 561 && i2 == -1) {
            String i3 = C36338a.m59824i(this, intent, C43217c.m76863XW());
            C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", i3);
            if (!C5046bo.isNullOrNil(i3)) {
                this.fWz = i3;
                this.cvd = 1;
                this.qge.cWV = 2;
                this.eYR = Exif.fromFile(i3).getOrientationInDegree();
                C4990ab.m7417i("MicroMsg.ScanTranslationCaptureUI", "degree %s", Integer.valueOf(this.eYR));
                Bitmap decodeFile = C5056d.decodeFile(i3, new Options());
                if (decodeFile != null) {
                    this.qfT = C5056d.m7648b(decodeFile, (float) this.eYR);
                    chF();
                    m33227R(this.qfT);
                }
            }
        }
        AppMethodBeat.m2505o(81312);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(81284);
        this.ylm = true;
        super.onCreate(bundle);
        this.qba = new C39640h(this, 3, false);
        initView();
        C4879a.xxA.mo10052c(this.qbL);
        this.qge.cWV = 3;
        AppMethodBeat.m2505o(81284);
    }
}
