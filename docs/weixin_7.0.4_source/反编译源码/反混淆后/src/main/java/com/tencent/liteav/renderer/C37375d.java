package com.tencent.liteav.renderer;

import android.graphics.Matrix;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.liteav.renderer.d */
public class C37375d {
    /* renamed from: a */
    private TextureView f16012a;
    /* renamed from: b */
    private Handler f16013b;
    /* renamed from: c */
    private int f16014c = 0;
    /* renamed from: d */
    private int f16015d = 0;
    /* renamed from: e */
    private int f16016e = 640;
    /* renamed from: f */
    private int f16017f = 480;
    /* renamed from: g */
    private int f16018g = 0;
    /* renamed from: h */
    private int f16019h = 0;
    /* renamed from: i */
    private int f16020i = 1;
    /* renamed from: j */
    private int f16021j = 0;
    /* renamed from: k */
    private float f16022k = 1.0f;
    /* renamed from: l */
    private int f16023l = 0;

    /* renamed from: com.tencent.liteav.renderer.d$3 */
    class C373763 implements Runnable {
        C373763() {
        }

        public void run() {
            AppMethodBeat.m2504i(67339);
            C37375d.m62946a(C37375d.this, C37375d.this.f16016e, C37375d.this.f16017f);
            C37375d.this.mo60213b(C37375d.this.f16020i);
            C37375d.this.mo60216d(C37375d.this.f16021j);
            AppMethodBeat.m2505o(67339);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m62946a(C37375d c37375d, int i, int i2) {
        AppMethodBeat.m2504i(67261);
        c37375d.m62949c(i, i2);
        AppMethodBeat.m2505o(67261);
    }

    public C37375d(TextureView textureView) {
        AppMethodBeat.m2504i(67252);
        this.f16012a = textureView;
        this.f16014c = textureView.getWidth();
        this.f16015d = textureView.getHeight();
        this.f16013b = new Handler(textureView.getContext().getMainLooper());
        AppMethodBeat.m2505o(67252);
    }

    /* renamed from: a */
    public void mo60211a(final int i) {
        AppMethodBeat.m2504i(67253);
        try {
            this.f16013b.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67152);
                    C37375d.this.mo60213b(i);
                    AppMethodBeat.m2505o(67152);
                }
            });
            AppMethodBeat.m2505o(67253);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67253);
        }
    }

    /* renamed from: b */
    public void mo60213b(int i) {
        float f = 1.0f;
        AppMethodBeat.m2504i(67254);
        this.f16020i = i;
        if (this.f16012a != null) {
            float f2;
            if (i == 1) {
                if (!(this.f16021j == 0 || this.f16021j == 180 || (this.f16021j != 270 && this.f16021j != 90))) {
                    if (this.f16018g == 0 || this.f16019h == 0) {
                        AppMethodBeat.m2505o(67254);
                        return;
                    }
                    f2 = ((float) this.f16015d) / ((float) this.f16018g);
                    f = ((float) this.f16014c) / ((float) this.f16019h);
                    if (f2 <= f) {
                        f = f2;
                    }
                }
            } else if (i == 0) {
                if (this.f16018g == 0 || this.f16019h == 0) {
                    AppMethodBeat.m2505o(67254);
                    return;
                } else if (this.f16021j == 0 || this.f16021j == 180) {
                    f2 = ((float) this.f16015d) / ((float) this.f16019h);
                    f = ((float) this.f16014c) / ((float) this.f16018g);
                    if (f2 >= f) {
                        f = f2;
                    }
                } else if (this.f16021j == 270 || this.f16021j == 90) {
                    f2 = ((float) this.f16015d) / ((float) this.f16018g);
                    f = ((float) this.f16014c) / ((float) this.f16019h);
                    if (f2 >= f) {
                        f = f2;
                    }
                }
            }
            if (this.f16022k < 0.0f) {
                f = -f;
            }
            this.f16012a.setScaleX(f);
            this.f16012a.setScaleY(Math.abs(f));
            this.f16022k = f;
        }
        AppMethodBeat.m2505o(67254);
    }

    /* renamed from: c */
    public void mo60215c(final int i) {
        AppMethodBeat.m2504i(67255);
        try {
            this.f16013b.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67354);
                    C37375d.this.mo60216d(i);
                    AppMethodBeat.m2505o(67354);
                }
            });
            AppMethodBeat.m2505o(67255);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67255);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public void mo60216d(int i) {
        float f = 1.0f;
        AppMethodBeat.m2504i(67256);
        int i2 = i % v2helper.VOIP_ENC_HEIGHT_LV1;
        this.f16021j = i2;
        if (this.f16012a != null) {
            float f2;
            float f3;
            if (i2 == 0 || i2 == 180) {
                this.f16012a.setRotation((float) (360 - i2));
                if (this.f16020i == 1) {
                    f2 = 1.0f;
                } else {
                    if (this.f16020i == 0) {
                        if (this.f16018g == 0 || this.f16019h == 0) {
                            AppMethodBeat.m2505o(67256);
                            return;
                        }
                        f3 = ((float) this.f16015d) / ((float) this.f16019h);
                        f2 = ((float) this.f16014c) / ((float) this.f16018g);
                        if (f3 >= f2) {
                            f2 = f3;
                        }
                        f = f2;
                    }
                    if (this.f16022k < 0.0f) {
                        f = -f;
                    }
                    this.f16012a.setScaleX(f);
                    this.f16012a.setScaleY(Math.abs(f));
                    this.f16022k = f;
                }
            } else {
                if (i2 == 270 || i2 == 90) {
                    if (this.f16018g == 0 || this.f16019h == 0) {
                        AppMethodBeat.m2505o(67256);
                        return;
                    }
                    this.f16012a.setRotation((float) (360 - i2));
                    f3 = ((float) this.f16015d) / ((float) this.f16018g);
                    f2 = ((float) this.f16014c) / ((float) this.f16019h);
                    if (this.f16020i == 1) {
                        if (f3 <= f2) {
                            f2 = f3;
                        }
                        f = f2;
                    } else if (this.f16020i == 0) {
                        if (f3 >= f2) {
                            f2 = f3;
                        }
                    }
                }
                if (this.f16022k < 0.0f) {
                }
                this.f16012a.setScaleX(f);
                this.f16012a.setScaleY(Math.abs(f));
                this.f16022k = f;
            }
            f = f2;
            if (this.f16022k < 0.0f) {
            }
            this.f16012a.setScaleX(f);
            this.f16012a.setScaleY(Math.abs(f));
            this.f16022k = f;
        }
        AppMethodBeat.m2505o(67256);
    }

    /* renamed from: a */
    private void m62945a() {
        AppMethodBeat.m2504i(67257);
        try {
            this.f16013b.post(new C373763());
            AppMethodBeat.m2505o(67257);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67257);
        }
    }

    /* renamed from: c */
    private void m62949c(int i, int i2) {
        AppMethodBeat.m2504i(67258);
        if (this.f16012a == null || i == 0 || i2 == 0) {
            AppMethodBeat.m2505o(67258);
        } else if (this.f16014c == 0 || this.f16015d == 0) {
            AppMethodBeat.m2505o(67258);
        } else {
            double d = ((double) i2) / ((double) i);
            if (this.f16015d > ((int) (((double) this.f16014c) * d))) {
                this.f16018g = this.f16014c;
                this.f16019h = (int) (d * ((double) this.f16014c));
            } else {
                this.f16018g = (int) (((double) this.f16015d) / d);
                this.f16019h = this.f16015d;
            }
            float f = ((float) (this.f16014c - this.f16018g)) / 2.0f;
            float f2 = ((float) (this.f16015d - this.f16019h)) / 2.0f;
            float f3 = ((float) this.f16018g) / ((float) this.f16014c);
            float f4 = ((float) this.f16019h) / ((float) this.f16015d);
            Matrix matrix = new Matrix();
            this.f16012a.getTransform(matrix);
            matrix.setScale(f3, f4);
            matrix.postTranslate(f, f2);
            this.f16012a.setTransform(matrix);
            this.f16012a.requestLayout();
            AppMethodBeat.m2505o(67258);
        }
    }

    /* renamed from: a */
    public void mo60212a(int i, int i2) {
        AppMethodBeat.m2504i(67259);
        TXCLog.m15679w("TXCTextureViewWrapper", "vrender: set view size:" + i + "," + i2);
        this.f16014c = i;
        this.f16015d = i2;
        m62945a();
        AppMethodBeat.m2505o(67259);
    }

    /* renamed from: b */
    public void mo60214b(int i, int i2) {
        AppMethodBeat.m2504i(67260);
        TXCLog.m15679w("TXCTextureViewWrapper", "vrender: set video size:" + i + "," + i2);
        this.f16016e = i;
        this.f16017f = i2;
        m62945a();
        AppMethodBeat.m2505o(67260);
    }
}
