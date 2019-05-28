package com.tencent.p177mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.p069v7.p073d.C17469a;
import android.support.p069v7.p073d.C17471b;
import android.support.p069v7.p073d.C17471b.C17472b;
import android.support.p069v7.p073d.C17471b.C17473c;
import android.support.p069v7.p073d.C17471b.C17474a;
import android.support.p069v7.p073d.C37135c;
import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.pluginsdk.model.C23251k;
import com.tencent.p177mm.protocal.protobuf.cit;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.scanner.util.n */
public final class C46190n {
    public volatile int qiA;
    public volatile C34843b qiB;
    public C24823a qiC;

    /* renamed from: com.tencent.mm.plugin.scanner.util.n$a */
    public class C24823a extends C23251k<Void, Void, Bitmap> {
        private float angle;
        private Canvas bmG;
        private Bitmap qfT;
        private int qiD;
        private Bitmap qiE;
        private Matrix qiF;
        private Matrix qiG;
        private List<cit> qiH;
        private Set<cit> qiI = new HashSet();
        private Map<Integer, List<cit>> qiJ = new HashMap();

        /* renamed from: dv */
        public final /* synthetic */ Object mo38879dv() {
            AppMethodBeat.m2504i(81470);
            Bitmap ow = m38783ow();
            AppMethodBeat.m2505o(81470);
            return ow;
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(81469);
            Bitmap bitmap = (Bitmap) obj;
            C4990ab.m7417i("MicroMsg.MMAsyncTask", "task session %d, curSession %d", Integer.valueOf(this.qiD), Integer.valueOf(C46190n.this.qiA));
            if (this.qiD != C46190n.this.qiA) {
                C4990ab.m7416i("MicroMsg.MMAsyncTask", "ignore this translation result");
                AppMethodBeat.m2505o(81469);
                return;
            }
            if (!(C46190n.this.qiB == null || bitmap == null || bitmap == null)) {
                C46190n.this.qiB.mo37175b(this.qiD, bitmap);
            }
            AppMethodBeat.m2505o(81469);
        }

        public C24823a(int i, List<cit> list, float f, Bitmap bitmap) {
            cit cit;
            AppMethodBeat.m2504i(81466);
            this.qiD = i;
            this.qiH = list;
            this.angle = f;
            this.qfT = bitmap;
            Iterator it = this.qiH.iterator();
            while (it.hasNext()) {
                Object obj;
                cit = (cit) it.next();
                if (cit.Width <= 1 || cit.Height <= 1 || cit.Width == BaseClientBuilder.API_PRIORITY_OTHER || cit.Height == BaseClientBuilder.API_PRIORITY_OTHER || cit.f17917X < 0 || cit.f17918Y < 0 || cit.f17917X == BaseClientBuilder.API_PRIORITY_OTHER || cit.f17918Y == BaseClientBuilder.API_PRIORITY_OTHER) {
                    C4990ab.m7417i("MicroMsg.MMAsyncTask", "invalid translation info (%d,%d) %d %d", Integer.valueOf(cit.f17917X), Integer.valueOf(cit.f17918Y), Integer.valueOf(cit.Width), Integer.valueOf(cit.Height));
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    C4990ab.m7416i("MicroMsg.MMAsyncTask", "remove invalid translation info");
                    it.remove();
                }
            }
            for (cit cit2 : this.qiH) {
                if (cit2.weB > 0) {
                    if (!this.qiJ.containsKey(Integer.valueOf(cit2.weB))) {
                        this.qiJ.put(Integer.valueOf(cit2.weB), new ArrayList());
                    }
                    ((List) this.qiJ.get(Integer.valueOf(cit2.weB))).add(cit2);
                } else {
                    this.qiI.add(cit2);
                }
            }
            AppMethodBeat.m2505o(81466);
        }

        /* renamed from: ow */
        private Bitmap m38783ow() {
            AppMethodBeat.m2504i(81467);
            try {
                Bitmap copy = this.qfT.copy(Config.ARGB_8888, true);
                this.qiF = new Matrix();
                float[] fArr = new float[]{0.0f, 0.0f, (float) this.qfT.getWidth(), (float) this.qfT.getHeight()};
                float[] fArr2 = new float[]{0.0f, (float) (((double) this.qfT.getWidth()) * Math.abs(Math.sin((double) this.angle))), (float) ((((double) this.qfT.getWidth()) * Math.abs(Math.cos((double) this.angle))) + (((double) this.qfT.getHeight()) * Math.abs(Math.sin((double) this.angle)))), (float) (((double) this.qfT.getHeight()) * Math.abs(Math.cos((double) this.angle)))};
                this.qiF.setPolyToPoly(fArr, 0, fArr2, 0, 2);
                this.qiF.setRotate(-this.angle);
                this.qiG = new Matrix();
                this.qiG.setPolyToPoly(fArr2, 0, fArr, 0, 2);
                this.qiG.setRotate(this.angle);
                C4990ab.m7417i("MicroMsg.MMAsyncTask", "angle %s", Float.valueOf(this.angle));
                long currentTimeMillis = System.currentTimeMillis();
                this.qiE = Bitmap.createBitmap(copy, 0, 0, this.qfT.getWidth(), this.qfT.getHeight(), this.qiF, true);
                C4990ab.m7417i("MicroMsg.MMAsyncTask", "originalBitmap %d, %d  rotatedBitmap %d %d", Integer.valueOf(this.qfT.getWidth()), Integer.valueOf(this.qfT.getHeight()), Integer.valueOf(this.qiE.getWidth()), Integer.valueOf(this.qiE.getHeight()));
                this.bmG = new Canvas(this.qiE);
                C4990ab.m7417i("MicroMsg.MMAsyncTask", "create rotated bitmap cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis2 = System.currentTimeMillis();
                for (cit cit : this.qiH) {
                    C4990ab.m7417i("MicroMsg.MMAsyncTask", "x %s, y %s, width %s, height %s, text.length %s", Integer.valueOf(cit.f17917X), Integer.valueOf(cit.f17918Y), Integer.valueOf(cit.Width), Integer.valueOf(cit.Height), Integer.valueOf(cit.wIG.length()));
                    Bitmap bitmap = this.qiE;
                    if (cit.f17917X + cit.Width > bitmap.getWidth()) {
                        cit.Width = bitmap.getWidth() - cit.f17917X;
                    }
                    if (cit.f17918Y + cit.Height > bitmap.getHeight()) {
                        cit.Height = bitmap.getHeight() - cit.f17918Y;
                    }
                    C4990ab.m7417i("MicroMsg.MMAsyncTask", "area bitmap %d, %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(Bitmap.createBitmap(this.qiE, cit.f17917X, cit.f17918Y, cit.Width, cit.Height).getHeight()));
                    int[] S = C46190n.m86344S(bitmap);
                    int i = S[0];
                    Canvas canvas = this.bmG;
                    Paint paint = new Paint();
                    Rect rect = new Rect(cit.f17917X, cit.f17918Y, cit.Width + cit.f17917X, cit.Height + cit.f17918Y);
                    paint.setStyle(Style.FILL_AND_STROKE);
                    paint.setColor(i);
                    paint.setAntiAlias(true);
                    canvas.drawRect(rect, paint);
                    if (this.qiI.contains(cit)) {
                        C46190n.m86346a(C46190n.m86345a(cit), S[1], cit, this.bmG);
                    }
                }
                C4990ab.m7417i("MicroMsg.MMAsyncTask", "draw all translation bg cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                for (Integer intValue : this.qiJ.keySet()) {
                    int intValue2 = intValue.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (cit cit2 : (List) this.qiJ.get(Integer.valueOf(intValue2))) {
                        arrayList.add(Float.valueOf(C46190n.m86345a(cit2)));
                    }
                    float floatValue = ((Float) Collections.min(arrayList)).floatValue();
                    List list = (List) this.qiJ.get(Integer.valueOf(intValue2));
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        cit cit3 = (cit) list.get(i2);
                        C4990ab.m7417i("MicroMsg.MMAsyncTask", "x %s, y %s, width %s, height %s", Integer.valueOf(cit3.f17917X), Integer.valueOf(cit3.f17918Y), Integer.valueOf(cit3.Width), Integer.valueOf(cit3.Height));
                        C4990ab.m7417i("MicroMsg.MMAsyncTask", "area bitmap %d, %d", Integer.valueOf(r7.getWidth()), Integer.valueOf(Bitmap.createBitmap(this.qiE, cit3.f17917X, cit3.f17918Y, cit3.Width, cit3.Height).getHeight()));
                        C46190n.m86346a(floatValue, C46190n.m86344S(r7)[1], cit3, this.bmG);
                    }
                }
                C4990ab.m7417i("MicroMsg.MMAsyncTask", "draw all translation text cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                Bitmap createBitmap = Bitmap.createBitmap(this.qiE, 0, 0, this.qiE.getWidth(), this.qiE.getHeight(), this.qiG, true);
                C4990ab.m7417i("MicroMsg.MMAsyncTask", "resultBitmap width %d, height %d", Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
                int[] iArr = new int[(this.qfT.getWidth() * this.qfT.getHeight())];
                createBitmap.getPixels(iArr, 0, this.qfT.getWidth(), (createBitmap.getWidth() - this.qfT.getWidth()) / 2, (createBitmap.getHeight() - this.qfT.getHeight()) / 2, this.qfT.getWidth(), this.qfT.getHeight());
                createBitmap = C5056d.m7623a(iArr, this.qfT.getWidth(), this.qfT.getHeight(), Config.ARGB_8888);
                AppMethodBeat.m2505o(81467);
                return createBitmap;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMAsyncTask", e, "render translation info error", new Object[0]);
                AppMethodBeat.m2505o(81467);
                return null;
            }
        }

        public final C4946a cin() {
            AppMethodBeat.m2504i(81468);
            C4946a cin = C7305d.xDG.cin();
            AppMethodBeat.m2505o(81468);
            return cin;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.n$b */
    public interface C34843b {
        /* renamed from: b */
        void mo37175b(int i, Bitmap bitmap);
    }

    public final void cim() {
        this.qiA = 0;
        this.qiB = null;
    }

    /* renamed from: S */
    static /* synthetic */ int[] m86344S(Bitmap bitmap) {
        List list;
        AppMethodBeat.m2504i(81471);
        C17474a d = C17471b.m27128d(bitmap);
        if (d.mBitmap != null) {
            Bitmap bitmap2;
            C17472b[] c17472bArr;
            Bitmap bitmap3 = d.mBitmap;
            double d2 = -1.0d;
            int width;
            if (d.f4033XL > 0) {
                width = bitmap3.getWidth() * bitmap3.getHeight();
                if (width > d.f4033XL) {
                    d2 = Math.sqrt(((double) d.f4033XL) / ((double) width));
                }
            } else if (d.f4034XM > 0) {
                width = Math.max(bitmap3.getWidth(), bitmap3.getHeight());
                if (width > d.f4034XM) {
                    d2 = ((double) d.f4034XM) / ((double) width);
                }
            }
            if (d2 <= 0.0d) {
                bitmap2 = bitmap3;
            } else {
                bitmap2 = Bitmap.createScaledBitmap(bitmap3, (int) Math.ceil(((double) bitmap3.getWidth()) * d2), (int) Math.ceil(d2 * ((double) bitmap3.getHeight())), false);
            }
            Rect rect = d.f4035XN;
            if (!(bitmap2 == d.mBitmap || rect == null)) {
                double width2 = ((double) bitmap2.getWidth()) / ((double) d.mBitmap.getWidth());
                rect.left = (int) Math.floor(((double) rect.left) * width2);
                rect.top = (int) Math.floor(((double) rect.top) * width2);
                rect.right = Math.min((int) Math.ceil(((double) rect.right) * width2), bitmap2.getWidth());
                rect.bottom = Math.min((int) Math.ceil(width2 * ((double) rect.bottom)), bitmap2.getHeight());
            }
            int[] e = d.mo31822e(bitmap2);
            int i = d.f4032XK;
            if (d.mFilters.isEmpty()) {
                c17472bArr = null;
            } else {
                c17472bArr = (C17472b[]) d.mFilters.toArray(new C17472b[d.mFilters.size()]);
            }
            C17469a c17469a = new C17469a(e, i, c17472bArr);
            if (bitmap2 != d.mBitmap) {
                bitmap2.recycle();
            }
            list = c17469a.f4001Xp;
        } else {
            list = d.f4030XE;
        }
        C17471b c17471b = new C17471b(list, d.f4031XF);
        int size = c17471b.f4017XF.size();
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            int length;
            C37135c c37135c = (C37135c) c17471b.f4017XF.get(i2);
            float f = 0.0f;
            for (float f2 : c37135c.f15834Ye) {
                if (f2 > 0.0f) {
                    f += f2;
                }
            }
            if (f != 0.0f) {
                length = c37135c.f15834Ye.length;
                for (i3 = 0; i3 < length; i3++) {
                    if (c37135c.f15834Ye[i3] > 0.0f) {
                        float[] fArr = c37135c.f15834Ye;
                        fArr[i3] = fArr[i3] / f;
                    }
                }
            }
            Map map = c17471b.f4018XG;
            float f3 = 0.0f;
            C17473c c17473c = null;
            int size2 = c17471b.f4016XE.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj;
                C17473c c17473c2 = (C17473c) c17471b.f4016XE.get(i4);
                float[] fR = c17473c2.mo31818fR();
                if (fR[1] < c37135c.f15832Yc[0] || fR[1] > c37135c.f15832Yc[2] || fR[2] < c37135c.f15833Yd[0] || fR[2] > c37135c.f15833Yd[2] || c17471b.f4019XH.get(c17473c2.f4024XR)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    float f4;
                    float[] fR2 = c17473c2.mo31818fR();
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    if (c17471b.f4020XI != null) {
                        length = c17471b.f4020XI.f4029Xw;
                    } else {
                        length = 1;
                    }
                    if (c37135c.f15834Ye[0] > 0.0f) {
                        f5 = c37135c.f15834Ye[0] * (1.0f - Math.abs(fR2[1] - c37135c.f15832Yc[1]));
                    }
                    if (c37135c.f15834Ye[1] > 0.0f) {
                        f6 = c37135c.f15834Ye[1] * (1.0f - Math.abs(fR2[2] - c37135c.f15833Yd[1]));
                    }
                    if (c37135c.f15834Ye[2] > 0.0f) {
                        f4 = (((float) c17473c2.f4029Xw) / ((float) length)) * c37135c.f15834Ye[2];
                    } else {
                        f4 = 0.0f;
                    }
                    f4 += f5 + f6;
                    if (c17473c == null || f4 > f3) {
                        f3 = f4;
                        i4++;
                        c17473c = c17473c2;
                    }
                }
                c17473c2 = c17473c;
                i4++;
                c17473c = c17473c2;
            }
            if (c17473c != null && c37135c.f15835Yf) {
                c17471b.f4019XH.append(c17473c.f4024XR, true);
            }
            map.put(c37135c, c17473c);
        }
        c17471b.f4019XH.clear();
        int[] f7;
        if (c17471b.f4020XI == null) {
            C4990ab.m7416i("MicroMsg.ScanTranslationRender", "can not find suitable swatch");
            f7 = C5222ae.m7943f(bitmap, bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.m2505o(81471);
            return f7;
        }
        f7 = new int[]{c17471b.f4020XI.f4024XR, c17471b.f4020XI.mo31819fS()};
        AppMethodBeat.m2505o(81471);
        return f7;
    }

    /* renamed from: a */
    static /* synthetic */ float m86345a(cit cit) {
        AppMethodBeat.m2504i(81472);
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Style.FILL);
        textPaint.setTextSize(16.0f);
        DynamicLayout dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        while (dynamicLayout.getLineBottom(dynamicLayout.getLineCount() - 1) < cit.Height) {
            textPaint.setTextSize(textPaint.getTextSize() + 0.5f);
            C4990ab.m7411d("MicroMsg.ScanTranslationRender", "try bigger text size %f", Float.valueOf(textPaint.getTextSize()));
            dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        }
        while (dynamicLayout.getLineBottom(dynamicLayout.getLineCount() - 1) > cit.Height && textPaint.getTextSize() > 1.0f) {
            textPaint.setTextSize(textPaint.getTextSize() - 0.5f);
            C4990ab.m7411d("MicroMsg.ScanTranslationRender", "try smaller text size %f", Float.valueOf(textPaint.getTextSize()));
            dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        }
        float textSize = textPaint.getTextSize();
        AppMethodBeat.m2505o(81472);
        return textSize;
    }

    /* renamed from: a */
    static /* synthetic */ void m86346a(float f, int i, cit cit, Canvas canvas) {
        AppMethodBeat.m2504i(81473);
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Style.FILL);
        textPaint.setColor(i);
        textPaint.setTextSize(f);
        textPaint.setAntiAlias(true);
        C4990ab.m7417i("MicroMsg.ScanTranslationRender", "alignment %d", Integer.valueOf(cit.xhI));
        DynamicLayout dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, cit.xhI == 2 ? Alignment.ALIGN_CENTER : Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        canvas.save();
        C4990ab.m7417i("MicroMsg.ScanTranslationRender", "translate %d, %d, textHeight %d, rect Height %d", Integer.valueOf(cit.f17917X), Integer.valueOf(cit.f17918Y), Integer.valueOf(dynamicLayout.getHeight()), Integer.valueOf(cit.Height));
        if (dynamicLayout.getHeight() < cit.Height) {
            canvas.translate((float) cit.f17917X, (float) (cit.f17918Y + ((cit.Height - dynamicLayout.getHeight()) / 2)));
        } else {
            canvas.translate((float) cit.f17917X, (float) cit.f17918Y);
        }
        dynamicLayout.draw(canvas);
        canvas.restore();
        AppMethodBeat.m2505o(81473);
    }
}
