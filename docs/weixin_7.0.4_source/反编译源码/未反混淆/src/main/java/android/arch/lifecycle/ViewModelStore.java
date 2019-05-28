package android.arch.lifecycle;

import java.util.HashMap;

public class ViewModelStore {
    final HashMap<String, ViewModel> cS = new HashMap();

    /* Access modifiers changed, original: final */
    public final void a(String str, ViewModel viewModel) {
        ViewModel viewModel2 = (ViewModel) this.cS.get(str);
        if (viewModel2 != null) {
            viewModel2.ao();
        }
        this.cS.put(str, viewModel);
    }

    public final void clear() {
        for (ViewModel ao : this.cS.values()) {
            ao.ao();
        }
        this.cS.clear();
    }
}
