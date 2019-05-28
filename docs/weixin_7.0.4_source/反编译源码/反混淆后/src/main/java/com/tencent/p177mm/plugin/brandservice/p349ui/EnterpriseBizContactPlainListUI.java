package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C36692b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.applet.C36043b.C23577b;
import com.tencent.p177mm.p612ui.applet.C36043b.C5234a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t.C23281a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C30201lk;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI */
public class EnterpriseBizContactPlainListUI extends MMActivity {
    private String fuO;
    private ListView gGW;
    private C38686a jMi;
    private long jMj;
    private OnItemClickListener jMk;
    private int scene;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$2 */
    class C26922 implements OnMenuItemClickListener {
        C26922() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13981);
            EnterpriseBizContactPlainListUI.this.aqX();
            EnterpriseBizContactPlainListUI.this.finish();
            AppMethodBeat.m2505o(13981);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$1 */
    class C200371 implements OnItemClickListener {
        C200371() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(13980);
            C4990ab.m7417i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", Integer.valueOf(i));
            EnterpriseBizContactPlainListUI.m84577a(EnterpriseBizContactPlainListUI.this, i);
            AppMethodBeat.m2505o(13980);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$3 */
    class C337253 implements OnClickListener {
        C337253() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13982);
            C4978c.m7375a(EnterpriseBizContactPlainListUI.this.gGW);
            AppMethodBeat.m2505o(13982);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$a */
    class C38686a extends C46692p<C30201lk> implements C4937b {
        C36043b gvm = new C36043b(new C111961());
        private C23577b gvn = null;

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$a$1 */
        class C111961 implements C5234a {
            C111961() {
            }

            /* renamed from: wd */
            public final Bitmap mo10738wd(String str) {
                AppMethodBeat.m2504i(13985);
                Bitmap a = C41730b.m73490a(str, false, -1);
                AppMethodBeat.m2505o(13985);
                return a;
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$a$3 */
        class C386843 implements C23577b {
            C386843() {
            }

            /* renamed from: mW */
            public final String mo11090mW(int i) {
                AppMethodBeat.m2504i(13987);
                if (i < 0 || i >= C38686a.this.getCount()) {
                    C4990ab.m7412e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
                    AppMethodBeat.m2505o(13987);
                    return null;
                }
                C30201lk c30201lk = (C30201lk) C38686a.this.getItem(i);
                if (c30201lk == null) {
                    AppMethodBeat.m2505o(13987);
                    return null;
                }
                String str = c30201lk.userName;
                AppMethodBeat.m2505o(13987);
                return str;
            }

            public final int apO() {
                AppMethodBeat.m2504i(13988);
                int count = C38686a.this.getCount();
                AppMethodBeat.m2505o(13988);
                return count;
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$a$a */
        class C38685a {
            TextView gtG;
            ImageView gvq;

            C38685a() {
            }

            public final void clear() {
                AppMethodBeat.m2504i(13989);
                if (this.gvq != null) {
                    this.gvq.setImageDrawable(null);
                    this.gvq.setVisibility(8);
                }
                if (this.gtG != null) {
                    this.gtG.setText("");
                    this.gtG.setVisibility(8);
                }
                AppMethodBeat.m2505o(13989);
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$a$2 */
        class C386872 implements Runnable {
            C386872() {
            }

            public final void run() {
                AppMethodBeat.m2504i(13986);
                C38686a.this.mo6870KD();
                TextView textView = (TextView) EnterpriseBizContactPlainListUI.this.findViewById(2131823618);
                if (!(EnterpriseBizContactPlainListUI.this.gGW == null || textView == null)) {
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(EnterpriseBizContactPlainListUI.this.fuO);
                    if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                        EnterpriseBizContactPlainListUI.this.gGW.setVisibility(8);
                        textView.setVisibility(0);
                    } else if (EnterpriseBizContactPlainListUI.this.jMi.getCount() <= 0) {
                        EnterpriseBizContactPlainListUI.this.gGW.setVisibility(8);
                        textView.setVisibility(0);
                    } else {
                        EnterpriseBizContactPlainListUI.this.gGW.setVisibility(0);
                        textView.setVisibility(8);
                        EnterpriseBizContactPlainListUI.this.gGW.setAdapter(EnterpriseBizContactPlainListUI.this.jMi);
                        EnterpriseBizContactPlainListUI.this.gGW.setOnItemClickListener(EnterpriseBizContactPlainListUI.this.jMk);
                    }
                }
                C38686a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(13986);
            }
        }

        public C38686a(Context context) {
            super(context, new C30201lk());
            AppMethodBeat.m2504i(13990);
            mo6869KC();
            AppMethodBeat.m2505o(13990);
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(13991);
            C4990ab.m7416i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
            C5004al.m7441d(new C386872());
            AppMethodBeat.m2505o(13991);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C38685a c38685a;
            AppMethodBeat.m2504i(13992);
            if (this.gvn == null) {
                this.gvn = new C386843();
            }
            if (this.gvm != null) {
                this.gvm.mo56803a(i, this.gvn);
            }
            if (view == null) {
                c38685a = new C38685a();
                view = View.inflate(this.context, 2130969394, null);
                c38685a.gvq = (ImageView) view.findViewById(2131823615);
                c38685a.gtG = (TextView) view.findViewById(2131823616);
                view.setTag(c38685a);
            } else {
                c38685a = (C38685a) view.getTag();
            }
            C30201lk c30201lk = (C30201lk) getItem(i);
            if (c30201lk == null) {
                c38685a.clear();
                AppMethodBeat.m2505o(13992);
            } else {
                c38685a.clear();
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                view.setBackgroundDrawable(C1338a.m2864g(this.context, C25738R.drawable.f6623k5));
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                c38685a.gtG.setText(C44089j.m79293b(this.context, C5046bo.nullAsNil(c30201lk.ehM.mo16706Oi()), c38685a.gtG.getTextSize()));
                c38685a.gtG.setVisibility(0);
                c38685a.gvq.setVisibility(0);
                if (C5046bo.isNullOrNil(c30201lk.ehM.field_username)) {
                    c38685a.gvq.setImageDrawable(null);
                } else {
                    C40460b.m69434b(c38685a.gvq, c30201lk.ehM.field_username);
                }
                AppMethodBeat.m2505o(13992);
            }
            return view;
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(138967);
            mo6869KC();
            AppMethodBeat.m2505o(138967);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(13994);
            if (C1720g.m3531RK()) {
                bIf();
                Cursor cursor = null;
                switch (EnterpriseBizContactPlainListUI.this.scene) {
                    case 1:
                        C41747z.aeR();
                        cursor = C25764e.m40942V(EnterpriseBizContactPlainListUI.this.fuO, 25);
                        break;
                    case 2:
                        C41747z.aeR();
                        cursor = C25764e.m40950qR(EnterpriseBizContactPlainListUI.this.fuO);
                        break;
                    case 3:
                        C41747z.aeR();
                        cursor = C25764e.m40942V(EnterpriseBizContactPlainListUI.this.fuO, 128);
                        break;
                    case 4:
                        C16527d qX = C17903f.m28104qX(EnterpriseBizContactPlainListUI.this.fuO);
                        if (!(qX == null || qX.field_enterpriseFather == null)) {
                            cursor = C41747z.aeR().mo43730qQ(qX.field_enterpriseFather);
                            break;
                        }
                    default:
                        C41747z.aeR();
                        cursor = C25764e.m40941F(EnterpriseBizContactPlainListUI.this.fuO, true);
                        break;
                }
                setCursor(cursor);
                AppMethodBeat.m2505o(13994);
                return;
            }
            C4990ab.m7412e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
            AppMethodBeat.m2505o(13994);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13996);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.fuO = getIntent().getStringExtra("enterprise_biz_name");
        this.jMj = getIntent().getLongExtra("biz_chat_chat_id", -1);
        C4990ab.m7417i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", this.fuO);
        initView();
        C41747z.aeR().mo10116c(this.jMi);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this.jMi);
        AppMethodBeat.m2505o(13996);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13997);
        this.gGW = (ListView) findViewById(2131823617);
        if (this.jMi == null) {
            this.jMi = new C38686a(this);
            this.jMk = new C200371();
        }
        C4990ab.m7417i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", Integer.valueOf(this.jMi.getCount()));
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.fuO);
        if (this.scene == 2) {
            setMMTitle((int) C25738R.string.bdp);
        } else if (aoO != null) {
            setMMTitle(aoO.mo16706Oi());
        }
        if (aoO == null || !C7486a.m12942jh(aoO.field_type) || this.jMi.getCount() <= 0) {
            this.gGW.setVisibility(8);
            TextView textView = (TextView) findViewById(2131823618);
            textView.setText(C25738R.string.bdv);
            textView.setVisibility(0);
        } else {
            this.gGW.setVisibility(0);
            this.gGW.setAdapter(this.jMi);
            this.gGW.setOnItemClickListener(this.jMk);
        }
        setBackBtn(new C26922());
        C337253 c337253 = new C337253();
        AppMethodBeat.m2505o(13997);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13998);
        super.onResume();
        if (C1855t.m3912mY(this.fuO)) {
            AppMethodBeat.m2505o(13998);
            return;
        }
        C4990ab.m7413e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", this.fuO);
        finish();
        AppMethodBeat.m2505o(13998);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13999);
        super.onPause();
        AppMethodBeat.m2505o(13999);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(14000);
        C41747z.aeR().mo10117d(this.jMi);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this.jMi);
        this.jMi.bIf();
        C38686a c38686a = this.jMi;
        if (c38686a.gvm != null) {
            c38686a.gvm.detach();
            c38686a.gvm = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(14000);
    }

    public final int getLayoutId() {
        return 2130969396;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(14001);
        super.onActivityResult(i, i2, intent);
        if (this.scene == 4) {
            finish();
        }
        AppMethodBeat.m2505o(14001);
    }

    /* renamed from: a */
    static /* synthetic */ void m84577a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, int i) {
        AppMethodBeat.m2504i(14002);
        final C30201lk c30201lk = (C30201lk) enterpriseBizContactPlainListUI.jMi.getItem(i);
        if (c30201lk == null || c30201lk.userName == null) {
            C4990ab.m7412e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "item is null.");
            AppMethodBeat.m2505o(14002);
        } else if (enterpriseBizContactPlainListUI.scene == 1) {
            ((C40437i) C1720g.m3528K(C40437i.class)).mo56643a(enterpriseBizContactPlainListUI.mController, c30201lk.userName, enterpriseBizContactPlainListUI.getString(C25738R.string.dr7), C1854s.m3865mI(c30201lk.userName), null, enterpriseBizContactPlainListUI.getString(C25738R.string.f9221tf), new C30111a() {
                /* renamed from: a */
                public final void mo6399a(boolean z, String str, int i) {
                    AppMethodBeat.m2504i(13983);
                    if (z) {
                        Intent intent = EnterpriseBizContactPlainListUI.this.getIntent();
                        intent.putExtra("enterprise_biz_name", c30201lk.userName);
                        EnterpriseBizContactPlainListUI.this.setResult(-1, intent);
                        EnterpriseBizContactPlainListUI.this.finish();
                    }
                    AppMethodBeat.m2505o(13983);
                }
            });
            AppMethodBeat.m2505o(14002);
        } else if (enterpriseBizContactPlainListUI.scene == 2) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", c30201lk.userName);
            C33720b.gkE.mo38912c(intent, enterpriseBizContactPlainListUI);
            AppMethodBeat.m2505o(14002);
        } else if (enterpriseBizContactPlainListUI.scene == 3) {
            HashMap hashMap = (HashMap) enterpriseBizContactPlainListUI.getIntent().getSerializableExtra("enterprise_extra_params");
            String str = (String) hashMap.get("img_url");
            String str2 = (String) hashMap.get("desc");
            String str3 = (String) hashMap.get("title");
            final String str4 = c30201lk.userName;
            C23281a.vlq.mo30687a(enterpriseBizContactPlainListUI.mController, str3, str, str2, false, enterpriseBizContactPlainListUI.getResources().getString(C25738R.string.f9221tf), new C30111a() {
                /* renamed from: a */
                public final void mo6399a(boolean z, String str, int i) {
                    AppMethodBeat.m2504i(13984);
                    if (z) {
                        if (EnterpriseBizContactPlainListUI.this.scene == 3) {
                            Intent intent = EnterpriseBizContactPlainListUI.this.getIntent();
                            intent.putExtra("enterprise_biz_name", str4);
                            EnterpriseBizContactPlainListUI.this.setResult(-1, intent);
                            EnterpriseBizContactPlainListUI.this.finish();
                        }
                        AppMethodBeat.m2505o(13984);
                        return;
                    }
                    AppMethodBeat.m2505o(13984);
                }
            });
            AppMethodBeat.m2505o(14002);
        } else {
            if (enterpriseBizContactPlainListUI.scene == 4) {
                C16527d qX = C17903f.m28104qX(c30201lk.userName);
                String adW = qX == null ? null : qX.adW();
                if (!C5046bo.isNullOrNil(adW)) {
                    int i2;
                    int i3;
                    C36692b qC = C41747z.afa().mo20347qC(qX.adX());
                    if (qC != null) {
                        i2 = qC.field_qyUin;
                    } else {
                        i2 = 0;
                    }
                    if (qC != null) {
                        i3 = qC.field_userUin;
                    } else {
                        i3 = 0;
                    }
                    int qE = C41747z.afa().mo20349qE(qX.field_username);
                    C7060h.pYm.mo8381e(13419, Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Integer.valueOf(1));
                    C4990ab.m7411d("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizEnterpriseActive report fatherUin:%d,childUin:%d,userUin:%d,scene:%d", Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Integer.valueOf(1));
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", adW);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", c30201lk.userName);
                    intent2.putExtra("enterprise_biz_name", enterpriseBizContactPlainListUI.fuO);
                    intent2.putExtra("biz_chat_chat_id", enterpriseBizContactPlainListUI.jMj);
                    C25985d.m41468b(enterpriseBizContactPlainListUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2, 1);
                }
            }
            AppMethodBeat.m2505o(14002);
        }
    }
}
