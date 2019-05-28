package com.tencent.p177mm.p612ui.contact;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.p1024b.C21875k;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.tencent.mm.ui.contact.SnsTagContactListUI */
public class SnsTagContactListUI extends MMActivity {
    private ListView nIv;
    private C23917a zps;
    private List<Long> zpt = new ArrayList();

    /* renamed from: com.tencent.mm.ui.contact.SnsTagContactListUI$a */
    static class C23917a extends BaseAdapter {
        private Context context = null;
        private C7309bd rqa = null;
        private Map<Integer, C7486a> zpn = new HashMap();
        private ColorStateList zpo;
        private ColorStateList zpp;
        private Map<Integer, String> zpv = new HashMap();

        public C23917a(Context context, List<Long> list) {
            AppMethodBeat.m2504i(33957);
            this.context = context;
            this.zpn.clear();
            this.zpv.clear();
            C9638aw.m17190ZK();
            this.rqa = C18628c.m29078XM();
            int i = 0;
            for (Long longValue : list) {
                long longValue2 = longValue.longValue();
                C21875k c21875k = C21877n.qFA;
                if (c21875k != null) {
                    for (String str : c21875k.mo37359jT(longValue2)) {
                        C7486a c7486a = new C7486a();
                        c7486a.setUsername(str);
                        this.zpv.put(Integer.valueOf(this.zpn.size()), c21875k.mo37360jU(longValue2));
                        int i2 = i + 1;
                        this.zpn.put(Integer.valueOf(i), c7486a);
                        i = i2;
                    }
                }
                i = i;
            }
            try {
                XmlResourceParser xml = context.getResources().getXml(C25738R.color.a7t);
                XmlResourceParser xml2 = context.getResources().getXml(C25738R.color.a7u);
                this.zpo = ColorStateList.createFromXml(context.getResources(), xml);
                this.zpp = ColorStateList.createFromXml(context.getResources(), xml2);
                AppMethodBeat.m2505o(33957);
            } catch (XmlPullParserException e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsTagContactList", e, "", new Object[0]);
                AppMethodBeat.m2505o(33957);
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.SnsTagContactList", e2, "", new Object[0]);
                AppMethodBeat.m2505o(33957);
            }
        }

        public final int getCount() {
            AppMethodBeat.m2504i(33958);
            int size = this.zpn.size();
            AppMethodBeat.m2505o(33958);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(33959);
            if (i < 0) {
                AppMethodBeat.m2505o(33959);
                return null;
            }
            Object obj = (C7486a) this.zpn.get(Integer.valueOf(i));
            if (obj.field_showHead == 0) {
                C7616ad aoO = this.rqa.aoO(obj.field_username);
                if (aoO != null) {
                    this.zpn.put(Integer.valueOf(i), aoO);
                    obj = aoO;
                }
            }
            AppMethodBeat.m2505o(33959);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C30653b c30653b;
            AppMethodBeat.m2504i(33960);
            if (view == null) {
                view = View.inflate(this.context, 2130969223, null);
                C30653b c30653b2 = new C30653b();
                c30653b2.nBN = (TextView) view.findViewById(2131821069);
                c30653b2.emP = (MaskLayout) view.findViewById(2131821072);
                c30653b2.emg = (TextView) view.findViewById(2131821079);
                c30653b2.zpr = (TextView) view.findViewById(2131821080);
                view.setTag(c30653b2);
                c30653b = c30653b2;
            } else {
                c30653b = (C30653b) view.getTag();
            }
            if (((C7486a) getItem(i - 1)) == null) {
                Object obj = "";
            } else {
                String obj2 = m36860Pq(i - 1);
            }
            C7486a c7486a = (C7486a) getItem(i);
            if (i == 0) {
                c30653b.nBN.setVisibility(0);
                c30653b.nBN.setText(m36860Pq(i));
                c30653b.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (i <= 0 || m36860Pq(i).equals(obj2)) {
                c30653b.nBN.setVisibility(8);
            } else {
                c30653b.nBN.setVisibility(0);
                c30653b.nBN.setText(m36860Pq(i));
                c30653b.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            c30653b.emg.setTextColor(!C1855t.m3923nI(c7486a.field_username) ? this.zpo : this.zpp);
            C40460b.m69439t((ImageView) c30653b.emP.getContentView(), c7486a.field_username);
            c30653b.zpr.setVisibility(8);
            c30653b.emP.setVisibility(0);
            c30653b.emg.setText(C44089j.m79293b(this.context, c7486a.mo16707Oj(), c30653b.emg.getTextSize()));
            c30653b.emg.setVisibility(0);
            AppMethodBeat.m2505o(33960);
            return view;
        }

        /* renamed from: Pq */
        private String m36860Pq(int i) {
            AppMethodBeat.m2504i(33961);
            String str;
            if (this.zpv.containsKey(Integer.valueOf(i))) {
                str = (String) this.zpv.get(Integer.valueOf(i));
                AppMethodBeat.m2505o(33961);
                return str;
            }
            str = "";
            AppMethodBeat.m2505o(33961);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsTagContactListUI$b */
    static class C30653b {
        MaskLayout emP;
        TextView emg;
        TextView nBN;
        TextView zpr;

        private C30653b() {
        }

        /* synthetic */ C30653b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsTagContactListUI$1 */
    class C306541 implements OnItemClickListener {
        C306541() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(33955);
            Intent intent = new Intent();
            C7486a c7486a = (C7486a) SnsTagContactListUI.this.zps.getItem(i);
            C39728h c39728h = C21877n.qFC;
            if (c39728h == null) {
                SnsTagContactListUI.this.finish();
                AppMethodBeat.m2505o(33955);
                return;
            }
            Intent e = c39728h.mo8622e(intent, c7486a.field_username);
            if (e == null) {
                SnsTagContactListUI.this.finish();
                AppMethodBeat.m2505o(33955);
                return;
            }
            e.putExtra("sns_adapter_type", 1);
            C25985d.m41467b(SnsTagContactListUI.this.mController.ylL, "sns", ".ui.SnsTimeLineUserPagerUI", e);
            AppMethodBeat.m2505o(33955);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsTagContactListUI$2 */
    class C306552 implements OnMenuItemClickListener {
        C306552() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33956);
            SnsTagContactListUI.this.finish();
            AppMethodBeat.m2505o(33956);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsTagContactListUI() {
        AppMethodBeat.m2504i(33962);
        AppMethodBeat.m2505o(33962);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33963);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(33963);
    }

    public final void initView() {
        AppMethodBeat.m2504i(33964);
        setMMTitle((int) C25738R.string.epf);
        findViewById(2131828206).setVisibility(8);
        this.nIv = (ListView) findViewById(2131821054);
        long[] longArrayExtra = getIntent().getLongArrayExtra("sns_tag_list");
        if (longArrayExtra == null) {
            finish();
            AppMethodBeat.m2505o(33964);
            return;
        }
        for (long valueOf : longArrayExtra) {
            this.zpt.add(Long.valueOf(valueOf));
        }
        ((TextView) findViewById(2131821056)).setVisibility(8);
        findViewById(2131821057).setVisibility(8);
        this.nIv.setBackgroundColor(getResources().getColor(C25738R.color.a69));
        ((View) this.nIv.getParent()).setBackgroundColor(getResources().getColor(C25738R.color.a69));
        this.zps = new C23917a(this, this.zpt);
        this.nIv.setAdapter(this.zps);
        this.nIv.setVisibility(0);
        this.nIv.setOnItemClickListener(new C306541());
        setBackBtn(new C306552());
        showOptionMenu(false);
        AppMethodBeat.m2505o(33964);
    }

    public void onResume() {
        AppMethodBeat.m2504i(33965);
        super.onResume();
        if (this.zps != null) {
            this.zps.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(33965);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33966);
        super.onDestroy();
        AppMethodBeat.m2505o(33966);
    }

    public final int getLayoutId() {
        return 2130968638;
    }
}
