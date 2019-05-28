package com.tencent.mm.ui.contact;

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
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class SnsLabelContactListUI extends MMActivity {
    private ListView nIv;
    private cbf qBX;
    private a zph;
    private ArrayList<String> zpi = new ArrayList();
    private int zpj;
    private String zpk;
    private b zpl;

    static class a extends BaseAdapter {
        private Context context = null;
        private bd rqa = null;
        private Map<Integer, com.tencent.mm.n.a> zpn = new HashMap();
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
        public a(Context context, List<String> list) {
            Throwable e;
            XmlResourceParser xmlResourceParser;
            XmlResourceParser xmlResourceParser2;
            int i = 0;
            AppMethodBeat.i(33940);
            this.context = context;
            this.zpn.clear();
            aw.ZK();
            this.rqa = com.tencent.mm.model.c.XM();
            Iterator it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    com.tencent.mm.n.a aVar = new com.tencent.mm.n.a();
                    aVar.setUsername(str);
                    i = i2 + 1;
                    this.zpn.put(Integer.valueOf(i2), aVar);
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
                        ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                        if (xmlResourceParser2 != null) {
                            xmlResourceParser2.close();
                        }
                        if (xmlResourceParser != null) {
                            xmlResourceParser.close();
                            AppMethodBeat.o(33940);
                            return;
                        }
                        AppMethodBeat.o(33940);
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
                        AppMethodBeat.o(33940);
                        throw e;
                    }
                }
            }
            xmlResourceParser2 = context.getResources().getXml(R.color.a7t);
            try {
                xmlResourceParser = context.getResources().getXml(R.color.a7u);
            } catch (XmlPullParserException e4) {
                e = e4;
                xmlResourceParser = null;
            } catch (IOException e5) {
                e = e5;
                xmlResourceParser = null;
                ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                if (xmlResourceParser2 != null) {
                }
                if (xmlResourceParser != null) {
                }
                AppMethodBeat.o(33940);
            } catch (Throwable th2) {
                e = th2;
                xmlResourceParser = null;
                if (xmlResourceParser2 != null) {
                }
                if (xmlResourceParser != null) {
                }
                AppMethodBeat.o(33940);
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
                    AppMethodBeat.o(33940);
                    return;
                }
            } catch (XmlPullParserException e6) {
                e = e6;
                try {
                    ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                    if (xmlResourceParser2 != null) {
                        xmlResourceParser2.close();
                    }
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                        AppMethodBeat.o(33940);
                        return;
                    }
                    AppMethodBeat.o(33940);
                } catch (Throwable th3) {
                    e = th3;
                    if (xmlResourceParser2 != null) {
                    }
                    if (xmlResourceParser != null) {
                    }
                    AppMethodBeat.o(33940);
                    throw e;
                }
            } catch (IOException e7) {
                e = e7;
                ab.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                if (xmlResourceParser2 != null) {
                }
                if (xmlResourceParser != null) {
                }
                AppMethodBeat.o(33940);
            }
            AppMethodBeat.o(33940);
        }

        public final int getCount() {
            AppMethodBeat.i(33941);
            int size = this.zpn.size();
            AppMethodBeat.o(33941);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(33942);
            if (i < 0) {
                AppMethodBeat.o(33942);
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
            AppMethodBeat.o(33942);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(33943);
            if (view == null) {
                view = View.inflate(this.context, R.layout.qq, null);
                c cVar2 = new c();
                cVar2.nBN = (TextView) view.findViewById(R.id.nh);
                cVar2.emP = (MaskLayout) view.findViewById(R.id.nk);
                cVar2.emg = (TextView) view.findViewById(R.id.nr);
                cVar2.zpr = (TextView) view.findViewById(R.id.ns);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            getItem(i);
            com.tencent.mm.n.a aVar = (com.tencent.mm.n.a) getItem(i);
            cVar.nBN.setVisibility(8);
            cVar.emg.setTextColor(!t.nI(aVar.field_username) ? this.zpo : this.zpp);
            com.tencent.mm.pluginsdk.ui.a.b.t((ImageView) cVar.emP.getContentView(), aVar.field_username);
            cVar.zpr.setVisibility(8);
            cVar.emP.setVisibility(0);
            cVar.emg.setText(j.b(this.context, aVar.Oj(), cVar.emg.getTextSize()));
            cVar.emg.setVisibility(0);
            AppMethodBeat.o(33943);
            return view;
        }
    }

    class b extends com.tencent.mm.sdk.b.c<pd> {
        private b() {
            AppMethodBeat.i(33945);
            this.xxI = pd.class.getName().hashCode();
            AppMethodBeat.o(33945);
        }

        /* synthetic */ b(SnsLabelContactListUI snsLabelContactListUI, byte b) {
            this();
            AppMethodBeat.i(33947);
            this.xxI = pd.class.getName().hashCode();
            AppMethodBeat.o(33947);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(33946);
            pd pdVar = (pd) bVar;
            if (pdVar instanceof pd) {
                SnsLabelContactListUI.this.qBX = pdVar.cLs.cCZ;
                if (SnsLabelContactListUI.this.qBX != null) {
                    SnsLabelContactListUI.c(SnsLabelContactListUI.this);
                    SnsLabelContactListUI.this.initView();
                } else {
                    SnsLabelContactListUI.this.initView();
                    h.a(SnsLabelContactListUI.this, SnsLabelContactListUI.this.getString(R.string.elh), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(33944);
                            SnsLabelContactListUI.this.finish();
                            AppMethodBeat.o(33944);
                        }
                    });
                }
                AppMethodBeat.o(33946);
                return true;
            }
            AppMethodBeat.o(33946);
            return false;
        }
    }

    static class c {
        MaskLayout emP;
        TextView emg;
        TextView nBN;
        TextView zpr;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsLabelContactListUI() {
        AppMethodBeat.i(33948);
        AppMethodBeat.o(33948);
    }

    static /* synthetic */ void c(SnsLabelContactListUI snsLabelContactListUI) {
        AppMethodBeat.i(33954);
        snsLabelContactListUI.dIm();
        AppMethodBeat.o(33954);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33949);
        super.onCreate(bundle);
        this.zpl = new b(this, (byte) 0);
        com.tencent.mm.sdk.b.a.xxA.c(this.zpl);
        this.zpj = getIntent().getIntExtra("sns_label_sns_info", -1);
        if (this.zpj == -1) {
            finish();
            AppMethodBeat.o(33949);
            return;
        }
        ia iaVar = new ia();
        iaVar.cCX.cyN = this.zpj;
        com.tencent.mm.sdk.b.a.xxA.m(iaVar);
        this.qBX = iaVar.cCY.cCZ;
        if (this.qBX != null && ((this.qBX.wGz == 3 && this.qBX.xaB != null && this.qBX.xaB.size() > 0) || (this.qBX.wGz == 5 && this.qBX.wFp != null && this.qBX.wFp.size() > 0))) {
            dIm();
            initView();
        }
        AppMethodBeat.o(33949);
    }

    private void dIm() {
        AppMethodBeat.i(33950);
        Iterator it;
        if (this.qBX.wGz == 3) {
            this.zpk = getString(R.string.elf);
            it = this.qBX.xaB.iterator();
            while (it.hasNext()) {
                this.zpi.add(((bts) it.next()).wVI);
            }
            AppMethodBeat.o(33950);
            return;
        }
        if (this.qBX.wGz == 5) {
            this.zpk = getString(R.string.elg);
            it = this.qBX.wFp.iterator();
            while (it.hasNext()) {
                this.zpi.add(((bts) it.next()).wVI);
            }
        }
        AppMethodBeat.o(33950);
    }

    public final void initView() {
        AppMethodBeat.i(33951);
        setMMTitle(this.zpk);
        findViewById(R.id.ev4).setVisibility(8);
        this.nIv = (ListView) findViewById(R.id.n3);
        ((TextView) findViewById(R.id.n5)).setVisibility(8);
        findViewById(R.id.n6).setVisibility(8);
        this.nIv.setBackgroundColor(getResources().getColor(R.color.a69));
        ((View) this.nIv.getParent()).setBackgroundColor(getResources().getColor(R.color.a69));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33938);
                SnsLabelContactListUI.this.finish();
                AppMethodBeat.o(33938);
                return true;
            }
        });
        showOptionMenu(false);
        if (!(this.zpi == null || this.zpi.size() == 0)) {
            this.zph = new a(this, this.zpi);
            this.nIv.setAdapter(this.zph);
            this.nIv.setVisibility(0);
            this.nIv.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(33939);
                    Intent intent = new Intent();
                    com.tencent.mm.n.a aVar = (com.tencent.mm.n.a) SnsLabelContactListUI.this.zph.getItem(i);
                    com.tencent.mm.plugin.sns.b.h hVar = n.qFC;
                    if (hVar == null) {
                        SnsLabelContactListUI.this.finish();
                        AppMethodBeat.o(33939);
                        return;
                    }
                    intent = hVar.e(intent, aVar.field_username);
                    if (intent == null) {
                        SnsLabelContactListUI.this.finish();
                        AppMethodBeat.o(33939);
                        return;
                    }
                    intent.putExtra("Contact_User", aVar.field_username);
                    WorkerProfile.Ca().cfV.c(intent, SnsLabelContactListUI.this);
                    AppMethodBeat.o(33939);
                }
            });
        }
        AppMethodBeat.o(33951);
    }

    public void onResume() {
        AppMethodBeat.i(33952);
        super.onResume();
        if (this.zph != null) {
            this.zph.notifyDataSetChanged();
        }
        AppMethodBeat.o(33952);
    }

    public void onDestroy() {
        AppMethodBeat.i(33953);
        com.tencent.mm.sdk.b.a.xxA.d(this.zpl);
        super.onDestroy();
        AppMethodBeat.o(33953);
    }

    public final int getLayoutId() {
        return R.layout.az;
    }
}
