package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.p;
import java.util.GregorianCalendar;

final class d extends p<f> {
    private Context mContext;
    private LayoutInflater mInflater;
    int quL = 20;

    class a {
        TextView iDT;
        TextView kEq;
        TextView nSC;
        MMImageView quM;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(24750);
        f fVar = (f) obj;
        if (fVar == null) {
            fVar = new f();
        }
        fVar.d(cursor);
        AppMethodBeat.o(24750);
        return fVar;
    }

    public d(Context context) {
        super(context, new f());
        AppMethodBeat.i(24745);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(24745);
    }

    public final void CA(int i) {
        AppMethodBeat.i(24746);
        bIf();
        this.quL = i;
        KC();
        AppMethodBeat.o(24746);
    }

    public final void KD() {
        AppMethodBeat.i(24747);
        KC();
        AppMethodBeat.o(24747);
    }

    public final void KC() {
        AppMethodBeat.i(24748);
        setCursor(m.cjT().Cv(this.quL));
        super.notifyDataSetChanged();
        AppMethodBeat.o(24748);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        AppMethodBeat.i(24749);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.asc, viewGroup, false);
            aVar = new a();
            aVar.quM = (MMImageView) view.findViewById(R.id.ebj);
            aVar.iDT = (TextView) view.findViewById(R.id.ebk);
            aVar.kEq = (TextView) view.findViewById(R.id.ebl);
            aVar.nSC = (TextView) view.findViewById(R.id.ebm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i);
        e.a(aVar.quM, fVar.field_thumburl, R.raw.app_attach_file_icon_webpage, false);
        if (bo.isNullOrNil(fVar.field_title)) {
            aVar.iDT.setVisibility(8);
        } else {
            aVar.iDT.setText(j.b(this.mContext, fVar.field_title, aVar.iDT.getTextSize()));
            aVar.iDT.setVisibility(0);
        }
        if (bo.isNullOrNil(fVar.field_desc)) {
            aVar.kEq.setVisibility(8);
        } else {
            aVar.kEq.setText(j.b(this.mContext, fVar.field_desc, aVar.kEq.getTextSize()));
            aVar.kEq.setVisibility(0);
        }
        TextView textView = aVar.nSC;
        Context context = this.mContext;
        long j = fVar.field_createtime * 1000;
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
                charSequence = context.getResources().getQuantityString(R.plurals.k, i2, new Object[]{Integer.valueOf(i2)});
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
                        charSequence = context.getResources().getQuantityString(R.plurals.l, i2, new Object[]{Integer.valueOf(i2)});
                    } else {
                        charSequence = context.getString(R.string.byb);
                    }
                } else {
                    i2 = (int) ((timeInMillis - j) / 3600000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(R.plurals.j, i2, new Object[]{Integer.valueOf(i2)});
                }
            }
        }
        textView.setText(charSequence);
        AppMethodBeat.o(24749);
        return view;
    }
}
