package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.p381a.C16733g;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2MainFragment */
public class EmojiStoreV2MainFragment extends EmojiStoreV2BaseFragment {
    private boolean ldT = false;

    public int getLayoutId() {
        return 2130969366;
    }

    public void onAttach(Activity activity) {
        AppMethodBeat.m2504i(53640);
        super.onAttach(activity);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
        AppMethodBeat.m2505o(53640);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53641);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
        AppMethodBeat.m2505o(53641);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(53642);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.m2505o(53642);
        return onCreateView;
    }

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.m2504i(53643);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        AppMethodBeat.m2505o(53643);
    }

    public void onStart() {
        AppMethodBeat.m2504i(53644);
        super.onStart();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
        AppMethodBeat.m2505o(53644);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53645);
        super.onResume();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
        AppMethodBeat.m2505o(53645);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53646);
        super.onPause();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
        AppMethodBeat.m2505o(53646);
    }

    public void onStop() {
        AppMethodBeat.m2504i(53647);
        super.onStop();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
        AppMethodBeat.m2505o(53647);
    }

    public void onDestroyView() {
        AppMethodBeat.m2504i(53648);
        super.onDestroyView();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
        AppMethodBeat.m2505o(53648);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53649);
        super.onDestroy();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
        AppMethodBeat.m2505o(53649);
    }

    public void onDetach() {
        AppMethodBeat.m2504i(53650);
        super.onDetach();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
        AppMethodBeat.m2505o(53650);
    }

    public final int bkV() {
        return 5;
    }

    public final C33944a bkO() {
        AppMethodBeat.m2504i(53651);
        C16733g c16733g = new C16733g(getContext());
        AppMethodBeat.m2505o(53651);
        return c16733g;
    }

    public final boolean bmd() {
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.m2504i(53652);
        super.setUserVisibleHint(z);
        if (!this.ldT && z) {
            this.ldT = true;
            C7060h.pYm.mo8381e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(1), Integer.valueOf(1));
        }
        AppMethodBeat.m2505o(53652);
    }
}
