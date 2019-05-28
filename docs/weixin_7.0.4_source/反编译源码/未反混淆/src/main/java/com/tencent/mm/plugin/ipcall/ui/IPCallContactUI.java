package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.tools.o;

public class IPCallContactUI extends MMActivity {
    private o elS = new o((byte) 0);
    private ak fbD = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22072);
            if (message.what == 1) {
                if (IPCallContactUI.this.nBv != null) {
                    IPCallContactUI.this.nBv.dismiss();
                }
                IPCallContactUI.this.nBx.setVisibility(0);
                IPCallContactUI.this.nBw;
                c.nzw = b.bHW();
                IPCallContactUI.this.nBw.KC();
                IPCallContactUI.this.nBw.notifyDataSetChanged();
                IPCallContactUI.this.nBg.invalidateViews();
                IPCallContactUI.this.nBz.setAddressCount(IPCallContactUI.this.nBw.getCount());
                a.bGG().bGH();
                AppMethodBeat.o(22072);
                return;
            }
            if (message.what == 2) {
                if (IPCallContactUI.this.nBw.getCount() == 0) {
                    IPCallContactUI.this.nBB.setVisibility(0);
                } else {
                    IPCallContactUI.this.nBB.setVisibility(8);
                }
                if (IPCallContactUI.this.nBw.getCount() != 0 && IPCallContactUI.this.nBG) {
                    IPCallContactUI.this.nBw.notifyDataSetChanged();
                }
            }
            AppMethodBeat.o(22072);
        }
    };
    private String gtX;
    private VerticalScrollBar nBA;
    private LinearLayout nBB;
    private int nBC = -1;
    private int nBD = -1;
    private com.tencent.mm.plugin.ipcall.a.a.a nBE = new com.tencent.mm.plugin.ipcall.a.a.a() {
        public final void aLj() {
            AppMethodBeat.i(22081);
            IPCallContactUI.this.fbD.sendEmptyMessage(1);
            AppMethodBeat.o(22081);
        }
    };
    private Runnable nBF = new Runnable() {
        public final void run() {
            AppMethodBeat.i(22084);
            if (!(IPCallContactUI.this.nBw == null || IPCallContactUI.this.nBg == null || IPCallContactUI.this.nBw.jLC)) {
                IPCallContactUI.this.nBw.vM(IPCallContactUI.this.gtX);
                IPCallContactUI.this.fbD.sendEmptyMessage(2);
                IPCallContactUI.this.nBg.invalidateViews();
            }
            AppMethodBeat.o(22084);
        }
    };
    private boolean nBG = true;
    private ListView nBg;
    private Runnable nBn = new Runnable() {
        public final void run() {
            AppMethodBeat.i(22082);
            com.tencent.mm.plugin.ipcall.a.a.bHb().a(IPCallContactUI.this.nBE, false);
            AppMethodBeat.o(22082);
        }
    };
    private ProgressDialog nBv = null;
    private c nBw;
    private RelativeLayout nBx;
    private LinearLayout nBy;
    private IPCallAddressCountView nBz = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallContactUI() {
        AppMethodBeat.i(22088);
        AppMethodBeat.o(22088);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22089);
        super.onCreate(bundle);
        setMMTitle((int) R.string.cg6);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22071);
                IPCallContactUI.this.finish();
                AppMethodBeat.o(22071);
                return true;
            }
        });
        ab.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            this.nBx = (RelativeLayout) findViewById(R.id.bz0);
            this.nBy = (LinearLayout) findViewById(R.id.cjd);
            this.nBg = (ListView) findViewById(R.id.cje);
            this.nBA = (VerticalScrollBar) findViewById(R.id.n6);
            this.nBB = (LinearLayout) findViewById(R.id.cjf);
            this.elS.zHa = new o.b() {
                public final void app() {
                    AppMethodBeat.i(22075);
                    ab.d("MicroMsg.IPCallContactUI", "onEnterSearch");
                    h.pYm.e(12767, Integer.valueOf(1));
                    IPCallContactUI.this.nBy.setVisibility(0);
                    IPCallContactUI.this.nBg.setVisibility(8);
                    IPCallContactUI.this.nBz.setVisibility(8);
                    IPCallContactUI.this.iu(false);
                    AppMethodBeat.o(22075);
                }

                public final void apo() {
                    AppMethodBeat.i(22076);
                    ab.d("MicroMsg.IPCallContactUI", "onQuitSearch");
                    IPCallContactUI.this.vM("");
                    IPCallContactUI.this.iu(true);
                    IPCallContactUI.this.nBy.setVisibility(8);
                    IPCallContactUI.this.nBg.setVisibility(0);
                    IPCallContactUI.this.nBz.setVisibility(0);
                    AppMethodBeat.o(22076);
                }

                public final void vO(String str) {
                    AppMethodBeat.i(22077);
                    ab.d("MicroMsg.IPCallContactUI", "onSearchChange");
                    IPCallContactUI.this.vM(str);
                    if (!bo.isNullOrNil(str)) {
                        IPCallContactUI.this.nBy.setVisibility(8);
                        IPCallContactUI.this.nBg.setVisibility(0);
                        IPCallContactUI.this.nBz.setVisibility(8);
                    }
                    AppMethodBeat.o(22077);
                }

                public final boolean vN(String str) {
                    AppMethodBeat.i(22078);
                    ab.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
                    AppMethodBeat.o(22078);
                    return false;
                }

                public final void apq() {
                    AppMethodBeat.i(22079);
                    IPCallContactUI.this.nBy.setVisibility(0);
                    IPCallContactUI.this.nBg.setVisibility(8);
                    IPCallContactUI.this.nBz.setVisibility(8);
                    AppMethodBeat.o(22079);
                }

                public final void apr() {
                }
            };
            this.elS.zHf = R.string.te;
            a(this.elS);
            this.nBw = new c(this.mController.ylL);
            c.nzw = b.bHW();
            this.nBz = new IPCallAddressCountView(this.mController.ylL, this.nBw.bIe());
            this.nBg.addFooterView(this.nBz, null, false);
            this.nBg.setAdapter(this.nBw);
            this.nBg.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(22080);
                    if (IPCallContactUI.this.nBw.wK(i)) {
                        AppMethodBeat.o(22080);
                        return;
                    }
                    c xn = IPCallContactUI.this.nBw.xn(i);
                    if (xn != null) {
                        if (!IPCallContactUI.this.nBG) {
                            h.pYm.e(12767, Integer.valueOf(2));
                        }
                        Intent intent = new Intent(IPCallContactUI.this.mController.ylL, IPCallUserProfileUI.class);
                        intent.putExtra("IPCallProfileUI_contactid", xn.field_contactId);
                        intent.putExtra("IPCallProfileUI_systemUsername", xn.field_systemAddressBookUsername);
                        intent.putExtra("IPCallProfileUI_wechatUsername", xn.field_wechatUsername);
                        IPCallContactUI.this.mController.ylL.startActivity(intent);
                    }
                    AppMethodBeat.o(22080);
                }
            });
            this.nBA.setVisibility(0);
            this.nBg.setOnScrollListener(new OnScrollListener() {
                private int lqq = 0;

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    AppMethodBeat.i(22085);
                    this.lqq = i;
                    IPCallContactUI.this.aqX();
                    AppMethodBeat.o(22085);
                }

                @TargetApi(11)
                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AppMethodBeat.i(22086);
                    if (IPCallContactUI.this.nBC == -1) {
                        IPCallContactUI.this.nBC = i;
                        AppMethodBeat.o(22086);
                        return;
                    }
                    if (IPCallContactUI.this.nBD == -1) {
                        IPCallContactUI.this.nBD = i;
                    }
                    AppMethodBeat.o(22086);
                }
            });
            this.nBA.setOnScrollBarTouchListener(new VerticalScrollBar.a() {
                public final void kp(String str) {
                    AppMethodBeat.i(22087);
                    if ("↑".equals(str)) {
                        IPCallContactUI.this.nBg.setSelection(0);
                        AppMethodBeat.o(22087);
                        return;
                    }
                    int intValue;
                    c d = IPCallContactUI.this.nBw;
                    if (d.emK.containsKey(str)) {
                        intValue = ((Integer) d.emK.get(str)).intValue();
                    } else {
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        IPCallContactUI.this.nBg.setSelection(intValue);
                    }
                    AppMethodBeat.o(22087);
                }
            });
            if (this.nBw.bIe() <= 0) {
                this.nBx.setVisibility(8);
                Context context = this.mController.ylL;
                this.mController.ylL.getString(R.string.tz);
                this.nBv = com.tencent.mm.ui.base.h.b(context, this.mController.ylL.getString(R.string.cgq), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(22083);
                        IPCallContactUI.this.finish();
                        AppMethodBeat.o(22083);
                    }
                });
                d.post(this.nBn, "IPCall_LoadSystemAddressBook");
                AppMethodBeat.o(22089);
                return;
            }
            a.bGG().bGH();
        }
        AppMethodBeat.o(22089);
    }

    public final void vM(String str) {
        AppMethodBeat.i(22090);
        this.gtX = str;
        this.fbD.removeCallbacks(this.nBF);
        this.fbD.postDelayed(this.nBF, 200);
        AppMethodBeat.o(22090);
    }

    public final void iu(boolean z) {
        AppMethodBeat.i(22091);
        this.nBG = z;
        if (this.nBG) {
            this.nBw.notifyDataSetChanged();
        }
        AppMethodBeat.o(22091);
    }

    public final int getLayoutId() {
        return R.layout.a8i;
    }

    public void onDestroy() {
        AppMethodBeat.i(22092);
        super.onDestroy();
        com.tencent.mm.plugin.ipcall.a.a bHb = com.tencent.mm.plugin.ipcall.a.a.bHb();
        com.tencent.mm.plugin.ipcall.a.a.a aVar = this.nBE;
        if (bHb.nvk.contains(aVar)) {
            bHb.nvk.remove(aVar);
        }
        this.fbD.removeMessages(1);
        AppMethodBeat.o(22092);
    }

    public void onResume() {
        AppMethodBeat.i(22093);
        super.onResume();
        supportInvalidateOptionsMenu();
        AppMethodBeat.o(22093);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(22094);
        ab.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(22094);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.i(22095);
        super.onBackPressed();
        AppMethodBeat.o(22095);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(22096);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(22096);
            return;
        }
        ab.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22073);
                            dialogInterface.dismiss();
                            IPCallContactUI.this.finish();
                            IPCallContactUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(22073);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22074);
                            dialogInterface.dismiss();
                            IPCallContactUI.this.finish();
                            AppMethodBeat.o(22074);
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(22096);
    }
}
