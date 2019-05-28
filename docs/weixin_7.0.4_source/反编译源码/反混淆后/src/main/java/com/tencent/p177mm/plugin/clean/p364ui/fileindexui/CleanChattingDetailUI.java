package com.tencent.p177mm.plugin.clean.p364ui.fileindexui;

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
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.gridviewheaders.GridHeadersGridView;
import com.tencent.p177mm.p612ui.widget.textview.MMAutoAdjustTextView;
import com.tencent.p177mm.plugin.clean.p1246b.C45810b;
import com.tencent.p177mm.plugin.clean.p362c.C2808i;
import com.tencent.p177mm.plugin.clean.p362c.C33824h;
import com.tencent.p177mm.plugin.clean.p362c.C6826j;
import com.tencent.p177mm.plugin.clean.p364ui.fileindexui.C11397b.C11403b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI */
public class CleanChattingDetailUI extends MMActivity implements C33824h {
    private ProgressDialog ehJ;
    private Button gzI;
    private long kvY;
    private View kxA;
    CheckBox kxB;
    MMAutoAdjustTextView kxC;
    private C45810b kxD;
    private GridHeadersGridView kxy;
    private C11397b kxz;
    private int pos;
    private String username;

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI$1 */
    class C202311 implements OnMenuItemClickListener {
        C202311() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18766);
            CleanChattingDetailUI.this.finish();
            AppMethodBeat.m2505o(18766);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI$2 */
    class C276442 implements OnClickListener {
        C276442() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18767);
            C11397b a = CleanChattingDetailUI.this.kxz;
            if (a.jur.size() == a.iLD.size()) {
                a.jur.clear();
            } else {
                for (int i = 0; i < a.iLD.size(); i++) {
                    a.jur.add(Integer.valueOf(i));
                }
            }
            a.bgi();
            CleanChattingDetailUI.this.kxz.notifyDataSetChanged();
            AppMethodBeat.m2505o(18767);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI$3 */
    class C387983 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI$3$1 */
        class C202321 implements DialogInterface.OnClickListener {
            C202321() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18768);
                CleanChattingDetailUI.m84733b(CleanChattingDetailUI.this);
                C7060h.pYm.mo8378a(714, 31, 1, false);
                AppMethodBeat.m2505o(18768);
            }
        }

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI$3$2 */
        class C202332 implements DialogInterface.OnClickListener {
            C202332() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C387983() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18769);
            C30379h.m48466d(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(C25738R.string.at9), "", CleanChattingDetailUI.this.getString(C25738R.string.b53), CleanChattingDetailUI.this.getString(C25738R.string.abx), new C202321(), new C202332());
            AppMethodBeat.m2505o(18769);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI$4 */
    class C428914 implements OnCancelListener {
        C428914() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18772);
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("key_username");
        this.pos = getIntent().getIntExtra("key_pos", 0);
        if (C5046bo.isNullOrNil(this.username)) {
            C4990ab.m7420w("MicroMsg.CleanChattingDetailUI", "username is null");
            finish();
            AppMethodBeat.m2505o(18772);
            return;
        }
        this.kxA = findViewById(2131821612);
        this.kxB = (CheckBox) findViewById(2131821610);
        this.kxC = (MMAutoAdjustTextView) findViewById(2131822773);
        this.gzI = (Button) findViewById(2131822772);
        mo73613tx(0);
        if (C1855t.m3896kH(this.username)) {
            setMMTitle(C1854s.getDisplayName(this.username, this.username));
        } else {
            setMMTitle(C1854s.m3866mJ(this.username));
        }
        this.kxy = (GridHeadersGridView) findViewById(2131822771);
        this.kxy.setNumColumns(3);
        this.kxz = new C11397b(this, this.username);
        this.kxy.setOnHeaderClickListener(this.kxz.kxn);
        this.kxy.setOnItemClickListener(this.kxz.jMk);
        this.kxy.setOnScrollListener(this.kxz.kxp);
        this.kxy.setAdapter(this.kxz);
        setBackBtn(new C202311());
        this.kxA.setOnClickListener(new C276442());
        this.gzI.setOnClickListener(new C387983());
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.apz), false, new C428914());
        this.ehJ.dismiss();
        if (this.kxz != null) {
            C7305d.post(new C11403b(this.kxz, (byte) 0), "load_clean_detail");
        }
        C7060h.pYm.mo8378a(714, 30, 1, false);
        AppMethodBeat.m2505o(18772);
    }

    public final int getLayoutId() {
        return 2130969142;
    }

    /* renamed from: tx */
    public final void mo73613tx(int i) {
        AppMethodBeat.m2504i(18773);
        this.gzI.setEnabled(i > 0);
        AppMethodBeat.m2505o(18773);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18774);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.kxz != null) {
            this.kxz.isStop = true;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(18774);
    }

    /* renamed from: dP */
    public final void mo23158dP(final int i, final int i2) {
        AppMethodBeat.m2504i(18775);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18770);
                CleanChattingDetailUI.this.ehJ.setMessage(CleanChattingDetailUI.this.getString(C25738R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
                AppMethodBeat.m2505o(18770);
            }
        });
        AppMethodBeat.m2505o(18775);
    }

    /* renamed from: hi */
    public final void mo23159hi(final long j) {
        AppMethodBeat.m2504i(18776);
        C4990ab.m7417i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", hashCode(), Long.valueOf(j));
        C6826j.bgd().kvW -= j;
        C6826j.bgd().kvV -= j;
        this.kvY += j;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18771);
                CleanChattingDetailUI.this.ehJ.dismiss();
                Intent intent = new Intent();
                intent.putExtra("key_pos", CleanChattingDetailUI.this.pos);
                intent.putExtra("key_delete_size", CleanChattingDetailUI.this.kvY);
                CleanChattingDetailUI.this.setResult(1000, intent);
                C30379h.m48461b(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(C25738R.string.aq0, new Object[]{C5046bo.m7565ga(j)}), "", true);
                AppMethodBeat.m2505o(18771);
            }
        });
        AppMethodBeat.m2505o(18776);
    }

    /* renamed from: b */
    static /* synthetic */ void m84733b(CleanChattingDetailUI cleanChattingDetailUI) {
        AppMethodBeat.m2504i(18777);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cleanChattingDetailUI.kxz.jur);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            C2808i tv = cleanChattingDetailUI.kxz.mo23149tv(intValue);
            if (tv != null) {
                arrayList2.add(tv);
                cleanChattingDetailUI.kxz.iLD.remove(intValue);
            }
        }
        cleanChattingDetailUI.kxz.bgh();
        cleanChattingDetailUI.kxz.notifyDataSetChanged();
        cleanChattingDetailUI.kxD = new C45810b(null, arrayList2, cleanChattingDetailUI);
        C7305d.post(cleanChattingDetailUI.kxD, "delete-clean");
        cleanChattingDetailUI.ehJ.show();
        cleanChattingDetailUI.ehJ.setMessage(cleanChattingDetailUI.getString(C25738R.string.aqi, new Object[]{"0%"}));
        AppMethodBeat.m2505o(18777);
    }
}
