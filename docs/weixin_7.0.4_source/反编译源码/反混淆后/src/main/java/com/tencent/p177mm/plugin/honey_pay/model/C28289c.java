package com.tencent.p177mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p230g.p231a.C18395su;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.honey_pay.C12223a;
import com.tencent.p177mm.plugin.honey_pay.p435ui.HoneyPayCheckPwdUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.protocal.protobuf.ask;
import com.tencent.p177mm.protocal.protobuf.bab;
import com.tencent.p177mm.protocal.protobuf.bbd;
import com.tencent.p177mm.protocal.protobuf.btn;
import com.tencent.p177mm.protocal.protobuf.chl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.honey_pay.model.c */
public final class C28289c {
    private static String nqM = (C6457e.eSn + "wallet");

    /* renamed from: iR */
    public static String m44887iR(long j) {
        AppMethodBeat.m2504i(41756);
        String bigDecimal = C36391e.m59981a(String.valueOf(j), "100", 2, RoundingMode.HALF_UP).toString();
        AppMethodBeat.m2505o(41756);
        return bigDecimal;
    }

    /* renamed from: a */
    public static void m44883a(MMActivity mMActivity, Bundle bundle, ask ask, final boolean z) {
        AppMethodBeat.m2504i(41757);
        RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
        realnameGuideHelper.mo74571a(ask.vAF, ask.nZa, ask.nZb, ask.nZc, ask.nZd, 0);
        bundle.putString("realname_verify_process_jump_plugin", "honey_pay");
        realnameGuideHelper.mo74573a(mMActivity, bundle, null, new C30857a() {
            /* renamed from: n */
            public final Intent mo7785n(int i, Bundle bundle) {
                AppMethodBeat.m2504i(41752);
                if (z) {
                    C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                } else {
                    C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                }
                Intent intent = new Intent();
                AppMethodBeat.m2505o(41752);
                return intent;
            }
        }, false);
        if (z) {
            C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            AppMethodBeat.m2505o(41757);
            return;
        }
        C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.m2505o(41757);
    }

    /* renamed from: a */
    public static void m44884a(MMActivity mMActivity, btn btn, String str, int i, chl chl) {
        AppMethodBeat.m2504i(41758);
        if (!(btn == null || btn.wVw == null || btn.wVw.isEmpty())) {
            final MMActivity mMActivity2 = mMActivity;
            final btn btn2 = btn;
            final String str2 = str;
            final chl chl2 = chl;
            final int i2 = i;
            OnMenuItemClickListener c282912 = new OnMenuItemClickListener() {

                /* renamed from: com.tencent.mm.plugin.honey_pay.model.c$2$1 */
                class C282921 implements C36073c {
                    C282921() {
                    }

                    /* renamed from: a */
                    public final void mo5746a(C44273l c44273l) {
                        AppMethodBeat.m2504i(41753);
                        int i = 0;
                        Iterator it = btn2.wVw.iterator();
                        while (true) {
                            int i2 = i;
                            if (it.hasNext()) {
                                bbd bbd = (bbd) it.next();
                                if (C5046bo.isNullOrNil(bbd.jMS)) {
                                    i = i2;
                                } else {
                                    if (C5046bo.isNullOrNil(bbd.color)) {
                                        c44273l.mo70068e(i2, bbd.jMS);
                                    } else {
                                        c44273l.mo70048a(i2, Color.parseColor(bbd.color), bbd.jMS);
                                    }
                                    i = i2 + 1;
                                }
                            } else {
                                AppMethodBeat.m2505o(41753);
                                return;
                            }
                        }
                    }
                }

                /* renamed from: com.tencent.mm.plugin.honey_pay.model.c$2$2 */
                class C282932 implements C5279d {
                    C282932() {
                    }

                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(41754);
                        bbd bbd = (bbd) btn2.wVw.get(i);
                        if (!C5046bo.isNullOrNil(bbd.url)) {
                            if (!bbd.url.equals("weixin://wcpay/honeypay/unbind") || C5046bo.isNullOrNil(str2) || chl2 == null) {
                                C36391e.m60016n(mMActivity2, bbd.url, false);
                            } else {
                                C4990ab.m7416i("MicroMsg.HoneyPayUtil", "go to unbind");
                                Intent intent = new Intent(mMActivity2, HoneyPayCheckPwdUI.class);
                                intent.putExtra("key_scene", 3);
                                intent.putExtra("key_card_no", str2);
                                try {
                                    intent.putExtra("key_toke_mess", chl2.toByteArray());
                                } catch (IOException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.HoneyPayUtil", e, "", new Object[0]);
                                }
                                mMActivity2.startActivityForResult(intent, i2);
                                AppMethodBeat.m2505o(41754);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(41754);
                    }
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.m2504i(41755);
                    C36356d c36356d = new C36356d(mMActivity2, 1, false);
                    c36356d.rBl = new C282921();
                    c36356d.rBm = new C282932();
                    c36356d.cpD();
                    AppMethodBeat.m2505o(41755);
                    return false;
                }
            };
            if (C5046bo.isNullOrNil(btn.title)) {
                mMActivity.addIconOptionMenu(0, C1318a.actionbar_dark_icon_more, c282912);
            } else {
                mMActivity.mo17382a(btn.title, (int) C25738R.color.a69, c282912);
                AppMethodBeat.m2505o(41758);
                return;
            }
        }
        AppMethodBeat.m2505o(41758);
    }

    /* renamed from: b */
    public static void m44885b(MMActivity mMActivity, btn btn, String str, int i, chl chl) {
        AppMethodBeat.m2504i(41759);
        C28289c.m44884a(mMActivity, btn, str, i, chl);
        AppMethodBeat.m2505o(41759);
    }

    /* renamed from: z */
    public static String m44891z(String str, String str2, int i) {
        AppMethodBeat.m2504i(41761);
        String replace;
        if (i >= 0) {
            replace = str.replace("$" + str2 + "$", C36391e.m60007eK(C36391e.m60015mJ(str2), i));
            AppMethodBeat.m2505o(41761);
            return replace;
        }
        replace = str.replace("$" + str2 + "$", C36391e.m60015mJ(str2));
        AppMethodBeat.m2505o(41761);
        return replace;
    }

    /* renamed from: eG */
    public static String m44886eG(String str, String str2) {
        AppMethodBeat.m2504i(41762);
        String z = C28289c.m44891z(str, str2, -1);
        AppMethodBeat.m2505o(41762);
        return z;
    }

    static {
        AppMethodBeat.m2504i(41769);
        AppMethodBeat.m2505o(41769);
    }

    /* renamed from: Y */
    public static int m44881Y(int i, boolean z) {
        AppMethodBeat.m2504i(41763);
        int i2;
        if (z) {
            i2 = -1;
            if (i == 1) {
                i2 = C1318a.honey_pay_grey_father_card_icon;
            } else if (i == 2) {
                i2 = C1318a.honey_pay_grey_mother_card_icon;
            } else if (i == 3) {
                i2 = C1318a.honey_pay_grey_child_card_icon;
            }
            AppMethodBeat.m2505o(41763);
            return i2;
        }
        i2 = C28289c.m44890wS(i);
        AppMethodBeat.m2505o(41763);
        return i2;
    }

    /* renamed from: wS */
    public static int m44890wS(int i) {
        if (i == 1) {
            return C1318a.honey_pay_father_card_icon;
        }
        if (i == 2) {
            return C1318a.honey_pay_mother_card_icon;
        }
        if (i == 3) {
            return C1318a.honey_pay_child_card_icon;
        }
        return -1;
    }

    public static int bFX() {
        return C1318a.honey_pay_input_logo;
    }

    /* renamed from: U */
    public static void m44879U(String str, String str2, String str3) {
        AppMethodBeat.m2504i(41764);
        C28289c.m44889o(str, str2, str3, null);
        AppMethodBeat.m2505o(41764);
    }

    /* renamed from: o */
    public static void m44889o(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(41765);
        C4990ab.m7417i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", str, Boolean.valueOf(C5046bo.isNullOrNil(str2)));
        if (!(C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str))) {
            String str5;
            String z = C28289c.m44891z(str2, str3, 6);
            if (C5046bo.isNullOrNil(str4)) {
                str5 = z;
            } else {
                str5 = C28289c.m44891z(z, str4, 6);
            }
            C34334a c34334a = new C34334a();
            c34334a.field_payMsgId = str;
            C12223a.bFV().bFW().mo10102b((C4925c) c34334a, new String[0]);
            if (c34334a.field_msgId > 0) {
                C4990ab.m7417i("MicroMsg.HoneyPayUtil", "find msg: %s", Long.valueOf(c34334a.field_msgId));
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c34334a.field_msgId);
                if (jf.field_msgId > 0) {
                    jf.setContent(str5);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
                    AppMethodBeat.m2505o(41765);
                    return;
                }
                C4990ab.m7421w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", Long.valueOf(c34334a.field_msgId));
            }
        }
        AppMethodBeat.m2505o(41765);
    }

    /* renamed from: V */
    public static void m44880V(String str, String str2, String str3) {
        AppMethodBeat.m2504i(41766);
        C4990ab.m7417i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", str, Boolean.valueOf(C5046bo.isNullOrNil(str2)));
        if (!(C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str))) {
            String z = C28289c.m44891z(C28289c.m44891z(str2, str, -1), str3, -1);
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo14781hO(0);
            c7620bi.mo14794ju(str);
            c7620bi.setStatus(3);
            c7620bi.setContent(z);
            c7620bi.mo14775eJ(C1829bf.m3764q(str, System.currentTimeMillis() / 1000));
            c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            c7620bi.mo14783hY(c7620bi.field_flag | 8);
            C4990ab.m7417i("MicroMsg.HoneyPayUtil", "insert msgId: %s", Long.valueOf(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi)));
            if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi) <= 0) {
                C4990ab.m7420w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
            }
        }
        AppMethodBeat.m2505o(41766);
    }

    /* renamed from: iS */
    public static String m44888iS(long j) {
        AppMethodBeat.m2504i(41768);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000 * j));
        AppMethodBeat.m2505o(41768);
        return format;
    }

    /* renamed from: a */
    public static void m44882a(Context context, bab bab, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(41760);
        C30379h.m48445a(context, bab.cEh, "", bab.nZc, bab.nZb, false, onClickListener, null);
        AppMethodBeat.m2505o(41760);
    }

    /* renamed from: OC */
    public static void m44878OC(String str) {
        AppMethodBeat.m2504i(41767);
        C18416uq c18416uq = new C18416uq();
        c18416uq.cQP.scene = 8;
        C4879a.xxA.mo10055m(c18416uq);
        C4990ab.m7416i("MicroMsg.HoneyPayUtil", "trigger offline event");
        C18395su c18395su = new C18395su();
        c18395su.cOT.cOU = false;
        c18395su.cOT.scene = 1;
        c18395su.cOT.cOV = true;
        c18395su.cOT.cOW = 65281;
        C4879a.xxA.mo10055m(c18395su);
        if (!C5046bo.isNullOrNil(str)) {
            C28630a.m45497Ue(str);
        }
        AppMethodBeat.m2505o(41767);
    }
}
