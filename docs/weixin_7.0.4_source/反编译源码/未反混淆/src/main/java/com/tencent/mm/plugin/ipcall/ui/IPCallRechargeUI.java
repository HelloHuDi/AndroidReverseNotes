package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.a.e.g;
import com.tencent.mm.plugin.ipcall.a.e.h;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI extends MMActivity implements f {
    TextView kEq;
    private com.tencent.mm.pluginsdk.model.h.a lbF = new com.tencent.mm.pluginsdk.model.h.a() {
        public final void A(ArrayList<n> arrayList) {
            AppMethodBeat.i(22251);
            IPCallRechargeUI.this.nEl.nzj = bo.anU();
            if (arrayList == null || arrayList.size() <= 0) {
                if (IPCallRechargeUI.this.nBv != null && IPCallRechargeUI.this.nBv.isShowing()) {
                    IPCallRechargeUI.this.nBv.dismiss();
                }
                ab.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
                IPCallRechargeUI.this.lbo = 10236;
                IPCallRechargeUI.this.bIt();
                AppMethodBeat.o(22251);
                return;
            }
            IPCallRechargeUI.this.nEc = new String[arrayList.size()];
            IPCallRechargeUI.this.nEd = new String[arrayList.size()];
            n nVar = (n) arrayList.get(0);
            if (nVar.vbt == 10232) {
                ab.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    nVar = (n) it.next();
                    IPCallRechargeUI.this.nEc[i] = new BigDecimal(nVar.vbs).divide(new BigDecimal(1000000)).toString();
                    IPCallRechargeUI.this.nEd[i] = nVar.vbr;
                    i++;
                }
                if (IPCallRechargeUI.this.nEh > 0 && IPCallRechargeUI.this.nEd.length > 0) {
                    String str = IPCallRechargeUI.this.nEd[0];
                    if (!(bo.isNullOrNil(str) || str.equals(IPCallRechargeUI.this.nEf))) {
                        ab.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.this.nEf + ",google wallet currency:" + str);
                        IPCallRechargeUI.a(IPCallRechargeUI.this, str);
                        AppMethodBeat.o(22251);
                        return;
                    }
                }
                if (IPCallRechargeUI.this.nBv != null && IPCallRechargeUI.this.nBv.isShowing()) {
                    IPCallRechargeUI.this.nBv.dismiss();
                }
                IPCallRechargeUI.this.bIt();
                AppMethodBeat.o(22251);
                return;
            }
            if (IPCallRechargeUI.this.nBv != null && IPCallRechargeUI.this.nBv.isShowing()) {
                IPCallRechargeUI.this.nBv.dismiss();
            }
            IPCallRechargeUI.this.lbo = nVar.vbt;
            ab.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.this.lbo);
            IPCallRechargeUI.this.bIt();
            AppMethodBeat.o(22251);
        }
    };
    private int lbo = -1;
    private String[] lbs;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22253);
            switch (message.what) {
                case 1002:
                    IPCallRechargeUI.this.nEq.setVisibility(0);
                    IPCallRechargeUI.k(IPCallRechargeUI.this);
                    AppMethodBeat.o(22253);
                    return;
                default:
                    ab.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                    AppMethodBeat.o(22253);
                    return;
            }
        }
    };
    ProgressDialog nBv;
    private String[] nEc;
    private String[] nEd;
    private String nEe;
    private String nEf;
    private boolean nEg = false;
    private int nEh;
    private int nEi = -1;
    private String nEj;
    private String nEk;
    private h nEl = new h();
    private g nEm = new g();
    private j nEn = new j();
    RelativeLayout nEo;
    GridView nEp;
    ListView nEq;
    a nEr;
    Button nEs;
    com.tencent.mm.plugin.ipcall.a.d.f nEt;

    static class a extends BaseAdapter {
        private IPCallRechargeUI nEw = null;
        aqo nEx = null;
        List<crt> ngC = null;

        class a {
            TextView nDC;
            TextView nEA;
            TextView nEB;
            Button nEC;
            TextView nEz;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(IPCallRechargeUI iPCallRechargeUI) {
            AppMethodBeat.i(22264);
            Assert.assertTrue(true);
            this.nEw = iPCallRechargeUI;
            AppMethodBeat.o(22264);
        }

        public final int getCount() {
            AppMethodBeat.i(22265);
            if (this.ngC == null) {
                AppMethodBeat.o(22265);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.o(22265);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(22266);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.o(22266);
                return obj;
            }
            AppMethodBeat.o(22266);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(22267);
            if (view == null) {
                view = ((LayoutInflater) this.nEw.getSystemService("layout_inflater")).inflate(R.layout.a94, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.nDC = (TextView) view.findViewById(R.id.cne);
                aVar.nEz = (TextView) view.findViewById(R.id.cnf);
                aVar.nEA = (TextView) view.findViewById(R.id.cnh);
                aVar.nEB = (TextView) view.findViewById(R.id.cng);
                aVar.nEC = (Button) view.findViewById(R.id.cnc);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            crt crt = (crt) getItem(i);
            if (crt == null) {
                AppMethodBeat.o(22267);
            } else {
                aVar.nDC.setText(crt.wOs);
                aVar.nEz.setText(crt.xpq);
                aVar.nEA.setText(crt.xpr);
                if (bo.isNullOrNil(crt.xpr)) {
                    aVar.nEA.setVisibility(8);
                } else {
                    aVar.nEA.setVisibility(0);
                }
                if (this.nEx != null) {
                    aVar.nEB.setText(String.format(this.nEw.getString(R.string.chl), new Object[]{com.tencent.mm.plugin.ipcall.b.a.Pp(this.nEx.wuk), String.valueOf(crt.xpo)}));
                }
                aVar.nEC.setTag(Integer.valueOf(i));
                aVar.nEC.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Object obj;
                        AppMethodBeat.i(22263);
                        IPCallRechargeUI a = a.this.nEw;
                        if (com.tencent.mm.sdk.platformtools.g.dnY()) {
                            obj = null;
                        } else {
                            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(a);
                            aVar.PZ(R.string.cjc);
                            aVar.Qc(R.string.r4).a(new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(22467);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(22467);
                                }
                            });
                            aVar.aMb().show();
                            obj = 1;
                        }
                        if (obj != null) {
                            ab.i("MicroMsg.IPCallRechargeUI", "onClick recharged, non gp version!");
                            AppMethodBeat.o(22263);
                            return;
                        }
                        IPCallRechargeUI.b(a.this.nEw, ((Integer) view.getTag()).intValue());
                        AppMethodBeat.o(22263);
                    }
                });
                AppMethodBeat.o(22267);
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallRechargeUI() {
        AppMethodBeat.i(22268);
        AppMethodBeat.o(22268);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22269);
        super.onCreate(bundle);
        aw.Rg().a(929, (f) this);
        setMMTitle((int) R.string.chh);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22255);
                IPCallRechargeUI.this.finish();
                AppMethodBeat.o(22255);
                return true;
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22256);
                IPCallRechargeUI.h(IPCallRechargeUI.this);
                AppMethodBeat.o(22256);
                return true;
            }
        });
        this.nEo = (RelativeLayout) findViewById(R.id.bz0);
        this.nEp = (GridView) findViewById(R.id.cnj);
        this.nEq = (ListView) findViewById(R.id.cnb);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.mController.ylL, R.layout.a93, null);
        this.nEq.addFooterView(viewGroup, null, false);
        this.nEr = new a(this);
        this.nEq.setAdapter(this.nEr);
        this.kEq = (TextView) viewGroup.findViewById(R.id.n0);
        this.nEs = (Button) findViewById(R.id.cnk);
        String string = getString(R.string.chn);
        Spannable newSpannable = Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                AppMethodBeat.i(22257);
                ((TextView) view).setHighlightColor(IPCallRechargeUI.this.getResources().getColor(R.color.a3p));
                Intent intent = new Intent();
                String str = IPCallRechargeUI.this.getString(R.string.chm) + "&usedcc=";
                List bHf = c.bHc().bHf();
                if (bHf.size() > 0) {
                    int size = bHf.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String Pr = com.tencent.mm.plugin.ipcall.b.a.Pr(((Integer) bHf.get(i)).toString());
                        if (bo.isNullOrNil(Pr)) {
                            Pr = str;
                        } else {
                            Pr = str + Pr + "|";
                        }
                        i++;
                        str = Pr;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                } else {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.Pr(com.tencent.mm.plugin.ipcall.b.c.bIR());
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(22257);
            }

            public final void updateDrawState(TextPaint textPaint) {
                AppMethodBeat.i(22258);
                textPaint.setColor(IPCallRechargeUI.this.getResources().getColor(R.color.t7));
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(22258);
            }
        }, 0, string.length(), 33);
        this.kEq.setText(newSpannable);
        this.kEq.setMovementMethod(LinkMovementMethod.getInstance());
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.nBv = com.tencent.mm.ui.base.h.b(context, getString(R.string.ch0), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22259);
                try {
                    if (IPCallRechargeUI.this.nEt != null) {
                        aw.Rg().c(IPCallRechargeUI.this.nEt);
                    }
                    IPCallRechargeUI.this.finish();
                    AppMethodBeat.o(22259);
                } catch (Exception e) {
                    ab.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", e.getMessage());
                    AppMethodBeat.o(22259);
                }
            }
        });
        Ph("");
        this.nEl.start();
        com.tencent.mm.plugin.report.service.h.pYm.a(257, 4, 1, true);
        AppMethodBeat.o(22269);
    }

    public void onDestroy() {
        AppMethodBeat.i(22270);
        super.onDestroy();
        this.nEl.nyL = bo.anU();
        this.nEl.finish();
        aw.Rg().b(929, (f) this);
        AppMethodBeat.o(22270);
    }

    public final int getLayoutId() {
        return R.layout.a95;
    }

    private void Ph(String str) {
        String Pr;
        AppMethodBeat.i(22271);
        List bHf = c.bHc().bHf();
        if (bHf.size() == 0) {
            Pr = com.tencent.mm.plugin.ipcall.b.a.Pr(com.tencent.mm.plugin.ipcall.b.c.bIR());
        } else {
            Pr = com.tencent.mm.plugin.ipcall.b.a.Pr(((Integer) bHf.get(0)).toString());
        }
        this.nEt = new com.tencent.mm.plugin.ipcall.a.d.f(Pr, str);
        aw.Rg().a(this.nEt, 0);
        AppMethodBeat.o(22271);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22272);
        ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        boolean z;
        ArrayList stringArrayListExtra;
        if (i == 2001) {
            int intExtra;
            int intExtra2;
            String string;
            int i3;
            String str = "";
            z = false;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                int intExtra3 = intent.getIntExtra("key_gw_error_code", 0);
                intExtra2 = intent.getIntExtra("key_response_position", 0);
                if (intExtra == 100000001) {
                    z = true;
                }
                ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra3), Integer.valueOf(intExtra2), String.valueOf(z));
                if (intExtra != 6 || intExtra3 == 0) {
                    this.nEm.nzd = (long) intExtra;
                } else {
                    this.nEm.nzd = (long) intExtra3;
                }
                if (intExtra2 == 3) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 9, 1, true);
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 11, 1, true);
                    this.nEm.nzd = 0;
                    this.nEm.nze = 2;
                    string = getString(R.string.ck1);
                } else {
                    if (intExtra2 != 1) {
                        if (i2 == -1 && intExtra == 0) {
                            com.tencent.mm.plugin.report.service.h.pYm.a(257, 9, 1, true);
                            string = stringExtra;
                        } else if (z) {
                            com.tencent.mm.plugin.report.service.h.pYm.a(257, 9, 1, true);
                            com.tencent.mm.plugin.report.service.h.pYm.a(257, 12, 1, true);
                            this.nEm.nzd = 0;
                            this.nEm.nze = 1;
                        }
                    }
                    string = stringExtra;
                }
                this.nEm.nzc = longExtra;
                this.nEm.nyL = bo.anU();
                this.nEm.finish();
                i3 = intExtra3;
            } else {
                i3 = 0;
                intExtra2 = 0;
                intExtra = 0;
                string = str;
            }
            if (i2 == -1) {
                if (intent != null && intExtra == 0) {
                    stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                    intent.getStringArrayListExtra("key_response_series_ids");
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        ab.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", bo.nullAsNil((String) it.next()));
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 6, 1, true);
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 10, 1, true);
                    Toast.makeText(this, R.string.cj1, 0).show();
                    finish();
                    AppMethodBeat.o(22272);
                    return;
                } else if (intent != null && intExtra == 100000002) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 6, 1, true);
                    JD(string);
                    AppMethodBeat.o(22272);
                    return;
                } else if (intent != null && intExtra == 109) {
                    JD(string);
                    AppMethodBeat.o(22272);
                    return;
                } else if (intent != null && intExtra == 1) {
                    string = getString(R.string.ciz);
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 8, 1, true);
                    Toast.makeText(this, string, 0).show();
                    AppMethodBeat.o(22272);
                    return;
                } else if (intent == null || intExtra != 113) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 7, 1, true);
                    if (intExtra2 == 3) {
                        JD(string);
                        AppMethodBeat.o(22272);
                        return;
                    } else if (intExtra == 100000001 || intExtra == 6) {
                        if (i3 == 0) {
                            Toast.makeText(this, getString(R.string.cgx), 0).show();
                            AppMethodBeat.o(22272);
                            return;
                        }
                        string = getString(R.string.cgz);
                        if (!Pi(string)) {
                            Toast.makeText(this, string, 0).show();
                        }
                    }
                } else {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.cik), getString(R.string.cj0), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22261);
                            IPCallRechargeUI.j(IPCallRechargeUI.this);
                            AppMethodBeat.o(22261);
                        }
                    });
                    AppMethodBeat.o(22272);
                    return;
                }
            }
            AppMethodBeat.o(22272);
            return;
        }
        if (i == 2002) {
            if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
            }
            String str2 = "";
            int i4 = 0;
            int i5 = 0;
            z = false;
            if (intent != null) {
                i4 = intent.getIntExtra("key_err_code", 0);
                str2 = intent.getStringExtra("key_err_msg");
                i5 = intent.getIntExtra("key_response_position", 0);
                if (i4 == 100000001) {
                    z = true;
                }
                ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(i4), str2, Integer.valueOf(i5), String.valueOf(z));
            }
            CharSequence charSequence = str2;
            this.nEn.nzm = (long) i4;
            this.nEn.nzk = 0;
            if (i2 != -1) {
                this.nEn.nzl = 2;
                ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, R.string.cje, 0).show();
            } else if (intent == null || i4 != 0) {
                if (z) {
                    this.nEn.nzl = 1;
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 17, 1, true);
                    charSequence = getString(R.string.cjf);
                } else if (i5 == 3) {
                    this.nEn.nzl = 2;
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 16, 1, true);
                } else {
                    this.nEn.nzl = 2;
                }
                ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, charSequence, 0).show();
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    this.nEn.nzl = 3;
                    ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, R.string.cjf, 0).show();
                } else {
                    this.nEn.nzl = 0;
                    com.tencent.mm.plugin.report.service.h.pYm.a(257, 15, 1, true);
                    ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.cjg), getString(R.string.cjh), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22262);
                            IPCallRechargeUI.this.finish();
                            AppMethodBeat.o(22262);
                        }
                    });
                }
            }
            this.nEn.nyL = bo.anU();
            this.nEn.finish();
        }
        AppMethodBeat.o(22272);
    }

    private void JD(String str) {
        AppMethodBeat.i(22273);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.cj0);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.string.cj0), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(22273);
    }

    private boolean Pi(String str) {
        AppMethodBeat.i(22274);
        if (com.tencent.mm.plugin.ipcall.b.c.bIS() && this.nEi >= 0) {
            Object item = this.nEr.getItem(this.nEi);
            if ((item instanceof crt) && !bo.isNullOrNil(((crt) item).xpt)) {
                final String str2 = ((crt) item).xpt;
                ab.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(str2)));
                com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.string.cj0), getString(R.string.cib), getString(R.string.or), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22252);
                        com.tencent.mm.plugin.report.service.h.pYm.a(257, 3, 1, true);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("showShare", false);
                        d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(22252);
                    }
                }, null);
                AppMethodBeat.o(22274);
                return true;
            }
        }
        AppMethodBeat.o(22274);
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(22275);
        ab.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i2), str);
        if (mVar instanceof com.tencent.mm.plugin.ipcall.a.d.f) {
            h hVar = this.nEl;
            hVar.nzh = bo.anU();
            hVar.nzi = (long) i2;
            if (i == 0 && i2 == 0) {
                aqo aqo = ((com.tencent.mm.plugin.ipcall.a.d.f) mVar).nyq;
                this.nEr.ngC = aqo.CellList;
                this.nEr.nEx = aqo;
                this.nEr.notifyDataSetChanged();
                this.lbs = new String[aqo.CellList.size()];
                Iterator it = aqo.CellList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.lbs[i4] = ((crt) it.next()).ProductID;
                    i4++;
                }
                this.nEj = aqo.wup;
                this.nEk = aqo.wuq;
                this.nEe = aqo.wuk;
                this.nEf = aqo.wuo;
                this.nEh = aqo.wun;
                if (this.nEg) {
                    this.nEd = new String[aqo.CellList.size()];
                    for (int i5 = 0; i5 < this.nEd.length; i5++) {
                        this.nEd[i5] = aqo.wuo;
                    }
                    this.nEc = new String[aqo.CellList.size()];
                    while (i3 < this.nEc.length) {
                        this.nEc[i3] = IPCallDynamicTextView.Pg(((crt) aqo.CellList.get(i3)).wOs);
                        i3++;
                    }
                }
                if (((com.tencent.mm.plugin.ipcall.a.d.f) mVar).nyr) {
                    ab.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.lbs != null && this.lbs.length > 0) {
                        ab.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        com.tencent.mm.pluginsdk.model.h.a(this, this.lbs, this.lbF);
                    }
                    AppMethodBeat.o(22275);
                    return;
                }
                if (this.nBv != null && this.nBv.isShowing()) {
                    this.nBv.dismiss();
                }
                bIt();
                AppMethodBeat.o(22275);
                return;
            }
            if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
            }
            Toast.makeText(this.mController.ylL, getString(R.string.cgx), 0).show();
            finish();
        }
        AppMethodBeat.o(22275);
    }

    public final void bIt() {
        AppMethodBeat.i(22276);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
        AppMethodBeat.o(22276);
    }

    static /* synthetic */ void h(IPCallRechargeUI iPCallRechargeUI) {
        AppMethodBeat.i(22278);
        com.tencent.mm.ui.base.h.a(iPCallRechargeUI.mController.ylL, null, null, iPCallRechargeUI.getResources().getString(R.string.cjd), false, new com.tencent.mm.ui.base.h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(22260);
                switch (i) {
                    case 0:
                        ab.i("MicroMsg.IPCallRechargeUI", "start restore");
                        IPCallRechargeUI.this.nEn.start();
                        com.tencent.mm.plugin.report.service.h.pYm.a(257, 14, 1, true);
                        Intent intent = new Intent();
                        intent.putExtra("key_action_type", 200002);
                        intent.putExtra("key_force_google", true);
                        d.b(IPCallRechargeUI.this, "wallet_index", ".ui.WalletIapUI", intent, 2002);
                        IPCallRechargeUI iPCallRechargeUI = IPCallRechargeUI.this;
                        if (!iPCallRechargeUI.isFinishing()) {
                            Context context = iPCallRechargeUI.mController.ylL;
                            iPCallRechargeUI.getString(R.string.tz);
                            iPCallRechargeUI.nBv = com.tencent.mm.ui.base.h.b(context, iPCallRechargeUI.getString(R.string.ch0), false, null);
                            break;
                        }
                        ab.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                        AppMethodBeat.o(22260);
                        return;
                }
                AppMethodBeat.o(22260);
            }
        });
        AppMethodBeat.o(22278);
    }

    static /* synthetic */ void j(IPCallRechargeUI iPCallRechargeUI) {
        AppMethodBeat.i(22279);
        if (iPCallRechargeUI.nEr != null) {
            iPCallRechargeUI.nEr.ngC = null;
            iPCallRechargeUI.nEr.notifyDataSetChanged();
        }
        if (iPCallRechargeUI.nEq != null) {
            iPCallRechargeUI.nEq.setVisibility(4);
        }
        if (iPCallRechargeUI.nBv != null) {
            iPCallRechargeUI.nBv.show();
        }
        iPCallRechargeUI.Ph("");
        AppMethodBeat.o(22279);
    }

    static /* synthetic */ void k(IPCallRechargeUI iPCallRechargeUI) {
        AppMethodBeat.i(22280);
        if (!(bo.isNullOrNil(iPCallRechargeUI.nEj) || bo.isNullOrNil(iPCallRechargeUI.nEk))) {
            ab.i("MicroMsg.IPCallRechargeUI", "showGotoExchangeRecordsAlert");
            com.tencent.mm.ui.base.h.a((Context) iPCallRechargeUI, iPCallRechargeUI.nEk, iPCallRechargeUI.nEj, iPCallRechargeUI.getString(R.string.chi), iPCallRechargeUI.getString(R.string.chj), false, null, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22254);
                    IPCallRechargeUI.this.finish();
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", IPCallRechargeUI.this.getString(R.string.cgp));
                    intent.putExtra("showShare", false);
                    d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(22254);
                }
            });
        }
        AppMethodBeat.o(22280);
    }
}
