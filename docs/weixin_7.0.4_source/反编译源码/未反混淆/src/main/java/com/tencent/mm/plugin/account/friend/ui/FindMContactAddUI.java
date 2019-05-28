package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAddUI extends MMWizardActivity {
    private ProgressDialog ehJ = null;
    private String elr = null;
    private TextView emptyTipTv = null;
    private f fQS = null;
    private String gsF;
    private String gsy = "";
    private int gsz = 2;
    private ListView gtT;
    private i gwQ;
    private View gwR;
    private TextView gwS = null;
    private TextView gwT = null;
    private TextView gwU = null;
    private TextView gwV = null;
    private Button gwW = null;
    private int gwX;
    private List<String[]> gwY;
    private boolean gwZ = true;
    private a gxa = new a() {
        public final void notifyDataSetChanged() {
            AppMethodBeat.i(108520);
            if (FindMContactAddUI.this.gsz == 2 || FindMContactAddUI.this.gsz != 1) {
                FindMContactAddUI.this.gwW.setText(FindMContactAddUI.this.getString(R.string.bu2, new Object[]{Integer.valueOf(FindMContactAddUI.this.gwQ.getCount())}));
            } else {
                FindMContactAddUI.this.gwW.setText(FindMContactAddUI.this.getString(R.string.bu3));
            }
            if (FindMContactAddUI.this.gwQ.apN()) {
                if (!(FindMContactAddUI.this.gsz == 1 || FindMContactAddUI.this.gwW.getVisibility() != 0 || FindMContactAddUI.this.gwV == null)) {
                    FindMContactAddUI.this.gwW.setVisibility(8);
                    FindMContactAddUI.this.gwV.setVisibility(0);
                }
            } else if (!(FindMContactAddUI.this.gsz == 1 || FindMContactAddUI.this.gwW.getVisibility() != 8 || FindMContactAddUI.this.gwV == null)) {
                FindMContactAddUI.this.gwW.setVisibility(0);
                FindMContactAddUI.this.gwV.setVisibility(8);
            }
            if (FindMContactAddUI.this.gwQ.getSelectCount() <= 0 || FindMContactAddUI.this.gsz == 1) {
                FindMContactAddUI.this.gwS.setText(FindMContactAddUI.this.getResources().getQuantityString(R.plurals.i, FindMContactAddUI.this.gwQ.getCount(), new Object[]{Integer.valueOf(FindMContactAddUI.this.gwQ.getCount())}));
                AppMethodBeat.o(108520);
                return;
            }
            FindMContactAddUI.this.gwS.setText(FindMContactAddUI.this.getResources().getQuantityString(R.plurals.f, FindMContactAddUI.this.gwQ.getSelectCount(), new Object[]{Integer.valueOf(FindMContactAddUI.this.gwQ.getSelectCount())}));
            AppMethodBeat.o(108520);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FindMContactAddUI() {
        AppMethodBeat.i(108526);
        AppMethodBeat.o(108526);
    }

    static /* synthetic */ void n(FindMContactAddUI findMContactAddUI) {
        AppMethodBeat.i(108537);
        findMContactAddUI.aoZ();
        AppMethodBeat.o(108537);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108527);
        super.onCreate(bundle);
        setMMTitle((int) R.string.bu7);
        com.tencent.mm.plugin.account.a.a.gkF.BV();
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.gwX = getIntent().getIntExtra("login_type", 0);
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        AppMethodBeat.o(108527);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(108529);
        if (i == 4) {
            aoZ();
            AppMethodBeat.o(108529);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(108529);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(108530);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        aqX();
        Ni(1);
        AppMethodBeat.o(108530);
    }

    public void onResume() {
        AppMethodBeat.i(108531);
        super.onResume();
        this.gwQ.notifyDataSetChanged();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_300_QQ")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("R300_300_QQ");
        } else {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_300_phone,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_300_phone")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("R300_300_phone");
        }
        if (this.gwZ) {
            ab.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
            if (b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                aqv();
            } else {
                AppMethodBeat.o(108531);
                return;
            }
        }
        AppMethodBeat.o(108531);
    }

    public void onPause() {
        AppMethodBeat.i(108532);
        super.onPause();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_300_QQ")).append(",2").toString());
            AppMethodBeat.o(108532);
            return;
        }
        stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_300_phone")).append(",2").toString());
        AppMethodBeat.o(108532);
    }

    public void onDestroy() {
        AppMethodBeat.i(108533);
        if (this.fQS != null) {
            g.Rg().b(30, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.o(108533);
    }

    public final int getLayoutId() {
        return R.layout.zl;
    }

    public final void initView() {
        AppMethodBeat.i(108534);
        this.emptyTipTv = (TextView) findViewById(R.id.bt4);
        this.emptyTipTv.setText(R.string.d07);
        this.gtT = (ListView) findViewById(R.id.bsq);
        if (this.gsz == 2 || this.gsz != 1) {
            this.gwR = LayoutInflater.from(this).inflate(R.layout.zm, null);
            this.gwS = (TextView) this.gwR.findViewById(R.id.bt7);
            this.gwT = (TextView) this.gwR.findViewById(R.id.bt6);
            this.gwU = (TextView) this.gwR.findViewById(R.id.bt_);
            this.gwW = (Button) this.gwR.findViewById(R.id.bt9);
            this.gwT.setText(getString(R.string.buy));
            this.gwU.setText(getString(R.string.buz));
            this.gwW.setText(getString(R.string.bu2, new Object[]{Integer.valueOf(0)}));
            this.gwV = (TextView) this.gwR.findViewById(R.id.bt8);
        } else {
            this.gwR = LayoutInflater.from(this).inflate(R.layout.zn, null);
            this.gwS = (TextView) this.gwR.findViewById(R.id.bt7);
            this.gwT = (TextView) this.gwR.findViewById(R.id.bt6);
            this.gwU = (TextView) this.gwR.findViewById(R.id.bt_);
            this.gwW = (Button) this.gwR.findViewById(R.id.bt9);
            this.gwT.setText(getString(R.string.buy));
            this.gwU.setText(getString(R.string.buz));
            this.gwW.setText(getString(R.string.bu3));
        }
        this.gwQ = new i(this, this.gxa, 1);
        this.gwW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108521);
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FindMContactAddUI.this.getClass().getName()).append(",R300_300_AddAllButton,");
                g.RN();
                com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_300_AddAllButton")).append(",3").toString());
                if (FindMContactAddUI.this.gsz == 2) {
                    FindMContactAddUI.this.gwQ.dl(true);
                    FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                    FindMContactAddUI.this.gwW.setVisibility(8);
                    if (FindMContactAddUI.this.gwV != null) {
                        FindMContactAddUI.this.gwV.setVisibility(0);
                        AppMethodBeat.o(108521);
                        return;
                    }
                } else if (FindMContactAddUI.this.gsz == 1) {
                    FindMContactAddUI.this.gwQ.dl(true);
                    FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                    FindMContactAddUI.i(FindMContactAddUI.this);
                    AppMethodBeat.o(108521);
                    return;
                } else {
                    FindMContactAddUI.this.gwQ.dl(true);
                    FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                    FindMContactAddUI.this.gwW.setVisibility(8);
                    if (FindMContactAddUI.this.gwV != null) {
                        FindMContactAddUI.this.gwV.setVisibility(0);
                    }
                }
                AppMethodBeat.o(108521);
            }
        });
        if (this.gwV != null) {
            this.gwV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(108522);
                    FindMContactAddUI.this.gwW.setVisibility(0);
                    FindMContactAddUI.this.gwV.setVisibility(8);
                    FindMContactAddUI.this.gwQ.dl(false);
                    FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                    AppMethodBeat.o(108522);
                }
            });
            this.gwV.setVisibility(8);
        }
        this.gtT.addHeaderView(this.gwR);
        this.gtT.setAdapter(this.gwQ);
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108523);
                FindMContactAddUI.i(FindMContactAddUI.this);
                AppMethodBeat.o(108523);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108524);
                c.a(FindMContactAddUI.this.gtT);
                AppMethodBeat.o(108524);
            }
        };
        AppMethodBeat.o(108534);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(108535);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(108535);
            return;
        }
        ab.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(108515);
                            FindMContactAddUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FindMContactAddUI.this.gwZ = true;
                            FindMContactAddUI.this.finish();
                            AppMethodBeat.o(108515);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(108516);
                            FindMContactAddUI.this.gwZ = true;
                            FindMContactAddUI.this.finish();
                            AppMethodBeat.o(108516);
                        }
                    });
                    break;
                }
                aqv();
                AppMethodBeat.o(108535);
                return;
        }
        AppMethodBeat.o(108535);
    }

    private void aqv() {
        AppMethodBeat.i(108528);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.ehJ = h.b(context, getString(R.string.d09), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        g.RS().a(new al.a() {
            public final boolean acg() {
                AppMethodBeat.i(108517);
                if (FindMContactAddUI.this.ehJ != null) {
                    FindMContactAddUI.this.ehJ.dismiss();
                    FindMContactAddUI.this.ehJ = null;
                }
                FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                AppMethodBeat.o(108517);
                return false;
            }

            public final boolean acf() {
                AppMethodBeat.i(108518);
                try {
                    FindMContactAddUI.this.gwY = com.tencent.mm.pluginsdk.a.cJ(FindMContactAddUI.this);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FindMContactAddUI", e, "", new Object[0]);
                }
                FindMContactAddUI.this.gwQ.gsD = FindMContactAddUI.this.gwY;
                FindMContactAddUI.this.gwQ.r(((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
                AppMethodBeat.o(108518);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(108519);
                String str = super.toString() + "|listMFriendData";
                AppMethodBeat.o(108519);
                return str;
            }
        });
        AppMethodBeat.o(108528);
    }

    static /* synthetic */ void i(FindMContactAddUI findMContactAddUI) {
        AppMethodBeat.i(108536);
        findMContactAddUI.aqX();
        if (findMContactAddUI.gwQ.getSelectCount() == 0) {
            h.d(findMContactAddUI, findMContactAddUI.getString(R.string.bun), "", findMContactAddUI.getString(R.string.bu0), findMContactAddUI.getString(R.string.bu1), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(108525);
                    if (FindMContactAddUI.this.gsy == null || !FindMContactAddUI.this.gsy.contains("2")) {
                        FindMContactAddUI.n(FindMContactAddUI.this);
                        AppMethodBeat.o(108525);
                        return;
                    }
                    Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.elr);
                    intent.putExtra("login_type", FindMContactAddUI.this.gwX);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.gsz);
                    MMWizardActivity.J(FindMContactAddUI.this, intent);
                    AppMethodBeat.o(108525);
                }
            });
            AppMethodBeat.o(108536);
            return;
        }
        p Rg = g.Rg();
        f anonymousClass2 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(108514);
                if (FindMContactAddUI.this.ehJ != null) {
                    FindMContactAddUI.this.ehJ.dismiss();
                    FindMContactAddUI.this.ehJ = null;
                }
                if (FindMContactAddUI.this.fQS != null) {
                    g.Rg().b(30, FindMContactAddUI.this.fQS);
                    FindMContactAddUI.this.fQS = null;
                }
                if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                    Toast.makeText(FindMContactAddUI.this.mController.ylL, str, 1).show();
                    AppMethodBeat.o(108514);
                } else if (FindMContactAddUI.this.gsy == null || !FindMContactAddUI.this.gsy.contains("2")) {
                    FindMContactAddUI.n(FindMContactAddUI.this);
                    AppMethodBeat.o(108514);
                } else {
                    Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.elr);
                    intent.putExtra("login_type", FindMContactAddUI.this.gwX);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.gsz);
                    MMWizardActivity.J(FindMContactAddUI.this, intent);
                    AppMethodBeat.o(108514);
                }
            }
        };
        findMContactAddUI.fQS = anonymousClass2;
        Rg.a(30, anonymousClass2);
        Context context = findMContactAddUI.mController.ylL;
        findMContactAddUI.getString(R.string.tz);
        findMContactAddUI.ehJ = h.b(context, findMContactAddUI.getString(R.string.bud), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        i iVar = findMContactAddUI.gwQ;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < iVar.gvi.size(); i++) {
            if (iVar.gty[i] == 1) {
                linkedList.add(((aym) iVar.gvi.get(i)).jBB);
                linkedList2.add(Integer.valueOf(52));
            }
        }
        g.Rg().a(new com.tencent.mm.pluginsdk.model.m(2, linkedList, linkedList2, "", ""), 0);
        AppMethodBeat.o(108536);
    }
}
