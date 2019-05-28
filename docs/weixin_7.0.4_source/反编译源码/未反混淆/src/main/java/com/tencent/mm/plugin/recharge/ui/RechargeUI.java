package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.recharge.ui.MallEditText.b;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI extends MMActivity implements f, com.tencent.mm.platformtools.x.a, b {
    private Button gHn = null;
    protected Dialog gII = null;
    private boolean hZP = true;
    private TextView pHA = null;
    private TextView pHB = null;
    private TextView pHC = null;
    private FrameLayout pHD = null;
    private ImageView pHE = null;
    private ImageView pHF = null;
    private LinearLayout pHG = null;
    private a pHH = null;
    private a pHI = null;
    private MallEditText pHJ;
    private TextView pHK;
    private int pHL;
    private MallRechargeProduct pHM = null;
    private String pHN = null;
    private MallNews pHO = null;
    private boolean pHP = false;
    private Map<String, Integer> pHQ = new HashMap();
    private String pHR;
    public String pHS;
    private String pHT;
    public String pHU;
    private MallFunction pHj = null;
    private TextView pHz = null;
    private boolean piJ = false;
    private c piM = new c<uv>() {
        {
            AppMethodBeat.i(44315);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(44315);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44316);
            uv uvVar = (uv) bVar;
            if (uvVar instanceof uv) {
                if (uvVar.cRF.result != -1) {
                    ab.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                } else if (!RechargeUI.this.piJ) {
                    ab.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.cea().a(RechargeUI.this.pHJ.getInputRecord());
                    RechargeUI.this.finish();
                    RechargeUI.this.piJ = true;
                }
                AppMethodBeat.o(44316);
                return true;
            }
            ab.f("MicroMsg.MallRechargeUI", "mismatched event");
            AppMethodBeat.o(44316);
            return false;
        }
    };

    class a extends BaseAdapter {
        private List<MallRechargeProduct> pFZ;

        private a() {
            this.pFZ = null;
        }

        /* synthetic */ a(RechargeUI rechargeUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(44331);
            MallRechargeProduct BD = BD(i);
            AppMethodBeat.o(44331);
            return BD;
        }

        public final void cN(List<MallRechargeProduct> list) {
            AppMethodBeat.i(44325);
            this.pFZ = list;
            notifyDataSetChanged();
            AppMethodBeat.o(44325);
        }

        public final void BC(int i) {
            AppMethodBeat.i(44326);
            for (int i2 = 0; i2 < this.pFZ.size(); i2++) {
                ((MallRechargeProduct) this.pFZ.get(i2)).isDefault = false;
            }
            ((MallRechargeProduct) this.pFZ.get(i)).isDefault = true;
            AppMethodBeat.o(44326);
        }

        public final int getCount() {
            AppMethodBeat.i(44327);
            if (this.pFZ == null) {
                AppMethodBeat.o(44327);
                return 0;
            }
            int size = this.pFZ.size();
            AppMethodBeat.o(44327);
            return size;
        }

        public final MallRechargeProduct BD(int i) {
            AppMethodBeat.i(44328);
            MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) this.pFZ.get(i);
            AppMethodBeat.o(44328);
            return mallRechargeProduct;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(44329);
            if (BD(i).isValid()) {
                boolean isEnabled = super.isEnabled(i);
                AppMethodBeat.o(44329);
                return isEnabled;
            }
            AppMethodBeat.o(44329);
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(44330);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(RechargeUI.this, R.layout.anh, null);
            MallRechargeProduct BD = BD(i);
            checkedTextView.setText(BD.lcC);
            checkedTextView.setEnabled(BD.isValid());
            if (BD.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.o(44330);
            return checkedTextView;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RechargeUI() {
        AppMethodBeat.i(44332);
        AppMethodBeat.o(44332);
    }

    static /* synthetic */ String B(int i, String str, String str2) {
        AppMethodBeat.i(44363);
        String A = A(i, str, str2);
        AppMethodBeat.o(44363);
        return A;
    }

    static /* synthetic */ boolean b(RechargeUI rechargeUI) {
        AppMethodBeat.i(44358);
        boolean arW = rechargeUI.arW();
        AppMethodBeat.o(44358);
        return arW;
    }

    static /* synthetic */ void l(RechargeUI rechargeUI) {
        AppMethodBeat.i(44361);
        rechargeUI.cu();
        AppMethodBeat.o(44361);
    }

    static /* synthetic */ String m(RechargeUI rechargeUI) {
        AppMethodBeat.i(44362);
        String cer = rechargeUI.cer();
        AppMethodBeat.o(44362);
        return cer;
    }

    public final int getLayoutId() {
        return R.layout.ank;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44333);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.pHj = (MallFunction) intent.getParcelableExtra("key_func_info");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.hZP = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.pHj == null) {
            ab.e("MicroMsg.MallRechargeUI", "function info is null");
            t.makeText(this, "function info is null", 1).show();
            AppMethodBeat.o(44333);
            return;
        }
        if (parcelableArrayListExtra == null) {
            ab.d("MicroMsg.MallRechargeUI", "function info : " + this.pHj.cOI);
            p(new e(this.pHj.pFP));
        } else {
            this.pHM = a.cL(parcelableArrayListExtra);
        }
        ab.i("MicroMsg.MallRechargeUI", "onCreate()");
        this.pHO = com.tencent.mm.plugin.wallet_core.model.mall.c.cQT().acI(this.pHj.pFP);
        initView();
        AppMethodBeat.o(44333);
    }

    public final void initView() {
        AppMethodBeat.i(44334);
        setMMTitle(this.pHj.cOI);
        ab.v("MicroMsg.MallRechargeUI", "initView");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44307);
                RechargeUI.this.aqX();
                RechargeUI.this.finish();
                AppMethodBeat.o(44307);
                return true;
            }
        });
        this.pHz = (TextView) findViewById(R.id.dpq);
        this.pHA = (TextView) findViewById(R.id.dww);
        this.pHB = (TextView) findViewById(R.id.dwv);
        this.gHn = (Button) findViewById(R.id.ay8);
        this.pHG = (LinearLayout) findViewById(R.id.dwt);
        this.pHC = (TextView) findViewById(R.id.dwx);
        this.pHC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44317);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", RechargeUI.this.pHT);
                d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(44317);
            }
        });
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44318);
                if (RechargeUI.b(RechargeUI.this) && RechargeUI.c(RechargeUI.this)) {
                    RechargeUI.d(RechargeUI.this);
                }
                AppMethodBeat.o(44318);
            }
        });
        this.pHJ = (MallEditText) findViewById(R.id.dws);
        this.pHJ.setInfoTvOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44319);
                if (RechargeUI.this.pHJ.pGu) {
                    RechargeUI.this.pHJ.setInput(null);
                    AppMethodBeat.o(44319);
                    return;
                }
                RechargeUI.this.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
                AppMethodBeat.o(44319);
            }
        });
        this.pHK = (TextView) findViewById(R.id.dwu);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List f = f(0, parcelableArrayListExtra);
        List f2 = f(2, parcelableArrayListExtra);
        this.pHL = f.size() > f2.size() ? f.size() : f2.size();
        this.pHH = new a(this, (byte) 0);
        this.pHH.cN(f);
        this.pHI = new a(this, (byte) 0);
        this.pHI.cN(f2);
        this.pHG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44320);
                if ((RechargeUI.this.pHH != null && RechargeUI.this.pHH.getCount() > 0) || (RechargeUI.this.pHI != null && RechargeUI.this.pHI.getCount() > 0)) {
                    RechargeUI.this.showDialog(1);
                }
                AppMethodBeat.o(44320);
            }
        });
        this.pHD = (FrameLayout) findViewById(R.id.dwp);
        this.pHE = (ImageView) findViewById(R.id.dwq);
        this.pHF = (ImageView) findViewById(R.id.dwr);
        this.pHF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44321);
                com.tencent.mm.plugin.wallet_core.model.mall.c cQT = com.tencent.mm.plugin.wallet_core.model.mall.c.cQT();
                String str = RechargeUI.this.pHj.pFP;
                ab.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
                if (!bo.isNullOrNil(str) && cQT.tDE.containsKey(str)) {
                    MallNews mallNews = (MallNews) cQT.tDE.get(str);
                    if ("1".equals(mallNews.tDt)) {
                        mallNews.tDt = "2";
                        cQT.bZX();
                    }
                }
                RechargeUI.this.pHD.setVisibility(8);
                AppMethodBeat.o(44321);
            }
        });
        this.pHD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44322);
                if (!bo.isNullOrNil(RechargeUI.this.pHj.tDn.tDw)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", RechargeUI.this.pHj.tDn.tDw);
                    intent.putExtra("geta8key_username", r.Yz());
                    d.b(RechargeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(44322);
            }
        });
        this.pHJ.setOnInputValidChangeListener(this);
        this.pHJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44323);
                RechargeUI.this.pHJ.getFocus();
                if (RechargeUI.this.pHJ.getInputRecord().cvp == 2) {
                    RechargeUI.this.pHJ.setInput(null);
                }
                if (bo.isNullOrNil(RechargeUI.this.pHJ.getText().toString())) {
                    RechargeUI.this.pHJ.pGt.showDropDown();
                }
                RechargeUI.this.showVKB();
                AppMethodBeat.o(44323);
            }
        });
        ceg();
        x.a((com.tencent.mm.platformtools.x.a) this);
        cu();
        AppMethodBeat.o(44334);
    }

    private void cu() {
        AppMethodBeat.i(44335);
        ab.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.pHM);
        if (this.pHM != null) {
            this.pHK.setText(this.pHM.lcC);
            this.pHB.setText(a(this.pHM));
        }
        if (this.pHO != null && this.pHj.tDn != null && this.pHO.equals(this.pHj.tDn) && !"1".equals(this.pHO.tDt)) {
            this.pHD.setVisibility(8);
            ab.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.pHO.toString());
        } else if (this.pHj.tDn == null || bo.isNullOrNil(this.pHj.tDn.tDx)) {
            this.pHD.setVisibility(8);
            ab.d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.pHN = this.pHj.tDn.tDx;
            this.pHE.setImageBitmap(x.a(new com.tencent.mm.plugin.recharge.b.a(this.pHN)));
            this.pHD.setVisibility(0);
            ab.d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.pHA.setVisibility(4);
        if (!arW()) {
            this.pHz.setText("");
        } else if (!(this.pHM == null || ces())) {
            this.pHz.setText(this.pHM.pFQ);
            this.pHz.setTextColor(getResources().getColor(R.color.s0));
        }
        ceo();
        cep();
        AppMethodBeat.o(44335);
    }

    private void ceo() {
        AppMethodBeat.i(44336);
        String string = getString(R.string.cy_);
        if (!TextUtils.isEmpty(this.pHS)) {
            string = this.pHS;
        }
        if (!bo.isNullOrNil(this.pHR)) {
            addTextOptionMenu(0, string, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(44324);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", RechargeUI.this.pHR);
                    d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(44324);
                    return true;
                }
            });
        }
        AppMethodBeat.o(44336);
    }

    private void cep() {
        AppMethodBeat.i(44337);
        if (bo.isNullOrNil(this.pHT)) {
            this.pHC.setVisibility(8);
        } else {
            this.pHC.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.pHU)) {
            this.pHC.setText(this.pHU);
        }
        AppMethodBeat.o(44337);
    }

    private String a(MallRechargeProduct mallRechargeProduct) {
        AppMethodBeat.i(44338);
        String string;
        if (!mallRechargeProduct.isValid()) {
            string = getString(R.string.cyh);
            AppMethodBeat.o(44338);
            return string;
        } else if (mallRechargeProduct.pFR != mallRechargeProduct.pFS || (ces() && this.pHM.pFW)) {
            string = "";
            AppMethodBeat.o(44338);
            return string;
        } else {
            string = String.format(getString(R.string.cyk), new Object[]{Float.valueOf(mallRechargeProduct.pFR)});
            AppMethodBeat.o(44338);
            return string;
        }
    }

    private static List<MallRechargeProduct> f(int i, List<MallRechargeProduct> list) {
        AppMethodBeat.i(44339);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.fmR == i) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        AppMethodBeat.o(44339);
        return arrayList;
    }

    private void p(final m mVar) {
        AppMethodBeat.i(44340);
        if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX || mVar.getType() == 1555) {
            g.RQ();
            g.RO().eJo.a(mVar, 0);
            AppMethodBeat.o(44340);
        } else if (this.hZP) {
            if (this.gII == null || !(this.gII == null || this.gII.isShowing())) {
                this.gII = com.tencent.mm.wallet_core.ui.g.a(this.mController.ylL, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(44309);
                        g.RQ();
                        g.RO().eJo.c(mVar);
                        AppMethodBeat.o(44309);
                    }
                });
            }
            g.RQ();
            g.RO().eJo.a(mVar, 0);
            AppMethodBeat.o(44340);
        } else {
            g.RQ();
            g.RO().eJo.a(mVar, 0);
            AppMethodBeat.o(44340);
        }
    }

    private boolean arW() {
        boolean z;
        AppMethodBeat.i(44341);
        if (this.pHJ.cef()) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.pHM != null && this.pHM.isValid()) {
            if (ces() && this.pHM.pFW) {
                p(new com.tencent.mm.plugin.recharge.model.d(this.pHM.fmR, this.pHj.pFP, this.pHM.cwg, this.pHM.appId, ceq(), cer()));
            }
            aqX();
            this.gHn.setEnabled(true);
            this.gHn.setClickable(true);
            ab.d("MicroMsg.MallRechargeUI", "checkInfo : true");
            AppMethodBeat.o(44341);
            return true;
        }
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        ab.d("MicroMsg.MallRechargeUI", "checkInfo : false");
        AppMethodBeat.o(44341);
        return false;
    }

    private String ceq() {
        AppMethodBeat.i(44342);
        String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.ws(this.pHJ.getText());
        AppMethodBeat.o(44342);
        return str;
    }

    private String cer() {
        AppMethodBeat.i(44343);
        String ws = com.tencent.mm.plugin.recharge.model.b.ws(this.pHJ.getText());
        AppMethodBeat.o(44343);
        return ws;
    }

    private static String A(int i, String str, String str2) {
        AppMethodBeat.i(44344);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(44344);
        return stringBuilder2;
    }

    private boolean ces() {
        AppMethodBeat.i(44345);
        if (this.pHQ.containsKey(A(this.pHM.fmR, this.pHM.cwg, cer()))) {
            AppMethodBeat.o(44345);
            return false;
        }
        AppMethodBeat.o(44345);
        return true;
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(44346);
        if (!z) {
            this.pHQ.clear();
            this.pHz.setText("");
            this.pHA.setVisibility(4);
        }
        arW();
        AppMethodBeat.o(44346);
    }

    public final void ceg() {
        AppMethodBeat.i(44347);
        if (bo.isNullOrNil(this.pHJ.getText()) || this.pHJ.asa()) {
            this.pHJ.setInfoTvImageResource(R.drawable.yb);
            AppMethodBeat.o(44347);
            return;
        }
        this.pHJ.setInfoTvImageResource(R.drawable.r8);
        AppMethodBeat.o(44347);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44348);
        ab.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i + ", errCode = " + i2);
        if (!(this.gII == null || !this.gII.isShowing() || mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX)) {
            this.gII.dismiss();
            this.gII = null;
        }
        if (i == 0 && i2 == 0) {
            if (mVar instanceof e) {
                e eVar = (e) mVar;
                ArrayList arrayList = eVar.pGb;
                if (arrayList != null) {
                    this.pHM = a.cL(arrayList);
                    ab.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.pHM);
                }
                this.pHR = eVar.pGc;
                this.pHS = eVar.pGd;
                this.pHT = eVar.pGe;
                this.pHU = eVar.pGf;
                ab.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(arrayList)));
                cu();
                List f = f(0, arrayList);
                List f2 = f(2, arrayList);
                this.pHL = f.size() > f2.size() ? f.size() : f2.size();
                this.pHH.cN(f);
                this.pHI.cN(f2);
                AppMethodBeat.o(44348);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                ab.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.pHM);
                com.tencent.mm.plugin.recharge.model.d dVar = (com.tencent.mm.plugin.recharge.model.d) mVar;
                if (!(this.pHM == null || this.pHM.cwg == null || dVar.pFY == null || ((!this.pHM.cwg.equals(dVar.pFY.cwg) || !cer().equals(dVar.gyD)) && dVar.fmR == 2))) {
                    MallRechargeProduct.a(dVar.pFY, this.pHM);
                    this.pHM.isDefault = true;
                    this.pHQ.put(A(dVar.fmR, dVar.pFY.cwg, dVar.gyD), Integer.valueOf(1));
                    cu();
                    this.pHA.setText(str);
                    this.pHA.setVisibility(0);
                    this.pHA.setTextColor(getResources().getColor(R.color.ra));
                }
                if (dVar.fmR == 2) {
                    if (this.pHM == null || !this.pHM.cwg.equals(dVar.pGa) || !cer().equals(dVar.gyD)) {
                        this.gHn.setEnabled(true);
                        this.gHn.setClickable(true);
                        this.pHA.setText(null);
                    } else if (((ake) dVar.ehh.fsH.fsP).wjY == 0 && this.pHM.cwg.equals(dVar.pFY.cwg)) {
                        p(new com.tencent.mm.plugin.recharge.model.c(this.pHM.pFP, cer(), this.pHM.lcC, this.pHM.appId, ceq()));
                    } else {
                        this.gHn.setEnabled(false);
                        this.gHn.setClickable(false);
                        this.pHA.setText(((ake) dVar.ehh.fsH.fsP).wjZ);
                        this.pHA.setVisibility(0);
                        this.pHA.setTextColor(getResources().getColor(R.color.xy));
                    }
                }
                cM(dVar.pFZ);
                ab.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.pHM);
                AppMethodBeat.o(44348);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.recharge.model.g) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) mVar).pGr;
                payInfo.cIf = 6;
                payInfo.vwe = 100;
                h.a(this, payInfo, 2);
                com.tencent.mm.sdk.b.a.xxA.c(this.piM);
                AppMethodBeat.o(44348);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.recharge.model.c) {
                com.tencent.mm.plugin.recharge.model.c cVar = (com.tencent.mm.plugin.recharge.model.c) mVar;
                if (this.pHM == null || !this.pHM.lcC.equals(cVar.lcC) || !cer().equals(cVar.cFl)) {
                    this.gHn.setEnabled(true);
                    this.gHn.setClickable(true);
                    this.pHA.setText(null);
                } else if (((acg) cVar.ehh.fsH.fsP).wjY != 0) {
                    this.gHn.setEnabled(false);
                    this.gHn.setClickable(false);
                    this.pHA.setText(((acg) cVar.ehh.fsH.fsP).wjZ);
                    this.pHA.setVisibility(0);
                    this.pHA.setTextColor(getResources().getColor(R.color.xy));
                    AppMethodBeat.o(44348);
                    return;
                }
                AppMethodBeat.o(44348);
                return;
            }
        } else if (!(mVar instanceof com.tencent.mm.plugin.recharge.model.c)) {
            if (mVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                if (i2 == 100) {
                    this.gHn.setEnabled(true);
                    this.gHn.setClickable(true);
                } else {
                    this.gHn.setEnabled(false);
                    this.gHn.setClickable(false);
                }
                cM(((com.tencent.mm.plugin.recharge.model.d) mVar).pFZ);
                this.pHA.setText(str);
                this.pHA.setVisibility(0);
                this.pHA.setTextColor(getResources().getColor(R.color.xy));
                this.pHz.setText(((com.tencent.mm.plugin.recharge.model.d) mVar).pFQ);
                this.pHz.setTextColor(getResources().getColor(R.color.xy));
                AppMethodBeat.o(44348);
                return;
            }
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.fu2);
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        AppMethodBeat.o(44348);
    }

    public void onResume() {
        AppMethodBeat.i(44349);
        super.onResume();
        g.RQ();
        g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.a(1555, (f) this);
        AppMethodBeat.o(44349);
    }

    public void onPause() {
        AppMethodBeat.i(44350);
        super.onPause();
        g.RQ();
        g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.b(1555, (f) this);
        AppMethodBeat.o(44350);
    }

    private void cM(List<MallRechargeProduct> list) {
        AppMethodBeat.i(44351);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.fmR == 2) {
                    if (this.pHM != null && mallRechargeProduct.cwg.equals(this.pHM.cwg)) {
                        mallRechargeProduct.isDefault = true;
                        i = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (i == 0 && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.pHI.cN(arrayList);
            AppMethodBeat.o(44351);
            return;
        }
        this.pHI.cN(new ArrayList());
        AppMethodBeat.o(44351);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(44352);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS")) {
                            String str;
                            String str2;
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(query.getString(query.getColumnIndex("_id")))), null, null);
                                    if (query2.moveToFirst()) {
                                        str = null;
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string = query2.getString(columnIndex);
                                            String string2 = query2.getString(columnIndex2);
                                            ab.d("MicroMsg.MallRechargeUI", "username : ".concat(String.valueOf(string2)));
                                            if (string != null) {
                                                ab.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(string)));
                                                string = com.tencent.mm.plugin.recharge.model.b.ws(string);
                                                ab.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(string)));
                                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    string = str2;
                                                }
                                                ab.d("MicroMsg.MallRechargeUI", "phoneResult : ".concat(String.valueOf(string)));
                                            } else {
                                                string = str2;
                                            }
                                            query2.moveToNext();
                                            str = string2;
                                            str2 = string;
                                        }
                                    } else {
                                        str = null;
                                        str2 = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (!PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                        this.pHQ.clear();
                                        this.pHJ.setInput(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                        this.pHz.setText("");
                                        this.pHA.setVisibility(4);
                                        arW();
                                        break;
                                    }
                                    showDialog(2);
                                    break;
                                }
                            }
                            str = null;
                            str2 = null;
                            query.close();
                            if (!PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                            }
                            break;
                        }
                        ab.e("MicroMsg.MallRechargeUI", "no contact permission");
                        AppMethodBeat.o(44352);
                        return;
                    }
                    ab.e("MicroMsg.MallRechargeUI", "uri == null");
                    AppMethodBeat.o(44352);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.piJ) {
                        ab.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.cea().a(this.pHJ.getInputRecord());
                        finish();
                        this.piJ = true;
                        break;
                    }
                }
                ab.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(44352);
    }

    public void onDestroy() {
        AppMethodBeat.i(44353);
        com.tencent.mm.sdk.b.a.xxA.d(this.piM);
        super.onDestroy();
        AppMethodBeat.o(44353);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(44354);
        if (this.pHN == null) {
            AppMethodBeat.o(44354);
            return;
        }
        if (str.equals(this.pHN)) {
            this.pHE.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(44314);
                    RechargeUI.this.pHE.setImageBitmap(bitmap);
                    AppMethodBeat.o(44314);
                }
            });
        }
        AppMethodBeat.o(44354);
    }

    public final void showVKB() {
        AppMethodBeat.i(44355);
        ab.d("MicroMsg.MallRechargeUI", "showVKB");
        this.pHJ.setInfoTvImageResource(R.drawable.r8);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(44355);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(44355);
        } else if (currentFocus.getWindowToken() == null) {
            AppMethodBeat.o(44355);
        } else {
            inputMethodManager.showSoftInput(currentFocus, 2);
            AppMethodBeat.o(44355);
        }
    }

    public final void aqX() {
        AppMethodBeat.i(44356);
        ab.d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(44356);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(44356);
            return;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(44356);
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        AppMethodBeat.o(44356);
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.i(44357);
        switch (i) {
            case 1:
                final int color = getResources().getColor(R.color.a54);
                final int color2 = getResources().getColor(R.color.a61);
                View inflate = getLayoutInflater().inflate(R.layout.ang, null);
                final TextView textView = (TextView) inflate.findViewById(R.id.dwj);
                final ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.dwk);
                final ListViewInScrollView listViewInScrollView2 = (ListViewInScrollView) inflate.findViewById(R.id.dwl);
                final TextView textView2 = (TextView) inflate.findViewById(R.id.dwd);
                final View findViewById = inflate.findViewById(R.id.dwe);
                final TextView textView3 = (TextView) inflate.findViewById(R.id.dwg);
                final View findViewById2 = inflate.findViewById(R.id.dwh);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.dwi);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(R.dimen.mg) * this.pHL) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listViewInScrollView.setAdapter(this.pHH);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(44310);
                        RechargeUI.this.dismissDialog(1);
                        ab.d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(i)));
                        ab.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.pHM);
                        RechargeUI.this.pHM = RechargeUI.this.pHH.BD(i);
                        RechargeUI.this.pHH.BC(i);
                        RechargeUI.this.pHH.notifyDataSetChanged();
                        ab.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.pHM);
                        RechargeUI.l(RechargeUI.this);
                        AppMethodBeat.o(44310);
                    }
                });
                listViewInScrollView2.setAdapter(this.pHI);
                listViewInScrollView2.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(44311);
                        RechargeUI.this.dismissDialog(1);
                        ab.d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(i)));
                        RechargeUI.this.pHM = RechargeUI.this.pHI.BD(i);
                        RechargeUI.this.pHI.BC(i);
                        RechargeUI.this.pHI.notifyDataSetChanged();
                        RechargeUI.this.pHQ.remove(RechargeUI.B(RechargeUI.this.pHM.fmR, RechargeUI.this.pHM.cwg, RechargeUI.m(RechargeUI.this)));
                        RechargeUI.b(RechargeUI.this);
                        RechargeUI.l(RechargeUI.this);
                        AppMethodBeat.o(44311);
                    }
                });
                inflate.findViewById(R.id.dwc).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44312);
                        findViewById.setVisibility(0);
                        textView2.setTextColor(color2);
                        listViewInScrollView.setVisibility(0);
                        findViewById2.setVisibility(8);
                        textView3.setTextColor(color);
                        listViewInScrollView2.setVisibility(8);
                        if (RechargeUI.this.pHH.getCount() == 0) {
                            textView.setVisibility(0);
                            AppMethodBeat.o(44312);
                            return;
                        }
                        textView.setVisibility(8);
                        AppMethodBeat.o(44312);
                    }
                });
                final View view = findViewById2;
                final TextView textView4 = textView3;
                final int i2 = color2;
                final ListViewInScrollView listViewInScrollView3 = listViewInScrollView2;
                final View view2 = findViewById;
                final TextView textView5 = textView2;
                final int i3 = color;
                final ListViewInScrollView listViewInScrollView4 = listViewInScrollView;
                final TextView textView6 = textView;
                inflate.findViewById(R.id.dwf).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44313);
                        view.setVisibility(0);
                        textView4.setTextColor(i2);
                        listViewInScrollView3.setVisibility(0);
                        view2.setVisibility(8);
                        textView5.setTextColor(i3);
                        listViewInScrollView4.setVisibility(8);
                        if (RechargeUI.this.pHI.getCount() == 0) {
                            textView6.setVisibility(0);
                            AppMethodBeat.o(44313);
                            return;
                        }
                        textView6.setVisibility(8);
                        AppMethodBeat.o(44313);
                    }
                });
                if (this.pHH.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.asD(null);
                aVar.fn(inflate);
                aVar.f(null);
                Dialog aMb = aVar.aMb();
                AppMethodBeat.o(44357);
                return aMb;
            default:
                com.tencent.mm.ui.widget.a.c b = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cyj), "", true);
                AppMethodBeat.o(44357);
                return b;
        }
    }

    static /* synthetic */ boolean c(RechargeUI rechargeUI) {
        AppMethodBeat.i(44359);
        if (rechargeUI.pHJ.getInputRecord().cvp == 0) {
            Context context = rechargeUI;
            com.tencent.mm.ui.base.h.d(context, rechargeUI.getString(R.string.cyc, new Object[]{rechargeUI.pHJ.getText().toString()}), "", rechargeUI.getString(R.string.up), rechargeUI.getString(R.string.s2), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44308);
                    RechargeUI.d(RechargeUI.this);
                    AppMethodBeat.o(44308);
                }
            }, null);
            AppMethodBeat.o(44359);
            return false;
        }
        AppMethodBeat.o(44359);
        return true;
    }

    static /* synthetic */ void d(RechargeUI rechargeUI) {
        AppMethodBeat.i(44360);
        rechargeUI.p(new com.tencent.mm.plugin.recharge.model.g(rechargeUI.pHM, rechargeUI.ceq()));
        AppMethodBeat.o(44360);
    }
}
