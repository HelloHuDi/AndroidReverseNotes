package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    final a aGD;
    final m aGE;
    private final Set<SupportRequestManagerFragment> aGF;
    private SupportRequestManagerFragment aGT;
    Fragment aGU;
    j awX;

    class a implements m {
        a() {
        }

        public final String toString() {
            AppMethodBeat.i(92411);
            String str = super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
            AppMethodBeat.o(92411);
            return str;
        }
    }

    public SupportRequestManagerFragment() {
        this(new a());
        AppMethodBeat.i(92412);
        AppMethodBeat.o(92412);
    }

    @SuppressLint({"ValidFragment"})
    private SupportRequestManagerFragment(a aVar) {
        AppMethodBeat.i(92413);
        this.aGE = new a();
        this.aGF = new HashSet();
        this.aGD = aVar;
        AppMethodBeat.o(92413);
    }

    private void nI() {
        AppMethodBeat.i(92414);
        if (this.aGT != null) {
            this.aGT.aGF.remove(this);
            this.aGT = null;
        }
        AppMethodBeat.o(92414);
    }

    public void onAttach(Context context) {
        AppMethodBeat.i(92415);
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            nI();
            this.aGT = c.ae(activity).awl.a(activity.getSupportFragmentManager(), l.j(activity));
            if (!equals(this.aGT)) {
                this.aGT.aGF.add(this);
            }
            AppMethodBeat.o(92415);
        } catch (IllegalStateException e) {
            Log.isLoggable("SupportRMFragment", 5);
            AppMethodBeat.o(92415);
        }
    }

    public void onDetach() {
        AppMethodBeat.i(92416);
        super.onDetach();
        this.aGU = null;
        nI();
        AppMethodBeat.o(92416);
    }

    public void onStart() {
        AppMethodBeat.i(92417);
        super.onStart();
        this.aGD.onStart();
        AppMethodBeat.o(92417);
    }

    public void onStop() {
        AppMethodBeat.i(92418);
        super.onStop();
        this.aGD.onStop();
        AppMethodBeat.o(92418);
    }

    public void onDestroy() {
        AppMethodBeat.i(92419);
        super.onDestroy();
        this.aGD.onDestroy();
        nI();
        AppMethodBeat.o(92419);
    }

    public String toString() {
        AppMethodBeat.i(92420);
        StringBuilder append = new StringBuilder().append(super.toString()).append("{parent=");
        Object parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.aGU;
        }
        String stringBuilder = append.append(parentFragment).append("}").toString();
        AppMethodBeat.o(92420);
        return stringBuilder;
    }
}
