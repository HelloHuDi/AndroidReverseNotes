package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI extends MMActivity implements f {
    private String bCv;
    private String dul;
    private ad ehM;
    private String fNa;
    private ProgressDialog fsh;
    private int gwP;
    private String nIM;
    private com.tencent.mm.sdk.e.n.b ppA = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(33637);
            ab.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
            ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
            AppMethodBeat.o(33637);
        }
    };
    private MMTagPanel ppy;
    private List<String> ppz;
    private String username;
    private String vrd;
    private MMClearEditText zlC;
    private TextView zlD;
    private MMEditText zlE;
    private TextView zlF;
    private TextView zlG;
    private TextView zlH;
    private TextView zlI;
    private ImageView zlJ;
    private ImageView zlK;
    private TextView zlL;
    private View zlM;
    private View zlN;
    private String zlO;
    private boolean zlP = false;
    private boolean zlQ = false;
    private boolean zlR = false;
    private boolean zlS = false;
    private boolean zlT = false;
    private a zlU = new a(this, (byte) 0);
    private TextView zlV;
    private ScrollView zlW;
    private ProfileEditPhoneNumberView zlX;
    private String zlY;
    private String zlZ;
    private TextWatcher zma = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(33628);
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
            AppMethodBeat.o(33628);
        }
    };
    private b zmb = new b(this, (byte) 0);
    private String zmc;
    boolean zmd = true;
    boolean zme = false;
    private boolean zmf = false;

    class a implements OnClickListener {
        private a() {
        }

        /* synthetic */ a(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(33647);
            ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this);
            AppMethodBeat.o(33647);
        }
    }

    class c extends ClickableSpan {
        public String hHV;

        public c(String str) {
            this.hHV = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(33649);
            ContactRemarkInfoModUI.this.zlR = true;
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
            ContactRemarkInfoModUI.this.zlC.setText(j.b(ContactRemarkInfoModUI.this, ah.nullAsNil(this.hHV), ContactRemarkInfoModUI.this.zlC.getTextSize()));
            ContactRemarkInfoModUI.this.zlC.setSelection(ContactRemarkInfoModUI.this.zlC.getText().length());
            ContactRemarkInfoModUI.this.zlM.setVisibility(8);
            AppMethodBeat.o(33649);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(33650);
            textPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(R.color.hb));
            textPaint.setUnderlineText(false);
            AppMethodBeat.o(33650);
        }
    }

    class b implements TextWatcher {
        private int qkM;
        private String zmi;

        private b() {
            this.qkM = 800;
            this.zmi = "";
        }

        /* synthetic */ b(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(33648);
            this.qkM = com.tencent.mm.ui.tools.f.bP(800, editable.toString());
            if (this.qkM < 0) {
                this.qkM = 0;
            }
            if (ContactRemarkInfoModUI.this.zlI != null) {
                ContactRemarkInfoModUI.this.zlI.setText(this.qkM);
            }
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
            AppMethodBeat.o(33648);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactRemarkInfoModUI() {
        AppMethodBeat.i(33651);
        AppMethodBeat.o(33651);
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33677);
        contactRemarkInfoModUI.JZ();
        AppMethodBeat.o(33677);
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z, int i) {
        AppMethodBeat.i(33680);
        contactRemarkInfoModUI.I(z, i);
        AppMethodBeat.o(33680);
    }

    static /* synthetic */ void d(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33679);
        contactRemarkInfoModUI.cbz();
        AppMethodBeat.o(33679);
    }

    static /* synthetic */ void k(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33681);
        contactRemarkInfoModUI.dHH();
        AppMethodBeat.o(33681);
    }

    static /* synthetic */ void r(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33684);
        contactRemarkInfoModUI.goBack();
        AppMethodBeat.o(33684);
    }

    static /* synthetic */ void v(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33685);
        contactRemarkInfoModUI.dHJ();
        AppMethodBeat.o(33685);
    }

    static /* synthetic */ void w(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33686);
        contactRemarkInfoModUI.dHO();
        AppMethodBeat.o(33686);
    }

    private void JZ() {
        boolean z;
        AppMethodBeat.i(33652);
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.zlX;
        ArrayList phoneNumberList = profileEditPhoneNumberView.getPhoneNumberList();
        if (phoneNumberList == null || phoneNumberList.isEmpty()) {
            if (profileEditPhoneNumberView.vio != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.vio == null) {
            z = true;
        } else if (phoneNumberList.size() != profileEditPhoneNumberView.vio.length) {
            z = true;
        } else {
            Iterator it = phoneNumberList.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!((String) it.next()).equals(profileEditPhoneNumberView.vio[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
        }
        this.zmf = z;
        if (dHM() || dHN() || qD(false) || this.zmf) {
            enableOptionMenu(true);
            AppMethodBeat.o(33652);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(33652);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(33653);
        super.onCreate(bundle);
        aw.Rg().a(575, (f) this);
        aw.Rg().a(576, (f) this);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.vrd = getIntent().getStringExtra("Contact_RoomNickname");
        this.zlS = getIntent().getBooleanExtra("view_mode", false);
        this.zmc = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.zlY = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.zlZ = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (ah.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.o(33653);
            return;
        }
        int i2;
        aw.ZK();
        this.ehM = com.tencent.mm.model.c.XM().aoO(this.username);
        this.bCv = this.ehM.field_conRemark;
        this.dul = this.ehM.dul;
        this.fNa = this.ehM.dum;
        this.nIM = this.ehM.field_contactLabelIds;
        this.ppz = com.tencent.mm.plugin.label.a.a.bJa().PG(this.nIM);
        initView();
        JZ();
        if (this.ehM == null || !ad.aox(this.ehM.field_username)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            if (this.zlC == null) {
                AppMethodBeat.o(33653);
                return;
            }
            View view = (ViewGroup) this.zlC.getParent();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != view) {
                    childAt.setVisibility(8);
                }
                i++;
            }
        }
        AppMethodBeat.o(33653);
    }

    public void onResume() {
        AppMethodBeat.i(33654);
        super.onResume();
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this.ppA);
        cbz();
        AppMethodBeat.o(33654);
    }

    public void onPause() {
        AppMethodBeat.i(33655);
        aw.ZK();
        com.tencent.mm.model.c.XM().b(this.ppA);
        super.onPause();
        AppMethodBeat.o(33655);
    }

    public void onDestroy() {
        AppMethodBeat.i(33656);
        aw.Rg().b(575, (f) this);
        aw.Rg().b(576, (f) this);
        this.zlC.removeTextChangedListener(this.zma);
        this.zlE.removeTextChangedListener(this.zmb);
        super.onDestroy();
        AppMethodBeat.o(33656);
    }

    public final int getLayoutId() {
        return R.layout.r2;
    }

    private void I(boolean z, int i) {
        AppMethodBeat.i(33657);
        if (this.zlR) {
            this.zlF.setVisibility(8);
            if (z && ah.isNullOrNil(this.dul)) {
                this.zlG.setVisibility(0);
                this.zlN.setVisibility(8);
            } else if (i == R.id.b5w) {
                this.zlG.setVisibility(8);
                this.zlN.setVisibility(0);
            }
            this.zlC.setVisibility(0);
            AppMethodBeat.o(33657);
            return;
        }
        this.zlF.setVisibility(0);
        this.zlG.setVisibility(0);
        this.zlC.setVisibility(8);
        this.zlN.setVisibility(8);
        AppMethodBeat.o(33657);
    }

    public final void initView() {
        AppMethodBeat.i(33658);
        this.zlD = (TextView) findViewById(R.id.b5k);
        this.zlF = (TextView) findViewById(R.id.b5m);
        this.zlG = (TextView) findViewById(R.id.b5w);
        this.zlH = (TextView) findViewById(R.id.b5x);
        this.zlC = (MMClearEditText) findViewById(R.id.b5l);
        this.zlE = (MMEditText) findViewById(R.id.b5u);
        this.zlJ = (ImageView) findViewById(R.id.b5z);
        this.zlK = (ImageView) findViewById(R.id.b5y);
        this.zlI = (TextView) findViewById(R.id.b5v);
        this.zlN = findViewById(R.id.b5t);
        this.zlX = (ProfileEditPhoneNumberView) findViewById(R.id.b5s);
        this.zlX.ldh = this.ehM;
        this.zlX.hF(this.zlY, this.zlZ);
        this.zlX.vir = new com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a() {
            public final void aVU() {
                AppMethodBeat.i(33639);
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
                AppMethodBeat.o(33639);
            }

            public final void djk() {
                AppMethodBeat.i(33640);
                t.s(ContactRemarkInfoModUI.this.ehM);
                com.tencent.mm.modelmulti.n.ahW().lN(7);
                AppMethodBeat.o(33640);
            }
        };
        this.ppy = (MMTagPanel) findViewById(R.id.b5r);
        this.ppy.setPanelClickable(false);
        this.zlW = (ScrollView) findViewById(R.id.b5j);
        this.zlV = (TextView) findViewById(R.id.b5q);
        this.zlV.setText(R.string.d0x);
        this.ppy.setOnClickListener(this.zlU);
        this.zlV.setOnClickListener(this.zlU);
        setMMTitle((int) R.string.axw);
        if (ah.isNullOrNil(this.bCv)) {
            this.zlC.setText(j.b((Context) this, ah.nullAsNil(this.ehM.Oi()), this.zlC.getTextSize()));
            this.zlF.setText(j.b((Context) this, ah.nullAsNil(this.ehM.Oi()), this.zlC.getTextSize()));
        } else {
            this.zlC.setText(j.b((Context) this, ah.nullAsNil(this.bCv), this.zlC.getTextSize()));
            this.zlF.setText(j.b((Context) this, ah.nullAsNil(this.bCv), this.zlF.getTextSize()));
        }
        this.zlC.setSelection(this.zlC.getText().length());
        this.zlE.setText(j.b((Context) this, ah.nullAsNil(this.dul), this.zlG.getTextSize()));
        this.zlE.setSelection(this.zlE.getText().length());
        if (!ah.isNullOrNil(this.dul)) {
            this.zlG.setText(j.b((Context) this, ah.nullAsNil(this.dul), this.zlG.getTextSize()));
            this.zlG.setTextColor(getResources().getColor(R.color.w4));
        }
        this.zlF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33641);
                ContactRemarkInfoModUI.this.zlR = true;
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, view.getId());
                ContactRemarkInfoModUI.this.zlC.performClick();
                ContactRemarkInfoModUI.this.zlC.requestFocus();
                ContactRemarkInfoModUI.this.showVKB();
                AppMethodBeat.o(33641);
            }
        });
        this.zlG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33642);
                ContactRemarkInfoModUI.this.zlR = true;
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, view.getId());
                ContactRemarkInfoModUI.this.zlE.performClick();
                ContactRemarkInfoModUI.this.zlE.requestFocus();
                ContactRemarkInfoModUI.this.showVKB();
                AppMethodBeat.o(33642);
            }
        });
        this.zlC.addTextChangedListener(this.zma);
        this.zlI.setText(com.tencent.mm.ui.tools.f.bP(800, this.zlE.getEditableText().toString()));
        this.zlE.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(33643);
                if (z) {
                    ContactRemarkInfoModUI.this.zlN.setBackgroundResource(R.drawable.b77);
                    AppMethodBeat.o(33643);
                    return;
                }
                ContactRemarkInfoModUI.this.zlN.setBackgroundResource(R.drawable.b78);
                AppMethodBeat.o(33643);
            }
        });
        this.zlE.addTextChangedListener(this.zmb);
        if (ah.isNullOrNil(this.fNa)) {
            this.zlH.setVisibility(0);
            this.zlJ.setVisibility(8);
        } else {
            this.zlH.setVisibility(8);
            this.zlJ.setVisibility(0);
            dHI();
        }
        this.zlJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33644);
                if (ContactRemarkInfoModUI.this.zlP) {
                    String o;
                    ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
                    Intent intent = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", ContactRemarkInfoModUI.this.username);
                    if (ah.isNullOrNil(ContactRemarkInfoModUI.this.fNa) || ContactRemarkInfoModUI.this.zlQ) {
                        o = ContactRemarkInfoModUI.this.zlO;
                    } else {
                        com.tencent.mm.bc.c.aiB();
                        o = com.tencent.mm.bc.c.sW(ContactRemarkInfoModUI.this.username);
                    }
                    intent.putExtra("remark_image_path", o);
                    intent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.this.zlQ);
                    ContactRemarkInfoModUI.this.startActivityForResult(intent, 400);
                    AppMethodBeat.o(33644);
                    return;
                }
                AppMethodBeat.o(33644);
            }
        });
        this.zlH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33645);
                if (ah.isNullOrNil(ContactRemarkInfoModUI.this.fNa) || ContactRemarkInfoModUI.this.zlT) {
                    ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
                    ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
                }
                AppMethodBeat.o(33645);
            }
        });
        if (!cbB()) {
            dHK();
        }
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33646);
                ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
                ContactRemarkInfoModUI.this.aqX();
                AppMethodBeat.o(33646);
                return false;
            }
        }, com.tencent.mm.ui.q.b.GREEN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33629);
                ContactRemarkInfoModUI.r(ContactRemarkInfoModUI.this);
                AppMethodBeat.o(33629);
                return true;
            }
        });
        if (ah.isNullOrNil(this.bCv)) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.zlK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33630);
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
                ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
                AppMethodBeat.o(33630);
            }
        });
        if (!this.zlS) {
            this.zlR = true;
            I(true, -1);
        }
        dHH();
        AppMethodBeat.o(33658);
    }

    private void dHH() {
        AppMethodBeat.i(33659);
        this.zlD.setFocusableInTouchMode(true);
        this.zlD.requestFocus();
        this.zlC.clearFocus();
        this.zlE.clearFocus();
        this.zlX.clearFocus();
        aqX();
        AppMethodBeat.o(33659);
    }

    private void dHI() {
        AppMethodBeat.i(33660);
        com.tencent.mm.bc.c.aiB();
        if (com.tencent.mm.bc.c.sX(this.username)) {
            dHJ();
            AppMethodBeat.o(33660);
            return;
        }
        com.tencent.mm.bc.c.aiB().a(this.username, this.fNa, new com.tencent.mm.bc.c.a() {
            public final void cP(final boolean z) {
                AppMethodBeat.i(33634);
                ContactRemarkInfoModUI.this.zlJ.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33633);
                        if (z) {
                            ContactRemarkInfoModUI.v(ContactRemarkInfoModUI.this);
                            AppMethodBeat.o(33633);
                            return;
                        }
                        h.bQ(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(R.string.ps));
                        ContactRemarkInfoModUI.this.zlK.setVisibility(0);
                        ContactRemarkInfoModUI.this.zlH.setVisibility(8);
                        ContactRemarkInfoModUI.this.zlJ.setVisibility(8);
                        AppMethodBeat.o(33633);
                    }
                });
                AppMethodBeat.o(33634);
            }
        });
        AppMethodBeat.o(33660);
    }

    private void dHJ() {
        AppMethodBeat.i(33661);
        com.tencent.mm.bc.c.aiB();
        Bitmap sZ = com.tencent.mm.bc.c.sZ(this.username);
        if (sZ != null) {
            this.zlH.setVisibility(8);
            this.zlK.setVisibility(8);
            this.zlJ.setVisibility(0);
            this.zlJ.setImageBitmap(sZ);
        }
        this.zlP = true;
        AppMethodBeat.o(33661);
    }

    private void arO(String str) {
        AppMethodBeat.i(33662);
        if (ah.isNullOrNil(str)) {
            AppMethodBeat.o(33662);
            return;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (!bVar.exists()) {
            AppMethodBeat.o(33662);
        } else if (bVar.length() > 204800) {
            h.b((Context) this, getString(R.string.av4), null, true);
            AppMethodBeat.o(33662);
        } else {
            Bitmap i = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.i(this.zlO, com.tencent.mm.bz.a.getDensity(this));
            if (i != null) {
                this.zlH.setVisibility(8);
                this.zlK.setVisibility(8);
                this.zlJ.setVisibility(0);
                this.zlJ.setImageBitmap(i);
                this.zlP = true;
            }
            AppMethodBeat.o(33662);
        }
    }

    private boolean cbB() {
        AppMethodBeat.i(33663);
        com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.ehM.field_username);
        if (vT == null || ah.isNullOrNil(vT.apA()) || vT.apA().equals(this.zlC.getText().toString())) {
            AppMethodBeat.o(33663);
            return false;
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
        AppMethodBeat.o(33663);
        return true;
    }

    private boolean dHK() {
        AppMethodBeat.i(33664);
        if (this.gwP != 14 || ah.isNullOrNil(this.vrd) || this.vrd.equals(this.zlC.getText().toString())) {
            AppMethodBeat.o(33664);
            return false;
        }
        this.zlL = (TextView) findViewById(R.id.b5o);
        this.zlM = findViewById(R.id.b5n);
        this.zlM.setVisibility(0);
        this.zlL.setText(j.b((Context) this, ah.nullAsNil(getString(R.string.b04, new Object[]{this.vrd})), this.zlL.getTextSize()));
        k kVar = new k(getString(R.string.g1q));
        kVar.setSpan(new c(this.vrd), 0, kVar.length(), 17);
        this.zlL.append(" ");
        this.zlL.append(kVar);
        this.zlL.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(33664);
        return true;
    }

    private void dHL() {
        AppMethodBeat.i(33665);
        if (this.zmf) {
            String str;
            bck bck = new bck();
            bck.wGA = this.username;
            bkg bkg = new bkg();
            ArrayList phoneNumberList = this.zlX.getPhoneNumberList();
            bkg.jBv = phoneNumberList == null ? 0 : phoneNumberList.size();
            bkg.wNu = new LinkedList();
            if (phoneNumberList != null) {
                Iterator it = phoneNumberList.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    bkf bkf = new bkf();
                    bkf.wNt = str;
                    bkg.wNu.add(bkf);
                }
            }
            bck.wGw = bkg;
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(60, bck));
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(this.username);
            if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                String str2;
                str = "";
                if (phoneNumberList != null) {
                    Iterator it2 = phoneNumberList.iterator();
                    while (true) {
                        str2 = str;
                        if (!it2.hasNext()) {
                            break;
                        }
                        str = (str2 + ((String) it2.next())) + ",";
                    }
                } else {
                    str2 = str;
                }
                ab.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", this.username, str2);
                this.ehM.jd(str2);
                aw.ZK();
                com.tencent.mm.model.c.XM().Y(this.ehM);
            }
            AppMethodBeat.o(33665);
            return;
        }
        AppMethodBeat.o(33665);
    }

    private boolean qD(boolean z) {
        AppMethodBeat.i(33666);
        String obj = this.zlC.getText().toString();
        if (z) {
            boolean z2;
            if ((this.bCv == null || !this.bCv.equals(obj)) && !(ah.isNullOrNil(this.bCv) && ah.isNullOrNil(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.ehM.field_nickname))) {
                AppMethodBeat.o(33666);
                return false;
            }
            AppMethodBeat.o(33666);
            return true;
        } else if ((this.bCv == null || !this.bCv.equals(obj)) && !(ah.isNullOrNil(this.bCv) && ah.isNullOrNil(obj))) {
            AppMethodBeat.o(33666);
            return true;
        } else {
            AppMethodBeat.o(33666);
            return false;
        }
    }

    private boolean dHM() {
        AppMethodBeat.i(33667);
        String obj = this.zlE.getText().toString();
        if ((this.dul == null || !this.dul.equals(obj)) && !(ah.isNullOrNil(this.dul) && ah.isNullOrNil(obj))) {
            AppMethodBeat.o(33667);
            return true;
        }
        AppMethodBeat.o(33667);
        return false;
    }

    private boolean dHN() {
        AppMethodBeat.i(33668);
        if (!ah.isNullOrNil(this.zlO) || this.zlT) {
            AppMethodBeat.o(33668);
            return true;
        }
        AppMethodBeat.o(33668);
        return false;
    }

    private void goBack() {
        AppMethodBeat.i(33669);
        boolean dHN = dHN();
        boolean qD = qD(true);
        boolean dHM = dHM();
        if (dHN || qD || dHM) {
            h.d(this, getString(R.string.aze), null, getString(R.string.azg), getString(R.string.azf), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(33636);
                    ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
                    AppMethodBeat.o(33636);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(33638);
                    ContactRemarkInfoModUI.this.finish();
                    AppMethodBeat.o(33638);
                }
            });
            AppMethodBeat.o(33669);
            return;
        }
        aqX();
        finish();
        AppMethodBeat.o(33669);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(33670);
        if (keyEvent.getKeyCode() == 4) {
            goBack();
            AppMethodBeat.o(33670);
            return true;
        }
        AppMethodBeat.o(33670);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(33671);
        ab.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            ab.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            AppMethodBeat.o(33671);
            return;
        }
        Context applicationContext;
        String h;
        switch (i) {
            case 100:
                applicationContext = getApplicationContext();
                aw.ZK();
                h = com.tencent.mm.pluginsdk.ui.tools.n.h(applicationContext, intent, com.tencent.mm.model.c.XW());
                if (h == null) {
                    AppMethodBeat.o(33671);
                    return;
                }
                this.zlO = arP(h);
                arO(this.zlO);
                this.zlQ = true;
                this.zlT = false;
                JZ();
                AppMethodBeat.o(33671);
                return;
            case 200:
                applicationContext = getApplicationContext();
                aw.ZK();
                h = com.tencent.mm.ui.tools.a.i(applicationContext, intent, com.tencent.mm.model.c.XW());
                if (h == null) {
                    AppMethodBeat.o(33671);
                    return;
                }
                this.zlO = arP(h);
                arO(this.zlO);
                this.zlQ = true;
                this.zlT = false;
                JZ();
                AppMethodBeat.o(33671);
                return;
            case 400:
                if (intent.getBooleanExtra("response_delete", false)) {
                    dHO();
                }
                AppMethodBeat.o(33671);
                return;
            case 600:
                if (qD(true) || dHM() || dHN() || intent.getBooleanExtra("hasLableChange", false)) {
                    enableOptionMenu(true);
                    AppMethodBeat.o(33671);
                    return;
                }
                enableOptionMenu(false);
                AppMethodBeat.o(33671);
                return;
            default:
                AppMethodBeat.o(33671);
                return;
        }
    }

    private void dHO() {
        AppMethodBeat.i(33672);
        this.zlT = true;
        this.zlK.setVisibility(8);
        this.zlH.setVisibility(0);
        this.zlJ.setVisibility(8);
        this.zlJ.setImageBitmap(null);
        JZ();
        AppMethodBeat.o(33672);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(33673);
        ab.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 575) {
                if (this.zlO != null) {
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.zlO);
                    if (bVar.exists()) {
                        com.tencent.mm.bc.c.aiB();
                        bVar.o(new com.tencent.mm.vfs.b(com.tencent.mm.bc.c.sW(this.username)));
                    }
                }
                String str2 = ((com.tencent.mm.bc.b) mVar).fNa;
                if (!ah.isNullOrNil(str2)) {
                    this.fNa = str2;
                }
            } else if (mVar.getType() == 576) {
                this.zlO = null;
                this.fNa = null;
                this.zlP = false;
                aw.ZK();
                this.ehM = com.tencent.mm.model.c.XM().aoO(this.username);
                this.ehM.iY("");
                aw.ZK();
                com.tencent.mm.model.c.XM().b(this.username, this.ehM);
            }
            finish();
            AppMethodBeat.o(33673);
            return;
        }
        h.b((Context) this, getString(R.string.pr), null, true);
        AppMethodBeat.o(33673);
    }

    private String arP(String str) {
        AppMethodBeat.i(33674);
        if (e.ct(str)) {
            int bJ = ExifHelper.bJ(str);
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.bc.c.aiB();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.bc.c.sW(this.username)).append(".tmp").toString();
            if (!d.a(str, (int) VideoFilterUtil.IMAGE_HEIGHT, VideoFilterUtil.IMAGE_HEIGHT, CompressFormat.JPEG, 70, stringBuilder2)) {
                ab.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
                AppMethodBeat.o(33674);
                return null;
            } else if (bJ == 0 || d.a(stringBuilder2, bJ, CompressFormat.JPEG, 70, stringBuilder2)) {
                AppMethodBeat.o(33674);
                return stringBuilder2;
            } else {
                ab.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
                AppMethodBeat.o(33674);
                return null;
            }
        }
        AppMethodBeat.o(33674);
        return null;
    }

    private void cbA() {
        AppMethodBeat.i(33675);
        if (ah.isNullOrNil(this.nIM)) {
            this.ppy.setVisibility(8);
            this.zlV.setVisibility(0);
            AppMethodBeat.o(33675);
            return;
        }
        this.ppy.setVisibility(0);
        this.zlV.setVisibility(8);
        this.ppy.a(this.ppz, this.ppz);
        AppMethodBeat.o(33675);
    }

    private void cbz() {
        AppMethodBeat.i(33676);
        aw.ZK();
        this.ehM = com.tencent.mm.model.c.XM().aoO(this.username);
        this.nIM = this.ehM.field_contactLabelIds;
        this.ppz = com.tencent.mm.plugin.label.a.a.bJa().PG(this.nIM);
        cbA();
        AppMethodBeat.o(33676);
    }

    static /* synthetic */ void c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33678);
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.nIM);
        if (contactRemarkInfoModUI.ppz != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.ppz);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        com.tencent.mm.bp.d.b((Context) contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
        AppMethodBeat.o(33678);
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        AppMethodBeat.i(33682);
        aw.ZK();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.t.hO(contactRemarkInfoModUI);
        }
        if (z) {
            h.a((Context) contactRemarkInfoModUI, "", new String[]{contactRemarkInfoModUI.getString(R.string.e28), contactRemarkInfoModUI.getString(R.string.p4)}, "", new com.tencent.mm.ui.base.h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(GLType.GL_UNSIGNED_SHORT_5_6_5);
                    switch (i) {
                        case 0:
                            ab.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                            Intent intent = new Intent();
                            intent.putExtra("max_select_count", 1);
                            intent.putExtra("query_source_type", 0);
                            intent.putExtra("send_btn_string", " ");
                            intent.addFlags(67108864);
                            com.tencent.mm.bp.d.b(ContactRemarkInfoModUI.this, "gallery", ".ui.GalleryEntryUI", intent, 200);
                            AppMethodBeat.o(GLType.GL_UNSIGNED_SHORT_5_6_5);
                            return;
                        case 1:
                            ab.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                            ContactRemarkInfoModUI.w(ContactRemarkInfoModUI.this);
                            break;
                    }
                    AppMethodBeat.o(GLType.GL_UNSIGNED_SHORT_5_6_5);
                }
            });
            AppMethodBeat.o(33682);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("max_select_count", 1);
        intent.putExtra("query_source_type", 0);
        intent.putExtra("send_btn_string", " ");
        intent.addFlags(67108864);
        com.tencent.mm.bp.d.b((Context) contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, 200);
        AppMethodBeat.o(33682);
    }

    static /* synthetic */ void q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.i(33683);
        contactRemarkInfoModUI.zmd = true;
        com.tencent.mm.ui.tools.b.c.d(contactRemarkInfoModUI.zlC).PM(100).a(new com.tencent.mm.ui.tools.b.c.a() {
            public final void ki(String str) {
            }

            public final void JW() {
            }

            public final void JX() {
                AppMethodBeat.i(33631);
                h.g(ContactRemarkInfoModUI.this, R.string.e8u, R.string.e8p);
                ContactRemarkInfoModUI.this.zmd = false;
                AppMethodBeat.o(33631);
            }
        });
        com.tencent.mm.ui.tools.b.c.d(contactRemarkInfoModUI.zlE).PM(800).a(new com.tencent.mm.ui.tools.b.c.a() {
            public final void ki(String str) {
            }

            public final void JW() {
            }

            public final void JX() {
                AppMethodBeat.i(33632);
                h.g(ContactRemarkInfoModUI.this, R.string.e8h, R.string.e8p);
                ContactRemarkInfoModUI.this.zmd = false;
                AppMethodBeat.o(33632);
            }
        });
        if (contactRemarkInfoModUI.zmd) {
            String obj;
            ab.i("MiroMsg.ContactRemarkInfoModUI", "[dealModRemarkDesc] :%s", contactRemarkInfoModUI.username);
            if (contactRemarkInfoModUI.dHM()) {
                obj = contactRemarkInfoModUI.zlE.getText().toString();
                contactRemarkInfoModUI.dul = obj;
                bbw bbw = new bbw();
                bbw.wGA = contactRemarkInfoModUI.username;
                bbw.Desc = obj;
                aw.ZK();
                com.tencent.mm.model.c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(54, bbw));
            }
            String obj2 = contactRemarkInfoModUI.zlC.getText().toString();
            ab.i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj2 + ", Report kvStat, addContactScene = " + contactRemarkInfoModUI.gwP);
            com.tencent.mm.plugin.report.service.h.pYm.e(10448, Integer.valueOf(contactRemarkInfoModUI.gwP));
            switch (contactRemarkInfoModUI.ehM.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(contactRemarkInfoModUI.ehM.field_username);
                    if (!(vT == null || ah.isNullOrNil(vT.apA()))) {
                        if (ah.isNullOrNil(obj2)) {
                            vT.apH();
                        } else {
                            vT.guJ &= -2;
                        }
                        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(vT.Aq(), vT);
                        break;
                    }
            }
            aw.ZK();
            bv RB = com.tencent.mm.model.c.XN().RB(contactRemarkInfoModUI.ehM.field_username);
            if ((RB == null || ah.isNullOrNil(RB.field_encryptUsername)) && !ah.isNullOrNil(contactRemarkInfoModUI.ehM.field_encryptUsername)) {
                aw.ZK();
                RB = com.tencent.mm.model.c.XN().RB(contactRemarkInfoModUI.ehM.field_encryptUsername);
            }
            if (!(RB == null || ah.isNullOrNil(RB.field_encryptUsername))) {
                aw.ZK();
                com.tencent.mm.model.c.XN().RC(RB.field_encryptUsername);
            }
            if (contactRemarkInfoModUI.qD(false)) {
                contactRemarkInfoModUI.bCv = obj2;
                ab.i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", contactRemarkInfoModUI.ehM.field_username, obj2);
                t.b(contactRemarkInfoModUI.ehM, obj2);
            } else {
                ab.i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", Boolean.valueOf(contactRemarkInfoModUI.qD(false)));
            }
            contactRemarkInfoModUI.dHL();
            obj = contactRemarkInfoModUI.bCv;
            obj2 = contactRemarkInfoModUI.dul;
            String str = contactRemarkInfoModUI.fNa;
            ab.i("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] :%s :%s", contactRemarkInfoModUI.username, obj);
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(contactRemarkInfoModUI.username);
            if (aoO == null || ((int) aoO.ewQ) <= 0 || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                ab.e("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] is error!");
            } else {
                int i;
                contactRemarkInfoModUI.ehM.iz(obj);
                contactRemarkInfoModUI.ehM.iX(obj2);
                contactRemarkInfoModUI.ehM.iY(str);
                aw.ZK();
                boolean Y = com.tencent.mm.model.c.XM().Y(contactRemarkInfoModUI.ehM);
                ab.i("MiroMsg.ContactRemarkInfoModUI", "saveRemarkInfo ret %s", Boolean.valueOf(Y));
                str = "MiroMsg.ContactRemarkInfoModUI";
                String str2 = "remarkDesc (%s, %s, %s)";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(obj2 == null);
                if (obj2 == null) {
                    i = 0;
                } else {
                    i = obj2.length();
                }
                objArr[1] = Integer.valueOf(i);
                if (obj2 == null) {
                    obj = "";
                } else {
                    obj = bo.anv(obj2);
                }
                objArr[2] = obj;
                ab.i(str, str2, objArr);
                com.tencent.mm.sdk.b.a.xxA.m(new tv());
            }
            if (!contactRemarkInfoModUI.dHN()) {
                contactRemarkInfoModUI.finish();
            } else if (contactRemarkInfoModUI.zlT) {
                aw.Rg().a(new com.tencent.mm.bc.a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(R.string.tz);
                contactRemarkInfoModUI.fsh = h.b((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.string.av5), false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                AppMethodBeat.o(33683);
                return;
            } else {
                aw.Rg().a(new com.tencent.mm.bc.b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.zlO), 0);
                contactRemarkInfoModUI.getString(R.string.tz);
                contactRemarkInfoModUI.fsh = h.b((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.string.av6), false, null);
                AppMethodBeat.o(33683);
                return;
            }
        }
        AppMethodBeat.o(33683);
    }
}
