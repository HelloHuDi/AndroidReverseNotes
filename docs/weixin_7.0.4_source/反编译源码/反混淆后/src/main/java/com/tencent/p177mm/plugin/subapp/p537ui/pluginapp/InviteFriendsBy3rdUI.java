package com.tencent.p177mm.plugin.subapp.p537ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18665g;
import com.tencent.p177mm.modelmulti.C42214d;
import com.tencent.p177mm.p1528bb.C37508a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.p1094i.C15898a;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15905c;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15906a;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15907b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C35852b;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI */
public class InviteFriendsBy3rdUI extends MMPreference implements C1202f, C15906a, C15907b {
    private static int svo = 1;
    private static int svp = 2;
    private static int svq = 3;
    private static int svr = 4;
    private static int svs = 5;
    private static int svt = 0;
    private static int svu = 1;
    private ProgressDialog ehJ = null;
    private int fromScene;
    private ProgressBar mqj = null;
    private ProgressDialog nEK = null;
    private C15898a rCx = new C15898a();
    private boolean svA = false;
    private boolean svB = false;
    private int svv = 0;
    private Bitmap svw = null;
    private View svx;
    private ImageView svy = null;
    private EditText svz = null;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$11 */
    class C2235311 implements OnClickListener {
        C2235311() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$7 */
    class C223547 implements OnClickListener {
        C223547() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$10 */
    class C2940110 implements OnClickListener {
        C2940110() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$1 */
    class C294021 implements OnMenuItemClickListener {
        C294021() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25538);
            InviteFriendsBy3rdUI.this.finish();
            AppMethodBeat.m2505o(25538);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$4 */
    class C294034 implements OnClickListener {
        C294034() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25541);
            C25985d.m41467b(InviteFriendsBy3rdUI.this.mController.ylL, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.m2505o(25541);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$5 */
    class C294045 implements OnClickListener {
        C294045() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$6 */
    class C294056 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$6$1 */
        class C294061 implements OnCancelListener {
            C294061() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        C294056() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25542);
            InviteFriendsBy3rdUI inviteFriendsBy3rdUI = InviteFriendsBy3rdUI.this;
            Context context = InviteFriendsBy3rdUI.this.mController.ylL;
            InviteFriendsBy3rdUI.this.mController.ylL.getString(C25738R.string.f9238tz);
            inviteFriendsBy3rdUI.nEK = C30379h.m48458b(context, InviteFriendsBy3rdUI.this.mController.ylL.getString(C25738R.string.ey0), true, new C294061());
            InviteFriendsBy3rdUI.this.rCx.mo28144a(InviteFriendsBy3rdUI.this, InviteFriendsBy3rdUI.this.mController.ylL);
            AppMethodBeat.m2505o(25542);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public InviteFriendsBy3rdUI() {
        AppMethodBeat.m2504i(25545);
        AppMethodBeat.m2505o(25545);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8512ax;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25546);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.btf);
        this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("InviteFriendsInviteFlags"), 0);
        C40675h c40675h = this.yCw;
        if ((i & 2) <= 0) {
            c40675h.aqP("invite_friends_by_message");
        }
        if ((i & 1) <= 0) {
            c40675h.aqP("invite_friends_by_mail");
        }
        if ((i & 4) <= 0 || !InviteFriendsBy3rdUI.m46672aD(this.mController.ylL, "com.whatsapp")) {
            c40675h.aqP("invite_friends_by_whatsapp");
        }
        if ((i & 8) <= 0 || !C1853r.m3842YX()) {
            c40675h.aqP("invite_friends_by_facebook");
        }
        if ((i & 16) <= 0) {
            c40675h.aqP("invite_friends_by_twitter");
        }
        c40675h.notifyDataSetChanged();
        C9638aw.m17182Rg().mo14539a(1803, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1804, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(168, (C1202f) this);
        setBackBtn(new C294021());
        AppMethodBeat.m2505o(25546);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25547);
        C9638aw.m17182Rg().mo14546b(1803, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1804, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(168, (C1202f) this);
        if (this.svv == 0) {
            C7060h.pYm.mo8381e(14035, Integer.valueOf(this.svv), Integer.valueOf(svt), Integer.valueOf(this.fromScene));
        }
        super.onDestroy();
        AppMethodBeat.m2505o(25547);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(25548);
        if ("invite_friends_by_message".equals(preference.mKey)) {
            this.svv = svp;
            m46667Fr(2);
            AppMethodBeat.m2505o(25548);
            return true;
        } else if ("invite_friends_by_mail".equals(preference.mKey)) {
            this.svv = svo;
            m46667Fr(1);
            AppMethodBeat.m2505o(25548);
            return true;
        } else if ("invite_friends_by_whatsapp".equals(preference.mKey)) {
            this.svv = svq;
            m46667Fr(4);
            AppMethodBeat.m2505o(25548);
            return true;
        } else if ("invite_friends_by_facebook".equals(preference.mKey)) {
            this.svv = svr;
            if (C1853r.m3847Za()) {
                this.svB = true;
                m46667Fr(8);
            } else {
                C30379h.m48432a(this.mController.ylL, (int) C25738R.string.e6v, (int) C25738R.string.f9238tz, new C294034(), new C294045());
            }
            AppMethodBeat.m2505o(25548);
            return true;
        } else if ("invite_friends_by_twitter".equals(preference.mKey)) {
            this.svv = svs;
            if (this.rCx.dKv()) {
                this.svA = true;
                m46667Fr(16);
            } else {
                C30379h.m48432a(this.mController.ylL, (int) C25738R.string.ec9, (int) C25738R.string.f9238tz, new C294056(), new C223547());
            }
            AppMethodBeat.m2505o(25548);
            return true;
        } else {
            AppMethodBeat.m2505o(25548);
            return false;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25549);
        C4990ab.m7416i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!(i == 0 && i2 == 0)) {
            C7060h.pYm.mo8381e(14035, Integer.valueOf(this.svv), Integer.valueOf(svt), Integer.valueOf(this.fromScene));
        }
        if (c1207m.getType() == 1803) {
            if (i == 0 && i2 == 0) {
                String str2;
                String str3;
                Intent intent;
                C42214d c42214d = (C42214d) c1207m;
                if (C5046bo.isNullOrNil(c42214d.title)) {
                    str2 = null;
                } else {
                    str2 = c42214d.title;
                }
                c42214d = (C42214d) c1207m;
                if (C5046bo.isNullOrNil(c42214d.content)) {
                    str3 = null;
                } else {
                    str3 = c42214d.content;
                }
                String YA = C1853r.m3819YA();
                C9638aw.m17190ZK();
                String str4 = (String) C18628c.m29072Ry().get(6, null);
                if (C5046bo.isNullOrNil(YA)) {
                    YA = str4;
                }
                int i3 = ((C42214d) c1207m).fHT;
                if ((i3 & 1) > 0) {
                    if (C5046bo.isNullOrNil(str2)) {
                        str2 = String.format(getString(C25738R.string.cel), new Object[]{C1853r.m3820YB()});
                    }
                    if (C5046bo.isNullOrNil(str3)) {
                        str3 = String.format(getString(C25738R.string.cek), new Object[]{YA});
                    }
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.putExtra("android.intent.extra.SUBJECT", str2);
                    intent2.putExtra("android.intent.extra.TEXT", str3);
                    intent2.setType("plain/text");
                    startActivity(Intent.createChooser(intent2, getString(C25738R.string.cee)));
                    C7060h.pYm.mo8381e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
                }
                str4 = str3;
                if ((i3 & 2) > 0) {
                    if (C5046bo.isNullOrNil(str4)) {
                        str4 = String.format(getString(C25738R.string.cem), new Object[]{YA});
                    }
                    intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("sms_body", str4);
                    intent.setType("vnd.android-dir/mms-sms");
                    if (C5046bo.m7572k((Context) this, intent)) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, C25738R.string.e2a, 1).show();
                    }
                    C7060h.pYm.mo8381e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
                }
                if ((i3 & 4) > 0) {
                    if (C5046bo.isNullOrNil(str4)) {
                        str4 = String.format(getString(C25738R.string.cem), new Object[]{YA});
                    }
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str4);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                    C7060h.pYm.mo8381e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
                }
                if ((i3 & 8) > 0) {
                    if (C5046bo.isNullOrNil(str4)) {
                        if (C5046bo.isNullOrNil(C1853r.m3819YA())) {
                            str4 = getString(C25738R.string.cej);
                        } else {
                            str4 = String.format(getString(C25738R.string.cei), new Object[]{C1853r.m3819YA()});
                        }
                    }
                    str2 = getString(C25738R.string.ceb);
                    if (this.svB) {
                        m46674w(i3, str4, str2);
                        this.svB = false;
                    }
                }
                if ((i3 & 16) > 0) {
                    this.rCx.mo28143a((C15906a) this);
                    if (C5046bo.isNullOrNil(str4)) {
                        if (C5046bo.isNullOrNil(C1853r.m3819YA())) {
                            str4 = getString(C25738R.string.cej);
                        } else {
                            str4 = String.format(getString(C25738R.string.cei), new Object[]{C1853r.m3819YA()});
                        }
                    }
                    str2 = getString(C25738R.string.ceg);
                    if (this.svA) {
                        m46674w(i3, str4, str2);
                        this.svA = false;
                    }
                }
            } else {
                C30379h.m48467g(this.mController.ylL, C25738R.string.cn3, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(25549);
                return;
            }
        }
        if (c1207m.getType() == 1804) {
            if (i == 0 && i2 == 0) {
                C30379h.m48465bQ(this, getResources().getString(C25738R.string.ate));
                C7060h.pYm.mo8381e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
            } else {
                C30379h.m48467g(this.mController.ylL, C25738R.string.e3n, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(25549);
                return;
            }
        }
        if (c1207m.getType() == 168) {
            if (i != 0 || i2 != 0) {
                AppMethodBeat.m2505o(25549);
                return;
            } else if (this.svy != null) {
                if (this.mqj != null) {
                    this.mqj.setVisibility(8);
                }
                this.svy.setImageBitmap(InviteFriendsBy3rdUI.bIu());
            }
        }
        AppMethodBeat.m2505o(25549);
    }

    /* renamed from: Fr */
    private void m46667Fr(int i) {
        AppMethodBeat.m2504i(25550);
        final C1207m c42214d = new C42214d(i);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(25543);
                C9638aw.m17182Rg().mo14547c(c42214d);
                AppMethodBeat.m2505o(25543);
            }
        });
        C9638aw.m17182Rg().mo14541a(c42214d, 0);
        AppMethodBeat.m2505o(25550);
    }

    /* renamed from: aD */
    private static boolean m46672aD(Context context, String str) {
        AppMethodBeat.m2504i(25551);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25551);
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            AppMethodBeat.m2505o(25551);
            return true;
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(25551);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo28157a(C15905c c15905c) {
        AppMethodBeat.m2504i(25553);
        if (this.nEK != null) {
            this.nEK.cancel();
        }
        switch (c15905c) {
            case Finished:
                m46675xv(C25738R.string.ey2);
                AppMethodBeat.m2505o(25553);
                return;
            case Canceled:
                AppMethodBeat.m2505o(25553);
                return;
            case Failed:
                m46675xv(C25738R.string.ey1);
                break;
        }
        AppMethodBeat.m2505o(25553);
    }

    /* renamed from: b */
    public final void mo28156b(C15905c c15905c) {
    }

    private static Bitmap bIu() {
        AppMethodBeat.m2504i(25555);
        byte[] Pj = InviteFriendsBy3rdUI.m46668Pj(C1853r.m3846Yz());
        if (Pj == null) {
            AppMethodBeat.m2505o(25555);
            return null;
        }
        Bitmap bQ = C5056d.m7652bQ(Pj);
        AppMethodBeat.m2505o(25555);
        return bQ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A:{SYNTHETIC, Splitter:B:19:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f A:{SYNTHETIC, Splitter:B:13:0x004f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Pj */
    private static byte[] m46668Pj(String str) {
        Throwable e;
        AppMethodBeat.m2504i(25556);
        C9638aw.m17190ZK();
        String XW = C18628c.m29088XW();
        C9638aw.m17190ZK();
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(C15428j.m23711g(XW, C18628c.m29089XX(), "qr_", C1178g.m2591x(str.getBytes()), ".png"), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.m2505o(25556);
                return bArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(25556);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(25556);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            C4990ab.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.m2505o(25556);
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.m2505o(25556);
            throw e;
        }
    }

    private static void abr(String str) {
        AppMethodBeat.m2504i(25557);
        C9638aw.m17190ZK();
        C9638aw.m17182Rg().mo14541a(new C37508a(str, C5046bo.m7567h((Integer) C18628c.m29072Ry().get(66561, null))), 0);
        AppMethodBeat.m2505o(25557);
    }

    /* renamed from: xv */
    private void m46675xv(int i) {
        AppMethodBeat.m2504i(25552);
        C30379h.m48432a(this.mController.ylL, i, (int) C25738R.string.f9238tz, new C2940110(), new C2235311());
        AppMethodBeat.m2505o(25552);
    }

    /* renamed from: w */
    private void m46674w(final int i, final String str, String str2) {
        AppMethodBeat.m2504i(25554);
        this.svx = View.inflate(this.mController.ylL, 2130969183, null);
        this.svz = (EditText) this.svx.findViewById(2131822921);
        this.svy = (ImageView) this.svx.findViewById(2131822920);
        this.mqj = (ProgressBar) this.svx.findViewById(2131821605);
        ((View) this.svy.getParent()).setVisibility(8);
        this.svz.setText(str);
        this.svw = InviteFriendsBy3rdUI.bIu();
        if (this.svw == null) {
            InviteFriendsBy3rdUI.abr(C1853r.m3846Yz());
            ((ProgressBar) this.svx.findViewById(2131821605)).setVisibility(0);
        } else if (this.svy != null) {
            this.svy.setImageBitmap(this.svw);
        }
        C35844g.m58763a(this.mController, str2, this.svx, getResources().getString(C25738R.string.f9221tf), new C35852b() {
            /* renamed from: iw */
            public final void mo26134iw(boolean z) {
                AppMethodBeat.m2504i(25539);
                if (z) {
                    InviteFriendsBy3rdUI.m46671a(InviteFriendsBy3rdUI.this, i, InviteFriendsBy3rdUI.this.svz == null ? str : InviteFriendsBy3rdUI.this.svz.getText().toString());
                    AppMethodBeat.m2505o(25539);
                    return;
                }
                AppMethodBeat.m2505o(25539);
            }
        });
        AppMethodBeat.m2505o(25554);
    }

    /* renamed from: a */
    static /* synthetic */ void m46671a(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, int i, String str) {
        AppMethodBeat.m2504i(25558);
        final C1207m c18665g = new C18665g(i, str);
        inviteFriendsBy3rdUI.getString(C25738R.string.f9238tz);
        inviteFriendsBy3rdUI.ehJ = C30379h.m48458b((Context) inviteFriendsBy3rdUI, inviteFriendsBy3rdUI.getString(C25738R.string.f9222th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(25544);
                C9638aw.m17182Rg().mo14547c(c18665g);
                AppMethodBeat.m2505o(25544);
            }
        });
        C9638aw.m17182Rg().mo14541a(c18665g, 0);
        AppMethodBeat.m2505o(25558);
    }
}
