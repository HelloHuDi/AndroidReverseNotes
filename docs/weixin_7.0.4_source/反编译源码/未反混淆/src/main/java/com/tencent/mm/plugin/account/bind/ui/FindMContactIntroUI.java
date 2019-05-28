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
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
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

public class FindMContactIntroUI extends MMWizardActivity {
    private String cFl;
    private ProgressDialog ehJ = null;
    private String elr = null;
    private f fQS = null;
    private boolean gsC = false;
    private List<String[]> gsD = null;
    private ag gsE;
    private String gsF;
    private Button gsR;
    private TextView gsS;
    private TextView gsT;
    private String gsy = "";
    private int gsz = 2;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.i(13620);
        findMContactIntroUI.aoZ();
        AppMethodBeat.o(13620);
    }

    static /* synthetic */ void f(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.i(13621);
        findMContactIntroUI.api();
        AppMethodBeat.o(13621);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(13610);
        super.onCreate(bundle);
        setMMTitle((int) R.string.buo);
        a.gkF.BV();
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (l.apS() != l.a.SUCC) {
            z = true;
        } else {
            z = false;
        }
        this.gsC = z;
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        ab.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", this.gsy, Integer.valueOf(this.gsz));
        AppMethodBeat.o(13610);
    }

    public void onDestroy() {
        AppMethodBeat.i(13611);
        if (this.fQS != null) {
            g.Rg().b(431, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.o(13611);
    }

    public void onResume() {
        AppMethodBeat.i(13612);
        super.onResume();
        initView();
        StringBuilder stringBuilder;
        if (this.gsC) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_100_QQ")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("R300_100_QQ");
            AppMethodBeat.o(13612);
            return;
        }
        stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_100_phone")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("R300_100_phone");
        AppMethodBeat.o(13612);
    }

    public void onPause() {
        AppMethodBeat.i(13613);
        super.onPause();
        com.tencent.mm.plugin.b.a.wA("RE900_100");
        StringBuilder stringBuilder;
        if (this.gsC) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_100_QQ")).append(",4").toString());
            AppMethodBeat.o(13613);
            return;
        }
        stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_100_phone")).append(",4").toString());
        AppMethodBeat.o(13613);
    }

    public final void initView() {
        AppMethodBeat.i(13614);
        this.gsR = (Button) findViewById(R.id.bta);
        this.gsT = (TextView) findViewById(R.id.btc);
        this.gsS = (TextView) findViewById(R.id.btb);
        if (this.gsy == null || !this.gsy.contains("2")) {
            this.gsS.setText(getString(R.string.bu6));
        } else {
            this.gsS.setText(getString(R.string.bu5));
        }
        this.cFl = (String) g.RP().Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) g.RP().Ry().get(4097, null);
        }
        this.gsR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13596);
                FindMContactIntroUI.a(FindMContactIntroUI.this);
                AppMethodBeat.o(13596);
            }
        });
        this.gsT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13600);
                h.d(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.string.bul), null, FindMContactIntroUI.this.getString(R.string.bum), FindMContactIntroUI.this.getString(R.string.buk), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(13599);
                        FindMContactIntroUI.b(FindMContactIntroUI.this);
                        AppMethodBeat.o(13599);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(13600);
            }
        });
        AppMethodBeat.o(13614);
    }

    private void api() {
        AppMethodBeat.i(13615);
        ab.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
        if (b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            p Rg = g.Rg();
            f anonymousClass9 = new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(13605);
                    if (FindMContactIntroUI.this.ehJ != null) {
                        FindMContactIntroUI.this.ehJ.dismiss();
                        FindMContactIntroUI.this.ehJ = null;
                    }
                    if (FindMContactIntroUI.this.fQS != null) {
                        g.Rg().b(431, FindMContactIntroUI.this.fQS);
                        FindMContactIntroUI.this.fQS = null;
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
                        String str2 = "MicroMsg.FindMContactIntroUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(aqj == null ? 0 : aqj.size());
                        objArr[1] = Integer.valueOf(i3);
                        ab.d(str2, str3, objArr);
                        if (FindMContactIntroUI.this.gsy == null || !FindMContactIntroUI.this.gsy.contains("1") || i4 == 0) {
                            FindMContactIntroUI.b(FindMContactIntroUI.this);
                            AppMethodBeat.o(13605);
                            return;
                        }
                        com.tencent.mm.plugin.b.a.wA("R300_300_phone");
                        Intent intent = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.elr);
                        intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.gsy);
                        intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.gsz);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.J(FindMContactIntroUI.this, intent);
                        AppMethodBeat.o(13605);
                        return;
                    }
                    Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.string.ps, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.o(13605);
                }
            };
            this.fQS = anonymousClass9;
            Rg.a(431, anonymousClass9);
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(context, getString(R.string.rd), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(13606);
                    if (FindMContactIntroUI.this.fQS != null) {
                        g.Rg().b(431, FindMContactIntroUI.this.fQS);
                        FindMContactIntroUI.this.fQS = null;
                    }
                    AppMethodBeat.o(13606);
                }
            });
            g.RS().a(new al.a() {
                public final boolean acg() {
                    AppMethodBeat.i(13607);
                    if (FindMContactIntroUI.this.gsD == null || FindMContactIntroUI.this.gsD.size() == 0) {
                        if (FindMContactIntroUI.this.ehJ != null) {
                            FindMContactIntroUI.this.ehJ.dismiss();
                            FindMContactIntroUI.this.ehJ = null;
                        }
                        FindMContactIntroUI.b(FindMContactIntroUI.this);
                    } else {
                        FindMContactIntroUI.this.gsE = new ag(FindMContactIntroUI.this.elr, FindMContactIntroUI.this.gsD);
                        g.Rg().a(FindMContactIntroUI.this.gsE, 0);
                    }
                    AppMethodBeat.o(13607);
                    return false;
                }

                public final boolean acf() {
                    AppMethodBeat.i(13608);
                    try {
                        FindMContactIntroUI.this.gsD = com.tencent.mm.pluginsdk.a.cJ(FindMContactIntroUI.this);
                        ab.d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (FindMContactIntroUI.this.gsD == null ? 0 : FindMContactIntroUI.this.gsD.size()));
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FindMContactIntroUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.o(13608);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(13609);
                    String str = super.toString() + "|doUpload";
                    AppMethodBeat.o(13609);
                    return str;
                }
            });
            AppMethodBeat.o(13615);
            return;
        }
        AppMethodBeat.o(13615);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13616);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.o(13616);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13616);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(13617);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        aqX();
        Ni(1);
        AppMethodBeat.o(13617);
    }

    public final int getLayoutId() {
        return R.layout.zo;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(13618);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(13618);
            return;
        }
        ab.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13597);
                            dialogInterface.dismiss();
                            FindMContactIntroUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(13597);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13598);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(13598);
                        }
                    });
                    break;
                }
                api();
                AppMethodBeat.o(13618);
                return;
        }
        AppMethodBeat.o(13618);
    }

    static /* synthetic */ void a(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.i(13619);
        StringBuilder stringBuilder;
        if (findMContactIntroUI.gsC) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            g.RN();
            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_200_phone")).append(",1").toString());
            h.a((Context) findMContactIntroUI, (int) R.string.bu8, (int) R.string.tz, (int) R.string.s6, (int) R.string.or, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13601);
                    g.RP().Ry().set(12322, Boolean.TRUE);
                    com.tencent.mm.plugin.b.a.wA("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.elr);
                    intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.gsy);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.gsz);
                    a.gkE.a(FindMContactIntroUI.this, intent);
                    com.tencent.mm.plugin.b.a.wA("R300_300_phone");
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FindMContactIntroUI.this.getClass().getName()).append(",R300_200_phone,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_200_phone")).append(",2").toString());
                    AppMethodBeat.o(13601);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13602);
                    g.RP().Ry().set(12322, Boolean.FALSE);
                    AppMethodBeat.o(13602);
                }
            });
            AppMethodBeat.o(13619);
        } else if (l.apR()) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            g.RN();
            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_200_phone")).append(",1").toString());
            h.a((Context) findMContactIntroUI, (int) R.string.bu8, (int) R.string.tz, (int) R.string.s6, (int) R.string.or, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13603);
                    g.RP().Ry().set(12322, Boolean.TRUE);
                    FindMContactIntroUI.f(FindMContactIntroUI.this);
                    AppMethodBeat.o(13603);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13604);
                    g.RP().Ry().set(12322, Boolean.FALSE);
                    AppMethodBeat.o(13604);
                }
            });
            AppMethodBeat.o(13619);
        } else {
            findMContactIntroUI.api();
            AppMethodBeat.o(13619);
        }
    }
}
