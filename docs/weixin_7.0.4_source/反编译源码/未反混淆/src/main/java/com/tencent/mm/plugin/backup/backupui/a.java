package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ah;
import java.lang.ref.WeakReference;

public final class a extends b {
    private static String TAG = "MicroMsg.BackupChatBanner";
    private TextView gne = null;
    private View jyC = null;
    private View jyD;
    private int jyE = 100;
    private int jyF = 100;
    private com.tencent.mm.plugin.backup.b.b.a jyG = new a(this);

    static class a implements com.tencent.mm.plugin.backup.b.b.a {
        private final WeakReference<a> jyI;

        a(a aVar) {
            AppMethodBeat.i(17711);
            this.jyI = new WeakReference(aVar);
            AppMethodBeat.o(17711);
        }

        public final void ri(int i) {
            AppMethodBeat.i(17712);
            a aVar = (a) this.jyI.get();
            if (aVar != null) {
                a.a(aVar, i);
                AppMethodBeat.o(17712);
                return;
            }
            ab.e(a.TAG, "BackupChatBanner WeakReference is null!");
            AppMethodBeat.o(17712);
        }
    }

    static /* synthetic */ void b(a aVar, boolean z) {
        AppMethodBeat.i(17721);
        aVar.fq(z);
        AppMethodBeat.o(17721);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(17713);
        ab.i(TAG, "BackupChatBanner.");
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW = -100;
        com.tencent.mm.plugin.backup.d.b.aSZ().aSu().jqW = -100;
        ab.i(TAG, "initialize");
        this.gne = (TextView) this.view.findViewById(R.id.a2d);
        this.jyC = this.view.findViewById(R.id.a2b);
        this.jyD = this.view.findViewById(R.id.a2a);
        if (this.view != null) {
            this.jyC = this.view.findViewById(R.id.a2b);
            this.jyC.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(17710);
                    ab.i(a.TAG, "backupbanner onclick, backupMode[%d]", Integer.valueOf(d.aSx()));
                    switch (d.aSx()) {
                        case 1:
                            ab.i(a.TAG, "backupbanner onclick, backupPcState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW));
                            switch (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW) {
                                case -4:
                                case 4:
                                case 5:
                                case 12:
                                case 14:
                                case 15:
                                case 22:
                                case 23:
                                case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                    ab.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW));
                                    a.a(a.this, false);
                                    AppMethodBeat.o(17710);
                                    return;
                                case 24:
                                case 25:
                                    ab.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW));
                                    a.a(a.this, true);
                                    AppMethodBeat.o(17710);
                                    return;
                                default:
                                    ab.i(a.TAG, "click backup banner, BackupPcState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW));
                                    AppMethodBeat.o(17710);
                                    return;
                            }
                        case 22:
                            ab.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.d.b.aSZ().aSu().jqW));
                            switch (com.tencent.mm.plugin.backup.d.b.aSZ().aSu().jqW) {
                                case -4:
                                case 4:
                                case 5:
                                case 12:
                                case 22:
                                case 23:
                                case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                case 52:
                                    ab.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", Integer.valueOf(r0));
                                    a.b(a.this, false);
                                    AppMethodBeat.o(17710);
                                    return;
                                case 24:
                                case 25:
                                    ab.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", Integer.valueOf(r0));
                                    a.b(a.this, true);
                                    AppMethodBeat.o(17710);
                                    return;
                                default:
                                    ab.i(a.TAG, "click backup banner,backupMoveState[%d]", Integer.valueOf(r0));
                                    break;
                            }
                    }
                    AppMethodBeat.o(17710);
                }
            });
        }
        aMN();
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().jwn = this.jyG;
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTG().jwn = this.jyG;
        com.tencent.mm.plugin.backup.d.b.aSZ().aTc().jtn = this.jyG;
        AppMethodBeat.o(17713);
    }

    public final int getLayoutId() {
        return R.layout.fn;
    }

    private void fp(boolean z) {
        AppMethodBeat.i(17714);
        ab.i(TAG, "jumpToBackupPcUI");
        if (bo.cv((Context) this.vlu.get())) {
            Intent className = new Intent().setClassName((Context) this.vlu.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.J((Context) this.vlu.get(), className);
        }
        AppMethodBeat.o(17714);
    }

    private void fq(boolean z) {
        AppMethodBeat.i(17715);
        ab.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", Boolean.valueOf(z));
        if (bo.cv((Context) this.vlu.get())) {
            Intent className = new Intent().setClassName((Context) this.vlu.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.J((Context) this.vlu.get(), className);
        }
        AppMethodBeat.o(17715);
    }

    private boolean rB(int i) {
        AppMethodBeat.i(17717);
        if (!(i == -100 && i == this.jyE)) {
            ab.i(TAG, "refreshPcState backupMode[%d], backupPcState[%d]", Integer.valueOf(d.aSx()), Integer.valueOf(i));
            this.jyE = i;
        }
        e aSu = com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu();
        TextView textView;
        Context context;
        Object[] objArr;
        switch (i) {
            case -4:
            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                this.jyC.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                    ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.a01));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                    ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.a02));
                }
                AppMethodBeat.o(17717);
                return true;
            case 4:
            case 5:
                this.jyC.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                    textView = (TextView) this.view.findViewById(R.id.a2d);
                    context = com.tencent.mm.sdk.platformtools.ah.getContext();
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE();
                    objArr[2] = c.aTJ();
                    textView.setText(context.getString(R.string.a1b, objArr));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                    textView = (TextView) this.view.findViewById(R.id.a2d);
                    context = com.tencent.mm.sdk.platformtools.ah.getContext();
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE();
                    objArr[2] = c.aTJ();
                    textView.setText(context.getString(R.string.a0y, objArr));
                }
                AppMethodBeat.o(17717);
                return true;
            case 12:
            case 22:
                this.jyC.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwa) {
                    ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                }
                ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.a0n));
                AppMethodBeat.o(17717);
                return true;
            case 14:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                textView = (TextView) this.view.findViewById(R.id.a2d);
                context = com.tencent.mm.sdk.platformtools.ah.getContext();
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aSu.jqX);
                objArr[1] = Integer.valueOf(aSu.jqY);
                com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE();
                objArr[2] = c.aTJ();
                textView.setText(context.getString(R.string.a1b, objArr));
                AppMethodBeat.o(17717);
                return true;
            case 15:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.zl));
                AppMethodBeat.o(17717);
                return true;
            case 23:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                textView = (TextView) this.view.findViewById(R.id.a2d);
                context = com.tencent.mm.sdk.platformtools.ah.getContext();
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aSu.jqX);
                objArr[1] = Integer.valueOf(aSu.jqY);
                com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE();
                objArr[2] = c.aTJ();
                textView.setText(context.getString(R.string.a0y, objArr));
                AppMethodBeat.o(17717);
                return true;
            case 24:
                fp(true);
                AppMethodBeat.o(17717);
                return true;
            case 25:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_display_mobile, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.a10));
                AppMethodBeat.o(17717);
                return true;
            case 26:
            case 27:
                this.jyC.setVisibility(8);
                if (bo.cv((Context) this.vlu.get())) {
                    fp(true);
                }
                AppMethodBeat.o(17717);
                return true;
            default:
                this.jyC.setVisibility(8);
                AppMethodBeat.o(17717);
                return false;
        }
    }

    private boolean rC(int i) {
        AppMethodBeat.i(17718);
        if (!(i == -100 && i == this.jyF)) {
            ab.i(TAG, "refreshMoveRecoverState backupMode[%d], backupMoveState[%d]", Integer.valueOf(d.aSx()), Integer.valueOf(i));
            this.jyF = i;
        }
        e aSu = com.tencent.mm.plugin.backup.d.b.aSZ().aSu();
        switch (i) {
            case -4:
            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.xx));
                AppMethodBeat.o(17718);
                return true;
            case 4:
            case 5:
            case 23:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                TextView textView = (TextView) this.view.findViewById(R.id.a2d);
                Context context = com.tencent.mm.sdk.platformtools.ah.getContext();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(aSu.jqX);
                objArr[1] = Integer.valueOf(aSu.jqY);
                com.tencent.mm.plugin.backup.d.b.aSZ().aTc();
                objArr[2] = com.tencent.mm.plugin.backup.d.c.aTi();
                textView.setText(context.getString(R.string.z5, objArr));
                AppMethodBeat.o(17718);
                return true;
            case 22:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.z0));
                AppMethodBeat.o(17718);
                return true;
            case 24:
            case 52:
                if (bo.cv((Context) this.vlu.get())) {
                    fq(true);
                }
                AppMethodBeat.o(17718);
                return true;
            case 25:
                this.jyC.setVisibility(0);
                ((ImageView) this.view.findViewById(R.id.a2c)).setImageDrawable(ah.f((Context) this.vlu.get(), R.raw.icons_outlined_migration_recieve, ((Context) this.vlu.get()).getResources().getColor(R.color.a3_)));
                ((TextView) this.view.findViewById(R.id.a2d)).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.z7));
                AppMethodBeat.o(17718);
                return true;
            case 26:
            case 27:
                this.jyC.setVisibility(8);
                if (bo.cv((Context) this.vlu.get())) {
                    fq(true);
                }
                AppMethodBeat.o(17718);
                return true;
            default:
                this.jyC.setVisibility(8);
                AppMethodBeat.o(17718);
                return false;
        }
    }

    public final void destroy() {
    }

    public final int getOrder() {
        return 3;
    }

    public final boolean aMN() {
        AppMethodBeat.i(17716);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.b7t);
            this.gne.setBackgroundResource(R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(R.drawable.a_q);
        }
        boolean rB;
        switch (d.aSx()) {
            case 1:
                rB = rB(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW);
                AppMethodBeat.o(17716);
                return rB;
            case 22:
                rB = rC(com.tencent.mm.plugin.backup.d.b.aSZ().aSu().jqW);
                AppMethodBeat.o(17716);
                return rB;
            default:
                this.jyC.setVisibility(8);
                AppMethodBeat.o(17716);
                return false;
        }
    }
}
