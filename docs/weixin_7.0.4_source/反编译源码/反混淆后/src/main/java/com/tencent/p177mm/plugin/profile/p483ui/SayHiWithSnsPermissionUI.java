package com.tencent.p177mm.plugin.profile.p483ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p716b.C42240q;
import com.tencent.p177mm.openim.p716b.C9770o;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMTagPanel;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.profile.C34696c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14985g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI */
public class SayHiWithSnsPermissionUI extends MMActivity implements C1202f {
    private String bCu;
    private String bCv;
    private String chatroomName;
    private ProgressDialog ehJ = null;
    private int[] gCr = new int[8];
    private int gwP;
    private String nIM;
    private String oPy;
    private C4937b ppA = new C128411();
    private CharSequence ppB = null;
    private EditText ppp;
    private EditText ppq;
    private View ppr;
    private TextView pps;
    private MMSwitchBtn ppt;
    private boolean ppu;
    private boolean ppv;
    private boolean ppw;
    private TextView ppx;
    private MMTagPanel ppy;
    private List<String> ppz;
    private String userName;

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$7 */
    class C36287 implements OnMenuItemClickListener {
        C36287() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23776);
            if (SayHiWithSnsPermissionUI.this.ppv) {
                SayHiWithSnsPermissionUI.this.gCr[1] = 1;
            }
            SayHiWithSnsPermissionUI.this.finish();
            AppMethodBeat.m2505o(23776);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$1 */
    class C128411 implements C4937b {
        C128411() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(23766);
            SayHiWithSnsPermissionUI.m32940a(SayHiWithSnsPermissionUI.this);
            AppMethodBeat.m2505o(23766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$2 */
    class C214772 implements Runnable {
        C214772() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23767);
            SayHiWithSnsPermissionUI.this.showVKB();
            AppMethodBeat.m2505o(23767);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$3 */
    class C214783 implements OnFocusChangeListener {
        C214783() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(23768);
            if (z && !C5046bo.m7519ac(SayHiWithSnsPermissionUI.this.ppq.getHint()) && C5046bo.m7519ac(SayHiWithSnsPermissionUI.this.ppq.getText())) {
                SayHiWithSnsPermissionUI.this.ppq.setText(SayHiWithSnsPermissionUI.this.ppq.getHint());
                SayHiWithSnsPermissionUI.this.ppq.setOnFocusChangeListener(null);
                SayHiWithSnsPermissionUI.this.ppq.setHint(null);
            }
            AppMethodBeat.m2505o(23768);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$a */
    class C21479a extends ClickableSpan {
        public String hHV;

        public C21479a(String str) {
            this.hHV = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23777);
            SayHiWithSnsPermissionUI.this.ppq.setText(C44089j.m79293b(SayHiWithSnsPermissionUI.this, C5046bo.nullAsNil(this.hHV), SayHiWithSnsPermissionUI.this.ppq.getTextSize()));
            SayHiWithSnsPermissionUI.this.ppq.setSelection(SayHiWithSnsPermissionUI.this.ppq.getText().length());
            SayHiWithSnsPermissionUI.this.ppr.setVisibility(8);
            SayHiWithSnsPermissionUI.this.gCr[4] = 1;
            AppMethodBeat.m2505o(23777);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(23778);
            textPaint.setColor(SayHiWithSnsPermissionUI.this.getResources().getColor(C25738R.color.f11788hb));
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(23778);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$5 */
    class C214805 implements OnClickListener {
        C214805() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23770);
            SayHiWithSnsPermissionUI.m32942c(SayHiWithSnsPermissionUI.this);
            AppMethodBeat.m2505o(23770);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$4 */
    class C214814 implements OnClickListener {
        C214814() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23769);
            SayHiWithSnsPermissionUI.m32942c(SayHiWithSnsPermissionUI.this);
            AppMethodBeat.m2505o(23769);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI$6 */
    class C214826 implements OnMenuItemClickListener {
        C214826() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23775);
            if (SayHiWithSnsPermissionUI.this.ehJ == null || !SayHiWithSnsPermissionUI.this.ehJ.isShowing()) {
                final C1207m c9770o;
                SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI;
                Context context;
                if (SayHiWithSnsPermissionUI.this.ppu) {
                    int i;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(SayHiWithSnsPermissionUI.this.userName);
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(Integer.valueOf(SayHiWithSnsPermissionUI.this.gwP));
                    String h = SayHiWithSnsPermissionUI.m32947h(SayHiWithSnsPermissionUI.this);
                    HashMap hashMap = new HashMap();
                    if (SayHiWithSnsPermissionUI.this.ppt.zMU) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    hashMap.put(SayHiWithSnsPermissionUI.this.userName, Integer.valueOf(i));
                    C4990ab.m7411d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", Integer.valueOf(i));
                    if (C7616ad.aox(SayHiWithSnsPermissionUI.this.userName)) {
                        c9770o = new C9770o(SayHiWithSnsPermissionUI.this.userName, h, SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(C5495b.yfT));
                        C9638aw.m17182Rg().mo14541a(c9770o, 0);
                        sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.ylL;
                        SayHiWithSnsPermissionUI.this.getString(C25738R.string.f9238tz);
                        sayHiWithSnsPermissionUI.ehJ = C30379h.m48458b(context, SayHiWithSnsPermissionUI.this.getString(C25738R.string.e3p), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(23771);
                                C9638aw.m17182Rg().mo14547c(c9770o);
                                AppMethodBeat.m2505o(23771);
                            }
                        });
                    } else {
                        final C1207m c46498m = new C46498m(linkedList, linkedList2, h, "", hashMap, SayHiWithSnsPermissionUI.this.chatroomName);
                        String stringExtra = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                        String stringExtra2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                        if (!C5046bo.isNullOrNil(stringExtra)) {
                            c46498m.mo74715hB(stringExtra, stringExtra2);
                        }
                        C9638aw.m17182Rg().mo14541a(c46498m, 0);
                        SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI2 = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.ylL;
                        SayHiWithSnsPermissionUI.this.getString(C25738R.string.f9238tz);
                        sayHiWithSnsPermissionUI2.ehJ = C30379h.m48458b(context, SayHiWithSnsPermissionUI.this.getString(C25738R.string.e3p), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(23772);
                                C9638aw.m17182Rg().mo14547c(c46498m);
                                AppMethodBeat.m2505o(23772);
                            }
                        });
                    }
                } else if (SayHiWithSnsPermissionUI.this.ppv) {
                    String stringExtra3 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("Verify_ticket");
                    if (C7616ad.aox(SayHiWithSnsPermissionUI.this.userName)) {
                        c9770o = new C42240q(SayHiWithSnsPermissionUI.this.userName, stringExtra3);
                        C9638aw.m17182Rg().mo14541a(c9770o, 0);
                        sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.ylL;
                        SayHiWithSnsPermissionUI.this.getString(C25738R.string.f9238tz);
                        sayHiWithSnsPermissionUI.ehJ = C30379h.m48458b(context, SayHiWithSnsPermissionUI.this.getString(C25738R.string.avi), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(23773);
                                C9638aw.m17182Rg().mo14547c(c9770o);
                                AppMethodBeat.m2505o(23773);
                            }
                        });
                    } else {
                        c9770o = new C46498m(SayHiWithSnsPermissionUI.this.userName, stringExtra3, SayHiWithSnsPermissionUI.this.gwP, (byte) 0);
                        C9638aw.m17182Rg().mo14541a(c9770o, 0);
                        sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.ylL;
                        SayHiWithSnsPermissionUI.this.getString(C25738R.string.f9238tz);
                        sayHiWithSnsPermissionUI.ehJ = C30379h.m48458b(context, SayHiWithSnsPermissionUI.this.getString(C25738R.string.avi), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(23774);
                                C9638aw.m17182Rg().mo14547c(c9770o);
                                AppMethodBeat.m2505o(23774);
                            }
                        });
                    }
                }
                AppMethodBeat.m2505o(23775);
            } else {
                AppMethodBeat.m2505o(23775);
            }
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SayHiWithSnsPermissionUI() {
        AppMethodBeat.m2504i(23779);
        AppMethodBeat.m2505o(23779);
    }

    /* renamed from: a */
    static /* synthetic */ void m32940a(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.m2504i(23792);
        sayHiWithSnsPermissionUI.cbz();
        AppMethodBeat.m2505o(23792);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(23780);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(23780);
    }

    public final int getLayoutId() {
        return 2130970537;
    }

    public void onResume() {
        AppMethodBeat.m2504i(23781);
        if (this.ppw) {
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10118a(this.ppA);
            cbz();
        }
        C9638aw.m17182Rg().mo14539a(30, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(243, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(853, (C1202f) this);
        super.onResume();
        AppMethodBeat.m2505o(23781);
    }

    public void onStop() {
        AppMethodBeat.m2504i(23782);
        C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(243, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(853, (C1202f) this);
        if (this.ppw) {
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10121b(this.ppA);
        }
        super.onStop();
        AppMethodBeat.m2505o(23782);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(23783);
        C7060h.pYm.mo8381e(14036, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]), Integer.valueOf(this.gCr[5]), Integer.valueOf(this.gCr[6]), Integer.valueOf(this.gCr[7]));
        super.onDestroy();
        this.mController.removeAllOptionMenu();
        AppMethodBeat.m2505o(23783);
    }

    public final void initView() {
        String mJ;
        AppMethodBeat.m2504i(23784);
        this.ppt = (MMSwitchBtn) findViewById(2131827185).findViewById(2131820932);
        this.ppt.setCheck(getIntent().getBooleanExtra("sayhi_with_sns_permission", false));
        this.ppu = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
        this.ppv = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
        this.ppw = getIntent().getBooleanExtra("sayhi_with_sns_perm_set_label", false);
        this.userName = getIntent().getStringExtra("Contact_User");
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.chatroomName = getIntent().getStringExtra("room_name");
        this.bCv = getIntent().getStringExtra("Contact_RemarkName");
        this.bCu = getIntent().getStringExtra("Contact_Nick");
        this.oPy = getIntent().getStringExtra("Contact_RoomNickname");
        this.ppr = findViewById(2131827180);
        this.pps = (TextView) findViewById(2131827181);
        setMMTitle(getString(C25738R.string.f9176ru));
        if (C7616ad.aox(this.userName)) {
            View findViewById = findViewById(2131827184);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        if (this.ppu) {
            String substring;
            setMMTitle(getString(C25738R.string.e3t));
            this.ppp = (EditText) findViewById(2131827175);
            this.ppp.setMinHeight(this.mController.ylL.getResources().getDimensionPixelSize(C25738R.dimen.f9959lf));
            C7357c.m12555d(this.ppp).mo15877PM(100).mo15879a(null);
            this.ppp.setFilters(C14985g.vuR);
            ((LinearLayout) this.ppp.getParent()).setVisibility(0);
            C9638aw.m17190ZK();
            CharSequence charSequence = (String) C18628c.m29072Ry().get(294913, null);
            String YB = C1853r.m3820YB();
            if (YB == null) {
                YB = "";
            }
            String string = getString(C25738R.string.e3j);
            if (string.length() + YB.length() > 50) {
                substring = YB.substring(0, 50 - string.length());
            } else {
                substring = YB;
            }
            if (!C5046bo.isNullOrNil(this.chatroomName)) {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.chatroomName);
                if (!(aoO == null || C5046bo.isNullOrNil(aoO.field_nickname))) {
                    mJ = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.chatroomName).mo16807mJ(C1853r.m3846Yz());
                    if (C5046bo.m7519ac(mJ)) {
                        mJ = substring;
                    }
                    C4990ab.m7417i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", this.chatroomName, aoO.field_nickname);
                    charSequence = C44089j.m79293b(this.mController.ylL, getResources().getString(C25738R.string.e3k, new Object[]{aoO.field_nickname, mJ}), this.ppp.getTextSize());
                    this.ppB = charSequence;
                }
            }
            if (C5046bo.m7519ac(this.ppB)) {
                this.ppB = C44089j.m79293b(this.mController.ylL, String.format(string, new Object[]{substring}), this.ppp.getTextSize());
            }
            if (C5046bo.m7519ac(charSequence)) {
                this.ppp.setText(this.ppB);
            } else {
                this.ppp.setText(C44089j.m79293b(this.mController.ylL, charSequence, this.ppp.getTextSize()));
            }
            this.ppp.requestFocus();
            this.ppp.postDelayed(new C214772(), 100);
        }
        if (this.ppv) {
            this.ppq = (EditText) findViewById(2131827179);
            ((LinearLayout) this.ppq.getParent()).setVisibility(0);
            if (!this.ppu) {
                this.ppq.clearFocus();
            }
            this.ppq.setMinHeight(this.mController.ylL.getResources().getDimensionPixelSize(C25738R.dimen.f9959lf));
            C7357c.m12555d(this.ppq).mo15877PM(100).mo15879a(null);
            this.ppq.setFilters(C14985g.vuR);
            if (!this.ppu) {
                this.gCr[0] = 1;
                setMMTitle(getString(C25738R.string.b2x));
                LayoutParams layoutParams = (LayoutParams) ((View) this.ppq.getParent()).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            if (C5046bo.isNullOrNil(this.bCv)) {
                if (!C5046bo.isNullOrNil(this.bCu)) {
                    this.ppq.setHint(C44089j.m79293b(this.mController.ylL, this.bCu, this.ppq.getTextSize()));
                    this.ppq.setOnFocusChangeListener(new C214783());
                }
                boolean cbC;
                switch (this.gwP) {
                    case 8:
                    case 14:
                        cbC = cbC();
                        break;
                    case 10:
                    case 11:
                    case 13:
                        cbC = cbB();
                        break;
                    default:
                        cbC = false;
                        break;
                }
                if (!(this.ppu || cbC)) {
                    cbD();
                }
            } else {
                this.ppq.setText(C44089j.m79293b(this.mController.ylL, this.bCv, this.ppq.getTextSize()));
                this.gCr[6] = 1;
            }
        }
        if (C7616ad.aox(this.userName)) {
            this.ppw = false;
        }
        if (this.ppw) {
            this.ppx = (TextView) findViewById(2131827182);
            this.ppy = (MMTagPanel) findViewById(2131827183);
            this.ppy.setPanelClickable(false);
            ((LinearLayout) ((FrameLayout) this.ppy.getParent()).getParent()).setVisibility(0);
            this.ppx.setOnClickListener(new C214814());
            this.ppy.setOnClickListener(new C214805());
        }
        cbz();
        if (!C5046bo.isNullOrNil(this.nIM)) {
            this.gCr[7] = 1;
        }
        mJ = getString(C25738R.string.f9221tf);
        if (!this.ppu) {
            mJ = getString(C25738R.string.f9142qt);
        }
        mo17379a(0, mJ, (OnMenuItemClickListener) new C214826(), C5535b.GREEN);
        setBackBtn(new C36287());
        AppMethodBeat.m2505o(23784);
    }

    private void cbz() {
        AppMethodBeat.m2504i(23785);
        C9638aw.m17190ZK();
        C7575bv RB = C18628c.m29079XN().mo15364RB(this.userName);
        if (RB != null) {
            this.nIM = RB.field_contactLabels;
            this.ppz = (ArrayList) C21156a.bJa().mo41633PF(this.nIM);
        }
        if (this.ppw) {
            cbA();
        }
        AppMethodBeat.m2505o(23785);
    }

    private void cbA() {
        AppMethodBeat.m2504i(23786);
        if (C5046bo.isNullOrNil(this.nIM)) {
            this.ppy.setVisibility(4);
            this.ppx.setVisibility(0);
            AppMethodBeat.m2505o(23786);
            return;
        }
        this.ppy.setVisibility(0);
        this.ppx.setVisibility(4);
        this.ppy.mo71950a(this.ppz, this.ppz);
        AppMethodBeat.m2505o(23786);
    }

    private boolean cbB() {
        AppMethodBeat.m2504i(23787);
        C18817a vT = C32923a.getAddrUploadStg().mo34089vT(this.userName);
        if (vT == null || C5046bo.isNullOrNil(vT.apA()) || vT.apA().equals(this.ppq.getText().toString())) {
            AppMethodBeat.m2505o(23787);
            return false;
        }
        this.ppr.setVisibility(0);
        this.pps.setText(C44089j.m79293b((Context) this, C5046bo.nullAsNil(getString(C25738R.string.b05, new Object[]{vT.apA()})), this.pps.getTextSize()));
        C44090k c44090k = new C44090k(getString(C25738R.string.g1q));
        c44090k.setSpan(new C21479a(vT.apA()), 0, c44090k.length(), 17);
        this.pps.append(" ");
        this.pps.append(c44090k);
        this.pps.setMovementMethod(LinkMovementMethod.getInstance());
        this.gCr[3] = 1;
        AppMethodBeat.m2505o(23787);
        return true;
    }

    private boolean cbC() {
        AppMethodBeat.m2504i(23788);
        if (C5046bo.isNullOrNil(this.oPy) || this.oPy.equals(this.ppq.getText().toString())) {
            AppMethodBeat.m2505o(23788);
            return false;
        }
        this.ppr.setVisibility(0);
        this.pps.setText(C44089j.m79293b((Context) this, C5046bo.nullAsNil(getString(C25738R.string.b04, new Object[]{this.oPy})), this.pps.getTextSize()));
        C44090k c44090k = new C44090k(getString(C25738R.string.g1q));
        c44090k.setSpan(new C21479a(this.oPy), 0, c44090k.length(), 17);
        this.pps.append(" ");
        this.pps.append(c44090k);
        this.pps.setMovementMethod(LinkMovementMethod.getInstance());
        this.gCr[3] = 2;
        AppMethodBeat.m2505o(23788);
        return true;
    }

    private boolean cbD() {
        AppMethodBeat.m2504i(23789);
        C7569ax apx = C41789d.akO().apx(this.userName);
        if (apx == null) {
            AppMethodBeat.m2505o(23789);
            return false;
        }
        C14957b b = C14957b.m23244b(this, apx);
        if (C5046bo.isNullOrNil(b.fjz) || b.fjz.equals(getString(C25738R.string.bw7))) {
            AppMethodBeat.m2505o(23789);
            return false;
        }
        String substring = getString(C25738R.string.e3j).substring(0, getString(C25738R.string.e3j).indexOf("%s"));
        String str = b.fjz;
        if (b.fjz.startsWith(substring)) {
            str = b.fjz.substring(substring.length());
        }
        this.ppr.setVisibility(0);
        this.pps.setText(C44089j.m79293b((Context) this, C5046bo.nullAsNil(getString(C25738R.string.b07, new Object[]{b.fjz})), this.pps.getTextSize()));
        C44090k c44090k = new C44090k(getString(C25738R.string.g1q));
        c44090k.setSpan(new C21479a(str), 0, c44090k.length(), 17);
        this.pps.append(" ");
        this.pps.append(c44090k);
        this.pps.setMovementMethod(LinkMovementMethod.getInstance());
        this.gCr[3] = 3;
        AppMethodBeat.m2505o(23789);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(23790);
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7416i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (this.ppu) {
                int i3;
                Object trim = this.ppp.getText().toString().trim();
                if (C5046bo.isNullOrNil(trim) || trim.equals(this.ppB) || !C5046bo.isNullOrNil(this.chatroomName)) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(294913, (Object) "");
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(294913, trim);
                }
                switch (i2) {
                    case -34:
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        Toast.makeText(this, C25738R.string.bwe, 0).show();
                        i3 = 1;
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        Toast.makeText(this, C25738R.string.e3n, 0).show();
                        i3 = 1;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                if (i3 != 0) {
                    C4990ab.m7417i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(23790);
                    return;
                }
            }
            if (i == 0 && i2 == 0) {
                C30379h.m48465bQ(this, getString(C25738R.string.e3o));
                if (this.ppv) {
                    int i4;
                    String str2 = "";
                    if (this.ppq.getText() != null) {
                        str2 = this.ppq.getText().toString();
                    }
                    if (!C5046bo.isNullOrNil(str2) && str2.length() > 50) {
                        str2 = str2.substring(0, 50);
                    }
                    if (!C5046bo.isNullOrNil(str2)) {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(this.userName);
                        aoO.mo14729iz(str2);
                        C9638aw.m17190ZK();
                        C7575bv RB = C18628c.m29079XN().mo15364RB(this.userName);
                        RB.field_encryptUsername = this.userName;
                        RB.field_conRemark = str2;
                        C9638aw.m17190ZK();
                        C18628c.m29079XN().mo10099a(RB);
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15701Y(aoO);
                        this.gCr[2] = 1;
                        if (!(C5046bo.isNullOrNil(this.bCu) || str2.equals(this.bCu))) {
                            this.gCr[5] = 1;
                        }
                    } else if (C5046bo.isNullOrNil(this.bCu)) {
                        this.gCr[2] = 2;
                    } else {
                        this.gCr[2] = 0;
                    }
                    List linkedList = new LinkedList();
                    if (c1207m instanceof C46498m) {
                        i4 = ((C46498m) c1207m).cAd;
                        linkedList = ((C46498m) c1207m).vbm;
                    } else {
                        if (c1207m instanceof C42240q) {
                            linkedList.add(((C42240q) c1207m).geZ);
                        }
                        i4 = 0;
                    }
                    if (i4 == 3 || (c1207m instanceof C42240q)) {
                        C7569ax apx = C41789d.akO().apx(this.userName);
                        C9638aw.m17190ZK();
                        C7616ad aoO2 = C18628c.m29078XM().aoO(this.userName);
                        if (linkedList != null && linkedList.contains(this.userName)) {
                            if (((int) aoO2.ewQ) == 0) {
                                aoO2 = C14957b.m23239a(apx);
                                C9638aw.m17190ZK();
                                if (!C18628c.m29078XM().mo15702Z(aoO2)) {
                                    C4990ab.m7412e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
                                }
                            }
                            C1855t.m3960q(aoO2);
                            C9638aw.getNotification().mo41568IH();
                            C41789d.akP().mo17076ep(this.userName, 1);
                            C14957b.m23245bG(this.userName, this.gwP);
                        }
                        C9638aw.m17190ZK();
                        aoO2 = C18628c.m29078XM().aoO(this.userName);
                        C18384ro c18384ro = new C18384ro();
                        c18384ro.cNw.cNy = true;
                        c18384ro.cNw.cNx = false;
                        c18384ro.cNw.username = this.userName;
                        C4879a.xxA.mo10055m(c18384ro);
                        if (this.ppt.zMU) {
                            C1855t.m3895k(aoO2);
                        } else {
                            C1855t.m3898l(aoO2);
                        }
                        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
                            Intent intent = new Intent();
                            intent.putExtra("friend_message_transfer_username", this.userName);
                            intent.setAction("friend_message_accept_" + this.userName);
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8403df);
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8402dc);
                            C25985d.m41467b((Context) this, "subapp", ".ui.friend.FMessageTransferUI", intent);
                        }
                    }
                }
                getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
                C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(getIntent())), Integer.valueOf(1));
                setResult(-1, getIntent());
                finish();
            } else if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                Toast.makeText(this, str, 1).show();
            } else if (i != 4 || (!(i2 == -2 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || C5046bo.isNullOrNil(str))) {
                Toast.makeText(this, C25738R.string.e3n, 0).show();
            } else {
                C30379h.m48443a((Context) this, str, getString(C25738R.string.f9238tz), getString(C25738R.string.f9187s6), null);
            }
            C4990ab.m7417i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(23790);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e.getMessage());
            C4990ab.m7417i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(23790);
        } catch (Throwable th) {
            C4990ab.m7417i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(23790);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(23791);
        if (i == 4) {
            this.gCr[0] = 1;
            finish();
            AppMethodBeat.m2505o(23791);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(23791);
        return onKeyDown;
    }

    /* renamed from: c */
    static /* synthetic */ void m32942c(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.m2504i(23793);
        Intent intent = new Intent();
        intent.putExtra("label_id_list", sayHiWithSnsPermissionUI.nIM);
        if (sayHiWithSnsPermissionUI.ppz != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) sayHiWithSnsPermissionUI.ppz);
        }
        intent.putExtra("label_username", sayHiWithSnsPermissionUI.userName);
        intent.putExtra("is_stranger", true);
        C25985d.m41467b((Context) sayHiWithSnsPermissionUI, "label", ".ui.ContactLabelUI", intent);
        AppMethodBeat.m2505o(23793);
    }

    /* renamed from: h */
    static /* synthetic */ String m32947h(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.m2504i(23794);
        String trim = sayHiWithSnsPermissionUI.ppp.getText().toString().trim();
        if (trim.length() <= 50) {
            AppMethodBeat.m2505o(23794);
            return trim;
        }
        trim = trim.substring(0, 50);
        AppMethodBeat.m2505o(23794);
        return trim;
    }
}
