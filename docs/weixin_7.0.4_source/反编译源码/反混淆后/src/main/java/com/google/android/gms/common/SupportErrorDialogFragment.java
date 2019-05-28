package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.DialogFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog mDialog = null;
    private OnCancelListener zzap = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        AppMethodBeat.m2504i(60474);
        SupportErrorDialogFragment newInstance = newInstance(dialog, null);
        AppMethodBeat.m2505o(60474);
        return newInstance;
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(60475);
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.mDialog = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.zzap = onCancelListener;
        }
        AppMethodBeat.m2505o(60475);
        return supportErrorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        AppMethodBeat.m2504i(60473);
        if (this.zzap != null) {
            this.zzap.onCancel(dialogInterface);
        }
        AppMethodBeat.m2505o(60473);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.m2504i(60472);
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        Dialog dialog = this.mDialog;
        AppMethodBeat.m2505o(60472);
        return dialog;
    }

    public void show(C0336i c0336i, String str) {
        AppMethodBeat.m2504i(60476);
        super.show(c0336i, str);
        AppMethodBeat.m2505o(60476);
    }
}
