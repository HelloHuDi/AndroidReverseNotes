package com.tencent.p177mm.plugin.music.p467ui;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.music.model.C28571a;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.music.ui.LyricView */
public class LyricView extends View {
    public static int oOi = C1338a.fromDPToPix(C4996ah.getContext(), 16);
    public static int oOj = C1338a.fromDPToPix(C4996ah.getContext(), 10);
    private int bCp = this.oOk;
    private float faK;
    private float faL;
    private long fnZ;
    private int height;
    private GestureDetector lCs;
    private C28571a oOc;
    private TextPaint oOd;
    private TextPaint oOe;
    private int oOf;
    private int oOg;
    private int oOh = -1;
    private int oOk = (oOi + oOj);
    private boolean oOl;
    private boolean oOm;
    private int oOn;
    private int width;

    /* renamed from: com.tencent.mm.plugin.music.ui.LyricView$a */
    class C28578a extends SimpleOnGestureListener {
        private C28578a() {
        }

        /* synthetic */ C28578a(LyricView lyricView, byte b) {
            this();
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(105043);
            String a = LyricView.m86018a(LyricView.this, motionEvent.getX(), motionEvent.getY());
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7416i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
                AppMethodBeat.m2505o(105043);
                return;
            }
            C39445e.bUl().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", a));
            Toast.makeText(LyricView.this.getContext(), LyricView.this.getContext().getString(C25738R.string.d3s, new Object[]{a}), 0).show();
            AppMethodBeat.m2505o(105043);
        }
    }

    public void setLyricObj(C28571a c28571a) {
        AppMethodBeat.m2504i(105044);
        this.oOc = c28571a;
        invalidate();
        AppMethodBeat.m2505o(105044);
    }

    public void setCurrentTime(long j) {
        AppMethodBeat.m2504i(105045);
        if (this.fnZ != j) {
            this.fnZ = j;
            if (this.oOc == null || this.oOc.oMj.size() == 0) {
                AppMethodBeat.m2505o(105045);
                return;
            }
            int i = -1;
            int i2 = 0;
            while (i2 < this.oOc.oMj.size() && this.oOc.mo46702zJ(i2).timestamp < j) {
                if (!this.oOc.mo46702zJ(i2).oMp) {
                    i = i2;
                }
                i2++;
            }
            if (!(this.oOm || i == this.oOh)) {
                this.oOh = i;
                this.oOf = (oOi + oOj) * this.oOh;
                this.oOg = (oOi + oOj) * ((this.oOc.oMj.size() - this.oOh) - 1);
                if (this.bCp == 0) {
                    this.bCp = -this.oOk;
                }
                this.oOl = true;
                invalidate();
            }
        }
        AppMethodBeat.m2505o(105045);
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105046);
        initView();
        AppMethodBeat.m2505o(105046);
    }

    public LyricView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(105047);
        initView();
        AppMethodBeat.m2505o(105047);
    }

    static {
        AppMethodBeat.m2504i(105054);
        AppMethodBeat.m2505o(105054);
    }

    private void initView() {
        AppMethodBeat.m2504i(105048);
        this.oOd = new TextPaint();
        this.oOd.setTextSize((float) oOi);
        this.oOd.setColor(-1);
        this.oOd.setAntiAlias(true);
        this.oOd.setTextAlign(Align.CENTER);
        this.oOe = new TextPaint();
        this.oOe.setTextSize((float) oOi);
        this.oOe.setColor(-1);
        this.oOe.setAlpha(C31128d.MIC_SketchMark);
        this.oOe.setAntiAlias(true);
        this.oOe.setTextAlign(Align.CENTER);
        this.lCs = new GestureDetector(getContext(), new C28578a(this, (byte) 0));
        AppMethodBeat.m2505o(105048);
    }

    public void setLyricColor(int i) {
        AppMethodBeat.m2504i(105049);
        this.oOd.setColor(i);
        this.oOd.setAlpha(255);
        this.oOe.setColor(i);
        this.oOe.setAlpha(C31128d.MIC_SketchMark);
        AppMethodBeat.m2505o(105049);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(105050);
        super.onDraw(canvas);
        if (this.oOc == null) {
            C4990ab.m7418v("MicroMsg.Music.LyricView", "lyricObj is null");
            AppMethodBeat.m2505o(105050);
            return;
        }
        if (this.height == 0 || this.width == 0) {
            this.height = getMeasuredHeight();
            this.width = getMeasuredWidth();
        }
        if (this.oOh < 0) {
            AppMethodBeat.m2505o(105050);
            return;
        }
        int i = this.bCp;
        if (this.oOc != null && this.oOc.oMj.size() > this.oOh) {
            int i2;
            int i3 = (this.height / 2) - i;
            if (i3 < this.height && i3 > 0) {
                canvas.drawText(this.oOc.mo46702zJ(this.oOh).content, (float) (this.width / 2), (float) i3, this.oOd);
            }
            for (i = this.oOh - 1; i >= 0; i--) {
                i2 = i3 - ((this.oOh - i) * (oOi + oOj));
                if (i2 > 0 && i2 < this.height) {
                    canvas.drawText(this.oOc.mo46702zJ(i).content, (float) (this.width / 2), (float) i2, this.oOe);
                }
            }
            i = this.oOh;
            while (true) {
                i++;
                if (i >= this.oOc.oMj.size()) {
                    break;
                }
                i2 = ((i - this.oOh) * (oOi + oOj)) + i3;
                if (i2 < this.height && i2 > 0) {
                    canvas.drawText(this.oOc.mo46702zJ(i).content, (float) (this.width / 2), (float) i2, this.oOe);
                }
            }
        }
        if (this.oOl) {
            Object obj;
            if (this.bCp != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.bCp = (int) (((float) this.bCp) * 0.9f);
                invalidate();
            }
        }
        AppMethodBeat.m2505o(105050);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(105051);
        super.onSizeChanged(i, i2, i3, i4);
        this.height = i2;
        this.width = i;
        AppMethodBeat.m2505o(105051);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105052);
        this.lCs.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.faL = motionEvent.getY();
                this.faK = motionEvent.getX();
                this.oOn = this.bCp;
                this.oOm = true;
                this.oOl = false;
                break;
            case 1:
                this.oOm = false;
                break;
            case 2:
                int x = (int) (motionEvent.getX() - this.faK);
                int y = this.oOn - ((int) (motionEvent.getY() - this.faL));
                if (y > 0) {
                    this.bCp = y > this.oOg ? this.oOg : y;
                } else {
                    this.bCp = y < (-this.oOf) ? -this.oOf : y;
                }
                invalidate();
                C4990ab.m7411d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", Integer.valueOf(x), Integer.valueOf(r3), Integer.valueOf(y), Integer.valueOf(this.oOn));
                break;
        }
        AppMethodBeat.m2505o(105052);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ String m86018a(LyricView lyricView, float f, float f2) {
        String str;
        AppMethodBeat.m2504i(105053);
        C4990ab.m7417i("MicroMsg.Music.LyricView", "getSentenceByXY %f, %f", Float.valueOf(f), Float.valueOf(f2));
        if (lyricView.oOc != null && lyricView.oOc.oMj.size() > 0) {
            int i = (lyricView.height / 2) - lyricView.bCp;
            int i2 = i - ((oOi + oOj) / 2);
            i += (oOi + oOj) / 2;
            if (f2 >= ((float) i2) && f2 <= ((float) i)) {
                str = lyricView.oOc.mo46702zJ(lyricView.oOh).content;
                AppMethodBeat.m2505o(105053);
                return str;
            } else if (f2 < ((float) i2)) {
                i = (lyricView.oOh - (((int) (((float) i2) - f2)) / (oOi + oOj))) - 1;
                if (i < lyricView.oOc.oMj.size() && i >= 0) {
                    str = lyricView.oOc.mo46702zJ(i).content;
                    AppMethodBeat.m2505o(105053);
                    return str;
                }
            } else if (f2 > ((float) i)) {
                i = ((((int) (f2 - ((float) i))) / (oOi + oOj)) + lyricView.oOh) + 1;
                if (i < lyricView.oOc.oMj.size() && i >= 0) {
                    str = lyricView.oOc.mo46702zJ(i).content;
                    AppMethodBeat.m2505o(105053);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.m2505o(105053);
        return str;
    }
}
