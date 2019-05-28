package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class WalletFaceIdAuthFragment extends AppCompatDialogFragment {
    private Dialog mDialog;
    private a mqT;
    private Bundle mqU;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(41362);
        getDialog().requestWindowFeature(1);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.o(41362);
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(41363);
        this.mDialog = new b(getActivity(), this.mqT, this.mqU);
        this.mDialog.setCancelable(false);
        Dialog dialog = this.mDialog;
        AppMethodBeat.o(41363);
        return dialog;
    }

    public void onPause() {
        AppMethodBeat.i(41364);
        super.onPause();
        ab.d("MicroMsg.WalletFaceIdAuthFragment", "on pause");
        AppMethodBeat.o(41364);
    }

    public void onStop() {
        AppMethodBeat.i(41365);
        super.onStop();
        ab.d("MicroMsg.WalletFaceIdAuthFragment", "on stop");
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
        AppMethodBeat.o(41365);
    }
}
