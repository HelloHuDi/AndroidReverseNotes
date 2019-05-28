package android.arch.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;

public class AndroidViewModel extends ViewModel {
    @SuppressLint({"StaticFieldLeak"})
    private Application cc;

    public AndroidViewModel(Application application) {
        this.cc = application;
    }

    public <T extends Application> T getApplication() {
        return this.cc;
    }
}
