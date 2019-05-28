package com.tencent.mm.pluginsdk.i;

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
import android.support.v4.widget.j;
import android.view.SurfaceHolder;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;

public final class g implements SensorEventListener {
    private static int otM = 0;
    private SensorManager bCW;
    public t erH = null;
    a fbb;
    private PreviewCallback mPreviewCallback = null;
    private boolean otL = false;
    private Sensor otO;
    private float otP = 0.0f;
    private float otQ = 0.0f;
    private float otR = 0.0f;
    private SurfaceHolder szR = null;
    private a vge;
    public List<Integer> vgf = new ArrayList();
    private boolean vgg = true;
    private boolean vgh = true;
    private AutoFocusCallback vgi = new AutoFocusCallback() {
        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.i(27483);
            ab.d("MicroMsg.YuvReocrder", "auto focus callback");
            g.this.vgh = true;
            AppMethodBeat.o(27483);
        }
    };

    public g() {
        AppMethodBeat.i(27484);
        AppMethodBeat.o(27484);
    }

    public static int getCameraId() {
        return otM;
    }

    public final void bPl() {
        AppMethodBeat.i(27485);
        if (!(this.bCW == null || this.otO == null)) {
            this.bCW.unregisterListener(this);
        }
        if (this.erH != null) {
            ab.d("MicroMsg.YuvReocrder", "release camera");
            this.erH.setPreviewCallback(null);
            this.erH.stopPreview();
            this.erH.release();
            this.erH = null;
            this.otL = false;
        }
        AppMethodBeat.o(27485);
    }

    @TargetApi(9)
    private static void g(Parameters parameters) {
        AppMethodBeat.i(27486);
        if (q.etc.eri > 0) {
            AppMethodBeat.o(27486);
        } else if (VERSION.SDK_INT < 9) {
            AppMethodBeat.o(27486);
        } else {
            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
                AppMethodBeat.o(27486);
                return;
            }
            int size = supportedPreviewFpsRange.size();
            int i = 0;
            int i2 = j.INVALID_ID;
            int i3 = j.INVALID_ID;
            while (i < size) {
                int i4;
                int i5;
                int[] iArr = (int[]) supportedPreviewFpsRange.get(i);
                if (iArr != null && iArr.length > 1) {
                    i4 = iArr[0];
                    i5 = iArr[1];
                    ab.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5));
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
            ab.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", Integer.valueOf(i3), Integer.valueOf(i2));
            if (i3 == BaseClientBuilder.API_PRIORITY_OTHER || i2 == BaseClientBuilder.API_PRIORITY_OTHER) {
                AppMethodBeat.o(27486);
                return;
            }
            try {
                parameters.setPreviewFpsRange(i3, i2);
                AppMethodBeat.o(27486);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                AppMethodBeat.o(27486);
            }
        }
    }

    public final int b(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(27487);
        int line;
        if (this.otL) {
            AppMethodBeat.o(27487);
            return 0;
        } else if (surfaceHolder == null) {
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(27487);
            return line;
        } else {
            try {
                List supportedVideoSizes;
                List supportedPreviewSizes;
                this.szR = surfaceHolder;
                Parameters parameters = this.erH.getParameters();
                a aVar = this.vge;
                ab.d("MicroMsg.YuvReocrder", "getFitRecordSize");
                int i = BaseClientBuilder.API_PRIORITY_OTHER;
                if (VERSION.SDK_INT >= 11) {
                    h hVar = new h();
                    supportedVideoSizes = parameters.getSupportedVideoSizes();
                } else {
                    supportedVideoSizes = null;
                }
                if (supportedVideoSizes == null) {
                    ab.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                    com.tencent.mm.compatible.e.g gVar = new com.tencent.mm.compatible.e.g();
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
                        ab.d("MicroMsg.YuvReocrder", "supp w:" + line + " h:" + i3);
                        int i4 = i3 * line;
                        if ((((aVar.rotate == 0 || aVar.rotate == 180) && i3 >= aVar.ouT && line >= aVar.ouU) || ((aVar.rotate == 90 || aVar.rotate == 270) && line >= aVar.ouT && i3 >= aVar.ouU)) && i4 < i) {
                            aVar.lZe = line;
                            aVar.lZf = i3;
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
                        aVar.lZf = previewSize.height;
                        aVar.lZe = previewSize.width;
                    }
                } else {
                    previewSize = parameters.getPreviewSize();
                    aVar.lZf = previewSize.height;
                    aVar.lZe = previewSize.width;
                }
                ab.d("MicroMsg.YuvReocrder", " rotate:" + aVar.rotate + " w:" + aVar.lZe + " h:" + aVar.lZf);
                parameters.setPreviewSize(this.vge.lZe, this.vge.lZf);
                g(parameters);
                supportedVideoSizes = parameters.getSupportedPreviewFrameRates();
                this.vgf.clear();
                this.vgf.addAll(supportedVideoSizes);
                parameters.setPreviewFormat(17);
                supportedVideoSizes = parameters.getSupportedFocusModes();
                if (supportedVideoSizes != null) {
                    if (d.iX(9) && true == supportedVideoSizes.contains("continuous-video")) {
                        ab.i("MicroMsg.YuvReocrder", "support continous-video");
                        this.vgg = false;
                        parameters.setFocusMode("continuous-video");
                    } else if (!supportedVideoSizes.contains("auto")) {
                        ab.i("MicroMsg.YuvReocrder", "don't support auto");
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
                AppMethodBeat.o(27487);
                return 0;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                ab.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e.getMessage());
                line = 0 - com.tencent.mm.compatible.util.g.getLine();
                AppMethodBeat.o(27487);
                return line;
            }
        }
    }

    public final int a(Activity activity, a aVar, boolean z) {
        AppMethodBeat.i(27488);
        int line;
        if (aVar == null) {
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(27488);
            return line;
        }
        this.vge = aVar;
        if (this.bCW == null && this.otO == null) {
            this.bCW = (SensorManager) ah.getContext().getSystemService("sensor");
            this.otO = this.bCW.getDefaultSensor(1);
        }
        if (z || this.erH == null) {
            bPl();
            if (z) {
                otM = (otM ^ -1) & 1;
            }
            this.fbb = com.tencent.mm.compatible.e.d.a(activity, otM, null);
            if (this.fbb == null) {
                ab.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                line = 0 - com.tencent.mm.compatible.util.g.getLine();
                AppMethodBeat.o(27488);
                return line;
            }
            this.erH = this.fbb.erH;
            this.vge.rotate = this.fbb.rotate;
            if (this.erH == null) {
                ab.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                line = 0 - com.tencent.mm.compatible.util.g.getLine();
                AppMethodBeat.o(27488);
                return line;
            }
        }
        AppMethodBeat.o(27488);
        return 0;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(27489);
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if ((Math.abs(this.otP - f) > 2.0f || Math.abs(this.otQ - f2) > 2.0f || Math.abs(this.otR - f3) > 2.0f) && this.erH != null && this.vgh && true == this.vgg) {
            try {
                ab.d("MicroMsg.YuvReocrder", "auto focus");
                this.erH.autoFocus(this.vgi);
                this.vgh = false;
            } catch (Exception e) {
                ab.d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.otP = f;
        this.otQ = f2;
        this.otR = f3;
        AppMethodBeat.o(27489);
    }
}
