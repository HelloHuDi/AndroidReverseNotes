package com.tencent.mm.y;

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
import com.tencent.mm.R;
import com.tencent.mm.api.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.util.ArrayList;
import java.util.List;

public class c implements Cloneable {
    private Rect eHc;
    public String eHf;
    public k eHg;
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

    class a {
        float[] eHr = new float[this.eHt];
        float[] eHs = new float[this.eHt];
        int eHt;

        public a(List<PointF> list) {
            AppMethodBeat.i(116273);
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
                    AppMethodBeat.o(116273);
                    return;
                }
            }
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(116289);
        c Qh = Qh();
        AppMethodBeat.o(116289);
        return Qh;
    }

    public c(Context context, Matrix matrix, String str, k kVar, Rect rect) {
        AppMethodBeat.i(116274);
        this.eHf = str;
        this.mMatrix = matrix;
        this.eHg = kVar;
        this.mContext = context;
        this.eHc = rect;
        this.eHi = new PointF();
        this.eHk = new PointF();
        AppMethodBeat.o(116274);
    }

    public c(Context context, Matrix matrix, String str, Rect rect) {
        AppMethodBeat.i(116275);
        this.eHf = str;
        this.mMatrix = matrix;
        this.mContext = context;
        this.eHc = rect;
        this.eHi = new PointF();
        this.eHk = new PointF();
        AppMethodBeat.o(116275);
    }

    public final void a(float f, float f2, float f3, int i) {
        AppMethodBeat.i(116276);
        this.eHh = q(Qf());
        this.eHl = (1.2f * ((float) this.eHc.width())) / ((float) this.eHh.getWidth());
        this.eHm = (0.1f * ((float) this.eHc.width())) / ((float) this.eHh.getWidth());
        this.eHj = f3;
        this.mRotation = i;
        this.mScale *= f3;
        ab.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", Float.valueOf(this.eHl), Float.valueOf(this.eHm), Float.valueOf(this.eHj));
        this.eHi.set(f, f2);
        ab.d("MicroMsg.EmojiItem", "[setPoint] point:%s", this.eHi);
        Qg();
        AppMethodBeat.o(116276);
    }

    public final boolean Qc() {
        AppMethodBeat.i(116277);
        ab.d("MicroMsg.EmojiItem", "[checkBitmap]");
        if (this.eHh == null || this.eHh.isRecycled()) {
            this.eHh = q(Qf());
            AppMethodBeat.o(116277);
            return true;
        }
        AppMethodBeat.o(116277);
        return false;
    }

    public final boolean D(float f, float f2) {
        AppMethodBeat.i(116278);
        this.eHo.clear();
        this.eHo.add(ac(this.eHp - 180.0f));
        this.eHo.add(ac(-this.eHp));
        this.eHo.add(ac(this.eHp));
        this.eHo.add(ac((-this.eHp) + 180.0f));
        a aVar = new a(this.eHo);
        int i = aVar.eHt - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 < aVar.eHt) {
            if ((aVar.eHs[i2] < f2 && aVar.eHs[i] >= f2) || (aVar.eHs[i] < f2 && aVar.eHs[i2] >= f2)) {
                if (((aVar.eHr[i] - aVar.eHr[i2]) * ((f2 - aVar.eHs[i2]) / (aVar.eHs[i] - aVar.eHs[i2]))) + aVar.eHr[i2] < f) {
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
        AppMethodBeat.o(116278);
        return z;
    }

    public void setSelected(boolean z) {
        this.ejw = z;
    }

    public final void b(float f, float f2, float f3, int i) {
        AppMethodBeat.i(116279);
        this.eHi.offset(f, f2);
        if (0.0f != f3) {
            this.mScale = f3;
        }
        this.mRotation = i;
        AppMethodBeat.o(116279);
    }

    public final void clear() {
        AppMethodBeat.i(116280);
        ab.i("MicroMsg.EmojiItem", "[clear]");
        if (!(this.eHh == null || this.eHh.isRecycled())) {
            ab.i("MicroMsg.EmojiItem", "bitmap recycle %s", this.eHh.toString());
            this.eHh.recycle();
            this.eHh = null;
        }
        AppMethodBeat.o(116280);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(116281);
        if (this.eHh == null || this.eHh.isRecycled()) {
            ab.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
            AppMethodBeat.o(116281);
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
            canvas.drawBitmap(this.eHh, (float) ((-Qd()) / 2), (float) ((-Qe()) / 2), null);
        } else {
            canvas.clipRect(((float) ((-Qd()) / 2)) + 40.0f, ((float) ((-Qe()) / 2)) + 40.0f, ((float) (this.eHh.getWidth() / 2)) - 40.0f, ((float) (this.eHh.getHeight() / 2)) - 40.0f);
            canvas.drawBitmap(this.eHh, (float) ((-Qd()) / 2), (float) ((-Qe()) / 2), null);
        }
        canvas.restore();
        canvas.setDrawFilter(null);
        AppMethodBeat.o(116281);
    }

    private int Qd() {
        AppMethodBeat.i(116282);
        if (this.eHh != null) {
            int width = this.eHh.getWidth();
            AppMethodBeat.o(116282);
            return width;
        }
        AppMethodBeat.o(116282);
        return 0;
    }

    private int Qe() {
        AppMethodBeat.i(116283);
        if (this.eHh != null) {
            int height = this.eHh.getHeight();
            AppMethodBeat.o(116283);
            return height;
        }
        AppMethodBeat.o(116283);
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public Bitmap Qf() {
        AppMethodBeat.i(116284);
        if (this.eHh == null || this.eHh.isRecycled()) {
            this.eHh = this.eHg.w(this.mContext, 480);
        }
        if (this.eHh == null) {
            ab.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
            d dVar = new d();
            this.eHh = d.createBitmap(120, 120, Config.ARGB_4444);
            new Canvas(this.eHh).drawColor(-7829368);
        }
        Bitmap bitmap = this.eHh;
        AppMethodBeat.o(116284);
        return bitmap;
    }

    private Bitmap q(Bitmap bitmap) {
        AppMethodBeat.i(116285);
        int width = (int) (((float) bitmap.getWidth()) + 80.0f);
        int height = (int) (((float) bitmap.getHeight()) + 80.0f);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 40.0f, 40.0f, null);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.emoji_box), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.emoji_box).getNinePatchChunk(), new Rect(), null);
        ninePatchDrawable.setBounds(0, 0, width, height);
        ninePatchDrawable.draw(canvas);
        AppMethodBeat.o(116285);
        return createBitmap;
    }

    public final void Qg() {
        AppMethodBeat.i(116286);
        float f = this.eHj;
        double Qd = (double) (((((float) Qd()) * 1.0f) / 2.0f) * f);
        double Qe = (double) (f * ((((float) Qe()) * 1.0f) / 2.0f));
        this.eHq = (float) Math.sqrt((Qd * Qd) + (Qe * Qe));
        this.eHp = (float) Math.toDegrees(Math.atan(Qe / Qd));
        AppMethodBeat.o(116286);
    }

    private PointF ac(float f) {
        AppMethodBeat.i(116287);
        float f2 = (this.mScale / this.eHj) / 2.0f;
        double Qd = (double) (((((float) Qd()) * 1.0f) / 2.0f) * f2);
        double Qe = (double) (f2 * ((((float) Qe()) * 1.0f) / 2.0f));
        this.eHq = (float) Math.sqrt((Qe * Qe) + (Qd * Qd));
        PointF pointF = new PointF();
        Qd = (((double) (((float) this.mRotation) + f)) * 3.141592653589793d) / 180.0d;
        pointF.x = this.eHi.x + ((float) (((double) this.eHq) * Math.cos(Qd)));
        pointF.y = this.eHi.y + ((float) (Math.sin(Qd) * ((double) this.eHq)));
        AppMethodBeat.o(116287);
        return pointF;
    }

    public final c Qh() {
        c cVar;
        Throwable e;
        AppMethodBeat.i(116288);
        try {
            cVar = (c) super.clone();
            try {
                cVar.eHi = new PointF(this.eHi.x, this.eHi.y);
                cVar.eHg = this.eHg;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                ab.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
                AppMethodBeat.o(116288);
                return cVar;
            }
        } catch (CloneNotSupportedException e3) {
            e = e3;
            cVar = null;
            ab.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
            AppMethodBeat.o(116288);
            return cVar;
        }
        AppMethodBeat.o(116288);
        return cVar;
    }
}
