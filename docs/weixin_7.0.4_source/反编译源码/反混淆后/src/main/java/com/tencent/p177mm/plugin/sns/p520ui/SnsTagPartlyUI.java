package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C7110x;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI */
public class SnsTagPartlyUI extends MMActivity implements C1202f {
    private ListView gGW;
    private C29145a rxF;
    private OnClickListener rxG = new C291425();
    protected C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$3 */
    class C220333 implements OnMenuItemClickListener {
        C220333() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            boolean z;
            AppMethodBeat.m2504i(39378);
            C29145a a = SnsTagPartlyUI.this.rxF;
            if (SnsTagPartlyUI.this.rxF.rxJ) {
                z = false;
            } else {
                z = true;
            }
            a.rxJ = z;
            SnsTagPartlyUI.this.updateOptionMenuText(0, SnsTagPartlyUI.this.rxF.rxJ ? SnsTagPartlyUI.this.getString(C25738R.string.f9142qt) : SnsTagPartlyUI.this.getString(C25738R.string.ep7));
            SnsTagPartlyUI.this.rxF.notifyDataSetChanged();
            AppMethodBeat.m2505o(39378);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$4 */
    class C220344 implements C30723a {
        C220344() {
        }

        public final void apt() {
            boolean z = true;
            AppMethodBeat.m2504i(39379);
            SnsTagPartlyUI snsTagPartlyUI = SnsTagPartlyUI.this;
            if (SnsTagPartlyUI.this.rxF.getCount() <= 1) {
                z = false;
            }
            snsTagPartlyUI.enableOptionMenu(z);
            AppMethodBeat.m2505o(39379);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$2 */
    class C291412 implements OnItemClickListener {
        C291412() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(39377);
            if (i < SnsTagPartlyUI.this.rxF.getCount() - 1) {
                Intent intent = new Intent();
                C13479t c13479t = (C13479t) SnsTagPartlyUI.this.rxF.getItem(i);
                if (c13479t == null) {
                    AppMethodBeat.m2505o(39377);
                    return;
                }
                intent.putExtra("k_sns_tag_id", c13479t.field_tagId);
                intent.setClass(SnsTagPartlyUI.this, SnsTagDetailUI.class);
                SnsTagPartlyUI.this.startActivity(intent);
                AppMethodBeat.m2505o(39377);
                return;
            }
            Intent intent2 = new Intent();
            String Yz = C1853r.m3846Yz();
            intent2.putExtra("titile", SnsTagPartlyUI.this.getString(C25738R.string.f8778ep));
            intent2.putExtra("list_type", 1);
            intent2.putExtra("KBlockOpenImFav", true);
            String str = "list_attr";
            intent2.putExtra(str, C15830s.m24193hs(C15830s.m24190C(C15830s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 16777216));
            intent2.putExtra("block_contact", Yz);
            C25985d.m41466b(SnsTagPartlyUI.this, ".ui.contact.SelectContactUI", intent2, 1);
            AppMethodBeat.m2505o(39377);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$5 */
    class C291425 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$5$1 */
        class C220351 implements OnCancelListener {
            C220351() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        C291425() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39380);
            if (SnsTagPartlyUI.this.rxF == null) {
                C4990ab.m7412e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                AppMethodBeat.m2505o(39380);
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                C4990ab.m7412e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
                AppMethodBeat.m2505o(39380);
            } else if (tag instanceof Integer) {
                C13479t c13479t = (C13479t) SnsTagPartlyUI.this.rxF.getItem(((Integer) tag).intValue());
                SnsTagPartlyUI.this.tipDialog = C30379h.m48458b(SnsTagPartlyUI.this, null, true, new C220351());
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C7110x(c13479t.field_tagId, c13479t.field_tagName), 0);
                AppMethodBeat.m2505o(39380);
            } else {
                C4990ab.m7412e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
                AppMethodBeat.m2505o(39380);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$1 */
    class C291441 implements OnMenuItemClickListener {
        C291441() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39376);
            SnsTagPartlyUI.this.finish();
            AppMethodBeat.m2505o(39376);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$a */
    class C29145a extends C46692p<C13479t> {
        private Context context;
        public boolean rxJ = false;

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$a$a */
        class C29143a {
            Button gzI;
            TextView rxK;
            TextView rxL;

            C29143a() {
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(39385);
            C13479t c13479t = (C13479t) obj;
            if (c13479t == null) {
                c13479t = new C13479t();
                C4990ab.m7410d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
            }
            c13479t.mo8995d(cursor);
            AppMethodBeat.m2505o(39385);
            return c13479t;
        }

        public C29145a(Context context) {
            super(context, new C13479t());
            AppMethodBeat.m2504i(39381);
            this.context = context;
            AppMethodBeat.m2505o(39381);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C29143a c29143a;
            AppMethodBeat.m2504i(39382);
            if (view == null) {
                c29143a = new C29143a();
                view = View.inflate(this.context, 2130970343, null);
                c29143a.rxK = (TextView) view.findViewById(2131826454);
                c29143a.rxL = (TextView) view.findViewById(2131826455);
                c29143a.gzI = (Button) view.findViewById(2131822772);
                view.setTag(c29143a);
            } else {
                c29143a = (C29143a) view.getTag();
            }
            if (mo10892wK(i)) {
                c29143a.rxK.setText(C25738R.string.eu_);
                c29143a.rxL.setVisibility(8);
                c29143a.gzI.setVisibility(8);
            } else {
                int i2;
                C13479t c13479t = (C13479t) getItem(i);
                c29143a.rxK.setText(c13479t.field_tagName);
                c29143a.rxL.setVisibility(0);
                c29143a.rxL.setText(" (" + c13479t.field_count + ") ");
                Button button = c29143a.gzI;
                if (this.rxJ) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                button.setVisibility(i2);
                c29143a.gzI.setOnClickListener(SnsTagPartlyUI.this.rxG);
                c29143a.gzI.setTag(Integer.valueOf(i));
            }
            AppMethodBeat.m2505o(39382);
            return view;
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(39383);
            setCursor(C13373af.cnL().getCursor());
            notifyDataSetChanged();
            AppMethodBeat.m2505o(39383);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(39384);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(39384);
        }

        public final int bFs() {
            return 1;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsTagPartlyUI() {
        AppMethodBeat.m2504i(39386);
        AppMethodBeat.m2505o(39386);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39387);
        super.onCreate(bundle);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(290, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(39387);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39388);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(290, (C1202f) this);
        if (this.rxF != null) {
            this.rxF.bIf();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(39388);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39389);
        super.onResume();
        if (this.rxF != null) {
            this.rxF.mo5248a("", null);
        }
        AppMethodBeat.m2505o(39389);
    }

    public final void initView() {
        AppMethodBeat.m2504i(39390);
        setMMTitle((int) C25738R.string.e_l);
        setBackBtn(new C291441());
        this.gGW = (ListView) findViewById(2131827865);
        this.gGW.setOnItemClickListener(new C291412());
        this.rxF = new C29145a(this);
        this.gGW.addFooterView(View.inflate(this, 2130970808, null));
        this.gGW.setAdapter(this.rxF);
        addTextOptionMenu(0, getString(C25738R.string.ep7), new C220333());
        this.rxF.mo74992a((C30723a) new C220344());
        AppMethodBeat.m2505o(39390);
    }

    public final int getLayoutId() {
        return 2130970809;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39391);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(39391);
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    String stringExtra2 = intent.getStringExtra("Select_room_name");
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_sns_tag_id", 0);
                        intent2.putExtra("k_sns_tag_name", C5046bo.m7532bc(stringExtra2, ""));
                        intent2.putExtra("k_sns_tag_list", stringExtra);
                        intent2.setClass(this, SnsTagDetailUI.class);
                        startActivity(intent2);
                        break;
                    }
                    AppMethodBeat.m2505o(39391);
                    return;
                }
                AppMethodBeat.m2505o(39391);
                return;
        }
        AppMethodBeat.m2505o(39391);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39392);
        C4990ab.m7416i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.rxF != null) {
            this.rxF.mo5248a("", null);
        }
        AppMethodBeat.m2505o(39392);
    }
}
