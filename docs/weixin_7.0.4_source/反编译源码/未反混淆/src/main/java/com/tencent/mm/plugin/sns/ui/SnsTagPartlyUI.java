package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;

public class SnsTagPartlyUI extends MMActivity implements f {
    private ListView gGW;
    private a rxF;
    private OnClickListener rxG = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39380);
            if (SnsTagPartlyUI.this.rxF == null) {
                ab.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                AppMethodBeat.o(39380);
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                ab.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
                AppMethodBeat.o(39380);
            } else if (tag instanceof Integer) {
                t tVar = (t) SnsTagPartlyUI.this.rxF.getItem(((Integer) tag).intValue());
                SnsTagPartlyUI.this.tipDialog = h.b(SnsTagPartlyUI.this, null, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                g.RQ();
                g.RO().eJo.a(new x(tVar.field_tagId, tVar.field_tagName), 0);
                AppMethodBeat.o(39380);
            } else {
                ab.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
                AppMethodBeat.o(39380);
            }
        }
    };
    protected p tipDialog = null;

    class a extends com.tencent.mm.ui.p<t> {
        private Context context;
        public boolean rxJ = false;

        class a {
            Button gzI;
            TextView rxK;
            TextView rxL;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(39385);
            t tVar = (t) obj;
            if (tVar == null) {
                tVar = new t();
                ab.d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
            }
            tVar.d(cursor);
            AppMethodBeat.o(39385);
            return tVar;
        }

        public a(Context context) {
            super(context, new t());
            AppMethodBeat.i(39381);
            this.context = context;
            AppMethodBeat.o(39381);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(39382);
            if (view == null) {
                aVar = new a();
                view = View.inflate(this.context, R.layout.ajx, null);
                aVar.rxK = (TextView) view.findViewById(R.id.dkr);
                aVar.rxL = (TextView) view.findViewById(R.id.dks);
                aVar.gzI = (Button) view.findViewById(R.id.aw8);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (wK(i)) {
                aVar.rxK.setText(R.string.eu_);
                aVar.rxL.setVisibility(8);
                aVar.gzI.setVisibility(8);
            } else {
                int i2;
                t tVar = (t) getItem(i);
                aVar.rxK.setText(tVar.field_tagName);
                aVar.rxL.setVisibility(0);
                aVar.rxL.setText(" (" + tVar.field_count + ") ");
                Button button = aVar.gzI;
                if (this.rxJ) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                button.setVisibility(i2);
                aVar.gzI.setOnClickListener(SnsTagPartlyUI.this.rxG);
                aVar.gzI.setTag(Integer.valueOf(i));
            }
            AppMethodBeat.o(39382);
            return view;
        }

        public final void KC() {
            AppMethodBeat.i(39383);
            setCursor(af.cnL().getCursor());
            notifyDataSetChanged();
            AppMethodBeat.o(39383);
        }

        public final void KD() {
            AppMethodBeat.i(39384);
            bIf();
            KC();
            AppMethodBeat.o(39384);
        }

        public final int bFs() {
            return 1;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTagPartlyUI() {
        AppMethodBeat.i(39386);
        AppMethodBeat.o(39386);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39387);
        super.onCreate(bundle);
        g.RQ();
        g.RO().eJo.a(292, (f) this);
        g.RQ();
        g.RO().eJo.a(290, (f) this);
        initView();
        AppMethodBeat.o(39387);
    }

    public void onDestroy() {
        AppMethodBeat.i(39388);
        g.RQ();
        g.RO().eJo.b(292, (f) this);
        g.RQ();
        g.RO().eJo.b(290, (f) this);
        if (this.rxF != null) {
            this.rxF.bIf();
        }
        super.onDestroy();
        AppMethodBeat.o(39388);
    }

    public void onResume() {
        AppMethodBeat.i(39389);
        super.onResume();
        if (this.rxF != null) {
            this.rxF.a("", null);
        }
        AppMethodBeat.o(39389);
    }

    public final void initView() {
        AppMethodBeat.i(39390);
        setMMTitle((int) R.string.e_l);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39376);
                SnsTagPartlyUI.this.finish();
                AppMethodBeat.o(39376);
                return true;
            }
        });
        this.gGW = (ListView) findViewById(R.id.elw);
        this.gGW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(39377);
                if (i < SnsTagPartlyUI.this.rxF.getCount() - 1) {
                    Intent intent = new Intent();
                    t tVar = (t) SnsTagPartlyUI.this.rxF.getItem(i);
                    if (tVar == null) {
                        AppMethodBeat.o(39377);
                        return;
                    }
                    intent.putExtra("k_sns_tag_id", tVar.field_tagId);
                    intent.setClass(SnsTagPartlyUI.this, SnsTagDetailUI.class);
                    SnsTagPartlyUI.this.startActivity(intent);
                    AppMethodBeat.o(39377);
                    return;
                }
                Intent intent2 = new Intent();
                String Yz = r.Yz();
                intent2.putExtra("titile", SnsTagPartlyUI.this.getString(R.string.ep));
                intent2.putExtra("list_type", 1);
                intent2.putExtra("KBlockOpenImFav", true);
                String str = "list_attr";
                intent2.putExtra(str, s.hs(s.C(s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 16777216));
                intent2.putExtra("block_contact", Yz);
                d.b(SnsTagPartlyUI.this, ".ui.contact.SelectContactUI", intent2, 1);
                AppMethodBeat.o(39377);
            }
        });
        this.rxF = new a(this);
        this.gGW.addFooterView(View.inflate(this, R.layout.awi, null));
        this.gGW.setAdapter(this.rxF);
        addTextOptionMenu(0, getString(R.string.ep7), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                AppMethodBeat.i(39378);
                a a = SnsTagPartlyUI.this.rxF;
                if (SnsTagPartlyUI.this.rxF.rxJ) {
                    z = false;
                } else {
                    z = true;
                }
                a.rxJ = z;
                SnsTagPartlyUI.this.updateOptionMenuText(0, SnsTagPartlyUI.this.rxF.rxJ ? SnsTagPartlyUI.this.getString(R.string.qt) : SnsTagPartlyUI.this.getString(R.string.ep7));
                SnsTagPartlyUI.this.rxF.notifyDataSetChanged();
                AppMethodBeat.o(39378);
                return true;
            }
        });
        this.rxF.a((com.tencent.mm.ui.p.a) new com.tencent.mm.ui.p.a() {
            public final void apt() {
                boolean z = true;
                AppMethodBeat.i(39379);
                SnsTagPartlyUI snsTagPartlyUI = SnsTagPartlyUI.this;
                if (SnsTagPartlyUI.this.rxF.getCount() <= 1) {
                    z = false;
                }
                snsTagPartlyUI.enableOptionMenu(z);
                AppMethodBeat.o(39379);
            }
        });
        AppMethodBeat.o(39390);
    }

    public final int getLayoutId() {
        return R.layout.awj;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39391);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(39391);
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    String stringExtra2 = intent.getStringExtra("Select_room_name");
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_sns_tag_id", 0);
                        intent2.putExtra("k_sns_tag_name", bo.bc(stringExtra2, ""));
                        intent2.putExtra("k_sns_tag_list", stringExtra);
                        intent2.setClass(this, SnsTagDetailUI.class);
                        startActivity(intent2);
                        break;
                    }
                    AppMethodBeat.o(39391);
                    return;
                }
                AppMethodBeat.o(39391);
                return;
        }
        AppMethodBeat.o(39391);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(39392);
        ab.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.rxF != null) {
            this.rxF.a("", null);
        }
        AppMethodBeat.o(39392);
    }
}
