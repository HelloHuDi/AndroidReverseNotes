package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements OnClickListener {
    private List<l> uYY;
    private List<l> uYZ = new ArrayList();
    private l uZa;
    private l uZb;
    private int uZc = -1;
    private boolean uZd;
    private boolean uZe;
    private TextView uZf;
    private TextView uZg;
    private TextView uZh;
    private TextView uZi;
    private TextView uZj;
    private TextView uZk;
    private EditText uZl;
    private EditText uZm;
    private EditText uZn;
    private EditText uZo;
    private BaseAdapter uZp = new BaseAdapter() {
        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(48702);
            l Km = Km(i);
            AppMethodBeat.o(48702);
            return Km;
        }

        public final int getCount() {
            AppMethodBeat.i(48699);
            if (WalletWXCreditChangeAmountUI.this.uYZ != null) {
                int size = WalletWXCreditChangeAmountUI.this.uYZ.size();
                AppMethodBeat.o(48699);
                return size;
            }
            AppMethodBeat.o(48699);
            return 0;
        }

        private l Km(int i) {
            AppMethodBeat.i(48700);
            l lVar = (l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
            AppMethodBeat.o(48700);
            return lVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(48701);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, R.layout.b4p, null);
            l Km = Km(i);
            checkedTextView.setText(Km.desc);
            checkedTextView.setChecked(Km.uYP != 0);
            AppMethodBeat.o(48701);
            return checkedTextView;
        }
    };
    private BaseAdapter uZq = new BaseAdapter() {
        public final int getCount() {
            return 2;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            AppMethodBeat.i(48689);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, R.layout.b4p, null);
            if (i == 0) {
                checkedTextView.setText(R.string.up);
            } else {
                checkedTextView.setText(R.string.s2);
            }
            if (WalletWXCreditChangeAmountUI.this.uZe) {
                if (WalletWXCreditChangeAmountUI.this.uZa.uYS == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.uZa.nYb)) {
                    if (i == 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                } else {
                    if (i != 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                }
            } else if (WalletWXCreditChangeAmountUI.this.uZb.uYS == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.uZb.nYb)) {
                if (i == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
            AppMethodBeat.o(48689);
            return checkedTextView;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(48690);
            l lVar = (l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
            AppMethodBeat.o(48690);
            return lVar;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletWXCreditChangeAmountUI() {
        AppMethodBeat.i(48703);
        AppMethodBeat.o(48703);
    }

    static /* synthetic */ void k(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.i(48712);
        walletWXCreditChangeAmountUI.cu();
        AppMethodBeat.o(48712);
    }

    public final int getLayoutId() {
        return R.layout.b6k;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48704);
        super.onCreate(bundle);
        initView();
        cu();
        AppMethodBeat.o(48704);
    }

    public final void initView() {
        AppMethodBeat.i(48705);
        setMMTitle((int) R.string.fxf);
        this.uZf = (TextView) findViewById(R.id.fhq);
        this.uZh = (TextView) findViewById(R.id.fht);
        this.uZg = (TextView) findViewById(R.id.fhv);
        this.uZi = (TextView) findViewById(R.id.fhy);
        this.uZl = (EditText) findViewById(R.id.fhr);
        this.uZm = (EditText) findViewById(R.id.fhu);
        this.uZn = (EditText) findViewById(R.id.fhw);
        this.uZo = (EditText) findViewById(R.id.fhz);
        this.uZj = (TextView) findViewById(R.id.fhs);
        this.uZk = (TextView) findViewById(R.id.fhx);
        this.uZj.setOnClickListener(this);
        this.uZk.setOnClickListener(this);
        this.uZf.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48688);
                WalletWXCreditChangeAmountUI.this.uZd = true;
                WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
                WalletWXCreditChangeAmountUI.this.showDialog(1);
                AppMethodBeat.o(48688);
            }
        });
        this.uZg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48692);
                WalletWXCreditChangeAmountUI.this.uZd = false;
                WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
                WalletWXCreditChangeAmountUI.this.showDialog(1);
                AppMethodBeat.o(48692);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48693);
                WalletWXCreditChangeAmountUI.this.aqX();
                WalletWXCreditChangeAmountUI.this.showDialog(3);
                AppMethodBeat.o(48693);
                return true;
            }
        });
        findViewById(R.id.ay8).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48694);
                if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
                    if (WalletWXCreditChangeAmountUI.this.uZa.uYS == null) {
                        WalletWXCreditChangeAmountUI.this.uZa.nYb = WalletWXCreditChangeAmountUI.this.uZl.getText().toString();
                    } else if (WalletWXCreditChangeAmountUI.this.uZm.getVisibility() == 0) {
                        WalletWXCreditChangeAmountUI.this.uZa.uYS.nYb = WalletWXCreditChangeAmountUI.this.uZm.getText().toString();
                    }
                    if (WalletWXCreditChangeAmountUI.this.uZb.uYS == null) {
                        WalletWXCreditChangeAmountUI.this.uZb.nYb = WalletWXCreditChangeAmountUI.this.uZn.getText().toString();
                    } else if (WalletWXCreditChangeAmountUI.this.uZo.getVisibility() == 0) {
                        WalletWXCreditChangeAmountUI.this.uZb.uYS.nYb = WalletWXCreditChangeAmountUI.this.uZo.getText().toString();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(WalletWXCreditChangeAmountUI.this.uZa);
                    arrayList.add(WalletWXCreditChangeAmountUI.this.uZb);
                    String string = WalletWXCreditChangeAmountUI.this.mBundle.getString("kreq_token");
                    WalletWXCreditChangeAmountUI.this.mBundle.getString("key_bank_type");
                    WalletWXCreditChangeAmountUI.this.a(new c(arrayList, string), true, false);
                    AppMethodBeat.o(48694);
                    return;
                }
                t.makeText(WalletWXCreditChangeAmountUI.this.mController.ylL, R.string.fxb, 0).show();
                AppMethodBeat.o(48694);
            }
        });
        AppMethodBeat.o(48705);
    }

    private void cu() {
        AppMethodBeat.i(48706);
        if (this.uZa != null) {
            this.uZf.setText(this.uZa.desc);
            if (this.uZa.uYS != null) {
                this.uZj.setVisibility(0);
                this.uZl.setVisibility(8);
                this.uZh.setText(this.uZa.uYS.desc);
                this.uZm.setHint(this.uZa.uYS.kfM);
                if ("Y".equals(this.uZa.nYb)) {
                    this.uZh.setVisibility(0);
                    this.uZm.setVisibility(0);
                    this.uZj.setText(R.string.up);
                } else {
                    this.uZh.setVisibility(8);
                    this.uZm.setVisibility(8);
                    if ("N".equals(this.uZa.nYb)) {
                        this.uZj.setText(R.string.s2);
                    }
                }
            } else {
                this.uZj.setVisibility(8);
                this.uZl.setVisibility(0);
                this.uZl.setHint(this.uZa.kfM);
                this.uZh.setVisibility(8);
                this.uZm.setVisibility(8);
            }
        }
        if (this.uZb != null) {
            this.uZg.setText(this.uZb.desc);
            if (this.uZb.uYS != null) {
                this.uZk.setVisibility(0);
                this.uZn.setVisibility(8);
                this.uZi.setText(this.uZb.uYS.desc);
                this.uZo.setHint(this.uZb.uYS.kfM);
                if ("Y".equals(this.uZb.nYb)) {
                    this.uZi.setVisibility(0);
                    this.uZo.setVisibility(0);
                    this.uZk.setText(R.string.up);
                    AppMethodBeat.o(48706);
                    return;
                }
                this.uZi.setVisibility(8);
                this.uZo.setVisibility(8);
                if ("N".equals(this.uZb.nYb)) {
                    this.uZk.setText(R.string.s2);
                    AppMethodBeat.o(48706);
                    return;
                }
            }
            this.uZk.setVisibility(8);
            this.uZn.setVisibility(0);
            this.uZn.setHint(this.uZb.kfM);
            this.uZi.setVisibility(8);
            this.uZo.setVisibility(8);
        }
        AppMethodBeat.o(48706);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48707);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof e) {
                this.uYY = ((e) mVar).uYx;
                this.uZc = ((e) mVar).uYy;
                if (this.uYY != null && this.uYY.size() >= 2) {
                    this.uZa = (l) this.uYY.get(0);
                    this.uZb = (l) this.uYY.get(1);
                    this.uZa.uYP = 1;
                    this.uZb.uYP = 2;
                }
                cu();
                AppMethodBeat.o(48707);
                return true;
            }
        } else if (mVar instanceof c) {
            h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(48691);
                    com.tencent.mm.wallet_core.c aE = a.aE(WalletWXCreditChangeAmountUI.this);
                    if (aE != null) {
                        aE.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.mBundle);
                        AppMethodBeat.o(48691);
                        return;
                    }
                    WalletWXCreditChangeAmountUI.this.finish();
                    AppMethodBeat.o(48691);
                }
            });
            AppMethodBeat.o(48707);
            return true;
        }
        AppMethodBeat.o(48707);
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.i(48708);
        if (view.getId() == R.id.fhs) {
            this.uZe = true;
            showDialog(2);
            AppMethodBeat.o(48708);
            return;
        }
        if (view.getId() == R.id.fhx) {
            this.uZe = false;
            showDialog(2);
        }
        AppMethodBeat.o(48708);
    }

    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.i(48709);
        View inflate;
        ListViewInScrollView listViewInScrollView;
        com.tencent.mm.ui.widget.a.c.a aVar;
        Dialog aMb;
        switch (i) {
            case 1:
                inflate = getLayoutInflater().inflate(R.layout.b4o, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.n3);
                listViewInScrollView.setAdapter(this.uZp);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(48695);
                        WalletWXCreditChangeAmountUI.this.dismissDialog(1);
                        if (WalletWXCreditChangeAmountUI.this.uZd) {
                            WalletWXCreditChangeAmountUI.this.uZa.uYP = 0;
                            WalletWXCreditChangeAmountUI.this.uZa = (l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
                            WalletWXCreditChangeAmountUI.this.uZa.uYP = 1;
                        } else {
                            WalletWXCreditChangeAmountUI.this.uZb.uYP = 0;
                            WalletWXCreditChangeAmountUI.this.uZb = (l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
                            WalletWXCreditChangeAmountUI.this.uZb.uYP = 2;
                        }
                        WalletWXCreditChangeAmountUI.k(WalletWXCreditChangeAmountUI.this);
                        AppMethodBeat.o(48695);
                    }
                });
                aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.PV(R.string.fxd);
                aVar.fn(inflate);
                aVar.f(null);
                aMb = aVar.aMb();
                AppMethodBeat.o(48709);
                return aMb;
            case 2:
                inflate = getLayoutInflater().inflate(R.layout.b4o, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.n3);
                listViewInScrollView.setAdapter(this.uZq);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(48696);
                        WalletWXCreditChangeAmountUI.this.dismissDialog(2);
                        if (WalletWXCreditChangeAmountUI.this.uZe) {
                            if (i == 0) {
                                WalletWXCreditChangeAmountUI.this.uZa.nYb = "Y";
                            } else {
                                WalletWXCreditChangeAmountUI.this.uZa.nYb = "N";
                            }
                        } else if (i == 0) {
                            WalletWXCreditChangeAmountUI.this.uZb.nYb = "Y";
                        } else {
                            WalletWXCreditChangeAmountUI.this.uZb.nYb = "N";
                        }
                        WalletWXCreditChangeAmountUI.k(WalletWXCreditChangeAmountUI.this);
                        AppMethodBeat.o(48696);
                    }
                });
                aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.PV(R.string.fx_);
                aVar.fn(inflate);
                aVar.f(null);
                aMb = aVar.aMb();
                AppMethodBeat.o(48709);
                return aMb;
            case 3:
                String string = getString(R.string.fxc);
                if (this.uZc > 0) {
                    string = getString(R.string.fxa, new Object[]{Integer.valueOf(this.uZc)});
                }
                aMb = h.a((Context) this, string, null, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(48697);
                        com.tencent.mm.wallet_core.c aE = a.aE(WalletWXCreditChangeAmountUI.this);
                        if (aE != null) {
                            aE.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.mBundle);
                            AppMethodBeat.o(48697);
                            return;
                        }
                        WalletWXCreditChangeAmountUI.this.finish();
                        AppMethodBeat.o(48697);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(48698);
                        WalletWXCreditChangeAmountUI.this.showVKB();
                        AppMethodBeat.o(48698);
                    }
                });
                AppMethodBeat.o(48709);
                return aMb;
            default:
                com.tencent.mm.ui.widget.a.c b = h.b((Context) this, "", "", true);
                AppMethodBeat.o(48709);
                return b;
        }
    }

    static /* synthetic */ void a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.i(48710);
        walletWXCreditChangeAmountUI.uYZ.clear();
        if (walletWXCreditChangeAmountUI.uZd) {
            for (l lVar : walletWXCreditChangeAmountUI.uYY) {
                if (lVar.uYP != 2) {
                    walletWXCreditChangeAmountUI.uYZ.add(lVar);
                }
            }
            AppMethodBeat.o(48710);
            return;
        }
        for (l lVar2 : walletWXCreditChangeAmountUI.uYY) {
            if (lVar2.uYP != 1) {
                walletWXCreditChangeAmountUI.uYZ.add(lVar2);
            }
        }
        AppMethodBeat.o(48710);
    }

    static /* synthetic */ boolean b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.i(48711);
        if (walletWXCreditChangeAmountUI.uZa == null || walletWXCreditChangeAmountUI.uZb == null) {
            AppMethodBeat.o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZl.getVisibility() == 0 && bo.isNullOrNil(walletWXCreditChangeAmountUI.uZl.getText().toString())) {
            AppMethodBeat.o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZm.getVisibility() == 0 && bo.isNullOrNil(walletWXCreditChangeAmountUI.uZm.getText().toString())) {
            AppMethodBeat.o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZj.getVisibility() == 0 && bo.isNullOrNil(walletWXCreditChangeAmountUI.uZj.getText().toString())) {
            AppMethodBeat.o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZn.getVisibility() == 0 && bo.isNullOrNil(walletWXCreditChangeAmountUI.uZn.getText().toString())) {
            AppMethodBeat.o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZo.getVisibility() == 0 && bo.isNullOrNil(walletWXCreditChangeAmountUI.uZo.getText().toString())) {
            AppMethodBeat.o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZk.getVisibility() == 0 && bo.isNullOrNil(walletWXCreditChangeAmountUI.uZk.getText().toString())) {
            AppMethodBeat.o(48711);
            return false;
        } else {
            AppMethodBeat.o(48711);
            return true;
        }
    }
}
