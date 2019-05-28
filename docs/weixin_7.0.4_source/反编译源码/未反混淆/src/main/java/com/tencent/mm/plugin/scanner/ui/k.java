package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class k extends i implements f, a {
    private static int qeG = 300;
    private int ctE;
    private TextView qbp;
    private View qbq;
    private long qeH = 130;
    h qeI;
    private int qeJ = 0;
    private int qeK = 1;
    private long qeL;
    private final int qeM = 300;
    private final int qeN = 400;
    private final long qeO = 30000;
    private long qeP;
    private final int qeQ = 50;
    private e.a qeR = new e.a() {
        public final void o(int i, Bundle bundle) {
            AppMethodBeat.i(81166);
            switch (i) {
                case 0:
                    AppMethodBeat.o(81166);
                    return;
                case 1:
                    AppMethodBeat.o(81166);
                    return;
                case 2:
                    AppMethodBeat.o(81166);
                    return;
                case 3:
                    k.this.qet.chi();
                    break;
            }
            AppMethodBeat.o(81166);
        }
    };
    private OnTouchListener qeS;

    public k(b bVar, Point point) {
        super(bVar, point);
        AppMethodBeat.i(81169);
        fd(300, 400);
        ab.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s]", Integer.valueOf(this.qep), Integer.valueOf(this.qeq));
        if (bo.gO(bVar.getContext()) < 100) {
            ab.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
            this.qeH = 300;
        }
        this.ctE = (int) (System.currentTimeMillis() & -1);
        this.qeP = System.currentTimeMillis();
        AppMethodBeat.o(81169);
    }

    /* Access modifiers changed, original: protected|final */
    public final void j(Rect rect) {
        AppMethodBeat.i(81170);
        this.qbq = this.qet.findViewById(R.id.e4q);
        this.qbp = (TextView) this.qet.findViewById(R.id.e4r);
        this.iqU = (TextView) this.qet.findViewById(R.id.e56);
        this.iqU.setText(r.fT(r.qiR, this.qet.getContext().getString(R.string.dxw)));
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
        }
        if (d.Lt()) {
            this.iqU.setPadding(BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.iqU.getPaddingTop(), BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.iqU.getPaddingBottom());
        }
        if (this.qen != null) {
            ((j) this.qen).ovx = this.qet.chh();
        }
        chv();
        kl(true);
        AppMethodBeat.o(81170);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.i(81171);
        j(new Rect(0, 0, 0, 0));
        this.qet.b(4, null);
        onResume();
        AppMethodBeat.o(81171);
    }

    /* Access modifiers changed, original: protected|final */
    public final void kn(boolean z) {
        AppMethodBeat.i(81172);
        super.kn(z);
        if (this.qen != null) {
            ((j) this.qen).ovx = z;
        }
        AppMethodBeat.o(81172);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return R.layout.ape;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.scanner.util.b cgO() {
        AppMethodBeat.i(81173);
        if (this.qen == null) {
            int i = 50;
            if (q.etc.erl > 0) {
                i = q.etc.erl;
                ab.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", Integer.valueOf(q.etc.erl));
            }
            if (at.is2G(this.qet.getContext())) {
                this.qen = new j(this, i - 10, false, this.qet.chh());
            } else {
                this.qen = new j(this, i, false, this.qet.chh());
            }
        }
        com.tencent.mm.plugin.scanner.util.b bVar = this.qen;
        AppMethodBeat.o(81173);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.i(81174);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.o(81174);
            return;
        }
        chv();
        AppMethodBeat.o(81174);
    }

    private void chv() {
        AppMethodBeat.i(81175);
        if (this.qet == null) {
            ab.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.o(81175);
            return;
        }
        if (g.Rg().acS() == 6 || g.Rg().acS() == 4) {
            this.qet.jL(0);
        }
        AppMethodBeat.o(81175);
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(81176);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.o(81176);
        } else if (bArr2 == null || bArr2.length <= 0) {
            ab.w("MicroMsg.scanner.ScanModeImage", "greyData null");
            if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((j) this.qen).qin) {
                this.qet.jK(this.qeH);
                AppMethodBeat.o(81176);
                return;
            }
            this.qeL = System.currentTimeMillis();
            this.qet.jL(0);
            AppMethodBeat.o(81176);
        } else {
            chw();
            if (this.qeJ >= this.qeK) {
                ab.i("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
                this.qet.jK(this.qeH);
                if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((j) this.qen).qin) {
                    this.qet.jK(this.qeH);
                    AppMethodBeat.o(81176);
                    return;
                }
                this.qeL = System.currentTimeMillis();
                this.qet.jL(0);
                AppMethodBeat.o(81176);
                return;
            }
            this.qeI = new h(bArr2, bArr2.length, this.ctE);
            g.Rg().a(this.qeI, 0);
            this.qeJ++;
            this.qeu += bArr2.length;
            ab.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", Integer.valueOf(this.qeu));
            if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((j) this.qen).qin) {
                this.qet.jK(this.qeH);
                AppMethodBeat.o(81176);
                return;
            }
            this.qeL = System.currentTimeMillis();
            this.qet.jL(0);
            AppMethodBeat.o(81176);
        }
    }

    public final void jJ(long j) {
        AppMethodBeat.i(81177);
        ab.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.o(81177);
            return;
        }
        chw();
        if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((j) this.qen).qin) {
            this.qet.jK(this.qeH);
            AppMethodBeat.o(81177);
            return;
        }
        this.qeL = System.currentTimeMillis();
        this.qet.jL(0);
        AppMethodBeat.o(81177);
    }

    private void chw() {
        AppMethodBeat.i(81178);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(81168);
                if (System.currentTimeMillis() - k.this.qeP > 30000) {
                    ab.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
                    k.this.qet.kj(true);
                    k.this.iqU.setVisibility(8);
                    k.this.qbp.setText(R.string.dxu);
                    k.this.qbp.setVisibility(0);
                    if (k.this.qeS == null) {
                        k.this.qeS = new OnTouchListener() {
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                AppMethodBeat.i(81167);
                                k.this.qet.kj(false);
                                k.this.iqU.setVisibility(0);
                                k.this.iqU.setText(r.fT(r.qiR, k.this.qet.getContext().getString(R.string.dxw)));
                                k.this.qbp.setVisibility(8);
                                k.this.qeP = System.currentTimeMillis();
                                AppMethodBeat.o(81167);
                                return false;
                            }
                        };
                    }
                    k.this.qbq.setOnTouchListener(k.this.qeS);
                }
                AppMethodBeat.o(81168);
            }
        });
        AppMethodBeat.o(81178);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81179);
        this.qeJ = 0;
        if (this.qet == null || mVar == null) {
            String str2 = "MicroMsg.scanner.ScanModeImage";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(mVar == null);
            ab.e(str2, str3, objArr);
            AppMethodBeat.o(81179);
            return;
        }
        if (mVar.getType() == FilterEnum4Shaka.MIC_WEISHI_HUAYE) {
            if (i == 0 && i2 == 0) {
                kz kzVar;
                this.qeJ = this.qeK;
                h hVar = (h) mVar;
                if (hVar.ehh == null || hVar.ehh.fsH.fsP == null) {
                    kzVar = null;
                } else {
                    kzVar = (kz) hVar.ehh.fsH.fsP;
                }
                if (kzVar != null) {
                    ab.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", Integer.valueOf(kzVar.vOn), Integer.valueOf(kzVar.vOr));
                    switch (o.a(kzVar.jCt, kzVar.vOt, this, 3, this.qeR, 0, 0, false)) {
                        case 0:
                            this.qet.cha();
                            if (!(this.qet == null || this.qet.getContext() == null)) {
                                this.qet.chi();
                                break;
                            }
                        case 1:
                            ab.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                            break;
                        case 2:
                            ab.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                            break;
                    }
                }
                ab.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
                AppMethodBeat.o(81179);
                return;
            }
            ab.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
            this.iqU.setText(r.fT(r.qiR, this.qet.getContext().getString(R.string.dxw)));
            if (this.qeI != null) {
                g.Rg().c(this.qeI);
            }
        }
        AppMethodBeat.o(81179);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(81180);
        g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_HUAYE, (f) this);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.o(81180);
            return;
        }
        this.qeJ = 0;
        chv();
        AppMethodBeat.o(81180);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(81181);
        super.onPause();
        kl(false);
        g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_HUAYE, (f) this);
        AppMethodBeat.o(81181);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return qeG;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgS() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgT() {
        return true;
    }

    public final void K(Bundle bundle) {
    }
}
