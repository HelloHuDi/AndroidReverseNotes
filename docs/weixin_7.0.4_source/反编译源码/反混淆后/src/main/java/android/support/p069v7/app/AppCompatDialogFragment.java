package android.support.p069v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.p057v4.app.DialogFragment;

/* renamed from: android.support.v7.app.AppCompatDialogFragment */
public class AppCompatDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        return new C6218i(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof C6218i) {
            C6218i c6218i = (C6218i) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            c6218i.mo14042fA();
            return;
        }
        super.setupDialog(dialog, i);
    }
}
