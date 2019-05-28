package com.tencent.p177mm.plugin.account.bind.p271ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.account.friend.p272a.C32957ag;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.friend.p273ui.FindMContactAddUI;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.aym;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI */
public class FindMContactAlertUI extends MMWizardActivity {
    /* renamed from: X */
    private int f17173X = 0;
    /* renamed from: Y */
    private int f17174Y = 0;
    private String cFl;
    private ProgressDialog ehJ = null;
    private String elr = null;
    private C1202f fQS = null;
    private String gsA = null;
    private String gsB = null;
    private boolean gsC = false;
    private List<String[]> gsD = null;
    private C32957ag gsE;
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

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$4 */
    class C98594 implements OnClickListener {
        C98594() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13566);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_200_phone")).append(",2").toString());
            FindMContactAlertUI.m74707d(FindMContactAlertUI.this);
            AppMethodBeat.m2505o(13566);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$10 */
    class C1880610 implements OnCancelListener {
        C1880610() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13572);
            if (FindMContactAlertUI.this.fQS != null) {
                C1720g.m3540Rg().mo14546b(431, FindMContactAlertUI.this.fQS);
                FindMContactAlertUI.this.fQS = null;
                FindMContactAlertUI.m74714j(FindMContactAlertUI.this);
            }
            AppMethodBeat.m2505o(13572);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$5 */
    class C188075 implements OnClickListener {
        C188075() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13567);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
            FindMContactAlertUI.m74708e(FindMContactAlertUI.this);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(13567);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$3 */
    class C265653 implements OnClickListener {
        C265653() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13565);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(13565);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$6 */
    class C265666 implements OnClickListener {
        C265666() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13568);
            Intent intent = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
            intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.elr);
            intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.gsy);
            intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.gsz);
            MMWizardActivity.m23791J(FindMContactAlertUI.this, intent);
            AppMethodBeat.m2505o(13568);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$11 */
    class C4226511 implements C5002a {
        C4226511() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(13573);
            if (FindMContactAlertUI.this.gsD == null || FindMContactAlertUI.this.gsD.size() == 0) {
                if (FindMContactAlertUI.this.ehJ != null) {
                    FindMContactAlertUI.this.ehJ.dismiss();
                    FindMContactAlertUI.this.ehJ = null;
                }
                FindMContactAlertUI.m74707d(FindMContactAlertUI.this);
            } else {
                FindMContactAlertUI.this.gsE = new C32957ag(FindMContactAlertUI.this.elr, FindMContactAlertUI.this.gsD);
                C1720g.m3540Rg().mo14541a(FindMContactAlertUI.this.gsE, 0);
            }
            AppMethodBeat.m2505o(13573);
            return false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(13574);
            try {
                FindMContactAlertUI.this.gsD = C46482a.m87692cJ(FindMContactAlertUI.this);
                C4990ab.m7410d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (FindMContactAlertUI.this.gsD == null ? 0 : FindMContactAlertUI.this.gsD.size()));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FindMContactAlertUI", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(13574);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(13575);
            String str = super.toString() + "|doUpload";
            AppMethodBeat.m2505o(13575);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$2 */
    class C422662 implements OnClickListener {
        C422662() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13564);
            dialogInterface.dismiss();
            FindMContactAlertUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(13564);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$9 */
    class C422699 implements C1202f {
        C422699() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(13571);
            if (FindMContactAlertUI.this.ehJ != null) {
                FindMContactAlertUI.this.ehJ.dismiss();
                FindMContactAlertUI.this.ehJ = null;
            }
            if (FindMContactAlertUI.this.fQS != null) {
                C1720g.m3540Rg().mo14546b(431, FindMContactAlertUI.this.fQS);
                FindMContactAlertUI.this.fQS = null;
            }
            if (i == 0 && i2 == 0) {
                int i3;
                LinkedList aqj = ((C32957ag) c1207m).aqj();
                ((C7599a) C1720g.m3530M(C7599a.class)).setFriendData(aqj);
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
                C4990ab.m7411d(str2, str3, objArr);
                if (FindMContactAlertUI.this.gsy == null || !FindMContactAlertUI.this.gsy.contains("1") || i4 == 0) {
                    FindMContactAlertUI.m74707d(FindMContactAlertUI.this);
                    AppMethodBeat.m2505o(13571);
                    return;
                }
                C42756a.m75796wA("R300_300_phone");
                Intent intent = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
                intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.elr);
                intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.gsy);
                intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.gsz);
                intent.putExtra("login_type", 0);
                MMWizardActivity.m23791J(FindMContactAlertUI.this, intent);
                AppMethodBeat.m2505o(13571);
                return;
            }
            Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(C25738R.string.f9111ps, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            FindMContactAlertUI.m74707d(FindMContactAlertUI.this);
            AppMethodBeat.m2505o(13571);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI$1 */
    class C422701 implements OnClickListener {
        C422701() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13563);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
            C42756a.m75796wA("R200_100");
            Intent intent = new Intent();
            intent.putExtra("mobile_input_purpose", 4);
            intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.elr);
            intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.gsy);
            intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.gsz);
            C24679a.gkE.mo38901a(FindMContactAlertUI.this, intent);
            C42756a.m75796wA("R300_300_phone");
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_200_phone")).append(",2").toString());
            AppMethodBeat.m2505o(13563);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: d */
    static /* synthetic */ void m74707d(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.m2504i(13590);
        findMContactAlertUI.aoZ();
        AppMethodBeat.m2505o(13590);
    }

    /* renamed from: e */
    static /* synthetic */ void m74708e(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.m2504i(13591);
        findMContactAlertUI.api();
        AppMethodBeat.m2505o(13591);
    }

    /* renamed from: j */
    static /* synthetic */ void m74714j(FindMContactAlertUI findMContactAlertUI) {
        AppMethodBeat.m2504i(13595);
        findMContactAlertUI.apg();
        AppMethodBeat.m2505o(13595);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13576);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.buo);
        C24679a.gkF.mo38846BV();
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.gsA = getIntent().getStringExtra("alert_title");
        this.gsB = getIntent().getStringExtra("alert_message");
        this.gsC = C38033l.apS() != C38034a.SUCC;
        this.gsF = C42756a.m75794FP();
        C4990ab.m7411d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", this.gsy, Integer.valueOf(this.gsz));
        if (isFinishing()) {
            AppMethodBeat.m2505o(13576);
            return;
        }
        initView();
        apg();
        AppMethodBeat.m2505o(13576);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13577);
        C4990ab.m7410d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.fQS != null) {
            C1720g.m3540Rg().mo14546b(431, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(13577);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13578);
        super.onResume();
        StringBuilder stringBuilder;
        if (this.gsC) {
            C42756a.m75798wz("R300_100_QQ");
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R300_100_QQ")).append(",1").toString());
            AppMethodBeat.m2505o(13578);
            return;
        }
        C42756a.m75798wz("R300_100_phone");
        stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE300_100,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("RE300_100")).append(",1").toString());
        AppMethodBeat.m2505o(13578);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13579);
        super.onPause();
        StringBuilder stringBuilder;
        if (this.gsC) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_100_QQ")).append(",2").toString());
            AppMethodBeat.m2505o(13579);
            return;
        }
        stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE300_100,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("RE300_100")).append(",2").toString());
        AppMethodBeat.m2505o(13579);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13580);
        this.gsG = getString(C25738R.string.bu9);
        this.gsH = getString(C25738R.string.bu8);
        if (!C5046bo.isNullOrNil(this.gsA)) {
            this.gsG = this.gsA;
        }
        if (!C5046bo.isNullOrNil(this.gsB)) {
            this.gsH = this.gsB;
        }
        this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
        }
        AppMethodBeat.m2505o(13580);
    }

    /* renamed from: a */
    private C5653c m74699a(String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(13581);
        C5653c c5653c = new C5653c(this);
        c5653c.setTitle((CharSequence) str2);
        c5653c.setMessage(str);
        c5653c.mo11487a((int) C25738R.string.buv, onClickListener);
        c5653c.mo11490b(C25738R.string.buq, onClickListener2);
        c5653c.tJz.setVisibility(0);
        c5653c.setCancelable(false);
        c5653c.show();
        c5653c.getWindow().clearFlags(2);
        addDialog(c5653c);
        AppMethodBeat.m2505o(13581);
        return c5653c;
    }

    private void apg() {
        AppMethodBeat.m2504i(13582);
        if (this.gsC) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_200_phone,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_200_phone")).append(",1").toString());
            C30379h.m48453a((Context) this, false, getString(C25738R.string.bu8), getString(C25738R.string.f9238tz), getString(C25738R.string.f9187s6), getString(C25738R.string.f9076or), new C422701(), new C98594());
            AppMethodBeat.m2505o(13582);
        } else if (C38033l.apR()) {
            m74703a(m74699a(this.gsH, this.gsG, new C188075(), new C265666()));
            AppMethodBeat.m2505o(13582);
        } else {
            api();
            AppMethodBeat.m2505o(13582);
        }
    }

    /* renamed from: a */
    private void m74703a(final C5653c c5653c) {
        AppMethodBeat.m2504i(13583);
        c5653c.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                int measuredWidth;
                AppMethodBeat.m2504i(13569);
                c5653c.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int measuredWidth2 = c5653c.getWindow().getDecorView().getMeasuredWidth();
                int measuredHeight = c5653c.getWindow().getDecorView().getMeasuredHeight();
                View a = FindMContactAlertUI.m74697a(FindMContactAlertUI.this, (ViewGroup) c5653c.getWindow().getDecorView());
                if (a != null) {
                    measuredWidth = a.getMeasuredWidth() * 2;
                } else {
                    measuredWidth = measuredWidth2;
                }
                C4990ab.m7411d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                FindMContactAlertUI.m74702a(FindMContactAlertUI.this, measuredWidth, measuredHeight);
                AppMethodBeat.m2505o(13569);
            }
        });
        final View findViewById = findViewById(2131824036);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.m2504i(13570);
                findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int measuredHeight = findViewById.getMeasuredHeight();
                C4990ab.m7411d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", Integer.valueOf(findViewById.getMeasuredWidth()), Integer.valueOf(measuredHeight));
                FindMContactAlertUI.m74705b(FindMContactAlertUI.this, r1, measuredHeight);
                AppMethodBeat.m2505o(13570);
            }
        });
        AppMethodBeat.m2505o(13583);
    }

    /* renamed from: g */
    private View m74711g(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(13584);
        if (this.gsI >= 200) {
            AppMethodBeat.m2505o(13584);
            return null;
        }
        this.gsI++;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                AppMethodBeat.m2505o(13584);
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                childAt = m74711g((ViewGroup) childAt);
                if (childAt != null) {
                    AppMethodBeat.m2505o(13584);
                    return childAt;
                }
            }
        }
        AppMethodBeat.m2505o(13584);
        return null;
    }

    private void aph() {
        AppMethodBeat.m2504i(13585);
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.gsM - (getResources().getDimensionPixelSize(C25738R.dimen.f9984m_) + C1338a.fromDPToPix(this, 48));
        int fromDPToPix = C1338a.fromDPToPix(this, 20) + (((height / 2) + (this.gsL / 2)) - (height - this.gsN));
        if (!(dimensionPixelSize == this.f17173X && fromDPToPix == this.f17174Y)) {
            this.f17173X = dimensionPixelSize;
            this.f17174Y = fromDPToPix;
            View findViewById = findViewById(2131824037);
            findViewById.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            C4990ab.m7411d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth()));
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8304a9));
        }
        AppMethodBeat.m2505o(13585);
    }

    private void api() {
        AppMethodBeat.m2504i(13586);
        C4990ab.m7417i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
        if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            View findViewById = findViewById(2131824037);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            C6300p Rg = C1720g.m3540Rg();
            C1202f c422699 = new C422699();
            this.fQS = c422699;
            Rg.mo14539a(431, c422699);
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9160rd), true, new C1880610());
            C1720g.m3539RS().mo10300a(new C4226511());
            ((C7599a) C1720g.m3530M(C7599a.class)).syncUploadMContactStatus(true, false);
            ((C7599a) C1720g.m3530M(C7599a.class)).syncAddrBookAndUpload();
            C7060h.pYm.mo8381e(11438, Integer.valueOf(1));
            C4990ab.m7417i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(1));
            AppMethodBeat.m2505o(13586);
            return;
        }
        AppMethodBeat.m2505o(13586);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13587);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.m2505o(13587);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13587);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(13588);
        C42756a.m75796wA(this.gsF);
        aqX();
        mo27541Ni(1);
        AppMethodBeat.m2505o(13588);
    }

    public final int getLayoutId() {
        return 2130969557;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(13589);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(13589);
            return;
        }
        C4990ab.m7417i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C422662(), new C265653());
                    break;
                }
                api();
                AppMethodBeat.m2505o(13589);
                return;
        }
        AppMethodBeat.m2505o(13589);
    }

    /* renamed from: a */
    static /* synthetic */ void m74702a(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        AppMethodBeat.m2504i(13593);
        findMContactAlertUI.gsK = i;
        findMContactAlertUI.gsL = i2;
        if (findMContactAlertUI.gsM > 0 && findMContactAlertUI.gsN > 0) {
            findMContactAlertUI.aph();
        }
        AppMethodBeat.m2505o(13593);
    }

    /* renamed from: b */
    static /* synthetic */ void m74705b(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        AppMethodBeat.m2504i(13594);
        findMContactAlertUI.gsM = i;
        findMContactAlertUI.gsN = i2;
        if (findMContactAlertUI.gsK > 0 && findMContactAlertUI.gsL > 0) {
            findMContactAlertUI.aph();
        }
        AppMethodBeat.m2505o(13594);
    }
}
