package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.pluginsdk.ui.e.f;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class h extends a {
    public TextView jPK;
    public View jPL;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.h$1 */
    public class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ q jEl;

        public AnonymousClass1(q qVar) {
            this.jEl = qVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(14266);
            if (this.jEl.field_isExpand) {
                h.this.jPi.setMaxLines(5);
                this.jEl.field_isExpand = false;
                h.this.jPK.setText(R.string.a_1);
                AppMethodBeat.o(14266);
                return;
            }
            h.this.jPi.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            this.jEl.field_isExpand = true;
            h.this.jPK.setText(R.string.a_2);
            AppMethodBeat.o(14266);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.h$2 */
    public class AnonymousClass2 implements OnLongClickListener {
        final /* synthetic */ q jEl;

        public AnonymousClass2(q qVar) {
            this.jEl = qVar;
        }

        public final boolean onLongClick(View view) {
            h.this.jPm.jNl = this.jEl;
            h.this.jPm.jNn = 1;
            return true;
        }
    }

    public final View a(Context context, a aVar) {
        AppMethodBeat.i(14267);
        super.b(context, aVar);
        View view;
        if (this.jOR != null) {
            view = this.jOR;
            AppMethodBeat.o(14267);
            return view;
        }
        this.jOR = View.inflate(context, R.layout.h_, null);
        aWH();
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.z6);
        this.jPi.setOnTouchListener(new f(this.jPi, new m(this.jPi.getContext())));
        this.jPK = (TextView) this.jOR.findViewById(R.id.a8a);
        this.jPL = this.jOR.findViewById(R.id.a8_);
        view = this.jOR;
        AppMethodBeat.o(14267);
        return view;
    }
}
