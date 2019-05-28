package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.p177mm.plugin.honey_pay.p434a.C21050b;
import com.tencent.p177mm.plugin.honey_pay.p434a.C28288f;
import com.tencent.p177mm.plugin.honey_pay.p434a.C46020a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.asj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI */
public class HoneyPayMainUI extends HoneyPayBaseUI {
    private ArrayList<HoneyPayCardLayout> nsA = new ArrayList();
    private LinearLayout nsu;
    private ImageView nsv;
    private RelativeLayout nsw;
    private Button nsx;
    private LinearLayout nsy;
    private TextView nsz;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI$2 */
    class C122332 implements C40929a {
        C122332() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI$10 */
    class C2106310 implements C40929a {
        C2106310() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41890);
            C7060h.pYm.mo15419k(875, 1, 1);
            AppMethodBeat.m2505o(41890);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI$12 */
    class C2106412 implements C40929a {
        C2106412() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI$8 */
    class C343528 implements OnClickListener {
        C343528() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41888);
            C4990ab.m7416i(HoneyPayMainUI.this.TAG, "click empty header add friend");
            HoneyPayMainUI.m56313a(HoneyPayMainUI.this);
            AppMethodBeat.m2505o(41888);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI$15 */
    class C3435515 implements C40929a {
        C3435515() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI$9 */
    class C343569 implements C40929a {
        C343569() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41889);
            C7060h.pYm.mo15419k(875, 1, 1);
            AppMethodBeat.m2505o(41889);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI$1 */
    class C343571 implements OnClickListener {
        C343571() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41882);
            C4990ab.m7410d(HoneyPayMainUI.this.TAG, "click add friend");
            HoneyPayMainUI.m56313a(HoneyPayMainUI.this);
            AppMethodBeat.m2505o(41882);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public HoneyPayMainUI() {
        AppMethodBeat.m2504i(41894);
        AppMethodBeat.m2505o(41894);
    }

    /* renamed from: a */
    static /* synthetic */ void m56317a(HoneyPayMainUI honeyPayMainUI, String str, String str2) {
        AppMethodBeat.m2504i(41912);
        honeyPayMainUI.m56322b(str, false, str2);
        AppMethodBeat.m2505o(41912);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41896);
        this.nsy = (LinearLayout) findViewById(2131824916);
        this.nsw = (RelativeLayout) findViewById(2131824917);
        this.nsv = (ImageView) findViewById(2131824919);
        this.nsx = (Button) findViewById(2131824923);
        this.nsz = (TextView) findViewById(2131824924);
        this.nsu = (LinearLayout) findViewById(2131824925);
        this.nsu.setOnClickListener(new C343571());
        this.nsx.setOnClickListener(new C343528());
        AppMethodBeat.m2505o(41896);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41897);
        super.onDestroy();
        mo39993ng(2725);
        mo39993ng(2618);
        mo39993ng(2926);
        AppMethodBeat.m2505o(41897);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41898);
        if (c1207m instanceof C28288f) {
            final C28288f c28288f = (C28288f) c1207m;
            c28288f.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41891);
                    HoneyPayMainUI.m56320b(HoneyPayMainUI.this);
                    HoneyPayMainUI.this.mController.removeAllOptionMenu();
                    if (c28288f.nqC.wxk == null || c28288f.nqC.wxk.isEmpty()) {
                        C4990ab.m7416i(HoneyPayMainUI.this.TAG, "empty card");
                        HoneyPayMainUI.m56315a(HoneyPayMainUI.this, c28288f.nqC.wxl);
                        HoneyPayMainUI.this.nsu.setVisibility(8);
                        HoneyPayMainUI.this.nqT = C25738R.color.a69;
                        HoneyPayMainUI.this.setMMTitle("");
                    } else {
                        HoneyPayMainUI.m56324d(HoneyPayMainUI.this);
                        HoneyPayMainUI.m56318a(HoneyPayMainUI.this, c28288f.nqC.wxk);
                        C4990ab.m7417i(HoneyPayMainUI.this.TAG, "show open card: %s", Boolean.valueOf(c28288f.nqC.wxn));
                        if (c28288f.nqC.wxn) {
                            HoneyPayMainUI.this.nsu.setVisibility(0);
                        } else {
                            HoneyPayMainUI.this.nsu.setVisibility(8);
                        }
                        HoneyPayMainUI.this.nqT = C25738R.color.f12094s2;
                        HoneyPayMainUI.this.setMMTitle((int) C25738R.string.ccl);
                    }
                    HoneyPayMainUI.m56316a(HoneyPayMainUI.this, c28288f.nqC.wxo);
                    HoneyPayMainUI.this.bFY();
                    HoneyPayMainUI.this.findViewById(2131824915).setBackgroundResource(HoneyPayMainUI.this.nqT);
                    C28289c.m44885b(HoneyPayMainUI.this, c28288f.nqC.wxm, null, 0, null);
                    HoneyPayMainUI.this.findViewById(2131824926).setVisibility(8);
                    C7060h.pYm.mo15419k(875, 0, 1);
                    AppMethodBeat.m2505o(41891);
                }
            }).mo70319b(new C2106310()).mo70320c(new C343569());
        } else if (c1207m instanceof C46020a) {
            final C46020a c46020a = (C46020a) c1207m;
            c46020a.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41893);
                    if (c46020a.nqx.vYe != null) {
                        C4990ab.m7416i(HoneyPayMainUI.this.TAG, "do realname guide");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
                        C28289c.m44883a(HoneyPayMainUI.this, bundle, c46020a.nqx.vYe, true);
                        AppMethodBeat.m2505o(41893);
                        return;
                    }
                    HoneyPayMainUI.m56321b(HoneyPayMainUI.this, c46020a.nqx.vYf);
                    AppMethodBeat.m2505o(41893);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41892);
                    if (c46020a.nqx.vYe != null) {
                        C4990ab.m7416i(HoneyPayMainUI.this.TAG, "do realname guide");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
                        C28289c.m44883a(HoneyPayMainUI.this, bundle, c46020a.nqx.vYe, true);
                    }
                    AppMethodBeat.m2505o(41892);
                }
            }).mo70320c(new C2106412());
        } else if (c1207m instanceof C21050b) {
            final C21050b c21050b = (C21050b) c1207m;
            c21050b.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41883);
                    HoneyPayMainUI.m56314a(HoneyPayMainUI.this, c21050b.nqy.vYj, c21050b.nqy.vYi, c21050b.nqy.vYk, c21050b.nqy.vYl, c21050b.username);
                    AppMethodBeat.m2505o(41883);
                }
            }).mo70319b(new C122332()).mo70320c(new C3435515());
        }
        AppMethodBeat.m2505o(41898);
        return true;
    }

    public final int getLayoutId() {
        return 2130969831;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(41899);
        C4990ab.m7416i(this.TAG, "on new intent");
        m56319ab(intent);
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(41899);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41900);
        if (i == 3) {
            m56325id(false);
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(41900);
    }

    /* renamed from: ab */
    private void m56319ab(Intent intent) {
        AppMethodBeat.m2504i(41901);
        boolean booleanExtra = intent.getBooleanExtra("key_create_succ", false);
        String stringExtra = intent.getStringExtra("key_card_no");
        String stringExtra2 = intent.getStringExtra("key_card_type");
        C4990ab.m7417i(this.TAG, "create succ: %s", Boolean.valueOf(booleanExtra));
        if (booleanExtra) {
            m56322b(stringExtra, true, stringExtra2);
        }
        AppMethodBeat.m2505o(41901);
    }

    /* renamed from: id */
    private void m56325id(boolean z) {
        AppMethodBeat.m2504i(41902);
        C4990ab.m7416i(this.TAG, "get payer list");
        C1207m c28288f = new C28288f();
        c28288f.mo70321o(this);
        mo39970a(c28288f, z, false);
        AppMethodBeat.m2505o(41902);
    }

    /* renamed from: b */
    private void m56322b(String str, boolean z, String str2) {
        AppMethodBeat.m2504i(41903);
        C4990ab.m7417i(this.TAG, "go to card manager: %s", str);
        Intent intent = new Intent(this, HoneyPayCardManagerUI.class);
        intent.putExtra("key_card_no", str);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_is_create", z);
        intent.putExtra("key_card_type", str2);
        startActivityForResult(intent, 3);
        AppMethodBeat.m2505o(41903);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41895);
        this.yll = true;
        super.onCreate(bundle);
        mo39992nf(2725);
        mo39992nf(2618);
        mo39992nf(2926);
        m56319ab(getIntent());
        initView();
        m56325id(true);
        setMMTitle("");
        AppMethodBeat.m2505o(41895);
    }

    /* renamed from: a */
    static /* synthetic */ void m56313a(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.m2504i(41904);
        C4990ab.m7416i(honeyPayMainUI.TAG, "do check payer");
        C1207m c46020a = new C46020a();
        c46020a.mo70321o(honeyPayMainUI);
        honeyPayMainUI.mo39970a(c46020a, true, false);
        AppMethodBeat.m2505o(41904);
    }

    /* renamed from: b */
    static /* synthetic */ void m56320b(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.m2504i(41905);
        Iterator it = honeyPayMainUI.nsA.iterator();
        while (it.hasNext()) {
            honeyPayMainUI.nsy.removeView((HoneyPayCardLayout) it.next());
        }
        honeyPayMainUI.nsA.clear();
        AppMethodBeat.m2505o(41905);
    }

    /* renamed from: d */
    static /* synthetic */ void m56324d(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.m2504i(41907);
        honeyPayMainUI.nsw.setVisibility(8);
        AppMethodBeat.m2505o(41907);
    }

    /* renamed from: b */
    static /* synthetic */ void m56321b(HoneyPayMainUI honeyPayMainUI, List list) {
        AppMethodBeat.m2504i(41910);
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            for (asj honeyPayCardType : list) {
                arrayList.add(new HoneyPayCardType(honeyPayCardType));
            }
        }
        Intent intent = new Intent(honeyPayMainUI, HoneyPaySelectCardTypeUI.class);
        intent.putParcelableArrayListExtra("key_card_type_list", arrayList);
        honeyPayMainUI.startActivity(intent);
        AppMethodBeat.m2505o(41910);
    }

    /* renamed from: a */
    static /* synthetic */ void m56314a(HoneyPayMainUI honeyPayMainUI, long j, long j2, String str, String str2, String str3) {
        AppMethodBeat.m2504i(41911);
        C4990ab.m7416i(honeyPayMainUI.TAG, "go to give card");
        Intent intent = new Intent(honeyPayMainUI, HoneyPayGiveCardUI.class);
        intent.putExtra("key_max_credit_line", j);
        intent.putExtra("key_min_credit_line", j2);
        intent.putExtra("key_true_name", str);
        intent.putExtra("key_take_message", str2);
        intent.putExtra("key_username", str3);
        honeyPayMainUI.startActivityForResult(intent, 2);
        AppMethodBeat.m2505o(41911);
    }
}
