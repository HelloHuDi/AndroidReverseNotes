package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class i {
    protected ProgressDialog ehJ = null;
    protected TextView iqU;
    GestureDetector lCs;
    protected Point lUF;
    protected boolean ovx;
    protected long qel;
    protected Rect qem;
    protected com.tencent.mm.plugin.scanner.util.b qen;
    protected Point qeo;
    protected int qep;
    protected int qeq;
    protected int qer = 40;
    protected int qes = 20;
    protected b qet;
    protected int qeu;
    protected boolean qev;
    protected ak qew = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(81154);
            if (!(message == null || message.what != 1 || i.this.iqU == null)) {
                i.this.iqU.setVisibility(0);
            }
            AppMethodBeat.o(81154);
        }
    };

    public interface a {
        void c(Activity activity, int i, int i2, Intent intent);
    }

    public interface b {
        void a(a aVar);

        void a(String str, int i, int i2, int i3, com.tencent.mm.plugin.scanner.util.e.a aVar);

        void ah(int i, int i2, int i3);

        void b(int i, OnClickListener onClickListener);

        void cha();

        void chg();

        boolean chh();

        void chi();

        void chj();

        void chk();

        View findViewById(int i);

        Activity getContext();

        void jK(long j);

        void jL(long j);

        void kj(boolean z);
    }

    public abstract void cgN();

    public abstract com.tencent.mm.plugin.scanner.util.b cgO();

    public abstract int cgP();

    public abstract int cgQ();

    public abstract void cgR();

    public abstract boolean cgS();

    public abstract boolean cgT();

    public abstract void j(Rect rect);

    public abstract void onDestroy();

    public abstract void onResume();

    public final b chu() {
        return this.qet;
    }

    /* Access modifiers changed, original: protected|final */
    public final void kl(boolean z) {
        if (this.iqU != null) {
            if (z) {
                this.iqU.setVisibility(4);
                this.qew.sendEmptyMessageDelayed(1, 210);
                return;
            }
            this.qew.removeMessages(1);
            this.iqU.setVisibility(4);
        }
    }

    public i(b bVar, Point point) {
        this.qet = bVar;
        this.qeo = point;
    }

    public i(b bVar, Point point, byte b) {
        this.qet = bVar;
        this.qeo = point;
        this.qer = 50;
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
    }

    public final void e(Point point) {
        this.qeo = point;
    }

    /* Access modifiers changed, original: protected */
    public void dw(View view) {
    }

    /* Access modifiers changed, original: protected|final */
    public final double fd(int i, int i2) {
        Activity context = this.qet.getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = ((double) displayMetrics.densityDpi) / 160.0d;
        ab.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", Double.valueOf(d));
        int i3 = (int) (((float) this.qeo.x) * 0.85f);
        int i4 = (int) (((float) this.qeo.y) * 0.85f);
        int i5;
        if ((this instanceof j) || (this instanceof c)) {
            i3 = (int) (((float) this.qeo.y) * 0.85f);
            i5 = (int) (((float) this.qeo.x) * 0.85f);
        } else {
            i5 = i4;
        }
        float f = 1.0f;
        if (d <= 1.2d) {
            f = (this.qeo == null || this.qeo.x + this.qeo.y <= 1560) ? (this.qeo == null || this.qeo.x + this.qeo.y <= 1460) ? 0.9f : 1.1f : 1.7f;
        } else if (this.qeo.x + this.qeo.y > AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS && d < 2.4d) {
            f = 1.6f;
        }
        this.qep = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qet.getContext(), ((float) i) * f);
        this.qeq = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qet.getContext(), ((float) i2) * f);
        if (this.qep > i3 || this.qeq > i5) {
            while (true) {
                if (this.qep <= i3 && this.qeq <= i5) {
                    break;
                }
                this.qep = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qet.getContext(), ((float) i) * f);
                this.qeq = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qet.getContext(), ((float) i2) * f);
                f -= 0.1f;
            }
            ab.i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", Float.valueOf(f));
        }
        if (this.qep % 2 == 1) {
            this.qep++;
        }
        if (this.qeq % 2 == 1) {
            this.qeq++;
        }
        ab.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", Integer.valueOf(this.qep), Integer.valueOf(this.qeq), this.qeo);
        return d;
    }

    /* Access modifiers changed, original: protected */
    public Rect H(boolean z, boolean z2) {
        if (this.qem == null || z) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5 = this.qeo.x;
            int i6 = this.qeo.y;
            if (!z2) {
                i = (i5 / 2) - (this.qep / 2);
                i2 = (i5 / 2) + (this.qep / 2);
                i3 = (i6 / 2) - (this.qeq / 2);
                i4 = this.qeq + i3;
            } else if (i5 < i6) {
                i = (i6 / 2) - (this.qep / 2);
                i2 = (i6 / 2) + (this.qep / 2);
                i3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qet.getContext(), (float) this.qes);
                i4 = this.qeq + i3;
            } else {
                i = (i5 / 2) - (this.qep / 2);
                i2 = (i5 / 2) + (this.qep / 2);
                i3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qet.getContext(), (float) this.qes);
                i4 = this.qeq + i3;
            }
            ab.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.qem = new Rect(i, i3, i2, i4);
        }
        return this.qem;
    }

    /* Access modifiers changed, original: protected */
    public Rect km(boolean z) {
        return H(true, z);
    }

    /* Access modifiers changed, original: protected */
    public void f(Point point) {
        this.lUF = point;
    }

    /* Access modifiers changed, original: protected */
    public void kn(boolean z) {
        this.ovx = z;
    }

    public final void ko(boolean z) {
        if (this.iqU != null) {
            this.iqU.setVisibility(z ? 0 : 4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dx(View view) {
        this.lCs = new GestureDetector(new SimpleOnGestureListener() {
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(81155);
                ab.d("MicroMsg.scanner.ScanMode", "double click,pointer:%d,x:%f,y:%f", Integer.valueOf(motionEvent.getActionIndex()), Float.valueOf(motionEvent.getX(motionEvent.getActionIndex())), Float.valueOf(motionEvent.getY(motionEvent.getActionIndex())));
                i.this.qet.ah(5, 2, 100);
                AppMethodBeat.o(81155);
                return true;
            }
        });
        view.setOnTouchListener(new OnTouchListener() {
            private float qey;
            private float qez = 400.0f;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(81156);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                ab.d("MicroMsg.scanner.ScanMode", "pointIndex:%d", Integer.valueOf(actionIndex));
                switch (actionMasked) {
                    case 0:
                        ab.d("MicroMsg.scanner.ScanMode", "first down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                        break;
                    case 1:
                        ab.d("MicroMsg.scanner.ScanMode", "last up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                        if (motionEvent.getPointerCount() == 2) {
                            this.qey = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            break;
                        }
                        break;
                    case 2:
                        if (motionEvent.getPointerCount() == 2) {
                            ab.d("MicroMsg.scanner.ScanMode", "move,pointer:0,x:%f,y:%f", Float.valueOf(motionEvent.getX(0)), Float.valueOf(motionEvent.getY(0)));
                            ab.d("MicroMsg.scanner.ScanMode", "move,pointer:1,x:%f,y:%f", Float.valueOf(motionEvent.getX(1)), Float.valueOf(motionEvent.getY(1)));
                            float pow = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            ab.d("MicroMsg.scanner.ScanMode", "distance:%f,lastDistance:%f,min move:%f", Float.valueOf(pow), Float.valueOf(this.qey), Float.valueOf(this.qez));
                            if (Math.abs(pow - this.qey) > this.qez) {
                                if (i.this.qev) {
                                    i.this.qev = false;
                                }
                                if (pow - this.qey > 0.0f) {
                                    i.this.qet.ah(2, 2, 100);
                                } else {
                                    i.this.qet.ah(3, 2, 100);
                                }
                                this.qey = pow;
                                break;
                            }
                        }
                        break;
                    case 5:
                        ab.d("MicroMsg.scanner.ScanMode", "down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                        if (motionEvent.getPointerCount() == 2) {
                            this.qey = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            break;
                        }
                        break;
                    case 6:
                        ab.d("MicroMsg.scanner.ScanMode", "up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                        if (motionEvent.getPointerCount() == 2) {
                            this.qey = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            break;
                        }
                        break;
                }
                i.this.lCs.onTouchEvent(motionEvent);
                AppMethodBeat.o(81156);
                return true;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void a(byte[] bArr, Point point, int i, Rect rect) {
        ab.i("MicroMsg.scanner.ScanMode", "decode count:" + m.pZK.pZN);
        if (cgO() != null) {
            cgO().a(bArr, point, i, rect);
            if (m.pZK.pZN == 30) {
                this.qet.chk();
            }
        }
    }
}
