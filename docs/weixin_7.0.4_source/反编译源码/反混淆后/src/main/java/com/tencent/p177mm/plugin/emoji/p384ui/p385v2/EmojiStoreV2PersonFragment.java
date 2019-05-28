package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.p381a.C45844h;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2PersonFragment */
public class EmojiStoreV2PersonFragment extends EmojiStoreV2BaseFragment {
    private boolean ldT = false;

    public int getLayoutId() {
        return 2130969368;
    }

    public void onAttach(Activity activity) {
        AppMethodBeat.m2504i(53653);
        super.onAttach(activity);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
        AppMethodBeat.m2505o(53653);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53654);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
        AppMethodBeat.m2505o(53654);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(53655);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.m2505o(53655);
        return onCreateView;
    }

    public void onStart() {
        AppMethodBeat.m2504i(53656);
        super.onStart();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
        AppMethodBeat.m2505o(53656);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53657);
        super.onResume();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        if (this.lcW != null) {
            this.lcW.bmf();
        }
        AppMethodBeat.m2505o(53657);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53658);
        super.onPause();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
        AppMethodBeat.m2505o(53658);
    }

    public void onStop() {
        AppMethodBeat.m2504i(53659);
        super.onStop();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
        AppMethodBeat.m2505o(53659);
    }

    public void onDestroyView() {
        AppMethodBeat.m2504i(53660);
        super.onDestroyView();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        AppMethodBeat.m2505o(53660);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53661);
        super.onDestroy();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
        AppMethodBeat.m2505o(53661);
    }

    public void onDetach() {
        AppMethodBeat.m2504i(53662);
        super.onDetach();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
        AppMethodBeat.m2505o(53662);
    }

    public final int bkV() {
        return 9;
    }

    public final C33944a bkO() {
        AppMethodBeat.m2504i(53663);
        C45844h c45844h = new C45844h(getContext());
        AppMethodBeat.m2505o(53663);
        return c45844h;
    }

    public final boolean bmd() {
        return false;
    }

    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.m2504i(53664);
        super.setUserVisibleHint(z);
        if (!this.ldT && z) {
            this.ldT = true;
            C7060h.pYm.mo8381e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(2), Integer.valueOf(2));
        }
        AppMethodBeat.m2505o(53664);
    }
}
