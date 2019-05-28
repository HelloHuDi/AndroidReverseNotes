package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C46035e;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C12256m;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28332k;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14918b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI */
public class IPCallUserProfileUI extends MMActivity {
    private String cMQ;
    private String cOz;
    private ImageView eks;
    private boolean nBq = false;
    private TextView nFZ;
    private TextView nGa;
    private LinearLayout nGb;
    private LinearLayout nGc;
    private TextView nGd;
    private TextView nGe;
    private TextView nGf;
    private TextView nGg;
    private TextView nGh;
    private Button nGi;
    private String nGj;
    private String nGk;
    private Bitmap nGl;
    private boolean nGm;
    private Cursor nGn = null;
    private boolean nGo = false;
    private C46035e nGp = new C46035e();

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$2 */
    class C123112 implements OnClickListener {
        C123112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22372);
            C7060h.pYm.mo8381e(12766, Integer.valueOf(4));
            C34382c.m56378PB(IPCallUserProfileUI.this.cMQ);
            Toast.makeText(IPCallUserProfileUI.this, C25738R.string.ch7, 0).show();
            AppMethodBeat.m2505o(22372);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$3 */
    class C123123 implements OnClickListener {
        C123123() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22373);
            Intent intent = new Intent(IPCallUserProfileUI.this, IPCallAllRecordUI.class);
            if (!C5046bo.isNullOrNil(IPCallUserProfileUI.this.cOz)) {
                intent.putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.this.cOz);
            } else if (!C5046bo.isNullOrNil(IPCallUserProfileUI.this.cMQ)) {
                intent.putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.this.cMQ);
            }
            intent.putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.this.nBq);
            IPCallUserProfileUI.this.startActivity(intent);
            AppMethodBeat.m2505o(22373);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$10 */
    class C2112710 implements OnClickListener {
        C2112710() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22382);
            try {
                C7060h.pYm.mo8381e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                Intent intent = new Intent("android.intent.action.INSERT");
                intent.setType("vnd.android.cursor.dir/contact");
                intent.putExtra("phone", IPCallUserProfileUI.this.cMQ);
                IPCallUserProfileUI.this.startActivity(intent);
                AppMethodBeat.m2505o(22382);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.IPCallUserProfileUI", e.getMessage());
                AppMethodBeat.m2505o(22382);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$11 */
    class C2834811 implements OnClickListener {
        C2834811() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22383);
            IPCallUserProfileUI.m85674a(IPCallUserProfileUI.this, IPCallUserProfileUI.this.cMQ);
            AppMethodBeat.m2505o(22383);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$1 */
    class C343941 implements OnMenuItemClickListener {
        C343941() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22371);
            IPCallUserProfileUI.this.finish();
            AppMethodBeat.m2505o(22371);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$8 */
    class C343968 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$8$2 */
        class C343972 implements C14918b {
            C343972() {
            }

            /* renamed from: vQ */
            public final boolean mo8211vQ(String str) {
                AppMethodBeat.m2504i(22379);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", IPCallUserProfileUI.this.nGk);
                intent.putExtra("Contact_Scene", 13);
                intent.putExtra(C5495b.yfT, str);
                C25985d.m41467b(IPCallUserProfileUI.this, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent);
                AppMethodBeat.m2505o(22379);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$8$1 */
        class C343981 implements C14917a {
            C343981() {
            }

            /* renamed from: a */
            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.m2504i(22378);
                C4990ab.m7411d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                if (z) {
                    IPCallUserProfileUI.this.nGi.setVisibility(8);
                    IPCallUserProfileUI.this.nGh.setVisibility(8);
                    IPCallUserProfileUI.m85676b(IPCallUserProfileUI.this, str);
                }
                AppMethodBeat.m2505o(22378);
            }
        }

        C343968() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22380);
            C7060h.pYm.mo8381e(12766, Integer.valueOf(3));
            C14916a c14916a = new C14916a(IPCallUserProfileUI.this, new C343981());
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(86));
            c14916a.vjI = new C343972();
            c14916a.mo27242b(IPCallUserProfileUI.this.nGk, linkedList, true);
            AppMethodBeat.m2505o(22380);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$9 */
    class C343999 implements OnClickListener {
        C343999() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22381);
            IPCallUserProfileUI.this.nGp.start();
            IPCallUserProfileUI.this.nGp.nyP = 1;
            IPCallUserProfileUI.this.nGp.nyQ = 5;
            IPCallUserProfileUI.this.nGp.finish();
            C7060h.pYm.mo8381e(12766, Integer.valueOf(3));
            Intent intent;
            if (C5046bo.isNullOrNil(IPCallUserProfileUI.this.cOz)) {
                if (!C5046bo.isNullOrNil(IPCallUserProfileUI.this.cMQ)) {
                    intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.this.cMQ));
                    intent.putExtra("sms_body", IPCallUserProfileUI.this.getString(C25738R.string.cgw, new Object[]{C1853r.m3850Zd().mo16706Oi()}));
                    IPCallUserProfileUI.this.startActivity(intent);
                }
                AppMethodBeat.m2505o(22381);
                return;
            }
            intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.m85670Pl(IPCallUserProfileUI.this.cOz)));
            intent.putExtra("sms_body", IPCallUserProfileUI.this.getString(C25738R.string.cgw, new Object[]{C1853r.m3850Zd().mo16706Oi()}));
            IPCallUserProfileUI.this.startActivity(intent);
            AppMethodBeat.m2505o(22381);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$6 */
    class C367796 implements C36073c {
        C367796() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(22376);
            c44273l.add((int) C25738R.string.f9082oy);
            AppMethodBeat.m2505o(22376);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallUserProfileUI() {
        AppMethodBeat.m2504i(22384);
        AppMethodBeat.m2505o(22384);
    }

    /* renamed from: Pl */
    static /* synthetic */ String m85670Pl(String str) {
        AppMethodBeat.m2504i(22398);
        String Pk = IPCallUserProfileUI.m85669Pk(str);
        AppMethodBeat.m2505o(22398);
        return Pk;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22385);
        super.onCreate(bundle);
        C7060h.pYm.mo8381e(12061, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        setBackBtn(new C343941());
        setMMTitle((int) C25738R.string.che);
        this.eks = (ImageView) findViewById(2131821183);
        this.nFZ = (TextView) findViewById(2131825103);
        this.nGa = (TextView) findViewById(2131825104);
        this.nGb = (LinearLayout) findViewById(2131825107);
        this.nGd = (TextView) findViewById(2131825110);
        this.nGf = (TextView) findViewById(2131825109);
        this.nGe = (TextView) findViewById(2131825108);
        this.nGc = (LinearLayout) findViewById(2131825106);
        this.nGg = (TextView) findViewById(2131825105);
        this.nGh = (TextView) findViewById(2131825112);
        this.nGi = (Button) findViewById(2131825111);
        this.cOz = getIntent().getStringExtra("IPCallProfileUI_contactid");
        this.nGj = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
        this.nGk = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
        this.cMQ = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
        this.nGo = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
        if (!C5046bo.isNullOrNil(this.cOz)) {
            this.nGl = C46041a.m85643aH(this, this.cOz);
            if (this.nGl != null) {
                this.eks.setImageBitmap(this.nGl);
            }
        }
        if (this.nGl == null && !C5046bo.isNullOrNil(this.nGk)) {
            this.nGl = C41730b.m73490a(this.nGk, false, -1);
            if (this.nGl != null) {
                this.eks.setImageBitmap(this.nGl);
            }
        }
        if (!C5046bo.isNullOrNil(this.nGj)) {
            this.nFZ.setText(this.nGj);
        } else if (!C5046bo.isNullOrNil(this.cMQ)) {
            this.nFZ.setText(C46041a.m85637Pw(this.cMQ));
        }
        if (C5046bo.isNullOrNil(this.nGk) || this.nGk.endsWith("@stranger")) {
            this.nGa.setVisibility(8);
        } else {
            this.nGa.setText(C44089j.m79292b((Context) this, getString(C25738R.string.chf, new Object[]{C1854s.m3866mJ(this.nGk)})));
        }
        if (!C5046bo.isNullOrNil(this.cOz)) {
            if (C35805b.m58714o(this, "android.permission.READ_CONTACTS")) {
                this.nGn = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{this.cOz}, null);
                this.nBq = this.nGn.getCount() <= 1;
            } else {
                C4990ab.m7412e("MicroMsg.IPCallUserProfileUI", "no contact permission");
                AppMethodBeat.m2505o(22385);
                return;
            }
        }
        bIx();
        this.nGf.setVisibility(8);
        this.nGe.setVisibility(8);
        this.nGd.setVisibility(8);
        this.nGi.setVisibility(8);
        this.nGh.setVisibility(8);
        if (!C5046bo.isNullOrNil(this.nGk) && !C5046bo.isNullOrNil(this.nGj)) {
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.nGk);
            if (!(aoO == null || C7486a.m12942jh(aoO.field_type))) {
                this.nGi.setOnClickListener(new C343968());
                this.nGi.setText(C25738R.string.ch8);
                this.nGi.setVisibility(0);
            }
        } else if (!C5046bo.isNullOrNil(this.cOz) && !C5046bo.isNullOrNil(this.nGj)) {
            bIw();
            this.nGi.setText(C25738R.string.chc);
        } else if (!C5046bo.isNullOrNil(this.cMQ)) {
            this.nGe.setVisibility(0);
            this.nGf.setVisibility(0);
            Context context = C4996ah.getContext();
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/contact");
            intent.putExtra("phone", "10086");
            if (C5046bo.m7572k(context, intent)) {
                this.nGd.setVisibility(0);
            }
            this.nGd.setOnClickListener(new C2112710());
            this.nGe.setOnClickListener(new C2834811());
            this.nGf.setOnClickListener(new C123112());
            bIw();
            this.nGi.setText(C25738R.string.chc);
        }
        bIv();
        AppMethodBeat.m2505o(22385);
    }

    public final int getLayoutId() {
        return 2130969891;
    }

    private void bIv() {
        int i = 0;
        AppMethodBeat.m2504i(22386);
        ArrayList arrayList = new ArrayList();
        if (this.nGn == null || this.nGn.getCount() <= 0) {
            this.nGb.setVisibility(8);
            AppMethodBeat.m2505o(22386);
            return;
        }
        try {
            if (this.nGn.moveToFirst()) {
                while (!this.nGn.isAfterLast()) {
                    i++;
                    String string = this.nGn.getString(this.nGn.getColumnIndex("data1"));
                    int i2 = this.nGn.getInt(this.nGn.getColumnIndex("data2"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                        if (i == this.nGn.getCount()) {
                            m85682o(string, i2, false);
                        } else {
                            m85682o(string, i2, true);
                        }
                    }
                    this.nGn.moveToNext();
                }
            }
            this.nGn.close();
            AppMethodBeat.m2505o(22386);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", e.getMessage());
            this.nGn.close();
            AppMethodBeat.m2505o(22386);
        } catch (Throwable th) {
            this.nGn.close();
            AppMethodBeat.m2505o(22386);
            throw th;
        }
    }

    /* renamed from: o */
    private void m85682o(final String str, int i, boolean z) {
        AppMethodBeat.m2504i(22387);
        View inflate = LayoutInflater.from(this).inflate(2130970412, this.nGb, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131826665);
        if (z) {
            linearLayout.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.a_q));
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        TextView textView = (TextView) inflate.findViewById(2131826666);
        final TextView textView2 = (TextView) inflate.findViewById(2131825079);
        textView2.setText(C46041a.m85637Pw(C34382c.m56377PA(str)));
        textView.setText(C46041a.m85648xx(i));
        inflate.setClickable(true);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(22374);
                IPCallUserProfileUI.m85674a(IPCallUserProfileUI.this, str);
                AppMethodBeat.m2505o(22374);
            }
        });
        inflate.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(22375);
                IPCallUserProfileUI.m85673a(IPCallUserProfileUI.this, textView2);
                AppMethodBeat.m2505o(22375);
                return true;
            }
        });
        this.nGb.addView(inflate);
        AppMethodBeat.m2505o(22387);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Pk */
    private static String m85669Pk(String str) {
        Exception e;
        AppMethodBeat.m2504i(22388);
        String str2 = "";
        if (C35805b.m58714o(C4996ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = C4996ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                AppMethodBeat.m2505o(22388);
                return null;
            }
            String str3;
            try {
                if (query.moveToFirst()) {
                    str3 = str2;
                    while (!query.isAfterLast()) {
                        try {
                            str3 = str3 + query.getString(query.getColumnIndex("data1")) + ",";
                            query.moveToNext();
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.IPCallUserProfileUI", "extractAddressItemFromCursor, error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                                query.close();
                                if (str3.lastIndexOf(",") >= 0) {
                                }
                                AppMethodBeat.m2505o(22388);
                                return str3;
                            } catch (Throwable th) {
                                query.close();
                                AppMethodBeat.m2505o(22388);
                            }
                        }
                    }
                } else {
                    str3 = str2;
                }
                query.close();
            } catch (Exception e3) {
                e = e3;
                str3 = str2;
            }
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            AppMethodBeat.m2505o(22388);
            return str3;
        }
        C4990ab.m7412e("MicroMsg.IPCallUserProfileUI", "no contact permission");
        AppMethodBeat.m2505o(22388);
        return null;
    }

    private void bIw() {
        AppMethodBeat.m2504i(22389);
        this.nGi.setOnClickListener(new C343999());
        AppMethodBeat.m2505o(22389);
    }

    private void bIx() {
        Cursor OU;
        AppMethodBeat.m2504i(22390);
        if (!this.nGo) {
            this.nGc.setVisibility(8);
            this.nGg.setVisibility(8);
        }
        if (C5046bo.isNullOrNil(this.cOz)) {
            OU = C21088i.bHx().mo46243OU(this.cMQ);
        } else {
            OU = C12256m.m20184OW(this.cOz);
        }
        if (OU == null || OU.getCount() <= 0) {
            this.nGc.setVisibility(8);
            this.nGg.setVisibility(8);
            AppMethodBeat.m2505o(22390);
            return;
        }
        try {
            if (OU.moveToFirst()) {
                int i = 0;
                while (!OU.isAfterLast()) {
                    boolean z;
                    C28332k c28332k = new C28332k();
                    c28332k.mo8995d(OU);
                    i++;
                    if (i >= 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m85672a(c28332k, z, OU.getCount());
                    if (z) {
                        break;
                    }
                    OU.moveToNext();
                }
                if (i <= 0) {
                    this.nGc.setVisibility(8);
                } else if (OU.getCount() >= 4) {
                    bIy();
                }
            }
            OU.close();
            AppMethodBeat.m2505o(22390);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", e.getMessage());
            OU.close();
            AppMethodBeat.m2505o(22390);
        } catch (Throwable th) {
            OU.close();
            AppMethodBeat.m2505o(22390);
            throw th;
        }
    }

    /* renamed from: a */
    private void m85672a(C28332k c28332k, boolean z, int i) {
        AppMethodBeat.m2504i(22391);
        View inflate = LayoutInflater.from(this).inflate(2130970414, this.nGc, false);
        TextView textView = (TextView) inflate.findViewById(2131825141);
        TextView textView2 = (TextView) inflate.findViewById(2131825143);
        ((TextView) inflate.findViewById(2131825142)).setText(C46041a.m85637Pw(c28332k.field_phonenumber));
        if (c28332k.field_duration > 0) {
            textView2.setText(C34382c.m56388jc(c28332k.field_duration));
        } else {
            textView2.setText(C34382c.m56389xy(c28332k.field_status));
        }
        textView.setText(C34382c.m56384iY(c28332k.field_calltime));
        if (z) {
            inflate.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.f6972x_));
            int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9692cb);
            inflate.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        if (1 == i) {
            LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
            layoutParams.height = C1338a.m2856al(this.mController.ylL, C25738R.dimen.a76);
            inflate.setLayoutParams(layoutParams);
        }
        this.nGc.addView(inflate);
        AppMethodBeat.m2505o(22391);
    }

    private void bIy() {
        AppMethodBeat.m2504i(22392);
        View inflate = LayoutInflater.from(this).inflate(2130970415, this.nGc, false);
        this.nGc.addView(inflate);
        inflate.setOnClickListener(new C123123());
        AppMethodBeat.m2505o(22392);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22393);
        super.onResume();
        if (this.nGm) {
            this.nGm = false;
            this.nGc.removeAllViews();
            bIx();
        }
        AppMethodBeat.m2505o(22393);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22394);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(22394);
    }

    /* renamed from: b */
    static /* synthetic */ void m85676b(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        AppMethodBeat.m2504i(22397);
        if (!(C5046bo.isNullOrNil(iPCallUserProfileUI.cOz) || C5046bo.isNullOrNil(str) || str.endsWith("@stranger"))) {
            C21083c OQ = C21088i.bHw().mo36404OQ(iPCallUserProfileUI.cOz);
            if (OQ.xDa > 0) {
                OQ.field_wechatUsername = str;
                C21088i.bHw().mo16757a(OQ.xDa, (C4925c) OQ);
            }
        }
        AppMethodBeat.m2505o(22397);
    }
}
