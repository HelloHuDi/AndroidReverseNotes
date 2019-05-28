package com.tencent.p177mm.pluginsdk.p1082i;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
import android.view.SurfaceHolder;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C26045h;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.compatible.p221e.C9241g;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.i.g */
public final class C44054g implements SensorEventListener {
    private static int otM = 0;
    private SensorManager bCW;
    public C41938t erH = null;
    C32470a fbb;
    private PreviewCallback mPreviewCallback = null;
    private boolean otL = false;
    private Sensor otO;
    private float otP = 0.0f;
    private float otQ = 0.0f;
    private float otR = 0.0f;
    private SurfaceHolder szR = null;
    private C40435a vge;
    public List<Integer> vgf = new ArrayList();
    private boolean vgg = true;
    private boolean vgh = true;
    private AutoFocusCallback vgi = new C404361();

    /* renamed from: com.tencent.mm.pluginsdk.i.g$1 */
    class C404361 implements AutoFocusCallback {
        C404361() {
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.m2504i(27483);
            C4990ab.m7410d("MicroMsg.YuvReocrder", "auto focus callback");
            C44054g.this.vgh = true;
            AppMethodBeat.m2505o(27483);
        }
    }

    public C44054g() {
        AppMethodBeat.m2504i(27484);
        AppMethodBeat.m2505o(27484);
    }

    public static int getCameraId() {
        return otM;
    }

    public final void bPl() {
        AppMethodBeat.m2504i(27485);
        if (!(this.bCW == null || this.otO == null)) {
            this.bCW.unregisterListener(this);
        }
        if (this.erH != null) {
            C4990ab.m7410d("MicroMsg.YuvReocrder", "release camera");
            this.erH.setPreviewCallback(null);
            this.erH.stopPreview();
            this.erH.release();
            this.erH = null;
            this.otL = false;
        }
        AppMethodBeat.m2505o(27485);
    }

    @TargetApi(9)
    /* renamed from: g */
    private static void m79185g(Parameters parameters) {
        AppMethodBeat.m2504i(27486);
        if (C1427q.etc.eri > 0) {
            AppMethodBeat.m2505o(27486);
        } else if (VERSION.SDK_INT < 9) {
            AppMethodBeat.m2505o(27486);
        } else {
            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
                AppMethodBeat.m2505o(27486);
                return;
            }
            int size = supportedPreviewFpsRange.size();
            int i = 0;
            int i2 = C8415j.INVALID_ID;
            int i3 = C8415j.INVALID_ID;
            while (i < size) {
                int i4;
                int i5;
                int[] iArr = (int[]) supportedPreviewFpsRange.get(i);
                if (iArr != null && iArr.length > 1) {
                    i4 = iArr[0];
                    i5 = iArr[1];
                    C4990ab.m7411d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5));
                    if (i4 >= 0 && i5 >= i4 && i5 >= i2) {
                        i++;
                        i2 = i5;
                        i3 = i4;
                    }
                }
                i5 = i2;
                i4 = i3;
                i++;
                i2 = i5;
                i3 = i4;
            }
            C4990ab.m7411d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", Integer.valueOf(i3), Integer.valueOf(i2));
            if (i3 == BaseClientBuilder.API_PRIORITY_OTHER || i2 == BaseClientBuilder.API_PRIORITY_OTHER) {
                AppMethodBeat.m2505o(27486);
                return;
            }
            try {
                parameters.setPreviewFpsRange(i3, i2);
                AppMethodBeat.m2505o(27486);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                AppMethodBeat.m2505o(27486);
            }
        }
    }

    /* renamed from: b */
    public final int mo69743b(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(27487);
        int line;
        if (this.otL) {
            AppMethodBeat.m2505o(27487);
            return 0;
        } else if (surfaceHolder == null) {
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(27487);
            return line;
        } else {
            try {
                List supportedVideoSizes;
                List supportedPreviewSizes;
                this.szR = surfaceHolder;
                Parameters parameters = this.erH.getParameters();
                C40435a c40435a = this.vge;
                C4990ab.m7410d("MicroMsg.YuvReocrder", "getFitRecordSize");
                int i = BaseClientBuilder.API_PRIORITY_OTHER;
                if (VERSION.SDK_INT >= 11) {
                    C26045h c26045h = new C26045h();
                    supportedVideoSizes = parameters.getSupportedVideoSizes();
                } else {
                    supportedVideoSizes = null;
                }
                if (supportedVideoSizes == null) {
                    C4990ab.m7410d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                    C9241g c9241g = new C9241g();
                    supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                } else {
                    supportedPreviewSizes = supportedVideoSizes;
                }
                Size previewSize;
                if (supportedPreviewSizes != null) {
                    int i2 = 0;
                    boolean z = false;
                    while (i2 < supportedPreviewSizes.size()) {
                        boolean z2;
                        int i3 = ((Size) supportedPreviewSizes.get(i2)).height;
                        line = ((Size) supportedPreviewSizes.get(i2)).width;
                        C4990ab.m7410d("MicroMsg.YuvReocrder", "supp w:" + line + " h:" + i3);
                        int i4 = i3 * line;
                        if ((((c40435a.rotate == 0 || c40435a.rotate == 180) && i3 >= c40435a.ouT && line >= c40435a.ouU) || ((c40435a.rotate == 90 || c40435a.rotate == 270) && line >= c40435a.ouT && i3 >= c40435a.ouU)) && i4 < i) {
                            c40435a.lZe = line;
                            c40435a.lZf = i3;
                            z2 = true;
                        } else {
                            z2 = z;
                            i4 = i;
                        }
                        i2++;
                        z = z2;
                        i = i4;
                    }
                    if (!z) {
                        previewSize = parameters.getPreviewSize();
                        c40435a.lZf = previewSize.height;
                        c40435a.lZe = previewSize.width;
                    }
                } else {
                    previewSize = parameters.getPreviewSize();
                    c40435a.lZf = previewSize.height;
                    c40435a.lZe = previewSize.width;
                }
                C4990ab.m7410d("MicroMsg.YuvReocrder", " rotate:" + c40435a.rotate + " w:" + c40435a.lZe + " h:" + c40435a.lZf);
                parameters.setPreviewSize(this.vge.lZe, this.vge.lZf);
                C44054g.m79185g(parameters);
                supportedVideoSizes = parameters.getSupportedPreviewFrameRates();
                this.vgf.clear();
                this.vgf.addAll(supportedVideoSizes);
                parameters.setPreviewFormat(17);
                supportedVideoSizes = parameters.getSupportedFocusModes();
                if (supportedVideoSizes != null) {
                    if (C1443d.m3069iX(9) && true == supportedVideoSizes.contains("continuous-video")) {
                        C4990ab.m7416i("MicroMsg.YuvReocrder", "support continous-video");
                        this.vgg = false;
                        parameters.setFocusMode("continuous-video");
                    } else if (!supportedVideoSizes.contains("auto")) {
                        C4990ab.m7416i("MicroMsg.YuvReocrder", "don't support auto");
                        this.vgg = false;
                    }
                }
                this.erH.setParameters(parameters);
                this.erH.setPreviewDisplay(surfaceHolder);
                this.erH.startPreview();
                if (!(this.bCW == null || this.otO == null || !this.vgg)) {
                    this.bCW.registerListener(this, this.otO, 2);
                }
                this.otL = true;
                AppMethodBeat.m2505o(27487);
                return 0;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e.getMessage());
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(27487);
                return line;
            }
        }
    }

    /* renamed from: a */
    public final int mo69742a(Activity activity, C40435a c40435a, boolean z) {
        AppMethodBeat.m2504i(27488);
        int line;
        if (c40435a == null) {
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(27488);
            return line;
        }
        this.vge = c40435a;
        if (this.bCW == null && this.otO == null) {
            this.bCW = (SensorManager) C4996ah.getContext().getSystemService("sensor");
            this.otO = this.bCW.getDefaultSensor(1);
        }
        if (z || this.erH == null) {
            bPl();
            if (z) {
                otM = (otM ^ -1) & 1;
            }
            this.fbb = C32468d.m53155a(activity, otM, null);
            if (this.fbb == null) {
                C4990ab.m7412e("MicroMsg.YuvReocrder", "start camera FAILED!");
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(27488);
                return line;
            }
            this.erH = this.fbb.erH;
            this.vge.rotate = this.fbb.rotate;
            if (this.erH == null) {
                C4990ab.m7412e("MicroMsg.YuvReocrder", "start camera FAILED!");
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(27488);
                return line;
            }
        }
        AppMethodBeat.m2505o(27488);
        return 0;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.m2504i(27489);
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if ((Math.abs(this.otP - f) > 2.0f || Math.abs(this.otQ - f2) > 2.0f || Math.abs(this.otR - f3) > 2.0f) && this.erH != null && this.vgh && true == this.vgg) {
            try {
                C4990ab.m7410d("MicroMsg.YuvReocrder", "auto focus");
                this.erH.autoFocus(this.vgi);
                this.vgh = false;
            } catch (Exception e) {
                C4990ab.m7410d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.otP = f;
        this.otQ = f2;
        this.otR = f3;
        AppMethodBeat.m2505o(27489);
    }
}
