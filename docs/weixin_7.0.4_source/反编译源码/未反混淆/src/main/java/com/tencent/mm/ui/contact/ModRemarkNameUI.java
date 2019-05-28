package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import java.util.ArrayList;

public class ModRemarkNameUI extends MMActivity implements f {
    private String cIS;
    private ad ehM;
    private int gwP = 9;
    private String hHV = "";
    private bv pCq;
    private ArrayList<String> plC;
    private String pml;
    private MMTagPanel ppy;
    private TextView zlL;
    private View zlM;
    private View zlN;
    private TextView zlV;
    private EditText znO;
    private int znP;
    private String znQ = "";
    private TextView znR = null;
    private EditText znS = null;
    private TextView znT = null;
    private String znU = "";
    private boolean znV = false;
    private a znW = new a(this, (byte) 0);
    private View znX;

    class a implements OnClickListener {
        private a() {
        }

        /* synthetic */ a(ModRemarkNameUI modRemarkNameUI, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(33748);
            ModRemarkNameUI.k(ModRemarkNameUI.this);
            AppMethodBeat.o(33748);
        }
    }

    class c extends ClickableSpan {
        public String hHV;

        public c(String str) {
            this.hHV = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(33750);
            ModRemarkNameUI.this.znO.setText(j.b(ModRemarkNameUI.this, ah.nullAsNil(this.hHV), ModRemarkNameUI.this.znO.getTextSize()));
            ModRemarkNameUI.this.znO.setSelection(ModRemarkNameUI.this.znO.getText().length());
            ModRemarkNameUI.this.zlM.setVisibility(8);
            AppMethodBeat.o(33750);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(33751);
            textPaint.setColor(ModRemarkNameUI.this.getResources().getColor(R.color.hb));
            textPaint.setUnderlineText(false);
            AppMethodBeat.o(33751);
        }
    }

    class b implements TextWatcher {
        private int qkM;

        private b() {
            this.qkM = 800;
        }

        /* synthetic */ b(ModRemarkNameUI modRemarkNameUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(33749);
            this.qkM = com.tencent.mm.ui.tools.f.bP(800, editable.toString());
            if (this.qkM < 0) {
                this.qkM = 0;
            }
            if (ModRemarkNameUI.this.znT != null) {
                ModRemarkNameUI.this.znT.setText(this.qkM);
            }
            ModRemarkNameUI.j(ModRemarkNameUI.this);
            AppMethodBeat.o(33749);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ModRemarkNameUI() {
        AppMethodBeat.i(33752);
        AppMethodBeat.o(33752);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(33753);
        super.onCreate(bundle);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.znP = getIntent().getIntExtra("Contact_mode_name_type", 0);
        this.znQ = ah.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
        this.hHV = ah.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
        this.znV = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
        initView();
        this.znX = findViewById(R.id.dc8);
        if (this.znP != 0) {
            this.znX.setVisibility(8);
        } else {
            this.znX.setVisibility(0);
        }
        this.ppy = (MMTagPanel) findViewById(R.id.b5r);
        this.ppy.setPanelClickable(false);
        this.zlV = (TextView) findViewById(R.id.b5q);
        this.zlV.setText(R.string.d0x);
        this.ppy.setOnClickListener(this.znW);
        this.zlV.setOnClickListener(this.znW);
        if (this.ehM == null || !ad.aox(this.ehM.field_username)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.znO == null) {
                AppMethodBeat.o(33753);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.znO.getParent();
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                int id = childAt.getId();
                if (!(id == R.id.b5k || id == R.id.b5l)) {
                    childAt.setVisibility(8);
                }
                i++;
            }
        }
        AppMethodBeat.o(33753);
    }

    public final int getLayoutId() {
        return R.layout.ah7;
    }

    public final void initView() {
        AppMethodBeat.i(33754);
        this.cIS = getIntent().getStringExtra("Contact_User");
        if (this.cIS != null && this.cIS.length() > 0) {
            aw.ZK();
            this.ehM = com.tencent.mm.model.c.XM().aoO(this.cIS);
            aw.ZK();
            this.pCq = com.tencent.mm.model.c.XN().RB(this.cIS);
            if (this.ehM == null || ah.isNullOrNil(this.ehM.field_username)) {
                this.ehM = new ad(this.cIS);
                this.ehM.iB(ah.nullAsNil(this.znQ));
                this.ehM.iz(ah.nullAsNil(this.hHV));
            }
        }
        this.znO = (EditText) findViewById(R.id.b5l);
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.ui.widget.MMEditText.b() {
            public final void aqH() {
                AppMethodBeat.i(33744);
                if (ModRemarkNameUI.this.znO.getText().toString().trim().length() > 0) {
                    ModRemarkNameUI.this.enableOptionMenu(true);
                }
                AppMethodBeat.o(33744);
            }
        };
        com.tencent.mm.pluginsdk.ui.tools.g.a aVar = new com.tencent.mm.pluginsdk.ui.tools.g.a();
        aVar.vuS = anonymousClass1;
        this.znO.addTextChangedListener(aVar);
        com.tencent.mm.ui.tools.b.c.d(this.znO).PM(100).a(null);
        if (!(this.ehM == null || this.znP == 3)) {
            if (this.znP == 4) {
                this.znO.setText(j.b((Context) this, ah.nullAsNil(this.znQ), this.znO.getTextSize()));
            } else if (ah.isNullOrNil(this.ehM.field_conRemark)) {
                if (!ah.isNullOrNil(this.hHV)) {
                    this.znO.setText(j.b((Context) this, ah.nullAsNil(this.hHV), this.znO.getTextSize()));
                } else if (ah.isNullOrNil(this.ehM.field_nickname)) {
                    if (!ah.isNullOrNil(this.znQ)) {
                        this.znO.setText(j.b((Context) this, ah.nullAsNil(this.znQ), this.znO.getTextSize()));
                    } else if (JO()) {
                        this.znO.setText(j.b((Context) this, ah.nullAsNil(this.ehM.Oj()), this.znO.getTextSize()));
                    } else {
                        this.znO.setText("");
                    }
                } else if (this.znP != 0 || ah.isNullOrNil(this.znQ) || com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                    this.znO.setText(j.b((Context) this, ah.nullAsNil(this.ehM.field_nickname), this.znO.getTextSize()));
                } else {
                    this.znO.setText(j.b((Context) this, ah.nullAsNil(this.znQ), this.znO.getTextSize()));
                }
            } else if (this.znP != 0 || ah.isNullOrNil(this.hHV)) {
                this.znO.setText(j.b((Context) this, ah.nullAsNil(this.ehM.field_conRemark), this.znO.getTextSize()));
            } else {
                this.znO.setText(j.b((Context) this, this.hHV, this.znO.getTextSize()));
            }
            this.znO.setSelection(this.znO.getText().length());
        }
        TextView textView;
        if (this.znP == 0) {
            setMMTitle((int) R.string.axw);
            dIi();
        } else if (this.znP == 3) {
            setMMTitle((int) R.string.eua);
            this.znO.setHint("");
            if (!ah.isNullOrNil(this.znQ)) {
                this.znO.setText(this.znQ);
            }
            textView = (TextView) findViewById(R.id.b5k);
            textView.setText(R.string.e3y);
            textView.setVisibility(0);
            findViewById(R.id.dc9).setVisibility(8);
        } else if (this.znP == 4) {
            setMMTitle((int) R.string.dtf);
            this.znO.setHint("");
            textView = (TextView) findViewById(R.id.b5k);
            textView.setText(R.string.dus);
            textView.setVisibility(0);
        }
        addTextOptionMenu(0, getString(R.string.tc), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33745);
                switch (ModRemarkNameUI.this.znP) {
                    case 0:
                        ModRemarkNameUI.c(ModRemarkNameUI.this);
                        break;
                    case 3:
                        ModRemarkNameUI.d(ModRemarkNameUI.this);
                        break;
                    case 4:
                        ModRemarkNameUI.e(ModRemarkNameUI.this);
                        break;
                }
                AppMethodBeat.o(33745);
                return true;
            }
        });
        if (this.znO == null || this.znO.getText().toString().trim().length() <= 0) {
            enableOptionMenu(false);
        } else {
            enableOptionMenu(true);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33746);
                ModRemarkNameUI.this.finish();
                AppMethodBeat.o(33746);
                return true;
            }
        });
        this.znR = (TextView) findViewById(R.id.b5w);
        this.znS = (EditText) findViewById(R.id.b5u);
        this.znT = (TextView) findViewById(R.id.b5v);
        this.zlN = findViewById(R.id.b5t);
        com.tencent.mm.ui.tools.b.c.d(this.znS).PM(800).a(null);
        this.znT.setText(com.tencent.mm.ui.tools.f.bP(800, this.znS.getEditableText().toString()));
        this.znS.append(j.b((Context) this, ah.nullAsNil(this.znU), this.znS.getTextSize()));
        this.znR.append(j.b((Context) this, ah.nullAsNil(this.znU), this.znR.getTextSize()));
        if (this.pCq != null) {
            this.znS.setText(j.b((Context) this, ah.nullAsNil(this.pCq.field_conDescription), this.znS.getTextSize()));
            this.znR.setText(j.b((Context) this, ah.nullAsNil(this.pCq.field_conDescription), this.znS.getTextSize()));
        }
        this.znS.addTextChangedListener(new b(this, (byte) 0));
        this.znR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33747);
                ModRemarkNameUI.this.zlN.setVisibility(0);
                ModRemarkNameUI.this.znR.setVisibility(8);
                ModRemarkNameUI.this.znS.requestFocus();
                ModRemarkNameUI.this.showVKB();
                AppMethodBeat.o(33747);
            }
        });
        AppMethodBeat.o(33754);
    }

    public void onResume() {
        AppMethodBeat.i(33755);
        super.onResume();
        aw.ZK();
        this.pCq = com.tencent.mm.model.c.XN().RB(this.cIS);
        if (this.pCq != null) {
            this.pml = this.pCq.field_contactLabels;
            this.plC = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PF(this.pml);
        }
        if (ah.isNullOrNil(this.pml)) {
            this.ppy.setVisibility(8);
            this.zlV.setVisibility(0);
        } else {
            this.ppy.setVisibility(0);
            this.zlV.setVisibility(8);
            if (!(this.plC == null || this.plC.isEmpty())) {
                this.ppy.a(this.plC, this.plC);
                AppMethodBeat.o(33755);
                return;
            }
        }
        AppMethodBeat.o(33755);
    }

    private void dIi() {
        AppMethodBeat.i(33756);
        com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.ehM.field_username);
        if (vT == null || ah.isNullOrNil(vT.apA()) || vT.apA().equals(this.znO.getText())) {
            AppMethodBeat.o(33756);
            return;
        }
        this.zlL = (TextView) findViewById(R.id.b5o);
        this.zlM = findViewById(R.id.b5n);
        this.zlM.setVisibility(0);
        this.zlL.setText(ah.nullAsNil(getString(R.string.b05, new Object[]{vT.apA()})));
        k kVar = new k(getString(R.string.g1q));
        kVar.setSpan(new c(vT.apA()), 0, kVar.length(), 17);
        this.zlL.append(" ");
        this.zlL.append(kVar);
        this.zlL.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(33756);
    }

    private boolean JO() {
        AppMethodBeat.i(33757);
        String str = this.ehM.field_nickname;
        if (ah.isNullOrNil(str) || str.length() > 50) {
            AppMethodBeat.o(33757);
            return false;
        }
        AppMethodBeat.o(33757);
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.i(33758);
        super.onDestroy();
        AppMethodBeat.o(33758);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(33759);
        ab.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() == 44) {
            if (i != 0 && i2 < 0) {
                ab.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
                Toast.makeText(this, getString(R.string.duh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            finish();
        }
        AppMethodBeat.o(33759);
    }

    static /* synthetic */ void c(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(33760);
        if (!aw.RK()) {
            ab.e("MiroMsg.ModRemarkName", "!MMCore.hasSetUin()");
            AppMethodBeat.o(33760);
        } else if (modRemarkNameUI.znO == null) {
            ab.e("MiroMsg.ModRemarkName", "remarkName == null in dealModNickName(), return");
            AppMethodBeat.o(33760);
        } else {
            String trim = modRemarkNameUI.znO.getText().toString().trim();
            ab.i("MiroMsg.ModRemarkName", "Set New RemarkName : " + trim + ", Report kvStat, addContactScene = " + modRemarkNameUI.gwP);
            h.pYm.e(10448, Integer.valueOf(modRemarkNameUI.gwP));
            if (modRemarkNameUI.znV) {
                modRemarkNameUI.ehM.iz(trim);
                bv bvVar = new bv(modRemarkNameUI.ehM.field_username, trim);
                bvVar.field_conDescription = modRemarkNameUI.znS.getText().toString().trim();
                if (!ah.isNullOrNil(modRemarkNameUI.pml)) {
                    bvVar.field_contactLabels = modRemarkNameUI.pml;
                }
                aw.ZK();
                com.tencent.mm.model.c.XN().a(bvVar);
                if (modRemarkNameUI.ehM != null) {
                    aw.ZK();
                    com.tencent.mm.model.c.XM().b(modRemarkNameUI.ehM.field_username, modRemarkNameUI.ehM);
                }
            }
            modRemarkNameUI.finish();
            AppMethodBeat.o(33760);
        }
    }

    static /* synthetic */ void d(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(33761);
        String trim = modRemarkNameUI.znO.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("k_sns_tag_name", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        AppMethodBeat.o(33761);
    }

    static /* synthetic */ void e(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(33762);
        String trim = modRemarkNameUI.znO.getText().toString().trim();
        if (trim.length() > 50) {
            com.tencent.mm.ui.base.h.a(modRemarkNameUI.mController.ylL, modRemarkNameUI.getString(R.string.drq), modRemarkNameUI.getString(R.string.duu), modRemarkNameUI.getString(R.string.or), null);
            AppMethodBeat.o(33762);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Nick", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        com.tencent.mm.sdk.b.a.xxA.m(new tv());
        AppMethodBeat.o(33762);
    }

    static /* synthetic */ void j(ModRemarkNameUI modRemarkNameUI) {
        boolean z;
        AppMethodBeat.i(33763);
        String trim = modRemarkNameUI.znS.getText().toString().trim();
        if ((modRemarkNameUI.znU == null || !modRemarkNameUI.znU.equals(trim)) && !(ah.isNullOrNil(modRemarkNameUI.znU) && ah.isNullOrNil(trim))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            trim = modRemarkNameUI.znO.getText().toString().trim();
            if ((modRemarkNameUI.znO == null || !modRemarkNameUI.znO.equals(trim)) && !(ah.isNullOrNil(modRemarkNameUI.hHV) && ah.isNullOrNil(trim))) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                modRemarkNameUI.enableOptionMenu(false);
                AppMethodBeat.o(33763);
                return;
            }
        }
        modRemarkNameUI.enableOptionMenu(true);
        AppMethodBeat.o(33763);
    }

    static /* synthetic */ void k(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.i(33764);
        Intent intent = new Intent();
        if (modRemarkNameUI.plC != null) {
            intent.putStringArrayListExtra("label_str_list", modRemarkNameUI.plC);
        }
        intent.putExtra("is_stranger", true);
        intent.putExtra("label_username", modRemarkNameUI.cIS);
        d.b((Context) modRemarkNameUI, "label", ".ui.ContactLabelUI", intent);
        AppMethodBeat.o(33764);
    }
}
