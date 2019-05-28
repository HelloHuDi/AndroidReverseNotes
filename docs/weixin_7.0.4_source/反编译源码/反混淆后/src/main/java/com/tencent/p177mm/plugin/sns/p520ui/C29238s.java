package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C37691an;
import com.tencent.p177mm.p230g.p231a.C42019kv;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9463sb;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.SnsCmdList;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p1558j.C39739a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.sns.ui.s */
public final class C29238s implements C1202f {
    /* renamed from: IS */
    String f13708IS;
    final Context context;
    int cvn;
    int cvo;
    public int jCq = 0;
    C4884c mip = new C713310();
    C46236n qBY;
    String riC;
    boolean riD = false;
    C4884c riJ = new C292362();
    String riz;
    SnsCmdList rjk = new SnsCmdList();
    private final C29239a rjl;
    C36356d rjm = null;
    boolean rjn;
    bau rjo;
    private final String rjp;
    public C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$10 */
    class C713310 extends C4884c<C18346nr> {
        C713310() {
            AppMethodBeat.m2504i(38260);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(38260);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38261);
            C18346nr c18346nr = (C18346nr) c4883b;
            if (C29238s.this.rjm == null || C29238s.this.riz == null) {
                C4990ab.m7412e("MicroMsg.GalleryTitleManager", "not in recoging");
                AppMethodBeat.m2505o(38261);
            } else if (c18346nr == null || !(c18346nr instanceof C18346nr)) {
                C4990ab.m7412e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
                AppMethodBeat.m2505o(38261);
            } else if (c18346nr.cJX.filePath.equals(C29238s.this.riz)) {
                C4990ab.m7416i("MicroMsg.GalleryTitleManager", "recog result: " + c18346nr.cJX.result);
                if (!C5046bo.isNullOrNil(c18346nr.cJX.result)) {
                    C29238s.this.riC = c18346nr.cJX.result;
                    C29238s.this.cvn = c18346nr.cJX.cvn;
                    C29238s.this.cvo = c18346nr.cJX.cvo;
                    if (!(C29238s.this.riC == null || C29238s.this.rjm == null)) {
                        C29238s.this.riD = true;
                    }
                    C29238s.this.mo47403a(C29238s.this.rjn, C29238s.this.qBY, C29238s.this.rjo, false, 0);
                }
                C29238s.this.riz = null;
                AppMethodBeat.m2505o(38261);
            } else {
                C4990ab.m7412e("MicroMsg.GalleryTitleManager", "not same filepath");
                AppMethodBeat.m2505o(38261);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$9 */
    class C137139 implements OnCancelListener {
        final /* synthetic */ C46224r rjx;

        C137139(C46224r c46224r) {
            this.rjx = c46224r;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(38259);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c(this.rjx);
            AppMethodBeat.m2505o(38259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$2 */
    class C292362 extends C4884c<C42019kv> {
        C292362() {
            AppMethodBeat.m2504i(38249);
            this.xxI = C42019kv.class.getName().hashCode();
            AppMethodBeat.m2505o(38249);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38250);
            C42019kv c42019kv = (C42019kv) c4883b;
            if (c42019kv == null || !(c42019kv instanceof C42019kv)) {
                C4990ab.m7412e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                C4990ab.m7417i("MicroMsg.GalleryTitleManager", "notify Event: %d", Integer.valueOf(c42019kv.cGM.cGK));
                if (!(c42019kv.cGM.activity == ((Activity) C29238s.this.context) && c42019kv.cGM.ctB.equals(C29238s.this.riC))) {
                    C4990ab.m7412e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            AppMethodBeat.m2505o(38250);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$4 */
    class C292374 implements C15994a {
        C292374() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(38254);
            C37691an c37691an = new C37691an();
            c37691an.ctC.filePath = C29238s.this.riz;
            C4879a.xxA.mo10055m(c37691an);
            C29238s.this.rjm = null;
            C29238s.this.riz = null;
            C29238s.this.qBY = null;
            C29238s.this.f13708IS = null;
            C29238s.this.riC = null;
            C29238s c29238s = C29238s.this;
            C29238s.this.cvo = 0;
            c29238s.cvn = 0;
            AppMethodBeat.m2505o(38254);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$a */
    public interface C29239a {
        void crM();

        void crN();

        /* renamed from: dg */
        void mo8727dg(String str, int i);

        /* renamed from: dh */
        void mo8728dh(String str, int i);

        /* renamed from: gt */
        void mo47407gt(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$8 */
    class C292438 implements OnCancelListener {
        final /* synthetic */ C46224r rjw;

        C292438(C46224r c46224r) {
            this.rjw = c46224r;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(38258);
            if (C29238s.this.jCq != 0) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14547c(this.rjw);
                C29238s.this.jCq = 0;
            }
            AppMethodBeat.m2505o(38258);
        }
    }

    /* renamed from: DN */
    public final void mo47401DN(int i) {
        AppMethodBeat.m2504i(38262);
        if (i == 0) {
            AppMethodBeat.m2505o(38262);
            return;
        }
        this.rjk.mo8581CK(i);
        AppMethodBeat.m2505o(38262);
    }

    public C29238s(Context context, C29239a c29239a) {
        AppMethodBeat.m2504i(38263);
        this.context = context;
        this.rjl = c29239a;
        this.rjp = ((Activity) context).getIntent().getStringExtra("sns_gallery_pre_title");
        AppMethodBeat.m2505o(38263);
    }

    public final void crL() {
        AppMethodBeat.m2504i(38264);
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rjk);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
        AppMethodBeat.m2505o(38264);
    }

    /* renamed from: a */
    public final void mo47403a(boolean z, final C46236n c46236n, final bau bau, boolean z2, final int i) {
        AppMethodBeat.m2504i(38265);
        this.rjn = z;
        this.qBY = c46236n;
        this.rjo = bau;
        this.f13708IS = bau.f17915Id;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        C9321dq c9321dq;
        if (!z) {
            c46236n.cqu();
            arrayList.add(this.context.getString(C25738R.string.ens));
            arrayList2.add(Integer.valueOf(3));
            if (C25985d.afj("favorite")) {
                arrayList.add(this.context.getString(C25738R.string.dcq));
                arrayList2.add(Integer.valueOf(6));
            }
            if (c46236n.field_type == 15 || c46236n.field_type == 5) {
                arrayList.add(this.context.getString(C25738R.string.dx0));
                arrayList2.add(Integer.valueOf(2));
            } else if (c46236n.field_type == 1) {
                arrayList.add(this.context.getString(C25738R.string.dwx));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(C25738R.string.enw));
                arrayList2.add(Integer.valueOf(2));
            }
            c9321dq = new C9321dq();
            c9321dq.cxc.cwT = c46236n.cqU();
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB) {
                arrayList.add(this.context.getString(C25738R.string.f9188s7));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.riC != null) {
                if (C13119a.m21149BR(this.cvn)) {
                    arrayList.add(this.context.getString(C25738R.string.diy));
                } else if (C13119a.m21150ba(this.cvn, this.riC)) {
                    arrayList.add(this.context.getString(C25738R.string.diz));
                } else if (C13119a.m21148BQ(this.cvn)) {
                    arrayList.add(this.context.getString(C25738R.string.dix));
                }
                arrayList2.add(Integer.valueOf(7));
            }
            if (arrayList.size() != 0) {
                if (this.rjm == null || !this.riD) {
                    this.rjm = new C36356d(this.context, 1, false);
                } else {
                    this.riD = false;
                }
                this.rjm.rBl = new C36073c() {
                    /* renamed from: a */
                    public final void mo5746a(C44273l c44273l) {
                        AppMethodBeat.m2504i(38255);
                        c44273l.clear();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                c44273l.mo70068e(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                                i = i2 + 1;
                            } else {
                                AppMethodBeat.m2505o(38255);
                                return;
                            }
                        }
                    }
                };
                this.rjm.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(38256);
                        int itemId = menuItem.getItemId();
                        C4990ab.m7410d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(itemId)));
                        switch (itemId) {
                            case 2:
                                if (!(c46236n == null || c46236n.cqu().xfI == null)) {
                                    if (c46236n.field_type != 15) {
                                        C14987n.m23321j(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46121l(bau), C29238s.this.context);
                                        AppMethodBeat.m2505o(38256);
                                        return;
                                    }
                                    C29238s.m46418Zx(c46236n.cqU());
                                    AppMethodBeat.m2505o(38256);
                                    return;
                                }
                            case 3:
                                if (!(c46236n == null || c46236n.cqu().xfI == null)) {
                                    if (c46236n.cqu().xfI.wbJ == 1) {
                                        C29238s.this.mo47402Zw(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46121l(bau));
                                        AppMethodBeat.m2505o(38256);
                                        return;
                                    }
                                    C29238s.m46419Zy(c46236n.cqU());
                                    AppMethodBeat.m2505o(38256);
                                    return;
                                }
                            case 4:
                                C29238s c29238s = C29238s.this;
                                long j = c46236n.field_snsId;
                                C46236n kD = C13373af.cnF().mo62941kD(j);
                                if (j == 0 || kD == null) {
                                    AppMethodBeat.m2505o(38256);
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("k_username", kD.field_userName);
                                intent.putExtra("k_expose_msg_id", j);
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                C25985d.m41467b(c29238s.context, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.m2505o(38256);
                                return;
                            case 6:
                                if (!(c46236n == null || c46236n.cqu().xfI == null)) {
                                    C29238s.m46421a(C29238s.this, c46236n, bau);
                                    AppMethodBeat.m2505o(38256);
                                    return;
                                }
                            case 7:
                                Bundle bundle = new Bundle();
                                bundle.putString("stat_msg_id", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                                bundle.putString("stat_send_msg_user", c46236n.field_userName);
                                bundle.putInt("stat_scene", 3);
                                C29238s.m46420a(C29238s.this, bundle);
                                break;
                            case 8:
                                C29238s.m46422a(C29238s.this, c46236n, bau, i);
                                AppMethodBeat.m2505o(38256);
                                return;
                        }
                        AppMethodBeat.m2505o(38256);
                    }
                };
                this.rjm.cpD();
            }
        } else if (c46236n == null) {
            AppMethodBeat.m2505o(38265);
            return;
        } else {
            if (c46236n.field_localPrivate > 0) {
                if (!C5046bo.isNullOrNil(C13373af.cnk()) && C13373af.cnk().equals(c46236n.field_userName)) {
                    arrayList.add(this.context.getString(C25738R.string.eo_));
                    arrayList2.add(Integer.valueOf(5));
                }
                arrayList.add(this.context.getString(C25738R.string.ens));
                arrayList2.add(Integer.valueOf(3));
            } else {
                arrayList.add(this.context.getString(C25738R.string.eoa));
                arrayList2.add(Integer.valueOf(1));
                arrayList.add(this.context.getString(C25738R.string.ens));
                arrayList2.add(Integer.valueOf(3));
            }
            if (C25985d.afj("favorite")) {
                arrayList.add(this.context.getString(C25738R.string.dcq));
                arrayList2.add(Integer.valueOf(6));
            }
            if (c46236n.field_type == 15 || c46236n.field_type == 5) {
                arrayList.add(this.context.getString(C25738R.string.dx0));
                arrayList2.add(Integer.valueOf(2));
            } else if (c46236n.field_type == 1) {
                arrayList.add(this.context.getString(C25738R.string.dwx));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(C25738R.string.enw));
                arrayList2.add(Integer.valueOf(2));
            }
            c9321dq = new C9321dq();
            c9321dq.cxc.cwT = c46236n.cqU();
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB) {
                arrayList.add(this.context.getString(C25738R.string.f9188s7));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.riC != null) {
                if (C13119a.m21149BR(this.cvn)) {
                    arrayList.add(this.context.getString(C25738R.string.diy));
                } else if (C13119a.m21150ba(this.cvn, this.riC)) {
                    arrayList.add(this.context.getString(C25738R.string.diz));
                } else if (C13119a.m21148BQ(this.cvn)) {
                    arrayList.add(this.context.getString(C25738R.string.dix));
                } else {
                    arrayList.add(this.context.getString(C25738R.string.diy));
                }
                arrayList2.add(Integer.valueOf(7));
            }
            if (this.rjm == null || !this.riD) {
                this.rjm = new C36356d(this.context, 1, false);
            } else {
                this.riD = false;
            }
            this.rjm.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(38248);
                    c44273l.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            c44273l.mo70068e(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                            i = i2 + 1;
                        } else {
                            c44273l.mo70068e(-1, C29238s.this.context.getString(C25738R.string.ek5));
                            AppMethodBeat.m2505o(38248);
                            return;
                        }
                    }
                }
            };
            this.rjm.rBm = new C5279d() {

                /* renamed from: com.tencent.mm.plugin.sns.ui.s$3$2 */
                class C137112 implements OnClickListener {
                    C137112() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(38252);
                        C29238s.this.mo47400C(c46236n);
                        AppMethodBeat.m2505o(38252);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.sns.ui.s$3$1 */
                class C137121 implements OnClickListener {
                    C137121() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(38251);
                        C29238s.this.mo47400C(c46236n);
                        AppMethodBeat.m2505o(38251);
                    }
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(38253);
                    int itemId = menuItem.getItemId();
                    C4990ab.m7410d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(itemId)));
                    C29238s c29238s;
                    C1207m c46224r;
                    Context context;
                    switch (itemId) {
                        case -1:
                            if (c46236n.cqu().xfI.wbK.size() <= 1) {
                                C30379h.m48440a(C29238s.this.context, C29238s.this.context.getString(C25738R.string.eni), "", new C137112(), null);
                                break;
                            }
                            C30379h.m48440a(C29238s.this.context, C29238s.this.context.getString(C25738R.string.enk), "", new C137121(), null);
                            AppMethodBeat.m2505o(38253);
                            return;
                        case 1:
                            c29238s = C29238s.this;
                            C46236n c46236n = c46236n;
                            if (c46236n.cqV() || c46236n.cqW()) {
                                C13373af.cnF().mo62915DL(c46236n.reX);
                                AppMethodBeat.m2505o(38253);
                                return;
                            }
                            c46224r = new C46224r(c46236n.field_snsId, 2);
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                            context = c29238s.context;
                            c29238s.context.getString(C25738R.string.f9238tz);
                            c29238s.tipDialog = C30379h.m48458b(context, c29238s.context.getString(C25738R.string.eo7), true, new C292438(c46224r));
                            AppMethodBeat.m2505o(38253);
                            return;
                        case 2:
                            if (!(c46236n == null || c46236n.cqu().xfI == null)) {
                                if (c46236n.field_type != 15) {
                                    C14987n.m23321j(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46121l(bau), C29238s.this.context);
                                    AppMethodBeat.m2505o(38253);
                                    return;
                                }
                                C29238s.m46418Zx(c46236n.cqU());
                                AppMethodBeat.m2505o(38253);
                                return;
                            }
                        case 3:
                            if (!(c46236n == null || c46236n.cqu().xfI == null)) {
                                if (c46236n.cqu().xfI.wbJ == 1) {
                                    C29238s.this.mo47402Zw(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46121l(bau));
                                    AppMethodBeat.m2505o(38253);
                                    return;
                                }
                                C29238s.m46419Zy(c46236n.cqU());
                                AppMethodBeat.m2505o(38253);
                                return;
                            }
                        case 5:
                            c29238s = C29238s.this;
                            c46224r = new C46224r(c46236n.field_snsId, 3);
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                            context = c29238s.context;
                            c29238s.context.getString(C25738R.string.f9238tz);
                            c29238s.tipDialog = C30379h.m48458b(context, c29238s.context.getString(C25738R.string.eo7), true, new C137139(c46224r));
                            AppMethodBeat.m2505o(38253);
                            return;
                        case 6:
                            if (!(c46236n == null || c46236n.cqu().xfI == null)) {
                                C29238s.m46421a(C29238s.this, c46236n, bau);
                                AppMethodBeat.m2505o(38253);
                                return;
                            }
                        case 7:
                            Bundle bundle = new Bundle();
                            bundle.putString("stat_msg_id", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                            bundle.putString("stat_send_msg_user", c46236n.field_userName);
                            bundle.putInt("stat_scene", 3);
                            C29238s.m46420a(C29238s.this, bundle);
                            AppMethodBeat.m2505o(38253);
                            return;
                        case 8:
                            C29238s.m46422a(C29238s.this, c46236n, bau, i);
                            AppMethodBeat.m2505o(38253);
                            return;
                    }
                    AppMethodBeat.m2505o(38253);
                }
            };
            this.rjm.zQf = new C292374();
            this.rjm.cpD();
        }
        if (true == z2) {
            C1720g.m3537RQ();
            if (C1720g.m3535RO().eJo.acS() != 0) {
                C45347np c45347np = new C45347np();
                String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.f13708IS) + C29036i.m46121l(bau);
                c45347np.cJU.filePath = str;
                this.riz = str;
                C4879a.xxA.mo10055m(c45347np);
            }
        }
        AppMethodBeat.m2505o(38265);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: C */
    public final void mo47400C(C46236n c46236n) {
        AppMethodBeat.m2504i(38266);
        if (c46236n.cqV() || c46236n.cqW()) {
            C13373af.cnF().mo62915DL(c46236n.reX);
            this.rjk.mo8581CK(c46236n.reX);
            AppMethodBeat.m2505o(38266);
            return;
        }
        C13373af.cnE().mo37410km(c46236n.field_snsId);
        final C1207m c46224r = new C46224r(c46236n.field_snsId, 1);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
        Context context = this.context;
        this.context.getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, this.context.getString(C25738R.string.ek6), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(38257);
                if (C29238s.this.jCq != 0) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c46224r);
                    C29238s.this.jCq = 0;
                }
                AppMethodBeat.m2505o(38257);
            }
        });
        AppMethodBeat.m2505o(38266);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Zw */
    public final void mo47402Zw(String str) {
        AppMethodBeat.m2504i(38267);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        C24826a.gkE.mo38926k(intent, this.context);
        AppMethodBeat.m2505o(38267);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(38268);
        if (i == 0 && i2 == 0 && c1207m != null) {
            C4990ab.m7416i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType() + " @" + hashCode());
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            C46224r c46224r = (C46224r) c1207m;
            switch (c46224r.type) {
                case -1:
                    this.rjl.mo8727dg("", c46224r.type);
                    AppMethodBeat.m2505o(38268);
                    return;
                case 1:
                    this.rjk.mo8581CK(c46224r.cNE);
                    this.rjl.mo8727dg(C35002v.m57490ap("sns_table_", (long) c46224r.cNE), c46224r.type);
                    AppMethodBeat.m2505o(38268);
                    return;
                case 2:
                    this.rjk.mo8582CL(c46224r.cNE);
                    this.rjl.mo8727dg("", c46224r.type);
                    AppMethodBeat.m2505o(38268);
                    return;
                case 3:
                    this.rjk.mo8582CL(c46224r.cNE);
                    this.rjl.mo8727dg(C35002v.m57490ap("sns_table_", (long) c46224r.cNE), c46224r.type);
                    break;
            }
            AppMethodBeat.m2505o(38268);
            return;
        }
        AppMethodBeat.m2505o(38268);
    }

    /* renamed from: a */
    static /* synthetic */ void m46421a(C29238s c29238s, C46236n c46236n, bau bau) {
        AppMethodBeat.m2504i(38269);
        C45316cl c45316cl;
        if (c46236n == null) {
            C4990ab.m7416i("MicroMsg.GalleryTitleManager", "error beacause info null");
            AppMethodBeat.m2505o(38269);
        } else if (c46236n.field_type == 1) {
            c45316cl = new C45316cl();
            C39739a.m67959a(c45316cl, c46236n, bau.f17915Id);
            c45316cl.cvA.activity = (Activity) c29238s.context;
            c45316cl.cvA.cvH = 15;
            C4879a.xxA.mo10055m(c45316cl);
            AppMethodBeat.m2505o(38269);
        } else {
            if (c46236n != null) {
                if (c46236n.mo74253DI(32)) {
                    c45316cl = new C45316cl();
                    C39739a.m67958a(c45316cl, c46236n);
                    c45316cl.cvA.activity = (Activity) c29238s.context;
                    c45316cl.cvA.cvH = 16;
                    C4879a.xxA.mo10055m(c45316cl);
                } else {
                    String cqU = c46236n.cqU();
                    C9463sb c9463sb = new C9463sb();
                    c9463sb.cNV.cAd = 2;
                    c9463sb.cNV.cNW = 16;
                    c9463sb.cNV.cNX = false;
                    c9463sb.cNV.czD = cqU;
                    C4879a.xxA.mo10055m(c9463sb);
                    AppMethodBeat.m2505o(38269);
                    return;
                }
            }
            AppMethodBeat.m2505o(38269);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m46422a(C29238s c29238s, C46236n c46236n, bau bau, int i) {
        AppMethodBeat.m2504i(38270);
        if (c46236n == null) {
            C4990ab.m7412e("MicroMsg.GalleryTitleManager", "error beacause info null");
            AppMethodBeat.m2505o(38270);
            return;
        }
        Intent intent = new Intent();
        if (c46236n.field_type == 1) {
            intent.putExtra("sns_send_data_ui_image_path", FlipView.m89491g(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46121l(bau), c29238s.context));
            intent.putExtra("sns_send_data_ui_image_position", i);
        }
        intent.putExtra("sns_send_data_ui_activity", true);
        intent.putExtra("sns_local_id", c46236n.cqU());
        C25985d.m41473f(c29238s.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
        AppMethodBeat.m2505o(38270);
    }

    /* renamed from: Zx */
    static /* synthetic */ void m46418Zx(String str) {
        AppMethodBeat.m2504i(38271);
        C9463sb c9463sb = new C9463sb();
        c9463sb.cNV.cAd = 3;
        c9463sb.cNV.czD = str;
        C4879a.xxA.mo10055m(c9463sb);
        AppMethodBeat.m2505o(38271);
    }

    /* renamed from: Zy */
    static /* synthetic */ void m46419Zy(String str) {
        AppMethodBeat.m2504i(38272);
        C9463sb c9463sb = new C9463sb();
        c9463sb.cNV.cAd = 1;
        c9463sb.cNV.cNY = 2;
        c9463sb.cNV.czD = str;
        C4879a.xxA.mo10055m(c9463sb);
        AppMethodBeat.m2505o(38272);
    }

    /* renamed from: a */
    static /* synthetic */ void m46420a(C29238s c29238s, Bundle bundle) {
        AppMethodBeat.m2504i(38273);
        C4990ab.m7416i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
        C26102cf c26102cf = new C26102cf();
        c26102cf.cvm.activity = (Activity) c29238s.context;
        c26102cf.cvm.ctB = c29238s.riC;
        c26102cf.cvm.cvn = c29238s.cvn;
        c26102cf.cvm.cvo = c29238s.cvo;
        c26102cf.cvm.cvs = bundle;
        C4879a.xxA.mo10055m(c26102cf);
        AppMethodBeat.m2505o(38273);
    }
}
