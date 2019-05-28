package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView extends LinearLayout {
    private String igi;
    private TextView lBH;
    private MMHorList lBI;
    private a lBJ = new a(this, (byte) 0);
    private ArrayList<String> lBK;

    class a extends BaseAdapter {
        private Runnable lBM;

        class a {
            ImageView gvq;

            a() {
            }
        }

        private a() {
            AppMethodBeat.i(20013);
            this.lBM = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20012);
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(20012);
                }
            };
            AppMethodBeat.o(20013);
        }

        /* synthetic */ a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(20014);
            if (ExdeviceProfileAffectedUserView.this.lBK == null) {
                AppMethodBeat.o(20014);
                return 0;
            }
            int size = ExdeviceProfileAffectedUserView.this.lBK.size();
            AppMethodBeat.o(20014);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.i(20015);
            String str = (String) ExdeviceProfileAffectedUserView.this.lBK.get(i);
            AppMethodBeat.o(20015);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(20016);
            String item = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(ExdeviceProfileAffectedUserView.this.getContext()).inflate(R.layout.wf, viewGroup, false);
                a aVar2 = new a();
                aVar2.gvq = (ImageView) view.findViewById(R.id.bke);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            Runnable runnable = this.lBM;
            i act = o.act();
            if (act != null) {
                h qo = act.qo(item);
                if (qo == null || bo.isNullOrNil(qo.acl())) {
                    com.tencent.mm.model.ao.a.flu.a(item, "", new com.tencent.mm.plugin.exdevice.model.f.AnonymousClass1(bo.anU(), runnable));
                }
            }
            b.s(aVar.gvq, item);
            AppMethodBeat.o(20016);
            return view;
        }
    }

    public ExdeviceProfileAffectedUserView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(20018);
        View inflate = LayoutInflater.from(context).inflate(R.layout.w_, this, true);
        this.lBH = (TextView) inflate.findViewById(R.id.bjm);
        this.lBI = (MMHorList) inflate.findViewById(R.id.bjn);
        this.lBI.setCenterInParent(true);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 44);
        this.lBI.setOverScrollEnabled(true);
        this.lBI.setItemWidth(fromDPToPix);
        this.lBI.setCenterInParent(true);
        this.lBI.setAdapter(this.lBJ);
        this.lBI.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(20009);
                String str = (String) adapterView.getAdapter().getItem(i);
                ab.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", str);
                if (bo.isNullOrNil(str)) {
                    ab.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
                    AppMethodBeat.o(20009);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", str);
                context.startActivity(intent);
                AppMethodBeat.o(20009);
            }
        });
        this.lBH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20010);
                String Yz = r.Yz();
                if (Yz != null && Yz.equals(ExdeviceProfileAffectedUserView.this.igi)) {
                    ExdeviceProfileAffectedUserView.this.lBI.setVisibility(ExdeviceProfileAffectedUserView.this.lBI.getVisibility() == 0 ? 8 : 0);
                }
                AppMethodBeat.o(20010);
            }
        });
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20011);
                ExdeviceProfileAffectedUserView.this.lBH.performClick();
                AppMethodBeat.o(20011);
            }
        });
        setVisibility(8);
        AppMethodBeat.o(20018);
    }

    public void setUsername(String str) {
        this.igi = str;
    }

    public void setAffectedUserInfo(ArrayList<String> arrayList) {
        AppMethodBeat.i(20019);
        this.lBK = arrayList;
        if (this.lBK == null || this.lBK.size() == 0) {
            this.lBH.setText("");
            setVisibility(8);
            AppMethodBeat.o(20019);
            return;
        }
        setVisibility(0);
        this.lBH.setText(getResources().getString(R.string.bh9, new Object[]{Integer.valueOf(this.lBK.size())}));
        this.lBJ.notifyDataSetChanged();
        AppMethodBeat.o(20019);
    }
}
