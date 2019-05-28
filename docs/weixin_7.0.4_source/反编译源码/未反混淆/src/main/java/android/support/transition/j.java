package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

interface j {

    public interface a {
        void A(View view);

        j a(View view, ViewGroup viewGroup, Matrix matrix);
    }

    void a(ViewGroup viewGroup, View view);

    void setVisibility(int i);
}
