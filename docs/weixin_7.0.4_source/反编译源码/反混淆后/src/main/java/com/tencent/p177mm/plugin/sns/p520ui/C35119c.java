package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.sns.data.C34935b;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21980a.C21982b.C21983a;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C13474b;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C3956a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.c */
public final class C35119c extends BaseAdapter {
    public int hzv = 0;
    private final Context mContext;
    private String nJy = null;
    public C34935b rfZ = null;

    public C35119c(Context context, C34935b c34935b) {
        AppMethodBeat.m2504i(38073);
        this.mContext = context;
        this.rfZ = c34935b;
        this.nJy = C4988aa.m7403gw(C4996ah.getContext());
        AppMethodBeat.m2505o(38073);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(38074);
        int size;
        if (this.hzv == 1) {
            size = this.rfZ.qFH.rDn.qTP.coJ().size();
            AppMethodBeat.m2505o(38074);
            return size;
        }
        size = 0;
        if (this.rfZ.qFH.rDm.qUZ != null) {
            size = this.rfZ.qFH.rDm.qUZ.list.size();
        }
        size++;
        AppMethodBeat.m2505o(38074);
        return size;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(38075);
        if (view == null) {
            view = View.inflate(this.mContext, 2130968633, null);
        }
        view.setTag(this.rfZ);
        CharSequence charSequence = "";
        if (this.hzv == 1) {
            C21983a c21983a = (C21983a) getItem(i);
            if ("zh_CN".equals(this.nJy)) {
                charSequence = c21983a.qTZ;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                charSequence = c21983a.qUa;
            } else {
                charSequence = c21983a.qUb;
            }
            if (C5046bo.isNullOrNil(charSequence)) {
                charSequence = c21983a.qUb;
            }
        } else if (i != 0) {
            C3956a c3956a = this.rfZ.qFH.rDm.qUZ;
            if (c3956a != null && i <= c3956a.list.size()) {
                C13474b c13474b = (C13474b) c3956a.list.get(i - 1);
                if ("zh_CN".equals(this.nJy)) {
                    charSequence = c13474b.qVi;
                } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                    charSequence = c13474b.qVj;
                } else {
                    charSequence = c13474b.qOI;
                }
                if (C5046bo.isNullOrNil(charSequence)) {
                    charSequence = c13474b.qOI;
                }
            }
        } else if (!(this.rfZ == null || this.rfZ.qFH.rDm == null)) {
            String str;
            C21980a c21980a = this.rfZ.qFH.rDn;
            if ("zh_CN".equals(this.nJy)) {
                str = c21980a.qTQ;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                str = c21980a.qTS;
            } else {
                str = c21980a.qTR;
            }
            if (C5046bo.isNullOrNil(str)) {
                charSequence = this.mContext.getString(C25738R.string.ejc);
            } else {
                Object charSequence2 = str;
            }
        }
        TextView textView = (TextView) view.findViewById(2131821033);
        if (this.rfZ.qFH.rDn.qTT) {
            textView.setTextColor(Color.parseColor("#3A3A3A"));
        } else {
            textView.setTextColor(Color.parseColor("#576B95"));
        }
        textView.setText(charSequence2);
        view.findViewById(2131821034).setVisibility(i == getCount() + -1 ? 8 : 0);
        AppMethodBeat.m2505o(38075);
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(38076);
        Object obj = this.rfZ.qFH.rDn.qTP.coJ().get(i);
        AppMethodBeat.m2505o(38076);
        return obj;
    }
}
