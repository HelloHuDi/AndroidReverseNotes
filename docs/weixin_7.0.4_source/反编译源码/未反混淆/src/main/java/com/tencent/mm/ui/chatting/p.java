package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.j;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.subapp.c.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.b;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.e;
import com.tencent.mm.ui.chatting.c.b.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p implements b {
    public static boolean yJd = true;
    private ad ehM;
    private final ap gci = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(30630);
            p.this.oor.Lf(p.this.yJe.getMaxAmplitude());
            AppMethodBeat.o(30630);
            return true;
        }
    }, true);
    private Vibrator kgA;
    private Object lock = new Object();
    private final ap miP = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(30631);
            long EV = p.this.yJe.EV();
            ab.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(EV)));
            if (EV >= 50000 && EV <= 60000) {
                if (!p.this.yJm) {
                    bo.gM(p.this.yod.yTx.getContext());
                    p.this.yJm = true;
                }
                int i = (int) ((60000 - EV) / 1000);
                p.this.oor.setRecordNormalWording(p.this.yod.yTx.getMMResources().getQuantityString(R.plurals.c, i, new Object[]{Integer.valueOf(i)}));
            }
            if (EV >= 60000) {
                ab.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
                p.l(p.this);
                p.this.oor.bvH();
                ay.au(p.this.yod.yTx.getContext(), R.string.ew8);
                AppMethodBeat.o(30631);
                return false;
            }
            AppMethodBeat.o(30631);
            return true;
        }
    }, true);
    private ChatFooter oor;
    private ToneGenerator oot;
    private final j.a oox = new j.a() {
        public final void onError() {
            AppMethodBeat.i(30623);
            p.this.yJe.reset();
            p.this.gci.stopTimer();
            p.this.miP.stopTimer();
            aj.amB("keep_app_silent");
            p.this.oor.bvH();
            ((com.tencent.mm.ui.chatting.c.b.aj) p.this.yod.aF(com.tencent.mm.ui.chatting.c.b.aj.class)).dFm().dBx();
            ab.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
            p.this.yod.yTx.enableOptionMenu(true);
            p.this.yod.yTx.enableBackMenu(true);
            Toast.makeText(p.this.yod.yTx.getContext(), p.this.yod.yTx.getContext().getString(R.string.anm), 0).show();
            AppMethodBeat.o(30623);
        }
    };
    private final j.b ooy = new j.b() {
        public final void acE() {
            AppMethodBeat.i(30626);
            p.this.oor.dki();
            AppMethodBeat.o(30626);
        }
    };
    private AppPanel.a ope = new AppPanel.a() {
        d pki = null;

        public final void bNO() {
            AppMethodBeat.i(30637);
            if (com.tencent.mm.r.a.bH(p.this.yod.yTx.getContext())) {
                AppMethodBeat.o(30637);
                return;
            }
            uh uhVar = new uh();
            com.tencent.mm.sdk.b.a.xxA.m(uhVar);
            if (p.this.getTalkerUserName() == null || p.this.getTalkerUserName().equals(uhVar.cQt.talker) || !(uhVar.cQt.cQv || uhVar.cQt.cQw)) {
                if (1 == g.Nu().getInt("EnableVoiceVoipFromPlugin", 0)) {
                    boolean z = (ad.aox(p.this.yod.sRl.field_username) || t.mP(p.this.yod.sRl.field_username)) ? (((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).vi(p.this.yod.sRl.field_openImAppid) & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 : false;
                    this.pki = new d(p.this.yod.yTx.getContext(), 1, false);
                    this.pki.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(30632);
                            lVar.ax(2, R.string.qh, R.raw.sharemore_videovoip);
                            if (!z) {
                                lVar.ax(1, R.string.qj, R.raw.sharemore_voipvoice);
                            }
                            AppMethodBeat.o(30632);
                        }
                    };
                    this.pki.rBm = new n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(30633);
                            switch (menuItem.getItemId()) {
                                case 1:
                                    p.this.cbl();
                                    AppMethodBeat.o(30633);
                                    return;
                                case 2:
                                    p.this.cbm();
                                    break;
                            }
                            AppMethodBeat.o(30633);
                        }
                    };
                    this.pki.cpD();
                } else {
                    p.this.dCl();
                }
                h.pYm.e(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
                AppMethodBeat.o(30637);
                return;
            }
            Toast.makeText(p.this.yod.yTx.getContext(), uhVar.cQt.cQu ? R.string.ac6 : R.string.ac7, 0).show();
            ab.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(30637);
        }

        public final void bNP() {
            AppMethodBeat.i(30638);
            if (com.tencent.mm.r.a.bH(p.this.yod.yTx.getContext())) {
                AppMethodBeat.o(30638);
                return;
            }
            uh uhVar = new uh();
            com.tencent.mm.sdk.b.a.xxA.m(uhVar);
            if (p.this.getTalkerUserName().equals(uhVar.cQt.talker) || !(uhVar.cQt.cQv || uhVar.cQt.cQw)) {
                p.this.dCk();
                AppMethodBeat.o(30638);
                return;
            }
            Toast.makeText(p.this.yod.yTx.getContext(), uhVar.cQt.cQu ? R.string.ac6 : R.string.ac7, 0).show();
            ab.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(30638);
        }

        public final void bNQ() {
            AppMethodBeat.i(30639);
            if (!(com.tencent.mm.r.a.bJ(p.this.yod.yTx.getContext()) || com.tencent.mm.r.a.bH(p.this.yod.yTx.getContext()))) {
                ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(p.this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 81, "", "")), bo.dpG(), p.this.yod.yTx.getContext());
                if (com.tencent.mm.pluginsdk.permission.b.a(p.this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 81, "", "")) {
                    p.this.dCm();
                } else {
                    AppMethodBeat.o(30639);
                    return;
                }
            }
            AppMethodBeat.o(30639);
        }

        public final void bNR() {
            AppMethodBeat.i(30640);
            ((u) p.this.yod.aF(u.class)).dEH();
            AppMethodBeat.o(30640);
        }

        public final void bNS() {
            AppMethodBeat.i(30641);
            ((e) p.this.yod.aF(e.class)).dDD();
            AppMethodBeat.o(30641);
        }

        public final void ys(int i) {
            AppMethodBeat.i(30642);
            switch (i) {
                case 0:
                    File file = new File(com.tencent.mm.compatible.util.e.euR);
                    if (file.exists() || file.mkdir()) {
                        ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(p.this.yod.yTx.getContext(), "android.permission.CAMERA", 20, "", "")), bo.dpG(), p.this.yod.yTx.getContext());
                        if (com.tencent.mm.pluginsdk.permission.b.a(p.this.yod.yTx.getContext(), "android.permission.CAMERA", 20, "", "")) {
                            p.this.dCn();
                            break;
                        } else {
                            AppMethodBeat.o(30642);
                            return;
                        }
                    }
                    Toast.makeText(p.this.yod.yTx.getContext(), p.this.yod.yTx.getMMResources().getString(R.string.aor), 1).show();
                    AppMethodBeat.o(30642);
                    return;
                    break;
                case 1:
                    String string = p.this.yod.yTx.getContext().getSharedPreferences(ah.doA(), 0).getString("gallery", "1");
                    com.tencent.mm.plugin.report.service.g.BN(19);
                    if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        com.tencent.mm.pluginsdk.ui.tools.n.e(p.this.yod.yTx);
                    } else {
                        string = p.this.yod.dFu();
                        String talkerUserName = p.this.yod.getTalkerUserName();
                        if (p.this.yJj && p.yJd) {
                            com.tencent.mm.pluginsdk.ui.tools.n.b(p.this.yod.yTx, 3, string, talkerUserName);
                        } else if (ad.mg(talkerUserName)) {
                            com.tencent.mm.pluginsdk.ui.tools.n.a(p.this.yod.yTx, 12, string, talkerUserName);
                        } else {
                            com.tencent.mm.pluginsdk.ui.tools.n.a(p.this.yod.yTx, 3, string, talkerUserName);
                        }
                    }
                    h.pYm.e(13822, Integer.valueOf(2), Integer.valueOf(1));
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(30634);
                            p.this.oor.setBottomPanelVisibility(8);
                            AppMethodBeat.o(30634);
                        }
                    }, 1000);
                    AppMethodBeat.o(30642);
                    return;
            }
            AppMethodBeat.o(30642);
        }

        public final void b(f fVar) {
            AppMethodBeat.i(30643);
            ((com.tencent.mm.ui.chatting.c.b.b) p.this.yod.aF(com.tencent.mm.ui.chatting.c.b.b.class)).q(fVar);
            AppMethodBeat.o(30643);
        }

        public final void bNT() {
            AppMethodBeat.i(30644);
            com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
            AppMethodBeat.o(30644);
        }

        public final void bNU() {
            AppMethodBeat.i(30645);
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            if (com.tencent.mm.aj.f.kq(p.this.ehM.field_username)) {
                arrayList.add("4");
                arrayList.add("7");
                arrayList.add("9");
                arrayList.add(PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
                arrayList.add("11");
                arrayList.add("12");
                arrayList.add("13");
                arrayList.add("15");
                arrayList.add("16");
                arrayList.add("17");
                arrayList.add("18");
            }
            intent.putExtra("key_to_user", p.this.ehM.field_username);
            intent.putExtra("key_fav_item_id", TextUtils.join(",", arrayList));
            com.tencent.mm.plugin.fav.a.b.b(p.this.yod.yTx.getContext(), ".ui.FavSelectUI", intent);
            h.pYm.e(14103, Integer.valueOf(1));
            AppMethodBeat.o(30645);
        }

        public final void bNV() {
            AppMethodBeat.i(30646);
            Intent intent = new Intent();
            intent.putExtra("service_app_talker_user", p.this.getTalkerUserName());
            com.tencent.mm.bp.d.a(p.this.yod.yTx, "subapp", ".ui.openapi.ServiceAppUI", intent, 222);
            AppMethodBeat.o(30646);
        }

        public final void bNW() {
            AppMethodBeat.i(30647);
            Intent intent = new Intent();
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("preceding_scence", 13);
            com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            h.pYm.e(12065, Integer.valueOf(4));
            AppMethodBeat.o(30647);
        }

        public final void yt(int i) {
            AppMethodBeat.i(30648);
            if (!(com.tencent.mm.r.a.bI(p.this.yod.yTx.getContext()) || com.tencent.mm.r.a.bJ(p.this.yod.yTx.getContext()) || com.tencent.mm.r.a.bH(p.this.yod.yTx.getContext()))) {
                p.this.Om(i);
            }
            AppMethodBeat.o(30648);
        }

        public final void bNX() {
            AppMethodBeat.i(30649);
            h.pYm.e(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            h.pYm.e(11850, Integer.valueOf(4), Integer.valueOf(1));
            Intent intent;
            if (p.this.yJh) {
                h.pYm.e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2));
                intent = new Intent();
                int mA = com.tencent.mm.model.n.mA(p.this.getTalkerUserName());
                intent.putExtra("key_way", 1);
                intent.putExtra("key_chatroom_num", mA);
                intent.putExtra("key_type", 1);
                intent.putExtra("key_from", 1);
                intent.putExtra("key_username", p.this.getTalkerUserName());
                intent.putExtra("pay_channel", 14);
                com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                AppMethodBeat.o(30649);
                return;
            }
            aw.ZK();
            Integer num = (Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(0));
            aw.ZK();
            Integer num2 = (Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0));
            if (num.intValue() == 1 || num2.intValue() == 1) {
                int i;
                if (r.YG() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    com.tencent.mm.g.b.a.l lVar = new com.tencent.mm.g.b.a.l();
                    lVar.cVT = 13;
                    lVar.ajK();
                    com.tencent.mm.ui.base.h.a(p.this.yod.yTx.getContext(), null, new String[]{p.this.yod.yTx.getMMResources().getString(R.string.amt), p.this.yod.yTx.getMMResources().getString(R.string.ams)}, null, new com.tencent.mm.ui.base.h.c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(30635);
                            Intent intent = new Intent();
                            switch (i) {
                                case 0:
                                    h.pYm.e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
                                    intent.putExtra("key_way", 0);
                                    intent.putExtra("key_type", 0);
                                    intent.putExtra("key_from", 1);
                                    intent.putExtra("key_username", p.this.getTalkerUserName());
                                    intent.putExtra("pay_channel", 11);
                                    com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                                    AppMethodBeat.o(30635);
                                    return;
                                case 1:
                                    h.pYm.e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
                                    intent.putExtra("key_username", p.this.getTalkerUserName());
                                    intent.putExtra("key_way", 0);
                                    intent.putExtra("pay_channel", 11);
                                    com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", intent);
                                    com.tencent.mm.g.b.a.l lVar = new com.tencent.mm.g.b.a.l();
                                    lVar.cVT = 1;
                                    lVar.ajK();
                                    break;
                            }
                            AppMethodBeat.o(30635);
                        }
                    });
                    AppMethodBeat.o(30649);
                    return;
                }
            }
            h.pYm.e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
            intent = new Intent();
            intent.putExtra("key_way", 0);
            intent.putExtra("key_type", 0);
            intent.putExtra("key_from", 1);
            intent.putExtra("key_username", p.this.getTalkerUserName());
            intent.putExtra("pay_channel", 11);
            com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
            AppMethodBeat.o(30649);
        }

        public final void bNY() {
            AppMethodBeat.i(30650);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(81, Boolean.FALSE);
            if (at.isNetworkConnected(p.this.yod.yTx.getContext())) {
                p.this.dCj();
                AppMethodBeat.o(30650);
                return;
            }
            com.tencent.mm.bg.e.a(p.this.yod.yTx.getContext(), R.string.f6c, null);
            AppMethodBeat.o(30650);
        }

        public final void bNZ() {
            AppMethodBeat.i(30651);
            Intent intent = new Intent();
            intent.putExtra("enterprise_scene", 4);
            intent.putExtra("enterprise_biz_name", p.this.getTalkerUserName());
            intent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.c.b.d) p.this.yod.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDz());
            com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent);
            AppMethodBeat.o(30651);
        }

        public final void bOa() {
            AppMethodBeat.i(30652);
            if (p.this.yJh) {
                Intent intent = new Intent();
                intent.putExtra("enter_scene", 1);
                intent.putExtra("chatroom_name", p.this.getTalkerUserName());
                com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "aa", ".ui.LaunchAAUI", intent);
            }
            AppMethodBeat.o(30652);
        }

        public final void bOb() {
            AppMethodBeat.i(30653);
            h.pYm.e(14523, Integer.valueOf(0));
            Intent intent = new Intent();
            intent.setClass(p.this.yod.yTx.getContext(), NewFileExplorerUI.class);
            intent.putExtra("TO_USER", p.this.yJf);
            p.this.yod.a(intent, 227, new com.tencent.mm.bp.d.a() {
                public final void onActivityResult(int i, int i2, Intent intent) {
                    AppMethodBeat.i(30636);
                    if (i == 227) {
                        p.a(p.this, p.this.yod, i2, intent);
                    }
                    AppMethodBeat.o(30636);
                }
            });
            AppMethodBeat.o(30653);
        }
    };
    private boolean yFW;
    private j yJe;
    private String yJf;
    private String yJg;
    private boolean yJh;
    private boolean yJi;
    public boolean yJj;
    private volatile boolean yJk = false;
    private volatile boolean yJl = false;
    private boolean yJm = false;
    com.tencent.mm.ui.chatting.d.a yod;

    static /* synthetic */ void dCo() {
        AppMethodBeat.i(30681);
        Ol(0);
        AppMethodBeat.o(30681);
    }

    static /* synthetic */ boolean l(p pVar) {
        AppMethodBeat.i(30682);
        boolean dCg = pVar.dCg();
        AppMethodBeat.o(30682);
        return dCg;
    }

    public p(com.tencent.mm.ui.chatting.d.a aVar, ChatFooter chatFooter, String str) {
        AppMethodBeat.i(30655);
        this.yod = aVar;
        this.oor = chatFooter;
        this.yJf = str;
        aw.ZK();
        this.ehM = com.tencent.mm.model.c.XM().aoO(str);
        this.yJh = t.kH(this.yod.getTalkerUserName());
        this.yJi = t.mT(this.yod.getTalkerUserName());
        boolean z = this.yJh || this.yJi;
        this.yFW = z;
        this.kgA = (Vibrator) this.yod.yTx.getContext().getSystemService("vibrator");
        if (t.nv(this.yJf)) {
            this.yJe = new i();
            ab.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
        } else {
            String str2 = this.yJf;
            if (t.nG(str2)) {
                z = true;
            } else {
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str2);
                if (aoO != null && aoO.dsf()) {
                    com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(aoO.field_username);
                    if (qX != null) {
                        com.tencent.mm.aj.d.b cJ = qX.cJ(false);
                        if (cJ != null) {
                            if (cJ.fvc != null) {
                                cJ.fvg = "1".equals(cJ.fvc.optString("CanReceiveSpeexVoice"));
                            }
                            if (cJ.fvg) {
                                ab.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + aoO.field_username + " canReceiveSpeexVoice");
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (z) {
                this.yJe = new com.tencent.mm.audio.b.h(this.yod.yTx.getContext(), true);
                ab.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
            } else {
                this.yJe = new com.tencent.mm.audio.b.h(this.yod.yTx.getContext(), false);
                ab.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
            }
        }
        this.yJe.a(this.ooy);
        this.yJe.a(this.oox);
        chatFooter.setAppPanelListener(this.ope);
        AppMethodBeat.o(30655);
    }

    public final boolean bNG() {
        AppMethodBeat.i(30656);
        synchronized (this.lock) {
            try {
                this.yJk = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(30656);
            }
        }
        if (this.yJl) {
            this.yJl = false;
            releaseWakeLock();
            if (dCg()) {
                this.oor.bvH();
                ab.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
            } else {
                this.oor.ddN();
                ab.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
            }
            ((com.tencent.mm.ui.chatting.c.b.aj) this.yod.aF(com.tencent.mm.ui.chatting.c.b.aj.class)).dFm().dBx();
            ((com.tencent.mm.ui.chatting.c.b.ab) this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).OE(4);
            ((com.tencent.mm.ui.chatting.c.b.ab) this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).stopSignalling();
            Ol(1);
            ((com.tencent.mm.ui.chatting.c.b.aj) this.yod.aF(com.tencent.mm.ui.chatting.c.b.aj.class)).a(this.yod.yTx, false);
            AppMethodBeat.o(30656);
            return true;
        }
        boolean z = "MicroMsg.ChattingFooterEventImpl";
        ab.i(z, "jacks in voice rcd stop but not begin.");
        return z;
    }

    public final boolean bNI() {
        AppMethodBeat.i(30657);
        ab.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
        synchronized (this.lock) {
            try {
                this.yJk = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(30657);
            }
        }
        if (this.yJl) {
            this.yJl = false;
            releaseWakeLock();
            this.yod.yTx.enableOptionMenu(true);
            this.yod.yTx.enableBackMenu(true);
            if (this.yJe != null) {
                this.yJe.cancel();
                this.gci.stopTimer();
                this.miP.stopTimer();
            }
            this.oor.bvH();
            ((com.tencent.mm.ui.chatting.c.b.aj) this.yod.aF(com.tencent.mm.ui.chatting.c.b.aj.class)).dFm().dBx();
            ((com.tencent.mm.ui.chatting.c.b.ab) this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).OE(4);
            ((com.tencent.mm.ui.chatting.c.b.ab) this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).stopSignalling();
            Ol(1);
            ((com.tencent.mm.ui.chatting.c.b.aj) this.yod.aF(com.tencent.mm.ui.chatting.c.b.aj.class)).a(this.yod.yTx, false);
            AppMethodBeat.o(30657);
            return true;
        }
        boolean z = "MicroMsg.ChattingFooterEventImpl";
        ab.i(z, "jacks in voice rcd stop but not begin.");
        return z;
    }

    public final boolean bNJ() {
        AppMethodBeat.i(30658);
        if (com.tencent.mm.r.a.bJ(this.yod.yTx.getContext()) || com.tencent.mm.r.a.bH(this.yod.yTx.getContext())) {
            ab.d("MicroMsg.ChattingFooterEventImpl", "voip is running, cann't record voice");
            AppMethodBeat.o(30658);
            return false;
        }
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (!com.tencent.mm.compatible.f.b.Mi()) {
                com.tencent.mm.ui.base.h.a(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(R.string.tv), this.yod.yTx.getMMResources().getString(R.string.rw), this.yod.yTx.getMMResources().getString(R.string.ry), true, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(30627);
                        com.tencent.mm.compatible.f.b.bE(p.this.yod.yTx.getContext());
                        AppMethodBeat.o(30627);
                    }
                });
            }
            if (this.yJe != null) {
                if (this.oot == null) {
                    try {
                        this.oot = new ToneGenerator(3, (int) ((((float) this.yod.yTx.getStreamMaxVolume(3)) / ((float) this.yod.yTx.getStreamVolume(3))) * 100.0f));
                        ab.i("MicroMsg.ChattingFooterEventImpl", "init tone");
                    } catch (Exception e) {
                        ab.e("MicroMsg.ChattingFooterEventImpl", "init tone failed");
                    }
                }
                if (this.oot != null) {
                    this.oot.startTone(24);
                    ab.i("MicroMsg.ChattingFooterEventImpl", "start tone");
                }
                this.yod.getListView().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(30629);
                        if (p.this.oot != null) {
                            p.this.oot.stopTone();
                            ab.i("MicroMsg.ChattingFooterEventImpl", "stopTone");
                        }
                        AppMethodBeat.o(30629);
                    }
                }, 200);
            }
            synchronized (this.lock) {
                try {
                    this.yJk = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(30658);
                }
            }
            new ak(Looper.myLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30628);
                    synchronized (p.this.lock) {
                        try {
                            if (p.this.yJk) {
                                ab.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
                            } else {
                                p.this.yJl = true;
                                p.this.gci.ae(100, 100);
                                p.this.yJm = false;
                                p.this.miP.ae(200, 200);
                                p.this.oor.Le(p.this.yod.getListView().getHeight());
                                d dFm = ((com.tencent.mm.ui.chatting.c.b.aj) p.this.yod.aF(com.tencent.mm.ui.chatting.c.b.aj.class)).dFm();
                                dFm.isRecording = true;
                                dFm.dBB();
                                dFm.dBw();
                                p.i(p.this);
                                p.this.yod.setKeepScreenOn(true);
                                ((com.tencent.mm.ui.chatting.c.b.ab) p.this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).OE(3);
                                ((com.tencent.mm.ui.chatting.c.b.ab) p.this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).keepSignalling();
                                p.dCo();
                                ((com.tencent.mm.ui.chatting.c.b.aj) p.this.yod.aF(com.tencent.mm.ui.chatting.c.b.aj.class)).a(p.this.yod.yTx, true);
                                AppMethodBeat.o(30628);
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(30628);
                        }
                    }
                }
            }, 200);
            return true;
        }
        com.tencent.mm.ui.base.t.hO(this.yod.yTx.getContext());
        ab.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(30658);
        return false;
    }

    public final void I(MotionEvent motionEvent) {
        AppMethodBeat.i(30662);
        if (motionEvent == null || motionEvent.getAction() == 1) {
            this.yod.dFA();
            this.yod.dCy();
        }
        AppMethodBeat.o(30662);
    }

    private void releaseWakeLock() {
        AppMethodBeat.i(30663);
        this.yod.setKeepScreenOn(false);
        AppMethodBeat.o(30663);
    }

    private boolean dCg() {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(30664);
        this.yod.yTx.enableOptionMenu(true);
        this.yod.yTx.enableBackMenu(true);
        if (this.yJe != null) {
            if (!(this.yJe.isRecording() && dCh())) {
                z2 = false;
            }
            z = this.yJe.EH();
            this.gci.stopTimer();
            this.miP.stopTimer();
            if (z2) {
                dCi();
            }
            aj.amB("keep_app_silent");
        } else {
            ab.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
        }
        AppMethodBeat.o(30664);
        return z;
    }

    public final String getTalkerUserName() {
        AppMethodBeat.i(30665);
        String str;
        if (this.ehM != null && ad.mR(this.ehM.field_username)) {
            str = this.yJf;
            AppMethodBeat.o(30665);
            return str;
        } else if (this.ehM == null) {
            AppMethodBeat.o(30665);
            return null;
        } else {
            str = this.ehM.field_username;
            AppMethodBeat.o(30665);
            return str;
        }
    }

    public final void release() {
        AppMethodBeat.i(30666);
        if (this.oot != null) {
            ab.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.oot.release();
            this.oot = null;
        }
        AppMethodBeat.o(30666);
    }

    public final void onPause() {
        AppMethodBeat.i(30667);
        if (this.oot != null) {
            ab.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.oot.release();
            this.oot = null;
        }
        dCg();
        this.gci.stopTimer();
        this.miP.stopTimer();
        AppMethodBeat.o(30667);
    }

    private boolean dCh() {
        AppMethodBeat.i(30668);
        if (this.ehM.field_username.equals("medianote") && (r.YD() & 16384) == 0) {
            AppMethodBeat.o(30668);
            return true;
        }
        AppMethodBeat.o(30668);
        return false;
    }

    private void dCi() {
        AppMethodBeat.i(30669);
        bi biVar = new bi();
        biVar.ju("medianote");
        biVar.setType(34);
        biVar.hO(1);
        biVar.jv(this.yJg);
        biVar.setStatus(2);
        biVar.setContent(com.tencent.mm.modelvoice.n.d(r.Yz(), (long) this.yJe.ET(), false));
        biVar.eJ(bf.oC("medianote"));
        if (this.yJe.EY() == 2) {
            biVar.ix("SOURCE_SILK_FILE");
        }
        aw.ZK();
        long Z = com.tencent.mm.model.c.XO().Z(biVar);
        if (Z <= 0) {
            ab.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
            AppMethodBeat.o(30669);
            return;
        }
        ab.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(Z)));
        AppMethodBeat.o(30669);
    }

    public final void iS(boolean z) {
        AppMethodBeat.i(30670);
        if (z) {
            ((com.tencent.mm.ui.chatting.c.b.ab) this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).keepSignalling();
            AppMethodBeat.o(30670);
            return;
        }
        ((com.tencent.mm.ui.chatting.c.b.ab) this.yod.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).stopSignalling();
        AppMethodBeat.o(30670);
    }

    private static void Ol(int i) {
        AppMethodBeat.i(30671);
        nu nuVar = new nu();
        nuVar.cKl.state = i;
        com.tencent.mm.sdk.b.a.xxA.m(nuVar);
        AppMethodBeat.o(30671);
    }

    public final void dCj() {
        AppMethodBeat.i(30672);
        ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 22, "", "")), bo.dpG(), this.yod.yTx.getContext());
        if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 22, "", "")) {
            ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 22, "", "")), bo.dpG(), this.yod.yTx.getContext());
            if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 22, "", "")) {
                ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
                Intent intent = new Intent();
                if (com.tencent.mm.bh.d.fUu.tQ(getTalkerUserName())) {
                    ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
                    Toast.makeText(ah.getContext(), R.string.cdo, 0).show();
                    AppMethodBeat.o(30672);
                    return;
                }
                if (getTalkerUserName() != null) {
                    int i;
                    List<String> RY = ((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RY(getTalkerUserName());
                    aw.ZK();
                    String str = (String) com.tencent.mm.model.c.Ry().get(2, null);
                    boolean RV = ((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RV(getTalkerUserName());
                    for (String str2 : RY) {
                        if (str != null && str.equals(str2)) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (RY.size() < 9 || i != 0) {
                        if (i != 0) {
                            if (((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bRd()) {
                                ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
                                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d2l), 0).show();
                                AppMethodBeat.o(30672);
                                return;
                            }
                            ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
                        }
                        if (((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bRb()) {
                            ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
                            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d2l), 0).show();
                            AppMethodBeat.o(30672);
                            return;
                        } else if (RV) {
                            ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
                            com.tencent.mm.ui.base.h.d(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(R.string.d3j), "", this.yod.yTx.getMMResources().getString(R.string.d26), this.yod.yTx.getMMResources().getString(R.string.d23), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(30654);
                                    if (((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RV(p.this.getTalkerUserName())) {
                                        if (!((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).Sb(p.this.getTalkerUserName())) {
                                            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d2e), 0).show();
                                        }
                                        AppMethodBeat.o(30654);
                                        return;
                                    }
                                    Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d3c), 0).show();
                                    AppMethodBeat.o(30654);
                                }
                            }, null);
                            AppMethodBeat.o(30672);
                            return;
                        }
                    }
                    ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
                    Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d2x, new Object[]{Integer.valueOf(9)}), 0).show();
                    AppMethodBeat.o(30672);
                    return;
                }
                intent.putExtra("chatroomName", getTalkerUserName());
                intent.putExtra("key_need_gallery", true);
                intent.putExtra("titile", this.yod.yTx.getMMResources().getString(R.string.d36));
                com.tencent.mm.bp.d.b(this.yod.yTx.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", intent);
                AppMethodBeat.o(30672);
                return;
            }
            AppMethodBeat.o(30672);
            return;
        }
        AppMethodBeat.o(30672);
    }

    public final void Om(final int i) {
        AppMethodBeat.i(30673);
        ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 18, "", "")), bo.dpG(), this.yod.yTx.getContext());
        if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 18, "", "")) {
            ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 18, "", "")), bo.dpG(), this.yod.yTx.getContext());
            if (!com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 18, "", "")) {
                AppMethodBeat.o(30673);
                return;
            } else if (com.tencent.mm.sdk.a.b.dnO() || ae.gjs) {
                com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this.yod.yTx.getContext());
                jVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(30624);
                        lVar.e(1, p.this.yod.yTx.getMMResources().getString(R.string.q4));
                        lVar.e(5, "拍摄参数设置面板");
                        AppMethodBeat.o(30624);
                    }
                };
                jVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(30625);
                        switch (menuItem.getItemId()) {
                            case 1:
                                Intent intent = new Intent();
                                h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(1));
                                com.tencent.mm.pluginsdk.ui.tools.n.a(p.this.yod.yTx, new Intent(), p.this.getTalkerUserName(), i);
                                AppMethodBeat.o(30625);
                                return;
                            case 5:
                                com.tencent.mm.bp.d.b(p.this.yod.yTx.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
                                break;
                        }
                        AppMethodBeat.o(30625);
                    }
                };
                jVar.cuu();
                AppMethodBeat.o(30673);
                return;
            } else {
                if (!ae.gjt) {
                    h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(1));
                    com.tencent.mm.pluginsdk.ui.tools.n.a(this.yod.yTx, new Intent(), getTalkerUserName(), i);
                }
                AppMethodBeat.o(30673);
                return;
            }
        }
        AppMethodBeat.o(30673);
    }

    public final void dCk() {
        AppMethodBeat.i(30674);
        ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 83, "", "")), bo.dpG(), this.yod.yTx.getContext());
        if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 83, "", "")) {
            if (this.oor.dky()) {
                this.oor.setBottomPanelVisibility(8);
            }
            ui uiVar = new ui();
            uiVar.cQx.cAd = 5;
            uiVar.cQx.talker = getTalkerUserName();
            uiVar.cQx.context = this.yod.yTx.getContext();
            uiVar.cQx.cQs = 3;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            h.pYm.e(11033, Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0));
            AppMethodBeat.o(30674);
            return;
        }
        AppMethodBeat.o(30674);
    }

    public final void dCl() {
        AppMethodBeat.i(30675);
        ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 21, "", "")), bo.dpG(), this.yod.yTx.getContext());
        if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 21, "", "")) {
            ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 21, "", "")), bo.dpG(), this.yod.yTx.getContext());
            if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 21, "", "")) {
                if (this.oor.dky()) {
                    this.oor.setBottomPanelVisibility(8);
                }
                ui uiVar = new ui();
                uiVar.cQx.cAd = 5;
                uiVar.cQx.talker = getTalkerUserName();
                uiVar.cQx.context = this.yod.yTx.getContext();
                uiVar.cQx.cQs = 2;
                com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                AppMethodBeat.o(30675);
                return;
            }
            AppMethodBeat.o(30675);
            return;
        }
        AppMethodBeat.o(30675);
    }

    public final void cbl() {
        AppMethodBeat.i(30676);
        ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 82, "", "")), bo.dpG(), this.yod.yTx.getContext());
        if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 82, "", "")) {
            ui uiVar = new ui();
            uiVar.cQx.cAd = 5;
            uiVar.cQx.talker = getTalkerUserName();
            uiVar.cQx.context = this.yod.yTx.getContext();
            uiVar.cQx.cQs = 4;
            if (this.oor.dky()) {
                this.oor.setBottomPanelVisibility(8);
            }
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            AppMethodBeat.o(30676);
            return;
        }
        AppMethodBeat.o(30676);
    }

    public final void cbm() {
        AppMethodBeat.i(30677);
        ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 19, "", "")), bo.dpG(), this.yod.yTx.getContext());
        if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.CAMERA", 19, "", "")) {
            ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 19, "", "")), bo.dpG(), this.yod.yTx.getContext());
            if (com.tencent.mm.pluginsdk.permission.b.a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 19, "", "")) {
                ui uiVar = new ui();
                uiVar.cQx.cAd = 5;
                uiVar.cQx.talker = getTalkerUserName();
                uiVar.cQx.context = this.yod.yTx.getContext();
                uiVar.cQx.cQs = 2;
                if (this.oor.dky()) {
                    this.oor.setBottomPanelVisibility(8);
                }
                com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                AppMethodBeat.o(30677);
                return;
            }
            AppMethodBeat.o(30677);
            return;
        }
        AppMethodBeat.o(30677);
    }

    public final void dCm() {
        AppMethodBeat.i(30678);
        ((af) this.yod.aF(af.class)).qt(false);
        this.oor.setBottomPanelVisibility(8);
        AppMethodBeat.o(30678);
    }

    public final void dCn() {
        AppMethodBeat.i(30679);
        if (!com.tencent.mm.pluginsdk.ui.tools.n.a(this.yod.yTx, com.tencent.mm.compatible.util.e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG)) {
            Toast.makeText(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(R.string.e29), 1).show();
        }
        AppMethodBeat.o(30679);
    }

    public final boolean Qu(String str) {
        AppMethodBeat.i(30659);
        this.yod.dFA();
        this.yod.dCy();
        boolean arq = ((com.tencent.mm.ui.chatting.c.b.ad) this.yod.aF(com.tencent.mm.ui.chatting.c.b.ad.class)).arq(str);
        AppMethodBeat.o(30659);
        return arq;
    }

    public final void bNK() {
        AppMethodBeat.i(30660);
        this.yod.dFA();
        this.yod.dCy();
        AppMethodBeat.o(30660);
    }

    public final void bNL() {
        AppMethodBeat.i(30661);
        this.yod.dFA();
        this.yod.dCy();
        AppMethodBeat.o(30661);
    }

    static /* synthetic */ void i(p pVar) {
        AppMethodBeat.i(30680);
        pVar.yod.yTx.enableOptionMenu(false);
        pVar.yod.yTx.enableBackMenu(false);
        if (pVar.yJe != null) {
            aj.amA("keep_app_silent");
            pVar.oor.setRecordNormalWording(pVar.yod.yTx.getMMResources().getString(R.string.aj5));
            pVar.yJe.em(pVar.getTalkerUserName());
            pVar.yJg = pVar.yJe.getFileName();
            pVar.yJe.a(pVar.ooy);
            pVar.kgA.vibrate(50);
            pVar.yod.aWv();
            pVar.yod.dFA();
            pVar.yJe.a(pVar.oox);
            AppMethodBeat.o(30680);
            return;
        }
        ab.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
        AppMethodBeat.o(30680);
    }

    static /* synthetic */ void a(p pVar, com.tencent.mm.ui.chatting.d.a aVar, int i, Intent intent) {
        AppMethodBeat.i(30683);
        if (i == -1 && intent != null) {
            int mA;
            String str;
            ((aa) aVar.aF(aa.class)).g(217, i, intent);
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            if (aVar.dFx()) {
                mA = com.tencent.mm.model.n.mA(pVar.yJf);
            } else {
                mA = 0;
            }
            Iterator it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                WXFileObject wXFileObject = new WXFileObject();
                wXFileObject.setFilePath(str2);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXFileObject;
                File file = new File(str2);
                wXMediaMessage.title = file.getName();
                wXMediaMessage.description = bo.ga(file.length());
                com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", pVar.yJf, 4, null);
                int lastIndexOf = file.getName().lastIndexOf(".");
                str = "";
                if (lastIndexOf >= 0 && lastIndexOf < file.getName().length() - 1) {
                    str = file.getName().substring(lastIndexOf + 1);
                }
                h hVar = h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = Long.valueOf(file.length());
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(aVar.dFx() ? 1 : 0);
                objArr[3] = Integer.valueOf(mA);
                objArr[4] = str;
                hVar.e(14986, objArr);
            }
            str = intent.getStringExtra("with_text_content");
            if (!bo.isNullOrNil(str)) {
                com.tencent.mm.plugin.messenger.a.g.bOk().eZ(str, pVar.yJf);
            }
        }
        AppMethodBeat.o(30683);
    }
}
