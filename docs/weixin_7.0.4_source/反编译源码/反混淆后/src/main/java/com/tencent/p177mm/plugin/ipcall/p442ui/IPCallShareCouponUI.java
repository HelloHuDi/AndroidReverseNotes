package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32574ir;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C46032c;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C3307i;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C46034b;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34373g;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C43223b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.aqq;
import com.tencent.p177mm.protocal.protobuf.crw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI */
public class IPCallShareCouponUI extends MMActivity implements C1202f {
    private String eeO = null;
    private String mTitle = null;
    private C4884c nBm = new C69541();
    private ProgressDialog nBv;
    private String nEP = null;
    private String nEQ = null;
    private String nER = null;
    private String nES = null;
    private String nET = null;
    private String nEU = null;
    private String nEV = null;
    private String nEW = null;
    private ImageView nFA;
    private TextView nFB;
    private TextView nFC;
    private View nFD;
    private IPCallDynamicTextView nFE;
    private C46034b nFF = new C46034b();
    private LinkedList<crw> nFG = null;
    private boolean nFH = false;
    private RelativeLayout nFk;
    private TextView nFl;
    private ImageView nFm;
    private RelativeLayout nFn;
    private TextView nFo;
    private ImageView nFp;
    private LinearLayout nFq;
    private LinearLayout nFr;
    private LinearLayout nFs;
    private LinearLayout nFt;
    private ImageView nFu;
    private LinearLayout nFv;
    private ImageView nFw;
    private TextView nFx;
    private TextView nFy;
    private TextView nFz;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$6 */
    class C33186 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$6$1 */
        class C33191 implements C30391c {
            C33191() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(22323);
                if (!IPCallShareCouponUI.this.nFH) {
                    i++;
                }
                switch (i) {
                    case 0:
                        IPCallShareCouponUI.m20236i(IPCallShareCouponUI.this);
                        AppMethodBeat.m2505o(22323);
                        return;
                    case 1:
                        IPCallShareCouponUI.m20231d(IPCallShareCouponUI.this);
                        AppMethodBeat.m2505o(22323);
                        return;
                    case 2:
                        IPCallShareCouponUI.m20232e(IPCallShareCouponUI.this);
                        break;
                }
                AppMethodBeat.m2505o(22323);
            }
        }

        C33186() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onMenuItemClick(MenuItem menuItem) {
            int i;
            String[] strArr;
            AppMethodBeat.m2504i(22324);
            aqq bIU = C34382c.bIU();
            if (!(bIU == null || C5046bo.isNullOrNil(bIU.wuD))) {
                if ((C26373g.m41964Nu().getInt("WCOWebPayListSwitch", 0) > 0 ? 1 : 0) != 0) {
                    i = 1;
                    if (i == 0) {
                        strArr = new String[]{IPCallShareCouponUI.this.getString(C25738R.string.cic), IPCallShareCouponUI.this.getString(C25738R.string.cgt), IPCallShareCouponUI.this.getString(C25738R.string.cg9)};
                        IPCallShareCouponUI.this.nFH = true;
                    } else {
                        strArr = new String[]{IPCallShareCouponUI.this.getString(C25738R.string.cgt), IPCallShareCouponUI.this.getString(C25738R.string.cg9)};
                        IPCallShareCouponUI.this.nFH = false;
                    }
                    C30379h.m48424a(IPCallShareCouponUI.this.mController.ylL, null, strArr, null, false, new C33191());
                    AppMethodBeat.m2505o(22324);
                    return true;
                }
            }
            i = 0;
            if (i == 0) {
            }
            C30379h.m48424a(IPCallShareCouponUI.this.mController.ylL, null, strArr, null, false, new C33191());
            AppMethodBeat.m2505o(22324);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$8 */
    class C33208 implements OnMenuItemClickListener {
        C33208() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22326);
            IPCallShareCouponUI.this.finish();
            AppMethodBeat.m2505o(22326);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$9 */
    class C33219 implements OnClickListener {
        C33219() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22327);
            IPCallShareCouponUI.m20231d(IPCallShareCouponUI.this);
            AppMethodBeat.m2505o(22327);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$1 */
    class C69541 extends C4884c<C32574ir> {

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$1$1 */
        class C69551 implements Runnable {
            C69551() {
            }

            public final void run() {
                AppMethodBeat.m2504i(22315);
                C9638aw.m17190ZK();
                if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    IPCallShareCouponUI.this.nFm.setVisibility(0);
                } else {
                    IPCallShareCouponUI.this.nFm.setVisibility(8);
                }
                C9638aw.m17190ZK();
                IPCallShareCouponUI.this.nFl.setText((String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_RECHARGE_STRING, (Object) ""));
                C9638aw.m17190ZK();
                IPCallShareCouponUI.this.nFo.setText((String) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, (Object) ""));
                AppMethodBeat.m2505o(22315);
            }
        }

        C69541() {
            AppMethodBeat.m2504i(22316);
            this.xxI = C32574ir.class.getName().hashCode();
            AppMethodBeat.m2505o(22316);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(22317);
            C5004al.m7441d(new C69551());
            AppMethodBeat.m2505o(22317);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$11 */
    class C1229711 implements OnClickListener {
        C1229711() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22329);
            IPCallShareCouponUI.m20233f(IPCallShareCouponUI.this);
            AppMethodBeat.m2505o(22329);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$10 */
    class C1229810 implements OnClickListener {
        C1229810() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22328);
            IPCallShareCouponUI.m20232e(IPCallShareCouponUI.this);
            AppMethodBeat.m2505o(22328);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$7 */
    class C122997 implements DialogInterface.OnClickListener {
        C122997() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22325);
            IPCallShareCouponUI.this.finish();
            AppMethodBeat.m2505o(22325);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$12 */
    class C1230012 implements OnClickListener {
        C1230012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22330);
            C7060h.pYm.mo8381e(13340, Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
            Intent intent = new Intent();
            intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallShareCouponCardUI.class);
            IPCallShareCouponUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(22330);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$2 */
    class C123012 implements OnClickListener {
        C123012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22318);
            Intent intent = new Intent();
            intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallPackageUI.class);
            IPCallShareCouponUI.this.startActivity(intent);
            AppMethodBeat.m2505o(22318);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$3 */
    class C123023 implements OnClickListener {
        C123023() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22319);
            Intent intent = new Intent();
            String str = IPCallShareCouponUI.this.getString(C25738R.string.chm) + "&usedcc=";
            List bHf = C46032c.bHc().bHf();
            if (bHf == null || bHf.size() <= 0) {
                str = str + C46041a.m85632Pr(C34382c.bIR());
            } else {
                int size = bHf.size();
                if (size > 5) {
                    size = 5;
                }
                int i = 0;
                while (i < size) {
                    String Pr = C46041a.m85632Pr(((Integer) bHf.get(i)).toString());
                    if (C5046bo.isNullOrNil(Pr)) {
                        Pr = str;
                    } else {
                        Pr = str + Pr + "|";
                    }
                    i++;
                    str = Pr;
                }
                if (str.endsWith("|")) {
                    str = str.substring(0, str.length() - 1);
                }
            }
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            C25985d.m41467b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(22319);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$4 */
    class C123034 implements OnCancelListener {
        C123034() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22320);
            try {
                IPCallShareCouponUI.this.finish();
                AppMethodBeat.m2505o(22320);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", e.getMessage());
                AppMethodBeat.m2505o(22320);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$5 */
    class C123045 extends ClickableSpan {
        C123045() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22321);
            ((TextView) view).setHighlightColor(IPCallShareCouponUI.this.getResources().getColor(C25738R.color.a3p));
            String str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
            String gw = C4988aa.m7403gw(C4996ah.getContext());
            if (!C5046bo.isNullOrNil(gw)) {
                str = str + "&wechat_real_lang=" + gw;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            C25985d.m41467b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(22321);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(22322);
            textPaint.setColor(IPCallShareCouponUI.this.getResources().getColor(C25738R.color.f12123t7));
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(22322);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$15 */
    class C1230515 implements OnClickListener {
        C1230515() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22333);
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                C3307i.m5626Z(3, -1, -1);
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
            IPCallShareCouponUI.this.nFm.setVisibility(8);
            Intent intent = new Intent();
            intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallRechargeUI.class);
            IPCallShareCouponUI.this.startActivity(intent);
            AppMethodBeat.m2505o(22333);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$13 */
    class C1230613 implements OnClickListener {
        C1230613() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22331);
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                C9638aw.m17190ZK();
                C3307i.m5626Z(4, -1, ((Integer) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1))).intValue());
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
            IPCallShareCouponUI.this.nFu.setVisibility(8);
            Intent intent = new Intent();
            intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallMsgUI.class);
            IPCallShareCouponUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(22331);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI$14 */
    class C1230714 implements OnClickListener {
        C1230714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22332);
            Intent intent = new Intent();
            intent.setClass(IPCallShareCouponUI.this.mController.ylL, IPCallMyGiftCardUI.class);
            IPCallShareCouponUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(22332);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallShareCouponUI() {
        AppMethodBeat.m2504i(22334);
        AppMethodBeat.m2505o(22334);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(22335);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_TOKYO, (C1202f) this);
        C4879a.xxA.mo10052c(this.nBm);
        setMMTitle((int) C25738R.string.cid);
        setBackBtn(new C33208());
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C33186());
        this.nFE = (IPCallDynamicTextView) findViewById(2131825050);
        this.nFk = (RelativeLayout) findViewById(2131825055);
        this.nFl = (TextView) findViewById(2131825056);
        this.nFm = (ImageView) findViewById(2131825057);
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.nFm.setVisibility(0);
        }
        C9638aw.m17190ZK();
        this.nFl.setText((String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_RECHARGE_STRING, (Object) ""));
        this.nFn = (RelativeLayout) findViewById(2131825058);
        this.nFo = (TextView) findViewById(2131825059);
        this.nFp = (ImageView) findViewById(2131825060);
        C9638aw.m17190ZK();
        this.nFo.setText((String) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, (Object) ""));
        this.nFB = (TextView) findViewById(2131825051);
        this.nFC = (TextView) findViewById(2131825053);
        this.nFD = findViewById(2131825052);
        this.nFq = (LinearLayout) findViewById(2131825069);
        this.nFA = (ImageView) findViewById(2131825070);
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.nFA.setVisibility(0);
        }
        this.nFx = (TextView) findViewById(2131825074);
        this.nFy = (TextView) findViewById(2131825075);
        this.nFz = (TextView) findViewById(2131825073);
        this.nFr = (LinearLayout) findViewById(2131825062);
        this.nFs = (LinearLayout) findViewById(2131825064);
        this.nFv = (LinearLayout) findViewById(2131825071);
        this.nFw = (ImageView) findViewById(2131825072);
        this.nFt = (LinearLayout) findViewById(2131825067);
        this.nFu = (ImageView) findViewById(2131825068);
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.nFu.setVisibility(0);
        }
        if (C34382c.bIT()) {
            z = true;
        } else {
            if (C26373g.m41964Nu().getInt("WCOPurchaseSwitch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.nFk.setVisibility(8);
        }
        if (C34382c.bIT() || C26373g.m41964Nu().getInt("WCOPackagePurchaseSwitch", 0) == 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.nFn.setVisibility(0);
        }
        if (C26373g.m41964Nu().getInt("WCOAccountDetailSwitch", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.nFq.setVisibility(8);
        }
        if (C34382c.bIT()) {
            z = true;
        } else {
            if (C26373g.m41964Nu().getInt("WCOInviteFriend", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.nFr.setVisibility(8);
        }
        this.nFx.setOnClickListener(new C33219());
        this.nFy.setOnClickListener(new C1229810());
        this.nFq.setOnClickListener(new C1229711());
        this.nFr.setOnClickListener(new C1230012());
        this.nFt.setOnClickListener(new C1230613());
        this.nFs.setOnClickListener(new C1230714());
        this.nFk.setOnClickListener(new C1230515());
        this.nFn.setOnClickListener(new C123012());
        this.nFv.setOnClickListener(new C123023());
        aqq bIU = C34382c.bIU();
        if (bIU != null) {
            m20227a(bIU);
            refreshView();
        } else {
            this.nFE.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.nBv = C30379h.m48458b(context, getString(C25738R.string.ch0), true, new C123034());
        }
        if (C34382c.bIT()) {
            String string = getString(C25738R.string.cjw);
            String str = string + getString(C25738R.string.cjv);
            C123045 c123045 = new C123045();
            Spannable newSpannable = Factory.getInstance().newSpannable(str);
            int length = string.length();
            int length2 = newSpannable.length();
            if (length < 0 || length >= length2 || length2 < 0 || length2 > newSpannable.length()) {
                newSpannable.setSpan(c123045, 0, newSpannable.length(), 33);
            } else {
                newSpannable.setSpan(c123045, length, length2, 33);
            }
            this.nFz.setText(newSpannable);
            this.nFz.setMovementMethod(LinkMovementMethod.getInstance());
            this.nFz.setVisibility(0);
        } else {
            this.nFz.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(2131825054);
        if (linearLayout != null && this.nFk.getVisibility() == 8 && this.nFn.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        linearLayout = (LinearLayout) findViewById(2131825061);
        if (linearLayout != null && this.nFr.getVisibility() == 8 && this.nFs.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        this.nFF.start();
        AppMethodBeat.m2505o(22335);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22336);
        super.onResume();
        C43223b.bHU().mo68730it(false);
        AppMethodBeat.m2505o(22336);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22337);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_TOKYO, (C1202f) this);
        C4879a.xxA.mo10053d(this.nBm);
        this.nFF.nyL = C5046bo.anU();
        this.nFF.finish();
        AppMethodBeat.m2505o(22337);
    }

    public final int getLayoutId() {
        return 2130969887;
    }

    private void refreshView() {
        AppMethodBeat.m2504i(22338);
        if (!C5046bo.isNullOrNil(this.nEU)) {
            if (this.nET == null) {
                this.nFE.setValue(this.nEU, this.nEU);
            } else {
                this.nFE.setValue(this.nET, this.nEU);
            }
            this.nET = this.nEU;
        }
        this.nFB.getText();
        this.nFB.setText(this.nEV);
        if (C5046bo.isNullOrNil(this.nEV)) {
            this.nFB.setVisibility(8);
        } else {
            this.nFB.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.nFG != null && this.nFG.size() > 0) {
            Iterator it = this.nFG.iterator();
            while (it.hasNext()) {
                crw crw = (crw) it.next();
                if (!(crw == null || C5046bo.isNullOrNil(crw.xpw))) {
                    stringBuffer.append(crw.xpw).append(10);
                }
            }
        }
        if (C5046bo.isNullOrNil(stringBuffer.toString())) {
            this.nFC.setText("");
            this.nFC.setVisibility(8);
        } else {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == 10) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.nFC.setText(stringBuffer.toString());
            this.nFC.setVisibility(0);
        }
        if (this.nFB.getVisibility() == 0 && this.nFC.getVisibility() == 0) {
            this.nFD.setVisibility(0);
            AppMethodBeat.m2505o(22338);
            return;
        }
        this.nFD.setVisibility(8);
        AppMethodBeat.m2505o(22338);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22339);
        if (c1207m instanceof C34373g) {
            if (i == 0 && i2 == 0) {
                m20227a(((C34373g) c1207m).nyt);
                refreshView();
                if (this.nBv != null && this.nBv.isShowing()) {
                    this.nBv.dismiss();
                }
                AppMethodBeat.m2505o(22339);
                return;
            } else if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
                C30379h.m48438a(this.mController.ylL, getString(C25738R.string.cgy), getString(C25738R.string.cgr), new C122997());
            }
        }
        AppMethodBeat.m2505o(22339);
    }

    /* renamed from: a */
    private void m20227a(aqq aqq) {
        this.nEP = aqq.wut;
        this.eeO = aqq.Desc;
        this.nEQ = aqq.wuu;
        this.mTitle = aqq.Title;
        this.nER = aqq.nzz;
        this.nES = aqq.wuv;
        this.nEU = aqq.wuw;
        this.nEV = aqq.wux;
        this.nEW = aqq.wuy;
        this.nFG = aqq.wuh;
    }

    /* renamed from: d */
    static /* synthetic */ void m20231d(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.m2504i(22340);
        C46034b c46034b = iPCallShareCouponUI.nFF;
        c46034b.nyN++;
        C7060h.pYm.mo8378a(257, 2, 1, true);
        String string = C4996ah.getContext().getString(C25738R.string.ch4);
        try {
            C1720g.m3534RN();
            int QF = C1668a.m3383QF();
            String encode = URLEncoder.encode(C7243d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(C5046bo.dpA(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(C1427q.m3026LK(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(C7243d.vxi, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(C7243d.vxj, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(C7243d.vxk, ProtocolPackage.ServerEncoding);
            String encode7 = URLEncoder.encode(C9638aw.m17181Rb(), ProtocolPackage.ServerEncoding);
            string = string + "&version=" + C7243d.vxo + "&lang=" + C4988aa.m7403gw(C4996ah.getContext()) + ("&uin=" + QF + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(C5046bo.m7557gS(C4996ah.getContext()), ProtocolPackage.ServerEncoding) + "&scene=0");
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7413e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", e.getMessage());
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        C25985d.m41467b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(22340);
    }

    /* renamed from: e */
    static /* synthetic */ void m20232e(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.m2504i(22341);
        C46034b c46034b = iPCallShareCouponUI.nFF;
        c46034b.nyO++;
        C7060h.pYm.mo8378a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(C25738R.string.cg_));
        intent.putExtra("showShare", false);
        C25985d.m41467b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(22341);
    }

    /* renamed from: f */
    static /* synthetic */ void m20233f(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.m2504i(22342);
        C46034b c46034b = iPCallShareCouponUI.nFF;
        c46034b.nyM++;
        C7060h.pYm.mo8378a(257, 1, 1, true);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
        iPCallShareCouponUI.nFA.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(C25738R.string.cgp));
        intent.putExtra("showShare", false);
        C25985d.m41467b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(22342);
    }

    /* renamed from: i */
    static /* synthetic */ void m20236i(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.m2504i(22343);
        aqq bIU = C34382c.bIU();
        if (!(bIU == null || C5046bo.isNullOrNil(bIU.wuD))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", bIU.wuD);
            intent.putExtra("showShare", false);
            C25985d.m41467b((Context) iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(22343);
    }
}
