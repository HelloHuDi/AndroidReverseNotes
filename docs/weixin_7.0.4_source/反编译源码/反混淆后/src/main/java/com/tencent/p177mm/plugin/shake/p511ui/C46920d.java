package com.tencent.p177mm.plugin.shake.p511ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.plugin.shake.p1019b.C13248f;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.GregorianCalendar;

/* renamed from: com.tencent.mm.plugin.shake.ui.d */
final class C46920d extends C46692p<C13248f> {
    private Context mContext;
    private LayoutInflater mInflater;
    int quL = 20;

    /* renamed from: com.tencent.mm.plugin.shake.ui.d$a */
    class C39712a {
        TextView iDT;
        TextView kEq;
        TextView nSC;
        MMImageView quM;

        C39712a() {
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(24750);
        C13248f c13248f = (C13248f) obj;
        if (c13248f == null) {
            c13248f = new C13248f();
        }
        c13248f.mo8995d(cursor);
        AppMethodBeat.m2505o(24750);
        return c13248f;
    }

    public C46920d(Context context) {
        super(context, new C13248f());
        AppMethodBeat.m2504i(24745);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.m2505o(24745);
    }

    /* renamed from: CA */
    public final void mo76129CA(int i) {
        AppMethodBeat.m2504i(24746);
        bIf();
        this.quL = i;
        mo6869KC();
        AppMethodBeat.m2505o(24746);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(24747);
        mo6869KC();
        AppMethodBeat.m2505o(24747);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(24748);
        setCursor(C28987m.cjT().mo25316Cv(this.quL));
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(24748);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C39712a c39712a;
        CharSequence charSequence;
        AppMethodBeat.m2504i(24749);
        if (view == null) {
            view = this.mInflater.inflate(2130970655, viewGroup, false);
            c39712a = new C39712a();
            c39712a.quM = (MMImageView) view.findViewById(2131827482);
            c39712a.iDT = (TextView) view.findViewById(2131827483);
            c39712a.kEq = (TextView) view.findViewById(2131827484);
            c39712a.nSC = (TextView) view.findViewById(2131827485);
            view.setTag(c39712a);
        } else {
            c39712a = (C39712a) view.getTag();
        }
        C13248f c13248f = (C13248f) getItem(i);
        C43527e.m77787a(c39712a.quM, c13248f.field_thumburl, C1318a.app_attach_file_icon_webpage, false);
        if (C5046bo.isNullOrNil(c13248f.field_title)) {
            c39712a.iDT.setVisibility(8);
        } else {
            c39712a.iDT.setText(C44089j.m79293b(this.mContext, c13248f.field_title, c39712a.iDT.getTextSize()));
            c39712a.iDT.setVisibility(0);
        }
        if (C5046bo.isNullOrNil(c13248f.field_desc)) {
            c39712a.kEq.setVisibility(8);
        } else {
            c39712a.kEq.setText(C44089j.m79293b(this.mContext, c13248f.field_desc, c39712a.kEq.getTextSize()));
            c39712a.kEq.setVisibility(0);
        }
        TextView textView = c39712a.nSC;
        Context context = this.mContext;
        long j = c13248f.field_createtime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            int i2;
            if ((timeInMillis - j) / 3600000 == 0) {
                i2 = (int) ((timeInMillis - j) / 60000);
                if (i2 <= 0) {
                    i2 = 1;
                }
                charSequence = context.getResources().getQuantityString(C25738R.plurals.f9599k, i2, new Object[]{Integer.valueOf(i2)});
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                    timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        i2 = (int) ((timeInMillis - j) / 86400000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        charSequence = context.getResources().getQuantityString(C25738R.plurals.f9600l, i2, new Object[]{Integer.valueOf(i2)});
                    } else {
                        charSequence = context.getString(C25738R.string.byb);
                    }
                } else {
                    i2 = (int) ((timeInMillis - j) / 3600000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(C25738R.plurals.f9598j, i2, new Object[]{Integer.valueOf(i2)});
                }
            }
        }
        textView.setText(charSequence);
        AppMethodBeat.m2505o(24749);
        return view;
    }
}
