package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.i;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog mDialog = null;
    private OnCancelListener zzap = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        AppMethodBeat.i(60474);
        SupportErrorDialogFragment newInstance = newInstance(dialog, null);
        AppMethodBeat.o(60474);
        return newInstance;
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, OnCancelListener onCancelListener) {
        AppMethodBeat.i(60475);
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.mDialog = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.zzap = onCancelListener;
        }
        AppMethodBeat.o(60475);
        return supportErrorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        AppMethodBeat.i(60473);
        if (this.zzap != null) {
            this.zzap.onCancel(dialogInterface);
        }
        AppMethodBeat.o(60473);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(60472);
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        Dialog dialog = this.mDialog;
        AppMethodBeat.o(60472);
        return dialog;
    }

    public void show(i iVar, String str) {
        AppMethodBeat.i(60476);
        super.show(iVar, str);
        AppMethodBeat.o(60476);
    }
}
