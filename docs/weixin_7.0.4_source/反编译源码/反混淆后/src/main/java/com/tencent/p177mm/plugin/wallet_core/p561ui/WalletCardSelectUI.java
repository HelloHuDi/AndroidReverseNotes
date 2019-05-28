package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MaxListView;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI */
public class WalletCardSelectUI extends WalletBaseUI {
    private CheckedTextView tGA;
    private String tGB;
    private int tGC;
    private int tGD = -1;
    private int tGE = -1;
    private C29653a tGF;
    private MaxListView tGG;
    private List<ElementQuery> tGx = new LinkedList();
    private List<ElementQuery> tGy = new LinkedList();
    private CheckedTextView tGz;
    private int tmh = -1;
    private int trC = 3;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$2 */
    class C226042 implements OnMenuItemClickListener {
        C226042() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47297);
            WalletCardSelectUI.this.finish();
            AppMethodBeat.m2505o(47297);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$1 */
    class C296471 implements OnItemClickListener {
        C296471() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(47296);
            ElementQuery Hv = WalletCardSelectUI.this.tGF.mo47898Hv(i);
            if (C5046bo.isNullOrNil(Hv.tyK)) {
                if (Hv.cPr()) {
                    WalletCardSelectUI.this.tGD = i;
                } else {
                    WalletCardSelectUI.this.tGE = i;
                }
                WalletCardSelectUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(47296);
                return;
            }
            C30379h.m48448a(WalletCardSelectUI.this, Hv.tyK, null, true, null);
            AppMethodBeat.m2505o(47296);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$3 */
    class C296483 implements OnMenuItemClickListener {
        C296483() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47298);
            Parcelable parcelable = null;
            Intent intent = new Intent();
            if (WalletCardSelectUI.this.tGz.isChecked() && WalletCardSelectUI.this.tGD >= 0) {
                parcelable = (ElementQuery) WalletCardSelectUI.this.tGx.get(WalletCardSelectUI.this.tGD);
            } else if (WalletCardSelectUI.this.tGA.isChecked() && WalletCardSelectUI.this.tGE >= 0) {
                ElementQuery parcelable2 = (ElementQuery) WalletCardSelectUI.this.tGy.get(WalletCardSelectUI.this.tGE);
            }
            if (parcelable2 != null) {
                intent.putExtra("elemt_query", parcelable2);
                WalletCardSelectUI.this.setResult(-1, intent);
            } else {
                WalletCardSelectUI.this.setResult(0);
            }
            WalletCardSelectUI.this.finish();
            AppMethodBeat.m2505o(47298);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$4 */
    class C296494 implements OnClickListener {
        C296494() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47299);
            WalletCardSelectUI.m47024a(WalletCardSelectUI.this, true);
            AppMethodBeat.m2505o(47299);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$7 */
    class C296507 implements Comparator<ElementQuery> {
        C296507() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ElementQuery) obj2).tuo - ((ElementQuery) obj).tuo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$5 */
    class C296515 implements OnClickListener {
        C296515() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47300);
            WalletCardSelectUI.m47024a(WalletCardSelectUI.this, false);
            AppMethodBeat.m2505o(47300);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$6 */
    class C296526 implements Comparator<ElementQuery> {
        C296526() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ElementQuery) obj).tuo - ((ElementQuery) obj2).tuo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$a */
    public class C29653a extends BaseAdapter {
        private Context context;
        List<ElementQuery> items = new ArrayList();

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$a$a */
        class C14275a {
            CheckedTextView tGI;

            C14275a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(47306);
            ElementQuery Hv = mo47898Hv(i);
            AppMethodBeat.m2505o(47306);
            return Hv;
        }

        public C29653a(Context context) {
            AppMethodBeat.m2504i(47301);
            this.context = context;
            AppMethodBeat.m2505o(47301);
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(47302);
            boolean isNullOrNil = C5046bo.isNullOrNil(((ElementQuery) this.items.get(i)).tyK);
            AppMethodBeat.m2505o(47302);
            return isNullOrNil;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            AppMethodBeat.m2504i(47303);
            C14275a c14275a = new C14275a();
            View inflate = View.inflate(this.context, 2130971056, null);
            c14275a.tGI = (CheckedTextView) inflate.findViewById(2131828644);
            ElementQuery elementQuery = (ElementQuery) this.items.get(i);
            String bc = C5046bo.m7532bc(elementQuery.nuL, "");
            if (C5046bo.isNullOrNil(elementQuery.tyK)) {
                c14275a.tGI.setEnabled(true);
                Object charSequence2 = bc;
            } else {
                charSequence2 = bc + "[" + elementQuery.tyK + "]";
                c14275a.tGI.setEnabled(false);
            }
            c14275a.tGI.setText(charSequence2);
            AppMethodBeat.m2505o(47303);
            return inflate;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47304);
            int size = this.items.size();
            AppMethodBeat.m2505o(47304);
            return size;
        }

        /* renamed from: Hv */
        public final ElementQuery mo47898Hv(int i) {
            AppMethodBeat.m2504i(47305);
            ElementQuery elementQuery = (ElementQuery) this.items.get(i);
            AppMethodBeat.m2505o(47305);
            return elementQuery;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletCardSelectUI() {
        AppMethodBeat.m2504i(47307);
        AppMethodBeat.m2505o(47307);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47308);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.fcp);
        initView();
        this.tGy.clear();
        this.tGx.clear();
        if (C14241r.cPQ().tum != null) {
            for (ElementQuery elementQuery : C14241r.cPQ().tum) {
                if (this.tmh == 5 && !elementQuery.tza) {
                    elementQuery.tyK = getString(C25738R.string.fvu);
                }
                if (elementQuery.cPe()) {
                    this.tGy.add(elementQuery);
                } else if (elementQuery.cPr()) {
                    this.tGx.add(elementQuery);
                }
            }
        }
        if (this.trC == 3 && !this.tGy.isEmpty()) {
            if (C14241r.cPI().cQp()) {
                Collections.sort(this.tGy, new C296526());
            } else {
                Collections.sort(this.tGy, new C296507());
            }
        }
        int size;
        int i;
        if (this.tGx.isEmpty()) {
            size = this.tGy.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.tGy.get(i)).pbn.equals(this.tGB)) {
                    this.tGE = i;
                    m47032nj(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.tGE < 0) {
                m47032nj(false);
                enableOptionMenu(false);
            }
            this.tGz.setVisibility(8);
            this.tGA.setBackgroundResource(C25738R.drawable.f6623k5);
            this.tGA.setCheckMarkDrawable(C25738R.drawable.f7022yu);
            AppMethodBeat.m2505o(47308);
        } else if (C5046bo.isNullOrNil(this.tGB)) {
            this.tGz.setChecked(false);
            this.tGA.setChecked(false);
            this.tGG.setVisibility(8);
            AppMethodBeat.m2505o(47308);
        } else if (this.tGC == 2) {
            size = this.tGy.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.tGy.get(i)).pbn.equals(this.tGB)) {
                    this.tGE = i;
                    m47032nj(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.tGE < 0) {
                m47032nj(false);
                enableOptionMenu(false);
            }
            AppMethodBeat.m2505o(47308);
        } else {
            size = this.tGx.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.tGx.get(i)).pbn.equals(this.tGB)) {
                    this.tGD = i;
                    m47032nj(true);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.tGD < 0) {
                m47032nj(false);
                enableOptionMenu(false);
            }
            AppMethodBeat.m2505o(47308);
        }
    }

    /* renamed from: nj */
    private void m47032nj(boolean z) {
        AppMethodBeat.m2504i(47310);
        this.tGG.setVisibility(0);
        if (z) {
            this.tGz.setChecked(true);
            this.tGA.setChecked(false);
            this.tGF.items = this.tGx;
            this.tGF.notifyDataSetChanged();
            this.tGG.clearChoices();
            if (this.tGD >= 0) {
                this.tGG.setItemChecked(this.tGD, true);
                enableOptionMenu(true);
                AppMethodBeat.m2505o(47310);
                return;
            }
            enableOptionMenu(false);
            AppMethodBeat.m2505o(47310);
            return;
        }
        this.tGz.setChecked(false);
        this.tGA.setChecked(true);
        this.tGF.items = this.tGy;
        this.tGF.notifyDataSetChanged();
        this.tGG.clearChoices();
        if (this.tGE >= 0) {
            this.tGG.setItemChecked(this.tGE, true);
            enableOptionMenu(true);
            AppMethodBeat.m2505o(47310);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.m2505o(47310);
    }

    public final int getLayoutId() {
        return 2130971077;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final boolean bNf() {
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(47309);
        this.tGB = this.mBundle.getString("key_bank_type");
        this.tGC = this.mBundle.getInt("key_bankcard_type", 1);
        this.trC = this.mBundle.getInt("key_support_bankcard", 1);
        this.tmh = this.mBundle.getInt("key_bind_scene", -1);
        this.tGG = (MaxListView) findViewById(2131828743);
        this.tGz = (CheckedTextView) findViewById(2131828741);
        this.tGA = (CheckedTextView) findViewById(2131828742);
        this.tGF = new C29653a(this);
        this.tGG.setAdapter(this.tGF);
        this.tGG.setOnItemClickListener(new C296471());
        setBackBtn(new C226042());
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C296483(), C5535b.GREEN);
        enableOptionMenu(false);
        this.tGz.setOnClickListener(new C296494());
        this.tGA.setOnClickListener(new C296515());
        AppMethodBeat.m2505o(47309);
    }
}
