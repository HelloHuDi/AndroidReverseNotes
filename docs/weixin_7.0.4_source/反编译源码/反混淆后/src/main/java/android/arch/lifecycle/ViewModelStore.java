package android.arch.lifecycle;

import java.util.HashMap;

public class ViewModelStore {
    /* renamed from: cS */
    final HashMap<String, ViewModel> f35cS = new HashMap();

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo326a(String str, ViewModel viewModel) {
        ViewModel viewModel2 = (ViewModel) this.f35cS.get(str);
        if (viewModel2 != null) {
            viewModel2.mo322ao();
        }
        this.f35cS.put(str, viewModel);
    }

    public final void clear() {
        for (ViewModel ao : this.f35cS.values()) {
            ao.mo322ao();
        }
        this.f35cS.clear();
    }
}
