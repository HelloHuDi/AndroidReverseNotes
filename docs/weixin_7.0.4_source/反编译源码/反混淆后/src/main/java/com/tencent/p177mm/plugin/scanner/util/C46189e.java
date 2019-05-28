package com.tencent.p177mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17915b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C42202a;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.openim.p716b.C6700n;
import com.tencent.p177mm.p1177ao.C17912c;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C26195mf;
import com.tencent.p177mm.p230g.p231a.C6538pr;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5494a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C33251a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.p543u.p544a.C4255c;
import com.tencent.p177mm.plugin.p543u.p544a.C4255c.C4261a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35891h;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.protocal.protobuf.bvk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.util.e */
public final class C46189e implements C1202f, C4261a {
    public String appId;
    public int cvp;
    public String cvr;
    public String imagePath;
    private ProgressDialog jMB = null;
    public int jSW;
    private Activity mActivity;
    C21729a qhA = null;
    private Map<C1207m, Integer> qhB = new HashMap();
    private int qhx;
    private String qhy;
    private Bundle qhz;
    public String source;

    /* renamed from: com.tencent.mm.plugin.scanner.util.e$a */
    public interface C21729a {
        /* renamed from: o */
        void mo8437o(int i, Bundle bundle);
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.e$10 */
    class C3963510 implements OnClickListener {
        C3963510() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81402);
            if (C46189e.this.qhA != null) {
                C46189e.this.qhA.mo8437o(1, null);
            }
            AppMethodBeat.m2505o(81402);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.e$11 */
    class C4618611 implements OnClickListener {
        C4618611() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81403);
            if (C46189e.this.qhA != null) {
                C46189e.this.qhA.mo8437o(1, null);
            }
            AppMethodBeat.m2505o(81403);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.e$2 */
    class C461872 implements Runnable {
        C461872() {
        }

        public final void run() {
            AppMethodBeat.m2504i(81394);
            if (C46189e.this.qhA != null) {
                C46189e.this.qhA.mo8437o(3, null);
            }
            AppMethodBeat.m2505o(81394);
        }
    }

    public C46189e() {
        AppMethodBeat.m2504i(81404);
        onResume();
        AppMethodBeat.m2505o(81404);
    }

    /* renamed from: a */
    public final void mo74179a(Activity activity, String str, int i, int i2, int i3, C21729a c21729a, Bundle bundle) {
        AppMethodBeat.m2504i(81405);
        C4990ab.m7417i("MicroMsg.QBarStringHandler", "deal QBarString %s, source:%d, codeType: %s, codeVersion: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mActivity = activity;
        this.qhx = i;
        this.qhy = str;
        this.qhA = c21729a;
        this.qhz = bundle;
        String str2 = "";
        if (bundle != null) {
            str2 = bundle.getString("stat_url", "");
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
            AppMethodBeat.m2505o(81405);
        } else if (C1720g.m3540Rg().acS() == 0) {
            Toast.makeText(activity, activity.getString(C25738R.string.bx9), 0).show();
            if (this.qhA != null) {
                this.qhA.mo8437o(0, null);
            }
            AppMethodBeat.m2505o(81405);
        } else {
            String str3 = "";
            if (str.startsWith("weixin://qr/")) {
                str3 = str.substring(12) + "@qr";
            }
            if (C5046bo.isNullOrNil(str3)) {
                C4990ab.m7411d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", str, Boolean.TRUE, Boolean.TRUE);
                int Cb;
                int Bx;
                final C6538pr c6538pr;
                if (str.startsWith("weixin://wxpay/bizpayurl")) {
                    C4990ab.m7416i("MicroMsg.QBarStringHandler", "do native pay");
                    this.qhA.mo8437o(5, null);
                    Cb = C46189e.m86338Cb(this.qhx);
                    Bx = C46189e.m86337Bx(Cb);
                    final C4883b c26195mf = new C26195mf();
                    c26195mf.cHZ.url = str;
                    c26195mf.cHZ.cIb = Bx;
                    c26195mf.cHZ.scene = Cb;
                    c26195mf.cHZ.context = this.mActivity;
                    if (Bx == 13) {
                        C4990ab.m7410d("MicroMsg.QBarStringHandler", "add source and sourceType");
                        c26195mf.cHZ.source = this.source;
                        c26195mf.cHZ.cvp = this.cvp;
                    }
                    c26195mf.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(81393);
                            if (C46189e.this.getContext() == null || c26195mf.cIa == null) {
                                AppMethodBeat.m2505o(81393);
                            } else if (c26195mf.cIa.ret == 1) {
                                C46189e.this.mo9244jZ(true);
                                AppMethodBeat.m2505o(81393);
                            } else {
                                if (c26195mf.cIa.ret == 2) {
                                    C46189e.this.mo9244jZ(false);
                                }
                                AppMethodBeat.m2505o(81393);
                            }
                        }
                    };
                    C4879a.xxA.mo10048a(c26195mf, Looper.myLooper());
                    new C7306ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(81396);
                            if (C46189e.this.qhA != null && (c26195mf.cIa == null || c26195mf.cIa.ret != 1)) {
                                C46189e.this.qhA.mo8437o(3, null);
                            }
                            AppMethodBeat.m2505o(81396);
                        }
                    }, 10000);
                    m86339Cc(11);
                    C7060h.pYm.mo8381e(16472, Integer.valueOf(2), str, str2);
                    AppMethodBeat.m2505o(81405);
                    return;
                } else if (str.startsWith("https://wx.tenpay.com/f2f") || str.startsWith("wxp://f2f")) {
                    if (this.qhA != null) {
                        this.qhA.mo8437o(5, null);
                    }
                    C35899h.m58851a(this.mActivity, 1, str, C46189e.m86337Bx(C46189e.m86338Cb(this.qhx)), null);
                    if (this.qhA != null) {
                        this.qhA.mo8437o(3, null);
                    }
                    m86339Cc(11);
                    C7060h.pYm.mo8381e(16472, Integer.valueOf(1), str, str2);
                    AppMethodBeat.m2505o(81405);
                    return;
                } else if (str.startsWith("wxp://wbf2f")) {
                    if (this.qhA != null) {
                        this.qhA.mo8437o(5, null);
                    }
                    C35899h.m58851a(this.mActivity, 6, str, C46189e.m86337Bx(C46189e.m86338Cb(this.qhx)), null);
                    if (this.qhA != null) {
                        this.qhA.mo8437o(3, null);
                    }
                    m86339Cc(11);
                    C7060h.pYm.mo8381e(16472, Integer.valueOf(3), str, str2);
                    AppMethodBeat.m2505o(81405);
                    return;
                } else if (i2 == 22 && str.startsWith("m")) {
                    C4990ab.m7410d("MicroMsg.QBarStringHandler", "go to reward");
                    if (this.qhA != null) {
                        this.qhA.mo8437o(5, null);
                    }
                    Bx = C46189e.m86337Bx(C46189e.m86338Cb(this.qhx));
                    Cb = 1;
                    if (this.jSW == 37) {
                        Cb = 2;
                    } else if (this.jSW == 38) {
                        Cb = 3;
                    } else if (this.jSW == 40) {
                        Cb = 4;
                    }
                    C35899h.m58850a(this.mActivity, str, Bx, str2, Cb);
                    if (this.qhA != null) {
                        this.qhA.mo8437o(3, null);
                    }
                    m86339Cc(11);
                    C7060h.pYm.mo8381e(16472, Integer.valueOf(6), str, str2);
                    AppMethodBeat.m2505o(81405);
                    return;
                } else if (str.startsWith("https://payapp.weixin.qq.com/qr/")) {
                    C4990ab.m7410d("MicroMsg.QBarStringHandler", "f2f pay material");
                    if (this.qhA != null) {
                        this.qhA.mo8437o(5, null);
                    }
                    Cb = C46189e.m86338Cb(this.qhx);
                    Bx = C46189e.m86337Bx(Cb);
                    c6538pr = new C6538pr();
                    c6538pr.cLS.cLU = str;
                    c6538pr.cLS.scene = Cb;
                    c6538pr.cLS.type = 0;
                    c6538pr.cLS.aIq = new WeakReference(this.mActivity);
                    c6538pr.cLS.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(81397);
                            if (!C5046bo.isNullOrNil(c6538pr.cLT.aIm)) {
                                Toast.makeText(C46189e.this.getContext(), c6538pr.cLT.aIm, 1).show();
                            } else if (C5046bo.isNullOrNil(c6538pr.cLT.cLV)) {
                                C4990ab.m7420w("MicroMsg.QBarStringHandler", "resp url is null!");
                            } else if (c6538pr.cLT.actionType == 1) {
                                C35899h.m58851a(C46189e.this.getContext(), 1, c6538pr.cLT.cLV, Bx, null);
                            } else {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", c6538pr.cLT.cLV);
                                C28892c.gkE.mo38924i(intent, C46189e.this.getContext());
                            }
                            if (C46189e.this.qhA != null) {
                                C46189e.this.qhA.mo8437o(3, null);
                            }
                            AppMethodBeat.m2505o(81397);
                        }
                    };
                    C4879a.xxA.mo10055m(c6538pr);
                    m86339Cc(11);
                    C7060h.pYm.mo8381e(16472, Integer.valueOf(5), str, str2);
                    AppMethodBeat.m2505o(81405);
                    return;
                } else if (i2 == 22 && str.startsWith("n")) {
                    C4990ab.m7410d("MicroMsg.QBarStringHandler", "qr reward pay material");
                    if (this.qhA != null) {
                        this.qhA.mo8437o(5, null);
                    }
                    final int Cb2 = C46189e.m86338Cb(this.qhx);
                    final int Bx2 = C46189e.m86337Bx(Cb2);
                    c6538pr = new C6538pr();
                    c6538pr.cLS.cLU = str;
                    c6538pr.cLS.scene = Cb2;
                    c6538pr.cLS.type = 1;
                    c6538pr.cLS.aIq = new WeakReference(this.mActivity);
                    c6538pr.cLS.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(81398);
                            if (!C5046bo.isNullOrNil(c6538pr.cLT.aIm)) {
                                Toast.makeText(C46189e.this.getContext(), c6538pr.cLT.aIm, 1).show();
                            } else if (C5046bo.isNullOrNil(c6538pr.cLT.cLV)) {
                                C4990ab.m7420w("MicroMsg.QBarStringHandler", "resp url is null!");
                            } else if (c6538pr.cLT.actionType == 1) {
                                C35899h.m58850a(C46189e.this.getContext(), c6538pr.cLT.cLV, Bx2, str2, Cb2);
                            } else {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", c6538pr.cLT.cLV);
                                C28892c.gkE.mo38924i(intent, C46189e.this.getContext());
                            }
                            if (C46189e.this.qhA != null) {
                                C46189e.this.qhA.mo8437o(3, null);
                            }
                            AppMethodBeat.m2505o(81398);
                        }
                    };
                    C4879a.xxA.mo10055m(c6538pr);
                    m86339Cc(11);
                    C7060h.pYm.mo8381e(16472, Integer.valueOf(7), str, str2);
                    AppMethodBeat.m2505o(81405);
                    return;
                } else if (str.startsWith("wxhb://f2f")) {
                    C4990ab.m7416i("MicroMsg.QBarStringHandler", "scan f2f hb url");
                    if (i2 != 19) {
                        AppMethodBeat.m2505o(81405);
                        return;
                    }
                    if (this.qhA != null) {
                        this.qhA.mo8437o(5, null);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_share_url", str);
                    C25985d.m41468b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", intent, 1);
                    C7060h.pYm.mo8381e(16472, Integer.valueOf(4), str, str2);
                    m86339Cc(11);
                    AppMethodBeat.m2505o(81405);
                    return;
                } else {
                    m86341a(activity, str, i2, i3, this.appId);
                    if (this.qhA != null) {
                        this.qhA.mo8437o(5, null);
                    }
                    AppMethodBeat.m2505o(81405);
                    return;
                }
            }
            m86340a(activity, i, str3, false);
            AppMethodBeat.m2505o(81405);
        }
    }

    /* renamed from: Bx */
    private static int m86337Bx(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4 || i == 47) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }

    public final void chU() {
        AppMethodBeat.m2504i(81406);
        C4990ab.m7416i("MicroMsg.QBarStringHandler", "cancel Deal");
        this.qhy = null;
        this.mActivity = null;
        onPause();
        AppMethodBeat.m2505o(81406);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(81407);
        C4990ab.m7416i("MicroMsg.QBarStringHandler", "onResume");
        C1720g.m3540Rg().mo14539a(106, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
        C1720g.m3540Rg().mo14539a(666, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C33251a.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(81407);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(81408);
        C4990ab.m7416i("MicroMsg.QBarStringHandler", "onPause");
        C1720g.m3540Rg().mo14546b(106, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
        C1720g.m3540Rg().mo14546b(666, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C33251a.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(81408);
    }

    /* renamed from: a */
    private void m86340a(Activity activity, int i, String str, boolean z) {
        int i2 = 2;
        AppMethodBeat.m2504i(81409);
        C4990ab.m7417i("MicroMsg.QBarStringHandler", "start search contact %s", str);
        if (i != 2) {
            i2 = 1;
        }
        final C1207m c12518f = new C12518f(str, i2, 5, z);
        this.qhB.put(c12518f, Integer.valueOf(1));
        C1720g.m3540Rg().mo14541a(c12518f, 0);
        activity.getString(C25738R.string.f9238tz);
        this.jMB = C30379h.m48457b(activity, activity.getString(C25738R.string.dy4), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(81399);
                C1720g.m3540Rg().mo14547c(c12518f);
                if (C46189e.this.qhA != null) {
                    C46189e.this.qhA.mo8437o(1, null);
                }
                AppMethodBeat.m2505o(81399);
            }
        });
        AppMethodBeat.m2505o(81409);
    }

    /* renamed from: a */
    private void m86341a(Activity activity, String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(81410);
        C4990ab.m7417i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", str, Integer.valueOf(this.qhx), Integer.valueOf(this.jSW > 0 ? this.jSW : C46189e.m86338Cb(this.qhx)));
        final C1207m c6681h = new C6681h(str, r2, i, i2, str2, (int) System.currentTimeMillis(), new byte[0]);
        if (str.startsWith("http://weixin.qq.com/r/")) {
            String stringExtra = activity.getIntent().getStringExtra("img_gallery_session_id");
            c6681h.mo14919lV(C5494a.m8288MQ(this.qhx));
            String str3 = "";
            if (!C5046bo.isNullOrNil(stringExtra)) {
                C32800b nV = C37922v.m64076Zp().mo60674nV(stringExtra);
                if (nV != null) {
                    str3 = nV.getString("url", null);
                }
                c6681h.mo14920tq(str3);
            }
            C4990ab.m7417i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", str3, Integer.valueOf(r3));
        }
        this.qhB.put(c6681h, Integer.valueOf(1));
        C1720g.m3540Rg().mo14541a(c6681h, 0);
        if (this.jMB != null) {
            this.jMB.dismiss();
        }
        activity.getString(C25738R.string.f9238tz);
        this.jMB = C30379h.m48458b((Context) activity, activity.getString(C25738R.string.dgn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(81401);
                C1720g.m3540Rg().mo14547c(c6681h);
                if (C46189e.this.qhA != null) {
                    C46189e.this.qhA.mo8437o(1, null);
                }
                AppMethodBeat.m2505o(81401);
            }
        });
        AppMethodBeat.m2505o(81410);
    }

    /* renamed from: Cb */
    private static int m86338Cb(int i) {
        if (i == 1) {
            return 34;
        }
        if (i == 0) {
            return 4;
        }
        if (i == 3) {
            return 42;
        }
        return 30;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0277  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81411);
        C4990ab.m7417i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        String str2;
        if (c1207m == null) {
            String str3 = "MicroMsg.QBarStringHandler";
            str2 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(c1207m == null);
            C4990ab.m7413e(str3, str2, objArr);
            if (this.qhA != null) {
                this.qhA.mo8437o(2, null);
            }
            AppMethodBeat.m2505o(81411);
            return;
        }
        if (!this.qhB.containsKey(c1207m)) {
            if (c1207m instanceof C17912c) {
                C4990ab.m7412e("MicroMsg.QBarStringHandler", "emotion scan scene");
            } else {
                C4990ab.m7412e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
                AppMethodBeat.m2505o(81411);
                return;
            }
        }
        this.qhB.remove(c1207m);
        if (this.jMB != null) {
            this.jMB.dismiss();
            this.jMB = null;
        }
        C1207m c6681h;
        if (c1207m.getType() == C33251a.CTRL_INDEX && i == 4 && i2 == -2034) {
            c6681h = new C6681h(((C6700n) c1207m).gfh, null, 50, 0, 0, new byte[0]);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c6681h, 0);
            this.qhB.put(c6681h, Integer.valueOf(1));
            AppMethodBeat.m2505o(81411);
        } else if (i == 4 && i2 == -4) {
            C30379h.m48431a(this.mActivity, (int) C25738R.string.dgi, (int) C25738R.string.f9238tz, new C3963510());
            AppMethodBeat.m2505o(81411);
        } else {
            Object obj;
            switch (i) {
                case 1:
                    if (C1720g.m3540Rg().acT()) {
                        C1720g.m3540Rg().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (C32856ab.m53750ch(this.mActivity)) {
                        C35891h.m58839fR(this.mActivity);
                    } else {
                        Toast.makeText(this.mActivity, this.mActivity.getString(C25738R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    obj = 1;
                    break;
                case 2:
                    Toast.makeText(this.mActivity, this.mActivity.getString(C25738R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
            Activity activity;
            String stringExtra;
            Bundle bundle;
            if (obj != null) {
                if (this.qhA != null) {
                    this.qhA.mo8437o(1, null);
                }
                AppMethodBeat.m2505o(81411);
            } else if (i == 4 && i2 == -2004) {
                C30379h.m48467g(this.mActivity, C25738R.string.dgb, C25738R.string.f9238tz);
                if (this.qhA != null) {
                    this.qhA.mo8437o(1, null);
                }
                AppMethodBeat.m2505o(81411);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.mActivity, this.mActivity.getString(C25738R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                if (this.qhA != null) {
                    this.qhA.mo8437o(1, null);
                }
                AppMethodBeat.m2505o(81411);
            } else if (c1207m.getType() == 106) {
                C12518f c12518f = (C12518f) c1207m;
                if (!c12518f.opS) {
                    buv bOj = c12518f.bOj();
                    if (C7616ad.m13547Mn(bOj.wBT) && bOj.wCa != null && !C5046bo.isNullOrNil(bOj.wCa.gvc) && C42202a.m74445pi(bOj.wCa.gvc)) {
                        int i3;
                        if (this.jSW > 0) {
                            i3 = this.jSW;
                        } else {
                            i3 = C46189e.m86338Cb(this.qhx);
                        }
                        C4990ab.m7417i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", this.qhy, Integer.valueOf(this.qhx), Integer.valueOf(i3));
                        c6681h = new C6681h(this.qhy, null, 43, 0, 0, new byte[0]);
                        this.qhB.put(c6681h, Integer.valueOf(1));
                        C1720g.m3540Rg().mo14541a(c6681h, 0);
                        if (this.jMB != null) {
                            this.jMB.dismiss();
                        }
                        Context context = this.mActivity;
                        this.mActivity.getString(C25738R.string.f9238tz);
                        this.jMB = C30379h.m48458b(context, this.mActivity.getString(C25738R.string.dgn), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(81395);
                                C1720g.m3540Rg().mo14547c(c6681h);
                                if (C46189e.this.qhA != null) {
                                    C46189e.this.qhA.mo8437o(1, null);
                                }
                                AppMethodBeat.m2505o(81395);
                            }
                        });
                        obj = 1;
                        if (obj == null) {
                            AppMethodBeat.m2505o(81411);
                            return;
                        }
                        buv bOj2 = ((C12518f) c1207m).bOj();
                        str2 = C1946aa.m4148a(bOj2.wcB);
                        C4990ab.m7410d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + bOj2.wcB);
                        C17884o.acd().mo67506n(str2, C1946aa.m4150a(bOj2.vEF));
                        if (this.jMB != null && this.jMB.isShowing()) {
                            C4990ab.m7410d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                            this.jMB.dismiss();
                        }
                        if (C5046bo.nullAsNil(str2).length() > 0) {
                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
                            if (aoO != null && C7486a.m12942jh(aoO.field_type) && aoO.dsf()) {
                                C16527d qP = C41747z.aeR().mo43729qP(str2);
                                qP.mo30481cJ(false);
                                C16529b c16529b = qP.fuY;
                                if (c16529b.fvc != null) {
                                    c16529b.fvs = c16529b.fvc.optInt("ScanQRCodeType", 0);
                                }
                                if (c16529b.fvs == 1) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (!(obj == null || qP.adP())) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Chat_User", str2);
                                    intent.putExtra("finish_direct", true);
                                    C28892c.gkE.mo38915d(intent, this.mActivity);
                                    obj = 1;
                                }
                            }
                            i3 = chV();
                            Intent intent2 = new Intent();
                            C17915b.m28130a(intent2, bOj2, i3);
                            if (!(aoO == null || C7486a.m12942jh(aoO.field_type))) {
                                intent2.putExtra("Contact_IsLBSFriend", true);
                            }
                            if ((bOj2.wBT & 8) > 0) {
                                C7060h.pYm.mo8374X(10298, str2 + "," + i3);
                            }
                            if (this.mActivity != null) {
                                if (C7616ad.m13547Mn(bOj2.wBT)) {
                                    activity = this.mActivity;
                                    if (activity != null) {
                                        intent2.putExtra("qbarScene", this.qhx);
                                        stringExtra = activity.getIntent().getStringExtra("img_gallery_session_id");
                                        if (!C5046bo.isNullOrNil(stringExtra)) {
                                            C32800b nV = C37922v.m64076Zp().mo60674nV(stringExtra);
                                            if (nV != null) {
                                                str2 = nV.getString("preUsername", null);
                                                String string = nV.getString("preChatName", null);
                                                String string2 = nV.getString("url", null);
                                                stringExtra = nV.getString("rawUrl", null);
                                                int ad = C32798u.m53583ad(str2, string);
                                                intent2.putExtra("preUsername", str2);
                                                intent2.putExtra("preChatName", string);
                                                intent2.putExtra("url", string2);
                                                intent2.putExtra("rawUrl", stringExtra);
                                                intent2.putExtra("preChatTYPE", ad);
                                            }
                                        }
                                    }
                                }
                                C28892c.gkE.mo38912c(intent2, this.mActivity);
                                C7060h c7060h = C7060h.pYm;
                                Object[] objArr2 = new Object[6];
                                objArr2[0] = Integer.valueOf(C7616ad.m13547Mn(bOj2.wBT) ? 0 : 1);
                                objArr2[1] = Integer.valueOf(this.cvp);
                                objArr2[2] = Integer.valueOf(this.qhx);
                                objArr2[3] = this.imagePath;
                                objArr2[4] = this.qhy;
                                objArr2[5] = C5046bo.nullAsNil(this.cvr);
                                c7060h.mo8381e(14268, objArr2);
                            }
                            obj = 1;
                        } else {
                            if (this.mActivity != null) {
                                Toast.makeText(this.mActivity, C25738R.string.dyr, 0).show();
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            if (this.qhA != null) {
                                bundle = new Bundle();
                                bundle.putString("geta8key_fullurl", C1946aa.m4148a(((C12518f) c1207m).bOj().wcB));
                                bundle.putInt("geta8key_action_code", 4);
                                this.qhA.mo8437o(3, bundle);
                            }
                            m86339Cc(4);
                            AppMethodBeat.m2505o(81411);
                            return;
                        }
                        if (this.qhA != null) {
                            this.qhA.mo8437o(1, null);
                        }
                        AppMethodBeat.m2505o(81411);
                        return;
                    }
                }
                obj = null;
                if (obj == null) {
                }
            } else if (c1207m.getType() == C33251a.CTRL_INDEX) {
                bvk bvk = ((C6700n) c1207m).gfg;
                str2 = bvk.jBB;
                C4990ab.m7410d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(str2)));
                if (this.jMB != null && this.jMB.isShowing()) {
                    C4990ab.m7410d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                    this.jMB.dismiss();
                }
                if (C5046bo.nullAsNil(str2).length() > 0) {
                    C7616ad aoO2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
                    int chV = chV();
                    Intent intent3 = new Intent();
                    C17915b.m28131a(intent3, bvk, chV);
                    if (!(aoO2 == null || C7486a.m12942jh(aoO2.field_type))) {
                        intent3.putExtra("Contact_IsLBSFriend", true);
                    }
                    if (this.mActivity != null) {
                        C28892c.gkE.mo38912c(intent3, this.mActivity);
                        C7060h.pYm.mo8381e(14268, Integer.valueOf(2), Integer.valueOf(this.cvp), Integer.valueOf(this.qhx), this.imagePath, this.qhy, C5046bo.nullAsNil(this.cvr));
                    }
                    obj = 1;
                } else {
                    if (this.mActivity != null) {
                        Toast.makeText(this.mActivity, C25738R.string.dyr, 0).show();
                    }
                    obj = null;
                }
                if (obj != null) {
                    if (this.qhA != null) {
                        bundle = new Bundle();
                        bundle.putString("geta8key_fullurl", bvk.jBB);
                        bundle.putInt("geta8key_action_code", 4);
                        this.qhA.mo8437o(3, bundle);
                    }
                    m86339Cc(4);
                    AppMethodBeat.m2505o(81411);
                    return;
                }
                if (this.qhA != null) {
                    this.qhA.mo8437o(1, null);
                }
                AppMethodBeat.m2505o(81411);
            } else if (c1207m.getType() == C31128d.MIC_PTU_MEISHI) {
                int i4;
                String aiT = ((C6681h) c1207m).aiT();
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_fullurl", aiT);
                bundle2.putInt("geta8key_action_code", ((C6681h) c1207m).aiV());
                if (this.qhA != null) {
                    this.qhA.mo8437o(4, bundle2);
                }
                m86339Cc(((C6681h) c1207m).aiV());
                if (this.jSW > 0) {
                    i4 = this.jSW;
                } else {
                    i4 = C46189e.m86338Cb(this.qhx);
                }
                C4990ab.m7417i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", Integer.valueOf(i4));
                boolean a = C4255c.m6612a(this, (C6681h) c1207m, new C4618611(), this.qhy, i4, this.qhx, new C461872(), this.qhz);
                if (!a && ((C6681h) c1207m).aiV() == 4) {
                    m86340a(this.mActivity, this.qhx, aiT, true);
                    AppMethodBeat.m2505o(81411);
                } else if (a || ((C6681h) c1207m).aiV() != 29) {
                    C4990ab.m7417i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", Boolean.valueOf(a));
                    if (!(a || this.qhA == null)) {
                        this.qhA.mo8437o(1, null);
                    }
                    AppMethodBeat.m2505o(81411);
                } else {
                    activity = this.mActivity;
                    C4990ab.m7417i("MicroMsg.QBarStringHandler", "start search contact %s", aiT);
                    final C1207m c6700n = new C6700n(aiT, (byte) 0);
                    this.qhB.put(c6700n, Integer.valueOf(1));
                    C1720g.m3540Rg().mo14541a(c6700n, 0);
                    activity.getString(C25738R.string.f9238tz);
                    this.jMB = C30379h.m48457b(activity, activity.getString(C25738R.string.dy4), new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(81400);
                            C1720g.m3540Rg().mo14547c(c6700n);
                            if (C46189e.this.qhA != null) {
                                C46189e.this.qhA.mo8437o(1, null);
                            }
                            AppMethodBeat.m2505o(81400);
                        }
                    });
                    AppMethodBeat.m2505o(81411);
                }
            } else {
                if (c1207m.getType() == 666) {
                    if (i != 0 || i2 != 0) {
                        C4990ab.m7416i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
                    } else if (c1207m instanceof C17912c) {
                        C4990ab.m7411d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", ((C17912c) c1207m).agd().ProductID);
                        Intent intent4 = new Intent();
                        intent4.putExtra("extra_id", stringExtra);
                        intent4.putExtra("preceding_scence", 11);
                        intent4.putExtra("download_entrance_scene", 14);
                        C25985d.m41467b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", intent4);
                        C4990ab.m7416i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
                        if (this.qhA != null) {
                            this.qhA.mo8437o(3, null);
                        }
                        AppMethodBeat.m2505o(81411);
                        return;
                    }
                }
                AppMethodBeat.m2505o(81411);
            }
        }
    }

    private int chV() {
        switch (this.qhx) {
            case 1:
                return 45;
            default:
                return 30;
        }
    }

    /* renamed from: Cc */
    private void m86339Cc(int i) {
        AppMethodBeat.m2504i(81412);
        if (this.qhz != null) {
            String string = this.qhz.getString("stat_url");
            if ((this.cvp == 6 || this.cvp == 0) && !C5046bo.isNullOrNil(string)) {
                String str = "";
                String str2 = "";
                try {
                    str = URLEncoder.encode(C5046bo.nullAsNil(string), "UTF-8");
                    str2 = URLEncoder.encode(C5046bo.nullAsNil(this.qhy), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.QBarStringHandler", e, "", new Object[0]);
                }
                C7060h.pYm.mo8381e(13329, str, str2, Integer.valueOf(i));
            }
        }
        AppMethodBeat.m2505o(81412);
    }

    public final Context getContext() {
        return this.mActivity;
    }

    /* renamed from: jZ */
    public final void mo9244jZ(boolean z) {
        AppMethodBeat.m2504i(81413);
        if (z) {
            if (this.qhA != null) {
                this.qhA.mo8437o(1, null);
                AppMethodBeat.m2505o(81413);
                return;
            }
        } else if (this.qhA != null) {
            this.qhA.mo8437o(3, null);
        }
        AppMethodBeat.m2505o(81413);
    }
}
