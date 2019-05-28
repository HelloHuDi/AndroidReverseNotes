package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C46631f;
import com.tencent.p177mm.p612ui.p627e.p1346b.C24002c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.ui.tools.CropImageView */
public class CropImageView extends ImageView {
    int cDW = 0;
    private OnTouchListener mNa = new C307393();
    Bitmap mQQ;
    private long nOa;
    private float neG;
    private float neH;
    private Timer oGr = new Timer(true);
    float riF = 0.0f;
    float riG = 0.0f;
    private boolean rst = false;
    private float translateX = 0.0f;
    private float translateY = 0.0f;
    private boolean yzp = false;
    private Drawable yzq;
    private C5564b zBA = null;
    C7306ak zBB = new C307372();
    private C30738a zBC;
    private boolean zBD = true;
    private boolean zBi = true;
    private boolean zBj = false;
    private float zBk;
    private float zBl;
    private PointF zBm = new PointF();
    boolean zBn = false;
    private boolean zBo = false;
    private boolean zBp = false;
    private boolean zBq = false;
    private boolean zBr = false;
    private boolean zBs = false;
    private boolean zBt = false;
    private boolean zBu = false;
    private float zBv = 1.0f;
    private C5565c zBw = null;
    private boolean zBx = false;
    Timer zBy;
    C7306ak zBz = new C159211();

    /* renamed from: com.tencent.mm.ui.tools.CropImageView$b */
    class C5564b extends TimerTask {
        final /* synthetic */ CropImageView zBE;

        public final void run() {
            AppMethodBeat.m2504i(107604);
            Message message = new Message();
            if (this.zBE.zBt || this.zBE.zBu || this.zBE.zBs || this.zBE.zBr) {
                message.what = 4654;
            } else {
                message.what = 4653;
            }
            this.zBE.zBB.sendMessage(message);
            AppMethodBeat.m2505o(107604);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageView$c */
    class C5565c extends TimerTask {
        final /* synthetic */ CropImageView zBE;

        public final void run() {
            AppMethodBeat.m2504i(107605);
            C4990ab.m7410d("MicroMsg.CropImageView", "in timer task run");
            Message message = new Message();
            if (this.zBE.zBq) {
                message.what = 4659;
            } else if (this.zBE.zBp) {
                message.what = 4658;
            } else {
                message.what = 4660;
            }
            this.zBE.zBz.sendMessage(message);
            AppMethodBeat.m2505o(107605);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageView$1 */
    class C159211 extends C7306ak {
        C159211() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(107600);
            C4990ab.m7410d("MicroMsg.CropImageView", "on handler");
            if (message.what == 4659) {
                CropImageView.this.zoomIn();
            } else if (message.what == 4658) {
                CropImageView.this.zoomOut();
            } else if (message.what == 4660) {
                if (!(CropImageView.this.oGr == null || CropImageView.this.zBw == null)) {
                    CropImageView.this.zBw.cancel();
                    CropImageView.this.zBw = null;
                }
            } else if (message.what == 4661) {
                boolean z;
                MotionEvent motionEvent = (MotionEvent) message.obj;
                CropImageView.this.nOa = System.currentTimeMillis();
                CropImageView.this.zBo = false;
                if (motionEvent.getRawX() - CropImageView.this.zBk > 10.0f || motionEvent.getRawY() - CropImageView.this.zBl > 10.0f || motionEvent.getRawX() - CropImageView.this.zBk < -10.0f || motionEvent.getRawY() - CropImageView.this.zBl < -10.0f) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (CropImageView.this.nOa != 0 && currentTimeMillis - CropImageView.this.nOa < 300 && currentTimeMillis - CropImageView.this.nOa >= 0 && CropImageView.this.zBC != null) {
                        CropImageView.this.zBC.dJI();
                    }
                    CropImageView.this.nOa = 0;
                }
                C46631f.m88233a(CropImageView.this.zBm, CropImageView.this.mQQ);
            }
            super.handleMessage(message);
            AppMethodBeat.m2505o(107600);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageView$2 */
    class C307372 extends C7306ak {
        C307372() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(107601);
            if (message.what != 4653) {
                CropImageView.m49006o(CropImageView.this);
            } else if (!(CropImageView.this.oGr == null || CropImageView.this.zBA == null)) {
                CropImageView.this.zBA.cancel();
                CropImageView.this.zBA = null;
            }
            super.handleMessage(message);
            AppMethodBeat.m2505o(107601);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageView$a */
    public interface C30738a {
        void dJI();
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageView$3 */
    class C307393 implements OnTouchListener {
        C307393() {
        }

        public final boolean onTouch(View view, final MotionEvent motionEvent) {
            AppMethodBeat.m2504i(107603);
            if (!CropImageView.this.zBD) {
                AppMethodBeat.m2505o(107603);
                return false;
            } else if (CropImageView.this.mQQ == null) {
                AppMethodBeat.m2505o(107603);
                return false;
            } else {
                int action = motionEvent.getAction() & 255;
                C4990ab.m7410d("MicroMsg.CropImageView", "on touch : event type=" + action + ", isDownOnImg=" + CropImageView.this.zBo);
                if (CropImageView.this.zBo || action == 0) {
                    switch (action) {
                        case 0:
                            C4990ab.m7410d("MicroMsg.CropImageView", "action_down");
                            CropImageView.this.neG = motionEvent.getRawX();
                            CropImageView.this.neH = motionEvent.getRawY();
                            C4990ab.m7410d("MicroMsg.CropImageView", "lastX=" + CropImageView.this.neG + ",lastY=" + CropImageView.this.neH);
                            CropImageView.this.zBk = CropImageView.this.neG;
                            CropImageView.this.zBl = CropImageView.this.neH;
                            Matrix imageMatrix = CropImageView.this.getImageMatrix();
                            RectF rectF = new RectF();
                            rectF.set(0.0f, 0.0f, (float) CropImageView.this.mQQ.getWidth(), (float) CropImageView.this.mQQ.getHeight());
                            imageMatrix.mapRect(rectF);
                            CropImageView.this.zBo = rectF.contains(CropImageView.this.neG, CropImageView.this.neH);
                            CropImageView.this.nOa = System.currentTimeMillis();
                            break;
                        case 1:
                            C4990ab.m7410d("MicroMsg.CropImageView", "action_up");
                            if (!CropImageView.this.rst) {
                                CropImageView.this.rst = true;
                                if (CropImageView.this.zBy != null) {
                                    CropImageView.this.zBy.cancel();
                                }
                                CropImageView.this.zBy = new Timer();
                                CropImageView.this.zBy.schedule(new TimerTask() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(107602);
                                        if (CropImageView.this.rst) {
                                            Message message = new Message();
                                            message.what = 4661;
                                            message.obj = motionEvent;
                                            CropImageView.this.zBz.sendMessage(message);
                                            CropImageView.this.rst = false;
                                        }
                                        AppMethodBeat.m2505o(107602);
                                    }
                                }, 200);
                                break;
                            }
                            CropImageView.this.rst = false;
                            if (!CropImageView.this.zBx) {
                                CropImageView.this.zBx = true;
                                CropImageView.this.zoomIn();
                                CropImageView.this.zoomIn();
                                CropImageView.this.zoomIn();
                                CropImageView.this.zoomIn();
                                CropImageView.this.zoomIn();
                                break;
                            }
                            CropImageView.this.zBx = false;
                            CropImageView.this.zoomOut();
                            CropImageView.this.zoomOut();
                            CropImageView.this.zoomOut();
                            CropImageView.this.zoomOut();
                            CropImageView.this.zoomOut();
                            break;
                        case 2:
                            float f;
                            C4990ab.m7410d("MicroMsg.CropImageView", "action_move");
                            if (CropImageView.this.zBn) {
                                C4990ab.m7410d("MicroMsg.CropImageView", "is valid mult down");
                                CropImageView.this.riG = C46631f.m88231N(motionEvent);
                                f = CropImageView.this.riG - CropImageView.this.riF;
                                if (CropImageView.this.riG > 5.0f && Math.abs(f) > 5.0f) {
                                    C46631f.m88234a(CropImageView.this.zBm, motionEvent);
                                    C4990ab.m7410d("MicroMsg.CropImageView", "mX=" + CropImageView.this.zBm.x + ",mY=" + CropImageView.this.zBm.y);
                                    if (f > 0.0f) {
                                        C4990ab.m7410d("MicroMsg.CropImageView", "zoom in");
                                        CropImageView.this.zoomIn();
                                    } else {
                                        C4990ab.m7410d("MicroMsg.CropImageView", "zoom out");
                                        CropImageView.this.zoomOut();
                                    }
                                }
                                CropImageView.this.riF = CropImageView.this.riG;
                            }
                            if (!CropImageView.this.zBj) {
                                f = motionEvent.getRawX() - CropImageView.this.neG;
                                float rawY = motionEvent.getRawY() - CropImageView.this.neH;
                                if (Math.abs(f) > 5.0f || Math.abs(rawY) > 5.0f) {
                                    CropImageView.this.getImageMatrix().postTranslate(f, rawY);
                                }
                                CropImageView.this.invalidate();
                            }
                            CropImageView.this.zBj = false;
                            CropImageView.this.neG = motionEvent.getRawX();
                            CropImageView.this.neH = motionEvent.getRawY();
                            break;
                        case 5:
                            C4990ab.m7410d("MicroMsg.CropImageView", "action_mult_down");
                            CropImageView.this.zBj = true;
                            CropImageView.this.riF = C46631f.m88231N(motionEvent);
                            if (CropImageView.this.riF > 5.0f) {
                                CropImageView.this.zBn = true;
                                C46631f.m88234a(CropImageView.this.zBm, motionEvent);
                                AppMethodBeat.m2505o(107603);
                                return true;
                            }
                            break;
                        case 6:
                            C4990ab.m7410d("MicroMsg.CropImageView", "action_mult_up");
                            CropImageView.this.zBn = false;
                            CropImageView.this.zBj = true;
                            AppMethodBeat.m2505o(107603);
                            return true;
                    }
                    AppMethodBeat.m2505o(107603);
                    return false;
                }
                AppMethodBeat.m2505o(107603);
                return false;
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107606);
        dJJ();
        AppMethodBeat.m2505o(107606);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(107607);
        this.yzp = false;
        this.mQQ = bitmap;
        C46631f.m88233a(this.zBm, bitmap);
        super.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(107607);
    }

    public void setLimitZoomIn(boolean z) {
        this.zBi = z;
    }

    public void setEnableOprate(boolean z) {
        this.zBD = z;
    }

    public Bitmap getBmp() {
        return this.mQQ;
    }

    public void setOnShortClick(C30738a c30738a) {
        this.zBC = c30738a;
    }

    public final void dJJ() {
        AppMethodBeat.m2504i(107608);
        setOnTouchListener(this.mNa);
        AppMethodBeat.m2505o(107608);
    }

    public final void zoomIn() {
        AppMethodBeat.m2504i(107609);
        this.zBv *= 1.0666f;
        if (1.0f <= this.zBv) {
            this.zBq = false;
        }
        if (1.6f < this.zBv) {
            this.zBp = true;
        } else {
            this.zBp = false;
        }
        if (!this.zBi || 4.0f >= this.zBv) {
            ctq();
            AppMethodBeat.m2505o(107609);
            return;
        }
        this.zBv = 4.0f;
        AppMethodBeat.m2505o(107609);
    }

    private void ctq() {
        AppMethodBeat.m2504i(107610);
        float[] fArr = new float[2];
        r1 = new float[2];
        float f = this.zBm.x;
        r1[0] = f;
        fArr[0] = f;
        f = this.zBm.y;
        r1[1] = f;
        fArr[1] = f;
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postScale(1.0666f, 1.0666f);
        getImageMatrix().mapPoints(r1);
        getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
        setImageBitmap(this.mQQ);
        invalidate();
        AppMethodBeat.m2505o(107610);
    }

    public final void zoomOut() {
        AppMethodBeat.m2504i(107611);
        this.zBv *= 0.9375f;
        if (1.6f > this.zBv) {
            this.zBp = false;
        }
        if (1.0f > this.zBv) {
            this.zBq = true;
        } else {
            this.zBq = false;
        }
        if (0.4f > this.zBv) {
            this.zBv = 0.4f;
            AppMethodBeat.m2505o(107611);
            return;
        }
        ctr();
        AppMethodBeat.m2505o(107611);
    }

    private void ctr() {
        AppMethodBeat.m2504i(107612);
        float[] fArr = new float[2];
        r1 = new float[2];
        float f = this.zBm.x;
        r1[0] = f;
        fArr[0] = f;
        f = this.zBm.y;
        r1[1] = f;
        fArr[1] = f;
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postScale(0.9375f, 0.9375f);
        getImageMatrix().mapPoints(r1);
        getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
        setImageBitmap(this.mQQ);
        invalidate();
        AppMethodBeat.m2505o(107612);
    }

    public int getRotateCount() {
        return this.cDW;
    }

    public void setGifPath(String str) {
        AppMethodBeat.m2504i(107613);
        try {
            this.yzp = true;
            this.yzq = C24002c.m36988io(str, str);
            setImageDrawable(this.yzq);
            AppMethodBeat.m2505o(107613);
        } catch (Exception e) {
            this.yzp = false;
            AppMethodBeat.m2505o(107613);
        }
    }

    public int getGifWidth() {
        AppMethodBeat.m2504i(107614);
        int width;
        if (!this.yzp || this.yzq == null) {
            width = getWidth();
            AppMethodBeat.m2505o(107614);
            return width;
        }
        width = this.yzq.getIntrinsicWidth();
        AppMethodBeat.m2505o(107614);
        return width;
    }

    public int getGifHeight() {
        AppMethodBeat.m2504i(107615);
        int height;
        if (!this.yzp || this.yzq == null) {
            height = getHeight();
            AppMethodBeat.m2505o(107615);
            return height;
        }
        height = this.yzq.getIntrinsicHeight();
        AppMethodBeat.m2505o(107615);
        return height;
    }

    /* renamed from: o */
    static /* synthetic */ void m49006o(CropImageView cropImageView) {
        AppMethodBeat.m2504i(107616);
        if (cropImageView.zBr) {
            cropImageView.translateX -= -20.0f;
            if (cropImageView.translateX > 0.0f) {
                cropImageView.zBr = false;
            }
            cropImageView.getImageMatrix().postTranslate(-20.0f, 0.0f);
        }
        if (cropImageView.zBs) {
            cropImageView.translateX -= 20.0f;
            if (cropImageView.translateX < 0.0f) {
                cropImageView.zBs = false;
            }
            cropImageView.getImageMatrix().postTranslate(20.0f, 0.0f);
        }
        if (cropImageView.zBt) {
            cropImageView.translateY -= 20.0f;
            if (cropImageView.translateY < 0.0f) {
                cropImageView.zBt = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, 20.0f);
        }
        if (cropImageView.zBu) {
            cropImageView.translateY -= -20.0f;
            if (cropImageView.translateY > 0.0f) {
                cropImageView.zBu = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, -20.0f);
        }
        cropImageView.setImageBitmap(cropImageView.mQQ);
        cropImageView.invalidate();
        AppMethodBeat.m2505o(107616);
    }
}
