package com.tencent.p177mm.plugin.clean.p364ui.newui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.clean.p362c.C27641b;
import com.tencent.p177mm.plugin.clean.p362c.C27642d;
import com.tencent.p177mm.plugin.clean.p362c.C33824h;
import com.tencent.p177mm.plugin.clean.p362c.C41261e;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI */
public class CleanChattingUI extends MMActivity implements C33824h {
    private ProgressDialog ehJ;
    private Button gzI;
    private TextView jux;
    private View kxA;
    private CheckBox kxB;
    private ListView kxI;
    private TextView kxJ;
    private C41261e kyL;
    private C27660a kyO;

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$2 */
    class C202512 implements OnItemClickListener {
        C202512() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(18875);
            Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
            intent.putExtra("key_position", i);
            CleanChattingUI.this.startActivityForResult(intent, 0);
            AppMethodBeat.m2505o(18875);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$1 */
    class C276551 implements OnMenuItemClickListener {
        C276551() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18874);
            CleanChattingUI.this.finish();
            AppMethodBeat.m2505o(18874);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$4 */
    class C428944 implements OnClickListener {
        C428944() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18878);
            C27660a b = CleanChattingUI.this.kyO;
            if (b.jur.size() == b.getCount()) {
                b.jur.clear();
            } else {
                for (int i = 0; i < b.getCount(); i++) {
                    b.jur.add(Integer.valueOf(i));
                }
            }
            b.notifyDataSetChanged();
            b.kyF.mo68427a(b.jur);
            AppMethodBeat.m2505o(18878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$5 */
    class C428955 implements OnCancelListener {
        C428955() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$6 */
    class C428966 implements DialogInterface.OnClickListener {
        C428966() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(18879);
            if (C27642d.bfS() != null && C27642d.bfS().size() == 0) {
                CleanChattingUI.this.finish();
            }
            AppMethodBeat.m2505o(18879);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$3 */
    class C428973 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$3$1 */
        class C428921 implements DialogInterface.OnClickListener {
            C428921() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18876);
                CleanChattingUI.m76172a(CleanChattingUI.this);
                AppMethodBeat.m2505o(18876);
            }
        }

        /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI$3$2 */
        class C428932 implements DialogInterface.OnClickListener {
            C428932() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C428973() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18877);
            C30379h.m48466d(CleanChattingUI.this, CleanChattingUI.this.getString(C25738R.string.at8), "", CleanChattingUI.this.getString(C25738R.string.b53), CleanChattingUI.this.getString(C25738R.string.abx), new C428921(), new C428932());
            AppMethodBeat.m2505o(18877);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18880);
        super.onCreate(bundle);
        C27642d.bfZ();
        C4990ab.m7416i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle((int) C25738R.string.aqq);
        this.kxI = (ListView) findViewById(2131822774);
        this.kyO = new C27660a(this);
        this.kxI.setAdapter(this.kyO);
        this.kxI.setEmptyView(findViewById(2131821604));
        this.kxA = findViewById(2131821612);
        this.kxJ = (TextView) findViewById(2131822773);
        this.kxB = (CheckBox) findViewById(2131821610);
        this.jux = (TextView) findViewById(2131821611);
        if (!C4988aa.don()) {
            this.kxJ.setTextSize(1, 14.0f);
            this.jux.setTextSize(1, 14.0f);
        }
        this.gzI = (Button) findViewById(2131822772);
        this.gzI.setEnabled(false);
        setBackBtn(new C276551());
        this.kxI.setOnItemClickListener(new C202512());
        this.gzI.setOnClickListener(new C428973());
        this.kxA.setOnClickListener(new C428944());
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.apz), false, new C428955());
        this.ehJ.dismiss();
        AppMethodBeat.m2505o(18880);
    }

    /* renamed from: a */
    public final void mo68427a(HashSet<Integer> hashSet) {
        AppMethodBeat.m2504i(18881);
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < C27642d.bfS().size()) {
                i = (int) (((C27641b) C27642d.bfS().get(intValue)).jrb + ((long) i));
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || i > 0) {
            this.kxJ.setText(getString(C25738R.string.b58, new Object[]{C5046bo.m7565ga((long) i)}));
            this.gzI.setEnabled(true);
            if (hashSet.size() == this.kyO.getCount()) {
                this.kxB.setChecked(true);
                AppMethodBeat.m2505o(18881);
                return;
            }
            this.kxB.setChecked(false);
            AppMethodBeat.m2505o(18881);
            return;
        }
        this.kxJ.setText("");
        this.gzI.setEnabled(false);
        this.kxB.setChecked(false);
        AppMethodBeat.m2505o(18881);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18882);
        if (this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.kyL != null) {
            this.kyL.bgb();
        }
        C27642d.bga();
        C27642d.bfY();
        super.onDestroy();
        AppMethodBeat.m2505o(18882);
    }

    public final int getLayoutId() {
        return 2130969144;
    }

    /* renamed from: dP */
    public final void mo23158dP(int i, int i2) {
        AppMethodBeat.m2504i(18883);
        this.ehJ.setMessage(getString(C25738R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.m2505o(18883);
    }

    /* renamed from: hi */
    public final void mo23159hi(long j) {
        AppMethodBeat.m2504i(18884);
        this.ehJ.dismiss();
        C27642d.m43921hg(C27642d.bfW() + j);
        C27642d.m43918hd(C27642d.bfT() - j);
        C30379h.m48438a((Context) this, getString(C25738R.string.aq0, new Object[]{C5046bo.m7565ga(j)}), "", new C428966());
        AppMethodBeat.m2505o(18884);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(18885);
        this.kyO.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(18885);
    }
}
