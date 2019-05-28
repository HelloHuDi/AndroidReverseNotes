package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6472cw;
import com.tencent.p177mm.p612ui.MMTabView;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView */
public class EmojiStoreV2TabView extends RelativeLayout {
    private int lfN;
    private int lfO = 0;
    private Bitmap lfP;
    private LinearLayout lfQ;
    private ImageView lfR;
    private MMTabView lfS;
    private MMTabView lfT;
    private C33985a lfU;
    protected OnClickListener lfV = new C115981();
    C4884c<C6472cw> lfW = new C339842();
    private Matrix mMatrix = new Matrix();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView$1 */
    class C115981 implements OnClickListener {
        C115981() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53798);
            int intValue = ((Integer) view.getTag()).intValue();
            if (EmojiStoreV2TabView.this.lfU != null) {
                EmojiStoreV2TabView.this.lfU.onTabClick(intValue);
            }
            AppMethodBeat.m2505o(53798);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView$2 */
    class C339842 extends C4884c<C6472cw> {

        /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView$2$1 */
        class C277861 implements Runnable {
            C277861() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53799);
                try {
                    if (EmojiStoreV2TabView.this.lfS != null) {
                        if (C42952j.getEmojiStorageMgr().dta()) {
                            EmojiStoreV2TabView.this.lfS.setText((int) C25738R.string.bax);
                            AppMethodBeat.m2505o(53799);
                            return;
                        }
                        EmojiStoreV2TabView.this.lfS.setText((int) C25738R.string.baw);
                    }
                    AppMethodBeat.m2505o(53799);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2TabView", e, "event update error", new Object[0]);
                    AppMethodBeat.m2505o(53799);
                }
            }
        }

        C339842() {
            AppMethodBeat.m2504i(53800);
            this.xxI = C6472cw.class.getName().hashCode();
            AppMethodBeat.m2505o(53800);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53801);
            C5004al.m7441d(new C277861());
            AppMethodBeat.m2505o(53801);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView$a */
    public interface C33985a {
        void onTabClick(int i);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(53802);
        init();
        AppMethodBeat.m2505o(53802);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53803);
        init();
        AppMethodBeat.m2505o(53803);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(53804);
        super.onLayout(z, i, i2, i3, i4);
        this.lfN = (i3 - i) / 2;
        int i5 = this.lfN;
        if ((this.lfP == null || this.lfP.getWidth() != i5) && i5 > 0) {
            String str = "MicroMsg.emoji.EmojiStoreV2TabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.lfP == null ? -1 : this.lfP.getWidth());
            objArr[1] = Integer.valueOf(i5);
            C4990ab.m7421w(str, str2, objArr);
            this.lfP = Bitmap.createBitmap(i5, C1338a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.lfP).drawColor(getResources().getColor(C25738R.color.a61));
            mo68497l(this.lfO, 0.0f);
            this.lfR.setImageBitmap(this.lfP);
        }
        setTo(this.lfO);
        AppMethodBeat.m2505o(53804);
    }

    private void init() {
        AppMethodBeat.m2504i(53805);
        bmo();
        bmp();
        bmq();
        bmr();
        AppMethodBeat.m2505o(53805);
    }

    private void bmo() {
        AppMethodBeat.m2504i(53806);
        this.lfQ = new LinearLayout(getContext());
        this.lfQ.setBackgroundResource(C25738R.color.a69);
        this.lfQ.setId(2131820597);
        this.lfQ.setOrientation(0);
        addView(this.lfQ, new LayoutParams(-1, -2));
        AppMethodBeat.m2505o(53806);
    }

    private void bmp() {
        AppMethodBeat.m2504i(53807);
        this.lfR = new ImageView(getContext());
        this.lfR.setImageMatrix(this.mMatrix);
        this.lfR.setScaleType(ScaleType.MATRIX);
        this.lfR.setId(2131820598);
        LayoutParams layoutParams = new LayoutParams(-1, C1338a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2131820597);
        addView(this.lfR, layoutParams);
        AppMethodBeat.m2505o(53807);
    }

    private void bmq() {
        AppMethodBeat.m2504i(53808);
        this.lfS = m76297ul(0);
        if (C42952j.getEmojiStorageMgr().dta()) {
            this.lfS.setText((int) C25738R.string.bax);
        } else {
            this.lfS.setText((int) C25738R.string.baw);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.lfS, layoutParams);
        AppMethodBeat.m2505o(53808);
    }

    private void bmr() {
        AppMethodBeat.m2504i(53809);
        this.lfT = m76297ul(1);
        this.lfT.setText((int) C25738R.string.bb4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.lfT, layoutParams);
        AppMethodBeat.m2505o(53809);
    }

    /* renamed from: ul */
    private MMTabView m76297ul(int i) {
        AppMethodBeat.m2504i(53810);
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.lfV);
        AppMethodBeat.m2505o(53810);
        return mMTabView;
    }

    public void setOnTabClickListener(C33985a c33985a) {
        this.lfU = c33985a;
    }

    public int getCurentIndex() {
        return this.lfO;
    }

    /* renamed from: l */
    public final void mo68497l(int i, float f) {
        AppMethodBeat.m2504i(53811);
        this.mMatrix.setTranslate(((float) this.lfN) * (((float) i) + f), 0.0f);
        this.lfR.setImageMatrix(this.mMatrix);
        AppMethodBeat.m2505o(53811);
    }

    public void setTo(int i) {
        AppMethodBeat.m2504i(53812);
        this.lfO = i;
        this.lfS.setTextColor(this.lfO == 0 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        this.lfT.setTextColor(this.lfO == 1 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        AppMethodBeat.m2505o(53812);
    }

    public void setPersonTabUnReadCount(String str) {
        AppMethodBeat.m2504i(53813);
        if (this.lfT != null) {
            this.lfT.setUnread(str);
        }
        AppMethodBeat.m2505o(53813);
    }

    /* renamed from: gz */
    public final void mo68496gz(boolean z) {
        AppMethodBeat.m2504i(53814);
        if (this.lfT != null) {
            this.lfT.mo10695pR(z);
        }
        AppMethodBeat.m2505o(53814);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bms() {
        AppMethodBeat.m2504i(53815);
        C4879a.xxA.mo10052c(this.lfW);
        AppMethodBeat.m2505o(53815);
    }
}
