package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        return new C17391c(getContext(), getTheme());
    }
}
