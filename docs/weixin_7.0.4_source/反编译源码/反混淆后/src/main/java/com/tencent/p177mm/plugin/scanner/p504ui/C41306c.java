package com.tencent.p177mm.plugin.scanner.p504ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C6535pp;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.util.C21730k;
import com.tencent.p177mm.plugin.scanner.util.C3771b;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.protocal.protobuf.C23412la;
import com.tencent.p177mm.protocal.protobuf.C30200lb;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.scanner.ui.c */
public abstract class C41306c extends C13161i implements C3772a {
    private long qaM;
    int qaN;
    private HighlightRectSideView qaO;
    C1207m qaP;
    private C44275p qaQ;
    private C5653c qaR;

    /* renamed from: a */
    public abstract C3771b mo55448a(C3772a c3772a);

    public abstract float cgK();

    public abstract String cgL();

    public abstract int cgM();

    public C41306c(C13164b c13164b, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(c13164b, point);
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
        mo25196fd(point3.x, point3.y);
        if (C5046bo.m7553gO(c13164b.getContext()) < 100) {
            C4990ab.m7420w("MicroMsg.BaseScanModeLicence", "memory is not much");
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
    public final C3771b cgO() {
        if (this.qen == null) {
            this.qen = mo55448a(this);
        }
        return this.qen;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return 2130970547;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dw */
    public final void mo25192dw(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(2131827211);
            if (textView != null) {
                textView.setText(view.getContext().getString(C25738R.string.dxy, new Object[]{view.getContext().getString(cgM())}));
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
    /* renamed from: j */
    public final void mo8429j(Rect rect) {
        C4990ab.m7411d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", rect);
        HighlightRectSideView highlightRectSideView = (HighlightRectSideView) this.qet.findViewById(2131827210);
        if (highlightRectSideView != null) {
            highlightRectSideView.setMaskRect(rect);
        }
        this.qaO = highlightRectSideView;
    }

    /* renamed from: b */
    public void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        C4990ab.m7410d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
        Bitmap bitmap = ((C21730k) this.qen).qir;
        final String cgL = cgL();
        if (this.qaQ != null) {
            this.qaQ.dismiss();
        }
        Context context = this.qet.getContext();
        context.getString(C25738R.string.f9238tz);
        this.qaQ = C30379h.m48458b(context, context.getString(C25738R.string.dy3), false, null);
        this.qaQ.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                AppMethodBeat.m2504i(80908);
                if (i == 4 && keyEvent.getAction() == 1) {
                    C41306c.m71952a(C41306c.this, cgL);
                    AppMethodBeat.m2505o(80908);
                    return true;
                }
                AppMethodBeat.m2505o(80908);
                return false;
            }
        });
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23412la();
        c1196a.fsK = new C30200lb();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
        c1196a.fsI = 1803;
        C7472b acD = c1196a.acD();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream)) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (C5046bo.m7540cb(toByteArray)) {
                m71950C(2, cgL, "");
                return;
            }
            C23412la c23412la = (C23412la) acD.fsG.fsP;
            c23412la.vOx = new C1332b(toByteArray);
            if (cgL.equals("driving")) {
                c23412la.vOw = 0;
            } else if (cgL.equals("identity")) {
                c23412la.vOw = 1;
            }
            this.qaP = C1226w.m2655a(acD, new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(80907);
                    C4990ab.m7417i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
                    C41306c c41306c = C41306c.this;
                    c41306c.qaN++;
                    C41306c.this.m71950C(i2, cgL, ((C30200lb) c7472b.fsH.fsP).vOy);
                    AppMethodBeat.m2505o(80907);
                    return 0;
                }
            }, false);
            return;
        }
        m71950C(2, cgL, "");
    }

    /* renamed from: jJ */
    public final void mo8430jJ(long j) {
        C4990ab.m7410d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.BaseScanModeLicence", "ui callback is null");
        } else {
            cgU();
        }
    }

    private void cgU() {
        this.qaO.setShowRectEdges(((C21730k) this.qen).cih());
        this.qet.mo25214jK(this.qaM);
    }

    /* renamed from: C */
    private void m71950C(int i, String str, String str2) {
        C4883b c6535pp;
        C4883b c6535pp2;
        if (i == 0) {
            c6535pp = new C6535pp();
            c6535pp.cLM.cardType = str;
            c6535pp.cLM.cLN = 1;
            c6535pp.cLM.cLO = str2;
            if (this.qen instanceof C21730k) {
                c6535pp.cLM.cLP = ((C21730k) this.qen).qir;
            }
            C4879a.xxA.mo10048a(c6535pp, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else if ((i & 2) > 0 && (i & 1) > 0) {
            c6535pp2 = new C6535pp();
            c6535pp2.cLM.cardType = str;
            c6535pp2.cLM.cLN = 0;
            c6535pp2.cLM.cLO = str2;
            C4879a.xxA.mo10048a(c6535pp2, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else if (this.qaN >= 3) {
            c6535pp = new C6535pp();
            c6535pp.cLM.cardType = str;
            c6535pp.cLM.cLN = 1;
            c6535pp.cLM.cLO = str2;
            if (this.qen instanceof C21730k) {
                c6535pp.cLM.cLP = ((C21730k) this.qen).qir;
            }
            C4879a.xxA.mo10048a(c6535pp, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else if ((i & 1) <= 0 || this.qaN >= 3) {
            c6535pp2 = new C6535pp();
            c6535pp2.cLM.cardType = str;
            c6535pp2.cLM.cLN = 0;
            c6535pp2.cLM.cLO = str2;
            C4879a.xxA.mo10048a(c6535pp2, Looper.getMainLooper());
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            this.qet.getContext().finish();
        } else {
            if (this.qaQ != null) {
                this.qaQ.dismiss();
            }
            cgO().chP();
            m71949BW(i);
            cgU();
        }
    }

    /* renamed from: BW */
    private void m71949BW(int i) {
        int i2;
        if ((i & 32) > 0) {
            i2 = C25738R.string.dy1;
        } else if ((i & 64) > 0) {
            i2 = C25738R.string.dy2;
        } else {
            i2 = C25738R.string.dy0;
        }
        Toast.makeText(this.qet.getContext(), i2, 0).show();
    }

    /* renamed from: K */
    public final void mo8420K(Bundle bundle) {
    }

    /* renamed from: a */
    static /* synthetic */ void m71952a(C41306c c41306c, final String str) {
        if (c41306c.qaR != null) {
            c41306c.qaR.dismiss();
        }
        c41306c.qaR = C30379h.m48432a(c41306c.qet.getContext(), (int) C25738R.string.dxz, (int) C25738R.string.f9238tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(80909);
                C1720g.m3540Rg().mo14547c(C41306c.this.qaP);
                C6535pp c6535pp = new C6535pp();
                c6535pp.cLM.cardType = str;
                c6535pp.cLM.cLN = 2;
                C4879a.xxA.mo10055m(c6535pp);
                C41306c.this.qet.getContext().finish();
                AppMethodBeat.m2505o(80909);
            }
        }, null);
    }
}
