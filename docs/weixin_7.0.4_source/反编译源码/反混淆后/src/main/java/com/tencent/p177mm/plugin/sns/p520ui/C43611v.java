package com.tencent.p177mm.plugin.sns.p520ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.v */
public interface C43611v {

    /* renamed from: com.tencent.mm.plugin.sns.ui.v$a */
    public static abstract class C22145a {
        public OnClickListener rjy = new C221461();

        /* renamed from: com.tencent.mm.plugin.sns.ui.v$a$1 */
        class C221461 implements OnClickListener {
            C221461() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(38274);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(38274);
                    return;
                }
                C22145a.this.mo37706DO(((Integer) view.getTag()).intValue());
                AppMethodBeat.m2505o(38274);
            }
        }

        /* renamed from: DO */
        public abstract void mo37706DO(int i);
    }

    void clean();

    View getView();

    void setImageClick(C22145a c22145a);

    void setIsShowAddImage(boolean z);

    void setList$22875ea3(List<String> list);
}
