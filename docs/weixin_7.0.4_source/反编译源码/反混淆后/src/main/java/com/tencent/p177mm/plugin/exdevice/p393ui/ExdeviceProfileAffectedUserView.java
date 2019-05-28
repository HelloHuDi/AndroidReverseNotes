package com.tencent.p177mm.plugin.exdevice.p393ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMHorList;
import com.tencent.p177mm.plugin.exdevice.model.C27852f.C278511;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView */
public class ExdeviceProfileAffectedUserView extends LinearLayout {
    private String igi;
    private TextView lBH;
    private MMHorList lBI;
    private C27882a lBJ = new C27882a(this, (byte) 0);
    private ArrayList<String> lBK;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView$a */
    class C27882a extends BaseAdapter {
        private Runnable lBM;

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView$a$1 */
        class C278831 implements Runnable {
            C278831() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20012);
                C27882a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(20012);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView$a$a */
        class C27884a {
            ImageView gvq;

            C27884a() {
            }
        }

        private C27882a() {
            AppMethodBeat.m2504i(20013);
            this.lBM = new C278831();
            AppMethodBeat.m2505o(20013);
        }

        /* synthetic */ C27882a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(20014);
            if (ExdeviceProfileAffectedUserView.this.lBK == null) {
                AppMethodBeat.m2505o(20014);
                return 0;
            }
            int size = ExdeviceProfileAffectedUserView.this.lBK.size();
            AppMethodBeat.m2505o(20014);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(20015);
            String str = (String) ExdeviceProfileAffectedUserView.this.lBK.get(i);
            AppMethodBeat.m2505o(20015);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C27884a c27884a;
            AppMethodBeat.m2504i(20016);
            String item = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(ExdeviceProfileAffectedUserView.this.getContext()).inflate(2130969434, viewGroup, false);
                C27884a c27884a2 = new C27884a();
                c27884a2.gvq = (ImageView) view.findViewById(2131823704);
                view.setTag(c27884a2);
                c27884a = c27884a2;
            } else {
                c27884a = (C27884a) view.getTag();
            }
            Runnable runnable = this.lBM;
            C17881i act = C17884o.act();
            if (act != null) {
                C17880h qo = act.mo33392qo(item);
                if (qo == null || C5046bo.isNullOrNil(qo.acl())) {
                    C26417a.flu.mo20966a(item, "", new C278511(C5046bo.anU(), runnable));
                }
            }
            C40460b.m69438s(c27884a.gvq, item);
            AppMethodBeat.m2505o(20016);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView$2 */
    class C340602 implements OnClickListener {
        C340602() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20010);
            String Yz = C1853r.m3846Yz();
            if (Yz != null && Yz.equals(ExdeviceProfileAffectedUserView.this.igi)) {
                ExdeviceProfileAffectedUserView.this.lBI.setVisibility(ExdeviceProfileAffectedUserView.this.lBI.getVisibility() == 0 ? 8 : 0);
            }
            AppMethodBeat.m2505o(20010);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView$3 */
    class C340623 implements OnClickListener {
        C340623() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20011);
            ExdeviceProfileAffectedUserView.this.lBH.performClick();
            AppMethodBeat.m2505o(20011);
        }
    }

    public ExdeviceProfileAffectedUserView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(20018);
        View inflate = LayoutInflater.from(context).inflate(2130969428, this, true);
        this.lBH = (TextView) inflate.findViewById(2131823675);
        this.lBI = (MMHorList) inflate.findViewById(2131823676);
        this.lBI.setCenterInParent(true);
        int fromDPToPix = C1338a.fromDPToPix(context, 44);
        this.lBI.setOverScrollEnabled(true);
        this.lBI.setItemWidth(fromDPToPix);
        this.lBI.setCenterInParent(true);
        this.lBI.setAdapter(this.lBJ);
        this.lBI.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(20009);
                String str = (String) adapterView.getAdapter().getItem(i);
                C4990ab.m7411d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", str);
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7420w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
                    AppMethodBeat.m2505o(20009);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", str);
                context.startActivity(intent);
                AppMethodBeat.m2505o(20009);
            }
        });
        this.lBH.setOnClickListener(new C340602());
        setOnClickListener(new C340623());
        setVisibility(8);
        AppMethodBeat.m2505o(20018);
    }

    public void setUsername(String str) {
        this.igi = str;
    }

    public void setAffectedUserInfo(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(20019);
        this.lBK = arrayList;
        if (this.lBK == null || this.lBK.size() == 0) {
            this.lBH.setText("");
            setVisibility(8);
            AppMethodBeat.m2505o(20019);
            return;
        }
        setVisibility(0);
        this.lBH.setText(getResources().getString(C25738R.string.bh9, new Object[]{Integer.valueOf(this.lBK.size())}));
        this.lBJ.notifyDataSetChanged();
        AppMethodBeat.m2505o(20019);
    }
}
