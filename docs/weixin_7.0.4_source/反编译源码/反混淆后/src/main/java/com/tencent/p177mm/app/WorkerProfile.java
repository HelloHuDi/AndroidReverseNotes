package com.tencent.p177mm.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.plugin.C1263d;
import com.tencent.p177mm.app.plugin.C1265e;
import com.tencent.p177mm.app.plugin.C32261a;
import com.tencent.p177mm.app.plugin.p706b.C45156a.C6318a;
import com.tencent.p177mm.booter.C1321a;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.booter.C45270c;
import com.tencent.p177mm.booter.NotifyReceiver;
import com.tencent.p177mm.booter.notification.C18103d;
import com.tencent.p177mm.booter.notification.C44682b;
import com.tencent.p177mm.booter.notification.p841a.C25977g;
import com.tencent.p177mm.booter.notification.p841a.C37622h;
import com.tencent.p177mm.choosemsgfile.compat.C32464b;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.console.C45300a;
import com.tencent.p177mm.console.Shell;
import com.tencent.p177mm.console.Shell.Receiver;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.kiss.p243a.C1742b.C17432;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C24672an;
import com.tencent.p177mm.model.C26412am;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C42195f.C26425a;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9634ae;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p263d.C1843a;
import com.tencent.p177mm.model.p263d.C1843a.C18461;
import com.tencent.p177mm.model.p263d.C1843a.C18472;
import com.tencent.p177mm.model.p263d.C31273b;
import com.tencent.p177mm.modelappbrand.C32812p;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.modelsimple.C18675k;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.utils.ILog;
import com.tencent.p177mm.opensdk.utils.Log;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p1192h.C42127b;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p1638bs.C45273a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C41736i;
import com.tencent.p177mm.p183ai.C7477v;
import com.tencent.p177mm.p183ai.C7477v.C1221a;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p190at.C32290n;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.p209c.C32429a.C32430a;
import com.tencent.p177mm.p209c.C37624b;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18273g;
import com.tencent.p177mm.p230g.p231a.C18298il;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C18363pa;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26100ce;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C26212ov;
import com.tencent.p177mm.p230g.p231a.C26215pi;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p230g.p231a.C32548fc;
import com.tencent.p177mm.p230g.p231a.C32575ja;
import com.tencent.p177mm.p230g.p231a.C32579jc;
import com.tencent.p177mm.p230g.p231a.C32614pk;
import com.tencent.p177mm.p230g.p231a.C32621pw;
import com.tencent.p177mm.p230g.p231a.C32649ub;
import com.tencent.p177mm.p230g.p231a.C37698c;
import com.tencent.p177mm.p230g.p231a.C37700ck;
import com.tencent.p177mm.p230g.p231a.C37739iu;
import com.tencent.p177mm.p230g.p231a.C37775nx;
import com.tencent.p177mm.p230g.p231a.C37787qr;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p230g.p231a.C6459ak;
import com.tencent.p177mm.p230g.p231a.C6488hm;
import com.tencent.p177mm.p230g.p231a.C6512kz;
import com.tencent.p177mm.p230g.p231a.C6548tf;
import com.tencent.p177mm.p230g.p231a.C9302bl;
import com.tencent.p177mm.p230g.p231a.C9411lk;
import com.tencent.p177mm.p230g.p231a.C9440ph;
import com.tencent.p177mm.p230g.p231a.C9443pj;
import com.tencent.p177mm.p230g.p231a.C9468sj;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p264n.C7486a.C1888a;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.C5227ai.C5226a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.chatting.C36121ak;
import com.tencent.p177mm.p612ui.chatting.p1090b.C23707a;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p612ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.p177mm.p612ui.tools.NewTaskUI;
import com.tencent.p177mm.p612ui.transmit.C44387d;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.account.bind.p271ui.C18815e;
import com.tencent.p177mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.p177mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.p177mm.plugin.bbom.C38673d;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20022a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.p499b.C7046e;
import com.tencent.p177mm.plugin.report.service.C34831i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.IKVReportNotify;
import com.tencent.p177mm.pluginsdk.C44055j;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.pluginsdk.C46490h;
import com.tencent.p177mm.pluginsdk.C46500q;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30061al.C30062a;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e.C40422a;
import com.tencent.p177mm.pluginsdk.p1082i.C14862c;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23314l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C40487b.C4758a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.any;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.app.WorkerProfile */
public final class WorkerProfile extends C1439e implements C1202f, C1221a, C26412am, C26425a, IKVReportNotify {
    public static final String ceo = (C4996ah.getPackageName());
    private static WorkerProfile cfI;
    private static int cfX = -1;
    /* renamed from: ID */
    private final int f2858ID = 2130706432;
    private final Shell cfG = new Shell();
    private final C45300a cfH = new C45300a();
    private C24672an cfJ;
    private C5133b cfK;
    private C9634ae cfL;
    public boolean cfM = false;
    @Deprecated
    public boolean cfN;
    public boolean cfO;
    private final int cfP = 0;
    private final int cfQ = 1;
    private int cfR;
    private StringBuilder cfS = new StringBuilder();
    private C25977g cfT;
    private C42127b cfU;
    public final C41759y cfV = new C41759y();
    public final C24654x cfW = new C24654x();
    private boolean cfY = false;
    protected Locale locale;

    /* renamed from: com.tencent.mm.app.WorkerProfile$18 */
    class C631518 extends C4884c<C26100ce> {
        C631518() {
            AppMethodBeat.m2504i(15500);
            this.xxI = C26100ce.class.getName().hashCode();
            AppMethodBeat.m2505o(15500);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15501);
            C26100ce c26100ce = (C26100ce) c4883b;
            Context context = c26100ce.cvl.context;
            if (context == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, context is null");
                AppMethodBeat.m2505o(15501);
                return false;
            }
            String[] strArr = c26100ce.cvl.selectionArgs;
            if (strArr == null || strArr.length < 2) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, invalid args");
                AppMethodBeat.m2505o(15501);
                return false;
            }
            String str;
            int i;
            String[] strArr2 = c26100ce.cvl.crW;
            String str2 = "";
            if (strArr2 != null && strArr2.length > 0) {
                str2 = strArr2[0];
            }
            String str3 = strArr[0];
            String str4 = strArr[1];
            String str5 = strArr[2];
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            if (c26100ce.cvl.action == 1) {
                str = "action_create";
                if (strArr.length >= 4) {
                    str6 = strArr[3];
                }
                if (strArr.length >= 5) {
                    str7 = strArr[4];
                }
                if (strArr.length >= 6) {
                    str8 = strArr[5];
                }
                if (strArr.length >= 7) {
                    str9 = strArr[6];
                }
                i = 14;
            } else if (c26100ce.cvl.action == 2) {
                str = "action_join";
                if (strArr.length >= 4) {
                    str7 = strArr[3];
                }
                if (strArr.length >= 5) {
                    str8 = strArr[4];
                }
                if (strArr.length >= 6) {
                    str9 = strArr[5];
                }
                i = 15;
            } else {
                AppMethodBeat.m2505o(15501);
                return false;
            }
            Intent intent = new Intent(context, WXBizEntryActivity.class);
            intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
            intent.putExtra("key_app_id", str3);
            intent.putExtra("key_transaction", str4);
            intent.putExtra("key_command_id", i);
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, str);
            intent.putExtra("package_name", str2);
            intent.putExtra(C8741b.GROUP_ID, str5);
            intent.putExtra("chatroom_name", str6);
            intent.putExtra("chatroom_nickname", str7);
            intent.putExtra("ext_msg", str8);
            intent.putExtra("open_id", str9);
            context.startActivity(intent);
            AppMethodBeat.m2505o(15501);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$19 */
    class C631619 extends C4884c<C26215pi> {
        C631619() {
            super(0);
            AppMethodBeat.m2504i(15502);
            this.xxI = C26215pi.class.getName().hashCode();
            AppMethodBeat.m2505o(15502);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15503);
            C26215pi c26215pi = (C26215pi) c4883b;
            Context context = c26215pi.cLA.context;
            if (context == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
            } else {
                String str;
                String str2;
                String[] strArr = c26215pi.cLA.crW;
                if (strArr == null || strArr.length <= 0) {
                    str = null;
                    str2 = null;
                } else {
                    String str3 = strArr[0];
                    str = C1178g.m2591x(C35799p.m58691bx(c26215pi.cLA.context, strArr[0])[0].toByteArray());
                    str2 = str3;
                }
                String[] strArr2 = c26215pi.cLA.selectionArgs;
                if (strArr2 != null && strArr2.length >= 6) {
                    Intent intent = new Intent(context, WXBizEntryActivity.class);
                    intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                    intent.putExtra("key_way", 4);
                    intent.putExtra("appId", strArr2[0]);
                    intent.putExtra("timeStamp", strArr2[1]);
                    intent.putExtra("nonceStr", strArr2[2]);
                    intent.putExtra("packageExt", strArr2[5]);
                    intent.putExtra("signtype", strArr2[3]);
                    intent.putExtra("paySignature", strArr2[4]);
                    intent.putExtra("key_wxapi_package_name", str2);
                    intent.putExtra("key_wxapi_sign", str);
                    intent.putExtra("key_command_id", 13);
                    context.startActivity(intent);
                }
            }
            AppMethodBeat.m2505o(15503);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$11 */
    class C895911 extends C4884c<C18273g> {
        C895911() {
            AppMethodBeat.m2504i(15486);
            this.xxI = C18273g.class.getName().hashCode();
            AppMethodBeat.m2505o(15486);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            String str = null;
            AppMethodBeat.m2504i(15487);
            C18273g c18273g = (C18273g) c4883b;
            Context context = c18273g.crV.context;
            if (context == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
                AppMethodBeat.m2505o(15487);
                return false;
            }
            String str2;
            String str3;
            String str4;
            String str5;
            String[] strArr = c18273g.crV.crW;
            if (strArr == null || strArr.length <= 0) {
                str2 = null;
                str3 = null;
            } else {
                str3 = strArr[0];
                str2 = C1178g.m2591x(C35799p.m58691bx(c18273g.crV.context, strArr[0])[0].toByteArray());
            }
            String[] strArr2 = c18273g.crV.selectionArgs;
            if (strArr2 == null || strArr2.length <= 1) {
                str4 = null;
                str5 = null;
            } else {
                str4 = strArr2[0];
                str5 = strArr2[1];
            }
            if (strArr2 != null && strArr2.length > 2) {
                str = strArr2[2];
            }
            C4990ab.m7417i("MicroMsg.WorkerProfile", "carlist = %s, appid = %s, transcation = %s", str5, str4, str);
            Intent intent = new Intent(context, WXBizEntryActivity.class);
            intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
            intent.putExtra("key_in_card_list", str5);
            intent.putExtra("key_package_name", str3);
            intent.putExtra("key_sign", str2);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_command_id", 9);
            intent.putExtra("key_app_id", str4);
            intent.putExtra("key_transaction", str);
            context.startActivity(intent);
            AppMethodBeat.m2505o(15487);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$6 */
    class C89606 extends C4884c<C6512kz> {
        C89606() {
            AppMethodBeat.m2504i(15473);
            this.xxI = C6512kz.class.getName().hashCode();
            AppMethodBeat.m2505o(15473);
        }

        @TargetApi(16)
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            Notification a;
            AppMethodBeat.m2504i(15474);
            C6512kz c6512kz = (C6512kz) c4883b;
            int dtd = C41789d.akP().dtd();
            int i = c6512kz.cGR.type;
            String str = c6512kz.cGR.userName;
            String anU = C37626b.dqD().anU(c6512kz.cGR.bCu);
            if (WorkerProfile.this.cfT == null) {
                WorkerProfile.this.cfT = new C25977g(C4996ah.getContext());
            }
            WorkerProfile.this.cfT;
            int bWV = C45186a.bWV();
            Notification notification = new Notification();
            notification.icon = C25738R.drawable.icon;
            notification.when = System.currentTimeMillis();
            notification.flags = 16;
            Intent intent = new Intent();
            intent.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
            intent.setFlags(335544320);
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 0, intent, 134217728);
            if (i == 1) {
                String string = C4996ah.getContext().getString(C25738R.string.d9s);
                Bitmap a2 = C41730b.m73490a(str, false, -1);
                String str2 = anU + string;
                String string2 = C4996ah.getContext().getString(C25738R.string.d95);
                String string3 = C4996ah.getContext().getString(C25738R.string.bwi);
                Intent intent2 = new Intent();
                intent2.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent2.putExtra("friend_message_transfer_username", str);
                intent2.setAction("friend_message_ignore_".concat(String.valueOf(str)));
                PendingIntent activity2 = PendingIntent.getActivity(C4996ah.getContext(), 0, intent2, 134217728);
                intent2 = new Intent();
                intent2.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent2.putExtra("friend_message_transfer_username", str);
                intent2.setAction("friend_message_accept_".concat(String.valueOf(str)));
                a = C9638aw.getNotification().mo41572a(notification, bWV, activity, anU, string, str2, a2, string2, activity2, string3, PendingIntent.getActivity(C4996ah.getContext(), 0, intent2, 134217728), str);
            } else {
                String str3;
                String string4 = C4996ah.getContext().getString(C25738R.string.d9r);
                if (dtd > 2) {
                    str3 = anU + C4996ah.getContext().getString(C25738R.string.d9o, new Object[]{Integer.valueOf(dtd)});
                } else {
                    str3 = anU;
                }
                Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), bWV);
                a = C9638aw.getNotification().mo41571a(notification, bWV, 1, activity, str3, string4, str3 + string4, decodeResource, str);
            }
            if (VERSION.SDK_INT >= 16) {
                a.priority = 2;
            }
            if (str != null) {
                WorkerProfile.this.cfR = 2130706432 | (str.hashCode() & 16777215);
            } else {
                WorkerProfile.this.cfR = 2130706432;
            }
            C9638aw.getNotification().mo41574a(WorkerProfile.this.cfR, a, false);
            if (dtd == 0) {
                C41789d.eRI = 0;
            } else {
                WorkerProfile.this.cfS.append(WorkerProfile.this.cfR + ",");
                C4996ah.getContext().getSharedPreferences("notify_newfriend_prep", 0).edit().putString("notify_newfriend_prep", WorkerProfile.this.cfS.toString()).commit();
            }
            AppMethodBeat.m2505o(15474);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$9 */
    class C89619 extends C4884c<C6488hm> {
        C89619() {
            AppMethodBeat.m2504i(15482);
            this.xxI = C6488hm.class.getName().hashCode();
            AppMethodBeat.m2505o(15482);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15483);
            C6488hm c6488hm = (C6488hm) c4883b;
            if (c6488hm == null || c6488hm.cCo == null) {
                C4990ab.m7420w("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent event null ret false");
                AppMethodBeat.m2505o(15483);
            } else {
                final int i = c6488hm.cCo.cCp;
                final boolean z = c6488hm.cCo.cCq;
                C4990ab.m7417i("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent callback event noticeid[%d], manualauthSucc[%b]", Integer.valueOf(i), Boolean.valueOf(z));
                C9638aw.m17180RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(15481);
                        C9638aw.m17182Rg().mo14541a(new C18675k(i, z), 0);
                        AppMethodBeat.m2505o(15481);
                    }
                });
                AppMethodBeat.m2505o(15483);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$25 */
    class C896325 implements ILog {
        C896325() {
            AppMethodBeat.m2504i(15517);
            AppMethodBeat.m2505o(15517);
        }

        /* renamed from: v */
        public final void mo20423v(String str, String str2) {
            AppMethodBeat.m2504i(138588);
            C4990ab.m7418v(str, str2);
            AppMethodBeat.m2505o(138588);
        }

        /* renamed from: d */
        public final void mo20420d(String str, String str2) {
            AppMethodBeat.m2504i(138589);
            C4990ab.m7410d(str, str2);
            AppMethodBeat.m2505o(138589);
        }

        /* renamed from: i */
        public final void mo20422i(String str, String str2) {
            AppMethodBeat.m2504i(138590);
            C4990ab.m7416i(str, str2);
            AppMethodBeat.m2505o(138590);
        }

        /* renamed from: w */
        public final void mo20424w(String str, String str2) {
            AppMethodBeat.m2504i(138591);
            C4990ab.m7420w(str, str2);
            AppMethodBeat.m2505o(138591);
        }

        /* renamed from: e */
        public final void mo20421e(String str, String str2) {
            AppMethodBeat.m2504i(138592);
            C4990ab.m7412e(str, str2);
            AppMethodBeat.m2505o(138592);
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$31 */
    class C896431 extends C4884c<C6548tf> {
        C896431() {
            AppMethodBeat.m2504i(15536);
            this.xxI = C6548tf.class.getName().hashCode();
            AppMethodBeat.m2505o(15536);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15537);
            C6548tf c6548tf = (C6548tf) c4883b;
            if (c6548tf.cPv.cPw == 3) {
                NotifyReceiver.m41394Im();
            }
            C37634d.dvV().mo60468ev(c6548tf.cPv.className, c6548tf.cPv.cPw);
            AppMethodBeat.m2505o(15537);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$10 */
    class C896510 extends C4884c<C26212ov> {
        C896510() {
            AppMethodBeat.m2504i(15484);
            this.xxI = C26212ov.class.getName().hashCode();
            AppMethodBeat.m2505o(15484);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15485);
            C7620bi c7620bi = ((C26212ov) c4883b).cLh.csG;
            if (c7620bi != null) {
                C4990ab.m7417i("MicroMsg.WorkerProfile", "resend msg, type:%d", Integer.valueOf(c7620bi.getType()));
                long oC;
                if (c7620bi.drD()) {
                    C36121ak.m59475aQ(c7620bi);
                } else if (c7620bi.drE()) {
                    C36121ak.m59476aR(c7620bi);
                } else if (c7620bi.dtx()) {
                    C36121ak.m59477aS(c7620bi);
                } else if (c7620bi.isText()) {
                    C36121ak.m59479aU(c7620bi);
                } else if (c7620bi.bAC()) {
                    C36121ak.m59480aV(c7620bi);
                } else if (c7620bi.dty()) {
                    C36121ak.m59478aT(c7620bi);
                } else if (c7620bi.bAA()) {
                    C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", Long.valueOf(c7620bi.field_msgId));
                    oC = C1829bf.m3756oC(c7620bi.field_talker);
                    if (oC == c7620bi.field_createTime) {
                        oC++;
                    }
                    c7620bi.mo14775eJ(oC);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                    String str = c7620bi.field_content;
                    int i = c7620bi.field_isSend;
                    String str2 = c7620bi.field_talker;
                    int i2 = (C1855t.m3907mT(str2) || C37921n.m64068ms(str2)) ? 1 : 0;
                    if (!(i2 == 0 || str == null || i != 0)) {
                        str = C1829bf.m3763oz(str);
                    }
                    C8910b me = C8910b.m16064me(str);
                    if ((me == null || 19 != me.type) && (me == null || 24 != me.type)) {
                        C4733l.m7097al(c7620bi);
                    } else {
                        C18348nt c18348nt = new C18348nt();
                        c18348nt.cJY.type = 4;
                        c18348nt.cJY.cKd = c7620bi;
                        c18348nt.cJY.toUser = c7620bi.field_talker;
                        C4879a.xxA.mo10055m(c18348nt);
                    }
                    C1829bf.m3748fm(c7620bi.field_msgId);
                } else if (c7620bi.dtw()) {
                    C36121ak.m59481aW(c7620bi);
                } else if (c7620bi.bws() || c7620bi.bwt()) {
                    oC = C1829bf.m3756oC(c7620bi.field_talker);
                    if (oC == c7620bi.field_createTime) {
                        oC++;
                    }
                    c7620bi.mo14775eJ(oC);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                    C26493s uf = C37961o.all().mo21063uf(c7620bi.field_imgPath);
                    if (uf != null) {
                        uf.createTime = c7620bi.field_createTime;
                        uf.bJt = 128;
                        C37961o.all().mo21060c(uf);
                        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendVideoMsg, msgId:%d, msgtime: %d, infotime:%d", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_createTime), Long.valueOf(uf.createTime));
                    }
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable()) {
                        C26494u.m42267us(c7620bi.field_imgPath);
                    } else {
                        C23639t.m36492hO(C4996ah.getContext());
                    }
                } else {
                    c7620bi.setStatus(5);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                    C4990ab.m7412e("MicroMsg.WorkerProfile", "resendMsg, unknown msg type");
                }
            }
            AppMethodBeat.m2505o(15485);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$12 */
    class C896612 extends C1924a {
        C896612() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(15488);
            if (i != 4 && i != 6) {
                AppMethodBeat.m2505o(15488);
            } else if (C9638aw.m17179RK() && C1720g.m3534RN().eJb && !C9638aw.m17178QT()) {
                C4990ab.m7416i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
                C9638aw.m17182Rg().mo14541a(new C26451h(), 0);
                AppMethodBeat.m2505o(15488);
            } else {
                AppMethodBeat.m2505o(15488);
            }
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$23 */
    class C896723 implements C1837a {
        C896723() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(15512);
            C34831i.m57200Wa(C1946aa.m4148a(c1197a.eAB.vED));
            AppMethodBeat.m2505o(15512);
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$24 */
    class C896824 extends C4884c<C32621pw> {

        /* renamed from: com.tencent.mm.app.WorkerProfile$24$1 */
        class C89691 implements C5662c {
            C89691() {
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(15513);
                MMAppMgr.ymL = false;
                WorkerProfile.this.cfY = false;
                AppMethodBeat.m2505o(15513);
            }
        }

        C896824() {
            AppMethodBeat.m2504i(15514);
            this.xxI = C32621pw.class.getName().hashCode();
            AppMethodBeat.m2505o(15514);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15516);
            boolean Cg = m16184Cg();
            AppMethodBeat.m2505o(15516);
            return Cg;
        }

        /* renamed from: Cg */
        private boolean m16184Cg() {
            int i;
            AppMethodBeat.m2504i(15515);
            if (C1443d.m3068iW(23)) {
                Context context = C4996ah.getContext();
                int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_if_show_ignore_battery_optimizations, 0);
                i = C5018as.amF("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
                C4990ab.m7417i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", Integer.valueOf(i));
                if (C5046bo.m7563gW(a, 1) && i < 3 && !C45270c.m83435bn(context)) {
                    C4990ab.m7416i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
                    Editor edit = C5018as.amF("sdcard_usable_report").edit();
                    long currentTimeMillis = System.currentTimeMillis();
                    Object obj = null;
                    if (i == 0) {
                        try {
                            C45270c.m83432Ih();
                        } catch (Exception e) {
                            obj = 1;
                            C4990ab.m7417i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e.getClass().toString(), e.getMessage());
                        }
                        if (obj == null) {
                            edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                            edit.putInt("ignore_battery_dialog_time", 1);
                        }
                    } else {
                        long j = currentTimeMillis - C5018as.amF("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", currentTimeMillis);
                        C4990ab.m7417i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", Long.valueOf(C5018as.amF("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", currentTimeMillis)), Long.valueOf(j));
                        if (i == 1) {
                            if (j >= 86400000) {
                                try {
                                    C45270c.m83432Ih();
                                } catch (Exception e2) {
                                    obj = 1;
                                    C4990ab.m7417i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e2.getClass().toString(), e2.getMessage());
                                }
                                if (obj == null) {
                                    edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                    edit.putInt("ignore_battery_dialog_time", 2);
                                }
                            }
                        } else if (i == 2 && j >= 604800000) {
                            try {
                                C45270c.m83432Ih();
                            } catch (Exception e22) {
                                obj = 1;
                                C4990ab.m7417i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e22.getClass().toString(), e22.getMessage());
                            }
                            if (obj == null) {
                                edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                edit.putInt("ignore_battery_dialog_time", 3);
                            }
                        }
                    }
                    edit.commit();
                }
            }
            Editor edit2;
            if (C14862c.diH() || WorkerProfile.this.cfY) {
                C4990ab.m7417i("MicroMsg.WorkerProfile", "SdcardUsableDetectionEvent pass tipCountAboutSdcarDisable=%s ifSdcardDialogShow=%s", Integer.valueOf(WorkerProfile.cfX), Boolean.valueOf(WorkerProfile.this.cfY));
                WorkerProfile.cfX = -1;
                if (WorkerProfile.this.cfY) {
                    AppMethodBeat.m2505o(15515);
                    return false;
                }
                SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("sdcard_usable_report", 4);
                int i2 = sharedPreferences.getInt("mm_process_pid", -1);
                i = Process.myPid();
                C4990ab.m7417i("MicroMsg.WorkerProfile", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", Integer.valueOf(i2), Integer.valueOf(i));
                if (C5046bo.m7563gW(i2, -1)) {
                    AppMethodBeat.m2505o(15515);
                    return false;
                }
                if (C5046bo.m7563gW(i2, i)) {
                    C7060h.pYm.mo15419k(951, 22, 1);
                } else if (!C5046bo.m7563gW(i2, i)) {
                    C7060h.pYm.mo15419k(951, 21, 1);
                }
                edit2 = sharedPreferences.edit();
                edit2.putInt("mm_process_pid", -1);
                edit2.commit();
                AppMethodBeat.m2505o(15515);
                return false;
            }
            WorkerProfile.m16162Cd();
            C4990ab.m7417i("MicroMsg.WorkerProfile", "tipCountAboutSdcarDisable:%d", Integer.valueOf(WorkerProfile.cfX));
            if (WorkerProfile.cfX <= 0) {
                AppMethodBeat.m2505o(15515);
                return false;
            }
            WorkerProfile.this.cfY = true;
            switch (WorkerProfile.cfX) {
                case 1:
                    C7060h.pYm.mo15419k(951, 0, 1);
                    edit2 = C4996ah.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
                    edit2.putInt("mm_process_pid", Process.myPid());
                    edit2.commit();
                    break;
                case 3:
                    C7060h.pYm.mo15419k(951, 1, 1);
                    break;
                case 5:
                    C7060h.pYm.mo15419k(951, 2, 1);
                    break;
                case 10:
                    C7060h.pYm.mo15419k(951, 3, 1);
                    break;
            }
            new C5659a(C4996ah.getContext()).asL(C4996ah.getContext().getString(C25738R.string.dz7)).mo11514al(C4996ah.getContext().getString(C25738R.string.f9238tz)).mo11526re(false).mo11522b(new C89691()).show();
            AppMethodBeat.m2505o(15515);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$26 */
    class C897026 implements C40422a {
        C897026() {
        }

        /* renamed from: bd */
        public final void mo20426bd(Context context) {
            AppMethodBeat.m2504i(138593);
            MMAppMgr.m7905bd(context);
            AppMethodBeat.m2505o(138593);
        }

        /* renamed from: Ch */
        public final boolean mo20425Ch() {
            AppMethodBeat.m2504i(138594);
            boolean Ch = MMAppMgr.m7892Ch();
            AppMethodBeat.m2505o(138594);
            return Ch;
        }

        /* renamed from: k */
        public final void mo20428k(Context context, boolean z) {
            AppMethodBeat.m2504i(138595);
            MMAppMgr.m7913k(context, z);
            AppMethodBeat.m2505o(138595);
        }

        /* renamed from: be */
        public final void mo20427be(Context context) {
            AppMethodBeat.m2504i(138596);
            MMAppMgr.m7906be(context);
            AppMethodBeat.m2505o(138596);
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$30 */
    class C897130 extends C4884c<C26171jl> {
        C897130() {
            AppMethodBeat.m2504i(15534);
            this.xxI = C26171jl.class.getName().hashCode();
            AppMethodBeat.m2505o(15534);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = true;
            AppMethodBeat.m2504i(15535);
            C26171jl c26171jl = (C26171jl) c4883b;
            if (c26171jl.cEK.boZ != 2 && c26171jl.cEK.status == 0) {
                C45287c.atD("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
            }
            if (C9638aw.m17179RK()) {
                boolean z2 = c26171jl.cEK.boZ == 3;
                if (c26171jl.cEK.boZ != 1) {
                    z = false;
                }
                if (z2) {
                    C6665av.fly.mo14897ak("login_user_name", "");
                    C1668a.m3387QJ();
                } else {
                    if (z) {
                        C1668a.m3387QJ();
                    }
                    C6665av c6665av = C6665av.fly;
                    C9638aw.m17190ZK();
                    String str = (String) C18628c.m29072Ry().get(6, null);
                    C9638aw.m17190ZK();
                    int intValue = ((Integer) C18628c.m29072Ry().get(9, null)).intValue();
                    C9638aw.m17190ZK();
                    c6665av.mo14898c(str, intValue, (String) C18628c.m29072Ry().get(5, null));
                }
            }
            AppMethodBeat.m2505o(15535);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$5 */
    class C89725 extends C4884c<C9468sj> {
        C89725() {
            AppMethodBeat.m2504i(15471);
            this.xxI = C9468sj.class.getName().hashCode();
            AppMethodBeat.m2505o(15471);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15472);
            C9468sj c9468sj = (C9468sj) c4883b;
            Context context = c9468sj.cOF.context;
            String str = c9468sj.cOF.cOG;
            if (context == null || C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(15472);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(15472);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$7 */
    class C89737 extends C4884c<C32579jc> {
        C89737() {
            AppMethodBeat.m2504i(15475);
            this.xxI = C32579jc.class.getName().hashCode();
            AppMethodBeat.m2505o(15475);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15476);
            C32579jc c32579jc = (C32579jc) c4883b;
            Context context = c32579jc.cEj.context;
            if (context == null) {
                context = C4996ah.getContext();
            }
            c32579jc.cEk.cEn = C46494g.m87727a(context, c32579jc.cEj.appId, c32579jc.cEj.cEl, c32579jc.cEj.showType, c32579jc.cEj.cEm, c32579jc.cEj.cvs);
            AppMethodBeat.m2505o(15476);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$8 */
    class C89748 extends C4884c<C32548fc> {
        C89748() {
            AppMethodBeat.m2504i(15477);
            this.xxI = C32548fc.class.getName().hashCode();
            AppMethodBeat.m2505o(15477);
        }

        /* renamed from: a */
        private static boolean m16195a(C32548fc c32548fc) {
            AppMethodBeat.m2504i(15478);
            if (c32548fc == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
                AppMethodBeat.m2505o(15478);
                return false;
            } else if (!(c32548fc instanceof C32548fc)) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
                AppMethodBeat.m2505o(15478);
                return false;
            } else if (c32548fc.cyu == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
                AppMethodBeat.m2505o(15478);
                return false;
            } else {
                Intent intent;
                switch (c32548fc.cyu.f2860op) {
                    case 27:
                        if (c32548fc.cyu.selectionArgs == null || c32548fc.cyu.selectionArgs.length < 2) {
                            C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
                            AppMethodBeat.m2505o(15478);
                            return true;
                        }
                        Object encode;
                        String str = "";
                        Object obj = c32548fc.cyu.selectionArgs[0];
                        String str2 = c32548fc.cyu.selectionArgs[1];
                        if (c32548fc.cyu.selectionArgs.length >= 3) {
                            Object nullAsNil = C5046bo.nullAsNil(c32548fc.cyu.selectionArgs[2]);
                            try {
                                encode = URLEncoder.encode(nullAsNil, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                encode = nullAsNil;
                            }
                        } else {
                            String encode2 = str;
                        }
                        if (obj == null || str2 == null) {
                            C4990ab.m7413e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", obj, str2);
                            AppMethodBeat.m2505o(15478);
                            return true;
                        }
                        int i;
                        if (c32548fc.cyu.selectionArgs.length >= 4) {
                            str = c32548fc.cyu.selectionArgs[3];
                            if (!C5046bo.isNullOrNil(str)) {
                                i = C5046bo.getInt(str, 0);
                                C4990ab.m7416i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                                str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                                intent = new Intent(c32548fc.cyu.context, WXCustomSchemeEntryActivity.class);
                                intent.addFlags(268435456);
                                intent.setData(Uri.parse(str));
                                intent.putExtra("translate_link_scene", 1);
                                c32548fc.cyu.context.startActivity(intent);
                                AppMethodBeat.m2505o(15478);
                                return true;
                            }
                        }
                        i = 0;
                        C4990ab.m7416i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                        str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                        intent = new Intent(c32548fc.cyu.context, WXCustomSchemeEntryActivity.class);
                        intent.addFlags(268435456);
                        intent.setData(Uri.parse(str));
                        intent.putExtra("translate_link_scene", 1);
                        c32548fc.cyu.context.startActivity(intent);
                        AppMethodBeat.m2505o(15478);
                        return true;
                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        C4990ab.m7416i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
                        Context context = c32548fc.cyu.context;
                        intent = new Intent(context, WXBizEntryActivity.class);
                        intent.addFlags(268435456);
                        intent.putExtra("key_command_id", 11);
                        context.startActivity(intent);
                        AppMethodBeat.m2505o(15478);
                        return true;
                    default:
                        boolean a = C89748.m16194a(c32548fc.cyu.context, c32548fc.cyu.selectionArgs, c32548fc.cyu.crW, c32548fc.cyu.cvd, c32548fc.cyu.cyv);
                        AppMethodBeat.m2505o(15478);
                        return a;
                }
            }
        }

        /* renamed from: a */
        private static boolean m16194a(Context context, String[] strArr, String[] strArr2, int i, String str) {
            AppMethodBeat.m2504i(15479);
            if (context == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
                context = C4996ah.getContext();
            }
            if (strArr == null || strArr.length < 2) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
                AppMethodBeat.m2505o(15479);
                return false;
            }
            int i2;
            int length = strArr.length;
            for (i2 = 0; i2 < length; i2++) {
                C4990ab.m7417i("MicroMsg.WorkerProfile", "arg : %s", strArr[i2]);
            }
            String str2 = strArr[0];
            String str3 = strArr[1];
            String str4 = null;
            if (strArr.length > 2) {
                str4 = strArr[2];
            }
            length = 0;
            if (strArr.length > 3) {
                length = C5046bo.getInt(strArr[3], 0);
            }
            int i3 = 0;
            if (strArr.length > 4) {
                i3 = C5046bo.getInt(strArr[4], 0);
            }
            C4990ab.m7417i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", Integer.valueOf(i));
            switch (i) {
                case 1:
                    if (strArr2 == null || strArr2.length == 0) {
                        C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
                        AppMethodBeat.m2505o(15479);
                        return false;
                    }
                case 2:
                    if (C5046bo.isNullOrNil(str)) {
                        C4990ab.m7413e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", str);
                        AppMethodBeat.m2505o(15479);
                        return false;
                    }
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
                    AppMethodBeat.m2505o(15479);
                    return false;
            }
            C4990ab.m7417i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", str2, str3, str4, str);
            if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
                AppMethodBeat.m2505o(15479);
                return false;
            }
            int i4 = 0;
            if (length == 1) {
                i4 = 8;
            } else if (length == 0) {
                i4 = 7;
            }
            Intent intent = new Intent(context, WXBizEntryActivity.class);
            intent.putExtra("key_command_id", i4);
            intent.putExtra("appId", str2);
            intent.putExtra("toUserName", str3);
            intent.putExtra(IssueStorage.COLUMN_EXT_INFO, str4);
            intent.putExtra("source", i);
            intent.putExtra("scene", length);
            intent.putExtra("jump_profile_type", i3);
            intent.addFlags(268435456).addFlags(67108864);
            if (strArr2 != null && strArr2.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (Object add : strArr2) {
                    arrayList.add(add);
                }
                intent.putStringArrayListExtra("androidPackNameList", arrayList);
            }
            context.startActivity(intent);
            AppMethodBeat.m2505o(15479);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$1 */
    class C89751 implements C5226a {
        C89751() {
        }

        /* renamed from: v */
        public final void mo10735v(String str, String str2) {
            AppMethodBeat.m2504i(15460);
            C4990ab.m7418v(str, str2);
            AppMethodBeat.m2505o(15460);
        }

        /* renamed from: d */
        public final void mo10732d(String str, String str2) {
            AppMethodBeat.m2504i(15461);
            C4990ab.m7410d(str, str2);
            AppMethodBeat.m2505o(15461);
        }

        /* renamed from: i */
        public final void mo10734i(String str, String str2) {
            AppMethodBeat.m2504i(15462);
            C4990ab.m7416i(str, str2);
            AppMethodBeat.m2505o(15462);
        }

        /* renamed from: w */
        public final void mo10736w(String str, String str2) {
            AppMethodBeat.m2504i(15463);
            C4990ab.m7420w(str, str2);
            AppMethodBeat.m2505o(15463);
        }

        /* renamed from: e */
        public final void mo10733e(String str, String str2) {
            AppMethodBeat.m2504i(15464);
            C4990ab.m7412e(str, str2);
            AppMethodBeat.m2505o(15464);
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$13 */
    class C897613 extends C4884c<C9302bl> {
        C897613() {
            AppMethodBeat.m2504i(15489);
            this.xxI = C9302bl.class.getName().hashCode();
            AppMethodBeat.m2505o(15489);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i = 0;
            AppMethodBeat.m2504i(15490);
            C9302bl c9302bl = (C9302bl) c4883b;
            Context context = c9302bl.cuK.context;
            if (context == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "choose card from wx event, context is null");
                AppMethodBeat.m2505o(15490);
                return false;
            }
            String[] strArr = c9302bl.cuK.crW;
            String str = null;
            if (strArr != null && strArr.length > 0) {
                str = strArr[0];
                C1178g.m2591x(C35799p.m58691bx(c9302bl.cuK.context, strArr[0])[0].toByteArray());
            }
            String[] strArr2 = c9302bl.cuK.selectionArgs;
            if (strArr2 == null || strArr2.length < 10) {
                if (strArr2 != null) {
                    i = strArr2.length;
                }
                C4990ab.m7412e("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs is null or length is < 10, the length is ".concat(String.valueOf(i)));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < strArr2.length; i2++) {
                    stringBuilder.append(", selectionArgs[" + i2 + "]:" + strArr2[i2]);
                }
                C4990ab.m7417i("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs:", strArr2.toString());
                Intent intent = new Intent(context, WXBizEntryActivity.class);
                intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                intent.putExtra("app_id", strArr2[0]);
                intent.putExtra("shop_id", C5046bo.getInt(strArr2[1], 0));
                intent.putExtra("sign_type", strArr2[2]);
                intent.putExtra("card_sign", strArr2[3]);
                intent.putExtra("time_stamp", C5046bo.getInt(strArr2[4], 0));
                intent.putExtra("nonce_str", strArr2[5]);
                intent.putExtra("card_tp_id", strArr2[6]);
                intent.putExtra("card_type", strArr2[7]);
                intent.putExtra("can_multi_select", C5046bo.getInt(strArr2[8], 0));
                intent.putExtra("key_from_scene", 8);
                intent.putExtra("key_command_id", 16);
                intent.putExtra("key_app_id", strArr2[0]);
                intent.putExtra("key_package_name", str);
                intent.putExtra("key_transaction", strArr2[9]);
                context.startActivity(intent);
            }
            AppMethodBeat.m2505o(15490);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$14 */
    class C897714 extends C4884c<C32614pk> {
        C897714() {
            AppMethodBeat.m2504i(15491);
            this.xxI = C32614pk.class.getName().hashCode();
            AppMethodBeat.m2505o(15491);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15492);
            C32614pk c32614pk = (C32614pk) c4883b;
            Context context = c32614pk.cLC.context;
            if (context == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "context is null");
            } else {
                String[] strArr = c32614pk.cLC.crW;
                String str = null;
                String str2 = null;
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                    str2 = C1178g.m2591x(C35799p.m58691bx(c32614pk.cLC.context, strArr[0])[0].toByteArray());
                }
                String[] strArr2 = c32614pk.cLC.selectionArgs;
                if (strArr2 == null || strArr2.length <= 0) {
                    C4990ab.m7412e("MicroMsg.WorkerProfile", "args is null");
                } else {
                    C4990ab.m7417i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle event, withType = %b", Boolean.valueOf(c32614pk.cLC.cLD));
                    String str3;
                    String str4;
                    Intent intent;
                    C32800b y;
                    if (!c32614pk.cLC.cLD) {
                        str3 = null;
                        str4 = null;
                        if (strArr2 != null && strArr2.length > 1) {
                            str3 = strArr2[0];
                            str4 = strArr2[1];
                        }
                        C4990ab.m7417i("MicroMsg.WorkerProfile", "open webview, appid = %s, url = %s", str3, str4);
                        if (!(C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4))) {
                            C4990ab.m7417i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&url=%s", new Object[]{str3, str4}));
                            intent = new Intent(context, WXBizEntryActivity.class);
                            intent.setData(Uri.parse(str4));
                            intent.addFlags(268435456);
                            intent.putExtra("key_package_name", str);
                            intent.putExtra("translate_link_scene", 1);
                            intent.putExtra("key_package_signature", str2);
                            intent.putExtra("key_command_id", 12);
                            y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
                            y.mo53356j("key_package_name", str);
                            y.mo53356j("key_package_signature", str2);
                            C4990ab.m7417i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                            context.startActivity(intent);
                            AppMethodBeat.m2505o(15492);
                            return true;
                        }
                    } else if (strArr2 == null || strArr2.length <= 0) {
                        C4990ab.m7412e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle fail, selectionArgs length invalid");
                    } else {
                        str4 = strArr2[0];
                        C4990ab.m7417i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent, typeStr = %s, appid = %s", strArr2[1], str4);
                        String str5;
                        switch (C5046bo.ank(str3)) {
                            case 1:
                                if (strArr2.length < 5) {
                                    C4990ab.m7413e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", Integer.valueOf(strArr2.length));
                                }
                                String str6 = strArr2[2];
                                String str7 = strArr2[3];
                                str5 = strArr2[4];
                                C4990ab.m7417i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, scene = %s, templateID = %s, reserved = %s", str4, Integer.valueOf(r3), str6, str7, str5);
                                if (C5046bo.isNullOrNil(str4)) {
                                    C4990ab.m7412e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                    break;
                                }
                                str5 = Uri.encode(String.format("scene=%s&template_id=%s&reserved=%s", new Object[]{str6, str7, str5}));
                                C4990ab.m7417i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                intent = new Intent(context, WXBizEntryActivity.class);
                                intent.setData(Uri.parse(str4));
                                intent.addFlags(268435456);
                                intent.putExtra("key_package_name", str);
                                intent.putExtra("translate_link_scene", 1);
                                intent.putExtra("key_package_signature", str2);
                                intent.putExtra("key_command_id", 12);
                                y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
                                y.mo53356j("key_package_name", str);
                                y.mo53356j("key_package_signature", str2);
                                C4990ab.m7417i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                context.startActivity(intent);
                                AppMethodBeat.m2505o(15492);
                                return true;
                            case 5:
                                if (strArr2.length < 5) {
                                    C4990ab.m7413e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", Integer.valueOf(strArr2.length));
                                }
                                C4990ab.m7417i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, miniProgramAppid = %s", str4, Integer.valueOf(r3), strArr2[2]);
                                if (C5046bo.isNullOrNil(str4)) {
                                    C4990ab.m7412e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                    break;
                                } else if (C5046bo.isNullOrNil(str5)) {
                                    C4990ab.m7412e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, miniProgramAppid is null");
                                    break;
                                } else {
                                    str5 = Uri.encode(String.format("miniProgramAppid=%s", new Object[]{str5}));
                                    C4990ab.m7417i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                    intent = new Intent(context, WXBizEntryActivity.class);
                                    intent.setData(Uri.parse(str4));
                                    intent.addFlags(268435456);
                                    intent.putExtra("key_package_name", str);
                                    intent.putExtra("translate_link_scene", 1);
                                    intent.putExtra("key_package_signature", str2);
                                    intent.putExtra("key_command_id", 12);
                                    y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
                                    y.mo53356j("key_package_name", str);
                                    y.mo53356j("key_package_signature", str2);
                                    C4990ab.m7417i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                    context.startActivity(intent);
                                    AppMethodBeat.m2505o(15492);
                                    return true;
                                }
                            default:
                                if (strArr2.length < 3) {
                                    C4990ab.m7413e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent fail, unknown type = %d", Integer.valueOf(r3));
                                    break;
                                }
                                str5 = strArr2[2];
                                C4990ab.m7417i("MicroMsg.WorkerProfile", "default url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                intent = new Intent(context, WXBizEntryActivity.class);
                                intent.setData(Uri.parse(str4));
                                intent.addFlags(268435456);
                                intent.putExtra("key_package_name", str);
                                intent.putExtra("translate_link_scene", 1);
                                intent.putExtra("key_package_signature", str2);
                                intent.putExtra("key_command_id", 12);
                                y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
                                y.mo53356j("key_package_name", str);
                                y.mo53356j("key_package_signature", str2);
                                C4990ab.m7417i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                context.startActivity(intent);
                                AppMethodBeat.m2505o(15492);
                                return true;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(15492);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$16 */
    class C897816 extends C4884c<C9440ph> {
        C897816() {
            AppMethodBeat.m2504i(15495);
            this.xxI = C9440ph.class.getName().hashCode();
            AppMethodBeat.m2505o(15495);
        }

        /* renamed from: a */
        private static boolean m16204a(C9440ph c9440ph) {
            AppMethodBeat.m2504i(15496);
            String[] strArr = c9440ph.cLz.selectionArgs;
            if (strArr == null || strArr.length == 0) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "args is null");
                AppMethodBeat.m2505o(15496);
                return true;
            } else if (strArr.length < 2) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "args must contain appid and username");
                AppMethodBeat.m2505o(15496);
                return true;
            } else {
                String str;
                Context context = c9440ph.cLz.context;
                String str2 = strArr[0];
                String str3 = strArr[1];
                String str4 = "";
                int i = 0;
                String str5 = "";
                int i2 = 0;
                String str6 = "";
                String str7 = "";
                String str8 = "";
                if (strArr.length > 2) {
                    str4 = strArr[2];
                }
                if (strArr.length > 3) {
                    i = C5046bo.getInt(strArr[3], 0);
                }
                if (strArr.length > 4) {
                    str = strArr[4];
                    if (str != null) {
                        try {
                            C41726i c41726i = new C41726i(URLDecoder.decode(str, ProtocolPackage.ServerEncoding));
                            str5 = URLEncoder.encode(c41726i.optString("invokeData"), ProtocolPackage.ServerEncoding);
                            i2 = C5046bo.getInt(c41726i.optString("pathType"), 0);
                            str6 = c41726i.optString("runtimeAppid");
                            str7 = c41726i.optString("runtimeTicket");
                            str8 = c41726i.optString("runtimeSessionId");
                            C4990ab.m7417i("MicroMsg.WorkerProfile", "invokeData = %s, pathType:%d, runtimeAppid:%s, runtimeTicket:%s, runtimeSessionId:%s", str5, Integer.valueOf(i2), str6, str7, str8);
                        } catch (C41724g e) {
                            C4990ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                        } catch (UnsupportedEncodingException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.WorkerProfile", e2, "", new Object[0]);
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.WorkerProfile", "extdata is null");
                    }
                }
                if (!C5046bo.isNullOrNil(str4)) {
                    try {
                        str4 = URLEncoder.encode(str4);
                    } catch (Exception e3) {
                        C4990ab.m7413e("MicroMsg.WorkerProfile", "encode path failed : %s", e3.getMessage());
                        str4 = "";
                    }
                }
                String[] strArr2 = c9440ph.cLz.crW;
                String str9 = null;
                str = null;
                if (strArr2 != null && strArr2.length > 0) {
                    str9 = strArr2[0];
                    Signature[] bx = C35799p.m58691bx(c9440ph.cLz.context, strArr2[0]);
                    if (bx != null && bx.length > 0) {
                        str = C1178g.m2591x(bx[0].toByteArray());
                    }
                }
                C4990ab.m7417i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, appid = %s, username = %s, path = %s, type = %d", str2, str3, str4, Integer.valueOf(i));
                C4990ab.m7417i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, package name = %s, sig = %s", str9, str);
                C4990ab.m7417i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/jumpWxa/?appid=%s&userName=%s@app&path=%s&invokeData=%s&pathType=%d&runtimeAppid=%s&runtimeTicket=%s&runtimeSessionId=%s", new Object[]{str2, str3, str4, str5, Integer.valueOf(i2), str6, str7, str8}));
                Intent intent = new Intent(context, WXBizEntryActivity.class);
                intent.setData(Uri.parse(str4));
                intent.addFlags(268435456);
                intent.putExtra("key_app_id", str2);
                intent.putExtra("key_package_name", str9);
                intent.putExtra("translate_link_scene", 1);
                intent.putExtra("key_package_signature", str);
                intent.putExtra("key_command_id", 19);
                C32800b y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
                y.mo53356j("key_package_name", str9);
                y.mo53356j("key_package_signature", str);
                y.mo53356j("key_launch_miniprogram_type", Integer.valueOf(i));
                C4990ab.m7417i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s, type = %d", str9, str, Integer.valueOf(i));
                context.startActivity(intent);
                AppMethodBeat.m2505o(15496);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$2 */
    class C89812 extends C4884c<C42041qh> {
        C89812() {
            AppMethodBeat.m2504i(15465);
            this.xxI = C42041qh.class.getName().hashCode();
            AppMethodBeat.m2505o(15465);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15466);
            C42041qh c42041qh = (C42041qh) c4883b;
            C36249e.m59677a(c42041qh.cMw.intent, c42041qh.cMw.username);
            AppMethodBeat.m2505o(15466);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$33 */
    class C898233 extends C4884c<C32649ub> {
        C898233() {
            AppMethodBeat.m2504i(15541);
            this.xxI = C32649ub.class.getName().hashCode();
            AppMethodBeat.m2505o(15541);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15542);
            C4990ab.m7416i("MicroMsg.WorkerProfile", "upload sql file");
            C31273b.abr().mo51235pg(C31273b.m50486pe(C31273b.fpk + "MMSQL.trace"));
            AppMethodBeat.m2505o(15542);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$4 */
    class C89834 extends C4884c<C32575ja> {
        C89834() {
            AppMethodBeat.m2504i(15469);
            this.xxI = C32575ja.class.getName().hashCode();
            AppMethodBeat.m2505o(15469);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15470);
            C32575ja c32575ja = (C32575ja) c4883b;
            String str = c32575ja.cEg.cEh;
            String str2 = c32575ja.cEg.url;
            C4990ab.m7417i("MicroMsg.WorkerProfile", "summertoken KickOffline callback wording[%s], url[%s]", str, str2);
            C7060h.pYm.mo8378a(322, 21, 1, true);
            LauncherUI instance = LauncherUI.getInstance();
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(4021);
            String str3 = "%s|%s|%b";
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = str2;
            boolean z = instance == null || instance.isFinishing();
            objArr2[2] = Boolean.valueOf(z);
            objArr[1] = String.format(str3, objArr2);
            c7060h.mo8381e(11098, objArr);
            if (instance == null || instance.isFinishing()) {
                C7060h.pYm.mo8378a(322, 22, 1, true);
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4022);
                str3 = "%s|%s|%b";
                objArr2 = new Object[3];
                objArr2[0] = str;
                objArr2[1] = str2;
                objArr2[2] = Boolean.valueOf(instance == null);
                objArr[1] = String.format(str3, objArr2);
                c7060h.mo8381e(11098, objArr);
                C4990ab.m7421w("MicroMsg.WorkerProfile", "summertoken KickOffline error LauncherUI is null launcherisFirst[%b], launcheruiOnTop[%b] return", Boolean.valueOf(WorkerProfile.this.cfN), Boolean.valueOf(WorkerProfile.this.cfO));
            }
            C30777u.m49117a(instance, str, str2, new Intent().setClass(instance, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864));
            AppMethodBeat.m2505o(15470);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$20 */
    class C898420 extends C4884c<C9411lk> {

        /* renamed from: com.tencent.mm.app.WorkerProfile$20$1 */
        class C89851 implements C1202f {
            C89851() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(15504);
                C9638aw.m17182Rg().mo14546b(1145, (C1202f) this);
                C4990ab.m7417i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i != 0 || i2 != 0) {
                    AppMethodBeat.m2505o(15504);
                } else if (c1207m.getType() != 1145) {
                    AppMethodBeat.m2505o(15504);
                } else {
                    C32812p c32812p = (C32812p) c1207m;
                    if ((((any) c32812p.fpJ.fsG.fsP).wsv & 1) == 0) {
                        AppMethodBeat.m2505o(15504);
                        return;
                    }
                    boolean z = c32812p.abG().vKO;
                    C9638aw.m17190ZK();
                    if (z != C18628c.m29072Ry().getBoolean(C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                        C4990ab.m7417i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", Boolean.valueOf(z));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(z));
                        C4879a.xxA.mo10055m(new C37775nx());
                    }
                    z = c32812p.abG().wsw;
                    C9638aw.m17190ZK();
                    if (z != C18628c.m29072Ry().getBoolean(C5127a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                        C4990ab.m7417i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", Boolean.valueOf(z));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(z));
                        C4879a.xxA.mo10055m(new C37775nx());
                    }
                    AppMethodBeat.m2505o(15504);
                }
            }
        }

        C898420() {
            AppMethodBeat.m2504i(15505);
            this.xxI = C9411lk.class.getName().hashCode();
            AppMethodBeat.m2505o(15505);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15507);
            boolean Cf = m16211Cf();
            AppMethodBeat.m2505o(15507);
            return Cf;
        }

        /* renamed from: Cf */
        private boolean m16211Cf() {
            AppMethodBeat.m2504i(15506);
            C9638aw.m17182Rg().mo14539a(1145, new C89851());
            C9638aw.m17182Rg().mo14541a(new C32812p(5), 0);
            AppMethodBeat.m2505o(15506);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$21 */
    class C898621 extends C4884c<C37787qr> {
        C898621() {
            AppMethodBeat.m2504i(15508);
            this.xxI = C37787qr.class.getName().hashCode();
            AppMethodBeat.m2505o(15508);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15509);
            C37787qr c37787qr = (C37787qr) c4883b;
            C23314l.m35797a(c37787qr.cMP.context, c37787qr.cMP.cMQ, c37787qr.cMP.cMR, c37787qr.cMP.cMS);
            AppMethodBeat.m2505o(15509);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$22 */
    class C898722 extends C4884c<C18363pa> {
        C898722() {
            AppMethodBeat.m2504i(15510);
            this.xxI = C18363pa.class.getName().hashCode();
            AppMethodBeat.m2505o(15510);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15511);
            C18103d.m28522in(0);
            C18103d.m28519bx(true);
            AppMethodBeat.m2505o(15511);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$34 */
    class C898834 extends C4884c<C18372qb> {
        C898834() {
            AppMethodBeat.m2504i(15543);
            this.xxI = C18372qb.class.getName().hashCode();
            AppMethodBeat.m2505o(15543);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15544);
            C18372qb c18372qb = (C18372qb) c4883b;
            for (String c26451h : C5046bo.m7508P(c18372qb.cMq.cMr.split(","))) {
                C9638aw.m17182Rg().mo14541a(new C26451h(c26451h, c18372qb.cMq.content, c18372qb.cMq.type), 0);
            }
            AppMethodBeat.m2505o(15544);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$35 */
    class C898935 extends C4884c<C26217py> {
        C898935() {
            AppMethodBeat.m2504i(15545);
            this.xxI = C26217py.class.getName().hashCode();
            AppMethodBeat.m2505o(15545);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15546);
            C26217py c26217py = (C26217py) c4883b;
            for (String str : C5046bo.m7508P(c26217py.cMe.toUser.split(","))) {
                if (C5046bo.isNullOrNil(c26217py.cMe.cMi)) {
                    WXMediaMessage wXMediaMessage = c26217py.cMe.cEl;
                    String str2 = c26217py.cMe.appId;
                    String str3 = c26217py.cMe.appName;
                    int i = c26217py.cMe.cMf;
                    String str4 = c26217py.cMe.cMg;
                    String str5 = c26217py.cMe.cMh;
                    String str6 = c26217py.cMe.cMj;
                    String str7 = c26217py.cMe.cMk;
                    String str8 = c26217py.cMe.cMl;
                    String str9 = c26217py.cMe.cMm;
                    String str10 = c26217py.cMe.cvF;
                    String str11 = c26217py.cMe.cMn;
                    C30065b c30065b = null;
                    C8910b c8910b = new C8910b();
                    C32800b y = C37922v.m64076Zp().mo60676y(str10, true);
                    if (y.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE")) {
                        int i2 = y.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
                        if (i2 != -1) {
                            C37435f c25747e = new C25747e();
                            c25747e.ffZ = i2;
                            if (i2 == 5) {
                                c25747e.fgd = y.getString("_DATA_CENTER_VID", "");
                                c25747e.fga = y.getInt("_DATA_CENTER_PUB_TIME", 0);
                                c25747e.duration = y.getInt("_DATA_CENTER__DULATION", 0);
                                c25747e.videoWidth = y.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
                                c25747e.videoHeight = y.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
                                c25747e.fgc = y.getInt("_DATA_CENTER_FUNC_FLAG", 0);
                            }
                            c8910b.mo20334a(c25747e);
                        }
                        c8910b.thumburl = y.getString("_DATA_CENTER_COVER_URL", "");
                    }
                    c8910b.appId = str2;
                    c8910b.appName = str3;
                    c8910b.fgr = i;
                    c8910b.cMg = str4;
                    c8910b.cMh = str5;
                    c8910b.cMj = str6;
                    c8910b.cMk = str7;
                    c8910b.cMl = str8;
                    c8910b.cMm = str9;
                    c8910b.cMn = str11;
                    str2 = C4733l.m7098b(c8910b, wXMediaMessage, null);
                    C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " content url:" + c8910b.url + " lowUrl:" + c8910b.fgn + " attachlen:" + c8910b.fgo + " attachid:" + c8910b.csD + " attach file:" + str2);
                    String str12 = System.currentTimeMillis();
                    if (!C5046bo.isNullOrNil(str2)) {
                        c30065b = C4733l.m7093a(str12, c8910b, str2);
                        if (c30065b == null) {
                            C1447g.getLine();
                        }
                    }
                    C7620bi c7620bi = new C7620bi();
                    if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                        str2 = C32291o.ahl().mo73094a(wXMediaMessage.thumbData, c8910b.type == 2, CompressFormat.PNG);
                        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " thumbData MsgInfo path:" + str2);
                        if (!C5046bo.isNullOrNil(str2)) {
                            c7620bi.mo14795jv(str2);
                            C4990ab.m7410d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(str2)));
                        }
                    }
                    if (c30065b != null) {
                        c8910b.csD = c30065b.xDa;
                    }
                    c7620bi.setContent(C8910b.m16061a(c8910b, null, null));
                    c7620bi.setStatus(1);
                    c7620bi.mo14794ju(str);
                    c7620bi.mo14775eJ(C1829bf.m3756oC(str));
                    c7620bi.mo14781hO(1);
                    c7620bi.setType(C4733l.m7100d(c8910b));
                    if (C17903f.m28103kq(c7620bi.field_talker)) {
                        c7620bi.mo14791ix(C25754e.aae());
                        C4990ab.m7411d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", c7620bi.dqJ);
                    }
                    C9638aw.m17190ZK();
                    long Z = C18628c.m29080XO().mo15281Z(c7620bi);
                    C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " msginfo insert id: " + Z);
                    if (Z < 0) {
                        C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + "insert msg failed :" + Z);
                        C1447g.getLine();
                    } else {
                        C4990ab.m7416i("MicroMsg.AppMsgLogic", C1447g.getLine() + " new msg inserted to db , local id = " + Z);
                        c7620bi.setMsgId(Z);
                        C8909j c8909j = new C8909j();
                        c8909j.field_xml = c7620bi.field_content;
                        c8909j.field_title = wXMediaMessage.title;
                        c8909j.field_type = wXMediaMessage.mediaObject.type();
                        c8909j.field_description = wXMediaMessage.description;
                        c8909j.field_msgId = Z;
                        c8909j.field_source = str3;
                        C14877am.dhN().mo10101b((C4925c) c8909j);
                        if (c30065b != null) {
                            c30065b.field_msgInfoId = Z;
                            c30065b.field_status = 101;
                            C14877am.aUq().mo48326a(c30065b, new String[0]);
                            C14877am.dhP().run();
                        } else {
                            C14877am.dhP();
                            C30062a.m47588A(Z, str10);
                        }
                    }
                } else {
                    C4733l.m7090a(c26217py.cMe.cEl, c26217py.cMe.appId, c26217py.cMe.appName, str, c26217py.cMe.cMf, c26217py.cMe.cMi);
                }
            }
            AppMethodBeat.m2505o(15546);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$15 */
    class C899015 extends C4884c<C9443pj> {
        C899015() {
            AppMethodBeat.m2504i(15493);
            this.xxI = C9443pj.class.getName().hashCode();
            AppMethodBeat.m2505o(15493);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15494);
            C9443pj c9443pj = (C9443pj) c4883b;
            String[] strArr = c9443pj.cLB.selectionArgs;
            if (strArr == null || strArr.length == 0) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "args is null");
                AppMethodBeat.m2505o(15494);
            } else if (strArr.length <= 0) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "args must contain appid");
                AppMethodBeat.m2505o(15494);
            } else {
                String str;
                String str2;
                String str3;
                Context context = c9443pj.cLB.context;
                String str4 = strArr[0];
                strArr = c9443pj.cLB.crW;
                if (strArr == null || strArr.length <= 0) {
                    str = null;
                    str2 = null;
                } else {
                    str3 = strArr[0];
                    str = C1178g.m2591x(C35799p.m58691bx(c9443pj.cLB.context, strArr[0])[0].toByteArray());
                    str2 = str3;
                }
                C4990ab.m7417i("MicroMsg.WorkerProfile", "sdk open offlinePay, appid = %s, package = %s", str4, str2);
                C4990ab.m7417i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/offlinepay/?appid=%s", new Object[]{str4}));
                Intent intent = new Intent(context, WXBizEntryActivity.class);
                intent.setData(Uri.parse(str3));
                intent.addFlags(268435456);
                intent.putExtra("key_app_id", str4);
                intent.putExtra("key_package_name", str2);
                intent.putExtra("translate_link_scene", 1);
                intent.putExtra("key_package_signature", str);
                intent.putExtra("key_command_id", 24);
                C32800b y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
                y.mo53356j("key_package_name", str2);
                y.mo53356j("key_package_signature", str);
                C4990ab.m7417i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str2, str);
                context.startActivity(intent);
                AppMethodBeat.m2505o(15494);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$17 */
    class C899117 extends C4884c<C18298il> {
        C899117() {
            AppMethodBeat.m2504i(15498);
            this.xxI = C18298il.class.getName().hashCode();
            AppMethodBeat.m2505o(15498);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15499);
            C18298il c18298il = (C18298il) c4883b;
            Context context = c18298il.cDC.context;
            if (context == null) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "context is null");
            } else {
                String str;
                String str2;
                String[] strArr = c18298il.cDC.crW;
                if (strArr == null || strArr.length <= 0) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = strArr[0];
                    str = C1178g.m2591x(C35799p.m58691bx(c18298il.cDC.context, strArr[0])[0].toByteArray());
                }
                String[] strArr2 = c18298il.cDC.selectionArgs;
                if (strArr2 == null || strArr2.length <= 0) {
                    C4990ab.m7412e("MicroMsg.WorkerProfile", "args is null");
                } else {
                    String str3;
                    String str4;
                    if (strArr2 == null || strArr2.length <= 1) {
                        str3 = null;
                        str4 = null;
                    } else {
                        str4 = strArr2[0];
                        str3 = strArr2[1];
                    }
                    C4990ab.m7417i("MicroMsg.WorkerProfile", "handleScanResult, appid = %s, scanResult = %s", str4, str3);
                    if (!(C5046bo.isNullOrNil(str4) || C5046bo.isNullOrNil(str3))) {
                        String format = String.format("weixin://dl/handleScanResult?appid=%s&result=%s", new Object[]{str4, str3});
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.setData(Uri.parse(format));
                        intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                        intent.putExtra("key_command_id", 17);
                        intent.putExtra("key_package_name", str2);
                        intent.putExtra("translate_link_scene", 1);
                        intent.putExtra("key_package_signature", str);
                        context.startActivity(intent);
                        AppMethodBeat.m2505o(15499);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(15499);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$28 */
    class C899228 implements C5133b {
        C899228() {
        }

        /* renamed from: a */
        public final void mo10533a(C7620bi c7620bi, PString pString, PString pString2, PInt pInt, boolean z) {
            AppMethodBeat.m2504i(138600);
            C37622h.m63528b(c7620bi, pString, pString2, pInt, z);
            AppMethodBeat.m2505o(138600);
        }

        /* renamed from: a */
        public final String mo10532a(int i, String str, String str2, int i2, Context context) {
            AppMethodBeat.m2504i(138601);
            String a = C37622h.m63519a(i, str, str2, i2, context);
            AppMethodBeat.m2505o(138601);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$32 */
    class C899332 extends C4884c<C37739iu> {
        C899332() {
            AppMethodBeat.m2504i(15539);
            this.xxI = C37739iu.class.getName().hashCode();
            AppMethodBeat.m2505o(15539);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15540);
            C37739iu c37739iu = (C37739iu) c4883b;
            final String str = c37739iu.cDU.imagePath;
            final String str2 = c37739iu.cDU.toUser;
            final boolean booleanValue = c37739iu.cDU.cDV.booleanValue();
            final int i = c37739iu.cDU.cDW;
            if (c37739iu.cDU.cDX.booleanValue()) {
                C9638aw.m17180RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(15538);
                        if (C1720g.m3534RN().mo5161QY()) {
                            C32290n.ahb().mo52996a(0, i, str, str2, booleanValue);
                            AppMethodBeat.m2505o(15538);
                            return;
                        }
                        C4990ab.m7420w("MicroMsg.WorkerProfile", "ImageSelectedOperationEvent: account not init.");
                        AppMethodBeat.m2505o(15538);
                    }
                });
            }
            AppMethodBeat.m2505o(15540);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WorkerProfile$3 */
    class C89953 extends C4884c<C37698c> {
        C89953() {
            AppMethodBeat.m2504i(15467);
            this.xxI = C37698c.class.getName().hashCode();
            AppMethodBeat.m2505o(15467);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15468);
            C37698c c37698c = (C37698c) c4883b;
            MMActivity mMActivity = c37698c.crO.crP;
            C30777u.m49118a(mMActivity, c37698c.crO.errType, c37698c.crO.errCode, new Intent().setClass(mMActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), null);
            AppMethodBeat.m2505o(15468);
            return false;
        }
    }

    /* renamed from: Cd */
    static /* synthetic */ int m16162Cd() {
        int i = cfX;
        cfX = i + 1;
        return i;
    }

    static {
        AppMethodBeat.m2504i(15558);
        AppMethodBeat.m2505o(15558);
    }

    public WorkerProfile() {
        AppMethodBeat.m2504i(15547);
        cfI = this;
        AppMethodBeat.m2505o(15547);
    }

    /* renamed from: Ca */
    public static WorkerProfile m16161Ca() {
        return cfI;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x07af  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x062b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0701 A:{Splitter:B:10:0x00fa, ExcHandler: NameNotFoundException (e android.content.pm.PackageManager$NameNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0701 A:{Splitter:B:10:0x00fa, ExcHandler: NameNotFoundException (e android.content.pm.PackageManager$NameNotFoundException)} */
    /* JADX WARNING: Missing block: B:89:0x0702, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate() {
        AppMethodBeat.m2504i(15548);
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7418v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
        C4990ab.m7416i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + ceo + Process.myPid());
        C4990ab.m7417i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", Boolean.TRUE, Thread.currentThread().getName());
        long currentTimeMillis2 = System.currentTimeMillis();
        C1843a abl = C1843a.abl();
        C1843a.ceK = ceo;
        if (C4996ah.xzd) {
            C4990ab.m7416i("MicroMsg.HandlerTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(C1173e.deleteFile(C1843a.foO))));
        }
        abl.fpd = System.currentTimeMillis();
        C7306ak.setLogCallback(new C18461());
        C5013ao.m7459a("NetsceneQueue forbid in ", new C18472());
        C9638aw.m17182Rg().mo14539a(-1, (C1202f) this);
        C7477v.m12891a(this);
        C9638aw.m17193ZN().fkz = this;
        C9638aw.m17198a(new C896612());
        C9638aw.getSysCmdMsgExtension().mo14900a("getkvidkeystg", new C896723(), true);
        Application application = this.app;
        C5059g.m7674gj(application);
        C5059g.m7675gk(application);
        try {
            C32429a c32429a;
            String str = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).applicationInfo.sourceDir;
            C4990ab.m7417i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", str);
            try {
                int cs = C1173e.m2560cs(str);
                C4990ab.m7417i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", Integer.valueOf(cs));
                if (cs >= 8) {
                    C32430a C = C32430a.m53090C(C1173e.m2571f(str, cs - 8, 8));
                    if (C == null) {
                        C4990ab.m7412e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
                    } else if ((C.cde + 8) - 8 >= 0) {
                        C37624b c37624b = new C37624b();
                        c37624b.parseFrom(C1173e.m2571f(str, (cs - ((C.cde + 8) - 8)) - 8, (C.cde + 8) - 8));
                        c32429a = new C32429a(c37624b);
                        C4990ab.m7416i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
                    } else {
                        C4990ab.m7412e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", e.getMessage());
            } catch (NameNotFoundException e2) {
            }
            c32429a = C32429a.m53086cL(str);
            C1326d bo;
            Context applicationContext;
            int i;
            int i2;
            SharedPreferences sharedPreferences;
            int i3;
            int i4;
            Editor edit;
            C45154c c45154c;
            C42127b c42127b;
            C897927 c897927;
            if (c32429a == null || c32429a.cdc == null) {
                str = "MicroMsg.WorkerProfile";
                String str2 = "initChannelUtil something null %s";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(c32429a == null);
                C4990ab.m7413e(str, str2, objArr);
                C1245d.m2681Ba();
                bo = C1326d.m2839bo(this.app);
                if (!(bo == null || bo.ebO == -1)) {
                    C5059g.cdf = bo.ebO;
                }
                applicationContext = this.app.getApplicationContext();
                i = C5059g.cdf;
                i2 = C7243d.vxo;
                if (applicationContext != null && i >= 0 && i2 >= 637534208) {
                    try {
                        sharedPreferences = applicationContext.getSharedPreferences("crash_status_file", 4);
                        i3 = sharedPreferences.getInt("channel", -1);
                        i4 = sharedPreferences.getInt("version", 0);
                        if (!(i3 == i && i4 == i2)) {
                            edit = sharedPreferences.edit();
                            edit.putInt("channel", i);
                            edit.putInt("version", i2);
                            edit.commit();
                        }
                    } catch (Throwable th) {
                    }
                }
                if (C5059g.xyb > 0) {
                    C5059g.xyd = true;
                }
                C25985d.dlL();
                C7243d.eSg = "android-" + (C5046bo.isNullOrNil(C5059g.cdg) ? Integer.valueOf(VERSION.SDK_INT) : C5059g.cdg);
                if (!C5046bo.isNullOrNil(C4872b.dnP())) {
                    C7243d.eSg = "android-" + C4872b.dnP();
                }
                C4990ab.m7419v("MicroMsg.WorkerProfile", "set device type :%s  %s", C7243d.eSg, C4872b.dnP());
                this.locale = MMActivity.initLanguage(this.app.getBaseContext());
                if (C4872b.dnO()) {
                    Shell shell = this.cfG;
                    Context context = C4996ah.getContext();
                    if (shell.ewv == null) {
                        shell.ewv = new Receiver();
                        context.registerReceiver(shell.ewv, Shell.ewx);
                    }
                }
                C4879a.xxA.mo10052c(this.cfH);
                c45154c = new C45154c();
                C4990ab.m7410d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(c45154c)));
                C40460b.pqK = c45154c;
                C40423e.vdx = new C897026();
                C1720g.m3543a(C41736i.class, new C6625e(this.cfW));
                C1720g.m3543a(C46490h.class, new C6625e(this.cfW));
                C1720g.m3543a(C44055j.class, new C6625e(this.cfW));
                C1720g.m3542a(C20022a.class, new C38673d());
                C1720g.m3542a(C46500q.class, new C1263d());
                C1720g.m3542a(C32464b.class, new C23707a());
                C4879a.xxA.mo10052c(new C6318a());
                if (this.cfJ == null) {
                    this.cfJ = new C44682b(this.app);
                }
                this.cfU = new C42127b();
                c42127b = this.cfU;
                C4990ab.m7416i("MicroMsg.BroadcastController", "summerdiz init");
                C4879a.xxA.mo10052c(c42127b.eeX);
                C4879a.xxA.mo10052c(new C17432());
                C4879a.xxA.mo10052c(new C18815e());
                C4879a.xxA.mo10052c(new C897130());
                C4879a.xxA.mo10052c(new C896431());
                C4879a.xxA.mo10052c(new C899332());
                C4879a.xxA.mo10052c(new C898233());
                C4879a.xxA.mo10052c(new C898834());
                C4879a.xxA.mo10052c(new C898935());
                C4879a.xxA.mo10052c(new C89812());
                C4879a.xxA.mo10052c(new C89953());
                C4879a.xxA.mo10052c(new C89834());
                C4879a.xxA.mo10052c(new C89725());
                C4879a.xxA.mo10052c(new C89606());
                C4879a.xxA.mo10052c(new C89737());
                C4879a.xxA.mo10052c(new C89748());
                C4879a.xxA.mo10052c(new C89619());
                C4879a.xxA.mo10052c(new C896510());
                C4879a.xxA.mo10052c(new C895911());
                C4879a.xxA.mo10052c(new C897613());
                C4879a.xxA.mo10052c(new C897714());
                C4879a.xxA.mo10052c(new C899015());
                C4879a.xxA.mo10052c(new C897816());
                C4879a.xxA.mo10052c(new C899117());
                C4879a.xxA.mo10052c(new C631518());
                C4879a.xxA.mo10052c(new C631619());
                C4879a.xxA.mo10052c(new C898420());
                C4879a.xxA.mo10052c(new C898621());
                C4879a.xxA.mo10052c(new C898722());
                C4879a.xxA.mo10052c(new C9004m(2, 12));
                C4879a.xxA.mo10052c(new C896824());
                C12519g.opT = new C44387d();
                C23257a.vax = new C32261a();
                C4758a.vrC = C1265e.m2715Cl();
                if (!C9638aw.m17178QT()) {
                    C9638aw.m17190ZK();
                }
                C4879a.xxA.mo10055m(new C37700ck());
                this.cfM = true;
                Log.setLogImpl(new C896325());
                C4990ab.m7410d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
                applicationContext = C4996ah.getContext();
                c897927 = new C1888a() {
                    final Map<String, Integer> cgf = new HashMap();
                    final Map<String, Integer> map = new HashMap();

                    /* renamed from: do */
                    public final String mo5471do(String str) {
                        AppMethodBeat.m2504i(138598);
                        if (this.map.containsKey(str)) {
                            String string = applicationContext.getString(((Integer) this.map.get(str)).intValue());
                            AppMethodBeat.m2505o(138598);
                            return string;
                        }
                        AppMethodBeat.m2505o(138598);
                        return null;
                    }

                    /* renamed from: dp */
                    public final String mo5472dp(String str) {
                        AppMethodBeat.m2504i(138599);
                        if (this.cgf.containsKey(str)) {
                            String string = applicationContext.getString(((Integer) this.cgf.get(str)).intValue());
                            AppMethodBeat.m2505o(138599);
                            return string;
                        }
                        AppMethodBeat.m2505o(138599);
                        return null;
                    }
                };
                c897927.map.put("qqmail", Integer.valueOf(C25738R.string.cat));
                c897927.map.put("fmessage", Integer.valueOf(C25738R.string.c_z));
                c897927.map.put("floatbottle", Integer.valueOf(C25738R.string.c_k));
                c897927.map.put("lbsapp", Integer.valueOf(C25738R.string.ca7));
                c897927.map.put("shakeapp", Integer.valueOf(C25738R.string.cb5));
                c897927.map.put("medianote", Integer.valueOf(C25738R.string.caf));
                c897927.map.put("qqfriend", Integer.valueOf(C25738R.string.caq));
                c897927.map.put("newsapp", Integer.valueOf(C25738R.string.cb1));
                c897927.map.put("facebookapp", Integer.valueOf(C25738R.string.c_t));
                c897927.map.put("masssendapp", Integer.valueOf(C25738R.string.cac));
                c897927.map.put("meishiapp", Integer.valueOf(C25738R.string.cai));
                c897927.map.put("feedsapp", Integer.valueOf(C25738R.string.c_w));
                c897927.map.put("voipapp", Integer.valueOf(C25738R.string.cbe));
                c897927.map.put("weixin", Integer.valueOf(C25738R.string.da5));
                c897927.map.put("filehelper", Integer.valueOf(C25738R.string.c_g));
                c897927.map.put("cardpackage", Integer.valueOf(C25738R.string.c_n));
                c897927.map.put("officialaccounts", Integer.valueOf(C25738R.string.cam));
                c897927.map.put("voicevoipapp", Integer.valueOf(C25738R.string.cbh));
                c897927.map.put("helper_entry", Integer.valueOf(C25738R.string.ca4));
                c897927.map.put("voiceinputapp", Integer.valueOf(C25738R.string.cbb));
                c897927.map.put("linkedinplugin", Integer.valueOf(C25738R.string.ca_));
                c897927.map.put("notifymessage", Integer.valueOf(C25738R.string.caj));
                c897927.map.put("gh_43f2581f6fd6", Integer.valueOf(C25738R.string.cb8));
                c897927.map.put("appbrandcustomerservicemsg", Integer.valueOf(C25738R.string.c_h));
                c897927.cgf.put("weixin", Integer.valueOf(C25738R.string.da4));
                C7486a.m12941a(c897927);
                C5227ai.m7970a(new C89751());
                if (!C1445f.m3070Mn()) {
                    C7060h.pYm.mo8378a(340, C1443d.m3068iW(19) ? 5 : 6, 1, false);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(C1443d.m3068iW(19) ? ReaderCallback.HIDDEN_BAR : ReaderCallback.SHOW_BAR);
                    objArr2[1] = String.format("%s;%s;%s", new Object[]{C6457e.eSl, Environment.getExternalStorageDirectory().getAbsolutePath(), C1448h.getExternalStorageDirectory().getAbsolutePath()});
                    c7060h.mo8381e(11098, objArr2);
                }
                C4990ab.m7417i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.cfN), Integer.valueOf(C5059g.cdf), Integer.valueOf(C7243d.vxo), C5046bo.m7562gW(C4996ah.getContext()));
                AppMethodBeat.m2505o(15548);
            }
            C4990ab.m7416i("MicroMsg.WorkerProfile", "apk external info not null");
            if (c32429a.cdc.cdf != 0) {
                C5059g.cdf = c32429a.cdc.cdf;
                C4990ab.m7416i("MicroMsg.WorkerProfile", "read channelId from apk external");
            }
            if (c32429a.cdc.cdh != 0) {
                C5059g.cdh = c32429a.cdc.cdh;
                C4990ab.m7417i("MicroMsg.WorkerProfile", "ext.updateMode = %s", Integer.valueOf(C5059g.cdh));
            }
            if (c32429a.cdc.cdi != null) {
                C5059g.xyb = C5046bo.getInt(c32429a.cdc.cdi, 0);
            }
            if (c32429a.cdc.cdj != null) {
                C5059g.xyc = c32429a.cdc.cdj;
            }
            if (c32429a.cdc.cdg != null) {
                C5059g.cdg = c32429a.cdc.cdg;
            }
            if (c32429a.cdc.cdm) {
                C5059g.xyg = c32429a.cdc.cdm;
                C4990ab.m7417i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", Boolean.valueOf(C5059g.xyg));
            }
            if (c32429a.cdc.cdl != 0) {
                C5059g.cdl = c32429a.cdc.cdl;
                C4990ab.m7417i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", Integer.valueOf(C5059g.cdl));
            }
            if (c32429a.cdc.cdk) {
                C5059g.xyf = c32429a.cdc.cdk;
                C4990ab.m7417i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", Boolean.valueOf(C5059g.xyf));
            }
            C1245d.m2681Ba();
            bo = C1326d.m2839bo(this.app);
            C5059g.cdf = bo.ebO;
            applicationContext = this.app.getApplicationContext();
            i = C5059g.cdf;
            i2 = C7243d.vxo;
            sharedPreferences = applicationContext.getSharedPreferences("crash_status_file", 4);
            i3 = sharedPreferences.getInt("channel", -1);
            i4 = sharedPreferences.getInt("version", 0);
            edit = sharedPreferences.edit();
            edit.putInt("channel", i);
            edit.putInt("version", i2);
            edit.commit();
            if (C5059g.xyb > 0) {
            }
            C25985d.dlL();
            if (C5046bo.isNullOrNil(C5059g.cdg)) {
            }
            C7243d.eSg = "android-" + (C5046bo.isNullOrNil(C5059g.cdg) ? Integer.valueOf(VERSION.SDK_INT) : C5059g.cdg);
            if (C5046bo.isNullOrNil(C4872b.dnP())) {
            }
            C4990ab.m7419v("MicroMsg.WorkerProfile", "set device type :%s  %s", C7243d.eSg, C4872b.dnP());
            this.locale = MMActivity.initLanguage(this.app.getBaseContext());
            if (C4872b.dnO()) {
            }
            C4879a.xxA.mo10052c(this.cfH);
            c45154c = new C45154c();
            C4990ab.m7410d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(c45154c)));
            C40460b.pqK = c45154c;
            C40423e.vdx = new C897026();
            C1720g.m3543a(C41736i.class, new C6625e(this.cfW));
            C1720g.m3543a(C46490h.class, new C6625e(this.cfW));
            C1720g.m3543a(C44055j.class, new C6625e(this.cfW));
            C1720g.m3542a(C20022a.class, new C38673d());
            C1720g.m3542a(C46500q.class, new C1263d());
            C1720g.m3542a(C32464b.class, new C23707a());
            C4879a.xxA.mo10052c(new C6318a());
            if (this.cfJ == null) {
            }
            this.cfU = new C42127b();
            c42127b = this.cfU;
            C4990ab.m7416i("MicroMsg.BroadcastController", "summerdiz init");
            C4879a.xxA.mo10052c(c42127b.eeX);
            C4879a.xxA.mo10052c(new C17432());
            C4879a.xxA.mo10052c(new C18815e());
            C4879a.xxA.mo10052c(new C897130());
            C4879a.xxA.mo10052c(new C896431());
            C4879a.xxA.mo10052c(new C899332());
            C4879a.xxA.mo10052c(new C898233());
            C4879a.xxA.mo10052c(new C898834());
            C4879a.xxA.mo10052c(new C898935());
            C4879a.xxA.mo10052c(new C89812());
            C4879a.xxA.mo10052c(new C89953());
            C4879a.xxA.mo10052c(new C89834());
            C4879a.xxA.mo10052c(new C89725());
            C4879a.xxA.mo10052c(new C89606());
            C4879a.xxA.mo10052c(new C89737());
            C4879a.xxA.mo10052c(new C89748());
            C4879a.xxA.mo10052c(new C89619());
            C4879a.xxA.mo10052c(new C896510());
            C4879a.xxA.mo10052c(new C895911());
            C4879a.xxA.mo10052c(new C897613());
            C4879a.xxA.mo10052c(new C897714());
            C4879a.xxA.mo10052c(new C899015());
            C4879a.xxA.mo10052c(new C897816());
            C4879a.xxA.mo10052c(new C899117());
            C4879a.xxA.mo10052c(new C631518());
            C4879a.xxA.mo10052c(new C631619());
            C4879a.xxA.mo10052c(new C898420());
            C4879a.xxA.mo10052c(new C898621());
            C4879a.xxA.mo10052c(new C898722());
            C4879a.xxA.mo10052c(new C9004m(2, 12));
            C4879a.xxA.mo10052c(new C896824());
            C12519g.opT = new C44387d();
            C23257a.vax = new C32261a();
            C4758a.vrC = C1265e.m2715Cl();
            if (C9638aw.m17178QT()) {
            }
            C4879a.xxA.mo10055m(new C37700ck());
            this.cfM = true;
            Log.setLogImpl(new C896325());
            C4990ab.m7410d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
            applicationContext = C4996ah.getContext();
            c897927 = /* anonymous class already generated */;
            c897927.map.put("qqmail", Integer.valueOf(C25738R.string.cat));
            c897927.map.put("fmessage", Integer.valueOf(C25738R.string.c_z));
            c897927.map.put("floatbottle", Integer.valueOf(C25738R.string.c_k));
            c897927.map.put("lbsapp", Integer.valueOf(C25738R.string.ca7));
            c897927.map.put("shakeapp", Integer.valueOf(C25738R.string.cb5));
            c897927.map.put("medianote", Integer.valueOf(C25738R.string.caf));
            c897927.map.put("qqfriend", Integer.valueOf(C25738R.string.caq));
            c897927.map.put("newsapp", Integer.valueOf(C25738R.string.cb1));
            c897927.map.put("facebookapp", Integer.valueOf(C25738R.string.c_t));
            c897927.map.put("masssendapp", Integer.valueOf(C25738R.string.cac));
            c897927.map.put("meishiapp", Integer.valueOf(C25738R.string.cai));
            c897927.map.put("feedsapp", Integer.valueOf(C25738R.string.c_w));
            c897927.map.put("voipapp", Integer.valueOf(C25738R.string.cbe));
            c897927.map.put("weixin", Integer.valueOf(C25738R.string.da5));
            c897927.map.put("filehelper", Integer.valueOf(C25738R.string.c_g));
            c897927.map.put("cardpackage", Integer.valueOf(C25738R.string.c_n));
            c897927.map.put("officialaccounts", Integer.valueOf(C25738R.string.cam));
            c897927.map.put("voicevoipapp", Integer.valueOf(C25738R.string.cbh));
            c897927.map.put("helper_entry", Integer.valueOf(C25738R.string.ca4));
            c897927.map.put("voiceinputapp", Integer.valueOf(C25738R.string.cbb));
            c897927.map.put("linkedinplugin", Integer.valueOf(C25738R.string.ca_));
            c897927.map.put("notifymessage", Integer.valueOf(C25738R.string.caj));
            c897927.map.put("gh_43f2581f6fd6", Integer.valueOf(C25738R.string.cb8));
            c897927.map.put("appbrandcustomerservicemsg", Integer.valueOf(C25738R.string.c_h));
            c897927.cgf.put("weixin", Integer.valueOf(C25738R.string.da4));
            C7486a.m12941a(c897927);
            C5227ai.m7970a(new C89751());
            if (C1445f.m3070Mn()) {
            }
            C4990ab.m7417i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.cfN), Integer.valueOf(C5059g.cdf), Integer.valueOf(C7243d.vxo), C5046bo.m7562gW(C4996ah.getContext()));
            AppMethodBeat.m2505o(15548);
        } catch (NameNotFoundException e22) {
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", e3.getMessage());
        }
    }

    public final void onTerminate() {
        AppMethodBeat.m2504i(15549);
        super.onTerminate();
        C42127b c42127b = this.cfU;
        C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", c42127b.eeU, Integer.valueOf(c42127b.eeW.size()));
        C4879a.xxA.mo10053d(c42127b.eeX);
        c42127b.eeU = null;
        c42127b.eeV.clear();
        c42127b.eeW.clear();
        this.cfU = null;
        AppMethodBeat.m2505o(15549);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(15550);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        C4996ah.getContext();
        if ("language_default".equals(C4988aa.m7405h(sharedPreferences))) {
            C4990ab.m7417i("MicroMsg.WorkerProfile", "config locale %s", C4988aa.m7400c(configuration.locale));
            Locale bM = MMActivity.m13632bM(this.app.getBaseContext(), C4988aa.m7400c(configuration.locale));
            C4990ab.m7417i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", this.locale, bM);
            if (!(bM == null || this.locale == null || bM.equals(this.locale))) {
                if (C9638aw.m17179RK()) {
                    try {
                        C1902e c1902e = C9638aw.m17182Rg().ftA;
                        if (c1902e != null) {
                            C1898c adg = c1902e.adg();
                            if (adg != null) {
                                byte[] bArr = new byte[0];
                                byte[] bArr2 = new byte[0];
                                byte[] bArr3 = new byte[0];
                                C9638aw.m17190ZK();
                                adg.mo5482a(bArr, bArr2, bArr3, C18628c.m29064QF());
                            }
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                        C4990ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "what the f$!k", new Object[0]);
                    }
                }
                C4990ab.m7420w("MicroMsg.WorkerProfile", "language changed, restart process");
                C45273a.m83446jB(C4996ah.getContext());
                System.exit(-1);
            }
        }
        AppMethodBeat.m2505o(15550);
    }

    public final String toString() {
        return ceo;
    }

    public final C24672an getNotification() {
        AppMethodBeat.m2504i(15551);
        if (this.cfJ == null) {
            this.cfJ = new C44682b(this.app);
        }
        C24672an c24672an = this.cfJ;
        AppMethodBeat.m2505o(15551);
        return c24672an;
    }

    /* renamed from: Cb */
    public final C5133b mo20414Cb() {
        AppMethodBeat.m2504i(15552);
        if (this.cfK == null) {
            this.cfK = new C899228();
        }
        C5133b c5133b = this.cfK;
        AppMethodBeat.m2505o(15552);
        return c5133b;
    }

    /* renamed from: Cc */
    public final C9634ae mo20415Cc() {
        AppMethodBeat.m2504i(15553);
        if (this.cfL == null) {
            this.cfL = C1321a.m2829Ib();
        }
        C9634ae c9634ae = this.cfL;
        AppMethodBeat.m2505o(15553);
        return c9634ae;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(15554);
        C4990ab.m7417i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 3 && i2 == -1) {
            C4990ab.m7417i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", C5046bo.dpG(), Long.valueOf(Thread.currentThread().getId()));
        }
        Intent intent;
        if (i == 4 && i2 == -3002) {
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
                AppMethodBeat.m2505o(15554);
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            C4990ab.m7417i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", str);
            C6459ak c6459ak = new C6459ak();
            c6459ak.cto.type = 4;
            c6459ak.cto.ctq = str;
            C4879a.xxA.mo10055m(c6459ak);
            AppMethodBeat.m2505o(15554);
        } else if (!C9638aw.m17179RK() || i != 4 || ((i2 != -6 && i2 != -310 && i2 != -311) || str == null || !str.startsWith("autoauth_errmsg_"))) {
            if (c1207m.getType() == 701 || c1207m.getType() == 702 || c1207m.getType() == 126 || c1207m.getType() == 252 || c1207m.getType() == 763 || c1207m.getType() == 138) {
                C26171jl c26171jl;
                if (i == 4 && i2 == -213) {
                    c26171jl = new C26171jl();
                    c26171jl.cEK.status = 0;
                    c26171jl.cEK.boZ = 3;
                    C4879a.xxA.mo10055m(c26171jl);
                    if (AccountDeletedAlphaAlertUI.dJp() != null) {
                        AppMethodBeat.m2505o(15554);
                        return;
                    }
                    intent = new Intent();
                    intent.setClass(C4996ah.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
                    intent.putExtra("errmsg", str);
                    C4996ah.getContext().startActivity(intent);
                    AppMethodBeat.m2505o(15554);
                    return;
                } else if (i == 4 && i2 == -100) {
                    c26171jl = new C26171jl();
                    c26171jl.cEK.status = 0;
                    c26171jl.cEK.boZ = 1;
                    C4879a.xxA.mo10055m(c26171jl);
                }
            }
            AppMethodBeat.m2505o(15554);
        } else if (NewTaskUI.dJR() != null) {
            AppMethodBeat.m2505o(15554);
        } else {
            intent = new Intent();
            intent.setClass(C4996ah.getContext(), NewTaskUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(15554);
        }
    }

    public final void onReportKVDataReady(byte[] bArr, final byte[] bArr2, final int i) {
        AppMethodBeat.m2504i(15555);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(138602);
                if (C9638aw.m17183ZD()) {
                    AppMethodBeat.m2505o(138602);
                    return;
                }
                C4990ab.m7416i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + i);
                C9638aw.m17182Rg().mo14541a(new C7046e(bArr2, i), 0);
                AppMethodBeat.m2505o(138602);
            }
        });
        AppMethodBeat.m2505o(15555);
    }

    /* renamed from: dm */
    public final void mo4492dm(String str) {
        AppMethodBeat.m2504i(15556);
        C4990ab.m7417i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", str);
        C6459ak c6459ak = new C6459ak();
        c6459ak.cto.type = 4;
        c6459ak.cto.ctq = str;
        C4879a.xxA.mo10055m(c6459ak);
        AppMethodBeat.m2505o(15556);
    }

    /* renamed from: dn */
    public final void mo20416dn(String str) {
        AppMethodBeat.m2504i(15557);
        C4990ab.m7417i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", str);
        C6459ak c6459ak = new C6459ak();
        c6459ak.cto.type = 1;
        c6459ak.cto.ctq = str;
        C4879a.xxA.mo10055m(c6459ak);
        AppMethodBeat.m2505o(15557);
    }
}
