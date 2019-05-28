package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p195b.C32307h;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C41737j;
import com.tencent.p177mm.p183ai.C41737j.C37445a;
import com.tencent.p177mm.p183ai.C41737j.C41738b;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p230g.p231a.C18411uh;
import com.tencent.p177mm.p230g.p231a.C26208nu;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p232b.p233a.C37833l;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23728ab;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30467ad;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36133b;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36136e;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40723af;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44296aa;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46644u;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.multitalk.model.C39419a;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.subapp.p1039c.C29386i;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.chat.AppPanel.C14934a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23288b;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.NewFileExplorerUI;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.p */
public final class C30562p implements C23288b {
    public static boolean yJd = true;
    private C7616ad ehM;
    private final C7564ap gci = new C7564ap(new C157088(), true);
    private Vibrator kgA;
    private Object lock = new Object();
    private final C7564ap miP = new C7564ap(new C157099(), true);
    private ChatFooter oor;
    private ToneGenerator oot;
    private final C37445a oox = new C53601();
    private final C41738b ooy = new C305724();
    private C14934a ope = new C3056710();
    private boolean yFW;
    private C41737j yJe;
    private String yJf;
    private String yJg;
    private boolean yJh;
    private boolean yJi;
    public boolean yJj;
    private volatile boolean yJk = false;
    private volatile boolean yJl = false;
    private boolean yJm = false;
    C46650a yod;

    /* renamed from: com.tencent.mm.ui.chatting.p$1 */
    class C53601 implements C37445a {
        C53601() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(30623);
            C30562p.this.yJe.reset();
            C30562p.this.gci.stopTimer();
            C30562p.this.miP.stopTimer();
            C4997aj.amB("keep_app_silent");
            C30562p.this.oor.bvH();
            ((C15611aj) C30562p.this.yod.mo74857aF(C15611aj.class)).dFm().dBx();
            C4990ab.m7418v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
            C30562p.this.yod.yTx.enableOptionMenu(true);
            C30562p.this.yod.yTx.enableBackMenu(true);
            Toast.makeText(C30562p.this.yod.yTx.getContext(), C30562p.this.yod.yTx.getContext().getString(C25738R.string.anm), 0).show();
            AppMethodBeat.m2505o(30623);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$7 */
    class C53617 implements Runnable {
        C53617() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30629);
            if (C30562p.this.oot != null) {
                C30562p.this.oot.stopTone();
                C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "stopTone");
            }
            AppMethodBeat.m2505o(30629);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$8 */
    class C157088 implements C5015a {
        C157088() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(30630);
            C30562p.this.oor.mo63902Lf(C30562p.this.yJe.getMaxAmplitude());
            AppMethodBeat.m2505o(30630);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$9 */
    class C157099 implements C5015a {
        C157099() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(30631);
            long EV = C30562p.this.yJe.mo47619EV();
            C4990ab.m7410d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(EV)));
            if (EV >= 50000 && EV <= 60000) {
                if (!C30562p.this.yJm) {
                    C5046bo.m7551gM(C30562p.this.yod.yTx.getContext());
                    C30562p.this.yJm = true;
                }
                int i = (int) ((60000 - EV) / 1000);
                C30562p.this.oor.setRecordNormalWording(C30562p.this.yod.yTx.getMMResources().getQuantityString(C25738R.plurals.f9591c, i, new Object[]{Integer.valueOf(i)}));
            }
            if (EV >= 60000) {
                C4990ab.m7418v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
                C30562p.m48717l(C30562p.this);
                C30562p.this.oor.bvH();
                C35988ay.m59201au(C30562p.this.yod.yTx.getContext(), C25738R.string.ew8);
                AppMethodBeat.m2505o(30631);
                return false;
            }
            AppMethodBeat.m2505o(30631);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$11 */
    class C3056311 implements OnClickListener {
        C3056311() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(30654);
            if (((C39419a) C1720g.m3528K(C39419a.class)).mo55110RV(C30562p.this.getTalkerUserName())) {
                if (!((C39419a) C1720g.m3528K(C39419a.class)).mo55116Sb(C30562p.this.getTalkerUserName())) {
                    Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d2e), 0).show();
                }
                AppMethodBeat.m2505o(30654);
                return;
            }
            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d3c), 0).show();
            AppMethodBeat.m2505o(30654);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$5 */
    class C305645 implements OnClickListener {
        C305645() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(30627);
            C37657b.m63683bE(C30562p.this.yod.yTx.getContext());
            AppMethodBeat.m2505o(30627);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$6 */
    class C305656 implements Runnable {
        C305656() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30628);
            synchronized (C30562p.this.lock) {
                try {
                    if (C30562p.this.yJk) {
                        C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
                    } else {
                        C30562p.this.yJl = true;
                        C30562p.this.gci.mo16770ae(100, 100);
                        C30562p.this.yJm = false;
                        C30562p.this.miP.mo16770ae(200, 200);
                        C30562p.this.oor.mo63901Le(C30562p.this.yod.getListView().getHeight());
                        C36866d dFm = ((C15611aj) C30562p.this.yod.mo74857aF(C15611aj.class)).dFm();
                        dFm.isRecording = true;
                        dFm.dBB();
                        dFm.dBw();
                        C30562p.m48714i(C30562p.this);
                        C30562p.this.yod.setKeepScreenOn(true);
                        ((C23728ab) C30562p.this.yod.mo74857aF(C23728ab.class)).mo39569OE(3);
                        ((C23728ab) C30562p.this.yod.mo74857aF(C23728ab.class)).keepSignalling();
                        C30562p.dCo();
                        ((C15611aj) C30562p.this.yod.mo74857aF(C15611aj.class)).mo27790a(C30562p.this.yod.yTx, true);
                        AppMethodBeat.m2505o(30628);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(30628);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$2 */
    class C305662 implements C36073c {
        C305662() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(30624);
            c44273l.mo70068e(1, C30562p.this.yod.yTx.getMMResources().getString(C25738R.string.f9121q4));
            c44273l.mo70068e(5, "拍摄参数设置面板");
            AppMethodBeat.m2505o(30624);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$10 */
    class C3056710 implements C14934a {
        C36356d pki = null;

        /* renamed from: com.tencent.mm.ui.chatting.p$10$2 */
        class C157072 implements C5279d {
            C157072() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(30633);
                switch (menuItem.getItemId()) {
                    case 1:
                        C30562p.this.cbl();
                        AppMethodBeat.m2505o(30633);
                        return;
                    case 2:
                        C30562p.this.cbm();
                        break;
                }
                AppMethodBeat.m2505o(30633);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.p$10$4 */
        class C305684 implements C30391c {
            C305684() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(30635);
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
                        intent.putExtra("key_way", 0);
                        intent.putExtra("key_type", 0);
                        intent.putExtra("key_from", 1);
                        intent.putExtra("key_username", C30562p.this.getTalkerUserName());
                        intent.putExtra("pay_channel", 11);
                        C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                        AppMethodBeat.m2505o(30635);
                        return;
                    case 1:
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
                        intent.putExtra("key_username", C30562p.this.getTalkerUserName());
                        intent.putExtra("key_way", 0);
                        intent.putExtra("pay_channel", 11);
                        C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", intent);
                        C37833l c37833l = new C37833l();
                        c37833l.cVT = 1;
                        c37833l.ajK();
                        break;
                }
                AppMethodBeat.m2505o(30635);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.p$10$3 */
        class C305693 implements Runnable {
            C305693() {
            }

            public final void run() {
                AppMethodBeat.m2504i(30634);
                C30562p.this.oor.setBottomPanelVisibility(8);
                AppMethodBeat.m2505o(30634);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.p$10$5 */
        class C305705 implements C25987a {
            C305705() {
            }

            public final void onActivityResult(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(30636);
                if (i == 227) {
                    C30562p.m48705a(C30562p.this, C30562p.this.yod, i2, intent);
                }
                AppMethodBeat.m2505o(30636);
            }
        }

        C3056710() {
        }

        public final void bNO() {
            AppMethodBeat.m2504i(30637);
            if (C35973a.m59177bH(C30562p.this.yod.yTx.getContext())) {
                AppMethodBeat.m2505o(30637);
                return;
            }
            C18411uh c18411uh = new C18411uh();
            C4879a.xxA.mo10055m(c18411uh);
            if (C30562p.this.getTalkerUserName() == null || C30562p.this.getTalkerUserName().equals(c18411uh.cQt.talker) || !(c18411uh.cQt.cQv || c18411uh.cQt.cQw)) {
                if (1 == C26373g.m41964Nu().getInt("EnableVoiceVoipFromPlugin", 0)) {
                    boolean z = (C7616ad.aox(C30562p.this.yod.sRl.field_username) || C1855t.m3903mP(C30562p.this.yod.sRl.field_username)) ? (((C32873b) C1720g.m3528K(C32873b.class)).mo44311vi(C30562p.this.yod.sRl.field_openImAppid) & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 : false;
                    this.pki = new C36356d(C30562p.this.yod.yTx.getContext(), 1, false);
                    this.pki.rBl = new C36073c() {
                        /* renamed from: a */
                        public final void mo5746a(C44273l c44273l) {
                            AppMethodBeat.m2504i(30632);
                            c44273l.mo70063ax(2, C25738R.string.f9132qh, C1318a.sharemore_videovoip);
                            if (!z) {
                                c44273l.mo70063ax(1, C25738R.string.f9134qj, C1318a.sharemore_voipvoice);
                            }
                            AppMethodBeat.m2505o(30632);
                        }
                    };
                    this.pki.rBm = new C157072();
                    this.pki.cpD();
                } else {
                    C30562p.this.dCl();
                }
                C7060h.pYm.mo8381e(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
                AppMethodBeat.m2505o(30637);
                return;
            }
            Toast.makeText(C30562p.this.yod.yTx.getContext(), c18411uh.cQt.cQu ? C25738R.string.ac6 : C25738R.string.ac7, 0).show();
            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.m2505o(30637);
        }

        public final void bNP() {
            AppMethodBeat.m2504i(30638);
            if (C35973a.m59177bH(C30562p.this.yod.yTx.getContext())) {
                AppMethodBeat.m2505o(30638);
                return;
            }
            C18411uh c18411uh = new C18411uh();
            C4879a.xxA.mo10055m(c18411uh);
            if (C30562p.this.getTalkerUserName().equals(c18411uh.cQt.talker) || !(c18411uh.cQt.cQv || c18411uh.cQt.cQw)) {
                C30562p.this.dCk();
                AppMethodBeat.m2505o(30638);
                return;
            }
            Toast.makeText(C30562p.this.yod.yTx.getContext(), c18411uh.cQt.cQu ? C25738R.string.ac6 : C25738R.string.ac7, 0).show();
            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.m2505o(30638);
        }

        public final void bNQ() {
            AppMethodBeat.m2504i(30639);
            if (!(C35973a.m59179bJ(C30562p.this.yod.yTx.getContext()) || C35973a.m59177bH(C30562p.this.yod.yTx.getContext()))) {
                C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(C30562p.this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 81, "", "")), C5046bo.dpG(), C30562p.this.yod.yTx.getContext());
                if (C35805b.m58707a(C30562p.this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 81, "", "")) {
                    C30562p.this.dCm();
                } else {
                    AppMethodBeat.m2505o(30639);
                    return;
                }
            }
            AppMethodBeat.m2505o(30639);
        }

        public final void bNR() {
            AppMethodBeat.m2504i(30640);
            ((C46644u) C30562p.this.yod.mo74857aF(C46644u.class)).dEH();
            AppMethodBeat.m2505o(30640);
        }

        public final void bNS() {
            AppMethodBeat.m2504i(30641);
            ((C36136e) C30562p.this.yod.mo74857aF(C36136e.class)).dDD();
            AppMethodBeat.m2505o(30641);
        }

        /* renamed from: ys */
        public final void mo24428ys(int i) {
            AppMethodBeat.m2504i(30642);
            switch (i) {
                case 0:
                    File file = new File(C6457e.euR);
                    if (file.exists() || file.mkdir()) {
                        C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(C30562p.this.yod.yTx.getContext(), "android.permission.CAMERA", 20, "", "")), C5046bo.dpG(), C30562p.this.yod.yTx.getContext());
                        if (C35805b.m58707a(C30562p.this.yod.yTx.getContext(), "android.permission.CAMERA", 20, "", "")) {
                            C30562p.this.dCn();
                            break;
                        } else {
                            AppMethodBeat.m2505o(30642);
                            return;
                        }
                    }
                    Toast.makeText(C30562p.this.yod.yTx.getContext(), C30562p.this.yod.yTx.getMMResources().getString(C25738R.string.aor), 1).show();
                    AppMethodBeat.m2505o(30642);
                    return;
                    break;
                case 1:
                    String string = C30562p.this.yod.yTx.getContext().getSharedPreferences(C4996ah.doA(), 0).getString("gallery", "1");
                    C34830g.m57194BN(19);
                    if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        C14987n.m23317e(C30562p.this.yod.yTx);
                    } else {
                        string = C30562p.this.yod.dFu();
                        String talkerUserName = C30562p.this.yod.getTalkerUserName();
                        if (C30562p.this.yJj && C30562p.yJd) {
                            C14987n.m23308b(C30562p.this.yod.yTx, 3, string, talkerUserName);
                        } else if (C7616ad.m13549mg(talkerUserName)) {
                            C14987n.m23299a(C30562p.this.yod.yTx, 12, string, talkerUserName);
                        } else {
                            C14987n.m23299a(C30562p.this.yod.yTx, 3, string, talkerUserName);
                        }
                    }
                    C7060h.pYm.mo8381e(13822, Integer.valueOf(2), Integer.valueOf(1));
                    C5004al.m7442n(new C305693(), 1000);
                    AppMethodBeat.m2505o(30642);
                    return;
            }
            AppMethodBeat.m2505o(30642);
        }

        /* renamed from: b */
        public final void mo24413b(C40439f c40439f) {
            AppMethodBeat.m2504i(30643);
            ((C36133b) C30562p.this.yod.mo74857aF(C36133b.class)).mo57003q(c40439f);
            AppMethodBeat.m2505o(30643);
        }

        public final void bNT() {
            AppMethodBeat.m2504i(30644);
            C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
            AppMethodBeat.m2505o(30644);
        }

        public final void bNU() {
            AppMethodBeat.m2504i(30645);
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            if (C17903f.m28103kq(C30562p.this.ehM.field_username)) {
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
            intent.putExtra("key_to_user", C30562p.this.ehM.field_username);
            intent.putExtra("key_fav_item_id", TextUtils.join(",", arrayList));
            C39037b.m66371b(C30562p.this.yod.yTx.getContext(), ".ui.FavSelectUI", intent);
            C7060h.pYm.mo8381e(14103, Integer.valueOf(1));
            AppMethodBeat.m2505o(30645);
        }

        public final void bNV() {
            AppMethodBeat.m2504i(30646);
            Intent intent = new Intent();
            intent.putExtra("service_app_talker_user", C30562p.this.getTalkerUserName());
            C25985d.m41458a(C30562p.this.yod.yTx, "subapp", ".ui.openapi.ServiceAppUI", intent, 222);
            AppMethodBeat.m2505o(30646);
        }

        public final void bNW() {
            AppMethodBeat.m2504i(30647);
            Intent intent = new Intent();
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("preceding_scence", 13);
            C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            C7060h.pYm.mo8381e(12065, Integer.valueOf(4));
            AppMethodBeat.m2505o(30647);
        }

        /* renamed from: yt */
        public final void mo24429yt(int i) {
            AppMethodBeat.m2504i(30648);
            if (!(C35973a.m59178bI(C30562p.this.yod.yTx.getContext()) || C35973a.m59179bJ(C30562p.this.yod.yTx.getContext()) || C35973a.m59177bH(C30562p.this.yod.yTx.getContext()))) {
                C30562p.this.mo48966Om(i);
            }
            AppMethodBeat.m2505o(30648);
        }

        public final void bNX() {
            AppMethodBeat.m2504i(30649);
            C7060h.pYm.mo8381e(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            C7060h.pYm.mo8381e(11850, Integer.valueOf(4), Integer.valueOf(1));
            Intent intent;
            if (C30562p.this.yJh) {
                C7060h.pYm.mo8381e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2));
                intent = new Intent();
                int mA = C37921n.m64060mA(C30562p.this.getTalkerUserName());
                intent.putExtra("key_way", 1);
                intent.putExtra("key_chatroom_num", mA);
                intent.putExtra("key_type", 1);
                intent.putExtra("key_from", 1);
                intent.putExtra("key_username", C30562p.this.getTalkerUserName());
                intent.putExtra("pay_channel", 14);
                C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                AppMethodBeat.m2505o(30649);
                return;
            }
            C9638aw.m17190ZK();
            Integer num = (Integer) C18628c.m29072Ry().get(C5127a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(0));
            C9638aw.m17190ZK();
            Integer num2 = (Integer) C18628c.m29072Ry().get(C5127a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0));
            if (num.intValue() == 1 || num2.intValue() == 1) {
                int i;
                if (C1853r.m3825YG() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    C37833l c37833l = new C37833l();
                    c37833l.cVT = 13;
                    c37833l.ajK();
                    C30379h.m48422a(C30562p.this.yod.yTx.getContext(), null, new String[]{C30562p.this.yod.yTx.getMMResources().getString(C25738R.string.amt), C30562p.this.yod.yTx.getMMResources().getString(C25738R.string.ams)}, null, new C305684());
                    AppMethodBeat.m2505o(30649);
                    return;
                }
            }
            C7060h.pYm.mo8381e(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
            intent = new Intent();
            intent.putExtra("key_way", 0);
            intent.putExtra("key_type", 0);
            intent.putExtra("key_from", 1);
            intent.putExtra("key_username", C30562p.this.getTalkerUserName());
            intent.putExtra("pay_channel", 11);
            C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
            AppMethodBeat.m2505o(30649);
        }

        public final void bNY() {
            AppMethodBeat.m2504i(30650);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(81, Boolean.FALSE);
            if (C5023at.isNetworkConnected(C30562p.this.yod.yTx.getContext())) {
                C30562p.this.dCj();
                AppMethodBeat.m2505o(30650);
                return;
            }
            C17981e.m28295a(C30562p.this.yod.yTx.getContext(), C25738R.string.f6c, null);
            AppMethodBeat.m2505o(30650);
        }

        public final void bNZ() {
            AppMethodBeat.m2504i(30651);
            Intent intent = new Intent();
            intent.putExtra("enterprise_scene", 4);
            intent.putExtra("enterprise_biz_name", C30562p.this.getTalkerUserName());
            intent.putExtra("biz_chat_chat_id", ((C36135d) C30562p.this.yod.mo74857aF(C36135d.class)).dDz());
            C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent);
            AppMethodBeat.m2505o(30651);
        }

        public final void bOa() {
            AppMethodBeat.m2504i(30652);
            if (C30562p.this.yJh) {
                Intent intent = new Intent();
                intent.putExtra("enter_scene", 1);
                intent.putExtra("chatroom_name", C30562p.this.getTalkerUserName());
                C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "aa", ".ui.LaunchAAUI", intent);
            }
            AppMethodBeat.m2505o(30652);
        }

        public final void bOb() {
            AppMethodBeat.m2504i(30653);
            C7060h.pYm.mo8381e(14523, Integer.valueOf(0));
            Intent intent = new Intent();
            intent.setClass(C30562p.this.yod.yTx.getContext(), NewFileExplorerUI.class);
            intent.putExtra("TO_USER", C30562p.this.yJf);
            C30562p.this.yod.mo74855a(intent, 227, new C305705());
            AppMethodBeat.m2505o(30653);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.p$4 */
    class C305724 implements C41738b {
        C305724() {
        }

        public final void acE() {
            AppMethodBeat.m2504i(30626);
            C30562p.this.oor.dki();
            AppMethodBeat.m2505o(30626);
        }
    }

    static /* synthetic */ void dCo() {
        AppMethodBeat.m2504i(30681);
        C30562p.m48703Ol(0);
        AppMethodBeat.m2505o(30681);
    }

    /* renamed from: l */
    static /* synthetic */ boolean m48717l(C30562p c30562p) {
        AppMethodBeat.m2504i(30682);
        boolean dCg = c30562p.dCg();
        AppMethodBeat.m2505o(30682);
        return dCg;
    }

    public C30562p(C46650a c46650a, ChatFooter chatFooter, String str) {
        AppMethodBeat.m2504i(30655);
        this.yod = c46650a;
        this.oor = chatFooter;
        this.yJf = str;
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(str);
        this.yJh = C1855t.m3896kH(this.yod.getTalkerUserName());
        this.yJi = C1855t.m3907mT(this.yod.getTalkerUserName());
        boolean z = this.yJh || this.yJi;
        this.yFW = z;
        this.kgA = (Vibrator) this.yod.yTx.getContext().getSystemService("vibrator");
        if (C1855t.m3953nv(this.yJf)) {
            this.yJe = new C29386i();
            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
        } else {
            String str2 = this.yJf;
            if (C1855t.m3921nG(str2)) {
                z = true;
            } else {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
                if (aoO != null && aoO.dsf()) {
                    C16527d qX = C17903f.m28104qX(aoO.field_username);
                    if (qX != null) {
                        C16529b cJ = qX.mo30481cJ(false);
                        if (cJ != null) {
                            if (cJ.fvc != null) {
                                cJ.fvg = "1".equals(cJ.fvc.optString("CanReceiveSpeexVoice"));
                            }
                            if (cJ.fvg) {
                                C4990ab.m7416i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + aoO.field_username + " canReceiveSpeexVoice");
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (z) {
                this.yJe = new C32307h(this.yod.yTx.getContext(), true);
                C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
            } else {
                this.yJe = new C32307h(this.yod.yTx.getContext(), false);
                C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
            }
        }
        this.yJe.mo47622a(this.ooy);
        this.yJe.mo47621a(this.oox);
        chatFooter.setAppPanelListener(this.ope);
        AppMethodBeat.m2505o(30655);
    }

    public final boolean bNG() {
        AppMethodBeat.m2504i(30656);
        synchronized (this.lock) {
            try {
                this.yJk = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(30656);
            }
        }
        if (this.yJl) {
            this.yJl = false;
            releaseWakeLock();
            if (dCg()) {
                this.oor.bvH();
                C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
            } else {
                this.oor.ddN();
                C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
            }
            ((C15611aj) this.yod.mo74857aF(C15611aj.class)).dFm().dBx();
            ((C23728ab) this.yod.mo74857aF(C23728ab.class)).mo39569OE(4);
            ((C23728ab) this.yod.mo74857aF(C23728ab.class)).stopSignalling();
            C30562p.m48703Ol(1);
            ((C15611aj) this.yod.mo74857aF(C15611aj.class)).mo27790a(this.yod.yTx, false);
            AppMethodBeat.m2505o(30656);
            return true;
        }
        boolean z = "MicroMsg.ChattingFooterEventImpl";
        C4990ab.m7416i(z, "jacks in voice rcd stop but not begin.");
        return z;
    }

    public final boolean bNI() {
        AppMethodBeat.m2504i(30657);
        C4990ab.m7418v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
        synchronized (this.lock) {
            try {
                this.yJk = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(30657);
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
            ((C15611aj) this.yod.mo74857aF(C15611aj.class)).dFm().dBx();
            ((C23728ab) this.yod.mo74857aF(C23728ab.class)).mo39569OE(4);
            ((C23728ab) this.yod.mo74857aF(C23728ab.class)).stopSignalling();
            C30562p.m48703Ol(1);
            ((C15611aj) this.yod.mo74857aF(C15611aj.class)).mo27790a(this.yod.yTx, false);
            AppMethodBeat.m2505o(30657);
            return true;
        }
        boolean z = "MicroMsg.ChattingFooterEventImpl";
        C4990ab.m7416i(z, "jacks in voice rcd stop but not begin.");
        return z;
    }

    public final boolean bNJ() {
        AppMethodBeat.m2504i(30658);
        if (C35973a.m59179bJ(this.yod.yTx.getContext()) || C35973a.m59177bH(this.yod.yTx.getContext())) {
            C4990ab.m7410d("MicroMsg.ChattingFooterEventImpl", "voip is running, cann't record voice");
            AppMethodBeat.m2505o(30658);
            return false;
        }
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            if (!C37657b.m63680Mi()) {
                C30379h.m48447a(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(C25738R.string.f9234tv), this.yod.yTx.getMMResources().getString(C25738R.string.f9177rw), this.yod.yTx.getMMResources().getString(C25738R.string.f9179ry), true, new C305645());
            }
            if (this.yJe != null) {
                if (this.oot == null) {
                    try {
                        this.oot = new ToneGenerator(3, (int) ((((float) this.yod.yTx.getStreamMaxVolume(3)) / ((float) this.yod.yTx.getStreamVolume(3))) * 100.0f));
                        C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "init tone");
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.ChattingFooterEventImpl", "init tone failed");
                    }
                }
                if (this.oot != null) {
                    this.oot.startTone(24);
                    C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "start tone");
                }
                this.yod.getListView().postDelayed(new C53617(), 200);
            }
            synchronized (this.lock) {
                try {
                    this.yJk = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(30658);
                }
            }
            new C7306ak(Looper.myLooper()).postDelayed(new C305656(), 200);
            return true;
        }
        C23639t.m36492hO(this.yod.yTx.getContext());
        C4990ab.m7412e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.m2505o(30658);
        return false;
    }

    /* renamed from: I */
    public final void mo38998I(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(30662);
        if (motionEvent == null || motionEvent.getAction() == 1) {
            this.yod.dFA();
            this.yod.dCy();
        }
        AppMethodBeat.m2505o(30662);
    }

    private void releaseWakeLock() {
        AppMethodBeat.m2504i(30663);
        this.yod.setKeepScreenOn(false);
        AppMethodBeat.m2505o(30663);
    }

    private boolean dCg() {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(30664);
        this.yod.yTx.enableOptionMenu(true);
        this.yod.yTx.enableBackMenu(true);
        if (this.yJe != null) {
            if (!(this.yJe.isRecording() && dCh())) {
                z2 = false;
            }
            z = this.yJe.mo24432EH();
            this.gci.stopTimer();
            this.miP.stopTimer();
            if (z2) {
                dCi();
            }
            C4997aj.amB("keep_app_silent");
        } else {
            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
        }
        AppMethodBeat.m2505o(30664);
        return z;
    }

    public final String getTalkerUserName() {
        AppMethodBeat.m2504i(30665);
        String str;
        if (this.ehM != null && C7616ad.m13548mR(this.ehM.field_username)) {
            str = this.yJf;
            AppMethodBeat.m2505o(30665);
            return str;
        } else if (this.ehM == null) {
            AppMethodBeat.m2505o(30665);
            return null;
        } else {
            str = this.ehM.field_username;
            AppMethodBeat.m2505o(30665);
            return str;
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(30666);
        if (this.oot != null) {
            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "release");
            this.oot.release();
            this.oot = null;
        }
        AppMethodBeat.m2505o(30666);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(30667);
        if (this.oot != null) {
            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "release");
            this.oot.release();
            this.oot = null;
        }
        dCg();
        this.gci.stopTimer();
        this.miP.stopTimer();
        AppMethodBeat.m2505o(30667);
    }

    private boolean dCh() {
        AppMethodBeat.m2504i(30668);
        if (this.ehM.field_username.equals("medianote") && (C1853r.m3822YD() & 16384) == 0) {
            AppMethodBeat.m2505o(30668);
            return true;
        }
        AppMethodBeat.m2505o(30668);
        return false;
    }

    private void dCi() {
        AppMethodBeat.m2504i(30669);
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju("medianote");
        c7620bi.setType(34);
        c7620bi.mo14781hO(1);
        c7620bi.mo14795jv(this.yJg);
        c7620bi.setStatus(2);
        c7620bi.setContent(C42230n.m74526d(C1853r.m3846Yz(), (long) this.yJe.mo47618ET(), false));
        c7620bi.mo14775eJ(C1829bf.m3756oC("medianote"));
        if (this.yJe.mo47620EY() == 2) {
            c7620bi.mo14791ix("SOURCE_SILK_FILE");
        }
        C9638aw.m17190ZK();
        long Z = C18628c.m29080XO().mo15281Z(c7620bi);
        if (Z <= 0) {
            C4990ab.m7412e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
            AppMethodBeat.m2505o(30669);
            return;
        }
        C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(Z)));
        AppMethodBeat.m2505o(30669);
    }

    /* renamed from: iS */
    public final void mo39005iS(boolean z) {
        AppMethodBeat.m2504i(30670);
        if (z) {
            ((C23728ab) this.yod.mo74857aF(C23728ab.class)).keepSignalling();
            AppMethodBeat.m2505o(30670);
            return;
        }
        ((C23728ab) this.yod.mo74857aF(C23728ab.class)).stopSignalling();
        AppMethodBeat.m2505o(30670);
    }

    /* renamed from: Ol */
    private static void m48703Ol(int i) {
        AppMethodBeat.m2504i(30671);
        C26208nu c26208nu = new C26208nu();
        c26208nu.cKl.state = i;
        C4879a.xxA.mo10055m(c26208nu);
        AppMethodBeat.m2505o(30671);
    }

    public final void dCj() {
        AppMethodBeat.m2504i(30672);
        C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 22, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
        if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 22, "", "")) {
            C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 22, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
            if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 22, "", "")) {
                C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
                Intent intent = new Intent();
                if (C25859d.fUu.mo20565tQ(getTalkerUserName())) {
                    C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
                    Toast.makeText(C4996ah.getContext(), C25738R.string.cdo, 0).show();
                    AppMethodBeat.m2505o(30672);
                    return;
                }
                if (getTalkerUserName() != null) {
                    int i;
                    List<String> RY = ((C39419a) C1720g.m3528K(C39419a.class)).mo55113RY(getTalkerUserName());
                    C9638aw.m17190ZK();
                    String str = (String) C18628c.m29072Ry().get(2, null);
                    boolean RV = ((C39419a) C1720g.m3528K(C39419a.class)).mo55110RV(getTalkerUserName());
                    for (String str2 : RY) {
                        if (str != null && str.equals(str2)) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (RY.size() < 9 || i != 0) {
                        if (i != 0) {
                            if (((C39419a) C1720g.m3528K(C39419a.class)).bRd()) {
                                C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
                                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d2l), 0).show();
                                AppMethodBeat.m2505o(30672);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
                        }
                        if (((C39419a) C1720g.m3528K(C39419a.class)).bRb()) {
                            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
                            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d2l), 0).show();
                            AppMethodBeat.m2505o(30672);
                            return;
                        } else if (RV) {
                            C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
                            C30379h.m48466d(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(C25738R.string.d3j), "", this.yod.yTx.getMMResources().getString(C25738R.string.d26), this.yod.yTx.getMMResources().getString(C25738R.string.d23), new C3056311(), null);
                            AppMethodBeat.m2505o(30672);
                            return;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
                    Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d2x, new Object[]{Integer.valueOf(9)}), 0).show();
                    AppMethodBeat.m2505o(30672);
                    return;
                }
                intent.putExtra("chatroomName", getTalkerUserName());
                intent.putExtra("key_need_gallery", true);
                intent.putExtra("titile", this.yod.yTx.getMMResources().getString(C25738R.string.d36));
                C25985d.m41467b(this.yod.yTx.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", intent);
                AppMethodBeat.m2505o(30672);
                return;
            }
            AppMethodBeat.m2505o(30672);
            return;
        }
        AppMethodBeat.m2505o(30672);
    }

    /* renamed from: Om */
    public final void mo48966Om(final int i) {
        AppMethodBeat.m2504i(30673);
        C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 18, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
        if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 18, "", "")) {
            C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 18, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
            if (!C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 18, "", "")) {
                AppMethodBeat.m2505o(30673);
                return;
            } else if (C4872b.dnO() || C1947ae.gjs) {
                C46696j c46696j = new C46696j(this.yod.yTx.getContext());
                c46696j.rBl = new C305662();
                c46696j.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(30625);
                        switch (menuItem.getItemId()) {
                            case 1:
                                Intent intent = new Intent();
                                C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(1));
                                C14987n.m23304a(C30562p.this.yod.yTx, new Intent(), C30562p.this.getTalkerUserName(), i);
                                AppMethodBeat.m2505o(30625);
                                return;
                            case 5:
                                C25985d.m41467b(C30562p.this.yod.yTx.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
                                break;
                        }
                        AppMethodBeat.m2505o(30625);
                    }
                };
                c46696j.cuu();
                AppMethodBeat.m2505o(30673);
                return;
            } else {
                if (!C1947ae.gjt) {
                    C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(1));
                    C14987n.m23304a(this.yod.yTx, new Intent(), getTalkerUserName(), i);
                }
                AppMethodBeat.m2505o(30673);
                return;
            }
        }
        AppMethodBeat.m2505o(30673);
    }

    public final void dCk() {
        AppMethodBeat.m2504i(30674);
        C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 83, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
        if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 83, "", "")) {
            if (this.oor.dky()) {
                this.oor.setBottomPanelVisibility(8);
            }
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 5;
            c26250ui.cQx.talker = getTalkerUserName();
            c26250ui.cQx.context = this.yod.yTx.getContext();
            c26250ui.cQx.cQs = 3;
            C4879a.xxA.mo10055m(c26250ui);
            C7060h.pYm.mo8381e(11033, Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0));
            AppMethodBeat.m2505o(30674);
            return;
        }
        AppMethodBeat.m2505o(30674);
    }

    public final void dCl() {
        AppMethodBeat.m2504i(30675);
        C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 21, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
        if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 21, "", "")) {
            C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 21, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
            if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 21, "", "")) {
                if (this.oor.dky()) {
                    this.oor.setBottomPanelVisibility(8);
                }
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 5;
                c26250ui.cQx.talker = getTalkerUserName();
                c26250ui.cQx.context = this.yod.yTx.getContext();
                c26250ui.cQx.cQs = 2;
                C4879a.xxA.mo10055m(c26250ui);
                AppMethodBeat.m2505o(30675);
                return;
            }
            AppMethodBeat.m2505o(30675);
            return;
        }
        AppMethodBeat.m2505o(30675);
    }

    public final void cbl() {
        AppMethodBeat.m2504i(30676);
        C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 82, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
        if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 82, "", "")) {
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 5;
            c26250ui.cQx.talker = getTalkerUserName();
            c26250ui.cQx.context = this.yod.yTx.getContext();
            c26250ui.cQx.cQs = 4;
            if (this.oor.dky()) {
                this.oor.setBottomPanelVisibility(8);
            }
            C4879a.xxA.mo10055m(c26250ui);
            AppMethodBeat.m2505o(30676);
            return;
        }
        AppMethodBeat.m2505o(30676);
    }

    public final void cbm() {
        AppMethodBeat.m2504i(30677);
        C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 19, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
        if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.CAMERA", 19, "", "")) {
            C4990ab.m7417i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 19, "", "")), C5046bo.dpG(), this.yod.yTx.getContext());
            if (C35805b.m58707a(this.yod.yTx.getContext(), "android.permission.RECORD_AUDIO", 19, "", "")) {
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 5;
                c26250ui.cQx.talker = getTalkerUserName();
                c26250ui.cQx.context = this.yod.yTx.getContext();
                c26250ui.cQx.cQs = 2;
                if (this.oor.dky()) {
                    this.oor.setBottomPanelVisibility(8);
                }
                C4879a.xxA.mo10055m(c26250ui);
                AppMethodBeat.m2505o(30677);
                return;
            }
            AppMethodBeat.m2505o(30677);
            return;
        }
        AppMethodBeat.m2505o(30677);
    }

    public final void dCm() {
        AppMethodBeat.m2504i(30678);
        ((C40723af) this.yod.mo74857aF(C40723af.class)).mo41856qt(false);
        this.oor.setBottomPanelVisibility(8);
        AppMethodBeat.m2505o(30678);
    }

    public final void dCn() {
        AppMethodBeat.m2504i(30679);
        if (!C14987n.m23305a(this.yod.yTx, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG)) {
            Toast.makeText(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(C25738R.string.e29), 1).show();
        }
        AppMethodBeat.m2505o(30679);
    }

    /* renamed from: Qu */
    public final boolean mo38999Qu(String str) {
        AppMethodBeat.m2504i(30659);
        this.yod.dFA();
        this.yod.dCy();
        boolean arq = ((C30467ad) this.yod.mo74857aF(C30467ad.class)).arq(str);
        AppMethodBeat.m2505o(30659);
        return arq;
    }

    public final void bNK() {
        AppMethodBeat.m2504i(30660);
        this.yod.dFA();
        this.yod.dCy();
        AppMethodBeat.m2505o(30660);
    }

    public final void bNL() {
        AppMethodBeat.m2504i(30661);
        this.yod.dFA();
        this.yod.dCy();
        AppMethodBeat.m2505o(30661);
    }

    /* renamed from: i */
    static /* synthetic */ void m48714i(C30562p c30562p) {
        AppMethodBeat.m2504i(30680);
        c30562p.yod.yTx.enableOptionMenu(false);
        c30562p.yod.yTx.enableBackMenu(false);
        if (c30562p.yJe != null) {
            C4997aj.amA("keep_app_silent");
            c30562p.oor.setRecordNormalWording(c30562p.yod.yTx.getMMResources().getString(C25738R.string.aj5));
            c30562p.yJe.mo47624em(c30562p.getTalkerUserName());
            c30562p.yJg = c30562p.yJe.getFileName();
            c30562p.yJe.mo47622a(c30562p.ooy);
            c30562p.kgA.vibrate(50);
            c30562p.yod.aWv();
            c30562p.yod.dFA();
            c30562p.yJe.mo47621a(c30562p.oox);
            AppMethodBeat.m2505o(30680);
            return;
        }
        C4990ab.m7412e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
        AppMethodBeat.m2505o(30680);
    }

    /* renamed from: a */
    static /* synthetic */ void m48705a(C30562p c30562p, C46650a c46650a, int i, Intent intent) {
        AppMethodBeat.m2504i(30683);
        if (i == -1 && intent != null) {
            int mA;
            String str;
            ((C44296aa) c46650a.mo74857aF(C44296aa.class)).mo70172g(217, i, intent);
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            if (c46650a.dFx()) {
                mA = C37921n.m64060mA(c30562p.yJf);
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
                wXMediaMessage.description = C5046bo.m7565ga(file.length());
                C4733l.m7090a(wXMediaMessage, "", "", c30562p.yJf, 4, null);
                int lastIndexOf = file.getName().lastIndexOf(".");
                str = "";
                if (lastIndexOf >= 0 && lastIndexOf < file.getName().length() - 1) {
                    str = file.getName().substring(lastIndexOf + 1);
                }
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = Long.valueOf(file.length());
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(c46650a.dFx() ? 1 : 0);
                objArr[3] = Integer.valueOf(mA);
                objArr[4] = str;
                c7060h.mo8381e(14986, objArr);
            }
            str = intent.getStringExtra("with_text_content");
            if (!C5046bo.isNullOrNil(str)) {
                C12519g.bOk().mo46461eZ(str, c30562p.yJf);
            }
        }
        AppMethodBeat.m2505o(30683);
    }
}
