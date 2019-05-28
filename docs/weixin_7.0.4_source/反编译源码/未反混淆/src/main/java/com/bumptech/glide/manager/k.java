package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class k extends Fragment {
    final a aGD;
    final m aGE;
    private final Set<k> aGF;
    private k aGG;
    Fragment aGH;
    j awX;

    class a implements m {
        a() {
        }

        public final String toString() {
            AppMethodBeat.i(92384);
            String str = super.toString() + "{fragment=" + k.this + "}";
            AppMethodBeat.o(92384);
            return str;
        }
    }

    public k() {
        this(new a());
        AppMethodBeat.i(92385);
        AppMethodBeat.o(92385);
    }

    @SuppressLint({"ValidFragment"})
    private k(a aVar) {
        AppMethodBeat.i(92386);
        this.aGE = new a();
        this.aGF = new HashSet();
        this.aGD = aVar;
        AppMethodBeat.o(92386);
    }

    private void nI() {
        AppMethodBeat.i(92387);
        if (this.aGG != null) {
            this.aGG.aGF.remove(this);
            this.aGG = null;
        }
        AppMethodBeat.o(92387);
    }

    public final void onAttach(Activity activity) {
        AppMethodBeat.i(92388);
        super.onAttach(activity);
        try {
            nI();
            this.aGG = c.ae(activity).awl.a(activity.getFragmentManager(), l.j(activity));
            if (!equals(this.aGG)) {
                this.aGG.aGF.add(this);
            }
            AppMethodBeat.o(92388);
        } catch (IllegalStateException e) {
            Log.isLoggable("RMFragment", 5);
            AppMethodBeat.o(92388);
        }
    }

    public final void onDetach() {
        AppMethodBeat.i(92389);
        super.onDetach();
        nI();
        AppMethodBeat.o(92389);
    }

    public final void onStart() {
        AppMethodBeat.i(92390);
        super.onStart();
        this.aGD.onStart();
        AppMethodBeat.o(92390);
    }

    public final void onStop() {
        AppMethodBeat.i(92391);
        super.onStop();
        this.aGD.onStop();
        AppMethodBeat.o(92391);
    }

    public final void onDestroy() {
        AppMethodBeat.i(92392);
        super.onDestroy();
        this.aGD.onDestroy();
        nI();
        AppMethodBeat.o(92392);
    }

    public final String toString() {
        Object parentFragment;
        AppMethodBeat.i(92393);
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
        AppMethodBeat.o(92393);
        return stringBuilder;
    }
}
