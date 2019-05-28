package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.sdk.platformtools.ab;

public class EmojiStoreV2PersonFragment extends EmojiStoreV2BaseFragment {
    private boolean ldT = false;

    public int getLayoutId() {
        return R.layout.un;
    }

    public void onAttach(Activity activity) {
        AppMethodBeat.i(53653);
        super.onAttach(activity);
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
        AppMethodBeat.o(53653);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53654);
        super.onCreate(bundle);
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
        AppMethodBeat.o(53654);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(53655);
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.o(53655);
        return onCreateView;
    }

    public void onStart() {
        AppMethodBeat.i(53656);
        super.onStart();
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
        AppMethodBeat.o(53656);
    }

    public void onResume() {
        AppMethodBeat.i(53657);
        super.onResume();
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        if (this.lcW != null) {
            this.lcW.bmf();
        }
        AppMethodBeat.o(53657);
    }

    public void onPause() {
        AppMethodBeat.i(53658);
        super.onPause();
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
        AppMethodBeat.o(53658);
    }

    public void onStop() {
        AppMethodBeat.i(53659);
        super.onStop();
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
        AppMethodBeat.o(53659);
    }

    public void onDestroyView() {
        AppMethodBeat.i(53660);
        super.onDestroyView();
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        AppMethodBeat.o(53660);
    }

    public void onDestroy() {
        AppMethodBeat.i(53661);
        super.onDestroy();
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
        AppMethodBeat.o(53661);
    }

    public void onDetach() {
        AppMethodBeat.i(53662);
        super.onDetach();
        ab.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
        AppMethodBeat.o(53662);
    }

    public final int bkV() {
        return 9;
    }

    public final a bkO() {
        AppMethodBeat.i(53663);
        h hVar = new h(getContext());
        AppMethodBeat.o(53663);
        return hVar;
    }

    public final boolean bmd() {
        return false;
    }

    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(53664);
        super.setUserVisibleHint(z);
        if (!this.ldT && z) {
            this.ldT = true;
            com.tencent.mm.plugin.report.service.h.pYm.e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(2), Integer.valueOf(2));
        }
        AppMethodBeat.o(53664);
    }
}
