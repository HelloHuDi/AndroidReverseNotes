package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.C8555c;
import com.bumptech.glide.C8565j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    final C37197a aGD;
    final C37200m aGE;
    private final Set<SupportRequestManagerFragment> aGF;
    private SupportRequestManagerFragment aGT;
    Fragment aGU;
    C8565j awX;

    /* renamed from: com.bumptech.glide.manager.SupportRequestManagerFragment$a */
    class C41198a implements C37200m {
        C41198a() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(92411);
            String str = super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
            AppMethodBeat.m2505o(92411);
            return str;
        }
    }

    public SupportRequestManagerFragment() {
        this(new C37197a());
        AppMethodBeat.m2504i(92412);
        AppMethodBeat.m2505o(92412);
    }

    @SuppressLint({"ValidFragment"})
    private SupportRequestManagerFragment(C37197a c37197a) {
        AppMethodBeat.m2504i(92413);
        this.aGE = new C41198a();
        this.aGF = new HashSet();
        this.aGD = c37197a;
        AppMethodBeat.m2505o(92413);
    }

    /* renamed from: nI */
    private void m72797nI() {
        AppMethodBeat.m2504i(92414);
        if (this.aGT != null) {
            this.aGT.aGF.remove(this);
            this.aGT = null;
        }
        AppMethodBeat.m2505o(92414);
    }

    public void onAttach(Context context) {
        AppMethodBeat.m2504i(92415);
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            m72797nI();
            this.aGT = C8555c.m15204ae(activity).awl.mo72288a(activity.getSupportFragmentManager(), C45005l.m82436j(activity));
            if (!equals(this.aGT)) {
                this.aGT.aGF.add(this);
            }
            AppMethodBeat.m2505o(92415);
        } catch (IllegalStateException e) {
            Log.isLoggable("SupportRMFragment", 5);
            AppMethodBeat.m2505o(92415);
        }
    }

    public void onDetach() {
        AppMethodBeat.m2504i(92416);
        super.onDetach();
        this.aGU = null;
        m72797nI();
        AppMethodBeat.m2505o(92416);
    }

    public void onStart() {
        AppMethodBeat.m2504i(92417);
        super.onStart();
        this.aGD.onStart();
        AppMethodBeat.m2505o(92417);
    }

    public void onStop() {
        AppMethodBeat.m2504i(92418);
        super.onStop();
        this.aGD.onStop();
        AppMethodBeat.m2505o(92418);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(92419);
        super.onDestroy();
        this.aGD.onDestroy();
        m72797nI();
        AppMethodBeat.m2505o(92419);
    }

    public String toString() {
        AppMethodBeat.m2504i(92420);
        StringBuilder append = new StringBuilder().append(super.toString()).append("{parent=");
        Object parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.aGU;
        }
        String stringBuilder = append.append(parentFragment).append("}").toString();
        AppMethodBeat.m2505o(92420);
        return stringBuilder;
    }
}
