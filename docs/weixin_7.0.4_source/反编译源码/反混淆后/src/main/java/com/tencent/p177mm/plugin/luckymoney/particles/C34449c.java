package com.tencent.p177mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.luckymoney.particles.c */
public final class C34449c {
    private float emissionRate;
    private ValueAnimator jcQ;
    private final C34448b nZE;
    private final C28431d nZF;
    private final ViewGroup nZG;
    final ConfettiView nZH;
    final Queue<C28430b> nZI;
    final List<C28430b> nZJ;
    private long nZK;
    int nZL;
    long nZM;
    private float nZN;
    public Interpolator nZO;
    private Rect nZP;
    private float nZQ;
    private float nZR;
    private float nZS;
    private float nZT;
    private float nZU;
    private float nZV;
    private float nZW;
    private float nZX;
    private Float nZY;
    private Float nZZ;
    private Float oaa;
    private Float oab;
    private int oac;
    private int oad;
    private float oae;
    private float oaf;
    private float oag;
    private float oah;
    private Float oai;
    private Float oaj;
    private long oak;
    public float oal;
    public float oam;
    private final Random random;

    /* renamed from: com.tencent.mm.plugin.luckymoney.particles.c$2 */
    class C344502 implements AnimatorUpdateListener {
        C344502() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(42437);
            long currentPlayTime = valueAnimator.getCurrentPlayTime();
            C34449c.m56451a(C34449c.this, currentPlayTime);
            C34449c c34449c = C34449c.this;
            Iterator it = c34449c.nZJ.iterator();
            while (it.hasNext()) {
                Object obj;
                C28430b c28430b = (C28430b) it.next();
                if (c28430b.oaz == -1) {
                    c28430b.oaz = currentPlayTime;
                }
                long j = currentPlayTime - c28430b.oaz;
                c28430b.oaO = j >= 0;
                if (c28430b.oaO && !c28430b.terminated) {
                    c28430b.oaL = C28430b.m45118a(j, c28430b.oaA, c28430b.oaC, c28430b.nZU, c28430b.oaE, c28430b.nZY);
                    c28430b.oaM = C28430b.m45118a(j, c28430b.oaB, c28430b.oaD, c28430b.nZW, c28430b.oaF, c28430b.oaa);
                    c28430b.oaN = C28430b.m45118a(j, c28430b.oaG, c28430b.oaH, c28430b.oag, c28430b.oaI, c28430b.oai);
                    if (c28430b.nZO != null) {
                        c28430b.alpha = (int) (c28430b.nZO.getInterpolation(((float) j) / c28430b.oaJ) * 255.0f);
                    } else {
                        c28430b.alpha = 255;
                    }
                    boolean z = !c28430b.oaP && ((float) j) >= c28430b.oaJ;
                    c28430b.terminated = z;
                    c28430b.oaK = Math.min(1.0f, ((float) j) / c28430b.oaJ);
                }
                if (c28430b.terminated) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    it.remove();
                    c34449c.nZI.add(c28430b);
                }
            }
            if (C34449c.this.nZJ.size() != 0 || currentPlayTime < C34449c.this.nZM) {
                C34449c.this.nZH.invalidate();
                AppMethodBeat.m2505o(42437);
                return;
            }
            C34449c.this.bLM();
            AppMethodBeat.m2505o(42437);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.particles.c$1 */
    class C344511 implements OnAttachStateChangeListener {
        C344511() {
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.m2504i(42436);
            C34449c.this.bLM();
            AppMethodBeat.m2505o(42436);
        }
    }

    public C34449c(Context context, C34448b c34448b, C28431d c28431d, ViewGroup viewGroup) {
        this(c34448b, c28431d, viewGroup, ConfettiView.m5673es(context));
        AppMethodBeat.m2504i(42438);
        AppMethodBeat.m2505o(42438);
    }

    private C34449c(C34448b c34448b, C28431d c28431d, ViewGroup viewGroup, ConfettiView confettiView) {
        AppMethodBeat.m2504i(42439);
        this.random = new Random();
        this.nZI = new LinkedList();
        this.nZJ = new ArrayList(300);
        this.nZE = c34448b;
        this.nZF = c28431d;
        this.nZG = viewGroup;
        this.nZH = confettiView;
        this.nZH.nZJ = this.nZJ;
        this.nZH.addOnAttachStateChangeListener(new C344511());
        this.oak = -1;
        this.nZP = new Rect(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        AppMethodBeat.m2505o(42439);
    }

    public final C34449c bLG() {
        this.nZM = Long.MAX_VALUE;
        return this;
    }

    /* renamed from: aF */
    public final C34449c mo54984aF(float f) {
        this.emissionRate = f / 1000.0f;
        this.nZN = 1.0f / this.emissionRate;
        return this;
    }

    /* renamed from: R */
    public final C34449c mo54982R(float f, float f2) {
        this.nZQ = f / 1000.0f;
        this.nZR = f2 / 1000.0f;
        return this;
    }

    /* renamed from: S */
    public final C34449c mo54983S(float f, float f2) {
        this.nZS = f / 1000.0f;
        this.nZT = f2 / 1000.0f;
        return this;
    }

    /* renamed from: aG */
    public final C34449c mo54985aG(float f) {
        this.nZU = f / 1000000.0f;
        this.nZV = 0.0f;
        return this;
    }

    /* renamed from: aH */
    public final C34449c mo54986aH(float f) {
        this.nZW = f / 1000000.0f;
        this.nZX = 0.0f;
        return this;
    }

    public final C34449c bLH() {
        this.oac = 180;
        this.oad = 180;
        return this;
    }

    public final C34449c bLI() {
        this.oag = 3.6E-4f;
        this.oah = 1.8E-4f;
        return this;
    }

    public final C34449c bLJ() {
        AppMethodBeat.m2504i(42441);
        this.oai = Float.valueOf(0.36f);
        this.oaj = Float.valueOf(0.0f);
        AppMethodBeat.m2505o(42441);
        return this;
    }

    public final C34449c bLK() {
        this.oak = 1500;
        return this;
    }

    public final C34449c bLL() {
        AppMethodBeat.m2504i(42442);
        bLN();
        bLO();
        m56448Q(this.nZL, 0);
        bLP();
        AppMethodBeat.m2505o(42442);
        return this;
    }

    public final void bLM() {
        AppMethodBeat.m2504i(42443);
        if (this.jcQ != null) {
            this.jcQ.cancel();
        }
        this.nZH.bLM();
        AppMethodBeat.m2505o(42443);
    }

    private void bLN() {
        AppMethodBeat.m2504i(42444);
        if (this.jcQ != null) {
            this.jcQ.cancel();
        }
        this.nZK = 0;
        Iterator it = this.nZJ.iterator();
        while (it.hasNext()) {
            this.nZI.add(it.next());
            it.remove();
        }
        AppMethodBeat.m2505o(42444);
    }

    private void bLO() {
        AppMethodBeat.m2504i(42445);
        ViewParent parent = this.nZH.getParent();
        if (parent != null) {
            if (parent != this.nZG) {
                ((ViewGroup) parent).removeView(this.nZH);
            }
            this.nZH.terminated = false;
            AppMethodBeat.m2505o(42445);
        }
        this.nZG.addView(this.nZH);
        this.nZH.terminated = false;
        AppMethodBeat.m2505o(42445);
    }

    /* renamed from: Q */
    private void m56448Q(int i, long j) {
        AppMethodBeat.m2504i(42446);
        for (int i2 = 0; i2 < i; i2++) {
            C28430b b;
            C28430b c28430b = (C28430b) this.nZI.poll();
            if (c28430b == null) {
                b = this.nZE.mo24309b(this.random);
            } else {
                b = c28430b;
            }
            m56450a(b, this.nZF, this.random, j);
            this.nZJ.add(b);
        }
        AppMethodBeat.m2505o(42446);
    }

    private void bLP() {
        AppMethodBeat.m2504i(42447);
        this.jcQ = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
        this.jcQ.addUpdateListener(new C344502());
        this.jcQ.start();
        AppMethodBeat.m2505o(42447);
    }

    /* renamed from: a */
    private void m56450a(C28430b c28430b, C28431d c28431d, Random random, long j) {
        Float f;
        Float f2 = null;
        AppMethodBeat.m2504i(42448);
        c28430b.reset();
        c28430b.oaz = j;
        c28430b.oaA = c28431d.mo46416aI(random.nextFloat());
        c28430b.oaB = c28431d.mo46417aJ(random.nextFloat());
        c28430b.oaC = C34449c.m56449a(this.nZQ, this.nZR, random);
        c28430b.oaD = C34449c.m56449a(this.nZS, this.nZT, random);
        c28430b.nZU = C34449c.m56449a(this.nZU, this.nZV, random);
        c28430b.nZW = C34449c.m56449a(this.nZW, this.nZX, random);
        if (this.nZY == null) {
            f = null;
        } else {
            f = Float.valueOf(C34449c.m56449a(this.nZY.floatValue(), this.nZZ.floatValue(), random));
        }
        c28430b.nZY = f;
        if (this.oaa == null) {
            f = null;
        } else {
            f = Float.valueOf(C34449c.m56449a(this.oaa.floatValue(), this.oab.floatValue(), random));
        }
        c28430b.oaa = f;
        c28430b.oaG = C34449c.m56449a((float) this.oac, (float) this.oad, random);
        c28430b.oaH = C34449c.m56449a(this.oae, this.oaf, random);
        c28430b.oag = C34449c.m56449a(this.oag, this.oah, random);
        if (this.oai != null) {
            f2 = Float.valueOf(C34449c.m56449a(this.oai.floatValue(), this.oaj.floatValue(), random));
        }
        c28430b.oai = f2;
        c28430b.oak = this.oak;
        c28430b.nZO = this.nZO;
        c28430b.oaJ = C34449c.m56449a(this.oal, this.oam, random);
        c28430b.mo46414i(this.nZP);
        AppMethodBeat.m2505o(42448);
    }

    /* renamed from: a */
    private static float m56449a(float f, float f2, Random random) {
        AppMethodBeat.m2504i(42449);
        float nextFloat = (((random.nextFloat() * 2.0f) - 1.0f) * f2) + f;
        AppMethodBeat.m2505o(42449);
        return nextFloat;
    }

    /* renamed from: a */
    static /* synthetic */ void m56451a(C34449c c34449c, long j) {
        AppMethodBeat.m2504i(42450);
        if (j < c34449c.nZM) {
            if (c34449c.nZK == 0) {
                c34449c.nZK = j;
                AppMethodBeat.m2505o(42450);
                return;
            }
            int nextFloat = (int) (((float) (j - c34449c.nZK)) * (c34449c.random.nextFloat() * c34449c.emissionRate));
            if (nextFloat > 0) {
                c34449c.nZK = (long) (((float) c34449c.nZK) + (c34449c.nZN * ((float) nextFloat)));
                c34449c.m56448Q(nextFloat, j);
            }
        }
        AppMethodBeat.m2505o(42450);
    }
}
