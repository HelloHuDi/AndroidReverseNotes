package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.C8555c;
import com.bumptech.glide.C8565j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* renamed from: com.bumptech.glide.manager.k */
public final class C31981k extends Fragment {
    final C37197a aGD;
    final C37200m aGE;
    private final Set<C31981k> aGF;
    private C31981k aGG;
    Fragment aGH;
    C8565j awX;

    /* renamed from: com.bumptech.glide.manager.k$a */
    class C31982a implements C37200m {
        C31982a() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(92384);
            String str = super.toString() + "{fragment=" + C31981k.this + "}";
            AppMethodBeat.m2505o(92384);
            return str;
        }
    }

    public C31981k() {
        this(new C37197a());
        AppMethodBeat.m2504i(92385);
        AppMethodBeat.m2505o(92385);
    }

    @SuppressLint({"ValidFragment"})
    private C31981k(C37197a c37197a) {
        AppMethodBeat.m2504i(92386);
        this.aGE = new C31982a();
        this.aGF = new HashSet();
        this.aGD = c37197a;
        AppMethodBeat.m2505o(92386);
    }

    /* renamed from: nI */
    private void m51970nI() {
        AppMethodBeat.m2504i(92387);
        if (this.aGG != null) {
            this.aGG.aGF.remove(this);
            this.aGG = null;
        }
        AppMethodBeat.m2505o(92387);
    }

    public final void onAttach(Activity activity) {
        AppMethodBeat.m2504i(92388);
        super.onAttach(activity);
        try {
            m51970nI();
            this.aGG = C8555c.m15204ae(activity).awl.mo72289a(activity.getFragmentManager(), C45005l.m82436j(activity));
            if (!equals(this.aGG)) {
                this.aGG.aGF.add(this);
            }
            AppMethodBeat.m2505o(92388);
        } catch (IllegalStateException e) {
            Log.isLoggable("RMFragment", 5);
            AppMethodBeat.m2505o(92388);
        }
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(92389);
        super.onDetach();
        m51970nI();
        AppMethodBeat.m2505o(92389);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(92390);
        super.onStart();
        this.aGD.onStart();
        AppMethodBeat.m2505o(92390);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(92391);
        super.onStop();
        this.aGD.onStop();
        AppMethodBeat.m2505o(92391);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(92392);
        super.onDestroy();
        this.aGD.onDestroy();
        m51970nI();
        AppMethodBeat.m2505o(92392);
    }

    public final String toString() {
        Object parentFragment;
        AppMethodBeat.m2504i(92393);
        StringBuilder append = new StringBuilder().append(super.toString()).append("{parent=");
        if (VERSION.SDK_INT >= 17) {
            parentFragment = getParentFragment();
        } else {
            parentFragment = null;
        }
        if (parentFragment == null) {
            parentFragment = this.aGH;
        }
        String stringBuilder = append.append(parentFragment).append("}").toString();
        AppMethodBeat.m2505o(92393);
        return stringBuilder;
    }
}
