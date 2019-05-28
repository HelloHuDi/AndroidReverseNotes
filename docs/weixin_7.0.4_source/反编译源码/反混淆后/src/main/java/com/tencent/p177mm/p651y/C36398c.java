package com.tencent.p177mm.p651y;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.y.c */
public class C36398c implements Cloneable {
    private Rect eHc;
    public String eHf;
    public C8955k eHg;
    public Bitmap eHh;
    public PointF eHi;
    private float eHj = 1.0f;
    public PointF eHk;
    private float eHl;
    private float eHm;
    public boolean eHn = false;
    List<PointF> eHo = new ArrayList();
    private float eHp;
    private float eHq;
    public boolean ejw;
    protected Context mContext;
    private Matrix mMatrix;
    public int mRotation = 0;
    public float mScale = 1.0f;

    /* renamed from: com.tencent.mm.y.c$a */
    class C36399a {
        float[] eHr = new float[this.eHt];
        float[] eHs = new float[this.eHt];
        int eHt;

        public C36399a(List<PointF> list) {
            AppMethodBeat.m2504i(116273);
            this.eHt = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eHt) {
                    this.eHr[i2] = ((PointF) list.get(i2)).x;
                    this.eHs[i2] = ((PointF) list.get(i2)).y;
                    i = i2 + 1;
                } else {
                    new StringBuilder("lasso size:").append(this.eHt);
                    AppMethodBeat.m2505o(116273);
                    return;
                }
            }
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(116289);
        C36398c Qh = mo57318Qh();
        AppMethodBeat.m2505o(116289);
        return Qh;
    }

    public C36398c(Context context, Matrix matrix, String str, C8955k c8955k, Rect rect) {
        AppMethodBeat.m2504i(116274);
        this.eHf = str;
        this.mMatrix = matrix;
        this.eHg = c8955k;
        this.mContext = context;
        this.eHc = rect;
        this.eHi = new PointF();
        this.eHk = new PointF();
        AppMethodBeat.m2505o(116274);
    }

    public C36398c(Context context, Matrix matrix, String str, Rect rect) {
        AppMethodBeat.m2504i(116275);
        this.eHf = str;
        this.mMatrix = matrix;
        this.mContext = context;
        this.eHc = rect;
        this.eHi = new PointF();
        this.eHk = new PointF();
        AppMethodBeat.m2505o(116275);
    }

    /* renamed from: a */
    public final void mo57319a(float f, float f2, float f3, int i) {
        AppMethodBeat.m2504i(116276);
        this.eHh = m60026q(mo57316Qf());
        this.eHl = (1.2f * ((float) this.eHc.width())) / ((float) this.eHh.getWidth());
        this.eHm = (0.1f * ((float) this.eHc.width())) / ((float) this.eHh.getWidth());
        this.eHj = f3;
        this.mRotation = i;
        this.mScale *= f3;
        C4990ab.m7417i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", Float.valueOf(this.eHl), Float.valueOf(this.eHm), Float.valueOf(this.eHj));
        this.eHi.set(f, f2);
        C4990ab.m7411d("MicroMsg.EmojiItem", "[setPoint] point:%s", this.eHi);
        mo57317Qg();
        AppMethodBeat.m2505o(116276);
    }

    /* renamed from: Qc */
    public final boolean mo57315Qc() {
        AppMethodBeat.m2504i(116277);
        C4990ab.m7410d("MicroMsg.EmojiItem", "[checkBitmap]");
        if (this.eHh == null || this.eHh.isRecycled()) {
            this.eHh = m60026q(mo57316Qf());
            AppMethodBeat.m2505o(116277);
            return true;
        }
        AppMethodBeat.m2505o(116277);
        return false;
    }

    /* renamed from: D */
    public final boolean mo57314D(float f, float f2) {
        AppMethodBeat.m2504i(116278);
        this.eHo.clear();
        this.eHo.add(m60025ac(this.eHp - 180.0f));
        this.eHo.add(m60025ac(-this.eHp));
        this.eHo.add(m60025ac(this.eHp));
        this.eHo.add(m60025ac((-this.eHp) + 180.0f));
        C36399a c36399a = new C36399a(this.eHo);
        int i = c36399a.eHt - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 < c36399a.eHt) {
            if ((c36399a.eHs[i2] < f2 && c36399a.eHs[i] >= f2) || (c36399a.eHs[i] < f2 && c36399a.eHs[i2] >= f2)) {
                if (((c36399a.eHr[i] - c36399a.eHr[i2]) * ((f2 - c36399a.eHs[i2]) / (c36399a.eHs[i] - c36399a.eHs[i2]))) + c36399a.eHr[i2] < f) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
            }
            i = i2;
            i2++;
        }
        AppMethodBeat.m2505o(116278);
        return z;
    }

    public void setSelected(boolean z) {
        this.ejw = z;
    }

    /* renamed from: b */
    public final void mo57320b(float f, float f2, float f3, int i) {
        AppMethodBeat.m2504i(116279);
        this.eHi.offset(f, f2);
        if (0.0f != f3) {
            this.mScale = f3;
        }
        this.mRotation = i;
        AppMethodBeat.m2505o(116279);
    }

    public final void clear() {
        AppMethodBeat.m2504i(116280);
        C4990ab.m7416i("MicroMsg.EmojiItem", "[clear]");
        if (!(this.eHh == null || this.eHh.isRecycled())) {
            C4990ab.m7417i("MicroMsg.EmojiItem", "bitmap recycle %s", this.eHh.toString());
            this.eHh.recycle();
            this.eHh = null;
        }
        AppMethodBeat.m2505o(116280);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(116281);
        if (this.eHh == null || this.eHh.isRecycled()) {
            C4990ab.m7420w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
            AppMethodBeat.m2505o(116281);
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.eHl < this.mScale * this.eHj) {
            this.mScale = this.eHl / this.eHj;
        } else if (this.eHm > this.mScale * this.eHj) {
            this.mScale = this.eHm / this.eHj;
        }
        canvas.save();
        canvas.translate(this.eHi.x, this.eHi.y);
        canvas.rotate((float) this.mRotation);
        canvas.scale(this.mScale, this.mScale);
        if (this.ejw) {
            canvas.drawBitmap(this.eHh, (float) ((-m60023Qd()) / 2), (float) ((-m60024Qe()) / 2), null);
        } else {
            canvas.clipRect(((float) ((-m60023Qd()) / 2)) + 40.0f, ((float) ((-m60024Qe()) / 2)) + 40.0f, ((float) (this.eHh.getWidth() / 2)) - 40.0f, ((float) (this.eHh.getHeight() / 2)) - 40.0f);
            canvas.drawBitmap(this.eHh, (float) ((-m60023Qd()) / 2), (float) ((-m60024Qe()) / 2), null);
        }
        canvas.restore();
        canvas.setDrawFilter(null);
        AppMethodBeat.m2505o(116281);
    }

    /* renamed from: Qd */
    private int m60023Qd() {
        AppMethodBeat.m2504i(116282);
        if (this.eHh != null) {
            int width = this.eHh.getWidth();
            AppMethodBeat.m2505o(116282);
            return width;
        }
        AppMethodBeat.m2505o(116282);
        return 0;
    }

    /* renamed from: Qe */
    private int m60024Qe() {
        AppMethodBeat.m2504i(116283);
        if (this.eHh != null) {
            int height = this.eHh.getHeight();
            AppMethodBeat.m2505o(116283);
            return height;
        }
        AppMethodBeat.m2505o(116283);
        return 0;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Qf */
    public Bitmap mo57316Qf() {
        AppMethodBeat.m2504i(116284);
        if (this.eHh == null || this.eHh.isRecycled()) {
            this.eHh = this.eHg.mo20411w(this.mContext, 480);
        }
        if (this.eHh == null) {
            C4990ab.m7412e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
            C5056d c5056d = new C5056d();
            this.eHh = C5056d.createBitmap(120, 120, Config.ARGB_4444);
            new Canvas(this.eHh).drawColor(-7829368);
        }
        Bitmap bitmap = this.eHh;
        AppMethodBeat.m2505o(116284);
        return bitmap;
    }

    /* renamed from: q */
    private Bitmap m60026q(Bitmap bitmap) {
        AppMethodBeat.m2504i(116285);
        int width = (int) (((float) bitmap.getWidth()) + 80.0f);
        int height = (int) (((float) bitmap.getHeight()) + 80.0f);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 40.0f, 40.0f, null);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), C25738R.drawable.emoji_box), BitmapFactory.decodeResource(this.mContext.getResources(), C25738R.drawable.emoji_box).getNinePatchChunk(), new Rect(), null);
        ninePatchDrawable.setBounds(0, 0, width, height);
        ninePatchDrawable.draw(canvas);
        AppMethodBeat.m2505o(116285);
        return createBitmap;
    }

    /* renamed from: Qg */
    public final void mo57317Qg() {
        AppMethodBeat.m2504i(116286);
        float f = this.eHj;
        double Qd = (double) (((((float) m60023Qd()) * 1.0f) / 2.0f) * f);
        double Qe = (double) (f * ((((float) m60024Qe()) * 1.0f) / 2.0f));
        this.eHq = (float) Math.sqrt((Qd * Qd) + (Qe * Qe));
        this.eHp = (float) Math.toDegrees(Math.atan(Qe / Qd));
        AppMethodBeat.m2505o(116286);
    }

    /* renamed from: ac */
    private PointF m60025ac(float f) {
        AppMethodBeat.m2504i(116287);
        float f2 = (this.mScale / this.eHj) / 2.0f;
        double Qd = (double) (((((float) m60023Qd()) * 1.0f) / 2.0f) * f2);
        double Qe = (double) (f2 * ((((float) m60024Qe()) * 1.0f) / 2.0f));
        this.eHq = (float) Math.sqrt((Qe * Qe) + (Qd * Qd));
        PointF pointF = new PointF();
        Qd = (((double) (((float) this.mRotation) + f)) * 3.141592653589793d) / 180.0d;
        pointF.x = this.eHi.x + ((float) (((double) this.eHq) * Math.cos(Qd)));
        pointF.y = this.eHi.y + ((float) (Math.sin(Qd) * ((double) this.eHq)));
        AppMethodBeat.m2505o(116287);
        return pointF;
    }

    /* renamed from: Qh */
    public final C36398c mo57318Qh() {
        C36398c c36398c;
        Throwable e;
        AppMethodBeat.m2504i(116288);
        try {
            c36398c = (C36398c) super.clone();
            try {
                c36398c.eHi = new PointF(this.eHi.x, this.eHi.y);
                c36398c.eHg = this.eHg;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                C4990ab.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
                AppMethodBeat.m2505o(116288);
                return c36398c;
            }
        } catch (CloneNotSupportedException e3) {
            e = e3;
            c36398c = null;
            C4990ab.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
            AppMethodBeat.m2505o(116288);
            return c36398c;
        }
        AppMethodBeat.m2505o(116288);
        return c36398c;
    }
}
