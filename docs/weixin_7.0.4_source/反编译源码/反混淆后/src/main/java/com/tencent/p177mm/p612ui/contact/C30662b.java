package com.tencent.p177mm.p612ui.contact;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.contact.b */
public final class C30662b extends RelativeLayout {
    private TextView contentView = null;
    private Context context;
    private View gbS = null;
    private View gwR = null;

    /* renamed from: com.tencent.mm.ui.contact.b$a */
    public enum C30661a {
        Chatromm,
        ContactLabel,
        ContactIpCall;

        static {
            AppMethodBeat.m2505o(33536);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.b$2 */
    class C306632 implements OnTouchListener {
        C306632() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(33532);
            if (C30662b.this.context instanceof MMActivity) {
                ((MMActivity) C30662b.this.context).aqX();
            }
            AppMethodBeat.m2505o(33532);
            return false;
        }
    }

    public C30662b(Context context, final C30661a c30661a) {
        super(context);
        AppMethodBeat.m2504i(33537);
        this.context = context;
        View.inflate(getContext(), 2130968640, this);
        this.gbS = findViewById(2131821064);
        this.gwR = this.gbS.findViewById(2131821065);
        LayoutParams layoutParams = this.gwR.getLayoutParams();
        layoutParams.height = (int) (((float) C1338a.m2857am(this.context, C25738R.dimen.f9768f4)) * C1338a.m2863fZ(this.context));
        this.gwR.setLayoutParams(layoutParams);
        this.contentView = (TextView) this.gwR.findViewById(2131821068);
        this.gbS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(33531);
                switch (C306653.zkC[c30661a.ordinal()]) {
                    case 1:
                        Intent intent = new Intent();
                        intent.setClassName(C30662b.this.context, "com.tencent.mm.ui.contact.ChatroomContactUI");
                        C30662b.this.context.startActivity(intent);
                        AppMethodBeat.m2505o(33531);
                        return;
                    case 2:
                        C25985d.m41467b(C30662b.this.context, "label", ".ui.ContactLabelManagerUI", new Intent());
                        AppMethodBeat.m2505o(33531);
                        return;
                    case 3:
                        C25985d.m41467b(C30662b.this.context, "ipcall", ".ui.IPCallAddressUI", new Intent());
                        AppMethodBeat.m2505o(33531);
                        return;
                    default:
                        C4990ab.m7413e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", c30661a);
                        AppMethodBeat.m2505o(33531);
                        return;
                }
            }
        });
        this.gwR.setOnTouchListener(new C306632());
        ImageView imageView = (ImageView) ((MaskLayout) this.gwR.findViewById(2131821066)).getContentView();
        switch (c30661a) {
            case Chatromm:
                this.contentView.setText(C25738R.string.f8738dl);
                C41732d.m73519a(getContext(), imageView, (int) C1318a.default_chatroom);
                AppMethodBeat.m2505o(33537);
                return;
            case ContactLabel:
                this.contentView.setText(C25738R.string.f8741dp);
                C41732d.m73519a(getContext(), imageView, (int) C1318a.default_contactlabel);
                AppMethodBeat.m2505o(33537);
                return;
            case ContactIpCall:
                this.gwR.setBackgroundResource(C25738R.drawable.f6623k5);
                this.contentView.setText(C25738R.string.f8740do);
                C41732d.m73519a(getContext(), imageView, (int) C1318a.default_ipcall);
                break;
        }
        AppMethodBeat.m2505o(33537);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.m2504i(33538);
        this.gbS.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(33538);
    }
}
