package com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView */
public class DanmuView extends View {
    private int iaW;
    private int iaX;
    private int iaY;
    private float iaZ;
    private float iba;
    private boolean ibb;
    private boolean ibc;
    private C19515c ibd;
    private HashMap<Integer, ArrayList<C19516d>> ibe;
    public final Deque<C19516d> ibf;
    public List<C19516d> ibg;
    private int[] ibh;
    private volatile boolean ibi;
    private LinkedList<Long> ibj;
    private Paint ibk;
    private long ibl;
    private LinkedList<Float> ibm;
    private final Context mContext;
    private volatile int status;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$5 */
    public class C195135 implements Runnable {
        final /* synthetic */ int ibq;

        public C195135(int i) {
            this.ibq = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(126603);
            synchronized (DanmuView.this.ibf) {
                try {
                    for (int size = DanmuView.this.ibg.size() - 1; size >= 0; size--) {
                        C19516d c19516d = (C19516d) DanmuView.this.ibg.get(size);
                        if (c19516d.aGc() < this.ibq) {
                            break;
                        }
                        C4990ab.m7419v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", Integer.valueOf(size), Integer.valueOf(c19516d.aGc()));
                        DanmuView.this.ibf.addFirst(c19516d);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126603);
                }
            }
            DanmuView.m54596c(DanmuView.this);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$2 */
    class C333972 implements Runnable {
        C333972() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126600);
            DanmuView.this.ibi = false;
            DanmuView.this.invalidate();
            AppMethodBeat.m2505o(126600);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$1 */
    class C333981 implements Runnable {
        C333981() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126599);
            DanmuView.this.ibi = true;
            AppMethodBeat.m2505o(126599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$3 */
    public class C333993 implements Runnable {
        final /* synthetic */ C19516d ibo;

        public C333993(C19516d c19516d) {
            this.ibo = c19516d;
        }

        public final void run() {
            AppMethodBeat.m2504i(126601);
            synchronized (DanmuView.this.ibg) {
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= DanmuView.this.ibg.size()) {
                            break;
                        } else if (this.ibo.aGc() <= ((C19516d) DanmuView.this.ibg.get(i2)).aGc()) {
                            DanmuView.this.ibg.add(i2, this.ibo);
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(126601);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$4 */
    public class C334004 extends Thread {
        final /* synthetic */ List ibp;

        public C334004(List list) {
            this.ibp = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(126602);
            synchronized (DanmuView.this.ibf) {
                try {
                    DanmuView.this.ibf.addAll(this.ibp);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126602);
                }
            }
            synchronized (DanmuView.this.ibg) {
                try {
                    DanmuView.this.ibg.addAll(this.ibp);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(126602);
                    }
                }
            }
            DanmuView.this.postInvalidate();
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m54596c(DanmuView danmuView) {
        AppMethodBeat.m2504i(126627);
        danmuView.aGi();
        AppMethodBeat.m2505o(126627);
    }

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(126604);
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
        AppMethodBeat.m2505o(126604);
    }

    /* renamed from: L */
    private static void m54591L(float f, float f2) {
        AppMethodBeat.m2504i(126605);
        IllegalArgumentException illegalArgumentException;
        if (f >= f2) {
            illegalArgumentException = new IllegalArgumentException("start_Y_offset must < end_Y_offset");
            AppMethodBeat.m2505o(126605);
            throw illegalArgumentException;
        } else if (f < 0.0f || f >= 1.0f || f2 < 0.0f || f2 > 1.0f) {
            illegalArgumentException = new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
            AppMethodBeat.m2505o(126605);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(126605);
        }
    }

    public final void prepare() {
        AppMethodBeat.m2504i(126606);
        DanmuView.m54591L(this.iaZ, this.iba);
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        aGe();
        AppMethodBeat.m2505o(126606);
    }

    private void aGe() {
        AppMethodBeat.m2504i(126607);
        aGf();
        aGg();
        AppMethodBeat.m2505o(126607);
    }

    private void aGf() {
        AppMethodBeat.m2504i(126608);
        this.ibe = new HashMap(this.iaW);
        for (int i = 0; i < this.iaW; i++) {
            this.ibe.put(Integer.valueOf(i), new ArrayList(this.iaY));
        }
        AppMethodBeat.m2505o(126608);
    }

    private void aGg() {
        int i = 0;
        AppMethodBeat.m2504i(126609);
        this.ibh = new int[this.iaW];
        float cO = C19514b.m30236cO(this.mContext);
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
        AppMethodBeat.m2505o(126609);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(126610);
        super.onDraw(canvas);
        int i;
        Iterator it;
        Iterator it2;
        float floatValue;
        if (this.ibi) {
            C4990ab.m7416i("MicroMsg.DanmuView", "inTransition");
            AppMethodBeat.m2505o(126610);
        } else if (this.status == 1) {
            try {
                C19516d c19516d;
                canvas.drawColor(0);
                for (i = 0; i < this.ibe.size(); i++) {
                    it = ((ArrayList) this.ibe.get(Integer.valueOf(i))).iterator();
                    while (it.hasNext()) {
                        c19516d = (C19516d) it.next();
                        if (c19516d.aGb()) {
                            it.remove();
                        } else {
                            c19516d.mo34706b(canvas, false);
                        }
                    }
                }
                if (System.currentTimeMillis() - this.ibl > ((long) this.iaX)) {
                    this.ibl = System.currentTimeMillis();
                    synchronized (this.ibf) {
                        if (this.ibf.size() > 0) {
                            c19516d = (C19516d) this.ibf.getFirst();
                            int afA = this.ibd.afA();
                            C19516d c19516d2 = c19516d;
                            while (c19516d2 != null && c19516d2.mo34711oC(afA)) {
                                this.ibf.pollFirst();
                                c19516d2 = (C19516d) this.ibf.getFirst();
                            }
                            if (c19516d2 != null && c19516d2.mo34710oB(afA)) {
                                int b = m54594b(c19516d2);
                                if (b >= 0) {
                                    c19516d2.mo34707dg(canvas.getWidth() - 2, this.ibh[b]);
                                    c19516d2.mo34706b(canvas, false);
                                    ((ArrayList) this.ibe.get(Integer.valueOf(b))).add(c19516d2);
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
                C4990ab.m7421w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", e);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(126610);
                }
            }
            invalidate();
            AppMethodBeat.m2505o(126610);
        } else {
            if (this.status == 2) {
                try {
                    canvas.drawColor(0);
                    for (i = 0; i < this.ibe.size(); i++) {
                        it = ((ArrayList) this.ibe.get(Integer.valueOf(i))).iterator();
                        while (it.hasNext()) {
                            ((C19516d) it.next()).mo34706b(canvas, true);
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
                    C4990ab.m7421w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", e2);
                }
                invalidate();
            }
            AppMethodBeat.m2505o(126610);
        }
    }

    /* renamed from: b */
    private int m54594b(C19516d c19516d) {
        AppMethodBeat.m2504i(126611);
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
                    AppMethodBeat.m2505o(126611);
                    return i3;
                } else if (arrayList.size() > this.iaY || c19516d.mo34702a((C19516d) arrayList.get(arrayList.size() - 1))) {
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(126611);
                    return i3;
                }
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.DanmuView", "findVacant,Exception:" + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(126611);
        return -1;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(126612);
        super.onSizeChanged(i, i2, i3, i4);
        aGg();
        AppMethodBeat.m2505o(126612);
    }

    public final void aGh() {
        AppMethodBeat.m2504i(126613);
        if (DanmuView.isMainThread()) {
            this.ibi = true;
            AppMethodBeat.m2505o(126613);
            return;
        }
        post(new C333981());
        AppMethodBeat.m2505o(126613);
    }

    public final void aGi() {
        AppMethodBeat.m2504i(126614);
        if (DanmuView.isMainThread()) {
            this.ibi = false;
            invalidate();
            AppMethodBeat.m2505o(126614);
            return;
        }
        post(new C333972());
        AppMethodBeat.m2505o(126614);
    }

    public final void show() {
        AppMethodBeat.m2504i(126615);
        this.status = 1;
        invalidate();
        AppMethodBeat.m2505o(126615);
    }

    public final void pause() {
        AppMethodBeat.m2504i(126616);
        this.status = 2;
        invalidate();
        AppMethodBeat.m2505o(126616);
    }

    public final void hide() {
        AppMethodBeat.m2504i(126617);
        this.status = 4;
        invalidate();
        AppMethodBeat.m2505o(126617);
    }

    public final void clear() {
        AppMethodBeat.m2504i(126618);
        this.status = 3;
        aGj();
        this.ibg.clear();
        invalidate();
        AppMethodBeat.m2505o(126618);
    }

    public final void aGj() {
        AppMethodBeat.m2504i(126619);
        aGk();
        aGl();
        AppMethodBeat.m2505o(126619);
    }

    private void aGk() {
        AppMethodBeat.m2504i(126620);
        if (!(this.ibe == null || this.ibe.isEmpty())) {
            this.ibe.clear();
        }
        AppMethodBeat.m2505o(126620);
    }

    private void aGl() {
        AppMethodBeat.m2504i(126621);
        synchronized (this.ibf) {
            try {
                if (!this.ibf.isEmpty()) {
                    this.ibf.clear();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(126621);
            }
        }
    }

    public void setMaxRow(int i) {
        AppMethodBeat.m2504i(126622);
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
                            AppMethodBeat.m2505o(126622);
                        }
                    }
                }
            }
        }
        aGe();
        AppMethodBeat.m2505o(126622);
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
        AppMethodBeat.m2504i(126623);
        this.ibb = z;
        if (z && (this.ibk == null || this.ibj == null)) {
            this.ibk = new TextPaint(1);
            this.ibk.setColor(-256);
            this.ibk.setTextSize(20.0f);
            this.ibj = new LinkedList();
        }
        AppMethodBeat.m2505o(126623);
    }

    public void setShowLines(boolean z) {
        AppMethodBeat.m2504i(126624);
        this.ibc = z;
        if (z && this.ibm == null) {
            this.ibm = new LinkedList();
        }
        AppMethodBeat.m2505o(126624);
    }

    public void setDanmuViewCallBack(C19515c c19515c) {
        this.ibd = c19515c;
    }

    private double aGn() {
        AppMethodBeat.m2504i(126625);
        long nanoTime = System.nanoTime();
        this.ibj.addLast(Long.valueOf(nanoTime));
        double longValue = ((double) (nanoTime - ((Long) this.ibj.getFirst()).longValue())) / 1.0E9d;
        if (this.ibj.size() > 100) {
            this.ibj.removeFirst();
        }
        if (longValue > 0.0d) {
            longValue = ((double) this.ibj.size()) / longValue;
            AppMethodBeat.m2505o(126625);
            return longValue;
        }
        AppMethodBeat.m2505o(126625);
        return 0.0d;
    }

    private static boolean isMainThread() {
        AppMethodBeat.m2504i(126626);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AppMethodBeat.m2505o(126626);
            return true;
        }
        AppMethodBeat.m2505o(126626);
        return false;
    }
}
