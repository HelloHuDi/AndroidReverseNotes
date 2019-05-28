package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23306f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.storage.C46627q;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.h */
public final class C11234h extends C33729a {
    public TextView jPK;
    public View jPL;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.h$1 */
    public class C112351 implements OnClickListener {
        final /* synthetic */ C46627q jEl;

        public C112351(C46627q c46627q) {
            this.jEl = c46627q;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14266);
            if (this.jEl.field_isExpand) {
                C11234h.this.jPi.setMaxLines(5);
                this.jEl.field_isExpand = false;
                C11234h.this.jPK.setText(C25738R.string.a_1);
                AppMethodBeat.m2505o(14266);
                return;
            }
            C11234h.this.jPi.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            this.jEl.field_isExpand = true;
            C11234h.this.jPK.setText(C25738R.string.a_2);
            AppMethodBeat.m2505o(14266);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.h$2 */
    public class C112362 implements OnLongClickListener {
        final /* synthetic */ C46627q jEl;

        public C112362(C46627q c46627q) {
            this.jEl = c46627q;
        }

        public final boolean onLongClick(View view) {
            C11234h.this.jPm.jNl = this.jEl;
            C11234h.this.jPm.jNn = 1;
            return true;
        }
    }

    /* renamed from: a */
    public final View mo22938a(Context context, C38701a c38701a) {
        AppMethodBeat.m2504i(14267);
        super.mo45311b(context, c38701a);
        View view;
        if (this.jOR != null) {
            view = this.jOR;
            AppMethodBeat.m2505o(14267);
            return view;
        }
        this.jOR = View.inflate(context, 2130968871, null);
        aWH();
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821513);
        this.jPi.setOnTouchListener(new C23306f(this.jPi, new C30132m(this.jPi.getContext())));
        this.jPK = (TextView) this.jOR.findViewById(2131821851);
        this.jPL = this.jOR.findViewById(2131821850);
        view = this.jOR;
        AppMethodBeat.m2505o(14267);
        return view;
    }
}
