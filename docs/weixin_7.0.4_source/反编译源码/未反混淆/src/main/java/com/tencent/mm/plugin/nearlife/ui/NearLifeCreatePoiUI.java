package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

public class NearLifeCreatePoiUI extends MMActivity implements f {
    private TextWatcher arx = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(22978);
            if (NearLifeCreatePoiUI.this.oSx.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.oSy.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.oSz.getText().toString().trim().length() == 0) {
                NearLifeCreatePoiUI.this.enableOptionMenu(0, false);
                AppMethodBeat.o(22978);
                return;
            }
            NearLifeCreatePoiUI.this.enableOptionMenu(0, true);
            AppMethodBeat.o(22978);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private p ejZ;
    private String hlm;
    private TextView oSA;
    private c oSB;
    private b oSC;
    private OnClickListener oSD = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22971);
            Intent intent = new Intent();
            intent.putExtra("ui_title", R.string.d7e);
            if (NearLifeCreatePoiUI.this.oSv != null) {
                intent.putExtra("extra_province", NearLifeCreatePoiUI.this.oSv.fBh);
                intent.putExtra("extra_city", NearLifeCreatePoiUI.this.oSv.fBi);
            }
            d.b(NearLifeCreatePoiUI.this.mController.ylL, "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
            AppMethodBeat.o(22971);
        }
    };
    private OnClickListener oSE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22972);
            Intent intent = new Intent();
            intent.setClass(NearLifeCreatePoiUI.this.mController.ylL, SelectPoiCategoryUI.class);
            NearLifeCreatePoiUI.this.startActivityForResult(intent, 2);
            AppMethodBeat.o(22972);
        }
    };
    private OnClickListener oSF = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22973);
            NearLifeCreatePoiUI.this.findViewById(R.id.dg4).setVisibility(8);
            NearLifeCreatePoiUI.this.findViewById(R.id.dg5).setVisibility(0);
            NearLifeCreatePoiUI.this.findViewById(R.id.dg7).setVisibility(0);
            AppMethodBeat.o(22973);
        }
    };
    private OnMenuItemClickListener oSG = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(22975);
            h.pYm.e(11138, "2", AppEventsConstants.EVENT_PARAM_VALUE_NO, NearLifeCreatePoiUI.this.hlm);
            NearLifeCreatePoiUI nearLifeCreatePoiUI = NearLifeCreatePoiUI.this;
            Context context = NearLifeCreatePoiUI.this.mController.ylL;
            NearLifeCreatePoiUI.this.getString(R.string.d75);
            nearLifeCreatePoiUI.ejZ = com.tencent.mm.ui.base.h.b(context, NearLifeCreatePoiUI.this.getString(R.string.d76), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(22974);
                    aw.Rg().c(NearLifeCreatePoiUI.this.oSC);
                    AppMethodBeat.o(22974);
                }
            });
            NearLifeCreatePoiUI.this.oSt = NearLifeCreatePoiUI.this.oSx.getText().toString();
            NearLifeCreatePoiUI.this.oSu = NearLifeCreatePoiUI.this.oSz.getText().toString();
            NearLifeCreatePoiUI.this.oSw = NearLifeCreatePoiUI.this.oSy.getText().toString();
            String obj = ((EditText) NearLifeCreatePoiUI.this.findViewById(R.id.dg8)).getText().toString();
            LinkedList g = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
            NearLifeCreatePoiUI.this.oSC = new b(NearLifeCreatePoiUI.this.oSt, NearLifeCreatePoiUI.this.oSu, NearLifeCreatePoiUI.this.oSw, NearLifeCreatePoiUI.this.oSs, g.size(), g, obj);
            aw.Rg().a(NearLifeCreatePoiUI.this.oSC, 0);
            ab.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
            AppMethodBeat.o(22975);
            return true;
        }
    };
    private a oSH = new a() {
        public final void b(Addr addr) {
            AppMethodBeat.i(22976);
            String str = bo.nullAsNil(addr.fBi) + bo.nullAsNil(addr.fBk);
            String str2 = bo.nullAsNil(addr.fBl) + bo.nullAsNil(addr.fBm);
            ab.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str)));
            if (bo.isNullOrNil(NearLifeCreatePoiUI.this.oSz.getText().toString())) {
                NearLifeCreatePoiUI.this.oSz.setText(str);
            }
            if (bo.isNullOrNil(NearLifeCreatePoiUI.this.oSy.getText().toString()) && !bo.isNullOrNil(str2)) {
                NearLifeCreatePoiUI.this.oSy.setText(str2);
            }
            NearLifeCreatePoiUI.this.oSv = addr;
            AppMethodBeat.o(22976);
        }
    };
    private OnMenuItemClickListener oSI = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(22977);
            NearLifeCreatePoiUI.l(NearLifeCreatePoiUI.this);
            AppMethodBeat.o(22977);
            return true;
        }
    };
    private axx oSs;
    private String oSt;
    private String oSu;
    private Addr oSv;
    private String oSw;
    private EditText oSx;
    private EditText oSy;
    private TextView oSz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NearLifeCreatePoiUI() {
        AppMethodBeat.i(22980);
        AppMethodBeat.o(22980);
    }

    static /* synthetic */ void l(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        AppMethodBeat.i(22989);
        nearLifeCreatePoiUI.bVq();
        AppMethodBeat.o(22989);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22981);
        super.onCreate(bundle);
        aw.Rg().a(650, (f) this);
        this.oSs = new axx();
        this.oSs.vRq = getIntent().getFloatExtra("get_lat", -85.0f);
        this.oSs.vRp = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.oSs.wfG = getIntent().getIntExtra("get_preci", 0);
        this.oSs.wfI = "";
        this.oSs.wfJ = 0;
        this.oSs.wfH = "";
        this.oSB = c.agw();
        if (this.oSB != null) {
            this.oSB.a((double) this.oSs.vRq, (double) this.oSs.vRp, this.oSH);
        }
        this.hlm = getIntent().getStringExtra("search_id");
        ab.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", this.hlm);
        initView();
        AppMethodBeat.o(22981);
    }

    public final int getLayoutId() {
        return R.layout.aia;
    }

    public final void initView() {
        AppMethodBeat.i(22982);
        setMMTitle((int) R.string.d75);
        ((ViewGroup) findViewById(R.id.dg1)).setOnClickListener(this.oSD);
        ((ViewGroup) findViewById(R.id.dg5)).setOnClickListener(this.oSE);
        ((TextView) findViewById(R.id.dg4)).setOnClickListener(this.oSF);
        findViewById(R.id.dg4).setVisibility(8);
        findViewById(R.id.dg5).setVisibility(0);
        findViewById(R.id.dg7).setVisibility(0);
        this.oSx = (EditText) findViewById(R.id.dg0);
        this.oSy = (EditText) findViewById(R.id.dg3);
        this.oSz = (TextView) findViewById(R.id.dg2);
        this.oSA = (TextView) findViewById(R.id.dg6);
        this.oSx.addTextChangedListener(this.arx);
        this.oSy.addTextChangedListener(this.arx);
        this.oSz.addTextChangedListener(this.arx);
        String bc = bo.bc(getIntent().getStringExtra("get_poi_name"), "");
        if (bc.length() != 0) {
            this.oSx.setText(bc);
            this.oSx.setSelection(bc.length());
        }
        com.tencent.mm.ui.tools.b.c.d(this.oSx).PM(100).a(null);
        com.tencent.mm.ui.tools.b.c.d(this.oSy).PM(400).a(null);
        com.tencent.mm.ui.tools.b.c.d((EditText) findViewById(R.id.dg8)).PM(100).a(null);
        a(0, getString(R.string.qt), this.oSG, q.b.GREEN);
        enableOptionMenu(0, false);
        setBackBtn(this.oSI);
        AppMethodBeat.o(22982);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22983);
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!bo.isNullOrNil(stringExtra)) {
                    ((TextView) findViewById(R.id.dg2)).setText(stringExtra.replace(" ", ""));
                    AppMethodBeat.o(22983);
                    return;
                }
                break;
            case 2:
                if (-1 == i2 && intent != null) {
                    this.oSA.setText(bo.nullAsNil(intent.getStringExtra("poi_category")));
                    break;
                }
        }
        AppMethodBeat.o(22983);
    }

    public void onDestroy() {
        AppMethodBeat.i(22984);
        super.onDestroy();
        aw.Rg().b(650, (f) this);
        AppMethodBeat.o(22984);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(22985);
        if (4 == keyEvent.getKeyCode()) {
            bVq();
            AppMethodBeat.o(22985);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(22985);
        return onKeyDown;
    }

    private void bVq() {
        AppMethodBeat.i(22986);
        com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.d6z, (int) R.string.d75, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(22979);
                h.pYm.e(11138, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, AppEventsConstants.EVENT_PARAM_VALUE_NO, NearLifeCreatePoiUI.this.hlm);
                NearLifeCreatePoiUI.this.setResult(0, new Intent());
                NearLifeCreatePoiUI.this.finish();
                AppMethodBeat.o(22979);
            }
        }, null);
        AppMethodBeat.o(22986);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22987);
        ab.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            this.ejZ.dismiss();
            b bVar = (b) mVar;
            Intent intent = new Intent();
            if (this.oSs != null) {
                intent.putExtra("get_lat", this.oSs.vRq);
                intent.putExtra("get_lng", this.oSs.vRp);
            }
            if (this.oSv != null) {
                intent.putExtra("get_city", this.oSv.fBi);
            }
            intent.putExtra("get_poi_address", this.oSu);
            intent.putExtra("get_poi_classify_id", bVar.oRf);
            intent.putExtra("get_poi_name", this.oSt);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(22987);
            return;
        }
        this.ejZ.dismiss();
        Toast.makeText(this.mController.ylL, getString(R.string.d73), 1).show();
        this.oSC = null;
        AppMethodBeat.o(22987);
    }

    static /* synthetic */ LinkedList g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        AppMethodBeat.i(22988);
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(R.id.dg6)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new bts().alV(charSequence));
        AppMethodBeat.o(22988);
        return linkedList;
    }
}
