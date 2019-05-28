package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.g */
public final class C14734g {
    public View mParentView;
    public PopupWindow uPB;
    public C4685a uPC;

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.g$a */
    public interface C4685a {
        void deD();

        void deE();

        void deF();

        void deG();
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.g$4 */
    class C147334 implements OnClickListener {
        C147334() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26778);
            C14734g.this.uPB.dismiss();
            C14734g.this.mParentView.setVisibility(8);
            if (C14734g.this.uPC != null) {
                C14734g.this.uPC.deG();
            }
            AppMethodBeat.m2505o(26778);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.g$1 */
    class C147351 implements OnClickListener {
        C147351() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26775);
            C14734g.this.uPB.dismiss();
            C14734g.this.mParentView.setVisibility(8);
            if (C14734g.this.uPC != null) {
                C14734g.this.uPC.deD();
            }
            AppMethodBeat.m2505o(26775);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.g$2 */
    class C147362 implements OnClickListener {
        C147362() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26776);
            C14734g.this.uPB.dismiss();
            C14734g.this.mParentView.setVisibility(8);
            if (C14734g.this.uPC != null) {
                C14734g.this.uPC.deE();
            }
            AppMethodBeat.m2505o(26776);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.g$3 */
    class C147373 implements OnClickListener {
        C147373() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26777);
            C14734g.this.uPB.dismiss();
            C14734g.this.mParentView.setVisibility(8);
            if (C14734g.this.uPC != null) {
                C14734g.this.uPC.deF();
            }
            AppMethodBeat.m2505o(26777);
        }
    }

    public C14734g(Context context, View view) {
        AppMethodBeat.m2504i(26779);
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(2130971231, null);
        inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.uPB = new PopupWindow(inflate, -2, -2, false);
        this.uPB.setClippingEnabled(false);
        inflate.findViewById(2131829220).setOnClickListener(new C147351());
        inflate.findViewById(2131829221).setOnClickListener(new C147362());
        inflate.findViewById(2131829222).setOnClickListener(new C147373());
        inflate.findViewById(2131829223).setOnClickListener(new C147334());
        AppMethodBeat.m2505o(26779);
    }
}
