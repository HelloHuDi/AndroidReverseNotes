package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String cFl;
    private ProgressDialog ehJ = null;
    private String elr = null;
    private f fQS = null;
    private List<String[]> gsD = null;
    private ag gsE;
    private Button gsW;
    private TextView gsX;
    private String gsy = "";
    private int gsz = 2;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        AppMethodBeat.i(13640);
        findMContactLearmMoreUI.api();
        AppMethodBeat.o(13640);
    }

    static /* synthetic */ void b(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        AppMethodBeat.i(13641);
        findMContactLearmMoreUI.aoZ();
        AppMethodBeat.o(13641);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13631);
        super.onCreate(bundle);
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        initView();
        AppMethodBeat.o(13631);
    }

    public void onDestroy() {
        AppMethodBeat.i(13632);
        if (this.fQS != null) {
            g.Rg().b(431, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.o(13632);
    }

    public void onResume() {
        AppMethodBeat.i(13633);
        super.onResume();
        a.wz("R300_100_phone");
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE300_600,");
        g.RN();
        a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE300_600")).append(",1").toString());
        AppMethodBeat.o(13633);
    }

    public void onPause() {
        AppMethodBeat.i(13634);
        super.onPause();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE300_600,");
        g.RN();
        a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE300_600")).append(",2").toString());
        AppMethodBeat.o(13634);
    }

    public final void initView() {
        AppMethodBeat.i(13635);
        setMMTitle((int) R.string.bux);
        this.gsW = (Button) findViewById(R.id.b7o);
        this.gsX = (TextView) findViewById(R.id.axh);
        this.gsW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13622);
                g.RP().Ry().set(12322, Boolean.TRUE);
                ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
                FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this);
                AppMethodBeat.o(13622);
            }
        });
        this.gsX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13623);
                g.RP().Ry().set(12322, Boolean.FALSE);
                ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
                FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                AppMethodBeat.o(13623);
            }
        });
        g.RP().Ry().set(12323, Boolean.TRUE);
        this.cFl = (String) g.RP().Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) g.RP().Ry().get(4097, null);
        }
        AppMethodBeat.o(13635);
    }

    private void api() {
        AppMethodBeat.i(13636);
        ab.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
        if (b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            p Rg = g.Rg();
            f anonymousClass3 = new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(13624);
                    if (FindMContactLearmMoreUI.this.ehJ != null) {
                        FindMContactLearmMoreUI.this.ehJ.dismiss();
                        FindMContactLearmMoreUI.this.ehJ = null;
                    }
                    if (FindMContactLearmMoreUI.this.fQS != null) {
                        g.Rg().b(431, FindMContactLearmMoreUI.this.fQS);
                        FindMContactLearmMoreUI.this.fQS = null;
                    }
                    if (i == 0 && i2 == 0) {
                        int i3;
                        LinkedList aqj = ((ag) mVar).aqj();
                        ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(aqj);
                        int i4;
                        if (aqj == null || aqj.size() <= 0) {
                            i4 = 0;
                            i3 = 0;
                        } else {
                            Iterator it = aqj.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                aym aym = (aym) it.next();
                                if (aym != null) {
                                    if (aym.jBT == 1) {
                                        i4 = i3 + 1;
                                    } else {
                                        i4 = i3;
                                    }
                                    i3 = i4;
                                }
                            }
                            i4 = i3 > 0 ? 1 : 0;
                        }
                        String str2 = "MicroMsg.FindMContactLearmMoreUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(aqj == null ? 0 : aqj.size());
                        objArr[1] = Integer.valueOf(i3);
                        ab.d(str2, str3, objArr);
                        if (FindMContactLearmMoreUI.this.gsy == null || !FindMContactLearmMoreUI.this.gsy.contains("1") || i4 == 0) {
                            FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                            AppMethodBeat.o(13624);
                            return;
                        }
                        a.wA("R300_300_phone");
                        Intent intent = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.this.elr);
                        intent.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.this.gsy);
                        intent.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.this.gsz);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.J(FindMContactLearmMoreUI.this, intent);
                        AppMethodBeat.o(13624);
                        return;
                    }
                    Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(R.string.ps, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                    AppMethodBeat.o(13624);
                }
            };
            this.fQS = anonymousClass3;
            Rg.a(431, anonymousClass3);
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(context, getString(R.string.rd), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(13625);
                    if (FindMContactLearmMoreUI.this.fQS != null) {
                        g.Rg().b(431, FindMContactLearmMoreUI.this.fQS);
                        FindMContactLearmMoreUI.this.fQS = null;
                    }
                    AppMethodBeat.o(13625);
                }
            });
            g.RS().a(new al.a() {
                public final boolean acg() {
                    AppMethodBeat.i(13626);
                    if (FindMContactLearmMoreUI.this.gsD == null || FindMContactLearmMoreUI.this.gsD.size() == 0) {
                        if (FindMContactLearmMoreUI.this.ehJ != null) {
                            FindMContactLearmMoreUI.this.ehJ.dismiss();
                            FindMContactLearmMoreUI.this.ehJ = null;
                        }
                        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
                    } else {
                        FindMContactLearmMoreUI.this.gsE = new ag(FindMContactLearmMoreUI.this.elr, FindMContactLearmMoreUI.this.gsD);
                        g.Rg().a(FindMContactLearmMoreUI.this.gsE, 0);
                    }
                    AppMethodBeat.o(13626);
                    return false;
                }

                public final boolean acf() {
                    AppMethodBeat.i(13627);
                    try {
                        FindMContactLearmMoreUI.this.gsD = com.tencent.mm.pluginsdk.a.cJ(FindMContactLearmMoreUI.this);
                        ab.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (FindMContactLearmMoreUI.this.gsD == null ? 0 : FindMContactLearmMoreUI.this.gsD.size()));
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.o(13627);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(13628);
                    String str = super.toString() + "|doUpload";
                    AppMethodBeat.o(13628);
                    return str;
                }
            });
            ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
            ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
            AppMethodBeat.o(13636);
            return;
        }
        AppMethodBeat.o(13636);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13637);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.o(13637);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13637);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(13638);
        aqX();
        Ni(1);
        AppMethodBeat.o(13638);
    }

    public final int getLayoutId() {
        return R.layout.zp;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(13639);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(13639);
            return;
        }
        ab.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13629);
                            dialogInterface.dismiss();
                            FindMContactLearmMoreUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(13629);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13630);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(13630);
                        }
                    });
                    break;
                }
                api();
                AppMethodBeat.o(13639);
                return;
        }
        AppMethodBeat.o(13639);
    }
}
