package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.openim.p716b.C32876g;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p1528bb.C37508a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.alj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI */
public class SelfQRCodeUI extends MMActivity implements C1202f {
    private static final String PATH = (C1448h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private ProgressDialog ehJ = null;
    private Bitmap fru = null;
    private ImageView iqT = null;
    private TextView jPp = null;
    private long kFU;
    private ImageView qkD = null;
    private byte[] qkE = null;
    private TextView qlv = null;
    private boolean qlw = false;
    private C39664b qlx;
    private String userName = "";

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$3 */
    class C132033 implements OnClickListener {
        C132033() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127015);
            SelfQRCodeUI.m67788f(SelfQRCodeUI.this);
            AppMethodBeat.m2505o(127015);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$5 */
    class C132045 implements OnMenuItemClickListener {
        C132045() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127017);
            SelfQRCodeUI.this.aqX();
            SelfQRCodeUI.this.finish();
            AppMethodBeat.m2505o(127017);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$4 */
    class C289374 implements OnMenuItemClickListener {
        C289374() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127016);
            SelfQRCodeUI.m67784b(SelfQRCodeUI.this);
            AppMethodBeat.m2505o(127016);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$10 */
    class C3485610 implements DialogInterface.OnClickListener {
        C3485610() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127022);
            SelfQRCodeUI.m67783a(SelfQRCodeUI.this, 2);
            AppMethodBeat.m2505o(127022);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$1 */
    class C348571 implements Runnable {
        C348571() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127014);
            int width = SelfQRCodeUI.this.qkD.getWidth();
            LayoutParams layoutParams = (LayoutParams) SelfQRCodeUI.this.qkD.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = width;
            SelfQRCodeUI.this.qkD.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(127014);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$8 */
    class C396618 implements C36073c {
        C396618() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(127020);
            boolean mN = C1855t.m3901mN(SelfQRCodeUI.this.userName);
            boolean rc = C17903f.m28109rc(SelfQRCodeUI.this.userName);
            if (!(rc || mN)) {
                c44273l.mo70072hi(2, C25738R.string.e2d);
            }
            c44273l.mo70072hi(1, C25738R.string.e2h);
            if (!rc) {
                c44273l.mo70072hi(3, C25738R.string.e2x);
            }
            if (SelfQRCodeUI.this.qlw) {
                c44273l.mo70072hi(4, C25738R.string.e2w);
            }
            AppMethodBeat.m2505o(127020);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$9 */
    class C396629 implements C5279d {
        C396629() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(127021);
            switch (menuItem.getItemId()) {
                case 1:
                    SelfQRCodeUI.m67787e(SelfQRCodeUI.this);
                    AppMethodBeat.m2505o(127021);
                    return;
                case 2:
                    SelfQRCodeUI.m67783a(SelfQRCodeUI.this, 0);
                    AppMethodBeat.m2505o(127021);
                    return;
                case 3:
                    if (!(C35973a.m59178bI(SelfQRCodeUI.this.mController.ylL) || C17981e.akI())) {
                        C25985d.m41448H(SelfQRCodeUI.this.mController.ylL, "scanner", ".ui.BaseScanUI");
                        AppMethodBeat.m2505o(127021);
                        return;
                    }
                case 4:
                    SelfQRCodeUI.m67788f(SelfQRCodeUI.this);
                    break;
            }
            AppMethodBeat.m2505o(127021);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$a */
    interface C39663a {
        String ciA();

        byte[] ciy();

        String ciz();
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$b */
    public class C39664b extends FileObserver {
        private MMActivity qlB;
        private String qlC;

        public C39664b(MMActivity mMActivity) {
            super(SelfQRCodeUI.PATH, 8);
            AppMethodBeat.m2504i(127023);
            this.qlB = mMActivity;
            AppMethodBeat.m2505o(127023);
        }

        public final void onEvent(int i, String str) {
            AppMethodBeat.m2504i(127024);
            if (str != null && i == 8 && (this.qlC == null || !str.equalsIgnoreCase(this.qlC))) {
                this.qlC = str;
                Uri.fromFile(new File(SelfQRCodeUI.PATH + str));
                SelfQRCodeUI.cix();
                C4990ab.m7416i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
            }
            AppMethodBeat.m2505o(127024);
        }

        public final void start() {
            AppMethodBeat.m2504i(127025);
            super.startWatching();
            AppMethodBeat.m2505o(127025);
        }

        public final void stop() {
            AppMethodBeat.m2504i(127026);
            super.stopWatching();
            AppMethodBeat.m2505o(127026);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI$6 */
    class C396656 implements OnClickListener {
        C396656() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127018);
            C25985d.m41448H(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
            AppMethodBeat.m2505o(127018);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m67783a(SelfQRCodeUI selfQRCodeUI, int i) {
        AppMethodBeat.m2504i(127037);
        selfQRCodeUI.m67780Ck(i);
        AppMethodBeat.m2505o(127037);
    }

    public final int getLayoutId() {
        return 2130970612;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127027);
        super.onCreate(bundle);
        dyb();
        this.qlx = new C39664b(this);
        this.qlx.start();
        C1720g.m3540Rg().mo14539a(168, (C1202f) this);
        C1720g.m3540Rg().mo14539a(890, (C1202f) this);
        initView();
        this.qkD.post(new C348571());
        AppMethodBeat.m2505o(127027);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127028);
        C1720g.m3540Rg().mo14546b(168, (C1202f) this);
        C1720g.m3540Rg().mo14546b(890, (C1202f) this);
        if (this.qlx != null) {
            this.qlx.stop();
        }
        if (!(this.fru == null || this.fru.isRecycled())) {
            C4990ab.m7417i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", this.fru.toString());
            this.fru.recycle();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(127028);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127029);
        super.onResume();
        if (C1855t.m3901mN(this.userName) || C17903f.m28109rc(this.userName)) {
            AppMethodBeat.m2505o(127029);
            return;
        }
        View findViewById = findViewById(2131821048);
        this.kFU = C1853r.m3823YE();
        C4990ab.m7410d("MicroMsg.SelfQRCodeNewUI", (this.kFU & 2) + ",extstatus:" + this.kFU);
        if ((this.kFU & 2) != 0) {
            findViewById.setVisibility(0);
            this.qkD.setAlpha(0.1f);
            findViewById(2131821049).setOnClickListener(new C396656());
            AppMethodBeat.m2505o(127029);
            return;
        }
        findViewById.setVisibility(8);
        this.qkD.setAlpha(1.0f);
        AppMethodBeat.m2505o(127029);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127030);
        this.userName = getIntent().getStringExtra("from_userName");
        if (C5046bo.isNullOrNil(this.userName)) {
            this.userName = C1853r.m3846Yz();
        }
        if (C1853r.m3846Yz().equals(this.userName)) {
            this.qlw = true;
        }
        if (C1855t.m3901mN(this.userName)) {
            setMMTitle((int) C25738R.string.ea0);
            ((TextView) findViewById(2131821050)).setText("");
            enableOptionMenu(false);
        } else if (C17903f.m28109rc(this.userName)) {
            setMMTitle((int) C25738R.string.bdx);
            ((TextView) findViewById(2131821050)).setText(C25738R.string.bdy);
            enableOptionMenu(false);
        } else {
            setMMTitle((int) C25738R.string.e_o);
        }
        this.qkD = (ImageView) findViewById(2131821047);
        this.iqT = (ImageView) findViewById(2131821043);
        this.jPp = (TextView) findViewById(2131821045);
        this.qlv = (TextView) findViewById(2131821046);
        CharSequence charSequence;
        if (!C1855t.m3901mN(this.userName) && !C17903f.m28109rc(this.userName)) {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(42, null);
            String string = getString(C25738R.string.f9131qf);
            if (C5046bo.isNullOrNil(str)) {
                str = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
                string = string + str;
                C7616ad.aoA(str);
                str = string;
            } else {
                str = string + str;
            }
            C4990ab.m7411d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", str);
            if (this.fru == null) {
                C4990ab.m7411d("MicroMsg.SelfQRCodeNewUI", "%s", "bitmap == null");
                m67780Ck(1);
            } else {
                this.qkD.setImageBitmap(this.fru);
            }
            C40460b.m69434b(this.iqT, C1853r.m3846Yz());
            C4990ab.m7411d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", (String) C1720g.m3536RP().mo5239Ry().get(4, null));
            this.jPp.setText(C44089j.m79294b((Context) this, charSequence, C1338a.m2856al(this.mController.ylL, C25738R.dimen.f9936kr)));
            C32782bp aao = C32782bp.aao();
            string = C5046bo.nullAsNil(aao.getProvince());
            C4990ab.m7411d("MicroMsg.SelfQRCodeNewUI", "display location = %s", C1854s.m3868mL(string) + " " + C5046bo.nullAsNil(aao.getCity()));
            this.qlv.setText(str);
            switch (C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(12290, null), 0)) {
                case 1:
                    this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, C1338a.m2864g(this, C1318a.ic_sex_male), null);
                    break;
                case 2:
                    this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, C1338a.m2864g(this, C1318a.ic_sex_female), null);
                    break;
            }
        }
        m67780Ck(1);
        C40460b.m69434b(this.iqT, this.userName);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.userName);
        this.jPp.setSingleLine(false);
        this.jPp.setMaxLines(3);
        if (C1855t.m3903mP(this.userName)) {
            this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(C1318a.open_im_main_logo), null);
        } else {
            this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        if (aoO != null) {
            charSequence = aoO.field_nickname;
            if (C5046bo.isNullOrNil(charSequence)) {
                charSequence = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.userName).field_displayname;
            }
            this.jPp.setText(C44089j.m79293b((Context) this, charSequence, this.jPp.getTextSize()));
        } else {
            this.jPp.setVisibility(8);
        }
        this.qlv.setVisibility(8);
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C289374());
        setBackBtn(new C132045());
        AppMethodBeat.m2505o(127030);
    }

    /* renamed from: Ck */
    private void m67780Ck(int i) {
        int h;
        C1207m c32876g;
        AppMethodBeat.m2504i(127031);
        if (this.qlw) {
            h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(66561, null));
        } else {
            h = 0;
        }
        if (C1855t.m3903mP(this.userName)) {
            c32876g = new C32876g(this.userName);
            C1720g.m3540Rg().mo14541a(c32876g, 0);
        } else {
            C1207m c37508a = new C37508a(this.userName, h, i);
            C1720g.m3540Rg().mo14541a(c37508a, 0);
            c32876g = c37508a;
        }
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.e2g), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127019);
                C1720g.m3540Rg().mo14547c(c32876g);
                if (C1855t.m3901mN(SelfQRCodeUI.this.userName) || C17903f.m28109rc(SelfQRCodeUI.this.userName)) {
                    SelfQRCodeUI.this.finish();
                }
                AppMethodBeat.m2505o(127019);
            }
        });
        AppMethodBeat.m2505o(127031);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127032);
        C4990ab.m7416i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m instanceof C37508a) {
            final C37508a c37508a = (C37508a) c1207m;
            m67782a(i, i2, str, new C39663a() {
                public final byte[] ciy() {
                    return c37508a.fME;
                }

                public final String ciz() {
                    return c37508a.fMC;
                }

                public final String ciA() {
                    return c37508a.fMD;
                }
            });
            AppMethodBeat.m2505o(127032);
            return;
        }
        if (c1207m instanceof C32876g) {
            alj alj = (alj) ((C7472b) ((C32876g) c1207m).ftl).fsH.fsP;
            final byte[] bArr = alj.wqK.f1226wR;
            final String str2 = alj.vBP;
            m67782a(i, i2, str, new C39663a() {
                public final byte[] ciy() {
                    return bArr;
                }

                public final String ciz() {
                    return str2;
                }

                public final String ciA() {
                    return str2;
                }
            });
        }
        AppMethodBeat.m2505o(127032);
    }

    /* renamed from: a */
    private void m67782a(int i, int i2, String str, C39663a c39663a) {
        AppMethodBeat.m2504i(127033);
        if (C24824b.gkF.mo38861b(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(127033);
        } else if (i == 0 && i2 == 0) {
            this.qkE = c39663a.ciy();
            this.fru = C5056d.m7652bQ(this.qkE);
            if (C1855t.m3901mN(this.userName) || C17903f.m28109rc(this.userName)) {
                enableOptionMenu(true);
                String ciz = c39663a.ciz();
                if (!C5046bo.isNullOrNil(ciz)) {
                    ((TextView) findViewById(2131821050)).setText(ciz);
                }
            } else if (this.qlw) {
                String ciA = c39663a.ciA();
                TextView textView = (TextView) findViewById(2131827340);
                View view = (View) textView.getParent();
                if (C5046bo.isNullOrNil(ciA)) {
                    view.setVisibility(8);
                } else {
                    textView.setText(ciA);
                    view.setOnClickListener(new C132033());
                    view.setVisibility(0);
                }
            }
            this.qkD.setImageBitmap(this.fru);
            AppMethodBeat.m2505o(127033);
        } else {
            Toast.makeText(this, getString(C25738R.string.bym, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(127033);
        }
    }

    public static void cix() {
        AppMethodBeat.m2504i(127034);
        C7060h.pYm.mo8378a(219, 14, 1, true);
        AppMethodBeat.m2505o(127034);
    }

    static {
        AppMethodBeat.m2504i(127039);
        AppMethodBeat.m2505o(127039);
    }

    /* renamed from: b */
    static /* synthetic */ void m67784b(SelfQRCodeUI selfQRCodeUI) {
        AppMethodBeat.m2504i(127035);
        C36356d c36356d = new C36356d(selfQRCodeUI, 1, false);
        c36356d.rBl = new C396618();
        c36356d.rBm = new C396629();
        c36356d.cpD();
        AppMethodBeat.m2505o(127035);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3 A:{SYNTHETIC, Splitter:B:28:0x00b3} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3 A:{SYNTHETIC, Splitter:B:36:0x00c3} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    static /* synthetic */ void m67787e(SelfQRCodeUI selfQRCodeUI) {
        byte[] toByteArray;
        Throwable e;
        AppMethodBeat.m2504i(127036);
        if (C1855t.m3901mN(selfQRCodeUI.userName) || C17903f.m28109rc(selfQRCodeUI.userName)) {
            C7060h.pYm.mo8378a(219, 10, 1, true);
            Bitmap eA = C5056d.m7661eA(selfQRCodeUI.findViewById(2131827338));
            if (eA != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                eA.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
            } else {
                toByteArray = null;
            }
            if (toByteArray == null) {
                toByteArray = selfQRCodeUI.qkE;
            }
        } else {
            toByteArray = selfQRCodeUI.qkE;
        }
        if (toByteArray == null || toByteArray.length <= 0) {
            AppMethodBeat.m2505o(127036);
            return;
        }
        String str = C14987n.dly() + "mmqrcode" + System.currentTimeMillis() + ".png";
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(toByteArray);
                Toast.makeText(selfQRCodeUI, selfQRCodeUI.getString(C25738R.string.b3r, new Object[]{C14987n.dly()}), 1).show();
                C14987n.m23300a(str, selfQRCodeUI);
                try {
                    fileOutputStream.close();
                    AppMethodBeat.m2505o(127036);
                } catch (Exception e2) {
                    AppMethodBeat.m2505o(127036);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            AppMethodBeat.m2505o(127036);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(127036);
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    AppMethodBeat.m2505o(127036);
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(127036);
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(127036);
            throw e;
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m67788f(SelfQRCodeUI selfQRCodeUI) {
        AppMethodBeat.m2504i(127038);
        C30379h.m48453a((Context) selfQRCodeUI, true, selfQRCodeUI.getString(C25738R.string.dr9), selfQRCodeUI.getString(C25738R.string.dr_), selfQRCodeUI.getString(C25738R.string.dra), selfQRCodeUI.getString(C25738R.string.f9076or), new C3485610(), null);
        AppMethodBeat.m2505o(127038);
    }
}
