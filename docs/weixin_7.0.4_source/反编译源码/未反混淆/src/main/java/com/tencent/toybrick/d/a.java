package com.tencent.toybrick.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.ui.BaseToyUI;
import java.util.LinkedList;

public final class a {
    public a AFT;
    private BaseToyUI AGA;

    public class a {
        public LinkedList<g> AGQ = new LinkedList();
        public boolean AGR = true;
        public Drawable AGS;

        public a(Context context) {
            AppMethodBeat.i(113224);
            this.AGS = new ColorDrawable(context.getResources().getColor(R.color.t_));
            AppMethodBeat.o(113224);
        }
    }

    public a(BaseToyUI baseToyUI) {
        AppMethodBeat.i(113225);
        this.AGA = baseToyUI;
        this.AFT = new a(baseToyUI);
        AppMethodBeat.o(113225);
    }
}
