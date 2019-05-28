package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;

public class c extends e {
    public View jOZ;
    public TextView jPa;
    public ImageView jPd;
    public ImageView jPe;

    public void a(View view, a aVar) {
        AppMethodBeat.i(14243);
        super.a(view, aVar);
        AppMethodBeat.o(14243);
    }

    public final void aWI() {
        AppMethodBeat.i(14244);
        if (this.jOR == null) {
            AppMethodBeat.o(14244);
            return;
        }
        this.jOZ = this.jOR.findViewById(R.id.a88);
        this.jPa = (TextView) this.jOR.findViewById(R.id.a89);
        AppMethodBeat.o(14244);
    }
}
