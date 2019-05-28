package com.tencent.p177mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42759b;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C45736c;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19936a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.plugin.backup.p345d.C33697c;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.backup.backupui.a */
public final class C33672a extends C14933b {
    private static String TAG = "MicroMsg.BackupChatBanner";
    private TextView gne = null;
    private View jyC = null;
    private View jyD;
    private int jyE = 100;
    private int jyF = 100;
    private C19936a jyG = new C33673a(this);

    /* renamed from: com.tencent.mm.plugin.backup.backupui.a$1 */
    class C274511 implements OnClickListener {
        C274511() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17710);
            C4990ab.m7417i(C33672a.TAG, "backupbanner onclick, backupMode[%d]", Integer.valueOf(C38634d.aSx()));
            switch (C38634d.aSx()) {
                case 1:
                    C4990ab.m7417i(C33672a.TAG, "backupbanner onclick, backupPcState[%d]", Integer.valueOf(C42759b.aTD().aSu().jqW));
                    switch (C42759b.aTD().aSu().jqW) {
                        case -4:
                        case 4:
                        case 5:
                        case 12:
                        case 14:
                        case 15:
                        case 22:
                        case 23:
                        case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                            C4990ab.m7417i(C33672a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", Integer.valueOf(C42759b.aTD().aSu().jqW));
                            C33672a.m54972a(C33672a.this, false);
                            AppMethodBeat.m2505o(17710);
                            return;
                        case 24:
                        case 25:
                            C4990ab.m7417i(C33672a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", Integer.valueOf(C42759b.aTD().aSu().jqW));
                            C33672a.m54972a(C33672a.this, true);
                            AppMethodBeat.m2505o(17710);
                            return;
                        default:
                            C4990ab.m7417i(C33672a.TAG, "click backup banner, BackupPcState[%d]", Integer.valueOf(C42759b.aTD().aSu().jqW));
                            AppMethodBeat.m2505o(17710);
                            return;
                    }
                case 22:
                    C4990ab.m7417i(C33672a.TAG, "backupbanner onclick, backupMoveState[%d]", Integer.valueOf(C41258b.aSZ().aSu().jqW));
                    switch (C41258b.aSZ().aSu().jqW) {
                        case -4:
                        case 4:
                        case 5:
                        case 12:
                        case 22:
                        case 23:
                        case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        case 52:
                            C4990ab.m7417i(C33672a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", Integer.valueOf(r0));
                            C33672a.m54974b(C33672a.this, false);
                            AppMethodBeat.m2505o(17710);
                            return;
                        case 24:
                        case 25:
                            C4990ab.m7417i(C33672a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", Integer.valueOf(r0));
                            C33672a.m54974b(C33672a.this, true);
                            AppMethodBeat.m2505o(17710);
                            return;
                        default:
                            C4990ab.m7417i(C33672a.TAG, "click backup banner,backupMoveState[%d]", Integer.valueOf(r0));
                            break;
                    }
            }
            AppMethodBeat.m2505o(17710);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupui.a$a */
    static class C33673a implements C19936a {
        private final WeakReference<C33672a> jyI;

        C33673a(C33672a c33672a) {
            AppMethodBeat.m2504i(17711);
            this.jyI = new WeakReference(c33672a);
            AppMethodBeat.m2505o(17711);
        }

        /* renamed from: ri */
        public final void mo35185ri(int i) {
            AppMethodBeat.m2504i(17712);
            C33672a c33672a = (C33672a) this.jyI.get();
            if (c33672a != null) {
                C33672a.m54973a(c33672a, i);
                AppMethodBeat.m2505o(17712);
                return;
            }
            C4990ab.m7412e(C33672a.TAG, "BackupChatBanner WeakReference is null!");
            AppMethodBeat.m2505o(17712);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m54974b(C33672a c33672a, boolean z) {
        AppMethodBeat.m2504i(17721);
        c33672a.m54976fq(z);
        AppMethodBeat.m2505o(17721);
    }

    public C33672a(Context context) {
        super(context);
        AppMethodBeat.m2504i(17713);
        C4990ab.m7416i(TAG, "BackupChatBanner.");
        C42759b.aTD().aSu().jqW = -100;
        C41258b.aSZ().aSu().jqW = -100;
        C4990ab.m7416i(TAG, "initialize");
        this.gne = (TextView) this.view.findViewById(2131821632);
        this.jyC = this.view.findViewById(2131821630);
        this.jyD = this.view.findViewById(2131821629);
        if (this.view != null) {
            this.jyC = this.view.findViewById(2131821630);
            this.jyC.setOnClickListener(new C274511());
        }
        aMN();
        C42759b.aTD().aTF().jwn = this.jyG;
        C42759b.aTD().aTG().jwn = this.jyG;
        C41258b.aSZ().aTc().jtn = this.jyG;
        AppMethodBeat.m2505o(17713);
    }

    public final int getLayoutId() {
        return 2130968811;
    }

    /* renamed from: fp */
    private void m54975fp(boolean z) {
        AppMethodBeat.m2504i(17714);
        C4990ab.m7416i(TAG, "jumpToBackupPcUI");
        if (C5046bo.m7544cv((Context) this.vlu.get())) {
            Intent className = new Intent().setClassName((Context) this.vlu.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.m23791J((Context) this.vlu.get(), className);
        }
        AppMethodBeat.m2505o(17714);
    }

    /* renamed from: fq */
    private void m54976fq(boolean z) {
        AppMethodBeat.m2504i(17715);
        C4990ab.m7417i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", Boolean.valueOf(z));
        if (C5046bo.m7544cv((Context) this.vlu.get())) {
            Intent className = new Intent().setClassName((Context) this.vlu.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.m23791J((Context) this.vlu.get(), className);
        }
        AppMethodBeat.m2505o(17715);
    }

    /* renamed from: rB */
    private boolean m54977rB(int i) {
        AppMethodBeat.m2504i(17717);
        if (!(i == -100 && i == this.jyE)) {
            C4990ab.m7417i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", Integer.valueOf(C38634d.aSx()), Integer.valueOf(i));
            this.jyE = i;
        }
        C42758e aSu = C42759b.aTD().aSu();
        TextView textView;
        Context context;
        Object[] objArr;
        switch (i) {
            case -4:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                this.jyC.setVisibility(0);
                if (1 == C42759b.aTD().aTE().jwa || 3 == C42759b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                    ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a01));
                } else if (2 == C42759b.aTD().aTE().jwa || 4 == C42759b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                    ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a02));
                }
                AppMethodBeat.m2505o(17717);
                return true;
            case 4:
            case 5:
                this.jyC.setVisibility(0);
                if (1 == C42759b.aTD().aTE().jwa || 3 == C42759b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                    textView = (TextView) this.view.findViewById(2131821632);
                    context = C4996ah.getContext();
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    C42759b.aTD().aTE();
                    objArr[2] = C45736c.aTJ();
                    textView.setText(context.getString(C25738R.string.a1b, objArr));
                } else if (2 == C42759b.aTD().aTE().jwa || 4 == C42759b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                    textView = (TextView) this.view.findViewById(2131821632);
                    context = C4996ah.getContext();
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    C42759b.aTD().aTE();
                    objArr[2] = C45736c.aTJ();
                    textView.setText(context.getString(C25738R.string.a0y, objArr));
                }
                AppMethodBeat.m2505o(17717);
                return true;
            case 12:
            case 22:
                this.jyC.setVisibility(0);
                if (1 == C42759b.aTD().aTE().jwa || 3 == C42759b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                } else if (2 == C42759b.aTD().aTE().jwa || 4 == C42759b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                }
                ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a0n));
                AppMethodBeat.m2505o(17717);
                return true;
            case 14:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                textView = (TextView) this.view.findViewById(2131821632);
                context = C4996ah.getContext();
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aSu.jqX);
                objArr[1] = Integer.valueOf(aSu.jqY);
                C42759b.aTD().aTE();
                objArr[2] = C45736c.aTJ();
                textView.setText(context.getString(C25738R.string.a1b, objArr));
                AppMethodBeat.m2505o(17717);
                return true;
            case 15:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.f9425zl));
                AppMethodBeat.m2505o(17717);
                return true;
            case 23:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                textView = (TextView) this.view.findViewById(2131821632);
                context = C4996ah.getContext();
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aSu.jqX);
                objArr[1] = Integer.valueOf(aSu.jqY);
                C42759b.aTD().aTE();
                objArr[2] = C45736c.aTJ();
                textView.setText(context.getString(C25738R.string.a0y, objArr));
                AppMethodBeat.m2505o(17717);
                return true;
            case 24:
                m54975fp(true);
                AppMethodBeat.m2505o(17717);
                return true;
            case 25:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a10));
                AppMethodBeat.m2505o(17717);
                return true;
            case 26:
            case 27:
                this.jyC.setVisibility(8);
                if (C5046bo.m7544cv((Context) this.vlu.get())) {
                    m54975fp(true);
                }
                AppMethodBeat.m2505o(17717);
                return true;
            default:
                this.jyC.setVisibility(8);
                AppMethodBeat.m2505o(17717);
                return false;
        }
    }

    /* renamed from: rC */
    private boolean m54978rC(int i) {
        AppMethodBeat.m2504i(17718);
        if (!(i == -100 && i == this.jyF)) {
            C4990ab.m7417i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", Integer.valueOf(C38634d.aSx()), Integer.valueOf(i));
            this.jyF = i;
        }
        C42758e aSu = C41258b.aSZ().aSu();
        switch (i) {
            case -4:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.f9366xx));
                AppMethodBeat.m2505o(17718);
                return true;
            case 4:
            case 5:
            case 23:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                TextView textView = (TextView) this.view.findViewById(2131821632);
                Context context = C4996ah.getContext();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(aSu.jqX);
                objArr[1] = Integer.valueOf(aSu.jqY);
                C41258b.aSZ().aTc();
                objArr[2] = C33697c.aTi();
                textView.setText(context.getString(C25738R.string.f9410z5, objArr));
                AppMethodBeat.m2505o(17718);
                return true;
            case 22:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.f9405z0));
                AppMethodBeat.m2505o(17718);
                return true;
            case 24:
            case 52:
                if (C5046bo.m7544cv((Context) this.vlu.get())) {
                    m54976fq(true);
                }
                AppMethodBeat.m2505o(17718);
                return true;
            case 25:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(2131821631)).setImageDrawable(C5225ah.m7962f((Context) this.vlu.get(), C1318a.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_)));
                ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.f9412z7));
                AppMethodBeat.m2505o(17718);
                return true;
            case 26:
            case 27:
                this.jyC.setVisibility(8);
                if (C5046bo.m7544cv((Context) this.vlu.get())) {
                    m54976fq(true);
                }
                AppMethodBeat.m2505o(17718);
                return true;
            default:
                this.jyC.setVisibility(8);
                AppMethodBeat.m2505o(17718);
                return false;
        }
    }

    public final void destroy() {
    }

    public final int getOrder() {
        return 3;
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(17716);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.b7t);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        }
        boolean rB;
        switch (C38634d.aSx()) {
            case 1:
                rB = m54977rB(C42759b.aTD().aSu().jqW);
                AppMethodBeat.m2505o(17716);
                return rB;
            case 22:
                rB = m54978rC(C41258b.aSZ().aSu().jqW);
                AppMethodBeat.m2505o(17716);
                return rB;
            default:
                this.jyC.setVisibility(8);
                AppMethodBeat.m2505o(17716);
                return false;
        }
    }
}
