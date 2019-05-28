package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p612ui.C5510e.C5503j;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.setting.model.C39646b;
import com.tencent.p177mm.plugin.setting.model.C39648e;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.apd;
import com.tencent.p177mm.protocal.protobuf.ciu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI */
public class SettingsTrustFriendUI extends MMActivity implements C1202f {
    private static int qpn = 5;
    private View jyC;
    private C44275p lRg;
    private GridView mPe;
    private TextView nml;
    private boolean qnu;
    private List<String> qpl;
    private C39683a qpm;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$3 */
    class C217933 implements OnClickListener {
        C217933() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127534);
            SettingsTrustFriendUI.m67831h(SettingsTrustFriendUI.this);
            AppMethodBeat.m2505o(127534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$4 */
    class C217944 implements OnClickListener {
        C217944() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127535);
            SettingsTrustFriendUI.this.finish();
            AppMethodBeat.m2505o(127535);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$10 */
    class C2896010 implements View.OnClickListener {
        C2896010() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127541);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
            C25985d.m41467b(SettingsTrustFriendUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(127541);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$1 */
    class C289611 implements Runnable {
        C289611() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127532);
            SettingsTrustFriendUI.m67823a(SettingsTrustFriendUI.this);
            AppMethodBeat.m2505o(127532);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$9 */
    class C289629 implements View.OnClickListener {
        C289629() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127540);
            SettingsTrustFriendUI.this.jyC.setVisibility(8);
            AppMethodBeat.m2505o(127540);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$11 */
    class C3967811 implements OnMenuItemClickListener {
        C3967811() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127542);
            SettingsTrustFriendUI.m67830g(SettingsTrustFriendUI.this);
            AppMethodBeat.m2505o(127542);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$6 */
    class C396796 implements View.OnClickListener {
        C396796() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127537);
            if (SettingsTrustFriendUI.this.qnu) {
                SettingsTrustFriendUI.this.qnu = false;
                SettingsTrustFriendUI.this.qpm.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(127537);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$7 */
    class C396817 implements OnTouchListener {
        C396817() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(127538);
            if (SettingsTrustFriendUI.this.qnu && motionEvent.getAction() == 1 && SettingsTrustFriendUI.this.mPe.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) == -1) {
                SettingsTrustFriendUI.this.qnu = false;
                SettingsTrustFriendUI.this.qpm.notifyDataSetChanged();
                AppMethodBeat.m2505o(127538);
                return true;
            }
            AppMethodBeat.m2505o(127538);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$8 */
    class C396828 implements OnItemClickListener {
        C396828() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(127539);
            if (SettingsTrustFriendUI.this.qpm.getItemViewType(i) == 1) {
                Intent intent = new Intent();
                intent.putExtra("list_type", 12);
                intent.putExtra("titile", SettingsTrustFriendUI.this.getString(C25738R.string.f8782eu));
                intent.putExtra("scene", 2);
                intent.putExtra("max_limit_num", SettingsTrustFriendUI.qpn);
                intent.putExtra("stay_in_wechat", true);
                intent.putExtra("already_select_contact", C5046bo.m7536c(SettingsTrustFriendUI.this.qpl, ","));
                intent.putExtra("block_contact", C1853r.m3846Yz());
                intent.putExtra("list_attr", C15830s.m24193hs(C15830s.znK, 256));
                intent.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(C25738R.string.ec2, new Object[]{Integer.valueOf(SettingsTrustFriendUI.qpn)}));
                C25985d.m41466b(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", intent, 1);
                AppMethodBeat.m2505o(127539);
                return;
            }
            if (SettingsTrustFriendUI.this.qpm.getItemViewType(i) == 2) {
                if (!SettingsTrustFriendUI.this.qnu) {
                    SettingsTrustFriendUI.this.qnu = true;
                }
                AppMethodBeat.m2505o(127539);
            }
            if (SettingsTrustFriendUI.this.qpm.getItemViewType(i) == 0 && SettingsTrustFriendUI.this.qnu) {
                SettingsTrustFriendUI.this.qpl.remove(SettingsTrustFriendUI.this.qpm.getItem(i));
                if (SettingsTrustFriendUI.this.qpl.size() == 0) {
                    SettingsTrustFriendUI.this.qnu = false;
                }
            }
            AppMethodBeat.m2505o(127539);
            SettingsTrustFriendUI.this.qpm.notifyDataSetChanged();
            AppMethodBeat.m2505o(127539);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$a */
    class C39683a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$a$a */
        class C39680a {
            TextView jAJ;
            ImageView qgZ;
            ImageView qpr;

            private C39680a() {
            }

            /* synthetic */ C39680a(C39683a c39683a, byte b) {
                this();
            }
        }

        private C39683a() {
        }

        /* synthetic */ C39683a(SettingsTrustFriendUI settingsTrustFriendUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(127544);
            int size = SettingsTrustFriendUI.this.qpl.size();
            if (!SettingsTrustFriendUI.this.qnu) {
                size = size == 0 ? 1 : (size <= 0 || size >= SettingsTrustFriendUI.qpn) ? size >= SettingsTrustFriendUI.qpn ? size + 1 : 0 : size + 2;
            }
            AppMethodBeat.m2505o(127544);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(127545);
            if (getItemViewType(i) == 0) {
                Object obj = SettingsTrustFriendUI.this.qpl.get(i);
                AppMethodBeat.m2505o(127545);
                return obj;
            }
            AppMethodBeat.m2505o(127545);
            return null;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(127546);
            int size = SettingsTrustFriendUI.this.qpl.size();
            if (SettingsTrustFriendUI.this.qnu || i < size) {
                AppMethodBeat.m2505o(127546);
                return 0;
            } else if (size == 0) {
                AppMethodBeat.m2505o(127546);
                return 1;
            } else if (size >= SettingsTrustFriendUI.qpn) {
                AppMethodBeat.m2505o(127546);
                return 2;
            } else if (i == size) {
                AppMethodBeat.m2505o(127546);
                return 1;
            } else if (i == size + 1) {
                AppMethodBeat.m2505o(127546);
                return 2;
            } else {
                AppMethodBeat.m2505o(127546);
                return -1;
            }
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C39680a c39680a;
            AppMethodBeat.m2504i(127547);
            if (view == null) {
                view = SettingsTrustFriendUI.this.getLayoutInflater().inflate(2130970647, null);
                ImageView imageView = (ImageView) view.findViewById(2131827448);
                ImageView imageView2 = (ImageView) view.findViewById(2131827449);
                TextView textView = (TextView) view.findViewById(2131827450);
                C39680a c39680a2 = new C39680a(this, (byte) 0);
                c39680a2.qgZ = imageView;
                c39680a2.qpr = imageView2;
                c39680a2.jAJ = textView;
                view.setTag(c39680a2);
                c39680a = c39680a2;
            } else {
                c39680a = (C39680a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                String str = (String) SettingsTrustFriendUI.this.qpl.get(i);
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                c39680a.qgZ.setScaleType(ScaleType.FIT_XY);
                C40460b.m69434b(c39680a.qgZ, str);
                c39680a.jAJ.setText(C44089j.m79293b(SettingsTrustFriendUI.this, aoO.mo16707Oj(), c39680a.jAJ.getTextSize()));
                if (SettingsTrustFriendUI.this.qnu) {
                    c39680a.qpr.setVisibility(0);
                } else {
                    c39680a.qpr.setVisibility(8);
                }
            } else {
                c39680a.jAJ.setVisibility(4);
                c39680a.qpr.setVisibility(8);
                c39680a.qgZ.setScaleType(ScaleType.FIT_XY);
                if (getItemViewType(i) == 1) {
                    c39680a.qgZ.setImageResource(C25738R.drawable.f6436e4);
                } else if (getItemViewType(i) == 2) {
                    c39680a.qgZ.setImageResource(C25738R.drawable.f6437e5);
                }
            }
            AppMethodBeat.m2505o(127547);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$12 */
    class C3968412 implements OnMenuItemClickListener {
        C3968412() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127543);
            SettingsTrustFriendUI.m67831h(SettingsTrustFriendUI.this);
            AppMethodBeat.m2505o(127543);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: g */
    static /* synthetic */ void m67830g(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.m2504i(127557);
        settingsTrustFriendUI.cjh();
        AppMethodBeat.m2505o(127557);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127548);
        super.onCreate(bundle);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(352277, null);
        if (!C5046bo.isNullOrNil(str)) {
            this.qpl = C5046bo.m7508P(str.split(","));
        }
        if (this.qpl == null) {
            this.qpl = new ArrayList();
        }
        this.mController.contentView.post(new C289611());
        initView();
        AppMethodBeat.m2505o(127548);
    }

    public final int getLayoutId() {
        return 2130970646;
    }

    public void onStart() {
        AppMethodBeat.m2504i(127549);
        super.onStart();
        C1720g.m3540Rg().mo14539a(869, (C1202f) this);
        C1720g.m3540Rg().mo14539a(583, (C1202f) this);
        AppMethodBeat.m2505o(127549);
    }

    public void onStop() {
        AppMethodBeat.m2504i(127550);
        super.onStop();
        C1720g.m3540Rg().mo14546b(869, (C1202f) this);
        C1720g.m3540Rg().mo14546b(583, (C1202f) this);
        AppMethodBeat.m2505o(127550);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127551);
        setMMTitle((int) C25738R.string.ec0);
        this.mPe = (GridView) findViewById(2131827447);
        this.qpm = new C39683a(this, (byte) 0);
        this.mPe.setColumnWidth(getResources().getDimensionPixelSize(C25738R.dimen.f9974ly));
        this.mPe.setNumColumns(-1);
        this.mPe.setStretchMode(1);
        this.mPe.setHorizontalSpacing(getResources().getDimensionPixelSize(C25738R.dimen.a2u) * 2);
        this.mPe.setVerticalSpacing(getResources().getDimensionPixelSize(C25738R.dimen.a2v));
        this.mPe.setAdapter(this.qpm);
        ((ViewGroup) this.mPe.getParent()).setOnClickListener(new C396796());
        this.mPe.setOnTouchListener(new C396817());
        this.mPe.setHorizontalScrollBarEnabled(false);
        this.mPe.setVerticalScrollBarEnabled(false);
        this.mPe.setOnItemClickListener(new C396828());
        this.nml = (TextView) findViewById(2131827445);
        String stringExtra = getIntent().getStringExtra(C5503j.ygc);
        if (C5046bo.isNullOrNil(stringExtra)) {
            this.nml.setText(getResources().getString(C25738R.string.ec4, new Object[]{Integer.valueOf(3)}));
        } else {
            this.nml.setText(stringExtra);
        }
        this.jyC = findViewById(2131827443);
        this.jyC.setVisibility(8);
        ((TextView) this.jyC.findViewById(2131827444)).setText(getString(C25738R.string.ec3, new Object[]{Integer.valueOf(3)}));
        this.jyC.findViewById(2131822694).setOnClickListener(new C289629());
        findViewById(2131827446).setOnClickListener(new C2896010());
        setBackBtn(new C3967811());
        mo17379a(1, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C3968412(), C5535b.GREEN);
        showOptionMenu(true);
        AppMethodBeat.m2505o(127551);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127552);
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!C5046bo.isNullOrNil(stringExtra)) {
                this.qpl.clear();
                this.qpl.addAll(C5046bo.m7508P(stringExtra.split(",")));
                this.qpm.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(127552);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127553);
        C4990ab.m7411d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.lRg != null) {
            this.lRg.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 869) {
                int i3;
                apd apd = (apd) ((C7472b) c1207m.ftl).fsH.fsP;
                qpn = apd.wte;
                LinkedList<ciu> linkedList = apd.vET;
                if (linkedList.size() != this.qpl.size()) {
                    i3 = 1;
                    break;
                } else if (linkedList.size() == 0) {
                    i3 = 0;
                } else {
                    for (ciu ciu : linkedList) {
                        if (!this.qpl.contains(ciu.jBB)) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.qpl.clear();
                    for (ciu ciu2 : linkedList) {
                        this.qpl.add(ciu2.jBB);
                    }
                    this.qpm.notifyDataSetChanged();
                }
                if (this.qpl.size() > 0 && this.qpl.size() < 3) {
                    this.jyC.setVisibility(0);
                }
                C1720g.m3536RP().mo5239Ry().set(352277, C5046bo.m7536c(this.qpl, ","));
                AppMethodBeat.m2505o(127553);
                return;
            } else if (c1207m.getType() == 583) {
                C1720g.m3536RP().mo5239Ry().set(352277, C5046bo.m7536c(this.qpl, ","));
                finish();
                AppMethodBeat.m2505o(127553);
                return;
            }
        } else if (!C5046bo.isNullOrNil(str)) {
            C30379h.m48465bQ(this, str);
        }
        AppMethodBeat.m2505o(127553);
    }

    private void cjh() {
        List P;
        AppMethodBeat.m2504i(127554);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(352277, null);
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str)) {
            Object P2 = arrayList;
        } else {
            P2 = C5046bo.m7508P(str.split(","));
        }
        if (this.qpl.size() == P2.size() && this.qpl.containsAll(P2)) {
            finish();
            AppMethodBeat.m2505o(127554);
            return;
        }
        C30379h.m48445a((Context) this, getString(C25738R.string.dwy), getString(C25738R.string.f9238tz), getString(C25738R.string.f9218tc), getString(C25738R.string.f9184s3), true, new C217933(), new C217944());
        AppMethodBeat.m2505o(127554);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127555);
        if (i == 4) {
            cjh();
            AppMethodBeat.m2505o(127555);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(127555);
        return onKeyUp;
    }

    /* renamed from: a */
    static /* synthetic */ void m67823a(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.m2504i(127556);
        final C1207m c39648e = new C39648e();
        C1720g.m3540Rg().mo14541a(c39648e, 0);
        settingsTrustFriendUI.getString(C25738R.string.f9104pl);
        settingsTrustFriendUI.lRg = C30379h.m48458b((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(C25738R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127536);
                C1720g.m3540Rg().mo14547c(c39648e);
                AppMethodBeat.m2505o(127536);
            }
        });
        AppMethodBeat.m2505o(127556);
    }

    /* renamed from: h */
    static /* synthetic */ void m67831h(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.m2504i(127558);
        if (settingsTrustFriendUI.qpl.size() <= 0 || settingsTrustFriendUI.qpl.size() >= 3) {
            final C1207m c39646b = new C39646b(settingsTrustFriendUI.qpl);
            C1720g.m3540Rg().mo14541a(c39646b, 0);
            if (settingsTrustFriendUI.lRg != null) {
                settingsTrustFriendUI.lRg.dismiss();
            }
            settingsTrustFriendUI.getString(C25738R.string.f9104pl);
            settingsTrustFriendUI.lRg = C30379h.m48458b((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(C25738R.string.f9222th), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(127533);
                    C1720g.m3540Rg().mo14547c(c39646b);
                    AppMethodBeat.m2505o(127533);
                }
            });
            AppMethodBeat.m2505o(127558);
            return;
        }
        C30379h.m48461b((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(C25738R.string.ec3, new Object[]{Integer.valueOf(3)}), settingsTrustFriendUI.getString(C25738R.string.f9238tz), true);
        AppMethodBeat.m2505o(127558);
    }
}
