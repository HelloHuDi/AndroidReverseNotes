package com.tencent.p177mm.plugin.nearlife.p471ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.modelgeo.C18657c;
import com.tencent.p177mm.modelgeo.C18657c.C18660a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.nearlife.p1494b.C46110b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.axx;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI */
public class NearLifeCreatePoiUI extends MMActivity implements C1202f {
    private TextWatcher arx = new C213787();
    private C44275p ejZ;
    private String hlm;
    private TextView oSA;
    private C18657c oSB;
    private C46110b oSC;
    private OnClickListener oSD = new C394631();
    private OnClickListener oSE = new C433442();
    private OnClickListener oSF = new C394643();
    private OnMenuItemClickListener oSG = new C286084();
    private C18660a oSH = new C127105();
    private OnMenuItemClickListener oSI = new C286096();
    private axx oSs;
    private String oSt;
    private String oSu;
    private Addr oSv;
    private String oSw;
    private EditText oSx;
    private EditText oSy;
    private TextView oSz;

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$5 */
    class C127105 implements C18660a {
        C127105() {
        }

        /* renamed from: b */
        public final void mo8746b(Addr addr) {
            AppMethodBeat.m2504i(22976);
            String str = C5046bo.nullAsNil(addr.fBi) + C5046bo.nullAsNil(addr.fBk);
            String str2 = C5046bo.nullAsNil(addr.fBl) + C5046bo.nullAsNil(addr.fBm);
            C4990ab.m7410d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str)));
            if (C5046bo.isNullOrNil(NearLifeCreatePoiUI.this.oSz.getText().toString())) {
                NearLifeCreatePoiUI.this.oSz.setText(str);
            }
            if (C5046bo.isNullOrNil(NearLifeCreatePoiUI.this.oSy.getText().toString()) && !C5046bo.isNullOrNil(str2)) {
                NearLifeCreatePoiUI.this.oSy.setText(str2);
            }
            NearLifeCreatePoiUI.this.oSv = addr;
            AppMethodBeat.m2505o(22976);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$7 */
    class C213787 implements TextWatcher {
        C213787() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(22978);
            if (NearLifeCreatePoiUI.this.oSx.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.oSy.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.oSz.getText().toString().trim().length() == 0) {
                NearLifeCreatePoiUI.this.enableOptionMenu(0, false);
                AppMethodBeat.m2505o(22978);
                return;
            }
            NearLifeCreatePoiUI.this.enableOptionMenu(0, true);
            AppMethodBeat.m2505o(22978);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$4 */
    class C286084 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$4$1 */
        class C286071 implements OnCancelListener {
            C286071() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(22974);
                C9638aw.m17182Rg().mo14547c(NearLifeCreatePoiUI.this.oSC);
                AppMethodBeat.m2505o(22974);
            }
        }

        C286084() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22975);
            C7060h.pYm.mo8381e(11138, "2", AppEventsConstants.EVENT_PARAM_VALUE_NO, NearLifeCreatePoiUI.this.hlm);
            NearLifeCreatePoiUI nearLifeCreatePoiUI = NearLifeCreatePoiUI.this;
            Context context = NearLifeCreatePoiUI.this.mController.ylL;
            NearLifeCreatePoiUI.this.getString(C25738R.string.d75);
            nearLifeCreatePoiUI.ejZ = C30379h.m48458b(context, NearLifeCreatePoiUI.this.getString(C25738R.string.d76), true, new C286071());
            NearLifeCreatePoiUI.this.oSt = NearLifeCreatePoiUI.this.oSx.getText().toString();
            NearLifeCreatePoiUI.this.oSu = NearLifeCreatePoiUI.this.oSz.getText().toString();
            NearLifeCreatePoiUI.this.oSw = NearLifeCreatePoiUI.this.oSy.getText().toString();
            String obj = ((EditText) NearLifeCreatePoiUI.this.findViewById(2131826286)).getText().toString();
            LinkedList g = NearLifeCreatePoiUI.m77344g(NearLifeCreatePoiUI.this);
            NearLifeCreatePoiUI.this.oSC = new C46110b(NearLifeCreatePoiUI.this.oSt, NearLifeCreatePoiUI.this.oSu, NearLifeCreatePoiUI.this.oSw, NearLifeCreatePoiUI.this.oSs, g.size(), g, obj);
            C9638aw.m17182Rg().mo14541a(NearLifeCreatePoiUI.this.oSC, 0);
            C4990ab.m7410d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
            AppMethodBeat.m2505o(22975);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$6 */
    class C286096 implements OnMenuItemClickListener {
        C286096() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22977);
            NearLifeCreatePoiUI.m77349l(NearLifeCreatePoiUI.this);
            AppMethodBeat.m2505o(22977);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$1 */
    class C394631 implements OnClickListener {
        C394631() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22971);
            Intent intent = new Intent();
            intent.putExtra("ui_title", C25738R.string.d7e);
            if (NearLifeCreatePoiUI.this.oSv != null) {
                intent.putExtra("extra_province", NearLifeCreatePoiUI.this.oSv.fBh);
                intent.putExtra("extra_city", NearLifeCreatePoiUI.this.oSv.fBi);
            }
            C25985d.m41468b(NearLifeCreatePoiUI.this.mController.ylL, "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
            AppMethodBeat.m2505o(22971);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$3 */
    class C394643 implements OnClickListener {
        C394643() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22973);
            NearLifeCreatePoiUI.this.findViewById(2131826282).setVisibility(8);
            NearLifeCreatePoiUI.this.findViewById(2131826283).setVisibility(0);
            NearLifeCreatePoiUI.this.findViewById(2131826285).setVisibility(0);
            AppMethodBeat.m2505o(22973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$8 */
    class C433438 implements DialogInterface.OnClickListener {
        C433438() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22979);
            C7060h.pYm.mo8381e(11138, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, AppEventsConstants.EVENT_PARAM_VALUE_NO, NearLifeCreatePoiUI.this.hlm);
            NearLifeCreatePoiUI.this.setResult(0, new Intent());
            NearLifeCreatePoiUI.this.finish();
            AppMethodBeat.m2505o(22979);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI$2 */
    class C433442 implements OnClickListener {
        C433442() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22972);
            Intent intent = new Intent();
            intent.setClass(NearLifeCreatePoiUI.this.mController.ylL, SelectPoiCategoryUI.class);
            NearLifeCreatePoiUI.this.startActivityForResult(intent, 2);
            AppMethodBeat.m2505o(22972);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NearLifeCreatePoiUI() {
        AppMethodBeat.m2504i(22980);
        AppMethodBeat.m2505o(22980);
    }

    /* renamed from: l */
    static /* synthetic */ void m77349l(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        AppMethodBeat.m2504i(22989);
        nearLifeCreatePoiUI.bVq();
        AppMethodBeat.m2505o(22989);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22981);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(650, (C1202f) this);
        this.oSs = new axx();
        this.oSs.vRq = getIntent().getFloatExtra("get_lat", -85.0f);
        this.oSs.vRp = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.oSs.wfG = getIntent().getIntExtra("get_preci", 0);
        this.oSs.wfI = "";
        this.oSs.wfJ = 0;
        this.oSs.wfH = "";
        this.oSB = C18657c.agw();
        if (this.oSB != null) {
            this.oSB.mo33923a((double) this.oSs.vRq, (double) this.oSs.vRp, this.oSH);
        }
        this.hlm = getIntent().getStringExtra("search_id");
        C4990ab.m7411d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", this.hlm);
        initView();
        AppMethodBeat.m2505o(22981);
    }

    public final int getLayoutId() {
        return 2130970282;
    }

    public final void initView() {
        AppMethodBeat.m2504i(22982);
        setMMTitle((int) C25738R.string.d75);
        ((ViewGroup) findViewById(2131826279)).setOnClickListener(this.oSD);
        ((ViewGroup) findViewById(2131826283)).setOnClickListener(this.oSE);
        ((TextView) findViewById(2131826282)).setOnClickListener(this.oSF);
        findViewById(2131826282).setVisibility(8);
        findViewById(2131826283).setVisibility(0);
        findViewById(2131826285).setVisibility(0);
        this.oSx = (EditText) findViewById(2131826278);
        this.oSy = (EditText) findViewById(2131826281);
        this.oSz = (TextView) findViewById(2131826280);
        this.oSA = (TextView) findViewById(2131826284);
        this.oSx.addTextChangedListener(this.arx);
        this.oSy.addTextChangedListener(this.arx);
        this.oSz.addTextChangedListener(this.arx);
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("get_poi_name"), "");
        if (bc.length() != 0) {
            this.oSx.setText(bc);
            this.oSx.setSelection(bc.length());
        }
        C7357c.m12555d(this.oSx).mo15877PM(100).mo15879a(null);
        C7357c.m12555d(this.oSy).mo15877PM(400).mo15879a(null);
        C7357c.m12555d((EditText) findViewById(2131826286)).mo15877PM(100).mo15879a(null);
        mo17379a(0, getString(C25738R.string.f9142qt), this.oSG, C5535b.GREEN);
        enableOptionMenu(0, false);
        setBackBtn(this.oSI);
        AppMethodBeat.m2505o(22982);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22983);
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    ((TextView) findViewById(2131826280)).setText(stringExtra.replace(" ", ""));
                    AppMethodBeat.m2505o(22983);
                    return;
                }
                break;
            case 2:
                if (-1 == i2 && intent != null) {
                    this.oSA.setText(C5046bo.nullAsNil(intent.getStringExtra("poi_category")));
                    break;
                }
        }
        AppMethodBeat.m2505o(22983);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22984);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(650, (C1202f) this);
        AppMethodBeat.m2505o(22984);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(22985);
        if (4 == keyEvent.getKeyCode()) {
            bVq();
            AppMethodBeat.m2505o(22985);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(22985);
        return onKeyDown;
    }

    private void bVq() {
        AppMethodBeat.m2504i(22986);
        C30379h.m48432a((Context) this, (int) C25738R.string.d6z, (int) C25738R.string.d75, new C433438(), null);
        AppMethodBeat.m2505o(22986);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22987);
        C4990ab.m7417i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            this.ejZ.dismiss();
            C46110b c46110b = (C46110b) c1207m;
            Intent intent = new Intent();
            if (this.oSs != null) {
                intent.putExtra("get_lat", this.oSs.vRq);
                intent.putExtra("get_lng", this.oSs.vRp);
            }
            if (this.oSv != null) {
                intent.putExtra("get_city", this.oSv.fBi);
            }
            intent.putExtra("get_poi_address", this.oSu);
            intent.putExtra("get_poi_classify_id", c46110b.oRf);
            intent.putExtra("get_poi_name", this.oSt);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(22987);
            return;
        }
        this.ejZ.dismiss();
        Toast.makeText(this.mController.ylL, getString(C25738R.string.d73), 1).show();
        this.oSC = null;
        AppMethodBeat.m2505o(22987);
    }

    /* renamed from: g */
    static /* synthetic */ LinkedList m77344g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        AppMethodBeat.m2504i(22988);
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(2131826284)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new bts().alV(charSequence));
        AppMethodBeat.m2505o(22988);
        return linkedList;
    }
}
