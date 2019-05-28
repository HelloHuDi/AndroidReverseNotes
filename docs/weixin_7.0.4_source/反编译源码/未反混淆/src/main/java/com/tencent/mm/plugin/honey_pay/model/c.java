package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public final class c {
    private static String nqM = (e.eSn + "wallet");

    public static String iR(long j) {
        AppMethodBeat.i(41756);
        String bigDecimal = com.tencent.mm.wallet_core.ui.e.a(String.valueOf(j), "100", 2, RoundingMode.HALF_UP).toString();
        AppMethodBeat.o(41756);
        return bigDecimal;
    }

    public static void a(MMActivity mMActivity, Bundle bundle, ask ask, final boolean z) {
        AppMethodBeat.i(41757);
        RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
        realnameGuideHelper.a(ask.vAF, ask.nZa, ask.nZb, ask.nZc, ask.nZd, 0);
        bundle.putString("realname_verify_process_jump_plugin", "honey_pay");
        realnameGuideHelper.a(mMActivity, bundle, null, new a() {
            public final Intent n(int i, Bundle bundle) {
                AppMethodBeat.i(41752);
                if (z) {
                    h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                } else {
                    h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                }
                Intent intent = new Intent();
                AppMethodBeat.o(41752);
                return intent;
            }
        }, false);
        if (z) {
            h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            AppMethodBeat.o(41757);
            return;
        }
        h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.o(41757);
    }

    public static void a(MMActivity mMActivity, btn btn, String str, int i, chl chl) {
        AppMethodBeat.i(41758);
        if (!(btn == null || btn.wVw == null || btn.wVw.isEmpty())) {
            final MMActivity mMActivity2 = mMActivity;
            final btn btn2 = btn;
            final String str2 = str;
            final chl chl2 = chl;
            final int i2 = i;
            OnMenuItemClickListener anonymousClass2 = new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(41755);
                    d dVar = new d(mMActivity2, 1, false);
                    dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(41753);
                            int i = 0;
                            Iterator it = btn2.wVw.iterator();
                            while (true) {
                                int i2 = i;
                                if (it.hasNext()) {
                                    bbd bbd = (bbd) it.next();
                                    if (bo.isNullOrNil(bbd.jMS)) {
                                        i = i2;
                                    } else {
                                        if (bo.isNullOrNil(bbd.color)) {
                                            lVar.e(i2, bbd.jMS);
                                        } else {
                                            lVar.a(i2, Color.parseColor(bbd.color), bbd.jMS);
                                        }
                                        i = i2 + 1;
                                    }
                                } else {
                                    AppMethodBeat.o(41753);
                                    return;
                                }
                            }
                        }
                    };
                    dVar.rBm = new n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(41754);
                            bbd bbd = (bbd) btn2.wVw.get(i);
                            if (!bo.isNullOrNil(bbd.url)) {
                                if (!bbd.url.equals("weixin://wcpay/honeypay/unbind") || bo.isNullOrNil(str2) || chl2 == null) {
                                    com.tencent.mm.wallet_core.ui.e.n(mMActivity2, bbd.url, false);
                                } else {
                                    ab.i("MicroMsg.HoneyPayUtil", "go to unbind");
                                    Intent intent = new Intent(mMActivity2, HoneyPayCheckPwdUI.class);
                                    intent.putExtra("key_scene", 3);
                                    intent.putExtra("key_card_no", str2);
                                    try {
                                        intent.putExtra("key_toke_mess", chl2.toByteArray());
                                    } catch (IOException e) {
                                        ab.printErrStackTrace("MicroMsg.HoneyPayUtil", e, "", new Object[0]);
                                    }
                                    mMActivity2.startActivityForResult(intent, i2);
                                    AppMethodBeat.o(41754);
                                    return;
                                }
                            }
                            AppMethodBeat.o(41754);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(41755);
                    return false;
                }
            };
            if (bo.isNullOrNil(btn.title)) {
                mMActivity.addIconOptionMenu(0, R.raw.actionbar_dark_icon_more, anonymousClass2);
            } else {
                mMActivity.a(btn.title, (int) R.color.a69, anonymousClass2);
                AppMethodBeat.o(41758);
                return;
            }
        }
        AppMethodBeat.o(41758);
    }

    public static void b(MMActivity mMActivity, btn btn, String str, int i, chl chl) {
        AppMethodBeat.i(41759);
        a(mMActivity, btn, str, i, chl);
        AppMethodBeat.o(41759);
    }

    public static String z(String str, String str2, int i) {
        AppMethodBeat.i(41761);
        String replace;
        if (i >= 0) {
            replace = str.replace("$" + str2 + "$", com.tencent.mm.wallet_core.ui.e.eK(com.tencent.mm.wallet_core.ui.e.mJ(str2), i));
            AppMethodBeat.o(41761);
            return replace;
        }
        replace = str.replace("$" + str2 + "$", com.tencent.mm.wallet_core.ui.e.mJ(str2));
        AppMethodBeat.o(41761);
        return replace;
    }

    public static String eG(String str, String str2) {
        AppMethodBeat.i(41762);
        String z = z(str, str2, -1);
        AppMethodBeat.o(41762);
        return z;
    }

    static {
        AppMethodBeat.i(41769);
        AppMethodBeat.o(41769);
    }

    public static int Y(int i, boolean z) {
        AppMethodBeat.i(41763);
        int i2;
        if (z) {
            i2 = -1;
            if (i == 1) {
                i2 = R.raw.honey_pay_grey_father_card_icon;
            } else if (i == 2) {
                i2 = R.raw.honey_pay_grey_mother_card_icon;
            } else if (i == 3) {
                i2 = R.raw.honey_pay_grey_child_card_icon;
            }
            AppMethodBeat.o(41763);
            return i2;
        }
        i2 = wS(i);
        AppMethodBeat.o(41763);
        return i2;
    }

    public static int wS(int i) {
        if (i == 1) {
            return R.raw.honey_pay_father_card_icon;
        }
        if (i == 2) {
            return R.raw.honey_pay_mother_card_icon;
        }
        if (i == 3) {
            return R.raw.honey_pay_child_card_icon;
        }
        return -1;
    }

    public static int bFX() {
        return R.raw.honey_pay_input_logo;
    }

    public static void U(String str, String str2, String str3) {
        AppMethodBeat.i(41764);
        o(str, str2, str3, null);
        AppMethodBeat.o(41764);
    }

    public static void o(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(41765);
        ab.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", str, Boolean.valueOf(bo.isNullOrNil(str2)));
        if (!(bo.isNullOrNil(str2) || bo.isNullOrNil(str))) {
            String str5;
            String z = z(str2, str3, 6);
            if (bo.isNullOrNil(str4)) {
                str5 = z;
            } else {
                str5 = z(z, str4, 6);
            }
            a aVar = new a();
            aVar.field_payMsgId = str;
            com.tencent.mm.plugin.honey_pay.a.bFV().bFW().b((com.tencent.mm.sdk.e.c) aVar, new String[0]);
            if (aVar.field_msgId > 0) {
                ab.i("MicroMsg.HoneyPayUtil", "find msg: %s", Long.valueOf(aVar.field_msgId));
                bi jf = ((j) g.K(j.class)).bOr().jf(aVar.field_msgId);
                if (jf.field_msgId > 0) {
                    jf.setContent(str5);
                    ((j) g.K(j.class)).bOr().a(jf.field_msgId, jf);
                    AppMethodBeat.o(41765);
                    return;
                }
                ab.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", Long.valueOf(aVar.field_msgId));
            }
        }
        AppMethodBeat.o(41765);
    }

    public static void V(String str, String str2, String str3) {
        AppMethodBeat.i(41766);
        ab.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", str, Boolean.valueOf(bo.isNullOrNil(str2)));
        if (!(bo.isNullOrNil(str2) || bo.isNullOrNil(str))) {
            String z = z(z(str2, str, -1), str3, -1);
            bi biVar = new bi();
            biVar.hO(0);
            biVar.ju(str);
            biVar.setStatus(3);
            biVar.setContent(z);
            biVar.eJ(bf.q(str, System.currentTimeMillis() / 1000));
            biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            biVar.hY(biVar.field_flag | 8);
            ab.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", Long.valueOf(((j) g.K(j.class)).bOr().Z(biVar)));
            if (((j) g.K(j.class)).bOr().Z(biVar) <= 0) {
                ab.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
            }
        }
        AppMethodBeat.o(41766);
    }

    public static String iS(long j) {
        AppMethodBeat.i(41768);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000 * j));
        AppMethodBeat.o(41768);
        return format;
    }

    public static void a(Context context, bab bab, OnClickListener onClickListener) {
        AppMethodBeat.i(41760);
        com.tencent.mm.ui.base.h.a(context, bab.cEh, "", bab.nZc, bab.nZb, false, onClickListener, null);
        AppMethodBeat.o(41760);
    }

    public static void OC(String str) {
        AppMethodBeat.i(41767);
        uq uqVar = new uq();
        uqVar.cQP.scene = 8;
        com.tencent.mm.sdk.b.a.xxA.m(uqVar);
        ab.i("MicroMsg.HoneyPayUtil", "trigger offline event");
        su suVar = new su();
        suVar.cOT.cOU = false;
        suVar.cOT.scene = 1;
        suVar.cOT.cOV = true;
        suVar.cOT.cOW = 65281;
        com.tencent.mm.sdk.b.a.xxA.m(suVar);
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.plugin.offline.c.a.Ue(str);
        }
        AppMethodBeat.o(41767);
    }
}
