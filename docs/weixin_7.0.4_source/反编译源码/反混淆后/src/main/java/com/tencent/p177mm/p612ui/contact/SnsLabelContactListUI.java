package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.p177mm.app.WorkerProfile;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C45356pd;
import com.tencent.p177mm.p230g.p231a.C9377ia;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.tencent.mm.ui.contact.SnsLabelContactListUI */
public class SnsLabelContactListUI extends MMActivity {
    private ListView nIv;
    private cbf qBX;
    private C15807a zph;
    private ArrayList<String> zpi = new ArrayList();
    private int zpj;
    private String zpk;
    private C15808b zpl;

    /* renamed from: com.tencent.mm.ui.contact.SnsLabelContactListUI$a */
    static class C15807a extends BaseAdapter {
        private Context context = null;
        private C7309bd rqa = null;
        private Map<Integer, C7486a> zpn = new HashMap();
        private ColorStateList zpo;
        private ColorStateList zpp;

        /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x00a4=Splitter:B:24:0x00a4, B:16:0x0087=Splitter:B:16:0x0087} */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C15807a(Context context, List<String> list) {
            Throwable e;
            XmlResourceParser xmlResourceParser;
            XmlResourceParser xmlResourceParser2;
            int i = 0;
            AppMethodBeat.m2504i(33940);
            this.context = context;
            this.zpn.clear();
            C9638aw.m17190ZK();
            this.rqa = C18628c.m29078XM();
            Iterator it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    C7486a c7486a = new C7486a();
                    c7486a.setUsername(str);
                    i = i2 + 1;
                    this.zpn.put(Integer.valueOf(i2), c7486a);
                } else {
                    try {
                        break;
                    } catch (XmlPullParserException e2) {
                        e = e2;
                        xmlResourceParser = null;
                        xmlResourceParser2 = null;
                    } catch (IOException e3) {
                        e = e3;
                        xmlResourceParser = null;
                        xmlResourceParser2 = null;
                        C4990ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                        if (xmlResourceParser2 != null) {
                            xmlResourceParser2.close();
                        }
                        if (xmlResourceParser != null) {
                            xmlResourceParser.close();
                            AppMethodBeat.m2505o(33940);
                            return;
                        }
                        AppMethodBeat.m2505o(33940);
                    } catch (Throwable th) {
                        e = th;
                        xmlResourceParser = null;
                        xmlResourceParser2 = null;
                        if (xmlResourceParser2 != null) {
                            xmlResourceParser2.close();
                        }
                        if (xmlResourceParser != null) {
                            xmlResourceParser.close();
                        }
                        AppMethodBeat.m2505o(33940);
                        throw e;
                    }
                }
            }
            xmlResourceParser2 = context.getResources().getXml(C25738R.color.a7t);
            try {
                xmlResourceParser = context.getResources().getXml(C25738R.color.a7u);
            } catch (XmlPullParserException e4) {
                e = e4;
                xmlResourceParser = null;
            } catch (IOException e5) {
                e = e5;
                xmlResourceParser = null;
                C4990ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                if (xmlResourceParser2 != null) {
                }
                if (xmlResourceParser != null) {
                }
                AppMethodBeat.m2505o(33940);
            } catch (Throwable th2) {
                e = th2;
                xmlResourceParser = null;
                if (xmlResourceParser2 != null) {
                }
                if (xmlResourceParser != null) {
                }
                AppMethodBeat.m2505o(33940);
                throw e;
            }
            try {
                this.zpo = ColorStateList.createFromXml(context.getResources(), xmlResourceParser2);
                this.zpp = ColorStateList.createFromXml(context.getResources(), xmlResourceParser);
                if (xmlResourceParser2 != null) {
                    xmlResourceParser2.close();
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                    AppMethodBeat.m2505o(33940);
                    return;
                }
            } catch (XmlPullParserException e6) {
                e = e6;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                    if (xmlResourceParser2 != null) {
                        xmlResourceParser2.close();
                    }
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                        AppMethodBeat.m2505o(33940);
                        return;
                    }
                    AppMethodBeat.m2505o(33940);
                } catch (Throwable th3) {
                    e = th3;
                    if (xmlResourceParser2 != null) {
                    }
                    if (xmlResourceParser != null) {
                    }
                    AppMethodBeat.m2505o(33940);
                    throw e;
                }
            } catch (IOException e7) {
                e = e7;
                C4990ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                if (xmlResourceParser2 != null) {
                }
                if (xmlResourceParser != null) {
                }
                AppMethodBeat.m2505o(33940);
            }
            AppMethodBeat.m2505o(33940);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(33941);
            int size = this.zpn.size();
            AppMethodBeat.m2505o(33941);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(33942);
            if (i < 0) {
                AppMethodBeat.m2505o(33942);
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
            AppMethodBeat.m2505o(33942);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C30650c c30650c;
            AppMethodBeat.m2504i(33943);
            if (view == null) {
                view = View.inflate(this.context, 2130969223, null);
                C30650c c30650c2 = new C30650c();
                c30650c2.nBN = (TextView) view.findViewById(2131821069);
                c30650c2.emP = (MaskLayout) view.findViewById(2131821072);
                c30650c2.emg = (TextView) view.findViewById(2131821079);
                c30650c2.zpr = (TextView) view.findViewById(2131821080);
                view.setTag(c30650c2);
                c30650c = c30650c2;
            } else {
                c30650c = (C30650c) view.getTag();
            }
            getItem(i);
            C7486a c7486a = (C7486a) getItem(i);
            c30650c.nBN.setVisibility(8);
            c30650c.emg.setTextColor(!C1855t.m3923nI(c7486a.field_username) ? this.zpo : this.zpp);
            C40460b.m69439t((ImageView) c30650c.emP.getContentView(), c7486a.field_username);
            c30650c.zpr.setVisibility(8);
            c30650c.emP.setVisibility(0);
            c30650c.emg.setText(C44089j.m79293b(this.context, c7486a.mo16707Oj(), c30650c.emg.getTextSize()));
            c30650c.emg.setVisibility(0);
            AppMethodBeat.m2505o(33943);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsLabelContactListUI$b */
    class C15808b extends C4884c<C45356pd> {

        /* renamed from: com.tencent.mm.ui.contact.SnsLabelContactListUI$b$1 */
        class C158091 implements OnClickListener {
            C158091() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(33944);
                SnsLabelContactListUI.this.finish();
                AppMethodBeat.m2505o(33944);
            }
        }

        private C15808b() {
            AppMethodBeat.m2504i(33945);
            this.xxI = C45356pd.class.getName().hashCode();
            AppMethodBeat.m2505o(33945);
        }

        /* synthetic */ C15808b(SnsLabelContactListUI snsLabelContactListUI, byte b) {
            this();
            AppMethodBeat.m2504i(33947);
            this.xxI = C45356pd.class.getName().hashCode();
            AppMethodBeat.m2505o(33947);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(33946);
            C45356pd c45356pd = (C45356pd) c4883b;
            if (c45356pd instanceof C45356pd) {
                SnsLabelContactListUI.this.qBX = c45356pd.cLs.cCZ;
                if (SnsLabelContactListUI.this.qBX != null) {
                    SnsLabelContactListUI.m48885c(SnsLabelContactListUI.this);
                    SnsLabelContactListUI.this.initView();
                } else {
                    SnsLabelContactListUI.this.initView();
                    C30379h.m48438a(SnsLabelContactListUI.this, SnsLabelContactListUI.this.getString(C25738R.string.elh), "", new C158091());
                }
                AppMethodBeat.m2505o(33946);
                return true;
            }
            AppMethodBeat.m2505o(33946);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsLabelContactListUI$c */
    static class C30650c {
        MaskLayout emP;
        TextView emg;
        TextView nBN;
        TextView zpr;

        private C30650c() {
        }

        /* synthetic */ C30650c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsLabelContactListUI$1 */
    class C306511 implements OnMenuItemClickListener {
        C306511() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33938);
            SnsLabelContactListUI.this.finish();
            AppMethodBeat.m2505o(33938);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsLabelContactListUI$2 */
    class C306522 implements OnItemClickListener {
        C306522() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(33939);
            Intent intent = new Intent();
            C7486a c7486a = (C7486a) SnsLabelContactListUI.this.zph.getItem(i);
            C39728h c39728h = C21877n.qFC;
            if (c39728h == null) {
                SnsLabelContactListUI.this.finish();
                AppMethodBeat.m2505o(33939);
                return;
            }
            intent = c39728h.mo8622e(intent, c7486a.field_username);
            if (intent == null) {
                SnsLabelContactListUI.this.finish();
                AppMethodBeat.m2505o(33939);
                return;
            }
            intent.putExtra("Contact_User", c7486a.field_username);
            WorkerProfile.m16161Ca().cfV.mo38912c(intent, SnsLabelContactListUI.this);
            AppMethodBeat.m2505o(33939);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsLabelContactListUI() {
        AppMethodBeat.m2504i(33948);
        AppMethodBeat.m2505o(33948);
    }

    /* renamed from: c */
    static /* synthetic */ void m48885c(SnsLabelContactListUI snsLabelContactListUI) {
        AppMethodBeat.m2504i(33954);
        snsLabelContactListUI.dIm();
        AppMethodBeat.m2505o(33954);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33949);
        super.onCreate(bundle);
        this.zpl = new C15808b(this, (byte) 0);
        C4879a.xxA.mo10052c(this.zpl);
        this.zpj = getIntent().getIntExtra("sns_label_sns_info", -1);
        if (this.zpj == -1) {
            finish();
            AppMethodBeat.m2505o(33949);
            return;
        }
        C9377ia c9377ia = new C9377ia();
        c9377ia.cCX.cyN = this.zpj;
        C4879a.xxA.mo10055m(c9377ia);
        this.qBX = c9377ia.cCY.cCZ;
        if (this.qBX != null && ((this.qBX.wGz == 3 && this.qBX.xaB != null && this.qBX.xaB.size() > 0) || (this.qBX.wGz == 5 && this.qBX.wFp != null && this.qBX.wFp.size() > 0))) {
            dIm();
            initView();
        }
        AppMethodBeat.m2505o(33949);
    }

    private void dIm() {
        AppMethodBeat.m2504i(33950);
        Iterator it;
        if (this.qBX.wGz == 3) {
            this.zpk = getString(C25738R.string.elf);
            it = this.qBX.xaB.iterator();
            while (it.hasNext()) {
                this.zpi.add(((bts) it.next()).wVI);
            }
            AppMethodBeat.m2505o(33950);
            return;
        }
        if (this.qBX.wGz == 5) {
            this.zpk = getString(C25738R.string.elg);
            it = this.qBX.wFp.iterator();
            while (it.hasNext()) {
                this.zpi.add(((bts) it.next()).wVI);
            }
        }
        AppMethodBeat.m2505o(33950);
    }

    public final void initView() {
        AppMethodBeat.m2504i(33951);
        setMMTitle(this.zpk);
        findViewById(2131828206).setVisibility(8);
        this.nIv = (ListView) findViewById(2131821054);
        ((TextView) findViewById(2131821056)).setVisibility(8);
        findViewById(2131821057).setVisibility(8);
        this.nIv.setBackgroundColor(getResources().getColor(C25738R.color.a69));
        ((View) this.nIv.getParent()).setBackgroundColor(getResources().getColor(C25738R.color.a69));
        setBackBtn(new C306511());
        showOptionMenu(false);
        if (!(this.zpi == null || this.zpi.size() == 0)) {
            this.zph = new C15807a(this, this.zpi);
            this.nIv.setAdapter(this.zph);
            this.nIv.setVisibility(0);
            this.nIv.setOnItemClickListener(new C306522());
        }
        AppMethodBeat.m2505o(33951);
    }

    public void onResume() {
        AppMethodBeat.m2504i(33952);
        super.onResume();
        if (this.zph != null) {
            this.zph.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(33952);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33953);
        C4879a.xxA.mo10053d(this.zpl);
        super.onDestroy();
        AppMethodBeat.m2505o(33953);
    }

    public final int getLayoutId() {
        return 2130968638;
    }
}
