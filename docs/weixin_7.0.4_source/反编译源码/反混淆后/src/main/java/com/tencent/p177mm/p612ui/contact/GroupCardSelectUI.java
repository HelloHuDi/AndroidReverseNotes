package com.tencent.p177mm.p612ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.GroupCardSelectUI */
public class GroupCardSelectUI extends MMActivity {
    private TextView emptyTipTv;
    private List<C7616ad> oov;
    private boolean zmC = true;
    private boolean zmD;
    private boolean zmE = false;
    private List<String> zmF = null;
    private int zmG;
    private ListView zmH;
    private C23896a zmI;
    private HashMap<String, Long> zmJ;

    /* renamed from: com.tencent.mm.ui.contact.GroupCardSelectUI$3 */
    class C157943 implements OnMenuItemClickListener {
        C157943() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33730);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_User", C5046bo.m7536c(GroupCardSelectUI.this.zmF, ","));
            GroupCardSelectUI.this.setResult(-1, intent);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.m2505o(33730);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.GroupCardSelectUI$a */
    class C23896a extends BaseAdapter {
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C23900b c23900b;
            AppMethodBeat.m2504i(33731);
            C7616ad c7616ad = (C7616ad) GroupCardSelectUI.this.oov.get(i);
            if (view == null) {
                C23900b c23900b2 = new C23900b();
                view = View.inflate(GroupCardSelectUI.this, 2130969811, null);
                c23900b2.nJc = (TextView) view.findViewById(2131824703);
                c23900b2.zmL = (TextView) view.findViewById(2131824702);
                c23900b2.gvq = (ImageView) view.findViewById(2131824701);
                c23900b2.piE = (CheckBox) view.findViewById(2131821593);
                view.setTag(c23900b2);
                c23900b = c23900b2;
            } else {
                c23900b = (C23900b) view.getTag();
            }
            C40460b.m69434b(c23900b.gvq, c7616ad.field_username);
            c23900b.zmL.setText(C44089j.m79294b(GroupCardSelectUI.this, C1854s.m3866mJ(c7616ad.field_username), C1338a.m2856al(GroupCardSelectUI.this.mController.ylL, C25738R.dimen.f9980m5)));
            c23900b.nJc.setText("(" + C37921n.m64060mA(c7616ad.field_username) + ")");
            if (C1855t.m3903mP(c7616ad.field_username)) {
                Drawable drawable = GroupCardSelectUI.this.getResources().getDrawable(C1318a.open_im_main_logo);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                c23900b.zmL.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
            } else {
                c23900b.zmL.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
            if (GroupCardSelectUI.this.zmE) {
                c23900b.piE.setVisibility(0);
                if (GroupCardSelectUI.this.zmF.contains(c7616ad.field_username)) {
                    c23900b.piE.setChecked(true);
                } else {
                    c23900b.piE.setChecked(false);
                }
            }
            AppMethodBeat.m2505o(33731);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(33732);
            int size = GroupCardSelectUI.this.oov.size();
            AppMethodBeat.m2505o(33732);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(33733);
            Object obj = GroupCardSelectUI.this.oov.get(i);
            AppMethodBeat.m2505o(33733);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.GroupCardSelectUI$2 */
    class C238972 implements OnMenuItemClickListener {
        C238972() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33729);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.m2505o(33729);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.GroupCardSelectUI$4 */
    class C238984 implements OnClickListener {
        C238984() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.GroupCardSelectUI$1 */
    class C238991 implements OnItemClickListener {
        C238991() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(33728);
            C7616ad c7616ad = (C7616ad) GroupCardSelectUI.this.zmI.getItem(i);
            if (c7616ad == null) {
                C4990ab.m7418v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                AppMethodBeat.m2505o(33728);
                return;
            }
            GroupCardSelectUI.m36822a(GroupCardSelectUI.this, c7616ad);
            GroupCardSelectUI.m36823b(GroupCardSelectUI.this);
            AppMethodBeat.m2505o(33728);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.GroupCardSelectUI$b */
    class C23900b {
        ImageView gvq;
        TextView nJc;
        CheckBox piE;
        TextView zmL;

        C23900b() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m36823b(GroupCardSelectUI groupCardSelectUI) {
        AppMethodBeat.m2504i(33743);
        groupCardSelectUI.m36819Kt();
        AppMethodBeat.m2505o(33743);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33734);
        super.onCreate(bundle);
        setMMTitle(getString(C25738R.string.f8774el));
        this.zmC = getIntent().getBooleanExtra("group_select_type", true);
        this.zmD = getIntent().getBooleanExtra("group_select_need_result", false);
        this.zmE = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.zmE) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (C5046bo.isNullOrNil(stringExtra)) {
                this.zmF = new LinkedList();
            } else {
                this.zmF = C42252ah.m74626j(stringExtra.split(","));
            }
            this.zmG = getIntent().getIntExtra("max_limit_num", 0);
        }
        dHT();
        initView();
        if (this.zmE) {
            mo17379a(1, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C157943(), C5535b.GREEN);
            enableOptionMenu(1, true);
            m36819Kt();
        }
        AppMethodBeat.m2505o(33734);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33735);
        super.onDestroy();
        AppMethodBeat.m2505o(33735);
    }

    public void onResume() {
        AppMethodBeat.m2504i(33736);
        super.onResume();
        AppMethodBeat.m2505o(33736);
    }

    public void onPause() {
        AppMethodBeat.m2504i(33737);
        super.onPause();
        AppMethodBeat.m2505o(33737);
    }

    public final void initView() {
        AppMethodBeat.m2504i(33738);
        this.zmH = (ListView) findViewById(2131824699);
        this.zmI = new C23896a();
        this.zmH.setAdapter(this.zmI);
        this.zmH.setOnItemClickListener(new C238991());
        this.emptyTipTv = (TextView) findViewById(2131824700);
        if (this.zmI.getCount() <= 0) {
            this.emptyTipTv.setVisibility(0);
        } else {
            this.emptyTipTv.setVisibility(8);
        }
        setBackBtn(new C238972());
        AppMethodBeat.m2505o(33738);
    }

    private void dHT() {
        AppMethodBeat.m2504i(33739);
        C9638aw.m17190ZK();
        this.zmJ = C18628c.m29083XR().dsK();
        this.oov = new LinkedList();
        List<C7616ad> Zi = C1855t.m3872Zi();
        if (Zi.size() == 0) {
            AppMethodBeat.m2505o(33739);
            return;
        }
        int i = 0;
        for (C7616ad c7616ad : Zi) {
            int i2;
            if (this.zmJ.containsKey(c7616ad.field_username)) {
                m36821a(i, c7616ad, ((Long) this.zmJ.get(c7616ad.field_username)).longValue());
                i2 = i + 1;
            } else if (C7486a.m12942jh(c7616ad.field_type)) {
                this.oov.add(c7616ad);
            } else {
                i2 = i;
            }
            i = i2;
        }
        Zi.clear();
        AppMethodBeat.m2505o(33739);
    }

    /* renamed from: a */
    private void m36821a(int i, C7616ad c7616ad, long j) {
        AppMethodBeat.m2504i(33740);
        int i2 = 0;
        while (i2 < i && j <= ((Long) this.zmJ.get(((C7616ad) this.oov.get(i2)).field_username)).longValue()) {
            i2++;
        }
        this.oov.add(i2, c7616ad);
        AppMethodBeat.m2505o(33740);
    }

    public final int getLayoutId() {
        return 2130969810;
    }

    /* renamed from: Kt */
    private void m36819Kt() {
        AppMethodBeat.m2504i(33741);
        if (this.zmE) {
            String format;
            StringBuilder append = new StringBuilder().append(getString(C25738R.string.f9187s6));
            if (this.zmF.size() > 0) {
                format = String.format("(%s)", new Object[]{Integer.valueOf(this.zmF.size())});
            } else {
                format = "";
            }
            updateOptionMenuText(1, append.append(format).toString());
        }
        AppMethodBeat.m2505o(33741);
    }

    /* renamed from: a */
    static /* synthetic */ void m36822a(GroupCardSelectUI groupCardSelectUI, C7616ad c7616ad) {
        int i = 1;
        AppMethodBeat.m2504i(33742);
        Intent intent;
        if (groupCardSelectUI.zmE) {
            if (groupCardSelectUI.zmF.contains(c7616ad.field_username)) {
                groupCardSelectUI.zmF.remove(c7616ad.field_username);
            } else {
                if (!groupCardSelectUI.zmE || groupCardSelectUI.zmF.size() < groupCardSelectUI.zmG) {
                    i = 0;
                } else {
                    C30379h.m48438a(groupCardSelectUI.mController.ylL, groupCardSelectUI.getString(C25738R.string.e1o, new Object[]{Integer.valueOf(groupCardSelectUI.zmG)}), groupCardSelectUI.getString(C25738R.string.f9213t6), new C238984());
                }
                if (i == 0) {
                    groupCardSelectUI.zmF.add(c7616ad.field_username);
                }
            }
            groupCardSelectUI.zmI.notifyDataSetChanged();
            AppMethodBeat.m2505o(33742);
        } else if (!groupCardSelectUI.zmC) {
            intent = new Intent();
            C9638aw.m17190ZK();
            intent.putExtra("Select_Contact", C5046bo.m7536c(C18628c.m29087XV().mo14889oe(c7616ad.field_username), ","));
            intent.putExtra("Select_room_name", C1854s.m3866mJ(c7616ad.field_username));
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
            AppMethodBeat.m2505o(33742);
        } else if (groupCardSelectUI.zmD) {
            intent = new Intent();
            intent.putExtra("Select_Conv_User", c7616ad.field_username);
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
            AppMethodBeat.m2505o(33742);
        } else {
            intent = new Intent(groupCardSelectUI, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", c7616ad.field_username);
            groupCardSelectUI.startActivity(intent);
            groupCardSelectUI.finish();
            AppMethodBeat.m2505o(33742);
        }
    }
}
