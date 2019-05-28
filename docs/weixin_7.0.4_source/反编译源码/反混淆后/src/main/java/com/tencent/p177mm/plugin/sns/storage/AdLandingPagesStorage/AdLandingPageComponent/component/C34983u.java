package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46232m;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u */
public final class C34983u extends C13437h implements SensorEventListener {
    Sensor accelerometer;
    private SensorManager bCW;
    Sensor bGE;
    ImageView cAw;
    ProgressBar progressBar;
    int rbs;
    final float rbt = 10.0f;
    final int rbu = 1;
    HorizontalScrollView rbv;
    float[] rbw;
    float[] rbx;
    private int rby = 0;
    boolean rbz = true;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u$2 */
    class C134442 implements Runnable {
        C134442() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37247);
            int measuredWidth = C34983u.this.cAw.getMeasuredWidth();
            if (measuredWidth > C34983u.this.ieu) {
                C34983u c34983u = C34983u.this;
                c34983u.rbs = (measuredWidth - c34983u.ieu) / 2;
                C34983u.this.rbv.scrollBy(C34983u.this.rbs, 0);
            }
            AppMethodBeat.m2505o(37247);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u$1 */
    class C349841 implements C3951a {
        C349841() {
        }

        public final void cpu() {
            AppMethodBeat.m2504i(37244);
            C34983u.this.startLoading();
            AppMethodBeat.m2505o(37244);
        }

        public final void cmD() {
            AppMethodBeat.m2504i(37245);
            C34983u.this.progressBar.setVisibility(8);
            AppMethodBeat.m2505o(37245);
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37246);
            try {
                C34983u.this.setImage(BitmapFactory.decodeFile(str));
                AppMethodBeat.m2505o(37246);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + C5046bo.m7574l(e));
                AppMethodBeat.m2505o(37246);
            }
        }
    }

    public C34983u(Context context, C46232m c46232m, ViewGroup viewGroup) {
        super(context, c46232m, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970717;
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37248);
        View view = this.contentView;
        this.bCW = (SensorManager) this.context.getSystemService("sensor");
        this.accelerometer = this.bCW.getDefaultSensor(1);
        this.bGE = this.bCW.getDefaultSensor(2);
        this.rbv = (HorizontalScrollView) view.findViewById(2131827622);
        this.cAw = (ImageView) view.findViewById(2131827623);
        this.progressBar = (ProgressBar) view.findViewById(2131821219);
        this.progressBar.setVisibility(8);
        AppMethodBeat.m2505o(37248);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37249);
        if (!C5730e.m8628ct(C13473h.m21625gj("adId", ((C46232m) this.qZo).qWD))) {
            this.rbz = false;
        }
        String str = ((C46232m) this.qZo).qWD;
        Bitmap gm = C13473h.m21628gm("adId", str);
        if (gm != null) {
            C4990ab.m7416i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
            setImage(gm);
            AppMethodBeat.m2505o(37249);
            return;
        }
        startLoading();
        C13473h.m21619a(str, ((C46232m) this.qZo).qWP, new C349841());
        AppMethodBeat.m2505o(37249);
    }

    public final void startLoading() {
        AppMethodBeat.m2504i(37250);
        this.progressBar.setVisibility(0);
        AppMethodBeat.m2505o(37250);
    }

    public final void setImage(Bitmap bitmap) {
        AppMethodBeat.m2504i(37251);
        if (bitmap == null) {
            C4990ab.m7412e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
            AppMethodBeat.m2505o(37251);
        } else if (this.cAw == null) {
            C4990ab.m7412e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
            AppMethodBeat.m2505o(37251);
        } else if (bitmap.getHeight() == 0) {
            C4990ab.m7412e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
            AppMethodBeat.m2505o(37251);
        } else {
            this.progressBar.setVisibility(8);
            this.cAw.setImageBitmap(bitmap);
            this.cAw.post(new C134442());
            if (bitmap.getHeight() != 0) {
                int i;
                int i2 = this.iev;
                if (((C46232m) this.qZo).qWV != 2.14748365E9f) {
                    i = (int) ((C46232m) this.qZo).qWV;
                } else {
                    i = i2;
                }
                this.cAw.setLayoutParams(new LayoutParams((bitmap.getWidth() * i) / bitmap.getHeight(), i));
            }
            AppMethodBeat.m2505o(37251);
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -10.0f;
        AppMethodBeat.m2504i(37252);
        if (sensorEvent.sensor.getType() == 1) {
            this.rbw = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.rbx = sensorEvent.values;
        }
        if (!(this.rbw == null || this.rbx == null)) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, new float[9], this.rbw, this.rbx)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                float f2 = fArr2[2];
                if (this.rbs != 0) {
                    if (f2 > 10.0f) {
                        f2 = 10.0f;
                    }
                    if (f2 >= -10.0f) {
                        f = f2;
                    }
                    this.rbv.scrollBy((int) ((f * ((float) this.rbs)) / 10.0f), 0);
                }
            }
        }
        AppMethodBeat.m2505o(37252);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final boolean cpx() {
        AppMethodBeat.m2504i(37253);
        if (cpw() >= ((int) (((float) getView().getHeight()) * 0.1f))) {
            AppMethodBeat.m2505o(37253);
            return true;
        }
        AppMethodBeat.m2505o(37253);
        return false;
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37254);
        super.cpa();
        this.bCW.registerListener(this, this.accelerometer, 1);
        this.bCW.registerListener(this, this.bGE, 1);
        AppMethodBeat.m2505o(37254);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37255);
        super.cpb();
        this.bCW.unregisterListener(this);
        AppMethodBeat.m2505o(37255);
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37256);
        if (super.mo15456al(jSONObject)) {
            try {
                jSONObject.put("swipeCount", this.rby);
                if (!this.rbz) {
                    String ck = C4995ag.m7428ck(((C46232m) this.qZo).qWD);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("imgUrlInfo", jSONObject2);
                }
                AppMethodBeat.m2505o(37256);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e, "", new Object[0]);
                AppMethodBeat.m2505o(37256);
                return false;
            }
        }
        AppMethodBeat.m2505o(37256);
        return false;
    }
}
