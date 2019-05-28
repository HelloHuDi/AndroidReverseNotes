package com.tencent.p177mm.plugin.scanner.p504ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p1177ao.C17912c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45345mv;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.p543u.p544a.C35336b.C4254a;
import com.tencent.p177mm.plugin.p543u.p544a.C4255c.C4261a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13163a;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.p740a.C21682m;
import com.tencent.p177mm.plugin.scanner.p740a.C43483g;
import com.tencent.p177mm.plugin.scanner.util.C13178d;
import com.tencent.p177mm.plugin.scanner.util.C21731m;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.plugin.scanner.util.C3771b;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.plugin.scanner.util.C43494o;
import com.tencent.p177mm.plugin.scanner.util.C46189e.C21729a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35891h;
import com.tencent.p177mm.protocal.protobuf.C30199kx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.plugin.scanner.ui.p */
public final class C16851p extends C13161i implements C1202f, C13163a, C3772a, C4261a {
    int bufferSize;
    Object cli = new Object();
    int cvH = 0;
    private int mMode = 0;
    private int pZN;
    long qeH = 80;
    private C21729a qeR = new C168541();
    C13178d qfd;
    AtomicBoolean qfe = new AtomicBoolean(false);
    boolean qff = false;
    boolean qfg = false;
    private Set<Integer> qfh;
    private float qfi = 1.5f;
    byte[] qfj;
    Point qfk;
    int qfl;
    private TextView qfm;
    boolean qfn = false;
    private OnClickListener qfo = new C168522();

    /* renamed from: com.tencent.mm.plugin.scanner.ui.p$2 */
    class C168522 implements OnClickListener {
        C168522() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81201);
            if (C16851p.this.qet == null) {
                C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
                AppMethodBeat.m2505o(81201);
                return;
            }
            C7060h.pYm.mo8381e(11264, Integer.valueOf(3));
            C28892c.gkE.mo38910bi(C16851p.this.qet.getContext());
            AppMethodBeat.m2505o(81201);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.p$1 */
    class C168541 implements C21729a {
        C168541() {
        }

        /* renamed from: o */
        public final void mo8437o(int i, Bundle bundle) {
            AppMethodBeat.m2504i(81200);
            C4990ab.m7417i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", Integer.valueOf(i));
            switch (i) {
                case 0:
                    C16851p.this.qff = false;
                    AppMethodBeat.m2505o(81200);
                    return;
                case 1:
                    C16851p.this.mo9244jZ(true);
                    AppMethodBeat.m2505o(81200);
                    return;
                case 2:
                    C16851p.this.mo9244jZ(true);
                    AppMethodBeat.m2505o(81200);
                    return;
                case 3:
                    C16851p.this.qet.chi();
                    AppMethodBeat.m2505o(81200);
                    return;
                case 4:
                    if (bundle != null) {
                        String string = bundle.getString("geta8key_fullurl");
                        if (string != null && (string.startsWith("http://login.weixin.qq.com") || string.startsWith("https://login.weixin.qq.com"))) {
                            C16851p.this.cvH = 2;
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
            }
            C16851p.this.qet.mo25216kj(true);
            C16851p.this.qff = true;
            AppMethodBeat.m2505o(81200);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.p$3 */
    class C168553 implements OnClickListener {
        C168553() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81202);
            C16851p.m26001a(C16851p.this);
            AppMethodBeat.m2505o(81202);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.p$4 */
    class C168564 implements DialogInterface.OnClickListener {
        C168564() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81203);
            C16851p.this.mo9244jZ(true);
            AppMethodBeat.m2505o(81203);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26002a(C16851p c16851p, int i, String str, byte[] bArr, int i2, int i3) {
        AppMethodBeat.m2504i(81236);
        c16851p.m26000a(i, str, bArr, i2, i3);
        AppMethodBeat.m2505o(81236);
    }

    /* renamed from: b */
    static /* synthetic */ void m26004b(C16851p c16851p) {
        AppMethodBeat.m2504i(81237);
        c16851p.chz();
        AppMethodBeat.m2505o(81237);
    }

    public C16851p(C13164b c13164b, Point point, int i, int i2) {
        super(c13164b, point);
        AppMethodBeat.m2504i(81212);
        mo25196fd(244, 244);
        this.cvH = i;
        this.mMode = i2;
        this.qev = true;
        this.qel = 1000;
        if (C5046bo.m7553gO(c13164b.getContext()) < 100) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.qeH = 280;
        }
        AppMethodBeat.m2505o(81212);
    }

    public C16851p(C13164b c13164b, Point point, int i, Set<Integer> set) {
        super(c13164b, point);
        AppMethodBeat.m2504i(81213);
        mo25196fd(244, 244);
        this.cvH = i;
        this.qfh = set;
        this.qev = true;
        this.qel = 1000;
        if (C5046bo.m7553gO(c13164b.getContext()) < 100) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.qeH = 280;
        }
        AppMethodBeat.m2505o(81213);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: f */
    public final void mo25195f(Point point) {
        AppMethodBeat.m2504i(81214);
        this.qem = null;
        super.mo25195f(point);
        AppMethodBeat.m2505o(81214);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: kn */
    public final void mo8431kn(boolean z) {
        AppMethodBeat.m2504i(81215);
        super.mo8431kn(z);
        if (this.qfd != null) {
            this.qfd.ovx = z;
        }
        AppMethodBeat.m2505o(81215);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: km */
    public final Rect mo25198km(boolean z) {
        AppMethodBeat.m2504i(81216);
        Rect rect = new Rect(mo25189H(true, z));
        C4990ab.m7416i("MicroMsg.scanner.ScanModeQRCode", "display rect:".concat(String.valueOf(rect)));
        int width = rect.width();
        int height = rect.height();
        int i = (int) (((float) width) * this.qfi);
        int i2 = (int) (((float) height) * this.qfi);
        if (i > ((int) (((float) this.qeo.x) * 0.85f))) {
            i = (int) (((float) this.qeo.x) * 0.85f);
        }
        if (i2 > ((int) (((float) this.qeo.y) * 0.85f))) {
            i2 = (int) (((float) this.qeo.y) * 0.85f);
        }
        if (i2 % 2 == 1) {
            i2--;
        }
        if (i % 2 == 1) {
            i--;
        }
        C4990ab.m7417i("MicroMsg.scanner.ScanModeQRCode", "newWidth:%d,newHeight:%d", Integer.valueOf(i), Integer.valueOf(i2));
        rect.left -= (i - width) / 2;
        rect.right = ((i - width) / 2) + rect.right;
        rect.top -= (i2 - height) / 2;
        rect.bottom += (i2 - height) / 2;
        C4990ab.m7416i("MicroMsg.scanner.ScanModeQRCode", "scan rect:".concat(String.valueOf(rect)));
        AppMethodBeat.m2505o(81216);
        return rect;
    }

    public final void chx() {
        this.qev = false;
    }

    public final boolean chy() {
        return this.qev;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final void mo8429j(Rect rect) {
        AppMethodBeat.m2504i(81217);
        this.qfm = (TextView) this.qet.findViewById(2131827215);
        this.qfm.setOnClickListener(this.qfo);
        this.iqU = (TextView) this.qet.findViewById(2131827209);
        if (rect.bottom > 0) {
            this.qfm.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + C4977b.m7371b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
        }
        chv();
        if (this.mMode == 2) {
            this.iqU.setText(C25738R.string.df2);
        } else if (this.mMode == 1) {
            this.iqU.setText(C25738R.string.df1);
        } else if (this.cvH == 1) {
            this.iqU.setText(C25738R.string.dgq);
        } else if (this.cvH == 2) {
            this.iqU.setText(C25738R.string.fzu);
        } else {
            this.iqU.setText(C25738R.string.dgr);
        }
        mo25197kl(true);
        AppMethodBeat.m2505o(81217);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.m2504i(81218);
        mo8429j(new Rect(0, 0, 0, 0));
        if (this.mMode == 2) {
            this.qet.mo25205b(4, null);
        } else {
            this.qet.mo25205b(0, new C168553());
        }
        this.qet.mo25202a(this);
        onResume();
        AppMethodBeat.m2505o(81218);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return 2130970550;
    }

    /* Access modifiers changed, original: protected|final */
    public final C3771b cgO() {
        AppMethodBeat.m2504i(81219);
        if (this.qfd == null && this.qet != null) {
            this.qfd = new C13178d(this, this.mMode, this.qet.chh());
        }
        C13178d c13178d = this.qfd;
        AppMethodBeat.m2505o(81219);
        return c13178d;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.m2504i(81220);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
            AppMethodBeat.m2505o(81220);
            return;
        }
        chv();
        AppMethodBeat.m2505o(81220);
    }

    private void chv() {
        AppMethodBeat.m2504i(81221);
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.m2505o(81221);
            return;
        }
        if (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4) {
            this.qet.mo25215jL(0);
        }
        AppMethodBeat.m2505o(81221);
    }

    /* renamed from: b */
    public final void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.m2504i(81222);
        this.qfe.set(false);
        this.pZN = 0;
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            AppMethodBeat.m2505o(81222);
        } else if (this.qff) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
            AppMethodBeat.m2505o(81222);
        } else {
            this.qff = true;
            C4990ab.m7411d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", str);
            if (C5046bo.isNullOrNil(str)) {
                this.qff = false;
                AppMethodBeat.m2505o(81222);
            } else if (C1720g.m3540Rg().acS() == 0) {
                Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(C25738R.string.bx9), 0).show();
                this.qff = false;
                AppMethodBeat.m2505o(81222);
            } else {
                C21731m.qiz.stop();
                m26000a(i, str, bArr, i2, i3);
                AppMethodBeat.m2505o(81222);
            }
        }
    }

    /* renamed from: a */
    private void m26000a(int i, String str, byte[] bArr, int i2, int i3) {
        int i4 = 1;
        AppMethodBeat.m2504i(81223);
        Activity context = this.qet.getContext();
        C45345mv c45345mv = new C45345mv();
        if (i == 1) {
            c45345mv.cIL.cIN = 0;
        } else {
            c45345mv.cIL.cIN = 1;
        }
        c45345mv.cIL.scanResult = str;
        if (this.qfn) {
            C4990ab.m7410d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
            c45345mv.cIL.bJt = 1;
            C4879a.xxA.mo10055m(c45345mv);
            Intent intent = new Intent();
            intent.putExtra("key_scan_result", str);
            intent.putExtra("key_scan_result_raw", bArr);
            intent.putExtra("key_scan_result_type", i);
            intent.putExtra("key_scan_result_code_type", i2);
            intent.putExtra("key_scan_result_code_version", i3);
            context.setResult(-1, intent);
            context.finish();
            context.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(81223);
            return;
        }
        c45345mv.cIL.bJt = 0;
        C4879a.xxA.mo10055m(c45345mv);
        if (c45345mv.cIM.ret == 1 || c45345mv.cIM.ret == 2) {
            context.finish();
            context.overridePendingTransition(0, 0);
        }
        if (i == 1) {
            this.qet.cha();
            this.qet.mo25216kj(true);
            this.qff = false;
            if (c45345mv.cIM.ret != 2) {
                if (!this.qfg) {
                    i4 = 0;
                }
                this.qet.mo25203a(str, i4, i2, i3, this.qeR);
                AppMethodBeat.m2505o(81223);
                return;
            }
        } else if (i == 2) {
            m26003af(str, i2, i3);
        }
        AppMethodBeat.m2505o(81223);
    }

    /* renamed from: jJ */
    public final void mo8430jJ(long j) {
        AppMethodBeat.m2504i(81224);
        C4990ab.m7417i("MicroMsg.scanner.ScanModeQRCode", "decodeFail cost %s", Long.valueOf(j));
        this.qfe.set(false);
        synchronized (this.cli) {
            try {
                chz();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(81224);
            }
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81225);
        C4990ab.m7417i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.qet == null || c1207m == null) {
            String str2 = "MicroMsg.scanner.ScanModeQRCode";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(c1207m == null);
            C4990ab.m7413e(str2, str3, objArr);
            this.qff = false;
            AppMethodBeat.m2505o(81225);
        } else if (i == 4 && i2 == -4) {
            C30379h.m48431a(this.qet.getContext(), (int) C25738R.string.dgi, (int) C25738R.string.f9238tz, new C168564());
            AppMethodBeat.m2505o(81225);
        } else {
            int i3;
            switch (i) {
                case 1:
                    if (C1720g.m3540Rg().acT()) {
                        C1720g.m3540Rg().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (C32856ab.m53750ch(this.qet.getContext())) {
                        C35891h.m58839fR(this.qet.getContext());
                    } else {
                        Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(C25738R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    i3 = 1;
                    break;
                case 2:
                    Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(C25738R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    i3 = 1;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                mo9244jZ(true);
                AppMethodBeat.m2505o(81225);
            } else if (i == 4 && i2 == -2004) {
                C30379h.m48467g(this.qet.getContext(), C25738R.string.dgb, C25738R.string.f9238tz);
                mo9244jZ(true);
                AppMethodBeat.m2505o(81225);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(C25738R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                mo9244jZ(true);
                AppMethodBeat.m2505o(81225);
            } else if (c1207m.getType() == FilterEnum4Shaka.MIC_WEISHI_QINSHUI) {
                C30199kx cgG = ((C43483g) c1207m).cgG();
                if (cgG == null) {
                    C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
                    mo9244jZ(true);
                    AppMethodBeat.m2505o(81225);
                    return;
                }
                C4990ab.m7411d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", Integer.valueOf(cgG.jCt));
                if (C5046bo.isNullOrNil(cgG.vNK)) {
                    mo9244jZ(true);
                    AppMethodBeat.m2505o(81225);
                    return;
                }
                switch (C43494o.m77714a(cgG.jCt, cgG.vNK, this, 4, this.qeR, ((C43483g) c1207m).cvn, ((C43483g) c1207m).cvo, ((C43483g) c1207m).pZG)) {
                    case 0:
                        this.qet.getContext().finish();
                        this.qet.getContext().overridePendingTransition(0, 0);
                        AppMethodBeat.m2505o(81225);
                        return;
                    case 1:
                        C4990ab.m7410d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        break;
                    case 2:
                        C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        this.qet.mo25215jL(0);
                        break;
                }
                this.qet.mo25216kj(false);
                AppMethodBeat.m2505o(81225);
            } else {
                if (c1207m.getType() == 666) {
                    if (c1207m instanceof C17912c) {
                        this.qet.mo25216kj(true);
                        this.qet.getContext().finish();
                        this.qet.getContext().overridePendingTransition(0, 0);
                        AppMethodBeat.m2505o(81225);
                        return;
                    }
                } else if (c1207m.getType() == 971) {
                    this.qet.mo25216kj(true);
                    this.qet.getContext().finish();
                    this.qet.getContext().overridePendingTransition(0, 0);
                }
                AppMethodBeat.m2505o(81225);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(81226);
        C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, (C1202f) this);
        C1720g.m3540Rg().mo14539a(666, (C1202f) this);
        C1720g.m3540Rg().mo14539a(971, (C1202f) this);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            AppMethodBeat.m2505o(81226);
            return;
        }
        if (!this.qfg) {
            this.qff = false;
        }
        chv();
        AppMethodBeat.m2505o(81226);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(81227);
        super.onPause();
        mo25197kl(false);
        C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, (C1202f) this);
        C1720g.m3540Rg().mo14546b(666, (C1202f) this);
        C1720g.m3540Rg().mo14546b(971, (C1202f) this);
        AppMethodBeat.m2505o(81227);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return 244;
    }

    /* renamed from: af */
    private void m26003af(String str, int i, int i2) {
        AppMethodBeat.m2504i(81228);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "result is null");
            this.qff = false;
            this.qet.mo25216kj(false);
            AppMethodBeat.m2505o(81228);
            return;
        }
        String[] split = str.split(",", 2);
        if (split == null || split.length < 2) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
            this.qff = false;
            this.qet.mo25216kj(false);
            AppMethodBeat.m2505o(81228);
            return;
        }
        final C1207m c43483g = new C43483g(C28923r.m45942Ws(split[0]), split[1], i, i2);
        c43483g.pZG = this.qfg;
        C1720g.m3540Rg().mo14541a(c43483g, 0);
        this.qet.cha();
        this.qet.mo25216kj(true);
        Context context = this.qet.getContext();
        this.qet.getContext().getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, this.qet.getContext().getString(C25738R.string.dgn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(81204);
                C1720g.m3540Rg().mo14547c(c43483g);
                C16851p.this.qet.mo25216kj(false);
                C16851p.this.qff = false;
                AppMethodBeat.m2505o(81204);
            }
        });
        AppMethodBeat.m2505o(81228);
    }

    /* renamed from: c */
    public final void mo25201c(final Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(81229);
        this.qff = true;
        if (i2 != -1) {
            this.qff = false;
            this.qfe.set(false);
            this.qfg = false;
            AppMethodBeat.m2505o(81229);
            return;
        }
        switch (i) {
            case 1:
                this.qet.chj();
                break;
            case 4660:
                if (intent == null) {
                    C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
                    this.qff = false;
                    this.qfe.set(false);
                    this.qfg = false;
                    AppMethodBeat.m2505o(81229);
                    return;
                }
                this.qfe.set(true);
                C4990ab.m7411d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", C36338a.m59824i(activity, intent, C43217c.m76863XW()));
                new C7306ak().post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.scanner.ui.p$6$1 */
                    class C168611 implements OnCancelListener {
                        C168611() {
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(81205);
                            C16851p.this.qff = false;
                            C16851p.this.qfe.set(false);
                            C16851p.this.qfg = false;
                            AppMethodBeat.m2505o(81205);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(81206);
                        C16851p c16851p = C16851p.this;
                        Context context = activity;
                        activity.getString(C25738R.string.f9238tz);
                        c16851p.ehJ = C30379h.m48458b(context, activity.getString(C25738R.string.dgl), true, new C168611());
                        AppMethodBeat.m2505o(81206);
                    }
                });
                if (this.qfd != null) {
                    this.qfd.mo8444sI();
                }
                if (this.qet != null) {
                    this.qet.mo25216kj(true);
                }
                C21682m.pZK.reset();
                C43488e.cgy().pYI.mo56082a(r0, new C4254a() {

                    /* renamed from: com.tencent.mm.plugin.scanner.ui.p$7$2 */
                    class C131692 implements DialogInterface.OnClickListener {
                        C131692() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(81208);
                            C16851p.this.qff = false;
                            C16851p.this.qfg = false;
                            C21682m.pZK.reset();
                            C21682m.pZK.mo37152BU(C21682m.pZH);
                            if (C16851p.this.qet != null) {
                                C16851p.this.qet.mo25216kj(false);
                                C16851p.this.qet.mo25214jK(C16851p.this.qeH);
                            }
                            AppMethodBeat.m2505o(81208);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.scanner.ui.p$7$1 */
                    class C168591 implements DialogInterface.OnClickListener {
                        C168591() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(81207);
                            C16851p.this.qff = false;
                            C16851p.this.qfg = false;
                            C21682m.pZK.reset();
                            C21682m.pZK.mo37152BU(C21682m.pZH);
                            if (C16851p.this.qet != null) {
                                C16851p.this.qet.mo25216kj(false);
                                C16851p.this.qet.mo25214jK(C16851p.this.qeH);
                            }
                            AppMethodBeat.m2505o(81207);
                        }
                    }

                    /* renamed from: a */
                    public final void mo9237a(String str, String str2, byte[] bArr, int i, int i2) {
                        int i3 = 1;
                        AppMethodBeat.m2504i(81209);
                        C21682m.pZK.mo37152BU(C21682m.pZI);
                        if (C16851p.this.qfd != null) {
                            C16851p.this.qfd.chP();
                        }
                        if (C16851p.this.ehJ == null || !C16851p.this.ehJ.isShowing()) {
                            C16851p.this.qff = false;
                            C16851p.this.qfg = false;
                            AppMethodBeat.m2505o(81209);
                            return;
                        }
                        if (C16851p.this.qet != null) {
                            C16851p.this.qet.mo25216kj(true);
                        }
                        C16851p.this.ehJ.dismiss();
                        if (C5046bo.isNullOrNil(str2)) {
                            C21682m.pZK.bHT();
                            C30379h.m48431a(activity, (int) C25738R.string.dgk, (int) C25738R.string.f9238tz, new C168591());
                            AppMethodBeat.m2505o(81209);
                            return;
                        }
                        C37907bv.aaq().mo60662c(10237, Integer.valueOf(1));
                        C16851p.this.qet.cha();
                        if (!(i == 19 || i == 22)) {
                            i3 = 2;
                        }
                        C16851p.m26002a(C16851p.this, i3, str2, bArr, i, i2);
                        C16851p.this.qfg = false;
                        C16851p.this.qfe.set(false);
                        AppMethodBeat.m2505o(81209);
                    }

                    /* renamed from: Vv */
                    public final void mo9236Vv(String str) {
                        AppMethodBeat.m2504i(81210);
                        C21682m.pZK.mo37152BU(C21682m.pZI);
                        if (C16851p.this.qfd != null) {
                            C16851p.this.qfd.chP();
                        }
                        if (C16851p.this.ehJ == null || !C16851p.this.ehJ.isShowing()) {
                            C16851p.this.qff = false;
                            C16851p.this.qfe.set(false);
                            C16851p.this.qfg = false;
                            AppMethodBeat.m2505o(81210);
                            return;
                        }
                        if (C16851p.this.qet != null) {
                            C16851p.this.qet.mo25216kj(true);
                        }
                        C16851p.this.ehJ.dismiss();
                        C21682m.pZK.bHT();
                        C30379h.m48431a(activity, (int) C25738R.string.dgk, (int) C25738R.string.f9238tz, new C131692());
                        C16851p.this.qfe.set(false);
                        AppMethodBeat.m2505o(81210);
                    }
                }, null);
                AppMethodBeat.m2505o(81229);
                return;
        }
        AppMethodBeat.m2505o(81229);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        this.qfj = null;
    }

    public final Context getContext() {
        AppMethodBeat.m2504i(81230);
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
            AppMethodBeat.m2505o(81230);
            return null;
        }
        Context context = this.qet.getContext();
        AppMethodBeat.m2505o(81230);
        return context;
    }

    /* renamed from: jZ */
    public final void mo9244jZ(boolean z) {
        AppMethodBeat.m2504i(81231);
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
            AppMethodBeat.m2505o(81231);
        } else if (z) {
            this.qet.mo25216kj(false);
            AppMethodBeat.m2505o(81231);
        } else {
            this.qet.getContext().finish();
            this.qet.getContext().overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(81231);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgS() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgT() {
        return true;
    }

    /* renamed from: K */
    public final void mo8420K(Bundle bundle) {
        AppMethodBeat.m2504i(81232);
        if (bundle.containsKey("zoom_action") && bundle.containsKey("zoom_type") && bundle.containsKey("zoom_scale") && this.qet != null) {
            this.qet.mo25204ah(bundle.getInt("zoom_action"), bundle.getInt("zoom_type"), bundle.getInt("zoom_scale"));
        }
        AppMethodBeat.m2505o(81232);
    }

    private void chz() {
        AppMethodBeat.m2504i(81233);
        if (this.qfe.get() || this.bufferSize <= 0) {
            if (this.qet != null) {
                this.qet.mo25214jK(0);
            }
            AppMethodBeat.m2505o(81233);
            return;
        }
        this.qfe.set(true);
        this.bufferSize--;
        if (this.qfh != null && this.qfh.size() > 0) {
            ((C13178d) cgO()).qfh = this.qfh;
        } else if (this.pZN % 3 >= 2 || !(this.mMode == 1 || this.mMode == 0)) {
            ((C13178d) cgO()).qht = this.mMode;
        } else {
            ((C13178d) cgO()).qht = 3;
        }
        C4990ab.m7416i("MicroMsg.scanner.ScanModeQRCode", "try decode,buffer size:" + this.bufferSize);
        if (this.pZN > 0 && this.qet != null) {
            this.qet.mo25214jK(30);
        }
        if (!(this.qfj == null || this.qfk == null)) {
            ((C13178d) cgO()).chT();
            ((C13178d) cgO()).mo25229a(this.qfj, this.qfk);
        }
        if (C21682m.pZK.pZN == 30 && this.qet != null) {
            this.qet.chk();
        }
        this.pZN++;
        AppMethodBeat.m2505o(81233);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo25190a(byte[] bArr, Point point, int i, Rect rect) {
        AppMethodBeat.m2504i(81234);
        synchronized (this.cli) {
            try {
                if (this.bufferSize == 1) {
                    C4990ab.m7410d("MicroMsg.scanner.ScanModeQRCode", "decode too slow");
                    this.bufferSize = 0;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(81234);
                }
            }
        }
        if (this.qfk == null) {
            this.qfk = new Point();
        }
        final byte[] bArr2 = bArr;
        final Point point2 = point;
        final int i2 = i;
        final Rect rect2 = rect;
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(81211);
                byte[] a = ((C13178d) C16851p.this.cgO()).mo25230a(bArr2, point2, i2, rect2, C16851p.this.qfk);
                if (a != null) {
                    synchronized (C16851p.this.cli) {
                        try {
                            if (C16851p.this.qfj == null || C16851p.this.qfl < a.length) {
                                C16851p.this.qfj = new byte[a.length];
                                C16851p.this.qfl = a.length;
                            }
                            System.arraycopy(a, 0, C16851p.this.qfj, 0, a.length);
                            C16851p c16851p = C16851p.this;
                            c16851p.bufferSize++;
                            C16851p.m26004b(C16851p.this);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(81211);
                        }
                    }
                    return;
                }
                AppMethodBeat.m2505o(81211);
            }
        }, "prepare_decode_data");
        AppMethodBeat.m2505o(81234);
    }

    /* renamed from: a */
    static /* synthetic */ void m26001a(C16851p c16851p) {
        AppMethodBeat.m2504i(81235);
        c16851p.qfg = true;
        c16851p.qff = true;
        c16851p.qet.chg();
        AppMethodBeat.m2505o(81235);
    }
}
