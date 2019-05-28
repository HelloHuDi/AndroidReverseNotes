package com.tencent.p177mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.p177mm.view.p1097f.C16067a;

/* renamed from: com.tencent.mm.view.SmileyPanelScrollView */
public class SmileyPanelScrollView extends View {
    private static boolean DEBUG = false;
    private int AaA;
    private boolean AaB = false;
    private boolean AaC = false;
    public int AaD = -1;
    public int AaE = -1;
    public float AaF;
    public boolean AaG = false;
    private boolean AaH = false;
    public int AaI = 0;
    private int AaJ = 1;
    private C16035a AaK = new C16035a();
    private C46714b Aak;
    private C16067a Aal;
    private Drawable Aam;
    private Drawable Aan;
    private Drawable Aao;
    private Drawable Aap;
    private int Aaq;
    public int Aar;
    private int Aas;
    private Paint Aat;
    private int Aau;
    private int Aav;
    private int Aaw;
    private int Aax;
    private int Aay;
    private int Aaz;
    private int STATE_NONE = 0;
    private Context mContext;
    private int mHeight;
    private int mState = this.STATE_NONE;
    private int mWidth;
    /* renamed from: xJ */
    private int f17953xJ;
    /* renamed from: xM */
    private int f17954xM;

    /* renamed from: com.tencent.mm.view.SmileyPanelScrollView$a */
    public class C16035a implements Runnable {
        long AaL;
        long mStartTime;

        /* Access modifiers changed, original: final */
        public final void dMJ() {
            AppMethodBeat.m2504i(62942);
            this.AaL = 300;
            this.mStartTime = SystemClock.uptimeMillis();
            C7060h.pYm.mo8381e(13361, Integer.valueOf(0));
            AppMethodBeat.m2505o(62942);
        }

        public final void run() {
            AppMethodBeat.m2504i(62943);
            dMJ();
            AppMethodBeat.m2505o(62943);
        }
    }

    /* renamed from: com.tencent.mm.view.SmileyPanelScrollView$b */
    public interface C46714b {
        /* renamed from: Qz */
        void mo31132Qz(int i);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(62944);
        init(context);
        AppMethodBeat.m2505o(62944);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62945);
        init(context);
        AppMethodBeat.m2505o(62945);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(62946);
        this.mContext = context;
        this.Aam = C5147a.m7837f(getResources(), C1318a.smiley_recent_dot);
        this.Aao = this.mContext.getResources().getDrawable(C25738R.drawable.smiley_panel_scroll_thumb_selected);
        this.Aan = this.mContext.getResources().getDrawable(C25738R.drawable.smiley_panel_scroll_thumb_pressed);
        this.Aap = this.mContext.getResources().getDrawable(C25738R.drawable.smiley_panel_scroll_track_pressed);
        this.Aau = C1338a.fromDPToPix(this.mContext, 12);
        this.Aav = this.Aan.getIntrinsicHeight();
        this.Aaw = this.Aan.getIntrinsicWidth();
        this.Aax = this.Aap.getIntrinsicHeight();
        this.Aaz = this.Aao.getIntrinsicHeight();
        this.AaA = this.Aao.getIntrinsicWidth();
        C4990ab.m7411d("MicroMsg.SmileyPanelScrollView", "init mDotPadding:%d mDotHeight:%d mDotWidth:%d", Integer.valueOf(this.Aau), Integer.valueOf(this.Aav), Integer.valueOf(this.Aaw));
        this.Aat = new Paint();
        this.Aat.setColor(-65536);
        this.Aat.setAntiAlias(true);
        this.Aat.setTextAlign(Align.CENTER);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.Aas = this.Aay / (this.Aaw + this.Aau);
        C4990ab.m7411d("MicroMsg.SmileyPanelScrollView", "init mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.Aay), Integer.valueOf(this.Aas));
        AppMethodBeat.m2505o(62946);
    }

    public void setSmileyPanelStg(C16067a c16067a) {
        this.Aal = c16067a;
    }

    public void setOnPageSelectListener(C46714b c46714b) {
        this.Aak = c46714b;
    }

    /* renamed from: f */
    public final void mo75107f(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(62947);
        C4990ab.m7411d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        this.Aaq = i;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > this.Aaq) {
            i2 = this.Aaq;
        }
        this.Aar = i2;
        if (this.AaE == -1 || z || this.AaI == 0) {
            this.AaE = this.Aar;
        }
        if (this.AaD == -1 || z || this.AaI == 0) {
            this.AaD = this.Aar;
            this.AaF = 0.0f;
        }
        this.AaH = z2;
        invalidate();
        AppMethodBeat.m2505o(62947);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        AppMethodBeat.m2504i(62948);
        super.draw(canvas);
        C16035a c16035a = this.AaK;
        if (SmileyPanelScrollView.this.getState() != SmileyPanelScrollView.this.AaJ) {
            i = 102;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis > c16035a.mStartTime + c16035a.AaL) {
                i2 = 255;
            } else {
                i2 = ((int) (((uptimeMillis - c16035a.mStartTime) * 153) / c16035a.AaL)) + 102;
                if (i2 < 102) {
                    i2 = 102;
                }
            }
            i = i2;
        }
        int i3;
        int i4;
        int i5;
        if (this.Aaq > this.Aas) {
            this.AaB = true;
            i3 = (this.mHeight - this.Aax) / 2;
            i4 = (this.mWidth - this.Aay) / 2;
            this.f17953xJ = i4 - (this.AaA / 2);
            this.f17954xM = (this.f17953xJ + this.Aay) + this.AaA;
            if (DEBUG) {
                canvas.drawLine((float) this.f17953xJ, 0.0f, (float) this.f17953xJ, (float) this.mHeight, this.Aat);
                canvas.drawLine((float) this.f17954xM, 0.0f, (float) this.f17954xM, (float) this.mHeight, this.Aat);
            }
            this.Aap.setBounds(i4, i3, this.Aay + i4, this.Aax + i3);
            this.Aap.setAlpha(i);
            this.Aap.draw(canvas);
            i5 = (this.mHeight - this.Aaz) / 2;
            if (this.AaC || this.AaG) {
                i2 = (((this.Aay / (this.Aaq - 1)) * this.Aar) + i4) - (this.AaA / 2);
            } else if (this.AaE == this.AaD) {
                i2 = ((((this.Aay / (this.Aaq - 1)) * this.AaD) + i4) - (this.AaA / 2)) + ((int) (((float) (this.Aay / (this.Aaq - 1))) * this.AaF));
            } else {
                i2 = ((((this.Aay / (this.Aaq - 1)) * this.AaD) + i4) - (this.AaA / 2)) - ((int) (((float) (this.Aay / (this.Aaq - 1))) * (1.0f - this.AaF)));
            }
            this.Aao.setBounds(i2, i5, this.AaA + i2, this.Aaz + i5);
            this.Aao.draw(canvas);
        } else {
            this.AaB = false;
            i3 = (this.mHeight - this.Aav) / 2;
            i4 = (this.mWidth - (((this.Aau + this.Aaw) * (this.Aaq - 1)) + this.Aaw)) / 2;
            this.f17953xJ = i4 - ((this.AaA - this.Aaw) / 2);
            this.f17954xM = ((this.f17953xJ + (this.Aaw * this.Aaq)) + (this.Aau * (this.Aaq - 1))) + (this.AaA - this.Aaw);
            if (DEBUG) {
                canvas.drawLine((float) this.f17953xJ, 0.0f, (float) this.f17953xJ, (float) this.mHeight, this.Aat);
                canvas.drawLine((float) this.f17954xM, 0.0f, (float) this.f17954xM, (float) this.mHeight, this.Aat);
            }
            this.Aan.setBounds(i4, i3, this.Aaw + i4, this.Aav + i3);
            i2 = (this.Aam.getIntrinsicWidth() - this.Aaw) / 2;
            i5 = (this.Aam.getIntrinsicHeight() - this.Aav) / 2;
            this.Aam.setBounds(i4 - i2, i3 - i5, i2 + (this.Aaw + i4), i5 + (this.Aav + i3));
            i5 = (this.mHeight - this.Aaz) / 2;
            if (this.AaC || this.AaG) {
                i2 = i4 - ((this.AaA - this.Aaw) / 2);
            } else {
                i2 = (i4 - ((this.AaA - this.Aaw) / 2)) + ((int) (((float) (this.Aaw + this.Aau)) * (((float) (this.AaE - this.AaD)) + this.AaF)));
            }
            this.Aao.setBounds(i2, i5, this.AaA + i2, this.Aaz + i5);
            for (i5 = 0; i5 < this.Aaq; i5++) {
                canvas.save();
                if (i5 > 0) {
                    canvas.translate((float) ((this.Aaw + this.Aau) * i5), 0.0f);
                }
                if (i5 == 0 && this.AaH) {
                    this.Aam.draw(canvas);
                } else {
                    this.Aan.setAlpha(i);
                    this.Aan.draw(canvas);
                }
                canvas.restore();
            }
            if (this.AaD > this.Aaq - 1) {
                this.AaD = this.Aaq - 1;
            }
            i5 = (this.Aaw + this.Aau) * this.AaD;
            if (i2 + i5 > this.f17954xM) {
                i2 = 0;
                C4990ab.m7416i("MicroMsg.SmileyPanelScrollView", "over right.");
            } else {
                i2 = i5;
            }
            canvas.save();
            canvas.translate((float) i2, 0.0f);
            this.Aao.draw(canvas);
            canvas.restore();
        }
        if (getState() == this.AaJ && i < 255) {
            invalidate();
        }
        AppMethodBeat.m2505o(62948);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(62949);
        super.onSizeChanged(i, i2, i3, i4);
        if (i != this.mWidth) {
            this.mWidth = getMeasuredWidth();
            this.mHeight = getMeasuredHeight();
            this.Aay = (this.mWidth - (this.Aal.getColumnWidth() - this.Aal.Aed)) - (C1338a.m2856al(this.mContext, C25738R.dimen.f10015nh) * 2);
            this.Aas = this.Aay / (this.Aaw + this.Aau);
            C4990ab.m7411d("MicroMsg.SmileyPanelScrollView", "onSizeChanged mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.Aay), Integer.valueOf(this.Aas));
            if (this.mHeight == 0) {
                C4990ab.m7416i("MicroMsg.SmileyPanelScrollView", "user default height");
                this.mHeight = C1338a.fromDPToPix(this.mContext, 16);
            }
        }
        AppMethodBeat.m2505o(62949);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        AppMethodBeat.m2504i(62950);
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (x < this.f17953xJ - this.Aau || x > this.f17954xM + this.Aau) {
            C4990ab.m7411d("MicroMsg.SmileyPanelScrollView", "over x :%d mLeft:%d mRight:%d ", Integer.valueOf(x), Integer.valueOf(this.f17953xJ), Integer.valueOf(this.f17954xM));
            if (action == 0) {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(62950);
                return onTouchEvent;
            }
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            if (x < this.f17953xJ) {
                x = this.f17953xJ;
            }
            if (x > this.f17954xM) {
                x = this.f17954xM;
            }
            if (this.AaB) {
                x = (x - this.f17953xJ) / (this.Aay / (this.Aaq - 1));
            } else {
                x = ((x - this.f17953xJ) + this.Aau) / (this.Aaw + this.Aau);
            }
            if (x > this.Aaq - 1) {
                x = this.Aaq - 1;
            }
            this.Aak.mo31132Qz(x);
            this.AaD = x;
            this.AaE = x;
        }
        switch (action) {
            case 0:
                if (i == 0) {
                    this.AaC = true;
                    this.AaG = true;
                    setState(this.AaJ);
                    this.AaK.dMJ();
                    invalidate();
                    break;
                }
                break;
            case 1:
            case 3:
                setState(this.STATE_NONE);
                this.AaC = false;
                invalidate();
                break;
            case 2:
                if (i == 0 && getState() != this.AaJ) {
                    setState(this.AaJ);
                    this.AaK.dMJ();
                    invalidate();
                    break;
                }
        }
        AppMethodBeat.m2505o(62950);
        return true;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int i) {
        this.mState = i;
    }
}
