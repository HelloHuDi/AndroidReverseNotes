package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
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
import com.tencent.mm.ui.widget.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI extends MMWizardActivity {
    private int X = 0;
    private int Y = 0;
    private String cFl;
    private ProgressDialog ehJ = null;
    private String elr = null;
    private f fQS = null;
    private String gsA = null;
    private String gsB = null;
    private boolean gsC = false;
    private List<String[]> gsD = null;
    private ag gsE;
    private String gsF;
    private String gsG;
    private String gsH;
    private int gsI = 0;
    private final int gsJ = 200;
    private int gsK = 0;
    private int gsL = 0;
    private int gsM = 0;
    private int gsN = 0;
    private String gsy = "";
    private int gsz = 2;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.i(13590);
        findMContactAlertUI.aoZ();
        AppMethodBeat.o(13590);
    }

    static /* synthetic */ void e(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.i(13591);
        findMContactAlertUI.api();
        AppMethodBeat.o(13591);
    }

    static /* synthetic */ void j(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.i(13595);
        findMContactAlertUI.apg();
        AppMethodBeat.o(13595);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13576);
        super.onCreate(bundle);
        setMMTitle((int) R.string.buo);
        a.gkF.BV();
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.gsA = getIntent().getStringExtra("alert_title");
        this.gsB = getIntent().getStringExtra("alert_message");
        this.gsC = l.apS() != l.a.SUCC;
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        ab.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", this.gsy, Integer.valueOf(this.gsz));
        if (isFinishing()) {
            AppMethodBeat.o(13576);
            return;
        }
        initView();
        apg();
        AppMethodBeat.o(13576);
    }

    public void onDestroy() {
        AppMethodBeat.i(13577);
        ab.d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.fQS != null) {
            g.Rg().b(431, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.o(13577);
    }

    public void onResume() {
        AppMethodBeat.i(13578);
        super.onResume();
        StringBuilder stringBuilder;
        if (this.gsC) {
            com.tencent.mm.plugin.b.a.wz("R300_100_QQ");
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_100_QQ")).append(",1").toString());
            AppMethodBeat.o(13578);
            return;
        }
        com.tencent.mm.plugin.b.a.wz("R300_100_phone");
        stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE300_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE300_100")).append(",1").toString());
        AppMethodBeat.o(13578);
    }

    public void onPause() {
        AppMethodBeat.i(13579);
        super.onPause();
        StringBuilder stringBuilder;
        if (this.gsC) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_100_QQ")).append(",2").toString());
            AppMethodBeat.o(13579);
            return;
        }
        stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE300_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE300_100")).append(",2").toString());
        AppMethodBeat.o(13579);
    }

    public final void initView() {
        AppMethodBeat.i(13580);
        this.gsG = getString(R.string.bu9);
        this.gsH = getString(R.string.bu8);
        if (!bo.isNullOrNil(this.gsA)) {
            this.gsG = this.gsA;
        }
        if (!bo.isNullOrNil(this.gsB)) {
            this.gsH = this.gsB;
        }
        this.cFl = (String) g.RP().Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) g.RP().Ry().get(4097, null);
        }
        AppMethodBeat.o(13580);
    }

    private c a(String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(13581);
        c cVar = new c(this);
        cVar.setTitle((CharSequence) str2);
        cVar.setMessage(str);
        cVar.a((int) R.string.buv, onClickListener);
        cVar.b(R.string.buq, onClickListener2);
        cVar.tJz.setVisibility(0);
        cVar.setCancelable(false);
        cVar.show();
        cVar.getWindow().clearFlags(2);
        addDialog(cVar);
        AppMethodBeat.o(13581);
        return cVar;
    }

    private void apg() {
        AppMethodBeat.i(13582);
        if (this.gsC) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R300_200_phone,");
            g.RN();
            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_200_phone")).append(",1").toString());
            h.a((Context) this, false, getString(R.string.bu8), getString(R.string.tz), getString(R.string.s6), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13563);
                    g.RP().Ry().set(12322, Boolean.TRUE);
                    com.tencent.mm.plugin.b.a.wA("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.elr);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.gsy);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.gsz);
                    a.gkE.a(FindMContactAlertUI.this, intent);
                    com.tencent.mm.plugin.b.a.wA("R300_300_phone");
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_200_phone")).append(",2").toString());
                    AppMethodBeat.o(13563);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13566);
                    g.RP().Ry().set(12322, Boolean.FALSE);
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R300_200_phone")).append(",2").toString());
                    FindMContactAlertUI.d(FindMContactAlertUI.this);
                    AppMethodBeat.o(13566);
                }
            });
            AppMethodBeat.o(13582);
        } else if (l.apR()) {
            a(a(this.gsH, this.gsG, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13567);
                    g.RP().Ry().set(12322, Boolean.TRUE);
                    FindMContactAlertUI.e(FindMContactAlertUI.this);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(13567);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13568);
                    Intent intent = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.elr);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.gsy);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.gsz);
                    MMWizardActivity.J(FindMContactAlertUI.this, intent);
                    AppMethodBeat.o(13568);
                }
            }));
            AppMethodBeat.o(13582);
        } else {
            api();
            AppMethodBeat.o(13582);
        }
    }

    private void a(final c cVar) {
        AppMethodBeat.i(13583);
        cVar.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                int measuredWidth;
                AppMethodBeat.i(13569);
                cVar.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int measuredWidth2 = cVar.getWindow().getDecorView().getMeasuredWidth();
                int measuredHeight = cVar.getWindow().getDecorView().getMeasuredHeight();
                View a = FindMContactAlertUI.a(FindMContactAlertUI.this, (ViewGroup) cVar.getWindow().getDecorView());
                if (a != null) {
                    measuredWidth = a.getMeasuredWidth() * 2;
                } else {
                    measuredWidth = measuredWidth2;
                }
                ab.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                FindMContactAlertUI.a(FindMContactAlertUI.this, measuredWidth, measuredHeight);
                AppMethodBeat.o(13569);
            }
        });
        final View findViewById = findViewById(R.id.btd);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(13570);
                findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int measuredHeight = findViewById.getMeasuredHeight();
                ab.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", Integer.valueOf(findViewById.getMeasuredWidth()), Integer.valueOf(measuredHeight));
                FindMContactAlertUI.b(FindMContactAlertUI.this, r1, measuredHeight);
                AppMethodBeat.o(13570);
            }
        });
        AppMethodBeat.o(13583);
    }

    private View g(ViewGroup viewGroup) {
        AppMethodBeat.i(13584);
        if (this.gsI >= 200) {
            AppMethodBeat.o(13584);
            return null;
        }
        this.gsI++;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                AppMethodBeat.o(13584);
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                childAt = g((ViewGroup) childAt);
                if (childAt != null) {
                    AppMethodBeat.o(13584);
                    return childAt;
                }
            }
        }
        AppMethodBeat.o(13584);
        return null;
    }

    private void aph() {
        AppMethodBeat.i(13585);
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.gsM - (getResources().getDimensionPixelSize(R.dimen.m_) + com.tencent.mm.bz.a.fromDPToPix(this, 48));
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this, 20) + (((height / 2) + (this.gsL / 2)) - (height - this.gsN));
        if (!(dimensionPixelSize == this.X && fromDPToPix == this.Y)) {
            this.X = dimensionPixelSize;
            this.Y = fromDPToPix;
            View findViewById = findViewById(R.id.bte);
            findViewById.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            ab.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth()));
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.anim.a9));
        }
        AppMethodBeat.o(13585);
    }

    private void api() {
        AppMethodBeat.i(13586);
        ab.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
        if (b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            View findViewById = findViewById(R.id.bte);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            p Rg = g.Rg();
            f anonymousClass9 = new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(13571);
                    if (FindMContactAlertUI.this.ehJ != null) {
                        FindMContactAlertUI.this.ehJ.dismiss();
                        FindMContactAlertUI.this.ehJ = null;
                    }
                    if (FindMContactAlertUI.this.fQS != null) {
                        g.Rg().b(431, FindMContactAlertUI.this.fQS);
                        FindMContactAlertUI.this.fQS = null;
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
                        String str2 = "MicroMsg.FindMContactAlertUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(aqj == null ? 0 : aqj.size());
                        objArr[1] = Integer.valueOf(i3);
                        ab.d(str2, str3, objArr);
                        if (FindMContactAlertUI.this.gsy == null || !FindMContactAlertUI.this.gsy.contains("1") || i4 == 0) {
                            FindMContactAlertUI.d(FindMContactAlertUI.this);
                            AppMethodBeat.o(13571);
                            return;
                        }
                        com.tencent.mm.plugin.b.a.wA("R300_300_phone");
                        Intent intent = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.elr);
                        intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.gsy);
                        intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.gsz);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.J(FindMContactAlertUI.this, intent);
                        AppMethodBeat.o(13571);
                        return;
                    }
                    Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(R.string.ps, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    FindMContactAlertUI.d(FindMContactAlertUI.this);
                    AppMethodBeat.o(13571);
                }
            };
            this.fQS = anonymousClass9;
            Rg.a(431, anonymousClass9);
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(context, getString(R.string.rd), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(13572);
                    if (FindMContactAlertUI.this.fQS != null) {
                        g.Rg().b(431, FindMContactAlertUI.this.fQS);
                        FindMContactAlertUI.this.fQS = null;
                        FindMContactAlertUI.j(FindMContactAlertUI.this);
                    }
                    AppMethodBeat.o(13572);
                }
            });
            g.RS().a(new al.a() {
                public final boolean acg() {
                    AppMethodBeat.i(13573);
                    if (FindMContactAlertUI.this.gsD == null || FindMContactAlertUI.this.gsD.size() == 0) {
                        if (FindMContactAlertUI.this.ehJ != null) {
                            FindMContactAlertUI.this.ehJ.dismiss();
                            FindMContactAlertUI.this.ehJ = null;
                        }
                        FindMContactAlertUI.d(FindMContactAlertUI.this);
                    } else {
                        FindMContactAlertUI.this.gsE = new ag(FindMContactAlertUI.this.elr, FindMContactAlertUI.this.gsD);
                        g.Rg().a(FindMContactAlertUI.this.gsE, 0);
                    }
                    AppMethodBeat.o(13573);
                    return false;
                }

                public final boolean acf() {
                    AppMethodBeat.i(13574);
                    try {
                        FindMContactAlertUI.this.gsD = com.tencent.mm.pluginsdk.a.cJ(FindMContactAlertUI.this);
                        ab.d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (FindMContactAlertUI.this.gsD == null ? 0 : FindMContactAlertUI.this.gsD.size()));
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FindMContactAlertUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.o(13574);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(13575);
                    String str = super.toString() + "|doUpload";
                    AppMethodBeat.o(13575);
                    return str;
                }
            });
            ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
            ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
            com.tencent.mm.plugin.report.service.h.pYm.e(11438, Integer.valueOf(1));
            ab.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(1));
            AppMethodBeat.o(13586);
            return;
        }
        AppMethodBeat.o(13586);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13587);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.o(13587);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13587);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(13588);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        aqX();
        Ni(1);
        AppMethodBeat.o(13588);
    }

    public final int getLayoutId() {
        return R.layout.zq;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(13589);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(13589);
            return;
        }
        ab.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13564);
                            dialogInterface.dismiss();
                            FindMContactAlertUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(13564);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13565);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(13565);
                        }
                    });
                    break;
                }
                api();
                AppMethodBeat.o(13589);
                return;
        }
        AppMethodBeat.o(13589);
    }

    static /* synthetic */ void a(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        AppMethodBeat.i(13593);
        findMContactAlertUI.gsK = i;
        findMContactAlertUI.gsL = i2;
        if (findMContactAlertUI.gsM > 0 && findMContactAlertUI.gsN > 0) {
            findMContactAlertUI.aph();
        }
        AppMethodBeat.o(13593);
    }

    static /* synthetic */ void b(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        AppMethodBeat.i(13594);
        findMContactAlertUI.gsM = i;
        findMContactAlertUI.gsN = i2;
        if (findMContactAlertUI.gsK > 0 && findMContactAlertUI.gsL > 0) {
            findMContactAlertUI.aph();
        }
        AppMethodBeat.o(13594);
    }
}
