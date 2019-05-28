package com.tencent.p177mm.plugin.bottle.p925ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.plugin.bottle.p924a.C38676c;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;

/* renamed from: com.tencent.mm.plugin.bottle.ui.a */
final class C42789a extends C46692p<C7617ak> implements C4937b {
    private final MMActivity crP;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23599f jJQ;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();

    /* renamed from: com.tencent.mm.plugin.bottle.ui.a$1 */
    class C200191 implements OnClickListener {
        C200191() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18544);
            C4990ab.m7418v("MicroMsg.BottleConversationAdapter", "on delView clicked");
            C42789a.this.jJR.bIq();
            if (C42789a.this.jJQ != null) {
                C42789a.this.jJQ.mo11067bN(view.getTag());
            }
            AppMethodBeat.m2505o(18544);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.a$a */
    public static class C38677a {
        public ImageView ejo;
        public TextView ejp;
        public ImageView iYg;
        public TextView jJT;
        public TextView jJU;
        public TextView jJV;
        public View jJW;
        public TextView jJX;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(18552);
        C7617ak c7617ak = (C7617ak) obj;
        if (c7617ak == null) {
            c7617ak = new C7617ak();
        }
        c7617ak.mo14758jh("");
        c7617ak.mo14759ji("");
        c7617ak.mo8995d(cursor);
        AppMethodBeat.m2505o(18552);
        return c7617ak;
    }

    public C42789a(Context context, C30723a c30723a) {
        super(context, new C7617ak());
        AppMethodBeat.m2504i(18545);
        super.mo74992a(c30723a);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(18545);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(18546);
        C9638aw.m17190ZK();
        setCursor(C18628c.m29083XR().dsP());
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(18546);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo68254a(C23599f c23599f) {
        this.jJQ = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(18547);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.m2505o(18547);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C38677a c38677a;
        int i2;
        AppMethodBeat.m2504i(18548);
        C7617ak c7617ak = (C7617ak) getItem(i);
        if (view == null) {
            C38677a c38677a2 = new C38677a();
            View view2 = (MMSlideDelView) View.inflate(this.crP, 2130968832, null);
            View inflate = View.inflate(this.crP, 2130970931, null);
            c38677a2.ejo = (ImageView) inflate.findViewById(2131821183);
            c38677a2.ejp = (TextView) inflate.findViewById(2131823149);
            c38677a2.jJT = (TextView) inflate.findViewById(2131823150);
            c38677a2.jJU = (TextView) inflate.findViewById(2131823151);
            c38677a2.iYg = (ImageView) inflate.findViewById(2131828242);
            c38677a2.jJV = (TextView) inflate.findViewById(2131821067);
            c38677a2.jJW = view2.findViewById(2131821704);
            c38677a2.jJX = (TextView) view2.findViewById(2131821082);
            view2.setView(inflate);
            view2.setPerformItemClickListener(this.jJO);
            view2.setGetViewPositionCallback(this.jJP);
            view2.setItemStatusCallBack(this.jJR);
            view2.setEnable(false);
            view2.setTag(c38677a2);
            c38677a = c38677a2;
            view = view2;
        } else {
            c38677a = (C38677a) view.getTag();
        }
        C9638aw.m17190ZK();
        c38677a.ejp.setText(mo68253E(C18628c.m29078XM().aoO(c7617ak.field_username)));
        c38677a.jJT.setText(c7617ak.field_status == 1 ? this.crP.getString(C25738R.string.cw8) : C14835h.m23089c(this.crP, c7617ak.field_conversationTime, true));
        C40460b.m69434b(c38677a.ejo, C7616ad.aoC(c7617ak.field_username));
        C9638aw.m17190ZK();
        c38677a.jJU.setText(C44089j.m79293b(this.crP, C18628c.m29083XR().mo15765Cb().mo10532a(c7617ak.field_isSend, c7617ak.field_username, c7617ak.field_content, C42789a.m75877FB(c7617ak.field_msgType), this.crP), c38677a.jJU.getTextSize()));
        c38677a.jJU.setTextColor(C1338a.m2870h(this.crP, (int) C25738R.color.a7x));
        if (C42789a.m75877FB(c7617ak.field_msgType) == 34 && c7617ak.field_isSend == 0 && !C5046bo.isNullOrNil(c7617ak.field_content) && !new C42230n(c7617ak.field_content).fWX) {
            c38677a.jJU.setTextColor(C1338a.m2870h(this.crP, (int) C25738R.color.a7y));
        }
        switch (c7617ak.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = C1318a.msg_state_sending;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = C1318a.msg_state_failed;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            c38677a.iYg.setBackgroundResource(i2);
            c38677a.iYg.setVisibility(0);
        } else {
            c38677a.iYg.setVisibility(8);
        }
        c38677a.jJW.setTag(c7617ak.field_username);
        c38677a.jJW.setOnClickListener(new C200191());
        i2 = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (c7617ak.field_unReadCount > 100) {
            c38677a.jJV.setText("...");
            c38677a.jJV.setVisibility(0);
            C4990ab.m7418v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (c7617ak.field_unReadCount > 0) {
            c38677a.jJV.setText(c7617ak.field_unReadCount);
            c38677a.jJV.setVisibility(0);
            C4990ab.m7418v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            c38677a.jJV.setVisibility(4);
            C4990ab.m7418v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(C25738R.drawable.a7q);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        AppMethodBeat.m2505o(18548);
        return view;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: E */
    public final String mo68253E(C7616ad c7616ad) {
        AppMethodBeat.m2504i(18549);
        String a = C38676c.m65607a(this.crP, c7616ad);
        AppMethodBeat.m2505o(18549);
        return a;
    }

    /* renamed from: FB */
    private static int m75877FB(String str) {
        int i = 1;
        AppMethodBeat.m2504i(18550);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(18550);
        return i;
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(18551);
        mo6869KC();
        AppMethodBeat.m2505o(18551);
    }
}
