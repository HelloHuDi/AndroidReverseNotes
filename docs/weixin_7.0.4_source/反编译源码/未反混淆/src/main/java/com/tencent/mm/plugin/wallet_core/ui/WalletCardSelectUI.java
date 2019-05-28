package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI extends WalletBaseUI {
    private CheckedTextView tGA;
    private String tGB;
    private int tGC;
    private int tGD = -1;
    private int tGE = -1;
    private a tGF;
    private MaxListView tGG;
    private List<ElementQuery> tGx = new LinkedList();
    private List<ElementQuery> tGy = new LinkedList();
    private CheckedTextView tGz;
    private int tmh = -1;
    private int trC = 3;

    public class a extends BaseAdapter {
        private Context context;
        List<ElementQuery> items = new ArrayList();

        class a {
            CheckedTextView tGI;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(47306);
            ElementQuery Hv = Hv(i);
            AppMethodBeat.o(47306);
            return Hv;
        }

        public a(Context context) {
            AppMethodBeat.i(47301);
            this.context = context;
            AppMethodBeat.o(47301);
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(47302);
            boolean isNullOrNil = bo.isNullOrNil(((ElementQuery) this.items.get(i)).tyK);
            AppMethodBeat.o(47302);
            return isNullOrNil;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            AppMethodBeat.i(47303);
            a aVar = new a();
            View inflate = View.inflate(this.context, R.layout.b34, null);
            aVar.tGI = (CheckedTextView) inflate.findViewById(R.id.f6y);
            ElementQuery elementQuery = (ElementQuery) this.items.get(i);
            String bc = bo.bc(elementQuery.nuL, "");
            if (bo.isNullOrNil(elementQuery.tyK)) {
                aVar.tGI.setEnabled(true);
                Object charSequence2 = bc;
            } else {
                charSequence2 = bc + "[" + elementQuery.tyK + "]";
                aVar.tGI.setEnabled(false);
            }
            aVar.tGI.setText(charSequence2);
            AppMethodBeat.o(47303);
            return inflate;
        }

        public final int getCount() {
            AppMethodBeat.i(47304);
            int size = this.items.size();
            AppMethodBeat.o(47304);
            return size;
        }

        public final ElementQuery Hv(int i) {
            AppMethodBeat.i(47305);
            ElementQuery elementQuery = (ElementQuery) this.items.get(i);
            AppMethodBeat.o(47305);
            return elementQuery;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletCardSelectUI() {
        AppMethodBeat.i(47307);
        AppMethodBeat.o(47307);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47308);
        super.onCreate(bundle);
        setMMTitle((int) R.string.fcp);
        initView();
        this.tGy.clear();
        this.tGx.clear();
        if (r.cPQ().tum != null) {
            for (ElementQuery elementQuery : r.cPQ().tum) {
                if (this.tmh == 5 && !elementQuery.tza) {
                    elementQuery.tyK = getString(R.string.fvu);
                }
                if (elementQuery.cPe()) {
                    this.tGy.add(elementQuery);
                } else if (elementQuery.cPr()) {
                    this.tGx.add(elementQuery);
                }
            }
        }
        if (this.trC == 3 && !this.tGy.isEmpty()) {
            if (r.cPI().cQp()) {
                Collections.sort(this.tGy, new Comparator<ElementQuery>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ElementQuery) obj).tuo - ((ElementQuery) obj2).tuo;
                    }
                });
            } else {
                Collections.sort(this.tGy, new Comparator<ElementQuery>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ElementQuery) obj2).tuo - ((ElementQuery) obj).tuo;
                    }
                });
            }
        }
        int size;
        int i;
        if (this.tGx.isEmpty()) {
            size = this.tGy.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.tGy.get(i)).pbn.equals(this.tGB)) {
                    this.tGE = i;
                    nj(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.tGE < 0) {
                nj(false);
                enableOptionMenu(false);
            }
            this.tGz.setVisibility(8);
            this.tGA.setBackgroundResource(R.drawable.k5);
            this.tGA.setCheckMarkDrawable(R.drawable.yu);
            AppMethodBeat.o(47308);
        } else if (bo.isNullOrNil(this.tGB)) {
            this.tGz.setChecked(false);
            this.tGA.setChecked(false);
            this.tGG.setVisibility(8);
            AppMethodBeat.o(47308);
        } else if (this.tGC == 2) {
            size = this.tGy.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.tGy.get(i)).pbn.equals(this.tGB)) {
                    this.tGE = i;
                    nj(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.tGE < 0) {
                nj(false);
                enableOptionMenu(false);
            }
            AppMethodBeat.o(47308);
        } else {
            size = this.tGx.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.tGx.get(i)).pbn.equals(this.tGB)) {
                    this.tGD = i;
                    nj(true);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.tGD < 0) {
                nj(false);
                enableOptionMenu(false);
            }
            AppMethodBeat.o(47308);
        }
    }

    private void nj(boolean z) {
        AppMethodBeat.i(47310);
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
                AppMethodBeat.o(47310);
                return;
            }
            enableOptionMenu(false);
            AppMethodBeat.o(47310);
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
            AppMethodBeat.o(47310);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(47310);
    }

    public final int getLayoutId() {
        return R.layout.b3o;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final boolean bNf() {
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.i(47309);
        this.tGB = this.mBundle.getString("key_bank_type");
        this.tGC = this.mBundle.getInt("key_bankcard_type", 1);
        this.trC = this.mBundle.getInt("key_support_bankcard", 1);
        this.tmh = this.mBundle.getInt("key_bind_scene", -1);
        this.tGG = (MaxListView) findViewById(R.id.f9m);
        this.tGz = (CheckedTextView) findViewById(R.id.f9k);
        this.tGA = (CheckedTextView) findViewById(R.id.f9l);
        this.tGF = new a(this);
        this.tGG.setAdapter(this.tGF);
        this.tGG.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(47296);
                ElementQuery Hv = WalletCardSelectUI.this.tGF.Hv(i);
                if (bo.isNullOrNil(Hv.tyK)) {
                    if (Hv.cPr()) {
                        WalletCardSelectUI.this.tGD = i;
                    } else {
                        WalletCardSelectUI.this.tGE = i;
                    }
                    WalletCardSelectUI.this.enableOptionMenu(true);
                    AppMethodBeat.o(47296);
                    return;
                }
                h.a(WalletCardSelectUI.this, Hv.tyK, null, true, null);
                AppMethodBeat.o(47296);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47297);
                WalletCardSelectUI.this.finish();
                AppMethodBeat.o(47297);
                return true;
            }
        });
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47298);
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
                AppMethodBeat.o(47298);
                return true;
            }
        }, b.GREEN);
        enableOptionMenu(false);
        this.tGz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47299);
                WalletCardSelectUI.a(WalletCardSelectUI.this, true);
                AppMethodBeat.o(47299);
            }
        });
        this.tGA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47300);
                WalletCardSelectUI.a(WalletCardSelectUI.this, false);
                AppMethodBeat.o(47300);
            }
        });
        AppMethodBeat.o(47309);
    }
}
