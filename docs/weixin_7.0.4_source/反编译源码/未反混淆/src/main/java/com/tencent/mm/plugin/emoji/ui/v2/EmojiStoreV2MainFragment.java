package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public class EmojiStoreV2MainFragment extends EmojiStoreV2BaseFragment {
    private boolean ldT = false;

    public int getLayoutId() {
        return R.layout.ul;
    }

    public void onAttach(Activity activity) {
        AppMethodBeat.i(53640);
        super.onAttach(activity);
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
        AppMethodBeat.o(53640);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53641);
        super.onCreate(bundle);
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
        AppMethodBeat.o(53641);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(53642);
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.o(53642);
        return onCreateView;
    }

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(53643);
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        AppMethodBeat.o(53643);
    }

    public void onStart() {
        AppMethodBeat.i(53644);
        super.onStart();
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
        AppMethodBeat.o(53644);
    }

    public void onResume() {
        AppMethodBeat.i(53645);
        super.onResume();
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
        AppMethodBeat.o(53645);
    }

    public void onPause() {
        AppMethodBeat.i(53646);
        super.onPause();
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
        AppMethodBeat.o(53646);
    }

    public void onStop() {
        AppMethodBeat.i(53647);
        super.onStop();
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
        AppMethodBeat.o(53647);
    }

    public void onDestroyView() {
        AppMethodBeat.i(53648);
        super.onDestroyView();
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
        AppMethodBeat.o(53648);
    }

    public void onDestroy() {
        AppMethodBeat.i(53649);
        super.onDestroy();
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
        AppMethodBeat.o(53649);
    }

    public void onDetach() {
        AppMethodBeat.i(53650);
        super.onDetach();
        ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
        AppMethodBeat.o(53650);
    }

    public final int bkV() {
        return 5;
    }

    public final a bkO() {
        AppMethodBeat.i(53651);
        g gVar = new g(getContext());
        AppMethodBeat.o(53651);
        return gVar;
    }

    public final boolean bmd() {
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(53652);
        super.setUserVisibleHint(z);
        if (!this.ldT && z) {
            this.ldT = true;
            h.pYm.e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(1), Integer.valueOf(1));
        }
        AppMethodBeat.o(53652);
    }
}
