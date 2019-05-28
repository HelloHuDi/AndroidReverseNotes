package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.d.c;
import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class n {
    public volatile int qiA;
    public volatile b qiB;
    public a qiC;

    public class a extends k<Void, Void, Bitmap> {
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

        public final /* synthetic */ Object dv() {
            AppMethodBeat.i(81470);
            Bitmap ow = ow();
            AppMethodBeat.o(81470);
            return ow;
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(81469);
            Bitmap bitmap = (Bitmap) obj;
            ab.i("MicroMsg.MMAsyncTask", "task session %d, curSession %d", Integer.valueOf(this.qiD), Integer.valueOf(n.this.qiA));
            if (this.qiD != n.this.qiA) {
                ab.i("MicroMsg.MMAsyncTask", "ignore this translation result");
                AppMethodBeat.o(81469);
                return;
            }
            if (!(n.this.qiB == null || bitmap == null || bitmap == null)) {
                n.this.qiB.b(this.qiD, bitmap);
            }
            AppMethodBeat.o(81469);
        }

        public a(int i, List<cit> list, float f, Bitmap bitmap) {
            cit cit;
            AppMethodBeat.i(81466);
            this.qiD = i;
            this.qiH = list;
            this.angle = f;
            this.qfT = bitmap;
            Iterator it = this.qiH.iterator();
            while (it.hasNext()) {
                Object obj;
                cit = (cit) it.next();
                if (cit.Width <= 1 || cit.Height <= 1 || cit.Width == BaseClientBuilder.API_PRIORITY_OTHER || cit.Height == BaseClientBuilder.API_PRIORITY_OTHER || cit.X < 0 || cit.Y < 0 || cit.X == BaseClientBuilder.API_PRIORITY_OTHER || cit.Y == BaseClientBuilder.API_PRIORITY_OTHER) {
                    ab.i("MicroMsg.MMAsyncTask", "invalid translation info (%d,%d) %d %d", Integer.valueOf(cit.X), Integer.valueOf(cit.Y), Integer.valueOf(cit.Width), Integer.valueOf(cit.Height));
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    ab.i("MicroMsg.MMAsyncTask", "remove invalid translation info");
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
            AppMethodBeat.o(81466);
        }

        private Bitmap ow() {
            AppMethodBeat.i(81467);
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
                ab.i("MicroMsg.MMAsyncTask", "angle %s", Float.valueOf(this.angle));
                long currentTimeMillis = System.currentTimeMillis();
                this.qiE = Bitmap.createBitmap(copy, 0, 0, this.qfT.getWidth(), this.qfT.getHeight(), this.qiF, true);
                ab.i("MicroMsg.MMAsyncTask", "originalBitmap %d, %d  rotatedBitmap %d %d", Integer.valueOf(this.qfT.getWidth()), Integer.valueOf(this.qfT.getHeight()), Integer.valueOf(this.qiE.getWidth()), Integer.valueOf(this.qiE.getHeight()));
                this.bmG = new Canvas(this.qiE);
                ab.i("MicroMsg.MMAsyncTask", "create rotated bitmap cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis2 = System.currentTimeMillis();
                for (cit cit : this.qiH) {
                    ab.i("MicroMsg.MMAsyncTask", "x %s, y %s, width %s, height %s, text.length %s", Integer.valueOf(cit.X), Integer.valueOf(cit.Y), Integer.valueOf(cit.Width), Integer.valueOf(cit.Height), Integer.valueOf(cit.wIG.length()));
                    Bitmap bitmap = this.qiE;
                    if (cit.X + cit.Width > bitmap.getWidth()) {
                        cit.Width = bitmap.getWidth() - cit.X;
                    }
                    if (cit.Y + cit.Height > bitmap.getHeight()) {
                        cit.Height = bitmap.getHeight() - cit.Y;
                    }
                    ab.i("MicroMsg.MMAsyncTask", "area bitmap %d, %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(Bitmap.createBitmap(this.qiE, cit.X, cit.Y, cit.Width, cit.Height).getHeight()));
                    int[] S = n.S(bitmap);
                    int i = S[0];
                    Canvas canvas = this.bmG;
                    Paint paint = new Paint();
                    Rect rect = new Rect(cit.X, cit.Y, cit.Width + cit.X, cit.Height + cit.Y);
                    paint.setStyle(Style.FILL_AND_STROKE);
                    paint.setColor(i);
                    paint.setAntiAlias(true);
                    canvas.drawRect(rect, paint);
                    if (this.qiI.contains(cit)) {
                        n.a(n.a(cit), S[1], cit, this.bmG);
                    }
                }
                ab.i("MicroMsg.MMAsyncTask", "draw all translation bg cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                for (Integer intValue : this.qiJ.keySet()) {
                    int intValue2 = intValue.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (cit cit2 : (List) this.qiJ.get(Integer.valueOf(intValue2))) {
                        arrayList.add(Float.valueOf(n.a(cit2)));
                    }
                    float floatValue = ((Float) Collections.min(arrayList)).floatValue();
                    List list = (List) this.qiJ.get(Integer.valueOf(intValue2));
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        cit cit3 = (cit) list.get(i2);
                        ab.i("MicroMsg.MMAsyncTask", "x %s, y %s, width %s, height %s", Integer.valueOf(cit3.X), Integer.valueOf(cit3.Y), Integer.valueOf(cit3.Width), Integer.valueOf(cit3.Height));
                        ab.i("MicroMsg.MMAsyncTask", "area bitmap %d, %d", Integer.valueOf(r7.getWidth()), Integer.valueOf(Bitmap.createBitmap(this.qiE, cit3.X, cit3.Y, cit3.Width, cit3.Height).getHeight()));
                        n.a(floatValue, n.S(r7)[1], cit3, this.bmG);
                    }
                }
                ab.i("MicroMsg.MMAsyncTask", "draw all translation text cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                Bitmap createBitmap = Bitmap.createBitmap(this.qiE, 0, 0, this.qiE.getWidth(), this.qiE.getHeight(), this.qiG, true);
                ab.i("MicroMsg.MMAsyncTask", "resultBitmap width %d, height %d", Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
                int[] iArr = new int[(this.qfT.getWidth() * this.qfT.getHeight())];
                createBitmap.getPixels(iArr, 0, this.qfT.getWidth(), (createBitmap.getWidth() - this.qfT.getWidth()) / 2, (createBitmap.getHeight() - this.qfT.getHeight()) / 2, this.qfT.getWidth(), this.qfT.getHeight());
                createBitmap = d.a(iArr, this.qfT.getWidth(), this.qfT.getHeight(), Config.ARGB_8888);
                AppMethodBeat.o(81467);
                return createBitmap;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMAsyncTask", e, "render translation info error", new Object[0]);
                AppMethodBeat.o(81467);
                return null;
            }
        }

        public final com.tencent.mm.sdk.g.b.a cin() {
            AppMethodBeat.i(81468);
            com.tencent.mm.sdk.g.b.a cin = com.tencent.mm.sdk.g.d.xDG.cin();
            AppMethodBeat.o(81468);
            return cin;
        }
    }

    public interface b {
        void b(int i, Bitmap bitmap);
    }

    public final void cim() {
        this.qiA = 0;
        this.qiB = null;
    }

    static /* synthetic */ int[] S(Bitmap bitmap) {
        List list;
        AppMethodBeat.i(81471);
        android.support.v7.d.b.a d = android.support.v7.d.b.d(bitmap);
        if (d.mBitmap != null) {
            Bitmap bitmap2;
            android.support.v7.d.b.b[] bVarArr;
            Bitmap bitmap3 = d.mBitmap;
            double d2 = -1.0d;
            int width;
            if (d.XL > 0) {
                width = bitmap3.getWidth() * bitmap3.getHeight();
                if (width > d.XL) {
                    d2 = Math.sqrt(((double) d.XL) / ((double) width));
                }
            } else if (d.XM > 0) {
                width = Math.max(bitmap3.getWidth(), bitmap3.getHeight());
                if (width > d.XM) {
                    d2 = ((double) d.XM) / ((double) width);
                }
            }
            if (d2 <= 0.0d) {
                bitmap2 = bitmap3;
            } else {
                bitmap2 = Bitmap.createScaledBitmap(bitmap3, (int) Math.ceil(((double) bitmap3.getWidth()) * d2), (int) Math.ceil(d2 * ((double) bitmap3.getHeight())), false);
            }
            Rect rect = d.XN;
            if (!(bitmap2 == d.mBitmap || rect == null)) {
                double width2 = ((double) bitmap2.getWidth()) / ((double) d.mBitmap.getWidth());
                rect.left = (int) Math.floor(((double) rect.left) * width2);
                rect.top = (int) Math.floor(((double) rect.top) * width2);
                rect.right = Math.min((int) Math.ceil(((double) rect.right) * width2), bitmap2.getWidth());
                rect.bottom = Math.min((int) Math.ceil(width2 * ((double) rect.bottom)), bitmap2.getHeight());
            }
            int[] e = d.e(bitmap2);
            int i = d.XK;
            if (d.mFilters.isEmpty()) {
                bVarArr = null;
            } else {
                bVarArr = (android.support.v7.d.b.b[]) d.mFilters.toArray(new android.support.v7.d.b.b[d.mFilters.size()]);
            }
            android.support.v7.d.a aVar = new android.support.v7.d.a(e, i, bVarArr);
            if (bitmap2 != d.mBitmap) {
                bitmap2.recycle();
            }
            list = aVar.Xp;
        } else {
            list = d.XE;
        }
        android.support.v7.d.b bVar = new android.support.v7.d.b(list, d.XF);
        int size = bVar.XF.size();
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            int length;
            c cVar = (c) bVar.XF.get(i2);
            float f = 0.0f;
            for (float f2 : cVar.Ye) {
                if (f2 > 0.0f) {
                    f += f2;
                }
            }
            if (f != 0.0f) {
                length = cVar.Ye.length;
                for (i3 = 0; i3 < length; i3++) {
                    if (cVar.Ye[i3] > 0.0f) {
                        float[] fArr = cVar.Ye;
                        fArr[i3] = fArr[i3] / f;
                    }
                }
            }
            Map map = bVar.XG;
            float f3 = 0.0f;
            android.support.v7.d.b.c cVar2 = null;
            int size2 = bVar.XE.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj;
                android.support.v7.d.b.c cVar3 = (android.support.v7.d.b.c) bVar.XE.get(i4);
                float[] fR = cVar3.fR();
                if (fR[1] < cVar.Yc[0] || fR[1] > cVar.Yc[2] || fR[2] < cVar.Yd[0] || fR[2] > cVar.Yd[2] || bVar.XH.get(cVar3.XR)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    float f4;
                    float[] fR2 = cVar3.fR();
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    if (bVar.XI != null) {
                        length = bVar.XI.Xw;
                    } else {
                        length = 1;
                    }
                    if (cVar.Ye[0] > 0.0f) {
                        f5 = cVar.Ye[0] * (1.0f - Math.abs(fR2[1] - cVar.Yc[1]));
                    }
                    if (cVar.Ye[1] > 0.0f) {
                        f6 = cVar.Ye[1] * (1.0f - Math.abs(fR2[2] - cVar.Yd[1]));
                    }
                    if (cVar.Ye[2] > 0.0f) {
                        f4 = (((float) cVar3.Xw) / ((float) length)) * cVar.Ye[2];
                    } else {
                        f4 = 0.0f;
                    }
                    f4 += f5 + f6;
                    if (cVar2 == null || f4 > f3) {
                        f3 = f4;
                        i4++;
                        cVar2 = cVar3;
                    }
                }
                cVar3 = cVar2;
                i4++;
                cVar2 = cVar3;
            }
            if (cVar2 != null && cVar.Yf) {
                bVar.XH.append(cVar2.XR, true);
            }
            map.put(cVar, cVar2);
        }
        bVar.XH.clear();
        int[] f7;
        if (bVar.XI == null) {
            ab.i("MicroMsg.ScanTranslationRender", "can not find suitable swatch");
            f7 = ae.f(bitmap, bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.o(81471);
            return f7;
        }
        f7 = new int[]{bVar.XI.XR, bVar.XI.fS()};
        AppMethodBeat.o(81471);
        return f7;
    }

    static /* synthetic */ float a(cit cit) {
        AppMethodBeat.i(81472);
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Style.FILL);
        textPaint.setTextSize(16.0f);
        DynamicLayout dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        while (dynamicLayout.getLineBottom(dynamicLayout.getLineCount() - 1) < cit.Height) {
            textPaint.setTextSize(textPaint.getTextSize() + 0.5f);
            ab.d("MicroMsg.ScanTranslationRender", "try bigger text size %f", Float.valueOf(textPaint.getTextSize()));
            dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        }
        while (dynamicLayout.getLineBottom(dynamicLayout.getLineCount() - 1) > cit.Height && textPaint.getTextSize() > 1.0f) {
            textPaint.setTextSize(textPaint.getTextSize() - 0.5f);
            ab.d("MicroMsg.ScanTranslationRender", "try smaller text size %f", Float.valueOf(textPaint.getTextSize()));
            dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        }
        float textSize = textPaint.getTextSize();
        AppMethodBeat.o(81472);
        return textSize;
    }

    static /* synthetic */ void a(float f, int i, cit cit, Canvas canvas) {
        AppMethodBeat.i(81473);
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Style.FILL);
        textPaint.setColor(i);
        textPaint.setTextSize(f);
        textPaint.setAntiAlias(true);
        ab.i("MicroMsg.ScanTranslationRender", "alignment %d", Integer.valueOf(cit.xhI));
        DynamicLayout dynamicLayout = new DynamicLayout(cit.wIG, textPaint, cit.Width, cit.xhI == 2 ? Alignment.ALIGN_CENTER : Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        canvas.save();
        ab.i("MicroMsg.ScanTranslationRender", "translate %d, %d, textHeight %d, rect Height %d", Integer.valueOf(cit.X), Integer.valueOf(cit.Y), Integer.valueOf(dynamicLayout.getHeight()), Integer.valueOf(cit.Height));
        if (dynamicLayout.getHeight() < cit.Height) {
            canvas.translate((float) cit.X, (float) (cit.Y + ((cit.Height - dynamicLayout.getHeight()) / 2)));
        } else {
            canvas.translate((float) cit.X, (float) cit.Y);
        }
        dynamicLayout.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(81473);
    }
}
