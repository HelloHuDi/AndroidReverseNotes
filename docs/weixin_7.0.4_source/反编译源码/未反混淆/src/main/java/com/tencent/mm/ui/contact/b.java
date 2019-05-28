package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b extends RelativeLayout {
    private TextView contentView = null;
    private Context context;
    private View gbS = null;
    private View gwR = null;

    public enum a {
        Chatromm,
        ContactLabel,
        ContactIpCall;

        static {
            AppMethodBeat.o(33536);
        }
    }

    public b(Context context, final a aVar) {
        super(context);
        AppMethodBeat.i(33537);
        this.context = context;
        View.inflate(getContext(), R.layout.b1, this);
        this.gbS = findViewById(R.id.nc);
        this.gwR = this.gbS.findViewById(R.id.nd);
        LayoutParams layoutParams = this.gwR.getLayoutParams();
        layoutParams.height = (int) (((float) com.tencent.mm.bz.a.am(this.context, R.dimen.f4)) * com.tencent.mm.bz.a.fZ(this.context));
        this.gwR.setLayoutParams(layoutParams);
        this.contentView = (TextView) this.gwR.findViewById(R.id.ng);
        this.gbS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33531);
                switch (AnonymousClass3.zkC[aVar.ordinal()]) {
                    case 1:
                        Intent intent = new Intent();
                        intent.setClassName(b.this.context, "com.tencent.mm.ui.contact.ChatroomContactUI");
                        b.this.context.startActivity(intent);
                        AppMethodBeat.o(33531);
                        return;
                    case 2:
                        d.b(b.this.context, "label", ".ui.ContactLabelManagerUI", new Intent());
                        AppMethodBeat.o(33531);
                        return;
                    case 3:
                        d.b(b.this.context, "ipcall", ".ui.IPCallAddressUI", new Intent());
                        AppMethodBeat.o(33531);
                        return;
                    default:
                        ab.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", aVar);
                        AppMethodBeat.o(33531);
                        return;
                }
            }
        });
        this.gwR.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(33532);
                if (b.this.context instanceof MMActivity) {
                    ((MMActivity) b.this.context).aqX();
                }
                AppMethodBeat.o(33532);
                return false;
            }
        });
        ImageView imageView = (ImageView) ((MaskLayout) this.gwR.findViewById(R.id.ne)).getContentView();
        switch (aVar) {
            case Chatromm:
                this.contentView.setText(R.string.dl);
                com.tencent.mm.ah.d.a(getContext(), imageView, (int) R.raw.default_chatroom);
                AppMethodBeat.o(33537);
                return;
            case ContactLabel:
                this.contentView.setText(R.string.dp);
                com.tencent.mm.ah.d.a(getContext(), imageView, (int) R.raw.default_contactlabel);
                AppMethodBeat.o(33537);
                return;
            case ContactIpCall:
                this.gwR.setBackgroundResource(R.drawable.k5);
                this.contentView.setText(R.string.f12do);
                com.tencent.mm.ah.d.a(getContext(), imageView, (int) R.raw.default_ipcall);
                break;
        }
        AppMethodBeat.o(33537);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.i(33538);
        this.gbS.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(33538);
    }
}
