package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class u extends h implements SensorEventListener {
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

    public u(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au1;
    }

    public final void cpk() {
        AppMethodBeat.i(37248);
        View view = this.contentView;
        this.bCW = (SensorManager) this.context.getSystemService("sensor");
        this.accelerometer = this.bCW.getDefaultSensor(1);
        this.bGE = this.bCW.getDefaultSensor(2);
        this.rbv = (HorizontalScrollView) view.findViewById(R.id.efb);
        this.cAw = (ImageView) view.findViewById(R.id.efc);
        this.progressBar = (ProgressBar) view.findViewById(R.id.rj);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(37248);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37249);
        if (!e.ct(h.gj("adId", ((m) this.qZo).qWD))) {
            this.rbz = false;
        }
        String str = ((m) this.qZo).qWD;
        Bitmap gm = h.gm("adId", str);
        if (gm != null) {
            ab.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
            setImage(gm);
            AppMethodBeat.o(37249);
            return;
        }
        startLoading();
        h.a(str, ((m) this.qZo).qWP, new a() {
            public final void cpu() {
                AppMethodBeat.i(37244);
                u.this.startLoading();
                AppMethodBeat.o(37244);
            }

            public final void cmD() {
                AppMethodBeat.i(37245);
                u.this.progressBar.setVisibility(8);
                AppMethodBeat.o(37245);
            }

            public final void YJ(String str) {
                AppMethodBeat.i(37246);
                try {
                    u.this.setImage(BitmapFactory.decodeFile(str));
                    AppMethodBeat.o(37246);
                } catch (Exception e) {
                    ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bo.l(e));
                    AppMethodBeat.o(37246);
                }
            }
        });
        AppMethodBeat.o(37249);
    }

    public final void startLoading() {
        AppMethodBeat.i(37250);
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(37250);
    }

    public final void setImage(Bitmap bitmap) {
        AppMethodBeat.i(37251);
        if (bitmap == null) {
            ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
            AppMethodBeat.o(37251);
        } else if (this.cAw == null) {
            ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
            AppMethodBeat.o(37251);
        } else if (bitmap.getHeight() == 0) {
            ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
            AppMethodBeat.o(37251);
        } else {
            this.progressBar.setVisibility(8);
            this.cAw.setImageBitmap(bitmap);
            this.cAw.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37247);
                    int measuredWidth = u.this.cAw.getMeasuredWidth();
                    if (measuredWidth > u.this.ieu) {
                        u uVar = u.this;
                        uVar.rbs = (measuredWidth - uVar.ieu) / 2;
                        u.this.rbv.scrollBy(u.this.rbs, 0);
                    }
                    AppMethodBeat.o(37247);
                }
            });
            if (bitmap.getHeight() != 0) {
                int i;
                int i2 = this.iev;
                if (((m) this.qZo).qWV != 2.14748365E9f) {
                    i = (int) ((m) this.qZo).qWV;
                } else {
                    i = i2;
                }
                this.cAw.setLayoutParams(new LayoutParams((bitmap.getWidth() * i) / bitmap.getHeight(), i));
            }
            AppMethodBeat.o(37251);
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -10.0f;
        AppMethodBeat.i(37252);
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
        AppMethodBeat.o(37252);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final boolean cpx() {
        AppMethodBeat.i(37253);
        if (cpw() >= ((int) (((float) getView().getHeight()) * 0.1f))) {
            AppMethodBeat.o(37253);
            return true;
        }
        AppMethodBeat.o(37253);
        return false;
    }

    public final void cpa() {
        AppMethodBeat.i(37254);
        super.cpa();
        this.bCW.registerListener(this, this.accelerometer, 1);
        this.bCW.registerListener(this, this.bGE, 1);
        AppMethodBeat.o(37254);
    }

    public final void cpb() {
        AppMethodBeat.i(37255);
        super.cpb();
        this.bCW.unregisterListener(this);
        AppMethodBeat.o(37255);
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37256);
        if (super.al(jSONObject)) {
            try {
                jSONObject.put("swipeCount", this.rby);
                if (!this.rbz) {
                    String ck = ag.ck(((m) this.qZo).qWD);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("imgUrlInfo", jSONObject2);
                }
                AppMethodBeat.o(37256);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e, "", new Object[0]);
                AppMethodBeat.o(37256);
                return false;
            }
        }
        AppMethodBeat.o(37256);
        return false;
    }
}
