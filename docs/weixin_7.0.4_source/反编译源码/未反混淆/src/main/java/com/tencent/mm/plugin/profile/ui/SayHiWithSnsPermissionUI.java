package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public class SayHiWithSnsPermissionUI extends MMActivity implements f {
    private String bCu;
    private String bCv;
    private String chatroomName;
    private ProgressDialog ehJ = null;
    private int[] gCr = new int[8];
    private int gwP;
    private String nIM;
    private String oPy;
    private b ppA = new b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(23766);
            SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this);
            AppMethodBeat.o(23766);
        }
    };
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

    class a extends ClickableSpan {
        public String hHV;

        public a(String str) {
            this.hHV = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(23777);
            SayHiWithSnsPermissionUI.this.ppq.setText(j.b(SayHiWithSnsPermissionUI.this, bo.nullAsNil(this.hHV), SayHiWithSnsPermissionUI.this.ppq.getTextSize()));
            SayHiWithSnsPermissionUI.this.ppq.setSelection(SayHiWithSnsPermissionUI.this.ppq.getText().length());
            SayHiWithSnsPermissionUI.this.ppr.setVisibility(8);
            SayHiWithSnsPermissionUI.this.gCr[4] = 1;
            AppMethodBeat.o(23777);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(23778);
            textPaint.setColor(SayHiWithSnsPermissionUI.this.getResources().getColor(R.color.hb));
            textPaint.setUnderlineText(false);
            AppMethodBeat.o(23778);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SayHiWithSnsPermissionUI() {
        AppMethodBeat.i(23779);
        AppMethodBeat.o(23779);
    }

    static /* synthetic */ void a(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.i(23792);
        sayHiWithSnsPermissionUI.cbz();
        AppMethodBeat.o(23792);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23780);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(23780);
    }

    public final int getLayoutId() {
        return R.layout.ap6;
    }

    public void onResume() {
        AppMethodBeat.i(23781);
        if (this.ppw) {
            aw.ZK();
            c.XM().a(this.ppA);
            cbz();
        }
        aw.Rg().a(30, (f) this);
        aw.Rg().a(243, (f) this);
        aw.Rg().a(853, (f) this);
        super.onResume();
        AppMethodBeat.o(23781);
    }

    public void onStop() {
        AppMethodBeat.i(23782);
        aw.Rg().b(30, (f) this);
        aw.Rg().b(243, (f) this);
        aw.Rg().b(853, (f) this);
        if (this.ppw) {
            aw.ZK();
            c.XM().b(this.ppA);
        }
        super.onStop();
        AppMethodBeat.o(23782);
    }

    public void onDestroy() {
        AppMethodBeat.i(23783);
        h.pYm.e(14036, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]), Integer.valueOf(this.gCr[5]), Integer.valueOf(this.gCr[6]), Integer.valueOf(this.gCr[7]));
        super.onDestroy();
        this.mController.removeAllOptionMenu();
        AppMethodBeat.o(23783);
    }

    public final void initView() {
        String mJ;
        AppMethodBeat.i(23784);
        this.ppt = (MMSwitchBtn) findViewById(R.id.e4i).findViewById(R.id.js);
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
        this.ppr = findViewById(R.id.e4d);
        this.pps = (TextView) findViewById(R.id.e4e);
        setMMTitle(getString(R.string.ru));
        if (ad.aox(this.userName)) {
            View findViewById = findViewById(R.id.e4h);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        if (this.ppu) {
            String substring;
            setMMTitle(getString(R.string.e3t));
            this.ppp = (EditText) findViewById(R.id.e49);
            this.ppp.setMinHeight(this.mController.ylL.getResources().getDimensionPixelSize(R.dimen.lf));
            com.tencent.mm.ui.tools.b.c.d(this.ppp).PM(100).a(null);
            this.ppp.setFilters(g.vuR);
            ((LinearLayout) this.ppp.getParent()).setVisibility(0);
            aw.ZK();
            CharSequence charSequence = (String) c.Ry().get(294913, null);
            String YB = r.YB();
            if (YB == null) {
                YB = "";
            }
            String string = getString(R.string.e3j);
            if (string.length() + YB.length() > 50) {
                substring = YB.substring(0, 50 - string.length());
            } else {
                substring = YB;
            }
            if (!bo.isNullOrNil(this.chatroomName)) {
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.chatroomName);
                if (!(aoO == null || bo.isNullOrNil(aoO.field_nickname))) {
                    mJ = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().ob(this.chatroomName).mJ(r.Yz());
                    if (bo.ac(mJ)) {
                        mJ = substring;
                    }
                    ab.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", this.chatroomName, aoO.field_nickname);
                    charSequence = j.b(this.mController.ylL, getResources().getString(R.string.e3k, new Object[]{aoO.field_nickname, mJ}), this.ppp.getTextSize());
                    this.ppB = charSequence;
                }
            }
            if (bo.ac(this.ppB)) {
                this.ppB = j.b(this.mController.ylL, String.format(string, new Object[]{substring}), this.ppp.getTextSize());
            }
            if (bo.ac(charSequence)) {
                this.ppp.setText(this.ppB);
            } else {
                this.ppp.setText(j.b(this.mController.ylL, charSequence, this.ppp.getTextSize()));
            }
            this.ppp.requestFocus();
            this.ppp.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23767);
                    SayHiWithSnsPermissionUI.this.showVKB();
                    AppMethodBeat.o(23767);
                }
            }, 100);
        }
        if (this.ppv) {
            this.ppq = (EditText) findViewById(R.id.e4c);
            ((LinearLayout) this.ppq.getParent()).setVisibility(0);
            if (!this.ppu) {
                this.ppq.clearFocus();
            }
            this.ppq.setMinHeight(this.mController.ylL.getResources().getDimensionPixelSize(R.dimen.lf));
            com.tencent.mm.ui.tools.b.c.d(this.ppq).PM(100).a(null);
            this.ppq.setFilters(g.vuR);
            if (!this.ppu) {
                this.gCr[0] = 1;
                setMMTitle(getString(R.string.b2x));
                LayoutParams layoutParams = (LayoutParams) ((View) this.ppq.getParent()).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            if (bo.isNullOrNil(this.bCv)) {
                if (!bo.isNullOrNil(this.bCu)) {
                    this.ppq.setHint(j.b(this.mController.ylL, this.bCu, this.ppq.getTextSize()));
                    this.ppq.setOnFocusChangeListener(new OnFocusChangeListener() {
                        public final void onFocusChange(View view, boolean z) {
                            AppMethodBeat.i(23768);
                            if (z && !bo.ac(SayHiWithSnsPermissionUI.this.ppq.getHint()) && bo.ac(SayHiWithSnsPermissionUI.this.ppq.getText())) {
                                SayHiWithSnsPermissionUI.this.ppq.setText(SayHiWithSnsPermissionUI.this.ppq.getHint());
                                SayHiWithSnsPermissionUI.this.ppq.setOnFocusChangeListener(null);
                                SayHiWithSnsPermissionUI.this.ppq.setHint(null);
                            }
                            AppMethodBeat.o(23768);
                        }
                    });
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
                this.ppq.setText(j.b(this.mController.ylL, this.bCv, this.ppq.getTextSize()));
                this.gCr[6] = 1;
            }
        }
        if (ad.aox(this.userName)) {
            this.ppw = false;
        }
        if (this.ppw) {
            this.ppx = (TextView) findViewById(R.id.e4f);
            this.ppy = (MMTagPanel) findViewById(R.id.e4g);
            this.ppy.setPanelClickable(false);
            ((LinearLayout) ((FrameLayout) this.ppy.getParent()).getParent()).setVisibility(0);
            this.ppx.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23769);
                    SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this);
                    AppMethodBeat.o(23769);
                }
            });
            this.ppy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23770);
                    SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this);
                    AppMethodBeat.o(23770);
                }
            });
        }
        cbz();
        if (!bo.isNullOrNil(this.nIM)) {
            this.gCr[7] = 1;
        }
        mJ = getString(R.string.tf);
        if (!this.ppu) {
            mJ = getString(R.string.qt);
        }
        a(0, mJ, (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23775);
                if (SayHiWithSnsPermissionUI.this.ehJ == null || !SayHiWithSnsPermissionUI.this.ehJ.isShowing()) {
                    final m oVar;
                    SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI;
                    Context context;
                    if (SayHiWithSnsPermissionUI.this.ppu) {
                        int i;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(SayHiWithSnsPermissionUI.this.userName);
                        LinkedList linkedList2 = new LinkedList();
                        linkedList2.add(Integer.valueOf(SayHiWithSnsPermissionUI.this.gwP));
                        String h = SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this);
                        HashMap hashMap = new HashMap();
                        if (SayHiWithSnsPermissionUI.this.ppt.zMU) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        hashMap.put(SayHiWithSnsPermissionUI.this.userName, Integer.valueOf(i));
                        ab.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", Integer.valueOf(i));
                        if (ad.aox(SayHiWithSnsPermissionUI.this.userName)) {
                            oVar = new o(SayHiWithSnsPermissionUI.this.userName, h, SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(e.b.yfT));
                            aw.Rg().a(oVar, 0);
                            sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                            context = SayHiWithSnsPermissionUI.this.mController.ylL;
                            SayHiWithSnsPermissionUI.this.getString(R.string.tz);
                            sayHiWithSnsPermissionUI.ehJ = com.tencent.mm.ui.base.h.b(context, SayHiWithSnsPermissionUI.this.getString(R.string.e3p), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(23771);
                                    aw.Rg().c(oVar);
                                    AppMethodBeat.o(23771);
                                }
                            });
                        } else {
                            final m mVar = new com.tencent.mm.pluginsdk.model.m(linkedList, linkedList2, h, "", hashMap, SayHiWithSnsPermissionUI.this.chatroomName);
                            String stringExtra = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                            String stringExtra2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                            if (!bo.isNullOrNil(stringExtra)) {
                                mVar.hB(stringExtra, stringExtra2);
                            }
                            aw.Rg().a(mVar, 0);
                            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI2 = SayHiWithSnsPermissionUI.this;
                            context = SayHiWithSnsPermissionUI.this.mController.ylL;
                            SayHiWithSnsPermissionUI.this.getString(R.string.tz);
                            sayHiWithSnsPermissionUI2.ehJ = com.tencent.mm.ui.base.h.b(context, SayHiWithSnsPermissionUI.this.getString(R.string.e3p), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(23772);
                                    aw.Rg().c(mVar);
                                    AppMethodBeat.o(23772);
                                }
                            });
                        }
                    } else if (SayHiWithSnsPermissionUI.this.ppv) {
                        String stringExtra3 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("Verify_ticket");
                        if (ad.aox(SayHiWithSnsPermissionUI.this.userName)) {
                            oVar = new q(SayHiWithSnsPermissionUI.this.userName, stringExtra3);
                            aw.Rg().a(oVar, 0);
                            sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                            context = SayHiWithSnsPermissionUI.this.mController.ylL;
                            SayHiWithSnsPermissionUI.this.getString(R.string.tz);
                            sayHiWithSnsPermissionUI.ehJ = com.tencent.mm.ui.base.h.b(context, SayHiWithSnsPermissionUI.this.getString(R.string.avi), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(23773);
                                    aw.Rg().c(oVar);
                                    AppMethodBeat.o(23773);
                                }
                            });
                        } else {
                            oVar = new com.tencent.mm.pluginsdk.model.m(SayHiWithSnsPermissionUI.this.userName, stringExtra3, SayHiWithSnsPermissionUI.this.gwP, (byte) 0);
                            aw.Rg().a(oVar, 0);
                            sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                            context = SayHiWithSnsPermissionUI.this.mController.ylL;
                            SayHiWithSnsPermissionUI.this.getString(R.string.tz);
                            sayHiWithSnsPermissionUI.ehJ = com.tencent.mm.ui.base.h.b(context, SayHiWithSnsPermissionUI.this.getString(R.string.avi), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(23774);
                                    aw.Rg().c(oVar);
                                    AppMethodBeat.o(23774);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(23775);
                } else {
                    AppMethodBeat.o(23775);
                }
                return false;
            }
        }, com.tencent.mm.ui.q.b.GREEN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23776);
                if (SayHiWithSnsPermissionUI.this.ppv) {
                    SayHiWithSnsPermissionUI.this.gCr[1] = 1;
                }
                SayHiWithSnsPermissionUI.this.finish();
                AppMethodBeat.o(23776);
                return true;
            }
        });
        AppMethodBeat.o(23784);
    }

    private void cbz() {
        AppMethodBeat.i(23785);
        aw.ZK();
        bv RB = c.XN().RB(this.userName);
        if (RB != null) {
            this.nIM = RB.field_contactLabels;
            this.ppz = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PF(this.nIM);
        }
        if (this.ppw) {
            cbA();
        }
        AppMethodBeat.o(23785);
    }

    private void cbA() {
        AppMethodBeat.i(23786);
        if (bo.isNullOrNil(this.nIM)) {
            this.ppy.setVisibility(4);
            this.ppx.setVisibility(0);
            AppMethodBeat.o(23786);
            return;
        }
        this.ppy.setVisibility(0);
        this.ppx.setVisibility(4);
        this.ppy.a(this.ppz, this.ppz);
        AppMethodBeat.o(23786);
    }

    private boolean cbB() {
        AppMethodBeat.i(23787);
        com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.userName);
        if (vT == null || bo.isNullOrNil(vT.apA()) || vT.apA().equals(this.ppq.getText().toString())) {
            AppMethodBeat.o(23787);
            return false;
        }
        this.ppr.setVisibility(0);
        this.pps.setText(j.b((Context) this, bo.nullAsNil(getString(R.string.b05, new Object[]{vT.apA()})), this.pps.getTextSize()));
        k kVar = new k(getString(R.string.g1q));
        kVar.setSpan(new a(vT.apA()), 0, kVar.length(), 17);
        this.pps.append(" ");
        this.pps.append(kVar);
        this.pps.setMovementMethod(LinkMovementMethod.getInstance());
        this.gCr[3] = 1;
        AppMethodBeat.o(23787);
        return true;
    }

    private boolean cbC() {
        AppMethodBeat.i(23788);
        if (bo.isNullOrNil(this.oPy) || this.oPy.equals(this.ppq.getText().toString())) {
            AppMethodBeat.o(23788);
            return false;
        }
        this.ppr.setVisibility(0);
        this.pps.setText(j.b((Context) this, bo.nullAsNil(getString(R.string.b04, new Object[]{this.oPy})), this.pps.getTextSize()));
        k kVar = new k(getString(R.string.g1q));
        kVar.setSpan(new a(this.oPy), 0, kVar.length(), 17);
        this.pps.append(" ");
        this.pps.append(kVar);
        this.pps.setMovementMethod(LinkMovementMethod.getInstance());
        this.gCr[3] = 2;
        AppMethodBeat.o(23788);
        return true;
    }

    private boolean cbD() {
        AppMethodBeat.i(23789);
        ax apx = d.akO().apx(this.userName);
        if (apx == null) {
            AppMethodBeat.o(23789);
            return false;
        }
        com.tencent.mm.pluginsdk.ui.preference.b b = com.tencent.mm.pluginsdk.ui.preference.b.b(this, apx);
        if (bo.isNullOrNil(b.fjz) || b.fjz.equals(getString(R.string.bw7))) {
            AppMethodBeat.o(23789);
            return false;
        }
        String substring = getString(R.string.e3j).substring(0, getString(R.string.e3j).indexOf("%s"));
        String str = b.fjz;
        if (b.fjz.startsWith(substring)) {
            str = b.fjz.substring(substring.length());
        }
        this.ppr.setVisibility(0);
        this.pps.setText(j.b((Context) this, bo.nullAsNil(getString(R.string.b07, new Object[]{b.fjz})), this.pps.getTextSize()));
        k kVar = new k(getString(R.string.g1q));
        kVar.setSpan(new a(str), 0, kVar.length(), 17);
        this.pps.append(" ");
        this.pps.append(kVar);
        this.pps.setMovementMethod(LinkMovementMethod.getInstance());
        this.gCr[3] = 3;
        AppMethodBeat.o(23789);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(23790);
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (this.ppu) {
                int i3;
                Object trim = this.ppp.getText().toString().trim();
                if (bo.isNullOrNil(trim) || trim.equals(this.ppB) || !bo.isNullOrNil(this.chatroomName)) {
                    aw.ZK();
                    c.Ry().set(294913, (Object) "");
                } else {
                    aw.ZK();
                    c.Ry().set(294913, trim);
                }
                switch (i2) {
                    case -34:
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        Toast.makeText(this, R.string.bwe, 0).show();
                        i3 = 1;
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        Toast.makeText(this, R.string.e3n, 0).show();
                        i3 = 1;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                if (i3 != 0) {
                    ab.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(23790);
                    return;
                }
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bQ(this, getString(R.string.e3o));
                if (this.ppv) {
                    int i4;
                    String str2 = "";
                    if (this.ppq.getText() != null) {
                        str2 = this.ppq.getText().toString();
                    }
                    if (!bo.isNullOrNil(str2) && str2.length() > 50) {
                        str2 = str2.substring(0, 50);
                    }
                    if (!bo.isNullOrNil(str2)) {
                        aw.ZK();
                        ad aoO = c.XM().aoO(this.userName);
                        aoO.iz(str2);
                        aw.ZK();
                        bv RB = c.XN().RB(this.userName);
                        RB.field_encryptUsername = this.userName;
                        RB.field_conRemark = str2;
                        aw.ZK();
                        c.XN().a(RB);
                        aw.ZK();
                        c.XM().Y(aoO);
                        this.gCr[2] = 1;
                        if (!(bo.isNullOrNil(this.bCu) || str2.equals(this.bCu))) {
                            this.gCr[5] = 1;
                        }
                    } else if (bo.isNullOrNil(this.bCu)) {
                        this.gCr[2] = 2;
                    } else {
                        this.gCr[2] = 0;
                    }
                    List linkedList = new LinkedList();
                    if (mVar instanceof com.tencent.mm.pluginsdk.model.m) {
                        i4 = ((com.tencent.mm.pluginsdk.model.m) mVar).cAd;
                        linkedList = ((com.tencent.mm.pluginsdk.model.m) mVar).vbm;
                    } else {
                        if (mVar instanceof q) {
                            linkedList.add(((q) mVar).geZ);
                        }
                        i4 = 0;
                    }
                    if (i4 == 3 || (mVar instanceof q)) {
                        ax apx = d.akO().apx(this.userName);
                        aw.ZK();
                        ad aoO2 = c.XM().aoO(this.userName);
                        if (linkedList != null && linkedList.contains(this.userName)) {
                            if (((int) aoO2.ewQ) == 0) {
                                aoO2 = com.tencent.mm.pluginsdk.ui.preference.b.a(apx);
                                aw.ZK();
                                if (!c.XM().Z(aoO2)) {
                                    ab.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
                                }
                            }
                            t.q(aoO2);
                            aw.getNotification().IH();
                            d.akP().ep(this.userName, 1);
                            com.tencent.mm.pluginsdk.ui.preference.b.bG(this.userName, this.gwP);
                        }
                        aw.ZK();
                        aoO2 = c.XM().aoO(this.userName);
                        ro roVar = new ro();
                        roVar.cNw.cNy = true;
                        roVar.cNw.cNx = false;
                        roVar.cNw.username = this.userName;
                        com.tencent.mm.sdk.b.a.xxA.m(roVar);
                        if (this.ppt.zMU) {
                            t.k(aoO2);
                        } else {
                            t.l(aoO2);
                        }
                        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
                            Intent intent = new Intent();
                            intent.putExtra("friend_message_transfer_username", this.userName);
                            intent.setAction("friend_message_accept_" + this.userName);
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.df);
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.dc);
                            com.tencent.mm.bp.d.b((Context) this, "subapp", ".ui.friend.FMessageTransferUI", intent);
                        }
                    }
                }
                getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
                h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(getIntent())), Integer.valueOf(1));
                setResult(-1, getIntent());
                finish();
            } else if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                Toast.makeText(this, str, 1).show();
            } else if (i != 4 || (!(i2 == -2 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || bo.isNullOrNil(str))) {
                Toast.makeText(this, R.string.e3n, 0).show();
            } else {
                com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.string.tz), getString(R.string.s6), null);
            }
            ab.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(23790);
        } catch (Exception e) {
            ab.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e.getMessage());
            ab.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(23790);
        } catch (Throwable th) {
            ab.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(23790);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(23791);
        if (i == 4) {
            this.gCr[0] = 1;
            finish();
            AppMethodBeat.o(23791);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(23791);
        return onKeyDown;
    }

    static /* synthetic */ void c(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.i(23793);
        Intent intent = new Intent();
        intent.putExtra("label_id_list", sayHiWithSnsPermissionUI.nIM);
        if (sayHiWithSnsPermissionUI.ppz != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) sayHiWithSnsPermissionUI.ppz);
        }
        intent.putExtra("label_username", sayHiWithSnsPermissionUI.userName);
        intent.putExtra("is_stranger", true);
        com.tencent.mm.bp.d.b((Context) sayHiWithSnsPermissionUI, "label", ".ui.ContactLabelUI", intent);
        AppMethodBeat.o(23793);
    }

    static /* synthetic */ String h(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.i(23794);
        String trim = sayHiWithSnsPermissionUI.ppp.getText().toString().trim();
        if (trim.length() <= 50) {
            AppMethodBeat.o(23794);
            return trim;
        }
        trim = trim.substring(0, 50);
        AppMethodBeat.o(23794);
        return trim;
    }
}
