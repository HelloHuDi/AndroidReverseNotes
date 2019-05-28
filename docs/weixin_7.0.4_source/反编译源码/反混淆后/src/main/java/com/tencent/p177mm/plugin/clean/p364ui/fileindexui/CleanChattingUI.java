package com.tencent.p177mm.plugin.clean.p364ui.fileindexui;

import android.app.ProgressDialog;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.clean.p1246b.C45810b;
import com.tencent.p177mm.plugin.clean.p362c.C33824h;
import com.tencent.p177mm.plugin.clean.p362c.C6826j;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI */
public class CleanChattingUI extends MMActivity implements C33824h {
    private List<C27654c> dataList = new ArrayList();
    private ProgressDialog ehJ;
    private Button gzI;
    private TextView jux;
    private View kxA;
    private CheckBox kxB;
    private C33825a kxH;
    private ListView kxI;
    private TextView kxJ;
    private TextView kxK;
    private boolean kxL = false;

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$2 */
    class C113912 implements OnItemClickListener {
        C113912() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(18779);
            C27654c tu = CleanChattingUI.this.kxH.mo54384tu(i);
            if (tu != null) {
                Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
                intent.putExtra("key_username", tu.username);
                intent.putExtra("key_pos", i);
                CleanChattingUI.this.startActivityForResult(intent, 0);
                C7060h.pYm.mo8378a(714, 21, 1, false);
            }
            AppMethodBeat.m2505o(18779);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$3 */
    class C113923 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$3$1 */
        class C113931 implements DialogInterface.OnClickListener {
            C113931() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18780);
                CleanChattingUI.m31299b(CleanChattingUI.this);
                C7060h.pYm.mo8378a(714, 22, 1, false);
                AppMethodBeat.m2505o(18780);
            }
        }

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$3$2 */
        class C113942 implements DialogInterface.OnClickListener {
            C113942() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C113923() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18781);
            C30379h.m48466d(CleanChattingUI.this, CleanChattingUI.this.getString(C25738R.string.at8), "", CleanChattingUI.this.getString(C25738R.string.b53), CleanChattingUI.this.getString(C25738R.string.abx), new C113931(), new C113942());
            AppMethodBeat.m2505o(18781);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$1 */
    class C202341 implements OnMenuItemClickListener {
        C202341() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18778);
            CleanChattingUI.this.finish();
            AppMethodBeat.m2505o(18778);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$4 */
    class C202354 implements OnClickListener {
        C202354() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18782);
            C33825a a = CleanChattingUI.this.kxH;
            if (a.jur.size() == a.getCount()) {
                a.jur.clear();
            } else {
                for (int i = 0; i < a.getCount(); i++) {
                    a.jur.add(Integer.valueOf(i));
                }
            }
            a.notifyDataSetChanged();
            a.kxj.mo35479a(a.jur);
            AppMethodBeat.m2505o(18782);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$5 */
    class C202365 implements OnCancelListener {
        C202365() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$6 */
    class C202386 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$6$2 */
        class C28092 implements Runnable {
            C28092() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18784);
                CleanChattingUI.this.kxH.notifyDataSetChanged();
                CleanChattingUI.this.kxK.setText(C25738R.string.apy);
                AppMethodBeat.m2505o(18784);
            }
        }

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI$6$1 */
        class C113951 implements Runnable {
            C113951() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18783);
                CleanChattingUI.this.kxK.setText(CleanChattingUI.this.getString(C25738R.string.f8811fp, new Object[]{" "}));
                AppMethodBeat.m2505o(18783);
            }
        }

        C202386() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18785);
            if (!CleanChattingUI.this.kxL) {
                C4990ab.m7416i("MicroMsg.CleanChattingUI", "load contact cursor now");
                CleanChattingUI.this.kxL = true;
                C5004al.m7441d(new C113951());
                try {
                    Cursor aZo = C45913b.aZc().aZd().aZo();
                    if (aZo != null) {
                        while (aZo.moveToNext()) {
                            C27654c c27654c = new C27654c();
                            c27654c.username = aZo.getString(0);
                            c27654c.size = aZo.getLong(1);
                            CleanChattingUI.this.dataList.add(c27654c);
                        }
                    }
                } catch (NullPointerException e) {
                    C4990ab.printErrStackTrace("MicroMsg.CleanChattingUI", e, "", new Object[0]);
                }
                C5004al.m7441d(new C28092());
            }
            AppMethodBeat.m2505o(18785);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CleanChattingUI() {
        AppMethodBeat.m2504i(18788);
        AppMethodBeat.m2505o(18788);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18789);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle((int) C25738R.string.aqb);
        this.kxI = (ListView) findViewById(2131822774);
        this.kxH = new C33825a(this, this.dataList);
        this.kxI.setAdapter(this.kxH);
        this.kxI.setEmptyView(findViewById(2131821604));
        this.kxK = (TextView) findViewById(2131821499);
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
        setBackBtn(new C202341());
        this.kxI.setOnItemClickListener(new C113912());
        this.gzI.setOnClickListener(new C113923());
        this.kxA.setOnClickListener(new C202354());
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.apz), false, new C202365());
        this.ehJ.dismiss();
        C7060h.pYm.mo8378a(714, 20, 1, false);
        AppMethodBeat.m2505o(18789);
    }

    /* renamed from: a */
    public final void mo35479a(HashSet<Integer> hashSet) {
        AppMethodBeat.m2504i(18790);
        if (this.kxH == null) {
            C4990ab.m7420w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
            AppMethodBeat.m2505o(18790);
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            C27654c tu = this.kxH.mo54384tu(intValue);
            if (tu != null) {
                j = tu.size + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.kxJ.setText(getString(C25738R.string.b58, new Object[]{C5046bo.m7565ga(j)}));
            this.gzI.setEnabled(true);
            if (hashSet.size() == this.kxH.getCount()) {
                this.kxB.setChecked(true);
                AppMethodBeat.m2505o(18790);
                return;
            }
            this.kxB.setChecked(false);
            AppMethodBeat.m2505o(18790);
            return;
        }
        this.kxJ.setText("");
        this.gzI.setEnabled(false);
        this.kxB.setChecked(false);
        AppMethodBeat.m2505o(18790);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18791);
        if (this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(18791);
    }

    public void onResume() {
        AppMethodBeat.m2504i(18792);
        super.onResume();
        if (this.kxH != null && this.dataList.isEmpty()) {
            C1720g.m3539RS().mo10302aa(new C202386());
        }
        AppMethodBeat.m2505o(18792);
    }

    public final int getLayoutId() {
        return 2130969144;
    }

    /* renamed from: dP */
    public final void mo23158dP(final int i, final int i2) {
        AppMethodBeat.m2504i(18793);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18786);
                CleanChattingUI.this.ehJ.setMessage(CleanChattingUI.this.getString(C25738R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
                AppMethodBeat.m2505o(18786);
            }
        });
        AppMethodBeat.m2505o(18793);
    }

    /* renamed from: hi */
    public final void mo23159hi(final long j) {
        AppMethodBeat.m2504i(18794);
        C4990ab.m7417i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", hashCode(), Long.valueOf(j));
        C6826j.bgd().kvW -= j;
        C6826j.bgd().kvV -= j;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18787);
                CleanChattingUI.this.ehJ.dismiss();
                C30379h.m48461b(CleanChattingUI.this, CleanChattingUI.this.getString(C25738R.string.aq0, new Object[]{C5046bo.m7565ga(j)}), "", true);
                CleanChattingUI.this.kxK.setText(CleanChattingUI.this.getString(C25738R.string.f8811fp, new Object[]{" "}));
                AppMethodBeat.m2505o(18787);
            }
        });
        AppMethodBeat.m2505o(18794);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(18795);
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pos", -1);
            long longExtra = intent.getLongExtra("key_delete_size", 0);
            if (intExtra >= 0 && intExtra < this.dataList.size()) {
                C27654c c27654c = (C27654c) this.dataList.get(intExtra);
                if (c27654c != null) {
                    if (c27654c.size == longExtra) {
                        this.dataList.remove(intExtra);
                        this.kxH.bgh();
                    } else {
                        c27654c.size -= longExtra;
                    }
                }
            }
        }
        this.kxH.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(18795);
    }

    /* renamed from: b */
    static /* synthetic */ void m31299b(CleanChattingUI cleanChattingUI) {
        AppMethodBeat.m2504i(18796);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cleanChattingUI.kxH.jur);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            C27654c tu = cleanChattingUI.kxH.mo54384tu(intValue);
            if (tu != null) {
                arrayList2.add(tu.username);
                cleanChattingUI.dataList.remove(intValue);
            }
        }
        cleanChattingUI.kxH.bgh();
        cleanChattingUI.kxH.notifyDataSetChanged();
        C7305d.post(new C45810b(arrayList2, null, cleanChattingUI), "delete-clean");
        cleanChattingUI.ehJ.setMessage(cleanChattingUI.getString(C25738R.string.aqi, new Object[]{"0%"}));
        cleanChattingUI.ehJ.show();
        AppMethodBeat.m2505o(18796);
    }
}
