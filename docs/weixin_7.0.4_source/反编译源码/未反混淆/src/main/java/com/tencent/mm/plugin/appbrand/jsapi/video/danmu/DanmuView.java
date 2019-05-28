package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView extends View {
    private int iaW;
    private int iaX;
    private int iaY;
    private float iaZ;
    private float iba;
    private boolean ibb;
    private boolean ibc;
    private c ibd;
    private HashMap<Integer, ArrayList<d>> ibe;
    public final Deque<d> ibf;
    public List<d> ibg;
    private int[] ibh;
    private volatile boolean ibi;
    private LinkedList<Long> ibj;
    private Paint ibk;
    private long ibl;
    private LinkedList<Float> ibm;
    private final Context mContext;
    private volatile int status;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ int ibq;

        public AnonymousClass5(int i) {
            this.ibq = i;
        }

        public final void run() {
            AppMethodBeat.i(126603);
            synchronized (DanmuView.this.ibf) {
                try {
                    for (int size = DanmuView.this.ibg.size() - 1; size >= 0; size--) {
                        d dVar = (d) DanmuView.this.ibg.get(size);
                        if (dVar.aGc() < this.ibq) {
                            break;
                        }
                        ab.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", Integer.valueOf(size), Integer.valueOf(dVar.aGc()));
                        DanmuView.this.ibf.addFirst(dVar);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(126603);
                }
            }
            DanmuView.c(DanmuView.this);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ d ibo;

        public AnonymousClass3(d dVar) {
            this.ibo = dVar;
        }

        public final void run() {
            AppMethodBeat.i(126601);
            synchronized (DanmuView.this.ibg) {
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= DanmuView.this.ibg.size()) {
                            break;
                        } else if (this.ibo.aGc() <= ((d) DanmuView.this.ibg.get(i2)).aGc()) {
                            DanmuView.this.ibg.add(i2, this.ibo);
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(126601);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$4 */
    public class AnonymousClass4 extends Thread {
        final /* synthetic */ List ibp;

        public AnonymousClass4(List list) {
            this.ibp = list;
        }

        public final void run() {
            AppMethodBeat.i(126602);
            synchronized (DanmuView.this.ibf) {
                try {
                    DanmuView.this.ibf.addAll(this.ibp);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(126602);
                }
            }
            synchronized (DanmuView.this.ibg) {
                try {
                    DanmuView.this.ibg.addAll(this.ibp);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(126602);
                    }
                }
            }
            DanmuView.this.postInvalidate();
        }
    }

    static /* synthetic */ void c(DanmuView danmuView) {
        AppMethodBeat.i(126627);
        danmuView.aGi();
        AppMethodBeat.o(126627);
    }

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(126604);
        this.iaW = 5;
        this.iaX = 500;
        this.iaY = 10;
        this.iaZ = 0.0f;
        this.iba = 0.6f;
        this.ibb = false;
        this.ibc = false;
        this.ibf = new LinkedList();
        this.ibg = new LinkedList();
        this.status = 3;
        this.ibl = 0;
        this.mContext = context;
        AppMethodBeat.o(126604);
    }

    private static void L(float f, float f2) {
        AppMethodBeat.i(126605);
        IllegalArgumentException illegalArgumentException;
        if (f >= f2) {
            illegalArgumentException = new IllegalArgumentException("start_Y_offset must < end_Y_offset");
            AppMethodBeat.o(126605);
            throw illegalArgumentException;
        } else if (f < 0.0f || f >= 1.0f || f2 < 0.0f || f2 > 1.0f) {
            illegalArgumentException = new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
            AppMethodBeat.o(126605);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.o(126605);
        }
    }

    public final void prepare() {
        AppMethodBeat.i(126606);
        L(this.iaZ, this.iba);
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        aGe();
        AppMethodBeat.o(126606);
    }

    private void aGe() {
        AppMethodBeat.i(126607);
        aGf();
        aGg();
        AppMethodBeat.o(126607);
    }

    private void aGf() {
        AppMethodBeat.i(126608);
        this.ibe = new HashMap(this.iaW);
        for (int i = 0; i < this.iaW; i++) {
            this.ibe.put(Integer.valueOf(i), new ArrayList(this.iaY));
        }
        AppMethodBeat.o(126608);
    }

    private void aGg() {
        int i = 0;
        AppMethodBeat.i(126609);
        this.ibh = new int[this.iaW];
        float cO = b.cO(this.mContext);
        float height = this.iaZ * ((float) getHeight());
        for (int i2 = 0; i2 < this.iaW; i2++) {
            this.ibh[i2] = (int) (((((float) (i2 + 1)) * cO) + height) - ((3.0f * cO) / 4.0f));
        }
        if (this.ibc) {
            this.ibm.clear();
            this.ibm.add(Float.valueOf(height));
            while (i < this.iaW) {
                this.ibm.add(Float.valueOf((((float) (i + 1)) * cO) + height));
                i++;
            }
        }
        AppMethodBeat.o(126609);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(126610);
        super.onDraw(canvas);
        int i;
        Iterator it;
        Iterator it2;
        float floatValue;
        if (this.ibi) {
            ab.i("MicroMsg.DanmuView", "inTransition");
            AppMethodBeat.o(126610);
        } else if (this.status == 1) {
            try {
                d dVar;
                canvas.drawColor(0);
                for (i = 0; i < this.ibe.size(); i++) {
                    it = ((ArrayList) this.ibe.get(Integer.valueOf(i))).iterator();
                    while (it.hasNext()) {
                        dVar = (d) it.next();
                        if (dVar.aGb()) {
                            it.remove();
                        } else {
                            dVar.b(canvas, false);
                        }
                    }
                }
                if (System.currentTimeMillis() - this.ibl > ((long) this.iaX)) {
                    this.ibl = System.currentTimeMillis();
                    synchronized (this.ibf) {
                        if (this.ibf.size() > 0) {
                            dVar = (d) this.ibf.getFirst();
                            int afA = this.ibd.afA();
                            d dVar2 = dVar;
                            while (dVar2 != null && dVar2.oC(afA)) {
                                this.ibf.pollFirst();
                                dVar2 = (d) this.ibf.getFirst();
                            }
                            if (dVar2 != null && dVar2.oB(afA)) {
                                int b = b(dVar2);
                                if (b >= 0) {
                                    dVar2.dg(canvas.getWidth() - 2, this.ibh[b]);
                                    dVar2.b(canvas, false);
                                    ((ArrayList) this.ibe.get(Integer.valueOf(b))).add(dVar2);
                                    this.ibf.pollFirst();
                                }
                            }
                        }
                    }
                }
                if (this.ibb && this.ibj != null) {
                    canvas.drawText("FPS:".concat(String.valueOf((int) aGn())), 5.0f, 20.0f, this.ibk);
                }
                if (this.ibc && this.ibm != null) {
                    it2 = this.ibm.iterator();
                    while (it2.hasNext()) {
                        floatValue = ((Float) it2.next()).floatValue();
                        canvas.drawLine(0.0f, floatValue, (float) getWidth(), floatValue, this.ibk);
                    }
                }
            } catch (Exception e) {
                ab.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", e);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(126610);
                }
            }
            invalidate();
            AppMethodBeat.o(126610);
        } else {
            if (this.status == 2) {
                try {
                    canvas.drawColor(0);
                    for (i = 0; i < this.ibe.size(); i++) {
                        it = ((ArrayList) this.ibe.get(Integer.valueOf(i))).iterator();
                        while (it.hasNext()) {
                            ((d) it.next()).b(canvas, true);
                        }
                    }
                    if (this.ibb && this.ibj != null) {
                        canvas.drawText("FPS:".concat(String.valueOf((int) aGn())), 5.0f, 20.0f, this.ibk);
                    }
                    if (this.ibc && this.ibm != null) {
                        it2 = this.ibm.iterator();
                        while (it2.hasNext()) {
                            floatValue = ((Float) it2.next()).floatValue();
                            canvas.drawLine(0.0f, floatValue, (float) getWidth(), floatValue, this.ibk);
                        }
                    }
                } catch (Exception e2) {
                    ab.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", e2);
                }
                invalidate();
            }
            AppMethodBeat.o(126610);
        }
    }

    private int b(d dVar) {
        AppMethodBeat.i(126611);
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.iaW) {
                    break;
                }
                int i3 = (i2 + 0) % this.iaW;
                ArrayList arrayList = (ArrayList) this.ibe.get(Integer.valueOf(i3));
                if (arrayList.size() == 0) {
                    AppMethodBeat.o(126611);
                    return i3;
                } else if (arrayList.size() > this.iaY || dVar.a((d) arrayList.get(arrayList.size() - 1))) {
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(126611);
                    return i3;
                }
            } catch (Exception e) {
                ab.w("MicroMsg.DanmuView", "findVacant,Exception:" + e.getMessage());
            }
        }
        AppMethodBeat.o(126611);
        return -1;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(126612);
        super.onSizeChanged(i, i2, i3, i4);
        aGg();
        AppMethodBeat.o(126612);
    }

    public final void aGh() {
        AppMethodBeat.i(126613);
        if (isMainThread()) {
            this.ibi = true;
            AppMethodBeat.o(126613);
            return;
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(126599);
                DanmuView.this.ibi = true;
                AppMethodBeat.o(126599);
            }
        });
        AppMethodBeat.o(126613);
    }

    public final void aGi() {
        AppMethodBeat.i(126614);
        if (isMainThread()) {
            this.ibi = false;
            invalidate();
            AppMethodBeat.o(126614);
            return;
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(126600);
                DanmuView.this.ibi = false;
                DanmuView.this.invalidate();
                AppMethodBeat.o(126600);
            }
        });
        AppMethodBeat.o(126614);
    }

    public final void show() {
        AppMethodBeat.i(126615);
        this.status = 1;
        invalidate();
        AppMethodBeat.o(126615);
    }

    public final void pause() {
        AppMethodBeat.i(126616);
        this.status = 2;
        invalidate();
        AppMethodBeat.o(126616);
    }

    public final void hide() {
        AppMethodBeat.i(126617);
        this.status = 4;
        invalidate();
        AppMethodBeat.o(126617);
    }

    public final void clear() {
        AppMethodBeat.i(126618);
        this.status = 3;
        aGj();
        this.ibg.clear();
        invalidate();
        AppMethodBeat.o(126618);
    }

    public final void aGj() {
        AppMethodBeat.i(126619);
        aGk();
        aGl();
        AppMethodBeat.o(126619);
    }

    private void aGk() {
        AppMethodBeat.i(126620);
        if (!(this.ibe == null || this.ibe.isEmpty())) {
            this.ibe.clear();
        }
        AppMethodBeat.o(126620);
    }

    private void aGl() {
        AppMethodBeat.i(126621);
        synchronized (this.ibf) {
            try {
                if (!this.ibf.isEmpty()) {
                    this.ibf.clear();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(126621);
            }
        }
    }

    public void setMaxRow(int i) {
        AppMethodBeat.i(126622);
        this.iaW = i;
        if (this.ibe != null) {
            synchronized (this.ibe) {
                int i2 = 0;
                while (i2 < this.ibe.size()) {
                    try {
                        ArrayList arrayList = (ArrayList) this.ibe.get(Integer.valueOf(i2));
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        i2++;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(126622);
                        }
                    }
                }
            }
        }
        aGe();
        AppMethodBeat.o(126622);
    }

    public void setPickItemInterval(int i) {
        this.iaX = i;
    }

    public void setMaxRunningPerRow(int i) {
        this.iaY = i;
    }

    public final void aGm() {
        this.iaZ = 0.0f;
        this.iba = 0.8f;
    }

    public float getYOffset() {
        return this.iba - this.iaZ;
    }

    public void setShowFps(boolean z) {
        AppMethodBeat.i(126623);
        this.ibb = z;
        if (z && (this.ibk == null || this.ibj == null)) {
            this.ibk = new TextPaint(1);
            this.ibk.setColor(-256);
            this.ibk.setTextSize(20.0f);
            this.ibj = new LinkedList();
        }
        AppMethodBeat.o(126623);
    }

    public void setShowLines(boolean z) {
        AppMethodBeat.i(126624);
        this.ibc = z;
        if (z && this.ibm == null) {
            this.ibm = new LinkedList();
        }
        AppMethodBeat.o(126624);
    }

    public void setDanmuViewCallBack(c cVar) {
        this.ibd = cVar;
    }

    private double aGn() {
        AppMethodBeat.i(126625);
        long nanoTime = System.nanoTime();
        this.ibj.addLast(Long.valueOf(nanoTime));
        double longValue = ((double) (nanoTime - ((Long) this.ibj.getFirst()).longValue())) / 1.0E9d;
        if (this.ibj.size() > 100) {
            this.ibj.removeFirst();
        }
        if (longValue > 0.0d) {
            longValue = ((double) this.ibj.size()) / longValue;
            AppMethodBeat.o(126625);
            return longValue;
        }
        AppMethodBeat.o(126625);
        return 0.0d;
    }

    private static boolean isMainThread() {
        AppMethodBeat.i(126626);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AppMethodBeat.o(126626);
            return true;
        }
        AppMethodBeat.o(126626);
        return false;
    }
}
