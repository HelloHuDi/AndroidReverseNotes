package com.tencent.p177mm.plugin.clean.p364ui.newui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import com.tencent.p177mm.plugin.clean.p362c.C27641b;
import com.tencent.p177mm.plugin.clean.p362c.C27642d;
import com.tencent.p177mm.plugin.clean.p362c.C33824h;
import com.tencent.p177mm.plugin.clean.p362c.C41261e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI */
public class CleanChattingDetailUI extends MMActivity implements C33824h {
    private ProgressDialog ehJ;
    private Button gzI;
    private int index;
    private View kxA;
    CheckBox kxB;
    MMAutoAdjustTextView kxC;
    private GridHeadersGridView kxy;
    private C27662b kyJ;
    private C27641b kyK;
    private C41261e kyL;

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI$5 */
    class C202465 implements OnClickListener {
        C202465() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(18867);
            if (CleanChattingDetailUI.this.kyK.kwf.size() == 0) {
                CleanChattingDetailUI.this.finish();
            }
            AppMethodBeat.m2505o(18867);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI$1 */
    class C202471 implements OnMenuItemClickListener {
        C202471() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18863);
            CleanChattingDetailUI.this.finish();
            AppMethodBeat.m2505o(18863);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI$2 */
    class C202482 implements View.OnClickListener {
        C202482() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18864);
            C27662b a = CleanChattingDetailUI.this.kyJ;
            if (a.jur.size() == a.iLD.size()) {
                a.jur.clear();
            } else {
                for (int i = 0; i < a.iLD.size(); i++) {
                    a.jur.add(Integer.valueOf(i));
                }
            }
            a.bgi();
            CleanChattingDetailUI.this.kyJ.notifyDataSetChanged();
            AppMethodBeat.m2505o(18864);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI$3 */
    class C202493 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI$3$2 */
        class C28122 implements OnClickListener {
            C28122() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI$3$1 */
        class C202451 implements OnClickListener {
            C202451() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18865);
                CleanChattingDetailUI.m31311b(CleanChattingDetailUI.this);
                AppMethodBeat.m2505o(18865);
            }
        }

        C202493() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18866);
            C30379h.m48466d(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(C25738R.string.at9), "", CleanChattingDetailUI.this.getString(C25738R.string.b53), CleanChattingDetailUI.this.getString(C25738R.string.abx), new C202451(), new C28122());
            AppMethodBeat.m2505o(18866);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI$4 */
    class C202504 implements OnCancelListener {
        C202504() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18868);
        super.onCreate(bundle);
        C27642d.bfZ();
        this.index = getIntent().getIntExtra("key_position", -1);
        if (this.index < 0) {
            finish();
            AppMethodBeat.m2505o(18868);
        } else if (C27642d.bfS() == null) {
            finish();
            AppMethodBeat.m2505o(18868);
        } else {
            this.kxA = findViewById(2131821612);
            this.kxB = (CheckBox) findViewById(2131821610);
            this.kxC = (MMAutoAdjustTextView) findViewById(2131822773);
            this.gzI = (Button) findViewById(2131822772);
            mo35491tx(0);
            this.kyK = (C27641b) C27642d.bfS().get(this.index);
            if (C1855t.m3896kH(this.kyK.username)) {
                setMMTitle(C1854s.getDisplayName(this.kyK.username, this.kyK.username));
            } else {
                setMMTitle(C1854s.m3866mJ(this.kyK.username));
            }
            this.kxy = (GridHeadersGridView) findViewById(2131822771);
            this.kxy.setNumColumns(3);
            this.kyJ = new C27662b(this, this.kyK.kwf);
            this.kxy.setOnHeaderClickListener(this.kyJ.kxn);
            this.kxy.setOnItemClickListener(this.kyJ.jMk);
            this.kxy.setOnScrollListener(this.kyJ.kxp);
            this.kxy.setAdapter(this.kyJ);
            setBackBtn(new C202471());
            this.kxA.setOnClickListener(new C202482());
            this.gzI.setOnClickListener(new C202493());
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.apz), false, new C202504());
            this.ehJ.dismiss();
            AppMethodBeat.m2505o(18868);
        }
    }

    public final int getLayoutId() {
        return 2130969142;
    }

    /* renamed from: tx */
    public final void mo35491tx(int i) {
        AppMethodBeat.m2504i(18869);
        this.gzI.setEnabled(i > 0);
        AppMethodBeat.m2505o(18869);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18870);
        if (this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.kyL != null) {
            this.kyL.bgb();
        }
        C27642d.bga();
        C27642d.bfY();
        super.onDestroy();
        AppMethodBeat.m2505o(18870);
    }

    /* renamed from: dP */
    public final void mo23158dP(int i, int i2) {
        AppMethodBeat.m2504i(18871);
        this.ehJ.setMessage(getString(C25738R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.m2505o(18871);
    }

    /* renamed from: hi */
    public final void mo23159hi(long j) {
        AppMethodBeat.m2504i(18872);
        this.ehJ.dismiss();
        C27642d.m43921hg(C27642d.bfW() + j);
        C27642d.m43918hd(C27642d.bfT() - j);
        C30379h.m48438a((Context) this, getString(C25738R.string.aq0, new Object[]{C5046bo.m7565ga(j)}), "", new C202465());
        AppMethodBeat.m2505o(18872);
    }

    /* renamed from: b */
    static /* synthetic */ void m31311b(CleanChattingDetailUI cleanChattingDetailUI) {
        AppMethodBeat.m2504i(18873);
        if (C27642d.bfQ() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(cleanChattingDetailUI.kyJ.jur);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                arrayList2.add(cleanChattingDetailUI.kyK.kwf.get(intValue));
                cleanChattingDetailUI.kyK.kwf.remove(intValue);
            }
            if (!cleanChattingDetailUI.kyK.bfI()) {
                C27642d.bfS().remove(cleanChattingDetailUI.index);
                C4990ab.m7417i("MicroMsg.CleanChattingDetailUI", "Delete username=%s", cleanChattingDetailUI.kyK.username);
            }
            cleanChattingDetailUI.kyJ.bgh();
            cleanChattingDetailUI.kyJ.notifyDataSetChanged();
            if (cleanChattingDetailUI.kyL != null) {
                cleanChattingDetailUI.kyL.bgb();
            }
            cleanChattingDetailUI.kyL = new C41261e(C27642d.bfQ(), cleanChattingDetailUI, arrayList2);
            cleanChattingDetailUI.kyL.start();
            cleanChattingDetailUI.ehJ.show();
            cleanChattingDetailUI.ehJ.setMessage(cleanChattingDetailUI.getString(C25738R.string.aqi, new Object[]{"0%"}));
        }
        AppMethodBeat.m2505o(18873);
    }
}
