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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class FindMContactInviteUI extends MMWizardActivity {
    private ProgressDialog ehJ = null;
    private TextView emptyTipTv = null;
    private f fQS = null;
    private String gsF;
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
            AppMethodBeat.i(108543);
            if (FindMContactInviteUI.this.gsz == 2 || FindMContactInviteUI.this.gsz != 1) {
                FindMContactInviteUI.this.gwW.setText(FindMContactInviteUI.this.getString(R.string.bua, new Object[]{Integer.valueOf(FindMContactInviteUI.this.gwQ.getCount())}));
            } else {
                FindMContactInviteUI.this.gwW.setText(FindMContactInviteUI.this.getString(R.string.bub));
            }
            if (FindMContactInviteUI.this.gwQ.apN()) {
                if (!(FindMContactInviteUI.this.gsz == 1 || FindMContactInviteUI.this.gwW.getVisibility() != 0 || FindMContactInviteUI.this.gwV == null)) {
                    FindMContactInviteUI.this.gwW.setVisibility(8);
                    FindMContactInviteUI.this.gwV.setVisibility(0);
                }
            } else if (!(FindMContactInviteUI.this.gsz == 1 || FindMContactInviteUI.this.gwW.getVisibility() != 8 || FindMContactInviteUI.this.gwV == null)) {
                FindMContactInviteUI.this.gwW.setVisibility(0);
                FindMContactInviteUI.this.gwV.setVisibility(8);
            }
            if (FindMContactInviteUI.this.gwQ.getSelectCount() <= 0 || FindMContactInviteUI.this.gsz == 1) {
                FindMContactInviteUI.this.gwS.setText(FindMContactInviteUI.this.getResources().getQuantityString(R.plurals.h, FindMContactInviteUI.this.gwQ.getCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.this.gwQ.getCount())}));
                AppMethodBeat.o(108543);
                return;
            }
            FindMContactInviteUI.this.gwS.setText(FindMContactInviteUI.this.getResources().getQuantityString(R.plurals.g, FindMContactInviteUI.this.gwQ.getSelectCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.this.gwQ.getSelectCount())}));
            AppMethodBeat.o(108543);
        }
    };
    private String gxc = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FindMContactInviteUI() {
        AppMethodBeat.i(108551);
        AppMethodBeat.o(108551);
    }

    static /* synthetic */ void l(FindMContactInviteUI findMContactInviteUI) {
        AppMethodBeat.i(108562);
        findMContactInviteUI.aoZ();
        AppMethodBeat.o(108562);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108552);
        super.onCreate(bundle);
        setMMTitle((int) R.string.bue);
        com.tencent.mm.plugin.account.a.a.gkF.BV();
        this.gxc = getIntent().getStringExtra("regsetinfo_ticket");
        this.gwX = getIntent().getIntExtra("login_type", 0);
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        AppMethodBeat.o(108552);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(108553);
        if (i == 4) {
            aoZ();
            AppMethodBeat.o(108553);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(108553);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(108554);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        aqX();
        Ni(1);
        AppMethodBeat.o(108554);
    }

    public void onResume() {
        AppMethodBeat.i(108555);
        super.onResume();
        this.gwQ.notifyDataSetChanged();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_400_QQ")).append(",1").toString());
        } else {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_400_phone,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_400_phone")).append(",1").toString());
        }
        if (this.gwZ) {
            ab.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
            if (b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                aqv();
            } else {
                AppMethodBeat.o(108555);
                return;
            }
        }
        AppMethodBeat.o(108555);
    }

    public void onPause() {
        AppMethodBeat.i(108557);
        super.onPause();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_400_QQ")).append(",2").toString());
            AppMethodBeat.o(108557);
            return;
        }
        stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_400_phone")).append(",2").toString());
        AppMethodBeat.o(108557);
    }

    public void onDestroy() {
        AppMethodBeat.i(108558);
        if (this.fQS != null) {
            g.Rg().b((int) v2helper.EMethodSetSendToNetworkOn, this.fQS);
            this.fQS = null;
        }
        if (this.gwQ != null) {
            i iVar = this.gwQ;
            if (iVar.gvm != null) {
                iVar.gvm.detach();
                iVar.gvm = null;
            }
        }
        ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
        super.onDestroy();
        AppMethodBeat.o(108558);
    }

    public final int getLayoutId() {
        return R.layout.zl;
    }

    public final void initView() {
        AppMethodBeat.i(108559);
        this.emptyTipTv = (TextView) findViewById(R.id.bt4);
        this.emptyTipTv.setText(R.string.d07);
        this.gtT = (ListView) findViewById(R.id.bsq);
        if (this.gsz == 2 || this.gsz != 1) {
            this.gwR = LayoutInflater.from(this).inflate(R.layout.zm, null);
            this.gwS = (TextView) this.gwR.findViewById(R.id.bt7);
            this.gwT = (TextView) this.gwR.findViewById(R.id.bt6);
            this.gwU = (TextView) this.gwR.findViewById(R.id.bt_);
            this.gwW = (Button) this.gwR.findViewById(R.id.bt9);
            this.gwT.setText(getString(R.string.buf));
            this.gwU.setText(getString(R.string.buc));
            this.gwW.setText(getString(R.string.bua, new Object[]{Integer.valueOf(0)}));
            this.gwV = (TextView) this.gwR.findViewById(R.id.bt8);
        } else {
            this.gwR = LayoutInflater.from(this).inflate(R.layout.zn, null);
            this.gwS = (TextView) this.gwR.findViewById(R.id.bt7);
            this.gwT = (TextView) this.gwR.findViewById(R.id.bt6);
            this.gwU = (TextView) this.gwR.findViewById(R.id.bt_);
            this.gwW = (Button) this.gwR.findViewById(R.id.bt9);
            this.gwT.setText(getString(R.string.buc));
            this.gwU.setText(getString(R.string.buc));
            this.gwW.setText(getString(R.string.bub));
        }
        this.gwQ = new i(this, this.gxa, 2);
        this.gwW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108544);
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
                g.RN();
                com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_300_AddAllButton")).append(",3").toString());
                if (FindMContactInviteUI.this.gsz == 2) {
                    FindMContactInviteUI.this.gwQ.dl(true);
                    FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                    FindMContactInviteUI.this.gwW.setVisibility(8);
                    if (FindMContactInviteUI.this.gwV != null) {
                        FindMContactInviteUI.this.gwV.setVisibility(0);
                        AppMethodBeat.o(108544);
                        return;
                    }
                } else if (FindMContactInviteUI.this.gsz == 1) {
                    FindMContactInviteUI.this.gwQ.dl(true);
                    FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                    FindMContactInviteUI.h(FindMContactInviteUI.this);
                    AppMethodBeat.o(108544);
                    return;
                } else {
                    FindMContactInviteUI.this.gwQ.dl(true);
                    FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                    FindMContactInviteUI.this.gwW.setVisibility(8);
                    if (FindMContactInviteUI.this.gwV != null) {
                        FindMContactInviteUI.this.gwV.setVisibility(0);
                    }
                }
                AppMethodBeat.o(108544);
            }
        });
        if (this.gwV != null) {
            this.gwV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(108545);
                    FindMContactInviteUI.this.gwW.setVisibility(0);
                    FindMContactInviteUI.this.gwV.setVisibility(8);
                    FindMContactInviteUI.this.gwQ.dl(false);
                    FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                    AppMethodBeat.o(108545);
                }
            });
            this.gwV.setVisibility(8);
        }
        this.gtT.addHeaderView(this.gwR);
        this.gtT.setAdapter(this.gwQ);
        this.gtT.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        this.gtT.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(108546);
                if (FindMContactInviteUI.this.gwQ != null) {
                    i b = FindMContactInviteUI.this.gwQ;
                    if (b.gvm != null) {
                        b.gvm.onTouchEvent(motionEvent);
                    }
                }
                AppMethodBeat.o(108546);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108547);
                FindMContactInviteUI.h(FindMContactInviteUI.this);
                AppMethodBeat.o(108547);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108548);
                c.a(FindMContactInviteUI.this.gtT);
                AppMethodBeat.o(108548);
            }
        };
        AppMethodBeat.o(108559);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(108560);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(108560);
            return;
        }
        ab.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(108538);
                            FindMContactInviteUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FindMContactInviteUI.this.gwZ = true;
                            FindMContactInviteUI.this.finish();
                            AppMethodBeat.o(108538);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(108539);
                            FindMContactInviteUI.this.gwZ = true;
                            FindMContactInviteUI.this.finish();
                            AppMethodBeat.o(108539);
                        }
                    });
                    break;
                }
                aqv();
                AppMethodBeat.o(108560);
                return;
        }
        AppMethodBeat.o(108560);
    }

    private void aqv() {
        AppMethodBeat.i(108556);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.ehJ = h.b(context, getString(R.string.d09), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        g.RS().a(new al.a() {
            public final boolean acg() {
                AppMethodBeat.i(108540);
                if (FindMContactInviteUI.this.ehJ != null) {
                    FindMContactInviteUI.this.ehJ.dismiss();
                    FindMContactInviteUI.this.ehJ = null;
                }
                FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                AppMethodBeat.o(108540);
                return false;
            }

            public final boolean acf() {
                AppMethodBeat.i(108541);
                try {
                    FindMContactInviteUI.this.gwY = com.tencent.mm.pluginsdk.a.cJ(FindMContactInviteUI.this);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FindMContactInviteUI", e, "", new Object[0]);
                }
                FindMContactInviteUI.this.gwQ.gsD = FindMContactInviteUI.this.gwY;
                FindMContactInviteUI.this.gwQ.r(((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
                AppMethodBeat.o(108541);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(108542);
                String str = super.toString() + "|listMFriendData";
                AppMethodBeat.o(108542);
                return str;
            }
        });
        AppMethodBeat.o(108556);
    }

    static /* synthetic */ void h(FindMContactInviteUI findMContactInviteUI) {
        AppMethodBeat.i(108561);
        findMContactInviteUI.aqX();
        if (findMContactInviteUI.gwQ.getSelectCount() == 0) {
            findMContactInviteUI.aoZ();
            AppMethodBeat.o(108561);
            return;
        }
        h.a((Context) findMContactInviteUI, findMContactInviteUI.getString(R.string.bu_), "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(108550);
                StringBuilder stringBuilder;
                if (FindMContactInviteUI.this.gwX == 1) {
                    stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_500_QQ,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_500_QQ")).append(",3").toString());
                } else {
                    stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_500_phone,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_500_phone")).append(",3").toString());
                }
                g.Rg().a((int) v2helper.EMethodSetSendToNetworkOn, FindMContactInviteUI.this.fQS = new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(108549);
                        if (FindMContactInviteUI.this.ehJ != null) {
                            FindMContactInviteUI.this.ehJ.dismiss();
                            FindMContactInviteUI.this.ehJ = null;
                        }
                        if (FindMContactInviteUI.this.fQS != null) {
                            g.Rg().b((int) v2helper.EMethodSetSendToNetworkOn, FindMContactInviteUI.this.fQS);
                            FindMContactInviteUI.this.fQS = null;
                        }
                        FindMContactInviteUI.l(FindMContactInviteUI.this);
                        AppMethodBeat.o(108549);
                    }
                });
                FindMContactInviteUI findMContactInviteUI = FindMContactInviteUI.this;
                Context context = FindMContactInviteUI.this.mController.ylL;
                FindMContactInviteUI.this.getString(R.string.tz);
                findMContactInviteUI.ehJ = h.b(context, FindMContactInviteUI.this.getString(R.string.bud), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                FindMContactInviteUI.this.gwQ.wc(FindMContactInviteUI.this.gxc);
                AppMethodBeat.o(108550);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(108561);
    }
}
