package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C15430ab;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7617ak;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog */
public class SnsSelectContactDialog extends MMBaseActivity {
    private List<String> items = new LinkedList();
    private GridView rvo = null;
    private C22023a rvp = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog$b */
    static class C22022b {
        ImageView image;
        ImageView rvr;

        C22022b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog$a */
    class C22023a extends BaseAdapter {
        private Context context;
        private List<String> items;
        private int rgh = 0;
        private int type;

        public C22023a(Context context, int i) {
            AppMethodBeat.m2504i(39189);
            this.items = i;
            this.context = context;
            this.type = 0;
            refresh();
            AppMethodBeat.m2505o(39189);
        }

        public final void refresh() {
            AppMethodBeat.m2504i(39190);
            if (this.items == null) {
                this.rgh = 0;
            } else {
                this.rgh = this.items.size();
            }
            this.rgh++;
            notifyDataSetChanged();
            AppMethodBeat.m2505o(39190);
        }

        public final int getCount() {
            return this.rgh;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(39191);
            Object obj = this.items.get(i);
            AppMethodBeat.m2505o(39191);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C22022b c22022b;
            View inflate;
            AppMethodBeat.m2504i(39192);
            if (view == null) {
                c22022b = new C22022b();
                if (this.type == 0) {
                    inflate = View.inflate(this.context, 2130970824, null);
                } else {
                    inflate = View.inflate(this.context, 2130970744, null);
                }
                c22022b.image = (ImageView) inflate.findViewById(2131820629);
                c22022b.rvr = (ImageView) inflate.findViewById(2131827676);
                inflate.setTag(c22022b);
            } else {
                c22022b = (C22022b) view.getTag();
                inflate = view;
            }
            inflate.setVisibility(0);
            if (i == this.rgh - 1) {
                c22022b.image.setBackgroundDrawable(null);
                c22022b.image.setImageResource(C25738R.drawable.a0r);
                c22022b.rvr.setVisibility(8);
                if (this.items.size() >= C15430ab.xID) {
                    inflate.setVisibility(8);
                }
            } else {
                c22022b.image.setBackgroundDrawable(null);
                c22022b.rvr.setVisibility(0);
                if (this.type == 0) {
                    C40460b.m69434b(c22022b.image, (String) this.items.get(i));
                } else {
                    c22022b.image.setImageBitmap(C5056d.m7659d((String) this.items.get(i), C13373af.cnN(), C13373af.cnN(), true));
                }
            }
            c22022b.image.setScaleType(ScaleType.CENTER_CROP);
            AppMethodBeat.m2505o(39192);
            return inflate;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog$1 */
    class C220241 implements OnItemClickListener {
        C220241() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(39187);
            if (i == SnsSelectContactDialog.this.rvp.getCount() - 1) {
                SnsSelectContactDialog.m33654b(SnsSelectContactDialog.this);
            } else {
                SnsSelectContactDialog.this.items.remove(i);
            }
            SnsSelectContactDialog.this.rvp.refresh();
            AppMethodBeat.m2505o(39187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog$2 */
    class C220252 implements OnClickListener {
        C220252() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39188);
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", C5046bo.m7536c(SnsSelectContactDialog.this.items, ","));
            SnsSelectContactDialog.this.setResult(-1, intent);
            SnsSelectContactDialog.this.finish();
            AppMethodBeat.m2505o(39188);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsSelectContactDialog() {
        AppMethodBeat.m2504i(39193);
        AppMethodBeat.m2505o(39193);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39194);
        super.onCreate(bundle);
        setContentView(2130970749);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.items.clear();
        } else {
            this.items = C5046bo.m7508P(stringExtra.split(","));
        }
        this.rvo = (GridView) findViewById(2131827692);
        this.rvp = new C22023a(this, this.items);
        this.rvo.setAdapter(this.rvp);
        this.rvo.setOnItemClickListener(new C220241());
        this.rvo.setSelection(this.rvp.getCount() - 1);
        ((ImageButton) findViewById(2131827693)).setOnClickListener(new C220252());
        AppMethodBeat.m2505o(39194);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39195);
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", C5046bo.m7536c(this.items, ","));
            setResult(-1, intent);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(39195);
        return onKeyDown;
    }

    /* renamed from: ZG */
    private boolean m33652ZG(String str) {
        AppMethodBeat.m2504i(39196);
        for (Object equals : C1855t.fkY) {
            if (str.equals(equals)) {
                AppMethodBeat.m2505o(39196);
                return false;
            }
        }
        if (C1855t.m3896kH(str)) {
            AppMethodBeat.m2505o(39196);
            return false;
        } else if (C1855t.m3913mZ(str)) {
            AppMethodBeat.m2505o(39196);
            return false;
        } else if (this.items == null || !this.items.contains(str)) {
            AppMethodBeat.m2505o(39196);
            return true;
        } else {
            AppMethodBeat.m2505o(39196);
            return false;
        }
    }

    private String ctJ() {
        AppMethodBeat.m2504i(39197);
        C7310be XR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR();
        String str = C1855t.fkP;
        LinkedList linkedList = new LinkedList();
        for (Object add : C1855t.fkY) {
            linkedList.add(add);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor c = XR.mo15804c(str, linkedList, "*");
        String str2;
        if (c.getCount() == 0) {
            c.close();
            str2 = "";
            AppMethodBeat.m2505o(39197);
            return str2;
        }
        List linkedList2 = new LinkedList();
        c.moveToFirst();
        do {
            C7617ak c7617ak = new C7617ak();
            c7617ak.mo8995d(c);
            if (m33652ZG(c7617ak.field_username)) {
                linkedList2.add(c7617ak.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (c.moveToNext());
        c.close();
        str2 = C5046bo.m7536c(linkedList2, ";");
        AppMethodBeat.m2505o(39197);
        return str2;
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39198);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(39198);
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    ArrayList<String> P = C5046bo.m7508P(intent.getStringExtra("Select_Contact").split(","));
                    if (P != null) {
                        if (this.items == null) {
                            this.items = new LinkedList();
                        }
                        for (String str : P) {
                            if (!this.items.contains(str)) {
                                this.items.add(str);
                            }
                        }
                        C4990ab.m7410d("MicroMsg.SnsSelectContactDialog", "withList count " + this.items.size());
                        if (this.rvp != null) {
                            C4990ab.m7410d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                            this.rvp.refresh();
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Select_Contact", C5046bo.m7536c(this.items, ","));
                        setResult(-1, intent2);
                        finish();
                        break;
                    }
                    AppMethodBeat.m2505o(39198);
                    return;
                }
                AppMethodBeat.m2505o(39198);
                return;
        }
        AppMethodBeat.m2505o(39198);
    }

    /* renamed from: b */
    static /* synthetic */ void m33654b(SnsSelectContactDialog snsSelectContactDialog) {
        AppMethodBeat.m2504i(39199);
        Intent intent = new Intent();
        String str = C5046bo.m7536c(snsSelectContactDialog.items, ",") + ", " + C1853r.m3846Yz();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.ctJ());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(C25738R.string.f8782eu));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", str);
        intent.putExtra("sns_address_count", snsSelectContactDialog.items.size());
        C24826a.gkE.mo38896a(intent, (Activity) snsSelectContactDialog, 1);
        AppMethodBeat.m2505o(39199);
    }
}
