package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.io.ByteArrayOutputStream;

public abstract class c extends i implements a {
    private long qaM;
    int qaN;
    private HighlightRectSideView qaO;
    m qaP;
    private p qaQ;
    private com.tencent.mm.ui.widget.a.c qaR;

    public abstract b a(a aVar);

    public abstract float cgK();

    public abstract String cgL();

    public abstract int cgM();

    public c(i.b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(bVar, point);
        this.qaN = 0;
        this.qaP = null;
        this.qaQ = null;
        this.qaR = null;
        this.qer = 0;
        this.qes = 0;
        float cgK = cgK();
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = (int) (((float) point2.y) * 0.8f);
        int i3 = (int) (((float) point2.x) * 0.8f);
        if (((float) i2) * cgK > ((float) point2.x)) {
            i2 = (int) (((float) i3) / cgK);
        } else {
            i3 = (int) (((float) i2) * cgK);
        }
        Point point3 = new Point((int) (((float) i3) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        this.qes = (int) (((((float) point2.y) / displayMetrics.density) - ((float) point3.y)) / 2.0f);
        fd(point3.x, point3.y);
        if (bo.gO(bVar.getContext()) < 100) {
            ab.w("MicroMsg.BaseScanModeLicence", "memory is not much");
            this.qaM = 280;
            return;
        }
        this.qaM = 80;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
    }

    /* Access modifiers changed, original: protected|final */
    public final b cgO() {
        if (this.qen == null) {
            this.qen = a(this);
        }
        return this.qen;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return R.layout.apf;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void dw(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.e58);
            if (textView != null) {
                textView.setText(view.getContext().getString(R.string.dxy, new Object[]{view.getContext().getString(cgM())}));
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgS() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgT() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void j(Rect rect) {
        ab.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", rect);
        HighlightRectSideView highlightRectSideView = (HighlightRectSideView) this.qet.findViewById(R.id.e57);
        if (highlightRectSideView != null) {
            highlightRectSideView.setMaskRect(rect);
        }
        this.qaO = highlightRectSideView;
    }

    public void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        ab.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
        Bitmap bitmap = ((k) this.qen).qir;
        final String cgL = cgL();
        if (this.qaQ != null) {
            this.qaQ.dismiss();
        }
        Context context = this.qet.getContext();
        context.getString(R.string.tz);
        this.qaQ = h.b(context, context.getString(R.string.dy3), false, null);
        this.qaQ.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(80908);
                if (i == 4 && keyEvent.getAction() == 1) {
                    c.a(c.this, cgL);
                    AppMethodBeat.o(80908);
                    return true;
                }
                AppMethodBeat.o(80908);
                return false;
            }
        });
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new la();
        aVar.fsK = new lb();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
        aVar.fsI = 1803;
        com.tencent.mm.ai.b acD = aVar.acD();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream)) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (bo.cb(toByteArray)) {
                C(2, cgL, "");
                return;
            }
            la laVar = (la) acD.fsG.fsP;
            laVar.vOx = new com.tencent.mm.bt.b(toByteArray);
            if (cgL.equals("driving")) {
                laVar.vOw = 0;
            } else if (cgL.equals("identity")) {
                laVar.vOw = 1;
            }
            this.qaP = w.a(acD, new w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(80907);
                    ab.i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
                    c cVar = c.this;
                    cVar.qaN++;
                    c.this.C(i2, cgL, ((lb) bVar.fsH.fsP).vOy);
                    AppMethodBeat.o(80907);
                    return 0;
                }
            }, false);
            return;
        }
        C(2, cgL, "");
    }

    public final void jJ(long j) {
        ab.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
        if (this.qet == null) {
            ab.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
        } else {
            cgU();
        }
    }

    private void cgU() {
        this.qaO.setShowRectEdges(((k) this.qen).cih());
        this.qet.jK(this.qaM);
    }

    private void C(int i, String str, String str2) {
        com.tencent.mm.sdk.b.b ppVar;
        com.tencent.mm.sdk.b.b ppVar2;
        if (i == 0) {
            ppVar = new pp();
            ppVar.cLM.cardType = str;
            ppVar.cLM.cLN = 1;
            ppVar.cLM.cLO = str2;
            if (this.qen instanceof k) {
                ppVar.cLM.cLP = ((k) this.qen).qir;
            }
            com.tencent.mm.sdk.b.a.xxA.a(ppVar, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else if ((i & 2) > 0 && (i & 1) > 0) {
            ppVar2 = new pp();
            ppVar2.cLM.cardType = str;
            ppVar2.cLM.cLN = 0;
            ppVar2.cLM.cLO = str2;
            com.tencent.mm.sdk.b.a.xxA.a(ppVar2, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else if (this.qaN >= 3) {
            ppVar = new pp();
            ppVar.cLM.cardType = str;
            ppVar.cLM.cLN = 1;
            ppVar.cLM.cLO = str2;
            if (this.qen instanceof k) {
                ppVar.cLM.cLP = ((k) this.qen).qir;
            }
            com.tencent.mm.sdk.b.a.xxA.a(ppVar, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else if ((i & 1) <= 0 || this.qaN >= 3) {
            ppVar2 = new pp();
            ppVar2.cLM.cardType = str;
            ppVar2.cLM.cLN = 0;
            ppVar2.cLM.cLO = str2;
            com.tencent.mm.sdk.b.a.xxA.a(ppVar2, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else {
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            cgO().chP();
            BW(i);
            cgU();
        }
    }

    private void BW(int i) {
        int i2;
        if ((i & 32) > 0) {
            i2 = R.string.dy1;
        } else if ((i & 64) > 0) {
            i2 = R.string.dy2;
        } else {
            i2 = R.string.dy0;
        }
        Toast.makeText(this.qet.getContext(), i2, 0).show();
    }

    public final void K(Bundle bundle) {
    }

    static /* synthetic */ void a(c cVar, final String str) {
        if (cVar.qaR != null) {
            cVar.qaR.dismiss();
        }
        cVar.qaR = h.a(cVar.qet.getContext(), (int) R.string.dxz, (int) R.string.tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(80909);
                g.Rg().c(c.this.qaP);
                pp ppVar = new pp();
                ppVar.cLM.cardType = str;
                ppVar.cLM.cLN = 2;
                com.tencent.mm.sdk.b.a.xxA.m(ppVar);
                c.this.qet.getContext().finish();
                AppMethodBeat.o(80909);
            }
        }, null);
    }
}
