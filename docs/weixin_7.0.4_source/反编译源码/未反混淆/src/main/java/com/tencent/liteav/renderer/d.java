package com.tencent.liteav.renderer;

import android.graphics.Matrix;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;

public class d {
    private TextureView a;
    private Handler b;
    private int c = 0;
    private int d = 0;
    private int e = 640;
    private int f = 480;
    private int g = 0;
    private int h = 0;
    private int i = 1;
    private int j = 0;
    private float k = 1.0f;
    private int l = 0;

    static /* synthetic */ void a(d dVar, int i, int i2) {
        AppMethodBeat.i(67261);
        dVar.c(i, i2);
        AppMethodBeat.o(67261);
    }

    public d(TextureView textureView) {
        AppMethodBeat.i(67252);
        this.a = textureView;
        this.c = textureView.getWidth();
        this.d = textureView.getHeight();
        this.b = new Handler(textureView.getContext().getMainLooper());
        AppMethodBeat.o(67252);
    }

    public void a(final int i) {
        AppMethodBeat.i(67253);
        try {
            this.b.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67152);
                    d.this.b(i);
                    AppMethodBeat.o(67152);
                }
            });
            AppMethodBeat.o(67253);
        } catch (Exception e) {
            AppMethodBeat.o(67253);
        }
    }

    public void b(int i) {
        float f = 1.0f;
        AppMethodBeat.i(67254);
        this.i = i;
        if (this.a != null) {
            float f2;
            if (i == 1) {
                if (!(this.j == 0 || this.j == 180 || (this.j != 270 && this.j != 90))) {
                    if (this.g == 0 || this.h == 0) {
                        AppMethodBeat.o(67254);
                        return;
                    }
                    f2 = ((float) this.d) / ((float) this.g);
                    f = ((float) this.c) / ((float) this.h);
                    if (f2 <= f) {
                        f = f2;
                    }
                }
            } else if (i == 0) {
                if (this.g == 0 || this.h == 0) {
                    AppMethodBeat.o(67254);
                    return;
                } else if (this.j == 0 || this.j == 180) {
                    f2 = ((float) this.d) / ((float) this.h);
                    f = ((float) this.c) / ((float) this.g);
                    if (f2 >= f) {
                        f = f2;
                    }
                } else if (this.j == 270 || this.j == 90) {
                    f2 = ((float) this.d) / ((float) this.g);
                    f = ((float) this.c) / ((float) this.h);
                    if (f2 >= f) {
                        f = f2;
                    }
                }
            }
            if (this.k < 0.0f) {
                f = -f;
            }
            this.a.setScaleX(f);
            this.a.setScaleY(Math.abs(f));
            this.k = f;
        }
        AppMethodBeat.o(67254);
    }

    public void c(final int i) {
        AppMethodBeat.i(67255);
        try {
            this.b.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67354);
                    d.this.d(i);
                    AppMethodBeat.o(67354);
                }
            });
            AppMethodBeat.o(67255);
        } catch (Exception e) {
            AppMethodBeat.o(67255);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(int i) {
        float f = 1.0f;
        AppMethodBeat.i(67256);
        int i2 = i % v2helper.VOIP_ENC_HEIGHT_LV1;
        this.j = i2;
        if (this.a != null) {
            float f2;
            float f3;
            if (i2 == 0 || i2 == 180) {
                this.a.setRotation((float) (360 - i2));
                if (this.i == 1) {
                    f2 = 1.0f;
                } else {
                    if (this.i == 0) {
                        if (this.g == 0 || this.h == 0) {
                            AppMethodBeat.o(67256);
                            return;
                        }
                        f3 = ((float) this.d) / ((float) this.h);
                        f2 = ((float) this.c) / ((float) this.g);
                        if (f3 >= f2) {
                            f2 = f3;
                        }
                        f = f2;
                    }
                    if (this.k < 0.0f) {
                        f = -f;
                    }
                    this.a.setScaleX(f);
                    this.a.setScaleY(Math.abs(f));
                    this.k = f;
                }
            } else {
                if (i2 == 270 || i2 == 90) {
                    if (this.g == 0 || this.h == 0) {
                        AppMethodBeat.o(67256);
                        return;
                    }
                    this.a.setRotation((float) (360 - i2));
                    f3 = ((float) this.d) / ((float) this.g);
                    f2 = ((float) this.c) / ((float) this.h);
                    if (this.i == 1) {
                        if (f3 <= f2) {
                            f2 = f3;
                        }
                        f = f2;
                    } else if (this.i == 0) {
                        if (f3 >= f2) {
                            f2 = f3;
                        }
                    }
                }
                if (this.k < 0.0f) {
                }
                this.a.setScaleX(f);
                this.a.setScaleY(Math.abs(f));
                this.k = f;
            }
            f = f2;
            if (this.k < 0.0f) {
            }
            this.a.setScaleX(f);
            this.a.setScaleY(Math.abs(f));
            this.k = f;
        }
        AppMethodBeat.o(67256);
    }

    private void a() {
        AppMethodBeat.i(67257);
        try {
            this.b.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67339);
                    d.a(d.this, d.this.e, d.this.f);
                    d.this.b(d.this.i);
                    d.this.d(d.this.j);
                    AppMethodBeat.o(67339);
                }
            });
            AppMethodBeat.o(67257);
        } catch (Exception e) {
            AppMethodBeat.o(67257);
        }
    }

    private void c(int i, int i2) {
        AppMethodBeat.i(67258);
        if (this.a == null || i == 0 || i2 == 0) {
            AppMethodBeat.o(67258);
        } else if (this.c == 0 || this.d == 0) {
            AppMethodBeat.o(67258);
        } else {
            double d = ((double) i2) / ((double) i);
            if (this.d > ((int) (((double) this.c) * d))) {
                this.g = this.c;
                this.h = (int) (d * ((double) this.c));
            } else {
                this.g = (int) (((double) this.d) / d);
                this.h = this.d;
            }
            float f = ((float) (this.c - this.g)) / 2.0f;
            float f2 = ((float) (this.d - this.h)) / 2.0f;
            float f3 = ((float) this.g) / ((float) this.c);
            float f4 = ((float) this.h) / ((float) this.d);
            Matrix matrix = new Matrix();
            this.a.getTransform(matrix);
            matrix.setScale(f3, f4);
            matrix.postTranslate(f, f2);
            this.a.setTransform(matrix);
            this.a.requestLayout();
            AppMethodBeat.o(67258);
        }
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67259);
        TXCLog.w("TXCTextureViewWrapper", "vrender: set view size:" + i + "," + i2);
        this.c = i;
        this.d = i2;
        a();
        AppMethodBeat.o(67259);
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(67260);
        TXCLog.w("TXCTextureViewWrapper", "vrender: set video size:" + i + "," + i2);
        this.e = i;
        this.f = i2;
        a();
        AppMethodBeat.o(67260);
    }
}
