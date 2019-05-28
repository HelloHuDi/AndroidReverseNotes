package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends BaseAdapter {
    public int hzv = 0;
    private final Context mContext;
    private String nJy = null;
    public b rfZ = null;

    public c(Context context, b bVar) {
        AppMethodBeat.i(38073);
        this.mContext = context;
        this.rfZ = bVar;
        this.nJy = aa.gw(ah.getContext());
        AppMethodBeat.o(38073);
    }

    public final int getCount() {
        AppMethodBeat.i(38074);
        int size;
        if (this.hzv == 1) {
            size = this.rfZ.qFH.rDn.qTP.coJ().size();
            AppMethodBeat.o(38074);
            return size;
        }
        size = 0;
        if (this.rfZ.qFH.rDm.qUZ != null) {
            size = this.rfZ.qFH.rDm.qUZ.list.size();
        }
        size++;
        AppMethodBeat.o(38074);
        return size;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(38075);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.au, null);
        }
        view.setTag(this.rfZ);
        CharSequence charSequence = "";
        if (this.hzv == 1) {
            a aVar = (a) getItem(i);
            if ("zh_CN".equals(this.nJy)) {
                charSequence = aVar.qTZ;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                charSequence = aVar.qUa;
            } else {
                charSequence = aVar.qUb;
            }
            if (bo.isNullOrNil(charSequence)) {
                charSequence = aVar.qUb;
            }
        } else if (i != 0) {
            com.tencent.mm.plugin.sns.storage.b.a aVar2 = this.rfZ.qFH.rDm.qUZ;
            if (aVar2 != null && i <= aVar2.list.size()) {
                com.tencent.mm.plugin.sns.storage.b.b bVar = (com.tencent.mm.plugin.sns.storage.b.b) aVar2.list.get(i - 1);
                if ("zh_CN".equals(this.nJy)) {
                    charSequence = bVar.qVi;
                } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                    charSequence = bVar.qVj;
                } else {
                    charSequence = bVar.qOI;
                }
                if (bo.isNullOrNil(charSequence)) {
                    charSequence = bVar.qOI;
                }
            }
        } else if (!(this.rfZ == null || this.rfZ.qFH.rDm == null)) {
            String str;
            com.tencent.mm.plugin.sns.storage.a aVar3 = this.rfZ.qFH.rDn;
            if ("zh_CN".equals(this.nJy)) {
                str = aVar3.qTQ;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                str = aVar3.qTS;
            } else {
                str = aVar3.qTR;
            }
            if (bo.isNullOrNil(str)) {
                charSequence = this.mContext.getString(R.string.ejc);
            } else {
                Object charSequence2 = str;
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.mi);
        if (this.rfZ.qFH.rDn.qTT) {
            textView.setTextColor(Color.parseColor("#3A3A3A"));
        } else {
            textView.setTextColor(Color.parseColor("#576B95"));
        }
        textView.setText(charSequence2);
        view.findViewById(R.id.mj).setVisibility(i == getCount() + -1 ? 8 : 0);
        AppMethodBeat.o(38075);
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(38076);
        Object obj = this.rfZ.qFH.rDn.qTP.coJ().get(i);
        AppMethodBeat.o(38076);
        return obj;
    }
}
