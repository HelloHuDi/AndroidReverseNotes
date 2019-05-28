package com.tencent.p177mm.plugin.account.p275ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.p069v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p1573q.C40600a;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.p612ui.base.MMFormVerifyCodeInputView;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.platformtools.C45475ag;
import com.tencent.p177mm.platformtools.C45476c;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.p275ui.C10004g.C10008a;
import com.tencent.p177mm.plugin.account.p275ui.C38082e.C380801;
import com.tencent.p177mm.plugin.account.p275ui.C38082e.C380812;
import com.tencent.p177mm.plugin.account.p275ui.ResizeLayout.C33029a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import java.util.ArrayList;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI */
public class LoginHistoryUI extends MMActivity implements C1202f {
    private String cOG = "";
    protected ProgressDialog ehJ = null;
    private SharedPreferences ehZ;
    private C4884c gAY = new C188821();
    protected TextView gBI;
    protected EditText gBJ;
    protected Button gBK;
    protected Button gBL;
    protected View gBM;
    protected View gBN;
    protected View gBO;
    protected Button gBP;
    protected Button gBQ;
    private View gBR;
    protected Button gBS;
    protected C31280f gBT = new C31280f();
    protected String gBU;
    protected String gBV;
    private String gBW;
    private String gBX;
    private ImageView gBY;
    private MMKeyboardUperView gBZ;
    private ResizeLayout gCa;
    protected String gCb;
    private String gCc;
    private C45476c gCd;
    protected LinearLayout gCe;
    protected LinearLayout gCf;
    protected LinearLayout gCg;
    protected MMFormInputView gCh;
    protected MMFormVerifyCodeInputView gCi;
    private Button gCj;
    protected String gCk = "";
    protected boolean gCl = false;
    protected boolean gCm;
    private int gCn;
    private int gCo;
    private boolean gCp = false;
    private String gCq;
    protected int[] gCr = new int[5];
    private int gCs;
    private String gCt;
    private int gCu = 0;
    private SecurityImage gue = null;
    protected int gwX;
    protected String gzO;

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$16 */
    class C992716 implements OnDismissListener {
        C992716() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(124926);
            LoginHistoryUI.this.gue = null;
            AppMethodBeat.m2505o(124926);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$17 */
    class C992817 implements OnClickListener {
        C992817() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$18 */
    class C992918 implements OnCancelListener {
        C992918() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$11 */
    class C1888111 implements OnClickListener {
        C1888111() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124922);
            LoginHistoryUI.m53935g(LoginHistoryUI.this);
            AppMethodBeat.m2505o(124922);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$1 */
    class C188821 extends C4884c<C37745jk> {
        C188821() {
            AppMethodBeat.m2504i(124913);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(124913);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124914);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(124914);
                return false;
            }
            C4990ab.m7417i("MicroMsg.LoginHistoryUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(124914);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$22 */
    class C1888322 implements OnClickListener {
        C1888322() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124929);
            C4990ab.m7416i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
            LoginHistoryUI.m53927a(LoginHistoryUI.this);
            AppMethodBeat.m2505o(124929);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$2 */
    class C188862 implements C5279d {
        C188862() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(124915);
            switch (menuItem.getItemId()) {
                case 7002:
                    LoginHistoryUI.m53932d(LoginHistoryUI.this);
                    AppMethodBeat.m2505o(124915);
                    return;
                case 7003:
                    LoginHistoryUI.m53933e(LoginHistoryUI.this);
                    AppMethodBeat.m2505o(124915);
                    return;
                case 7004:
                    LoginHistoryUI.m53934f(LoginHistoryUI.this);
                    AppMethodBeat.m2505o(124915);
                    return;
                case 7009:
                    LoginHistoryUI.m53926R(LoginHistoryUI.this, LoginHistoryUI.this.getString(C25738R.string.gb3) + C4988aa.dor());
                    break;
            }
            AppMethodBeat.m2505o(124915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$3 */
    class C188873 implements C15994a {
        C188873() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$5 */
    class C188895 implements View.OnClickListener {
        C188895() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124917);
            LoginHistoryUI.m53926R(LoginHistoryUI.this, LoginHistoryUI.this.getString(C25738R.string.gb3) + C4988aa.dor());
            AppMethodBeat.m2505o(124917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$21 */
    class C2661821 implements C15994a {
        C2661821() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$12 */
    class C3298812 implements OnClickListener {
        C3298812() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124923);
            LoginHistoryUI.this.gCu = LoginHistoryUI.this.gCu + 1;
            AppMethodBeat.m2505o(124923);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$14 */
    class C3298914 implements OnClickListener {
        C3298914() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$31 */
    class C3299031 implements C36073c {
        C3299031() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(124939);
            if (c44273l.size() == 0) {
                c44273l.mo70072hi(7002, C25738R.string.coa);
                c44273l.mo70072hi(7003, C25738R.string.cdz);
                c44273l.mo70072hi(7004, C25738R.string.g0m);
                if (!C4988aa.doo()) {
                    c44273l.mo70072hi(7009, C25738R.string.g0k);
                }
            }
            AppMethodBeat.m2505o(124939);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$20 */
    class C3299220 implements C5279d {
        C3299220() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(124928);
            LoginHistoryUI.m53928a(LoginHistoryUI.this, menuItem.getItemId());
            AppMethodBeat.m2505o(124928);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$25 */
    class C3299325 implements Runnable {
        C3299325() {
        }

        public final void run() {
            AppMethodBeat.m2504i(124932);
            LoginHistoryUI.this.finish();
            LoginHistoryUI.this.overridePendingTransition(-1, -1);
            AppMethodBeat.m2505o(124932);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$26 */
    class C3299426 implements OnMenuItemClickListener {
        C3299426() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124933);
            LoginHistoryUI.m53930b(LoginHistoryUI.this);
            AppMethodBeat.m2505o(124933);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$27 */
    class C3299527 implements View.OnClickListener {
        C3299527() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124934);
            LoginHistoryUI.m53926R(LoginHistoryUI.this, LoginHistoryUI.this.getString(C25738R.string.g7t) + C4988aa.dor());
            AppMethodBeat.m2505o(124934);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$28 */
    class C3299628 implements View.OnClickListener {
        C3299628() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124935);
            LoginHistoryUI.m53926R(LoginHistoryUI.this, LoginHistoryUI.this.getString(C25738R.string.g7k, new Object[]{C4988aa.dor()}));
            AppMethodBeat.m2505o(124935);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$29 */
    class C3299729 implements C33029a {

        /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$29$1 */
        class C99311 implements Runnable {
            C99311() {
            }

            public final void run() {
                AppMethodBeat.m2504i(124936);
                LoginHistoryUI.this.gBZ.fullScroll(130);
                AppMethodBeat.m2505o(124936);
            }
        }

        C3299729() {
        }

        public final void aqZ() {
            AppMethodBeat.m2504i(124937);
            LoginHistoryUI.this.gBZ.post(new C99311());
            AppMethodBeat.m2505o(124937);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$6 */
    class C329986 implements View.OnClickListener {
        C329986() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124918);
            LoginHistoryUI.m53934f(LoginHistoryUI.this);
            AppMethodBeat.m2505o(124918);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$7 */
    class C329997 implements View.OnClickListener {
        C329997() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124919);
            C25985d.m41448H(LoginHistoryUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginHistoryUI.this.overridePendingTransition(C25738R.anim.f8372cd, C25738R.anim.f8293s);
            AppMethodBeat.m2505o(124919);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$8 */
    class C330008 implements C10008a {
        C330008() {
        }

        /* renamed from: a */
        public final void mo17503a(ProgressDialog progressDialog) {
            LoginHistoryUI.this.ehJ = progressDialog;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$9 */
    class C330019 implements C1835a {
        C330019() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(124920);
            if (c1902e == null) {
                AppMethodBeat.m2505o(124920);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(124920);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$13 */
    class C3300213 implements OnClickListener {
        C3300213() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginHistoryUI$30 */
    class C3300330 implements OnTouchListener {
        C3300330() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(124938);
            LoginHistoryUI.this.aqX();
            AppMethodBeat.m2505o(124938);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LoginHistoryUI() {
        AppMethodBeat.m2504i(124940);
        AppMethodBeat.m2505o(124940);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124941);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", C24679a.gkF);
        C24679a.gkF.mo38846BV();
        this.ehZ = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.gCp = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
            this.gCp = this.gCp;
            if (this.gCp) {
                this.gCq = intent.getStringExtra("bind_login_fingerprint_info");
            }
        }
        initView();
        this.gCd = new C45476c();
        AppMethodBeat.m2505o(124941);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(124942);
        C4990ab.m7416i("MicroMsg.LoginHistoryUI", "onDestroy");
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        if (this.gCd != null) {
            this.gCd.close();
        }
        C7060h.pYm.mo8381e(14262, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]));
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(124942);
    }

    public void onResume() {
        C44274m c44274m;
        AppMethodBeat.m2504i(124943);
        super.onResume();
        final ArrayList arrayList = new ArrayList();
        if (!(!aqY() || this.gwX == 1 || (this.gCn & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0)) {
            c44274m = new C44274m(this, 7001, 0);
            c44274m.setTitle((int) C25738R.string.cos);
            arrayList.add(c44274m);
        }
        if (!(this.gwX == 5 || (this.gCn & 262144) == 0)) {
            c44274m = new C44274m(this, 7005, 0);
            c44274m.setTitle((int) C25738R.string.cop);
            arrayList.add(c44274m);
        }
        if (!C5046bo.isNullOrNil(this.gCb)) {
            if (this.gwX != 2) {
                c44274m = new C44274m(this, 7007, 0);
                c44274m.setTitle(getString(C25738R.string.coq));
                arrayList.add(c44274m);
            }
            if (!(C5046bo.isNullOrNil(this.gBV) || this.gwX == 3)) {
                c44274m = new C44274m(this, 7008, 0);
                c44274m.setTitle(getString(C25738R.string.cor));
                arrayList.add(c44274m);
            }
            if (this.gCb.equalsIgnoreCase(this.gBU)) {
                this.gBJ.setHint(getString(C25738R.string.dmh));
            }
        }
        if (arrayList.size() > 1) {
            final C36356d c36356d = new C36356d(this, 1, false);
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(124927);
                    if (c44273l.size() == 0) {
                        for (C44274m i : arrayList) {
                            c44273l.mo70073i(i);
                        }
                    }
                    AppMethodBeat.m2505o(124927);
                }
            };
            c36356d.rBm = new C3299220();
            c36356d.zQf = new C2661821();
            this.gBL.setVisibility(0);
            this.gBL.setText(C25738R.string.co_);
            this.gBL.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(124930);
                    LoginHistoryUI.this.aqX();
                    c36356d.cpD();
                    AppMethodBeat.m2505o(124930);
                }
            });
        } else if (arrayList.size() > 0) {
            this.gBL.setVisibility(0);
            this.gBL.setText(((C44274m) arrayList.get(0)).getTitle());
            this.gBL.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(124931);
                    LoginHistoryUI.m53928a(LoginHistoryUI.this, ((C44274m) arrayList.get(0)).getItemId());
                    AppMethodBeat.m2505o(124931);
                }
            });
        } else {
            this.gBL.setVisibility(8);
        }
        C4879a.xxA.mo10052c(this.gAY);
        C1720g.m3534RN();
        C1668a.m3398Rc();
        if (!C1720g.m3531RK() || !C1720g.m3534RN().eJb || this.gCb.equals("")) {
            if (C40600a.m70011On() == 2) {
                C5652a c5652a = new C5652a(this);
                c5652a.mo11446PV(C25738R.string.apa);
                c5652a.asE(getString(C25738R.string.ap_));
                c5652a.mo11482rc(false);
                c5652a.mo11453Qc(C25738R.string.ap8).mo11457a(new C1888322());
                c5652a.aMb().show();
                C40600a.m70012b(this, System.currentTimeMillis());
            }
            AppMethodBeat.m2505o(124943);
        } else if (this.ehJ == null || !this.ehJ.isShowing()) {
            m53929b(null);
            AppMethodBeat.m2505o(124943);
        } else {
            AppMethodBeat.m2505o(124943);
        }
    }

    public void onPause() {
        AppMethodBeat.m2504i(124944);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        AppMethodBeat.m2505o(124944);
    }

    private void goBack() {
        AppMethodBeat.m2504i(124945);
        Intent bh = C24679a.gkE.mo38909bh(this);
        bh.addFlags(67108864);
        if (C5046bo.isNullOrNil(this.gBX)) {
            bh.putExtra("can_finish", true);
        }
        startActivity(bh);
        finish();
        C5274b.m8054hM(this);
        AppMethodBeat.m2505o(124945);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(124946);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(124946);
        return onKeyDown;
    }

    /* renamed from: D */
    private static Bitmap m53925D(Bitmap bitmap) {
        AppMethodBeat.m2504i(124947);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 5, 5, bitmap.getWidth() - 10, bitmap.getHeight() - 10, null, false);
        AppMethodBeat.m2505o(124947);
        return createBitmap;
    }

    public final void initView() {
        AppMethodBeat.m2504i(124948);
        this.gCe = (LinearLayout) findViewById(2131825302);
        this.gCg = (LinearLayout) findViewById(2131825307);
        this.gCf = (LinearLayout) findViewById(2131825311);
        this.gCh = (MMFormInputView) findViewById(2131825300);
        this.gCi = (MMFormVerifyCodeInputView) findViewById(2131825301);
        this.gBX = getIntent().getStringExtra("switch_login_wx_id");
        if (C5046bo.isNullOrNil(this.gBX)) {
            this.gCb = C6665av.fly.mo5292T("login_user_name", "");
            this.gCc = C6665av.fly.mo14896ZC();
            this.gCo = C5046bo.ank(C6665av.fly.mo5292T("last_bind_info", ""));
            if ((this.gCo & 1) != 0) {
                this.gBU = C6665av.fly.mo5292T("last_login_bind_qq", "");
            }
            if ((this.gCo & 4) != 0) {
                this.gBV = C6665av.fly.mo5292T("last_login_bind_mobile", "");
            }
            this.gCn = C5046bo.ank(C6665av.fly.mo5292T("last_login_use_voice", ""));
        } else {
            this.gCb = C37914bx.fnB.getString(this.gBX, "login_user_name");
            this.gCc = C37914bx.fnB.getString(this.gBX, "last_avatar_path");
            this.gCo = C5046bo.ank(C37914bx.fnB.getString(this.gBX, "last_bind_info"));
            if ((this.gCo & 1) != 0) {
                this.gBU = C37914bx.fnB.getString(this.gBX, "last_login_bind_qq");
            }
            if ((this.gCo & 4) != 0) {
                this.gBV = C37914bx.fnB.getString(this.gBX, "last_login_bind_mobile");
            }
            this.gCn = C5046bo.ank(C37914bx.fnB.getString(this.gBX, "last_login_use_voice"));
            setBackBtn(new C3299426(), C1318a.actionbar_icon_close_black);
        }
        String stringExtra = getIntent().getStringExtra("email_address");
        if (!(C5046bo.isNullOrNil(stringExtra) || stringExtra.equalsIgnoreCase(this.gCb))) {
            this.gCb = stringExtra;
        }
        this.gBY = (ImageView) findViewById(2131825299);
        if (!C5046bo.isNullOrNil(this.gCc)) {
            try {
                Bitmap qi = C41732d.m73528qi(this.gCc);
                if (qi != null && qi.getWidth() > 10) {
                    this.gBY.setImageBitmap(LoginHistoryUI.m53925D(qi));
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LoginHistoryUI", e, "get avatar error", new Object[0]);
            }
        }
        C1720g.m3534RN();
        if (!C1668a.m3395QX() || this.gCb.equals("")) {
            this.gBZ = (MMKeyboardUperView) findViewById(2131820921);
            this.gBI = (TextView) findViewById(2131825289);
            this.gBJ = this.gCh.getContentEditText();
            this.gBK = (Button) findViewById(2131825292);
            this.gBM = findViewById(2131825303);
            this.gBN = findViewById(2131825308);
            this.gBO = (Button) findViewById(2131825313);
            this.gBL = (Button) findViewById(2131825306);
            this.gCj = (Button) findViewById(2131825293);
            this.gBP = (Button) findViewById(2131825295);
            this.gBQ = (Button) findViewById(2131825297);
            this.gBR = findViewById(2131825296);
            this.gBS = (Button) findViewById(2131825298);
            this.gBP.setOnClickListener(new C3299527());
            this.gBQ.setOnClickListener(new C3299628());
            if (!C4988aa.doo()) {
                this.gBR.setVisibility(8);
            }
            this.gCh.setVisibility(8);
            this.gCe.setVisibility(8);
            this.gCg.setVisibility(8);
            this.gCf.setVisibility(8);
            this.gBK.setVisibility(8);
            this.gBM.setVisibility(8);
            this.gBN.setVisibility(8);
            this.gBO.setVisibility(8);
            this.gBL.setVisibility(8);
            C7357c.m12555d(this.gBJ).mo15880hz(4, 16).mo15879a(null);
            this.gCa = (ResizeLayout) findViewById(2131825288);
            if (!C5046bo.ant(this.gCb).booleanValue() || this.gCb.equals(this.gBU)) {
                this.gCr[2] = 2;
                this.gBI.setText(this.gCb);
            } else {
                this.gCr[2] = 1;
                this.gBI.setText(mo53543ws(this.gCb));
            }
            this.gCa.setOnSizeChanged(new C3299729());
            this.gBZ.setOnTouchListener(new C3300330());
            final C36356d c36356d = new C36356d(this, 1, false);
            c36356d.rBl = new C3299031();
            c36356d.rBm = new C188862();
            c36356d.zQf = new C188873();
            if (C5046bo.isNullOrNil(this.gBX)) {
                this.gBS.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(124916);
                        LoginHistoryUI.this.aqX();
                        c36356d.cpD();
                        AppMethodBeat.m2505o(124916);
                    }
                });
            } else if (C4988aa.doo()) {
                this.gBS.setText(C25738R.string.g0m);
                this.gBS.setOnClickListener(new C329986());
            } else {
                this.gBS.setText(C25738R.string.g0k);
                this.gBS.setOnClickListener(new C188895());
            }
            setMMTitle("");
            mo17446xE(getResources().getColor(C25738R.color.f12206vy));
            dyb();
            mo17427pP(false);
            if (C5059g.xyf) {
                C24679a.gkF.mo38871p(this);
            }
            if (C5058f.EX_DEVICE_LOGIN) {
                this.gCj.setVisibility(0);
                this.gCj.setOnClickListener(new C329997());
            }
            AppMethodBeat.m2505o(124948);
            return;
        }
        this.gCl = true;
        m53929b(null);
        AppMethodBeat.m2505o(124948);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ws */
    public final String mo53543ws(String str) {
        AppMethodBeat.m2504i(124949);
        C5025av c5025av = new C5025av();
        String str2 = "86";
        if (this.gCb.startsWith("+")) {
            str = str.replace("+", "");
            str2 = C5025av.m7481Ps(str);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        str2 = C5025av.formatNumber(str2, str);
        AppMethodBeat.m2505o(124949);
        return str2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqV() {
        AppMethodBeat.m2504i(124950);
        C1720g.m3540Rg().mo14539a(701, (C1202f) this);
        C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        AppMethodBeat.m2505o(124950);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqW() {
        AppMethodBeat.m2504i(124951);
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        AppMethodBeat.m2505o(124951);
    }

    /* Access modifiers changed, original: protected */
    public void aqU() {
        AppMethodBeat.m2504i(124952);
        this.gBT.account = this.gCb.trim();
        AppMethodBeat.m2505o(124952);
    }

    public final void aqX() {
        AppMethodBeat.m2504i(124953);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(124953);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.m2505o(124953);
            return;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.m2505o(124953);
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        AppMethodBeat.m2505o(124953);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(124954);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginHistoryUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7411d(str, str2, objArr);
        String stringExtra;
        if (i != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || intent == null) {
            if (i != 1025 || intent == null) {
                if (i == 31685 && intent != null && i2 == -1) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                        aqU();
                    }
                }
            } else if (i2 == 2) {
                stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                str = "MicroMsg.LoginHistoryUI";
                str2 = "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                C4990ab.m7417i(str, str2, objArr);
                m53940wt(stringExtra);
                AppMethodBeat.m2505o(124954);
                return;
            }
        } else if (i2 == -1) {
            stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginHistoryUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
            if (!C5046bo.isNullOrNil(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            C4990ab.m7411d(str2, str3, objArr2);
            m53940wt(stringExtra);
            AppMethodBeat.m2505o(124954);
            return;
        }
        AppMethodBeat.m2505o(124954);
    }

    /* renamed from: wt */
    private void m53940wt(String str) {
        AppMethodBeat.m2504i(124955);
        this.gCk = str;
        aqU();
        AppMethodBeat.m2505o(124955);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124956);
        C4990ab.m7416i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        C4990ab.m7410d("MicroMsg.LoginHistoryUI", "Scene Type " + c1207m.getType());
        C42124a jY;
        boolean z;
        if (c1207m.getType() == 145) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            int Ah = ((C32815a) c1207m).mo53366Ah();
            if (Ah == 16) {
                if (i2 == -41) {
                    C30379h.m48467g(this, C25738R.string.dl6, C25738R.string.dl7);
                    this.gCi.reset();
                    AppMethodBeat.m2505o(124956);
                    return;
                } else if (i2 == -75) {
                    C30379h.m48461b((Context) this, getString(C25738R.string.f8809fm), "", true);
                    this.gCi.reset();
                    AppMethodBeat.m2505o(124956);
                    return;
                } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                    C42257z.m74635f(this, str, 32045);
                    this.gCi.reset();
                    AppMethodBeat.m2505o(124956);
                    return;
                }
            } else if (Ah == 17) {
                this.gCs = i2;
                this.gCt = str;
                if (i == 0 && i2 == 0) {
                    new C10004g(new C330008(), ((C32815a) c1207m).getUsername(), ((C32815a) c1207m).agf(), this.gBV).mo21362a(this);
                    AppMethodBeat.m2505o(124956);
                    return;
                } else if (m53939j(i, i2, str)) {
                    AppMethodBeat.m2505o(124956);
                    return;
                } else {
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, null, null);
                    }
                }
            }
        } else if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            this.cOG = ((C6686q) c1207m).ajm();
            C4990ab.m7412e("MicroMsg.LoginHistoryUI", "url " + this.cOG);
            C1720g.m3540Rg().mo14546b(701, (C1202f) this);
            C1720g.m3540Rg().mo14546b(252, (C1202f) this);
            this.gBT.gCL = ((C6686q) c1207m).getSecCodeType();
            this.gBT.guh = ((C6686q) c1207m).ajn();
            this.gBT.gug = ((C6686q) c1207m).ajo();
            this.gBT.gui = ((C6686q) c1207m).ajp();
            if (i2 == -205) {
                this.gzO = ((C6686q) c1207m).agh();
                this.gBV = ((C6686q) c1207m).ajq();
                this.gBW = ((C6686q) c1207m).ajt();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                C1720g.m3540Rg().mo14541a(new C6668bk(new C330019()), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                C1668a.unhold();
                C38033l.apX();
                C26529w.m42356cm(this);
                C42257z.m74637vx(this.gBT.account);
                if (this.ehJ != null && this.ehJ.isShowing()) {
                    this.ehJ.setMessage(getString(C25738R.string.f9160rd));
                }
                m53929b((C6686q) c1207m);
                if (this.gwX == 3) {
                    this.gCm = ((C6686q) c1207m).ajv();
                    C1720g.m3540Rg().mo14539a(255, (C1202f) this);
                    final C1207m c9706r = new C9706r(1);
                    C1720g.m3540Rg().mo14541a(c9706r, 0);
                    getString(C25738R.string.f9238tz);
                    this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9160rd), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(124921);
                            C1720g.m3540Rg().mo14547c(c9706r);
                            C1720g.m3540Rg().mo14546b(255, LoginHistoryUI.this);
                            AppMethodBeat.m2505o(124921);
                        }
                    });
                }
                AppMethodBeat.m2505o(124956);
                return;
            }
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                C42257z.m74635f(this, str, 31685);
                AppMethodBeat.m2505o(124956);
                return;
            } else if (i2 == -217) {
                C42257z.m74633a(this, C1948e.m4157a((C6686q) c1207m), i2);
                AppMethodBeat.m2505o(124956);
                return;
            } else if (m53939j(i, i2, str)) {
                AppMethodBeat.m2505o(124956);
                return;
            } else {
                jY = C42124a.m74268jY(str);
                if (jY == null || !jY.mo67668a(this, null, null)) {
                    Toast.makeText(this, getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    AppMethodBeat.m2505o(124956);
                    return;
                }
            }
        } else if (c1207m.getType() == 255) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            C1720g.m3540Rg().mo14546b(255, (C1202f) this);
            if (i2 == -3 && i == 4) {
                z = this.gCm;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(C25738R.string.e8s));
                intent.putExtra("kintent_cancelable", z);
                startActivity(intent);
            }
            AppMethodBeat.m2505o(124956);
            return;
        }
        if (m53939j(i, i2, str)) {
            AppMethodBeat.m2505o(124956);
        } else {
            AppMethodBeat.m2505o(124956);
        }
    }

    /* renamed from: b */
    private void m53929b(C6686q c6686q) {
        AppMethodBeat.m2504i(124957);
        C4990ab.m7417i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", Integer.valueOf(hashCode()), C5046bo.dpG());
        Intent bh = C24679a.gkE.mo38909bh(this);
        bh.addFlags(67108864);
        if (c6686q != null) {
            bh.putExtra("kstyle_show_bind_mobile_afterauth", c6686q.ajr());
            bh.putExtra("kstyle_bind_recommend_show", c6686q.aju());
            bh.putExtra("kstyle_bind_wording", c6686q.ajs());
        }
        startActivity(bh);
        finish();
        AppMethodBeat.m2505o(124957);
    }

    /* JADX WARNING: Missing block: B:17:0x0080, code skipped:
            com.tencent.p177mm.p612ui.base.C30379h.m48467g(r11, com.tencent.p177mm.C25738R.string.cof, com.tencent.p177mm.C25738R.string.cog);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(124958);
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: j */
    private boolean m53939j(final int i, int i2, String str) {
        AppMethodBeat.m2504i(124958);
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    C1720g.m3540Rg().mo14539a(701, (C1202f) this);
                    C1720g.m3540Rg().mo14539a(252, (C1202f) this);
                    if (this.gue == null) {
                        this.gue = C15492a.m23811a(this, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                int i2 = -1;
                                AppMethodBeat.m2504i(124925);
                                C4990ab.m7410d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.gBT.guh + " img len" + LoginHistoryUI.this.gBT.gug.length + " " + C1447g.m3075Mq());
                                String str = "MicroMsg.LoginHistoryUI";
                                String str2 = "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = Integer.valueOf(i);
                                objArr[1] = Integer.valueOf(LoginHistoryUI.this.gCk == null ? -1 : LoginHistoryUI.this.gCk.length());
                                objArr[2] = C5046bo.anv(LoginHistoryUI.this.gCk);
                                if (LoginHistoryUI.this.gBT.guf != null) {
                                    i2 = LoginHistoryUI.this.gBT.guf.length();
                                }
                                objArr[3] = Integer.valueOf(i2);
                                objArr[4] = C5046bo.anv(LoginHistoryUI.this.gBT.guf);
                                C4990ab.m7411d(str, str2, objArr);
                                final C1207m c6686q = new C6686q(LoginHistoryUI.this.gBT.account, LoginHistoryUI.this.gBT.guf, LoginHistoryUI.this.gBT.gCL, LoginHistoryUI.this.gue.getSecImgCode(), LoginHistoryUI.this.gue.getSecImgSid(), LoginHistoryUI.this.gue.getSecImgEncryptKey(), 0, "", false, false);
                                if (C5046bo.isNullOrNil(LoginHistoryUI.this.gBT.guf) && !C5046bo.isNullOrNil(LoginHistoryUI.this.gCk)) {
                                    C4990ab.m7417i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", C5046bo.anv(LoginHistoryUI.this.gCk));
                                    c6686q.mo14934tr(LoginHistoryUI.this.gCk);
                                }
                                C1720g.m3540Rg().mo14541a(c6686q, 0);
                                LoginHistoryUI loginHistoryUI = LoginHistoryUI.this;
                                Context context = LoginHistoryUI.this;
                                LoginHistoryUI.this.getString(C25738R.string.f9238tz);
                                loginHistoryUI.ehJ = C30379h.m48458b(context, LoginHistoryUI.this.getString(C25738R.string.cou), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(124924);
                                        C1720g.m3540Rg().mo14547c(c6686q);
                                        C1720g.m3540Rg().mo14546b(701, LoginHistoryUI.this);
                                        C1720g.m3540Rg().mo14546b(252, LoginHistoryUI.this);
                                        AppMethodBeat.m2505o(124924);
                                    }
                                });
                                AppMethodBeat.m2505o(124925);
                            }
                        }, null, new C992716(), this.gBT);
                    } else {
                        C4990ab.m7410d("MicroMsg.LoginHistoryUI", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + C1447g.m3075Mq());
                        this.gue.mo27573b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                    }
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -205:
                    C4990ab.m7417i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", C5046bo.anv(this.gzO), this.gBW);
                    C31280f.m50502a(this.gBT);
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.gzO);
                    intent.putExtra("binded_mobile", this.gBV);
                    intent.putExtra("close_safe_device_style", this.gBW);
                    intent.putExtra("from_source", 2);
                    C24679a.gkE.mo38920g((Context) this, intent);
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -140:
                    if (!C5046bo.isNullOrNil(this.cOG)) {
                        C42257z.m74636o(this, str, this.cOG);
                    }
                    AppMethodBeat.m2505o(124958);
                    return true;
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    String an;
                    C1668a.hold();
                    C1720g.m3534RN();
                    if (TextUtils.isEmpty(C1668a.m3385QH())) {
                        an = C1338a.m2858an(this, C25738R.string.cvw);
                    } else {
                        C1720g.m3534RN();
                        an = C1668a.m3385QH();
                    }
                    C30379h.m48439a((Context) this, an, getString(C25738R.string.f9238tz), new C992817(), new C992918());
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -75:
                    C42257z.m74634cu(this);
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -72:
                    C30379h.m48467g(this, C25738R.string.dmb, C25738R.string.f9238tz);
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -33:
                    C30379h.m48431a((Context) this, (int) C25738R.string.a7s, (int) C25738R.string.a7y, new C3298914());
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -32:
                    C30379h.m48438a((Context) this, getString(C25738R.string.a7u), "", new C3300213());
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -9:
                    break;
                case -3:
                    if (this.gCu <= 0) {
                        C30379h.m48467g(this, C25738R.string.be9, C25738R.string.cog);
                        this.gCu++;
                    } else {
                        C30379h.m48466d(this, getString(C25738R.string.be_), getString(C25738R.string.cog), getString(C25738R.string.bea), getString(C25738R.string.f9076or), new C1888111(), new C3298812());
                    }
                    AppMethodBeat.m2505o(124958);
                    return true;
                case -1:
                    if (C1720g.m3540Rg().acS() == 5) {
                        C30379h.m48467g(this, C25738R.string.d5n, C25738R.string.d5m);
                        AppMethodBeat.m2505o(124958);
                        return true;
                    }
                    break;
            }
        }
        if (C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
            if (this.gue != null) {
                this.gue.dismiss();
            }
            AppMethodBeat.m2505o(124958);
            return true;
        }
        boolean a = this.gCd.mo73273a(this, new C45475ag(i, i2, str));
        AppMethodBeat.m2505o(124958);
        return a;
    }

    public final int getLayoutId() {
        return 2130969950;
    }

    public void setRequestedOrientation(int i) {
    }

    /* renamed from: R */
    public static void m53926R(Context context, String str) {
        AppMethodBeat.m2504i(124959);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(124959);
    }

    public boolean aqY() {
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m53927a(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.m2504i(124960);
        C4997aj.amB("welcome_page_show");
        C1737l.m3593m(loginHistoryUI, true);
        C45382z c45382z = new C45382z();
        c45382z.csU.csV = false;
        C4879a.xxA.mo10055m(c45382z);
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41566BV();
        loginHistoryUI.finish();
        AppCompatActivity appCompatActivity = loginHistoryUI.mController.ylL;
        C4990ab.dot();
        MMNativeJpeg.Destroy();
        Intent intent = null;
        try {
            intent = new Intent().setClass(appCompatActivity, Class.forName(C4996ah.doy()));
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.LoginHistoryUI", e, "", new Object[0]);
        }
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        if (!(appCompatActivity instanceof Activity)) {
            intent.addFlags(268435456);
        }
        appCompatActivity.startActivity(intent);
        AppMethodBeat.m2505o(124960);
    }

    /* renamed from: d */
    static /* synthetic */ void m53932d(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.m2504i(124962);
        loginHistoryUI.gCr[4] = 1;
        Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        int[] iArr = new int[5];
        iArr[4] = 1;
        intent.putExtra("kv_report_login_method_data", iArr);
        loginHistoryUI.startActivity(intent);
        AppMethodBeat.m2505o(124962);
    }

    /* renamed from: e */
    static /* synthetic */ void m53933e(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.m2504i(124963);
        if (C7243d.vxr) {
            String string = loginHistoryUI.getString(C25738R.string.b3m, new Object[]{"0x" + Integer.toHexString(C7243d.vxo), C4988aa.dor()});
            C4990ab.m7412e("MicroMsg.LoginHistoryUI", "url ".concat(String.valueOf(string)));
            LoginHistoryUI.m53926R(loginHistoryUI.mController.ylL, string);
            AppMethodBeat.m2505o(124963);
            return;
        }
        loginHistoryUI.startActivity(new Intent(loginHistoryUI, RegByMobileRegAIOUI.class));
        AppMethodBeat.m2505o(124963);
    }

    /* renamed from: f */
    static /* synthetic */ void m53934f(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.m2504i(124964);
        LoginHistoryUI.m53926R(loginHistoryUI.mController.ylL, loginHistoryUI.getString(C25738R.string.g0n) + C4988aa.dor());
        AppMethodBeat.m2505o(124964);
    }

    /* renamed from: g */
    static /* synthetic */ void m53935g(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.m2504i(124965);
        int i = 0;
        if (loginHistoryUI.gCo != 0) {
            if (!((loginHistoryUI.gCo & 2) == 0 && (loginHistoryUI.gCo & 4) == 0)) {
                i = 2;
            }
            if ((loginHistoryUI.gCo & 4) != 0) {
                i |= 4;
            }
            if ((loginHistoryUI.gCo & 1) != 0) {
                i |= 1;
            }
        } else if (C17950b.ahP()) {
            i = 6;
        } else {
            i = 7;
        }
        i |= 8;
        C46696j c46696j = new C46696j(loginHistoryUI);
        c46696j.rBl = new C380801(i, loginHistoryUI);
        c46696j.rBm = new C380812(loginHistoryUI);
        c46696j.cuu();
        AppMethodBeat.m2505o(124965);
    }

    /* renamed from: a */
    static /* synthetic */ void m53928a(LoginHistoryUI loginHistoryUI, int i) {
        AppMethodBeat.m2504i(124966);
        Intent intent = null;
        loginHistoryUI.gCr[3] = 1;
        switch (i) {
            case 7001:
                intent = new Intent(loginHistoryUI, LoginVoiceUI.class);
                break;
            case 7006:
                intent = new Intent(loginHistoryUI, LoginFaceUI.class);
                break;
            case 7007:
                intent = new Intent(loginHistoryUI, LoginPasswordUI.class);
                break;
            case 7008:
                intent = new Intent(loginHistoryUI, LoginSmsUI.class);
                break;
        }
        if (intent != null) {
            intent.putExtra("switch_login_wx_id", loginHistoryUI.gBX);
            loginHistoryUI.startActivity(intent);
            C5004al.m7442n(new C3299325(), 300);
            C5274b.m8055hN(loginHistoryUI);
        }
        AppMethodBeat.m2505o(124966);
    }
}
