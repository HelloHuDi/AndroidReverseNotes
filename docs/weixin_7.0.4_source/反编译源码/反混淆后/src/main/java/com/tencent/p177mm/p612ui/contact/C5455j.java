package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C8935m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.base.MaskLayout.C23622a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.contact.j */
public final class C5455j extends LinearLayout {
    private Context context;
    private String fuO;

    /* renamed from: com.tencent.mm.ui.contact.j$1 */
    class C54541 implements OnClickListener {
        C54541() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33709);
            Intent intent = new Intent();
            intent.putExtra("enterprise_from_scene", 2);
            intent.putExtra("enterprise_biz_name", C5455j.this.fuO);
            C25985d.m41467b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
            AppMethodBeat.m2505o(33709);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.j$2 */
    class C54562 implements OnTouchListener {
        C54562() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(33710);
            if (C5455j.this.context instanceof MMActivity) {
                ((MMActivity) C5455j.this.context).aqX();
            }
            AppMethodBeat.m2505o(33710);
            return false;
        }
    }

    public C5455j(Context context, String str) {
        super(context);
        AppMethodBeat.m2504i(33711);
        this.context = context;
        this.fuO = str;
        View inflate = View.inflate(getContext(), 2130969393, this);
        View findViewById = findViewById(2131823612);
        inflate.setOnClickListener(new C54541());
        findViewById.setOnTouchListener(new C54562());
        C9638aw.m17190ZK();
        C7616ad aoM = C18628c.m29078XM().aoM(this.fuO);
        if (aoM == null || ((int) aoM.ewQ) <= 0) {
            C4990ab.m7413e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", this.fuO);
            AppMethodBeat.m2505o(33711);
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(2131821798);
        C40460b.m69434b((ImageView) maskLayout.getContentView(), this.fuO);
        if (aoM.field_verifyFlag == 0) {
            maskLayout.setMaskBitmap(null);
        } else if (C26417a.flw != null) {
            String kz = C26417a.flw.mo37873kz(aoM.field_verifyFlag);
            if (kz != null) {
                maskLayout.mo48741a(C8935m.m16106rk(kz), C23622a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
            } else {
                maskLayout.setMaskBitmap(null);
            }
        } else {
            maskLayout.setMaskBitmap(null);
        }
        ((TextView) findViewById(2131823613)).setText(aoM.mo16706Oi());
        AppMethodBeat.m2505o(33711);
    }
}
