package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;

final class c extends p<ak> implements b {
    private final MMActivity crP;
    protected g jJO;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jJP;
    protected f jJQ;
    protected d jJR = MMSlideDelView.getItemStatusCallBack();

    public static class a {
        public ImageView ejo;
        public TextView ejp;
        public ImageView iYg;
        public TextView jJT;
        public TextView jJU;
        public TextView jJV;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(24125);
        ak akVar = (ak) obj;
        if (akVar == null) {
            akVar = new ak();
        }
        akVar.jh("");
        akVar.ji("");
        akVar.d(cursor);
        AppMethodBeat.o(24125);
        return akVar;
    }

    public c(Context context, com.tencent.mm.ui.p.a aVar) {
        super(context, new ak());
        AppMethodBeat.i(24119);
        super.a(aVar);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(24119);
    }

    public final void KC() {
        AppMethodBeat.i(24120);
        aw.ZK();
        setCursor(com.tencent.mm.model.c.XR().api(t.fkS));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(24120);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(f fVar) {
        this.jJQ = fVar;
    }

    public final void setGetViewPositionCallback(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jJP = cVar;
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
        a aVar;
        CharSequence string;
        int i2;
        int paddingTop;
        int paddingRight;
        int paddingLeft;
        AppMethodBeat.i(24121);
        ak akVar = (ak) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.crP, R.layout.azs, null);
            aVar2.ejo = (ImageView) view.findViewById(R.id.qk);
            aVar2.ejp = (TextView) view.findViewById(R.id.b6e);
            aVar2.jJT = (TextView) view.findViewById(R.id.b6f);
            aVar2.jJU = (TextView) view.findViewById(R.id.b6g);
            aVar2.iYg = (ImageView) view.findViewById(R.id.ew3);
            aVar2.jJV = (TextView) view.findViewById(R.id.nf);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.ejp.setText(s.mJ(akVar.field_username));
        TextView textView = aVar.jJT;
        if (akVar.field_status == 1) {
            string = this.crP.getString(R.string.cw8);
        } else if (akVar.field_conversationTime == Long.MAX_VALUE) {
            string = "";
        } else {
            string = h.c(this.crP, akVar.field_conversationTime, true);
        }
        textView.setText(string);
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ejo, akVar.field_username);
        aw.ZK();
        be.b Cb = com.tencent.mm.model.c.XR().Cb();
        if (!bo.isNullOrNil(akVar.field_digest)) {
            if (bo.isNullOrNil(akVar.field_digestUser)) {
                string = akVar.field_digest;
            } else {
                String displayName;
                if (akVar.field_isSend == 0 && t.kH(akVar.field_username)) {
                    displayName = s.getDisplayName(akVar.field_digestUser, akVar.field_username);
                } else {
                    displayName = s.mJ(akVar.field_digestUser);
                }
                try {
                    string = String.format(akVar.field_digest, new Object[]{displayName});
                } catch (Exception e) {
                }
            }
            aVar.jJU.setText(j.b(this.crP, string, aVar.jJU.getTextSize()));
            switch (akVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = R.raw.msg_state_sending;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.raw.msg_state_failed;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (i2 == -1) {
                aVar.iYg.setBackgroundResource(i2);
                aVar.iYg.setVisibility(0);
            } else {
                aVar.iYg.setVisibility(8);
            }
            i2 = view.getPaddingBottom();
            paddingTop = view.getPaddingTop();
            paddingRight = view.getPaddingRight();
            paddingLeft = view.getPaddingLeft();
            if (akVar.field_unReadCount <= 100) {
                aVar.jJV.setText("...");
                aVar.jJV.setVisibility(0);
            } else if (akVar.field_unReadCount > 0) {
                aVar.jJV.setText(akVar.field_unReadCount);
                aVar.jJV.setVisibility(0);
            } else {
                aVar.jJV.setVisibility(4);
            }
            view.setBackgroundResource(R.drawable.ul);
            view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
            AppMethodBeat.o(24121);
            return view;
        }
        string = Cb.a(akVar.field_isSend, akVar.field_username, akVar.field_content, FB(akVar.field_msgType), this.crP);
        aVar.jJU.setText(j.b(this.crP, string, aVar.jJU.getTextSize()));
        switch (akVar.field_status) {
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
        if (akVar.field_unReadCount <= 100) {
        }
        view.setBackgroundResource(R.drawable.ul);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        AppMethodBeat.o(24121);
        return view;
    }

    private static int FB(String str) {
        int i = 1;
        AppMethodBeat.i(24122);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(24122);
        return i;
    }

    public final void onPause() {
        AppMethodBeat.i(24123);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.o(24123);
    }

    public final void KD() {
        AppMethodBeat.i(24124);
        KC();
        AppMethodBeat.o(24124);
    }
}
