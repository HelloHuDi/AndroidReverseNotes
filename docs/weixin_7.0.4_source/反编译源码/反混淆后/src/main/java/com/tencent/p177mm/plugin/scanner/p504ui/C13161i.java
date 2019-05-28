package com.tencent.p177mm.plugin.scanner.p504ui;

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
import com.tencent.p177mm.plugin.scanner.p740a.C21682m;
import com.tencent.p177mm.plugin.scanner.util.C3771b;
import com.tencent.p177mm.plugin.scanner.util.C46189e.C21729a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.scanner.ui.i */
public abstract class C13161i {
    protected ProgressDialog ehJ = null;
    protected TextView iqU;
    GestureDetector lCs;
    protected Point lUF;
    protected boolean ovx;
    protected long qel;
    protected Rect qem;
    protected C3771b qen;
    protected Point qeo;
    protected int qep;
    protected int qeq;
    protected int qer = 40;
    protected int qes = 20;
    protected C13164b qet;
    protected int qeu;
    protected boolean qev;
    protected C7306ak qew = new C131651();

    /* renamed from: com.tencent.mm.plugin.scanner.ui.i$3 */
    class C131623 implements OnTouchListener {
        private float qey;
        private float qez = 400.0f;

        C131623() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(81156);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            C4990ab.m7411d("MicroMsg.scanner.ScanMode", "pointIndex:%d", Integer.valueOf(actionIndex));
            switch (actionMasked) {
                case 0:
                    C4990ab.m7411d("MicroMsg.scanner.ScanMode", "first down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                    break;
                case 1:
                    C4990ab.m7411d("MicroMsg.scanner.ScanMode", "last up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                    if (motionEvent.getPointerCount() == 2) {
                        this.qey = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                        break;
                    }
                    break;
                case 2:
                    if (motionEvent.getPointerCount() == 2) {
                        C4990ab.m7411d("MicroMsg.scanner.ScanMode", "move,pointer:0,x:%f,y:%f", Float.valueOf(motionEvent.getX(0)), Float.valueOf(motionEvent.getY(0)));
                        C4990ab.m7411d("MicroMsg.scanner.ScanMode", "move,pointer:1,x:%f,y:%f", Float.valueOf(motionEvent.getX(1)), Float.valueOf(motionEvent.getY(1)));
                        float pow = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                        C4990ab.m7411d("MicroMsg.scanner.ScanMode", "distance:%f,lastDistance:%f,min move:%f", Float.valueOf(pow), Float.valueOf(this.qey), Float.valueOf(this.qez));
                        if (Math.abs(pow - this.qey) > this.qez) {
                            if (C13161i.this.qev) {
                                C13161i.this.qev = false;
                            }
                            if (pow - this.qey > 0.0f) {
                                C13161i.this.qet.mo25204ah(2, 2, 100);
                            } else {
                                C13161i.this.qet.mo25204ah(3, 2, 100);
                            }
                            this.qey = pow;
                            break;
                        }
                    }
                    break;
                case 5:
                    C4990ab.m7411d("MicroMsg.scanner.ScanMode", "down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                    if (motionEvent.getPointerCount() == 2) {
                        this.qey = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                        break;
                    }
                    break;
                case 6:
                    C4990ab.m7411d("MicroMsg.scanner.ScanMode", "up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                    if (motionEvent.getPointerCount() == 2) {
                        this.qey = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                        break;
                    }
                    break;
            }
            C13161i.this.lCs.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(81156);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.i$a */
    public interface C13163a {
        /* renamed from: c */
        void mo25201c(Activity activity, int i, int i2, Intent intent);
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.i$b */
    public interface C13164b {
        /* renamed from: a */
        void mo25202a(C13163a c13163a);

        /* renamed from: a */
        void mo25203a(String str, int i, int i2, int i3, C21729a c21729a);

        /* renamed from: ah */
        void mo25204ah(int i, int i2, int i3);

        /* renamed from: b */
        void mo25205b(int i, OnClickListener onClickListener);

        void cha();

        void chg();

        boolean chh();

        void chi();

        void chj();

        void chk();

        View findViewById(int i);

        Activity getContext();

        /* renamed from: jK */
        void mo25214jK(long j);

        /* renamed from: jL */
        void mo25215jL(long j);

        /* renamed from: kj */
        void mo25216kj(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.i$1 */
    class C131651 extends C7306ak {
        C131651() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(81154);
            if (!(message == null || message.what != 1 || C13161i.this.iqU == null)) {
                C13161i.this.iqU.setVisibility(0);
            }
            AppMethodBeat.m2505o(81154);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.i$2 */
    class C131662 extends SimpleOnGestureListener {
        C131662() {
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(81155);
            C4990ab.m7411d("MicroMsg.scanner.ScanMode", "double click,pointer:%d,x:%f,y:%f", Integer.valueOf(motionEvent.getActionIndex()), Float.valueOf(motionEvent.getX(motionEvent.getActionIndex())), Float.valueOf(motionEvent.getY(motionEvent.getActionIndex())));
            C13161i.this.qet.mo25204ah(5, 2, 100);
            AppMethodBeat.m2505o(81155);
            return true;
        }
    }

    public abstract void cgN();

    public abstract C3771b cgO();

    public abstract int cgP();

    public abstract int cgQ();

    public abstract void cgR();

    public abstract boolean cgS();

    public abstract boolean cgT();

    /* renamed from: j */
    public abstract void mo8429j(Rect rect);

    public abstract void onDestroy();

    public abstract void onResume();

    public final C13164b chu() {
        return this.qet;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: kl */
    public final void mo25197kl(boolean z) {
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

    public C13161i(C13164b c13164b, Point point) {
        this.qet = c13164b;
        this.qeo = point;
    }

    public C13161i(C13164b c13164b, Point point, byte b) {
        this.qet = c13164b;
        this.qeo = point;
        this.qer = 50;
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
    }

    /* renamed from: e */
    public final void mo25194e(Point point) {
        this.qeo = point;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dw */
    public void mo25192dw(View view) {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fd */
    public final double mo25196fd(int i, int i2) {
        Activity context = this.qet.getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = ((double) displayMetrics.densityDpi) / 160.0d;
        C4990ab.m7411d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", Double.valueOf(d));
        int i3 = (int) (((float) this.qeo.x) * 0.85f);
        int i4 = (int) (((float) this.qeo.y) * 0.85f);
        int i5;
        if ((this instanceof C3764j) || (this instanceof C41306c)) {
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
        this.qep = C4977b.m7371b(this.qet.getContext(), ((float) i) * f);
        this.qeq = C4977b.m7371b(this.qet.getContext(), ((float) i2) * f);
        if (this.qep > i3 || this.qeq > i5) {
            while (true) {
                if (this.qep <= i3 && this.qeq <= i5) {
                    break;
                }
                this.qep = C4977b.m7371b(this.qet.getContext(), ((float) i) * f);
                this.qeq = C4977b.m7371b(this.qet.getContext(), ((float) i2) * f);
                f -= 0.1f;
            }
            C4990ab.m7417i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", Float.valueOf(f));
        }
        if (this.qep % 2 == 1) {
            this.qep++;
        }
        if (this.qeq % 2 == 1) {
            this.qeq++;
        }
        C4990ab.m7411d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", Integer.valueOf(this.qep), Integer.valueOf(this.qeq), this.qeo);
        return d;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: H */
    public Rect mo25189H(boolean z, boolean z2) {
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
                i3 = C4977b.m7371b(this.qet.getContext(), (float) this.qes);
                i4 = this.qeq + i3;
            } else {
                i = (i5 / 2) - (this.qep / 2);
                i2 = (i5 / 2) + (this.qep / 2);
                i3 = C4977b.m7371b(this.qet.getContext(), (float) this.qes);
                i4 = this.qeq + i3;
            }
            C4990ab.m7411d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.qem = new Rect(i, i3, i2, i4);
        }
        return this.qem;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: km */
    public Rect mo25198km(boolean z) {
        return mo25189H(true, z);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: f */
    public void mo25195f(Point point) {
        this.lUF = point;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: kn */
    public void mo8431kn(boolean z) {
        this.ovx = z;
    }

    /* renamed from: ko */
    public final void mo25199ko(boolean z) {
        if (this.iqU != null) {
            this.iqU.setVisibility(z ? 0 : 4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dx */
    public final void mo25193dx(View view) {
        this.lCs = new GestureDetector(new C131662());
        view.setOnTouchListener(new C131623());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo25190a(byte[] bArr, Point point, int i, Rect rect) {
        C4990ab.m7416i("MicroMsg.scanner.ScanMode", "decode count:" + C21682m.pZK.pZN);
        if (cgO() != null) {
            cgO().mo8441a(bArr, point, i, rect);
            if (C21682m.pZK.pZN == 30) {
                this.qet.chk();
            }
        }
    }
}
