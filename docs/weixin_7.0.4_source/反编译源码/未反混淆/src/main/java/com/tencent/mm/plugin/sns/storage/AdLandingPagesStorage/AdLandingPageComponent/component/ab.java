package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public final class ab extends h {
    private static final int rbX = Color.parseColor("#26eae9e2");
    private CountDownLatch countDownLatch = new CountDownLatch(2);
    private Bitmap maskBitmap;
    private RadarChart rbY;
    private Bitmap rbZ;

    static {
        AppMethodBeat.i(37358);
        AppMethodBeat.o(37358);
    }

    public ab(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab abVar, ViewGroup viewGroup) {
        super(context, abVar, viewGroup);
        AppMethodBeat.i(37351);
        AppMethodBeat.o(37351);
    }

    public final void cpk() {
        AppMethodBeat.i(37352);
        this.rbY = (RadarChart) this.contentView.findViewById(R.id.efa);
        AppMethodBeat.o(37352);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.i(37353);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(37353);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37354);
        d.h(new Runnable() {
            public final void run() {
                AppMethodBeat.i(37346);
                try {
                    ab.this.countDownLatch.await();
                } catch (InterruptedException e) {
                }
                if (!(ab.this.rbZ == null || ab.this.maskBitmap == null)) {
                    ab.this.contentView.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37345);
                            ab.a(ab.this, ab.this.rbZ, ab.this.maskBitmap);
                            AppMethodBeat.o(37345);
                        }
                    });
                }
                AppMethodBeat.o(37346);
            }
        }, "AdlandingRadarComp").start();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab abVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab) cpB();
        if (abVar != null) {
            h.a(abVar.qXx, abVar.qWP, new a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.i(37347);
                    ab.this.rbZ = null;
                    ab.this.countDownLatch.countDown();
                    AppMethodBeat.o(37347);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37348);
                    try {
                        ab.this.rbZ = MMBitmapFactory.decodeFile(str);
                        ab.this.countDownLatch.countDown();
                        AppMethodBeat.o(37348);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.ab.e("AdlandingRadarChartComp", "%s" + bo.l(e));
                        AppMethodBeat.o(37348);
                    }
                }
            });
            h.a(abVar.qXD, abVar.qWP, new a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.i(37349);
                    ab.this.maskBitmap = null;
                    ab.this.countDownLatch.countDown();
                    AppMethodBeat.o(37349);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37350);
                    try {
                        ab.this.maskBitmap = MMBitmapFactory.decodeFile(str);
                        ab.this.countDownLatch.countDown();
                        AppMethodBeat.o(37350);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.ab.e("AdlandingRadarChartComp", "%s" + bo.l(e));
                        AppMethodBeat.o(37350);
                    }
                }
            });
            cpq();
            AppMethodBeat.o(37354);
            return;
        }
        Log.wtf("AdlandingRadarChartComp", "null info");
        AppMethodBeat.o(37354);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au0;
    }

    public final void coZ() {
        AppMethodBeat.i(37355);
        super.coZ();
        this.countDownLatch.countDown();
        this.countDownLatch.countDown();
        AppMethodBeat.o(37355);
    }

    private static void a(Spannable spannable, int i, int i2, Object... objArr) {
        AppMethodBeat.i(37356);
        for (int i3 = 0; i3 < 2; i3++) {
            spannable.setSpan(objArr[i3], i, i2, 18);
        }
        AppMethodBeat.o(37356);
    }

    static /* synthetic */ void a(ab abVar, Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.i(37357);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab abVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab) abVar.cpB();
        RadarChart radarChart = abVar.rbY;
        radarChart.qYs = 0;
        radarChart.qYu = null;
        radarChart.qYl = null;
        radarChart.qYj = null;
        abVar.rbY.setLatitudeNum(5);
        c cVar = new c();
        cVar.qXO = 0;
        int parseColor = Color.parseColor(abVar2.qXy);
        int i = 1442840575 & parseColor;
        parseColor &= BaseClientBuilder.API_PRIORITY_OTHER;
        cVar.backgroundColor = i;
        cVar.qXT = rbX;
        cVar.qXX = 1.0f;
        cVar.qYi = bitmap2;
        cVar.qXU = rbX;
        cVar.qXV = rbX;
        cVar.qXW = (float) com.tencent.mm.bz.a.fromDPToPix(abVar.context, 1);
        cVar.qXY = -1;
        cVar.qYa = 30.0f;
        cVar.qXZ = 40.0f;
        cVar.qYe = bitmap;
        cVar.qYf = abVar2.borderWidth;
        cVar.qYg = Color.parseColor("#7feae9e2");
        cVar.qYh = com.tencent.mm.bz.a.fromDPToPix(abVar.context, 1);
        abVar.rbY.setGridStyle(cVar);
        b bVar = new b();
        bVar.qXI = rbX;
        bVar.qXJ = 1.0f;
        bVar.qXK = parseColor;
        bVar.qXL = com.tencent.view.d.MIC_SketchMark;
        bVar.qXM = Color.parseColor("#00fcff");
        bVar.qXN = com.tencent.mm.bz.a.fromDPToPix(abVar.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(abVar2.qXz);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(abVar2.qXB);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(abVar2.qXA);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(abVar2.qXC);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a(bVar);
        StringBuilder stringBuilder = new StringBuilder();
        for (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab.a aVar2 : abVar2.itemList) {
            if (aVar2 != null) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(aVar2.label).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(aVar2.qXE);
                SpannableString spannableString = new SpannableString(stringBuilder.toString());
                a(spannableString, 0, aVar2.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                a(spannableString, aVar2.label.length() + 1, stringBuilder.length(), foregroundColorSpan2, absoluteSizeSpan2);
                aVar.put(spannableString, Float.valueOf(aVar2.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        try {
            abVar.rbY.setData((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[]) arrayList.toArray(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[arrayList.size()]));
        } catch (Exception e) {
            Log.getStackTraceString(e);
        }
        abVar.rbY.qYr = 2;
        AppMethodBeat.o(37357);
    }
}
