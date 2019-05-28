package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26203mx;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C40670b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38036o;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6721h.C2008a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C9906g.C9907a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46508c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.InviteFriendUI */
public class InviteFriendUI extends MMActivity implements C8915a {
    private ImageView gvq;
    private String gxo;
    private int gxp;
    private String gxq;
    private String gxr;
    private String gxs;
    private Button gxt;
    private int gxu;
    private int gxv;
    private String gxw = null;
    private String gxx = null;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.InviteFriendUI$1 */
    class C19941 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.InviteFriendUI$1$5 */
        class C19975 implements C9907a {
            C19975() {
            }

            /* renamed from: e */
            public final void mo5748e(boolean z, String str) {
                AppMethodBeat.m2504i(108575);
                if (z) {
                    InviteFriendUI.this.finish();
                }
                AppMethodBeat.m2505o(108575);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.InviteFriendUI$1$6 */
        class C19986 implements C2008a {
            C19986() {
            }

            /* renamed from: dn */
            public final void mo5749dn(boolean z) {
                AppMethodBeat.m2504i(108576);
                if (z) {
                    ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60779aj(InviteFriendUI.this.gxs, 1);
                }
                AppMethodBeat.m2505o(108576);
            }
        }

        C19941() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108577);
            final String string;
            switch (InviteFriendUI.this.gxp) {
                case 0:
                    new C9906g(InviteFriendUI.this, new C19975()).mo21262m(new int[]{C1183p.m2611cB(InviteFriendUI.this.gxo)});
                    AppMethodBeat.m2505o(108577);
                    return;
                case 1:
                    String str = (String) C1720g.m3536RP().mo5239Ry().get(42, (Object) "");
                    if (str == null || str.length() == 0) {
                        str = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
                    }
                    string = InviteFriendUI.this.getString(C25738R.string.ceq, new Object[]{str});
                    final Uri parse = Uri.parse("smsto:" + InviteFriendUI.this.gxo);
                    Intent intent = new Intent("android.intent.action.SENDTO", parse);
                    intent.putExtra("sms_body", string);
                    final PackageManager packageManager = InviteFriendUI.this.getPackageManager();
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                    final HashMap hashMap = new HashMap();
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                            hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                        }
                    }
                    if (hashMap.size() == 1) {
                        Iterator it = hashMap.keySet().iterator();
                        if (it.hasNext()) {
                            str = (String) it.next();
                            Intent intent2 = new Intent();
                            intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                            intent2.setAction("android.intent.action.SENDTO");
                            intent2.setData(parse);
                            intent2.putExtra("sms_body", string);
                            InviteFriendUI.this.startActivity(intent2);
                            InviteFriendUI.m42449c(InviteFriendUI.this);
                        }
                        AppMethodBeat.m2505o(108577);
                        return;
                    } else if (hashMap.size() > 1) {
                        C46696j c46696j = new C46696j(InviteFriendUI.this);
                        c46696j.zFT = new C36072a() {
                            /* renamed from: a */
                            public final void mo5750a(ImageView imageView, MenuItem menuItem) {
                                AppMethodBeat.m2504i(108571);
                                imageView.setImageDrawable(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadIcon(packageManager));
                                AppMethodBeat.m2505o(108571);
                            }
                        };
                        c46696j.zFU = new C40670b() {
                            /* renamed from: a */
                            public final void mo5751a(TextView textView, MenuItem menuItem) {
                                AppMethodBeat.m2504i(108572);
                                CharSequence loadLabel = ((ResolveInfo) hashMap.get(menuItem.getTitle())).loadLabel(packageManager);
                                if (loadLabel != null) {
                                    textView.setText(loadLabel.toString());
                                    AppMethodBeat.m2505o(108572);
                                    return;
                                }
                                textView.setText("");
                                AppMethodBeat.m2505o(108572);
                            }
                        };
                        c46696j.rBl = new C36073c() {
                            /* renamed from: a */
                            public final void mo5746a(C44273l c44273l) {
                                AppMethodBeat.m2504i(108573);
                                for (CharSequence add : hashMap.keySet()) {
                                    c44273l.add(add);
                                }
                                AppMethodBeat.m2505o(108573);
                            }
                        };
                        c46696j.rBm = new C5279d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.m2504i(108574);
                                String str = menuItem.getTitle();
                                Intent intent = new Intent();
                                intent.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                intent.setAction("android.intent.action.SENDTO");
                                intent.setData(parse);
                                intent.putExtra("sms_body", string);
                                InviteFriendUI.this.startActivity(intent);
                                AppMethodBeat.m2505o(108574);
                            }
                        };
                        c46696j.cuu();
                        InviteFriendUI.m42449c(InviteFriendUI.this);
                        AppMethodBeat.m2505o(108577);
                        return;
                    } else {
                        Toast.makeText(InviteFriendUI.this, C25738R.string.e2a, 1).show();
                        AppMethodBeat.m2505o(108577);
                        return;
                    }
                case 2:
                    C1202f c6721h = new C6721h(InviteFriendUI.this, new C19986());
                    string = InviteFriendUI.this.gxr;
                    String b = InviteFriendUI.this.gxo;
                    C1720g.m3540Rg().mo14539a(489, c6721h);
                    Cursor wg = ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60785wg(string);
                    if (wg == null || wg.getCount() <= 1) {
                        c6721h.mo14952wm(b);
                    } else {
                        c6721h.mo14951e(wg);
                    }
                    if (wg != null) {
                        wg.close();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(108577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.InviteFriendUI$2 */
    class C20012 implements OnClickListener {
        C20012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108578);
            C26203mx c26203mx = new C26203mx();
            c26203mx.cIO.opType = 0;
            c26203mx.cIO.cIQ = InviteFriendUI.this.gxo + "@qqim";
            c26203mx.cIO.cIR = InviteFriendUI.this.gxq;
            C4879a.xxA.mo10055m(c26203mx);
            if (c26203mx.cIP.cvi) {
                C24679a.gkE.mo38915d(new Intent().putExtra("Chat_User", InviteFriendUI.this.gxo + "@qqim"), InviteFriendUI.this);
            }
            InviteFriendUI.this.finish();
            AppMethodBeat.m2505o(108578);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.InviteFriendUI$3 */
    class C20023 implements OnMenuItemClickListener {
        C20023() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(108579);
            InviteFriendUI.this.finish();
            AppMethodBeat.m2505o(108579);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(108580);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.cea);
        Intent intent = getIntent();
        this.gxp = intent.getIntExtra("friend_type", -1);
        this.gxq = intent.getStringExtra("friend_nick");
        this.gxo = intent.getStringExtra("friend_num");
        this.gxr = intent.getStringExtra("friend_googleID");
        this.gxs = intent.getStringExtra("friend_googleItemID");
        this.gxo = C5046bo.nullAsNil(this.gxo);
        this.gxw = intent.getStringExtra("friend_linkedInID");
        this.gxx = intent.getStringExtra("friend_linkedInPicUrl");
        initView();
        this.gxu = intent.getIntExtra("search_kvstat_scene", 0);
        this.gxv = intent.getIntExtra("search_kvstat_position", 0);
        AppMethodBeat.m2505o(108580);
    }

    public void onPause() {
        AppMethodBeat.m2504i(108581);
        super.onPause();
        C17884o.acd().mo67503e(this);
        AppMethodBeat.m2505o(108581);
    }

    public void onResume() {
        AppMethodBeat.m2504i(108582);
        super.onResume();
        C17884o.acd().mo67502d(this);
        AppMethodBeat.m2505o(108582);
    }

    public final int getLayoutId() {
        return 2130969868;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(108583);
        super.onDestroy();
        AppMethodBeat.m2505o(108583);
    }

    public final void initView() {
        Bitmap b;
        AppMethodBeat.m2504i(108584);
        this.gvq = (ImageView) findViewById(2131823851);
        TextView textView = (TextView) findViewById(2131823852);
        TextView textView2 = (TextView) findViewById(2131825018);
        TextView textView3 = (TextView) findViewById(2131823853);
        this.gxt = (Button) findViewById(2131823854);
        Button button = (Button) findViewById(2131825020);
        textView.setText(this.gxq);
        textView3.setText(getString(C25738R.string.ce9, new Object[]{this.gxq}));
        if (this.gxp == 1) {
            this.gvq.setBackgroundDrawable(C1338a.m2864g(this, C1318a.default_mobile_avatar));
            textView2.setText(getString(C25738R.string.f9122q5) + this.gxo);
            String x = C1178g.m2591x(this.gxo.getBytes());
            if (C1720g.m3536RP().isSDCardAvailable()) {
                C18817a vW = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34092vW(x);
                if (vW != null) {
                    b = C38033l.m64348b(vW.apz(), this);
                } else {
                    b = null;
                }
            } else {
                b = C17884o.acd().mo67501bU(C4996ah.getContext());
            }
            if (b != null) {
                this.gvq.setImageBitmap(b);
            } else {
                this.gvq.setImageDrawable(C1338a.m2864g(this, C1318a.default_mobile_avatar));
            }
        }
        if (this.gxp == 0) {
            this.gvq.setBackgroundDrawable(C1338a.m2864g(this, C1318a.default_qq_avatar));
            textView2.setText(getString(C25738R.string.f9125q_) + this.gxo);
            long cB = (long) C1183p.m2611cB(this.gxo);
            b = null;
            if (cB != 0) {
                b = C41730b.m73496fr(cB);
            }
            if (b == null) {
                this.gvq.setImageDrawable(C1338a.m2864g(this, C1318a.default_qq_avatar));
            } else {
                this.gvq.setImageBitmap(b);
            }
            button.setVisibility(0);
        }
        if (this.gxp == 2) {
            Bitmap pP;
            this.gxt.setText(C25738R.string.c8r);
            this.gvq.setBackgroundDrawable(C1338a.m2864g(this, C25738R.drawable.ad4));
            textView2.setText(getString(C25738R.string.f9115px) + this.gxo);
            if (C1720g.m3536RP().isSDCardAvailable()) {
                pP = C41730b.m73497pP(this.gxr);
            } else {
                pP = C17884o.acd().mo67501bU(C4996ah.getContext());
            }
            if (pP != null) {
                this.gvq.setImageBitmap(pP);
            } else {
                this.gvq.setImageDrawable(C1338a.m2864g(this, C25738R.drawable.ad4));
            }
            if (TextUtils.isEmpty(this.gxq)) {
                textView.setText(C5046bo.anu(this.gxo));
                textView3.setText(getString(C25738R.string.ce9, new Object[]{C5046bo.anu(this.gxo)}));
            }
        }
        if (this.gxp == 3) {
            this.gxt.setText(C25738R.string.ce8);
            Bitmap a = C18764x.m29325a(new C46508c(this.gxx, this.gxx));
            if (a != null) {
                this.gvq.setImageBitmap(a);
            } else {
                this.gvq.setImageResource(C1318a.default_avatar);
            }
            button.setVisibility(8);
        }
        this.gxt.setOnClickListener(new C19941());
        button.setOnClickListener(new C20012());
        setBackBtn(new C20023());
        AppMethodBeat.m2505o(108584);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(108585);
        if (this.gxo == null || this.gxo.equals("")) {
            AppMethodBeat.m2505o(108585);
            return;
        }
        long pU = C41730b.m73502pU(str);
        if (pU > 0 && this.gxo.equals(String.valueOf(pU)) && this.gxp == 0) {
            this.gvq.setImageBitmap(C41730b.m73490a(str, false, -1));
        }
        AppMethodBeat.m2505o(108585);
    }

    /* renamed from: c */
    static /* synthetic */ void m42449c(InviteFriendUI inviteFriendUI) {
        AppMethodBeat.m2504i(108586);
        if (inviteFriendUI.gxu > 0 && inviteFriendUI.gxv > 0) {
            C7060h.pYm.mo8381e(10991, Integer.valueOf(inviteFriendUI.gxu), Integer.valueOf(7), Integer.valueOf(inviteFriendUI.gxv));
        }
        AppMethodBeat.m2505o(108586);
    }
}
