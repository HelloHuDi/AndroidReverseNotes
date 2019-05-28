package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.d;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.List;

public class MMSightProgressBar extends View {
    public static final int lEk = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 3);
    public static final int oDH = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 5);
    private static final int[] oDI = new int[]{-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private Paint aFY;
    private boolean cFy = false;
    private int centerX = 0;
    private int centerY = 0;
    private ak handler = null;
    private List<a> oDJ = new ArrayList(5);
    private int oDK = 0;
    private b oDL;
    private boolean oDM = false;
    private a oDN;

    public interface a {
    }

    static {
        AppMethodBeat.i(55340);
        AppMethodBeat.o(55340);
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55336);
        init();
        AppMethodBeat.o(55336);
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(55337);
        init();
        AppMethodBeat.o(55337);
    }

    private void init() {
        AppMethodBeat.i(55338);
        this.aFY = new Paint();
        this.aFY.setColor(-65536);
        this.aFY.setAntiAlias(true);
        this.handler = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(55335);
                if (message.what == d.MIC_PTU_MEISHI && MMSightProgressBar.this.cFy && MMSightProgressBar.this.oDJ.size() > 0 && MMSightProgressBar.this.oDJ.size() < 5) {
                    MMSightProgressBar.this.oDL = new b((a) MMSightProgressBar.this.oDJ.get(MMSightProgressBar.this.oDJ.size() - 1), new a(MMSightProgressBar.this.oDJ.size(), MMSightProgressBar.this.centerX, MMSightProgressBar.this.centerY, MMSightProgressBar.oDI[MMSightProgressBar.this.oDJ.size()]), new com.tencent.mm.plugin.mmsight.ui.progressbar.b.a() {
                        public final void a(a aVar) {
                            AppMethodBeat.i(55333);
                            MMSightProgressBar.this.oDJ.add(aVar);
                            MMSightProgressBar.this.oDL = null;
                            if (MMSightProgressBar.this.oDJ.size() >= 5) {
                                Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
                                if (MMSightProgressBar.this.oDN != null) {
                                    MMSightProgressBar.this.oDN;
                                }
                            } else if (MMSightProgressBar.this.cFy) {
                                MMSightProgressBar.this.handler.sendEmptyMessage(d.MIC_PTU_MEISHI);
                            }
                            MMSightProgressBar.this.invalidate();
                            AppMethodBeat.o(55333);
                        }

                        public final void bQN() {
                            AppMethodBeat.i(55334);
                            MMSightProgressBar.this.invalidate();
                            AppMethodBeat.o(55334);
                        }
                    });
                    b g = MMSightProgressBar.this.oDL;
                    g.jcQ = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
                    g.jcQ.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(55341);
                            b.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            b bVar = b.this;
                            float f = b.this.progress;
                            bVar.oEh = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.oDH + (MMSightProgressBar.lEk * 2)))) * (f / 100.0f)));
                            bVar.oEe = bVar.oEf - ((f / 100.0f) * (bVar.oEf - bVar.oEg));
                            bVar.oDY = new PointF((float) MMSightProgressBar.lEk, 0.0f);
                            bVar.oDZ = new PointF(((float) MMSightProgressBar.lEk) + (bVar.oEh / 2.0f), ((float) MMSightProgressBar.lEk) - (bVar.oEe / 2.0f));
                            bVar.oEa = new PointF(((float) MMSightProgressBar.lEk) + bVar.oEh, 0.0f);
                            bVar.oEb = new PointF((float) MMSightProgressBar.lEk, (float) (MMSightProgressBar.lEk * 2));
                            bVar.oEc = new PointF(((float) MMSightProgressBar.lEk) + (bVar.oEh / 2.0f), ((float) MMSightProgressBar.lEk) + (bVar.oEe / 2.0f));
                            bVar.oEd = new PointF(((float) MMSightProgressBar.lEk) + bVar.oEh, ((float) MMSightProgressBar.lEk) * 2.0f);
                            ab.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", Float.valueOf(bVar.oEh), Float.valueOf(bVar.oEe));
                            ab.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", bVar.oDY, bVar.oDZ, bVar.oEa, bVar.oEb, bVar.oEc, bVar.oEd);
                            if (b.this.oDX != null) {
                                b.this.oDX.bQN();
                            }
                            AppMethodBeat.o(55341);
                        }
                    });
                    g.jcQ.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationStart(Animator animator) {
                            b.this.oDW = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(55342);
                            b.this.oDW = true;
                            if (b.this.oDX != null) {
                                b.this.oDX.a(b.this.oDV);
                            }
                            AppMethodBeat.o(55342);
                        }
                    });
                    g.jcQ.setInterpolator(new AccelerateDecelerateInterpolator());
                    g.jcQ.setDuration(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    g.jcQ.start();
                }
                AppMethodBeat.o(55335);
            }
        };
        Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", Integer.valueOf(lEk), Integer.valueOf(oDH));
        AppMethodBeat.o(55338);
    }

    public void setProgressCallback(a aVar) {
        this.oDN = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int right;
        float f;
        a aVar;
        AppMethodBeat.i(55339);
        super.onDraw(canvas);
        if (this.cFy && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY));
            Log.i("MicroMsg.MMSightProgressBar", "add init point");
            this.oDJ.add(new a(0, this.centerX, this.centerY, -1));
        }
        int save = canvas.save();
        this.oDK = this.oDJ.size();
        if (this.oDK % 2 == 0) {
            f = -(((((float) oDH) / 2.0f) + ((float) (((this.oDK / 2) - 1) * oDH))) + ((float) ((this.oDK / 2) * lEk)));
        } else {
            f = -(((((float) lEk) / 2.0f) + ((float) ((this.oDK / 2) * oDH))) + ((float) ((this.oDK / 2) * lEk)));
        }
        if (this.oDL != null && this.oDL.oDW) {
            float f2;
            right = this.oDK + 1;
            if (right % 2 == 0) {
                f2 = -(((float) ((right / 2) * lEk)) + ((((float) oDH) / 2.0f) + ((float) (((right / 2) - 1) * oDH))));
            } else {
                f2 = -(((float) ((right / 2) * lEk)) + ((((float) lEk) / 2.0f) + ((float) ((right / 2) * oDH))));
            }
            Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", Float.valueOf(f2), Float.valueOf(this.oDL.progress));
            f -= (Math.abs(f2) - Math.abs(f)) * (this.oDL.progress / 100.0f);
        }
        Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", Float.valueOf(f), Integer.valueOf(this.oDK));
        canvas.translate(f, 0.0f);
        if (this.oDL != null && this.oDL.oDW) {
            b bVar = this.oDL;
            Paint paint = this.aFY;
            ab.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", Float.valueOf(bVar.progress), Float.valueOf(((float) (oDH + (lEk * 2))) * (bVar.progress / 100.0f)));
            if (bVar.oEe > bVar.oEg) {
                float f3 = bVar.oDU.oDQ - ((float) lEk);
                f = bVar.oDU.oDR - ((float) lEk);
                paint.setColor(bVar.oDV.color);
                bVar.oEi.reset();
                bVar.oEi.moveTo(bVar.oDY.x + f3, bVar.oDY.y + f);
                bVar.oEi.quadTo(bVar.oDZ.x + f3, bVar.oDZ.y + f, bVar.oEa.x + f3, bVar.oEa.y + f);
                bVar.oEi.lineTo(bVar.oEd.x + f3, bVar.oEd.y + f);
                bVar.oEi.quadTo(bVar.oEc.x + f3, bVar.oEc.y + f, bVar.oEb.x + f3, f + bVar.oEb.y);
                if (bVar.oDV.color != bVar.oDU.color) {
                    paint.setShader(new LinearGradient(bVar.oDY.x + f3, bVar.oDU.oDR - ((float) lEk), f3 + bVar.oEa.x, bVar.oDU.oDR - ((float) lEk), new int[]{bVar.oDU.color, bVar.oDV.color}, null, TileMode.REPEAT));
                }
                canvas.drawPath(bVar.oEi, paint);
                paint.setShader(null);
            }
            aVar = bVar.oDV;
            paint.setColor(aVar.color);
            aVar.oDR = (float) aVar.oDT;
            aVar.oDQ = ((float) (aVar.oDS + ((aVar.index - 1) * (oDH + (lEk * 2))))) + r11;
            Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", Integer.valueOf(aVar.index), Float.valueOf(r11), Float.valueOf(aVar.oDQ));
            canvas.drawCircle(aVar.oDQ, aVar.oDR, (float) lEk, paint);
            paint.setShader(null);
        }
        for (a aVar2 : this.oDJ) {
            Paint paint2 = this.aFY;
            paint2.setColor(aVar2.color);
            aVar2.oDQ = (float) (aVar2.oDS + (aVar2.index * (oDH + (lEk * 2))));
            aVar2.oDR = (float) aVar2.oDT;
            Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", Integer.valueOf(aVar2.index), Float.valueOf(aVar2.oDQ));
            canvas.drawCircle(aVar2.oDQ, aVar2.oDR, (float) lEk, paint2);
            paint2.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.cFy && !this.oDM && this.oDJ.size() > 0) {
            Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.oDM = true;
            this.handler.sendEmptyMessage(d.MIC_PTU_MEISHI);
        }
        AppMethodBeat.o(55339);
    }
}
