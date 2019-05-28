package com.tencent.mm.plugin.luckymoney.particles;

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
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c {
    private float emissionRate;
    private ValueAnimator jcQ;
    private final b nZE;
    private final d nZF;
    private final ViewGroup nZG;
    final ConfettiView nZH;
    final Queue<b> nZI;
    final List<b> nZJ;
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

    public c(Context context, b bVar, d dVar, ViewGroup viewGroup) {
        this(bVar, dVar, viewGroup, ConfettiView.es(context));
        AppMethodBeat.i(42438);
        AppMethodBeat.o(42438);
    }

    private c(b bVar, d dVar, ViewGroup viewGroup, ConfettiView confettiView) {
        AppMethodBeat.i(42439);
        this.random = new Random();
        this.nZI = new LinkedList();
        this.nZJ = new ArrayList(300);
        this.nZE = bVar;
        this.nZF = dVar;
        this.nZG = viewGroup;
        this.nZH = confettiView;
        this.nZH.nZJ = this.nZJ;
        this.nZH.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                AppMethodBeat.i(42436);
                c.this.bLM();
                AppMethodBeat.o(42436);
            }
        });
        this.oak = -1;
        this.nZP = new Rect(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        AppMethodBeat.o(42439);
    }

    public final c bLG() {
        this.nZM = Long.MAX_VALUE;
        return this;
    }

    public final c aF(float f) {
        this.emissionRate = f / 1000.0f;
        this.nZN = 1.0f / this.emissionRate;
        return this;
    }

    public final c R(float f, float f2) {
        this.nZQ = f / 1000.0f;
        this.nZR = f2 / 1000.0f;
        return this;
    }

    public final c S(float f, float f2) {
        this.nZS = f / 1000.0f;
        this.nZT = f2 / 1000.0f;
        return this;
    }

    public final c aG(float f) {
        this.nZU = f / 1000000.0f;
        this.nZV = 0.0f;
        return this;
    }

    public final c aH(float f) {
        this.nZW = f / 1000000.0f;
        this.nZX = 0.0f;
        return this;
    }

    public final c bLH() {
        this.oac = 180;
        this.oad = 180;
        return this;
    }

    public final c bLI() {
        this.oag = 3.6E-4f;
        this.oah = 1.8E-4f;
        return this;
    }

    public final c bLJ() {
        AppMethodBeat.i(42441);
        this.oai = Float.valueOf(0.36f);
        this.oaj = Float.valueOf(0.0f);
        AppMethodBeat.o(42441);
        return this;
    }

    public final c bLK() {
        this.oak = 1500;
        return this;
    }

    public final c bLL() {
        AppMethodBeat.i(42442);
        bLN();
        bLO();
        Q(this.nZL, 0);
        bLP();
        AppMethodBeat.o(42442);
        return this;
    }

    public final void bLM() {
        AppMethodBeat.i(42443);
        if (this.jcQ != null) {
            this.jcQ.cancel();
        }
        this.nZH.bLM();
        AppMethodBeat.o(42443);
    }

    private void bLN() {
        AppMethodBeat.i(42444);
        if (this.jcQ != null) {
            this.jcQ.cancel();
        }
        this.nZK = 0;
        Iterator it = this.nZJ.iterator();
        while (it.hasNext()) {
            this.nZI.add(it.next());
            it.remove();
        }
        AppMethodBeat.o(42444);
    }

    private void bLO() {
        AppMethodBeat.i(42445);
        ViewParent parent = this.nZH.getParent();
        if (parent != null) {
            if (parent != this.nZG) {
                ((ViewGroup) parent).removeView(this.nZH);
            }
            this.nZH.terminated = false;
            AppMethodBeat.o(42445);
        }
        this.nZG.addView(this.nZH);
        this.nZH.terminated = false;
        AppMethodBeat.o(42445);
    }

    private void Q(int i, long j) {
        AppMethodBeat.i(42446);
        for (int i2 = 0; i2 < i; i2++) {
            b b;
            b bVar = (b) this.nZI.poll();
            if (bVar == null) {
                b = this.nZE.b(this.random);
            } else {
                b = bVar;
            }
            a(b, this.nZF, this.random, j);
            this.nZJ.add(b);
        }
        AppMethodBeat.o(42446);
    }

    private void bLP() {
        AppMethodBeat.i(42447);
        this.jcQ = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
        this.jcQ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(42437);
                long currentPlayTime = valueAnimator.getCurrentPlayTime();
                c.a(c.this, currentPlayTime);
                c cVar = c.this;
                Iterator it = cVar.nZJ.iterator();
                while (it.hasNext()) {
                    Object obj;
                    b bVar = (b) it.next();
                    if (bVar.oaz == -1) {
                        bVar.oaz = currentPlayTime;
                    }
                    long j = currentPlayTime - bVar.oaz;
                    bVar.oaO = j >= 0;
                    if (bVar.oaO && !bVar.terminated) {
                        bVar.oaL = b.a(j, bVar.oaA, bVar.oaC, bVar.nZU, bVar.oaE, bVar.nZY);
                        bVar.oaM = b.a(j, bVar.oaB, bVar.oaD, bVar.nZW, bVar.oaF, bVar.oaa);
                        bVar.oaN = b.a(j, bVar.oaG, bVar.oaH, bVar.oag, bVar.oaI, bVar.oai);
                        if (bVar.nZO != null) {
                            bVar.alpha = (int) (bVar.nZO.getInterpolation(((float) j) / bVar.oaJ) * 255.0f);
                        } else {
                            bVar.alpha = 255;
                        }
                        boolean z = !bVar.oaP && ((float) j) >= bVar.oaJ;
                        bVar.terminated = z;
                        bVar.oaK = Math.min(1.0f, ((float) j) / bVar.oaJ);
                    }
                    if (bVar.terminated) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        it.remove();
                        cVar.nZI.add(bVar);
                    }
                }
                if (c.this.nZJ.size() != 0 || currentPlayTime < c.this.nZM) {
                    c.this.nZH.invalidate();
                    AppMethodBeat.o(42437);
                    return;
                }
                c.this.bLM();
                AppMethodBeat.o(42437);
            }
        });
        this.jcQ.start();
        AppMethodBeat.o(42447);
    }

    private void a(b bVar, d dVar, Random random, long j) {
        Float f;
        Float f2 = null;
        AppMethodBeat.i(42448);
        bVar.reset();
        bVar.oaz = j;
        bVar.oaA = dVar.aI(random.nextFloat());
        bVar.oaB = dVar.aJ(random.nextFloat());
        bVar.oaC = a(this.nZQ, this.nZR, random);
        bVar.oaD = a(this.nZS, this.nZT, random);
        bVar.nZU = a(this.nZU, this.nZV, random);
        bVar.nZW = a(this.nZW, this.nZX, random);
        if (this.nZY == null) {
            f = null;
        } else {
            f = Float.valueOf(a(this.nZY.floatValue(), this.nZZ.floatValue(), random));
        }
        bVar.nZY = f;
        if (this.oaa == null) {
            f = null;
        } else {
            f = Float.valueOf(a(this.oaa.floatValue(), this.oab.floatValue(), random));
        }
        bVar.oaa = f;
        bVar.oaG = a((float) this.oac, (float) this.oad, random);
        bVar.oaH = a(this.oae, this.oaf, random);
        bVar.oag = a(this.oag, this.oah, random);
        if (this.oai != null) {
            f2 = Float.valueOf(a(this.oai.floatValue(), this.oaj.floatValue(), random));
        }
        bVar.oai = f2;
        bVar.oak = this.oak;
        bVar.nZO = this.nZO;
        bVar.oaJ = a(this.oal, this.oam, random);
        bVar.i(this.nZP);
        AppMethodBeat.o(42448);
    }

    private static float a(float f, float f2, Random random) {
        AppMethodBeat.i(42449);
        float nextFloat = (((random.nextFloat() * 2.0f) - 1.0f) * f2) + f;
        AppMethodBeat.o(42449);
        return nextFloat;
    }

    static /* synthetic */ void a(c cVar, long j) {
        AppMethodBeat.i(42450);
        if (j < cVar.nZM) {
            if (cVar.nZK == 0) {
                cVar.nZK = j;
                AppMethodBeat.o(42450);
                return;
            }
            int nextFloat = (int) (((float) (j - cVar.nZK)) * (cVar.random.nextFloat() * cVar.emissionRate));
            if (nextFloat > 0) {
                cVar.nZK = (long) (((float) cVar.nZK) + (cVar.nZN * ((float) nextFloat)));
                cVar.Q(nextFloat, j);
            }
        }
        AppMethodBeat.o(42450);
    }
}
