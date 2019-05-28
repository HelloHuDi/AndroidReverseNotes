package com.tencent.mm.plugin.scanner.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class j extends i implements a {
    private long qaM;
    private long qbE;
    private HighlightRectSideView qeA;
    boolean qeB = false;
    private bk qeC = new bk();
    private OnClickListener qeD = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(81158);
            View inflate = ((LayoutInflater) j.this.qet.getContext().getSystemService("layout_inflater")).inflate(R.layout.ap8, null);
            Context context = j.this.qet.getContext();
            h.a(context, context.getString(R.string.dxb), context.getString(R.string.dxa), inflate, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(81157);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(81157);
                }
            }).show();
            AppMethodBeat.o(81158);
        }
    };

    public j(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(bVar, point);
        AppMethodBeat.i(81159);
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = point2.y - ((int) (118.0f * displayMetrics.density));
        Point point3 = new Point((int) (((float) ((int) (((float) i2) * 1.586f))) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        bVar.getContext().setResult(0);
        this.qer = 0;
        this.qes = 64;
        fd(point3.x, point3.y);
        if (bo.gO(bVar.getContext()) < 100) {
            ab.w("MicroMsg.ScanModeBankCard", "memory is not much");
            this.qaM = 280;
        } else {
            this.qaM = 80;
        }
        bk bkVar = this.qeC;
        bkVar.cVR = 1;
        bkVar.ajK();
        this.qbE = System.currentTimeMillis();
        AppMethodBeat.o(81159);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.i(81160);
        bk bkVar = this.qeC;
        bkVar.cVR = 4;
        bkVar.ajK();
        AppMethodBeat.o(81160);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.scanner.util.b cgO() {
        AppMethodBeat.i(81161);
        if (this.qen == null && this.qet != null) {
            this.qen = new g(this, this.qet.chh(), this.qeB);
        }
        com.tencent.mm.plugin.scanner.util.b bVar = this.qen;
        AppMethodBeat.o(81161);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return R.layout.ap7;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return 300;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void kn(boolean z) {
        AppMethodBeat.i(81162);
        super.kn(z);
        if (!(this.qen == null || this.qet == null)) {
            g gVar = (g) this.qen;
            boolean chh = this.qet.chh();
            ab.d("MicroMsg.ScanBankCardDecoder", "need rotate:".concat(String.valueOf(chh)));
            gVar.qhJ = chh;
        }
        AppMethodBeat.o(81162);
    }

    /* Access modifiers changed, original: protected|final */
    public final void j(Rect rect) {
        String str;
        AppMethodBeat.i(81163);
        LinearLayout linearLayout = (LinearLayout) this.qet.findViewById(R.id.e4j);
        TextView textView = (TextView) this.qet.findViewById(R.id.e4k);
        this.qeA = (HighlightRectSideView) this.qet.findViewById(R.id.e4m);
        this.qeA.setMaskRect(rect);
        Intent intent = this.qet.getContext().getIntent();
        if (intent != null) {
            String bc = bo.bc(intent.getStringExtra("bank_card_owner"), "");
            textView.setText(String.format(this.qet.getContext().getResources().getString(R.string.dxd), new Object[]{bc}));
            str = bc;
        } else {
            str = null;
        }
        if (bo.isNullOrNil(str)) {
            linearLayout.setVisibility(8);
            AppMethodBeat.o(81163);
            return;
        }
        linearLayout.setVisibility(0);
        ((ImageView) this.qet.findViewById(R.id.e4l)).setOnClickListener(this.qeD);
        AppMethodBeat.o(81163);
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(81164);
        ab.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", Integer.valueOf(i));
        if (3 != i) {
            ab.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:".concat(String.valueOf(i)));
            AppMethodBeat.o(81164);
            return;
        }
        bk bkVar = this.qeC;
        bkVar.cVR = 2;
        bkVar.dco = System.currentTimeMillis() - this.qbE;
        bkVar.ajK();
        Bitmap chW = ((g) this.qen).chW();
        if (this.qeB) {
            this.qet.chj();
            ConfirmScanBankCardResultUI.c(chW, str);
            AppMethodBeat.o(81164);
            return;
        }
        pn pnVar = new pn();
        pnVar.cLJ.cardId = str;
        pnVar.cLJ.cLK = chW;
        com.tencent.mm.sdk.b.a.xxA.m(pnVar);
        this.qet.getContext().finish();
        AppMethodBeat.o(81164);
    }

    public final void jJ(long j) {
        AppMethodBeat.i(81165);
        ab.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
        if (this.qet == null) {
            ab.e("MicroMsg.ScanModeBankCard", "ui callback is null");
            AppMethodBeat.o(81165);
            return;
        }
        this.qeA.setShowRectEdges(((g) this.qen).qhL);
        this.qet.jK(this.qaM);
        AppMethodBeat.o(81165);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgS() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgT() {
        return false;
    }

    public final void K(Bundle bundle) {
    }
}
