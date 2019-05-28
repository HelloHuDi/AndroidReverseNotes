package com.tencent.p177mm.plugin.qmessage.p485ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.storage.C7617ak;

/* renamed from: com.tencent.mm.plugin.qmessage.ui.c */
final class C28727c extends C46692p<C7617ak> implements C4937b {
    private final MMActivity crP;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23599f jJQ;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.c$a */
    public static class C28726a {
        public ImageView ejo;
        public TextView ejp;
        public ImageView iYg;
        public TextView jJT;
        public TextView jJU;
        public TextView jJV;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(24125);
        C7617ak c7617ak = (C7617ak) obj;
        if (c7617ak == null) {
            c7617ak = new C7617ak();
        }
        c7617ak.mo14758jh("");
        c7617ak.mo14759ji("");
        c7617ak.mo8995d(cursor);
        AppMethodBeat.m2505o(24125);
        return c7617ak;
    }

    public C28727c(Context context, C30723a c30723a) {
        super(context, new C7617ak());
        AppMethodBeat.m2504i(24119);
        super.mo74992a(c30723a);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(24119);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(24120);
        C9638aw.m17190ZK();
        setCursor(C18628c.m29083XR().api(C1855t.fkS));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(24120);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo46876a(C23599f c23599f) {
        this.jJQ = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C28726a c28726a;
        CharSequence string;
        int i2;
        int paddingTop;
        int paddingRight;
        int paddingLeft;
        AppMethodBeat.m2504i(24121);
        C7617ak c7617ak = (C7617ak) getItem(i);
        if (view == null) {
            C28726a c28726a2 = new C28726a();
            view = View.inflate(this.crP, 2130970931, null);
            c28726a2.ejo = (ImageView) view.findViewById(2131821183);
            c28726a2.ejp = (TextView) view.findViewById(2131823149);
            c28726a2.jJT = (TextView) view.findViewById(2131823150);
            c28726a2.jJU = (TextView) view.findViewById(2131823151);
            c28726a2.iYg = (ImageView) view.findViewById(2131828242);
            c28726a2.jJV = (TextView) view.findViewById(2131821067);
            view.setTag(c28726a2);
            c28726a = c28726a2;
        } else {
            c28726a = (C28726a) view.getTag();
        }
        c28726a.ejp.setText(C1854s.m3866mJ(c7617ak.field_username));
        TextView textView = c28726a.jJT;
        if (c7617ak.field_status == 1) {
            string = this.crP.getString(C25738R.string.cw8);
        } else if (c7617ak.field_conversationTime == Long.MAX_VALUE) {
            string = "";
        } else {
            string = C14835h.m23089c(this.crP, c7617ak.field_conversationTime, true);
        }
        textView.setText(string);
        C40460b.m69434b(c28726a.ejo, c7617ak.field_username);
        C9638aw.m17190ZK();
        C5133b Cb = C18628c.m29083XR().mo15765Cb();
        if (!C5046bo.isNullOrNil(c7617ak.field_digest)) {
            if (C5046bo.isNullOrNil(c7617ak.field_digestUser)) {
                string = c7617ak.field_digest;
            } else {
                String displayName;
                if (c7617ak.field_isSend == 0 && C1855t.m3896kH(c7617ak.field_username)) {
                    displayName = C1854s.getDisplayName(c7617ak.field_digestUser, c7617ak.field_username);
                } else {
                    displayName = C1854s.m3866mJ(c7617ak.field_digestUser);
                }
                try {
                    string = String.format(c7617ak.field_digest, new Object[]{displayName});
                } catch (Exception e) {
                }
            }
            c28726a.jJU.setText(C44089j.m79293b(this.crP, string, c28726a.jJU.getTextSize()));
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
            if (i2 == -1) {
                c28726a.iYg.setBackgroundResource(i2);
                c28726a.iYg.setVisibility(0);
            } else {
                c28726a.iYg.setVisibility(8);
            }
            i2 = view.getPaddingBottom();
            paddingTop = view.getPaddingTop();
            paddingRight = view.getPaddingRight();
            paddingLeft = view.getPaddingLeft();
            if (c7617ak.field_unReadCount <= 100) {
                c28726a.jJV.setText("...");
                c28726a.jJV.setVisibility(0);
            } else if (c7617ak.field_unReadCount > 0) {
                c28726a.jJV.setText(c7617ak.field_unReadCount);
                c28726a.jJV.setVisibility(0);
            } else {
                c28726a.jJV.setVisibility(4);
            }
            view.setBackgroundResource(C25738R.drawable.f6893ul);
            view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
            AppMethodBeat.m2505o(24121);
            return view;
        }
        string = Cb.mo10532a(c7617ak.field_isSend, c7617ak.field_username, c7617ak.field_content, C28727c.m45648FB(c7617ak.field_msgType), this.crP);
        c28726a.jJU.setText(C44089j.m79293b(this.crP, string, c28726a.jJU.getTextSize()));
        switch (c7617ak.field_status) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 5:
                break;
            default:
                break;
        }
        if (i2 == -1) {
        }
        i2 = view.getPaddingBottom();
        paddingTop = view.getPaddingTop();
        paddingRight = view.getPaddingRight();
        paddingLeft = view.getPaddingLeft();
        if (c7617ak.field_unReadCount <= 100) {
        }
        view.setBackgroundResource(C25738R.drawable.f6893ul);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        AppMethodBeat.m2505o(24121);
        return view;
    }

    /* renamed from: FB */
    private static int m45648FB(String str) {
        int i = 1;
        AppMethodBeat.m2504i(24122);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(24122);
        return i;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(24123);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.m2505o(24123);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(24124);
        mo6869KC();
        AppMethodBeat.m2505o(24124);
    }
}
