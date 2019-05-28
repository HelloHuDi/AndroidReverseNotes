package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public interface v {

    public static abstract class a {
        public OnClickListener rjy = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38274);
                if (view.getTag() == null) {
                    AppMethodBeat.o(38274);
                    return;
                }
                a.this.DO(((Integer) view.getTag()).intValue());
                AppMethodBeat.o(38274);
            }
        };

        public abstract void DO(int i);
    }

    void clean();

    View getView();

    void setImageClick(a aVar);

    void setIsShowAddImage(boolean z);

    void setList$22875ea3(List<String> list);
}
