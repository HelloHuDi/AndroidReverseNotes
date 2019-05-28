package com.tencent.p177mm.plugin.mmsight.p458ui.progressbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.mmsight.p458ui.progressbar.C21321b.C213201;
import com.tencent.p177mm.plugin.mmsight.p458ui.progressbar.C21321b.C21322a;
import com.tencent.p177mm.plugin.mmsight.p458ui.progressbar.C21321b.C35102;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar */
public class MMSightProgressBar extends View {
    public static final int lEk = C1338a.fromDPToPix(C4996ah.getContext(), 3);
    public static final int oDH = C1338a.fromDPToPix(C4996ah.getContext(), 5);
    private static final int[] oDI = new int[]{-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private Paint aFY;
    private boolean cFy = false;
    private int centerX = 0;
    private int centerY = 0;
    private C7306ak handler = null;
    private List<C28527a> oDJ = new ArrayList(5);
    private int oDK = 0;
    private C21321b oDL;
    private boolean oDM = false;
    private C39414a oDN;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar$a */
    public interface C39414a {
    }

    static {
        AppMethodBeat.m2504i(55340);
        AppMethodBeat.m2505o(55340);
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(55336);
        init();
        AppMethodBeat.m2505o(55336);
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(55337);
        init();
        AppMethodBeat.m2505o(55337);
    }

    private void init() {
        AppMethodBeat.m2504i(55338);
        this.aFY = new Paint();
        this.aFY.setColor(-65536);
        this.aFY.setAntiAlias(true);
        this.handler = new C7306ak(Looper.getMainLooper()) {

            /* renamed from: com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar$1$1 */
            class C394131 implements C21322a {
                C394131() {
                }

                /* renamed from: a */
                public final void mo36742a(C28527a c28527a) {
                    AppMethodBeat.m2504i(55333);
                    MMSightProgressBar.this.oDJ.add(c28527a);
                    MMSightProgressBar.this.oDL = null;
                    if (MMSightProgressBar.this.oDJ.size() >= 5) {
                        Log.m9448i("MicroMsg.MMSightProgressBar", "progress finish!");
                        if (MMSightProgressBar.this.oDN != null) {
                            MMSightProgressBar.this.oDN;
                        }
                    } else if (MMSightProgressBar.this.cFy) {
                        MMSightProgressBar.this.handler.sendEmptyMessage(C31128d.MIC_PTU_MEISHI);
                    }
                    MMSightProgressBar.this.invalidate();
                    AppMethodBeat.m2505o(55333);
                }

                public final void bQN() {
                    AppMethodBeat.m2504i(55334);
                    MMSightProgressBar.this.invalidate();
                    AppMethodBeat.m2505o(55334);
                }
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(55335);
                if (message.what == C31128d.MIC_PTU_MEISHI && MMSightProgressBar.this.cFy && MMSightProgressBar.this.oDJ.size() > 0 && MMSightProgressBar.this.oDJ.size() < 5) {
                    MMSightProgressBar.this.oDL = new C21321b((C28527a) MMSightProgressBar.this.oDJ.get(MMSightProgressBar.this.oDJ.size() - 1), new C28527a(MMSightProgressBar.this.oDJ.size(), MMSightProgressBar.this.centerX, MMSightProgressBar.this.centerY, MMSightProgressBar.oDI[MMSightProgressBar.this.oDJ.size()]), new C394131());
                    C21321b g = MMSightProgressBar.this.oDL;
                    g.jcQ = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
                    g.jcQ.addUpdateListener(new C213201());
                    g.jcQ.addListener(new C35102());
                    g.jcQ.setInterpolator(new AccelerateDecelerateInterpolator());
                    g.jcQ.setDuration(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    g.jcQ.start();
                }
                AppMethodBeat.m2505o(55335);
            }
        };
        Log.m9449i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", Integer.valueOf(lEk), Integer.valueOf(oDH));
        AppMethodBeat.m2505o(55338);
    }

    public void setProgressCallback(C39414a c39414a) {
        this.oDN = c39414a;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int right;
        float f;
        C28527a c28527a;
        AppMethodBeat.m2504i(55339);
        super.onDraw(canvas);
        if (this.cFy && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.m9449i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY));
            Log.m9448i("MicroMsg.MMSightProgressBar", "add init point");
            this.oDJ.add(new C28527a(0, this.centerX, this.centerY, -1));
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
            Log.m9443d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", Float.valueOf(f2), Float.valueOf(this.oDL.progress));
            f -= (Math.abs(f2) - Math.abs(f)) * (this.oDL.progress / 100.0f);
        }
        Log.m9443d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", Float.valueOf(f), Integer.valueOf(this.oDK));
        canvas.translate(f, 0.0f);
        if (this.oDL != null && this.oDL.oDW) {
            C21321b c21321b = this.oDL;
            Paint paint = this.aFY;
            C4990ab.m7411d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", Float.valueOf(c21321b.progress), Float.valueOf(((float) (oDH + (lEk * 2))) * (c21321b.progress / 100.0f)));
            if (c21321b.oEe > c21321b.oEg) {
                float f3 = c21321b.oDU.oDQ - ((float) lEk);
                f = c21321b.oDU.oDR - ((float) lEk);
                paint.setColor(c21321b.oDV.color);
                c21321b.oEi.reset();
                c21321b.oEi.moveTo(c21321b.oDY.x + f3, c21321b.oDY.y + f);
                c21321b.oEi.quadTo(c21321b.oDZ.x + f3, c21321b.oDZ.y + f, c21321b.oEa.x + f3, c21321b.oEa.y + f);
                c21321b.oEi.lineTo(c21321b.oEd.x + f3, c21321b.oEd.y + f);
                c21321b.oEi.quadTo(c21321b.oEc.x + f3, c21321b.oEc.y + f, c21321b.oEb.x + f3, f + c21321b.oEb.y);
                if (c21321b.oDV.color != c21321b.oDU.color) {
                    paint.setShader(new LinearGradient(c21321b.oDY.x + f3, c21321b.oDU.oDR - ((float) lEk), f3 + c21321b.oEa.x, c21321b.oDU.oDR - ((float) lEk), new int[]{c21321b.oDU.color, c21321b.oDV.color}, null, TileMode.REPEAT));
                }
                canvas.drawPath(c21321b.oEi, paint);
                paint.setShader(null);
            }
            c28527a = c21321b.oDV;
            paint.setColor(c28527a.color);
            c28527a.oDR = (float) c28527a.oDT;
            c28527a.oDQ = ((float) (c28527a.oDS + ((c28527a.index - 1) * (oDH + (lEk * 2))))) + r11;
            Log.m9443d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", Integer.valueOf(c28527a.index), Float.valueOf(r11), Float.valueOf(c28527a.oDQ));
            canvas.drawCircle(c28527a.oDQ, c28527a.oDR, (float) lEk, paint);
            paint.setShader(null);
        }
        for (C28527a c28527a2 : this.oDJ) {
            Paint paint2 = this.aFY;
            paint2.setColor(c28527a2.color);
            c28527a2.oDQ = (float) (c28527a2.oDS + (c28527a2.index * (oDH + (lEk * 2))));
            c28527a2.oDR = (float) c28527a2.oDT;
            Log.m9443d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", Integer.valueOf(c28527a2.index), Float.valueOf(c28527a2.oDQ));
            canvas.drawCircle(c28527a2.oDQ, c28527a2.oDR, (float) lEk, paint2);
            paint2.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.cFy && !this.oDM && this.oDJ.size() > 0) {
            Log.m9448i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.oDM = true;
            this.handler.sendEmptyMessage(C31128d.MIC_PTU_MEISHI);
        }
        AppMethodBeat.m2505o(55339);
    }
}
