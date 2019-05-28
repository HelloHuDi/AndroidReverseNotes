package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21937ab;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21937ab.C21938a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C13431a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C29063b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C39764c;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab */
public final class C46227ab extends C13437h {
    private static final int rbX = Color.parseColor("#26eae9e2");
    private CountDownLatch countDownLatch = new CountDownLatch(2);
    private Bitmap maskBitmap;
    private RadarChart rbY;
    private Bitmap rbZ;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab$1 */
    class C219441 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab$1$1 */
        class C134341 implements Runnable {
            C134341() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37345);
                C46227ab.m86461a(C46227ab.this, C46227ab.this.rbZ, C46227ab.this.maskBitmap);
                AppMethodBeat.m2505o(37345);
            }
        }

        C219441() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37346);
            try {
                C46227ab.this.countDownLatch.await();
            } catch (InterruptedException e) {
            }
            if (!(C46227ab.this.rbZ == null || C46227ab.this.maskBitmap == null)) {
                C46227ab.this.contentView.post(new C134341());
            }
            AppMethodBeat.m2505o(37346);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab$2 */
    class C435632 implements C3951a {
        C435632() {
        }

        public final void cpu() {
        }

        public final void cmD() {
            AppMethodBeat.m2504i(37347);
            C46227ab.this.rbZ = null;
            C46227ab.this.countDownLatch.countDown();
            AppMethodBeat.m2505o(37347);
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37348);
            try {
                C46227ab.this.rbZ = MMBitmapFactory.decodeFile(str);
                C46227ab.this.countDownLatch.countDown();
                AppMethodBeat.m2505o(37348);
            } catch (Exception e) {
                C4990ab.m7412e("AdlandingRadarChartComp", "%s" + C5046bo.m7574l(e));
                AppMethodBeat.m2505o(37348);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab$3 */
    class C435643 implements C3951a {
        C435643() {
        }

        public final void cpu() {
        }

        public final void cmD() {
            AppMethodBeat.m2504i(37349);
            C46227ab.this.maskBitmap = null;
            C46227ab.this.countDownLatch.countDown();
            AppMethodBeat.m2505o(37349);
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37350);
            try {
                C46227ab.this.maskBitmap = MMBitmapFactory.decodeFile(str);
                C46227ab.this.countDownLatch.countDown();
                AppMethodBeat.m2505o(37350);
            } catch (Exception e) {
                C4990ab.m7412e("AdlandingRadarChartComp", "%s" + C5046bo.m7574l(e));
                AppMethodBeat.m2505o(37350);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(37358);
        AppMethodBeat.m2505o(37358);
    }

    public C46227ab(Context context, C21937ab c21937ab, ViewGroup viewGroup) {
        super(context, c21937ab, viewGroup);
        AppMethodBeat.m2504i(37351);
        AppMethodBeat.m2505o(37351);
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37352);
        this.rbY = (RadarChart) this.contentView.findViewById(2131827621);
        AppMethodBeat.m2505o(37352);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.m2504i(37353);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(37353);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37354);
        C7305d.m12301h(new C219441(), "AdlandingRadarComp").start();
        C21937ab c21937ab = (C21937ab) cpB();
        if (c21937ab != null) {
            C13473h.m21619a(c21937ab.qXx, c21937ab.qWP, new C435632());
            C13473h.m21619a(c21937ab.qXD, c21937ab.qWP, new C435643());
            cpq();
            AppMethodBeat.m2505o(37354);
            return;
        }
        Log.wtf("AdlandingRadarChartComp", "null info");
        AppMethodBeat.m2505o(37354);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970716;
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37355);
        super.coZ();
        this.countDownLatch.countDown();
        this.countDownLatch.countDown();
        AppMethodBeat.m2505o(37355);
    }

    /* renamed from: a */
    private static void m86460a(Spannable spannable, int i, int i2, Object... objArr) {
        AppMethodBeat.m2504i(37356);
        for (int i3 = 0; i3 < 2; i3++) {
            spannable.setSpan(objArr[i3], i, i2, 18);
        }
        AppMethodBeat.m2505o(37356);
    }

    /* renamed from: a */
    static /* synthetic */ void m86461a(C46227ab c46227ab, Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.m2504i(37357);
        C21937ab c21937ab = (C21937ab) c46227ab.cpB();
        RadarChart radarChart = c46227ab.rbY;
        radarChart.qYs = 0;
        radarChart.qYu = null;
        radarChart.qYl = null;
        radarChart.qYj = null;
        c46227ab.rbY.setLatitudeNum(5);
        C39764c c39764c = new C39764c();
        c39764c.qXO = 0;
        int parseColor = Color.parseColor(c21937ab.qXy);
        int i = 1442840575 & parseColor;
        parseColor &= BaseClientBuilder.API_PRIORITY_OTHER;
        c39764c.backgroundColor = i;
        c39764c.qXT = rbX;
        c39764c.qXX = 1.0f;
        c39764c.qYi = bitmap2;
        c39764c.qXU = rbX;
        c39764c.qXV = rbX;
        c39764c.qXW = (float) C1338a.fromDPToPix(c46227ab.context, 1);
        c39764c.qXY = -1;
        c39764c.qYa = 30.0f;
        c39764c.qXZ = 40.0f;
        c39764c.qYe = bitmap;
        c39764c.qYf = c21937ab.borderWidth;
        c39764c.qYg = Color.parseColor("#7feae9e2");
        c39764c.qYh = C1338a.fromDPToPix(c46227ab.context, 1);
        c46227ab.rbY.setGridStyle(c39764c);
        C29063b c29063b = new C29063b();
        c29063b.qXI = rbX;
        c29063b.qXJ = 1.0f;
        c29063b.qXK = parseColor;
        c29063b.qXL = C31128d.MIC_SketchMark;
        c29063b.qXM = Color.parseColor("#00fcff");
        c29063b.qXN = C1338a.fromDPToPix(c46227ab.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(c21937ab.qXz);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(c21937ab.qXB);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(c21937ab.qXA);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(c21937ab.qXC);
        C13431a c13431a = new C13431a(c29063b);
        StringBuilder stringBuilder = new StringBuilder();
        for (C21938a c21938a : c21937ab.itemList) {
            if (c21938a != null) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(c21938a.label).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c21938a.qXE);
                SpannableString spannableString = new SpannableString(stringBuilder.toString());
                C46227ab.m86460a(spannableString, 0, c21938a.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                C46227ab.m86460a(spannableString, c21938a.label.length() + 1, stringBuilder.length(), foregroundColorSpan2, absoluteSizeSpan2);
                c13431a.put(spannableString, Float.valueOf(c21938a.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c13431a);
        try {
            c46227ab.rbY.setData((C13431a[]) arrayList.toArray(new C13431a[arrayList.size()]));
        } catch (Exception e) {
            Log.getStackTraceString(e);
        }
        c46227ab.rbY.qYr = 2;
        AppMethodBeat.m2505o(37357);
    }
}
