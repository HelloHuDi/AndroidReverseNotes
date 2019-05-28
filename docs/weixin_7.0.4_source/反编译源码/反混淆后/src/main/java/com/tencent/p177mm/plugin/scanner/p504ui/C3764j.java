package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C32615pn;
import com.tencent.p177mm.p230g.p232b.p233a.C37824bk;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.util.C3771b;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.plugin.scanner.util.C43493g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.ui.j */
public final class C3764j extends C13161i implements C3772a {
    private long qaM;
    private long qbE;
    private HighlightRectSideView qeA;
    boolean qeB = false;
    private C37824bk qeC = new C37824bk();
    private OnClickListener qeD = new C37651();

    /* renamed from: com.tencent.mm.plugin.scanner.ui.j$1 */
    class C37651 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.j$1$1 */
        class C37661 implements DialogInterface.OnClickListener {
            C37661() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(81157);
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(81157);
            }
        }

        C37651() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81158);
            View inflate = ((LayoutInflater) C3764j.this.qet.getContext().getSystemService("layout_inflater")).inflate(2130970539, null);
            Context context = C3764j.this.qet.getContext();
            C30379h.m48441a(context, context.getString(C25738R.string.dxb), context.getString(C25738R.string.dxa), inflate, new C37661()).show();
            AppMethodBeat.m2505o(81158);
        }
    }

    public C3764j(C13164b c13164b, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(c13164b, point);
        AppMethodBeat.m2504i(81159);
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = point2.y - ((int) (118.0f * displayMetrics.density));
        Point point3 = new Point((int) (((float) ((int) (((float) i2) * 1.586f))) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        c13164b.getContext().setResult(0);
        this.qer = 0;
        this.qes = 64;
        mo25196fd(point3.x, point3.y);
        if (C5046bo.m7553gO(c13164b.getContext()) < 100) {
            C4990ab.m7420w("MicroMsg.ScanModeBankCard", "memory is not much");
            this.qaM = 280;
        } else {
            this.qaM = 80;
        }
        C37824bk c37824bk = this.qeC;
        c37824bk.cVR = 1;
        c37824bk.ajK();
        this.qbE = System.currentTimeMillis();
        AppMethodBeat.m2505o(81159);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.m2504i(81160);
        C37824bk c37824bk = this.qeC;
        c37824bk.cVR = 4;
        c37824bk.ajK();
        AppMethodBeat.m2505o(81160);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
    }

    /* Access modifiers changed, original: protected|final */
    public final C3771b cgO() {
        AppMethodBeat.m2504i(81161);
        if (this.qen == null && this.qet != null) {
            this.qen = new C43493g(this, this.qet.chh(), this.qeB);
        }
        C3771b c3771b = this.qen;
        AppMethodBeat.m2505o(81161);
        return c3771b;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return 2130970538;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return 300;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: kn */
    public final void mo8431kn(boolean z) {
        AppMethodBeat.m2504i(81162);
        super.mo8431kn(z);
        if (!(this.qen == null || this.qet == null)) {
            C43493g c43493g = (C43493g) this.qen;
            boolean chh = this.qet.chh();
            C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "need rotate:".concat(String.valueOf(chh)));
            c43493g.qhJ = chh;
        }
        AppMethodBeat.m2505o(81162);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final void mo8429j(Rect rect) {
        String str;
        AppMethodBeat.m2504i(81163);
        LinearLayout linearLayout = (LinearLayout) this.qet.findViewById(2131827186);
        TextView textView = (TextView) this.qet.findViewById(2131827187);
        this.qeA = (HighlightRectSideView) this.qet.findViewById(2131827189);
        this.qeA.setMaskRect(rect);
        Intent intent = this.qet.getContext().getIntent();
        if (intent != null) {
            String bc = C5046bo.m7532bc(intent.getStringExtra("bank_card_owner"), "");
            textView.setText(String.format(this.qet.getContext().getResources().getString(C25738R.string.dxd), new Object[]{bc}));
            str = bc;
        } else {
            str = null;
        }
        if (C5046bo.isNullOrNil(str)) {
            linearLayout.setVisibility(8);
            AppMethodBeat.m2505o(81163);
            return;
        }
        linearLayout.setVisibility(0);
        ((ImageView) this.qet.findViewById(2131827188)).setOnClickListener(this.qeD);
        AppMethodBeat.m2505o(81163);
    }

    /* renamed from: b */
    public final void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.m2504i(81164);
        C4990ab.m7411d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", Integer.valueOf(i));
        if (3 != i) {
            C4990ab.m7412e("MicroMsg.ScanModeBankCard", "decode success, but result type error:".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(81164);
            return;
        }
        C37824bk c37824bk = this.qeC;
        c37824bk.cVR = 2;
        c37824bk.dco = System.currentTimeMillis() - this.qbE;
        c37824bk.ajK();
        Bitmap chW = ((C43493g) this.qen).chW();
        if (this.qeB) {
            this.qet.chj();
            ConfirmScanBankCardResultUI.m33208c(chW, str);
            AppMethodBeat.m2505o(81164);
            return;
        }
        C32615pn c32615pn = new C32615pn();
        c32615pn.cLJ.cardId = str;
        c32615pn.cLJ.cLK = chW;
        C4879a.xxA.mo10055m(c32615pn);
        this.qet.getContext().finish();
        AppMethodBeat.m2505o(81164);
    }

    /* renamed from: jJ */
    public final void mo8430jJ(long j) {
        AppMethodBeat.m2504i(81165);
        C4990ab.m7410d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.ScanModeBankCard", "ui callback is null");
            AppMethodBeat.m2505o(81165);
            return;
        }
        this.qeA.setShowRectEdges(((C43493g) this.qen).qhL);
        this.qet.mo25214jK(this.qaM);
        AppMethodBeat.m2505o(81165);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgS() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgT() {
        return false;
    }

    /* renamed from: K */
    public final void mo8420K(Bundle bundle) {
    }
}
