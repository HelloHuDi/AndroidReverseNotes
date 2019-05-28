package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class SnsTagContactListUI extends MMActivity {
    private ListView nIv;
    private a zps;
    private List<Long> zpt = new ArrayList();

    static class a extends BaseAdapter {
        private Context context = null;
        private bd rqa = null;
        private Map<Integer, com.tencent.mm.n.a> zpn = new HashMap();
        private ColorStateList zpo;
        private ColorStateList zpp;
        private Map<Integer, String> zpv = new HashMap();

        public a(Context context, List<Long> list) {
            AppMethodBeat.i(33957);
            this.context = context;
            this.zpn.clear();
            this.zpv.clear();
            aw.ZK();
            this.rqa = c.XM();
            int i = 0;
            for (Long longValue : list) {
                long longValue2 = longValue.longValue();
                k kVar = n.qFA;
                if (kVar != null) {
                    for (String str : kVar.jT(longValue2)) {
                        com.tencent.mm.n.a aVar = new com.tencent.mm.n.a();
                        aVar.setUsername(str);
                        this.zpv.put(Integer.valueOf(this.zpn.size()), kVar.jU(longValue2));
                        int i2 = i + 1;
                        this.zpn.put(Integer.valueOf(i), aVar);
                        i = i2;
                    }
                }
                i = i;
            }
            try {
                XmlResourceParser xml = context.getResources().getXml(R.color.a7t);
                XmlResourceParser xml2 = context.getResources().getXml(R.color.a7u);
                this.zpo = ColorStateList.createFromXml(context.getResources(), xml);
                this.zpp = ColorStateList.createFromXml(context.getResources(), xml2);
                AppMethodBeat.o(33957);
            } catch (XmlPullParserException e) {
                ab.printErrStackTrace("MicroMsg.SnsTagContactList", e, "", new Object[0]);
                AppMethodBeat.o(33957);
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.SnsTagContactList", e2, "", new Object[0]);
                AppMethodBeat.o(33957);
            }
        }

        public final int getCount() {
            AppMethodBeat.i(33958);
            int size = this.zpn.size();
            AppMethodBeat.o(33958);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(33959);
            if (i < 0) {
                AppMethodBeat.o(33959);
                return null;
            }
            Object obj = (com.tencent.mm.n.a) this.zpn.get(Integer.valueOf(i));
            if (obj.field_showHead == 0) {
                ad aoO = this.rqa.aoO(obj.field_username);
                if (aoO != null) {
                    this.zpn.put(Integer.valueOf(i), aoO);
                    obj = aoO;
                }
            }
            AppMethodBeat.o(33959);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(33960);
            if (view == null) {
                view = View.inflate(this.context, R.layout.qq, null);
                b bVar2 = new b();
                bVar2.nBN = (TextView) view.findViewById(R.id.nh);
                bVar2.emP = (MaskLayout) view.findViewById(R.id.nk);
                bVar2.emg = (TextView) view.findViewById(R.id.nr);
                bVar2.zpr = (TextView) view.findViewById(R.id.ns);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (((com.tencent.mm.n.a) getItem(i - 1)) == null) {
                Object obj = "";
            } else {
                String obj2 = Pq(i - 1);
            }
            com.tencent.mm.n.a aVar = (com.tencent.mm.n.a) getItem(i);
            if (i == 0) {
                bVar.nBN.setVisibility(0);
                bVar.nBN.setText(Pq(i));
                bVar.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (i <= 0 || Pq(i).equals(obj2)) {
                bVar.nBN.setVisibility(8);
            } else {
                bVar.nBN.setVisibility(0);
                bVar.nBN.setText(Pq(i));
                bVar.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            bVar.emg.setTextColor(!t.nI(aVar.field_username) ? this.zpo : this.zpp);
            com.tencent.mm.pluginsdk.ui.a.b.t((ImageView) bVar.emP.getContentView(), aVar.field_username);
            bVar.zpr.setVisibility(8);
            bVar.emP.setVisibility(0);
            bVar.emg.setText(j.b(this.context, aVar.Oj(), bVar.emg.getTextSize()));
            bVar.emg.setVisibility(0);
            AppMethodBeat.o(33960);
            return view;
        }

        private String Pq(int i) {
            AppMethodBeat.i(33961);
            String str;
            if (this.zpv.containsKey(Integer.valueOf(i))) {
                str = (String) this.zpv.get(Integer.valueOf(i));
                AppMethodBeat.o(33961);
                return str;
            }
            str = "";
            AppMethodBeat.o(33961);
            return str;
        }
    }

    static class b {
        MaskLayout emP;
        TextView emg;
        TextView nBN;
        TextView zpr;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTagContactListUI() {
        AppMethodBeat.i(33962);
        AppMethodBeat.o(33962);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33963);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(33963);
    }

    public final void initView() {
        AppMethodBeat.i(33964);
        setMMTitle((int) R.string.epf);
        findViewById(R.id.ev4).setVisibility(8);
        this.nIv = (ListView) findViewById(R.id.n3);
        long[] longArrayExtra = getIntent().getLongArrayExtra("sns_tag_list");
        if (longArrayExtra == null) {
            finish();
            AppMethodBeat.o(33964);
            return;
        }
        for (long valueOf : longArrayExtra) {
            this.zpt.add(Long.valueOf(valueOf));
        }
        ((TextView) findViewById(R.id.n5)).setVisibility(8);
        findViewById(R.id.n6).setVisibility(8);
        this.nIv.setBackgroundColor(getResources().getColor(R.color.a69));
        ((View) this.nIv.getParent()).setBackgroundColor(getResources().getColor(R.color.a69));
        this.zps = new a(this, this.zpt);
        this.nIv.setAdapter(this.zps);
        this.nIv.setVisibility(0);
        this.nIv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(33955);
                Intent intent = new Intent();
                com.tencent.mm.n.a aVar = (com.tencent.mm.n.a) SnsTagContactListUI.this.zps.getItem(i);
                h hVar = n.qFC;
                if (hVar == null) {
                    SnsTagContactListUI.this.finish();
                    AppMethodBeat.o(33955);
                    return;
                }
                Intent e = hVar.e(intent, aVar.field_username);
                if (e == null) {
                    SnsTagContactListUI.this.finish();
                    AppMethodBeat.o(33955);
                    return;
                }
                e.putExtra("sns_adapter_type", 1);
                d.b(SnsTagContactListUI.this.mController.ylL, "sns", ".ui.SnsTimeLineUserPagerUI", e);
                AppMethodBeat.o(33955);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33956);
                SnsTagContactListUI.this.finish();
                AppMethodBeat.o(33956);
                return true;
            }
        });
        showOptionMenu(false);
        AppMethodBeat.o(33964);
    }

    public void onResume() {
        AppMethodBeat.i(33965);
        super.onResume();
        if (this.zps != null) {
            this.zps.notifyDataSetChanged();
        }
        AppMethodBeat.o(33965);
    }

    public void onDestroy() {
        AppMethodBeat.i(33966);
        super.onDestroy();
        AppMethodBeat.o(33966);
    }

    public final int getLayoutId() {
        return R.layout.az;
    }
}
