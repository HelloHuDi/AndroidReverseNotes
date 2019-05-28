package com.tencent.mm.ui.contact;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class j extends LinearLayout {
    private Context context;
    private String fuO;

    public j(Context context, String str) {
        super(context);
        AppMethodBeat.i(33711);
        this.context = context;
        this.fuO = str;
        View inflate = View.inflate(getContext(), R.layout.vb, this);
        View findViewById = findViewById(R.id.bhx);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33709);
                Intent intent = new Intent();
                intent.putExtra("enterprise_from_scene", 2);
                intent.putExtra("enterprise_biz_name", j.this.fuO);
                d.b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
                AppMethodBeat.o(33709);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(33710);
                if (j.this.context instanceof MMActivity) {
                    ((MMActivity) j.this.context).aqX();
                }
                AppMethodBeat.o(33710);
                return false;
            }
        });
        aw.ZK();
        ad aoM = c.XM().aoM(this.fuO);
        if (aoM == null || ((int) aoM.ewQ) <= 0) {
            ab.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", this.fuO);
            AppMethodBeat.o(33711);
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.id.a6v);
        b.b((ImageView) maskLayout.getContentView(), this.fuO);
        if (aoM.field_verifyFlag == 0) {
            maskLayout.setMaskBitmap(null);
        } else if (a.flw != null) {
            String kz = a.flw.kz(aoM.field_verifyFlag);
            if (kz != null) {
                maskLayout.a(m.rk(kz), MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
            } else {
                maskLayout.setMaskBitmap(null);
            }
        } else {
            maskLayout.setMaskBitmap(null);
        }
        ((TextView) findViewById(R.id.bhy)).setText(aoM.Oi());
        AppMethodBeat.o(33711);
    }
}
