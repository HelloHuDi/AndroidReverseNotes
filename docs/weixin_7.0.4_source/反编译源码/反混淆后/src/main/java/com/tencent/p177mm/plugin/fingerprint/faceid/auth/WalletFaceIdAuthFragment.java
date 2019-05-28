package com.tencent.p177mm.plugin.fingerprint.faceid.auth;

import android.app.Dialog;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthFragment */
public class WalletFaceIdAuthFragment extends AppCompatDialogFragment {
    private Dialog mDialog;
    private C11932a mqT;
    private Bundle mqU;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(41362);
        getDialog().requestWindowFeature(1);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.m2505o(41362);
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.m2504i(41363);
        this.mDialog = new C34180b(getActivity(), this.mqT, this.mqU);
        this.mDialog.setCancelable(false);
        Dialog dialog = this.mDialog;
        AppMethodBeat.m2505o(41363);
        return dialog;
    }

    public void onPause() {
        AppMethodBeat.m2504i(41364);
        super.onPause();
        C4990ab.m7410d("MicroMsg.WalletFaceIdAuthFragment", "on pause");
        AppMethodBeat.m2505o(41364);
    }

    public void onStop() {
        AppMethodBeat.m2504i(41365);
        super.onStop();
        C4990ab.m7410d("MicroMsg.WalletFaceIdAuthFragment", "on stop");
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
        AppMethodBeat.m2505o(41365);
    }
}
