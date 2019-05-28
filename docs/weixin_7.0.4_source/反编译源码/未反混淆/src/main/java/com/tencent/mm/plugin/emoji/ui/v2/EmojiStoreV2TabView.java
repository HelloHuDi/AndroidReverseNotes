package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView extends RelativeLayout {
    private int lfN;
    private int lfO = 0;
    private Bitmap lfP;
    private LinearLayout lfQ;
    private ImageView lfR;
    private MMTabView lfS;
    private MMTabView lfT;
    private a lfU;
    protected OnClickListener lfV = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53798);
            int intValue = ((Integer) view.getTag()).intValue();
            if (EmojiStoreV2TabView.this.lfU != null) {
                EmojiStoreV2TabView.this.lfU.onTabClick(intValue);
            }
            AppMethodBeat.o(53798);
        }
    };
    c<cw> lfW = new c<cw>() {
        {
            AppMethodBeat.i(53800);
            this.xxI = cw.class.getName().hashCode();
            AppMethodBeat.o(53800);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53801);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(53799);
                    try {
                        if (EmojiStoreV2TabView.this.lfS != null) {
                            if (j.getEmojiStorageMgr().dta()) {
                                EmojiStoreV2TabView.this.lfS.setText((int) R.string.bax);
                                AppMethodBeat.o(53799);
                                return;
                            }
                            EmojiStoreV2TabView.this.lfS.setText((int) R.string.baw);
                        }
                        AppMethodBeat.o(53799);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2TabView", e, "event update error", new Object[0]);
                        AppMethodBeat.o(53799);
                    }
                }
            });
            AppMethodBeat.o(53801);
            return false;
        }
    };
    private Matrix mMatrix = new Matrix();

    public interface a {
        void onTabClick(int i);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53802);
        init();
        AppMethodBeat.o(53802);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53803);
        init();
        AppMethodBeat.o(53803);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(53804);
        super.onLayout(z, i, i2, i3, i4);
        this.lfN = (i3 - i) / 2;
        int i5 = this.lfN;
        if ((this.lfP == null || this.lfP.getWidth() != i5) && i5 > 0) {
            String str = "MicroMsg.emoji.EmojiStoreV2TabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.lfP == null ? -1 : this.lfP.getWidth());
            objArr[1] = Integer.valueOf(i5);
            ab.w(str, str2, objArr);
            this.lfP = Bitmap.createBitmap(i5, com.tencent.mm.bz.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.lfP).drawColor(getResources().getColor(R.color.a61));
            l(this.lfO, 0.0f);
            this.lfR.setImageBitmap(this.lfP);
        }
        setTo(this.lfO);
        AppMethodBeat.o(53804);
    }

    private void init() {
        AppMethodBeat.i(53805);
        bmo();
        bmp();
        bmq();
        bmr();
        AppMethodBeat.o(53805);
    }

    private void bmo() {
        AppMethodBeat.i(53806);
        this.lfQ = new LinearLayout(getContext());
        this.lfQ.setBackgroundResource(R.color.a69);
        this.lfQ.setId(R.id.aq);
        this.lfQ.setOrientation(0);
        addView(this.lfQ, new LayoutParams(-1, -2));
        AppMethodBeat.o(53806);
    }

    private void bmp() {
        AppMethodBeat.i(53807);
        this.lfR = new ImageView(getContext());
        this.lfR.setImageMatrix(this.mMatrix);
        this.lfR.setScaleType(ScaleType.MATRIX);
        this.lfR.setId(R.id.ar);
        LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.id.aq);
        addView(this.lfR, layoutParams);
        AppMethodBeat.o(53807);
    }

    private void bmq() {
        AppMethodBeat.i(53808);
        this.lfS = ul(0);
        if (j.getEmojiStorageMgr().dta()) {
            this.lfS.setText((int) R.string.bax);
        } else {
            this.lfS.setText((int) R.string.baw);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.lfS, layoutParams);
        AppMethodBeat.o(53808);
    }

    private void bmr() {
        AppMethodBeat.i(53809);
        this.lfT = ul(1);
        this.lfT.setText((int) R.string.bb4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.lfT, layoutParams);
        AppMethodBeat.o(53809);
    }

    private MMTabView ul(int i) {
        AppMethodBeat.i(53810);
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.lfV);
        AppMethodBeat.o(53810);
        return mMTabView;
    }

    public void setOnTabClickListener(a aVar) {
        this.lfU = aVar;
    }

    public int getCurentIndex() {
        return this.lfO;
    }

    public final void l(int i, float f) {
        AppMethodBeat.i(53811);
        this.mMatrix.setTranslate(((float) this.lfN) * (((float) i) + f), 0.0f);
        this.lfR.setImageMatrix(this.mMatrix);
        AppMethodBeat.o(53811);
    }

    public void setTo(int i) {
        AppMethodBeat.i(53812);
        this.lfO = i;
        this.lfS.setTextColor(this.lfO == 0 ? getResources().getColorStateList(R.color.a61) : getResources().getColorStateList(R.color.a7k));
        this.lfT.setTextColor(this.lfO == 1 ? getResources().getColorStateList(R.color.a61) : getResources().getColorStateList(R.color.a7k));
        AppMethodBeat.o(53812);
    }

    public void setPersonTabUnReadCount(String str) {
        AppMethodBeat.i(53813);
        if (this.lfT != null) {
            this.lfT.setUnread(str);
        }
        AppMethodBeat.o(53813);
    }

    public final void gz(boolean z) {
        AppMethodBeat.i(53814);
        if (this.lfT != null) {
            this.lfT.pR(z);
        }
        AppMethodBeat.o(53814);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bms() {
        AppMethodBeat.i(53815);
        com.tencent.mm.sdk.b.a.xxA.c(this.lfW);
        AppMethodBeat.o(53815);
    }
}
