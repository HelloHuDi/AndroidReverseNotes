package com.tencent.p177mm.p612ui.contact;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26245tv;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMTagPanel;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5621b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14985g.C14984a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI */
public class ModRemarkNameUI extends MMActivity implements C1202f {
    private String cIS;
    private C7616ad ehM;
    private int gwP = 9;
    private String hHV = "";
    private C7575bv pCq;
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
    private C30634a znW = new C30634a(this, (byte) 0);
    private View znX;

    /* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI$4 */
    class C157984 implements OnClickListener {
        C157984() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33747);
            ModRemarkNameUI.this.zlN.setVisibility(0);
            ModRemarkNameUI.this.znR.setVisibility(8);
            ModRemarkNameUI.this.znS.requestFocus();
            ModRemarkNameUI.this.showVKB();
            AppMethodBeat.m2505o(33747);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI$2 */
    class C239052 implements OnMenuItemClickListener {
        C239052() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33745);
            switch (ModRemarkNameUI.this.znP) {
                case 0:
                    ModRemarkNameUI.m48842c(ModRemarkNameUI.this);
                    break;
                case 3:
                    ModRemarkNameUI.m48843d(ModRemarkNameUI.this);
                    break;
                case 4:
                    ModRemarkNameUI.m48844e(ModRemarkNameUI.this);
                    break;
            }
            AppMethodBeat.m2505o(33745);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI$3 */
    class C306333 implements OnMenuItemClickListener {
        C306333() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33746);
            ModRemarkNameUI.this.finish();
            AppMethodBeat.m2505o(33746);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI$a */
    class C30634a implements OnClickListener {
        private C30634a() {
        }

        /* synthetic */ C30634a(ModRemarkNameUI modRemarkNameUI, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33748);
            ModRemarkNameUI.m48850k(ModRemarkNameUI.this);
            AppMethodBeat.m2505o(33748);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI$c */
    class C30635c extends ClickableSpan {
        public String hHV;

        public C30635c(String str) {
            this.hHV = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33750);
            ModRemarkNameUI.this.znO.setText(C44089j.m79293b(ModRemarkNameUI.this, C42252ah.nullAsNil(this.hHV), ModRemarkNameUI.this.znO.getTextSize()));
            ModRemarkNameUI.this.znO.setSelection(ModRemarkNameUI.this.znO.getText().length());
            ModRemarkNameUI.this.zlM.setVisibility(8);
            AppMethodBeat.m2505o(33750);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(33751);
            textPaint.setColor(ModRemarkNameUI.this.getResources().getColor(C25738R.color.f11788hb));
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(33751);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI$b */
    class C30636b implements TextWatcher {
        private int qkM;

        private C30636b() {
            this.qkM = 800;
        }

        /* synthetic */ C30636b(ModRemarkNameUI modRemarkNameUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(33749);
            this.qkM = C5584f.m8385bP(800, editable.toString());
            if (this.qkM < 0) {
                this.qkM = 0;
            }
            if (ModRemarkNameUI.this.znT != null) {
                ModRemarkNameUI.this.znT.setText(this.qkM);
            }
            ModRemarkNameUI.m48849j(ModRemarkNameUI.this);
            AppMethodBeat.m2505o(33749);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ModRemarkNameUI$1 */
    class C306371 implements C5621b {
        C306371() {
        }

        public final void aqH() {
            AppMethodBeat.m2504i(33744);
            if (ModRemarkNameUI.this.znO.getText().toString().trim().length() > 0) {
                ModRemarkNameUI.this.enableOptionMenu(true);
            }
            AppMethodBeat.m2505o(33744);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ModRemarkNameUI() {
        AppMethodBeat.m2504i(33752);
        AppMethodBeat.m2505o(33752);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(33753);
        super.onCreate(bundle);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.znP = getIntent().getIntExtra("Contact_mode_name_type", 0);
        this.znQ = C42252ah.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
        this.hHV = C42252ah.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
        this.znV = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
        initView();
        this.znX = findViewById(2131826138);
        if (this.znP != 0) {
            this.znX.setVisibility(8);
        } else {
            this.znX.setVisibility(0);
        }
        this.ppy = (MMTagPanel) findViewById(2131823125);
        this.ppy.setPanelClickable(false);
        this.zlV = (TextView) findViewById(2131823124);
        this.zlV.setText(C25738R.string.d0x);
        this.ppy.setOnClickListener(this.znW);
        this.zlV.setOnClickListener(this.znW);
        if (this.ehM == null || !C7616ad.aox(this.ehM.field_username)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.znO == null) {
                AppMethodBeat.m2505o(33753);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.znO.getParent();
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                int id = childAt.getId();
                if (!(id == 2131823118 || id == 2131823119)) {
                    childAt.setVisibility(8);
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(33753);
    }

    public final int getLayoutId() {
        return 2130970241;
    }

    public final void initView() {
        AppMethodBeat.m2504i(33754);
        this.cIS = getIntent().getStringExtra("Contact_User");
        if (this.cIS != null && this.cIS.length() > 0) {
            C9638aw.m17190ZK();
            this.ehM = C18628c.m29078XM().aoO(this.cIS);
            C9638aw.m17190ZK();
            this.pCq = C18628c.m29079XN().mo15364RB(this.cIS);
            if (this.ehM == null || C42252ah.isNullOrNil(this.ehM.field_username)) {
                this.ehM = new C7616ad(this.cIS);
                this.ehM.mo14703iB(C42252ah.nullAsNil(this.znQ));
                this.ehM.mo14729iz(C42252ah.nullAsNil(this.hHV));
            }
        }
        this.znO = (EditText) findViewById(2131823119);
        C306371 c306371 = new C306371();
        C14984a c14984a = new C14984a();
        c14984a.vuS = c306371;
        this.znO.addTextChangedListener(c14984a);
        C7357c.m12555d(this.znO).mo15877PM(100).mo15879a(null);
        if (!(this.ehM == null || this.znP == 3)) {
            if (this.znP == 4) {
                this.znO.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.znQ), this.znO.getTextSize()));
            } else if (C42252ah.isNullOrNil(this.ehM.field_conRemark)) {
                if (!C42252ah.isNullOrNil(this.hHV)) {
                    this.znO.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.hHV), this.znO.getTextSize()));
                } else if (C42252ah.isNullOrNil(this.ehM.field_nickname)) {
                    if (!C42252ah.isNullOrNil(this.znQ)) {
                        this.znO.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.znQ), this.znO.getTextSize()));
                    } else if (m48839JO()) {
                        this.znO.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.ehM.mo16707Oj()), this.znO.getTextSize()));
                    } else {
                        this.znO.setText("");
                    }
                } else if (this.znP != 0 || C42252ah.isNullOrNil(this.znQ) || C7486a.m12942jh(this.ehM.field_type)) {
                    this.znO.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.ehM.field_nickname), this.znO.getTextSize()));
                } else {
                    this.znO.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.znQ), this.znO.getTextSize()));
                }
            } else if (this.znP != 0 || C42252ah.isNullOrNil(this.hHV)) {
                this.znO.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.ehM.field_conRemark), this.znO.getTextSize()));
            } else {
                this.znO.setText(C44089j.m79293b((Context) this, this.hHV, this.znO.getTextSize()));
            }
            this.znO.setSelection(this.znO.getText().length());
        }
        TextView textView;
        if (this.znP == 0) {
            setMMTitle((int) C25738R.string.axw);
            dIi();
        } else if (this.znP == 3) {
            setMMTitle((int) C25738R.string.eua);
            this.znO.setHint("");
            if (!C42252ah.isNullOrNil(this.znQ)) {
                this.znO.setText(this.znQ);
            }
            textView = (TextView) findViewById(2131823118);
            textView.setText(C25738R.string.e3y);
            textView.setVisibility(0);
            findViewById(2131826139).setVisibility(8);
        } else if (this.znP == 4) {
            setMMTitle((int) C25738R.string.dtf);
            this.znO.setHint("");
            textView = (TextView) findViewById(2131823118);
            textView.setText(C25738R.string.dus);
            textView.setVisibility(0);
        }
        addTextOptionMenu(0, getString(C25738R.string.f9218tc), new C239052());
        if (this.znO == null || this.znO.getText().toString().trim().length() <= 0) {
            enableOptionMenu(false);
        } else {
            enableOptionMenu(true);
        }
        setBackBtn(new C306333());
        this.znR = (TextView) findViewById(2131823130);
        this.znS = (EditText) findViewById(2131823128);
        this.znT = (TextView) findViewById(2131823129);
        this.zlN = findViewById(2131823127);
        C7357c.m12555d(this.znS).mo15877PM(800).mo15879a(null);
        this.znT.setText(C5584f.m8385bP(800, this.znS.getEditableText().toString()));
        this.znS.append(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.znU), this.znS.getTextSize()));
        this.znR.append(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.znU), this.znR.getTextSize()));
        if (this.pCq != null) {
            this.znS.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.pCq.field_conDescription), this.znS.getTextSize()));
            this.znR.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.pCq.field_conDescription), this.znS.getTextSize()));
        }
        this.znS.addTextChangedListener(new C30636b(this, (byte) 0));
        this.znR.setOnClickListener(new C157984());
        AppMethodBeat.m2505o(33754);
    }

    public void onResume() {
        AppMethodBeat.m2504i(33755);
        super.onResume();
        C9638aw.m17190ZK();
        this.pCq = C18628c.m29079XN().mo15364RB(this.cIS);
        if (this.pCq != null) {
            this.pml = this.pCq.field_contactLabels;
            this.plC = (ArrayList) C21156a.bJa().mo41633PF(this.pml);
        }
        if (C42252ah.isNullOrNil(this.pml)) {
            this.ppy.setVisibility(8);
            this.zlV.setVisibility(0);
        } else {
            this.ppy.setVisibility(0);
            this.zlV.setVisibility(8);
            if (!(this.plC == null || this.plC.isEmpty())) {
                this.ppy.mo71950a(this.plC, this.plC);
                AppMethodBeat.m2505o(33755);
                return;
            }
        }
        AppMethodBeat.m2505o(33755);
    }

    private void dIi() {
        AppMethodBeat.m2504i(33756);
        C18817a vT = C32923a.getAddrUploadStg().mo34089vT(this.ehM.field_username);
        if (vT == null || C42252ah.isNullOrNil(vT.apA()) || vT.apA().equals(this.znO.getText())) {
            AppMethodBeat.m2505o(33756);
            return;
        }
        this.zlL = (TextView) findViewById(2131823122);
        this.zlM = findViewById(2131823121);
        this.zlM.setVisibility(0);
        this.zlL.setText(C42252ah.nullAsNil(getString(C25738R.string.b05, new Object[]{vT.apA()})));
        C44090k c44090k = new C44090k(getString(C25738R.string.g1q));
        c44090k.setSpan(new C30635c(vT.apA()), 0, c44090k.length(), 17);
        this.zlL.append(" ");
        this.zlL.append(c44090k);
        this.zlL.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(33756);
    }

    /* renamed from: JO */
    private boolean m48839JO() {
        AppMethodBeat.m2504i(33757);
        String str = this.ehM.field_nickname;
        if (C42252ah.isNullOrNil(str) || str.length() > 50) {
            AppMethodBeat.m2505o(33757);
            return false;
        }
        AppMethodBeat.m2505o(33757);
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33758);
        super.onDestroy();
        AppMethodBeat.m2505o(33758);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(33759);
        C4990ab.m7416i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() == 44) {
            if (i != 0 && i2 < 0) {
                C4990ab.m7410d("MiroMsg.ModRemarkName", "addRoomCard Error!");
                Toast.makeText(this, getString(C25738R.string.duh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            finish();
        }
        AppMethodBeat.m2505o(33759);
    }

    /* renamed from: c */
    static /* synthetic */ void m48842c(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.m2504i(33760);
        if (!C9638aw.m17179RK()) {
            C4990ab.m7412e("MiroMsg.ModRemarkName", "!MMCore.hasSetUin()");
            AppMethodBeat.m2505o(33760);
        } else if (modRemarkNameUI.znO == null) {
            C4990ab.m7412e("MiroMsg.ModRemarkName", "remarkName == null in dealModNickName(), return");
            AppMethodBeat.m2505o(33760);
        } else {
            String trim = modRemarkNameUI.znO.getText().toString().trim();
            C4990ab.m7416i("MiroMsg.ModRemarkName", "Set New RemarkName : " + trim + ", Report kvStat, addContactScene = " + modRemarkNameUI.gwP);
            C7060h.pYm.mo8381e(10448, Integer.valueOf(modRemarkNameUI.gwP));
            if (modRemarkNameUI.znV) {
                modRemarkNameUI.ehM.mo14729iz(trim);
                C7575bv c7575bv = new C7575bv(modRemarkNameUI.ehM.field_username, trim);
                c7575bv.field_conDescription = modRemarkNameUI.znS.getText().toString().trim();
                if (!C42252ah.isNullOrNil(modRemarkNameUI.pml)) {
                    c7575bv.field_contactLabels = modRemarkNameUI.pml;
                }
                C9638aw.m17190ZK();
                C18628c.m29079XN().mo10099a(c7575bv);
                if (modRemarkNameUI.ehM != null) {
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15724b(modRemarkNameUI.ehM.field_username, modRemarkNameUI.ehM);
                }
            }
            modRemarkNameUI.finish();
            AppMethodBeat.m2505o(33760);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m48843d(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.m2504i(33761);
        String trim = modRemarkNameUI.znO.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("k_sns_tag_name", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        AppMethodBeat.m2505o(33761);
    }

    /* renamed from: e */
    static /* synthetic */ void m48844e(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.m2504i(33762);
        String trim = modRemarkNameUI.znO.getText().toString().trim();
        if (trim.length() > 50) {
            C30379h.m48443a(modRemarkNameUI.mController.ylL, modRemarkNameUI.getString(C25738R.string.drq), modRemarkNameUI.getString(C25738R.string.duu), modRemarkNameUI.getString(C25738R.string.f9076or), null);
            AppMethodBeat.m2505o(33762);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Nick", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        C4879a.xxA.mo10055m(new C26245tv());
        AppMethodBeat.m2505o(33762);
    }

    /* renamed from: j */
    static /* synthetic */ void m48849j(ModRemarkNameUI modRemarkNameUI) {
        boolean z;
        AppMethodBeat.m2504i(33763);
        String trim = modRemarkNameUI.znS.getText().toString().trim();
        if ((modRemarkNameUI.znU == null || !modRemarkNameUI.znU.equals(trim)) && !(C42252ah.isNullOrNil(modRemarkNameUI.znU) && C42252ah.isNullOrNil(trim))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            trim = modRemarkNameUI.znO.getText().toString().trim();
            if ((modRemarkNameUI.znO == null || !modRemarkNameUI.znO.equals(trim)) && !(C42252ah.isNullOrNil(modRemarkNameUI.hHV) && C42252ah.isNullOrNil(trim))) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                modRemarkNameUI.enableOptionMenu(false);
                AppMethodBeat.m2505o(33763);
                return;
            }
        }
        modRemarkNameUI.enableOptionMenu(true);
        AppMethodBeat.m2505o(33763);
    }

    /* renamed from: k */
    static /* synthetic */ void m48850k(ModRemarkNameUI modRemarkNameUI) {
        AppMethodBeat.m2504i(33764);
        Intent intent = new Intent();
        if (modRemarkNameUI.plC != null) {
            intent.putStringArrayListExtra("label_str_list", modRemarkNameUI.plC);
        }
        intent.putExtra("is_stranger", true);
        intent.putExtra("label_username", modRemarkNameUI.cIS);
        C25985d.m41467b((Context) modRemarkNameUI, "label", ".ui.ContactLabelUI", intent);
        AppMethodBeat.m2505o(33764);
    }
}
